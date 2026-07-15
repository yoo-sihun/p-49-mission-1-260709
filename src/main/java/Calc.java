public class Calc {
    public static int run(String cal) {
        if(cal == null || cal.trim().isEmpty()){
            return 0;
        }
        String trimStr = cal.replace(" ", "");

        while(trimStr.startsWith("(") && trimStr.endsWith(")")) {
            boolean isBracket = true;
            int depth = 0;

            for(int i = 0; i < trimStr.length() - 1; i++) {
                char c = trimStr.charAt(i);
                if(c == '(') depth++;
                if(c == ')') depth--;

                if(depth <= 0) {
                    isBracket = false;
                    break;
                }
            }
            if (isBracket) {
                trimStr = trimStr.substring(1, trimStr.length() - 1);
            } else {
                break; // 껍데기 괄호가 아니면 탈출!
            }
        }
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
