package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class C48 extends AbstractC10745c76 {
    private long a;
    private int b;
    private byte[] c;
    private List d;
    private List e;

    public static C48 r(byte[] bArr) {
        return (C48) AbstractC16720ll0.b(new C48(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.d(3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(4); i++) {
            arrayList.add(new C15811kD());
        }
        this.d = c19084pl0.p(4, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(5); i2++) {
            arrayList2.add(new C23464wy());
        }
        this.e = c19084pl0.p(5, arrayList2);
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
        c19675ql0.m(4, this.d);
        c19675ql0.m(5, this.e);
    }

    public String toString() {
        return "update box WeakFatUpdate{}";
    }
}
