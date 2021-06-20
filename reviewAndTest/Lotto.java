package reviewAndTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import mylib.MyLibs;

class SHA256 {
    public byte[] encrypt_byte(String text, String salt) throws NoSuchAlgorithmException {
        byte[] textByte = text.getBytes();
        byte[] saltByte = salt.getBytes();
        byte[] bytes = new byte[textByte.length + saltByte.length];

        System.arraycopy(textByte, 0, bytes, 0, textByte.length);
        System.arraycopy(saltByte, 0, bytes, textByte.length, salt.length());

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);

        return md.digest();
    }

    public String encrypt_string(String text, String salt) throws NoSuchAlgorithmException {
        byte[] textByte = text.getBytes();
        byte[] saltByte = salt.getBytes();
        byte[] bytes = new byte[textByte.length + saltByte.length];

        System.arraycopy(textByte, 0, bytes, 0, textByte.length);
        System.arraycopy(saltByte, 0, bytes, textByte.length, salt.length());

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);

        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}

public class Lotto {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] myInfo = { "류요선", "19950808", "RyuYoSeon", "A RH(+)", "17768", "1573035261" };
        String salt = "2000000000";
        int[] lottoIndexs = new int[6];
        int[] lottoNumbers = new int[6];
        int maxNumber = 45;
        int minNumber = 1;

        SHA256 sha256 = new SHA256();
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        int i = 0;
        while (i < 6) {
            boolean isExist = false;
            sr.setSeed(sha256.encrypt_byte(myInfo[i], salt + System.currentTimeMillis()));
            int randomNumber = sr.nextInt(7);

            for (int idx : lottoIndexs) {
                if (idx == randomNumber) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                lottoIndexs[i] = randomNumber;
                i++;
            }
        }

        i = 0;
        while (i < 6) {
            boolean isExist = false;
            sr.setSeed(sha256.encrypt_byte(myInfo[lottoIndexs[i] - 1], salt + System.currentTimeMillis()));
            int randomNumber = sr.nextInt(maxNumber - minNumber + 2);

            for (int number : lottoNumbers) {
                if (number == randomNumber) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                lottoNumbers[i] = randomNumber;
                i++;
            }
        }

        MyLibs.pList(lottoNumbers);
    }
}
