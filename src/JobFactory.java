import java.util.HashMap;

public class JobFactory {
    private static final HashMap<String, Engineer> engineerMap = new HashMap<>();

    public static Job getEngineer(String job){
        Engineer engineer = engineerMap.get(job);

        if (engineer == null){
            engineer = new Engineer(job);
            engineerMap.put(job, engineer);
            System.out.println("Creating engineer of type: " + job);
        }
        return engineer;
    }
}
