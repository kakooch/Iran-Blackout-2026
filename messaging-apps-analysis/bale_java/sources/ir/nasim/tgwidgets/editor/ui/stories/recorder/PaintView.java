package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
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
import android.util.Pair;
import android.util.Property;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC12724f57;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC18697p57;
import ir.nasim.AbstractC20918sp3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC24131y57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C16463lJ6;
import ir.nasim.C17574nB7;
import ir.nasim.C17645nJ6;
import ir.nasim.C18390oa7;
import ir.nasim.C18435of2;
import ir.nasim.C19026pf2;
import ir.nasim.C19136pq2;
import ir.nasim.C22477vI7;
import ir.nasim.C22697vg5;
import ir.nasim.C24749z85;
import ir.nasim.C4278El2;
import ir.nasim.C7501Rz2;
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
import ir.nasim.tgwidgets.editor.messenger.C;
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
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EditTextOutline;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintCancelView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintColorsListView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintDoneView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTypefaceListView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PhotoView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.StickerView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.TextPaintView;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class PaintView extends SizeNotifierFrameLayoutPhoto implements YZ2, PaintToolsView.b, EntityView.g, PaintTextOptionsView.b, SizeNotifierFrameLayoutPhoto.a, StoryRecorder.u {
    private boolean A;
    private FrameLayout A0;
    private int A1;
    private RenderView B;
    private FrameLayout B0;
    private int B1;
    private LinearLayout C0;
    private PX0 C1;
    private View D;
    private View D0;
    private ObjectAnimator D1;
    private int E0;
    private boolean E1;
    private int F0;
    private boolean F1;
    private FrameLayout G;
    private float G0;
    private final float[] G1;
    public EntitiesContainerView H;
    private ValueAnimator H0;
    private final int[] H1;
    private boolean I0;
    private int[] I1;
    private FrameLayout J;
    private PaintWeightChooserView J0;
    private boolean J1;
    private PaintWeightChooserView.b K0;
    private boolean K1;
    private ArrayList L0;
    private boolean L1;
    private int M0;
    private int M1;
    private BigInteger N0;
    private boolean N1;
    private TextView O0;
    private int O1;
    private TextView P0;
    private int P1;
    private PaintToolsView Q0;
    private boolean Q1;
    private PaintTextOptionsView R0;
    private int R1;
    private PaintTypefaceListView S0;
    private boolean S1;
    private ImageView T0;
    private LinearLayout U0;
    private boolean U1;
    private ImageView V0;
    private Runnable V1;
    private TextView W0;
    private TextView X0;
    private TextView Y0;
    private TextView Z0;
    private Paint a1;
    private Paint b1;
    private float c1;
    private boolean d1;
    private C16463lJ6 e1;
    private PaintColorsListView f1;
    private final int g;
    private Paint g1;
    private final int h;
    private Paint h1;
    private final int i;
    private Paint i1;
    private PaintCancelView j;
    private G37 j1;
    private PaintDoneView k;
    private boolean k1;
    private float l;
    private boolean l1;
    private Bitmap m;
    private C16463lJ6 m1;
    private Bitmap n;
    private float n1;
    private C17574nB7 o;
    private Paint o1;
    private HU1 p;
    private int p1;
    private MediaController.i q;
    private m.h q1;
    private float r;
    private ActionBarPopupWindow r1;
    private float s;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout s1;
    private boolean t;
    private Rect t1;
    private float u;
    private Runnable u1;
    private SD6 v;
    private Runnable v1;
    private EntityView w;
    private StoryRecorder.WindowView w1;
    private boolean x;
    private AnimatorSet x1;
    private int y;
    public final AbstractC20918sp3 y1;
    public boolean z;
    private FrameLayout z0;
    private ArrayList z1;

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
            final /* synthetic */ PaintView b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, PaintView paintView) {
                super(context);
                this.b = paintView;
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
            setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.u0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4, PaintView.this.q1), false));
            a aVar = new a(context, PaintView.this);
            this.b = aVar;
            addView(aVar, AbstractC13840gu3.n(-2, -2, 19, 16, 0, 16, 0));
            ImageView imageView = new ImageView(context);
            this.c = imageView;
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
            imageView.setScaleType(scaleType);
            ImageView imageView2 = this.c;
            int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
            imageView2.setColorFilter(PaintView.this.R1(i));
            this.b.addView(this.c, AbstractC13840gu3.d(-2, -2, 17));
            ImageView imageView3 = new ImageView(context);
            this.d = imageView3;
            imageView3.setScaleType(scaleType);
            this.d.setColorFilter(PaintView.this.R1(i));
            this.d.setVisibility(8);
            this.b.addView(this.d, AbstractC13840gu3.d(-2, -2, 17));
            TextView textView = new TextView(context);
            this.a = textView;
            textView.setTextColor(PaintView.this.R1(i));
            this.a.setPadding(20, 0, 0, 0);
            addView(this.a, AbstractC13840gu3.n(-2, -2, 19, 0, 0, 16, 0));
            ImageView imageView4 = new ImageView(context);
            this.h = imageView4;
            imageView4.setImageResource(AbstractC23598xB5.msg_text_check);
            this.h.setScaleType(scaleType);
            this.h.setColorFilter(new PorterDuffColorFilter(PaintView.this.R1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q5), PorterDuff.Mode.MULTIPLY));
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
            if (PaintView.this.r1 != null && PaintView.this.r1.isShowing()) {
                PaintView.this.r1.k(true);
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
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.DV4
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

    class a extends FrameLayout {
        a(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            PaintView.this.a1.setAlpha((int) (PaintView.this.R0.getAlpha() * 20.0f * (1.0f - PaintView.this.c1)));
            PaintTextOptionsView paintTextOptionsView = PaintView.this.R0;
            RectF rectF = AbstractC21455b.x;
            paintTextOptionsView.g(rectF);
            float top = PaintView.this.z0.getTop() + PaintView.this.R0.getTop() + PaintView.this.z0.getTranslationY() + PaintView.this.R0.getTranslationY();
            rectF.set(AbstractC21455b.T0(rectF.left, PaintView.this.S0.getLeft(), PaintView.this.c1), AbstractC21455b.T0(rectF.top + top, PaintView.this.S0.getTop() - PaintView.this.S0.getTranslationY(), PaintView.this.c1), AbstractC21455b.T0(rectF.right, PaintView.this.S0.getRight(), PaintView.this.c1), AbstractC21455b.T0(top + rectF.bottom, PaintView.this.S0.getBottom() - PaintView.this.S0.getTranslationY(), PaintView.this.c1));
            float F = AbstractC21455b.F(AbstractC21455b.U0(32, 16, PaintView.this.c1));
            int alpha = PaintView.this.b1.getAlpha();
            PaintView.this.b1.setAlpha((int) (alpha * PaintView.this.c1));
            canvas.drawRoundRect(rectF, F, F, PaintView.this.b1);
            PaintView.this.b1.setAlpha(alpha);
            canvas.drawRoundRect(rectF, F, F, PaintView.this.a1);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0 || !PaintView.this.d1) {
                return super.onTouchEvent(motionEvent);
            }
            PaintView.this.h3(false);
            return true;
        }
    }

    class b extends PaintColorsListView {
        private Path c3;

        b(Context context) {
            super(context);
            this.c3 = new Path();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void draw(Canvas canvas) {
            ViewGroup barView = PaintView.this.getBarView();
            RectF rectF = AbstractC21455b.x;
            rectF.set(AbstractC21455b.U0(barView.getLeft() - getLeft(), 0, PaintView.this.n1), AbstractC21455b.U0(barView.getTop() - getTop(), 0, PaintView.this.n1), AbstractC21455b.U0(barView.getRight() - getLeft(), getWidth(), PaintView.this.n1), AbstractC21455b.U0(barView.getBottom() - getTop(), getHeight(), PaintView.this.n1));
            this.c3.rewind();
            this.c3.addRoundRect(rectF, AbstractC21455b.F(32.0f), AbstractC21455b.F(32.0f), Path.Direction.CW);
            canvas.save();
            canvas.clipPath(this.c3);
            super.draw(canvas);
            canvas.restore();
        }
    }

    class c implements PX0.h {
        private boolean a;
        final /* synthetic */ Bitmap b;
        final /* synthetic */ int c;

        c(Bitmap bitmap, int i) {
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
            PaintView.this.d3(false);
            T45.h(this.c).l(i);
            T45.h(this.c).k();
            PaintView.this.setNewColor(i);
            PaintView.this.f1.getAdapter().notifyDataSetChanged();
        }

        @Override // ir.nasim.PX0.h
        public void e(Bitmap bitmap, Canvas canvas) {
            Matrix matrix = PaintView.this.B.getMatrix();
            canvas.save();
            canvas.translate(PaintView.this.B.getX(), PaintView.this.B.getY());
            canvas.concat(matrix);
            canvas.scale(PaintView.this.B.getWidth() / this.b.getWidth(), PaintView.this.B.getHeight() / this.b.getHeight(), 0.0f, 0.0f);
            canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }

        @Override // ir.nasim.PX0.h
        public View f() {
            return PaintView.this;
        }

        @Override // ir.nasim.PX0.h
        public ViewGroup g() {
            return PaintView.this.B0;
        }

        @Override // ir.nasim.PX0.h
        public boolean h() {
            return this.b != null;
        }
    }

    class d extends AbstractC20918sp3 {
        d(View view, Utilities.b bVar) {
            super(view, bVar);
        }

        @Override // ir.nasim.AbstractC20918sp3
        public void h(boolean z) {
            super.h(z);
            if (z) {
                PaintView.this.h3(false);
            }
        }
    }

    class e implements PaintWeightChooserView.b {
        final /* synthetic */ TextPaintView a;
        final /* synthetic */ float b;

        e(TextPaintView textPaintView, float f) {
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

    class f extends LinearLayout {
        Paint a;

        f(Context context) {
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
            TextView textView = (TextView) getChildAt(PaintView.this.E0);
            TextView textView2 = PaintView.this.F0 != -1 ? (TextView) getChildAt(PaintView.this.F0) : null;
            this.a.setColor(textView.getCurrentTextColor());
            float y = ((textView.getY() + textView.getHeight()) - textView.getPaddingBottom()) + AbstractC21455b.F(3.0f);
            Layout layout = textView.getLayout();
            if (layout == null) {
                return;
            }
            Layout layout2 = textView2 != null ? textView2.getLayout() : null;
            float interpolation = layout2 == null ? 0.0f : InterpolatorC12631ew1.f.getInterpolation(PaintView.this.G0);
            float fT0 = AbstractC21455b.T0(textView.getX() + layout.getPrimaryHorizontal(layout.getLineStart(0)), layout2 != null ? textView2.getX() + layout2.getPrimaryHorizontal(layout.getLineStart(0)) : 0.0f, interpolation);
            canvas.drawLine(fT0, y, fT0 + AbstractC21455b.T0(layout.getPrimaryHorizontal(layout.getLineEnd(0)) - layout.getPrimaryHorizontal(layout.getLineStart(0)), layout2 != null ? layout2.getPrimaryHorizontal(layout2.getLineEnd(0)) - layout2.getPrimaryHorizontal(layout2.getLineStart(0)) : 0.0f, interpolation), y, this.a);
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;

        g(View view, View view2, int i) {
            this.a = view;
            this.b = view2;
            this.c = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PaintView paintView = PaintView.this;
            paintView.E0 = paintView.F0;
            PaintView.this.F0 = -1;
            PaintView.this.C0.invalidate();
            View view = this.a;
            if (view != null && this.b != null) {
                view.setVisibility(8);
            }
            if (animator == PaintView.this.H0) {
                PaintView.this.H0 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view;
            if (this.a != null && (view = this.b) != null) {
                view.setVisibility(0);
            }
            if (this.c == 1) {
                PaintView.this.J0.setMinMax(0.5f, 2.0f);
                return;
            }
            ir.nasim.tgwidgets.editor.ui.Components.Paint.a currentBrush = PaintView.this.B.getCurrentBrush();
            if ((currentBrush instanceof a.b) || (currentBrush instanceof a.d)) {
                PaintView.this.J0.setMinMax(0.4f, 1.75f);
            } else {
                PaintView.this.J0.setMinMax(0.05f, 1.0f);
            }
        }
    }

    class h extends StickerView {
        h(Context context, C22697vg5 c22697vg5, float f, float f2, SD6 sd6, AbstractC18106o57 abstractC18106o57, Object obj) {
            super(context, c22697vg5, f, f2, sd6, abstractC18106o57, obj);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.StickerView
        protected void g0(RLottieDrawable rLottieDrawable) {
            PaintView.this.J1(rLottieDrawable);
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PaintView.this.w instanceof TextPaintView) {
                EditTextOutline editText = ((TextPaintView) PaintView.this.w).getEditText();
                if (PaintView.this.U1 || editText == null || !PaintView.this.Q1 || PaintView.this.K1 || AbstractC21455b.r || AbstractC21455b.s || !AbstractC21455b.F0()) {
                    return;
                }
                editText.requestFocus();
                AbstractC21455b.C1(editText);
                AbstractC21455b.t(PaintView.this.V1);
                AbstractC21455b.n1(PaintView.this.V1, 100L);
            }
        }
    }

    class j implements PaintWeightChooserView.b {
        j() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public void a(float f) {
            T45.h(PaintView.this.p1).s(String.valueOf(ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.indexOf(PaintView.this.B.getCurrentBrush())), f);
            PaintView.this.j1.c = f;
            PaintView paintView = PaintView.this;
            paintView.a3(paintView.j1, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.b
        public float get() {
            ir.nasim.tgwidgets.editor.ui.Components.Paint.a currentBrush = PaintView.this.B.getCurrentBrush();
            return currentBrush == null ? T45.h(PaintView.this.p1).f() : T45.h(PaintView.this.p1).i(String.valueOf(ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.indexOf(currentBrush)), currentBrush.c());
        }
    }

    class k implements m.h {
        final /* synthetic */ m.h a;

        k(m.h hVar) {
            this.a = hVar;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.m.h
        public int getColor(int i) {
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7) {
                return -14145495;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7) {
                return -1;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.T3) {
                return -14737633;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.V3) {
                return -592138;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.d4) {
                return -8553091;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.id) {
                return -16777216;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.ld) {
                return -1610612736;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.od || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.sd || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.nd) {
                return -9539985;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.p5) {
                return -1;
            }
            int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Bf;
            if (i == i2) {
                return -11754001;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4) {
                return 536870911;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.uf || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.tf || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.vf) {
                return -1;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.wf) {
                return 352321535;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.kd || i == i2) {
                return -7895161;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.jd) {
                return 780633991;
            }
            m.h hVar = this.a;
            return hVar != null ? hVar.getColor(i) : ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i);
        }
    }

    class l extends RenderView {
        final /* synthetic */ Bitmap o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Context context, ir.nasim.tgwidgets.editor.ui.Components.Paint.d dVar, Bitmap bitmap, Bitmap bitmap2) {
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
            PaintView.this.Q0.t(iIndexOf);
            PaintView.this.A(aVar);
        }
    }

    class m implements RenderView.d {
        final /* synthetic */ Runnable a;

        m(Runnable runnable) {
            this.a = runnable;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public boolean a() {
            boolean z = PaintView.this.w == null;
            if (!z) {
                PaintView.this.Y2(null);
            }
            return z;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void b(boolean z) {
            PaintView.this.o.c().a();
            PaintView.this.J0.setViewHidden(false);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void c() {
            if (PaintView.this.w != null) {
                PaintView.this.Y2(null);
            }
            PaintView.this.J0.setViewHidden(true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void d() {
            if (PaintView.this.D != null) {
                PaintView.this.D.invalidate();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void e() {
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView.d
        public void f() {
            if (PaintView.this.I0) {
                PaintView.this.I0 = false;
            } else {
                PaintView.this.Q0.t(1);
                PaintView.this.A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
            }
        }
    }

    class n extends View {
        n(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (PaintView.this.B != null) {
                PaintView.this.B.z(canvas);
            }
        }
    }

    class o implements EntitiesContainerView.a {
        o() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public void a() {
            PaintView.this.Y2(null);
            PaintView paintView = PaintView.this;
            if (paintView.z) {
                paintView.K1();
                PaintView.this.z = false;
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public EntityView b() {
            return PaintView.this.w;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntitiesContainerView.a
        public boolean c() {
            return true;
        }
    }

    class p extends EntitiesContainerView {
        Paint g;
        long h;
        float i;
        float j;

        p(Context context, EntitiesContainerView.a aVar) {
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
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView.p.onDraw(android.graphics.Canvas):void");
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (PaintView.this.A1 <= 0) {
                PaintView paintView = PaintView.this;
                paintView.A1 = paintView.H.getMeasuredWidth();
            }
            if (PaintView.this.B1 <= 0) {
                PaintView paintView2 = PaintView.this;
                paintView2.B1 = paintView2.H.getMeasuredWidth();
            }
        }
    }

    class q extends FrameLayout {
        q(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }
    }

    class r extends FrameLayout {
        private float a;
        private float b;
        private Path c;

        r(Context context) {
            super(context);
            this.c = new Path();
            setWillNotDraw(false);
            PaintView.this.g1.setStyle(Paint.Style.STROKE);
            PaintView.this.g1.setStrokeWidth(AbstractC21455b.F(2.0f));
        }

        private void a(float f, float f2) {
            if (f == this.a && f2 == this.b) {
                return;
            }
            this.a = f;
            this.b = f2;
            PaintView.this.g1.setShader(new SweepGradient(f, f2, new int[]{-1356981, -1146130, -10452764, -16711681, -7352832, -256, -23296, -1356981}, (float[]) null));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            ViewGroup barView = PaintView.this.getBarView();
            RectF rectF = AbstractC21455b.x;
            rectF.set(AbstractC21455b.U0(barView.getLeft(), PaintView.this.f1.getLeft(), PaintView.this.n1), AbstractC21455b.U0(barView.getTop(), PaintView.this.f1.getTop(), PaintView.this.n1), AbstractC21455b.U0(barView.getRight(), PaintView.this.f1.getRight(), PaintView.this.n1), AbstractC21455b.U0(barView.getBottom(), PaintView.this.f1.getBottom(), PaintView.this.n1));
            float fU0 = AbstractC21455b.U0(AbstractC21455b.F(32.0f), AbstractC21455b.F(24.0f), PaintView.this.n1);
            canvas.drawRoundRect(rectF, fU0, fU0, PaintView.this.o1);
            if (barView.getChildCount() < 1 || PaintView.this.n1 == 1.0f) {
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
                PaintView.this.g1.setAlpha((int) ((1.0f - PaintView.this.n1) * view.getAlpha() * 255.0f));
                int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
                int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
                float x = view.getX() + view.getPaddingLeft() + (width / 2.0f);
                float y = view.getY() + view.getPaddingTop() + (height / 2.0f);
                if (PaintView.this.F0 != -1) {
                    PaintView paintView = PaintView.this;
                    ViewGroup viewGroup = (ViewGroup) paintView.N1(paintView.F0);
                    View childAt2 = (viewGroup == null ? barView : viewGroup).getChildAt(0);
                    if (viewGroup instanceof PaintTextOptionsView) {
                        childAt2 = ((PaintTextOptionsView) viewGroup).getColorClickableView();
                    }
                    x = AbstractC21455b.T0(x, childAt2.getX() + childAt2.getPaddingLeft() + (((childAt2.getWidth() - childAt2.getPaddingLeft()) - childAt2.getPaddingRight()) / 2.0f), PaintView.this.G0);
                    y = AbstractC21455b.T0(y, childAt2.getY() + childAt2.getPaddingTop() + (((childAt2.getHeight() - childAt2.getPaddingTop()) - childAt2.getPaddingBottom()) / 2.0f), PaintView.this.G0);
                }
                if (PaintView.this.f1 != null && PaintView.this.f1.getChildCount() > 0) {
                    View childAt3 = PaintView.this.f1.getChildAt(0);
                    x = AbstractC21455b.T0(x, (PaintView.this.f1.getX() - barView.getLeft()) + childAt3.getX() + (childAt3.getWidth() / 2.0f), PaintView.this.n1);
                    y = AbstractC21455b.T0(y, (PaintView.this.f1.getY() - barView.getTop()) + childAt3.getY() + (childAt3.getHeight() / 2.0f), PaintView.this.n1);
                }
                float f = y;
                float f2 = x;
                a(f2, f);
                float fMin = (Math.min(width, height) / 2.0f) - AbstractC21455b.F(0.5f);
                if (PaintView.this.f1 != null && PaintView.this.f1.getChildCount() > 0) {
                    View childAt4 = PaintView.this.f1.getChildAt(0);
                    fMin = AbstractC21455b.T0(fMin, (Math.min((childAt4.getWidth() - childAt4.getPaddingLeft()) - childAt4.getPaddingRight(), (childAt4.getHeight() - childAt4.getPaddingTop()) - childAt4.getPaddingBottom()) / 2.0f) - AbstractC21455b.F(2.0f), PaintView.this.n1);
                }
                float f3 = fMin;
                rectF.set(f2 - f3, f - f3, f2 + f3, f + f3);
                canvas.drawArc(rectF, 0.0f, 360.0f, false, PaintView.this.g1);
                PaintView.this.h1.setColor(PaintView.this.j1.a);
                PaintView.this.h1.setAlpha((int) (PaintView.this.h1.getAlpha() * view.getAlpha()));
                PaintView.this.i1.setColor(PaintView.this.j1.a);
                PaintView.this.i1.setAlpha((int) (view.getAlpha() * 255.0f));
                PaintColorsListView.c2(canvas, f2, f, f3 - AbstractC21455b.F(3.0f), PaintView.this.h1.getColor());
                PaintView.this.i1.setAlpha((int) (PaintView.this.i1.getAlpha() * PaintView.this.n1 * view.getAlpha()));
                canvas.drawCircle(f2, f, f3 - ((AbstractC21455b.F(3.0f) + PaintView.this.i1.getStrokeWidth()) * (1.0f - PaintView.this.n1)), PaintView.this.i1);
            }
            canvas.restore();
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (PaintView.this.A0 != null) {
                PaintView.this.A0.invalidate();
            }
        }
    }

    private static class s {
        private C22697vg5 a;
        private float b;
        private float c;

        s(C22697vg5 c22697vg5, float f, float f2) {
            this.a = c22697vg5;
            this.b = f;
            this.c = f2;
        }
    }

    public PaintView(final Context context, final StoryRecorder.WindowView windowView, Activity activity, final int i2, Bitmap bitmap, final Bitmap bitmap2, int i3, ArrayList arrayList, int i4, int i5, MediaController.i iVar, Runnable runnable, m.h hVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, activity, true);
        this.g = 0;
        this.h = 0;
        this.i = 1;
        this.E0 = 0;
        this.F0 = -1;
        this.K0 = new j();
        this.a1 = new Paint(1);
        this.b1 = new Paint(1);
        this.g1 = new Paint(1);
        this.h1 = new Paint(1);
        this.i1 = new Paint(1);
        this.j1 = new G37(-1, 1.0f, 0.016773745f);
        this.k1 = false;
        this.o1 = new Paint(1);
        this.E1 = false;
        this.G1 = new float[2];
        this.H1 = new int[2];
        this.I1 = new int[2];
        this.V1 = new i();
        setDelegate(this);
        this.w1 = windowView;
        this.z1 = arrayList;
        this.A1 = i4;
        this.B1 = i5;
        this.p1 = i2;
        this.q1 = new k(hVar);
        this.q = iVar;
        this.A = false;
        T45 t45H = T45.h(i2);
        this.j1.a = t45H.b(0);
        this.j1.c = t45H.f();
        this.p = new HU1("Paint");
        this.m = bitmap;
        this.n = bitmap2;
        this.M0 = i3;
        C17574nB7 c17574nB7 = new C17574nB7();
        this.o = c17574nB7;
        c17574nB7.h(new C17574nB7.a() { // from class: ir.nasim.cV4
            @Override // ir.nasim.C17574nB7.a
            public final void a() {
                this.a.a2();
            }
        });
        View view = new View(context);
        this.D0 = view;
        view.setVisibility(8);
        this.D0.setBackgroundColor(1291845632);
        this.D0.setAlpha(0.0f);
        l lVar = new l(context, new ir.nasim.tgwidgets.editor.ui.Components.Paint.d(getPaintingSize(), bitmap2, i3), this.m, bitmap2);
        this.B = lVar;
        lVar.setDelegate(new m(runnable));
        this.B.setUndoStore(this.o);
        this.B.setQueue(this.p);
        this.B.setVisibility(4);
        n nVar = new n(context);
        this.D = nVar;
        nVar.setVisibility(4);
        this.H = new p(context, new o());
        c3();
        this.H.setVisibility(4);
        this.G = new q(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.J = frameLayout;
        frameLayout.setPadding(AbstractC21455b.F(4.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(4.0f), AbstractC21455b.F(12.0f));
        FrameLayout frameLayout2 = this.J;
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        frameLayout2.setBackground(new GradientDrawable(orientation, new int[]{1073741824, 0}));
        addView(this.J, AbstractC13840gu3.d(-1, -2, 48));
        ImageView imageView = new ImageView(context);
        this.T0 = imageView;
        imageView.setImageResource(AbstractC23598xB5.photo_undo2);
        this.T0.setPadding(AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f));
        this.T0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.T0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.b2(view2);
            }
        });
        this.T0.setAlpha(0.6f);
        this.T0.setClickable(false);
        this.J.addView(this.T0, AbstractC13840gu3.c(32, 32.0f, 51, 12.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.U0 = linearLayout;
        linearLayout.setOrientation(0);
        this.U0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.U0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        TextView textView = new TextView(context);
        this.W0 = textView;
        textView.setTextColor(-1);
        this.W0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.W0.setTextSize(1, 16.0f);
        this.W0.setText(FH3.C(TD5.tgwidget_PhotoEditorZoomOut));
        ImageView imageView2 = new ImageView(context);
        this.V0 = imageView2;
        imageView2.setImageResource(AbstractC23598xB5.photo_zoomout);
        this.U0.addView(this.V0, AbstractC13840gu3.n(24, 24, 16, 0, 0, 8, 0));
        this.U0.addView(this.W0, AbstractC13840gu3.m(-2, -2, 16));
        this.U0.setAlpha(0.0f);
        this.U0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaintView.g2(view2);
            }
        });
        this.J.addView(this.U0, AbstractC13840gu3.d(-2, 32, 17));
        TextView textView2 = new TextView(context);
        this.X0 = textView2;
        textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.X0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.X0.setText(FH3.C(TD5.tgwidget_PhotoEditorClearAll));
        this.X0.setGravity(16);
        this.X0.setTextColor(-1);
        this.X0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.X0.setTextSize(1, 16.0f);
        this.X0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.h2(view2);
            }
        });
        this.X0.setAlpha(0.6f);
        this.J.addView(this.X0, AbstractC13840gu3.c(-2, 32.0f, 5, 0.0f, 0.0f, 4.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.Y0 = textView3;
        textView3.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.Y0.setText(FH3.C(TD5.tgwidget_Clear));
        this.Y0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.Y0.setGravity(16);
        this.Y0.setTextColor(-1);
        this.Y0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Y0.setTextSize(1, 16.0f);
        this.Y0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.i2(view2);
            }
        });
        this.Y0.setAlpha(0.0f);
        this.Y0.setVisibility(8);
        this.J.addView(this.Y0, AbstractC13840gu3.c(-2, 32.0f, 51, 4.0f, 0.0f, 0.0f, 0.0f));
        TextView textView4 = new TextView(context);
        this.Z0 = textView4;
        textView4.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(822083583, 7));
        this.Z0.setText(FH3.C(TD5.tgwidget_Done));
        this.Z0.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.Z0.setGravity(16);
        this.Z0.setTextColor(-1);
        this.Z0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.Z0.setTextSize(1, 16.0f);
        this.Z0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.j2(view2);
            }
        });
        this.Z0.setAlpha(0.0f);
        this.Z0.setVisibility(8);
        this.J.addView(this.Z0, AbstractC13840gu3.c(-2, 32.0f, 5, 0.0f, 0.0f, 4.0f, 0.0f));
        r rVar = new r(context);
        this.z0 = rVar;
        rVar.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), 0);
        this.z0.setBackground(new GradientDrawable(orientation, new int[]{0, RecyclerView.UNDEFINED_DURATION}));
        addView(this.z0, AbstractC13840gu3.d(-1, 104, 80));
        PaintToolsView paintToolsView = new PaintToolsView(context, bitmap2 != null);
        this.Q0 = paintToolsView;
        paintToolsView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
        this.Q0.setDelegate(this);
        this.Q0.setSelectedIndex(1);
        this.z0.addView(this.Q0, AbstractC13840gu3.b(-1, 48.0f));
        PaintTextOptionsView paintTextOptionsView = new PaintTextOptionsView(context);
        this.R0 = paintTextOptionsView;
        paintTextOptionsView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(8.0f), 0);
        this.R0.setVisibility(8);
        this.R0.setDelegate(this);
        post(new Runnable() { // from class: ir.nasim.mV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k2(i2);
            }
        });
        this.R0.setAlignment(T45.h(i2).c());
        this.z0.addView(this.R0, AbstractC13840gu3.b(-1, 48.0f));
        a aVar = new a(context);
        this.A0 = aVar;
        addView(aVar, AbstractC13840gu3.b(-1, -1.0f));
        PaintTypefaceListView paintTypefaceListView = new PaintTypefaceListView(context);
        this.S0 = paintTypefaceListView;
        paintTypefaceListView.setVisibility(8);
        this.S0.setOnItemClickListener(new RecyclerListView.i() { // from class: ir.nasim.nV4
            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.i
            public final void a(View view2, int i6) {
                this.a.l2(view2, i6);
            }
        });
        this.R0.setTypefaceListView(this.S0);
        this.A0.addView(this.S0, AbstractC13840gu3.c(-2, -2.0f, 85, 0.0f, 0.0f, 8.0f, 8.0f));
        this.a1.setStyle(Paint.Style.FILL);
        this.a1.setColor(352321535);
        this.b1.setColor(R1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7));
        b bVar = new b(context);
        this.f1 = bVar;
        bVar.setVisibility(8);
        this.f1.setColorPalette(T45.h(i2));
        this.f1.setColorListener(new InterfaceC25043ze1() { // from class: ir.nasim.oV4
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.m2((Integer) obj);
            }
        });
        this.z0.addView(this.f1, AbstractC13840gu3.c(-1, 84.0f, 48, 56.0f, 0.0f, 56.0f, 6.0f));
        setupTabsLayout(context);
        PaintCancelView paintCancelView = new PaintCancelView(context);
        this.j = paintCancelView;
        paintCancelView.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        this.j.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.z0.addView(this.j, AbstractC13840gu3.c(32, 32.0f, 83, 12.0f, 0.0f, 0.0f, 4.0f));
        this.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.n2(view2);
            }
        });
        PaintDoneView paintDoneView = new PaintDoneView(context);
        this.k = paintDoneView;
        paintDoneView.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
        this.k.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        this.k.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.d2(context, bitmap2, i2, view2);
            }
        });
        this.z0.addView(this.k, AbstractC13840gu3.c(32, 32.0f, 85, 0.0f, 0.0f, 12.0f, 4.0f));
        PaintWeightChooserView paintWeightChooserView = new PaintWeightChooserView(context);
        this.J0 = paintWeightChooserView;
        paintWeightChooserView.setColorSwatch(this.j1);
        this.J0.setRenderView(this.B);
        this.J0.setValueOverride(this.K0);
        this.j1.c = this.K0.get();
        this.J0.setOnUpdate(new Runnable() { // from class: ir.nasim.eV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e2(i2);
            }
        });
        addView(this.J0, AbstractC13840gu3.b(-1, -1.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.B0 = frameLayout3;
        addView(frameLayout3, AbstractC13840gu3.b(-1, -1.0f));
        this.i1.setStyle(Paint.Style.STROKE);
        this.i1.setStrokeWidth(AbstractC21455b.F(2.0f));
        a3(this.j1, true);
        A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
        B();
        if (Build.VERSION.SDK_INT >= 29) {
            setSystemGestureExclusionRects(Arrays.asList(new Rect(0, (int) (AbstractC21455b.h.y * 0.35f), AbstractC21455b.F(100.0f), (int) (AbstractC21455b.h.y * 0.65d))));
        }
        this.y1 = new d(windowView, new Utilities.b() { // from class: ir.nasim.fV4
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.f2(windowView, (Integer) obj);
            }
        });
    }

    private PopupButton A1(String str, int i2, boolean z, final Runnable runnable) {
        PopupButton popupButton = new PopupButton(getContext());
        popupButton.setIcon(i2);
        popupButton.setText(str);
        popupButton.setSelected(z);
        if (runnable != null) {
            popupButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vV4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    runnable.run();
                }
            });
        }
        return popupButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(EntityView entityView, View view) {
        Y2(entityView);
        M1();
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.r1.k(true);
    }

    private s B1(AbstractC18106o57 abstractC18106o57) {
        C18390oa7 c18390oa7;
        float f2;
        ArrayList arrayList;
        int i2;
        C24749z85 c24749z85Q1;
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
        MediaController.i iVar = this.q;
        float f3 = 0.75f;
        if (iVar != null) {
            f2 = -(iVar.i + iVar.d);
            f3 = 0.75f / iVar.c;
        } else {
            f2 = 0.0f;
        }
        s sVar = new s(C1(), f3, f2);
        if (c18390oa7 == null || (arrayList = this.L0) == null || arrayList.size() == 0 || (c24749z85Q1 = Q1((i2 = c18390oa7.b), abstractC18106o57.c, c18390oa7)) == null) {
            return sVar;
        }
        C22697vg5 c22697vg5B = c24749z85Q1.b(i2);
        float fC = c24749z85Q1.c(i2);
        return new s(new C22697vg5(c22697vg5B.a, c22697vg5B.b), (float) ((fC / z1().a) * c18390oa7.e), c24749z85Q1.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2(EntityView entityView, View view) {
        if (entityView instanceof StickerView) {
            ((StickerView) entityView).k0(true);
        } else {
            ((PhotoView) entityView).h0(true);
        }
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.r1.k(true);
    }

    private C22697vg5 C1() {
        int measuredWidth = this.H.getMeasuredWidth();
        int measuredHeight = this.H.getMeasuredHeight();
        if (measuredWidth <= 0) {
            measuredWidth = this.A1;
        }
        if (measuredHeight <= 0) {
            measuredHeight = this.B1;
        }
        return new C22697vg5(measuredWidth / 2.0f, measuredHeight / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2(EntityView entityView, View view) {
        L1(entityView);
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.r1.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2(final EntityView entityView) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
        textView.setTextColor(R1(i2));
        textView.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        textView.setGravity(16);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(14.0f), 0);
        textView.setTextSize(1, 14.0f);
        textView.setTag(0);
        textView.setText(FH3.E("PaintDelete", TD5.tgwidget_PaintDelete));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.SU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.y2(entityView, view);
            }
        });
        linearLayout.addView(textView, AbstractC13840gu3.g(-2, 48));
        if (entityView instanceof TextPaintView) {
            TextView textView2 = new TextView(getContext());
            textView2.setTextColor(R1(i2));
            textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
            textView2.setGravity(16);
            textView2.setEllipsize(truncateAt);
            textView2.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
            textView2.setTextSize(1, 14.0f);
            if ((!this.y1.i() || this.y1.c) && this.M1 <= 0) {
                textView2.setTag(1);
                textView2.setText(FH3.E("PaintEdit", TD5.tgwidget_PaintEdit));
                textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.UU4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.A2(entityView, view);
                    }
                });
            } else {
                textView2.setTag(3);
                textView2.setText(FH3.E("Paste", TD5.tgwidget_Paste));
                textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.TU4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.z2(entityView, view);
                    }
                });
            }
            linearLayout.addView(textView2, AbstractC13840gu3.g(-2, 48));
        }
        if ((entityView instanceof StickerView) || (entityView instanceof PhotoView)) {
            TextView textView3 = new TextView(getContext());
            textView3.setTextColor(R1(i2));
            textView3.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
            textView3.setEllipsize(truncateAt);
            textView3.setGravity(16);
            textView3.setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
            textView3.setTextSize(1, 14.0f);
            textView3.setTag(4);
            textView3.setText(FH3.C(TD5.tgwidget_Flip));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.VU4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.B2(entityView, view);
                }
            });
            linearLayout.addView(textView3, AbstractC13840gu3.g(-2, 48));
        }
        if (!(entityView instanceof PhotoView)) {
            TextView textView4 = new TextView(getContext());
            textView4.setTextColor(R1(i2));
            textView4.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
            textView4.setEllipsize(truncateAt);
            textView4.setGravity(16);
            textView4.setPadding(AbstractC21455b.F(14.0f), 0, AbstractC21455b.F(16.0f), 0);
            textView4.setTextSize(1, 14.0f);
            textView4.setTag(2);
            textView4.setText(FH3.E("PaintDuplicate", TD5.tgwidget_PaintDuplicate));
            textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WU4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.C2(entityView, view);
                }
            });
            linearLayout.addView(textView4, AbstractC13840gu3.g(-2, 48));
        }
        this.s1.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean E2(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.r1) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.t1);
        if (this.t1.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.r1.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.r1) != null && actionBarPopupWindow.isShowing()) {
            this.r1.dismiss();
        }
    }

    private StickerView G1(Object obj, AbstractC18106o57 abstractC18106o57, boolean z) {
        s sVarB1 = B1(abstractC18106o57);
        h hVar = new h(getContext(), sVarB1.a, sVarB1.c, sVarB1.b, z1(), abstractC18106o57, obj);
        if (C10743c74.b1(abstractC18106o57)) {
            hVar.K0.C0(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        }
        hVar.K0.d1(12);
        hVar.setDelegate(this);
        this.H.addView(hVar);
        if (z) {
            V2(hVar);
            Y2(hVar);
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2() {
        this.s1.n();
    }

    private TextPaintView H1(boolean z) {
        P2();
        SD6 paintingSize = getPaintingSize();
        C22697vg5 c22697vg5I3 = i3(null);
        TextPaintView textPaintView = new TextPaintView(getContext(), c22697vg5I3, (int) (paintingSize.a / 9.0f), "", this.j1, this.y);
        textPaintView.getEditText().K1 = true;
        if (c22697vg5I3.a == this.H.getMeasuredWidth() / 2.0f) {
            textPaintView.setHasStickyX(true);
        }
        if (c22697vg5I3.b == this.H.getMeasuredHeight() / 2.0f) {
            textPaintView.setHasStickyY(true);
        }
        textPaintView.setDelegate(this);
        textPaintView.setMaxWidth(this.A1 - AbstractC21455b.F(32.0f));
        textPaintView.setTypeface(T45.h(this.p1).e());
        textPaintView.setType(T45.h(this.p1).d());
        this.H.addView(textPaintView, AbstractC13840gu3.b(-2, -2.0f));
        MediaController.i iVar = this.q;
        if (iVar != null) {
            textPaintView.Z(1.0f / iVar.c);
            textPaintView.V(-(r0.i + this.q.d));
        }
        if (z) {
            V2(textPaintView);
            textPaintView.i0();
            Z2(textPaintView, false);
            textPaintView.getFocusedView().requestFocus();
            AbstractC21455b.C1(textPaintView.getFocusedView());
            this.x = true;
            this.R0.setAlignment(T45.h(this.p1).c(), true);
            this.R0.setOutlineType(T45.h(this.p1).d());
        }
        return textPaintView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
        float f4 = f2 / 1000.0f;
        this.c1 = f4;
        this.S0.setAlpha(f4);
        this.S0.invalidate();
        this.A0.invalidate();
        this.R0.getTypefaceCell().setAlpha(1.0f - this.c1);
    }

    private void I1() throws InterruptedException {
        this.p.j(new Runnable() { // from class: ir.nasim.CV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Y1();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2(boolean z, AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
        if (abstractC12098e22 == this.e1) {
            this.e1 = null;
            if (!z) {
                this.S0.setVisibility(8);
            }
            this.S0.setMaskProvider(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J2() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(View view, View view2, ValueAnimator valueAnimator) {
        this.G0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.C0.invalidate();
        this.z0.invalidate();
        this.A0.invalidate();
        int i2 = 0;
        while (i2 < this.C0.getChildCount()) {
            this.C0.getChildAt(i2).setAlpha(((i2 == this.F0 ? this.G0 : i2 == this.E0 ? 1.0f - this.G0 : 0.0f) * 0.4f) + 0.6f);
            i2++;
        }
        float interpolation = InterpolatorC12631ew1.f.getInterpolation(this.G0);
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

    private void L1(EntityView entityView) {
        EntityView entityView2;
        if (entityView == null) {
            return;
        }
        C22697vg5 c22697vg5I3 = i3(entityView);
        if (entityView instanceof StickerView) {
            StickerView stickerView = new StickerView(getContext(), (StickerView) entityView, c22697vg5I3);
            stickerView.setDelegate(this);
            this.H.addView(stickerView);
            entityView2 = stickerView;
        } else {
            if (!(entityView instanceof TextPaintView)) {
                return;
            }
            TextPaintView textPaintView = new TextPaintView(getContext(), (TextPaintView) entityView, c22697vg5I3);
            textPaintView.getEditText().K1 = true;
            textPaintView.setDelegate(this);
            textPaintView.setMaxWidth(this.A1 - AbstractC21455b.F(32.0f));
            this.H.addView(textPaintView, AbstractC13840gu3.b(-2, -2.0f));
            entityView2 = textPaintView;
        }
        V2(entityView2);
        Y2(entityView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(boolean z) {
        if (z) {
            return;
        }
        this.D0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View N1(int i2) {
        if (i2 == 0) {
            return this.Q0;
        }
        if (i2 == 1) {
            return this.R0;
        }
        return null;
    }

    private int[] P1(View view) {
        view.getLocationInWindow(this.I1);
        float width = view.getWidth() * view.getScaleX() * this.H.getScaleX();
        float height = view.getHeight() * view.getScaleY() * this.H.getScaleY();
        int[] iArr = this.I1;
        iArr[0] = (int) (iArr[0] + (width / 2.0f));
        iArr[1] = (int) (iArr[1] + (height / 2.0f));
        return iArr;
    }

    private C24749z85 Q1(int i2, long j2, C18390oa7 c18390oa7) {
        if (i2 >= 0 && i2 <= 3 && !this.L0.isEmpty()) {
            int size = this.L0.size();
            int iNextInt = Utilities.b.nextInt(size);
            for (int i3 = size; i3 > 0; i3--) {
                C24749z85 c24749z85 = (C24749z85) this.L0.get(iNextInt);
                if (!U1(c24749z85, i2, j2, c18390oa7)) {
                    return c24749z85;
                }
                iNextInt = (iNextInt + 1) % size;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R1(int i2) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, this.q1);
    }

    private void S1(boolean z) {
        if (this.J1) {
            e3(0);
        }
    }

    private void T1() {
        int i2 = this.M1;
        this.M1 = 0;
        if (i2 != 0) {
            this.y1.f();
        }
    }

    private void T2() {
        j3(0);
        postDelayed(new Runnable() { // from class: ir.nasim.wV4
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.r2();
            }
        }, 350L);
        N2(true);
    }

    private boolean U1(C24749z85 c24749z85, int i2, long j2, C18390oa7 c18390oa7) {
        if (c24749z85.b(i2) == null) {
            return true;
        }
        float fC = c24749z85.c(0) * 1.1f;
        for (int i3 = 0; i3 < this.H.getChildCount(); i3++) {
            View childAt = this.H.getChildAt(i3);
            if (childAt instanceof StickerView) {
                StickerView stickerView = (StickerView) childAt;
                if (stickerView.getAnchor() != i2) {
                    continue;
                } else {
                    C22697vg5 position = stickerView.getPosition();
                    float fHypot = (float) Math.hypot(position.a - r14.a, position.b - r14.b);
                    if ((j2 == stickerView.getSticker().c || this.L0.size() > 1) && fHypot < fC) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean V1() {
        int i2 = this.M0;
        return i2 % 360 == 90 || i2 % 360 == 270;
    }

    private void V2(final EntityView entityView) {
        if (entityView == null) {
            return;
        }
        this.o.f(entityView.getUUID(), new Runnable() { // from class: ir.nasim.RU4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s2(entityView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(View view) {
        if (view instanceof EntityView) {
            EntityView entityView = (EntityView) view;
            entityView.d0();
            Y2(entityView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X2, reason: merged with bridge method [inline-methods] */
    public void s2(EntityView entityView) {
        EntityView entityView2 = this.w;
        if (entityView == entityView2 && entityView2 != null) {
            entityView2.H();
            Y2(null);
            if (entityView instanceof TextPaintView) {
                ValueAnimator valueAnimator = this.H0;
                if (valueAnimator != null && this.F0 != 0) {
                    valueAnimator.cancel();
                }
                j3(0);
            }
        }
        this.H.removeView(entityView);
        if (entityView != null) {
            this.o.j(entityView.getUUID());
        }
        this.J0.setValueOverride(this.K0);
        this.J0.setShowPreview(true);
        this.j1.c = this.K0.get();
        a3(this.j1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1() {
        int i2;
        C19026pf2 c19026pf2A = null;
        try {
            try {
                c19026pf2A = new C19026pf2.a(getContext()).c(1).b(1).d(false).a();
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
                if (0 == 0) {
                    return;
                }
            }
            if (!c19026pf2A.c()) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("face detection is not operational");
                }
                c19026pf2A.a();
                return;
            }
            try {
                SparseArray sparseArrayB = c19026pf2A.b(new C7501Rz2.a().b(this.n).c(getFrameRotation()).a());
                ArrayList arrayList = new ArrayList();
                SD6 paintingSize = getPaintingSize();
                for (i2 = 0; i2 < sparseArrayB.size(); i2++) {
                    C24749z85 c24749z85 = new C24749z85((C18435of2) sparseArrayB.get(sparseArrayB.keyAt(i2)), this.n, paintingSize, V1());
                    if (c24749z85.d()) {
                        arrayList.add(c24749z85);
                    }
                }
                this.L0 = arrayList;
                c19026pf2A.a();
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
                c19026pf2A.a();
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                c19026pf2A.a();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y2(EntityView entityView) {
        return Z2(entityView, true);
    }

    private boolean Z2(EntityView entityView, boolean z) {
        boolean z2;
        int i2;
        boolean z3 = entityView instanceof TextPaintView;
        boolean z4 = true;
        if (z3 && (((i2 = this.F0) == -1 && this.E0 != 1) || (i2 != -1 && i2 != 1))) {
            ValueAnimator valueAnimator = this.H0;
            if (valueAnimator != null && i2 != 1) {
                valueAnimator.cancel();
            }
            if (this.l1) {
                d3(false);
            }
            j3(1);
        }
        if (z3 && z) {
            TextPaintView textPaintView = (TextPaintView) entityView;
            int gravity = textPaintView.getEditText().getGravity();
            this.R0.setAlignment(gravity != 17 ? gravity != 21 ? 0 : 2 : 1);
            LU4 typeface = textPaintView.getTypeface();
            if (typeface != null) {
                this.R0.setTypeface(typeface.o());
            }
            this.R0.setOutlineType(textPaintView.getType(), true);
            this.A0.invalidate();
        }
        EntityView entityView2 = this.w;
        if (entityView2 == null) {
            z2 = false;
        } else {
            if (entityView2 == entityView) {
                if (this.x) {
                    if (entityView2 instanceof TextPaintView) {
                        AbstractC21455b.C1(((TextPaintView) entityView2).getFocusedView());
                        S1(false);
                    }
                } else if (z3) {
                    this.z = true;
                    M1();
                } else {
                    f3(entityView2);
                }
                return true;
            }
            entityView2.H();
            EntityView entityView3 = this.w;
            if (entityView3 instanceof TextPaintView) {
                ((TextPaintView) entityView3).k0();
                if (!z3) {
                    this.x = false;
                    AbstractC21455b.t0(((TextPaintView) this.w).getFocusedView());
                    S1(false);
                }
            }
            z2 = true;
        }
        EntityView entityView4 = this.w;
        this.w = entityView;
        if ((entityView4 instanceof TextPaintView) && TextUtils.isEmpty(((TextPaintView) entityView4).getText())) {
            s2(entityView4);
        }
        EntityView entityView5 = this.w;
        if (entityView5 != null) {
            entityView5.a0(this.G);
            this.H.bringChildToFront(this.w);
            EntityView entityView6 = this.w;
            if (entityView6 instanceof TextPaintView) {
                TextPaintView textPaintView2 = (TextPaintView) entityView6;
                textPaintView2.getSwatch().c = this.j1.c;
                a3(textPaintView2.getSwatch(), true);
                this.J0.setValueOverride(new e(textPaintView2, (int) (this.v.a / 9.0f)));
                this.J0.setShowPreview(false);
            } else {
                this.J0.setValueOverride(this.K0);
                this.J0.setShowPreview(true);
                this.j1.c = this.K0.get();
                a3(this.j1, true);
            }
        } else {
            ValueAnimator valueAnimator2 = this.H0;
            if (valueAnimator2 != null && this.F0 != 0) {
                valueAnimator2.cancel();
            }
            if (this.l1) {
                d3(false);
            }
            j3(0);
            this.J0.setValueOverride(this.K0);
            this.J0.setShowPreview(true);
            this.j1.c = this.K0.get();
            a3(this.j1, true);
            z4 = z2;
        }
        m3();
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2() {
        boolean zB = this.o.b();
        this.T0.animate().cancel();
        this.T0.animate().alpha(zB ? 1.0f : 0.6f).translationY(0.0f).setDuration(150L).start();
        this.T0.setClickable(zB);
        this.X0.animate().cancel();
        this.X0.animate().alpha(zB ? 1.0f : 0.6f).translationY(0.0f).setDuration(150L).start();
        this.X0.setClickable(zB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(G37 g37, boolean z) {
        FrameLayout frameLayout;
        G37 g372 = this.j1;
        if (g372 != g37) {
            g372.a = g37.a;
            g372.b = g37.b;
            g372.c = g37.c;
            T45.h(this.p1).l(g37.a);
            T45.h(this.p1).r(g37.c);
        }
        this.B.setColor(g37.a);
        this.B.setBrushSize(g37.c);
        if (z && (frameLayout = this.z0) != null) {
            frameLayout.invalidate();
        }
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setSwatch(new G37(g37.a, g37.b, g37.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(View view) {
        RenderView renderView = this.B;
        if (renderView == null || !(renderView.getCurrentBrush() instanceof a.g)) {
            this.o.i();
            return;
        }
        this.B.t();
        this.Q0.setSelectedIndex(1);
        A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
    }

    private void b3(TextPaintView textPaintView, int i2) {
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
    public /* synthetic */ void c2(int i2, Integer num) {
        T45.h(i2).l(num.intValue());
        T45.h(i2).k();
        setNewColor(num.intValue());
        this.f1.getAdapter().notifyDataSetChanged();
        this.C1 = null;
    }

    private void c3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        R62.c[] cVarArr;
        PhotoView photoView;
        ArrayList arrayList = this.z1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                H.b bVar = (H.b) this.z1.get(i2);
                byte b2 = bVar.a;
                if (b2 == 0) {
                    StickerView stickerViewG1 = G1(bVar.w, bVar.v, false);
                    if ((2 & bVar.b) != 0) {
                        stickerViewG1.j0();
                    }
                    ViewGroup.LayoutParams layoutParams = stickerViewG1.getLayoutParams();
                    layoutParams.width = bVar.n;
                    layoutParams.height = bVar.o;
                    photoView = stickerViewG1;
                } else if (b2 == 1) {
                    TextPaintView textPaintViewH1 = H1(false);
                    textPaintViewH1.setType(bVar.b);
                    textPaintViewH1.setTypeface(bVar.l);
                    textPaintViewH1.setBaseFontSize(bVar.k);
                    SpannableString spannableString = new SpannableString(bVar.h);
                    Iterator it = bVar.i.iterator();
                    while (it.hasNext()) {
                        H.a aVar = (H.a) it.next();
                        AnimatedEmojiSpan animatedEmojiSpan = new AnimatedEmojiSpan(aVar.f, 1.0f, textPaintViewH1.getFontMetricsInt());
                        int i3 = aVar.b;
                        spannableString.setSpan(animatedEmojiSpan, i3, aVar.c + i3, 33);
                    }
                    CharSequence charSequenceS = R62.S(spannableString, textPaintViewH1.getFontMetricsInt(), (int) (textPaintViewH1.getFontSize() * 0.8f), false);
                    if ((charSequenceS instanceof Spanned) && (cVarArr = (R62.c[]) ((Spanned) charSequenceS).getSpans(0, charSequenceS.length(), R62.c.class)) != null) {
                        for (R62.c cVar : cVarArr) {
                            cVar.d(0.85f);
                        }
                    }
                    textPaintViewH1.setText(charSequenceS);
                    b3(textPaintViewH1, bVar.m);
                    G37 swatch = textPaintViewH1.getSwatch();
                    swatch.a = bVar.j;
                    textPaintViewH1.setSwatch(swatch);
                    photoView = textPaintViewH1;
                } else if (b2 == 2) {
                    PhotoView photoViewF1 = F1(bVar.h, false);
                    if ((2 & bVar.b) != 0) {
                        photoViewF1.g0();
                    }
                    ViewGroup.LayoutParams layoutParams2 = photoViewF1.getLayoutParams();
                    layoutParams2.width = bVar.n;
                    layoutParams2.height = bVar.o;
                    photoView = photoViewF1;
                }
                photoView.setX((bVar.c * this.A1) - ((bVar.n * (1.0f - bVar.q)) / 2.0f));
                photoView.setY((bVar.d * this.B1) - ((bVar.o * (1.0f - bVar.q)) / 2.0f));
                photoView.setPosition(new C22697vg5(photoView.getX() + (bVar.n / 2.0f), photoView.getY() + (bVar.o / 2.0f)));
                photoView.setScaleX(bVar.q);
                photoView.setScaleY(bVar.q);
                photoView.setRotation((float) (((-bVar.e) / 3.141592653589793d) * 180.0d));
            }
            this.z1 = null;
            this.H.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(Context context, Bitmap bitmap, final int i2, View view) {
        if (this.l1) {
            PX0 px0 = new PX0(context, this.q1);
            this.C1 = px0;
            px0.T0(this.j1.a).V0(new c(bitmap, i2)).U0(new InterfaceC25043ze1() { // from class: ir.nasim.rV4
                @Override // ir.nasim.InterfaceC25043ze1
                public final void accept(Object obj) {
                    this.a.c2(i2, (Integer) obj);
                }
            }).show();
        } else {
            Runnable runnable = this.u1;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(final boolean z) {
        if (this.l1 != z) {
            this.l1 = z;
            C16463lJ6 c16463lJ6 = this.m1;
            if (c16463lJ6 != null) {
                c16463lJ6.d();
            }
            C16463lJ6 c16463lJ62 = new C16463lJ6(new C19136pq2(z ? 0.0f : 1000.0f));
            this.m1 = c16463lJ62;
            c16463lJ62.A(new C17645nJ6().e(z ? 1000.0f : 0.0f).f(1250.0f).d(1.0f));
            final boolean[] zArr = {this.y1.i() || this.M1 > 0};
            final float translationY = this.z0.getTranslationY();
            final float alpha = this.k.getAlpha();
            final ViewGroup barView = getBarView();
            this.m1.c(new AbstractC12098e22.r() { // from class: ir.nasim.yV4
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
                    this.a.w2(barView, z, zArr, alpha, translationY, abstractC12098e22, f2, f3);
                }
            });
            this.m1.b(new AbstractC12098e22.q() { // from class: ir.nasim.zV4
                @Override // ir.nasim.AbstractC12098e22.q
                public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
                    this.a.x2(z, abstractC12098e22, z2, f2, f3);
                }
            });
            this.m1.s();
            if (z) {
                this.f1.setVisibility(0);
                this.f1.setSelectedColorIndex(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(int i2) {
        a3(this.j1, true);
        T45.h(i2).r(this.j1.c);
    }

    private void e3(int i2) {
        k3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void f2(ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.WindowView r11, java.lang.Integer r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.PaintView.f2(ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder$WindowView, java.lang.Integer):void");
    }

    private void f3(final EntityView entityView) {
        int[] iArrP1 = P1(entityView);
        g3(new Runnable() { // from class: ir.nasim.AV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D2(entityView);
            }
        }, this, 51, iArrP1[0], iArrP1[1] - AbstractC21455b.F(32.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(View view) {
        PhotoViewer.k8().Tb();
    }

    private void g3(Runnable runnable, View view, int i2, int i3, int i4) {
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.r1.dismiss();
            return;
        }
        if (this.s1 == null) {
            this.t1 = new Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext(), this.q1);
            this.s1 = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setAnimationEnabled(true);
            this.s1.setBackgroundColor(-14145495);
            this.s1.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.OU4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.a.E2(view2, motionEvent);
                }
            });
            this.s1.setDispatchKeyEventListener(new ActionBarPopupWindow.d() { // from class: ir.nasim.PU4
                @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.d
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.a.F2(keyEvent);
                }
            });
            this.s1.setShownFromBottom(true);
        }
        this.s1.n();
        runnable.run();
        if (this.r1 == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.s1, -2, -2);
            this.r1 = actionBarPopupWindow2;
            actionBarPopupWindow2.r(true);
            this.r1.setAnimationStyle(AbstractC16417lE5.PopupAnimation);
            this.r1.setOutsideTouchable(true);
            this.r1.setClippingEnabled(true);
            this.r1.setInputMethodMode(2);
            this.r1.setSoftInputMode(0);
            this.r1.getContentView().setFocusableInTouchMode(true);
            this.r1.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.QU4
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.a.G2();
                }
            });
        }
        this.s1.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(1000.0f), RecyclerView.UNDEFINED_DURATION));
        this.r1.setFocusable(true);
        if ((i2 & 48) != 0) {
            i3 -= this.s1.getMeasuredWidth() / 2;
            i4 -= this.s1.getMeasuredHeight();
        }
        this.r1.showAtLocation(view, i2, i3, i4);
        ActionBarPopupWindow.t(this.s1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getBarView() {
        return this.E0 == 1 ? this.R0 : this.Q0;
    }

    private int getFrameRotation() {
        int i2 = this.M0;
        if (i2 == 90) {
            return 1;
        }
        if (i2 != 180) {
            return i2 != 270 ? 0 : 3;
        }
        return 2;
    }

    private SD6 getPaintingSize() {
        SD6 sd6 = this.v;
        if (sd6 != null) {
            return sd6;
        }
        SD6 sd62 = new SD6(1080.0f, 1920.0f);
        this.v = sd62;
        return sd62;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(View view) {
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(final boolean z) {
        if (this.d1 != z) {
            this.d1 = z;
            C16463lJ6 c16463lJ6 = this.e1;
            if (c16463lJ6 != null) {
                c16463lJ6.d();
            }
            C16463lJ6 c16463lJ62 = new C16463lJ6(new C19136pq2(z ? 0.0f : 1000.0f));
            this.e1 = c16463lJ62;
            c16463lJ62.A(new C17645nJ6().e(z ? 1000.0f : 0.0f).f(1250.0f).d(1.0f));
            if (z) {
                this.S0.setAlpha(0.0f);
                this.S0.setVisibility(0);
            }
            this.e1.c(new AbstractC12098e22.r() { // from class: ir.nasim.YU4
                @Override // ir.nasim.AbstractC12098e22.r
                public final void a(AbstractC12098e22 abstractC12098e22, float f2, float f3) {
                    this.a.H2(abstractC12098e22, f2, f3);
                }
            });
            this.e1.b(new AbstractC12098e22.q() { // from class: ir.nasim.ZU4
                @Override // ir.nasim.AbstractC12098e22.q
                public final void a(AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
                    this.a.I2(z, abstractC12098e22, z2, f2, f3);
                }
            });
            this.e1.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(View view) {
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            AbstractC21455b.t0(((TextPaintView) entityView).getFocusedView());
        }
        if (this.J1) {
            S1(false);
        }
        s2(this.w);
        Y2(null);
    }

    private C22697vg5 i3(EntityView entityView) {
        MediaController.i iVar = this.q;
        float height = iVar != null ? 200.0f / iVar.c : 200.0f;
        if (entityView != null) {
            C22697vg5 position = entityView.getPosition();
            return new C22697vg5(position.a, position.b + entityView.getHeight());
        }
        float f2 = iVar != null ? 100.0f / iVar.c : 100.0f;
        C22697vg5 c22697vg5C1 = C1();
        while (true) {
            boolean z = false;
            for (int i2 = 0; i2 < this.H.getChildCount(); i2++) {
                View childAt = this.H.getChildAt(i2);
                if (childAt instanceof EntityView) {
                    C22697vg5 position2 = ((EntityView) childAt).getPosition();
                    if (((float) Math.sqrt(Math.pow(position2.a - c22697vg5C1.a, 2.0d) + Math.pow(position2.b - c22697vg5C1.b, 2.0d))) < f2) {
                        height = childAt.getHeight();
                        z = true;
                    }
                }
            }
            if (!z) {
                return c22697vg5C1;
            }
            c22697vg5C1 = new C22697vg5(c22697vg5C1.a, c22697vg5C1.b + height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(View view) {
        Y2(null);
    }

    private void j3(int i2) {
        if (this.E0 == i2 || this.F0 == i2) {
            return;
        }
        ValueAnimator valueAnimator = this.H0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final View viewN1 = N1(this.E0);
        this.F0 = i2;
        final View viewN12 = N1(i2);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.H0 = duration;
        duration.setInterpolator(InterpolatorC12631ew1.f);
        this.H0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.BV4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.K2(viewN1, viewN12, valueAnimator2);
            }
        });
        this.H0.addListener(new g(viewN1, viewN12, i2));
        this.H0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(int i2) {
        this.R0.setTypeface(T45.h(i2).e());
    }

    private void k3() {
        PaintTextOptionsView paintTextOptionsView = this.R0;
        if (paintTextOptionsView != null) {
            paintTextOptionsView.f(AbstractC23598xB5.msg_add);
        }
        boolean z = this.y1.i() || this.J1;
        AbstractC21455b.I1(this.X0, !z, false, 1.0f, true, null);
        AbstractC21455b.I1(this.T0, !z, false, 1.0f, true, null);
        boolean z2 = z;
        AbstractC21455b.I1(this.Z0, z2, false, 1.0f, true, null);
        AbstractC21455b.I1(this.Y0, z2, false, 1.0f, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view, int i2) {
        LU4 lu4 = (LU4) LU4.n().get(i2);
        this.R0.setTypeface(lu4.o());
        Q2(lu4);
        h3(false);
    }

    private void l3() {
        EntityView entityView;
        ObjectAnimator objectAnimator = this.D1;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = (View) this.B.getParent();
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, (((!this.y1.i() || this.y1.c) && this.M1 <= 0) || (entityView = this.w) == null) ? 0.0f : (-(entityView.getPosition().b - (view.getMeasuredHeight() * 0.3f))) * view.getScaleY());
        this.D1 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(350L);
        this.D1.setInterpolator(InterpolatorC12631ew1.h);
        this.D1.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(Integer num) {
        setNewColor(num.intValue());
        d3(false);
    }

    private void m3() {
        final boolean z = (this.w instanceof TextPaintView) && (this.y1.i() || this.M1 > 0) && !this.y1.c;
        this.D0.animate().cancel();
        this.D0.setVisibility(0);
        this.D0.animate().alpha(z ? 1.0f : 0.0f).withEndAction(new Runnable() { // from class: ir.nasim.xV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.L2(z);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(View view) {
        if (this.l1) {
            d3(false);
            return;
        }
        if (this.J1) {
            S1(true);
            return;
        }
        if (this.x) {
            Y2(null);
            return;
        }
        Runnable runnable = this.v1;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(a.g gVar, int i2) {
        if (this.B.getCurrentBrush() instanceof a.g) {
            this.I0 = true;
        }
        A(gVar);
        this.Q0.l(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean p2(View view) {
        if (this.s1 != null) {
            T45.h(this.p1).t();
            boolean zG = T45.h(this.p1).g();
            for (int i2 = 0; i2 < this.s1.getItemsCount(); i2++) {
                View viewL = this.s1.l(i2);
                if (viewL instanceof PopupButton) {
                    a.g gVar = (a.g) a.g.b.get(i2);
                    ((PopupButton) viewL).setIcon(zG ? gVar.n() : gVar.d(), zG, true);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2() {
        boolean zG = T45.h(this.p1).g();
        for (int i2 = 0; i2 < a.g.b.size(); i2++) {
            final a.g gVar = (a.g) a.g.b.get(i2);
            final int iN = zG ? gVar.n() : gVar.d();
            PopupButton popupButtonA1 = A1(gVar.o(), iN, false, new Runnable() { // from class: ir.nasim.sV4
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.o2(gVar, iN);
                }
            });
            popupButtonA1.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.uV4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.a.p2(view);
                }
            });
            this.s1.j(popupButtonA1, AbstractC13840gu3.g(-2, 48));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2() throws InterruptedException {
        if (this.n != null) {
            I1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewColor(final int i2) {
        G37 g37 = this.j1;
        final int i3 = g37.a;
        g37.a = i2;
        a3(g37, true);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tV4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.t2(i3, i2, valueAnimator);
            }
        });
        duration.start();
    }

    private void setTextType(int i2) {
        this.y = i2;
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setType(i2);
        }
        T45.h(this.p1).p(i2);
        this.R0.setOutlineType(i2, true);
    }

    private void setupTabsLayout(Context context) {
        f fVar = new f(context);
        this.C0 = fVar;
        fVar.setClipToPadding(false);
        this.C0.setOrientation(0);
        this.z0.addView(this.C0, AbstractC13840gu3.c(-1, 40.0f, 80, 52.0f, 0.0f, 52.0f, 0.0f));
        TextView textView = new TextView(context);
        this.O0 = textView;
        textView.setText(FH3.C(TD5.tgwidget_PhotoEditorDraw).toUpperCase());
        TextView textView2 = this.O0;
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4;
        textView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(R1(i2), 7));
        this.O0.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.O0.setTextColor(-1);
        this.O0.setTextSize(1, 14.0f);
        this.O0.setGravity(1);
        this.O0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.O0.setSingleLine();
        this.O0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.XU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u2(view);
            }
        });
        this.C0.addView(this.O0, AbstractC13840gu3.h(0, -2, 1.0f));
        TextView textView3 = new TextView(context);
        this.P0 = textView3;
        textView3.setText(FH3.C(TD5.tgwidget_PhotoEditorText).toUpperCase());
        this.P0.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(R1(i2), 7));
        this.P0.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.P0.setTextColor(-1);
        this.P0.setTextSize(1, 14.0f);
        this.P0.setGravity(1);
        this.P0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.P0.setAlpha(0.6f);
        this.P0.setSingleLine();
        this.P0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iV4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v2(view);
            }
        });
        this.C0.addView(this.P0, AbstractC13840gu3.h(0, -2, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(int i2, int i3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.j1.a = QY0.c(i2, i3, fFloatValue);
        this.z0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(View view) {
        if (this.x) {
            Y2(null);
        } else {
            j3(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(View view) {
        j3(1);
        if (this.w instanceof TextPaintView) {
            return;
        }
        this.F1 = true;
        H1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view, boolean z, boolean[] zArr, float f2, float f3, AbstractC12098e22 abstractC12098e22, float f4, float f5) {
        float f6 = f4 / 1000.0f;
        this.n1 = f6;
        float f7 = ((1.0f - f6) * 0.4f) + 0.6f;
        view.setScaleX(f7);
        view.setScaleY(f7);
        view.setTranslationY((AbstractC21455b.F(16.0f) * Math.min(this.n1, 0.25f)) / 0.25f);
        view.setAlpha(1.0f - (Math.min(this.n1, 0.25f) / 0.25f));
        this.f1.setProgress(this.n1, z);
        this.k.setProgress(this.n1);
        this.j.setProgress(this.n1);
        this.C0.setTranslationY(AbstractC21455b.F(32.0f) * this.n1);
        AnimatorSet animatorSet = this.x1;
        if (animatorSet != null && animatorSet.isRunning()) {
            zArr[0] = false;
        }
        if (zArr[0]) {
            float f8 = this.n1;
            if (!z) {
                f8 = 1.0f - f8;
            }
            this.k.setAlpha(AbstractC21455b.T0(f2, z ? 1.0f : 0.0f, f8));
            this.j.setAlpha(AbstractC21455b.T0(f2, z ? 1.0f : 0.0f, f8));
            this.z0.setTranslationY(f3 - ((AbstractC21455b.F(39.0f) * f8) * (z ? 1 : -1)));
        }
        this.z0.invalidate();
        if (view == this.R0) {
            this.A0.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(boolean z, AbstractC12098e22 abstractC12098e22, boolean z2, float f2, float f3) {
        if (abstractC12098e22 == this.m1) {
            this.m1 = null;
            if (z) {
                return;
            }
            this.f1.setVisibility(8);
            T45.h(this.p1).k();
            this.f1.getAdapter().notifyDataSetChanged();
        }
    }

    private SD6 y1(String str) {
        float f2;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            f2 = options.outWidth / options.outHeight;
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            f2 = 1.0f;
        }
        if (f2 > 1.0f) {
            float fFloor = (float) Math.floor(Math.max(this.A1, this.H.getMeasuredWidth()) * 0.5d);
            return new SD6(fFloor, fFloor / f2);
        }
        float fFloor2 = (float) Math.floor(Math.max(this.B1, this.H.getMeasuredHeight()) * 0.5d);
        return new SD6(f2 * fFloor2, fFloor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(EntityView entityView, View view) {
        s2(entityView);
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.r1.k(true);
    }

    private SD6 z1() {
        float fFloor = (float) Math.floor(getPaintingSize().a * 0.5d);
        return new SD6(fFloor, fFloor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(EntityView entityView, View view) {
        try {
            ((TextPaintView) entityView).getEditText().onTextContextMenuItem(R.id.pasteAsPlainText);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        ActionBarPopupWindow actionBarPopupWindow = this.r1;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.r1.k(true);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public void A(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
        if ((aVar instanceof a.b) || (aVar instanceof a.d)) {
            this.J0.setMinMax(0.4f, 1.75f);
        } else {
            this.J0.setMinMax(0.05f, 1.0f);
        }
        this.J0.setDrawCenter(!(aVar instanceof a.g));
        if (this.B.getCurrentBrush() instanceof a.g) {
            this.I0 = true;
        }
        this.B.setBrush(aVar);
        this.j1.c = this.K0.get();
        a3(this.j1, true);
        this.D.invalidate();
    }

    @Override // ir.nasim.YZ2
    public void B() {
        this.o1.setColor(-15132391);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void C() {
        h3(true);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean D(EntityView entityView) {
        f3(entityView);
        return true;
    }

    public void D1() {
        if (this.o.b()) {
            RenderView renderView = this.B;
            if (renderView != null && (renderView.getCurrentBrush() instanceof a.g)) {
                this.B.t();
                this.Q0.setSelectedIndex(1);
                A((ir.nasim.tgwidgets.editor.ui.Components.Paint.a) ir.nasim.tgwidgets.editor.ui.Components.Paint.a.a.get(0));
            }
            RenderView renderView2 = this.B;
            if (renderView2 != null) {
                renderView2.s();
            }
            this.o.g();
            this.H.removeAllViews();
        }
    }

    public void E1() {
        Y2(null);
    }

    public PhotoView F1(String str, boolean z) {
        SD6 sd6Y1 = y1(str);
        Pair pairB0 = AbstractC21455b.b0(str);
        if ((((Integer) pairB0.first).intValue() / 90) % 2 == 1) {
            float f2 = sd6Y1.a;
            sd6Y1.a = sd6Y1.b;
            sd6Y1.b = f2;
        }
        PhotoView photoView = new PhotoView(getContext(), C1(), 0.0f, 1.0f, sd6Y1, str, ((Integer) pairB0.first).intValue(), ((Integer) pairB0.second).intValue());
        photoView.J0.d1(12);
        photoView.setDelegate(this);
        this.H.addView(photoView);
        if (z) {
            V2(photoView);
            Y2(photoView);
        }
        return photoView;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto
    public int G() {
        return this.y1.g() - this.w1.P(false);
    }

    protected void J1(RLottieDrawable rLottieDrawable) {
    }

    protected void K1() {
    }

    protected void M1() {
        EntityView entityView = this.w;
        if (!(entityView instanceof TextPaintView) || this.x) {
            return;
        }
        TextPaintView textPaintView = (TextPaintView) entityView;
        this.x = true;
        textPaintView.i0();
        View focusedView = textPaintView.getFocusedView();
        focusedView.requestFocus();
        AbstractC21455b.C1(focusedView);
    }

    public void M2() {
        if (this.J1 && (this.w instanceof TextPaintView)) {
            this.y1.e();
            AbstractC21455b.C1(((TextPaintView) this.w).getEditText());
        }
        e3(!this.J1 ? 1 : 0);
    }

    protected void N2(boolean z) {
    }

    public Bitmap O1(ArrayList arrayList, int i2, int i3, boolean z, boolean z2) {
        Bitmap bitmap;
        int i4;
        int i5;
        View view;
        int i6;
        View view2;
        Bitmap bitmap2;
        int i7;
        Bitmap resultBitmap = z ? this.B.getResultBitmap() : null;
        this.N0 = BigInteger.ONE;
        if ((resultBitmap != null || !z2) && this.H.d() > 0) {
            int childCount = this.H.getChildCount();
            int i8 = 0;
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = this.H.getChildAt(i9);
                if (childAt instanceof EntityView) {
                    EntityView entityView = (EntityView) childAt;
                    entityView.getPosition();
                    H.b bVar = new H.b();
                    if (arrayList != null) {
                        if (entityView instanceof TextPaintView) {
                            bVar.a = (byte) 1;
                            TextPaintView textPaintView = (TextPaintView) entityView;
                            CharSequence text = textPaintView.getText();
                            if (text instanceof Spanned) {
                                Spanned spanned = (Spanned) text;
                                AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spanned.getSpans(i8, text.length(), AnimatedEmojiSpan.class);
                                if (animatedEmojiSpanArr != null) {
                                    int i10 = i8;
                                    while (i10 < animatedEmojiSpanArr.length) {
                                        AnimatedEmojiSpan animatedEmojiSpan = animatedEmojiSpanArr[i10];
                                        AbstractC18106o57 abstractC18106o57H = animatedEmojiSpan.b;
                                        if (abstractC18106o57H == null) {
                                            bitmap2 = resultBitmap;
                                            i7 = childCount;
                                            abstractC18106o57H = C21463b.h(this.p1, animatedEmojiSpan.g());
                                        } else {
                                            bitmap2 = resultBitmap;
                                            i7 = childCount;
                                        }
                                        if (abstractC18106o57H != null) {
                                            C21463b.k(this.p1).r(abstractC18106o57H);
                                        }
                                        H.a aVar = new H.a();
                                        int i11 = i9;
                                        View view3 = childAt;
                                        aVar.f = animatedEmojiSpan.g();
                                        aVar.g = abstractC18106o57H;
                                        aVar.b = spanned.getSpanStart(animatedEmojiSpan);
                                        aVar.c = spanned.getSpanEnd(animatedEmojiSpan) - aVar.b;
                                        aVar.i = C4278El2.H(this.p1).Q(abstractC18106o57H, true).getAbsolutePath();
                                        int i12 = 0;
                                        while (abstractC18106o57H != null) {
                                            ArrayList arrayList2 = abstractC18106o57H.k;
                                            if (arrayList2 == null || arrayList2.isEmpty() || new File(aVar.i).exists()) {
                                                break;
                                            }
                                            aVar.i = C4278El2.H(this.p1).Q((AbstractC12724f57) abstractC18106o57H.k.get(i12), true).getAbsolutePath();
                                            i12++;
                                            if (i12 >= abstractC18106o57H.k.size()) {
                                                break;
                                            }
                                        }
                                        boolean zM0 = C10743c74.m0(aVar.g, true);
                                        if (zM0 || C10743c74.h1(aVar.g)) {
                                            aVar.k = (byte) ((zM0 ? (byte) 1 : (byte) 4) | aVar.k);
                                        }
                                        if (C10743c74.b1(aVar.g)) {
                                            aVar.k = (byte) (aVar.k | 8);
                                        }
                                        bVar.i.add(aVar);
                                        if (abstractC18106o57H != null) {
                                            BigInteger bigIntegerValueOf = BigInteger.valueOf(5000L);
                                            this.N0 = this.N0.multiply(bigIntegerValueOf).divide(this.N0.gcd(bigIntegerValueOf));
                                        }
                                        i10++;
                                        i9 = i11;
                                        resultBitmap = bitmap2;
                                        childCount = i7;
                                        childAt = view3;
                                    }
                                }
                            }
                            bitmap = resultBitmap;
                            i4 = childCount;
                            i5 = i9;
                            view = childAt;
                            bVar.h = text.toString();
                            bVar.b = (byte) textPaintView.getType();
                            bVar.j = textPaintView.getSwatch().a;
                            bVar.k = textPaintView.getTextSize();
                            bVar.l = textPaintView.getTypeface();
                            bVar.m = textPaintView.getAlign();
                        } else {
                            bitmap = resultBitmap;
                            i4 = childCount;
                            i5 = i9;
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
                                bVar.h = C4278El2.H(C22477vI7.f).Q(sticker, true).getAbsolutePath();
                                if (C10743c74.m0(sticker, true) || C10743c74.h1(sticker)) {
                                    boolean zM02 = C10743c74.m0(sticker, true);
                                    bVar.b = (byte) (bVar.b | (zM02 ? (byte) 1 : (byte) 4));
                                    long duration = zM02 ? stickerView.getDuration() : 5000L;
                                    if (duration != 0) {
                                        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(duration);
                                        this.N0 = this.N0.multiply(bigIntegerValueOf2).divide(this.N0.gcd(bigIntegerValueOf2));
                                    }
                                }
                                if (C10743c74.b1(sticker)) {
                                    bVar.j = -1;
                                    bVar.b = (byte) (bVar.b | 8);
                                }
                                if (stickerView.h0()) {
                                    bVar.b = (byte) (bVar.b | 2);
                                }
                            } else {
                                if (entityView instanceof PhotoView) {
                                    PhotoView photoView = (PhotoView) entityView;
                                    bVar.a = (byte) 2;
                                    SD6 baseSize2 = photoView.getBaseSize();
                                    bVar.f = baseSize2.a;
                                    bVar.g = baseSize2.b;
                                    bVar.h = photoView.getPath();
                                    if (photoView.f0()) {
                                        bVar.b = (byte) (bVar.b | 2);
                                    }
                                }
                                resultBitmap = bitmap;
                                i6 = 0;
                            }
                        }
                        arrayList.add(bVar);
                        float scaleX = view.getScaleX();
                        float scaleY = view.getScaleY();
                        float x = view.getX();
                        float y = view.getY();
                        bVar.n = view.getWidth();
                        bVar.o = view.getHeight();
                        bVar.f = (view.getWidth() * scaleX) / this.H.getMeasuredWidth();
                        bVar.g = (view.getHeight() * scaleY) / this.H.getMeasuredHeight();
                        bVar.c = (((view.getWidth() * (1.0f - scaleX)) / 2.0f) + x) / this.H.getMeasuredWidth();
                        bVar.d = (((view.getHeight() * (1.0f - scaleY)) / 2.0f) + y) / this.H.getMeasuredHeight();
                        bVar.e = (float) ((-view.getRotation()) * 0.017453292519943295d);
                        bVar.t = (x + (view.getWidth() / 2.0f)) / this.H.getMeasuredWidth();
                        bVar.u = (y + (view.getHeight() / 2.0f)) / this.H.getMeasuredHeight();
                        bVar.r = bVar.n / this.H.getMeasuredWidth();
                        bVar.s = bVar.o / this.H.getMeasuredHeight();
                        bVar.q = scaleX;
                        if (entityView instanceof StickerView) {
                            float fY = ((StickerView) entityView).K0.y();
                            float f2 = bVar.c + (bVar.f / 2.0f);
                            float f3 = bVar.d + (bVar.g / 2.0f);
                            float measuredWidth = this.H.getMeasuredWidth() / this.H.getMeasuredHeight();
                            if (fY > 1.0f) {
                                float f4 = (bVar.f * measuredWidth) / fY;
                                bVar.g = f4;
                                bVar.o = (int) (bVar.n / fY);
                                bVar.d = f3 - (f4 / 2.0f);
                            } else if (fY < 1.0f) {
                                float f5 = (bVar.g / measuredWidth) * fY;
                                bVar.f = f5;
                                bVar.n = (int) (bVar.o * fY);
                                bVar.c = f2 - (f5 / 2.0f);
                            }
                        }
                    } else {
                        bitmap = resultBitmap;
                        i4 = childCount;
                        i5 = i9;
                        view = childAt;
                    }
                    if (!z2 || bitmap == null) {
                        resultBitmap = bitmap;
                    } else {
                        resultBitmap = bitmap;
                        Canvas canvas = new Canvas(resultBitmap);
                        float width = resultBitmap.getWidth() / this.H.getMeasuredWidth();
                        int i13 = 0;
                        while (i13 < 2) {
                            Canvas canvas2 = i13 == 0 ? canvas : null;
                            if (canvas2 != null) {
                                canvas2.save();
                                canvas2.scale(width, width);
                                canvas2.translate(bVar.c * this.H.getMeasuredWidth(), bVar.d * this.H.getMeasuredHeight());
                                canvas2.scale(view.getScaleX(), view.getScaleY());
                                canvas2.rotate(view.getRotation(), ((bVar.f / 2.0f) / view.getScaleX()) * this.H.getMeasuredWidth(), ((bVar.g / 2.0f) / view.getScaleY()) * this.H.getMeasuredHeight());
                                view2 = view;
                                if (!(view2 instanceof TextPaintView) || view2.getHeight() <= 0 || view2.getWidth() <= 0) {
                                    view2.draw(canvas2);
                                } else {
                                    Bitmap bitmapA = AbstractC21456c.a(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                                    Canvas canvas3 = new Canvas(bitmapA);
                                    view2.draw(canvas3);
                                    canvas2.drawBitmap(bitmapA, (Rect) null, new Rect(0, 0, bitmapA.getWidth(), bitmapA.getHeight()), (Paint) null);
                                    try {
                                        canvas3.setBitmap(null);
                                    } catch (Exception e2) {
                                        AbstractC6403Nl2.d(e2);
                                    }
                                    bitmapA.recycle();
                                }
                                canvas2.restore();
                            } else {
                                view2 = view;
                            }
                            i13++;
                            view = view2;
                        }
                    }
                    i6 = 0;
                } else {
                    i4 = childCount;
                    i6 = i8;
                    i5 = i9;
                }
                i9 = i5 + 1;
                i8 = i6;
                childCount = i4;
            }
        }
        return resultBitmap;
    }

    public void O2() {
        this.B.D();
    }

    protected void P2() {
    }

    public void Q2(LU4 lu4) {
        T45.h(this.p1).q(lu4.o());
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setTypeface(lu4);
        }
    }

    public void R2() {
        j3(0);
        E1();
    }

    public void S2() {
        j3(0);
        T2();
    }

    public void U2() {
        j3(1);
        this.F1 = true;
        H1(true);
    }

    public void W2() {
        EntityView entityView = this.w;
        if (entityView != null) {
            s2(entityView);
        }
    }

    @Override // ir.nasim.YZ2
    public boolean a() {
        if (this.l1) {
            d3(false);
            return true;
        }
        if (this.J1) {
            S1(true);
            return true;
        }
        if (!this.x) {
            return false;
        }
        if (!this.z) {
            Y2(null);
            return true;
        }
        this.z = false;
        this.y1.h(true);
        return false;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b, ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void b() {
        d3(true);
    }

    @Override // ir.nasim.YZ2
    public boolean c(MotionEvent motionEvent) {
        if (this.w != null) {
            Y2(null);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setLocation(x, y);
        this.B.B(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean d(EntityView entityView) {
        return !this.x;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        if ((view == this.B || view == this.D || view == this.H || view == this.G) && this.q != null) {
            canvas.save();
            i = this.A ? 0 : AbstractC21455b.d;
            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            MediaController.i iVar = this.q;
            int i2 = iVar.i;
            if (i2 == 90 || i2 == 270) {
                measuredHeight = measuredWidth;
                measuredWidth = measuredHeight;
            }
            float scaleX = measuredWidth * iVar.e * view.getScaleX();
            MediaController.i iVar2 = this.q;
            int i3 = (int) (scaleX / iVar2.c);
            int scaleY = (int) (((measuredHeight * iVar2.f) * view.getScaleY()) / this.q.c);
            float fCeil = ((float) Math.ceil((getMeasuredWidth() - i3) / 2.0f)) + this.r;
            float measuredHeight2 = (((((getMeasuredHeight() - currentActionBarHeight) - AbstractC21455b.F(48.0f)) + getAdditionalBottom()) - scaleY) / 2.0f) + AbstractC21455b.F(8.0f) + i + this.s;
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
        if (this.E1 != z2) {
            this.E1 = z2;
            this.U0.animate().cancel();
            this.U0.animate().alpha(z ? 0.0f : 1.0f).setInterpolator(InterpolatorC12631ew1.h).setDuration(240L).start();
        }
    }

    @Override // ir.nasim.YZ2
    public Bitmap f(ArrayList arrayList, Bitmap[] bitmapArr) {
        SD6 sd6 = this.v;
        return O1(arrayList, (int) sd6.a, (int) sd6.b, true, true);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void g(int i2) {
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            b3((TextPaintView) entityView, i2);
            T45.h(this.p1).n(i2);
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

    public View getBottomLayout() {
        return this.z0;
    }

    @Override // ir.nasim.YZ2
    public View getCancelView() {
        return this.j;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float getCropRotation() {
        MediaController.i iVar = this.q;
        if (iVar != null) {
            return iVar.d + iVar.i;
        }
        return 0.0f;
    }

    public View getDoneView() {
        return this.k;
    }

    public View getEntitiesView() {
        return this.H;
    }

    @Override // ir.nasim.YZ2
    public long getLcm() {
        return this.N0.longValue();
    }

    @Override // ir.nasim.YZ2
    public List<AbstractC24131y57> getMasks() {
        AnimatedEmojiSpan[] animatedEmojiSpanArr;
        int childCount = this.H.getChildCount();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.H.getChildAt(i2);
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
                                abstractC18106o57H = C21463b.h(this.p1, animatedEmojiSpan.g());
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
        return this.l;
    }

    public List<View> getPreviewViews() {
        return Arrays.asList(this.B, this.D, this.H, this.G);
    }

    public View getRenderInputView() {
        return this.D;
    }

    @Override // ir.nasim.YZ2
    public RenderView getRenderView() {
        return this.B;
    }

    public View getSelectionEntitiesView() {
        return this.G;
    }

    public View getTextDimView() {
        return this.D0;
    }

    public View getTopLayout() {
        return this.J;
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ View getView() {
        return super.getView();
    }

    public View getWeightChooserView() {
        return this.J0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public void h(boolean z) {
        l3();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public boolean i(EntityView entityView) {
        return Y2(entityView);
    }

    @Override // ir.nasim.YZ2
    public void init() {
        this.H.setVisibility(0);
        this.B.setVisibility(0);
        this.D.setVisibility(0);
    }

    @Override // ir.nasim.YZ2
    public int j(boolean z) {
        return this.M1;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public float[] k(MotionEvent motionEvent, float f2, float f3) {
        View view = (View) this.B.getParent();
        View view2 = (View) view.getParent();
        float x = (f2 - view.getX()) - view2.getLeft();
        float y = (f3 - view.getY()) - view2.getTop();
        float pivotX = view.getPivotX() + ((x - view.getPivotX()) / view.getScaleX());
        float pivotY = view.getPivotY() + ((y - view.getPivotY()) / view.getScaleY());
        float[] fArr = this.G1;
        fArr[0] = pivotX;
        fArr[1] = pivotY;
        return fArr;
    }

    @Override // ir.nasim.YZ2
    public void m(boolean z) {
        this.J0.setLayerType(z ? 2 : 0, null);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void n() {
        if (this.K1 || this.J1) {
            M2();
        } else {
            this.F1 = true;
            H1(true);
        }
    }

    @Override // ir.nasim.YZ2
    public void o(PhotoViewer photoViewer, Activity activity, final Runnable runnable) {
        if (this.l1) {
            d3(false);
            return;
        }
        if (this.J1) {
            S1(true);
            return;
        }
        if (this.x) {
            Y2(null);
            return;
        }
        if (!x()) {
            runnable.run();
            return;
        }
        if (activity == null) {
            return;
        }
        AlertDialog.i iVar = new AlertDialog.i(activity, this.q1);
        iVar.e(FH3.E("PhotoEditorDiscardAlert", TD5.tgwidget_PhotoEditorDiscardAlert));
        iVar.j(FH3.E("DiscardChanges", TD5.tgwidget_DiscardChanges));
        iVar.i(FH3.E("PassportDiscard", TD5.tgwidget_PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.nasim.aV4
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
        this.U1 = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.U1 = true;
        super.onDetachedFromWindow();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        float currentActionBarHeight;
        float width;
        this.t = true;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        int currentActionBarHeight2 = (((AbstractC21455b.h.y - ActionBar.getCurrentActionBarHeight()) - getAdditionalTop()) - getAdditionalBottom()) - AbstractC21455b.F(48.0f);
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            width = bitmap.getWidth();
            currentActionBarHeight = this.m.getHeight();
        } else {
            currentActionBarHeight = (size2 - ActionBar.getCurrentActionBarHeight()) - AbstractC21455b.F(48.0f);
            width = size;
        }
        float fFloor = size;
        if (((float) Math.floor((fFloor * currentActionBarHeight) / width)) > currentActionBarHeight2) {
            fFloor = (float) Math.floor((r3 * width) / currentActionBarHeight);
        }
        this.u = fFloor / this.v.a;
        EntityView entityView = this.w;
        if (entityView != null) {
            entityView.d0();
        }
        measureChild(this.z0, i2, i3);
        measureChild(this.J0, i2, i3);
        measureChild(this.B0, i2, i3);
        measureChild(this.A0, i2, View.MeasureSpec.makeMeasureSpec(size2 - Math.max(this.M1 - this.w1.getPaddingUnderContainer(), G()), 1073741824));
        FrameLayout frameLayout = this.J;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), AbstractC21455b.F(12.0f), this.J.getPaddingRight(), this.J.getPaddingBottom());
        measureChild(this.J, i2, i3);
        this.t = false;
        if (!this.Q1 && AbstractC21455b.F(20.0f) >= 0 && !this.J1 && !this.L1) {
            this.t = true;
            T1();
            this.t = false;
        }
        if (AbstractC21455b.F(20.0f) >= 0) {
            return;
        }
        T1();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto.a
    public void onSizeChanged(int i2, boolean z) {
        boolean z2;
        if (i2 > AbstractC21455b.F(50.0f) && this.K1 && !AbstractC21455b.s && !AbstractC21455b.F0()) {
            if (z) {
                this.P1 = i2;
                C.l().edit().putInt("kbd_height_land3", this.P1).commit();
            } else {
                this.O1 = i2;
                C.l().edit().putInt("kbd_height", this.O1).commit();
            }
        }
        if (this.R1 == i2 && this.S1 == z) {
            return;
        }
        this.R1 = i2;
        this.S1 = z;
        boolean z3 = this.K1;
        EntityView entityView = this.w;
        if (entityView instanceof TextPaintView) {
            this.K1 = ((TextPaintView) entityView).getEditText().isFocused() && this.y1.i();
        } else {
            this.K1 = false;
        }
        if (this.K1 && this.J1) {
            e3(0);
        }
        if (this.M1 != 0 && !(z2 = this.K1) && z2 != z3 && !this.J1) {
            this.M1 = 0;
            this.y1.f();
            requestLayout();
        }
        m3();
        if (z3 && !this.K1 && this.M1 > 0 && this.N1) {
            this.N1 = false;
        }
        if (this.K1 && this.Q1) {
            this.Q1 = false;
            AbstractC21455b.t(this.V1);
        }
        k3();
    }

    @Override // ir.nasim.YZ2
    public float p() {
        return 0.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public T45 q() {
        return T45.h(this.p1);
    }

    @Override // ir.nasim.YZ2
    public void r() {
        this.H.removeAllViews();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.t) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.nasim.YZ2
    public /* bridge */ /* synthetic */ void setOffsetTranslationX(float f2) {
        super.setOffsetTranslationX(f2);
    }

    @Override // ir.nasim.YZ2
    public void setOffsetTranslationY(float f2, float f3, int i2, boolean z) {
    }

    public void setOnCancelButtonClickedListener(Runnable runnable) {
        this.v1 = runnable;
    }

    @Override // ir.nasim.YZ2
    public void setOnDoneButtonClickedListener(Runnable runnable) {
        this.u1 = runnable;
    }

    @Override // ir.nasim.YZ2
    public void setTransform(float f2, float f3, float f4, float f5, float f6) {
    }

    @Override // ir.nasim.YZ2
    public void shutdown() {
        this.B.H();
        this.H.setVisibility(8);
        this.G.setVisibility(8);
        this.p.i(new Runnable() { // from class: ir.nasim.NU4
            @Override // java.lang.Runnable
            public final void run() {
                PaintView.J2();
            }
        });
        PX0 px0 = this.C1;
        if (px0 != null) {
            px0.dismiss();
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public void u() {
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.g
    public int[] v(EntityView entityView) {
        this.I1[0] = (int) entityView.getPosition().a;
        this.I1[1] = (int) entityView.getPosition().b;
        return this.I1;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintToolsView.b
    public void w(View view) {
        g3(new Runnable() { // from class: ir.nasim.qV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q2();
            }
        }, this, 53, 0, getHeight());
    }

    @Override // ir.nasim.YZ2
    public boolean x() {
        return this.o.b() || this.F1;
    }

    public void x1(final View view) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        view.setScaleX(scaleX * 0.5f);
        view.setScaleY(0.5f * scaleY);
        view.setAlpha(0.0f);
        view.animate().scaleX(scaleX).scaleY(scaleY).alpha(1.0f).setInterpolator(new OvershootInterpolator(3.0f)).setDuration(240L).withEndAction(new Runnable() { // from class: ir.nasim.bV4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.W1(view);
            }
        }).start();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintTextOptionsView.b
    public void y(View view) {
        setTextType((this.y + 1) % 4);
    }
}
