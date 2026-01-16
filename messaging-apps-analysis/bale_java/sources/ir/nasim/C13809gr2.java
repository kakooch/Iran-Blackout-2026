package ir.nasim;

import ir.nasim.AbstractC13218fr2;
import ir.nasim.C11348cr2;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.gr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13809gr2 {
    private final AbstractC13218fr2.a a;
    private final int b;
    private final int c;
    private final String d = "Accessing shownItemCount before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.";
    private int e = -1;
    private int f;
    private ZV3 g;
    private AbstractC21430te5 h;
    private ZV3 i;
    private AbstractC21430te5 j;
    private C17795na3 k;
    private C17795na3 l;
    private InterfaceC14603iB2 m;

    /* renamed from: ir.nasim.gr2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC13218fr2.a.values().length];
            try {
                iArr[AbstractC13218fr2.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC13218fr2.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC13218fr2.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC13218fr2.a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.gr2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC15010ir2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15010ir2 interfaceC15010ir2) {
            super(1);
            this.f = interfaceC15010ir2;
        }

        public final void a(AbstractC21430te5 abstractC21430te5) {
            int iG;
            int iC;
            if (abstractC21430te5 != null) {
                InterfaceC15010ir2 interfaceC15010ir2 = this.f;
                iG = interfaceC15010ir2.g(abstractC21430te5);
                iC = interfaceC15010ir2.c(abstractC21430te5);
            } else {
                iG = 0;
                iC = 0;
            }
            C13809gr2.this.k = C17795na3.a(C17795na3.b(iG, iC));
            C13809gr2.this.h = abstractC21430te5;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gr2$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC15010ir2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC15010ir2 interfaceC15010ir2) {
            super(1);
            this.f = interfaceC15010ir2;
        }

        public final void a(AbstractC21430te5 abstractC21430te5) {
            int iG;
            int iC;
            if (abstractC21430te5 != null) {
                InterfaceC15010ir2 interfaceC15010ir2 = this.f;
                iG = interfaceC15010ir2.g(abstractC21430te5);
                iC = interfaceC15010ir2.c(abstractC21430te5);
            } else {
                iG = 0;
                iC = 0;
            }
            C13809gr2.this.l = C17795na3.a(C17795na3.b(iG, iC));
            C13809gr2.this.j = abstractC21430te5;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5) obj);
            return C19938rB7.a;
        }
    }

    public C13809gr2(AbstractC13218fr2.a aVar, int i, int i2) {
        this.a = aVar;
        this.b = i;
        this.c = i2;
    }

    public final C11348cr2.a e(boolean z, int i, int i2) {
        ZV3 zv3;
        C17795na3 c17795na3;
        AbstractC21430te5 abstractC21430te5;
        ZV3 zv32;
        AbstractC21430te5 abstractC21430te52;
        int i3 = a.a[this.a.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return null;
        }
        if (i3 != 3 && i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            InterfaceC14603iB2 interfaceC14603iB2 = this.m;
            if (interfaceC14603iB2 == null || (zv3 = (ZV3) interfaceC14603iB2.invoke(Boolean.TRUE, Integer.valueOf(h()))) == null) {
                zv3 = this.g;
            }
            c17795na3 = this.k;
            if (this.m == null) {
                abstractC21430te5 = this.h;
                zv32 = zv3;
                abstractC21430te52 = abstractC21430te5;
            }
            zv32 = zv3;
            abstractC21430te52 = null;
        } else {
            if (i < this.b - 1 || i2 < this.c) {
                zv3 = null;
            } else {
                InterfaceC14603iB2 interfaceC14603iB22 = this.m;
                if (interfaceC14603iB22 == null || (zv3 = (ZV3) interfaceC14603iB22.invoke(Boolean.FALSE, Integer.valueOf(h()))) == null) {
                    zv3 = this.i;
                }
            }
            c17795na3 = this.l;
            if (this.m == null) {
                abstractC21430te5 = this.j;
                zv32 = zv3;
                abstractC21430te52 = abstractC21430te5;
            }
            zv32 = zv3;
            abstractC21430te52 = null;
        }
        if (zv32 == null) {
            return null;
        }
        AbstractC13042fc3.f(c17795na3);
        return new C11348cr2.a(zv32, abstractC21430te52, c17795na3.i(), false, 8, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13809gr2)) {
            return false;
        }
        C13809gr2 c13809gr2 = (C13809gr2) obj;
        return this.a == c13809gr2.a && this.b == c13809gr2.b && this.c == c13809gr2.c;
    }

    public final C17795na3 f(boolean z, int i, int i2) {
        int i3 = a.a[this.a.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return null;
        }
        if (i3 == 3) {
            if (z) {
                return this.k;
            }
            return null;
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return this.k;
        }
        if (i + 1 < this.b || i2 < this.c) {
            return null;
        }
        return this.l;
    }

    public final int g() {
        return this.b;
    }

    public final int h() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException(this.d);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public final AbstractC13218fr2.a i() {
        return this.a;
    }

    public final void j(int i) {
        this.f = i;
    }

    public final void k(int i) {
        this.e = i;
    }

    public final void l(InterfaceC15010ir2 interfaceC15010ir2, ZV3 zv3, ZV3 zv32, long j) {
        EnumC5311Iu3 enumC5311Iu3 = interfaceC15010ir2.m() ? EnumC5311Iu3.a : EnumC5311Iu3.b;
        long jF = AbstractC24880zM4.f(AbstractC24880zM4.e(AbstractC24880zM4.c(j, enumC5311Iu3), 0, 0, 0, 0, 10, null), enumC5311Iu3);
        if (zv3 != null) {
            AbstractC12582er2.h(zv3, interfaceC15010ir2, jF, new b(interfaceC15010ir2));
            this.g = zv3;
        }
        if (zv32 != null) {
            AbstractC12582er2.h(zv32, interfaceC15010ir2, jF, new c(interfaceC15010ir2));
            this.i = zv32;
        }
    }

    public final void m(InterfaceC9236Zb3 interfaceC9236Zb3, InterfaceC9236Zb3 interfaceC9236Zb32, boolean z, long j) {
        long jC = AbstractC24880zM4.c(j, z ? EnumC5311Iu3.a : EnumC5311Iu3.b);
        if (interfaceC9236Zb3 != null) {
            int iG = AbstractC12582er2.g(interfaceC9236Zb3, z, C17833ne1.k(jC));
            this.k = C17795na3.a(C17795na3.b(iG, AbstractC12582er2.e(interfaceC9236Zb3, z, iG)));
            this.g = interfaceC9236Zb3 instanceof ZV3 ? (ZV3) interfaceC9236Zb3 : null;
            this.h = null;
        }
        if (interfaceC9236Zb32 != null) {
            int iG2 = AbstractC12582er2.g(interfaceC9236Zb32, z, C17833ne1.k(jC));
            this.l = C17795na3.a(C17795na3.b(iG2, AbstractC12582er2.e(interfaceC9236Zb32, z, iG2)));
            this.i = interfaceC9236Zb32 instanceof ZV3 ? (ZV3) interfaceC9236Zb32 : null;
            this.j = null;
        }
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.a + ", minLinesToShowCollapse=" + this.b + ", minCrossAxisSizeToShowCollapse=" + this.c + ')';
    }
}
