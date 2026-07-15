public class Calc {
    public static int run(String cal) {
        if(cal == null || cal.trim().isEmpty()){
            return 0;
        }
        String trimStr = cal.replace(" ", "");
        for(int i = trimStr.length() - 1; i >= 0; i--){
            if(trimStr.charAt(i) == '+'){
                return run(trimStr.substring(0,i)) + run(trimStr.substring(i+1));
            }
            if(trimStr.charAt(i) == '-'){
                if(i == 0 || isOperator(trimStr.charAt(i - 1))) {
                    continue;
                }
                return run(trimStr.substring(0,i)) - run(trimStr.substring(i+1));
            }
        }
        for (int i = trimStr.length() - 1; i >= 0; i--) {
            if (trimStr.charAt(i) == '*') {
                return run(trimStr.substring(0, i)) * run(trimStr.substring(i + 1));
            }
            if (trimStr.charAt(i) == '/') {
                return run(trimStr.substring(0, i)) / run(trimStr.substring(i + 1));
            }
        }
        return Integer.parseInt(trimStr);
    }
    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
