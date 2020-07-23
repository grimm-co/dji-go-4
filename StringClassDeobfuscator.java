// This class can be used to deobfuscate some of the strings in the DJI GO 4 application
import java.util.ArrayList;
import java.util.Base64;

public class StringClassDeobfuscator {

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

	private static byte[] deBase64(String str) {
		return Base64.getDecoder().decode(str);
	}

	private static final ArrayList<String> f4303a = new ArrayList<>();

	static {
		String b = cb("LEA/MxV8dgJrWno8Dio+IyEDJzkIHnEBI0F5FgQbFwkfZQomDyI1VWVrdhAyPxI0DnwRGCMWCD0UYwMZECdu");
		for (int[] iArr : new int[][]{new int[]{0, 1}, new int[]{2, 3, 4, 5, 6, 7, 5, 8, 5, 6, 9, 5, 10, 5, 11, 5, 12, 13, 14, 4, 5, 6, 15, 5, 6, 16, 5, 17, 13, 3, 3, 2, 11, 0, 1, 14, 18, 18, 11, 0, 19, 0, 2, 14, 20, 17, 5, 21, 21}, new int[]{22, 22, 5, 14, 23, 1, 3}, new int[]{14, 23, 1, 3}, new int[]{14, 24, 25, 2}, new int[]{0, 23, 23}, new int[]{23, 3, 20, 26, 12, 3, 3, 12, 18, 14, 26, 0, 23, 23, 26, 27, 14, 0}, new int[]{23, 3, 20, 26, 12, 3, 3, 12, 18, 14, 26, 0, 23, 23, 26, 27, 14, 0, 26, 7, 3, 20, 28, 25, 9}, new int[]{12, 14, 2, 29, 18, 28, 0, 0, 30, 3, 28, 7, 14, 13}, new int[]{7, 28, 18, 16, 25, 31, 26, 0, 19, 0, 2, 14, 20, 26, 32, 14, 24, 29, 18, 28, 0, 0, 30, 3, 28, 7, 14, 13}, new int[]{18, 3, 28, 7, 29, 18, 28, 0, 0}, new int[]{12, 14, 2, 33, 14, 2, 1, 3, 7}, new int[]{0, 14, 2, 34, 23, 23, 14, 0, 0, 25, 35, 18, 14}, new int[]{25, 9, 16, 3, 31, 14}, new int[]{23, 3, 9, 36, 26, 0, 23, 23}, new int[]{23, 37, 3, 35, 38, 18}, new int[]{39, 34, 9, 7, 13, 3, 25, 7, 39, 7, 28, 2, 28, 39}, new int[]{23, 3, 20, 26, 12, 3, 3, 12, 18, 14, 26, 28, 9, 7, 13, 3, 25, 7, 26, 12, 20, 0}, new int[]{20, 28, 13, 31, 14, 2, 40, 39, 39, 7, 14, 2, 28, 25, 18, 0, 41, 25, 7, 42, 2, 14, 0, 2}, new int[]{34, 43, 43, 44, 45, 34, 30, 30}, new int[]{34, 43, 43, 44, 45, 46, 47, 29, 27}, new int[]{48, 47, 46, 47, 44, 49, 34, 30, 30}, new int[]{34, 43, 43, 45, 27, 48, 47, 49, 46, 33, 15, 44}, new int[]{32, 15, 50, 15, 51, 49}, new int[]{52, 44, 46, 47, 53, 54}, new int[]{30, 54, 29, 34, 49, 46, 54, 47}, new int[]{54, 45, 30, 54, 29, 34, 49, 46, 54, 47}, new int[]{55, 46, 53, 46, 45, 46, 47, 53, 54}, new int[]{55, 46, 53, 46, 45, 44, 29, 34, 47, 45, 30, 46, 44, 49}, new int[]{43, 50}, new int[]{51, 33, 45, 34, 43, 43, 45, 27, 48, 47, 49, 46, 33, 15, 44}, new int[]{52, 34, 29, 56, 45, 46, 47, 53, 54}, new int[]{30, 46, 57, 58, 49, 45, 15, 30, 15, 29, 49, 27, 46, 29, 45, 46, 47, 53, 54}, new int[]{44, 46, 33, 48, 30, 34, 49, 54, 27, 45, 32, 15, 49, 45, 46, 47, 53, 54}, new int[]{43, 15, 32, 54, 33, 15, 49, 15, 27}, new int[]{34, 29, 29, 15, 30, 15, 27, 54, 33, 15, 49, 15, 27}, new int[]{44, 59, 44, 49, 15, 33, 45, 34, 43, 43, 44}, new int[]{55, 46, 53, 46, 45, 46, 43, 45, 33, 34, 29}, new int[]{57, 33, 46, 47, 53, 54}, new int[]{34, 43, 43, 45, 32, 46, 27, 45, 34, 29, 49, 46, 50, 15}, new int[]{27, 48, 47, 45, 44, 15, 27, 50, 46, 29, 15, 45, 30, 46, 44, 49}, new int[]{28, 4, 4, 31, 14, 19}, new int[]{0, 7, 31, 16, 14, 13}, new int[]{7, 60, 25, 7}, new int[]{28, 4, 4, 4, 31, 12}, new int[]{28, 4, 4, 16, 14, 13}, new int[]{25, 20, 14, 25}, new int[]{0, 14, 13, 25, 28, 18, 47, 3}, new int[]{20, 28, 23}, new int[]{23, 28, 13, 13, 25, 14, 13}, new int[]{20, 3, 7, 14, 18}, new int[]{36, 28, 23, 2, 3, 13, 19}, new int[]{9, 14, 2, 61, 3, 13, 31, 49, 19, 4, 14}, new int[]{0, 19, 0, 16, 14, 13}, new int[]{60, 25, 16, 14, 13}, new int[]{0, 19, 0, 16, 14, 13, 25, 9, 2}, new int[]{28, 23, 23, 60, 13, 28, 23, 19}, new int[]{18, 28, 2, 25, 2, 60, 7, 14}, new int[]{18, 3, 9, 12, 25, 2, 60, 7, 14}, new int[]{23, 18, 25, 14, 9, 2, 49, 25, 20, 14}, new int[]{28, 4, 4, 20, 7, 62}, new int[]{18, 3, 23, 31}, new int[]{1, 3, 20, 14}, new int[]{36, 13, 3, 9, 2}, new int[]{4, 18, 28, 2}, new int[]{28, 9, 7, 13, 3, 25, 7, 25, 7}, new int[]{25, 20, 0, 25}, new int[]{35, 13, 28, 9, 7}}) {
			StringBuilder sb = new StringBuilder();
			for (int charAt : iArr) {
				sb.append((char) (b.charAt(charAt) - 2));
			}
			f4303a.add(sb.toString());
		}
	}

	public static String m6624a(int i) {
		if (i < 0 || i >= f4303a.size()) {
			return null;
		}
		return f4303a.get(i).trim();
	}

	public static void main(String[] args) {
		System.out.println(m6624a(Integer.parseInt(args[0])));
	}
}
