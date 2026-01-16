package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class G48 extends AbstractC10745c76 {
    private long a;
    private int b;
    private byte[] c;

    public static G48 r(byte[] bArr) {
        return (G48) AbstractC16720ll0.b(new G48(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.d(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
    }

    public String toString() {
        return "update box WeakUpdate{}";
    }
}
