package ir.nasim;

import ir.nasim.C12053dx5;
import ir.nasim.M17;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.oJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18231oJ1 extends AbstractC10678c1 {
    private final WI1 k;
    private final C12053dx5 l;
    private final YI1 m;

    /* renamed from: ir.nasim.oJ1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC15401jX0.m1(C18231oJ1.this.k.c().d().h(C18231oJ1.this.N0(), C18231oJ1.this.k.g()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C18231oJ1(WI1 wi1, C12053dx5 c12053dx5, int i) {
        AbstractC13042fc3.i(wi1, "c");
        AbstractC13042fc3.i(c12053dx5, "proto");
        ON6 on6H = wi1.h();
        InterfaceC12795fB1 interfaceC12795fB1E = wi1.e();
        C6432No4 c6432No4B = AbstractC7170Qo4.b(wi1.g(), c12053dx5.R());
        C18617ox5 c18617ox5 = C18617ox5.a;
        C12053dx5.c cVarX = c12053dx5.X();
        AbstractC13042fc3.h(cVarX, "proto.variance");
        super(on6H, interfaceC12795fB1E, c6432No4B, c18617ox5.d(cVarX), c12053dx5.S(), i, JH6.a, M17.a.a);
        this.k = wi1;
        this.l = c12053dx5;
        this.m = new YI1(wi1.h(), new a());
    }

    @Override // ir.nasim.AbstractC13322g2
    protected List K0() {
        List listO = AbstractC3921Cx5.o(this.l, this.k.j());
        if (listO.isEmpty()) {
            return AbstractC9766aX0.e(PI1.g(this).y());
        }
        List list = listO;
        C16264ky7 c16264ky7I = this.k.i();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c16264ky7I.p((C10647bx5) it.next()));
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC11996du, ir.nasim.InterfaceC10612bu
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public YI1 getAnnotations() {
        return this.m;
    }

    public final C12053dx5 N0() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC13322g2
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public Void J0(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        throw new IllegalStateException(AbstractC13042fc3.q("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
