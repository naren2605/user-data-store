package test.fission.dao.converters;

import test.fission.data.AllFieldsViewEntity;

public class AllFieldsConverter implements UserDataConverter<AllFieldsViewEntity>  {

    @Override
    public String getCSV(AllFieldsViewEntity userEntity){

        StringBuilder sb =new StringBuilder();
        sb.append(userEntity.getFirstName())
                .append(",")
        .append(userEntity.getLastName())
                .append(",")
                .append(userEntity.getOrganization())
                .append(",")
                .append(userEntity.getAge())
                .append(",")
                .append(userEntity.getExperience());

        return sb.toString();
    }

    @Override
    public AllFieldsViewEntity get(String csvString){
        String[] values=csvString.split(",");
        AllFieldsViewEntity userEntity=new AllFieldsViewEntity();
        userEntity.setAge(new Integer(values[3]));
        userEntity.setFirstName(values[0]);
        userEntity.setLastName(values[1]);
        userEntity.setOrganization(values[2]);
        userEntity.setExperience(new Integer(values[4]));

        return userEntity;
    }

}
