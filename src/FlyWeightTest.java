import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Arrays;

public class FlyWeightTest {

    public static void main(String[] args) {

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage beforeHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        newEngineerFactory();

        MemoryUsage afterHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long consumed = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        System.out.println("brugt memory efter metode: " + (consumed) + "");

        newEngineerObjects();

        afterHeapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        consumed = afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        System.out.println("brugt memory efter metode: " + (consumed) + "");

    }
    private static void newEngineerFactory() {
        System.out.println("New objects if it doesn't exist (Factory method)\n");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Engineer engineer = (Engineer) JobFactory.getEngineer(getRandomEngineerType());
            engineer.setAge(randomInt(18, 60));
            engineer.setId(randomInt(1, 10));
//            engineer.printJob();
//            System.out.println(engineer.hashCode());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Number of objects created: " + Engineer.noOfObjects);
        System.out.println("Time it took: " + (endTime - startTime) + "ms");
    }

    private static void newEngineerObjects() {
        System.out.println("New objects for every person\n");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Engineer engineer = new Engineer(getRandomEngineerType());
            engineer.setAge(randomInt(18, 60));
            engineer.setId(randomInt(1, 10));
//            engineer.printJob();
//            System.out.println(engineer.hashCode());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Number of objects created: " + Engineer.noOfObjects);
        System.out.println("Time it took: " + (endTime - startTime) + "ms");
    }

    private static final String[] engineerTypes =
            {
                    "Software engineer",
                    "Database engineer",
                    "Chemical engineer",
                    "Windmill engineer",
                    "Network engineer"};

    public static int randomInt(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range);
    }

    private static String getRandomEngineerType() {
        return engineerTypes[(int) (Math.random() * engineerTypes.length)];
    }
}

