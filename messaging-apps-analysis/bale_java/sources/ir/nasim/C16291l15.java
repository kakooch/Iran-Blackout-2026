package ir.nasim;

import android.graphics.Path;
import android.graphics.PointF;

/* renamed from: ir.nasim.l15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16291l15 extends C24561yp3 {
    private Path q;
    private final C24561yp3 r;

    public C16291l15(C23677xK3 c23677xK3, C24561yp3 c24561yp3) {
        super(c23677xK3, (PointF) c24561yp3.b, (PointF) c24561yp3.c, c24561yp3.d, c24561yp3.e, c24561yp3.f, c24561yp3.g, c24561yp3.h);
        this.r = c24561yp3;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.c;
        boolean z = (obj3 == null || (obj2 = this.b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.b;
        if (obj4 == null || (obj = this.c) == null || z) {
            return;
        }
        C24561yp3 c24561yp3 = this.r;
        this.q = AbstractC16500lN7.d((PointF) obj4, (PointF) obj, c24561yp3.o, c24561yp3.p);
    }

    Path k() {
        return this.q;
    }
}
