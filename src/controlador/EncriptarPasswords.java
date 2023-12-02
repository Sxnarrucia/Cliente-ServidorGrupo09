package controlador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncriptarPasswords {

    private static final String ALGORITHM = "DESede";
    private static final String CHARSET = "UTF-8";

    private String secretKey = "Grupo09";

    public String codificar(String cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes(StandardCharsets.UTF_8));
            byte[] bytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey, ALGORITHM);
            Cipher cifrado = Cipher.getInstance(ALGORITHM);
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] TextoPlanoBytes = cadena.getBytes(StandardCharsets.UTF_8);
            byte[] buffer = cifrado.doFinal(TextoPlanoBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buffer);
            encriptacion = new String(base64Bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encriptacion;
    }

    public String decodificar(String cadenaEncriptada) {
        String desencriptacion = "";
        try {
            byte[] mensaje = Base64.getDecoder().decode(cadenaEncriptada.getBytes(CHARSET));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] dPassword = md5.digest(secretKey.getBytes(CHARSET));
            byte[] bytesKey = Arrays.copyOf(dPassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey, ALGORITHM);
            Cipher descifrado = Cipher.getInstance(ALGORITHM);
            descifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] textPlano = descifrado.doFinal(mensaje);
            desencriptacion = new String(textPlano, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desencriptacion;
    }
}
