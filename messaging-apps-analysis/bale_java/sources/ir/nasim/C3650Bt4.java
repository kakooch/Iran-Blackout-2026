package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Bt4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3650Bt4 extends AbstractC10745c76 {
    private int a;
    private byte[] b;
    private int c;
    private byte[] d;
    private List e;
    private List f;
    private Integer g;

    public static C3650Bt4 r(byte[] bArr) {
        return (C3650Bt4) AbstractC16720ll0.b(new C3650Bt4(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.d(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.d(4);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new C15811kD());
        }
        this.e = c19084pl0.p(5, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(6); i2++) {
            arrayList2.add(new C23464wy());
        }
        this.f = c19084pl0.p(6, arrayList2);
        this.g = Integer.valueOf(c19084pl0.x(7));
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
        c19675ql0.m(5, this.e);
        c19675ql0.m(6, this.f);
        Integer num = this.g;
        if (num != null) {
            c19675ql0.f(7, num.intValue());
        }
    }

    public String toString() {
        return "update box NewFatSeqUpdate{}";
    }
}
