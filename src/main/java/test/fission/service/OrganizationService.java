package test.fission.service;

import test.fission.dao.OrganizationUserFileRepository;
import test.fission.dao.converters.OrganizartionDataConverter;
import test.fission.data.OrganizationViewEntity;
import test.fission.model.User;

import java.util.Collections;
import java.util.List;

public class OrganizationService implements UserDataService{
    private final EntityObjectConverter<User,OrganizationViewEntity> converter;
    private final OrganizationUserFileRepository repository;
    public OrganizationService(){
        converter=new OrganizationViewEntityConverter();
        repository=new OrganizationUserFileRepository(new OrganizartionDataConverter());
    }

    @Override
    public void add(User user) {
        repository.add(converter.toTarget(user));
    }

    @Override
    public void sort() {
        List<OrganizationViewEntity> organizationViewEntities=repository.getAll();
        Collections.sort(organizationViewEntities,(o1, o2)->o1.getLastName().compareTo(o2.getLastName()));
        Collections.sort(organizationViewEntities,(o1,o2)->o1.getFirstName().compareTo(o2.getFirstName()));
        Collections.sort(organizationViewEntities,(o1,o2)->new Integer(o1.getExperience()).compareTo(new Integer(o2.getExperience())));
        Collections.sort(organizationViewEntities,(o1,o2)->o1.getOrganization().compareTo(o2.getOrganization()));
        repository.updateAll(organizationViewEntities);

    }
}
