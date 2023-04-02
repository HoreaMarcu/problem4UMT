

public class Main {
    public static int makeStrongPassword(String s) {
        int numChanges = 0;

        // Check if the password is too short or too long, and add to the change count accordingly
        if (s.length() < 6) {
            numChanges += 6 - s.length();
        } else if (s.length() > 20) {
            numChanges += s.length() - 20;
        }

        // Check if the password contains at least one lowercase letter, one uppercase letter, and one digit,
        // and add to the change count accordingly
        int missingTypes = 0;
        if (!s.matches(".*[a-z].*")) {
            missingTypes++;
        }
        if (!s.matches(".*[A-Z].*")) {
            missingTypes++;
        }
        if (!s.matches(".*\\d.*")) {
            missingTypes++;
        }
        numChanges += missingTypes;

        // Check if the password contains three repeating characters in a row,
        // and add to the change count accordingly
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                numChanges += (j - i) / 3;  // Count all repeating sequences
            }
            i = j;
        }

        return numChanges;
    }







    public static void main(String[] args) {
        System.out.println(makeStrongPassword("Strong1")); 

    }
}