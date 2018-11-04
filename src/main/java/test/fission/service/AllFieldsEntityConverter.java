package test.fission.service;

import test.fission.data.AllFieldsViewEntity;
import test.fission.data.ExperienceViewEntity;
import test.fission.model.User;

import java.util.ArrayList;
import java.util.List;

public class AllFieldsEntityConverter implements EntityObjectConverter<User,AllFieldsViewEntity>{

    @Override
    public AllFieldsViewEntity toTarget(User user) {
        AllFieldsViewEntity allFieldsViewEntity=new AllFieldsViewEntity();
        allFieldsViewEntity.setAge(user.getAge());
        allFieldsViewEntity.setExperience(user.getExperience());
        allFieldsViewEntity.setFirstName(user.getFirstName());
        allFieldsViewEntity.setLastName(user.getLastName());
        allFieldsViewEntity.setOrganization(user.getOrganization());
        return allFieldsViewEntity;
    }

    @Override
    public List<AllFieldsViewEntity> toTarget(List<User> users) {
        List<AllFieldsViewEntity> list=new ArrayList<>();
        for(User user:users){
            list.add(toTarget(user));
        }
        return list;
    }


}
