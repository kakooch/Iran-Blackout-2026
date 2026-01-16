package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.z87, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24751z87 extends AbstractC3554Bi7 {
    public static int k = -860107216;
    public int b;
    public boolean c;
    public int d;
    public String e;
    public String f;
    public ArrayList g = new ArrayList();
    public AbstractC18106o57 h;
    public String i;
    public AbstractC18106o57 j;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = t1.e(z);
        this.e = t1.g(z);
        this.f = t1.g(z);
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            N57 n57D = N57.d(t1, t1.e(z), z);
            if (n57D == null) {
                return;
            }
            this.g.add(n57D);
        }
        if ((this.b & 2) != 0) {
            this.h = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.b & 4) != 0) {
            this.i = t1.g(z);
        }
        if ((this.b & 8) != 0) {
            this.j = AbstractC18106o57.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(k);
        int i = this.c ? this.b | 1 : this.b & (-2);
        this.b = i;
        t1.m(i);
        t1.m(this.d);
        t1.o(this.e);
        t1.o(this.f);
        t1.m(481674261);
        int size = this.g.size();
        t1.m(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((N57) this.g.get(i2)).c(t1);
        }
        if ((this.b & 2) != 0) {
            this.h.c(t1);
        }
        if ((this.b & 4) != 0) {
            t1.o(this.i);
        }
        if ((this.b & 8) != 0) {
            this.j.c(t1);
        }
    }
}
