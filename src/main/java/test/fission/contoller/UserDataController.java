package test.fission.contoller;

import test.fission.model.User;
import test.fission.service.UserDataService;
import test.fission.service.UserDataServiceImpl;

import java.util.InputMismatchException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UserDataController {
    private final UserDataService userDataService;
    private final ConcurrentLinkedQueue<String> concurrentLinkedQueue;
    public UserDataController(){
        this.userDataService=new UserDataServiceImpl();
        concurrentLinkedQueue=new ConcurrentLinkedQueue<>();
        new Thread(()->listenToQueue()).start();

    }

    public void listenToQueue(){
        String command;
        while((command=concurrentLinkedQueue.poll())!=null||(command!=null&&!command.equals("EXIT"))){
            command(command);
        }
    }

    public void send(String command){
        concurrentLinkedQueue.add(command);
    }


    public void command(String string){
        if(string!=null&&string.matches(" *.+, *.+, *[0-9]+, *[0-9]+, *.+")){
                String[] values=string.split(",");
            User user =new User();
            user.setFirstName(values[0].trim());
            user.setLastName(values[1].trim());
            user.setExperience(new Integer(values[2].trim()));
            user.setAge(new Integer(values[3].trim()));
            user.setOrganization(values[4].trim());
            userDataService.add(user);
        }else if(string.equals("SORT")){
            userDataService.sort();
        }else if(string.equals("EXIT")){
            System.out.println("graceful exit...");
            System.exit(0);
        }
        else{
            throw new InputMismatchException("please check the input and try again");
        }
    }

    public static void main(String[] args) {
        UserDataController userDataController=new UserDataController();

        userDataController.send("Naveen, Chandra, 50, 25, Fission");
        userDataController.send("Virat, Kohli, 74, 55, HCL");
        userDataController.send("SORT");
        userDataController.send("Ashok, Verma, 17, 17, Fission");
        userDataController.send("Ashok, Verma, 16, 17, Fission");
        userDataController.send("SORT");
        userDataController.send("EXIT");

    }
}
