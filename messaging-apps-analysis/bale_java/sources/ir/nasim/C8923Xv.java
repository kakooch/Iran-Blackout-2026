package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Xv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8923Xv extends AbstractC25211zv {
    private String a;
    private C12056dy b;
    private String c;
    private long d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C12056dy) c19084pl0.z(2, new C12056dy());
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
    }

    @Override // ir.nasim.AbstractC25211zv
    public int s() {
        return 8;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C12056dy c12056dy = this.b;
        if (c12056dy != null) {
            c19675ql0.i(2, c12056dy);
        }
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        c19675ql0.g(4, this.d);
    }

    public String toString() {
        return "struct BaleUnderPeerAd{}";
    }
}
