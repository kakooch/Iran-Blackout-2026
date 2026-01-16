package ir.nasim;

import ir.nasim.C16651le1;
import java.util.ArrayList;

/* renamed from: ir.nasim.eI0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12248eI0 {
    protected C16651le1 a;
    protected C16651le1 b;
    protected C16651le1 c;
    protected C16651le1 d;
    protected C16651le1 e;
    protected C16651le1 f;
    protected C16651le1 g;
    protected ArrayList h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public C12248eI0(C16651le1 c16651le1, int i, boolean z) {
        this.a = c16651le1;
        this.p = i;
        this.q = z;
    }

    private void b() {
        int i = this.p * 2;
        C16651le1 c16651le1 = this.a;
        this.o = true;
        C16651le1 c16651le12 = c16651le1;
        boolean z = false;
        while (!z) {
            this.i++;
            C16651le1[] c16651le1Arr = c16651le1.P0;
            int i2 = this.p;
            C16651le1 c16651le13 = null;
            c16651le1Arr[i2] = null;
            c16651le1.O0[i2] = null;
            if (c16651le1.W() != 8) {
                this.l++;
                C16651le1.b bVarW = c16651le1.w(this.p);
                C16651le1.b bVar = C16651le1.b.MATCH_CONSTRAINT;
                if (bVarW != bVar) {
                    this.m += c16651le1.H(this.p);
                }
                int iF = this.m + c16651le1.Y[i].f();
                this.m = iF;
                int i3 = i + 1;
                this.m = iF + c16651le1.Y[i3].f();
                int iF2 = this.n + c16651le1.Y[i].f();
                this.n = iF2;
                this.n = iF2 + c16651le1.Y[i3].f();
                if (this.b == null) {
                    this.b = c16651le1;
                }
                this.d = c16651le1;
                C16651le1.b[] bVarArr = c16651le1.b0;
                int i4 = this.p;
                if (bVarArr[i4] == bVar) {
                    int i5 = c16651le1.y[i4];
                    if (i5 == 0 || i5 == 3 || i5 == 2) {
                        this.j++;
                        float f = c16651le1.N0[i4];
                        if (f > 0.0f) {
                            this.k += f;
                        }
                        if (c(c16651le1, i4)) {
                            if (f < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add(c16651le1);
                        }
                        if (this.f == null) {
                            this.f = c16651le1;
                        }
                        C16651le1 c16651le14 = this.g;
                        if (c16651le14 != null) {
                            c16651le14.O0[this.p] = c16651le1;
                        }
                        this.g = c16651le1;
                    }
                    if (this.p == 0) {
                        if (c16651le1.w != 0 || c16651le1.z != 0 || c16651le1.A != 0) {
                            this.o = false;
                        }
                    } else if (c16651le1.x != 0 || c16651le1.C != 0 || c16651le1.D != 0) {
                        this.o = false;
                    }
                    if (c16651le1.f0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (c16651le12 != c16651le1) {
                c16651le12.P0[this.p] = c16651le1;
            }
            C8243Vd1 c8243Vd1 = c16651le1.Y[i + 1].f;
            if (c8243Vd1 != null) {
                C16651le1 c16651le15 = c8243Vd1.d;
                C8243Vd1 c8243Vd12 = c16651le15.Y[i].f;
                if (c8243Vd12 != null && c8243Vd12.d == c16651le1) {
                    c16651le13 = c16651le15;
                }
            }
            if (c16651le13 == null) {
                c16651le13 = c16651le1;
                z = true;
            }
            c16651le12 = c16651le1;
            c16651le1 = c16651le13;
        }
        C16651le1 c16651le16 = this.b;
        if (c16651le16 != null) {
            this.m -= c16651le16.Y[i].f();
        }
        C16651le1 c16651le17 = this.d;
        if (c16651le17 != null) {
            this.m -= c16651le17.Y[i + 1].f();
        }
        this.c = c16651le1;
        if (this.p == 0 && this.q) {
            this.e = c16651le1;
        } else {
            this.e = this.a;
        }
        this.t = this.s && this.r;
    }

    private static boolean c(C16651le1 c16651le1, int i) {
        int i2;
        return c16651le1.W() != 8 && c16651le1.b0[i] == C16651le1.b.MATCH_CONSTRAINT && ((i2 = c16651le1.y[i]) == 0 || i2 == 3);
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
