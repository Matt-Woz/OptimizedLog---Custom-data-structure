public class Driver {

    public static void main(String[] args) {
        OptimizedLog<String> color_list = new OptimizedLog<>();
        OptimizedLog<String> color_list2 = new OptimizedLog<>();
        color_list.add("Hi");
        color_list.add("Hi");
        color_list.add("Bye");
        color_list2.add("Hi");
        color_list2.add("Hi");
        color_list2.add("he;;p");
       // color_list2.add("Bye");


        System.out.println(color_list);
        System.out.println(color_list2);


        System.out.println(color_list.size());
        System.out.println(color_list2.size());
        System.out.println(color_list2.equals(color_list));

    }
}