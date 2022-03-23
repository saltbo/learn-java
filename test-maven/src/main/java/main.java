import com.google.common.hash.Hashing;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(123);

        MessageDigest md5 = MessageDigest.getInstance("md5");
        System.out.println(Hex.encodeHexString(md5.digest("aaa".getBytes())));

        System.out.println(DigestUtils.md5Hex("aaa"));

        System.out.println(Hashing.md5().hashBytes("aaa".getBytes()).toString());
    }
}
