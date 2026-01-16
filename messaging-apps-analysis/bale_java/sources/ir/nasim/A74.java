package ir.nasim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;

/* loaded from: classes5.dex */
public final class A74 extends l.e {
    private final Context d;
    private final InterfaceC13306g03 e;
    private Drawable f;
    private Drawable g;
    private RecyclerView.C h;
    private View i;
    private float j;
    private float k;
    private long l;
    private boolean m;
    private boolean n;
    private boolean o;

    public A74(Context context, InterfaceC13306g03 interfaceC13306g03) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC13306g03, "swipeControllerActions");
        this.d = context;
        this.e = interfaceC13306g03;
    }

    private final void D(Canvas canvas) {
        float f;
        float fH;
        int right;
        int iC;
        if (this.h == null) {
            return;
        }
        View view = this.i;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("mView");
            view = null;
        }
        float translationX = view.getTranslationX();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = AbstractC23053wG5.j(17L, jCurrentTimeMillis - this.l);
        this.l = jCurrentTimeMillis;
        boolean z = translationX <= ((float) AbstractC8943Xx1.c(-30));
        if (z) {
            float f2 = this.k;
            if (f2 < 1.0f) {
                float f3 = f2 + (j / 180.0f);
                this.k = f3;
                if (f3 > 1.0f) {
                    this.k = 1.0f;
                } else {
                    View view3 = this.i;
                    if (view3 == null) {
                        AbstractC13042fc3.y("mView");
                        view3 = null;
                    }
                    view3.invalidate();
                }
            }
        } else if (translationX <= 0.0f) {
            this.k = 0.0f;
            this.o = false;
            this.n = false;
        } else {
            float f4 = this.k;
            if (f4 > 0.0f) {
                float f5 = f4 - (j / 180.0f);
                this.k = f5;
                if (f5 < 0.1f) {
                    this.k = 0.0f;
                } else {
                    View view4 = this.i;
                    if (view4 == null) {
                        AbstractC13042fc3.y("mView");
                        view4 = null;
                    }
                    view4.invalidate();
                }
            }
        }
        if (z) {
            float f6 = this.k;
            f = f6 <= 0.8f ? (f6 / 0.8f) * 1.2f : 1.2f - (((f6 - 0.8f) / 0.2f) * 0.2f);
            fH = AbstractC23053wG5.h(255.0f, 255 * (f6 / 0.8f));
        } else {
            f = this.k;
            fH = AbstractC23053wG5.h(255.0f, 255 * f);
        }
        int i = (int) fH;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.setAlpha(i);
        }
        if (this.o && !this.n) {
            View view5 = this.i;
            if (view5 == null) {
                AbstractC13042fc3.y("mView");
                view5 = null;
            }
            if (view5.getTranslationX() <= AbstractC8943Xx1.c(-100)) {
                View view6 = this.i;
                if (view6 == null) {
                    AbstractC13042fc3.y("mView");
                    view6 = null;
                }
                view6.performHapticFeedback(3, 2);
                this.n = true;
            }
        }
        View view7 = this.i;
        if (view7 == null) {
            AbstractC13042fc3.y("mView");
            view7 = null;
        }
        if (view7.getTranslationX() < AbstractC8943Xx1.c(-130)) {
            View view8 = this.i;
            if (view8 == null) {
                AbstractC13042fc3.y("mView");
                view8 = null;
            }
            right = view8.getRight();
            iC = AbstractC8943Xx1.c(130) / 2;
        } else {
            View view9 = this.i;
            if (view9 == null) {
                AbstractC13042fc3.y("mView");
                view9 = null;
            }
            right = view9.getRight();
            View view10 = this.i;
            if (view10 == null) {
                AbstractC13042fc3.y("mView");
                view10 = null;
            }
            iC = -((int) (view10.getTranslationX() / 2));
        }
        int i2 = right - iC;
        View view11 = this.i;
        if (view11 == null) {
            AbstractC13042fc3.y("mView");
            view11 = null;
        }
        int top = view11.getTop();
        View view12 = this.i;
        if (view12 == null) {
            AbstractC13042fc3.y("mView");
        } else {
            view2 = view12;
        }
        float measuredHeight = top + (view2.getMeasuredHeight() / 2);
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            drawable3.setColorFilter(new PorterDuffColorFilter(-7829368, PorterDuff.Mode.MULTIPLY));
            float f7 = i2;
            drawable3.setBounds((int) (f7 - (AbstractC8943Xx1.c(18) * f)), (int) (measuredHeight - (AbstractC8943Xx1.c(18) * f)), (int) (f7 + (AbstractC8943Xx1.c(18) * f)), (int) ((AbstractC8943Xx1.c(18) * f) + measuredHeight));
            drawable3.draw(canvas);
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.f;
        if (drawable4 != null) {
            float f8 = i2;
            drawable4.setBounds((int) (f8 - (AbstractC8943Xx1.c(12) * f)), (int) (measuredHeight - (AbstractC8943Xx1.c(11) * f)), (int) (f8 + (AbstractC8943Xx1.c(12) * f)), (int) (measuredHeight + (AbstractC8943Xx1.c(10) * f)));
            drawable4.draw(canvas);
            drawable4.setAlpha(255);
        }
    }

    private final void E(RecyclerView recyclerView, final RecyclerView.C c) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.z74
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return A74.F(this.a, c, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F(A74 a74, RecyclerView.C c, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(a74, "this$0");
        AbstractC13042fc3.i(c, "$viewHolder");
        boolean z = true;
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            z = false;
        }
        a74.m = z;
        if (z) {
            View view2 = a74.i;
            if (view2 == null) {
                AbstractC13042fc3.y("mView");
                view2 = null;
            }
            if (Math.abs(view2.getTranslationX()) >= AbstractC8943Xx1.c(100)) {
                a74.e.b(c.K());
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.l.e
    public void B(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.l.e
    public int d(int i, int i2) {
        if (!this.m) {
            return super.d(i, i2);
        }
        this.m = false;
        return 0;
    }

    @Override // androidx.recyclerview.widget.l.e
    public int k(RecyclerView recyclerView, RecyclerView.C c) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(c, "viewHolder");
        this.i = c.a;
        Drawable drawable = this.d.getDrawable(KB5.reply);
        if (drawable != null) {
            drawable.setTint(-1);
        } else {
            drawable = null;
        }
        this.f = drawable;
        this.g = this.d.getDrawable(KB5.ic_round_shape);
        return !this.e.a(c.K()) ? l.e.t(0, 0) : l.e.t(0, 4);
    }

    @Override // androidx.recyclerview.widget.l.e
    public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c, float f, float f2, int i, boolean z) {
        AbstractC13042fc3.i(canvas, "c");
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(c, "viewHolder");
        if (i == 1) {
            E(recyclerView, c);
        }
        View view = this.i;
        if (view == null) {
            AbstractC13042fc3.y("mView");
            view = null;
        }
        if (view.getTranslationX() > AbstractC8943Xx1.c(-130) || f > this.j) {
            super.u(canvas, recyclerView, c, f, f2, i, z);
            this.j = f;
            this.o = true;
        }
        this.h = c;
        D(canvas);
    }

    @Override // androidx.recyclerview.widget.l.e
    public boolean y(RecyclerView recyclerView, RecyclerView.C c, RecyclerView.C c2) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(c, "viewHolder");
        AbstractC13042fc3.i(c2, "target");
        return false;
    }
}
