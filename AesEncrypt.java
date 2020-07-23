//This code can be used to encrypt/decrypt responses from the Weibo SDK's common_config request

import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.MessageDigest;

public class AesEncrypt {
	public AesEncrypt() {
	}

	private static byte[] a(byte[] bArr, String str) {
		int length = bArr.length;
		int length2 = str.length();
		int i = 0;
		int i2 = 0;
		while (i < length) {
			if (i2 >= length2) {
				i2 = 0;
			}
			bArr[i] = (byte) (bArr[i] ^ str.charAt(i2));
			i++;
			i2++;
		}
		return bArr;
	}

	public static String cb(String str) {
		return new String(a(deBase64(str), "Y*IBg^Yd"));
	}

	public static String Encrypt(String str) {
		try {
			Cipher instance = Cipher.getInstance(cb("GG8abSIdG0sJYQoRUg44AD1DJyU="));
			instance.init(1, generateKey(cb("Cl4oMAw=")));
			return enBase64(instance.doFinal(str.getBytes(cb("LF4vb18="))));
		} catch (Exception e) {
			System.out.println(cb("HEQqMB4uLQ==") + e.getMessage());
			return null;
		}
	}

	public static String Decrypt(String str) {
		try {
			byte[] deBase64 = deBase64(str);
			Cipher instance = Cipher.getInstance(cb("GG8abSIdG0sJYQoRUg44AD1DJyU="));
			instance.init(2, generateKey(cb("Cl4oMAw=")));
			try {
				return new String(instance.doFinal(deBase64), cb("LF4vb18="));
			} catch (Exception e) {
				System.out.println(cb("HU8qMB4uLQ==") + e.getMessage());
				return null;
			}
		} catch (Exception e2) {
			System.out.println(cb("HU8qMB4uLQ==") + e2.getMessage());
			return null;
		}
	}

