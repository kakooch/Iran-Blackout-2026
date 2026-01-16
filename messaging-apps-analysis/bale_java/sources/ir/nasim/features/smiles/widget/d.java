package ir.nasim.features.smiles.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import ir.nasim.AbstractC13042fc3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class d extends PopupWindow {
    private ViewTreeObserver.OnScrollChangedListener a;
    private ViewTreeObserver b;

    public d(View view, int i, int i2) {
        super(view, i, i2);
    }

    private final void a(View view) {
        if (this.a != null) {
            ViewTreeObserver viewTreeObserver = view.getWindowToken() != null ? view.getViewTreeObserver() : null;
            if (AbstractC13042fc3.d(viewTreeObserver, this.b)) {
                return;
            }
            ViewTreeObserver viewTreeObserver2 = this.b;
            if (viewTreeObserver2 != null) {
                AbstractC13042fc3.f(viewTreeObserver2);
                if (viewTreeObserver2.isAlive()) {
                    ViewTreeObserver viewTreeObserver3 = this.b;
                    AbstractC13042fc3.f(viewTreeObserver3);
                    viewTreeObserver3.removeOnScrollChangedListener(this.a);
                }
            }
            this.b = viewTreeObserver;
            if (viewTreeObserver != null) {
                AbstractC13042fc3.f(viewTreeObserver);
                viewTreeObserver.addOnScrollChangedListener(this.a);
            }
        }
    }

    private final void b() {
        ViewTreeObserver viewTreeObserver;
        if (this.a == null || (viewTreeObserver = this.b) == null) {
            return;
        }
        AbstractC13042fc3.f(viewTreeObserver);
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver viewTreeObserver2 = this.b;
            AbstractC13042fc3.f(viewTreeObserver2);
            viewTreeObserver2.removeOnScrollChangedListener(this.a);
        }
        this.b = null;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        setFocusable(false);
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
        b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        AbstractC13042fc3.i(view, "anchor");
        try {
            super.showAsDropDown(view, i, i2, 0);
            a(view);
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        AbstractC13042fc3.i(view, "parent");
        super.showAtLocation(view, i, i2, i3);
        b();
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        AbstractC13042fc3.i(view, "anchor");
        super.update(view, i, i2, i3, i4);
        a(view);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2) {
        AbstractC13042fc3.i(view, "anchor");
        super.update(view, i, i2);
        a(view);
    }
}
