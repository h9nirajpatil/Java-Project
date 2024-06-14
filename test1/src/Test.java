public class Test {
    public Test() {
        try {
            System.out.println("Hi Shivam");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Shivam");
        }
    }


}
