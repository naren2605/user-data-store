package test.fission.service;

import test.fission.dao.AllFieldsUserFileRepository;
import test.fission.dao.converters.AllFieldsConverter;
import test.fission.data.AllFieldsViewEntity;
import test.fission.model.User;

import java.util.Collections;
import java.util.List;

public class AllFieldsService implements UserDataService {

    private final AllFieldsUserFileRepository repository;
    private final EntityObjectConverter<User, AllFieldsViewEntity> entityObjectConverter;

    public AllFieldsService() {
        repository = new AllFieldsUserFileRepository(new AllFieldsConverter());
        entityObjectConverter = new AllFieldsEntityConverter();
    }


    @Override
    public void add(User user) {
        repository.add(entityObjectConverter.toTarget(user));
    }

    @Override
    public void sort() {
        List<AllFieldsViewEntity> allFieldsViewEntities = repository.getAll();
        Collections.sort(allFieldsViewEntities, (o1, o2) -> o1.getOrganization().compareTo(o2.getOrganization()));
        Collections.sort(allFieldsViewEntities, (o1, o2) -> new Integer(o1.getAge()).compareTo(new Integer(o2.getAge())));
        Collections.sort(allFieldsViewEntities, (o1, o2) -> new Integer(o1.getExperience()).compareTo(new Integer(o2.getExperience())));
        Collections.sort(allFieldsViewEntities, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        Collections.sort(allFieldsViewEntities, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        repository.updateAll(allFieldsViewEntities);

    }
}
