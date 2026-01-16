package ir.nasim;

import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public enum FZ2 {
    ISO_8859_1(Charset.forName("ISO-8859-1"), 1),
    UTF_16(Charset.forName("UTF-16"), 2),
    UTF_16BE(Charset.forName("UTF-16BE"), 2),
    UTF_8(Charset.forName("UTF-8"), 1);

    private final Charset a;
    private final int b;

    FZ2(Charset charset, int i) {
        this.a = charset;
        this.b = i;
    }

    public Charset j() {
        return this.a;
    }

    public int p() {
        return this.b;
    }
}
