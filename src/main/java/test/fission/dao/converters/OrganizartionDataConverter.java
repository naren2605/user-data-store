package test.fission.dao.converters;

import test.fission.data.OrganizationViewEntity;

public class OrganizartionDataConverter implements UserDataConverter<OrganizationViewEntity> {
    @Override
    public String getCSV(OrganizationViewEntity entity) {
        StringBuilder sb=new StringBuilder();
        sb.append(entity.getOrganization())
                .append(",")
                .append(entity.getExperience()).append(",")
                .append(entity.getFirstName()).append(",")
                .append(entity.getLastName());
        return sb.toString();
    }

    @Override
    public OrganizationViewEntity get(String csvString) {
        String[] values = csvString.split(",");
        OrganizationViewEntity entity=new OrganizationViewEntity();
        entity.setExperience(new Integer(values[1]));
        entity.setOrganization(values[0]);
        entity.setFirstName(values[2]);
        entity.setLastName(values[3]);
        return entity;
    }
}
