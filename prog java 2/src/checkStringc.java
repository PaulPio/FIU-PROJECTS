public class checkStringc {
    public static void main(String[]args) {

        System.out.println(checkString("Apple"));
        System.out.println(checkString("!Apple"));
        System.out.println(checkString("apple"));


    }

    public static boolean checkString(String input){
        char initial = input.charAt(0);

        if (!Character.isUpperCase(initial)) {
            return false;
        }
        for (char c: input.toCharArray()) {
            if(!Character.isLetter(c)){
                return false;
            }
        }

        return true;
    }
}
