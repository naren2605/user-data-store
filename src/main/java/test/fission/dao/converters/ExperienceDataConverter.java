package test.fission.dao.converters;

import test.fission.data.ExperienceViewEntity;

public class ExperienceDataConverter implements UserDataConverter<ExperienceViewEntity> {

    @Override
    public String getCSV(ExperienceViewEntity experienceViewEntity) {

        StringBuilder sb = new StringBuilder();
        sb.append(experienceViewEntity.getExpRatio())
                .append(",")
                .append(experienceViewEntity.getOrganization());

        return sb.toString();
    }


    @Override
    public ExperienceViewEntity get(String csvString) {
        String[] values = csvString.split(",");
        ExperienceViewEntity experienceViewEntity = new ExperienceViewEntity();
        experienceViewEntity.setExpRatio(new Double(values[0]));
        experienceViewEntity.setOrganization(values[1]);
        return experienceViewEntity;
    }
}