package ir.nasim;

/* loaded from: classes5.dex */
public final class ZS2 {
    private final int a;
    private final byte[] b;
    private final YS2 c;

    public ZS2(int i, byte[] bArr, YS2 ys2) {
        AbstractC13042fc3.i(bArr, "content");
        AbstractC13042fc3.i(ys2, "header");
        this.a = i;
        this.b = bArr;
        this.c = ys2;
    }

    public final int a() {
        return this.a;
    }

    public final byte[] b() {
        return this.b;
    }
}
