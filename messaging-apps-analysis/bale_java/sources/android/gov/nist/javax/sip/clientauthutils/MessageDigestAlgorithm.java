package android.gov.nist.javax.sip.clientauthutils;

import android.gov.nist.core.StackLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class MessageDigestAlgorithm {
    private static final char[] toHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String H(String str) {
        try {
            return toHexString(MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to instantiate an MD5 algorithm", e);
        }
    }

    private static String KD(String str, String str2) {
        return H(str + ":" + str2);
    }

    static String calculateResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, StackLogger stackLogger) {
        String str10;
        if (stackLogger.isLoggingEnabled(32)) {
            stackLogger.logDebug("trying to authenticate using : " + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + str5 + ", " + str6 + ", " + str7 + ", " + str8 + ", " + str9);
        }
        if (str2 == null || str6 == null || str7 == null || str3 == null) {
            throw new NullPointerException("Null parameter to MessageDigestAlgorithm.calculateResponse()");
        }
        if (str5 == null || str5.length() == 0) {
            throw new NullPointerException("cnonce_value may not be absent for MD5-Sess algorithm.");
        }
        if (str9 == null || str9.trim().length() == 0 || str9.trim().equalsIgnoreCase("auth")) {
            str10 = str6 + ":" + str7;
        } else {
            if (str8 == null) {
                str8 = "";
            }
            str10 = str6 + ":" + str7 + ":" + H(str8);
        }
        if (str9 == null || str4 == null || !(str9.equalsIgnoreCase("auth") || str9.equalsIgnoreCase("auth-int"))) {
            return KD(str2, str3 + ":" + H(str10));
        }
        return KD(str2, str3 + ":" + str4 + ":" + str5 + ":" + str9 + ":" + H(str10));
    }

    private static String toHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = toHex;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    static String calculateResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, StackLogger stackLogger) {
        String string;
        String str12;
        if (stackLogger.isLoggingEnabled(32)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trying to authenticate using : ");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append(", ");
            sb.append(str4 != null && str4.trim().length() > 0);
            sb.append(", ");
            sb.append(str5);
            sb.append(", ");
            sb.append(str6);
            sb.append(", ");
            sb.append(str7);
            sb.append(", ");
            sb.append(str8);
            sb.append(", ");
            sb.append(str9);
            sb.append(", ");
            sb.append(str10);
            sb.append(", ");
            sb.append(str11);
            stackLogger.logDebug(sb.toString());
        }
        if (str2 != null && str3 != null && str4 != null && str8 != null && str9 != null && str5 != null) {
            if (str != null && str.trim().length() != 0 && !str.trim().equalsIgnoreCase(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM)) {
                if (str7 != null && str7.length() != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(H(str2 + ":" + str3 + ":" + str4));
                    sb2.append(":");
                    sb2.append(str5);
                    sb2.append(":");
                    sb2.append(str7);
                    string = sb2.toString();
                } else {
                    throw new NullPointerException("cnonce_value may not be absent for MD5-Sess algorithm.");
                }
            } else {
                string = str2 + ":" + str3 + ":" + str4;
            }
            if (str11 != null && str11.trim().length() != 0 && !str11.trim().equalsIgnoreCase("auth")) {
                if (str10 == null) {
                    str10 = "";
                }
                str12 = str8 + ":" + str9 + ":" + H(str10);
            } else {
                str12 = str8 + ":" + str9;
            }
            if (str7 != null && str11 != null && str6 != null && (str11.equalsIgnoreCase("auth") || str11.equalsIgnoreCase("auth-int"))) {
                return KD(H(string), str5 + ":" + str6 + ":" + str7 + ":" + str11 + ":" + H(str12));
            }
            return KD(H(string), str5 + ":" + H(str12));
        }
        throw new NullPointerException("Null parameter to MessageDigestAlgorithm.calculateResponse()");
    }
}
