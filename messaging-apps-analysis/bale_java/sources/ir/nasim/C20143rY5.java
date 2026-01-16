package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.rY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20143rY5 extends AbstractC10365bX5 {
    private List b;
    private byte[] c;
    private EnumC6786Oz d;
    private List e;
    private List f;

    public static C20143rY5 s(byte[] bArr) {
        return (C20143rY5) AbstractC16720ll0.b(new C20143rY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C7030Pz());
        }
        this.b = c19084pl0.p(1, arrayList);
        this.c = c19084pl0.v(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.d = EnumC6786Oz.p(iH);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(4); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.e = c19084pl0.p(4, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < c19084pl0.m(5); i3++) {
            arrayList3.add(new C25238zy());
        }
        this.f = c19084pl0.p(5, arrayList3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        byte[] bArr = this.c;
        if (bArr != null) {
            c19675ql0.b(2, bArr);
        }
        EnumC6786Oz enumC6786Oz = this.d;
        if (enumC6786Oz != null) {
            c19675ql0.f(3, enumC6786Oz.j());
        }
        c19675ql0.m(4, this.e);
        c19675ql0.m(5, this.f);
    }

    public String toString() {
        return "response GetMoneyRequestPaymentList{}";
    }
}
