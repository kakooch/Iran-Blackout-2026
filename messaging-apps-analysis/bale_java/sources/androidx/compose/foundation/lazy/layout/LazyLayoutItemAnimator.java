package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC18606ow3;
import ir.nasim.AbstractC22068uc6;
import ir.nasim.AbstractC22490vK2;
import ir.nasim.AbstractC23254wc6;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14453hw3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C21226tK2;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.C7386Rm4;
import ir.nasim.C7620Sm4;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC20014rK2;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22264uw3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC24630yw3;
import ir.nasim.SA2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
public final class LazyLayoutItemAnimator {
    private InterfaceC22264uw3 b;
    private int c;
    private InterfaceC15687k02 j;
    private final C7386Rm4 a = AbstractC22068uc6.b();
    private final C7620Sm4 d = AbstractC23254wc6.a();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    private final List i = new ArrayList();
    private final androidx.compose.ui.e k = new DisplayingDisappearingItemsElement(this);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "l", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "foundation_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class DisplayingDisappearingItemsElement extends AbstractC25066zg4 {

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final LazyLayoutItemAnimator animator;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && AbstractC13042fc3.d(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public a getNode() {
            return new a(this.animator);
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(a node) {
            node.v2(this.animator);
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }
    }

    private static final class a extends e.c implements InterfaceC15687k02 {
        private LazyLayoutItemAnimator o;

        public a(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.o = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.e.c
        public void e2() {
            this.o.j = this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.o, ((a) obj).o);
        }

        @Override // androidx.compose.ui.e.c
        public void f2() {
            this.o.p();
        }

        public int hashCode() {
            return this.o.hashCode();
        }

        @Override // ir.nasim.InterfaceC15687k02
        public void o(InterfaceC23919xk1 interfaceC23919xk1) {
            List list = this.o.i;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                androidx.compose.foundation.lazy.layout.c cVar = (androidx.compose.foundation.lazy.layout.c) list.get(i);
                C21226tK2 c21226tK2P = cVar.p();
                if (c21226tK2P != null) {
                    float fK = C22045ua3.k(cVar.o());
                    float fK2 = fK - C22045ua3.k(c21226tK2P.x());
                    float fL = C22045ua3.l(cVar.o()) - C22045ua3.l(c21226tK2P.x());
                    interfaceC23919xk1.z1().b().c(fK2, fL);
                    try {
                        AbstractC22490vK2.a(interfaceC23919xk1, c21226tK2P);
                    } finally {
                        interfaceC23919xk1.z1().b().c(-fK2, -fL);
                    }
                }
            }
            interfaceC23919xk1.N1();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.o + ')';
        }

        public final void v2(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            if (AbstractC13042fc3.d(this.o, lazyLayoutItemAnimator) || !h().b2()) {
                return;
            }
            this.o.p();
            lazyLayoutItemAnimator.j = this;
            this.o = lazyLayoutItemAnimator;
        }
    }

    private final class b {
        private C17833ne1 b;
        private int c;
        private int d;
        private int f;
        private int g;
        private androidx.compose.foundation.lazy.layout.c[] a = AbstractC18606ow3.a;
        private int e = 1;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ LazyLayoutItemAnimator e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
                super(0);
                this.e = lazyLayoutItemAnimator;
            }

