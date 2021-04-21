import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class FlyWeightTest {

    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage beforeHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        newEngineerObjects();
//        newEngineerFactory();

        MemoryUsage afterHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long consumed = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        System.out.println("used memory:" + (consumed / 1024) + "kb");


    }

    private static void newEngineerFactory() {
        System.out.println("New objects if it doesn't exist (Factory method)\n");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 99_000_000; i++) {
            Engineer engineer = (Engineer) JobFactory.getEngineer(getRandomEngineerType());
            engineer.setAge(randomInt(18, 60));
            engineer.setId(randomInt(1, 10));
//            printVariablesAndHashCode(engineer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Number of objects created: " + Engineer.noOfObjects);
        System.out.println("Time it took: " + (endTime - startTime) + "ms");
    }

    private static void newEngineerObjects() {
        System.out.println("New objects for every person\n");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 99_000_000; i++) {
            Engineer engineer = new Engineer(getRandomEngineerType());
            engineer.setAge(randomInt(18, 60));
            engineer.setId(randomInt(1, 10));
//            printVariablesAndHashCode(engineer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Number of objects created: " + Engineer.noOfObjects);
        System.out.println("Time it took: " + (endTime - startTime) + "ms");
    }

    private static void printVariablesAndHashCode(Engineer engineer) {
        engineer.printJob();
        System.out.println(engineer.hashCode());
    }

    public static int randomInt(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range);
    }

    private static String getRandomEngineerType() {
        return engineerTypes[(int) (Math.random() * engineerTypes.length)];
    }

    private static final String[] engineerTypes =
            {
                    "Software engineer",
                    "Database engineer",
                    "Chemical engineer",
                    "Windmill engineer",
                    "Network engineer"
            };
}

