package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C20795sd0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.me1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17242me1 extends AbstractC13401g98 {
    C20795sd0 W0;
    public C12858fI1 X0;
    private int Y0;
    protected C20795sd0.b Z0;
    private boolean a1;
    protected C8963Xz3 b1;
    int c1;
    int d1;
    int e1;
    int f1;
    public int g1;
    public int h1;
    C12248eI0[] i1;
    C12248eI0[] j1;
    public boolean k1;
    public boolean l1;
    public boolean m1;
    public int n1;
    public int o1;
    private int p1;
    public boolean q1;
    private boolean r1;
    private boolean s1;
    int t1;
    private WeakReference u1;
    private WeakReference v1;
    private WeakReference w1;
    private WeakReference x1;
    HashSet y1;
    public C20795sd0.a z1;

    public C17242me1() {
        this.W0 = new C20795sd0(this);
        this.X0 = new C12858fI1(this);
        this.Z0 = null;
        this.a1 = false;
        this.b1 = new C8963Xz3();
        this.g1 = 0;
        this.h1 = 0;
        this.i1 = new C12248eI0[4];
        this.j1 = new C12248eI0[4];
        this.k1 = false;
        this.l1 = false;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = 0;
        this.p1 = Type.CAA;
        this.q1 = false;
        this.r1 = false;
        this.s1 = false;
        this.t1 = 0;
        this.u1 = null;
        this.v1 = null;
        this.w1 = null;
        this.x1 = null;
        this.y1 = new HashSet();
        this.z1 = new C20795sd0.a();
    }

    private void A1(C8243Vd1 c8243Vd1, EH6 eh6) {
        this.b1.h(this.b1.q(c8243Vd1), eh6, 0, 5);
    }

    private void B1(C16651le1 c16651le1) {
        int i = this.h1 + 1;
        C12248eI0[] c12248eI0Arr = this.i1;
        if (i >= c12248eI0Arr.length) {
            this.i1 = (C12248eI0[]) Arrays.copyOf(c12248eI0Arr, c12248eI0Arr.length * 2);
        }
        this.i1[this.h1] = new C12248eI0(c16651le1, 1, O1());
        this.h1++;
    }

    public static boolean R1(int i, C16651le1 c16651le1, C20795sd0.b bVar, C20795sd0.a aVar, int i2) {
        int i3;
        int i4;
        if (bVar == null) {
            return false;
        }
        if (c16651le1.W() == 8 || (c16651le1 instanceof NS2) || (c16651le1 instanceof C11523d90)) {
            aVar.e = 0;
            aVar.f = 0;
            return false;
        }
        aVar.a = c16651le1.C();
        aVar.b = c16651le1.U();
        aVar.c = c16651le1.X();
        aVar.d = c16651le1.z();
        aVar.i = false;
        aVar.j = i2;
        C16651le1.b bVar2 = aVar.a;
        C16651le1.b bVar3 = C16651le1.b.MATCH_CONSTRAINT;
        boolean z = bVar2 == bVar3;
        boolean z2 = aVar.b == bVar3;
        boolean z3 = z && c16651le1.f0 > 0.0f;
        boolean z4 = z2 && c16651le1.f0 > 0.0f;
        if (z && c16651le1.b0(0) && c16651le1.w == 0 && !z3) {
            aVar.a = C16651le1.b.WRAP_CONTENT;
            if (z2 && c16651le1.x == 0) {
                aVar.a = C16651le1.b.FIXED;
            }
            z = false;
        }
        if (z2 && c16651le1.b0(1) && c16651le1.x == 0 && !z4) {
            aVar.b = C16651le1.b.WRAP_CONTENT;
            if (z && c16651le1.w == 0) {
                aVar.b = C16651le1.b.FIXED;
            }
            z2 = false;
        }
        if (c16651le1.o0()) {
            aVar.a = C16651le1.b.FIXED;
            z = false;
        }
        if (c16651le1.p0()) {
            aVar.b = C16651le1.b.FIXED;
            z2 = false;
        }
        if (z3) {
            if (c16651le1.y[0] == 4) {
                aVar.a = C16651le1.b.FIXED;
            } else if (!z2) {
                C16651le1.b bVar4 = aVar.b;
                C16651le1.b bVar5 = C16651le1.b.FIXED;
                if (bVar4 == bVar5) {
                    i4 = aVar.d;
                } else {
                    aVar.a = C16651le1.b.WRAP_CONTENT;
                    bVar.b(c16651le1, aVar);
                    i4 = aVar.f;
                }
                aVar.a = bVar5;
                aVar.c = (int) (c16651le1.x() * i4);
            }
        }
        if (z4) {
            if (c16651le1.y[1] == 4) {
                aVar.b = C16651le1.b.FIXED;
            } else if (!z) {
                C16651le1.b bVar6 = aVar.a;
                C16651le1.b bVar7 = C16651le1.b.FIXED;
                if (bVar6 == bVar7) {
                    i3 = aVar.c;
                } else {
                    aVar.b = C16651le1.b.WRAP_CONTENT;
                    bVar.b(c16651le1, aVar);
                    i3 = aVar.e;
                }
                aVar.b = bVar7;
                if (c16651le1.y() == -1) {
                    aVar.d = (int) (i3 / c16651le1.x());
                } else {
                    aVar.d = (int) (c16651le1.x() * i3);
                }
            }
        }
        bVar.b(c16651le1, aVar);
        c16651le1.j1(aVar.e);
        c16651le1.K0(aVar.f);
        c16651le1.J0(aVar.h);
        c16651le1.z0(aVar.g);
        aVar.j = C20795sd0.a.k;
        return aVar.i;
    }

    private void T1() {
        this.g1 = 0;
        this.h1 = 0;
    }

    private void w1(C16651le1 c16651le1) {
        int i = this.g1 + 1;
        C12248eI0[] c12248eI0Arr = this.j1;
        if (i >= c12248eI0Arr.length) {
            this.j1 = (C12248eI0[]) Arrays.copyOf(c12248eI0Arr, c12248eI0Arr.length * 2);
        }
        this.j1[this.g1] = new C12248eI0(c16651le1, 0, O1());
        this.g1++;
    }

    private void z1(C8243Vd1 c8243Vd1, EH6 eh6) {
        this.b1.h(eh6, this.b1.q(c8243Vd1), 0, 5);
    }

    void C1(C8243Vd1 c8243Vd1) {
        WeakReference weakReference = this.w1;
        if (weakReference == null || weakReference.get() == null || c8243Vd1.e() > ((C8243Vd1) this.w1.get()).e()) {
            this.w1 = new WeakReference(c8243Vd1);
        }
    }

    void D1(C8243Vd1 c8243Vd1) {
        WeakReference weakReference = this.u1;
        if (weakReference == null || weakReference.get() == null || c8243Vd1.e() > ((C8243Vd1) this.u1.get()).e()) {
            this.u1 = new WeakReference(c8243Vd1);
        }
    }

    public boolean E1(boolean z) {
        return this.X0.f(z);
    }

    public boolean F1(boolean z) {
        return this.X0.g(z);
    }

    public boolean G1(boolean z, int i) {
        return this.X0.h(z, i);
    }

    public C20795sd0.b H1() {
        return this.Z0;
    }

    public int I1() {
        return this.p1;
    }

    public C8963Xz3 J1() {
        return this.b1;
    }

    public boolean K1() {
        return false;
    }

    public void L1() {
        this.X0.j();
    }

    public void M1() {
        this.X0.k();
    }

    public boolean N1() {
        return this.s1;
    }

    public boolean O1() {
        return this.a1;
    }

    public boolean P1() {
        return this.r1;
    }

    public long Q1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.c1 = i8;
        this.d1 = i9;
        return this.W0.d(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean S1(int i) {
        return (this.p1 & i) == i;
    }

    public void U1(C20795sd0.b bVar) {
        this.Z0 = bVar;
        this.X0.n(bVar);
    }

    public void V1(int i) {
        this.p1 = i;
        C8963Xz3.r = S1(512);
    }

    public void W1(int i) {
        this.Y0 = i;
    }

    public void X1(boolean z) {
        this.a1 = z;
    }

    public boolean Y1(C8963Xz3 c8963Xz3, boolean[] zArr) {
        zArr[2] = false;
        boolean zS1 = S1(64);
        p1(c8963Xz3, zS1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C16651le1 c16651le1 = (C16651le1) this.V0.get(i);
            c16651le1.p1(c8963Xz3, zS1);
            if (c16651le1.d0()) {
                z = true;
            }
        }
        return z;
    }

    public void Z1() {
        this.W0.e(this);
    }

    @Override // ir.nasim.C16651le1
    public void o1(boolean z, boolean z2) {
        super.o1(z, z2);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((C16651le1) this.V0.get(i)).o1(z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0307 A[PHI: r2 r16
      0x0307: PHI (r2v15 boolean) = (r2v14 boolean), (r2v19 boolean), (r2v19 boolean), (r2v19 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]
      0x0307: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // ir.nasim.AbstractC13401g98
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r1() {
        /*
            Method dump skipped, instructions count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17242me1.r1():void");
    }

    @Override // ir.nasim.AbstractC13401g98, ir.nasim.C16651le1
    public void u0() {
        this.b1.D();
        this.c1 = 0;
        this.e1 = 0;
        this.d1 = 0;
        this.f1 = 0;
        this.q1 = false;
        super.u0();
    }

    void u1(C16651le1 c16651le1, int i) {
        if (i == 0) {
            w1(c16651le1);
        } else if (i == 1) {
            B1(c16651le1);
        }
    }

    public boolean v1(C8963Xz3 c8963Xz3) {
        boolean zS1 = S1(64);
        g(c8963Xz3, zS1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C16651le1 c16651le1 = (C16651le1) this.V0.get(i);
            c16651le1.R0(0, false);
            c16651le1.R0(1, false);
            if (c16651le1 instanceof C11523d90) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                C16651le1 c16651le12 = (C16651le1) this.V0.get(i2);
                if (c16651le12 instanceof C11523d90) {
                    ((C11523d90) c16651le12).x1();
                }
            }
        }
        this.y1.clear();
        for (int i3 = 0; i3 < size; i3++) {
            C16651le1 c16651le13 = (C16651le1) this.V0.get(i3);
            if (c16651le13.f()) {
                if (c16651le13 instanceof DY7) {
                    this.y1.add(c16651le13);
                } else {
                    c16651le13.g(c8963Xz3, zS1);
                }
            }
        }
        while (this.y1.size() > 0) {
            int size2 = this.y1.size();
            Iterator it = this.y1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DY7 dy7 = (DY7) ((C16651le1) it.next());
                if (dy7.u1(this.y1)) {
                    dy7.g(c8963Xz3, zS1);
                    this.y1.remove(dy7);
                    break;
                }
            }
            if (size2 == this.y1.size()) {
                Iterator it2 = this.y1.iterator();
                while (it2.hasNext()) {
                    ((C16651le1) it2.next()).g(c8963Xz3, zS1);
                }
                this.y1.clear();
            }
        }
        if (C8963Xz3.r) {
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < size; i4++) {
                C16651le1 c16651le14 = (C16651le1) this.V0.get(i4);
                if (!c16651le14.f()) {
                    hashSet.add(c16651le14);
                }
            }
            e(this, c8963Xz3, hashSet, C() == C16651le1.b.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                C16651le1 c16651le15 = (C16651le1) it3.next();
                AbstractC22501vL4.a(this, c8963Xz3, c16651le15);
                c16651le15.g(c8963Xz3, zS1);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                C16651le1 c16651le16 = (C16651le1) this.V0.get(i5);
                if (c16651le16 instanceof C17242me1) {
                    C16651le1.b[] bVarArr = c16651le16.b0;
                    C16651le1.b bVar = bVarArr[0];
                    C16651le1.b bVar2 = bVarArr[1];
                    C16651le1.b bVar3 = C16651le1.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        c16651le16.O0(C16651le1.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        c16651le16.f1(C16651le1.b.FIXED);
                    }
                    c16651le16.g(c8963Xz3, zS1);
                    if (bVar == bVar3) {
                        c16651le16.O0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        c16651le16.f1(bVar2);
                    }
                } else {
                    AbstractC22501vL4.a(this, c8963Xz3, c16651le16);
                    if (!c16651le16.f()) {
                        c16651le16.g(c8963Xz3, zS1);
                    }
                }
            }
        }
        if (this.g1 > 0) {
            AbstractC11605dI0.b(this, c8963Xz3, null, 0);
        }
        if (this.h1 > 0) {
            AbstractC11605dI0.b(this, c8963Xz3, null, 1);
        }
        return true;
    }

    public void x1(C8243Vd1 c8243Vd1) {
        WeakReference weakReference = this.x1;
        if (weakReference == null || weakReference.get() == null || c8243Vd1.e() > ((C8243Vd1) this.x1.get()).e()) {
            this.x1 = new WeakReference(c8243Vd1);
        }
    }

    public void y1(C8243Vd1 c8243Vd1) {
        WeakReference weakReference = this.v1;
        if (weakReference == null || weakReference.get() == null || c8243Vd1.e() > ((C8243Vd1) this.v1.get()).e()) {
            this.v1 = new WeakReference(c8243Vd1);
        }
    }

    public C17242me1(int i, int i2) {
        super(i, i2);
        this.W0 = new C20795sd0(this);
        this.X0 = new C12858fI1(this);
        this.Z0 = null;
        this.a1 = false;
        this.b1 = new C8963Xz3();
        this.g1 = 0;
        this.h1 = 0;
        this.i1 = new C12248eI0[4];
        this.j1 = new C12248eI0[4];
        this.k1 = false;
        this.l1 = false;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = 0;
        this.p1 = Type.CAA;
        this.q1 = false;
        this.r1 = false;
        this.s1 = false;
        this.t1 = 0;
        this.u1 = null;
        this.v1 = null;
        this.w1 = null;
        this.x1 = null;
        this.y1 = new HashSet();
        this.z1 = new C20795sd0.a();
    }
}
