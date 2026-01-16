package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.InterfaceC12473eg3;
import ir.nasim.RB5;

/* loaded from: classes2.dex */
class m implements InterfaceC12473eg3 {
    static final InterfaceC12473eg3 a = new m();

    m() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float fV = AbstractC12990fW7.v(childAt);
                if (fV > f) {
                    f = fV;
                }
            }
        }
        return f;
    }

    @Override // ir.nasim.InterfaceC12473eg3
    public void a(View view) {
        Object tag = view.getTag(RB5.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            AbstractC12990fW7.x0(view, ((Float) tag).floatValue());
        }
        view.setTag(RB5.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // ir.nasim.InterfaceC12473eg3
    public void b(View view) {
    }

    @Override // ir.nasim.InterfaceC12473eg3
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (z && view.getTag(RB5.item_touch_helper_previous_elevation) == null) {
            Float fValueOf = Float.valueOf(AbstractC12990fW7.v(view));
            AbstractC12990fW7.x0(view, e(recyclerView, view) + 1.0f);
            view.setTag(RB5.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // ir.nasim.InterfaceC12473eg3
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }
}
