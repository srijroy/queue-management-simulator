import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {//comparator is interface in java to define how two objs can be compared
    

    private int rank(Person p) {//converts persons type into a number
        //a type of categorical encoding you can say 
        switch (p.getType().toLowerCase()) {
            case "emergency": return 1;
            case "elderly":   return 2;
            default:          return 3;
        }
    }
//java is min-heap by default-->always pulls smalleast value first
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(rank(p1), rank(p2));
    }
}