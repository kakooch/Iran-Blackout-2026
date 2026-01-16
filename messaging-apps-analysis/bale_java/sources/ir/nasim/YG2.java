package ir.nasim;

import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes2.dex */
public abstract class YG2 {
    private static final ByteString a;
    private static final ByteString b;
    private static final ByteString c;
    private static final ByteString d;
    private static final ByteString e;
    private static final ByteString f;
    private static final ByteString g;
    private static final ByteString h;
    private static final ByteString i;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.encodeUtf8("GIF87a");
        b = companion.encodeUtf8("GIF89a");
        c = companion.encodeUtf8("RIFF");
        d = companion.encodeUtf8("WEBP");
        e = companion.encodeUtf8("VP8X");
        f = companion.encodeUtf8("ftyp");
        g = companion.encodeUtf8("msf1");
        h = companion.encodeUtf8("hevc");
        i = companion.encodeUtf8("hevx");
    }

    public static final boolean a(C21144tB1 c21144tB1, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, b) || bufferedSource.rangeEquals(0L, a);
    }
}
