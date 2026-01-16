package ir.nasim;

import java.nio.charset.Charset;

/* renamed from: ir.nasim.eL0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12275eL0 {
    public static final C12275eL0 a = new C12275eL0();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;
    private static volatile Charset h;
    private static volatile Charset i;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        AbstractC13042fc3.h(charsetForName, "forName(...)");
        b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        AbstractC13042fc3.h(charsetForName2, "forName(...)");
        c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        AbstractC13042fc3.h(charsetForName3, "forName(...)");
        d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        AbstractC13042fc3.h(charsetForName4, "forName(...)");
        e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        AbstractC13042fc3.h(charsetForName5, "forName(...)");
        f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        AbstractC13042fc3.h(charsetForName6, "forName(...)");
        g = charsetForName6;
    }

    private C12275eL0() {
    }

    public final Charset a() {
        Charset charset = i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        AbstractC13042fc3.h(charsetForName, "forName(...)");
        i = charsetForName;
        return charsetForName;
    }

    public final Charset b() {
        Charset charset = h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        AbstractC13042fc3.h(charsetForName, "forName(...)");
        h = charsetForName;
        return charsetForName;
    }
}
