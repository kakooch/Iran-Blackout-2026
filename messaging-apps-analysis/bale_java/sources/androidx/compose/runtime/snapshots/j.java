package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.g;
import androidx.compose.runtime.snapshots.i;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16481lL6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C15854kH6;
import ir.nasim.C17036mH6;
import ir.nasim.C19938rB7;
import ir.nasim.C7620Sm4;
import ir.nasim.F48;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.QG6;
import ir.nasim.QL;
import ir.nasim.SG6;
import ir.nasim.UA2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public abstract class j {
    private static final long b = 0;
    private static i e;
    private static long f;
    private static final QG6 g;
    private static final C17036mH6 h;
    private static List i;
    private static List j;
    private static final androidx.compose.runtime.snapshots.a k;
    private static final g l;
    private static QL m;
    private static final UA2 a = a.e;
    private static final C15854kH6 c = new C15854kH6();
    private static final Object d = new Object();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(i iVar) {
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((i) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, UA2 ua22) {
            super(1);
            this.e = ua2;
            this.f = ua22;
        }

        public final void a(Object obj) {
            this.e.invoke(obj);
            this.f.invoke(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, UA2 ua22) {
            super(1);
            this.e = ua2;
            this.f = ua22;
        }

        public final void a(Object obj) {
            this.e.invoke(obj);
            this.f.invoke(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke(i iVar) {
            g gVar = (g) this.e.invoke(iVar);
            synchronized (j.J()) {
                j.e = j.e.C(gVar.i());
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            return gVar;
        }
    }

    static {
        i.a aVar = i.e;
        e = aVar.a();
        f = SG6.c(1) + 1;
        g = new QG6();
        h = new C17036mH6();
        i = AbstractC10360bX0.m();
        j = AbstractC10360bX0.m();
        long j2 = f;
        f = 1 + j2;
        androidx.compose.runtime.snapshots.a aVar2 = new androidx.compose.runtime.snapshots.a(j2, aVar.a());
        e = e.C(aVar2.i());
        k = aVar2;
        l = aVar2;
        m = new QL(0);
    }

    public static final i A(i iVar, long j2, long j3) {
        while (j2 < j3) {
            iVar = iVar.C(j2);
            j2++;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object B(ir.nasim.UA2 r17) {
        /*
            r0 = 1
            androidx.compose.runtime.snapshots.a r1 = androidx.compose.runtime.snapshots.j.k
            java.lang.Object r2 = J()
            monitor-enter(r2)
            ir.nasim.Sm4 r3 = r1.E()     // Catch: java.lang.Throwable -> L16
            if (r3 == 0) goto L13
            ir.nasim.QL r4 = androidx.compose.runtime.snapshots.j.m     // Catch: java.lang.Throwable -> L16
            r4.a(r0)     // Catch: java.lang.Throwable -> L16
        L13:
            r4 = r17
            goto L19
        L16:
            r0 = move-exception
            goto La0
        L19:
            java.lang.Object r4 = a0(r1, r4)     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)
            r2 = 0
            if (r3 == 0) goto L4b
            r5 = -1
            java.util.List r6 = androidx.compose.runtime.snapshots.j.i     // Catch: java.lang.Throwable -> L3d
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7     // Catch: java.lang.Throwable -> L3d
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L3d
            r8 = r2
        L2c:
            if (r8 >= r7) goto L3f
            java.lang.Object r9 = r6.get(r8)     // Catch: java.lang.Throwable -> L3d
            ir.nasim.iB2 r9 = (ir.nasim.InterfaceC14603iB2) r9     // Catch: java.lang.Throwable -> L3d
            java.util.Set r10 = ir.nasim.AbstractC24434yc6.a(r3)     // Catch: java.lang.Throwable -> L3d
            r9.invoke(r10, r1)     // Catch: java.lang.Throwable -> L3d
            int r8 = r8 + r0
            goto L2c
        L3d:
            r0 = move-exception
            goto L45
        L3f:
            ir.nasim.QL r1 = androidx.compose.runtime.snapshots.j.m
            r1.a(r5)
            goto L4b
        L45:
            ir.nasim.QL r1 = androidx.compose.runtime.snapshots.j.m
            r1.a(r5)
            throw r0
        L4b:
            java.lang.Object r1 = J()
            monitor-enter(r1)
            D()     // Catch: java.lang.Throwable -> L8f
            if (r3 == 0) goto L9c
            java.lang.Object[] r5 = r3.b     // Catch: java.lang.Throwable -> L8f
            long[] r3 = r3.a     // Catch: java.lang.Throwable -> L8f
            int r6 = r3.length     // Catch: java.lang.Throwable -> L8f
            int r6 = r6 + (-2)
            if (r6 < 0) goto L9a
            r7 = r2
        L5f:
            r8 = r3[r7]     // Catch: java.lang.Throwable -> L8f
            long r10 = ~r8     // Catch: java.lang.Throwable -> L8f
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L96
            int r10 = r7 - r6
            int r10 = ~r10     // Catch: java.lang.Throwable -> L8f
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r2
        L79:
            if (r12 >= r10) goto L94
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L91
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r5[r13]     // Catch: java.lang.Throwable -> L8f
            ir.nasim.iL6 r13 = (ir.nasim.InterfaceC14710iL6) r13     // Catch: java.lang.Throwable -> L8f
            U(r13)     // Catch: java.lang.Throwable -> L8f
            goto L91
        L8f:
            r0 = move-exception
            goto L9e
        L91:
            long r8 = r8 >> r11
            int r12 = r12 + r0
            goto L79
        L94:
            if (r10 != r11) goto L9a
        L96:
            if (r7 == r6) goto L9a
            int r7 = r7 + r0
            goto L5f
        L9a:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L8f
        L9c:
            monitor-exit(r1)
            return r4
        L9e:
            monitor-exit(r1)
            throw r0
        La0:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.j.B(ir.nasim.UA2):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C() {
        B(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D() {
        C17036mH6 c17036mH6 = h;
        int iE = c17036mH6.e();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= iE) {
                break;
            }
            F48 f48 = c17036mH6.f()[i2];
            if ((f48 != null ? f48.get() : null) != null && !(!T((InterfaceC14710iL6) r5))) {
                if (i3 != i2) {
                    c17036mH6.f()[i3] = f48;
                    c17036mH6.d()[i3] = c17036mH6.d()[i2];
                }
                i3++;
            }
            i2++;
        }
        for (int i4 = i3; i4 < iE; i4++) {
            c17036mH6.f()[i4] = null;
            c17036mH6.d()[i4] = 0;
        }
        if (i3 != iE) {
            c17036mH6.g(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g E(g gVar, UA2 ua2, boolean z) {
        boolean z2 = gVar instanceof androidx.compose.runtime.snapshots.b;
        if (z2 || gVar == null) {
            return new l(z2 ? (androidx.compose.runtime.snapshots.b) gVar : null, ua2, null, false, z);
        }
        return new m(gVar, ua2, false, z);
    }

    static /* synthetic */ g F(g gVar, UA2 ua2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            ua2 = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return E(gVar, ua2, z);
    }

    public static final AbstractC16481lL6 G(AbstractC16481lL6 abstractC16481lL6) {
        AbstractC16481lL6 abstractC16481lL6W;
        g.a aVar = g.e;
        g gVarC = aVar.c();
        AbstractC16481lL6 abstractC16481lL6W2 = W(abstractC16481lL6, gVarC.i(), gVarC.f());
        if (abstractC16481lL6W2 != null) {
            return abstractC16481lL6W2;
        }
        synchronized (J()) {
            g gVarC2 = aVar.c();
            abstractC16481lL6W = W(abstractC16481lL6, gVarC2.i(), gVarC2.f());
        }
        if (abstractC16481lL6W != null) {
            return abstractC16481lL6W;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final AbstractC16481lL6 H(AbstractC16481lL6 abstractC16481lL6, g gVar) {
        AbstractC16481lL6 abstractC16481lL6W;
        AbstractC16481lL6 abstractC16481lL6W2 = W(abstractC16481lL6, gVar.i(), gVar.f());
        if (abstractC16481lL6W2 != null) {
            return abstractC16481lL6W2;
        }
        synchronized (J()) {
            abstractC16481lL6W = W(abstractC16481lL6, gVar.i(), gVar.f());
        }
        if (abstractC16481lL6W != null) {
            return abstractC16481lL6W;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final g I() {
        g gVar = (g) c.a();
        return gVar == null ? k : gVar;
    }

    public static final Object J() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UA2 K(UA2 ua2, UA2 ua22, boolean z) {
        if (!z) {
            ua22 = null;
        }
        return (ua2 == null || ua22 == null || ua2 == ua22) ? ua2 == null ? ua22 : ua2 : new b(ua2, ua22);
    }

    static /* synthetic */ UA2 L(UA2 ua2, UA2 ua22, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return K(ua2, ua22, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UA2 M(UA2 ua2, UA2 ua22) {
        return (ua2 == null || ua22 == null || ua2 == ua22) ? ua2 == null ? ua22 : ua2 : new c(ua2, ua22);
    }

    public static final AbstractC16481lL6 N(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6) {
        AbstractC16481lL6 abstractC16481lL6D0 = d0(interfaceC14710iL6);
        if (abstractC16481lL6D0 != null) {
            abstractC16481lL6D0.h(Long.MAX_VALUE);
            return abstractC16481lL6D0;
        }
        AbstractC16481lL6 abstractC16481lL6D = abstractC16481lL6.d(Long.MAX_VALUE);
        abstractC16481lL6D.g(interfaceC14710iL6.j());
        AbstractC13042fc3.g(abstractC16481lL6D, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        interfaceC14710iL6.i(abstractC16481lL6D);
        AbstractC13042fc3.g(abstractC16481lL6D, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return abstractC16481lL6D;
    }

    public static final AbstractC16481lL6 O(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6, g gVar) {
        AbstractC16481lL6 abstractC16481lL6P;
        synchronized (J()) {
            abstractC16481lL6P = P(abstractC16481lL6, interfaceC14710iL6, gVar);
        }
        return abstractC16481lL6P;
    }

    private static final AbstractC16481lL6 P(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6, g gVar) {
        AbstractC16481lL6 abstractC16481lL6N = N(abstractC16481lL6, interfaceC14710iL6);
        abstractC16481lL6N.c(abstractC16481lL6);
        abstractC16481lL6N.h(gVar.i());
        return abstractC16481lL6N;
    }

    public static final void Q(g gVar, InterfaceC14710iL6 interfaceC14710iL6) {
        gVar.w(gVar.j() + 1);
        UA2 ua2K = gVar.k();
        if (ua2K != null) {
            ua2K.invoke(interfaceC14710iL6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map R(long j2, androidx.compose.runtime.snapshots.b bVar, i iVar) {
        long[] jArr;
        HashMap map;
        i iVar2;
        long[] jArr2;
        HashMap map2;
        i iVar3;
        long j3 = j2;
        C7620Sm4 c7620Sm4E = bVar.E();
        HashMap map3 = null;
        if (c7620Sm4E == null) {
            return null;
        }
        i iVarB = bVar.f().C(bVar.i()).B(bVar.F());
        Object[] objArr = c7620Sm4E.b;
        long[] jArr3 = c7620Sm4E.a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            HashMap map4 = null;
            int i2 = 0;
            while (true) {
                long j4 = jArr3[i2];
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j4) < 128) {
                            InterfaceC14710iL6 interfaceC14710iL6 = (InterfaceC14710iL6) objArr[(i2 << 3) + i5];
                            AbstractC16481lL6 abstractC16481lL6J = interfaceC14710iL6.j();
                            AbstractC16481lL6 abstractC16481lL6W = W(abstractC16481lL6J, j3, iVar);
                            if (abstractC16481lL6W == null) {
                                jArr2 = jArr3;
                            } else {
                                jArr2 = jArr3;
                                AbstractC16481lL6 abstractC16481lL6W2 = W(abstractC16481lL6J, j3, iVarB);
                                if (abstractC16481lL6W2 != null && !AbstractC13042fc3.d(abstractC16481lL6W, abstractC16481lL6W2)) {
                                    iVar3 = iVarB;
                                    AbstractC16481lL6 abstractC16481lL6W3 = W(abstractC16481lL6J, bVar.i(), bVar.f());
                                    if (abstractC16481lL6W3 == null) {
                                        V();
                                        throw new KotlinNothingValueException();
                                    }
                                    AbstractC16481lL6 abstractC16481lL6F = interfaceC14710iL6.f(abstractC16481lL6W2, abstractC16481lL6W, abstractC16481lL6W3);
                                    if (abstractC16481lL6F == null) {
                                        return null;
                                    }
                                    if (map4 == null) {
                                        map4 = new HashMap();
                                    }
                                    map4.put(abstractC16481lL6W, abstractC16481lL6F);
                                    map4 = map4;
                                }
                                map2 = null;
                            }
                            iVar3 = iVarB;
                            map2 = null;
                        } else {
                            jArr2 = jArr3;
                            map2 = map3;
                            iVar3 = iVarB;
                        }
                        j4 >>= 8;
                        i5++;
                        map3 = map2;
                        i3 = 8;
                        jArr3 = jArr2;
                        iVarB = iVar3;
                        j3 = j2;
                    }
                    jArr = jArr3;
                    map = map3;
                    iVar2 = iVarB;
                    if (i4 != i3) {
                        return map4;
                    }
                } else {
                    jArr = jArr3;
                    map = map3;
                    iVar2 = iVarB;
                }
                if (i2 == length) {
                    map3 = map4;
                    break;
                }
                i2++;
                map3 = map;
                jArr3 = jArr;
                iVarB = iVar2;
                j3 = j2;
            }
        }
        return map3;
    }

    public static final AbstractC16481lL6 S(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6, g gVar, AbstractC16481lL6 abstractC16481lL62) {
        AbstractC16481lL6 abstractC16481lL6N;
        if (gVar.h()) {
            gVar.p(interfaceC14710iL6);
        }
        long jI = gVar.i();
        if (abstractC16481lL62.f() == jI) {
            return abstractC16481lL62;
        }
        synchronized (J()) {
            abstractC16481lL6N = N(abstractC16481lL6, interfaceC14710iL6);
        }
        abstractC16481lL6N.h(jI);
        if (abstractC16481lL62.f() != SG6.c(1)) {
            gVar.p(interfaceC14710iL6);
        }
        return abstractC16481lL6N;
    }

    private static final boolean T(InterfaceC14710iL6 interfaceC14710iL6) {
        AbstractC16481lL6 abstractC16481lL6;
        long jE = g.e(f);
        AbstractC16481lL6 abstractC16481lL62 = null;
        AbstractC16481lL6 abstractC16481lL6J = null;
        int i2 = 0;
        for (AbstractC16481lL6 abstractC16481lL6J2 = interfaceC14710iL6.j(); abstractC16481lL6J2 != null; abstractC16481lL6J2 = abstractC16481lL6J2.e()) {
            long jF = abstractC16481lL6J2.f();
            if (jF != b) {
                if (jF >= jE) {
                    i2++;
                } else if (abstractC16481lL62 == null) {
                    i2++;
                    abstractC16481lL62 = abstractC16481lL6J2;
                } else {
                    if (abstractC16481lL6J2.f() < abstractC16481lL62.f()) {
                        abstractC16481lL6 = abstractC16481lL62;
                        abstractC16481lL62 = abstractC16481lL6J2;
                    } else {
                        abstractC16481lL6 = abstractC16481lL6J2;
                    }
                    if (abstractC16481lL6J == null) {
                        abstractC16481lL6J = interfaceC14710iL6.j();
                        AbstractC16481lL6 abstractC16481lL63 = abstractC16481lL6J;
                        while (true) {
                            if (abstractC16481lL6J == null) {
                                abstractC16481lL6J = abstractC16481lL63;
                                break;
                            }
                            if (abstractC16481lL6J.f() >= jE) {
                                break;
                            }
                            if (abstractC16481lL63.f() < abstractC16481lL6J.f()) {
                                abstractC16481lL63 = abstractC16481lL6J;
                            }
                            abstractC16481lL6J = abstractC16481lL6J.e();
                        }
                    }
                    abstractC16481lL62.h(b);
                    abstractC16481lL62.c(abstractC16481lL6J);
                    abstractC16481lL62 = abstractC16481lL6;
                }
            }
        }
        return i2 > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(InterfaceC14710iL6 interfaceC14710iL6) {
        if (T(interfaceC14710iL6)) {
            h.a(interfaceC14710iL6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void V() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC16481lL6 W(AbstractC16481lL6 abstractC16481lL6, long j2, i iVar) {
        AbstractC16481lL6 abstractC16481lL62 = null;
        while (abstractC16481lL6 != null) {
            if (f0(abstractC16481lL6, j2, iVar) && (abstractC16481lL62 == null || abstractC16481lL62.f() < abstractC16481lL6.f())) {
                abstractC16481lL62 = abstractC16481lL6;
            }
            abstractC16481lL6 = abstractC16481lL6.e();
        }
        if (abstractC16481lL62 != null) {
            return abstractC16481lL62;
        }
        return null;
    }

    public static final AbstractC16481lL6 X(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6) {
        AbstractC16481lL6 abstractC16481lL6W;
        g.a aVar = g.e;
        g gVarC = aVar.c();
        UA2 ua2G = gVarC.g();
        if (ua2G != null) {
            ua2G.invoke(interfaceC14710iL6);
        }
        AbstractC16481lL6 abstractC16481lL6W2 = W(abstractC16481lL6, gVarC.i(), gVarC.f());
        if (abstractC16481lL6W2 != null) {
            return abstractC16481lL6W2;
        }
        synchronized (J()) {
            g gVarC2 = aVar.c();
            AbstractC16481lL6 abstractC16481lL6J = interfaceC14710iL6.j();
            AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            abstractC16481lL6W = W(abstractC16481lL6J, gVarC2.i(), gVarC2.f());
            if (abstractC16481lL6W == null) {
                V();
                throw new KotlinNothingValueException();
            }
        }
        return abstractC16481lL6W;
    }

    public static final void Y(int i2) {
        g.f(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void Z() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object a0(androidx.compose.runtime.snapshots.a aVar, UA2 ua2) {
        long jI = aVar.i();
        Object objInvoke = ua2.invoke(e.v(jI));
        long j2 = f;
        f = 1 + j2;
        e = e.v(jI);
        aVar.v(j2);
        aVar.u(e);
        aVar.w(0);
        aVar.Q(null);
        aVar.q();
        e = e.C(j2);
        return objInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g b0(UA2 ua2) {
        return (g) B(new d(ua2));
    }

    public static final int c0(long j2, i iVar) {
        int iA;
        long jA = iVar.A(j2);
        synchronized (J()) {
            iA = g.a(jA);
        }
        return iA;
    }

    private static final AbstractC16481lL6 d0(InterfaceC14710iL6 interfaceC14710iL6) {
        long jE = g.e(f) - 1;
        i iVarA = i.e.a();
        AbstractC16481lL6 abstractC16481lL6 = null;
        for (AbstractC16481lL6 abstractC16481lL6J = interfaceC14710iL6.j(); abstractC16481lL6J != null; abstractC16481lL6J = abstractC16481lL6J.e()) {
            if (abstractC16481lL6J.f() == b) {
                return abstractC16481lL6J;
            }
            if (f0(abstractC16481lL6J, jE, iVarA)) {
                if (abstractC16481lL6 != null) {
                    return abstractC16481lL6J.f() < abstractC16481lL6.f() ? abstractC16481lL6J : abstractC16481lL6;
                }
                abstractC16481lL6 = abstractC16481lL6J;
            }
        }
        return null;
    }

    private static final boolean e0(long j2, long j3, i iVar) {
        return (j3 == b || j3 > j2 || iVar.x(j3)) ? false : true;
    }

    private static final boolean f0(AbstractC16481lL6 abstractC16481lL6, long j2, i iVar) {
        return e0(j2, abstractC16481lL6.f(), iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(g gVar) {
        long jE;
        if (e.x(gVar.i())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot is not open: snapshotId=");
        sb.append(gVar.i());
        sb.append(", disposed=");
        sb.append(gVar.e());
        sb.append(", applied=");
        androidx.compose.runtime.snapshots.b bVar = gVar instanceof androidx.compose.runtime.snapshots.b ? (androidx.compose.runtime.snapshots.b) gVar : null;
        sb.append(bVar != null ? Boolean.valueOf(bVar.D()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (J()) {
            jE = g.e(-1L);
        }
        sb.append(jE);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final AbstractC16481lL6 h0(AbstractC16481lL6 abstractC16481lL6, InterfaceC14710iL6 interfaceC14710iL6, g gVar) {
        AbstractC16481lL6 abstractC16481lL6W;
        if (gVar.h()) {
            gVar.p(interfaceC14710iL6);
        }
        long jI = gVar.i();
        AbstractC16481lL6 abstractC16481lL6W2 = W(abstractC16481lL6, jI, gVar.f());
        if (abstractC16481lL6W2 == null) {
            V();
            throw new KotlinNothingValueException();
        }
        if (abstractC16481lL6W2.f() == gVar.i()) {
            return abstractC16481lL6W2;
        }
        synchronized (J()) {
            abstractC16481lL6W = W(interfaceC14710iL6.j(), jI, gVar.f());
            if (abstractC16481lL6W == null) {
                V();
                throw new KotlinNothingValueException();
            }
            if (abstractC16481lL6W.f() != jI) {
                abstractC16481lL6W = P(abstractC16481lL6W, interfaceC14710iL6, gVar);
            }
        }
        AbstractC13042fc3.g(abstractC16481lL6W, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (abstractC16481lL6W2.f() != SG6.c(1)) {
            gVar.p(interfaceC14710iL6);
        }
        return abstractC16481lL6W;
    }
}
