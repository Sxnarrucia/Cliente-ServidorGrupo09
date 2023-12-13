package controlador;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncriptarPasswords {

    String secretKey = "Grupo09";

    public String codificar(String cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] bytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] TextoPlanoBytes = cadena.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(TextoPlanoBytes);
            byte[] base64Bytes = Base64.encodeBase64(buffer);
            encriptacion = new String(base64Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encriptacion;
    }

    public String decodificar(String cadenaEncriptada) {
        String desencriptacion = "";
        try {
            byte[] mensaje = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] dPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] bytesKey = Arrays.copyOf(dPassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] textPlano = descifrado.doFinal(mensaje);
            desencriptacion = new String(textPlano, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desencriptacion;
    }

}
