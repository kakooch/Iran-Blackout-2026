package ir.nasim;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* renamed from: ir.nasim.Yr7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC9150Yr7 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static ViewOnLongClickListenerC9150Yr7 k;
    private static ViewOnLongClickListenerC9150Yr7 l;
    private final View a;
    private final CharSequence b;
    private final int c;
    private final Runnable d = new Runnable() { // from class: ir.nasim.Wr7
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            this.a.e();
        }
    };
    private final Runnable e = new Runnable() { // from class: ir.nasim.Xr7
        @Override // java.lang.Runnable
        public final void run() {
            this.a.d();
        }
    };
    private int f;
    private int g;
    private C9983as7 h;
    private boolean i;
    private boolean j;

    private ViewOnLongClickListenerC9150Yr7(View view, CharSequence charSequence) {
        this.a = view;
        this.b = charSequence;
        this.c = AbstractC20736sW7.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.a.removeCallbacks(this.d);
    }

    private void c() {
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() throws Resources.NotFoundException {
        i(false);
    }

    private void f() {
        this.a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(ViewOnLongClickListenerC9150Yr7 viewOnLongClickListenerC9150Yr7) {
        ViewOnLongClickListenerC9150Yr7 viewOnLongClickListenerC9150Yr72 = k;
        if (viewOnLongClickListenerC9150Yr72 != null) {
            viewOnLongClickListenerC9150Yr72.b();
        }
        k = viewOnLongClickListenerC9150Yr7;
        if (viewOnLongClickListenerC9150Yr7 != null) {
            viewOnLongClickListenerC9150Yr7.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        ViewOnLongClickListenerC9150Yr7 viewOnLongClickListenerC9150Yr7 = k;
        if (viewOnLongClickListenerC9150Yr7 != null && viewOnLongClickListenerC9150Yr7.a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new ViewOnLongClickListenerC9150Yr7(view, charSequence);
            return;
        }
        ViewOnLongClickListenerC9150Yr7 viewOnLongClickListenerC9150Yr72 = l;
        if (viewOnLongClickListenerC9150Yr72 != null && viewOnLongClickListenerC9150Yr72.a == view) {
            viewOnLongClickListenerC9150Yr72.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.j && Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        this.j = false;
        return true;
    }

    void d() {
        if (l == this) {
            l = null;
            C9983as7 c9983as7 = this.h;
            if (c9983as7 != null) {
                c9983as7.c();
                this.h = null;
                c();
                this.a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            g(null);
        }
        this.a.removeCallbacks(this.e);
    }

    void i(boolean z) throws Resources.NotFoundException {
        long longPressTimeout;
        long j;
        long j2;
        if (AbstractC12990fW7.S(this.a)) {
            g(null);
            ViewOnLongClickListenerC9150Yr7 viewOnLongClickListenerC9150Yr7 = l;
            if (viewOnLongClickListenerC9150Yr7 != null) {
                viewOnLongClickListenerC9150Yr7.d();
            }
            l = this;
            this.i = z;
            C9983as7 c9983as7 = new C9983as7(this.a.getContext());
            this.h = c9983as7;
            c9983as7.e(this.a, this.f, this.g, this.i, this.b);
            this.a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                if ((AbstractC12990fW7.L(this.a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            this.a.removeCallbacks(this.e);
            this.a.postDelayed(this.e, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.a.isEnabled() && this.h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
