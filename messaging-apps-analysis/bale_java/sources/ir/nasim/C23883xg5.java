package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.xg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23883xg5 implements BQ7 {
    public static final C23883xg5 a = new C23883xg5();

    private C23883xg5() {
    }

    @Override // ir.nasim.BQ7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(AbstractC11911dl3 abstractC11911dl3, float f) {
        AbstractC11911dl3.b bVarJ = abstractC11911dl3.j();
        if (bVarJ == AbstractC11911dl3.b.BEGIN_ARRAY) {
            return AbstractC20878sl3.e(abstractC11911dl3, f);
        }
        if (bVarJ == AbstractC11911dl3.b.BEGIN_OBJECT) {
            return AbstractC20878sl3.e(abstractC11911dl3, f);
        }
        if (bVarJ == AbstractC11911dl3.b.NUMBER) {
            PointF pointF = new PointF(((float) abstractC11911dl3.f1()) * f, ((float) abstractC11911dl3.f1()) * f);
            while (abstractC11911dl3.d()) {
                abstractC11911dl3.R();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarJ);
    }
}
