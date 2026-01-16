package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.p06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18646p06 extends AbstractC10365bX5 {
    private List b;
    private List c;
    private List d;
    private List e;

    public static C18646p06 s(byte[] bArr) {
        return (C18646p06) AbstractC16720ll0.b(new C18646p06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C15811kD());
        }
        this.b = c19084pl0.p(1, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(2); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.c = c19084pl0.p(2, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(3); i3++) {
            arrayList3.add(new C23464wy());
        }
        this.d = c19084pl0.p(3, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < c19084pl0.m(4); i4++) {
            arrayList4.add(new C25238zy());
        }
        this.e = c19084pl0.p(4, arrayList4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(2, this.c);
        c19675ql0.m(3, this.d);
        c19675ql0.m(4, this.e);
    }

    public String toString() {
        return "response SearchContacts{}";
    }
}
