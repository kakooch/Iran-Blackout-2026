package ir.nasim;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: ir.nasim.zf2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C25054zf2 implements ViewPager.j {
    @Override // androidx.viewpager.widget.ViewPager.j
    public void a(View view, float f) {
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f <= 0.0f || f <= 1.0f) {
            view.setAlpha(f <= 0.0f ? f + 1.0f : 1.0f - f);
        } else if (f == 0.0f) {
            view.setAlpha(1.0f);
        }
    }
}
