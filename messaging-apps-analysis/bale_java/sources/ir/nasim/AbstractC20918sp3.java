package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* renamed from: ir.nasim.sp3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC20918sp3 {
    private final View a;
    private final Utilities.b b;
    public boolean c;
    private boolean d;
    private final Rect e = new Rect();
    private final View.OnLayoutChangeListener f;
    private final ViewTreeObserver.OnGlobalLayoutListener g;
    private int h;
    private int i;

    /* renamed from: ir.nasim.sp3$a */
    class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(AbstractC20918sp3.this.g);
            this.a.addOnLayoutChangeListener(AbstractC20918sp3.this.f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(AbstractC20918sp3.this.g);
            this.a.removeOnLayoutChangeListener(AbstractC20918sp3.this.f);
        }
    }

    public AbstractC20918sp3(View view, Utilities.b bVar) {
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: ir.nasim.qp3
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.a.j(view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.f = onLayoutChangeListener;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.rp3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.a.k();
            }
        };
        this.g = onGlobalLayoutListener;
        this.a = view;
        this.b = bVar;
        if (view.isAttachedToWindow()) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            view.addOnLayoutChangeListener(onLayoutChangeListener);
        }
        view.addOnAttachStateChangeListener(new a(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.c) {
            return;
        }
        this.a.getWindowVisibleDisplayFrame(this.e);
        int height = this.a.getHeight() - this.e.bottom;
        this.i = height;
        boolean z = this.h != height;
        this.h = height;
        if (z) {
            f();
        }
    }

    public void e() {
        this.d = true;
    }

    public void f() {
        if (this.d) {
            if (this.i < AbstractC21455b.e + AbstractC21455b.F(20.0f)) {
                return;
            } else {
                this.d = false;
            }
        }
        Utilities.b bVar = this.b;
        if (bVar != null) {
            bVar.a(Integer.valueOf(this.i));
        }
    }

    public int g() {
        return this.i;
    }

    public void h(boolean z) {
        boolean z2 = this.c && z;
        this.c = z;
        if (z2) {
            k();
        }
    }

    public boolean i() {
        return this.i > AbstractC21455b.e + AbstractC21455b.F(20.0f) || this.d;
    }
}
