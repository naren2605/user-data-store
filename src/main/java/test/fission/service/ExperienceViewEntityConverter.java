package test.fission.service;

import test.fission.data.ExperienceViewEntity;
import test.fission.data.OrganizationViewEntity;
import test.fission.model.User;

import java.util.ArrayList;
import java.util.List;

public class ExperienceViewEntityConverter implements EntityObjectConverter<User,ExperienceViewEntity> {

    @Override
    public ExperienceViewEntity toTarget(User source) {
        ExperienceViewEntity experienceViewEntity=new ExperienceViewEntity();
        experienceViewEntity.setOrganization(source.getOrganization());
        experienceViewEntity.setExpRatio((source.getExperience()+0.0d)/source.getAge());
        return experienceViewEntity;
    }


    @Override
    public List<ExperienceViewEntity> toTarget(List<User> users) {
        List<ExperienceViewEntity> list=new ArrayList<>();
        for(User user:users){
            list.add(toTarget(user));
        }
        return list;
    }

}
