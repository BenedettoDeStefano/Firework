package FireworkDeStefano.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FireworkDeStefano.Entities.User;
import FireworkDeStefano.Payload.UserPayload;
import FireworkDeStefano.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public void saveUser(UserPayload userPayload) {
        User newUser = new User();
        newUser.setName(userPayload.getName());
        userRepository.save(newUser);
    }

    public void updateUser(UUID id, UserPayload userPayload) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(userPayload.getName());
            userRepository.save(existingUser);
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}