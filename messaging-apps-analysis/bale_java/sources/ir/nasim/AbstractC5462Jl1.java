package ir.nasim;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* renamed from: ir.nasim.Jl1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5462Jl1 extends PopupWindow {
    private final C7140Ql1 a;
    private Point b;
    private Point c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5462Jl1(C7140Ql1 c7140Ql1, View view, int i, int i2) {
        super(view, i, i2);
        AbstractC13042fc3.i(c7140Ql1, "contextMenuData");
        this.a = c7140Ql1;
        setOutsideTouchable(true);
        setTouchable(true);
        setFocusable(true);
        setElevation(c7140Ql1.d() ? 0.0f : 12.0f);
        setBackgroundDrawable(AbstractC4043Dl1.f(c7140Ql1.a().getContext(), AbstractC24188yB5.context_menu_popup_window_background));
        if (view != null) {
            view.setPadding((int) ((c7140Ql1.c().b() * AbstractC3742Cd6.c()) + 0.5d), (int) ((c7140Ql1.c().d() * AbstractC3742Cd6.c()) + 0.5d), (int) ((c7140Ql1.c().c() * AbstractC3742Cd6.c()) + 0.5d), (int) ((c7140Ql1.c().a() * AbstractC3742Cd6.c()) + 0.5d));
        }
        int[] iArr = new int[2];
        c7140Ql1.b().getLocationInWindow(iArr);
        this.b = new Point(iArr[0], iArr[1]);
        this.c = new Point(c7140Ql1.b().getMeasuredWidth() - iArr[0], c7140Ql1.b().getMeasuredHeight() - iArr[1]);
    }

    private final int b(int i) {
        int iG = (i - this.a.g()) - (this.b.x + this.a.f());
        int iF = (this.c.x - this.a.f()) - ((getContentView().getMeasuredWidth() + i) - this.a.g());
        if (iF < this.a.f()) {
            i -= Math.abs(iF);
        } else if (iG < this.a.f()) {
            i += Math.abs(iG);
        }
        return i - this.a.g();
    }

    private final int c(int i) {
        int iH = (i - this.a.h()) - (this.b.y + this.a.f());
        int iF = (this.c.y - this.a.f()) - ((i - this.a.h()) + getContentView().getMeasuredHeight());
        if (iH < this.a.f()) {
            i += Math.abs(iH);
        } else if (iF < this.a.f()) {
            i -= Math.abs(iF);
        }
        return i - this.a.h();
    }

    public static /* synthetic */ void f(AbstractC5462Jl1 abstractC5462Jl1, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDropDown");
        }
        if ((i2 & 1) != 0) {
            i = 80;
        }
        abstractC5462Jl1.e(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AbstractC5462Jl1 abstractC5462Jl1, int i) {
        AbstractC13042fc3.i(abstractC5462Jl1, "this$0");
        abstractC5462Jl1.e(i);
    }

    protected final void d() {
        View rootView = getContentView().getRootView();
        if (rootView == null) {
            return;
        }
        Object systemService = rootView.getContext().getSystemService("window");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        layoutParams2.flags |= 2;
        layoutParams2.dimAmount = 0.5f;
        ((WindowManager) systemService).updateViewLayout(rootView, layoutParams2);
    }

    public void e(final int i) {
        if (this.a.a().getWidth() == 0 || this.a.a().getHeight() == 0) {
            this.a.a().post(new Runnable() { // from class: ir.nasim.Hl1
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC5462Jl1.g(this.a, i);
                }
            });
            return;
        }
        showAsDropDown(this.a.a(), this.a.e().x, this.a.e().y, i);
        if (this.a.d()) {
            d();
        }
    }

    public void h() {
        if (!this.a.i()) {
            if (this.a.a().getWidth() == 0 || this.a.a().getHeight() == 0) {
                this.a.a().post(new Runnable() { // from class: ir.nasim.Il1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                });
                return;
            }
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(getWidth(), getWidth() <= 0 ? 0 : 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), getHeight() <= 0 ? 0 : 1073741824));
        }
        showAtLocation(this.a.b(), 51, b(this.a.e().x), c(this.a.e().y));
        if (this.a.d()) {
            d();
        }
    }
}
