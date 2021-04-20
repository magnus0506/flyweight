public class Engineer implements Job {
    private String job;
    private int age;
    private int id;
    static int noOfObjects = 0;

    public Engineer(String job) {
        this.job = job;
        noOfObjects += 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void printJob() {
        System.out.println("Employee: " + id + ", age: " + age + ", position: " + job);
    }
}
