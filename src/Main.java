public class Main {
    public static void main(String[] args) {
        Parameters p = new Parameters(args);
        EncDecFactory factory = new EncDecFactory();
        String result = factory.encryptDecryptFactory(p);
        System.out.println(result);
    }
}