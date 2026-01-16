package ir.nasim;

import ir.nasim.InterfaceC19684qm;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class UB1 implements InterfaceC19684qm {
    private final boolean a;
    private final int b;
    private final byte[] c;
    private int d;
    private int e;
    private int f;
    private C19093pm[] g;

    public UB1(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // ir.nasim.InterfaceC19684qm
    public synchronized void a(C19093pm c19093pm) {
        C19093pm[] c19093pmArr = this.g;
        int i = this.f;
        this.f = i + 1;
        c19093pmArr[i] = c19093pm;
        this.e--;
        notifyAll();
    }

    @Override // ir.nasim.InterfaceC19684qm
    public synchronized C19093pm b() {
        C19093pm c19093pm;
        try {
            this.e++;
            int i = this.f;
            if (i > 0) {
                C19093pm[] c19093pmArr = this.g;
                int i2 = i - 1;
                this.f = i2;
                c19093pm = (C19093pm) AbstractC20011rK.e(c19093pmArr[i2]);
                this.g[this.f] = null;
            } else {
                c19093pm = new C19093pm(new byte[this.b], 0);
                int i3 = this.e;
                C19093pm[] c19093pmArr2 = this.g;
                if (i3 > c19093pmArr2.length) {
                    this.g = (C19093pm[]) Arrays.copyOf(c19093pmArr2, c19093pmArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return c19093pm;
    }

    @Override // ir.nasim.InterfaceC19684qm
    public synchronized void c(InterfaceC19684qm.a aVar) {
        while (aVar != null) {
            try {
                C19093pm[] c19093pmArr = this.g;
                int i = this.f;
                this.f = i + 1;
                c19093pmArr[i] = aVar.a();
                this.e--;
                aVar = aVar.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // ir.nasim.InterfaceC19684qm
    public synchronized void d() {
        try {
            int i = 0;
            int iMax = Math.max(0, AbstractC9683aN7.l(this.d, this.b) - this.e);
            int i2 = this.f;
            if (iMax >= i2) {
                return;
            }
            if (this.c != null) {
                int i3 = i2 - 1;
                while (i <= i3) {
                    C19093pm c19093pm = (C19093pm) AbstractC20011rK.e(this.g[i]);
                    if (c19093pm.a == this.c) {
                        i++;
                    } else {
                        C19093pm c19093pm2 = (C19093pm) AbstractC20011rK.e(this.g[i3]);
                        if (c19093pm2.a != this.c) {
                            i3--;
                        } else {
                            C19093pm[] c19093pmArr = this.g;
                            c19093pmArr[i] = c19093pm2;
                            c19093pmArr[i3] = c19093pm;
                            i3--;
                            i++;
                        }
                    }
                }
                iMax = Math.max(iMax, i);
                if (iMax >= this.f) {
                    return;
                }
            }
            Arrays.fill(this.g, iMax, this.f, (Object) null);
            this.f = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC19684qm
    public int e() {
        return this.b;
    }

    public synchronized int f() {
        return this.e * this.b;
    }

    public synchronized void g() {
        if (this.a) {
            h(0);
        }
    }

    public synchronized void h(int i) {
        boolean z = i < this.d;
        this.d = i;
        if (z) {
            d();
        }
    }

    public UB1(boolean z, int i, int i2) {
        AbstractC20011rK.a(i > 0);
        AbstractC20011rK.a(i2 >= 0);
        this.a = z;
        this.b = i;
        this.f = i2;
        this.g = new C19093pm[i2 + 100];
        if (i2 <= 0) {
            this.c = null;
            return;
        }
        this.c = new byte[i2 * i];
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3] = new C19093pm(this.c, i3 * i);
        }
    }
}
