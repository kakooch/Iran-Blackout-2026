package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C20795sd0;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.ae1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9834ae1 {
    private static final boolean a = false;

    /* renamed from: ir.nasim.ae1$a */
    public static final class a {
        a() {
        }
    }

    /* renamed from: ir.nasim.ae1$b */
    static final class b implements InterfaceC10970cW3 {
        final /* synthetic */ C15395jW3 a;
        final /* synthetic */ C14269he1 b;
        final /* synthetic */ int c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.ae1$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C15395jW3 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15395jW3 c15395jW3, List list) {
                super(1);
                this.e = c15395jW3;
                this.f = list;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC13042fc3.i(aVar, "$this$layout");
                this.e.k(aVar, this.f);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        b(C15395jW3 c15395jW3, C14269he1 c14269he1, int i, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = c15395jW3;
            this.b = c14269he1;
            this.c = i;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.a.c(this, interfaceC10436bc3, list, i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            AbstractC13042fc3.i(interfaceC12377eW3, "$this$MeasurePolicy");
            AbstractC13042fc3.i(list, "measurables");
            long jL = this.a.l(j, interfaceC12377eW3.getLayoutDirection(), this.b, list, this.c, interfaceC12377eW3);
            this.d.getValue();
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C4414Fa3.g(jL), C4414Fa3.f(jL), null, new a(this.a, list), 4, null);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.a.b(this, interfaceC10436bc3, list, i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.a.d(this, interfaceC10436bc3, list, i);
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return InterfaceC10970cW3.a.a(this, interfaceC10436bc3, list, i);
        }
    }

    /* renamed from: ir.nasim.ae1$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ C14269he1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9102Ym4 interfaceC9102Ym4, C14269he1 c14269he1) {
            super(0);
            this.e = interfaceC9102Ym4;
            this.f = c14269he1;
        }

        public final void a() {
            this.e.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
            this.f.i(true);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final void d(TK6 tk6, List list) {
        AbstractC13042fc3.i(tk6, "state");
        AbstractC13042fc3.i(list, "measurables");
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            ZV3 zv3 = (ZV3) list.get(i);
            Object objA = androidx.compose.ui.layout.a.a(zv3);
            if (objA == null && (objA = AbstractC11839de1.a(zv3)) == null) {
                objA = e();
            }
            tk6.i(objA, zv3);
            Object objB = AbstractC11839de1.b(zv3);
            if (objB != null && (objB instanceof String) && (objA instanceof String)) {
                tk6.m((String) objA, (String) objB);
            }
            if (i2 > size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    public static final Object e() {
        return new a();
    }

    public static final XV4 f(int i, C11044ce1 c11044ce1, InterfaceC9102Ym4 interfaceC9102Ym4, C15395jW3 c15395jW3, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c11044ce1, "scope");
        AbstractC13042fc3.i(interfaceC9102Ym4, "remeasureRequesterState");
        AbstractC13042fc3.i(c15395jW3, "measurer");
        interfaceC22053ub1.A(-441911751);
        interfaceC22053ub1.A(-3687241);
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new C14269he1(c11044ce1);
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        C14269he1 c14269he1 = (C14269he1) objB;
        Integer numValueOf = Integer.valueOf(i);
        interfaceC22053ub1.A(-3686930);
        boolean zV = interfaceC22053ub1.V(numValueOf);
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == aVar.a()) {
            objB2 = AbstractC4616Fw7.a(new b(c15395jW3, c14269he1, i, interfaceC9102Ym4), new c(interfaceC9102Ym4, c14269he1));
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.U();
        XV4 xv4 = (XV4) objB2;
        interfaceC22053ub1.U();
        return xv4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(C20795sd0.a aVar) {
        return "measure strategy is ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(C16651le1 c16651le1) {
        return ((Object) c16651le1.v()) + " width " + c16651le1.X() + " minWidth " + c16651le1.L() + " maxWidth " + c16651le1.J() + " height " + c16651le1.z() + " minHeight " + c16651le1.K() + " maxHeight " + c16651le1.I() + " HDB " + c16651le1.C() + " VDB " + c16651le1.U() + " MCW " + c16651le1.w + " MCH " + c16651le1.x + " percentW " + c16651le1.B + " percentH " + c16651le1.E;
    }
}
