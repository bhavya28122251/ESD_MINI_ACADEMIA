package org.esdpracticals.academicerp.service;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.esdpracticals.academicerp.dto.LoginRequest;
import org.esdpracticals.academicerp.entity.Employee;
import org.esdpracticals.academicerp.helper.CustomUserDetails;
import org.esdpracticals.academicerp.helper.EncryptionService;
import org.esdpracticals.academicerp.helper.JWTHelper;
import org.esdpracticals.academicerp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private JWTHelper jwtHelper;

    public String loginUser(LoginRequest request) {
        Employee existingEmployee = employeeRepository.findByEmail(request.email());
        Optional<Employee> existingUser = employeeRepository.findByEmployees(existingEmployee);

        if (existingUser.isPresent()) {
            if(!encryptionService.validates(request.password(), existingUser.get().getPassword())) {
                return "Wrong Password or Email";
            }
            else {
                return jwtHelper.generateToken(request.email());
            }
        } else {
            return "User not found";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee existingEmployee = employeeRepository.findByEmail(username);
        Employee login = employeeRepository.findByEmployees(existingEmployee)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + username));
        return new CustomUserDetails(login); // Wrapping Customer in CustomUserDetails
    }
}
