package ir.nasim;

/* renamed from: ir.nasim.Ve7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8258Ve7 extends C8024Ue7 {
    public static int j = 1520986705;

    @Override // ir.nasim.C8024Ue7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.c = AbstractC20488s57.d(t1, t1.e(z), z);
        this.d = t1.e(z);
        this.e = t1.e(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            this.h.add(Integer.valueOf(t1.e(z)));
        }
        if (this.h.isEmpty()) {
            return;
        }
        this.f = ((Integer) this.h.get(r5.size() - 1)).intValue();
    }

    @Override // ir.nasim.C8024Ue7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(j);
        t1.o(this.b);
        this.c.c(t1);
        t1.m(this.d);
        t1.m(this.e);
        t1.m(481674261);
        int size = this.h.size();
        t1.m(size);
        for (int i = 0; i < size; i++) {
            t1.m(((Integer) this.h.get(i)).intValue());
        }
    }
}
