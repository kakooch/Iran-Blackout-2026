package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC18697p57;
import ir.nasim.AbstractC18973pa;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24131y57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.C10743c74;
import ir.nasim.C16463lJ6;
import ir.nasim.C17574nB7;
import ir.nasim.C17645nJ6;
import ir.nasim.C18390oa7;
import ir.nasim.C19136pq2;
import ir.nasim.C22697vg5;
import ir.nasim.C24749z85;
import ir.nasim.C4278El2;
import ir.nasim.FH3;
import ir.nasim.G37;
import ir.nasim.HU1;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.J77;
import ir.nasim.LU4;
import ir.nasim.PX0;
import ir.nasim.Q87;
import ir.nasim.QY0;
import ir.nasim.R62;
import ir.nasim.SD6;
import ir.nasim.T45;
import ir.nasim.TD5;
import ir.nasim.YZ2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21456c;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.C21463b;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.LPhotoPaintView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class LPhotoPaintView extends SizeNotifierFrameLayoutPhoto implements YZ2, PaintToolsView.b, EntityView.g, PaintTextOptionsView.b, SizeNotifierFrameLayoutPhoto.a, E.d {
    private EntityView A;
    private EntitiesContainerView A0;
    private int[] A1;
    private boolean B;
    private FrameLayout B0;
    private boolean B1;
    private FrameLayout C0;
    private boolean C1;
    private int D;
    private FrameLayout D0;
    private boolean D1;
    private FrameLayout E0;
    private boolean E1;
    private LinearLayout F0;
    private int F1;
    private boolean G;
    private int G0;
    private boolean G1;
    private RenderView H;
    private int H0;
    private int H1;
    private float I0;
    private int I1;
    private View J;
    private ValueAnimator J0;
    private boolean J1;
    private boolean K0;
    private int K1;
    private PaintWeightChooserView L0;
    private boolean L1;
    private ArrayList M0;
    private boolean M1;
    private int N0;
    private Runnable N1;
    private BigInteger O0;
    AbstractC18973pa O1;
    private TextView P0;
    private TextView Q0;
    private TextView R0;
    private PaintToolsView S0;
    private PaintTextOptionsView T0;
    private PaintTypefaceListView U0;
    private ImageView V0;
    private LinearLayout W0;
    private ImageView X0;
    private TextView Y0;
    private TextView Z0;
    private TextView a1;
    private TextView b1;
    private Paint c1;
    private Paint d1;
    private float e1;
    private boolean f1;
    private PaintCancelView g;
    private C16463lJ6 g1;
    private PaintDoneView h;
    private PaintColorsListView h1;
    private float i;
    private Paint i1;
    private Bitmap j;
    private Paint j1;
    private Bitmap k;
    private Paint k1;
    private C17574nB7 l;
    private G37 l1;
    private HU1 m;
    private boolean m1;
    private MediaController.i n;
    private boolean n1;
    private float o;
    private C16463lJ6 o1;
    private float p;
    private float p1;
    private float q;
    private Paint q1;
    private float r;
    private int r1;
    private float s;
    private PaintWeightChooserView.b s1;
    private float t;
    private m.h t1;
    private float u;
    private ActionBarPopupWindow u1;
    private float v;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout v1;
    private float w;
    private Rect w1;
    private boolean x;
    private Runnable x1;
    private float y;
    private boolean y1;
    private SD6 z;
    private FrameLayout z0;
    private float[] z1;

    public class PopupButton extends LinearLayout {
        public TextView a;
        FrameLayout b;
        ImageView c;
        ImageView d;
        float e;
        boolean f;
        ValueAnimator g;
        ImageView h;

        class a extends FrameLayout {
            Path a;
            final /* synthetic */ LPhotoPaintView b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, LPhotoPaintView lPhotoPaintView) {
                super(context);
                this.b = lPhotoPaintView;
                this.a = new Path();
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean z;
                PopupButton popupButton = PopupButton.this;
                if (popupButton.g == null || (!((z = popupButton.f) && view == popupButton.d) && (z || view != popupButton.c))) {
                    return super.drawChild(canvas, view, j);
                }
                float measuredWidth = ((z ? popupButton.e : 1.0f - popupButton.e) * getMeasuredWidth()) / 2.0f;
                canvas.save();
                this.a.rewind();
                this.a.addCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, measuredWidth, Path.Direction.CW);
                canvas.clipPath(this.a);
                boolean zDrawChild = super.drawChild(canvas, view, j);
                canvas.restore();
                return zDrawChild;
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PopupButton popupButton = PopupButton.this;
                ImageView imageView = popupButton.c;
                popupButton.c = popupButton.d;
                popupButton.d = imageView;
                imageView.bringToFront();
                PopupButton.this.d.setVisibility(8);
                PopupButton.this.g = null;
            }
        }

        public PopupButton(Context context) {
            super(context);
            setOrientation(0);
            setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.u0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4, LPhotoPaintView.this.t1), false));
            a aVar = new a(context, LPhotoPaintView.this);
            this.b = aVar;
            addView(aVar, AbstractC13840gu3.n(-2, -2, 19, 16, 0, 16, 0));
            ImageView imageView = new ImageView(context);
            this.c = imageView;
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
            imageView.setScaleType(scaleType);
            ImageView imageView2 = this.c;
            int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
            imageView2.setColorFilter(LPhotoPaintView.this.K1(i));
            this.b.addView(this.c, AbstractC13840gu3.d(-2, -2, 17));
            ImageView imageView3 = new ImageView(context);
            this.d = imageView3;
            imageView3.setScaleType(scaleType);
            this.d.setColorFilter(LPhotoPaintView.this.K1(i));
            this.d.setVisibility(8);
            this.b.addView(this.d, AbstractC13840gu3.d(-2, -2, 17));
            TextView textView = new TextView(context);
            this.a = textView;
            textView.setTextColor(LPhotoPaintView.this.K1(i));
            this.a.setTextSize(1, 16.0f);
            addView(this.a, AbstractC13840gu3.n(-2, -2, 19, 16, 0, 16, 0));
            ImageView imageView4 = new ImageView(context);
            this.h = imageView4;
            imageView4.setImageResource(AbstractC23598xB5.msg_text_check);
            this.h.setScaleType(scaleType);
            this.h.setColorFilter(new PorterDuffColorFilter(LPhotoPaintView.this.K1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q5), PorterDuff.Mode.MULTIPLY));
            this.h.setVisibility(8);
            addView(this.h, AbstractC13840gu3.g(50, -1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.e = fFloatValue;
            if (!z) {
                this.c.setAlpha(1.0f - fFloatValue);
            }
            this.b.invalidate();
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (LPhotoPaintView.this.u1 != null && LPhotoPaintView.this.u1.isShowing()) {
                LPhotoPaintView.this.u1.k(true);
            }
            return super.performClick();
        }

        public void setIcon(int i) {
            setIcon(i, true, false);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            this.h.setVisibility(z ? 0 : 8);
        }

        public void setText(CharSequence charSequence) {
            this.a.setText(charSequence);
        }

        public void setIcon(int i, final boolean z, boolean z2) {
            if (!z2) {
                this.c.setImageResource(i);
                return;
            }
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.g = null;
                setIcon(i, false, false);
                return;
            }
            this.f = z;
            this.d.setImageResource(i);
            this.d.setVisibility(0);
            this.d.setAlpha(1.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Cs3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.b(z, valueAnimator2);
                }
            });
            this.g.addListener(new b());
            this.g.setInterpolator(InterpolatorC12631ew1.h);
            this.g.setDuration(420L);
            this.g.start();
        }
    }

    class a extends PaintColorsListView {
        private Path c3;

        a(Context context) {
            super(context);
            this.c3 = new Path();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void draw(Canvas canvas) {
            ViewGroup barView = LPhotoPaintView.this.getBarView();
            RectF rectF = AbstractC21455b.x;
            rectF.set(AbstractC21455b.U0(barView.getLeft() - getLeft(), 0, LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getTop() - getTop(), 0, LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getRight() - getLeft(), getWidth(), LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getBottom() - getTop(), getHeight(), LPhotoPaintView.this.p1));
            this.c3.rewind();
            this.c3.addRoundRect(rectF, AbstractC21455b.F(32.0f), AbstractC21455b.F(32.0f), Path.Direction.CW);
            canvas.save();
            canvas.clipPath(this.c3);
            super.draw(canvas);
            canvas.restore();
        }
    }

    class b implements PX0.h {
        private boolean a;
        final /* synthetic */ Bitmap b;
        final /* synthetic */ int c;

        b(Bitmap bitmap, int i) {
            this.b = bitmap;
            this.c = i;
        }

        @Override // ir.nasim.PX0.h
        public void a() {
            this.a = true;
        }

        @Override // ir.nasim.PX0.h
        public boolean b() {
            return this.a;
        }

        @Override // ir.nasim.PX0.h
        public void c() {
            this.a = false;
        }

        @Override // ir.nasim.PX0.h
        public void d(int i) {
            LPhotoPaintView.this.H2(false);
            T45.h(this.c).l(i);
            T45.h(this.c).k();
            LPhotoPaintView.this.setNewColor(i);
            LPhotoPaintView.this.h1.getAdapter().notifyDataSetChanged();
        }

        @Override // ir.nasim.PX0.h
        public void e(Bitmap bitmap, Canvas canvas) {
            Matrix matrix = LPhotoPaintView.this.H.getMatrix();
            canvas.save();
            canvas.translate(LPhotoPaintView.this.H.getX(), LPhotoPaintView.this.H.getY());
            canvas.concat(matrix);
            canvas.scale(LPhotoPaintView.this.H.getWidth() / this.b.getWidth(), LPhotoPaintView.this.H.getHeight() / this.b.getHeight(), 0.0f, 0.0f);
            canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }

        @Override // ir.nasim.PX0.h
        public View f() {
            return LPhotoPaintView.this;
        }

        @Override // ir.nasim.PX0.h
        public ViewGroup g() {
            return LPhotoPaintView.this.E0;
        }

        @Override // ir.nasim.PX0.h
        public boolean h() {
            return this.b != null;
        }
    }

    class c implements PaintWeightChooserView.b {
        final /* synthetic */ TextPaintView a;
        final /* synthetic */ float b;

        c(TextPaintView textPaintView, float f) {
            this.a = textPaintView;
            this.b = f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public void a(float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.setBaseFontSize((int) (this.b * f));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public float get() {
            return this.a.getBaseFontSize() / this.b;
        }
    }

    class d extends LinearLayout {
        Paint a;

        d(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setStrokeWidth(AbstractC21455b.F(2.0f));
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            setWillNotDraw(false);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            TextView textView = (TextView) getChildAt(LPhotoPaintView.this.G0);
            TextView textView2 = LPhotoPaintView.this.H0 != -1 ? (TextView) getChildAt(LPhotoPaintView.this.H0) : null;
            this.a.setColor(textView.getCurrentTextColor());
            float y = ((textView.getY() + textView.getHeight()) - textView.getPaddingBottom()) + AbstractC21455b.F(3.0f);
            Layout layout = textView.getLayout();
            Layout layout2 = textView2 != null ? textView2.getLayout() : null;
            float interpolation = layout2 == null ? 0.0f : InterpolatorC12631ew1.f.getInterpolation(LPhotoPaintView.this.I0);
            float fT0 = AbstractC21455b.T0(textView.getX() + layout.getPrimaryHorizontal(layout.getLineStart(0)), textView2 != null ? textView2.getX() + layout2.getPrimaryHorizontal(layout.getLineStart(0)) : 0.0f, interpolation);
            canvas.drawLine(fT0, y, fT0 + AbstractC21455b.T0(layout.getPrimaryHorizontal(layout.getLineEnd(0)) - layout.getPrimaryHorizontal(layout.getLineStart(0)), layout2 != null ? layout2.getPrimaryHorizontal(layout2.getLineEnd(0)) - layout2.getPrimaryHorizontal(layout2.getLineStart(0)) : 0.0f, interpolation), y, this.a);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;

        e(View view, View view2, int i) {
            this.a = view;
            this.b = view2;
            this.c = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LPhotoPaintView lPhotoPaintView = LPhotoPaintView.this;
            lPhotoPaintView.G0 = lPhotoPaintView.H0;
            LPhotoPaintView.this.H0 = -1;
            LPhotoPaintView.this.F0.invalidate();
            View view = this.a;
            if (view != null && this.b != null) {
                view.setVisibility(8);
            }
            if (animator == LPhotoPaintView.this.J0) {
                LPhotoPaintView.this.J0 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view;
            if (this.a != null && (view = this.b) != null) {
                view.setVisibility(0);
            }
            if (this.c == 2) {
                LPhotoPaintView.this.L0.setMinMax(0.5f, 2.0f);
                return;
            }
            ir.nasim.tgwidgets.editor.ui.Components.Paint.a currentBrush = LPhotoPaintView.this.H.getCurrentBrush();
            if ((currentBrush instanceof a.b) || (currentBrush instanceof a.d)) {
                LPhotoPaintView.this.L0.setMinMax(0.4f, 1.75f);
            } else {
                LPhotoPaintView.this.L0.setMinMax(0.05f, 1.0f);
            }
        }
    }

    class f extends StickerView {
        f(Context context, C22697vg5 c22697vg5, float f, float f2, SD6 sd6, AbstractC18106o57 abstractC18106o57, Object obj) {
            super(context, c22697vg5, f, f2, sd6, abstractC18106o57, obj);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.StickerView
        protected void g0(RLottieDrawable rLottieDrawable) {
            LPhotoPaintView.this.E1(rLottieDrawable);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LPhotoPaintView.this.A instanceof TextPaintView) {
                EditTextOutline editText = ((TextPaintView) LPhotoPaintView.this.A).getEditText();
                if (LPhotoPaintView.this.M1 || editText == null || !LPhotoPaintView.this.J1 || LPhotoPaintView.this.D1 || AbstractC21455b.r || AbstractC21455b.s || !AbstractC21455b.F0()) {
                    return;
                }
                editText.requestFocus();
                AbstractC21455b.C1(editText);
                AbstractC21455b.t(LPhotoPaintView.this.N1);
                AbstractC21455b.n1(LPhotoPaintView.this.N1, 100L);
            }
        }
    }

    class h extends AbstractC18973pa {
        h(View view, boolean z) {
            super(view, z);
        }

        @Override // ir.nasim.AbstractC18973pa
        protected boolean m() {
            return (LPhotoPaintView.this.M1 || LPhotoPaintView.this.B1) ? false : true;
        }

        @Override // ir.nasim.AbstractC18973pa
        protected void q(float f, float f2, boolean z) {
            LPhotoPaintView.this.B0.setTranslationY(f);
            LPhotoPaintView.this.o = 1.0f - f2;
            LPhotoPaintView.this.p = f / 2.0f;
            LPhotoPaintView.this.C0.setTranslationY(AbstractC21455b.F(40.0f) * f2);
            LPhotoPaintView.this.L0.m(f, f2);
            LPhotoPaintView lPhotoPaintView = LPhotoPaintView.this;
            lPhotoPaintView.setTransform(lPhotoPaintView.q, LPhotoPaintView.this.r, LPhotoPaintView.this.s, LPhotoPaintView.this.v, LPhotoPaintView.this.w);
            super.q(f, f2, z);
            ((View) LPhotoPaintView.this.getParent()).invalidate();
        }

        @Override // ir.nasim.AbstractC18973pa
        protected void r() {
            LPhotoPaintView.this.p = 0.0f;
            LPhotoPaintView.this.C1 = false;
            LPhotoPaintView lPhotoPaintView = LPhotoPaintView.this;
            lPhotoPaintView.setTransform(lPhotoPaintView.q, LPhotoPaintView.this.r, LPhotoPaintView.this.s, LPhotoPaintView.this.v, LPhotoPaintView.this.w);
            super.r();
            LPhotoPaintView.this.L0.l();
        }

        @Override // ir.nasim.AbstractC18973pa
        protected void t(boolean z, int i, int i2) {
            super.s(z, i2);
            LPhotoPaintView.this.L0.k(i, i2);
            if (LPhotoPaintView.this.n1) {
                LPhotoPaintView.this.H2(false);
            }
        }
    }

    class i implements PaintWeightChooserView.b {
        i() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public void a(float f) {
            T45.h(LPhotoPaintView.this.r1).s(String.valueOf(ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.indexOf(LPhotoPaintView.this.H.getCurrentBrush())), f);
            LPhotoPaintView.this.l1.c = f;
            LPhotoPaintView lPhotoPaintView = LPhotoPaintView.this;
            lPhotoPaintView.F2(lPhotoPaintView.l1, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public float get() {
            ir.nasim.tgwidgets.editor.ui.Components.Paint.a currentBrush = LPhotoPaintView.this.H.getCurrentBrush();
            return currentBrush == null ? T45.h(LPhotoPaintView.this.r1).f() : T45.h(LPhotoPaintView.this.r1).i(String.valueOf(ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.indexOf(currentBrush)), currentBrush.c());
        }
    }

    class j extends RenderView {
        final /* synthetic */ Bitmap o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Context context, ir.nasim.tgwidgets.editor.ui.Components.Paint.d dVar, Bitmap bitmap, Bitmap bitmap2) {
            super(context, dVar, bitmap);
            this.o = bitmap2;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView
        public void F(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
            int iIndexOf = ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.indexOf(aVar);
            int i = iIndexOf + 1;
            if (i <= 1 || this.o != null) {
                iIndexOf = i;
            }
            LPhotoPaintView.this.S0.t(iIndexOf);
            LPhotoPaintView.this.A(aVar);
        }
    }

    class k implements RenderView.d {
        final /* synthetic */ Runnable a;

        k(Runnable runnable) {
            this.a = runnable;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public boolean a() {
            boolean z = LPhotoPaintView.this.A == null;
            if (!z) {
                LPhotoPaintView.this.D2(null);
            }
            return z;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void b(boolean z) {
            LPhotoPaintView.this.l.c().a();
            LPhotoPaintView.this.L0.setViewHidden(false);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void c() {
            if (LPhotoPaintView.this.A != null) {
                LPhotoPaintView.this.D2(null);
            }
            LPhotoPaintView.this.L0.setViewHidden(true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void d() {
            if (LPhotoPaintView.this.J != null) {
                LPhotoPaintView.this.J.invalidate();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void e() {
            this.a.run();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void f() {
            if (LPhotoPaintView.this.K0) {
                LPhotoPaintView.this.K0 = false;
            } else {
                LPhotoPaintView.this.S0.t(1);
                LPhotoPaintView.this.A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
            }
        }
    }

    class l extends View {
        l(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (LPhotoPaintView.this.H != null) {
                LPhotoPaintView.this.H.z(canvas);
            }
        }
    }

    class m implements EntitiesContainerView.a {
        m() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public void a() {
            LPhotoPaintView.this.D2(null);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public EntityView b() {
            return LPhotoPaintView.this.A;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public boolean c() {
            return true;
        }
    }

    class n extends EntitiesContainerView {
        Paint g;
        long h;
        float i;
        float j;

        n(Context context, EntitiesContainerView.a aVar) {
            super(context, aVar);
            this.g = new Paint();
            setWillNotDraw(false);
            this.g.setStrokeWidth(AbstractC21455b.F(2.0f));
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setColor(-1);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r14) {
            /*
                Method dump skipped, instructions count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.LPhotoPaintView.n.onDraw(android.graphics.Canvas):void");
        }
    }

    class o extends FrameLayout {
        o(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    class p extends FrameLayout {
        private float a;
        private float b;
        private Path c;

        p(Context context) {
            super(context);
            this.c = new Path();
            setWillNotDraw(false);
            LPhotoPaintView.this.i1.setStyle(Paint.Style.STROKE);
            LPhotoPaintView.this.i1.setStrokeWidth(AbstractC21455b.F(2.0f));
        }

        private void a(float f, float f2) {
            if (f == this.a && f2 == this.b) {
                return;
            }
            this.a = f;
            this.b = f2;
            LPhotoPaintView.this.i1.setShader(new SweepGradient(f, f2, new int[]{-1356981, -1146130, -10452764, -16711681, -7352832, -256, -23296, -1356981}, (float[]) null));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            ViewGroup barView = LPhotoPaintView.this.getBarView();
            RectF rectF = AbstractC21455b.x;
            rectF.set(AbstractC21455b.U0(barView.getLeft(), LPhotoPaintView.this.h1.getLeft(), LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getTop(), LPhotoPaintView.this.h1.getTop(), LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getRight(), LPhotoPaintView.this.h1.getRight(), LPhotoPaintView.this.p1), AbstractC21455b.U0(barView.getBottom(), LPhotoPaintView.this.h1.getBottom(), LPhotoPaintView.this.p1));
            float fU0 = AbstractC21455b.U0(AbstractC21455b.F(32.0f), AbstractC21455b.F(24.0f), LPhotoPaintView.this.p1);
            canvas.drawRoundRect(rectF, fU0, fU0, LPhotoPaintView.this.q1);
            if (barView.getChildCount() < 1 || LPhotoPaintView.this.p1 == 1.0f) {
                return;
            }
            canvas.save();
            canvas.translate(barView.getLeft(), barView.getTop());
            View childAt = barView.getChildAt(0);
            if (barView instanceof PaintTextOptionsView) {
                childAt = ((PaintTextOptionsView) barView).getColorClickableView();
            }
            View view = childAt;
            if (view.getAlpha() != 0.0f) {
                canvas.scale(view.getScaleX(), view.getScaleY(), view.getPivotX(), view.getPivotY());
                LPhotoPaintView.this.i1.setAlpha((int) ((1.0f - LPhotoPaintView.this.p1) * view.getAlpha() * 255.0f));
                int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
                int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
                float x = view.getX() + view.getPaddingLeft() + (width / 2.0f);
                float y = view.getY() + view.getPaddingTop() + (height / 2.0f);
                if (LPhotoPaintView.this.H0 != -1) {
                    LPhotoPaintView lPhotoPaintView = LPhotoPaintView.this;
                    ViewGroup viewGroup = (ViewGroup) lPhotoPaintView.H1(lPhotoPaintView.H0);
                    View childAt2 = (viewGroup == null ? barView : viewGroup).getChildAt(0);
                    if (viewGroup instanceof PaintTextOptionsView) {
                        childAt2 = ((PaintTextOptionsView) viewGroup).getColorClickableView();
                    }
                    x = AbstractC21455b.T0(x, childAt2.getX() + childAt2.getPaddingLeft() + (((childAt2.getWidth() - childAt2.getPaddingLeft()) - childAt2.getPaddingRight()) / 2.0f), LPhotoPaintView.this.I0);
                    y = AbstractC21455b.T0(y, childAt2.getY() + childAt2.getPaddingTop() + (((childAt2.getHeight() - childAt2.getPaddingTop()) - childAt2.getPaddingBottom()) / 2.0f), LPhotoPaintView.this.I0);
                }
                if (LPhotoPaintView.this.h1 != null && LPhotoPaintView.this.h1.getChildCount() > 0) {
                    View childAt3 = LPhotoPaintView.this.h1.getChildAt(0);
                    x = AbstractC21455b.T0(x, (LPhotoPaintView.this.h1.getX() - barView.getLeft()) + childAt3.getX() + (childAt3.getWidth() / 2.0f), LPhotoPaintView.this.p1);
                    y = AbstractC21455b.T0(y, (LPhotoPaintView.this.h1.getY() - barView.getTop()) + childAt3.getY() + (childAt3.getHeight() / 2.0f), LPhotoPaintView.this.p1);
                }
                float f = y;
                float f2 = x;
                a(f2, f);
                float fMin = (Math.min(width, height) / 2.0f) - AbstractC21455b.F(0.5f);
                if (LPhotoPaintView.this.h1 != null && LPhotoPaintView.this.h1.getChildCount() > 0) {
                    View childAt4 = LPhotoPaintView.this.h1.getChildAt(0);
                    fMin = AbstractC21455b.T0(fMin, (Math.min((childAt4.getWidth() - childAt4.getPaddingLeft()) - childAt4.getPaddingRight(), (childAt4.getHeight() - childAt4.getPaddingTop()) - childAt4.getPaddingBottom()) / 2.0f) - AbstractC21455b.F(2.0f), LPhotoPaintView.this.p1);
                }
                float f3 = fMin;
                rectF.set(f2 - f3, f - f3, f2 + f3, f + f3);
                canvas.drawArc(rectF, 0.0f, 360.0f, false, LPhotoPaintView.this.i1);
                LPhotoPaintView.this.j1.setColor(LPhotoPaintView.this.l1.a);
                LPhotoPaintView.this.j1.setAlpha((int) (LPhotoPaintView.this.j1.getAlpha() * view.getAlpha()));
                LPhotoPaintView.this.k1.setColor(LPhotoPaintView.this.l1.a);
                LPhotoPaintView.this.k1.setAlpha((int) (view.getAlpha() * 255.0f));
                PaintColorsListView.c2(canvas, f2, f, f3 - AbstractC21455b.F(3.0f), LPhotoPaintView.this.j1.getColor());
                LPhotoPaintView.this.k1.setAlpha((int) (LPhotoPaintView.this.k1.getAlpha() * LPhotoPaintView.this.p1 * view.getAlpha()));
                canvas.drawCircle(f2, f, f3 - ((AbstractC21455b.F(3.0f) + LPhotoPaintView.this.k1.getStrokeWidth()) * (1.0f - LPhotoPaintView.this.p1)), LPhotoPaintView.this.k1);
            }
            canvas.restore();
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (LPhotoPaintView.this.D0 != null) {
                LPhotoPaintView.this.D0.invalidate();
            }
        }
    }

    class q extends FrameLayout {
        q(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            LPhotoPaintView.this.c1.setAlpha((int) (LPhotoPaintView.this.T0.getAlpha() * 102.0f * (1.0f - LPhotoPaintView.this.e1)));
            PaintTextOptionsView paintTextOptionsView = LPhotoPaintView.this.T0;
            RectF rectF = AbstractC21455b.x;
            paintTextOptionsView.g(rectF);
            float top = LPhotoPaintView.this.C0.getTop() + LPhotoPaintView.this.T0.getTop() + LPhotoPaintView.this.C0.getTranslationY() + LPhotoPaintView.this.T0.getTranslationY();
            rectF.set(AbstractC21455b.T0(rectF.left, LPhotoPaintView.this.U0.getLeft(), LPhotoPaintView.this.e1), AbstractC21455b.T0(rectF.top + top, LPhotoPaintView.this.U0.getTop() - LPhotoPaintView.this.U0.getTranslationY(), LPhotoPaintView.this.e1), AbstractC21455b.T0(rectF.right, LPhotoPaintView.this.U0.getRight(), LPhotoPaintView.this.e1), AbstractC21455b.T0(top + rectF.bottom, LPhotoPaintView.this.U0.getBottom() - LPhotoPaintView.this.U0.getTranslationY(), LPhotoPaintView.this.e1));
            float F = AbstractC21455b.F(AbstractC21455b.U0(32, 16, LPhotoPaintView.this.e1));
            int alpha = LPhotoPaintView.this.d1.getAlpha();
            LPhotoPaintView.this.d1.setAlpha((int) (alpha * LPhotoPaintView.this.e1));
            canvas.drawRoundRect(rectF, F, F, LPhotoPaintView.this.d1);
            LPhotoPaintView.this.d1.setAlpha(alpha);
            canvas.drawRoundRect(rectF, F, F, LPhotoPaintView.this.c1);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0 || !LPhotoPaintView.this.f1) {
                return super.onTouchEvent(motionEvent);
            }
            LPhotoPaintView.this.L2(false);
            return true;
        }
    }

    private static class r {
        private C22697vg5 a;
        private float b;
        private float c;

        r(C22697vg5 c22697vg5, float f, float f2) {
            this.a = c22697vg5;
            this.b = f;
            this.c = f2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LPhotoPaintView(final Context context, Activity activity, final int i2, Bitmap bitmap, final Bitmap bitmap2, int i3, ArrayList arrayList, MediaController.i iVar, Runnable runnable, final m.h hVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i4;
        TextPaintView textPaintView;
        super(context, activity, true);
        byte b2 = 1;
        this.G0 = 0;
        this.H0 = -1;
        this.c1 = new Paint(1);
        this.d1 = new Paint(1);
        this.i1 = new Paint(1);
        this.j1 = new Paint(1);
        this.k1 = new Paint(1);
        this.l1 = new G37(-1, 1.0f, 0.016773745f);
        this.m1 = false;
        this.q1 = new Paint(1);
        this.s1 = new i();
        this.y1 = false;
        byte b3 = 2;
        this.z1 = new float[2];
        this.A1 = new int[2];
        this.N1 = new g();
        this.O1 = new h(this, false);
        setDelegate(this);
        this.r1 = i2;
        this.t1 = new m.h() { // from class: ir.nasim.es3
            @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.m.h
            public final int getColor(int i5) {
                return LPhotoPaintView.Q1(hVar, i5);
            }
        };
        this.n = iVar;
        this.G = false;
        T45 t45H = T45.h(i2);
        this.l1.a = t45H.b(0);
        this.l1.c = t45H.f();
        this.m = new HU1("Paint");
        this.j = bitmap;
        this.k = bitmap2;
        this.N0 = i3;
        C17574nB7 c17574nB7 = new C17574nB7();
        this.l = c17574nB7;
        c17574nB7.h(new C17574nB7.a() { // from class: ir.nasim.gs3
            @Override // ir.nasim.C17574nB7.a
            public final void a() {
                this.a.R1();
            }
        });
        j jVar = new j(context, new ir.nasim.tgwidgets.editor.ui.Components.Paint.d(getPaintingSize(), bitmap2, i3), this.j, bitmap2);
        this.H = jVar;
        jVar.setDelegate(new k(runnable));
        this.H.setUndoStore(this.l);
        this.H.setQueue(this.m);
        this.H.setVisibility(4);
        addView(this.H, AbstractC13840gu3.d(-1, -1, 51));
        l lVar = new l(context);
        this.J = lVar;
        lVar.setVisibility(4);
        addView(this.J, AbstractC13840gu3.d(-1, -1, 51));
        n nVar = new n(context, new m());
        this.A0 = nVar;
        addView(nVar);
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                H.b bVar = (H.b) arrayList.get(i5);
                byte b4 = bVar.a;
                if (b4 == 0) {
                    StickerView stickerViewC1 = C1(bVar.w, bVar.v, false);
                    if ((bVar.b & b3) != 0) {
                        stickerViewC1.j0();
                    }
                    ViewGroup.LayoutParams layoutParams = stickerViewC1.getLayoutParams();
                    layoutParams.width = bVar.n;
                    layoutParams.height = bVar.o;
                    i4 = size;
                    textPaintView = stickerViewC1;
                } else if (b4 == b2) {
                    TextPaintView textPaintViewD1 = D1(false);
                    textPaintViewD1.setType(bVar.b);
                    textPaintViewD1.setTypeface(bVar.l);
                    textPaintViewD1.setBaseFontSize(bVar.k);
                    SpannableString spannableString = new SpannableString(bVar.h);
                    Iterator it = bVar.i.iterator();
                    while (it.hasNext()) {
                        H.a aVar = (H.a) it.next();
                        AnimatedEmojiSpan animatedEmojiSpan = new AnimatedEmojiSpan(aVar.f, textPaintViewD1.getFontMetricsInt());
                        int i6 = aVar.b;
                        spannableString.setSpan(animatedEmojiSpan, i6, aVar.c + i6, 33);
                        size = size;
                    }
                    i4 = size;
                    textPaintViewD1.setText(R62.S(spannableString, textPaintViewD1.getFontMetricsInt(), (int) (textPaintViewD1.getFontSize() * 0.8f), false));
                    G2(textPaintViewD1, bVar.m);
                    G37 swatch = textPaintViewD1.getSwatch();
                    swatch.a = bVar.j;
                    textPaintViewD1.setSwatch(swatch);
                    textPaintView = textPaintViewD1;
                } else {
                    i4 = size;
                    i5++;
                    size = i4;
                    b2 = 1;
                    b3 = 2;
                }
                textPaintView.setX((bVar.c * this.z.a) - ((bVar.n * (1.0f - bVar.q)) / 2.0f));
                textPaintView.setY((bVar.d * this.z.b) - ((bVar.o * (1.0f - bVar.q)) / 2.0f));
                textPaintView.setPosition(new C22697vg5(textPaintView.getX() + (bVar.n / 2.0f), textPaintView.getY() + (bVar.o / 2.0f)));
                textPaintView.setScaleX(bVar.q);
                textPaintView.setScaleY(bVar.q);
                textPaintView.setRotation((float) (((-bVar.e) / 3.141592653589793d) * 180.0d));
                i5++;
                size = i4;
                b2 = 1;
                b3 = 2;
            }
        }
        this.A0.setVisibility(4);
        o oVar = new o(context);
        this.z0 = oVar;
        addView(oVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.B0 = frameLayout;
        frameLayout.setPadding(AbstractC21455b.F(12.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(12.0f));
        FrameLayout frameLayout2 = this.B0;
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        frameLayout2.setBackground(new GradientDrawable(orientation, new int[]{-16777216, 0}));
        addView(this.B0, AbstractC13840gu3.d(-1, -2, 48));
        ImageView imageView = new ImageView(context);
        this.V0 = imageView;
        imageView.setImageResource(AbstractC23598xB5.photo_undo2);
        this.V0.setPadding(AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f));
        this.V0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.V0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hs3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U1(view);
            }
        });
        this.V0.setAlpha(0.6f);
        this.V0.setClickable(false);
        this.B0.addView(this.V0, AbstractC13840gu3.c(32, 32.0f, 51, 12.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.W0 = linearLayout;
        linearLayout.setOrientation(0);
        this.W0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.W0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        TextView textView = new TextView(context);
        this.Y0 = textView;
        textView.setTextColor(-1);
        this.Y0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Y0.setTextSize(1, 16.0f);
        this.Y0.setText(FH3.C(TD5.tgwidget_PhotoEditorZoomOut));
        ImageView imageView2 = new ImageView(context);
        this.X0 = imageView2;
        imageView2.setImageResource(AbstractC23598xB5.photo_zoomout);
        this.W0.addView(this.X0, AbstractC13840gu3.n(24, 24, 16, 0, 0, 8, 0));
        this.W0.addView(this.Y0, AbstractC13840gu3.m(-2, -2, 16));
        this.W0.setAlpha(0.0f);
        this.W0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.is3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LPhotoPaintView.V1(view);
            }
        });
        this.B0.addView(this.W0, AbstractC13840gu3.d(-2, 32, 17));
        TextView textView2 = new TextView(context);
        this.Z0 = textView2;
        textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.Z0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.Z0.setText(FH3.C(TD5.tgwidget_PhotoEditorClearAll));
        this.Z0.setGravity(16);
        this.Z0.setTextColor(-1);
        this.Z0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Z0.setTextSize(1, 16.0f);
        this.Z0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.js3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.W1(view);
            }
        });
        this.Z0.setAlpha(0.6f);
        this.B0.addView(this.Z0, AbstractC13840gu3.c(-2, 32.0f, 5, 0.0f, 0.0f, 4.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.a1 = textView3;
        textView3.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.a1.setText(FH3.C(TD5.tgwidget_Clear));
        this.a1.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.a1.setGravity(16);
        this.a1.setTextColor(-1);
        this.a1.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.a1.setTextSize(1, 16.0f);
        this.a1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ks3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X1(view);
            }
        });
        this.a1.setAlpha(0.0f);
        this.a1.setVisibility(8);
        this.B0.addView(this.a1, AbstractC13840gu3.c(-2, 32.0f, 51, 4.0f, 0.0f, 0.0f, 0.0f));
        TextView textView4 = new TextView(context);
        this.b1 = textView4;
        textView4.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.b1.setText(FH3.C(TD5.tgwidget_Done));
        this.b1.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.b1.setGravity(16);
        this.b1.setTextColor(-1);
        this.b1.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.b1.setTextSize(1, 16.0f);
        this.b1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ls3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Y1(view);
            }
        });
        this.b1.setAlpha(0.0f);
        this.b1.setVisibility(8);
        this.B0.addView(this.b1, AbstractC13840gu3.c(-2, 32.0f, 5, 0.0f, 0.0f, 4.0f, 0.0f));
        p pVar = new p(context);
        this.C0 = pVar;
        pVar.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), 0);
        this.C0.setBackground(new GradientDrawable(orientation, new int[]{0, RecyclerView.UNDEFINED_DURATION}));
        addView(this.C0, AbstractC13840gu3.d(-1, 104, 80));
        PaintToolsView paintToolsView = new PaintToolsView(context, bitmap2 != null);
        this.S0 = paintToolsView;
        paintToolsView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
        this.S0.setDelegate(this);
        this.S0.setSelectedIndex(1);
        this.C0.addView(this.S0, AbstractC13840gu3.b(-1, 48.0f));
        PaintTextOptionsView paintTextOptionsView = new PaintTextOptionsView(context);
        this.T0 = paintTextOptionsView;
        paintTextOptionsView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
        this.T0.setVisibility(8);
        this.T0.setDelegate(this);
        this.T0.setAlignment(T45.h(i2).c());
        this.C0.addView(this.T0, AbstractC13840gu3.b(-1, 48.0f));
        q qVar = new q(context);
        this.D0 = qVar;
        addView(qVar, AbstractC13840gu3.b(-1, -1.0f));
        PaintTypefaceListView paintTypefaceListView = new PaintTypefaceListView(context);
        this.U0 = paintTypefaceListView;
        paintTypefaceListView.setVisibility(8);
        this.U0.setOnItemClickListener(new RecyclerListView.i() { // from class: ir.nasim.ms3
            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.i
            public final void a(View view, int i7) {
                this.a.Z1(view, i7);
            }
        });
        this.T0.setTypefaceListView(this.U0);
        this.D0.addView(this.U0, AbstractC13840gu3.c(-2, -2.0f, 85, 0.0f, 0.0f, 8.0f, 8.0f));
        Paint paint = this.c1;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.c1.setColor(1728053247);
        this.c1.setStrokeWidth(Math.max(2, AbstractC21455b.F(1.0f)));
        this.d1.setColor(K1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7));
        a aVar2 = new a(context);
        this.h1 = aVar2;
        aVar2.setVisibility(8);
        this.h1.setColorPalette(T45.h(i2));
        this.h1.setColorListener(new InterfaceC25043ze1() { // from class: ir.nasim.ns3
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.a2((Integer) obj);
            }
        });
        this.C0.addView(this.h1, AbstractC13840gu3.c(-1, 84.0f, 48, 56.0f, 0.0f, 56.0f, 6.0f));
        setupTabsLayout(context);
        PaintCancelView paintCancelView = new PaintCancelView(context);
        this.g = paintCancelView;
        paintCancelView.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        this.g.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.C0.addView(this.g, AbstractC13840gu3.c(32, 32.0f, 83, 12.0f, 0.0f, 0.0f, 4.0f));
        PaintDoneView paintDoneView = new PaintDoneView(context);
        this.h = paintDoneView;
        paintDoneView.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        this.h.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ps3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S1(context, bitmap2, i2, view);
            }
        });
        this.C0.addView(this.h, AbstractC13840gu3.c(32, 32.0f, 85, 0.0f, 0.0f, 12.0f, 4.0f));
        PaintWeightChooserView paintWeightChooserView = new PaintWeightChooserView(context);
        this.L0 = paintWeightChooserView;
        paintWeightChooserView.setColorSwatch(this.l1);
        this.L0.setRenderView(this.H);
        this.L0.setValueOverride(this.s1);
        this.l1.c = this.s1.get();
        this.L0.setOnUpdate(new Runnable() { // from class: ir.nasim.fs3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T1(i2);
            }
        });
        addView(this.L0, AbstractC13840gu3.b(-1, -1.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.E0 = frameLayout3;
        addView(frameLayout3, AbstractC13840gu3.b(-1, -1.0f));
        this.k1.setStyle(style);
        this.k1.setStrokeWidth(AbstractC21455b.F(2.0f));
        F2(this.l1, true);
        A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
        B();
        if (Build.VERSION.SDK_INT >= 29) {
            setSystemGestureExclusionRects(Arrays.asList(new Rect(0, (int) (AbstractC21455b.h.y * 0.35f), AbstractC21455b.F(100.0f), (int) (AbstractC21455b.h.y * 0.65d))));
        }
    }

    private r A1(AbstractC18106o57 abstractC18106o57) {
        C18390oa7 c18390oa7;
        float f2;
        ArrayList arrayList;
        int i2;
        C24749z85 c24749z85J1;
        int i3 = 0;
        while (true) {
            if (i3 >= abstractC18106o57.p.size()) {
                c18390oa7 = null;
                break;
            }
            AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i3);
            if (abstractC18697p57 instanceof J77) {
                c18390oa7 = abstractC18697p57.f;
                break;
            }
            i3++;
        }
        MediaController.i iVar = this.n;
        float f3 = 0.75f;
        if (iVar != null) {
            f2 = -(iVar.i + iVar.d);
            f3 = 0.75f / iVar.c;
        } else {
            f2 = 0.0f;
        }
        r rVar = new r(B1(), f3, f2);
        if (c18390oa7 == null || (arrayList = this.M0) == null || arrayList.size() == 0 || (c24749z85J1 = J1((i2 = c18390oa7.b), abstractC18106o57.c, c18390oa7)) == null) {
            return rVar;
        }
        C22697vg5 c22697vg5B = c24749z85J1.b(i2);
        float fC = c24749z85J1.c(i2);
        float fA = c24749z85J1.a();
        float f4 = (float) ((fC / x1().a) * c18390oa7.e);
        double radians = (float) Math.toRadians(fA);
        double d2 = 1.5707963267948966d - radians;
        double d3 = fC;
        double d4 = radians + 1.5707963267948966d;
        return new r(new C22697vg5(c22697vg5B.a + ((float) (Math.sin(d2) * d3 * c18390oa7.c)) + ((float) (Math.cos(d4) * d3 * c18390oa7.d)), c22697vg5B.b + ((float) (Math.cos(d2) * d3 * c18390oa7.c)) + ((float) (Math.sin(d4) * d3 * c18390oa7.d))), f4, fA);
    }

    private void A2() {
    }

    private C22697vg5 B1() {
        SD6 paintingSize = getPaintingSize();
        float f2 = paintingSize.a / 2.0f;
        float f3 = paintingSize.b / 2.0f;
        if (this.n != null) {
            double radians = (float) Math.toRadians(-(r2.i + r2.d));
            float fCos = (float) ((this.n.a * Math.cos(radians)) - (this.n.b * Math.sin(radians)));
            float fSin = (float) ((this.n.a * Math.sin(radians)) + (this.n.b * Math.cos(radians)));
            f2 -= fCos * paintingSize.a;
            f3 -= fSin * paintingSize.b;
        }
        return new C22697vg5(f2, f3);
    }

    private void B2(final EntityView entityView) {
        this.l.f(entityView.getUUID(), new Runnable() { // from class: ir.nasim.Bs3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f2(entityView);
            }
        });
    }

    private StickerView C1(Object obj, AbstractC18106o57 abstractC18106o57, boolean z) {
        r rVarA1 = A1(abstractC18106o57);
        f fVar = new f(getContext(), rVarA1.a, rVarA1.c, rVarA1.b, x1(), abstractC18106o57, obj);
        fVar.K0.d1(12);
        if (rVarA1.a.a == this.A0.getMeasuredWidth() / 2.0f) {
            fVar.setHasStickyX(true);
        }
        if (rVarA1.a.b == this.A0.getMeasuredHeight() / 2.0f) {
            fVar.setHasStickyY(true);
        }
        fVar.setDelegate(this);
        this.A0.addView(fVar);
        if (z) {
            B2(fVar);
            D2(fVar);
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2, reason: merged with bridge method [inline-methods] */
    public void f2(EntityView entityView) {
        EntityView entityView2 = this.A;
        if (entityView == entityView2 && entityView2 != null) {
            entityView2.H();
            this.A = null;
            if (entityView instanceof TextPaintView) {
                ValueAnimator valueAnimator = this.J0;
                if (valueAnimator != null && this.H0 != 0) {
                    valueAnimator.cancel();
                }
                N2(0);
            }
        }
        this.A0.removeView(entityView);
        if (entityView != null) {
            this.l.j(entityView.getUUID());
        }
        this.L0.setValueOverride(this.s1);
        this.L0.setShowPreview(true);
        this.l1.c = this.s1.get();
        F2(this.l1, true);
    }

    private TextPaintView D1(boolean z) {
        x2();
        SD6 paintingSize = getPaintingSize();
        C22697vg5 c22697vg5M2 = M2(null);
        TextPaintView textPaintView = new TextPaintView(getContext(), c22697vg5M2, (int) (paintingSize.a / 9.0f), "", this.l1, this.D);
        if (c22697vg5M2.a == this.A0.getMeasuredWidth() / 2.0f) {
            textPaintView.setHasStickyX(true);
        }
        if (c22697vg5M2.b == this.A0.getMeasuredHeight() / 2.0f) {
            textPaintView.setHasStickyY(true);
        }
        textPaintView.setDelegate(this);
        textPaintView.setMaxWidth((int) (paintingSize.a - 20.0f));
        textPaintView.setTypeface(T45.h(this.r1).e());
        textPaintView.setType(T45.h(this.r1).d());
        this.A0.addView(textPaintView, AbstractC13840gu3.b(-2, -2.0f));
        MediaController.i iVar = this.n;
        if (iVar != null) {
            textPaintView.Z(1.0f / iVar.c);
            textPaintView.V(-(r0.i + this.n.d));
        }
        if (z) {
            B2(textPaintView);
            textPaintView.i0();
            E2(textPaintView, false);
            textPaintView.getFocusedView().requestFocus();
            AbstractC21455b.C1(textPaintView.getFocusedView());
            this.B = true;
            this.T0.setAlignment(T45.h(this.r1).c(), true);
            this.T0.setOutlineType(T45.h(this.r1).d());
        }
        return textPaintView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D2(EntityView entityView) {
        return E2(entityView, true);
    }

    private boolean E2(EntityView entityView, boolean z) {
        boolean z2;
        int i2;
        boolean z3 = entityView instanceof TextPaintView;
        int i3 = 2;
        if (z3 && (((i2 = this.H0) == -1 && this.G0 != 2) || (i2 != -1 && i2 != 2))) {
            ValueAnimator valueAnimator = this.J0;
            if (valueAnimator != null && i2 != 2) {
                valueAnimator.cancel();
            }
            if (this.n1) {
                H2(false);
            }
            N2(2);
        }
        if (z3 && z) {
            TextPaintView textPaintView = (TextPaintView) entityView;
            int gravity = textPaintView.getEditText().getGravity();
            if (gravity == 17) {
                i3 = 1;
            } else if (gravity != 21) {
                i3 = 0;
            }
            this.T0.setAlignment(i3);
            this.T0.setTypeface(textPaintView.getTypeface().o());
            this.T0.setOutlineType(textPaintView.getType(), true);
            this.D0.invalidate();
        }
        EntityView entityView2 = this.A;
        if (entityView2 == null) {
            z2 = false;
        } else {
            if (entityView2 == entityView) {
                if (!this.B) {
                    J2(entityView2);
                } else if (entityView2 instanceof TextPaintView) {
                    AbstractC21455b.C1(((TextPaintView) entityView2).getFocusedView());
                    L1(false);
                }
                return true;
            }
            entityView2.H();
            EntityView entityView3 = this.A;
            if (entityView3 instanceof TextPaintView) {
                ((TextPaintView) entityView3).k0();
                if (!z3) {
                    this.B = false;
                    AbstractC21455b.t0(((TextPaintView) this.A).getFocusedView());
                    L1(false);
                }
            }
            z2 = true;
        }
        EntityView entityView4 = this.A;
        this.A = entityView;
        if ((entityView4 instanceof TextPaintView) && TextUtils.isEmpty(((TextPaintView) entityView4).getText())) {
            f2(entityView4);
        }
        EntityView entityView5 = this.A;
        if (entityView5 == null) {
            ValueAnimator valueAnimator2 = this.J0;
            if (valueAnimator2 != null && this.H0 != 0) {
                valueAnimator2.cancel();
            }
            if (this.n1) {
                H2(false);
            }
            N2(0);
            this.L0.setValueOverride(this.s1);
            this.L0.setShowPreview(true);
            this.l1.c = this.s1.get();
            F2(this.l1, true);
            return z2;
        }
        entityView5.a0(this.z0);
        this.A0.bringChildToFront(this.A);
        EntityView entityView6 = this.A;
        if (!(entityView6 instanceof TextPaintView)) {
            this.L0.setValueOverride(this.s1);
            this.L0.setShowPreview(true);
            this.l1.c = this.s1.get();
            F2(this.l1, true);
            return true;
        }
        TextPaintView textPaintView2 = (TextPaintView) entityView6;
        textPaintView2.getSwatch().c = this.l1.c;
        F2(textPaintView2.getSwatch(), true);
        this.L0.setValueOverride(new c(textPaintView2, (int) (this.z.a / 9.0f)));
        this.L0.setShowPreview(false);
        return true;
    }

    private void F1() {
        EntityView entityView;
        EntityView entityView2 = this.A;
        if (entityView2 == null) {
            return;
        }
        C22697vg5 c22697vg5M2 = M2(entityView2);
        EntityView entityView3 = this.A;
        if (entityView3 instanceof StickerView) {
            StickerView stickerView = new StickerView(getContext(), (StickerView) this.A, c22697vg5M2);
            stickerView.setDelegate(this);
            this.A0.addView(stickerView);
            entityView = stickerView;
        } else if (entityView3 instanceof TextPaintView) {
            TextPaintView textPaintView = new TextPaintView(getContext(), (TextPaintView) this.A, c22697vg5M2);
            textPaintView.setDelegate(this);
            textPaintView.setMaxWidth((int) (getPaintingSize().a - 20.0f));
            this.A0.addView(textPaintView, AbstractC13840gu3.b(-2, -2.0f));
            entityView = textPaintView;
        } else {
            entityView = null;
        }
        B2(entityView);
        D2(entityView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F2(G37 g37, boolean z) {
        FrameLayout frameLayout;
        G37 g372 = this.l1;
        if (g372 != g37) {
            g372.a = g37.a;
            g372.b = g37.b;
            g372.c = g37.c;
            T45.h(this.r1).l(g37.a);
            T45.h(this.r1).r(g37.c);
        }
        this.H.setColor(g37.a);
        this.H.setBrushSize(g37.c);
        if (z && (frameLayout = this.C0) != null) {
            frameLayout.invalidate();
        }
        EntityView entityView = this.A;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setSwatch(new G37(g37.a, g37.b, g37.c));
        }
    }

    private void G1() {
        EntityView entityView = this.A;
        if (!(entityView instanceof TextPaintView) || this.B) {
            return;
        }
        TextPaintView textPaintView = (TextPaintView) entityView;
        this.B = true;
        textPaintView.i0();
        View focusedView = textPaintView.getFocusedView();
        focusedView.requestFocus();
        AbstractC21455b.C1(focusedView);
    }

    private void G2(TextPaintView textPaintView, int i2) {
        textPaintView.setAlign(i2);
        int i3 = 2;
        textPaintView.getEditText().setGravity(i2 != 1 ? i2 != 2 ? 19 : 21 : 17);
        if (i2 == 1) {
            i3 = 4;
        } else if (i2 == 2 ? !FH3.D : FH3.D) {
            i3 = 3;
        }
        textPaintView.getEditText().setTextAlignment(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View H1(int i2) {
        if (i2 == 0) {
            return this.S0;
        }
        if (i2 == 2) {
            return this.T0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(final boolean z) {
        if (this.n1 != z) {
            this.n1 = z;
            C16463lJ6 c16463lJ6 = this.o1;
            if (c16463lJ6 != null) {
                c16463lJ6.d();
            }
            C16463lJ6 c16463lJ62 = new C16463lJ6(new C19136pq2(z ? 0.0f : 1000.0f));
            this.o1 = c16463lJ62;
            c16463lJ62.A(new C17645nJ6().e(z ? 1000.0f : 0.0f).f(1250.0f).d(1.0f));
            final boolean[] zArr = {this.D1 || this.B1};
            final float translationY = this.C0.getTranslationY();
            final ViewGroup barView = getBarView();
            this.o1.c(new AbstractC12098e22.r() { // from class: ir.nasim.vs3
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
                    this.a.k2(barView, z, zArr, translationY, abstractC12098e22, f2, f3);
                }
            });
            this.o1.b(new AbstractC12098e22.q() { // from class: ir.nasim.ws3
                @Override // ir.nasim.AbstractC12098e22.q
                public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
                    this.a.l2(z, abstractC12098e22, z2, f2, f3);
                }
            });
            this.o1.s();
            if (z) {
                this.h1.setVisibility(0);
                this.h1.setSelectedColorIndex(0);
            }
        }
    }

    private int[] I1(View view) {
        view.getLocationInWindow(this.A1);
        float rotation = view.getRotation();
        float radians = (float) Math.toRadians(rotation + (this.n != null ? r1.d + r1.i : 0.0f));
        double width = view.getWidth() * view.getScaleX() * this.A0.getScaleX();
        double d2 = radians;
        double height = view.getHeight() * view.getScaleY() * this.A0.getScaleY();
        float fCos = (float) ((Math.cos(d2) * width) - (Math.sin(d2) * height));
        float fSin = (float) ((width * Math.sin(d2)) + (height * Math.cos(d2)));
        int[] iArr = this.A1;
        iArr[0] = (int) (iArr[0] + (fCos / 2.0f));
        iArr[1] = (int) (iArr[1] + (fSin / 2.0f));
        return iArr;
    }

    private void I2(int i2) {
    }

    private C24749z85 J1(int i2, long j2, C18390oa7 c18390oa7) {
        if (i2 >= 0 && i2 <= 3 && !this.M0.isEmpty()) {
            int size = this.M0.size();
            int iNextInt = Utilities.b.nextInt(size);
            for (int i3 = size; i3 > 0; i3--) {
                C24749z85 c24749z85 = (C24749z85) this.M0.get(iNextInt);
                if (!N1(c24749z85, i2, j2, c18390oa7)) {
                    return c24749z85;
                }
                iNextInt = (iNextInt + 1) % size;
            }
        }
        return null;
    }

    private void J2(final EntityView entityView) {
        int[] iArrI1 = I1(entityView);
        K2(new Runnable() { // from class: ir.nasim.ds3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p2(entityView);
            }
        }, this, 51, iArrI1[0], iArrI1[1] - AbstractC21455b.F(32.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K1(int i2) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, this.t1);
    }

    private void K2(Runnable runnable, View view, int i2, int i3, int i4) {
        ActionBarPopupWindow actionBarPopupWindow = this.u1;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.u1.dismiss();
            return;
        }
        if (this.v1 == null) {
            this.w1 = new Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext(), this.t1);
            this.v1 = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setAnimationEnabled(true);
            this.v1.setBackgroundColor(-14145495);
            this.v1.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Yr3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.a.q2(view2, motionEvent);
                }
            });
            this.v1.setDispatchKeyEventListener(new ActionBarPopupWindow.d() { // from class: ir.nasim.Zr3
                @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.d
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.a.r2(keyEvent);
                }
            });
            this.v1.setShownFromBottom(true);
        }
        this.v1.n();
        runnable.run();
        if (this.u1 == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.v1, -2, -2);
            this.u1 = actionBarPopupWindow2;
            actionBarPopupWindow2.r(true);
            this.u1.setAnimationStyle(AbstractC16417lE5.PopupAnimation);
            this.u1.setOutsideTouchable(true);
            this.u1.setClippingEnabled(true);
            this.u1.setInputMethodMode(2);
            this.u1.setSoftInputMode(0);
            this.u1.getContentView().setFocusableInTouchMode(true);
            this.u1.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.as3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.a.s2();
                }
            });
        }
        this.v1.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION));
        this.u1.setFocusable(true);
        if ((i2 & 48) != 0) {
            i3 -= this.v1.getMeasuredWidth() / 2;
            i4 -= this.v1.getMeasuredHeight();
        }
        this.u1.showAtLocation(view, i2, i3, i4);
        ActionBarPopupWindow.t(this.v1);
    }

    private void L1(boolean z) {
        if (this.B1) {
            I2(0);
        }
        if (z) {
            M1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(final boolean z) {
        if (this.f1 != z) {
            this.f1 = z;
            C16463lJ6 c16463lJ6 = this.g1;
            if (c16463lJ6 != null) {
                c16463lJ6.d();
            }
            C16463lJ6 c16463lJ62 = new C16463lJ6(new C19136pq2(z ? 0.0f : 1000.0f));
            this.g1 = c16463lJ62;
            c16463lJ62.A(new C17645nJ6().e(z ? 1000.0f : 0.0f).f(1250.0f).d(1.0f));
            if (z) {
                this.U0.setAlpha(0.0f);
                this.U0.setVisibility(0);
            }
            this.g1.c(new AbstractC12098e22.r() { // from class: ir.nasim.Tr3
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
                    this.a.t2(abstractC12098e22, f2, f3);
                }
            });
            this.g1.b(new AbstractC12098e22.q() { // from class: ir.nasim.Ur3
                @Override // ir.nasim.AbstractC12098e22.q
                public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
                    this.a.u2(z, abstractC12098e22, z2, f2, f3);
                }
            });
            this.g1.s();
        }
    }

    private void M1() {
        this.F1 = 0;
    }

    private C22697vg5 M2(EntityView entityView) {
        MediaController.i iVar = this.n;
        float f2 = iVar != null ? 200.0f / iVar.c : 200.0f;
        if (entityView != null) {
            C22697vg5 position = entityView.getPosition();
            return new C22697vg5(position.a + f2, position.b + f2);
        }
        float f3 = iVar != null ? 100.0f / iVar.c : 100.0f;
        C22697vg5 c22697vg5B1 = B1();
        while (true) {
            boolean z = false;
            for (int i2 = 0; i2 < this.A0.getChildCount(); i2++) {
                View childAt = this.A0.getChildAt(i2);
                if (childAt instanceof EntityView) {
                    C22697vg5 position2 = ((EntityView) childAt).getPosition();
                    if (((float) Math.sqrt(Math.pow(position2.a - c22697vg5B1.a, 2.0d) + Math.pow(position2.b - c22697vg5B1.b, 2.0d))) < f3) {
                        z = true;
                    }
                }
            }
            if (!z) {
                return c22697vg5B1;
            }
            c22697vg5B1 = new C22697vg5(c22697vg5B1.a + f2, c22697vg5B1.b + f2);
        }
    }

    private boolean N1(C24749z85 c24749z85, int i2, long j2, C18390oa7 c18390oa7) {
        if (c24749z85.b(i2) == null) {
            return true;
        }
        float fC = c24749z85.c(0) * 1.1f;
        for (int i3 = 0; i3 < this.A0.getChildCount(); i3++) {
            View childAt = this.A0.getChildAt(i3);
            if (childAt instanceof StickerView) {
                StickerView stickerView = (StickerView) childAt;
                if (stickerView.getAnchor() != i2) {
                    continue;
                } else {
                    C22697vg5 position = stickerView.getPosition();
                    float fHypot = (float) Math.hypot(position.a - r14.a, position.b - r14.b);
                    if ((j2 == stickerView.getSticker().c || this.M0.size() > 1) && fHypot < fC) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void N2(int i2) {
        if (this.G0 == i2 || this.H0 == i2) {
            return;
        }
        ValueAnimator valueAnimator = this.J0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final View viewH1 = H1(this.G0);
        this.H0 = i2;
        final View viewH12 = H1(i2);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.J0 = duration;
        duration.setInterpolator(InterpolatorC12631ew1.f);
        this.J0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.As3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.w2(viewH1, viewH12, valueAnimator2);
            }
        });
        this.J0.addListener(new e(viewH1, viewH12, i2));
        this.J0.start();
    }

    private void O2() {
        PaintTextOptionsView paintTextOptionsView = this.T0;
        if (paintTextOptionsView != null) {
            if (this.D1 || this.B1) {
                paintTextOptionsView.f(AbstractC23598xB5.msg_add);
            } else {
                paintTextOptionsView.f(AbstractC23598xB5.msg_add);
            }
        }
        AbstractC21455b.I1(this.Z0, (this.D1 || this.B1) ? false : true, false, 1.0f, true, null);
        AbstractC21455b.I1(this.V0, (this.D1 || this.B1) ? false : true, false, 1.0f, true, null);
        AbstractC21455b.I1(this.b1, this.D1 || this.B1, false, 1.0f, true, null);
        AbstractC21455b.I1(this.a1, this.D1 || this.B1, false, 1.0f, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q1(m.h hVar, int i2) {
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7) {
            return -14145495;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7) {
            return -1;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.T3) {
            return -14803426;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.V3) {
            return -592138;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.d4) {
            return -8553091;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.id) {
            return -16777216;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.ld) {
            return -1610612736;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.od || i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.sd || i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.nd) {
            return -9539985;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.pd) {
            return -10177041;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.p5) {
            return -1;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.Bf) {
            return -11754001;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4) {
            return 536870911;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.uf || i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.tf || i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.vf) {
            return -1;
        }
        if (i2 == ir.nasim.tgwidgets.editor.ui.ActionBar.m.wf) {
            return 352321535;
        }
        return hVar != null ? hVar.getColor(i2) : ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1() {
        boolean zB = this.l.b();
        this.V0.animate().cancel();
        this.V0.animate().alpha(zB ? 1.0f : 0.6f).translationY(0.0f).setDuration(150L).start();
        this.V0.setClickable(zB);
        this.Z0.animate().cancel();
        this.Z0.animate().alpha(zB ? 1.0f : 0.6f).translationY(0.0f).setDuration(150L).start();
        this.Z0.setClickable(zB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(Context context, Bitmap bitmap, final int i2, View view) {
        if (this.n1) {
            new PX0(context, this.t1).T0(this.l1.a).V0(new b(bitmap, i2)).U0(new InterfaceC25043ze1() { // from class: ir.nasim.qs3
                @Override // ir.nasim.InterfaceC25043ze1
                public final void accept(Object obj) {
                    this.a.b2(i2, (Integer) obj);
                }
            }).show();
            return;
        }
        Runnable runnable = this.x1;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(int i2) {
        F2(this.l1, true);
        T45.h(i2).r(this.l1.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        RenderView renderView = this.H;
        if (renderView == null || !(renderView.getCurrentBrush() instanceof a.g)) {
            this.l.i();
            return;
        }
        this.H.t();
        this.S0.setSelectedIndex(1);
        A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V1(View view) {
        PhotoViewer.k8().Tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(View view) {
        if (this.l.b()) {
            RenderView renderView = this.H;
            if (renderView != null && (renderView.getCurrentBrush() instanceof a.g)) {
                this.H.t();
                this.S0.setSelectedIndex(1);
                A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
            }
            this.H.s();
            this.l.g();
            this.A0.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(View view) {
        EntityView entityView = this.A;
        if (entityView instanceof TextPaintView) {
            AbstractC21455b.t0(((TextPaintView) entityView).getFocusedView());
        }
        if (this.B1) {
            L1(false);
        }
        f2(this.A);
        D2(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(View view) {
        D2(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(View view, int i2) {
        LU4 lu4 = (LU4) LU4.n().get(i2);
        this.T0.setTypeface(lu4.o());
        y2(lu4);
        L2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(Integer num) {
        setNewColor(num.intValue());
        H2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(int i2, Integer num) {
        T45.h(i2).l(num.intValue());
        T45.h(i2).k();
        setNewColor(num.intValue());
        this.h1.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(a.g gVar, int i2) {
        if (this.H.getCurrentBrush() instanceof a.g) {
            this.K0 = true;
        }
        A(gVar);
        this.S0.l(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d2(View view) {
        if (this.v1 != null) {
            T45.h(this.r1).t();
            boolean zG = T45.h(this.r1).g();
            for (int i2 = 0; i2 < this.v1.getItemsCount(); i2++) {
                View viewL = this.v1.l(i2);
                if (viewL instanceof PopupButton) {
                    a.g gVar = (a.g) a.g.b.get(i2);
                    ((PopupButton) viewL).setIcon(zG ? gVar.n() : gVar.d(), zG, true);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2() {
        boolean zG = T45.h(this.r1).g();
        for (int i2 = 0; i2 < a.g.b.size(); i2++) {
            final a.g gVar = (a.g) a.g.b.get(i2);
            final int iN = zG ? gVar.n() : gVar.d();
            PopupButton popupButtonZ1 = z1(gVar.o(), iN, false, new Runnable() { // from class: ir.nasim.ss3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c2(gVar, iN);
                }
            });
            popupButtonZ1.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.ts3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.a.d2(view);
                }
            });
            this.v1.j(popupButtonZ1, AbstractC13840gu3.g(-1, 48));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(int i2, int i3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.l1.a = QY0.c(i2, i3, fFloatValue);
        this.C0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getBarView() {
        return this.G0 == 2 ? this.T0 : this.S0;
    }

    private int getFrameRotation() {
        int i2 = this.N0;
        if (i2 == 90) {
            return 1;
        }
        if (i2 != 180) {
            return i2 != 270 ? 0 : 3;
        }
        return 2;
    }

    private SD6 getPaintingSize() {
        SD6 sd6 = this.z;
        if (sd6 != null) {
            return sd6;
        }
        float width = this.j.getWidth();
        float height = this.j.getHeight();
        int iH = AbstractC8662Wx6.h();
        int i2 = iH != 0 ? iH != 2 ? 2560 : 3840 : SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
        SD6 sd62 = new SD6(width, height);
        float f2 = i2;
        sd62.a = f2;
        float fFloor = (float) Math.floor((f2 * height) / width);
        sd62.b = fFloor;
        if (fFloor > f2) {
            sd62.b = f2;
            sd62.a = (float) Math.floor((f2 * width) / height);
        }
        this.z = sd62;
        return sd62;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        if (this.B) {
            D2(null);
        } else {
            N2(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        N2(2);
        if (this.A instanceof TextPaintView) {
            return;
        }
        D1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view, boolean z, boolean[] zArr, float f2, AbstractC12098e22 abstractC12098e22, float f3, float f4) {
        float f5 = f3 / 1000.0f;
        this.p1 = f5;
        float f6 = ((1.0f - f5) * 0.4f) + 0.6f;
        view.setScaleX(f6);
        view.setScaleY(f6);
        view.setTranslationY((AbstractC21455b.F(16.0f) * Math.min(this.p1, 0.25f)) / 0.25f);
        view.setAlpha(1.0f - (Math.min(this.p1, 0.25f) / 0.25f));
        this.h1.setProgress(this.p1, z);
        this.h.setProgress(this.p1);
        this.g.setProgress(this.p1);
        this.F0.setTranslationY(AbstractC21455b.F(32.0f) * this.p1);
        if (this.O1.i()) {
            zArr[0] = false;
        }
        if (zArr[0]) {
            float f7 = this.p1;
            if (!z) {
                f7 = 1.0f - f7;
            }
            this.C0.setTranslationY(f2 - ((AbstractC21455b.F(40.0f) * f7) * (z ? 1 : -1)));
        }
        this.C0.invalidate();
        if (view == this.T0) {
            this.D0.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(boolean z, AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
        if (abstractC12098e22 == this.o1) {
            this.o1 = null;
            if (z) {
                return;
            }
            this.h1.setVisibility(8);
            T45.h(this.r1).k();
            this.h1.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(EntityView entityView, View view) {
        f2(entityView);
        ActionBarPopupWindow actionBarPopupWindow = this.u1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.u1.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(View view) {
        G1();
        ActionBarPopupWindow actionBarPopupWindow = this.u1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.u1.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(View view) {
        F1();
        ActionBarPopupWindow actionBarPopupWindow = this.u1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.u1.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(final EntityView entityView) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
        textView.setTextColor(K1(i2));
        textView.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        textView.setGravity(16);
        textView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(14.0f), 0);
        textView.setTextSize(1, 14.0f);
        textView.setTag(0);
        textView.setText(FH3.E("PaintDelete", TD5.tgwidget_PaintDelete));
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m2(entityView, view);
            }
        });
        linearLayout.addView(textView, AbstractC13840gu3.g(-2, 48));
        if (entityView instanceof TextPaintView) {
            TextView textView2 = new TextView(getContext());
            textView2.setTextColor(K1(i2));
            textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
            textView2.setGravity(16);
            textView2.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
            textView2.setTextSize(1, 14.0f);
            textView2.setEllipsize(truncateAt);
            textView2.setTag(1);
            textView2.setText(FH3.E("PaintEdit", TD5.tgwidget_PaintEdit));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Wr3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.n2(view);
                }
            });
            linearLayout.addView(textView2, AbstractC13840gu3.g(-2, 48));
        }
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(K1(i2));
        textView3.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        textView3.setGravity(16);
        textView3.setEllipsize(truncateAt);
        textView3.setPadding(AbstractC21455b.F(14.0f), 0, AbstractC21455b.F(16.0f), 0);
        textView3.setTextSize(1, 14.0f);
        textView3.setTag(2);
        textView3.setText(FH3.E("PaintDuplicate", TD5.tgwidget_PaintDuplicate));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Xr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.o2(view);
            }
        });
        linearLayout.addView(textView3, AbstractC13840gu3.g(-2, 48));
        this.v1.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean q2(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.u1) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.w1);
        if (this.w1.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.u1.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.u1) != null && actionBarPopupWindow.isShowing()) {
            this.u1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2() {
        this.v1.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewColor(final int i2) {
        G37 g37 = this.l1;
        final int i3 = g37.a;
        g37.a = i2;
        F2(g37, true);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.os3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.g2(i3, i2, valueAnimator);
            }
        });
        duration.start();
    }

    private void setTextType(int i2) {
        this.D = i2;
        if (this.A instanceof TextPaintView) {
            if (i2 == 0 && this.l1.a == -1) {
                setNewColor(-16777216);
            } else if ((i2 == 1 || i2 == 2) && this.l1.a == -16777216) {
                setNewColor(-1);
            }
            ((TextPaintView) this.A).setType(i2);
        }
        T45.h(this.r1).p(i2);
        this.T0.setOutlineType(i2);
    }

    private void setupTabsLayout(Context context) {
        d dVar = new d(context);
        this.F0 = dVar;
        dVar.setClipToPadding(false);
        this.F0.setOrientation(0);
        this.C0.addView(this.F0, AbstractC13840gu3.c(-1, 40.0f, 80, 52.0f, 0.0f, 52.0f, 0.0f));
        TextView textView = new TextView(context);
        this.P0 = textView;
        textView.setText(FH3.C(TD5.tgwidget_PhotoEditorDraw).toUpperCase());
        TextView textView2 = this.P0;
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4;
        textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(K1(i2), 7));
        this.P0.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.P0.setTextColor(-1);
        this.P0.setTextSize(1, 14.0f);
        this.P0.setGravity(1);
        this.P0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.P0.setSingleLine();
        this.P0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xs3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h2(view);
            }
        });
        this.F0.addView(this.P0, AbstractC13840gu3.h(0, -2, 1.0f));
        TextView textView3 = new TextView(context);
        this.Q0 = textView3;
        textView3.setText(FH3.C(TD5.tgwidget_PhotoEditorSticker).toUpperCase());
        this.Q0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(K1(i2), 7));
        this.Q0.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.Q0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ys3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.i2(view);
            }
        });
        this.Q0.setTextColor(-1);
        this.Q0.setTextSize(1, 14.0f);
        this.Q0.setGravity(1);
        this.Q0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Q0.setAlpha(0.6f);
        this.Q0.setSingleLine();
        this.Q0.setVisibility(8);
        this.F0.addView(this.Q0, AbstractC13840gu3.h(0, -2, 1.0f));
        TextView textView4 = new TextView(context);
        this.R0 = textView4;
        textView4.setText(FH3.C(TD5.tgwidget_PhotoEditorText).toUpperCase());
        this.R0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(K1(i2), 7));
        this.R0.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.R0.setTextColor(-1);
        this.R0.setTextSize(1, 14.0f);
        this.R0.setGravity(1);
        this.R0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.R0.setAlpha(0.6f);
        this.R0.setSingleLine();
        this.R0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zs3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j2(view);
            }
        });
        this.F0.addView(this.R0, AbstractC13840gu3.h(0, -2, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
        float f4 = f2 / 1000.0f;
        this.e1 = f4;
        this.U0.setAlpha(f4);
        this.U0.invalidate();
        this.D0.invalidate();
        this.T0.getTypefaceCell().setAlpha(1.0f - this.e1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(boolean z, AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
        if (abstractC12098e22 == this.g1) {
            this.g1 = null;
            if (!z) {
                this.U0.setVisibility(8);
            }
            this.U0.setMaskProvider(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v2() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view, View view2, ValueAnimator valueAnimator) {
        this.I0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.F0.invalidate();
        this.C0.invalidate();
        this.D0.invalidate();
        int i2 = 0;
        while (i2 < this.F0.getChildCount()) {
            this.F0.getChildAt(i2).setAlpha(((i2 == this.H0 ? this.I0 : i2 == this.G0 ? 1.0f - this.I0 : 0.0f) * 0.4f) + 0.6f);
            i2++;
        }
        float interpolation = InterpolatorC12631ew1.f.getInterpolation(this.I0);
        if (view == null || view2 == null) {
            return;
        }
        float f2 = 1.0f - interpolation;
        float f3 = (f2 * 0.4f) + 0.6f;
        view.setScaleX(f3);
        view.setScaleY(f3);
        view.setTranslationY((AbstractC21455b.F(16.0f) * Math.min(interpolation, 0.25f)) / 0.25f);
        view.setAlpha(1.0f - (Math.min(interpolation, 0.25f) / 0.25f));
        float f4 = (interpolation * 0.4f) + 0.6f;
        view2.setScaleX(f4);
        view2.setScaleY(f4);
        view2.setTranslationY(((-AbstractC21455b.F(16.0f)) * Math.min(f2, 0.25f)) / 0.25f);
        view2.setAlpha(1.0f - (Math.min(f2, 0.25f) / 0.25f));
    }

    private SD6 x1() {
        float fFloor = (float) Math.floor(getPaintingSize().a * 0.5d);
        return new SD6(fFloor, fFloor);
    }

    private void y1(float f2, float f3) {
        this.C0.setTranslationY((f2 - this.F1) + (AbstractC21455b.F(40.0f) * f3));
        float f4 = (f2 - this.F1) / 2.0f;
        this.p = f4;
        this.o = ((f4 * 2.0f) / this.H1) + 1.0f;
        PaintWeightChooserView paintWeightChooserView = this.L0;
        if (!this.B1) {
            f2 = 0.0f;
        }
        paintWeightChooserView.m(f2, f3);
        setTransform(this.q, this.r, this.s, this.v, this.w);
        ((View) getParent()).invalidate();
    }

    private PopupButton z1(String str, int i2, boolean z, final Runnable runnable) {
        PopupButton popupButton = new PopupButton(getContext());
        popupButton.setIcon(i2);
        popupButton.setText(str);
        popupButton.setSelected(z);
        if (runnable != null) {
            popupButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.us3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            });
        }
        return popupButton;
    }

    private void z2() {
        getHeight();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public void A(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
        if ((aVar instanceof a.b) || (aVar instanceof a.d)) {
            this.L0.setMinMax(0.4f, 1.75f);
        } else {
            this.L0.setMinMax(0.05f, 1.0f);
        }
        this.L0.setDrawCenter(!(aVar instanceof a.g));
        if (this.H.getCurrentBrush() instanceof a.g) {
            this.K0 = true;
        }
        this.H.setBrush(aVar);
        this.l1.c = this.s1.get();
        F2(this.l1, true);
        this.J.invalidate();
    }

    @Override // ir.nasim.YZ2
    public void B() {
        this.q1.setColor(-15132391);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void C() {
        L2(true);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean D(EntityView entityView) {
        J2(entityView);
        return true;
    }

    protected void E1(RLottieDrawable rLottieDrawable) {
    }

    @Override // ir.nasim.YZ2
    public boolean a() {
        if (this.n1) {
            H2(false);
            return true;
        }
        if (this.B1) {
            L1(true);
            return true;
        }
        if (!this.B) {
            return false;
        }
        D2(null);
        return true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b, ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void b() {
        H2(true);
    }

    @Override // ir.nasim.YZ2
    public boolean c(MotionEvent motionEvent) {
        if (this.A != null) {
            D2(null);
        }
        float x = ((motionEvent.getX() - this.H.getTranslationX()) - (getMeasuredWidth() / 2.0f)) / this.H.getScaleX();
        float y = ((((motionEvent.getY() - this.H.getTranslationY()) - (getMeasuredHeight() / 2.0f)) + AbstractC21455b.F(32.0f)) - ((getAdditionalTop() - getAdditionalBottom()) / 2.0f)) / this.H.getScaleY();
        double d2 = x;
        double radians = (float) Math.toRadians(-this.H.getRotation());
        double d3 = y;
        float fCos = ((float) ((Math.cos(radians) * d2) - (Math.sin(radians) * d3))) + (this.H.getMeasuredWidth() / 2.0f);
        float fSin = ((float) ((d2 * Math.sin(radians)) + (d3 * Math.cos(radians)))) + (this.H.getMeasuredHeight() / 2.0f);
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setLocation(fCos, fSin);
        this.H.B(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean d(EntityView entityView) {
        return !this.B;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        if ((view == this.H || view == this.J || view == this.A0 || view == this.z0) && this.n != null) {
            canvas.save();
            i = this.G ? 0 : AbstractC21455b.d;
            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            MediaController.i iVar = this.n;
            int i2 = iVar.i;
            if (i2 == 90 || i2 == 270) {
                measuredHeight = measuredWidth;
                measuredWidth = measuredHeight;
            }
            float scaleX = measuredWidth * iVar.e * view.getScaleX();
            MediaController.i iVar2 = this.n;
            int i3 = (int) (scaleX / iVar2.c);
            int scaleY = (int) (((measuredHeight * iVar2.f) * view.getScaleY()) / this.n.c);
            float fCeil = ((float) Math.ceil((getMeasuredWidth() - i3) / 2.0f)) + this.t;
            float measuredHeight2 = (((((getMeasuredHeight() - currentActionBarHeight) - AbstractC21455b.F(48.0f)) + getAdditionalBottom()) - scaleY) / 2.0f) + AbstractC21455b.F(8.0f) + i + this.u;
            canvas.clipRect(Math.max(0.0f, fCeil), Math.max(0.0f, measuredHeight2), Math.min(fCeil + i3, getMeasuredWidth()), Math.min(getMeasuredHeight(), measuredHeight2 + scaleY));
            i = 1;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        if (i != 0) {
            canvas.restore();
        }
        return zDrawChild;
    }

    @Override // ir.nasim.YZ2
    public void e(boolean z) {
        boolean z2 = !z;
        if (this.y1 != z2) {
            this.y1 = z2;
            this.W0.animate().cancel();
            this.W0.animate().alpha(z ? 0.0f : 1.0f).setInterpolator(InterpolatorC12631ew1.h).setDuration(240L).start();
        }
    }

    @Override // ir.nasim.YZ2
    public Bitmap f(ArrayList arrayList, Bitmap[] bitmapArr) {
        Canvas canvas;
        int i2;
        int i3;
        View view;
        boolean z;
        int i4;
        View view2;
        int i5;
        AnimatedEmojiSpan[] animatedEmojiSpanArr;
        LPhotoPaintView lPhotoPaintView = this;
        Bitmap resultBitmap = lPhotoPaintView.H.getResultBitmap();
        lPhotoPaintView.O0 = BigInteger.ONE;
        if (resultBitmap != null && lPhotoPaintView.A0.d() > 0) {
            int childCount = lPhotoPaintView.A0.getChildCount();
            int i6 = 0;
            int i7 = 0;
            Canvas canvas2 = null;
            while (i7 < childCount) {
                View childAt = lPhotoPaintView.A0.getChildAt(i7);
                if (childAt instanceof EntityView) {
                    EntityView entityView = (EntityView) childAt;
                    C22697vg5 position = entityView.getPosition();
                    if (arrayList != null) {
                        H.b bVar = new H.b();
                        if (entityView instanceof TextPaintView) {
                            bVar.a = (byte) 1;
                            TextPaintView textPaintView = (TextPaintView) entityView;
                            CharSequence text = textPaintView.getText();
                            if (text instanceof Spanned) {
                                Spanned spanned = (Spanned) text;
                                AnimatedEmojiSpan[] animatedEmojiSpanArr2 = (AnimatedEmojiSpan[]) spanned.getSpans(i6, text.length(), AnimatedEmojiSpan.class);
                                if (animatedEmojiSpanArr2 != null) {
                                    int i8 = i6;
                                    while (i8 < animatedEmojiSpanArr2.length) {
                                        AnimatedEmojiSpan animatedEmojiSpan = animatedEmojiSpanArr2[i8];
                                        Canvas canvas3 = canvas2;
                                        AbstractC18106o57 abstractC18106o57H = animatedEmojiSpan.b;
                                        if (abstractC18106o57H == null) {
                                            i5 = childCount;
                                            animatedEmojiSpanArr = animatedEmojiSpanArr2;
                                            abstractC18106o57H = C21463b.h(lPhotoPaintView.r1, animatedEmojiSpan.g());
                                        } else {
                                            i5 = childCount;
                                            animatedEmojiSpanArr = animatedEmojiSpanArr2;
                                        }
                                        if (abstractC18106o57H != null) {
                                            C21463b.k(lPhotoPaintView.r1).r(abstractC18106o57H);
                                        }
                                        H.a aVar = new H.a();
                                        int i9 = i7;
                                        View view3 = childAt;
                                        aVar.f = animatedEmojiSpan.g();
                                        aVar.g = abstractC18106o57H;
                                        aVar.b = spanned.getSpanStart(animatedEmojiSpan);
                                        aVar.c = spanned.getSpanEnd(animatedEmojiSpan) - aVar.b;
                                        aVar.i = C4278El2.H(lPhotoPaintView.r1).Q(abstractC18106o57H, true).getAbsolutePath();
                                        boolean zM0 = C10743c74.m0(aVar.g, true);
                                        if (zM0 || C10743c74.h1(aVar.g)) {
                                            aVar.k = (byte) ((zM0 ? (byte) 1 : (byte) 4) | aVar.k);
                                        }
                                        bVar.i.add(aVar);
                                        if (abstractC18106o57H != null) {
                                            BigInteger bigIntegerValueOf = BigInteger.valueOf(5000L);
                                            lPhotoPaintView.O0 = lPhotoPaintView.O0.multiply(bigIntegerValueOf).divide(lPhotoPaintView.O0.gcd(bigIntegerValueOf));
                                        }
                                        i8++;
                                        i7 = i9;
                                        canvas2 = canvas3;
                                        childCount = i5;
                                        animatedEmojiSpanArr2 = animatedEmojiSpanArr;
                                        childAt = view3;
                                    }
                                }
                                canvas = canvas2;
                                i2 = childCount;
                                i3 = i7;
                                view = childAt;
                                bVar.i.isEmpty();
                            } else {
                                canvas = canvas2;
                                i2 = childCount;
                                i3 = i7;
                                view = childAt;
                            }
                            bVar.h = text.toString();
                            bVar.b = (byte) textPaintView.getType();
                            bVar.j = textPaintView.getSwatch().a;
                            bVar.k = textPaintView.getTextSize();
                            bVar.l = textPaintView.getTypeface();
                            bVar.m = textPaintView.getAlign();
                            z = true;
                        } else {
                            canvas = canvas2;
                            i2 = childCount;
                            i3 = i7;
                            view = childAt;
                            if (entityView instanceof StickerView) {
                                bVar.a = (byte) 0;
                                StickerView stickerView = (StickerView) entityView;
                                SD6 baseSize = stickerView.getBaseSize();
                                bVar.f = baseSize.a;
                                bVar.g = baseSize.b;
                                bVar.v = stickerView.getSticker();
                                bVar.w = stickerView.getParentObject();
                                AbstractC18106o57 sticker = stickerView.getSticker();
                                z = true;
                                if (C10743c74.m0(sticker, true) || C10743c74.h1(sticker)) {
                                    boolean zM02 = C10743c74.m0(sticker, true);
                                    bVar.b = (byte) (bVar.b | (zM02 ? (byte) 1 : (byte) 4));
                                    long duration = zM02 ? stickerView.getDuration() : 5000L;
                                    if (duration != 0) {
                                        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(duration);
                                        lPhotoPaintView.O0 = lPhotoPaintView.O0.multiply(bigIntegerValueOf2).divide(lPhotoPaintView.O0.gcd(bigIntegerValueOf2));
                                    }
                                }
                                if (stickerView.h0()) {
                                    bVar.b = (byte) (bVar.b | 2);
                                }
                            }
                        }
                        arrayList.add(bVar);
                        float scaleX = view.getScaleX();
                        float scaleY = view.getScaleY();
                        float x = view.getX();
                        float y = view.getY();
                        bVar.n = view.getWidth();
                        bVar.o = view.getHeight();
                        bVar.f = (view.getWidth() * scaleX) / lPhotoPaintView.A0.getMeasuredWidth();
                        bVar.g = (view.getHeight() * scaleY) / lPhotoPaintView.A0.getMeasuredHeight();
                        bVar.c = (((view.getWidth() * (1.0f - scaleX)) / 2.0f) + x) / lPhotoPaintView.A0.getMeasuredWidth();
                        bVar.d = (((view.getHeight() * (1.0f - scaleY)) / 2.0f) + y) / lPhotoPaintView.A0.getMeasuredHeight();
                        bVar.e = (float) ((-view.getRotation()) * 0.017453292519943295d);
                        bVar.t = (x + (view.getWidth() / 2.0f)) / lPhotoPaintView.A0.getMeasuredWidth();
                        bVar.u = (y + (view.getHeight() / 2.0f)) / lPhotoPaintView.A0.getMeasuredHeight();
                        bVar.r = bVar.n / lPhotoPaintView.A0.getMeasuredWidth();
                        bVar.s = bVar.o / lPhotoPaintView.A0.getMeasuredHeight();
                        bVar.q = scaleX;
                        if (bitmapArr[0] == null) {
                            bitmapArr[0] = Bitmap.createBitmap(resultBitmap.getWidth(), resultBitmap.getHeight(), resultBitmap.getConfig());
                            Canvas canvas4 = new Canvas(bitmapArr[0]);
                            canvas4.drawBitmap(resultBitmap, 0.0f, 0.0f, (Paint) null);
                            canvas = canvas4;
                        }
                    } else {
                        canvas = canvas2;
                        i2 = childCount;
                        i3 = i7;
                        view = childAt;
                        z = false;
                    }
                    Canvas canvas5 = new Canvas(resultBitmap);
                    int i10 = 0;
                    int i11 = 2;
                    while (i10 < i11) {
                        Canvas canvas6 = i10 == 0 ? canvas5 : canvas;
                        if (canvas6 == null || (i10 == 0 && z)) {
                            view2 = view;
                        } else {
                            canvas6.save();
                            canvas6.translate(position.a, position.b);
                            canvas6.scale(view.getScaleX(), view.getScaleY());
                            canvas6.rotate(view.getRotation());
                            canvas6.translate((-entityView.getWidth()) / 2.0f, (-entityView.getHeight()) / 2.0f);
                            view2 = view;
                            if (!(view2 instanceof TextPaintView) || view2.getHeight() <= 0 || view2.getWidth() <= 0) {
                                view2.draw(canvas6);
                            } else {
                                Bitmap bitmapA = AbstractC21456c.a(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                                Canvas canvas7 = new Canvas(bitmapA);
                                view2.draw(canvas7);
                                canvas6.drawBitmap(bitmapA, (Rect) null, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), (Paint) null);
                                try {
                                    canvas7.setBitmap(null);
                                } catch (Exception e2) {
                                    AbstractC6403Nl2.d(e2);
                                }
                                bitmapA.recycle();
                            }
                            canvas6.restore();
                        }
                        i10++;
                        i11 = 2;
                        view = view2;
                    }
                    i4 = 0;
                    canvas2 = canvas;
                    i6 = i4;
                    i7 = i3 + 1;
                    childCount = i2;
                    lPhotoPaintView = this;
                } else {
                    canvas = canvas2;
                    i2 = childCount;
                    i3 = i7;
                }
                canvas2 = canvas;
                i4 = 0;
                i6 = i4;
                i7 = i3 + 1;
                childCount = i2;
                lPhotoPaintView = this;
            }
        }
        return resultBitmap;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void g(int i2) {
        EntityView entityView = this.A;
        if (entityView instanceof TextPaintView) {
            G2((TextPaintView) entityView, i2);
            T45.h(this.r1).n(i2);
        }
    }

    @Override // ir.nasim.YZ2
    public int getAdditionalBottom() {
        return AbstractC21455b.F(24.0f);
    }

    @Override // ir.nasim.YZ2
    public int getAdditionalTop() {
        return AbstractC21455b.F(48.0f);
    }

    @Override // ir.nasim.YZ2
    public View getCancelView() {
        return this.g;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float getCropRotation() {
        MediaController.i iVar = this.n;
        if (iVar != null) {
            return iVar.d + iVar.i;
        }
        return 0.0f;
    }

    public View getDoneView() {
        return this.h;
    }

    @Override // ir.nasim.YZ2
    public long getLcm() {
        return this.O0.longValue();
    }

    @Override // ir.nasim.YZ2
    public List<AbstractC24131y57> getMasks() {
        AnimatedEmojiSpan[] animatedEmojiSpanArr;
        int childCount = this.A0.getChildCount();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.A0.getChildAt(i2);
            if (childAt instanceof StickerView) {
                AbstractC18106o57 sticker = ((StickerView) childAt).getSticker();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Q87 q87 = new Q87();
                q87.b = sticker.c;
                q87.c = sticker.d;
                byte[] bArr = sticker.e;
                q87.d = bArr;
                if (bArr == null) {
                    q87.d = new byte[0];
                }
                arrayList.add(q87);
            } else if (childAt instanceof TextPaintView) {
                CharSequence text = ((TextPaintView) childAt).getText();
                if ((text instanceof Spanned) && (animatedEmojiSpanArr = (AnimatedEmojiSpan[]) ((Spanned) text).getSpans(0, text.length(), AnimatedEmojiSpan.class)) != null) {
                    for (AnimatedEmojiSpan animatedEmojiSpan : animatedEmojiSpanArr) {
                        if (animatedEmojiSpan != null) {
                            AbstractC18106o57 abstractC18106o57H = animatedEmojiSpan.b;
                            if (abstractC18106o57H == null) {
                                abstractC18106o57H = C21463b.h(this.r1, animatedEmojiSpan.g());
                            }
                            if (abstractC18106o57H != null) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Q87 q872 = new Q87();
                                q872.b = abstractC18106o57H.c;
                                q872.c = abstractC18106o57H.d;
                                byte[] bArr2 = abstractC18106o57H.e;
                                q872.d = bArr2;
                                if (bArr2 == null) {
                                    q872.d = new byte[0];
                                }
                                arrayList.add(q872);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.YZ2
    public float getOffsetTranslationY() {
        return this.i;
    }

    @Override // ir.nasim.YZ2
    public RenderView getRenderView() {
        return this.H;
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ View getView() {
        return super.getView();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean i(EntityView entityView) {
        return D2(entityView);
    }

    @Override // ir.nasim.YZ2
    public void init() {
        this.T0.setTypeface(T45.h(this.r1).e());
        this.A0.setVisibility(0);
        this.H.setVisibility(0);
        this.J.setVisibility(0);
    }

    @Override // ir.nasim.YZ2
    public int j(boolean z) {
        if (this.G1 && z) {
            y1(0.0f, 1.0f);
        }
        if (this.D1 && this.G1 && !z) {
            return 0;
        }
        return (!this.O1.i() || this.D1) ? this.F1 : this.H1;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float[] k(MotionEvent motionEvent, float f2, float f3) {
        Point point = AbstractC21455b.h;
        float f4 = f3 - (point.y / 2.0f);
        double d2 = f2 - (point.x / 2.0f);
        double radians = (float) Math.toRadians(-this.A0.getRotation());
        double d3 = f4;
        this.z1[0] = ((float) ((Math.cos(radians) * d2) - (Math.sin(radians) * d3))) + (AbstractC21455b.h.x / 2.0f);
        this.z1[1] = ((float) ((d2 * Math.sin(radians)) + (d3 * Math.cos(radians)))) + (AbstractC21455b.h.y / 2.0f);
        return this.z1;
    }

    @Override // ir.nasim.YZ2
    public void m(boolean z) {
        if (this.G0 == 0) {
            this.L0.setLayerType(z ? 2 : 0, null);
            this.C0.setLayerType(z ? 2 : 0, null);
            this.B0.setLayerType(z ? 2 : 0, null);
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void n() {
        D1(true);
    }

    @Override // ir.nasim.YZ2
    public void o(PhotoViewer photoViewer, Activity activity, final Runnable runnable) {
        if (this.n1) {
            H2(false);
            return;
        }
        if (this.B1) {
            L1(true);
            return;
        }
        if (this.B) {
            D2(null);
            return;
        }
        if (!x()) {
            runnable.run();
            return;
        }
        if (activity == null) {
            return;
        }
        AlertDialog.i iVar = new AlertDialog.i(activity, this.t1);
        iVar.e(FH3.E("PhotoEditorDiscardAlert", TD5.tgwidget_PhotoEditorDiscardAlert));
        iVar.j(FH3.E("DiscardChanges", TD5.tgwidget_DiscardChanges));
        iVar.i(FH3.E("PassportDiscard", TD5.tgwidget_PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.nasim.cs3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                runnable.run();
            }
        });
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), null);
        photoViewer.jb(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.M1 = false;
        super.onAttachedToWindow();
        this.O1.u(this);
        this.O1.o();
        E.j().e(this, E.a4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.M1 = true;
        super.onDetachedFromWindow();
        this.O1.p();
        E.j().u(this, E.a4);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = !this.G ? AbstractC21455b.d : 0;
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i8;
        int iCeil = (int) Math.ceil((i6 - this.H.getMeasuredWidth()) / 2.0f);
        int iF = ((((i7 - currentActionBarHeight) - AbstractC21455b.F(48.0f)) - this.H.getMeasuredHeight()) / 2) + AbstractC21455b.F(8.0f) + i8 + ((getAdditionalTop() - getAdditionalBottom()) / 2);
        RenderView renderView = this.H;
        renderView.layout(iCeil, iF, renderView.getMeasuredWidth() + iCeil, this.H.getMeasuredHeight() + iF);
        View view = this.J;
        view.layout(iCeil, iF, view.getMeasuredWidth() + iCeil, this.J.getMeasuredHeight() + iF);
        int measuredWidth = ((this.H.getMeasuredWidth() - this.A0.getMeasuredWidth()) / 2) + iCeil;
        int measuredHeight = ((this.H.getMeasuredHeight() - this.A0.getMeasuredHeight()) / 2) + iF;
        EntitiesContainerView entitiesContainerView = this.A0;
        entitiesContainerView.layout(measuredWidth, measuredHeight, entitiesContainerView.getMeasuredWidth() + measuredWidth, this.A0.getMeasuredHeight() + measuredHeight);
        FrameLayout frameLayout = this.z0;
        frameLayout.layout(iCeil, iF, frameLayout.getMeasuredWidth() + iCeil, this.z0.getMeasuredHeight() + iF);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        float currentActionBarHeight;
        float width;
        this.x = true;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        int currentActionBarHeight2 = (((AbstractC21455b.h.y - ActionBar.getCurrentActionBarHeight()) - getAdditionalTop()) - getAdditionalBottom()) - AbstractC21455b.F(48.0f);
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            width = bitmap.getWidth();
            currentActionBarHeight = this.j.getHeight();
        } else {
            currentActionBarHeight = (size2 - ActionBar.getCurrentActionBarHeight()) - AbstractC21455b.F(48.0f);
            width = size;
        }
        float fFloor = size;
        float fFloor2 = (float) Math.floor((fFloor * currentActionBarHeight) / width);
        float f2 = currentActionBarHeight2;
        if (fFloor2 > f2) {
            fFloor = (float) Math.floor((width * f2) / currentActionBarHeight);
            fFloor2 = f2;
        }
        int i4 = (int) fFloor;
        int i5 = (int) fFloor2;
        this.H.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
        this.J.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
        float f3 = fFloor / this.z.a;
        this.y = f3;
        this.A0.setScaleX(f3);
        this.A0.setScaleY(this.y);
        this.A0.measure(View.MeasureSpec.makeMeasureSpec((int) this.z.a, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.z.b, 1073741824));
        EntityView entityView = this.A;
        if (entityView != null) {
            entityView.d0();
        }
        this.z0.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
        measureChild(this.C0, i2, i3);
        measureChild(this.L0, i2, i3);
        measureChild(this.E0, i2, i3);
        measureChild(this.D0, i2, i3);
        FrameLayout frameLayout = this.B0;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), AbstractC21455b.F(12.0f) + AbstractC21455b.d, this.B0.getPaddingRight(), this.B0.getPaddingBottom());
        measureChild(this.B0, i2, i3);
        this.x = false;
        if (!this.J1 && AbstractC21455b.F(20.0f) >= 0 && !this.B1 && !this.E1) {
            this.x = true;
            M1();
            this.x = false;
        }
        if (AbstractC21455b.F(20.0f) >= 0) {
            return;
        }
        M1();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto.a
    public void onSizeChanged(int i2, boolean z) {
        boolean z2;
        if (i2 > AbstractC21455b.F(50.0f) && this.D1 && !AbstractC21455b.s && !AbstractC21455b.F0()) {
            if (z) {
                this.I1 = i2;
            } else {
                this.H1 = i2;
            }
        }
        requestLayout();
        z2();
        if (this.K1 == i2 && this.L1 == z) {
            z2();
            return;
        }
        this.K1 = i2;
        this.L1 = z;
        boolean z3 = this.D1;
        EntityView entityView = this.A;
        if (entityView instanceof TextPaintView) {
            this.D1 = ((TextPaintView) entityView).getEditText().isFocused() && i2 > 0;
        } else {
            this.D1 = false;
        }
        if (this.D1 && this.B1) {
            I2(0);
        }
        if (this.F1 != 0 && !(z2 = this.D1) && z2 != z3 && !this.B1) {
            this.F1 = 0;
            requestLayout();
        }
        if (z3 && !this.D1 && this.F1 > 0 && this.G1) {
            this.G1 = false;
            y1(0.0f, 1.0f);
            this.L0.l();
        }
        if (this.D1 && this.J1) {
            this.J1 = false;
            AbstractC21455b.t(this.N1);
        }
        z2();
        O2();
    }

    @Override // ir.nasim.YZ2
    public float p() {
        return this.o;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public T45 q() {
        return T45.h(this.r1);
    }

    @Override // ir.nasim.YZ2
    public void r() {
        this.A0.removeAllViews();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.x) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.nasim.YZ2
    public void setOffsetTranslationX(float f2) {
        if (this.G0 == 0) {
            this.L0.setTranslationX(f2);
        }
    }

    @Override // ir.nasim.YZ2
    public void setOffsetTranslationY(float f2, float f3, int i2, boolean z) {
        this.i = f2;
        if (z) {
            setTranslationY(0.0f);
        } else {
            this.B0.setTranslationY(-f2);
            this.C0.setTranslationY(f2);
        }
    }

    @Override // ir.nasim.YZ2
    public void setOnDoneButtonClickedListener(Runnable runnable) {
        this.x1 = runnable;
    }

    @Override // ir.nasim.YZ2
    public void setTransform(float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        this.q = f2;
        this.v = f5;
        this.w = f6;
        this.r = f3;
        this.s = f4;
        this.t = f3;
        float f12 = f4 + this.p;
        this.u = f12;
        int i2 = 0;
        while (i2 < 4) {
            View view = i2 == 0 ? this.A0 : i2 == 1 ? this.z0 : i2 == 2 ? this.H : this.J;
            MediaController.i iVar = this.n;
            if (iVar != null) {
                float f13 = iVar.c * 1.0f;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (measuredWidth == 0 || measuredHeight == 0) {
                    return;
                }
                int i3 = this.n.i;
                if (i3 == 90 || i3 == 270) {
                    measuredHeight = measuredWidth;
                    measuredWidth = measuredHeight;
                }
                float fMax = Math.max(f5 / ((int) (r12.e * r10)), f6 / ((int) (r12.f * r11)));
                f8 = f13 * fMax;
                MediaController.i iVar2 = this.n;
                float f14 = iVar2.a * measuredWidth * f2 * fMax;
                float f15 = iVar2.c;
                f9 = (f14 * f15) + f3;
                float f16 = (iVar2.b * measuredHeight * f2 * fMax * f15) + f12;
                f10 = iVar2.d + i3;
                f11 = f16;
                f7 = 1.0f;
            } else {
                if (i2 == 0) {
                    f7 = 1.0f;
                    f8 = this.y * 1.0f;
                } else {
                    f7 = 1.0f;
                    f8 = 1.0f;
                }
                f9 = f3;
                f10 = 0.0f;
                f11 = f12;
            }
            float f17 = f8 * f2;
            if (!Float.isNaN(f17)) {
                f7 = f17;
            }
            view.setScaleX(f7);
            view.setScaleY(f7);
            view.setTranslationX(f9);
            view.setTranslationY(f11);
            view.setRotation(f10);
            view.invalidate();
            i2++;
        }
        invalidate();
    }

    @Override // ir.nasim.YZ2
    public void shutdown() {
        this.H.H();
        this.A0.setVisibility(8);
        this.z0.setVisibility(8);
        this.m.i(new Runnable() { // from class: ir.nasim.bs3
            @Override // java.lang.Runnable
            public final void run() {
                LPhotoPaintView.v2();
            }
        });
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i2, int i3, Object... objArr) {
        if (i2 != E.a4 || this.A0 == null) {
            return;
        }
        for (int i4 = 0; i4 < this.A0.getChildCount(); i4++) {
            View childAt = this.A0.getChildAt(i4);
            if (childAt instanceof TextPaintView) {
                ((TextPaintView) childAt).o0();
            }
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public int[] v(EntityView entityView) {
        return I1(entityView);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public void w(View view) {
        K2(new Runnable() { // from class: ir.nasim.rs3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e2();
            }
        }, this, 53, 0, getHeight());
    }

    @Override // ir.nasim.YZ2
    public boolean x() {
        return this.l.b();
    }

    protected void x2() {
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void y(View view) {
        setTextType((this.D + 1) % 4);
    }

    public void y2(LU4 lu4) {
        T45.h(this.r1).q(lu4.o());
        EntityView entityView = this.A;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setTypeface(lu4);
        }
    }
}
