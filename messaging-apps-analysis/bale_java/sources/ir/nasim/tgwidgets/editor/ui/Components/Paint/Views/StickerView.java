package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC18697p57;
import ir.nasim.C18390oa7;
import ir.nasim.C22697vg5;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.C9151Ys;
import ir.nasim.DK5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.J77;
import ir.nasim.SD6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;

/* loaded from: classes7.dex */
public class StickerView extends EntityView {
    private AbstractC18106o57 D0;
    private Object E0;
    private int F0;
    private boolean G0;
    private final C9151Ys H0;
    private SD6 I0;
    private a J0;
    public final ImageReceiver K0;

    public class StickerViewSelectionView extends EntityView.SelectionView {
        private RectF f;

        public StickerViewSelectionView(Context context) {
            super(context);
            this.f = new RectF();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.SelectionView
        protected int a(float f, float f2) {
            float F = AbstractC21455b.F(1.0f);
            float F2 = AbstractC21455b.F(19.5f);
            float f3 = F + F2;
            float f4 = f3 * 2.0f;
            float measuredHeight = ((getMeasuredHeight() - f4) / 2.0f) + f3;
            if (f > f3 - F2 && f2 > measuredHeight - F2 && f < f3 + F2 && f2 < measuredHeight + F2) {
                return 1;
            }
            if (f > ((getMeasuredWidth() - f4) + f3) - F2 && f2 > measuredHeight - F2 && f < f3 + (getMeasuredWidth() - f4) + F2 && f2 < measuredHeight + F2) {
                return 2;
            }
            float measuredWidth = getMeasuredWidth() / 2.0f;
            return Math.pow((double) (f - measuredWidth), 2.0d) + Math.pow((double) (f2 - measuredWidth), 2.0d) < Math.pow((double) measuredWidth, 2.0d) ? 3 : 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float F = AbstractC21455b.F(1.0f);
            float fH = AbstractC21455b.H(5.66f);
            float F2 = F + fH + AbstractC21455b.F(15.0f);
            float measuredWidth = (getMeasuredWidth() / 2) - F2;
            float f = F2 + (2.0f * measuredWidth);
            this.f.set(F2, F2, f, f);
            canvas.drawArc(this.f, 0.0f, 180.0f, false, this.a);
            canvas.drawArc(this.f, 180.0f, 180.0f, false, this.a);
            float f2 = measuredWidth + F2;
            canvas.drawCircle(F2, f2, fH, this.c);
            canvas.drawCircle(F2, f2, fH - AbstractC21455b.F(1.0f), this.b);
            canvas.drawCircle(f, f2, fH, this.c);
            canvas.drawCircle(f, f2, fH - AbstractC21455b.F(1.0f), this.b);
        }
    }

    private class a extends FrameLayout {
        public a(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            StickerView.this.l0(canvas);
        }
    }

    public StickerView(Context context, C22697vg5 c22697vg5, float f, float f2, SD6 sd6, AbstractC18106o57 abstractC18106o57, Object obj) throws InterruptedException {
        super(context, c22697vg5);
        this.F0 = -1;
        int i = 0;
        this.G0 = false;
        this.K0 = new ImageReceiver();
        setRotation(f);
        setScale(f2);
        this.D0 = abstractC18106o57;
        this.I0 = sd6;
        this.E0 = obj;
        while (true) {
            if (i >= abstractC18106o57.p.size()) {
                break;
            }
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i);
            if (abstractC18697p57 instanceof J77) {
                C18390oa7 c18390oa7 = abstractC18697p57.f;
                if (c18390oa7 != null) {
                    this.F0 = c18390oa7.b;
                }
            } else {
                i++;
            }
        }
        a aVar = new a(context);
        this.J0 = aVar;
        addView(aVar, AbstractC13840gu3.b(-1, -1.0f));
        this.H0 = new C9151Ys(this.J0, 0L, 500L, InterpolatorC12631ew1.h);
        this.K0.y0(true);
        this.K0.c1(true);
        this.K0.j1(this.J0);
        this.K0.T0(C24687z23.b(abstractC18106o57), null, C24687z23.c(C4278El2.y(abstractC18106o57.k, 90), abstractC18106o57), null, "webp", obj, 1);
        this.K0.H0(new ImageReceiver.c() { // from class: ir.nasim.wN6
            @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver.c
            public final void a(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
                this.a.i0(imageReceiver, z, z2, z3);
            }
        });
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        RLottieDrawable rLottieDrawableJ;
        if (!z || z2 || (rLottieDrawableJ = imageReceiver.J()) == null) {
            return;
        }
        g0(rLottieDrawableJ);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected EntityView.SelectionView G() {
        return new StickerViewSelectionView(getContext());
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected void b0() {
        SD6 sd6 = this.I0;
        float f = sd6.a / 2.0f;
        float f2 = sd6.b / 2.0f;
        setX(getPositionX() - f);
        setY(getPositionY() - f2);
        d0();
    }

    protected void g0(RLottieDrawable rLottieDrawable) {
    }

    public int getAnchor() {
        return this.F0;
    }

    public SD6 getBaseSize() {
        return this.I0;
    }

    public long getDuration() {
        RLottieDrawable rLottieDrawableJ = this.K0.J();
        if (rLottieDrawableJ != null) {
            return rLottieDrawableJ.I();
        }
        if (this.K0.k() != null) {
            return r0.x0();
        }
        return 0L;
    }

    public Object getParentObject() {
        return this.E0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView
    protected DK5 getSelectionBounds() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return new DK5();
        }
        float scaleX = viewGroup.getScaleX();
        float measuredWidth = getMeasuredWidth() * (getScale() + 0.5f);
        float f = measuredWidth / 2.0f;
        float f2 = measuredWidth * scaleX;
        return new DK5((getPositionX() - f) * scaleX, (getPositionY() - f) * scaleX, f2, f2);
    }

    public AbstractC18106o57 getSticker() {
        return this.D0;
    }

    public boolean h0() {
        return this.G0;
    }

    public void j0() {
        k0(false);
    }

    public void k0(boolean z) {
        boolean z2 = !this.G0;
        this.G0 = z2;
        if (!z) {
            this.H0.f(z2, true);
        }
        this.J0.invalidate();
    }

    protected void l0(Canvas canvas) {
        if (this.J0 == null) {
            return;
        }
        canvas.save();
        float fE = this.H0.e(this.G0);
        canvas.scale(1.0f - (fE * 2.0f), 1.0f, this.I0.a / 2.0f, 0.0f);
        canvas.skew(0.0f, 4.0f * fE * (1.0f - fE) * 0.25f);
        ImageReceiver imageReceiver = this.K0;
        SD6 sd6 = this.I0;
        imageReceiver.Y0(0.0f, 0.0f, (int) sd6.a, (int) sd6.b);
        this.K0.e(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.K0.q0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.K0.s0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.I0.a, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.I0.b, 1073741824));
    }

    public StickerView(Context context, StickerView stickerView, C22697vg5 c22697vg5) {
        this(context, c22697vg5, stickerView.getRotation(), stickerView.getScale(), stickerView.I0, stickerView.D0, stickerView.E0);
        if (stickerView.G0) {
            j0();
        }
    }
}
