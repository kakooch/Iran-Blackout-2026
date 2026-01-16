package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.tX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21363tX5 extends AbstractC10365bX5 {
    private int b;
    private byte[] c;
    private C23464wy d;
    private List e;
    private List f;
    private List g;
    private String h;

    public static C21363tX5 s(byte[] bArr) {
        return (C21363tX5) AbstractC16720ll0.b(new C21363tX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.d(2);
        this.d = (C23464wy) c19084pl0.z(3, new C23464wy());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(4); i++) {
            arrayList.add(new C15811kD());
        }
        this.e = c19084pl0.p(4, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(5); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.f = c19084pl0.p(5, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(6); i3++) {
            arrayList3.add(new C18766pD());
        }
        this.g = c19084pl0.p(6, arrayList3);
        this.h = c19084pl0.r(7);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        C23464wy c23464wy = this.d;
        if (c23464wy != null) {
            c19675ql0.i(3, c23464wy);
        }
        c19675ql0.m(4, this.e);
        c19675ql0.m(5, this.f);
        c19675ql0.m(6, this.g);
        String str = this.h;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str);
    }

    public String toString() {
        return "response CreateGroup{}";
    }
}
