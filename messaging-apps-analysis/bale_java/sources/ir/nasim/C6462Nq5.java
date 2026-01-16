package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.OJ;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: ir.nasim.Nq5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6462Nq5 extends OJ {
    private int g;
    private EH6[] h;
    private EH6[] i;
    private int j;
    b k;
    C13196fp0 l;

    /* renamed from: ir.nasim.Nq5$a */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EH6 eh6, EH6 eh62) {
            return eh6.c - eh62.c;
        }
    }

    /* renamed from: ir.nasim.Nq5$b */
    class b {
        EH6 a;
        C6462Nq5 b;

        public b(C6462Nq5 c6462Nq5) {
            this.b = c6462Nq5;
        }

        public boolean a(EH6 eh6, float f) {
            boolean z = true;
            if (!this.a.a) {
                for (int i = 0; i < 9; i++) {
                    float f2 = eh6.i[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.a.i[i] = f3;
                    } else {
                        this.a.i[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.a.i;
                float f4 = fArr[i2] + (eh6.i[i2] * f);
                fArr[i2] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.a.i[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                C6462Nq5.this.G(this.a);
            }
            return false;
        }

        public void b(EH6 eh6) {
            this.a = eh6;
        }

        public final boolean c() {
            for (int i = 8; i >= 0; i--) {
                float f = this.a.i[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(EH6 eh6) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = eh6.i[i];
                float f2 = this.a.i[i];
                if (f2 == f) {
                    i--;
                } else if (f2 < f) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.a.i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.a.i[i] + Separators.SP;
                }
            }
            return str + "] " + this.a;
        }
    }

    public C6462Nq5(C13196fp0 c13196fp0) {
        super(c13196fp0);
        this.g = 128;
        this.h = new EH6[128];
        this.i = new EH6[128];
        this.j = 0;
        this.k = new b(this);
        this.l = c13196fp0;
    }

    private final void F(EH6 eh6) {
        int i;
        int i2 = this.j + 1;
        EH6[] eh6Arr = this.h;
        if (i2 > eh6Arr.length) {
            EH6[] eh6Arr2 = (EH6[]) Arrays.copyOf(eh6Arr, eh6Arr.length * 2);
            this.h = eh6Arr2;
            this.i = (EH6[]) Arrays.copyOf(eh6Arr2, eh6Arr2.length * 2);
        }
        EH6[] eh6Arr3 = this.h;
        int i3 = this.j;
        eh6Arr3[i3] = eh6;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && eh6Arr3[i3].c > eh6.c) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a());
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        eh6.a = true;
        eh6.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(EH6 eh6) {
        int i = 0;
        while (i < this.j) {
            if (this.h[i] == eh6) {
                while (true) {
                    int i2 = this.j;
                    if (i >= i2 - 1) {
                        this.j = i2 - 1;
                        eh6.a = false;
                        return;
                    } else {
                        EH6[] eh6Arr = this.h;
                        int i3 = i + 1;
                        eh6Arr[i] = eh6Arr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // ir.nasim.OJ
    public void B(C8963Xz3 c8963Xz3, OJ oj, boolean z) {
        EH6 eh6 = oj.a;
        if (eh6 == null) {
            return;
        }
        OJ.a aVar = oj.e;
        int iD = aVar.d();
        for (int i = 0; i < iD; i++) {
            EH6 eh6A = aVar.a(i);
            float f = aVar.f(i);
            this.k.b(eh6A);
            if (this.k.a(eh6, f)) {
                F(eh6A);
            }
            this.b += oj.b * f;
        }
        G(eh6);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // ir.nasim.OJ, ir.nasim.C8963Xz3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.EH6 b(ir.nasim.C8963Xz3 r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.j
            if (r0 >= r2) goto L32
            ir.nasim.EH6[] r2 = r4.h
            r2 = r2[r0]
            int r3 = r2.c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            ir.nasim.Nq5$b r3 = r4.k
            r3.b(r2)
            if (r1 != r5) goto L22
            ir.nasim.Nq5$b r2 = r4.k
            boolean r2 = r2.c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            ir.nasim.Nq5$b r2 = r4.k
            ir.nasim.EH6[] r3 = r4.h
            r3 = r3[r1]
            boolean r2 = r2.d(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            ir.nasim.EH6[] r5 = r4.h
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6462Nq5.b(ir.nasim.Xz3, boolean[]):ir.nasim.EH6");
    }

    @Override // ir.nasim.OJ, ir.nasim.C8963Xz3.a
    public void c(EH6 eh6) {
        this.k.b(eh6);
        this.k.e();
        eh6.i[eh6.e] = 1.0f;
        F(eh6);
    }

    @Override // ir.nasim.OJ, ir.nasim.C8963Xz3.a
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    @Override // ir.nasim.OJ, ir.nasim.C8963Xz3.a
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override // ir.nasim.OJ
    public String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.j; i++) {
            this.k.b(this.h[i]);
            str = str + this.k + Separators.SP;
        }
        return str;
    }
}
