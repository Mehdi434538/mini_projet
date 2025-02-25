package ma.ensa.apms.services;

import lombok.AllArgsConstructor;
import ma.ensa.apms.model.UserStory;
import ma.ensa.apms.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserStoryServiceImpl implements IUserStoryService{
    private UserStoryRepository userStoryRepository;

    @Override
    public UserStory saveUserStory(UserStory userStory) {
        return userStoryRepository.save(userStory);
    }

    @Override
    public List<UserStory> getAllUserStory() {
        return userStoryRepository.findAll();
    }

    @Override
    public UserStory getUserStoryById(Long id) {
        return userStoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserStory(Long id) {
        userStoryRepository.deleteById(id);

    }
}
