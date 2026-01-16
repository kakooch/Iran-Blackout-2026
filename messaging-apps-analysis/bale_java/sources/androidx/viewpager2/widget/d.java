package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes2.dex */
final class d extends ViewPager2.i {
    private final LinearLayoutManager a;
    private ViewPager2.k b;

    d(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.a.K(); i3++) {
            View viewJ = this.a.J(i3);
            if (viewJ == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.a.K())));
            }
            this.b.a(viewJ, (this.a.i0(viewJ) - i) + f2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i) {
    }

    ViewPager2.k d() {
        return this.b;
    }

    void e(ViewPager2.k kVar) {
        this.b = kVar;
    }
}
