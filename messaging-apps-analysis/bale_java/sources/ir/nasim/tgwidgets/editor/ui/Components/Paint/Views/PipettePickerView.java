package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* loaded from: classes7.dex */
public class PipettePickerView extends View {
    private Bitmap a;
    private Paint b;
    private Paint c;
    private Paint d;
    private float e;
    private float f;
    private Path g;
    private Rect h;
    private RectF i;
    private int j;
    private boolean k;
    private InterfaceC25043ze1 l;
    private float m;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PipettePickerView.this.j();
            if (this.a) {
                PipettePickerView.this.l.accept(Integer.valueOf(PipettePickerView.this.j));
            }
            if (PipettePickerView.this.getParent() != null) {
                ((ViewGroup) PipettePickerView.this.getParent()).removeView(PipettePickerView.this);
            }
        }
    }

    public PipettePickerView(Context context, Bitmap bitmap) {
        super(context);
        this.b = new Paint(1);
        this.c = new Paint(1);
        this.d = new Paint(1);
        this.e = 0.5f;
        this.f = 0.5f;
        this.g = new Path();
        this.h = new Rect();
        this.i = new RectF();
        this.a = bitmap;
        Paint paint = this.b;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.b.setStrokeWidth(AbstractC21455b.F(4.0f));
        this.b.setColor(-1);
        this.c.setStyle(style);
        this.c.setStrokeWidth(AbstractC21455b.F(1.0f));
        this.c.setColor(-1711276033);
        this.d.setStyle(style);
        this.d.setStrokeWidth(AbstractC21455b.F(12.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ValueAnimator valueAnimator) {
        this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void k(MotionEvent motionEvent) {
        this.e = motionEvent.getX() / getWidth();
        this.f = motionEvent.getY() / getHeight();
        invalidate();
    }

    public void e(boolean z) {
        if (this.k) {
            return;
        }
        this.k = true;
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(150L);
        duration.setInterpolator(InterpolatorC12631ew1.f);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.pe5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.g(valueAnimator);
            }
        });
        duration.addListener(new a(z));
        duration.start();
    }

    public void f() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        duration.setInterpolator(InterpolatorC12631ew1.f);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.qe5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.h(valueAnimator);
            }
        });
        duration.start();
        i();
    }

    protected void i() {
    }

    protected void j() {
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
        this.a.recycle();
        this.a = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fMin = Math.min(getWidth(), getHeight()) * 0.2f;
        float width = this.e * getWidth();
        float height = this.f * getHeight();
        int iRound = Math.round(this.e * this.a.getWidth());
        int iRound2 = Math.round(this.f * this.a.getHeight());
        Bitmap bitmap = this.a;
        int pixel = bitmap.getPixel(Utilities.d(iRound, bitmap.getWidth(), 0), Utilities.d(iRound2, this.a.getHeight(), 0));
        this.j = pixel;
        this.d.setColor(pixel);
        float f = this.m;
        if (f == 0.0f || f == 1.0f) {
            canvas.save();
        } else {
            RectF rectF = AbstractC21455b.x;
            rectF.set(width - fMin, height - fMin, width + fMin, height + fMin);
            canvas.saveLayerAlpha(rectF, (int) (this.m * 255.0f), 31);
        }
        float f2 = (this.m * 0.5f) + 0.5f;
        canvas.scale(f2, f2, width, height);
        this.g.rewind();
        Path path = this.g;
        Path.Direction direction = Path.Direction.CW;
        path.addCircle(width, height, fMin, direction);
        canvas.clipPath(this.g);
        int iRound3 = Math.round(3.5f);
        this.h.set(iRound - iRound3, iRound2 - iRound3, iRound + iRound3, iRound2 + iRound3);
        this.i.set(width - fMin, height - fMin, width + fMin, height + fMin);
        canvas.drawBitmap(this.a, this.h, this.i, (Paint) null);
        float strokeWidth = fMin - (this.d.getStrokeWidth() / 2.0f);
        canvas.drawCircle(width, height, strokeWidth, this.d);
        float strokeWidth2 = (strokeWidth - (this.d.getStrokeWidth() / 2.0f)) - (this.b.getStrokeWidth() / 2.0f);
        canvas.drawCircle(width, height, strokeWidth2, this.b);
        float strokeWidth3 = strokeWidth2 - (this.b.getStrokeWidth() / 2.0f);
        this.g.rewind();
        this.g.addCircle(width, height, strokeWidth3, direction);
        canvas.clipPath(this.g);
        float f3 = (strokeWidth3 * 2.0f) / 8.0f;
        this.g.rewind();
        for (float f4 = -3.5f; f4 < 4.5f; f4 += 1.0f) {
            float f5 = (f4 * f3) + width;
            this.g.moveTo(f5, height - strokeWidth3);
            this.g.lineTo(f5, height + strokeWidth3);
        }
        for (float f6 = -3.5f; f6 < 4.5f; f6 += 1.0f) {
            float f7 = (f6 * f3) + height;
            this.g.moveTo(width - strokeWidth3, f7);
            this.g.lineTo(width + strokeWidth3, f7);
        }
        canvas.drawPath(this.g, this.c);
        float f8 = f3 / 2.0f;
        this.i.set(width - f8, height - f8, width + f8, height + f8);
        canvas.drawRoundRect(this.i, AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f), this.b);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == 0 || i2 == 0 || i3 == 0 || i4 == 0 || !isLaidOut()) {
            return;
        }
        this.e = (i3 * this.e) / i;
        this.f = (i4 * this.f) / i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            k(motionEvent);
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (actionMasked == 1) {
            e(true);
        } else if (actionMasked == 2) {
            k(motionEvent);
        } else if (actionMasked == 3) {
            e(false);
        }
        return true;
    }

    public void setColorListener(InterfaceC25043ze1 interfaceC25043ze1) {
        this.l = interfaceC25043ze1;
    }
}
