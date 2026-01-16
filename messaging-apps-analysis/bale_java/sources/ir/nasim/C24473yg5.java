package ir.nasim;

import android.graphics.PointF;
import java.util.List;

/* renamed from: ir.nasim.yg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24473yg5 extends AbstractC25155zp3 {
    private final PointF i;

    public C24473yg5(List list) {
        super(list);
        this.i = new PointF();
    }

    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(C24561yp3 c24561yp3, float f) {
        return j(c24561yp3, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public PointF j(C24561yp3 c24561yp3, float f, float f2, float f3) {
        Object obj;
        PointF pointF;
        Object obj2 = c24561yp3.b;
        if (obj2 == null || (obj = c24561yp3.c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        C13505gL3 c13505gL3 = this.e;
        if (c13505gL3 != null && (pointF = (PointF) c13505gL3.b(c24561yp3.g, c24561yp3.h.floatValue(), pointF2, pointF3, f, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.i;
        float f4 = pointF2.x;
        float f5 = f4 + (f2 * (pointF3.x - f4));
        float f6 = pointF2.y;
        pointF4.set(f5, f6 + (f3 * (pointF3.y - f6)));
        return this.i;
    }
}
