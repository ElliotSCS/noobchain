package Structure;

import java.security.MessageDigest;

public class StringUtil {
    /**
     * Applies SHA256 to a string and returns the result.
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest =  MessageDigest.getInstance("SHA-256");

            //Applies Sha256
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This contains the hash as hexidecimal.
            for (byte currentByte : hash) {
                String hex = Integer.toHexString(0xff & currentByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch(Exception E) {
            throw new RuntimeException();
        }
    }
}
