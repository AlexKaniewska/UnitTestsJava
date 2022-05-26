import java.util.*;

public class Registry {

    private ArrayList<Worker> registry;


    public Registry(){
        this.registry = new ArrayList<Worker>();
    }

    public void setList(ArrayList<Worker> list){
        this.registry = list;
    }

    public ArrayList<Worker> getList(){
        return this.registry;
    }


    public void addWorkers(Worker ...args){
        for (Worker i : args){
            this.registry.add(i);
        }
    }

    public void deleteWorker(long id){
        for(Worker i : this.registry){
            if(i.getID() == id){
                this.registry.remove(i);
            }
        }
    }

    

    public void showWorkersSort(){
        Comparator<Worker> sortWorkers = Comparator.comparing(Worker::getExp).reversed()
        .thenComparing(Worker::getAge)
        .thenComparing(Worker::getSurname);

        ArrayList<Worker> new_list = this.registry;
        new_list.sort(sortWorkers);

        for(Worker i: new_list){
            System.out.print("Name: " + i.getName() + " Surname: " + i.getSurname() + " Age: " + i.getAge() + " Doświadczenie: " + i.getExp() + '\n');
        }
    }


    public void showWorkersCity(String city){
        System.out.print("Lista pracowników pracująca w mieście: " + city);
        for(Worker i : this.registry){
            if(i.getAddress().getCity() == city){
                System.out.print("Name: "+ i.getName() + " Surname: " + i.getSurname() + '\n');
            }
        }
    }

    public void showWorkersValue(){
        System.out.print("Lista pracowników i ich wartości dla korporacji: ");
        
        for(Worker i : this.registry){
            System.out.print("Name: " + i.getName() + " Surname: " + i.getSurname() + " Warość korporacji: " + i.worker_value() + '\n');
        }
    }


    //check


    public ArrayList<Worker> showWorkersCity2(String city){
        ArrayList<Worker> new_list = new ArrayList<Worker>();
        for(Worker i : this.registry){
            if(i.getAddress().getCity() == city){
                new_list.add(i);
            }
        }
        return new_list;
    }

    public ArrayList<Integer> showWorkersValue2(){
        ArrayList<Integer> new_list = new ArrayList<Integer>();
        
        for(Worker i : this.registry){
            new_list.add(i.worker_value());
        }
        return new_list;
    }
}
