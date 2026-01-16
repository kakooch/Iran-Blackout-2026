package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LZ5 extends AbstractC10365bX5 {
    private C23464wy b;
    private int c;
    private List d;
    private List e;
    private long f;
    private int g;
    private int h;
    private byte[] i;
    private long j;

    public static LZ5 s(byte[] bArr) {
        return (LZ5) AbstractC16720ll0.b(new LZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C23464wy) c19084pl0.z(1, new C23464wy());
        this.c = c19084pl0.g(8);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(5); i++) {
            arrayList.add(new C15811kD());
        }
        this.d = c19084pl0.p(5, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(7); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.e = c19084pl0.p(7, arrayList2);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.g(2);
        this.h = c19084pl0.g(9);
        this.i = c19084pl0.d(3);
        this.j = c19084pl0.i(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C23464wy c23464wy = this.b;
        if (c23464wy != null) {
            c19675ql0.i(1, c23464wy);
        }
        c19675ql0.f(8, this.c);
        c19675ql0.m(5, this.d);
        c19675ql0.m(7, this.e);
        c19675ql0.g(6, this.f);
        c19675ql0.f(2, this.g);
        c19675ql0.f(9, this.h);
        byte[] bArr = this.i;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
        c19675ql0.g(4, this.j);
    }

    public String toString() {
        return "response JoinPublicGroup{}";
    }
}
