package test.fission.service;

import test.fission.data.OrganizationViewEntity;
import test.fission.model.User;

import java.util.ArrayList;
import java.util.List;

public class OrganizationViewEntityConverter implements EntityObjectConverter<User,OrganizationViewEntity> {


    @Override
    public OrganizationViewEntity toTarget(User user) {
        OrganizationViewEntity entity=new OrganizationViewEntity();
        entity.setLastName(user.getLastName());
        entity.setFirstName(user.getFirstName());
        entity.setOrganization(user.getOrganization());
        entity.setExperience(user.getExperience());
        return entity;
    }

    @Override
    public List<OrganizationViewEntity> toTarget(List<User> users) {
        List<OrganizationViewEntity> list=new ArrayList<>();
        for(User user:users){
            list.add(toTarget(user));
        }
        return list;
    }
}
