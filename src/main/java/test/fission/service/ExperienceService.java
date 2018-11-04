package test.fission.service;

import test.fission.dao.ExperienceUserFileRepository;
import test.fission.dao.converters.ExperienceDataConverter;
import test.fission.data.ExperienceViewEntity;
import test.fission.model.User;

import java.util.Collections;
import java.util.List;

public class ExperienceService implements UserDataService {

    private final EntityObjectConverter<User,ExperienceViewEntity> converter;
    private final ExperienceUserFileRepository repository;

    public ExperienceService(){
        converter=new ExperienceViewEntityConverter();
        repository=new ExperienceUserFileRepository(new ExperienceDataConverter());
    }

    @Override
    public void add(User user) {
        repository.add(converter.toTarget(user));
    }

    @Override
    public void sort() {
        List<ExperienceViewEntity> experienceViewEntities=repository.getAll();
        Collections.sort(experienceViewEntities,(o1, o2)->o1.getOrganization().compareTo(o2.getOrganization()));
        Collections.sort(experienceViewEntities,(o1,o2)->new Double(o1.getExpRatio()).compareTo(new Double(o2.getExpRatio())));
        repository.updateAll(experienceViewEntities);

    }
}
