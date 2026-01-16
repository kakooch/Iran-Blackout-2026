package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Od7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6591Od7 extends W57 {
    public String e;
    public long f;
    public long g;
    public String h;
    public int i;
    public ArrayList j = new ArrayList();
    public C18430oe7 k;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.e = t1.g(z);
        this.f = t1.f(z);
        this.g = t1.f(z);
        this.h = t1.g(z);
        this.i = t1.e(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            W57 w57D = W57.d(t1, t1.e(z), z);
            if (w57D == null) {
                return;
            }
            this.j.add(w57D);
        }
        this.k = C18430oe7.d(t1, t1.e(z), z);
    }
}
