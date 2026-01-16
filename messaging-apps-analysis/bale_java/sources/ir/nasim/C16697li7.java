package ir.nasim;

/* renamed from: ir.nasim.li7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16697li7 extends C11263ci7 {
    @Override // ir.nasim.C11263ci7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.f(z);
        this.d = t1.g(z);
        this.e = t1.g(z);
        this.f = t1.e(z);
        if ((this.b & 1) != 0) {
            this.g = t1.g(z);
        }
        if ((this.b & 2) != 0) {
            this.h = t1.g(z);
        }
        if ((this.b & 4) != 0) {
            this.i = t1.g(z);
        }
        if ((this.b & 8) != 0) {
            this.j = t1.g(z);
        }
        if ((this.b & 16) != 0) {
            this.k = AbstractC10736c67.d(t1, t1.e(z), z);
        }
        if ((this.b & 32) != 0) {
            this.l = t1.g(z);
        }
        if ((this.b & 32) != 0) {
            this.m = t1.g(z);
        }
        if ((this.b & 64) != 0) {
            this.n = t1.e(z);
        }
        if ((this.b & 64) != 0) {
            this.o = t1.e(z);
        }
        if ((this.b & 128) != 0) {
            this.p = t1.e(z);
        }
        if ((this.b & 256) != 0) {
            this.q = t1.g(z);
        }
        if ((this.b & 512) != 0) {
            this.r = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.b & 2048) != 0) {
            int iE = t1.e(z);
            if (iE != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
                }
                return;
            }
            C12497ei7 c12497ei7 = new C12497ei7();
            int iE2 = t1.e(z);
            for (int i = 0; i < iE2; i++) {
                AbstractC18106o57 abstractC18106o57D = AbstractC18106o57.d(t1, t1.e(z), z);
                if (abstractC18106o57D == null) {
                    return;
                }
                c12497ei7.c.add(abstractC18106o57D);
            }
            this.u.add(c12497ei7);
        }
        if ((this.b & 1024) != 0) {
            this.s = V57.d(t1, t1.e(z), z);
        }
    }
}
