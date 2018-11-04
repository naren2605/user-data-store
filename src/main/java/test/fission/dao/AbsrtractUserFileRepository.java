package test.fission.dao;

import test.fission.dao.converters.UserDataConverter;
import test.fission.data.AllFieldsViewEntity;
import test.fission.data.ExperienceViewEntity;
import test.fission.data.OrganizationViewEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbsrtractUserFileRepository<T> implements UserDataRepository<T> {
    protected UserDataConverter<T> converter;
    /**
     * specify filename to store
     * @return
     */
    abstract String getFileName();

    protected void write(String data){
            File file = new File(getFileName());
            try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(file,true))){
                bufferedWriter.write(data+"\n");
            } catch (IOException e) {
                System.out.println("io exception occurred = " + e.getMessage());
            }

    }

    protected List<String> getAllData(){

        File file = new File(getFileName());
        List<String> list= new ArrayList<>();
        synchronized (AbsrtractUserFileRepository.class) {
            try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()));) {

                String tmp = null;
                while ((tmp = reader.readLine()) != null) {
                    list.add(tmp);
                }
            } catch (IOException e) {
                System.out.println("io exception occurred = " + e.getMessage());
            }
        }
        return list;
    }

    protected void deleteFile(){
        File file = new File(getFileName());
        file.delete();
    }



    @Override
    public void add(T userEntity) {
        this.write(converter.getCSV(userEntity));
    }

    @Override
    public List<T> getAll() {
        return this.getAllData().stream().map((String csv)->converter.get(csv)).collect(Collectors.toList());
    }

    @Override
    public void updateAll(List<T> list) {
            this.deleteFile();
            list.forEach(e -> this.add(e));

    }
}
