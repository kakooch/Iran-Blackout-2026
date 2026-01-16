package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TZ5 extends AbstractC10365bX5 {
    private List b;
    private List c;
    private List d;
    private Boolean e;
    private Boolean f;
    private List g;
    private List h;

    public static TZ5 s(byte[] bArr) {
        return (TZ5) AbstractC16720ll0.b(new TZ5(), bArr);
    }

    public List C() {
        return this.c;
    }

    public Boolean D() {
        return this.e;
    }

    public Boolean E() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C25229zx());
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
        this.e = Boolean.valueOf(c19084pl0.u(4));
        this.f = Boolean.valueOf(c19084pl0.u(5));
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < c19084pl0.m(6); i4++) {
            arrayList4.add(new C18766pD());
        }
        this.g = c19084pl0.p(6, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        for (int i5 = 0; i5 < c19084pl0.m(7); i5++) {
            arrayList5.add(new C25238zy());
        }
        this.h = c19084pl0.p(7, arrayList5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        c19675ql0.m(2, this.c);
        c19675ql0.m(3, this.d);
        Boolean bool = this.e;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
        Boolean bool2 = this.f;
        if (bool2 != null) {
            c19675ql0.a(5, bool2.booleanValue());
        }
        c19675ql0.m(6, this.g);
        c19675ql0.m(7, this.h);
    }

    public String toString() {
        return "response LoadGroupedDialogs{}";
    }

    public List u() {
        return this.b;
    }

    public List w() {
        return this.h;
    }

    public List y() {
        return this.d;
    }

    public List z() {
        return this.g;
    }
}
