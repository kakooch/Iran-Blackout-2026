package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.w06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22900w06 extends AbstractC10365bX5 {
    private int b;
    private byte[] c;

    public static C22900w06 s(byte[] bArr) {
        return (C22900w06) AbstractC16720ll0.b(new C22900w06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.d(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
    }

    public String toString() {
        return "response Seq{}";
    }
}
