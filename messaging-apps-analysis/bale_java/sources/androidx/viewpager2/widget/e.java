package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes2.dex */
final class e extends RecyclerView.t {
    private ViewPager2.i a;
    private final ViewPager2 b;
    private final RecyclerView c;
    private final LinearLayoutManager d;
    private int e;
    private int f;
    private a g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    private static final class a {
        int a;
        float b;
        int c;

        a() {
        }

        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.g = new a();
        q();
    }

    private void c(int i, float f, int i2) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.b(i, f, i2);
        }
    }

    private void d(int i) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.c(i);
        }
    }

    private void e(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.a(i);
        }
    }

    private int f() {
        return this.d.d2();
    }

    private boolean l() {
        int i = this.e;
        return i == 1 || i == 4;
    }

    private void q() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    private void s(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = f();
        }
        e(1);
    }

    private void t() {
        int top;
        a aVar = this.g;
        int iD2 = this.d.d2();
        aVar.a = iD2;
        if (iD2 == -1) {
            aVar.a();
            return;
        }
        View viewD = this.d.D(iD2);
        if (viewD == null) {
            aVar.a();
            return;
        }
        int iB0 = this.d.b0(viewD);
        int iK0 = this.d.k0(viewD);
        int iN0 = this.d.n0(viewD);
        int I = this.d.I(viewD);
        ViewGroup.LayoutParams layoutParams = viewD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iB0 += marginLayoutParams.leftMargin;
            iK0 += marginLayoutParams.rightMargin;
            iN0 += marginLayoutParams.topMargin;
            I += marginLayoutParams.bottomMargin;
        }
        int height = viewD.getHeight() + iN0 + I;
        int width = viewD.getWidth() + iB0 + iK0;
        if (this.d.r2() == 0) {
            top = (viewD.getLeft() - iB0) - this.c.getPaddingLeft();
            if (this.b.h()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewD.getTop() - iN0) - this.c.getPaddingTop();
        }
        int i = -top;
        aVar.c = i;
        if (i >= 0) {
            aVar.b = height == 0 ? 0.0f : i / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i) {
        if (!(this.e == 1 && this.f == 1) && i == 1) {
            s(false);
            return;
        }
        if (l() && i == 2) {
            if (this.k) {
                e(2);
                this.j = true;
                return;
            }
            return;
        }
        if (l() && i == 0) {
            t();
            if (this.k) {
                a aVar = this.g;
                if (aVar.c == 0) {
                    int i2 = this.h;
                    int i3 = aVar.a;
                    if (i2 != i3) {
                        d(i3);
                    }
                }
            } else {
                int i4 = this.g.a;
                if (i4 != -1) {
                    c(i4, 0.0f, 0);
                }
            }
            e(0);
            q();
        }
        if (this.e == 2 && i == 0 && this.l) {
            t();
            a aVar2 = this.g;
            if (aVar2.c == 0) {
                int i5 = this.i;
                int i6 = aVar2.a;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    d(i6);
                }
                e(0);
                q();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k = r4
            r3.t()
            boolean r0 = r3.j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.b
            boolean r6 = r6.h()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r6 = r5.c
            if (r6 == 0) goto L29
            int r5 = r5.a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.a
        L2d:
            r3.i = r5
            int r6 = r3.h
            if (r6 == r5) goto L45
            r3.d(r5)
            goto L45
        L37:
            int r5 = r3.e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.d(r5)
        L45:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r6 = r5.a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.b
            int r5 = r5.c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r6 = r5.a
            int r0 = r3.i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.c
            if (r5 != 0) goto L6b
            int r5 = r3.f
            if (r5 == r4) goto L6b
            r3.e(r2)
            r3.q()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    double g() {
        t();
        a aVar = this.g;
        return aVar.a + aVar.b;
    }

    int h() {
        return this.f;
    }

    boolean i() {
        return this.f == 1;
    }

    boolean j() {
        return this.m;
    }

    boolean k() {
        return this.f == 0;
    }

    void m() {
        this.e = 4;
        s(true);
    }

    void n() {
        this.l = true;
    }

    void o() {
        if (!i() || this.m) {
            this.m = false;
            t();
            a aVar = this.g;
            if (aVar.c != 0) {
                e(2);
                return;
            }
            int i = aVar.a;
            if (i != this.h) {
                d(i);
            }
            e(0);
            q();
        }
    }

    void p(int i, boolean z) {
        this.e = z ? 2 : 3;
        this.m = false;
        boolean z2 = this.i != i;
        this.i = i;
        e(2);
        if (z2) {
            d(i);
        }
    }

    void r(ViewPager2.i iVar) {
        this.a = iVar;
    }
}
