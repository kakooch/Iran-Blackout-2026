package ir.nasim;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes6.dex */
public final class Pc8 implements ViewPager.j {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void a(View view, float f) {
        AbstractC13042fc3.i(view, "view");
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float f2 = 1;
        float fMax = Math.max(0.85f, f2 - Math.abs(f));
        float f3 = f2 - fMax;
        float f4 = 2;
        float f5 = (height * f3) / f4;
        float f6 = (width * f3) / f4;
        if (f < 0.0f) {
            view.setTranslationX(f6 - (f5 / f4));
        } else {
            view.setTranslationX((-f6) + (f5 / f4));
        }
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.setAlpha((((fMax - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
    }
}
