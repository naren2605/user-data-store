package test.fission.dao;

import test.fission.dao.converters.UserDataConverter;
import test.fission.data.OrganizationViewEntity;

import java.util.List;

public class OrganizationUserFileRepository extends AbsrtractUserFileRepository<OrganizationViewEntity> {


    public OrganizationUserFileRepository(UserDataConverter<OrganizationViewEntity> converter){
        this.converter=converter;
    }

    @Override
    String getFileName() {
        return "ORGANIZATION";
    }

}
