package ir.nasim;

import ir.nasim.InterfaceC19404qI1;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Vb1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8225Vb1 implements InterfaceC25123zm1, InterfaceC24090y16, RJ5 {
    private final AbstractC7050Qb1 a;
    private final InterfaceC15247jG b;
    private final AtomicReference c;
    private final Object d;
    private final Set e;
    private final C21850uE6 f;
    private final C7386Rm4 g;
    private final C7620Sm4 h;
    private final C7620Sm4 i;
    private final C7386Rm4 j;
    private final OI0 k;
    private final OI0 l;
    private final C7386Rm4 m;
    private C7386Rm4 n;
    private boolean o;
    private C8225Vb1 p;
    private int q;
    private final C14249hc1 r;
    private final C4670Gb1 s;
    private final InterfaceC11938do1 t;
    private final boolean u;
    private boolean v;
    private InterfaceC14603iB2 w;

    public C8225Vb1(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC15247jG interfaceC15247jG, InterfaceC11938do1 interfaceC11938do1) {
        this.a = abstractC7050Qb1;
        this.b = interfaceC15247jG;
        this.c = new AtomicReference(null);
        this.d = new Object();
        Set setL = new C7620Sm4(0, 1, null).l();
        this.e = setL;
        C21850uE6 c21850uE6 = new C21850uE6();
        if (abstractC7050Qb1.c()) {
            c21850uE6.A();
        }
        if (abstractC7050Qb1.e()) {
            c21850uE6.B();
        }
        this.f = c21850uE6;
        this.g = AbstractC19601qd6.d(null, 1, null);
        this.h = new C7620Sm4(0, 1, null);
        this.i = new C7620Sm4(0, 1, null);
        this.j = AbstractC19601qd6.d(null, 1, null);
        OI0 oi0 = new OI0();
        this.k = oi0;
        OI0 oi02 = new OI0();
        this.l = oi02;
        this.m = AbstractC19601qd6.d(null, 1, null);
        this.n = AbstractC19601qd6.d(null, 1, null);
        this.r = new C14249hc1(null, false, 3, null);
        C4670Gb1 c4670Gb1 = new C4670Gb1(interfaceC15247jG, abstractC7050Qb1, c21850uE6, setL, oi0, oi02, this);
        abstractC7050Qb1.n(c4670Gb1);
        this.s = c4670Gb1;
        this.t = interfaceC11938do1;
        this.u = abstractC7050Qb1 instanceof SJ5;
        this.w = C20462s31.a.a();
    }

    private final void A() {
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        int i3;
        boolean zD;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        C7386Rm4 c7386Rm4 = this.j;
        long[] jArr5 = c7386Rm4.a;
        int length = jArr5.length - 2;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i4 = 8;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j3 = jArr5[i5];
                if ((((~j3) << c) & j3 & j2) != j2) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j3 & j) < 128) {
                            int i8 = (i5 << 3) + i7;
                            Object obj = c7386Rm4.b[i8];
                            Object obj2 = c7386Rm4.c[i8];
                            if (obj2 instanceof C7620Sm4) {
                                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                C7620Sm4 c7620Sm4 = (C7620Sm4) obj2;
                                Object[] objArr3 = c7620Sm4.b;
                                long[] jArr6 = c7620Sm4.a;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i = length;
                                if (length2 >= 0) {
                                    int i9 = 0;
                                    while (true) {
                                        long j4 = jArr6[i9];
                                        i2 = i6;
                                        i3 = i7;
                                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j4 & 255) < 128) {
                                                    int i12 = (i9 << 3) + i11;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    if (!AbstractC19601qd6.e(this.g, (InterfaceC19404qI1) objArr3[i12])) {
                                                        c7620Sm4.A(i12);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                }
                                                j4 >>= 8;
                                                i11++;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i10 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        i6 = i2;
                                        i7 = i3;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        c = 7;
                                    }
                                } else {
                                    i2 = i6;
                                    i3 = i7;
                                }
                                zD = c7620Sm4.d();
                            } else {
                                jArr2 = jArr5;
                                i = length;
                                i2 = i6;
                                i3 = i7;
                                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                zD = !AbstractC19601qd6.e(this.g, (InterfaceC19404qI1) obj2);
                            }
                            if (zD) {
                                c7386Rm4.v(i8);
                            }
                        } else {
                            jArr2 = jArr5;
                            i = length;
                            i2 = i6;
                            i3 = i7;
                        }
                        j3 >>= 8;
                        i7 = i3 + 1;
                        i4 = 8;
                        jArr5 = jArr2;
                        length = i;
                        i6 = i2;
                        j = 255;
                        c = 7;
                    }
                    jArr = jArr5;
                    int i13 = length;
                    if (i6 != i4) {
                        break;
                    } else {
                        length = i13;
                    }
                } else {
                    jArr = jArr5;
                }
                if (i5 == length) {
                    break;
                }
                i5++;
                jArr5 = jArr;
                j = 255;
                c = 7;
                j2 = -9187201950435737472L;
                i4 = 8;
            }
        }
        if (!this.i.e()) {
            return;
        }
        C7620Sm4 c7620Sm42 = this.i;
        Object[] objArr4 = c7620Sm42.b;
        long[] jArr7 = c7620Sm42.a;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i14 = 0;
        while (true) {
            long j5 = jArr7[i14];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i15 = 8 - ((~(i14 - length3)) >>> 31);
                for (int i16 = 0; i16 < i15; i16++) {
                    if ((j5 & 255) < 128) {
                        int i17 = (i14 << 3) + i16;
                        if (!((PJ5) objArr4[i17]).w()) {
                            c7620Sm42.A(i17);
                        }
                    }
                    j5 >>= 8;
                }
                if (i15 != 8) {
                    return;
                }
            }
            if (i14 == length3) {
                return;
            } else {
                i14++;
            }
        }
    }

    private final void B(InterfaceC14603iB2 interfaceC14603iB2) {
        if (!(!this.v)) {
            AbstractC5214Ij5.b("The composition is disposed");
        }
        this.w = interfaceC14603iB2;
        this.a.a(this, interfaceC14603iB2);
    }

    private final void C() {
        Object andSet = this.c.getAndSet(AbstractC8459Wb1.a);
        if (andSet != null) {
            if (AbstractC13042fc3.d(andSet, AbstractC8459Wb1.a)) {
                AbstractC5138Ib1.t("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                y((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                AbstractC5138Ib1.t("corrupt pendingModifications drain: " + this.c);
                throw new KotlinNothingValueException();
            }
            for (Set set : (Set[]) andSet) {
                y(set, true);
            }
        }
    }

    private final void D() {
        Object andSet = this.c.getAndSet(null);
        if (AbstractC13042fc3.d(andSet, AbstractC8459Wb1.a)) {
            return;
        }
        if (andSet instanceof Set) {
            y((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                y(set, false);
            }
            return;
        }
        if (andSet == null) {
            AbstractC5138Ib1.t("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        AbstractC5138Ib1.t("corrupt pendingModifications drain: " + this.c);
        throw new KotlinNothingValueException();
    }

    private final void E() {
        Object andSet = this.c.getAndSet(AbstractC4597Fu6.d());
        if (AbstractC13042fc3.d(andSet, AbstractC8459Wb1.a) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            y((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            AbstractC5138Ib1.t("corrupt pendingModifications drain: " + this.c);
            throw new KotlinNothingValueException();
        }
        for (Set set : (Set[]) andSet) {
            y(set, false);
        }
    }

    private final boolean F() {
        return this.s.E0();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a7 A[Catch: all -> 0x001e, EDGE_INSN: B:65:0x00a7->B:51:0x00a7 BREAK  A[LOOP:0: B:32:0x0060->B:47:0x009f], EDGE_INSN: B:66:0x00a7->B:51:0x00a7 BREAK  A[LOOP:0: B:32:0x0060->B:47:0x009f], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0032, B:22:0x003b, B:24:0x003f, B:25:0x0048, B:27:0x0050, B:29:0x0054, B:32:0x0060, B:34:0x0070, B:36:0x007c, B:38:0x0086, B:43:0x0095, B:47:0x009f, B:48:0x00a2, B:51:0x00a7), top: B:63:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.EnumC11036cd3 I(ir.nasim.PJ5 r21, ir.nasim.C6669Om r22, java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8225Vb1.I(ir.nasim.PJ5, ir.nasim.Om, java.lang.Object):ir.nasim.cd3");
    }

    private final void J(Object obj) {
        Object objE = this.g.e(obj);
        if (objE == null) {
            return;
        }
        if (!(objE instanceof C7620Sm4)) {
            PJ5 pj5 = (PJ5) objE;
            if (pj5.v(obj) == EnumC11036cd3.d) {
                AbstractC19601qd6.a(this.m, obj, pj5);
                return;
            }
            return;
        }
        C7620Sm4 c7620Sm4 = (C7620Sm4) objE;
        Object[] objArr = c7620Sm4.b;
        long[] jArr = c7620Sm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        PJ5 pj52 = (PJ5) objArr[(i << 3) + i3];
                        if (pj52.v(obj) == EnumC11036cd3.d) {
                            AbstractC19601qd6.a(this.m, obj, pj52);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final InterfaceC13658gc1 K() {
        C14249hc1 c14249hc1 = this.r;
        if (c14249hc1.b()) {
            c14249hc1.a();
        } else {
            C14249hc1 c14249hc1I = this.a.i();
            if (c14249hc1I != null) {
                c14249hc1I.a();
            }
            c14249hc1.a();
            if (!AbstractC13042fc3.d(null, null)) {
                c14249hc1.c(null);
            }
        }
        return null;
    }

    private final C7386Rm4 N() {
        C7386Rm4 c7386Rm4 = this.n;
        this.n = AbstractC19601qd6.d(null, 1, null);
        return c7386Rm4;
    }

    private final boolean O(PJ5 pj5, Object obj) {
        return p() && this.s.s1(pj5, obj);
    }

    private final void s(Object obj, boolean z) {
        Object objE = this.g.e(obj);
        if (objE == null) {
            return;
        }
        if (!(objE instanceof C7620Sm4)) {
            PJ5 pj5 = (PJ5) objE;
            if (AbstractC19601qd6.g(this.m, obj, pj5) || pj5.v(obj) == EnumC11036cd3.a) {
                return;
            }
            if (!pj5.w() || z) {
                this.h.h(pj5);
                return;
            } else {
                this.i.h(pj5);
                return;
            }
        }
        C7620Sm4 c7620Sm4 = (C7620Sm4) objE;
        Object[] objArr = c7620Sm4.b;
        long[] jArr = c7620Sm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        PJ5 pj52 = (PJ5) objArr[(i << 3) + i3];
                        if (!AbstractC19601qd6.g(this.m, obj, pj52) && pj52.v(obj) != EnumC11036cd3.a) {
                            if (!pj52.w() || z) {
                                this.h.h(pj52);
                            } else {
                                this.i.h(pj52);
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0178 A[EDGE_INSN: B:69:0x0178->B:221:0x010d BREAK  A[LOOP:13: B:59:0x013e->B:70:0x017a]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y(java.util.Set r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8225Vb1.y(java.util.Set, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z(ir.nasim.OI0 r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8225Vb1.z(ir.nasim.OI0):void");
    }

    public final C14249hc1 G() {
        return this.r;
    }

    public final C21850uE6 H() {
        return this.f;
    }

    public final void L(InterfaceC19404qI1 interfaceC19404qI1) {
        if (AbstractC19601qd6.e(this.g, interfaceC19404qI1)) {
            return;
        }
        AbstractC19601qd6.h(this.j, interfaceC19404qI1);
    }

    public final void M(Object obj, PJ5 pj5) {
        AbstractC19601qd6.g(this.g, obj, pj5);
    }

    public final void P() {
        synchronized (this.d) {
            E();
            C7386Rm4 c7386Rm4N = N();
            try {
                this.s.u1(c7386Rm4N);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Exception e) {
                this.n = c7386Rm4N;
                throw e;
            }
        }
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public boolean a() {
        return this.v;
    }

    @Override // ir.nasim.InterfaceC25123zm1, ir.nasim.RJ5
    public void b(Object obj) {
        PJ5 pj5G0;
        long[] jArr;
        long[] jArr2;
        int i;
        if (F() || (pj5G0 = this.s.G0()) == null) {
            return;
        }
        pj5G0.M(true);
        if (pj5G0.z(obj)) {
            return;
        }
        if (obj instanceof AbstractC15299jL6) {
            ((AbstractC15299jL6) obj).A(androidx.compose.runtime.snapshots.e.a(1));
        }
        AbstractC19601qd6.a(this.g, obj, pj5G0);
        if (obj instanceof InterfaceC19404qI1) {
            InterfaceC19404qI1 interfaceC19404qI1 = (InterfaceC19404qI1) obj;
            InterfaceC19404qI1.a aVarY = interfaceC19404qI1.y();
            AbstractC19601qd6.h(this.j, obj);
            AbstractC21192tG4 abstractC21192tG4B = aVarY.b();
            Object[] objArr = abstractC21192tG4B.b;
            long[] jArr3 = abstractC21192tG4B.a;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr3[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                InterfaceC14710iL6 interfaceC14710iL6 = (InterfaceC14710iL6) objArr[(i2 << 3) + i5];
                                if (interfaceC14710iL6 instanceof AbstractC15299jL6) {
                                    jArr2 = jArr3;
                                    ((AbstractC15299jL6) interfaceC14710iL6).A(androidx.compose.runtime.snapshots.e.a(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                AbstractC19601qd6.a(this.j, interfaceC14710iL6, obj);
                                i = 8;
                            } else {
                                jArr2 = jArr3;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr3 = jArr;
                }
            }
            pj5G0.y(interfaceC19404qI1, aVarY.a());
        }
    }

    @Override // ir.nasim.RJ5
    public void c(PJ5 pj5) {
        this.o = true;
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void d(AbstractC20278rk4 abstractC20278rk4) {
        UM5 um5 = new UM5(this.e);
        C24216yE6 c24216yE6W = abstractC20278rk4.a().W();
        try {
            AbstractC5138Ib1.L(c24216yE6W, um5);
            C19938rB7 c19938rB7 = C19938rB7.a;
            c24216yE6W.L(true);
            um5.j();
        } catch (Throwable th) {
            c24216yE6W.L(false);
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC24090y16
    public void deactivate() {
        synchronized (this.d) {
            try {
                boolean z = this.f.L() > 0;
                if (z || (!this.e.isEmpty())) {
                    C17398mt7 c17398mt7 = C17398mt7.a;
                    Object objA = c17398mt7.a("Compose:deactivate");
                    try {
                        UM5 um5 = new UM5(this.e);
                        if (z) {
                            this.b.j();
                            C24216yE6 c24216yE6W = this.f.W();
                            try {
                                AbstractC5138Ib1.u(c24216yE6W, um5);
                                C19938rB7 c19938rB7 = C19938rB7.a;
                                c24216yE6W.L(true);
                                this.b.e();
                                um5.j();
                            } catch (Throwable th) {
                                c24216yE6W.L(false);
                                throw th;
                            }
                        }
                        um5.h();
                        C19938rB7 c19938rB72 = C19938rB7.a;
                        c17398mt7.b(objA);
                    } catch (Throwable th2) {
                        C17398mt7.a.b(objA);
                        throw th2;
                    }
                }
                AbstractC19601qd6.b(this.g);
                AbstractC19601qd6.b(this.j);
                AbstractC19601qd6.b(this.n);
                this.k.a();
                this.l.a();
                this.s.r0();
                C19938rB7 c19938rB73 = C19938rB7.a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public void dispose() {
        synchronized (this.d) {
            try {
                if (!(!this.s.P0())) {
                    AbstractC5214Ij5.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.v) {
                    this.v = true;
                    this.w = C20462s31.a.b();
                    OI0 oi0H0 = this.s.H0();
                    if (oi0H0 != null) {
                        z(oi0H0);
                    }
                    boolean z = this.f.L() > 0;
                    if (z || (!this.e.isEmpty())) {
                        UM5 um5 = new UM5(this.e);
                        if (z) {
                            this.b.j();
                            C24216yE6 c24216yE6W = this.f.W();
                            try {
                                AbstractC5138Ib1.L(c24216yE6W, um5);
                                C19938rB7 c19938rB7 = C19938rB7.a;
                                c24216yE6W.L(true);
                                this.b.clear();
                                this.b.e();
                                um5.j();
                            } catch (Throwable th) {
                                c24216yE6W.L(false);
                                throw th;
                            }
                        }
                        um5.h();
                    }
                    this.s.s0();
                }
                C19938rB7 c19938rB72 = C19938rB7.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.a.r(this);
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void e() {
        synchronized (this.d) {
            try {
                if (this.l.d()) {
                    z(this.l);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.e.isEmpty()) {
                            new UM5(this.e).h();
                        }
                        throw th;
                    } catch (Exception e) {
                        u();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void f(List list) {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!AbstractC13042fc3.d(((C20869sk4) ((XV4) list.get(i)).e()).b(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            AbstractC5138Ib1.s("Check failed");
        }
        try {
            this.s.M0(list);
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void g(SA2 sa2) {
        this.s.U0(sa2);
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public boolean h() {
        boolean zW0;
        synchronized (this.d) {
            try {
                C();
                try {
                    C7386Rm4 c7386Rm4N = N();
                    try {
                        K();
                        zW0 = this.s.W0(c7386Rm4N, null);
                        if (!zW0) {
                            D();
                        }
                    } catch (Exception e) {
                        this.n = c7386Rm4N;
                        throw e;
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zW0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // ir.nasim.InterfaceC25123zm1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(java.util.Set r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof ir.nasim.C23844xc6
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            ir.nasim.xc6 r15 = (ir.nasim.C23844xc6) r15
            ir.nasim.vc6 r15 = r15.f()
            java.lang.Object[] r0 = r15.b
            long[] r15 = r15.a
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            ir.nasim.Rm4 r11 = r14.g
            boolean r11 = ir.nasim.AbstractC19601qd6.e(r11, r10)
            if (r11 != 0) goto L50
            ir.nasim.Rm4 r11 = r14.j
            boolean r10 = ir.nasim.AbstractC19601qd6.e(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            ir.nasim.Rm4 r3 = r14.g
            boolean r3 = ir.nasim.AbstractC19601qd6.e(r3, r0)
            if (r3 != 0) goto L7c
            ir.nasim.Rm4 r3 = r14.j
            boolean r0 = ir.nasim.AbstractC19601qd6.e(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8225Vb1.i(java.util.Set):boolean");
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public Object j(InterfaceC25123zm1 interfaceC25123zm1, int i, SA2 sa2) {
        if (interfaceC25123zm1 == null || AbstractC13042fc3.d(interfaceC25123zm1, this) || i < 0) {
            return sa2.invoke();
        }
        this.p = (C8225Vb1) interfaceC25123zm1;
        this.q = i;
        try {
            return sa2.invoke();
        } finally {
            this.p = null;
            this.q = 0;
        }
    }

    @Override // ir.nasim.RJ5
    public EnumC11036cd3 k(PJ5 pj5, Object obj) {
        C8225Vb1 c8225Vb1;
        if (pj5.k()) {
            pj5.F(true);
        }
        C6669Om c6669OmI = pj5.i();
        if (c6669OmI == null || !c6669OmI.b()) {
            return EnumC11036cd3.a;
        }
        if (this.f.Y(c6669OmI)) {
            return !pj5.j() ? EnumC11036cd3.a : I(pj5, c6669OmI, obj);
        }
        synchronized (this.d) {
            c8225Vb1 = this.p;
        }
        return (c8225Vb1 == null || !c8225Vb1.O(pj5, obj)) ? EnumC11036cd3.a : EnumC11036cd3.d;
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public void l(InterfaceC14603iB2 interfaceC14603iB2) {
        B(interfaceC14603iB2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // ir.nasim.InterfaceC25123zm1
    public void n(Set set) {
        Object obj;
        Set setE;
        do {
            obj = this.c.get();
            if (obj == null ? true : AbstractC13042fc3.d(obj, AbstractC8459Wb1.a)) {
                setE = set;
            } else if (obj instanceof Set) {
                setE = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.c).toString());
                }
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                setE = AbstractC9648aK.E((Set[]) obj, set);
            }
        } while (!AbstractC16775lq5.a(this.c, obj, setE));
        if (obj == null) {
            synchronized (this.d) {
                D();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void o() {
        synchronized (this.d) {
            try {
                z(this.k);
                D();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.e.isEmpty()) {
                            new UM5(this.e).h();
                        }
                        throw th;
                    } catch (Exception e) {
                        u();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public boolean p() {
        return this.s.P0();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    @Override // ir.nasim.InterfaceC25123zm1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.d
            monitor-enter(r0)
            r14.J(r15)     // Catch: java.lang.Throwable -> L4f
            ir.nasim.Rm4 r1 = r14.j     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.e(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof ir.nasim.C7620Sm4     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            ir.nasim.Sm4 r15 = (ir.nasim.C7620Sm4) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.b     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.a     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            ir.nasim.qI1 r10 = (ir.nasim.InterfaceC19404qI1) r10     // Catch: java.lang.Throwable -> L4f
            r14.J(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r15 = move-exception
            goto L65
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            ir.nasim.qI1 r15 = (ir.nasim.InterfaceC19404qI1) r15     // Catch: java.lang.Throwable -> L4f
            r14.J(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r0)
            return
        L65:
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8225Vb1.q(java.lang.Object):void");
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public boolean r() {
        boolean z;
        synchronized (this.d) {
            z = AbstractC19601qd6.f(this.n) > 0;
        }
        return z;
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void t(InterfaceC14603iB2 interfaceC14603iB2) {
        try {
            synchronized (this.d) {
                C();
                C7386Rm4 c7386Rm4N = N();
                try {
                    K();
                    this.s.m0(c7386Rm4N, interfaceC14603iB2, null);
                } catch (Exception e) {
                    this.n = c7386Rm4N;
                    throw e;
                }
            }
        } finally {
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void u() {
        this.c.set(null);
        this.k.a();
        this.l.a();
        if (!this.e.isEmpty()) {
            new UM5(this.e).h();
        }
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void v() {
        synchronized (this.d) {
            try {
                this.s.j0();
                if (!this.e.isEmpty()) {
                    new UM5(this.e).h();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.e.isEmpty()) {
                            new UM5(this.e).h();
                        }
                        throw th;
                    } catch (Exception e) {
                        u();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC24090y16
    public void w(InterfaceC14603iB2 interfaceC14603iB2) {
        this.s.q1();
        B(interfaceC14603iB2);
        this.s.x0();
    }

    @Override // ir.nasim.InterfaceC25123zm1
    public void x() {
        synchronized (this.d) {
            try {
                for (Object obj : this.f.N()) {
                    PJ5 pj5 = obj instanceof PJ5 ? (PJ5) obj : null;
                    if (pj5 != null) {
                        pj5.invalidate();
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ C8225Vb1(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC15247jG interfaceC15247jG, InterfaceC11938do1 interfaceC11938do1, int i, ED1 ed1) {
        this(abstractC7050Qb1, interfaceC15247jG, (i & 4) != 0 ? null : interfaceC11938do1);
    }
}