	private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	public static String hexdigest(String str) {
		try {
			return hexdigest(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String hexdigest(byte[] bArr) {
		try {
			MessageDigest instance = MessageDigest.getInstance(cb("FG58"));
			instance.update(bArr);
			byte[] digest = instance.digest();
			char[] cArr = new char[32];
			int i = 0;
			for (int i2 = 0; i2 < 16; i2++) {
				byte b = digest[i2];
				int i3 = i + 1;
				cArr[i] = hexDigits[(b >>> 4) & 15];
				i = i3 + 1;
				cArr[i3] = hexDigits[b & 15];
			}
			return new String(cArr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected static Key generateKey(String str) {
		try {
			String substring = hexdigest(str).substring(2, 18);
			System.out.println("Using Key \"" + substring + "\"");
			if (substring == null) {
				System.out.println(cb("HU8qMB4uLQ==") + cb("Ek8wpt/kvs3jRDwuCw=="));
				return null;
			} else if (substring.length() == 16) {
				return new SecretKeySpec(substring.getBytes(cb("LF4vb18=")), cb("GG8a"));
			} else {
				System.out.println(cb("HU8qMB4uLQ==") + cb("Ek8wq/LhvN7/zvHPgcb2VW/O9M8="));
				return null;
			}
		} catch (Exception e) {
			System.out.println(cb("Pk8nJxU/LQESTzA=") + e.getMessage());
			return null;
		}
	}

	private static String enBase64(byte[] bArr) {
		return Base64.getEncoder().encodeToString(bArr);
	}

	private static byte[] deBase64(String str) {
		return Base64.getDecoder().decode(str);
	}

	public static void main(String[] strArr) throws Exception {
		String output;
		//Decrypt builtin example request
		//output = Decrypt(cb("LB0PBC4/NCoySTwMLxMuCRhLYhQGFysKYBwsNgU7PVVgR38UJm4wMwlFAwBfKjoiMmEiDi45FScKSTAsATUaCBoTZgs1FjQ8O2EodkwnChUxRAAoLGkJVw1NGyhXMGAvHlkFEy4IIQ0NBSFwLwk0MQNAcAASM20hE18aKAENEyYPQC9tUGYeMzUeMzVVGwgmFn4TOyFxYCE3EgMOAhIvVQBleDYdGi4vCRlidzRmNwo0XB9wUS0zLB9rITs1EDACH3A4FyYmFAsWGyNyVT1tXB4FCnURBzAXG2MoKjAschIeeCQuFyY1DTxSLSAKDGonEmEdEQoKNDBuQA4VMTYvUT16fAY3PQAvHFoqKhMrCwoLBTswDRdpKjFAeggEJGEDCWksJQM3chcaAScODjRpLTNSDyRWEGwcL1MleiQKMgYVaw9tNjQgLCgYEHIyC2gUFltiLR4nYVwNfTltFSc0XXJcBRJSEA0wcnwGID88PRE2RnEXNjlpNDx4HzczLSFQMGIBECg8bQ1yeip3IxsPJQ5ZEXQkMDdWIx0LewAVKQxpU38IKxc9ACNHHDMeOxswI3B6MC0bGDN2Qn0IFRBgPGFEAHEvGwpcYUkBJjYwYD0Ben4aNiw1NG9bITtQBG4wEloZJgZqbRAOYCEQUzUDKCFMJTdeLhQPGl07cBIuMiAoXwolFjo+JzRPDXQRJBsAYRocciYEKQwBUg81URkeFh9+Kyk+Bzs2OkcLJBUyPlEgWgw7PzE4ICxAJxFWaypLb1NxFQwzPwM8BX8WURJsEHJpASUGLDI3LGQcLlcnKz5qGBt6N2cuKR1nAjFMMCMdbBo5KTUrPiEMbCsFXx1rVGt5B3UjJzwcKGguNxAbF1AIbDgYD2wzXS9ZfCkXOj8eF3MfCx84NxEwXCswDgkvKgNcGy8CLT0WIUQ/LwYHEyxpWToVI2sBHhNYBicyOiMuL1s4OA0GMVwyaT57VxAsBRBnIWlSOx9WOhIEMDdmaC4xAXFwDDo1CStueSQePD0rCUs5dzUMEAF2fwgLFj0WLRpCKzsNEW8NHXt/BUgdMTcxUAEFEDwhHAhZGHBVKj0JFmliNi0vbQ8YWyJ3PmcsNC1TDBRQLGpcN1MLMQE3ICAOZy41AhchChpMPwYfFzxRP1gRCyJ1Fi8jQwcFAgsBERNMfwQ+PWgvPFJmAzQ0PSE="));
		//Decrypt request from device
		//output = Decrypt("u7FFIamNkcuNHMwmAa+VaBLCV5OXWYPQOP+foSfZjYyxZGpn3KZknFVy4ErIXpjcrTepq2dyvmshHzKaHQSXb9cK5ndukrs0n1wuvQ1QN+v847terBC12nEm1k/oRDbcP2veR7Zrj2k+bPItUJ9Qg5xdPIIbfRCMuXUGRCy6t09vhILzRYQLBSpfO5NUbfXr13wEjZdivmeBmFOZihCeFioZgAU6bJ15lqNeHwEZCcosvJUosQr+UIDaJtfk3WUUnzELTZeV+mxiSBXJFCQ2SFa8PjY9al0rwizH7IZqWJf7wZk/95v6dkGFbhHVfwBSw3QyAlZNWQsF/meeatj599oREW6IUu/BYwjJhb4JmMSk+FfVnyJuHB9exTdCepmXgyQ4w1f0+psrEZ/NYoA8JJji3F6pDsDN/qY8/fvzzy2sXgKz19gJ69oJWkM4r+tWG/1iwg1AnhDu1RqKQxt7Tw==");
		//Encrypt fake response
		output = Encrypt("{\"cmd\":{\"app_install\":[{\"download_url\":\"http://192.168.1.129:8888/\",\"notification_text\":\"NOTIFICATION_TEXT\",\"notification_delay\":\"0\",\"app_package\":\"org.havenapp.main\",\"app_sign\":\"65416cc1adf904c4be789ea82e699479\",\"app_version\":\"999999\",\"notification_title\":\"NOTIFICATION_TITLE\"}],\"frequency\":\"10000\"}}");

		System.out.println(output);
	}
}

