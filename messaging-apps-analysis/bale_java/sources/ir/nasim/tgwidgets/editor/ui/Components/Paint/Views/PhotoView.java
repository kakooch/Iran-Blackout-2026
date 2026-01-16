package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.C22697vg5;
import ir.nasim.C24687z23;
import ir.nasim.C9151Ys;
import ir.nasim.DK5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.SD6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;

/* loaded from: classes7.dex */
public class PhotoView extends EntityView {
    private String D0;
    private int E0;
    private boolean F0;
    private final C9151Ys G0;
    private SD6 H0;
    private a I0;
    public final ImageReceiver J0;

    public class PhotoViewSelectionView extends EntityView.SelectionView {
        private final Paint f;
        private Path g;

        public PhotoViewSelectionView(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.f = paint;
            this.g = new Path();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.SelectionView
        protected int a(float f, float f2) {
            float F = AbstractC21455b.F(1.0f);
            float F2 = AbstractC21455b.F(19.5f);
            float f3 = F + F2;
            float f4 = f3 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f4;
            float measuredHeight = getMeasuredHeight() - f4;
            float f5 = (measuredHeight / 2.0f) + f3;
            if (f > f3 - F2 && f2 > f5 - F2 && f < f3 + F2 && f2 < f5 + F2) {
                return 1;
            }
            float f6 = f3 + measuredWidth;
            if (f <= f6 - F2 || f2 <= f5 - F2 || f >= f6 + F2 || f2 >= f5 + F2) {
                return (f <= f3 || f >= measuredWidth || f2 <= f3 || f2 >= measuredHeight) ? 0 : 3;
            }
            return 2;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float F = AbstractC21455b.F(2.0f);
            float fH = AbstractC21455b.H(5.66f);
            float F2 = F + fH + AbstractC21455b.F(15.0f);
            float f = F2 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f;
            float measuredHeight = getMeasuredHeight() - f;
            RectF rectF = AbstractC21455b.x;
            float f2 = F2 + measuredWidth;
            float f3 = F2 + measuredHeight;
            rectF.set(F2, F2, f2, f3);
            float F3 = AbstractC21455b.F(12.0f);
            float fMin = Math.min(F3, measuredWidth / 2.0f);
            float f4 = measuredHeight / 2.0f;
            float fMin2 = Math.min(F3, f4);
            this.g.rewind();
            float f5 = fMin * 2.0f;
            float f6 = F2 + f5;
            float f7 = 2.0f * fMin2;
            float f8 = F2 + f7;
            rectF.set(F2, F2, f6, f8);
            this.g.arcTo(rectF, 180.0f, 90.0f);
            float f9 = f2 - f5;
            rectF.set(f9, F2, f2, f8);
            this.g.arcTo(rectF, 270.0f, 90.0f);
            canvas.drawPath(this.g, this.a);
            this.g.rewind();
            float f10 = f3 - f7;
            rectF.set(F2, f10, f6, f3);
            this.g.arcTo(rectF, 180.0f, -90.0f);
            rectF.set(f9, f10, f2, f3);
            this.g.arcTo(rectF, 90.0f, -90.0f);
            canvas.drawPath(this.g, this.a);
            float f11 = F2 + f4;
            canvas.drawCircle(F2, f11, fH, this.c);
            canvas.drawCircle(F2, f11, (fH - AbstractC21455b.F(1.0f)) + 1.0f, this.b);
            canvas.drawCircle(f2, f11, fH, this.c);
            canvas.drawCircle(f2, f11, (fH - AbstractC21455b.F(1.0f)) + 1.0f, this.b);
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255, 31);
            float f12 = F2 + fMin2;
            float f13 = f3 - fMin2;
            canvas.drawLine(F2, f12, F2, f13, this.a);
            canvas.drawLine(f2, f12, f2, f13, this.a);
            canvas.drawCircle(f2, f11, (AbstractC21455b.F(1.0f) + fH) - 1.0f, this.f);
            canvas.drawCircle(F2, f11, (fH + AbstractC21455b.F(1.0f)) - 1.0f, this.f);
            canvas.restore();
        }
    }

