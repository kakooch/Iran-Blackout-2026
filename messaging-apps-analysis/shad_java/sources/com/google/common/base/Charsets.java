package com.google.common.base;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class Charsets {
    public static final Charset UTF_16;
    public static final Charset UTF_16LE;
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName(Utf8Charset.NAME);

    static {
        Charset.forName("UTF-16BE");
        UTF_16LE = Charset.forName("UTF-16LE");
        UTF_16 = Charset.forName("UTF-16");
    }
}
