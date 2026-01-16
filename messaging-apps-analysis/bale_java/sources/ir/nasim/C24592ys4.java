package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ys4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24592ys4 implements InterfaceC17612nG0 {
    private final InterfaceC3932Cy7 a;
    private SA2 b;
    private final C24592ys4 c;
    private final InterfaceC22882vy7 d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.ys4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list) {
            super(0);
            this.e = list;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.ys4$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            SA2 sa2 = C24592ys4.this.b;
            if (sa2 == null) {
                return null;
            }
            return (List) sa2.invoke();
        }
    }

    /* renamed from: ir.nasim.ys4$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list) {
            super(0);
            this.e = list;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.ys4$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC5284Ir3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC5284Ir3 abstractC5284Ir3) {
            super(0);
            this.f = abstractC5284Ir3;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listB = C24592ys4.this.b();
            AbstractC5284Ir3 abstractC5284Ir3 = this.f;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listB, 10));
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC18174oC7) it.next()).U0(abstractC5284Ir3));
            }
            return arrayList;
        }
    }

    public C24592ys4(InterfaceC3932Cy7 interfaceC3932Cy7, SA2 sa2, C24592ys4 c24592ys4, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(interfaceC3932Cy7, "projection");
        this.a = interfaceC3932Cy7;
        this.b = sa2;
        this.c = c24592ys4;
        this.d = interfaceC22882vy7;
        this.e = AbstractC13269fw3.b(EnumC4870Gx3.b, new b());
    }

    private final List h() {
        return (List) this.e.getValue();
    }

    @Override // ir.nasim.InterfaceC17612nG0
    public InterfaceC3932Cy7 c() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: d */
    public MU0 t() {
        return null;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C24592ys4.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        }
        C24592ys4 c24592ys4 = (C24592ys4) obj;
        C24592ys4 c24592ys42 = this.c;
        if (c24592ys42 == null) {
            c24592ys42 = this;
        }
        C24592ys4 c24592ys43 = c24592ys4.c;
        if (c24592ys43 != null) {
            c24592ys4 = c24592ys43;
        }
        return c24592ys42 == c24592ys4;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public List b() {
        List listH = h();
        return listH == null ? AbstractC10360bX0.m() : listH;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public List getParameters() {
        return AbstractC10360bX0.m();
    }

    public int hashCode() {
        C24592ys4 c24592ys4 = this.c;
        return c24592ys4 == null ? super.hashCode() : c24592ys4.hashCode();
    }

    public final void i(List list) {
        AbstractC13042fc3.i(list, "supertypes");
        this.b = new c(list);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C24592ys4 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        InterfaceC3932Cy7 interfaceC3932Cy7A = c().a(abstractC5284Ir3);
        AbstractC13042fc3.h(interfaceC3932Cy7A, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.b == null ? null : new d(abstractC5284Ir3);
        C24592ys4 c24592ys4 = this.c;
        if (c24592ys4 == null) {
            c24592ys4 = this;
        }
        return new C24592ys4(interfaceC3932Cy7A, dVar, c24592ys4, this.d);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public AbstractC19738qr3 n() {
        AbstractC4099Dr3 type = c().getType();
        AbstractC13042fc3.h(type, "projection.type");
        return AbstractC7731Sy7.e(type);
    }

    public String toString() {
        return "CapturedType(" + c() + ')';
    }

    public /* synthetic */ C24592ys4(InterfaceC3932Cy7 interfaceC3932Cy7, SA2 sa2, C24592ys4 c24592ys4, InterfaceC22882vy7 interfaceC22882vy7, int i, ED1 ed1) {
        this(interfaceC3932Cy7, (i & 2) != 0 ? null : sa2, (i & 4) != 0 ? null : c24592ys4, (i & 8) != 0 ? null : interfaceC22882vy7);
    }

    public /* synthetic */ C24592ys4(InterfaceC3932Cy7 interfaceC3932Cy7, List list, C24592ys4 c24592ys4, int i, ED1 ed1) {
        this(interfaceC3932Cy7, list, (i & 4) != 0 ? null : c24592ys4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C24592ys4(InterfaceC3932Cy7 interfaceC3932Cy7, List list, C24592ys4 c24592ys4) {
        this(interfaceC3932Cy7, new a(list), c24592ys4, null, 8, null);
        AbstractC13042fc3.i(interfaceC3932Cy7, "projection");
        AbstractC13042fc3.i(list, "supertypes");
    }
}