            public final void a() {
                InterfaceC15687k02 interfaceC15687k02 = this.e.j;
                if (interfaceC15687k02 != null) {
                    AbstractC16278l02.a(interfaceC15687k02);
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        public b() {
        }

        private final boolean h() {
            for (androidx.compose.foundation.lazy.layout.c cVar : this.a) {
                if (cVar != null && cVar.x()) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ void l(b bVar, InterfaceC24630yw3 interfaceC24630yw3, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20014rK2 interfaceC20014rK2, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 32) != 0) {
                i3 = LazyLayoutItemAnimator.this.f(interfaceC24630yw3);
            }
            bVar.k(interfaceC24630yw3, interfaceC20315ro1, interfaceC20014rK2, i, i2, i3);
        }

        public final androidx.compose.foundation.lazy.layout.c[] a() {
            return this.a;
        }

        public final C17833ne1 b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.g;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.e;
        }

        public final void i(int i) {
            this.d = i;
        }

        public final void j(int i) {
            this.e = i;
        }

        public final void k(InterfaceC24630yw3 interfaceC24630yw3, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20014rK2 interfaceC20014rK2, int i, int i2, int i3) {
            if (!h()) {
                this.f = i;
                this.g = i2;
            }
            int length = this.a.length;
            for (int iE = interfaceC24630yw3.e(); iE < length; iE++) {
                androidx.compose.foundation.lazy.layout.c cVar = this.a[iE];
                if (cVar != null) {
                    cVar.y();
                }
            }
            if (this.a.length != interfaceC24630yw3.e()) {
                Object[] objArrCopyOf = Arrays.copyOf(this.a, interfaceC24630yw3.e());
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
                this.a = (androidx.compose.foundation.lazy.layout.c[]) objArrCopyOf;
            }
            this.b = C17833ne1.a(interfaceC24630yw3.d());
            this.c = i3;
            this.d = interfaceC24630yw3.n();
            this.e = interfaceC24630yw3.c();
            int iE2 = interfaceC24630yw3.e();
            LazyLayoutItemAnimator lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i4 = 0; i4 < iE2; i4++) {
                C14453hw3 c14453hw3C = AbstractC18606ow3.c(interfaceC24630yw3.l(i4));
                if (c14453hw3C == null) {
                    androidx.compose.foundation.lazy.layout.c cVar2 = this.a[i4];
                    if (cVar2 != null) {
                        cVar2.y();
                    }
                    this.a[i4] = null;
                } else {
                    androidx.compose.foundation.lazy.layout.c cVar3 = this.a[i4];
                    if (cVar3 == null) {
                        cVar3 = new androidx.compose.foundation.lazy.layout.c(interfaceC20315ro1, interfaceC20014rK2, new a(lazyLayoutItemAnimator));
                        this.a[i4] = cVar3;
                    }
                    cVar3.C(c14453hw3C.v2());
                    cVar3.I(c14453hw3C.x2());
                    cVar3.D(c14453hw3C.w2());
                }
            }
        }
    }

    public static final class c implements Comparator {
        final /* synthetic */ InterfaceC22264uw3 a;

        public c(InterfaceC22264uw3 interfaceC22264uw3) {
            this.a = interfaceC22264uw3;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj).getKey())), Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj2).getKey())));
        }
    }

    public static final class d implements Comparator {
        final /* synthetic */ InterfaceC22264uw3 a;

        public d(InterfaceC22264uw3 interfaceC22264uw3) {
            this.a = interfaceC22264uw3;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj).getKey())), Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj2).getKey())));
        }
    }

    public static final class e implements Comparator {
        final /* synthetic */ InterfaceC22264uw3 a;

        public e(InterfaceC22264uw3 interfaceC22264uw3) {
            this.a = interfaceC22264uw3;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj2).getKey())), Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj).getKey())));
        }
    }

    public static final class f implements Comparator {
        final /* synthetic */ InterfaceC22264uw3 a;

        public f(InterfaceC22264uw3 interfaceC22264uw3) {
            this.a = interfaceC22264uw3;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj2).getKey())), Integer.valueOf(this.a.c(((InterfaceC24630yw3) obj).getKey())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(InterfaceC24630yw3 interfaceC24630yw3) {
        long jM = interfaceC24630yw3.m(0);
        return !interfaceC24630yw3.i() ? C22045ua3.l(jM) : C22045ua3.k(jM);
    }

    private final boolean g(InterfaceC24630yw3 interfaceC24630yw3) {
        int iE = interfaceC24630yw3.e();
        for (int i = 0; i < iE; i++) {
            if (AbstractC18606ow3.c(interfaceC24630yw3.l(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int h(InterfaceC24630yw3 interfaceC24630yw3) {
        long jM = interfaceC24630yw3.m(0);
        return interfaceC24630yw3.i() ? C22045ua3.l(jM) : C22045ua3.k(jM);
    }

    private final void k(InterfaceC24630yw3 interfaceC24630yw3, int i, b bVar) {
        int i2 = 0;
        long jM = interfaceC24630yw3.m(0);
        long jH = interfaceC24630yw3.i() ? C22045ua3.h(jM, 0, i, 1, null) : C22045ua3.h(jM, i, 0, 2, null);
        androidx.compose.foundation.lazy.layout.c[] cVarArrA = bVar.a();
        int length = cVarArrA.length;
        int i3 = 0;
        while (i2 < length) {
            androidx.compose.foundation.lazy.layout.c cVar = cVarArrA[i2];
            int i4 = i3 + 1;
            if (cVar != null) {
                cVar.J(C22045ua3.o(jH, C22045ua3.n(interfaceC24630yw3.m(i3), jM)));
            }
            i2++;
            i3 = i4;
        }
    }

    static /* synthetic */ void l(LazyLayoutItemAnimator lazyLayoutItemAnimator, InterfaceC24630yw3 interfaceC24630yw3, int i, b bVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            Object objE = lazyLayoutItemAnimator.a.e(interfaceC24630yw3.getKey());
            AbstractC13042fc3.f(objE);
            bVar = (b) objE;
        }
        lazyLayoutItemAnimator.k(interfaceC24630yw3, i, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void n() {
        /*
            r14 = this;
            ir.nasim.Rm4 r0 = r14.a
            boolean r0 = r0.i()
            if (r0 == 0) goto L63
            ir.nasim.Rm4 r0 = r14.a
            java.lang.Object[] r1 = r0.c
            long[] r0 = r0.a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L5e
            r3 = 0
            r4 = r3
        L15:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L59
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L2f:
            if (r9 >= r7) goto L57
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L53
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$b r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b) r10
            androidx.compose.foundation.lazy.layout.c[] r10 = r10.a()
            int r11 = r10.length
            r12 = r3
        L47:
            if (r12 >= r11) goto L53
            r13 = r10[r12]
            if (r13 == 0) goto L50
            r13.y()
        L50:
            int r12 = r12 + 1
            goto L47
        L53:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L2f
        L57:
            if (r7 != r8) goto L5e
        L59:
            if (r4 == r2) goto L5e
            int r4 = r4 + 1
            goto L15
        L5e:
            ir.nasim.Rm4 r0 = r14.a
            r0.k()
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.n():void");
    }

    private final void o(Object obj) {
        androidx.compose.foundation.lazy.layout.c[] cVarArrA;
        b bVar = (b) this.a.u(obj);
        if (bVar == null || (cVarArrA = bVar.a()) == null) {
            return;
        }
        for (androidx.compose.foundation.lazy.layout.c cVar : cVarArrA) {
            if (cVar != null) {
                cVar.y();
            }
        }
    }

    private final void q(InterfaceC24630yw3 interfaceC24630yw3, boolean z) {
        Object objE = this.a.e(interfaceC24630yw3.getKey());
        AbstractC13042fc3.f(objE);
        androidx.compose.foundation.lazy.layout.c[] cVarArrA = ((b) objE).a();
        int length = cVarArrA.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            androidx.compose.foundation.lazy.layout.c cVar = cVarArrA[i];
            int i3 = i2 + 1;
            if (cVar != null) {
                long jM = interfaceC24630yw3.m(i2);
                long jS = cVar.s();
                if (!C22045ua3.j(jS, androidx.compose.foundation.lazy.layout.c.s.a()) && !C22045ua3.j(jS, jM)) {
                    cVar.m(C22045ua3.n(jM, jS), z);
                }
                cVar.J(jM);
            }
            i++;
            i2 = i3;
        }
    }

    static /* synthetic */ void r(LazyLayoutItemAnimator lazyLayoutItemAnimator, InterfaceC24630yw3 interfaceC24630yw3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyLayoutItemAnimator.q(interfaceC24630yw3, z);
    }

    private final int s(int[] iArr, InterfaceC24630yw3 interfaceC24630yw3) {
        int iN = interfaceC24630yw3.n();
        int iC = interfaceC24630yw3.c() + iN;
        int iMax = 0;
        while (iN < iC) {
            int iK = iArr[iN] + interfaceC24630yw3.k();
            iArr[iN] = iK;
            iMax = Math.max(iMax, iK);
            iN++;
        }
        return iMax;
    }

    public final androidx.compose.foundation.lazy.layout.c e(Object obj, int i) {
        androidx.compose.foundation.lazy.layout.c[] cVarArrA;
        b bVar = (b) this.a.e(obj);
        if (bVar == null || (cVarArrA = bVar.a()) == null) {
            return null;
        }
        return cVarArrA[i];
    }

    public final long i() {
        long jA = C4414Fa3.b.a();
        List list = this.i;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            androidx.compose.foundation.lazy.layout.c cVar = (androidx.compose.foundation.lazy.layout.c) list.get(i);
            C21226tK2 c21226tK2P = cVar.p();
            if (c21226tK2P != null) {
                jA = C4414Fa3.c((Math.max((int) (jA & 4294967295L), C22045ua3.l(cVar.s()) + ((int) (c21226tK2P.w() & 4294967295L))) & 4294967295L) | (Math.max((int) (jA >> 32), C22045ua3.k(cVar.s()) + ((int) (c21226tK2P.w() >> 32))) << 32));
            }
        }
        return jA;
    }

    public final androidx.compose.ui.e j() {
        return this.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0442  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(int r36, int r37, int r38, java.util.List r39, ir.nasim.InterfaceC22264uw3 r40, ir.nasim.InterfaceC3676Bw3 r41, boolean r42, boolean r43, int r44, boolean r45, int r46, int r47, ir.nasim.InterfaceC20315ro1 r48, ir.nasim.InterfaceC20014rK2 r49) {
        /*
            Method dump skipped, instructions count: 1433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.m(int, int, int, java.util.List, ir.nasim.uw3, ir.nasim.Bw3, boolean, boolean, int, boolean, int, int, ir.nasim.ro1, ir.nasim.rK2):void");
    }

    public final void p() {
        n();
        this.b = null;
        this.c = -1;
    }
}
