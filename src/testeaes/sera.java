package testeaes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

//import Base64;
public class sera {
	private static final byte[] a = new byte[16];

	public static void main(String[] args) throws IOException {
		String decrypt = "";
		String linha = "";
		File c = new File("C:\\owned\\senhasbase64.txt");
		FileReader reader = new FileReader(c);
		// leitor do arquivo
		BufferedReader leitor = new BufferedReader(reader);
		while (true) {
			linha = leitor.readLine();
			if (linha == null)
				break;
			if (linha.equals("\"")) {
				continue;
			}
			try {
				
				//System.out.println(linha.substring(1));
				//primeiro parametro, cifra. segundo, senha da wifi.
				//senha 8js38kjJDLaksjks^%718jdj81HA74jakUq pra ssid
				decrypt = b("1788dkd893hjas12474&%4jMDJFlq(82423",linha.substring(1));
				if (decrypt.equals("falhou") || decrypt.length()==0) {
					
				} else {
					System.out.println(decrypt);
				}
			} catch (Exception e) {

			}

		}

		// System.out.println(b("1788dkd893hjas12474&%4jMDJFlq(82423","NkY5RjA4QjQxQzA2RUExREMzNzIwRDc0QjMyOTNDRDU="));

	}

	public static String b(String paramString1, String paramString2) {
		int i = 16;
		try {
			byte[] arrayOfByte1 = paramString1.getBytes();
			byte[] arrayOfByte2 = a;
			if (arrayOfByte1.length < i)
				i = arrayOfByte1.length;
			System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
			String str2 = new String(Base64.decode(paramString2, 0));
			String str1 = new String(agoravai(digere(arrayOfByte1),
					mexenoA(str2)));
			return str1;
		} catch (Exception localException) {

			//System.out.println("decrypt " + localException.getMessage());
			String str1 = null;

		}
		return "falhou";
	}

	private static byte[] digere(byte[] paramArrayOfByte)
			throws NoSuchAlgorithmException {
		MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
		localMessageDigest.reset();
		return localMessageDigest.digest(paramArrayOfByte);
	}

	private static byte[] agoravai(byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1,
				"AES");
		Cipher localCipher = Cipher.getInstance("AES");
		localCipher.init(2, localSecretKeySpec);
		return localCipher.doFinal(paramArrayOfByte2);
	}

	public static byte[] mexenoA(String paramString) {
		int i = paramString.length() / 2;
		byte[] arrayOfByte = new byte[i];
		for (int j = 0;; j++) {
			if (j >= i)
				return arrayOfByte;
			arrayOfByte[j] = Integer.valueOf(
					paramString.substring(j * 2, 2 + j * 2), 16).byteValue();
		}
	}

}
