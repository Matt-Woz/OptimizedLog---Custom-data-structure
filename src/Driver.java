public class Driver {

    public static void main(String[] args) {
        OptimizedLog<String> log = new OptimizedLog<>();
        OptimizedLog<String> log2 = new OptimizedLog<>();
        log.add("hi");
        log.add("hi");
        log.add("hi");
        log.add("hi");
        log2.add("hi");
        log2.add("hi");
        log2.add("hi");
        log2.add("hi");

        System.out.println(log.equals(log2));
    }
}