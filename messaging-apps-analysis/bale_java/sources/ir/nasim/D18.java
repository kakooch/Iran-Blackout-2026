package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class D18 extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    public static final InterfaceC17311ml0 e = new InterfaceC17311ml0() { // from class: ir.nasim.C18
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return D18.q();
        }
    };
    private String a;
    private List b;
    private String c;
    private Boolean d;

    private D18() {
    }

    public static /* synthetic */ D18 q() {
        return new D18();
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new SW());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.r(3);
        this.d = Boolean.valueOf(c19084pl0.c(4, false));
    }

    public Boolean r() {
        return this.d;
    }

    public SW s(EnumC17422mw1 enumC17422mw1) {
        for (SW sw : this.b) {
            if (sw.r() == enumC17422mw1) {
                return sw;
            }
        }
        return null;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.o(1, this.a);
        c19675ql0.m(2, this.b);
        c19675ql0.o(3, this.c);
        c19675ql0.a(4, this.d.booleanValue());
    }

    public List u() {
        return this.b;
    }

    public String w() {
        return this.a;
    }

    public String y() {
        return this.c;
    }

    public D18 z(String str, EnumC17422mw1 enumC17422mw1, long j) {
        ArrayList arrayList = new ArrayList(this.b);
        for (SW sw : this.b) {
            if (sw.r() == enumC17422mw1) {
                arrayList.remove(sw);
                arrayList.add(sw.s(j));
            }
        }
        return new D18(str, arrayList, this.c, this.d);
    }

    public D18(String str, List list, String str2, Boolean bool) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = bool;
    }
}
