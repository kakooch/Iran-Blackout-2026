package ir.nasim;

import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public abstract class EK5 {
    public static final Rect a(C25005za3 c25005za3) {
        return new Rect(c25005za3.g(), c25005za3.j(), c25005za3.h(), c25005za3.d());
    }

    public static final Rect b(CK5 ck5) {
        return new Rect((int) ck5.i(), (int) ck5.l(), (int) ck5.j(), (int) ck5.e());
    }

    public static final RectF c(CK5 ck5) {
        return new RectF(ck5.i(), ck5.l(), ck5.j(), ck5.e());
    }

    public static final C25005za3 d(Rect rect) {
        return new C25005za3(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static final CK5 e(Rect rect) {
        return new CK5(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static final CK5 f(RectF rectF) {
        return new CK5(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
