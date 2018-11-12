public class wdString {
    public static void main(String[] args){
        String res = findString("aq8Wa9ertPyz0jnbhbhKjhghjYgghvjje");
        System.out.println(res);
    }

    private static String findString(String ip) {
        if(ip == null || ip.length() <= 0){
            return "";
        }

        int len = ip.length();

        int max;
        int start = 0;
        int end = 0;
        int lastCap = 0;

        int finalMax = Integer.MIN_VALUE;
        for(int i = 0, j = 0; i < len;){
            boolean foundOne = false;
            while( j < len && (Character.isLowerCase(ip.charAt(j)) ||
                    Character.isUpperCase(ip.charAt(j))) ){
                if(Character.isUpperCase(ip.charAt(j))){
                    if(foundOne == false){
                        foundOne = true;
                        lastCap = j;
                    }else{
                        break;
                    }
                }
                j++;

            }

            if(foundOne) {
                max = j - i + 1;
                if (max > finalMax) {
                    finalMax = max;
                    start = i;
                    end = j; // include
                    System.out.println(max);
                }

                j = lastCap + 1;
                i = j;
            }else{
                j++;
                i = j;
            }
        }

        return ip.substring(start, end);
    }
}
