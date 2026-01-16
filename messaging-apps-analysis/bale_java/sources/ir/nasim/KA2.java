package ir.nasim;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class KA2 implements ViewPager2.k {
    private final List a;

    public KA2(List list) {
        AbstractC13042fc3.i(list, "fadingItems");
        this.a = list;
    }

    private final void b(View view, float f) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            View viewFindViewById = view.findViewById(((Number) it.next()).intValue());
            if (viewFindViewById != null) {
                viewFindViewById.setAlpha(f);
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.k
    public void a(View view, float f) {
        AbstractC13042fc3.i(view, "page");
        if (f <= -1.0f || f >= 1.0f) {
            b(view, 0.0f);
        } else {
            b(view, 1.0f - Math.abs(f));
        }
    }
}
