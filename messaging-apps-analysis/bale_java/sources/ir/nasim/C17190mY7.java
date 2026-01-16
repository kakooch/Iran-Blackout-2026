package ir.nasim;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import ir.nasim.AbstractC21649tt7;

/* renamed from: ir.nasim.mY7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17190mY7 extends AbstractC10965cV7 {
    private final View a;
    private final boolean b;
    private final AbstractC21649tt7.e c;
    private final Handler d;
    private final ViewTreeObserver.OnGlobalLayoutListener e;
    private final ViewTreeObserver.OnScrollChangedListener f;
    private final int[] g;
    private final Rect h;
    private final Rect i;

    /* renamed from: ir.nasim.mY7$a */
    public interface a {
        C17190mY7 getViewVisibility();

        void setViewVisibility(C17190mY7 c17190mY7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C17190mY7(View view) {
        AbstractC13042fc3.i(view, "view");
        this.a = view;
        this.c = new AbstractC21649tt7.e(0, 0);
        this.d = new Handler(Looper.getMainLooper());
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.jY7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                C17190mY7.h(this.a);
            }
        };
        this.e = onGlobalLayoutListener;
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.nasim.kY7
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                C17190mY7.m(this.a);
            }
        };
        this.f = onScrollChangedListener;
        view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        if (view instanceof a) {
            ((a) view).setViewVisibility(this);
        }
        this.g = new int[2];
        this.h = new Rect();
        this.i = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(C17190mY7 c17190mY7) {
        AbstractC13042fc3.i(c17190mY7, "this$0");
        c17190mY7.k();
    }

    private final boolean i(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            return i(view2);
        }
        return true;
    }

    private final void k() {
        this.d.removeCallbacksAndMessages(null);
        this.d.postDelayed(new Runnable() { // from class: ir.nasim.lY7
            @Override // java.lang.Runnable
            public final void run() {
                C17190mY7.l(this.a);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(C17190mY7 c17190mY7) {
        AbstractC13042fc3.i(c17190mY7, "this$0");
        c17190mY7.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C17190mY7 c17190mY7) {
        AbstractC13042fc3.i(c17190mY7, "this$0");
        c17190mY7.k();
    }

    @Override // ir.nasim.AbstractC10965cV7
    public void a() {
        super.a();
        this.d.removeCallbacksAndMessages(null);
        this.a.getViewTreeObserver().removeOnScrollChangedListener(this.f);
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.e);
        KeyEvent.Callback callback = this.a;
        if ((callback instanceof a) && AbstractC13042fc3.d(((a) callback).getViewVisibility(), this)) {
            ((a) this.a).setViewVisibility(null);
        }
    }

    @Override // ir.nasim.AbstractC10965cV7
    public boolean b() {
        if (this.a.getWindowVisibility() != 0 || !i(this.a)) {
            return false;
        }
        this.a.getLocationInWindow(this.g);
        Rect rect = this.h;
        int[] iArr = this.g;
        int i = iArr[0];
        rect.set(i, iArr[1], this.a.getWidth() + i, this.g[1] + this.a.getHeight());
        this.a.getWindowVisibleDisplayFrame(this.i);
        Rect rect2 = this.i;
        rect2.offset(-rect2.left, -rect2.top);
        return this.h.intersect(this.i);
    }

    @Override // ir.nasim.AbstractC10965cV7
    public AbstractC21649tt7.e d() {
        return new AbstractC21649tt7.e(this.a.getWidth(), this.a.getHeight());
    }

    public final void j() {
        if (AbstractC13042fc3.d(d(), this.c) ? b() != this.b : true) {
            c();
        }
    }
}
