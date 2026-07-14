public class Calc {
    public static int run(String cal) {
        String trimStr = cal.trim();
        for(int i = trimStr.length() - 1; i >= 0; i--){
            if(trimStr.charAt(i) == '+'){
                return run(trimStr.substring(0,i)) + run(trimStr.substring(i+1));
            }
            if(trimStr.charAt(i) == '-'){
                return run(trimStr.substring(0,i)) - run(trimStr.substring(i+1));
            }
        }
        return Integer.parseInt(trimStr);
    }
}
