package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.jp6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15584jp6 extends AbstractC10745c76 {
    private int a;
    private byte[] b;
    private int c;
    private byte[] d;

    public static C15584jp6 r(byte[] bArr) {
        return (C15584jp6) AbstractC16720ll0.b(new C15584jp6(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.d(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.d(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        c19675ql0.f(3, this.c);
        byte[] bArr2 = this.d;
        if (bArr2 == null) {
            throw new IOException();
        }
        c19675ql0.b(4, bArr2);
    }

    public String toString() {
        return "update box SeqUpdate{}";
    }
}
