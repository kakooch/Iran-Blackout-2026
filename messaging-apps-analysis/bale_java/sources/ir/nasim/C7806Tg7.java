package ir.nasim;

/* renamed from: ir.nasim.Tg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7806Tg7 extends AbstractC19061pi7 {
    public static int i = -1917524116;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 4) != 0;
        this.d = AbstractC14549i57.d(t1, t1.e(z), z);
        this.e = t1.e(z);
        if ((this.b & 1) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            } else {
                int iE3 = t1.e(z);
                for (int i2 = 0; i2 < iE3; i2++) {
                    this.g.add(Integer.valueOf(t1.e(z)));
                }
            }
        }
        if ((this.b & 2) != 0) {
            this.h = AbstractC23315wi7.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(i);
        int i2 = this.c ? this.b | 4 : this.b & (-5);
        this.b = i2;
        t1.m(i2);
        this.d.c(t1);
        t1.m(this.e);
        if ((this.b & 1) != 0) {
            t1.m(481674261);
            int size = this.g.size();
            t1.m(size);
            for (int i3 = 0; i3 < size; i3++) {
                t1.m(((Integer) this.g.get(i3)).intValue());
            }
        }
        if ((this.b & 2) != 0) {
            this.h.c(t1);
        }
    }
}
