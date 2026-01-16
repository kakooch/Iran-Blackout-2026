package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Pg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6857Pg7 extends AbstractC18470oi7 {
    public static int n = -1609668650;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public String h;
    public String i;
    public AbstractC18106o57 j;
    public ArrayList k = new ArrayList();
    public String l;
    public int m;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.e = (iE & 32) != 0;
        this.f = t1.f(z);
        this.g = t1.f(z);
        this.h = t1.g(z);
        this.i = t1.g(z);
        if ((this.b & 4) != 0) {
            this.j = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.b & 8) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                C7335Rg7 c7335Rg7E = C7335Rg7.e(t1, t1.e(z), z);
                if (c7335Rg7E == null) {
                    return;
                }
                this.k.add(c7335Rg7E);
            }
        }
        if ((this.b & 64) != 0) {
            this.l = t1.g(z);
        }
        if ((this.b & 16) != 0) {
            this.m = t1.e(z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(n);
        int i = this.c ? this.b | 1 : this.b & (-2);
        this.b = i;
        int i2 = this.d ? i | 2 : i & (-3);
        this.b = i2;
        int i3 = this.e ? i2 | 32 : i2 & (-33);
        this.b = i3;
        t1.m(i3);
        t1.n(this.f);
        t1.n(this.g);
        t1.o(this.h);
        t1.o(this.i);
        if ((this.b & 4) != 0) {
            this.j.c(t1);
        }
        if ((this.b & 8) != 0) {
            t1.m(481674261);
            int size = this.k.size();
            t1.m(size);
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC19061pi7) this.k.get(i4)).c(t1);
            }
        }
        if ((this.b & 64) != 0) {
            t1.o(this.l);
        }
        if ((this.b & 16) != 0) {
            t1.m(this.m);
        }
    }
}
