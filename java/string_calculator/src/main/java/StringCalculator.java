public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            int returnValue = 0;
            for (String nextNumber : input.substring(4).split("[\n"+ input.charAt(2) +"]")) {
                returnValue += Integer.parseInt(nextNumber);
            }
            return returnValue;
        } else {
            int result = 0;
            for (String nextNumber : input.split("[\n,]")) {
                result += Integer.parseInt(nextNumber);
            }
            return result;
        }
    }
}
