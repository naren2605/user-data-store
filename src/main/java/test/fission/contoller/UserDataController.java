package test.fission.contoller;

import test.fission.model.User;
import test.fission.service.UserDataService;
import test.fission.service.UserDataServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UserDataController {
    private final UserDataService userDataService;
    private final BlockingQueue<String> queue;
    public UserDataController(){
        this.userDataService=new UserDataServiceImpl();
        queue=new LinkedBlockingQueue<>();

        new Thread(()-> {
            try {
                listenToQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void listenToQueue() throws InterruptedException {
        String command;
        while((command=queue.take())!=null&&(command!=null&&!command.equals("EXIT"))){
            command(command);
        }
        System.out.println("done...");
    }

    public void send(String command){
        queue.add(command);
    }


    public void command(String string){
        string=string.trim();
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
        }
        else{
            throw new InputMismatchException("please check the input and try again");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserDataController userDataController=new UserDataController();

       /* userDataController.send("Naveen, Chandra, 50, 25, Fission");
        userDataController.send("Virat, Kohli, 74, 55, HCL");
        userDataController.send("SORT");
        userDataController.send("Ashok, Verma, 17, 17, Fission");
        userDataController.send("Ashok, Verma, 16, 17, Fission");
        userDataController.send("SORT");
        userDataController.send("EXIT");*/

        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            String command=scanner.nextLine();
            userDataController.send(command);
            if (command.equals("EXIT")){
                break;
            }

        }
    }
}