    private class a extends FrameLayout {
        public a(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            PhotoView.this.i0(canvas);
        }
    }

    public PhotoView(Context context, C22697vg5 c22697vg5, float f, float f2, SD6 sd6, String str, int i, int i2) throws InterruptedException {
        super(context, c22697vg5);
        this.E0 = -1;
        this.F0 = false;
        ImageReceiver imageReceiver = new ImageReceiver();
        this.J0 = imageReceiver;
        setRotation(f);
        setScale(f2);
        this.D0 = str;
        this.H0 = sd6;
        a aVar = new a(context);
        this.I0 = aVar;
        addView(aVar, AbstractC13840gu3.b(-1, -1.0f));
        this.G0 = new C9151Ys(this.I0, 0L, 500L, InterpolatorC12631ew1.h);
        imageReceiver.y0(true);
        imageReceiver.c1(true);
        imageReceiver.j1(this.I0);
        imageReceiver.k1(AbstractC21455b.F(12.0f));
        imageReceiver.g1(i, i2, true);
        Point point = AbstractC21455b.h;
        int iRound = Math.round((Math.min(point.x, point.y) * 0.8f) / AbstractC21455b.g);
        imageReceiver.O0(C24687z23.g(str), iRound + "_" + iRound, null, null, null, 1);
        b0();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected EntityView.SelectionView G() {
        return new PhotoViewSelectionView(getContext());
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected void b0() {
        SD6 sd6 = this.H0;
        float f = sd6.a / 2.0f;
        float f2 = sd6.b / 2.0f;
        setX(getPositionX() - f);
        setY(getPositionY() - f2);
        d0();
    }

    public boolean f0() {
        return this.F0;
    }

    public void g0() {
        h0(false);
    }

    public int getAnchor() {
        return this.E0;
    }

    public SD6 getBaseSize() {
        return this.H0;
    }

    public long getDuration() {
        RLottieDrawable rLottieDrawableJ = this.J0.J();
        if (rLottieDrawableJ != null) {
            return rLottieDrawableJ.I();
        }
        if (this.J0.k() != null) {
            return r0.x0();
        }
        return 0L;
    }

    public String getPath() {
        return this.D0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected DK5 getSelectionBounds() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return new DK5();
        }
        float scaleX = viewGroup.getScaleX();
        float measuredWidth = (getMeasuredWidth() * getScale()) + (AbstractC21455b.F(64.0f) / scaleX);
        float measuredHeight = (getMeasuredHeight() * getScale()) + (AbstractC21455b.F(64.0f) / scaleX);
        float positionX = (getPositionX() - (measuredWidth / 2.0f)) * scaleX;
        return new DK5(positionX, (getPositionY() - (measuredHeight / 2.0f)) * scaleX, ((measuredWidth * scaleX) + positionX) - positionX, measuredHeight * scaleX);
    }

    public void h0(boolean z) {
        boolean z2 = !this.F0;
        this.F0 = z2;
        if (!z) {
            this.G0.f(z2, true);
        }
        this.I0.invalidate();
    }

    protected void i0(Canvas canvas) {
        if (this.I0 == null) {
            return;
        }
        canvas.save();
        float fE = this.G0.e(this.F0);
        canvas.scale(1.0f - (fE * 2.0f), 1.0f, this.H0.a / 2.0f, 0.0f);
        canvas.skew(0.0f, 4.0f * fE * (1.0f - fE) * 0.25f);
        ImageReceiver imageReceiver = this.J0;
        SD6 sd6 = this.H0;
        imageReceiver.Y0(0.0f, 0.0f, (int) sd6.a, (int) sd6.b);
        this.J0.e(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.J0.q0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.J0.s0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.H0.a, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.H0.b, 1073741824));
    }
}
