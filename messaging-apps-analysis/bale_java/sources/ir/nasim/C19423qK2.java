package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import ja.burhanrashid52.photoeditor.DrawingView;

/* renamed from: ir.nasim.qK2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19423qK2 {
    private final ViewGroup a;
    private final C24159y85 b;
    private LJ4 c;

    public C19423qK2(ViewGroup viewGroup, C24159y85 c24159y85) {
        AbstractC13042fc3.i(viewGroup, "mViewGroup");
        AbstractC13042fc3.i(c24159y85, "mViewState");
        this.a = viewGroup;
        this.b = c24159y85;
    }

    public final void a(AbstractC18241oK2 abstractC18241oK2) {
        AbstractC13042fc3.i(abstractC18241oK2, "graphic");
        View viewD = abstractC18241oK2.d();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        this.a.addView(viewD, layoutParams);
        this.b.a(viewD);
        LJ4 lj4 = this.c;
        if (lj4 == null) {
            return;
        }
        lj4.E3(abstractC18241oK2.e(), this.b.g());
    }

    public final LJ4 b() {
        return this.c;
    }

    public final void c(AbstractC18241oK2 abstractC18241oK2) {
        AbstractC13042fc3.i(abstractC18241oK2, "graphic");
        View viewD = abstractC18241oK2.d();
        if (this.b.e(viewD)) {
            this.a.removeView(viewD);
            this.b.m(viewD);
            this.b.k(viewD);
            LJ4 lj4 = this.c;
            if (lj4 == null) {
                return;
            }
            lj4.z0(abstractC18241oK2.e(), this.b.g());
        }
    }

    public final void d(LJ4 lj4) {
        this.c = lj4;
    }

    public final boolean e() {
        LJ4 lj4;
        if (this.b.g() > 0) {
            C24159y85 c24159y85 = this.b;
            View viewF = c24159y85.f(c24159y85.g() - 1);
            if (viewF instanceof DrawingView) {
                return ((DrawingView) viewF).m();
            }
            C24159y85 c24159y852 = this.b;
            c24159y852.l(c24159y852.g() - 1);
            this.a.removeView(viewF);
            this.b.k(viewF);
            Object tag = viewF.getTag();
            if ((tag instanceof ZX7) && (lj4 = this.c) != null) {
                lj4.z0((ZX7) tag, this.b.g());
            }
        }
        return this.b.g() != 0;
    }

    public final void f(View view) {
        AbstractC13042fc3.i(view, "view");
        this.a.updateViewLayout(view, view.getLayoutParams());
        this.b.n(view);
    }
}
