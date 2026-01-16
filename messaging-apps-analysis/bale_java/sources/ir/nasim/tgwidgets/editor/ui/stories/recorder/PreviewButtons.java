package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C11363cs7;
import ir.nasim.C19526qV6;
import ir.nasim.C9151Ys;
import ir.nasim.D20;
import ir.nasim.FH3;
import ir.nasim.IA5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.RA7;
import ir.nasim.SA2;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class PreviewButtons extends FrameLayout {
    private Runnable a;
    private View b;
    private ArrayList c;
    public b d;
    private String e;
    private Utilities.b f;
    private boolean g;
    private float h;
    private boolean i;
    private ValueAnimator j;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends ImageView {
        public a(Context context, final int i, int i2) {
            super(context);
            setTag(Integer.valueOf(i));
            setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
            setScaleType(ImageView.ScaleType.CENTER);
            setImageDrawable(RA7.b(context, i2));
            setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i, View view) {
            if (!PreviewButtons.this.i || PreviewButtons.this.f == null) {
                return;
            }
            PreviewButtons.this.f.a(Integer.valueOf(i));
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Button");
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(AbstractC21455b.F(40.0f), AbstractC21455b.F(40.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b extends View {
        private final Paint a;
        private final Paint b;
        private final Drawable c;
        private final int d;
        private final int e;
        private C9151Ys f;
        public boolean g;
        float h;
        ValueAnimator i;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.i = null;
            }
        }

        public b(Context context, String str) {
            super(context);
            Paint paint = new Paint(1);
            this.a = paint;
            Paint paint2 = new Paint(1);
            this.b = paint2;
            this.f = new C9151Ys(this, 0L, 220L, InterpolatorC12631ew1.h);
            this.g = true;
            paint.setColor(AbstractC4043Dl1.c(context, IA5.colorPrimary_light));
            paint2.setColor(1610612736);
            Drawable drawableF = AbstractC4043Dl1.f(getContext(), AbstractC24188yB5.bold_send_2);
            this.c = drawableF;
            drawableF.setBounds(0, 0, AbstractC21455b.F(24.0f), AbstractC21455b.F(24.0f));
            drawableF.mutate();
            drawableF.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
            this.d = AbstractC21455b.F(48.0f);
            this.e = AbstractC21455b.F(48.0f);
            setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            if (!PreviewButtons.this.i || PreviewButtons.this.f == null) {
                return;
            }
            PreviewButtons.this.f.a(5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(ValueAnimator valueAnimator) {
            this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }

        @Override // android.view.View
        public int getPaddingRight() {
            return AbstractC21455b.F(12.0f);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (isPressed()) {
                float f = this.h;
                if (f != 1.0f) {
                    float fMin = f + (Math.min(40.0f, 1000.0f / AbstractC21455b.i) / 80.0f);
                    this.h = fMin;
                    this.h = Utilities.c(fMin, 1.0f, 0.0f);
                    invalidate();
                }
            }
            float fC = this.f.c(this.g ? 1.0f : 0.5f);
            int saveCount = canvas.getSaveCount();
            if (fC < 1.0f) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (fC * 255.0f), 31);
            }
            float f2 = ((1.0f - this.h) * 0.1f) + 0.9f;
            canvas.save();
            canvas.scale(f2, f2, this.d / 2.0f, this.e / 2.0f);
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255, 31);
            RectF rectF = AbstractC21455b.x;
            rectF.set(0.0f, 0.0f, this.d, this.e);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.d / 2, this.a);
            canvas.save();
            canvas.translate((this.d - this.c.getIntrinsicWidth()) / 2, (this.e - this.c.getIntrinsicHeight()) / 2);
            this.c.draw(canvas);
            canvas.restore();
            canvas.restoreToCount(saveCount);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Button");
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.d + getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
        }

        @Override // android.view.View
        public void setPressed(boolean z) {
            ValueAnimator valueAnimator;
            if (isPressed() != z) {
                super.setPressed(z);
                invalidate();
                if (z && (valueAnimator = this.i) != null) {
                    valueAnimator.removeAllListeners();
                    this.i.cancel();
                }
                if (z) {
                    return;
                }
                float f = this.h;
                if (f != 0.0f) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
                    this.i = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.f
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            this.a.d(valueAnimator2);
                        }
                    });
                    this.i.addListener(new a());
                    this.i.setInterpolator(new OvershootInterpolator(1.5f));
                    this.i.setDuration(350L);
                    this.i.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends ImageView {
        private C19526qV6 a;

        public c(Context context, final int i, C19526qV6 c19526qV6) {
            super(context);
            setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
            setScaleType(ImageView.ScaleType.CENTER);
            c(c19526qV6);
            setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i, View view) {
            if (!PreviewButtons.this.i || PreviewButtons.this.f == null) {
                return;
            }
            PreviewButtons.this.f.a(Integer.valueOf(i));
        }

        public void c(C19526qV6 c19526qV6) {
            LayerDrawable layerDrawable;
            this.a = c19526qV6;
            if (c19526qV6 == null) {
                return;
            }
            Drawable drawableA = RA7.a(c19526qV6.c(), 24.0f, getResources());
            if (c19526qV6.e()) {
                layerDrawable = new LayerDrawable(new Drawable[]{drawableA, RA7.a(AbstractC4043Dl1.f(getContext(), AbstractC23598xB5.story_tag_bage_ring), 24.0f, getResources())});
                layerDrawable.setLayerInset(0, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f));
                layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            } else {
                layerDrawable = new LayerDrawable(new Drawable[]{drawableA});
                layerDrawable.setLayerInset(0, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f));
            }
            setImageDrawable(layerDrawable);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Button");
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(AbstractC21455b.F(40.0f), AbstractC21455b.F(40.0f));
        }
    }

    public PreviewButtons(Context context) {
        super(context);
        this.c = new ArrayList(7);
        this.g = true;
        View view = new View(context);
        this.b = view;
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{1711276032, 0}));
        addView(this.b, AbstractC13840gu3.d(-1, -1, 119));
        e(1, AbstractC23598xB5.msg_draw_pen, FH3.E("AccDescrPaint", TD5.tgwidget_AccDescrPaint));
        e(2, AbstractC23598xB5.msg_photo_text2, FH3.E("AccDescrPlaceText", TD5.tgwidget_AccDescrPlaceText));
        String strE = FH3.E("Send", TD5.tgwidget_Send);
        this.e = strE;
        b bVar = new b(context, strE);
        this.d = bVar;
        bVar.setContentDescription(FH3.E("Send", TD5.tgwidget_Send));
        addView(this.d, AbstractC13840gu3.b(-2, -2.0f));
        k();
    }

    private void e(int i, int i2, CharSequence charSequence) {
        a aVar = new a(getContext(), i, i2);
        aVar.setContentDescription(charSequence);
        this.c.add(aVar);
        addView(aVar);
    }

    private a g(int i) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if ((view.getTag() instanceof Integer) && ((Integer) view.getTag()).intValue() == i) {
                return (a) view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        this.h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, SA2 sa2) {
        View view = (View) this.c.get(0);
        if (view instanceof c) {
            D20.a aVarA = C11363cs7.a(null);
            aVarA.X1(str);
            aVarA.a().M0(view, AbstractC21455b.F(150.0f), AbstractC21455b.F(-5.0f));
            sa2.invoke();
        }
        this.a = null;
    }

    private void k() {
        this.b.setAlpha(this.h);
        this.b.setTranslationY((1.0f - this.h) * AbstractC21455b.F(16.0f));
        for (int i = 1; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            float interpolation = this.h;
            if (this.i) {
                interpolation = InterpolatorC12631ew1.h.getInterpolation(AbstractC21455b.u(interpolation, i - 1, getChildCount() - 1, 3.0f));
            }
            childAt.setAlpha(interpolation);
            childAt.setTranslationY((1.0f - interpolation) * AbstractC21455b.F(24.0f));
        }
    }

    public void f(boolean z, boolean z2) {
        Runnable runnable;
        if (this.i == z) {
            return;
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.i = z;
        if (!z2) {
            this.h = z ? 1.0f : 0.0f;
            k();
            if (!z || (runnable = this.a) == null) {
                return;
            }
            postDelayed(runnable, 100L);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.h, z ? 1.0f : 0.0f);
        this.j = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.vp5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.i(valueAnimator2);
            }
        });
        if (this.i) {
            this.j.setDuration(450);
            this.j.setInterpolator(new LinearInterpolator());
            Runnable runnable2 = this.a;
            if (runnable2 != null) {
                postDelayed(runnable2, 550);
            }
        } else {
            this.j.setDuration(350L);
            this.j.setInterpolator(InterpolatorC12631ew1.h);
        }
        this.j.start();
    }

    public boolean h() {
        return this.g;
    }

    public void l(boolean z) {
        a aVarG = g(6);
        if (aVarG == null) {
            if (z) {
                e(6, AbstractC24188yB5.link, FH3.E("AccDescrPlaceText", TD5.tgwidget_AccDescrPlaceText));
            }
        } else if (z) {
            aVarG.setVisibility(0);
        } else {
            aVarG.setVisibility(8);
        }
    }

    public void m(C19526qV6 c19526qV6) {
        View view = (View) this.c.get(0);
        if (c19526qV6 == null) {
            if (view instanceof c) {
                this.c.remove(view);
                removeView(view);
                return;
            }
            return;
        }
        if (view instanceof c) {
            ((c) view).c(c19526qV6);
            return;
        }
        c cVar = new c(getContext(), 0, c19526qV6);
        cVar.setContentDescription(FH3.E("AccDescrPaint", TD5.tgwidget_tag_desc));
        this.c.add(0, cVar);
        addView(cVar, 1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.b.layout(0, 0, i5, i6);
        b bVar = this.d;
        bVar.layout(i5 - bVar.getMeasuredWidth(), (i6 - this.d.getMeasuredHeight()) / 2, i5, (this.d.getMeasuredHeight() + i6) / 2);
        int iMin = Math.min(AbstractC21455b.F(20.0f), this.c.size() < 2 ? 0 : (((i5 - AbstractC21455b.F(32.33f)) - this.d.getMeasuredWidth()) - (this.c.size() * AbstractC21455b.F(40.0f))) / (this.c.size() - 1));
        int iF = (i6 - AbstractC21455b.F(40.0f)) / 2;
        int iF2 = (i6 + AbstractC21455b.F(40.0f)) / 2;
        int iF3 = AbstractC21455b.F(12.33f);
        for (int i7 = 0; i7 < this.c.size(); i7++) {
            ((View) this.c.get(i7)).layout(iF3, iF, AbstractC21455b.F(40.0f) + iF3, iF2);
            iF3 += AbstractC21455b.F(40.0f) + iMin;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(52.0f), 1073741824));
    }

    public void setOnClickListener(Utilities.b bVar) {
        this.f = bVar;
    }

    public void setShareEnabled(boolean z) {
        if (this.g != z) {
            this.g = z;
            b bVar = this.d;
            bVar.g = z;
            bVar.invalidate();
        }
    }

    public void setShareText(String str) {
        if (TextUtils.equals(str, this.e)) {
            return;
        }
        removeView(this.d);
        b bVar = new b(getContext(), str);
        this.d = bVar;
        bVar.setContentDescription(str);
        addView(this.d, AbstractC13840gu3.b(-2, -2.0f));
        k();
    }

    public void setTagTooltip(final String str, final SA2 sa2) {
        this.a = new Runnable() { // from class: ir.nasim.up5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(str, sa2);
            }
        };
    }
}
