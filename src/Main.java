public class Main {

    public static void main(String[] args) {
        String str1 = "pealp";
        String str2 = "peapl";

        int h;
//        int hash1 = ( h = str1.hashCode()) ^ h >>> 16;
//        int hash2 = ( h = str2.hashCode()) ^ h >>> 16;
        int hash1 = str1.hashCode() >>> 16;
        int hash2 = str2.hashCode() >>> 16;
        System.out.println("Hash code of \"" + str1 + "\": " + hash1);
        System.out.println("Hash code of \"" + str2 + "\": " + hash2);
        System.out.println("Hash code of \"" + str2 + "\": " + str2.hashCode());

    }

}