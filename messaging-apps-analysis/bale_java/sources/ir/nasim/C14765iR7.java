package ir.nasim;

/* renamed from: ir.nasim.iR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14765iR7 implements InterfaceC10929cR7 {
    private final AbstractC18977pa3 a;
    private final AbstractC20768sa3 b;
    private final int c;
    private final int d;
    private final K22 e;
    private final int f;
    private int[] g;
    private float[] h;
    private AbstractC8151Ut i;
    private AbstractC8151Ut j;
    private AbstractC8151Ut k;
    private AbstractC8151Ut l;
    private float[] m;
    private float[] n;
    private PI o;

    public /* synthetic */ C14765iR7(AbstractC18977pa3 abstractC18977pa3, AbstractC20768sa3 abstractC20768sa3, int i, int i2, K22 k22, int i3, ED1 ed1) {
        this(abstractC18977pa3, abstractC20768sa3, i, i2, k22, i3);
    }

    private final int h(int i) {
        int iB = AbstractC18977pa3.b(this.a, i, 0, 0, 6, null);
        return iB < -1 ? -(iB + 2) : iB;
    }

    private final float i(int i) {
        return j(h(i), i, false);
    }

    private final float j(int i, int i2, boolean z) {
        K22 k22B;
        float f;
        AbstractC18977pa3 abstractC18977pa3 = this.a;
        if (i >= abstractC18977pa3.b - 1) {
            f = i2;
        } else {
            int iE = abstractC18977pa3.e(i);
            int iE2 = this.a.e(i + 1);
            if (i2 == iE) {
                f = iE;
            } else {
                int i3 = iE2 - iE;
                C14154hR7 c14154hR7 = (C14154hR7) this.b.b(iE);
                if (c14154hR7 == null || (k22B = c14154hR7.b()) == null) {
                    k22B = this.e;
                }
                float f2 = i3;
                float fA = k22B.a((i2 - iE) / f2);
                if (z) {
                    return fA;
                }
                f = (f2 * fA) + iE;
            }
        }
        return f / 1000;
    }

    private final void k(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        float[] fArr;
        boolean z = this.o != AbstractC9719aR7.c;
        if (this.i == null) {
            this.i = AbstractC8385Vt.g(abstractC8151Ut);
            this.j = AbstractC8385Vt.g(abstractC8151Ut3);
            int i = this.a.b;
            float[] fArr2 = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr2[i2] = this.a.e(i2) / 1000;
            }
            this.h = fArr2;
            int i3 = this.a.b;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                C14154hR7 c14154hR7 = (C14154hR7) this.b.b(this.a.e(i4));
                int iA = c14154hR7 != null ? c14154hR7.a() : this.f;
                if (!OI.c(iA, OI.a.a())) {
                    z = true;
                }
                iArr[i4] = iA;
            }
            this.g = iArr;
        }
        if (z) {
            if (this.o != AbstractC9719aR7.c && AbstractC13042fc3.d(this.k, abstractC8151Ut) && AbstractC13042fc3.d(this.l, abstractC8151Ut2)) {
                return;
            }
            this.k = abstractC8151Ut;
            this.l = abstractC8151Ut2;
            int iB = (abstractC8151Ut.b() % 2) + abstractC8151Ut.b();
            this.m = new float[iB];
            this.n = new float[iB];
            int i5 = this.a.b;
            float[][] fArr3 = new float[i5][];
            for (int i6 = 0; i6 < i5; i6++) {
                int iE = this.a.e(i6);
                C14154hR7 c14154hR72 = (C14154hR7) this.b.b(iE);
                if (iE == 0 && c14154hR72 == null) {
                    fArr = new float[iB];
                    for (int i7 = 0; i7 < iB; i7++) {
                        fArr[i7] = abstractC8151Ut.a(i7);
                    }
                } else if (iE == e() && c14154hR72 == null) {
                    fArr = new float[iB];
                    for (int i8 = 0; i8 < iB; i8++) {
                        fArr[i8] = abstractC8151Ut2.a(i8);
                    }
                } else {
                    AbstractC13042fc3.f(c14154hR72);
                    AbstractC8151Ut abstractC8151UtC = c14154hR72.c();
                    float[] fArr4 = new float[iB];
                    for (int i9 = 0; i9 < iB; i9++) {
                        fArr4[i9] = abstractC8151UtC.a(i9);
                    }
                    fArr = fArr4;
                }
                fArr3[i6] = fArr;
            }
            this.o = new PI(this.g, this.h, fArr3);
        }
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        AbstractC8151Ut abstractC8151UtC;
        AbstractC8151Ut abstractC8151UtC2;
        int iE = (int) AbstractC9719aR7.e(this, j / 1000000);
        C14154hR7 c14154hR7 = (C14154hR7) this.b.b(iE);
        if (c14154hR7 != null) {
            return c14154hR7.c();
        }
        if (iE >= e()) {
            return abstractC8151Ut2;
        }
        if (iE <= 0) {
            return abstractC8151Ut;
        }
        k(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
        AbstractC8151Ut abstractC8151Ut4 = this.i;
        AbstractC13042fc3.f(abstractC8151Ut4);
        int i = 0;
        if (this.o != AbstractC9719aR7.c) {
            float fI = i(iE);
            float[] fArr = this.m;
            this.o.a(fI, fArr);
            int length = fArr.length;
            while (i < length) {
                abstractC8151Ut4.e(i, fArr[i]);
                i++;
            }
            return abstractC8151Ut4;
        }
        int iH = h(iE);
        float fJ = j(iH, iE, true);
        C14154hR7 c14154hR72 = (C14154hR7) this.b.b(this.a.e(iH));
        if (c14154hR72 != null && (abstractC8151UtC2 = c14154hR72.c()) != null) {
            abstractC8151Ut = abstractC8151UtC2;
        }
        C14154hR7 c14154hR73 = (C14154hR7) this.b.b(this.a.e(iH + 1));
        if (c14154hR73 != null && (abstractC8151UtC = c14154hR73.c()) != null) {
            abstractC8151Ut2 = abstractC8151UtC;
        }
        int iB = abstractC8151Ut4.b();
        while (i < iB) {
            abstractC8151Ut4.e(i, (abstractC8151Ut.a(i) * (1 - fJ)) + (abstractC8151Ut2.a(i) * fJ));
            i++;
        }
        return abstractC8151Ut4;
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int d() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int e() {
        return this.c;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        long jE = AbstractC9719aR7.e(this, j / 1000000);
        if (jE < 0) {
            return abstractC8151Ut3;
        }
        k(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
        AbstractC8151Ut abstractC8151Ut4 = this.j;
        AbstractC13042fc3.f(abstractC8151Ut4);
        int i = 0;
        if (this.o == AbstractC9719aR7.c) {
            AbstractC8151Ut abstractC8151UtG = AbstractC9719aR7.g(this, jE - 1, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
            AbstractC8151Ut abstractC8151UtG2 = AbstractC9719aR7.g(this, jE, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
            int iB = abstractC8151UtG.b();
            while (i < iB) {
                abstractC8151Ut4.e(i, (abstractC8151UtG.a(i) - abstractC8151UtG2.a(i)) * 1000.0f);
                i++;
            }
            return abstractC8151Ut4;
        }
        float fI = i((int) jE);
        float[] fArr = this.n;
        this.o.b(fI, fArr);
        int length = fArr.length;
        while (i < length) {
            abstractC8151Ut4.e(i, fArr[i]);
            i++;
        }
        return abstractC8151Ut4;
    }

    private C14765iR7(AbstractC18977pa3 abstractC18977pa3, AbstractC20768sa3 abstractC20768sa3, int i, int i2, K22 k22, int i3) {
        this.a = abstractC18977pa3;
        this.b = abstractC20768sa3;
        this.c = i;
        this.d = i2;
        this.e = k22;
        this.f = i3;
        this.g = AbstractC9719aR7.a;
        this.h = AbstractC9719aR7.b;
        this.m = AbstractC9719aR7.b;
        this.n = AbstractC9719aR7.b;
        this.o = AbstractC9719aR7.c;
    }
}
