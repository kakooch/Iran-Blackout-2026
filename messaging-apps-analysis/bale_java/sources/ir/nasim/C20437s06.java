package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.s06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20437s06 extends AbstractC10365bX5 {
    private List b;
    private List c;
    private List d;
    private List e;
    private List f;

    public static C20437s06 s(byte[] bArr) {
        return (C20437s06) AbstractC16720ll0.b(new C20437s06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new AA());
        }
        this.b = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new C15811kD());
        }
        this.c = c19084pl0.p(2, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(3); i3++) {
            arrayList3.add(new C23464wy());
        }
        this.d = c19084pl0.p(3, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < c19084pl0.m(4); i4++) {
            arrayList4.add(new C18766pD());
        }
        this.e = c19084pl0.p(4, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        for (int i5 = 0; i5 < c19084pl0.m(5); i5++) {
            arrayList5.add(new C25238zy());
        }
        this.f = c19084pl0.p(5, arrayList5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(2, this.c);
        c19675ql0.m(3, this.d);
        c19675ql0.m(4, this.e);
        c19675ql0.m(5, this.f);
    }

    public String toString() {
        return "response SearchPeer{}";
    }
}
