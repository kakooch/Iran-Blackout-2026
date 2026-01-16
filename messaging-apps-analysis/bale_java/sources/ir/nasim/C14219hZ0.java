package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.hZ0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14219hZ0 extends AbstractC10745c76 {
    private int a;
    private int b;
    private byte[] c;
    private List d;
    private List e;
    private List f;
    private List g;

    public static C14219hZ0 r(byte[] bArr) {
        return (C14219hZ0) AbstractC16720ll0.b(new C14219hZ0(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
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
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(6); i3++) {
            arrayList3.add(new C15065ix());
        }
        this.f = c19084pl0.p(6, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < c19084pl0.m(7); i4++) {
            arrayList4.add(new C25247zz());
        }
        this.g = c19084pl0.p(7, arrayList4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
        c19675ql0.m(4, this.d);
        c19675ql0.m(5, this.e);
        c19675ql0.m(6, this.f);
        c19675ql0.m(7, this.g);
    }

    public String toString() {
        return "update box CombinedUpdate{}";
    }
}
