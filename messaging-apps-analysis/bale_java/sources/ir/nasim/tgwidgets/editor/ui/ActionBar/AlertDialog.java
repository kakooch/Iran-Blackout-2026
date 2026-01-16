package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EffectsTextView;
import ir.nasim.tgwidgets.editor.ui.Components.LineProgressView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import ir.nasim.tgwidgets.editor.ui.Components.RadialProgressView;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class AlertDialog extends Dialog implements Drawable.Callback, E.d {
    private CharSequence A;
    private int A0;
    private int B;
    private int B0;
    private int C0;
    private View D;
    private boolean D0;
    private boolean E0;
    private boolean F0;
    private boolean G;
    private boolean G0;
    private int H;
    private boolean H0;
    private RLottieImageView I0;
    private int J;
    private CharSequence J0;
    private DialogInterface.OnClickListener K0;
    private CharSequence L0;
    private DialogInterface.OnClickListener M0;
    private CharSequence N0;
    private DialogInterface.OnClickListener O0;
    protected ViewGroup P0;
    private LineProgressView Q0;
    private TextView R0;
    private DialogInterface.OnClickListener S0;
    private int[] T0;
    private boolean U0;
    private Drawable V0;
    private Rect W0;
    private float X0;
    private Map Y;
    private Bitmap Y0;
    private int Z;
    private Matrix Z0;
    private View a;
    private BitmapShader a1;
    private int b;
    private Paint b1;
    private TextView c;
    private Paint c1;
    private TextView d;
    private boolean d1;
    private TextView e;
    private Runnable e1;
    private TextView f;
    private Runnable f1;
    private FrameLayout g;
    private ArrayList g1;
    private FrameLayout h;
    private float h1;
    private ScrollView i;
    private boolean i1;
    private LinearLayout j;
    private float j1;
    private ViewTreeObserver.OnScrollChangedListener k;
    private boolean k1;
    private BitmapDrawable[] l;
    private final m.h l1;
    private boolean[] m;
    private boolean m1;
    private AnimatorSet[] n;
    private boolean n1;
    private int o;
    private boolean o1;
    private int p;
    private int p1;
    private DialogInterface.OnCancelListener q;
    float q1;
    private AlertDialog r;
    private boolean r1;
    private int s;
    private int s1;
    private DialogInterface.OnClickListener t;
    private long t1;
    private DialogInterface.OnDismissListener u;
    private CharSequence[] v;
    private int[] w;
    private CharSequence x;
    private CharSequence y;
    private CharSequence z;
    private Drawable z0;

    public static class AlertDialogCell extends FrameLayout {
        private final m.h a;
        private TextView b;
        private ImageView c;

        public AlertDialogCell(Context context, m.h hVar) {
            super(context);
            this.a = hVar;
            setBackground(m.Z(a(m.u4), 2));
            setPadding(AbstractC21455b.F(23.0f), 0, AbstractC21455b.F(23.0f), 0);
            ImageView imageView = new ImageView(context);
            this.c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.c.setColorFilter(new PorterDuffColorFilter(a(m.v4), PorterDuff.Mode.MULTIPLY));
            addView(this.c, AbstractC13840gu3.d(-2, 40, (FH3.D ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.b = textView;
            textView.setLines(1);
            this.b.setSingleLine(true);
            this.b.setGravity(1);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setTextColor(a(m.V3));
            this.b.setTextSize(1, 16.0f);
            addView(this.b, AbstractC13840gu3.d(-2, -2, (FH3.D ? 5 : 3) | 16));
        }

        protected int a(int i) {
            return m.j0(i, this.a);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(48.0f), 1073741824));
        }

        public void setGravity(int i) {
            this.b.setGravity(i);
        }

        public void setTextAndIcon(CharSequence charSequence, int i) {
            this.b.setText(charSequence);
            if (i == 0) {
                this.c.setVisibility(4);
                this.b.setPadding(0, 0, 0, 0);
            } else {
                this.c.setImageResource(i);
                this.c.setVisibility(0);
                this.b.setPadding(FH3.D ? 0 : AbstractC21455b.F(56.0f), 0, FH3.D ? AbstractC21455b.F(56.0f) : 0, 0);
            }
        }

        public void setTextColor(int i) {
            this.b.setTextColor(i);
        }
    }

    class a extends LinearLayout {
        private boolean a;
        private C9151Ys b;
        private Paint c;

        a(Context context) {
            super(context);
            this.b = new C9151Ys(0.0f, this);
            this.c = new Paint(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            AlertDialog alertDialog = AlertDialog.this;
            boolean z = false;
            alertDialog.H0(0, alertDialog.c != null && AlertDialog.this.i.getScrollY() > AlertDialog.this.j.getTop());
            AlertDialog alertDialog2 = AlertDialog.this;
            if (alertDialog2.P0 != null && alertDialog2.i.getScrollY() + AlertDialog.this.i.getHeight() < AlertDialog.this.j.getBottom()) {
                z = true;
            }
            alertDialog2.H0(1, z);
            AlertDialog.this.i.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            AlertDialog.this.s = AbstractC21455b.h.x;
            int iF = AbstractC21455b.h.x - AbstractC21455b.F(56.0f);
            int iF2 = AbstractC21455b.F0() ? AbstractC21455b.E0() ? AbstractC21455b.F(446.0f) : AbstractC21455b.F(496.0f) : AbstractC21455b.F(356.0f);
            Window window = AlertDialog.this.getWindow();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = Math.min(iF2, iF) + AlertDialog.this.W0.left + AlertDialog.this.W0.right;
            try {
                window.setAttributes(layoutParams);
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (AlertDialog.this.G0 && !AlertDialog.this.n1) {
                AlertDialog.this.V0.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                if (AlertDialog.this.D == null || !AlertDialog.this.H0) {
                    AlertDialog.this.V0.draw(canvas);
                } else {
                    int bottom = AlertDialog.this.D.getBottom();
                    canvas.save();
                    canvas.clipRect(0, bottom, getMeasuredWidth(), getMeasuredHeight());
                    AlertDialog.this.V0.draw(canvas);
                    canvas.restore();
                }
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            float F;
            if (AlertDialog.this.n1 && !AlertDialog.this.o1) {
                if (AlertDialog.this.B0 != 3 || AlertDialog.this.g == null) {
                    F = AbstractC21455b.F(10.0f);
                    AbstractC21455b.x.set(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
                } else {
                    F = AbstractC21455b.F(18.0f);
                    float width = AlertDialog.this.g.getWidth() * AlertDialog.this.g.getScaleX();
                    float height = AlertDialog.this.g.getHeight() * AlertDialog.this.g.getScaleY();
                    AbstractC21455b.x.set((getWidth() - width) / 2.0f, (getHeight() - height) / 2.0f, (getWidth() + width) / 2.0f, (getHeight() + height) / 2.0f);
                }
                float fC = this.b.c(AlertDialog.this.b1 != null ? 1.0f : 0.0f);
                if (AlertDialog.this.b1 != null) {
                    AlertDialog.this.b1.setAlpha((int) (fC * 255.0f));
                    canvas.drawRoundRect(AbstractC21455b.x, F, F, AlertDialog.this.b1);
                }
                if (AlertDialog.this.c1 == null) {
                    AlertDialog.this.c1 = new Paint(1);
                    AlertDialog.this.c1.setColor(QY0.k(-16777216, (int) (AlertDialog.this.j1 * 255.0f)));
                }
                RectF rectF = AbstractC21455b.x;
                canvas.drawRoundRect(rectF, F, F, AlertDialog.this.c1);
                this.c.setColor(AlertDialog.this.p1);
                this.c.setAlpha((int) (r4.getAlpha() * ((fC * (AlertDialog.this.X0 - 1.0f)) + 1.0f)));
                canvas.drawRoundRect(rectF, F, F, this.c);
            }
            super.draw(canvas);
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (AlertDialog.this.B0 != 3) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AlertDialog.this.M0();
            return false;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (AlertDialog.this.B0 == 3) {
                int measuredWidth = ((i3 - i) - AlertDialog.this.g.getMeasuredWidth()) / 2;
                int measuredHeight = ((i4 - i2) - AlertDialog.this.g.getMeasuredHeight()) / 2;
                AlertDialog.this.g.layout(measuredWidth, measuredHeight, AlertDialog.this.g.getMeasuredWidth() + measuredWidth, AlertDialog.this.g.getMeasuredHeight() + measuredHeight);
            } else if (AlertDialog.this.i != null) {
                if (AlertDialog.this.k == null) {
                    AlertDialog.this.k = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.b
                        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                        public final void onScrollChanged() {
                            this.a.c();
                        }
                    };
                    AlertDialog.this.i.getViewTreeObserver().addOnScrollChangedListener(AlertDialog.this.k);
                }
                AlertDialog.this.k.onScrollChanged();
            }
            getLocationOnScreen(AlertDialog.this.T0);
            if (AlertDialog.this.Z0 == null || AlertDialog.this.a1 == null) {
                return;
            }
            AlertDialog.this.Z0.reset();
            AlertDialog.this.Z0.postScale(8.0f, 8.0f);
            AlertDialog.this.Z0.postTranslate(-AlertDialog.this.T0[0], -AlertDialog.this.T0[1]);
            AlertDialog.this.a1.setLocalMatrix(AlertDialog.this.Z0);
        }

        /* JADX WARN: Removed duplicated region for block: B:86:0x0322  */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r13, int r14) {
            /*
                Method dump skipped, instructions count: 944
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog.a.onMeasure(int, int):void");
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (AlertDialog.this.B0 != 3) {
                return super.onTouchEvent(motionEvent);
            }
            AlertDialog.this.M0();
            return false;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.a) {
                return;
            }
            super.requestLayout();
        }
    }

    class b extends Drawable {
        int a;
        final /* synthetic */ GradientDrawable b;

        b(GradientDrawable gradientDrawable) {
            this.b = gradientDrawable;
            this.a = AlertDialog.this.J + AbstractC21455b.F(52.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.b.setBounds((int) ((AlertDialog.this.I0.getWidth() - this.a) / 2.0f), (int) ((AlertDialog.this.I0.getHeight() - this.a) / 2.0f), (int) ((AlertDialog.this.I0.getWidth() + this.a) / 2.0f), (int) ((AlertDialog.this.I0.getHeight() + this.a) / 2.0f));
            this.b.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.b.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.b.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }
    }

    class c extends ScrollView {
        c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (AlertDialog.this.l[0].getPaint().getAlpha() != 0) {
                AlertDialog.this.l[0].setBounds(0, getScrollY(), getMeasuredWidth(), getScrollY() + AbstractC21455b.F(3.0f));
                AlertDialog.this.l[0].draw(canvas);
            }
            if (AlertDialog.this.l[1].getPaint().getAlpha() != 0) {
                AlertDialog.this.l[1].setBounds(0, (getScrollY() + getMeasuredHeight()) - AbstractC21455b.F(3.0f), getMeasuredWidth(), getScrollY() + getMeasuredHeight());
                AlertDialog.this.l[1].draw(canvas);
            }
            return zDrawChild;
        }
    }

    class d extends FrameLayout {
        d(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int left;
            int top;
            int childCount = getChildCount();
            int i5 = i3 - i;
            View view = null;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                Integer num = (Integer) childAt.getTag();
                if (num == null) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (view != null) {
                        left = view.getLeft() + ((view.getMeasuredWidth() - measuredWidth) / 2);
                        top = view.getTop() + ((view.getMeasuredHeight() - measuredHeight) / 2);
                    } else {
                        left = 0;
                        top = 0;
                    }
                    childAt.layout(left, top, measuredWidth + left, measuredHeight + top);
                } else if (num.intValue() == -1) {
                    if (FH3.D) {
                        childAt.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingTop() + childAt.getMeasuredHeight());
                    } else {
                        childAt.layout((i5 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i5 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
                    }
                    view = childAt;
                } else if (num.intValue() == -2) {
                    if (FH3.D) {
                        int paddingLeft = getPaddingLeft();
                        if (view != null) {
                            paddingLeft += view.getMeasuredWidth() + AbstractC21455b.F(8.0f);
                        }
                        childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    } else {
                        int paddingRight = (i5 - getPaddingRight()) - childAt.getMeasuredWidth();
                        if (view != null) {
                            paddingRight -= view.getMeasuredWidth() + AbstractC21455b.F(8.0f);
                        }
                        childAt.layout(paddingRight, getPaddingTop(), childAt.getMeasuredWidth() + paddingRight, getPaddingTop() + childAt.getMeasuredHeight());
                    }
                } else if (num.intValue() == -3) {
                    if (FH3.D) {
                        childAt.layout((i5 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i5 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
                    } else {
                        childAt.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingTop() + childAt.getMeasuredHeight());
                    }
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int measuredWidth2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof TextView) && childAt.getTag() != null) {
                    measuredWidth2 += childAt.getMeasuredWidth();
                }
            }
            if (measuredWidth2 > measuredWidth) {
                View viewFindViewWithTag = findViewWithTag(-2);
                View viewFindViewWithTag2 = findViewWithTag(-3);
                if (viewFindViewWithTag == null || viewFindViewWithTag2 == null) {
                    return;
                }
                if (viewFindViewWithTag.getMeasuredWidth() < viewFindViewWithTag2.getMeasuredWidth()) {
                    viewFindViewWithTag2.measure(View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag2.getMeasuredWidth() - (measuredWidth2 - measuredWidth), 1073741824), View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag2.getMeasuredHeight(), 1073741824));
                } else {
                    viewFindViewWithTag.measure(View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag.getMeasuredWidth() - (measuredWidth2 - measuredWidth), 1073741824), View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    class e extends AppCompatTextView {
        e(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        public void setEnabled(boolean z) {
            super.setEnabled(z);
            setAlpha(z ? 1.0f : 0.5f);
        }

        @Override // android.widget.TextView
        public void setTextColor(int i) {
            super.setTextColor(i);
            setBackgroundDrawable(m.s0(AbstractC21455b.F(6.0f), i));
        }
    }

    class f extends AppCompatTextView {
        f(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        public void setEnabled(boolean z) {
            super.setEnabled(z);
            setAlpha(z ? 1.0f : 0.5f);
        }

        @Override // android.widget.TextView
        public void setTextColor(int i) {
            super.setTextColor(i);
            setBackgroundDrawable(m.s0(AbstractC21455b.F(6.0f), i));
        }
    }

    class g extends AppCompatTextView {
        g(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        public void setEnabled(boolean z) {
            super.setEnabled(z);
            setAlpha(z ? 1.0f : 0.5f);
        }

        @Override // android.widget.TextView
        public void setTextColor(int i) {
            super.setTextColor(i);
            setBackgroundDrawable(m.s0(AbstractC21455b.F(6.0f), i));
        }
    }

    class h extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        h(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (AlertDialog.this.n[this.a] == null || !AlertDialog.this.n[this.a].equals(animator)) {
                return;
            }
            AlertDialog.this.n[this.a] = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AlertDialog.this.n[this.a] == null || !AlertDialog.this.n[this.a].equals(animator)) {
                return;
            }
            AlertDialog.this.n[this.a] = null;
        }
    }

    public static class i {
        private AlertDialog a;

        public i(Context context) {
            this(context, null);
        }

        public AlertDialog a() {
            return this.a;
        }

        public void b(boolean z) {
            this.a.H0 = z;
            this.a.n1 = false;
        }

        public i c(int i) {
            this.a.p = i;
            return this;
        }

        public i d(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.a.v = charSequenceArr;
            this.a.t = onClickListener;
            return this;
        }

        public i e(CharSequence charSequence) {
            this.a.A = charSequence;
            return this;
        }

        public i f(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.L0 = charSequence;
            this.a.M0 = onClickListener;
            return this;
        }

        public i g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.N0 = charSequence;
            this.a.O0 = onClickListener;
            return this;
        }

        public i h(DialogInterface.OnDismissListener onDismissListener) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }

        public i i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.J0 = charSequence;
            this.a.K0 = onClickListener;
            return this;
        }

        public i j(CharSequence charSequence) {
            this.a.x = charSequence;
            return this;
        }

        public i k(int i, int i2, boolean z, int i3) {
            return l(i, i2, z, i3, null);
        }

        public i l(int i, int i2, boolean z, int i3, Map map) {
            this.a.H = i;
            this.a.J = i2;
            this.a.m1 = z;
            this.a.A0 = i3;
            this.a.Y = map;
            return this;
        }

        public i m(View view) {
            this.a.D = view;
            return this;
        }

        public void n(float f) {
            this.a.h1 = f;
        }

        public i o(View view) {
            return p(view, -2);
        }

        public i p(View view, int i) {
            this.a.a = view;
            this.a.b = i;
            return this;
        }

        public AlertDialog q() {
            this.a.show();
            return this.a;
        }

        public i(Context context, m.h hVar) {
            this(context, 0, hVar);
        }

        public i(Context context, int i, m.h hVar) {
            this.a = new AlertDialog(context, i, hVar);
        }
    }

    public AlertDialog(Context context, int i2) {
        this(context, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(View view) {
        DialogInterface.OnClickListener onClickListener = this.t;
        if (onClickListener != null) {
            onClickListener.onClick(this, ((Integer) view.getTag()).intValue());
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view) {
        DialogInterface.OnClickListener onClickListener = this.K0;
        if (onClickListener != null) {
            onClickListener.onClick(this, -1);
        }
        if (this.F0) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        DialogInterface.OnClickListener onClickListener = this.M0;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
        if (this.F0) {
            cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        DialogInterface.OnClickListener onClickListener = this.O0;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
        if (this.F0) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(LinearLayout linearLayout, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.b1 == null) {
            this.b1 = new Paint(1);
        }
        this.Y0 = bitmap;
        Bitmap bitmap2 = this.Y0;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        this.a1 = bitmapShader;
        this.b1.setShader(bitmapShader);
        Matrix matrix = new Matrix();
        this.Z0 = matrix;
        matrix.postScale(8.0f, 8.0f);
        Matrix matrix2 = this.Z0;
        int[] iArr = this.T0;
        matrix2.postTranslate(-iArr[0], -iArr[1]);
        this.a1.setLocalMatrix(this.Z0);
        linearLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(DialogInterface dialogInterface, int i2) {
        DialogInterface.OnCancelListener onCancelListener = this.q;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(DialogInterface dialogInterface) {
        this.r = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i2, boolean z) {
        if ((!z || this.m[i2]) && (z || !this.m[i2])) {
            return;
        }
        this.m[i2] = z;
        AnimatorSet animatorSet = this.n[i2];
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.n[i2] = new AnimatorSet();
        BitmapDrawable bitmapDrawable = this.l[i2];
        if (bitmapDrawable != null) {
            this.n[i2].playTogether(ObjectAnimator.ofInt(bitmapDrawable, "alpha", z ? 255 : 0));
        }
        this.n[i2].setDuration(150L);
        this.n[i2].addListener(new h(i2));
        try {
            this.n[i2].start();
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (this.E0 && this.r == null) {
            i iVar = new i(getContext(), this.l1);
            iVar.j(FH3.E("StopLoadingTitle", TD5.tgwidget_StopLoadingTitle));
            iVar.e(FH3.E("StopLoading", TD5.tgwidget_StopLoading));
            iVar.i(FH3.E("WaitMore", TD5.tgwidget_WaitMore), null);
            iVar.f(FH3.E("Stop", TD5.tgwidget_Stop), new DialogInterface.OnClickListener() { // from class: ir.nasim.Jl
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.a.F0(dialogInterface, i2);
                }
            });
            iVar.h(new DialogInterface.OnDismissListener() { // from class: ir.nasim.Kl
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.a.G0(dialogInterface);
                }
            });
            try {
                this.r = iVar.q();
            } catch (Exception unused) {
            }
        }
    }

    private boolean N0() {
        return false;
    }

    private void O0() {
        this.R0.setText(String.format("%d%%", Integer.valueOf(this.C0)));
    }

    private boolean v0(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (v0(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        if (isShowing()) {
            return;
        }
        try {
            show();
        } catch (Exception unused) {
        }
    }

    public void I0(int i2) {
        this.p1 = i2;
        Drawable drawable = this.V0;
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(this.p1, PorterDuff.Mode.MULTIPLY));
        }
    }

    public void J0(CharSequence charSequence) {
        this.A = charSequence;
        if (this.f != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.f.setVisibility(8);
            } else {
                this.f.setText(this.A);
                this.f.setVisibility(0);
            }
        }
    }

    public void K0(int i2) {
        this.C0 = i2;
        LineProgressView lineProgressView = this.Q0;
        if (lineProgressView != null) {
            lineProgressView.setProgress(i2 / 100.0f, true);
            O0();
        }
    }

    public void L0(int i2) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Bitmap bitmap;
        E.j().u(this, E.K2);
        DialogInterface.OnDismissListener onDismissListener = this.u;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        AlertDialog alertDialog = this.r;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        try {
            super.dismiss();
        } catch (Throwable unused) {
        }
        AbstractC21455b.t(this.f1);
        if (this.a1 == null || (bitmap = this.Y0) == null) {
            return;
        }
        bitmap.recycle();
        this.a1 = null;
        this.b1 = null;
        this.Y0 = null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.i.invalidate();
        this.j.invalidate();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        DialogInterface.OnClickListener onClickListener = this.S0;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i2;
        super.onCreate(bundle);
        final a aVar = new a(getContext());
        aVar.setOrientation(1);
        if ((this.n1 || this.B0 == 3) && this.B0 != 2) {
            aVar.setBackgroundDrawable(null);
            aVar.setPadding(0, 0, 0, 0);
            if (this.n1 && !this.o1) {
                aVar.setWillNotDraw(false);
            }
            this.G0 = false;
        } else if (this.H0) {
            Rect rect = new Rect();
            this.V0.getPadding(rect);
            aVar.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            this.G0 = true;
        } else {
            aVar.setBackgroundDrawable(null);
            aVar.setPadding(0, 0, 0, 0);
            aVar.setBackgroundDrawable(this.V0);
            this.G0 = false;
        }
        aVar.setFitsSystemWindows(true);
        setContentView(aVar);
        Object[] objArr = (this.J0 == null && this.L0 == null && this.N0 == null) ? false : true;
        if (this.B == 0 && this.H == 0 && this.z0 == null) {
            View view = this.D;
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
                aVar.addView(this.D, AbstractC13840gu3.n(-1, this.Z, 51, 0, 0, 0, 0));
            }
        } else {
            RLottieImageView rLottieImageView = new RLottieImageView(getContext());
            this.I0 = rLottieImageView;
            Drawable drawable = this.z0;
            if (drawable != null) {
                rLottieImageView.setImageDrawable(drawable);
            } else {
                int i3 = this.B;
                if (i3 != 0) {
                    rLottieImageView.setImageResource(i3);
                } else {
                    rLottieImageView.setAutoRepeat(this.m1);
                    RLottieImageView rLottieImageView2 = this.I0;
                    int i4 = this.H;
                    int i5 = this.J;
                    rLottieImageView2.setAnimation(i4, i5, i5);
                    if (this.Y != null) {
                        RLottieDrawable animatedDrawable = this.I0.getAnimatedDrawable();
                        for (Map.Entry entry : this.Y.entrySet()) {
                            animatedDrawable.n0((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                    this.I0.f();
                }
            }
            this.I0.setScaleType(ImageView.ScaleType.CENTER);
            if (this.G) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(this.A0);
                gradientDrawable.setCornerRadius(AbstractC21455b.F(128.0f));
                this.I0.setBackground(new b(gradientDrawable));
                this.Z = 92;
            } else {
                this.I0.setBackground(m.X(AbstractC21455b.F(10.0f), 0, this.A0));
            }
            if (this.G) {
                this.I0.setTranslationY(AbstractC21455b.F(16.0f));
            } else {
                this.I0.setTranslationY(0.0f);
            }
            this.I0.setPadding(0, 0, 0, 0);
            aVar.addView(this.I0, AbstractC13840gu3.n(-1, this.Z, 51, 0, 0, 0, 0));
        }
        if (this.x != null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.h = frameLayout;
            aVar.addView(frameLayout, AbstractC13840gu3.n(-2, -2, this.G ? 1 : 0, 24, 0, 24, 0));
            SpoilersTextView spoilersTextView = new SpoilersTextView(getContext(), false);
            this.c = spoilersTextView;
            spoilersTextView.setText(this.x);
            this.c.setTextColor(y0(m.V3));
            this.c.setTextSize(1, 20.0f);
            this.c.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.c.setGravity((this.G ? 1 : FH3.D ? 5 : 3) | 48);
            FrameLayout frameLayout2 = this.h;
            TextView textView = this.c;
            boolean z = this.G;
            frameLayout2.addView(textView, AbstractC13840gu3.c(-2, -2.0f, (z ? 1 : FH3.D ? 5 : 3) | 48, 0.0f, 19.0f, 0.0f, z ? 4.0f : this.z != null ? 2 : this.v != null ? 14 : 10));
        }
        if (this.y != null && this.x != null) {
            TextView textView2 = new TextView(getContext());
            this.d = textView2;
            textView2.setText(this.y);
            this.d.setTextColor(y0(m.d4));
            this.d.setTextSize(1, 18.0f);
            this.d.setGravity((FH3.D ? 3 : 5) | 48);
            this.h.addView(this.d, AbstractC13840gu3.c(-2, -2.0f, (FH3.D ? 3 : 5) | 48, 0.0f, 21.0f, 0.0f, 0.0f));
        }
        if (this.z != null) {
            TextView textView3 = new TextView(getContext());
            this.e = textView3;
            textView3.setText(this.z);
            this.e.setTextColor(y0(m.v4));
            this.e.setTextSize(1, 14.0f);
            this.e.setGravity((FH3.D ? 5 : 3) | 48);
            aVar.addView(this.e, AbstractC13840gu3.n(-2, -2, (FH3.D ? 5 : 3) | 48, 24, 0, 24, this.v != null ? 14 : 10));
        }
        if (this.B0 == 0) {
            this.l[0] = (BitmapDrawable) getContext().getResources().getDrawable(AbstractC23598xB5.header_shadow).mutate();
            this.l[1] = (BitmapDrawable) getContext().getResources().getDrawable(AbstractC23598xB5.header_shadow_reverse).mutate();
            this.l[0].setAlpha(0);
            this.l[1].setAlpha(0);
            this.l[0].setCallback(this);
            this.l[1].setCallback(this);
            c cVar = new c(getContext());
            this.i = cVar;
            cVar.setVerticalScrollBarEnabled(false);
            AbstractC21455b.w1(this.i, y0(m.m4));
            aVar.addView(this.i, AbstractC13840gu3.i(-1, -2, 0.0f, 0.0f, 0.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.j = linearLayout;
            linearLayout.setOrientation(1);
            this.i.addView(this.j, new FrameLayout.LayoutParams(-1, -2));
        }
        EffectsTextView effectsTextView = new EffectsTextView(getContext());
        this.f = effectsTextView;
        E.p(effectsTextView);
        this.f.setTextColor(y0(this.G ? m.h5 : m.V3));
        this.f.setTextSize(1, 16.0f);
        this.f.setMovementMethod(new AbstractC21455b.d());
        this.f.setLinkTextColor(y0(m.W3));
        if (!this.D0) {
            this.f.setClickable(false);
            this.f.setEnabled(false);
        }
        this.f.setGravity((this.G ? 1 : FH3.D ? 5 : 3) | 48);
        int i6 = this.B0;
        if (i6 == 2) {
            aVar.addView(this.f, AbstractC13840gu3.n(-2, -2, (FH3.D ? 5 : 3) | 48, 24, this.x == null ? 19 : 0, 24, 20));
            LineProgressView lineProgressView = new LineProgressView(getContext());
            this.Q0 = lineProgressView;
            lineProgressView.setProgress(this.C0 / 100.0f, false);
            this.Q0.setProgressColor(y0(m.r4));
            this.Q0.setBackColor(y0(m.s4));
            aVar.addView(this.Q0, AbstractC13840gu3.n(-1, 4, 19, 24, 0, 24, 0));
            TextView textView4 = new TextView(getContext());
            this.R0 = textView4;
            textView4.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.R0.setGravity((FH3.D ? 5 : 3) | 48);
            this.R0.setTextColor(y0(m.c4));
            this.R0.setTextSize(1, 14.0f);
            aVar.addView(this.R0, AbstractC13840gu3.n(-2, -2, (FH3.D ? 5 : 3) | 48, 23, 4, 23, 24));
            O0();
        } else if (i6 == 3) {
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            this.g = new FrameLayout(getContext());
            this.p1 = y0(m.z4);
            if (!this.n1 || this.o1) {
                this.g.setBackgroundDrawable(m.W(AbstractC21455b.F(18.0f), this.p1));
            }
            aVar.addView(this.g, AbstractC13840gu3.m(86, 86, 17));
            RadialProgressView radialProgressView = new RadialProgressView(getContext(), this.l1);
            radialProgressView.setSize(AbstractC21455b.F(32.0f));
            radialProgressView.setProgressColor(y0(m.A4));
            this.g.addView(radialProgressView, AbstractC13840gu3.d(86, 86, 17));
        } else {
            this.j.addView(this.f, AbstractC13840gu3.n(-2, -2, (this.G ? 1 : FH3.D ? 5 : 3) | 48, 24, 0, 24, (this.a == null && this.v == null) ? 0 : this.o));
        }
        if (TextUtils.isEmpty(this.A)) {
            this.f.setVisibility(8);
        } else {
            this.f.setText(this.A);
            this.f.setVisibility(0);
        }
        if (this.v != null) {
            int i7 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.v;
                if (i7 >= charSequenceArr.length) {
                    break;
                }
                if (charSequenceArr[i7] != null) {
                    AlertDialogCell alertDialogCell = new AlertDialogCell(getContext(), this.l1);
                    CharSequence charSequence = this.v[i7];
                    int[] iArr = this.w;
                    alertDialogCell.setTextAndIcon(charSequence, iArr != null ? iArr[i7] : 0);
                    alertDialogCell.setTag(Integer.valueOf(i7));
                    this.g1.add(alertDialogCell);
                    this.j.addView(alertDialogCell, AbstractC13840gu3.g(-1, 50));
                    alertDialogCell.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Nl
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.a.A0(view2);
                        }
                    });
                }
                i7++;
            }
        }
        View view2 = this.a;
        if (view2 != null) {
            if (view2.getParent() != null) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            this.j.addView(this.a, AbstractC13840gu3.g(-1, this.b));
        }
        if (objArr != false) {
            if (!this.d1) {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(AbstractC21455b.F(14.0f));
                CharSequence charSequence2 = this.J0;
                int iMeasureText = charSequence2 != null ? (int) (0 + textPaint.measureText(charSequence2, 0, charSequence2.length()) + AbstractC21455b.F(10.0f)) : 0;
                CharSequence charSequence3 = this.L0;
                if (charSequence3 != null) {
                    iMeasureText = (int) (iMeasureText + textPaint.measureText(charSequence3, 0, charSequence3.length()) + AbstractC21455b.F(10.0f));
                }
                CharSequence charSequence4 = this.N0;
                if (charSequence4 != null) {
                    iMeasureText = (int) (iMeasureText + textPaint.measureText(charSequence4, 0, charSequence4.length()) + AbstractC21455b.F(10.0f));
                }
                if (iMeasureText > AbstractC21455b.h.x - AbstractC21455b.F(110.0f)) {
                    this.d1 = true;
                }
            }
            if (this.d1) {
                LinearLayout linearLayout2 = new LinearLayout(getContext());
                linearLayout2.setOrientation(1);
                this.P0 = linearLayout2;
            } else {
                this.P0 = new d(getContext());
            }
            this.P0.setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
            aVar.addView(this.P0, AbstractC13840gu3.g(-1, 52));
            if (this.G) {
                this.P0.setTranslationY(-AbstractC21455b.F(8.0f));
            }
            if (this.J0 != null) {
                e eVar = new e(getContext());
                eVar.setMinWidth(AbstractC21455b.F(64.0f));
                eVar.setTag(-1);
                eVar.setTextSize(1, 16.0f);
                eVar.setTextColor(y0(this.p));
                eVar.setGravity(17);
                eVar.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                eVar.setText(this.J0.toString());
                eVar.setBackgroundDrawable(m.s0(AbstractC21455b.F(6.0f), y0(this.p)));
                eVar.setPadding(AbstractC21455b.F(12.0f), 0, AbstractC21455b.F(12.0f), 0);
                if (this.d1) {
                    this.P0.addView(eVar, AbstractC13840gu3.m(-2, 36, FH3.D ? 3 : 5));
                } else {
                    this.P0.addView(eVar, AbstractC13840gu3.d(-2, 36, 53));
                }
                eVar.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Pl
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.a.B0(view3);
                    }
                });
            }
            if (this.L0 != null) {
                f fVar = new f(getContext());
                fVar.setMinWidth(AbstractC21455b.F(64.0f));
                fVar.setTag(-2);
                fVar.setTextSize(1, 16.0f);
                fVar.setTextColor(y0(this.p));
                fVar.setGravity(17);
                fVar.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                fVar.setEllipsize(TextUtils.TruncateAt.END);
                fVar.setSingleLine(true);
                fVar.setText(this.L0.toString());
                fVar.setBackgroundDrawable(m.s0(AbstractC21455b.F(6.0f), y0(this.p)));
                fVar.setPadding(AbstractC21455b.F(12.0f), 0, AbstractC21455b.F(12.0f), 0);
                if (this.d1) {
                    this.P0.addView(fVar, 0, AbstractC13840gu3.m(-2, 36, FH3.D ? 3 : 5));
                } else {
                    this.P0.addView(fVar, AbstractC13840gu3.d(-2, 36, 53));
                }
                fVar.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ql
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.a.C0(view3);
                    }
                });
            }
            if (this.N0 != null) {
                g gVar = new g(getContext());
                gVar.setMinWidth(AbstractC21455b.F(64.0f));
                gVar.setTag(-3);
                gVar.setTextSize(1, 16.0f);
                gVar.setTextColor(y0(this.p));
                gVar.setGravity(17);
                gVar.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                gVar.setEllipsize(TextUtils.TruncateAt.END);
                gVar.setSingleLine(true);
                gVar.setText(this.N0.toString());
                gVar.setBackground(m.s0(AbstractC21455b.F(6.0f), y0(this.p)));
                gVar.setPadding(AbstractC21455b.F(12.0f), 0, AbstractC21455b.F(12.0f), 0);
                if (this.d1) {
                    this.P0.addView(gVar, 1, AbstractC13840gu3.m(-2, 36, FH3.D ? 3 : 5));
                } else {
                    this.P0.addView(gVar, AbstractC13840gu3.d(-2, 36, 51));
                }
                gVar.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Rl
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.a.D0(view3);
                    }
                });
            }
            if (this.d1) {
                for (int i8 = 1; i8 < this.P0.getChildCount(); i8++) {
                    ((ViewGroup.MarginLayoutParams) this.P0.getChildAt(i8).getLayoutParams()).topMargin = AbstractC21455b.F(6.0f);
                }
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        if (this.B0 == 3) {
            layoutParams.width = -1;
        } else {
            if (!this.i1 || this.k1) {
                i2 = 2;
                layoutParams.dimAmount = 0.0f;
                layoutParams.flags ^= 2;
            } else {
                layoutParams.dimAmount = this.j1;
                i2 = 2;
                layoutParams.flags |= 2;
            }
            int i9 = AbstractC21455b.h.x;
            this.s = i9;
            int iMin = Math.min(AbstractC21455b.F0() ? AbstractC21455b.E0() ? AbstractC21455b.F(446.0f) : AbstractC21455b.F(496.0f) : AbstractC21455b.F(356.0f), (i9 - AbstractC21455b.F(48.0f)) - (this.s1 * i2));
            Rect rect2 = this.W0;
            layoutParams.width = iMin + rect2.left + rect2.right;
        }
        View view3 = this.a;
        if (view3 != null && this.U0 && v0(view3)) {
            layoutParams.softInputMode = 4;
        } else {
            layoutParams.flags |= 131072;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 0;
        }
        if (this.n1) {
            if (!N0()) {
                AbstractC21455b.a1(new Utilities.b() { // from class: ir.nasim.Sl
                    @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                    public final void a(Object obj) {
                        this.a.E0(aVar, (Bitmap) obj);
                    }
                }, 8.0f);
            } else if (this.B0 == 0) {
                this.o1 = true;
                if (i10 >= 31) {
                    window.setBackgroundBlurRadius(50);
                }
                float F = AbstractC21455b.F(12.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{F, F, F, F, F, F, F, F}, null, null));
                shapeDrawable.getPaint().setColor(QY0.k(this.p1, (int) (this.q1 * 255.0f)));
                window.setBackgroundDrawable(shapeDrawable);
                if (this.r1) {
                    layoutParams.flags |= 4;
                    if (i10 >= 31) {
                        layoutParams.setBlurBehindRadius(20);
                    }
                }
            }
        }
        window.setAttributes(layoutParams);
        E.j().e(this, E.K2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        ScrollView scrollView = this.i;
        if (scrollView != null) {
            scrollView.postDelayed(runnable, j);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.q = onCancelListener;
        super.setOnCancelListener(onCancelListener);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.x = charSequence;
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        FrameLayout frameLayout = this.g;
        if (frameLayout != null && this.B0 == 3) {
            frameLayout.setScaleX(0.0f);
            this.g.setScaleY(0.0f);
            this.g.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator(1.3f)).setDuration(190L).start();
        }
        this.t1 = System.currentTimeMillis();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i2, int i3, Object... objArr) {
        TextView textView;
        if (i2 != E.K2 || (textView = this.f) == null) {
            return;
        }
        textView.invalidate();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        ScrollView scrollView = this.i;
        if (scrollView != null) {
            scrollView.removeCallbacks(runnable);
        }
    }

    public View w0(int i2) {
        ViewGroup viewGroup = this.P0;
        if (viewGroup != null) {
            return viewGroup.findViewWithTag(Integer.valueOf(i2));
        }
        return null;
    }

    public ViewGroup x0() {
        return this.P0;
    }

    protected int y0(int i2) {
        return m.j0(i2, this.l1);
    }

    public AlertDialog(Context context, int i2, m.h hVar) {
        super(context, AbstractC16417lE5.TransparentDialog);
        this.b = -2;
        this.l = new BitmapDrawable[2];
        this.m = new boolean[2];
        this.n = new AnimatorSet[2];
        this.o = 12;
        this.p = m.t4;
        this.Z = WKSRecord.Service.CISCO_SYS;
        boolean z = true;
        this.D0 = true;
        this.E0 = true;
        this.F0 = true;
        this.T0 = new int[2];
        this.U0 = true;
        this.e1 = new Runnable() { // from class: ir.nasim.Tl
            @Override // java.lang.Runnable
            public final void run() {
                this.a.dismiss();
            }
        };
        this.f1 = new Runnable() { // from class: ir.nasim.Ul
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z0();
            }
        };
        this.g1 = new ArrayList();
        this.i1 = true;
        this.j1 = 0.5f;
        this.k1 = false;
        this.m1 = true;
        float f2 = 0.8f;
        this.q1 = 0.8f;
        this.l1 = hVar;
        this.o1 = N0() && this.B0 == 0;
        int iY0 = y0(m.T3);
        this.p1 = iY0;
        boolean z2 = AbstractC21455b.z(iY0) < 0.721f;
        if (!this.o1 && (N0() || AbstractC8662Wx6.h() < 2 || !z2)) {
            z = false;
        }
        this.n1 = z;
        this.W0 = new Rect();
        if (i2 != 3 || this.n1) {
            Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.popup_fixed_alert3).mutate();
            this.V0 = drawableMutate;
            if (i2 == 3) {
                f2 = 0.55f;
            } else if (!z2) {
                f2 = 0.985f;
            }
            this.X0 = f2;
            drawableMutate.setColorFilter(new PorterDuffColorFilter(this.p1, PorterDuff.Mode.MULTIPLY));
            this.V0.getPadding(this.W0);
        }
        this.B0 = i2;
    }
}
