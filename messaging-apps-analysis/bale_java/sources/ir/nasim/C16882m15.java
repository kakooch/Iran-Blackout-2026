package ir.nasim;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* renamed from: ir.nasim.m15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16882m15 extends AbstractC25155zp3 {
    private final PointF i;
    private final float[] j;
    private final float[] k;
    private final PathMeasure l;
    private C16291l15 m;

    public C16882m15(List list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new float[2];
        this.l = new PathMeasure();
    }

    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(C24561yp3 c24561yp3, float f) {
        PointF pointF;
        C16291l15 c16291l15 = (C16291l15) c24561yp3;
        Path pathK = c16291l15.k();
        C13505gL3 c13505gL3 = this.e;
        if (c13505gL3 != null && c24561yp3.h != null && (pointF = (PointF) c13505gL3.b(c16291l15.g, c16291l15.h.floatValue(), (PointF) c16291l15.b, (PointF) c16291l15.c, e(), f, f())) != null) {
            return pointF;
        }
        if (pathK == null) {
            return (PointF) c24561yp3.b;
        }
        if (this.m != c16291l15) {
            this.l.setPath(pathK, false);
            this.m = c16291l15;
        }
        float length = this.l.getLength();
        float f2 = f * length;
        this.l.getPosTan(f2, this.j, this.k);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        if (f2 < 0.0f) {
            PointF pointF3 = this.i;
            float[] fArr2 = this.k;
            pointF3.offset(fArr2[0] * f2, fArr2[1] * f2);
        } else if (f2 > length) {
            PointF pointF4 = this.i;
            float[] fArr3 = this.k;
            float f3 = f2 - length;
            pointF4.offset(fArr3[0] * f3, fArr3[1] * f3);
        }
        return this.i;
    }
}
