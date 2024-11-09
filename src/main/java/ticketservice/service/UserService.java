package ticketservice.service;

import org.springframework.stereotype.Service;
import ticketservice.model.User;
import ticketservice.model.UserStatus;
import ticketservice.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public int updateUserStatus(UserStatus userStatus, int id) {
        return userRepository.updateUserStatus(userStatus, id);
    }
}
