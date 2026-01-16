package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class GU5 extends TP5 {
    private long a;
    private String b;

    public static GU5 r(byte[] bArr) {
        return (GU5) AbstractC16720ll0.b(new GU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 51;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "rpc RegisterGooglePush{}";
    }
}
