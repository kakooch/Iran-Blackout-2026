package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.dY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11754dY5 extends AbstractC10365bX5 {
    private List b;
    private List c;
    private List d;
    private List e;
    private List f;

    public static C11754dY5 s(byte[] bArr) {
        return (C11754dY5) AbstractC16720ll0.b(new C11754dY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C3924Cy());
        }
        this.b = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(7); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.c = c19084pl0.p(7, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(8); i3++) {
            arrayList3.add(new C25238zy());
        }
        this.d = c19084pl0.p(8, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < c19084pl0.m(4); i4++) {
            arrayList4.add(new C15811kD());
        }
        this.e = c19084pl0.p(4, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        for (int i5 = 0; i5 < c19084pl0.m(5); i5++) {
            arrayList5.add(new C23464wy());
        }
        this.f = c19084pl0.p(5, arrayList5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(7, this.c);
        c19675ql0.m(8, this.d);
        c19675ql0.m(4, this.e);
        c19675ql0.m(5, this.f);
    }

    public String toString() {
        return "response GetGroupDifference{}";
    }
}
