package ma.ensa.apms.services;

import ma.ensa.apms.model.UserStory;

import java.util.List;

public interface IUserStoryService {
    UserStory saveUserStory(UserStory userStory);
    List<UserStory> getAllUserStory();
    UserStory getUserStoryById(Long id);
    void deleteUserStory(Long id);
}