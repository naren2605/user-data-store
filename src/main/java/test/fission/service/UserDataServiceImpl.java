package test.fission.service;

import test.fission.model.User;


public class UserDataServiceImpl implements UserDataService {

    private final AllFieldsService allFieldsService;
    private final ExperienceService experienceService;
    private final OrganizationService  organizationService;
    public UserDataServiceImpl(){
       allFieldsService=new AllFieldsService();
       experienceService=new ExperienceService();
       organizationService=new OrganizationService();
    }



    @Override
    public void add(User user) {
        allFieldsService.add(user);
        experienceService.add(user);
        organizationService.add(user);
    }

    @Override
    public void sort() {
        allFieldsService.sort();
        experienceService.sort();
        organizationService.sort();
    }



}
