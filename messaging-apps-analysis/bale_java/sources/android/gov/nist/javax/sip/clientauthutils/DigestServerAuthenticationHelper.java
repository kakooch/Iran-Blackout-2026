package android.gov.nist.javax.sip.clientauthutils;

import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import ir.nasim.InterfaceC10039ay5;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC9436Zx5;
import ir.nasim.LU2;
import ir.nasim.UP5;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/* loaded from: classes.dex */
public class DigestServerAuthenticationHelper {
    public static final String DEFAULT_ALGORITHM = "MD5";
    public static final String DEFAULT_SCHEME = "Digest";
    private static final char[] toHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private MessageDigest messageDigest = MessageDigest.getInstance(DEFAULT_ALGORITHM);

    private String generateNonce() {
        return toHexString(this.messageDigest.digest((new Long(new Date().getTime()).toString() + new Long(new Random().nextLong()).toString()).getBytes()));
    }

    public static String toHexString(byte[] bArr) {
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

    public boolean doAuthenticateHashedPassword(UP5 up5, String str) {
        InterfaceC10039ay5 interfaceC10039ay5 = (InterfaceC10039ay5) up5.getHeader(SIPHeaderNames.PROXY_AUTHORIZATION);
        if (interfaceC10039ay5 == null) {
            return false;
        }
        String realm = interfaceC10039ay5.getRealm();
        if (interfaceC10039ay5.getUsername() == null || realm == null) {
            return false;
        }
        String nonce = interfaceC10039ay5.getNonce();
        InterfaceC21815uA7 uri = interfaceC10039ay5.getURI();
        if (uri == null) {
            return false;
        }
        String hexString = toHexString(this.messageDigest.digest((up5.getMethod().toUpperCase() + ":" + uri.toString()).getBytes()));
        String cNonce = interfaceC10039ay5.getCNonce();
        String str2 = str + ":" + nonce;
        if (cNonce != null) {
            str2 = str2 + ":" + cNonce;
        }
        return toHexString(this.messageDigest.digest((str2 + ":" + hexString).getBytes())).equals(interfaceC10039ay5.getResponse());
    }

    public boolean doAuthenticatePlainTextPassword(UP5 up5, String str) {
        InterfaceC10039ay5 interfaceC10039ay5 = (InterfaceC10039ay5) up5.getHeader(SIPHeaderNames.PROXY_AUTHORIZATION);
        if (interfaceC10039ay5 == null) {
            return false;
        }
        String realm = interfaceC10039ay5.getRealm();
        String username = interfaceC10039ay5.getUsername();
        if (username == null || realm == null) {
            return false;
        }
        String nonce = interfaceC10039ay5.getNonce();
        InterfaceC21815uA7 uri = interfaceC10039ay5.getURI();
        if (uri == null) {
            return false;
        }
        String str2 = up5.getMethod().toUpperCase() + ":" + uri.toString();
        String hexString = toHexString(this.messageDigest.digest((username + ":" + realm + ":" + str).getBytes()));
        String hexString2 = toHexString(this.messageDigest.digest(str2.getBytes()));
        String cNonce = interfaceC10039ay5.getCNonce();
        String str3 = hexString + ":" + nonce;
        if (cNonce != null) {
            str3 = str3 + ":" + cNonce;
        }
        return toHexString(this.messageDigest.digest((str3 + ":" + hexString2).getBytes())).equals(interfaceC10039ay5.getResponse());
    }

    public void generateChallenge(LU2 lu2, InterfaceC10981cX5 interfaceC10981cX5, String str) {
        try {
            InterfaceC9436Zx5 interfaceC9436Zx5CreateProxyAuthenticateHeader = lu2.createProxyAuthenticateHeader("Digest");
            interfaceC9436Zx5CreateProxyAuthenticateHeader.setParameter("realm", str);
            interfaceC9436Zx5CreateProxyAuthenticateHeader.setParameter("nonce", generateNonce());
            interfaceC9436Zx5CreateProxyAuthenticateHeader.setParameter("opaque", "");
            interfaceC9436Zx5CreateProxyAuthenticateHeader.setParameter("stale", "FALSE");
            interfaceC9436Zx5CreateProxyAuthenticateHeader.setParameter("algorithm", DEFAULT_ALGORITHM);
            interfaceC10981cX5.setHeader(interfaceC9436Zx5CreateProxyAuthenticateHeader);
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
        }
    }
}
