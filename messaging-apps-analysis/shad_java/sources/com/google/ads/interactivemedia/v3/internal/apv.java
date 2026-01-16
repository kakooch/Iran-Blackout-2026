package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apv {
    public static final Charset a = Charset.forName("US-ASCII");
    public static final Charset b;

    static {
        Charset.forName("ISO-8859-1");
        b = Charset.forName(Utf8Charset.NAME);
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-16");
    }
}
