public class Calc {
    public static int run(String cal) {
        int result = 0;
        String[] splitStr = cal.split(" ");
        int value1 = Integer.parseInt(splitStr[0]);
        int value2 = Integer.parseInt(splitStr[2]);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(splitStr[1]);
        if(splitStr[1].equals("+")) {
            result = value1 + value2;
        }else if(splitStr[1].equals("-")) {
            result = value1 - value2;
        }
        return result;
    }
}
