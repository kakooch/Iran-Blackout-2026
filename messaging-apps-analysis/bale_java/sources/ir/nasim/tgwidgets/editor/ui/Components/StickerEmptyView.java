package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.U00;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* loaded from: classes7.dex */
public class StickerEmptyView extends FrameLayout implements E.d {
    public LinearLayout a;
    public BackupImageView b;
    private RadialProgressView c;
    public final TextView d;
    public final TextView e;
    private boolean f;
    private final m.h g;
    private int h;
    public final View i;
    int j;
    int k;
    boolean l;
    private boolean m;
    private int n;
    int o;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StickerEmptyView.this.i.setVisibility(8);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StickerEmptyView.this.i.setVisibility(8);
        }
    }

    private int a(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.g);
    }

    private void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            b();
        }
        ir.nasim.tgwidgets.editor.messenger.E.k(this.k).e(this, ir.nasim.tgwidgets.editor.messenger.E.w0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ir.nasim.tgwidgets.editor.messenger.E.k(this.k).u(this, ir.nasim.tgwidgets.editor.messenger.E.w0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        if ((this.m || this.l) && (i5 = this.n) > 0 && i5 != getMeasuredHeight()) {
            float measuredHeight = (this.n - getMeasuredHeight()) / 2.0f;
            LinearLayout linearLayout = this.a;
            linearLayout.setTranslationY(linearLayout.getTranslationY() + measuredHeight);
            if (!this.l) {
                this.a.animate().translationY(0.0f).setInterpolator(InterpolatorC12631ew1.f).setDuration(250L);
            }
            RadialProgressView radialProgressView = this.c;
            if (radialProgressView != null) {
                radialProgressView.setTranslationY(radialProgressView.getTranslationY() + measuredHeight);
                if (!this.l) {
                    this.c.animate().translationY(0.0f).setInterpolator(InterpolatorC12631ew1.f).setDuration(250L);
                }
            }
        }
        this.n = getMeasuredHeight();
    }

    public void setAnimateLayoutChange(boolean z) {
        this.m = z;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.d.setTag(Integer.valueOf(i));
        this.d.setTextColor(a(i));
        this.e.setTag(Integer.valueOf(i2));
        this.e.setTextColor(a(i2));
        this.o = i3;
    }

    public void setKeyboardHeight(int i, boolean z) {
        if (this.j != i) {
            if (getVisibility() != 0) {
                z = false;
            }
            this.j = i;
            float F = (-(i >> 1)) + (i > 0 ? AbstractC21455b.F(20.0f) : 0);
            if (!z) {
                this.a.setTranslationY(F);
                RadialProgressView radialProgressView = this.c;
                if (radialProgressView != null) {
                    radialProgressView.setTranslationY(F);
                    return;
                }
                return;
            }
            ViewPropertyAnimator viewPropertyAnimatorTranslationY = this.a.animate().translationY(F);
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
            viewPropertyAnimatorTranslationY.setInterpolator(interpolatorC12631ew1).setDuration(250L);
            RadialProgressView radialProgressView2 = this.c;
            if (radialProgressView2 != null) {
                radialProgressView2.animate().translationY(F).setInterpolator(interpolatorC12631ew1).setDuration(250L);
            }
        }
    }

    public void setPreventMoving(boolean z) {
        this.l = z;
        if (z) {
            return;
        }
        this.a.setTranslationY(0.0f);
        RadialProgressView radialProgressView = this.c;
        if (radialProgressView != null) {
            radialProgressView.setTranslationY(0.0f);
        }
    }

    public void setStickerType(int i) {
        if (this.h != i) {
            this.h = i;
            b();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) throws InterruptedException {
        if (getVisibility() != i && i == 0) {
            if (this.f) {
                this.a.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(150L).start();
                this.i.animate().setListener(null).cancel();
                this.i.setVisibility(0);
                this.i.setAlpha(1.0f);
            } else {
                this.a.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
                View view = this.i;
                if (view != null) {
                    view.animate().setListener(null).cancel();
                    this.i.animate().setListener(new a()).alpha(0.0f).setDuration(150L).start();
                } else {
                    this.c.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setDuration(150L).start();
                }
                this.b.getImageReceiver().u1();
            }
        }
        super.setVisibility(i);
        if (getVisibility() == 0) {
            b();
            return;
        }
        this.n = 0;
        this.a.setAlpha(0.0f);
        this.a.setScaleX(0.8f);
        this.a.setScaleY(0.8f);
        View view2 = this.i;
        if (view2 != null) {
            view2.animate().setListener(null).cancel();
            this.i.animate().setListener(new b()).alpha(0.0f).setDuration(150L).start();
        } else {
            this.c.setAlpha(0.0f);
            this.c.setScaleX(0.5f);
            this.c.setScaleY(0.5f);
        }
        this.b.getImageReceiver().v1();
        this.b.getImageReceiver().c();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        if (i == ir.nasim.tgwidgets.editor.messenger.E.w0) {
            U00.f(getContext(), "diceStickersDidLoad");
        }
    }
}
