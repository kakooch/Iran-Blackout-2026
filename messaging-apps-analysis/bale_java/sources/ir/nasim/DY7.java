package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C20795sd0;
import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class DY7 extends C18931pV2 {
    private int X0 = 0;
    private int Y0 = 0;
    private int Z0 = 0;
    private int a1 = 0;
    private int b1 = 0;
    private int c1 = 0;
    private int d1 = 0;
    private int e1 = 0;
    private boolean f1 = false;
    private int g1 = 0;
    private int h1 = 0;
    protected C20795sd0.a i1 = new C20795sd0.a();
    C20795sd0.b j1 = null;

    public int A1() {
        return this.X0;
    }

    public abstract void B1(int i, int i2, int i3, int i4);

    protected void C1(C16651le1 c16651le1, C16651le1.b bVar, int i, C16651le1.b bVar2, int i2) {
        while (this.j1 == null && N() != null) {
            this.j1 = ((C17242me1) N()).H1();
        }
        C20795sd0.a aVar = this.i1;
        aVar.a = bVar;
        aVar.b = bVar2;
        aVar.c = i;
        aVar.d = i2;
        this.j1.b(c16651le1, aVar);
        c16651le1.j1(this.i1.e);
        c16651le1.K0(this.i1.f);
        c16651le1.J0(this.i1.h);
        c16651le1.z0(this.i1.g);
    }

    protected boolean D1() {
        C16651le1 c16651le1 = this.c0;
        C20795sd0.b bVarH1 = c16651le1 != null ? ((C17242me1) c16651le1).H1() : null;
        if (bVarH1 == null) {
            return false;
        }
        for (int i = 0; i < this.W0; i++) {
            C16651le1 c16651le12 = this.V0[i];
            if (c16651le12 != null && !(c16651le12 instanceof NS2)) {
                C16651le1.b bVarW = c16651le12.w(0);
                C16651le1.b bVarW2 = c16651le12.w(1);
                C16651le1.b bVar = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarW != bVar || c16651le12.w == 1 || bVarW2 != bVar || c16651le12.x == 1) {
                    if (bVarW == bVar) {
                        bVarW = C16651le1.b.WRAP_CONTENT;
                    }
                    if (bVarW2 == bVar) {
                        bVarW2 = C16651le1.b.WRAP_CONTENT;
                    }
                    C20795sd0.a aVar = this.i1;
                    aVar.a = bVarW;
                    aVar.b = bVarW2;
                    aVar.c = c16651le12.X();
                    this.i1.d = c16651le12.z();
                    bVarH1.b(c16651le12, this.i1);
                    c16651le12.j1(this.i1.e);
                    c16651le12.K0(this.i1.f);
                    c16651le12.z0(this.i1.g);
                }
            }
        }
        return true;
    }

    public boolean E1() {
        return this.f1;
    }

    protected void F1(boolean z) {
        this.f1 = z;
    }

    public void G1(int i, int i2) {
        this.g1 = i;
        this.h1 = i2;
    }

    public void H1(int i) {
        this.Z0 = i;
        this.X0 = i;
        this.a1 = i;
        this.Y0 = i;
        this.b1 = i;
        this.c1 = i;
    }

    public void I1(int i) {
        this.Y0 = i;
    }

    public void J1(int i) {
        this.c1 = i;
    }

    public void K1(int i) {
        this.Z0 = i;
        this.d1 = i;
    }

    public void L1(int i) {
        this.a1 = i;
        this.e1 = i;
    }

    public void M1(int i) {
        this.b1 = i;
        this.d1 = i;
        this.e1 = i;
    }

    public void N1(int i) {
        this.X0 = i;
    }

    @Override // ir.nasim.C18931pV2, ir.nasim.InterfaceC17158mV2
    public void b(C17242me1 c17242me1) {
        t1();
    }

    public void s1(boolean z) {
        int i = this.b1;
        if (i > 0 || this.c1 > 0) {
            if (z) {
                this.d1 = this.c1;
                this.e1 = i;
            } else {
                this.d1 = i;
                this.e1 = this.c1;
            }
        }
    }

    public void t1() {
        for (int i = 0; i < this.W0; i++) {
            C16651le1 c16651le1 = this.V0[i];
            if (c16651le1 != null) {
                c16651le1.T0(true);
            }
        }
    }

    public boolean u1(HashSet hashSet) {
        for (int i = 0; i < this.W0; i++) {
            if (hashSet.contains(this.V0[i])) {
                return true;
            }
        }
        return false;
    }

    public int v1() {
        return this.h1;
    }

    public int w1() {
        return this.g1;
    }

    public int x1() {
        return this.Y0;
    }

    public int y1() {
        return this.d1;
    }

    public int z1() {
        return this.e1;
    }
}
