package test.fission.dao;

import test.fission.dao.converters.UserDataConverter;
import test.fission.data.ExperienceViewEntity;

import java.util.List;

public class ExperienceUserFileRepository extends AbsrtractUserFileRepository<ExperienceViewEntity>{
    public ExperienceUserFileRepository(UserDataConverter<ExperienceViewEntity> converter){
            this.converter=converter;
    }

    @Override
    String getFileName() {
        return "EXPERIENCE";
    }

}
