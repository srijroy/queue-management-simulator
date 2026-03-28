public class Person {
    private String name;
    private int age;
    private String type;//Normal,elderly,emergency

    public Person(String name,int age,String type){
        this.name=name;
        this.age=age;
        if(age>60 && type.equalsIgnoreCase("Normal")){
            this.type="Elderly";
            System.out.println("[Auto]"+name+"upgraded to Elderly");
        }else{
            this.type=type;
        }
    }
    public String getName(){
        return name;

    }
    public int getAge(){
        return age;
    }
    public String getType(){
        return type;
    }
    @Override
    public String toString(){
        return String.format("%-20s | Age: %-3d | Type: %s", name, age, type);
        
    }
}
