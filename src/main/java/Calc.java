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

        int depth = 0;
        for(int i = trimStr.length() - 1; i >= 0; i--){
            char c = trimStr.charAt(i);

            if(c == ')')depth++;
            else if(c == '(')depth--;

            if(depth == 0) {
                if (c == '+') {
                    if (i > 0 && isOperator(trimStr.charAt(i - 1))) {
                        continue;
                    }
                    return run(trimStr.substring(0, i)) + run(trimStr.substring(i + 1));
                }
                if (c == '-') {
                    if (i > 0 && (Character.isDigit(trimStr.charAt(i - 1)) || trimStr.charAt(i - 1) == ')')) {
                        return run(trimStr.substring(0, i)) - run(trimStr.substring(i + 1));

                    }
                    continue;
                }
            }
        }

        depth = 0;

        for(int i = trimStr.length() - 1; i >= 0; i--) {
            char c = trimStr.charAt(i);

            if (c == ')') depth++;
            else if (c == '(') depth--;

            if (depth == 0) {
                    if (c == '*') {
                        return run(trimStr.substring(0, i)) * run(trimStr.substring(i + 1));
                    }
                    if (c == '/') {
                        return run(trimStr.substring(0, i)) / run(trimStr.substring(i + 1));
                    }
                }
            }

                if (trimStr.startsWith("-")) {
                    return -1 * run(trimStr.substring(1)); // 마이너스를 뗀 뒷부분만 다시 재귀로 구해서 곱해줍니다!
                }
                return Integer.parseInt(trimStr);
            }

    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
