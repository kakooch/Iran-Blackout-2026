package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.h;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16481lL6;
import ir.nasim.AbstractC23254wc6;
import ir.nasim.AbstractC24434yc6;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5214Ij5;
import ir.nasim.AbstractC9628aH6;
import ir.nasim.AbstractC9648aK;
import ir.nasim.C19938rB7;
import ir.nasim.C7620Sm4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.InterfaceC19286q55;
import ir.nasim.SG6;
import ir.nasim.TG6;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public class b extends g {
    private static final a p = new a(null);
    public static final int q = 8;
    private static final int[] r = new int[0];
    private final UA2 g;
    private final UA2 h;
    private int i;
    private C7620Sm4 j;
    private List k;
    private i l;
    private int[] m;
    private int n;
    private boolean o;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public b(long j, i iVar, UA2 ua2, UA2 ua22) {
        super(j, iVar, null);
        this.g = ua2;
        this.h = ua22;
        this.l = i.e.a();
        this.m = r;
        this.n = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A() {
        /*
            r17 = this;
            r0 = r17
            ir.nasim.Sm4 r1 = r17.E()
            if (r1 == 0) goto L7f
            r17.S()
            r2 = 0
            r0.Q(r2)
            long r2 = r17.i()
            java.lang.Object[] r4 = r1.b
            long[] r1 = r1.a
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L7f
            r6 = 0
            r7 = r6
        L1e:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L7a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L38:
            if (r12 >= r10) goto L78
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L74
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            ir.nasim.iL6 r13 = (ir.nasim.InterfaceC14710iL6) r13
            ir.nasim.lL6 r13 = r13.j()
        L4e:
            if (r13 == 0) goto L74
            long r14 = r13.f()
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 == 0) goto L68
            androidx.compose.runtime.snapshots.i r14 = r0.l
            long r15 = r13.f()
            java.lang.Long r15 = java.lang.Long.valueOf(r15)
            boolean r14 = ir.nasim.ZW0.i0(r14, r15)
            if (r14 == 0) goto L6f
        L68:
            long r14 = androidx.compose.runtime.snapshots.j.i()
            r13.h(r14)
        L6f:
            ir.nasim.lL6 r13 = r13.e()
            goto L4e
        L74:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L38
        L78:
            if (r10 != r11) goto L7f
        L7a:
            if (r7 == r5) goto L7f
            int r7 = r7 + 1
            goto L1e
        L7f:
            r17.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.b.A():void");
    }

    private final void O() {
        int length = this.m.length;
        for (int i = 0; i < length; i++) {
            j.Y(this.m[i]);
        }
    }

    private final void S() {
        if (!this.o) {
            return;
        }
        AbstractC5214Ij5.b("Unsupported operation on a snapshot that has been applied");
    }

    private final void T() {
        if (!this.o || ((g) this).d >= 0) {
            return;
        }
        AbstractC5214Ij5.b("Unsupported operation on a disposed or applied snapshot");
    }

    public final void B() {
        K(i());
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (D() || e()) {
            return;
        }
        long jI = i();
        synchronized (j.J()) {
            long j = j.f;
            j.f++;
            v(j);
            j.e = j.e.C(i());
        }
        u(j.A(f(), jI + 1, i()));
    }

    public h C() {
        Map mapR;
        List list;
        C7620Sm4 c7620Sm4E;
        int i;
        long j;
        C7620Sm4 c7620Sm4E2 = E();
        if (c7620Sm4E2 != null) {
            androidx.compose.runtime.snapshots.a aVar = j.k;
            mapR = j.R(aVar.i(), this, j.e.v(aVar.i()));
        } else {
            mapR = null;
        }
        List listM = AbstractC10360bX0.m();
        synchronized (j.J()) {
            try {
                j.g0(this);
                if (c7620Sm4E2 == null || c7620Sm4E2.c() == 0) {
                    c();
                    androidx.compose.runtime.snapshots.a aVar2 = j.k;
                    C7620Sm4 c7620Sm4E3 = aVar2.E();
                    j.a0(aVar2, j.a);
                    if (c7620Sm4E3 == null || !c7620Sm4E3.e()) {
                        list = listM;
                        c7620Sm4E = null;
                    } else {
                        list = j.i;
                        c7620Sm4E = c7620Sm4E3;
                    }
                } else {
                    androidx.compose.runtime.snapshots.a aVar3 = j.k;
                    h hVarJ = J(j.f, c7620Sm4E2, mapR, j.e.v(aVar3.i()));
                    if (!AbstractC13042fc3.d(hVarJ, h.b.a)) {
                        return hVarJ;
                    }
                    c();
                    c7620Sm4E = aVar3.E();
                    j.a0(aVar3, j.a);
                    Q(null);
                    aVar3.Q(null);
                    list = j.i;
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                this.o = true;
                if (c7620Sm4E != null) {
                    Set setA = AbstractC24434yc6.a(c7620Sm4E);
                    if (!setA.isEmpty()) {
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ((InterfaceC14603iB2) list.get(i2)).invoke(setA, this);
                        }
                    }
                }
                if (c7620Sm4E2 != null && c7620Sm4E2.e()) {
                    Set setA2 = AbstractC24434yc6.a(c7620Sm4E2);
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((InterfaceC14603iB2) list.get(i3)).invoke(setA2, this);
                    }
                }
                AbstractC9628aH6.c(this, c7620Sm4E2);
                synchronized (j.J()) {
                    try {
                        r();
                        j.D();
                        if (c7620Sm4E != null) {
                            Object[] objArr = c7620Sm4E.b;
                            long[] jArr = c7620Sm4E.a;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i4 = 0;
                                while (true) {
                                    long j2 = jArr[i4];
                                    long[] jArr2 = jArr;
                                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                                        for (int i6 = 0; i6 < i5; i6++) {
                                            if ((j2 & 255) < 128) {
                                                j.U((InterfaceC14710iL6) objArr[(i4 << 3) + i6]);
                                            }
                                            j2 >>= 8;
                                        }
                                        if (i5 != 8) {
                                            break;
                                        }
                                    }
                                    if (i4 == length) {
                                        break;
                                    }
                                    i4++;
                                    jArr = jArr2;
                                }
                            }
                        }
                        if (c7620Sm4E2 != null) {
                            Object[] objArr2 = c7620Sm4E2.b;
                            long[] jArr3 = c7620Sm4E2.a;
                            int length2 = jArr3.length - 2;
                            if (length2 >= 0) {
                                int i7 = 0;
                                while (true) {
                                    long j3 = jArr3[i7];
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i8 = 8 - ((~(i7 - length2)) >>> 31);
                                        for (int i9 = 0; i9 < i8; i9++) {
                                            if ((j3 & 255) < 128) {
                                                j.U((InterfaceC14710iL6) objArr2[(i7 << 3) + i9]);
                                            }
                                            j3 >>= 8;
                                        }
                                        i = 1;
                                        j = 255;
                                        if (i8 != 8) {
                                            break;
                                        }
                                    } else {
                                        i = 1;
                                        j = 255;
                                    }
                                    if (i7 == length2) {
                                        break;
                                    }
                                    i7 += i;
                                }
                            }
                        }
                        List list2 = this.k;
                        if (list2 != null) {
                            int size3 = list2.size();
                            for (int i10 = 0; i10 < size3; i10++) {
                                j.U((InterfaceC14710iL6) list2.get(i10));
                            }
                        }
                        this.k = null;
                        C19938rB7 c19938rB72 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return h.b.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean D() {
        return this.o;
    }

    public C7620Sm4 E() {
        return this.j;
    }

    public final i F() {
        return this.l;
    }

    public final int[] G() {
        return this.m;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: H */
    public UA2 g() {
        return this.g;
    }

    public boolean I() {
        C7620Sm4 c7620Sm4E = E();
        return c7620Sm4E != null && c7620Sm4E.e();
    }

    public final h J(long j, C7620Sm4 c7620Sm4, Map map, i iVar) {
        i iVar2;
        Object[] objArr;
        long[] jArr;
        int i;
        int i2;
        i iVar3;
        Object[] objArr2;
        long[] jArr2;
        int i3;
        AbstractC16481lL6 abstractC16481lL6W;
        AbstractC16481lL6 abstractC16481lL6F;
        long j2 = j;
        i iVarB = f().C(i()).B(this.l);
        Object[] objArr3 = c7620Sm4.b;
        long[] jArr3 = c7620Sm4.a;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        List listR0 = null;
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                long j3 = jArr3[i4];
                List arrayList2 = listR0;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j3 & 255) < 128) {
                            InterfaceC14710iL6 interfaceC14710iL6 = (InterfaceC14710iL6) objArr3[(i4 << 3) + i6];
                            objArr2 = objArr3;
                            AbstractC16481lL6 abstractC16481lL6J = interfaceC14710iL6.j();
                            jArr2 = jArr3;
                            AbstractC16481lL6 abstractC16481lL6W2 = j.W(abstractC16481lL6J, j2, iVar);
                            if (abstractC16481lL6W2 == null || (abstractC16481lL6W = j.W(abstractC16481lL6J, i(), iVarB)) == null || abstractC16481lL6W.f() == SG6.c(1) || AbstractC13042fc3.d(abstractC16481lL6W2, abstractC16481lL6W)) {
                                iVar3 = iVarB;
                            } else {
                                i3 = length;
                                iVar3 = iVarB;
                                AbstractC16481lL6 abstractC16481lL6W3 = j.W(abstractC16481lL6J, i(), f());
                                if (abstractC16481lL6W3 == null) {
                                    j.V();
                                    throw new KotlinNothingValueException();
                                }
                                if (map == null || (abstractC16481lL6F = (AbstractC16481lL6) map.get(abstractC16481lL6W2)) == null) {
                                    abstractC16481lL6F = interfaceC14710iL6.f(abstractC16481lL6W, abstractC16481lL6W2, abstractC16481lL6W3);
                                }
                                if (abstractC16481lL6F == null) {
                                    return new h.a(this);
                                }
                                if (!AbstractC13042fc3.d(abstractC16481lL6F, abstractC16481lL6W3)) {
                                    if (AbstractC13042fc3.d(abstractC16481lL6F, abstractC16481lL6W2)) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(AbstractC4616Fw7.a(interfaceC14710iL6, abstractC16481lL6W2.d(i())));
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        List list = arrayList2;
                                        list.add(interfaceC14710iL6);
                                        arrayList2 = list;
                                    } else {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(!AbstractC13042fc3.d(abstractC16481lL6F, abstractC16481lL6W) ? AbstractC4616Fw7.a(interfaceC14710iL6, abstractC16481lL6F) : AbstractC4616Fw7.a(interfaceC14710iL6, abstractC16481lL6W.d(i())));
                                    }
                                }
                                j3 >>= 8;
                                i6++;
                                length = i3;
                                objArr3 = objArr2;
                                jArr3 = jArr2;
                                iVarB = iVar3;
                                j2 = j;
                            }
                        } else {
                            iVar3 = iVarB;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                        }
                        i3 = length;
                        j3 >>= 8;
                        i6++;
                        length = i3;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        iVarB = iVar3;
                        j2 = j;
                    }
                    iVar2 = iVarB;
                    objArr = objArr3;
                    jArr = jArr3;
                    i = length;
                    i2 = 1;
                    listR0 = arrayList2;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    iVar2 = iVarB;
                    objArr = objArr3;
                    jArr = jArr3;
                    i = length;
                    i2 = 1;
                    listR0 = arrayList2;
                }
                if (i4 == i) {
                    break;
                }
                i4 += i2;
                length = i;
                objArr3 = objArr;
                jArr3 = jArr;
                iVarB = iVar2;
                j2 = j;
            }
        }
        if (arrayList != null) {
            B();
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                XV4 xv4 = (XV4) arrayList.get(i7);
                InterfaceC14710iL6 interfaceC14710iL62 = (InterfaceC14710iL6) xv4.a();
                AbstractC16481lL6 abstractC16481lL6 = (AbstractC16481lL6) xv4.b();
                abstractC16481lL6.h(j);
                synchronized (j.J()) {
                    abstractC16481lL6.g(interfaceC14710iL62.j());
                    interfaceC14710iL62.i(abstractC16481lL6);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            }
        }
        if (listR0 != null) {
            int size2 = listR0.size();
            for (int i8 = 0; i8 < size2; i8++) {
                c7620Sm4.y((InterfaceC14710iL6) listR0.get(i8));
            }
            List list2 = this.k;
            if (list2 != null) {
                listR0 = AbstractC15401jX0.R0(list2, listR0);
            }
            this.k = listR0;
        }
        return h.b.a;
    }

    public final void K(long j) {
        synchronized (j.J()) {
            this.l = this.l.C(j);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void L(i iVar) {
        synchronized (j.J()) {
            this.l = this.l.B(iVar);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void M(int i) {
        if (i >= 0) {
            this.m = AbstractC9648aK.B(this.m, i);
        }
    }

    public final void N(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.m;
        if (iArr2.length != 0) {
            iArr = AbstractC9648aK.C(iArr2, iArr);
        }
        this.m = iArr;
    }

    public final void P(boolean z) {
        this.o = z;
    }

    public void Q(C7620Sm4 c7620Sm4) {
        this.j = c7620Sm4;
    }

    public b R(UA2 ua2, UA2 ua22) {
        Map map;
        c cVar;
        z();
        T();
        InterfaceC19286q55 interfaceC19286q55 = AbstractC9628aH6.a;
        UA2 ua23 = ua2;
        UA2 ua2B = ua22;
        if (interfaceC19286q55 != null) {
            XV4 xv4E = AbstractC9628aH6.e(interfaceC19286q55, this, false, ua23, ua2B);
            TG6 tg6 = (TG6) xv4E.e();
            UA2 ua2A = tg6.a();
            ua2B = tg6.b();
            map = (Map) xv4E.f();
            ua23 = ua2A;
        } else {
            map = null;
        }
        K(i());
        synchronized (j.J()) {
            long j = j.f;
            j.f++;
            j.e = j.e.C(j);
            i iVarF = f();
            u(iVarF.C(j));
            cVar = new c(j, j.A(iVarF, i() + 1, j), j.L(ua23, g(), false, 4, null), j.M(ua2B, k()), this);
        }
        if (!D() && !e()) {
            long jI = i();
            synchronized (j.J()) {
                long j2 = j.f;
                j.f++;
                v(j2);
                j.e = j.e.C(i());
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            u(j.A(f(), jI + 1, i()));
        }
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, this, cVar, map);
        }
        return cVar;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void c() {
        j.e = j.e.v(i()).t(this.l);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        n(this);
        AbstractC9628aH6.d(this);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public boolean h() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public int j() {
        return this.i;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public UA2 k() {
        return this.h;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void m(g gVar) {
        this.n++;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void n(g gVar) {
        if (!(this.n > 0)) {
            AbstractC5214Ij5.a("no pending nested snapshots");
        }
        int i = this.n - 1;
        this.n = i;
        if (i != 0 || this.o) {
            return;
        }
        A();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void o() {
        if (this.o || e()) {
            return;
        }
        B();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void p(InterfaceC14710iL6 interfaceC14710iL6) {
        C7620Sm4 c7620Sm4E = E();
        if (c7620Sm4E == null) {
            c7620Sm4E = AbstractC23254wc6.a();
            Q(c7620Sm4E);
        }
        c7620Sm4E.h(interfaceC14710iL6);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void r() {
        O();
        super.r();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void w(int i) {
        this.i = i;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public g x(UA2 ua2) {
        UA2 ua22;
        Map map;
        d dVar;
        z();
        T();
        long jI = i();
        b bVar = this instanceof androidx.compose.runtime.snapshots.a ? null : this;
        InterfaceC19286q55 interfaceC19286q55 = AbstractC9628aH6.a;
        if (interfaceC19286q55 != null) {
            XV4 xv4E = AbstractC9628aH6.e(interfaceC19286q55, bVar, true, ua2, null);
            TG6 tg6 = (TG6) xv4E.e();
            UA2 ua2A = tg6.a();
            tg6.b();
            map = (Map) xv4E.f();
            ua22 = ua2A;
        } else {
            ua22 = ua2;
            map = null;
        }
        K(i());
        synchronized (j.J()) {
            long j = j.f;
            j.f++;
            j.e = j.e.C(j);
            dVar = new d(j, j.A(f(), jI + 1, j), j.L(ua22, g(), false, 4, null), this);
        }
        if (!D() && !e()) {
            long jI2 = i();
            synchronized (j.J()) {
                long j2 = j.f;
                j.f++;
                v(j2);
                j.e = j.e.C(i());
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            u(j.A(f(), jI2 + 1, i()));
        }
        if (interfaceC19286q55 != null) {
            AbstractC9628aH6.b(interfaceC19286q55, bVar, dVar, map);
        }
        return dVar;
    }
}
