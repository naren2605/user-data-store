package test.fission.dao;

import test.fission.dao.converters.UserDataConverter;
import test.fission.data.AllFieldsViewEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AllFieldsUserFileRepository extends AbsrtractUserFileRepository<AllFieldsViewEntity> {

    public AllFieldsUserFileRepository(UserDataConverter<AllFieldsViewEntity> converter){
        this.converter=converter;
    }


    @Override
    String getFileName() {
        return "ALL_FIELDS";
    }
}
