package com.coremedia.iso;

import com.facebook.stetho.common.Utf8Charset;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class Utf8 {
    public static byte[] convert(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    public static String convert(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    public static int utf8StringLengthInBytes(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes(Utf8Charset.NAME).length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}
