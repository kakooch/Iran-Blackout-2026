package ir.nasim;

import ir.nasim.C4301En7;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.yl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24522yl4 {
    private final C25116zl4 a;
    private final int b;
    private final boolean c;
    private final float d;
    private final float e;
    private final int f;
    private final List g;
    private final List h;

    /* renamed from: ir.nasim.yl4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ float[] f;
        final /* synthetic */ C11637dL5 g;
        final /* synthetic */ C10873cL5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, float[] fArr, C11637dL5 c11637dL5, C10873cL5 c10873cL5) {
            super(1);
            this.e = j;
            this.f = fArr;
            this.g = c11637dL5;
            this.h = c10873cL5;
        }

        public final void a(C10971cW4 c10971cW4) {
            long j = this.e;
            float[] fArr = this.f;
            C11637dL5 c11637dL5 = this.g;
            C10873cL5 c10873cL5 = this.h;
            long jB = AbstractC4535Fn7.b(c10971cW4.r(c10971cW4.f() > C4301En7.l(j) ? c10971cW4.f() : C4301En7.l(j)), c10971cW4.r(c10971cW4.b() < C4301En7.k(j) ? c10971cW4.b() : C4301En7.k(j)));
            c10971cW4.e().y(jB, fArr, c11637dL5.a);
            int iJ = c11637dL5.a + (C4301En7.j(jB) * 4);
            for (int i = c11637dL5.a; i < iJ; i += 4) {
                int i2 = i + 1;
                float f = fArr[i2];
                float f2 = c10873cL5.a;
                fArr[i2] = f + f2;
                int i3 = i + 3;
                fArr[i3] = fArr[i3] + f2;
            }
            c11637dL5.a = iJ;
            c10873cL5.a += c10971cW4.e().getHeight();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C10971cW4) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yl4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ V05 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(V05 v05, int i, int i2) {
            super(1);
            this.e = v05;
            this.f = i;
            this.g = i2;
        }

        public final void a(C10971cW4 c10971cW4) {
            V05.g(this.e, c10971cW4.i(c10971cW4.e().u(c10971cW4.r(this.f), c10971cW4.r(this.g))), 0L, 2, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C10971cW4) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ C24522yl4(C25116zl4 c25116zl4, long j, int i, int i2, ED1 ed1) {
        this(c25116zl4, j, i, i2);
    }

    private final void K(int i) {
        boolean z = false;
        if (i >= 0 && i < b().k().length()) {
            z = true;
        }
        if (z) {
            return;
        }
        N73.a("offset(" + i + ") is out of bounds [0, " + b().length() + ')');
    }

    private final void L(int i) {
        boolean z = false;
        if (i >= 0 && i <= b().k().length()) {
            z = true;
        }
        if (z) {
            return;
        }
        N73.a("offset(" + i + ") is out of bounds [0, " + b().length() + ']');
    }

    private final void M(int i) {
        boolean z = false;
        if (i >= 0 && i < this.f) {
            z = true;
        }
        if (z) {
            return;
        }
        N73.a("lineIndex(" + i + ") is out of bounds [0, " + this.f + ')');
    }

    private final C13245fu b() {
        return this.a.d();
    }

    public static /* synthetic */ int o(C24522yl4 c24522yl4, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c24522yl4.n(i, z);
    }

    public final V05 A(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= b().k().length())) {
            N73.a("Start(" + i + ") or End(" + i2 + ") is out of range [0.." + b().k().length() + "), or start > end!");
        }
        if (i == i2) {
            return AbstractC21611tq.a();
        }
        V05 v05A = AbstractC21611tq.a();
        AbstractC3578Bl4.d(this.h, AbstractC4535Fn7.b(i, i2), new b(v05A, i, i2));
        return v05A;
    }

    public final List B() {
        return this.g;
    }

    public final long C(CK5 ck5, int i, InterfaceC5243Im7 interfaceC5243Im7) {
        C4301En7.a aVar;
        C4301En7.a aVar2;
        int iC = AbstractC3578Bl4.c(this.h, ck5.l());
        if (((C10971cW4) this.h.get(iC)).a() >= ck5.e() || iC == AbstractC10360bX0.o(this.h)) {
            C10971cW4 c10971cW4 = (C10971cW4) this.h.get(iC);
            return C10971cW4.l(c10971cW4, c10971cW4.e().s(c10971cW4.p(ck5), i, interfaceC5243Im7), false, 1, null);
        }
        int iC2 = AbstractC3578Bl4.c(this.h, ck5.e());
        long jA = C4301En7.b.a();
        while (true) {
            aVar = C4301En7.b;
            if (!C4301En7.g(jA, aVar.a()) || iC > iC2) {
                break;
            }
            C10971cW4 c10971cW42 = (C10971cW4) this.h.get(iC);
            jA = C10971cW4.l(c10971cW42, c10971cW42.e().s(c10971cW42.p(ck5), i, interfaceC5243Im7), false, 1, null);
            iC++;
        }
        if (C4301En7.g(jA, aVar.a())) {
            return aVar.a();
        }
        long jA2 = aVar.a();
        while (true) {
            aVar2 = C4301En7.b;
            if (!C4301En7.g(jA2, aVar2.a()) || iC > iC2) {
                break;
            }
            C10971cW4 c10971cW43 = (C10971cW4) this.h.get(iC2);
            jA2 = C10971cW4.l(c10971cW43, c10971cW43.e().s(c10971cW43.p(ck5), i, interfaceC5243Im7), false, 1, null);
            iC2--;
        }
        return C4301En7.g(jA2, aVar2.a()) ? jA : AbstractC4535Fn7.b(C4301En7.n(jA), C4301En7.i(jA2));
    }

    public final float D() {
        return this.d;
    }

    public final long E(int i) {
        L(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i == b().length() ? AbstractC10360bX0.o(this.h) : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.k(c10971cW4.e().j(c10971cW4.r(i)), false);
    }

    public final boolean F(int i) {
        M(i);
        return ((C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i))).e().m(i);
    }

    public final void G(UE0 ue0, long j, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        ue0.n();
        List list = this.h;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            C10971cW4 c10971cW4 = (C10971cW4) list.get(i2);
            c10971cW4.e().x(ue0, j, c5566Jw6, c24525yl7, abstractC18051o02, i);
            ue0.c(0.0f, c10971cW4.e().getHeight());
        }
        ue0.i();
    }

    public final void I(UE0 ue0, AbstractC12520el0 abstractC12520el0, float f, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        AbstractC11956dq.a(this, ue0, abstractC12520el0, f, c5566Jw6, c24525yl7, abstractC18051o02, i);
    }

    public final float[] a(long j, float[] fArr, int i) {
        K(C4301En7.l(j));
        L(C4301En7.k(j));
        C11637dL5 c11637dL5 = new C11637dL5();
        c11637dL5.a = i;
        AbstractC3578Bl4.d(this.h, j, new a(j, fArr, c11637dL5, new C10873cL5()));
        return fArr;
    }

    public final AW5 c(int i) {
        L(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i == b().length() ? AbstractC10360bX0.o(this.h) : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.e().B(c10971cW4.r(i));
    }

    public final CK5 d(int i) {
        K(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.j(c10971cW4.e().C(c10971cW4.r(i)));
    }

    public final CK5 e(int i) {
        L(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i == b().length() ? AbstractC10360bX0.o(this.h) : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.j(c10971cW4.e().h(c10971cW4.r(i)));
    }

    public final boolean f() {
        return this.c;
    }

    public final float g() {
        if (this.h.isEmpty()) {
            return 0.0f;
        }
        return ((C10971cW4) this.h.get(0)).e().k();
    }

    public final float h() {
        return this.e;
    }

    public final float i(int i, boolean z) {
        L(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i == b().length() ? AbstractC10360bX0.o(this.h) : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.e().v(c10971cW4.r(i), z);
    }

    public final C25116zl4 j() {
        return this.a;
    }

    public final float k() {
        if (this.h.isEmpty()) {
            return 0.0f;
        }
        C10971cW4 c10971cW4 = (C10971cW4) AbstractC15401jX0.C0(this.h);
        return c10971cW4.o(c10971cW4.e().z());
    }

    public final float l(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.o(c10971cW4.e().d(c10971cW4.s(i)));
    }

    public final int m() {
        return this.f;
    }

    public final int n(int i, boolean z) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.m(c10971cW4.e().n(c10971cW4.s(i), z));
    }

    public final int p(int i) {
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i >= b().length() ? AbstractC10360bX0.o(this.h) : i < 0 ? 0 : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.n(c10971cW4.e().A(c10971cW4.r(i)));
    }

    public final int q(float f) {
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.c(this.h, f));
        return c10971cW4.d() == 0 ? c10971cW4.g() : c10971cW4.n(c10971cW4.e().t(c10971cW4.t(f)));
    }

    public final float r(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.e().p(c10971cW4.s(i));
    }

    public final float s(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.e().w(c10971cW4.s(i));
    }

    public final float t(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.e().o(c10971cW4.s(i));
    }

    public final int u(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.m(c10971cW4.e().b(c10971cW4.s(i)));
    }

    public final float v(int i) {
        M(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.b(this.h, i));
        return c10971cW4.o(c10971cW4.e().a(c10971cW4.s(i)));
    }

    public final int w() {
        return this.b;
    }

    public final int x(long j) {
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(AbstractC3578Bl4.c(this.h, Float.intBitsToFloat((int) (4294967295L & j))));
        return c10971cW4.d() == 0 ? c10971cW4.f() : c10971cW4.m(c10971cW4.e().l(c10971cW4.q(j)));
    }

    public final AW5 y(int i) {
        L(i);
        C10971cW4 c10971cW4 = (C10971cW4) this.h.get(i == b().length() ? AbstractC10360bX0.o(this.h) : AbstractC3578Bl4.a(this.h, i));
        return c10971cW4.e().g(c10971cW4.r(i));
    }

    public final List z() {
        return this.h;
    }

    private C24522yl4(C25116zl4 c25116zl4, long j, int i, int i2) {
        boolean z;
        this.a = c25116zl4;
        this.b = i;
        int i3 = 0;
        if (!(C17833ne1.n(j) == 0 && C17833ne1.m(j) == 0)) {
            N73.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List listF = c25116zl4.f();
        int size = listF.size();
        int i4 = 0;
        float f = 0.0f;
        int i5 = 0;
        while (i5 < size) {
            C11735dW4 c11735dW4 = (C11735dW4) listF.get(i5);
            InterfaceC10355bW4 interfaceC10355bW4C = AbstractC13605gW4.c(c11735dW4.b(), AbstractC19606qe1.b(0, C17833ne1.l(j), 0, C17833ne1.g(j) ? AbstractC23053wG5.e(C17833ne1.k(j) - AbstractC13605gW4.d(f), i3) : C17833ne1.k(j), 5, null), this.b - i4, i2);
            float height = f + interfaceC10355bW4C.getHeight();
            int lineCount = i4 + interfaceC10355bW4C.getLineCount();
            arrayList.add(new C10971cW4(interfaceC10355bW4C, c11735dW4.c(), c11735dW4.a(), i4, lineCount, f, height));
            if (interfaceC10355bW4C.q() || (lineCount == this.b && i5 != AbstractC10360bX0.o(this.a.f()))) {
                i4 = lineCount;
                f = height;
                z = true;
                break;
            } else {
                i5++;
                i4 = lineCount;
                f = height;
                i3 = 0;
            }
        }
        z = false;
        this.e = f;
        this.f = i4;
        this.c = z;
        this.h = arrayList;
        this.d = C17833ne1.l(j);
        List arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i6 = 0; i6 < size2; i6++) {
            C10971cW4 c10971cW4 = (C10971cW4) arrayList.get(i6);
            List listD = c10971cW4.e().D();
            ArrayList arrayList3 = new ArrayList(listD.size());
            int size3 = listD.size();
            for (int i7 = 0; i7 < size3; i7++) {
                CK5 ck5 = (CK5) listD.get(i7);
                arrayList3.add(ck5 != null ? c10971cW4.j(ck5) : null);
            }
            AbstractC13610gX0.D(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.a.g().size()) {
            int size4 = this.a.g().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i8 = 0; i8 < size4; i8++) {
                arrayList4.add(null);
            }
            arrayList2 = AbstractC15401jX0.R0(arrayList2, arrayList4);
        }
        this.g = arrayList2;
    }
}
