package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.T45;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;

/* loaded from: classes7.dex */
public class PaintToolsView extends LinearLayout {
    private RLottieImageView[] a;
    private b b;
    private Paint c;
    private final int d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private ValueAnimator i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == PaintToolsView.this.i) {
                PaintToolsView paintToolsView = PaintToolsView.this;
                paintToolsView.f = paintToolsView.g;
                PaintToolsView.this.g = -1;
                PaintToolsView.this.i = null;
            }
        }
    }

    public interface b {
        void A(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar);

        void b();

        T45 q();

        void w(View view);
    }

    public PaintToolsView(Context context, boolean z) {
        super(context);
        this.a = new RLottieImageView[ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size() + 2];
        this.c = new Paint(1);
        this.f = 1;
        this.g = -1;
        this.h = 0.0f;
        setOrientation(0);
        setGravity(16);
        setWillNotDraw(false);
        setClipToPadding(false);
        this.c.setColor(822083583);
        this.d = ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size() - (!z ? 1 : 0);
        int i = 0;
        final int i2 = 0;
        while (i < ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size() + 2) {
            this.a[i2] = m(i == 0, i == ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size() + 1);
            if (i == 0) {
                this.a[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rU4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.q(view);
                    }
                });
            } else if (i > 0 && i <= ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size()) {
                final ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar = (ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(i - 1);
                if (z || !(aVar instanceof a.b)) {
                    this.a[i2].setAnimation(aVar.d(), 28, 28);
                    this.a[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sU4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.a.r(i2, aVar, view);
                        }
                    });
                } else {
                    i++;
                }
            } else if (i == ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.size() + 1) {
                this.a[i2].setImageResource(AbstractC23598xB5.msg_add);
                this.a[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tU4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.s(view);
                    }
                });
            }
            addView(this.a[i2]);
            i2++;
            i++;
        }
    }

    private void k(int i) {
        if (i >= 0) {
            RLottieImageView[] rLottieImageViewArr = this.a;
            if (i >= rLottieImageViewArr.length) {
                return;
            }
            if (this.i == null || this.g != i) {
                RLottieImageView rLottieImageView = rLottieImageViewArr[i];
                if (rLottieImageView != null) {
                    Drawable drawable = rLottieImageView.getDrawable();
                    if (drawable instanceof RLottieDrawable) {
                        RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                        rLottieDrawable.g0(0);
                        rLottieDrawable.start();
                    }
                }
                ValueAnimator valueAnimator = this.i;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                if (this.f == i) {
                    return;
                }
                if (this.e) {
                    this.e = false;
                    AbstractC21455b.G1(this.a[this.d + 1], AbstractC23598xB5.msg_add);
                }
                this.g = i;
                this.h = 0.0f;
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(250L);
                this.i = duration;
                duration.setInterpolator(InterpolatorC12631ew1.f);
                this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.qU4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.a.o(valueAnimator2);
                    }
                });
                this.i.addListener(new a());
                this.i.start();
            }
        }
    }

    private RLottieImageView m(boolean z, boolean z2) {
        RLottieImageView rLottieImageView = new RLottieImageView(getContext());
        rLottieImageView.setPadding(AbstractC21455b.F(z ? 0.0f : 8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(z2 ? 0.0f : 8.0f), AbstractC21455b.F(8.0f));
        rLottieImageView.setLayoutParams(AbstractC13840gu3.h(0, 40, 1.0f));
        rLottieImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        return rLottieImageView;
    }

    private float n(int i) {
        if (i == this.d + 1) {
            return AbstractC21455b.F(4.0f);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(int i, ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar, View view) {
        k(i);
        this.b.A(aVar);
        this.b.q().o(i - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.b.w(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2 || motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            motionEvent.getY();
            for (int i = 1; i < getChildCount() - 1; i++) {
                final View childAt = getChildAt(i);
                if (x >= childAt.getLeft() && x <= childAt.getRight()) {
                    if (this.i != null) {
                        if (this.g != i) {
                            k(i);
                            post(new Runnable() { // from class: ir.nasim.pU4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    childAt.performClick();
                                }
                            });
                            return true;
                        }
                    } else if (this.f != i) {
                        k(i);
                        post(new Runnable() { // from class: ir.nasim.pU4
                            @Override // java.lang.Runnable
                            public final void run() {
                                childAt.performClick();
                            }
                        });
                        return true;
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void l(int i) {
        k(this.d + 1);
        AbstractC21455b.G1(this.a[this.d + 1], i);
        this.e = true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RLottieImageView[] rLottieImageViewArr = this.a;
        RLottieImageView rLottieImageView = rLottieImageViewArr[this.f];
        int i = this.g;
        RLottieImageView rLottieImageView2 = i != -1 ? rLottieImageViewArr[i] : null;
        float f = rLottieImageView2 != null ? this.h : 0.0f;
        float f2 = 1.0f;
        if (f > 0.25f && f < 0.75f) {
            f2 = (f <= 0.25f || f >= 0.5f) ? 1.0f - ((0.75f - f) / 0.25f) : (0.5f - f) / 0.25f;
        }
        float fMin = (Math.min((rLottieImageView.getWidth() - rLottieImageView.getPaddingLeft()) - rLottieImageView.getPaddingRight(), (rLottieImageView.getHeight() - rLottieImageView.getPaddingTop()) - rLottieImageView.getPaddingBottom()) / 2.0f) + AbstractC21455b.F(3.0f) + (AbstractC21455b.F(3.0f) * f2);
        float x = rLottieImageView.getX() + (rLottieImageView.getWidth() / 2.0f) + n(this.f);
        float x2 = rLottieImageView2 != null ? rLottieImageView2.getX() + (rLottieImageView2.getWidth() / 2.0f) : 0.0f;
        int i2 = this.g;
        canvas.drawCircle(AbstractC21455b.T0(x, x2 + (i2 != -1 ? n(i2) : 0.0f), f), rLottieImageView.getY() + (rLottieImageView.getHeight() / 2.0f), fMin, this.c);
    }

    public void setDelegate(b bVar) {
        this.b = bVar;
    }

    public void setSelectedIndex(int i) {
        this.f = i;
        if (this.e) {
            this.e = false;
            AbstractC21455b.G1(this.a[this.d + 1], AbstractC23598xB5.msg_add);
        }
        invalidate();
    }

    public void t(int i) {
        k(i);
        this.b.q().o(i - 1);
    }
}
