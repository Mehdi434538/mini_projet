package ma.ensa.apms.services;

import ma.ensa.apms.model.Epic;

import java.util.List;

public interface IEpicService {
    Epic saveEpic(Epic epic);
    List<Epic> getAllEpic();
    Epic getEpicById(Long id);
    void deleteEpic(Long id);
}
