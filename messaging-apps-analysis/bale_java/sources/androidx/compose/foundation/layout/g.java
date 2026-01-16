package androidx.compose.foundation.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11637dL5;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.UA2;
import ir.nasim.ZV3;
import java.util.List;

/* loaded from: classes.dex */
final class g implements InterfaceC10970cW3 {
    private final InterfaceC12529em a;
    private final boolean b;

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ ZV3 f;
        final /* synthetic */ InterfaceC12377eW3 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ g j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21430te5 abstractC21430te5, ZV3 zv3, InterfaceC12377eW3 interfaceC12377eW3, int i, int i2, g gVar) {
            super(1);
            this.e = abstractC21430te5;
            this.f = zv3;
            this.g = interfaceC12377eW3;
            this.h = i;
            this.i = i2;
            this.j = gVar;
        }

        public final void a(AbstractC21430te5.a aVar) {
            f.h(aVar, this.e, this.f, this.g.getLayoutDirection(), this.h, this.i, this.j.a);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5[] e;
        final /* synthetic */ List f;
        final /* synthetic */ InterfaceC12377eW3 g;
        final /* synthetic */ C11637dL5 h;
        final /* synthetic */ C11637dL5 i;
        final /* synthetic */ g j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC21430te5[] abstractC21430te5Arr, List list, InterfaceC12377eW3 interfaceC12377eW3, C11637dL5 c11637dL5, C11637dL5 c11637dL52, g gVar) {
            super(1);
            this.e = abstractC21430te5Arr;
            this.f = list;
            this.g = interfaceC12377eW3;
            this.h = c11637dL5;
            this.i = c11637dL52;
            this.j = gVar;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5[] abstractC21430te5Arr = this.e;
            List list = this.f;
            InterfaceC12377eW3 interfaceC12377eW3 = this.g;
            C11637dL5 c11637dL5 = this.h;
            C11637dL5 c11637dL52 = this.i;
            g gVar = this.j;
            int length = abstractC21430te5Arr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                AbstractC21430te5 abstractC21430te5 = abstractC21430te5Arr[i];
                AbstractC13042fc3.g(abstractC21430te5, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                f.h(aVar, abstractC21430te5, (ZV3) list.get(i2), interfaceC12377eW3.getLayoutDirection(), c11637dL5.a, c11637dL52.a, gVar.a);
                i++;
                i2++;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public g(InterfaceC12529em interfaceC12529em, boolean z) {
        this.a = interfaceC12529em;
        this.b = z;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        int iN;
        int iM;
        AbstractC21430te5 abstractC21430te5L0;
        if (list.isEmpty()) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, a.e, 4, null);
        }
        long jB = this.b ? j : C17833ne1.b(j & (-8589934589L));
        if (list.size() == 1) {
            ZV3 zv3 = (ZV3) list.get(0);
            if (f.f(zv3)) {
                iN = C17833ne1.n(j);
                iM = C17833ne1.m(j);
                abstractC21430te5L0 = zv3.l0(C17833ne1.b.c(C17833ne1.n(j), C17833ne1.m(j)));
            } else {
                abstractC21430te5L0 = zv3.l0(jB);
                iN = Math.max(C17833ne1.n(j), abstractC21430te5L0.P0());
                iM = Math.max(C17833ne1.m(j), abstractC21430te5L0.A0());
            }
            int i = iN;
            int i2 = iM;
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, i, i2, null, new b(abstractC21430te5L0, zv3, interfaceC12377eW3, i, i2, this), 4, null);
        }
        AbstractC21430te5[] abstractC21430te5Arr = new AbstractC21430te5[list.size()];
        C11637dL5 c11637dL5 = new C11637dL5();
        c11637dL5.a = C17833ne1.n(j);
        C11637dL5 c11637dL52 = new C11637dL5();
        c11637dL52.a = C17833ne1.m(j);
        List list2 = list;
        int size = list2.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            ZV3 zv32 = (ZV3) list.get(i3);
            if (f.f(zv32)) {
                z = true;
            } else {
                AbstractC21430te5 abstractC21430te5L02 = zv32.l0(jB);
                abstractC21430te5Arr[i3] = abstractC21430te5L02;
                c11637dL5.a = Math.max(c11637dL5.a, abstractC21430te5L02.P0());
                c11637dL52.a = Math.max(c11637dL52.a, abstractC21430te5L02.A0());
            }
        }
        if (z) {
            int i4 = c11637dL5.a;
            int i5 = i4 != Integer.MAX_VALUE ? i4 : 0;
            int i6 = c11637dL52.a;
            long jA = AbstractC19606qe1.a(i5, i4, i6 != Integer.MAX_VALUE ? i6 : 0, i6);
            int size2 = list2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ZV3 zv33 = (ZV3) list.get(i7);
                if (f.f(zv33)) {
                    abstractC21430te5Arr[i7] = zv33.l0(jA);
                }
            }
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, c11637dL5.a, c11637dL52.a, null, new c(abstractC21430te5Arr, list, interfaceC12377eW3, c11637dL5, c11637dL52, this), 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return AbstractC13042fc3.d(this.a, gVar.a) && this.b == gVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.a + ", propagateMinConstraints=" + this.b + ')';
    }

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }

        public final void a(AbstractC21430te5.a aVar) {
        }
    }
}
