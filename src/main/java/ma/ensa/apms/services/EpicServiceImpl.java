package ma.ensa.apms.services;

import lombok.AllArgsConstructor;
import ma.ensa.apms.model.Epic;
import ma.ensa.apms.repository.EpicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpicServiceImpl implements IEpicService{
    private EpicRepository epicRepository;

    @Override
    public Epic saveEpic(Epic epic) {
        return epicRepository.save(epic);
    }

    @Override
    public List<Epic> getAllEpic() {
        return epicRepository.findAll();
    }

    @Override
    public Epic getEpicById(Long id) {
        return epicRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEpic(Long id) {
        epicRepository.deleteById(id);
    }
}
