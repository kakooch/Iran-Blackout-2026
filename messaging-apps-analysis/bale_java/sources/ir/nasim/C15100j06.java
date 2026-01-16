package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.j06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15100j06 extends AbstractC10365bX5 {
    private byte[] b;
    private byte[] c;

    public static C15100j06 s(byte[] bArr) {
        return (C15100j06) AbstractC16720ll0.b(new C15100j06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.d(1);
        this.c = c19084pl0.d(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(1, bArr);
        byte[] bArr2 = this.c;
        if (bArr2 == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr2);
    }

    public String toString() {
        return "response Proto{}";
    }

    public byte[] u() {
        return this.b;
    }

    public byte[] w() {
        return this.c;
    }
}
