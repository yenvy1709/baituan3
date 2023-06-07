package Book.DoanThiYenVy.services;

import Book.DoanThiYenVy.entity.User;
import Book.DoanThiYenVy.repository.IuserRepository;
import Book.DoanThiYenVy.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;
    public void save (User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername((user.getUsername()));
        Long roleId = roleRepository.getRoleIdByName("User");
        if (roleId != 0 && userId != 0) {
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
