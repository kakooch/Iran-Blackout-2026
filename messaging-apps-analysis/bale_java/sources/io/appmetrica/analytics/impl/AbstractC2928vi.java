package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: io.appmetrica.analytics.impl.vi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2928vi {
    public static byte[] a(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM);
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        return messageDigest.digest();
    }
}
