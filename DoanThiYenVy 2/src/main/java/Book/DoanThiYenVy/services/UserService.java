package Book.DoanThiYenVy.services;

import Book.DoanThiYenVy.entity.User;
import Book.DoanThiYenVy.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
