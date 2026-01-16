package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* loaded from: classes7.dex */
public class PhotoVideoSwitcherView extends View {
    private TextPaint a;
    private Paint b;
    private StaticLayout c;
    private StaticLayout d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private VelocityTracker l;
    private int m;
    private float n;
    private long o;
    private boolean p;
    private boolean q;
    private ValueAnimator r;
    private float s;
    private Utilities.b t;
    private Utilities.b u;
    private RectF v;
    private RectF w;
    private RectF x;
    private float y;
    private boolean z;

    public PhotoVideoSwitcherView(Context context) {
        super(context);
        this.a = new TextPaint(1);
        this.b = new Paint(1);
        this.v = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.b.setColor(855638015);
        this.a.setColor(-1);
        this.a.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.a.setTextSize(AbstractC21455b.H(14.0f));
        this.a.setShadowLayer(AbstractC21455b.H(1.0f), 0.0f, AbstractC21455b.H(0.4f), 855638016);
        String strE = FH3.E("StoryPhoto", TD5.tgwidget_StoryPhoto);
        strE = strE == null ? "Photo" : strE;
        TextPaint textPaint = this.a;
        int i = AbstractC21455b.h.x / 2;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        StaticLayout staticLayout = new StaticLayout(strE, textPaint, i, alignment, 1.0f, 0.0f, false);
        this.c = staticLayout;
        this.e = staticLayout.getLineCount() > 0 ? this.c.getLineLeft(0) : 0.0f;
        this.f = this.c.getLineCount() > 0 ? this.c.getLineWidth(0) : 0.0f;
        this.g = this.c.getHeight();
        String strE2 = FH3.E("StoryVideo", TD5.tgwidget_StoryVideo);
        StaticLayout staticLayout2 = new StaticLayout(strE2 == null ? "Video" : strE2, this.a, AbstractC21455b.h.x / 2, alignment, 1.0f, 0.0f, false);
        this.d = staticLayout2;
        this.h = staticLayout2.getLineCount() > 0 ? this.d.getLineLeft(0) : 0.0f;
        this.i = this.d.getLineCount() > 0 ? this.d.getLineWidth(0) : 0.0f;
        this.j = this.d.getHeight();
        this.k = AbstractC21455b.F(32.0f) + (this.f / 2.0f) + (this.i / 2.0f);
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.s = fFloatValue;
        Utilities.b bVar = this.u;
        if (bVar != null) {
            bVar.a(Float.valueOf(Utilities.c(fFloatValue, 1.0f, 0.0f)));
        }
        invalidate();
    }

    private float getScrollCx() {
        return (getWidth() / 2.0f) + AbstractC21455b.T0(AbstractC21455b.F(16.0f) + (this.f / 2.0f), -(AbstractC21455b.F(16.0f) + (this.i / 2.0f)), this.s);
    }

    public void c(float f) {
        if (!this.p && Math.abs(f) > this.m) {
            this.p = true;
            this.y = this.s;
        }
        if (this.p) {
            float f2 = this.s;
            if ((f2 <= 0.0f && f < 0.0f) || (f2 >= 1.0f && f > 0.0f)) {
                f *= 0.2f;
            }
            float f3 = f2 + ((f / this.k) / 2.5f);
            this.s = f3;
            float fC = Utilities.c(f3, 1.2f, -0.2f);
            this.s = fC;
            Utilities.b bVar = this.u;
            if (bVar != null) {
                bVar.a(Float.valueOf(Utilities.c(fC, 1.0f, 0.0f)));
            }
            invalidate();
        }
    }

    public boolean d(float f) {
        if (!this.p) {
            this.z = false;
            return false;
        }
        this.p = false;
        boolean z = Math.abs(f) <= 500.0f ? this.s > 0.5f : f < 0.0f;
        e(z);
        Utilities.b bVar = this.t;
        if (bVar != null) {
            bVar.a(Boolean.valueOf(z));
        }
        this.z = false;
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float height = getHeight() / 2.0f;
        float scrollCx = getScrollCx();
        int i = -AbstractC21455b.F(1.0f);
        float F = AbstractC21455b.F(26.0f) / 2.0f;
        float f = i;
        float f2 = (height - F) + f;
        float f3 = height + F + f;
        this.v.set((scrollCx - AbstractC21455b.F(28.0f)) - this.f, f2, scrollCx - AbstractC21455b.F(4.0f), f3);
        this.w.set(AbstractC21455b.F(4.0f) + scrollCx, f2, AbstractC21455b.F(28.0f) + scrollCx + this.i, f3);
        AbstractC21455b.W0(this.v, this.w, Utilities.c(this.s, 1.025f, -0.025f), this.x);
        canvas.drawRoundRect(this.x, F, F, this.b);
        canvas.save();
        canvas.translate(((scrollCx - AbstractC21455b.F(16.0f)) - this.f) - this.e, (height - (this.g / 2.0f)) + f);
        this.c.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate((scrollCx + AbstractC21455b.F(16.0f)) - this.h, (height - (this.j / 2.0f)) + f);
        this.d.draw(canvas);
        canvas.restore();
    }

    public void e(boolean z) {
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.s, z ? 1.0f : 0.0f);
        this.r = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.I95
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.b(valueAnimator2);
            }
        });
        this.r.setDuration(320L);
        this.r.setInterpolator(InterpolatorC12631ew1.h);
        this.r.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.l
            if (r0 != 0) goto La
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.l = r0
        La:
            android.view.VelocityTracker r0 = r6.l
            r0.addMovement(r7)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L98
            if (r0 == r1) goto L2d
            r2 = 2
            if (r0 == r2) goto L20
            r2 = 3
            if (r0 == r2) goto L2d
            goto L93
        L20:
            float r0 = r7.getX()
            float r1 = r6.n
            float r1 = r1 - r0
            r6.c(r1)
            r6.n = r0
            goto L93
        L2d:
            r0 = 0
            r6.q = r0
            android.view.VelocityTracker r2 = r6.l
            if (r2 == 0) goto L40
            r3 = 1000(0x3e8, float:1.401E-42)
            r2.computeCurrentVelocity(r3)
            android.view.VelocityTracker r2 = r6.l
            float r2 = r2.getXVelocity()
            goto L41
        L40:
            r2 = 0
        L41:
            boolean r2 = r6.d(r2)
            if (r2 != 0) goto L89
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r6.o
            long r2 = r2 - r4
            int r4 = android.view.ViewConfiguration.getTapTimeout()
            long r4 = (long) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L89
            float r2 = r7.getX()
            float r3 = r6.n
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            r3 = 1082130432(0x40800000, float:4.0)
            int r3 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r3)
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L89
            float r2 = r7.getX()
            float r3 = r6.getScrollCx()
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L7a
            goto L7b
        L7a:
            r1 = r0
        L7b:
            r6.e(r1)
            ir.nasim.tgwidgets.editor.messenger.Utilities$b r2 = r6.t
            if (r2 == 0) goto L89
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.a(r1)
        L89:
            android.view.VelocityTracker r1 = r6.l
            r1.recycle()
            r1 = 0
            r6.l = r1
            r6.z = r0
        L93:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        L98:
            r6.q = r1
            float r0 = r6.s
            r6.y = r0
            long r2 = java.lang.System.currentTimeMillis()
            r6.o = r2
            float r7 = r7.getX()
            r6.n = r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.PhotoVideoSwitcherView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSwitchModeListener(Utilities.b bVar) {
        this.t = bVar;
    }

    public void setOnSwitchingModeListener(Utilities.b bVar) {
        this.u = bVar;
    }
}
