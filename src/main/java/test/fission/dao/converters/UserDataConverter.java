package test.fission.dao.converters;


public interface UserDataConverter<T> {

     String getCSV(T entity);
     T get(String csvString);
}
