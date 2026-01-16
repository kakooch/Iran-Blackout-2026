package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class b extends ViewPager2.i {
    private final List a;

    b(int i) {
        this.a = new ArrayList(i);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).a(i);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i, float f, int i2) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).b(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).c(i);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    void d(ViewPager2.i iVar) {
        this.a.add(iVar);
    }

    void e(ViewPager2.i iVar) {
        this.a.remove(iVar);
    }
}
