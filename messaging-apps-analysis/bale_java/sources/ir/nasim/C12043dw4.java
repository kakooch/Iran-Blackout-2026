package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.dw4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12043dw4 extends AbstractC10745c76 {
    private int a;
    private byte[] b;
    private int c;
    private byte[] d;
    private Integer e;

    public static C12043dw4 r(byte[] bArr) {
        return (C12043dw4) AbstractC16720ll0.b(new C12043dw4(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.d(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.d(4);
        this.e = Integer.valueOf(c19084pl0.x(5));
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
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
    }

    public String toString() {
        return "update box NewSeqUpdate{}";
    }
}
