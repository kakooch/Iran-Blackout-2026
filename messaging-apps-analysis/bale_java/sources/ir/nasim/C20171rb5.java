package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.C21753u45;
import ir.nasim.S23;
import ir.nasim.components.checkbox.view.CheckBox;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.libphotovideo.PhotoPaintView;
import ir.nasim.features.media.Actionbar.ActionBar;
import ir.nasim.features.media.Actionbar.ActionBarMenu;
import ir.nasim.features.media.Actionbar.ActionBarMenuItem;
import ir.nasim.features.media.components.ClippingImageView;
import ir.nasim.features.media.components.PhotoCropView;
import ir.nasim.features.media.components.PhotoFilterView;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.media.components.PhotoViewerCaptionEnterView;
import ir.nasim.features.media.components.PickerBottomLayoutViewer;
import ir.nasim.features.media.components.SizeNotifierFrameLayoutPhoto;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.rb5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20171rb5 extends PhotoViewerAbs {
    private static Drawable[] r2;
    private static DecelerateInterpolator s2;
    private static Paint t2;
    private CheckBox A;
    private PhotoCropView A0;
    private long A1;
    private PickerBottomLayoutViewer B;
    private PhotoFilterView B0;
    private AnimatorSet B1;
    private PhotoPaintView C0;
    private AnimatorSet C1;
    private PickerBottomLayoutViewer D;
    private AlertDialog D0;
    private GestureDetector D1;
    private TextView E0;
    private DecelerateInterpolator E1;
    private TextView F0;
    private float F1;
    private P[] G;
    private TextView G0;
    private float G1;
    private ImageView H;
    private PhotoViewerCaptionEnterView H0;
    private float H1;
    private boolean I0;
    private float I1;
    private ImageView J;
    private int J0;
    private float J1;
    private boolean K0;
    private float K1;
    private C8610Ws L0;
    private float L1;
    private boolean M0;
    private float M1;
    private Object N0;
    private float N1;
    private float[][] O0;
    private float O1;
    private int P0;
    private float P1;
    private long Q0;
    private float Q1;
    private Runnable R0;
    private boolean R1;
    private PhotoViewerAbs.PlaceProviderObjectAbs S0;
    private boolean S1;
    private PhotoViewerAbs.PlaceProviderObjectAbs T0;
    private boolean U0;
    private boolean U1;
    private String V0;
    private boolean V1;
    private int W0;
    private boolean W1;
    private S23 X0;
    private boolean X1;
    private ImageView Y;
    private S23 Y0;
    private boolean Y1;
    private ActionBarMenuItem Z;
    private S23 Z0;
    private boolean Z1;
    private int a1;
    private boolean a2;
    private C11507d74 b1;
    private int b2;
    private AbstractC4761Gl2 c1;
    private VelocityTracker c2;
    private SA2 d;
    private String[] d1;
    private Scroller d2;
    private int e;
    private PhotoViewerAbs.PlaceProviderObjectAbs e1;
    private ArrayList e2;
    private PhotoViewerAbs.PhotoViewerProviderAbs f;
    private String f1;
    private HashMap[] f2;
    private boolean g;
    private Bitmap g1;
    private ArrayList g2;
    private Activity h;
    private int h1;
    private HashMap[] h2;
    private Context i;
    private long i1;
    private ArrayList i2;
    private int j1;
    private ArrayList j2;
    private ActionBar k;
    private int k1;
    private ArrayList k2;
    private boolean l1;
    private ArrayList l2;
    private WindowManager.LayoutParams m;
    private boolean m1;
    private AbstractC4761Gl2 m2;
    private O n;
    private boolean[] n1;
    private ActionBar.b n2;
    private FrameLayout o;
    private boolean o1;
    private boolean o2;
    private ClippingImageView p;
    private boolean p1;
    private C11458d25 p2;
    private FrameLayout q;
    private boolean q1;
    private ExPeerType q2;
    private TextView r;
    private boolean r1;
    private AvatarViewGlide s;
    private boolean s1;
    private TextView t;
    private float t1;
    private ActionBarMenuItem u;
    private float u1;
    private ActionBarMenuItem v;
    private float v1;
    private ActionBarMenuItem w;
    private float w1;
    private ImageView x;
    private float x1;
    private N y;
    private float y1;
    private Paint z;
    private AnimatorSet z0;
    private float z1;
    public boolean c = false;
    private boolean j = false;
    private boolean l = true;

    /* renamed from: ir.nasim.rb5$A */
    class A implements Runnable {
        final /* synthetic */ PhotoViewerAbs.PlaceProviderObjectAbs a;

        A(PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs) {
            this.a = placeProviderObjectAbs;
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.n.setLayerType(0, null);
            C20171rb5.this.P0 = 0;
            C20171rb5.this.q1(this.a);
        }
    }

    /* renamed from: ir.nasim.rb5$B */
    class B extends AbstractC9160Yt {

        /* renamed from: ir.nasim.rb5$B$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C20171rb5.this.R0 != null) {
                    C20171rb5.this.R0.run();
                    C20171rb5.this.R0 = null;
                }
            }
        }

        B() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC7426Rr.P(new a());
        }
    }

    /* renamed from: ir.nasim.rb5$C */
    class C implements Runnable {
        final /* synthetic */ PhotoViewerAbs.PlaceProviderObjectAbs a;

        C(PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs) {
            this.a = placeProviderObjectAbs;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C20171rb5.this.n == null) {
                return;
            }
            C20171rb5.this.n.setLayerType(0, null);
            C20171rb5.this.P0 = 0;
            C20171rb5.this.q1(this.a);
            C20171rb5.this.n.setScaleX(1.0f);
            C20171rb5.this.n.setScaleY(1.0f);
        }
    }

    /* renamed from: ir.nasim.rb5$D */
    class D extends AbstractC9160Yt {
        D() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C20171rb5.this.R0 != null) {
                C20171rb5.this.R0.run();
                C20171rb5.this.R0 = null;
            }
        }
    }

    /* renamed from: ir.nasim.rb5$E */
    class E implements Runnable {
        E() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.p.setImageBitmap(null);
            try {
                if (C20171rb5.this.o.getParent() != null) {
                    ((WindowManager) C20171rb5.this.h.getSystemService("window")).removeView(C20171rb5.this.o);
                }
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
        }
    }

    /* renamed from: ir.nasim.rb5$F */
    class F implements Runnable {
        final /* synthetic */ int a;

        F(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.w1(this.a + 1);
        }
    }

    /* renamed from: ir.nasim.rb5$G */
    class G extends AbstractC9160Yt {
        G() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C20171rb5.this.B1 = null;
            C20171rb5.this.n.invalidate();
        }
    }

    /* renamed from: ir.nasim.rb5$H */
    class H implements View.OnClickListener {
        H() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.J.getVisibility() == 0 || C20171rb5.this.o2) {
                C20171rb5.this.u1();
            }
        }
    }

    /* renamed from: ir.nasim.rb5$I */
    class I implements View.OnClickListener {
        I() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.J.getVisibility() == 0 || C20171rb5.this.o2) {
                C20171rb5.this.u1();
            }
        }
    }

    /* renamed from: ir.nasim.rb5$J */
    class J implements View.OnClickListener {
        J() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.f instanceof PhotoViewerAbs.EmptyPhotoViewerProviderAbs) {
                C20171rb5.this.closePhoto(false, false);
            } else if (C20171rb5.this.f != null) {
                C20171rb5.this.closePhoto(!r3.f.cancelButtonPressed(), false);
            }
        }
    }

    /* renamed from: ir.nasim.rb5$K */
    class K implements View.OnClickListener {
        K() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.f != null) {
                C20171rb5.this.f.sendButtonPressed(C20171rb5.this.a1, null);
                C20171rb5.this.closePhoto(false, false);
            }
        }
    }

    /* renamed from: ir.nasim.rb5$L */
    class L implements View.OnClickListener {
        L() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C20171rb5.this.C1(2);
        }
    }

    /* renamed from: ir.nasim.rb5$M */
    class M implements View.OnClickListener {
        M() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C20171rb5.this.C1(3);
        }
    }

    /* renamed from: ir.nasim.rb5$N */
    private class N extends ColorDrawable {
        private Runnable a;

        public N(int i) {
            super(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Runnable runnable;
            super.draw(canvas);
            if (getAlpha() == 0 || (runnable = this.a) == null) {
                return;
            }
            runnable.run();
            this.a = null;
        }
    }

    /* renamed from: ir.nasim.rb5$O */
    private class O extends SizeNotifierFrameLayoutPhoto {
        private Paint d;

        public O(Context context) {
            super(context);
            this.d = new Paint();
            setWillNotDraw(false);
            Paint paint = this.d;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            paint.setColor(c5495Jo7.y0(c5495Jo7.j2(), 20));
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            return view != null && super.drawChild(canvas, view, j);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            ((PhotoViewerAbs) PhotoViewerAbs.getInstance()).onDraw(canvas);
            if (AbstractC7426Rr.H() != 0) {
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AbstractC7426Rr.H(), this.d);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c1  */
        @Override // ir.nasim.features.media.components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 311
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.O.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, size2);
            measureChildWithMargins(C20171rb5.this.H0, i, 0, i2, 0);
            int measuredHeight = C20171rb5.this.H0.getMeasuredHeight();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8 && childAt != C20171rb5.this.H0) {
                    if (!C20171rb5.this.H0.isPopupView()) {
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                    } else if (AbstractC7426Rr.K()) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - measuredHeight) - AbstractC7426Rr.H(), 1073741824));
                    } else {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                    }
                }
            }
        }
    }

    /* renamed from: ir.nasim.rb5$P */
    private class P {
        private View i;
        private long a = 0;
        private float b = 0.0f;
        private float c = 0.0f;
        private float d = 0.0f;
        private long e = 0;
        private float f = 0.0f;
        private RectF g = new RectF();
        private int h = -1;
        private int j = AbstractC7426Rr.z(64.0f);
        private int k = -2;
        private float l = 1.0f;
        private float m = 1.0f;
        private float n = 1.0f;

        public P(View view) {
            this.i = null;
            if (C20171rb5.s2 == null) {
                C20171rb5.s2 = new DecelerateInterpolator(1.5f);
                C20171rb5.t2 = new Paint(1);
                C20171rb5.t2.setStyle(Paint.Style.STROKE);
                C20171rb5.t2.setStrokeCap(Paint.Cap.ROUND);
                C20171rb5.t2.setStrokeWidth(AbstractC7426Rr.z(3.0f));
                C20171rb5.t2.setColor(C5495Jo7.a.f0());
            }
            this.i = view;
        }

        private void g() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.a;
            this.a = jCurrentTimeMillis;
            if (this.f != 1.0f) {
                this.b += (360 * j) / 3000.0f;
                float f = this.c;
                float f2 = this.d;
                float f3 = f - f2;
                if (f3 > 0.0f) {
                    long j2 = this.e + j;
                    this.e = j2;
                    if (j2 >= 300) {
                        this.f = f;
                        this.d = f;
                        this.e = 0L;
                    } else {
                        this.f = f2 + (f3 * C20171rb5.s2.getInterpolation(this.e / 300.0f));
                    }
                }
                this.i.invalidate();
            }
            if (this.f < 1.0f || this.k == -2) {
                return;
            }
            float f4 = this.l - (j / 200.0f);
            this.l = f4;
            if (f4 <= 0.0f) {
                this.l = 0.0f;
                this.k = -2;
            }
            this.i.invalidate();
        }

        public void b(Canvas canvas) {
            int i;
            Drawable drawable;
            Drawable drawable2;
            int i2 = (int) (this.j * this.n);
            int iI1 = (C20171rb5.this.i1() - i2) / 2;
            int iG1 = (C20171rb5.this.g1() - i2) / 2;
            int i3 = this.k;
            if (i3 >= 0 && i3 < 4 && (drawable2 = C20171rb5.r2[this.k]) != null) {
                drawable2.setAlpha((int) (this.l * 255.0f * this.m));
                drawable2.setBounds(iI1, iG1, iI1 + i2, iG1 + i2);
                drawable2.draw(canvas);
            }
            int i4 = this.h;
            if (i4 >= 0 && i4 < 4 && (drawable = C20171rb5.r2[this.h]) != null) {
                if (this.k != -2) {
                    drawable.setAlpha((int) ((1.0f - this.l) * 255.0f * this.m));
                } else {
                    drawable.setAlpha((int) (this.m * 255.0f));
                }
                drawable.setBounds(iI1, iG1, iI1 + i2, iG1 + i2);
                drawable.draw(canvas);
            }
            int i5 = this.h;
            if (i5 == 0 || i5 == 1 || (i = this.k) == 0 || i == 1) {
                int iZ = AbstractC7426Rr.z(4.0f);
                if (this.k != -2) {
                    C20171rb5.t2.setAlpha((int) (this.l * 255.0f * this.m));
                } else {
                    C20171rb5.t2.setAlpha((int) (this.m * 255.0f));
                }
                this.g.set(iI1 + iZ, iG1 + iZ, (iI1 + i2) - iZ, (iG1 + i2) - iZ);
                canvas.drawArc(this.g, this.b - 90.0f, Math.max(4.0f, this.f * 360.0f), false, C20171rb5.t2);
                g();
            }
        }

        public void c(float f) {
            this.m = f;
        }

        public void d(int i, boolean z) {
            int i2;
            this.a = System.currentTimeMillis();
            if (!z || (i2 = this.h) == i) {
                this.k = -2;
            } else {
                this.k = i2;
                this.l = 1.0f;
            }
            this.h = i;
            this.i.invalidate();
        }

        public void e(float f, boolean z) {
            if (z) {
                this.d = this.f;
            } else {
                this.f = f;
                this.d = f;
            }
            this.c = f;
            this.e = 0L;
        }

        public void f(float f) {
            this.n = f;
        }
    }

    /* renamed from: ir.nasim.rb5$a, reason: case insensitive filesystem */
    class C20172a extends FrameLayout {

        /* renamed from: ir.nasim.rb5$a$a, reason: collision with other inner class name */
        class RunnableC1501a implements Runnable {
            RunnableC1501a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) C20171rb5.this.A.getLayoutParams();
                int rotation = ((WindowManager) C5721Ko.b.getSystemService("window")).getDefaultDisplay().getRotation();
                layoutParams.topMargin = AbstractC7426Rr.z((rotation == 3 || rotation == 1) ? 58.0f : 68.0f) + AbstractC7426Rr.H();
                C20171rb5.this.A.setLayoutParams(layoutParams);
            }
        }

        C20172a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                return super.dispatchKeyEventPreIme(keyEvent);
            }
            if (C20171rb5.this.H0.isPopupShowing() || C20171rb5.this.H0.isKeyboardVisible()) {
                C20171rb5.this.d1(false);
                return false;
            }
            PhotoViewerAbs.getInstance().closePhoto(true, false);
            return true;
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (view == C20171rb5.this.p && C20171rb5.this.N0 != null) {
                canvas.drawRect(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight() + ((WindowInsets) C20171rb5.this.N0).getSystemWindowInsetBottom(), C20171rb5.this.z);
            }
            return zDrawChild;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            C20171rb5.this.p1 = true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            C20171rb5.this.p1 = false;
            C20171rb5.this.q1 = false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return C20171rb5.this.g && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            C20171rb5.this.p.layout(0, 0, C20171rb5.this.p.getMeasuredWidth(), C20171rb5.this.p.getMeasuredHeight());
            C20171rb5.this.n.layout(0, 0, C20171rb5.this.n.getMeasuredWidth(), C20171rb5.this.n.getMeasuredHeight());
            C20171rb5.this.q1 = true;
            if (z) {
                if (!C20171rb5.this.r1) {
                    C20171rb5.this.w1 = 1.0f;
                    C20171rb5.this.u1 = 0.0f;
                    C20171rb5.this.v1 = 0.0f;
                    C20171rb5 c20171rb5 = C20171rb5.this;
                    c20171rb5.G1(c20171rb5.w1);
                }
                if (C20171rb5.this.A != null) {
                    C20171rb5.this.A.post(new RunnableC1501a());
                }
            }
            if (C20171rb5.this.r1) {
                C20171rb5.this.B1();
                C20171rb5.this.r1 = false;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (C20171rb5.this.N0 != null) {
                WindowInsets windowInsets = (WindowInsets) C20171rb5.this.N0;
                if (AbstractC7426Rr.F()) {
                    if (size2 > AbstractC7426Rr.C().y) {
                        size2 = AbstractC7426Rr.C().y;
                    }
                    size2 += AbstractC7426Rr.H();
                }
                size2 -= windowInsets.getSystemWindowInsetBottom();
                size -= windowInsets.getSystemWindowInsetRight();
            } else if (size2 > AbstractC7426Rr.C().y) {
                size2 = AbstractC7426Rr.C().y;
            }
            setMeasuredDimension(size, size2);
            ViewGroup.LayoutParams layoutParams = C20171rb5.this.p.getLayoutParams();
            C20171rb5.this.p.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(layoutParams.height, RecyclerView.UNDEFINED_DURATION));
            C20171rb5.this.n.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return C20171rb5.this.g && C20171rb5.this.t1(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
            View viewFindViewById = C20171rb5.this.h.findViewById(android.R.id.content);
            if (viewFindViewById instanceof ViewGroup) {
                try {
                    return ((ViewGroup) viewFindViewById).startActionModeForChild(view, callback, i);
                } catch (Throwable th) {
                    C19406qI3.d("baleMessages", th);
                }
            }
            return super.startActionModeForChild(view, callback, i);
        }
    }

    /* renamed from: ir.nasim.rb5$b, reason: case insensitive filesystem */
    class ViewOnClickListenerC20173b implements View.OnClickListener {
        ViewOnClickListenerC20173b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C20171rb5.this.C1(1);
        }
    }

    /* renamed from: ir.nasim.rb5$c, reason: case insensitive filesystem */
    class ViewOnClickListenerC20174c implements View.OnClickListener {
        ViewOnClickListenerC20174c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.W0 == 1) {
                C20171rb5.this.A0.cancelAnimationRunnable();
            }
            C20171rb5.this.C1(0);
        }
    }

    /* renamed from: ir.nasim.rb5$d, reason: case insensitive filesystem */
    class ViewOnClickListenerC20175d implements View.OnClickListener {
        ViewOnClickListenerC20175d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.W0 == 1) {
                C20171rb5.this.A0.cancelAnimationRunnable();
                if (C20171rb5.this.B1 != null) {
                    return;
                }
            }
            C20171rb5.this.Z0();
            C20171rb5.this.C1(0);
        }
    }

    /* renamed from: ir.nasim.rb5$e, reason: case insensitive filesystem */
    class ViewOnClickListenerC20176e implements View.OnClickListener {
        ViewOnClickListenerC20176e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C20171rb5.this.Y0.U(C20171rb5.this.Y0.u() - 90, false);
            C20171rb5.this.A0.setOrientation(C20171rb5.this.Y0.u());
            C20171rb5.this.n.invalidate();
        }
    }

    /* renamed from: ir.nasim.rb5$f, reason: case insensitive filesystem */
    class C20177f implements S23.a {
        C20177f() {
        }

        @Override // ir.nasim.S23.a
        public void a(S23 s23, boolean z) {
            if (s23 == C20171rb5.this.Y0 && z && C20171rb5.this.f != null && C20171rb5.this.f.scaleToFill()) {
                if (C20171rb5.this.q1) {
                    C20171rb5.this.B1();
                } else {
                    C20171rb5.this.r1 = true;
                }
            }
        }
    }

    /* renamed from: ir.nasim.rb5$g, reason: case insensitive filesystem */
    class ViewOnClickListenerC20178g implements View.OnClickListener {
        ViewOnClickListenerC20178g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C20171rb5.this.f != null) {
                C20171rb5.this.A.setChecked(C20171rb5.this.f.setPhotoChecked(C20171rb5.this.a1), true);
                C20171rb5.this.H1();
            }
        }
    }

    /* renamed from: ir.nasim.rb5$h, reason: case insensitive filesystem */
    class C20179h implements PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate {
        C20179h() {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
        public void onDoneButtonClicked() {
            C20171rb5.this.d1(true);
        }
    }

    /* renamed from: ir.nasim.rb5$i, reason: case insensitive filesystem */
    class DialogInterfaceOnDismissListenerC20180i implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC20180i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            C20171rb5.this.D0 = null;
        }
    }

    /* renamed from: ir.nasim.rb5$j, reason: case insensitive filesystem */
    class C20181j extends AbstractC9160Yt {
        final /* synthetic */ int a;

        /* renamed from: ir.nasim.rb5$j$a */
        class a extends AbstractC9160Yt {
            a() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C20171rb5.this.B.setVisibility(0);
                C20171rb5.this.k.setVisibility(0);
                if (C20171rb5.this.K0) {
                    C20171rb5.this.E0.setVisibility(C20171rb5.this.E0.getTag() != null ? 0 : 4);
                }
                if (C20171rb5.this.J0 == 0) {
                    C20171rb5.this.A.setVisibility(0);
                }
            }
        }

        C20181j(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C20171rb5.this.W0 == 1) {
                C20171rb5.this.D.setVisibility(8);
                C20171rb5.this.A0.setVisibility(8);
            } else if (C20171rb5.this.W0 == 2) {
                C20171rb5.this.n.removeView(C20171rb5.this.B0);
                C20171rb5.this.B0 = null;
            } else if (C20171rb5.this.W0 == 3) {
                C20171rb5.this.n.removeView(C20171rb5.this.C0);
                C20171rb5.this.C0 = null;
            }
            C20171rb5.this.B1 = null;
            C20171rb5.this.W0 = this.a;
            C20171rb5.this.z1 = 1.0f;
            C20171rb5.this.x1 = 0.0f;
            C20171rb5.this.y1 = 0.0f;
            C20171rb5.this.w1 = 1.0f;
            C20171rb5 c20171rb5 = C20171rb5.this;
            c20171rb5.G1(c20171rb5.w1);
            C20171rb5.this.n.invalidate();
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(C20171rb5.this.B, "translationY", 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(C20171rb5.this.k, "translationY", 0.0f));
            if (C20171rb5.this.K0) {
                arrayList.add(ObjectAnimator.ofFloat(C20171rb5.this.E0, "translationY", 0.0f));
            }
            if (C20171rb5.this.J0 == 0) {
                arrayList.add(ObjectAnimator.ofFloat(C20171rb5.this.A, "alpha", 1.0f));
            }
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(200L);
            animatorSet.addListener(new a());
            animatorSet.start();
        }
    }

    /* renamed from: ir.nasim.rb5$k, reason: case insensitive filesystem */
    class C20182k implements PhotoCropView.PhotoCropViewDelegate {
        C20182k() {
        }

        @Override // ir.nasim.features.media.components.PhotoCropView.PhotoCropViewDelegate
        public Bitmap getBitmap() {
            return C20171rb5.this.Y0.g();
        }

        @Override // ir.nasim.features.media.components.PhotoCropView.PhotoCropViewDelegate
        public void needMoveImageTo(float f, float f2, float f3, boolean z) {
            if (z) {
                C20171rb5.this.X0(f3, f, f2, true);
                return;
            }
            C20171rb5.this.u1 = f;
            C20171rb5.this.v1 = f2;
            C20171rb5.this.w1 = f3;
            C20171rb5.this.n.invalidate();
        }
    }

    /* renamed from: ir.nasim.rb5$l, reason: case insensitive filesystem */
    class C20183l extends AbstractC9160Yt {
        final /* synthetic */ int a;

        /* renamed from: ir.nasim.rb5$l$a */
        class a extends AbstractC9160Yt {
            a() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C20171rb5.this.B1 = null;
                C20183l c20183l = C20183l.this;
                C20171rb5.this.W0 = c20183l.a;
                C20171rb5.this.z1 = 1.0f;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = 0.0f;
                C20171rb5.this.w1 = 1.0f;
                C20171rb5 c20171rb5 = C20171rb5.this;
                c20171rb5.G1(c20171rb5.w1);
                C20171rb5.this.n.invalidate();
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C20171rb5.this.D.setVisibility(0);
                C20171rb5.this.A0.setVisibility(0);
            }
        }

        C20183l(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C20171rb5.this.C1 = null;
            C20171rb5.this.B.setVisibility(8);
            if (C20171rb5.this.K0) {
                C20171rb5.this.E0.setVisibility(4);
            }
            if (C20171rb5.this.J0 == 0) {
                C20171rb5.this.A.setVisibility(8);
            }
            Bitmap bitmapG = C20171rb5.this.Y0.g();
            if (bitmapG != null) {
                C20171rb5.this.A0.setBitmap(bitmapG, C20171rb5.this.Y0.u(), C20171rb5.this.J0 != 1 || ((PhotoViewerAbs) C20171rb5.this).isPurchaseType || ((PhotoViewerAbs) C20171rb5.this).isWallpaperType);
                int i = C20171rb5.this.Y0.i();
                float f = i;
                float fI1 = C20171rb5.this.i1() / f;
                float fH = C20171rb5.this.Y0.h();
                float fG1 = C20171rb5.this.g1() / fH;
                float fJ1 = C20171rb5.this.j1(1) / f;
                float fH1 = C20171rb5.this.h1(1) / fH;
                if (fI1 > fG1) {
                    fI1 = fG1;
                }
                if (fJ1 > fH1) {
                    fJ1 = fH1;
                }
                C20171rb5.this.z1 = fJ1 / fI1;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = (-AbstractC7426Rr.z(24.0f)) + (AbstractC7426Rr.H() / 2);
                C20171rb5.this.A1 = System.currentTimeMillis();
                C20171rb5.this.Z1 = true;
            }
            C20171rb5.this.B1 = new AnimatorSet();
            C20171rb5.this.B1.playTogether(ObjectAnimator.ofFloat(C20171rb5.this.D, "translationY", AbstractC7426Rr.z(48.0f), 0.0f), ObjectAnimator.ofFloat(C20171rb5.this, "animationValue", 0.0f, 1.0f), ObjectAnimator.ofFloat(C20171rb5.this.A0, "alpha", 0.0f, 1.0f));
            C20171rb5.this.B1.setDuration(200L);
            C20171rb5.this.B1.addListener(new a());
            C20171rb5.this.B1.start();
        }
    }

    /* renamed from: ir.nasim.rb5$m, reason: case insensitive filesystem */
    class ViewOnClickListenerC20184m implements View.OnClickListener {
        ViewOnClickListenerC20184m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C20171rb5.this.Z0();
            C20171rb5.this.C1(0);
        }
    }

    /* renamed from: ir.nasim.rb5$n, reason: case insensitive filesystem */
    class ViewOnClickListenerC20185n implements View.OnClickListener {

        /* renamed from: ir.nasim.rb5$n$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C20171rb5.this.C1(0);
            }
        }

        ViewOnClickListenerC20185n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C20171rb5.this.B0.hasChanges()) {
                C20171rb5.this.C1(0);
                return;
            }
            if (C20171rb5.this.h == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(C20171rb5.this.h, AbstractC23035wE5.AlertDialogStyle);
            builder.setMessage(AbstractC12217eE5.DiscardChanges);
            builder.setTitle(AbstractC12217eE5.app_name);
            builder.setPositiveButton(AbstractC12217eE5.OK, new a());
            builder.setNegativeButton(AbstractC12217eE5.Cancel, (DialogInterface.OnClickListener) null);
            C20171rb5.this.showAlertDialog(builder);
        }
    }

    /* renamed from: ir.nasim.rb5$p, reason: case insensitive filesystem */
    class ViewOnClickListenerC20187p implements View.OnClickListener {

        /* renamed from: ir.nasim.rb5$p$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C20171rb5.this.C1(0);
            }
        }

        ViewOnClickListenerC20187p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoPaintView photoPaintView = C20171rb5.this.C0;
            C20171rb5 c20171rb5 = C20171rb5.this;
            photoPaintView.R(c20171rb5, c20171rb5.h, new a());
        }
    }

    /* renamed from: ir.nasim.rb5$r */
    class r extends AbstractC9160Yt {
        r() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C20171rb5.this.z0 == null || !C20171rb5.this.z0.equals(animator)) {
                return;
            }
            C20171rb5.this.k.setVisibility(8);
            if (C20171rb5.this.I0) {
                C20171rb5.this.q.setVisibility(8);
                if (C20171rb5.this.E0.getTag() != null) {
                    C20171rb5.this.E0.setVisibility(4);
                }
            }
            C20171rb5.this.z0 = null;
        }
    }

    /* renamed from: ir.nasim.rb5$s */
    class s implements Runnable {
        s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.F0.setTag(null);
            C20171rb5.this.F0.setVisibility(4);
            C20171rb5.this.G0.setVisibility((C20171rb5.this.q.getVisibility() == 0 || C20171rb5.this.B.getVisibility() == 0) ? 0 : 4);
        }
    }

    /* renamed from: ir.nasim.rb5$t */
    class t implements Runnable {
        final /* synthetic */ ArrayList a;

        t(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C20171rb5.this.n == null || C20171rb5.this.o == null) {
                return;
            }
            C20171rb5.this.n.setLayerType(0, null);
            C20171rb5.this.P0 = 0;
            C20171rb5.this.Q0 = 0L;
            C20171rb5.this.z1();
            C20171rb5.this.n.invalidate();
            C20171rb5.this.p.setVisibility(8);
            if (C20171rb5.this.S0 != null) {
                C20171rb5.this.S0.imageReceiverOld.Z(true, true);
            }
            if (C20171rb5.this.T0 != null) {
                C20171rb5.this.T0.imageReceiverOld.Z(false, true);
            }
            if (this.a == null || C20171rb5.this.J0 == 3) {
                return;
            }
            C20171rb5.this.m.flags = -2147417856;
            C20171rb5.this.m.softInputMode = 272;
            ((WindowManager) C20171rb5.this.h.getSystemService("window")).updateViewLayout(C20171rb5.this.o, C20171rb5.this.m);
            C20171rb5.this.o.setFocusable(true);
            C20171rb5.this.n.setFocusable(true);
        }
    }

    /* renamed from: ir.nasim.rb5$u */
    class u extends AbstractC9160Yt {

        /* renamed from: ir.nasim.rb5$u$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C15225jD4.b().g(false);
                if (C20171rb5.this.R0 != null) {
                    C20171rb5.this.R0.run();
                    C20171rb5.this.R0 = null;
                }
            }
        }

        u() {
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC7426Rr.P(new a());
        }
    }

    /* renamed from: ir.nasim.rb5$v */
    class v implements View.OnApplyWindowInsetsListener {
        v() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            C20171rb5.this.N0 = windowInsets;
            C20171rb5.this.o.requestLayout();
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: ir.nasim.rb5$w */
    class w extends ActionBar.b {

        /* renamed from: ir.nasim.rb5$w$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:37:0x0124, code lost:
            
                if (r0.b == r5.a.a.m2.b) goto L38;
             */
            @Override // android.content.DialogInterface.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(android.content.DialogInterface r6, int r7) {
                /*
                    Method dump skipped, instructions count: 437
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.w.a.onClick(android.content.DialogInterface, int):void");
            }
        }

        w() {
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public boolean a() {
            if (C20171rb5.this.b1 != null) {
                String strQ = C4044Dl2.q(C20171rb5.this.b1);
                if (strQ == null) {
                    strQ = "";
                }
                if (new File(strQ).exists()) {
                    return true;
                }
            } else if (C20171rb5.this.c1 != null) {
                if (C4044Dl2.p(C20171rb5.this.c1, C20171rb5.this.h1 != 0).exists()) {
                    return true;
                }
            }
            return false;
        }

        @Override // ir.nasim.features.media.Actionbar.ActionBar.b
        public void b(int i) {
            File fileP;
            if (i == -1) {
                if (C20171rb5.this.K0 && (C20171rb5.this.H0.isPopupShowing() || C20171rb5.this.H0.isKeyboardVisible())) {
                    C20171rb5.this.d1(false);
                    return;
                } else {
                    C20171rb5.this.closePhoto(true, false);
                    return;
                }
            }
            if (i == 1) {
                if (Build.VERSION.SDK_INT <= 29 && C20171rb5.this.h.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    C21753u45.a.L0(C20171rb5.this.h, 4, C21753u45.d.j, C21753u45.d.m);
                    return;
                }
                if (C20171rb5.this.b1 != null) {
                    String strQ = C4044Dl2.q(C20171rb5.this.b1);
                    fileP = strQ != null ? new File(strQ) : new File("");
                } else if (C20171rb5.this.c1 != null) {
                    fileP = C4044Dl2.p(C20171rb5.this.c1, C20171rb5.this.h1 != 0);
                } else {
                    fileP = null;
                }
                if (fileP != null && fileP.exists()) {
                    C6906Pm2.A(fileP.toString(), C20171rb5.this.h, (C20171rb5.this.b1 == null || !C20171rb5.this.b1.v0()) ? 0 : 1, null, null);
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(C20171rb5.this.h, AbstractC23035wE5.AlertDialogStyle);
                builder.setTitle(AbstractC12217eE5.app_name);
                builder.setPositiveButton(AbstractC12217eE5.OK, (DialogInterface.OnClickListener) null);
                builder.setMessage(AbstractC12217eE5.PleaseDownload);
                C20171rb5.this.showAlertDialog(builder);
                return;
            }
            if (i == 2) {
                if (C20171rb5.this.p2 == null || C20171rb5.this.q2 == null) {
                    return;
                }
                if (C20171rb5.this.o1) {
                    C20171rb5.this.closePhoto(true, false);
                    return;
                }
                C20171rb5.this.U0 = true;
                C20171rb5.this.h.startActivity(C22055ub3.k(C20171rb5.this.p2, C20171rb5.this.h));
                C20171rb5.this.closePhoto(false, false);
                return;
            }
            if (i == 6) {
                if (C20171rb5.this.h == null) {
                    return;
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(C20171rb5.this.h, AbstractC23035wE5.AlertDialogStyle);
                if (C20171rb5.this.b1 == null || !C20171rb5.this.b1.v0()) {
                    builder2.setMessage(AbstractC12217eE5.AreYouSureDeletePhoto);
                } else {
                    builder2.setMessage(AbstractC12217eE5.AreYouSureDeleteVideo);
                }
                builder2.setTitle(AbstractC12217eE5.app_name);
                builder2.setPositiveButton(AbstractC12217eE5.OK, new a());
                builder2.setNegativeButton(AbstractC12217eE5.Cancel, (DialogInterface.OnClickListener) null);
                C20171rb5.this.showAlertDialog(builder2);
                return;
            }
            if (i == 9) {
                C20171rb5.this.d1(true);
                return;
            }
            if (i == 10) {
                C20171rb5.this.s1();
                return;
            }
            if (i == 11) {
                try {
                    AbstractC7426Rr.M(C20171rb5.this.b1, C20171rb5.this.h);
                    C20171rb5.this.closePhoto(false, false);
                    return;
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                    return;
                }
            }
            if (i != 13 || C20171rb5.this.h == null || C20171rb5.this.b1 == null || C20171rb5.this.b1.F() == null) {
                return;
            }
            C20171rb5.this.b1.F().m();
        }
    }

    /* renamed from: ir.nasim.rb5$x */
    class x implements Runnable {
        final /* synthetic */ AnimatorSet a;

        x(AnimatorSet animatorSet) {
            this.a = animatorSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            C15225jD4.b().f(new int[]{C15225jD4.r});
            C15225jD4.b().g(true);
            this.a.start();
        }
    }

    /* renamed from: ir.nasim.rb5$y */
    class y implements Runnable {
        final /* synthetic */ PhotoViewerAbs.PlaceProviderObjectAbs a;

        y(PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs) {
            this.a = placeProviderObjectAbs;
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.U0 = false;
            this.a.imageReceiverOld.Z(false, true);
        }
    }

    /* renamed from: ir.nasim.rb5$z */
    class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C20171rb5.this.C1(0);
        }
    }

    public C20171rb5() {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.y = new N(c5495Jo7.j2());
        this.z = new Paint();
        this.G = new P[3];
        this.I0 = true;
        this.O0 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 8);
        this.P0 = 0;
        this.Q0 = 0L;
        this.R0 = null;
        this.U0 = false;
        this.X0 = new S23();
        this.Y0 = new S23();
        this.Z0 = new S23();
        this.d1 = new String[3];
        this.g1 = null;
        this.n1 = new boolean[]{false, true};
        this.s1 = false;
        this.w1 = 1.0f;
        this.E1 = new DecelerateInterpolator(1.5f);
        this.G1 = 1.0f;
        this.R1 = true;
        this.S1 = false;
        this.U1 = false;
        this.V1 = false;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = true;
        this.Z1 = false;
        this.a2 = false;
        this.b2 = 0;
        this.c2 = null;
        this.d2 = null;
        this.e2 = new ArrayList();
        this.f2 = new HashMap[]{new HashMap(), new HashMap()};
        this.g2 = new ArrayList();
        this.h2 = new HashMap[]{new HashMap(), new HashMap()};
        this.i2 = new ArrayList();
        this.j2 = new ArrayList();
        this.k2 = new ArrayList();
        this.l2 = new ArrayList();
        this.m2 = null;
        this.o2 = false;
        this.z.setColor(c5495Jo7.j2());
    }

    private void A1(S23 s23, int i) {
        AbstractC4761Gl2 abstractC4761Gl2K1;
        C11507d74 c11507d74C;
        C8610Ws c8610Ws;
        String str;
        String str2;
        s23.U(0, false);
        if (!this.l2.isEmpty()) {
            s23.V(null);
            if (i < 0 || i >= this.l2.size()) {
                s23.O(null);
                return;
            }
            Object obj = this.l2.get(i);
            int iG = (int) (AbstractC7426Rr.G() / AbstractC7426Rr.B());
            Bitmap thumbForPhoto = this.g1;
            if (thumbForPhoto == null || s23 != this.Y0) {
                thumbForPhoto = null;
            }
            if (thumbForPhoto == null) {
                thumbForPhoto = this.f.getThumbForPhoto(i);
            }
            if (obj instanceof AbstractC14815iX3.b) {
                AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) obj;
                if (bVar.D) {
                    str = bVar.A;
                    str2 = null;
                } else {
                    str = bVar.c;
                    if (str == null) {
                        s23.U(bVar.B, false);
                        str = bVar.A;
                    }
                    str2 = String.format(Locale.US, "%d_%d", Integer.valueOf(iG), Integer.valueOf(iG));
                }
            } else {
                str = null;
                str2 = null;
            }
            s23.N(str, str2, thumbForPhoto != null ? new BitmapDrawable((Resources) null, thumbForPhoto) : null, null, 0);
            return;
        }
        int[] iArr = new int[1];
        AbstractC4761Gl2 abstractC4761Gl2K12 = k1(i, iArr);
        if (abstractC4761Gl2K12 != null) {
            C11507d74 c11507d74 = !this.g2.isEmpty() ? (C11507d74) this.g2.get(i) : null;
            s23.V(c11507d74);
            if (c11507d74 != null) {
                s23.X(true);
            }
            if (c11507d74 != null && c11507d74.v0()) {
                s23.T(true);
                ArrayList arrayList = c11507d74.z;
                if (arrayList == null || arrayList.isEmpty()) {
                    s23.P(this.h.getResources().getDrawable(KB5.photoview_placeholder));
                    return;
                }
                Bitmap bitmap = this.g1;
                if (bitmap == null || s23 != this.Y0) {
                    bitmap = null;
                }
                s23.M(null, null, null, bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null, C4044Dl2.h(c11507d74.z, 100).b, "b", 0, null, true);
                return;
            }
            if (c11507d74 != null && (c8610Ws = this.L0) != null) {
                s23.P(c8610Ws);
                this.L0.T(this.n);
                return;
            }
            s23.T(false);
            Bitmap bitmap2 = this.g1;
            if (bitmap2 == null || s23 != this.Y0) {
                bitmap2 = null;
            }
            if (iArr[0] == 0) {
                iArr[0] = -1;
            }
            H95 h95H = c11507d74 != null ? C4044Dl2.h(c11507d74.z, 100) : null;
            s23.M(abstractC4761Gl2K12, null, null, bitmap2 != null ? new BitmapDrawable((Resources) null, bitmap2) : null, h95H != null ? h95H.b : null, "b", iArr[0], null, this.h1 != 0);
            return;
        }
        if (i < 0 || this.g2.isEmpty() || i >= this.g2.size()) {
            abstractC4761Gl2K1 = null;
            c11507d74C = null;
        } else {
            c11507d74C = AbstractC24061xy6.c((J44) this.g2.get(i), true);
            if (c11507d74C != null) {
                this.g2.set(i, c11507d74C);
                abstractC4761Gl2K1 = k1(i, iArr);
            } else {
                abstractC4761Gl2K1 = null;
            }
        }
        if (c11507d74C == null || abstractC4761Gl2K1 == null) {
            s23.T(false);
            s23.V(null);
            if (iArr[0] == 0) {
                s23.O(null);
                return;
            } else {
                s23.P(this.h.getResources().getDrawable(KB5.photoview_placeholder));
                return;
            }
        }
        s23.V(c11507d74C);
        s23.X(true);
        if (c11507d74C.v0()) {
            s23.T(true);
            ArrayList arrayList2 = c11507d74C.z;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                s23.P(this.h.getResources().getDrawable(KB5.photoview_placeholder));
                return;
            }
            Bitmap bitmap3 = this.g1;
            if (bitmap3 == null || s23 != this.Y0) {
                bitmap3 = null;
            }
            s23.M(null, null, null, bitmap3 != null ? new BitmapDrawable((Resources) null, bitmap3) : null, C4044Dl2.h(c11507d74C.z, 100).b, "b", 0, null, true);
            return;
        }
        C8610Ws c8610Ws2 = this.L0;
        if (c8610Ws2 != null) {
            s23.P(c8610Ws2);
            this.L0.T(this.n);
            return;
        }
        s23.T(false);
        Bitmap bitmap4 = this.g1;
        if (bitmap4 == null || s23 != this.Y0) {
            bitmap4 = null;
        }
        if (iArr[0] == 0) {
            iArr[0] = -1;
        }
        H95 h95H2 = C4044Dl2.h(c11507d74C.z, 100);
        s23.M(abstractC4761Gl2K12, null, null, bitmap4 != null ? new BitmapDrawable((Resources) null, bitmap4) : null, h95H2 != null ? h95H2.b : null, "b", iArr[0], null, this.h1 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1() {
        float fI = this.Y0.i();
        float fI1 = i1();
        float fH = this.Y0.h();
        float fG1 = g1();
        float fMin = Math.min(fG1 / fH, fI1 / fI);
        float fMax = Math.max(fI1 / ((int) (fI * fMin)), fG1 / ((int) (fH * fMin)));
        this.w1 = fMax;
        G1(fMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(int i) {
        if (this.W0 != i && this.Y0.g() != null && this.C1 == null && this.B1 == null && this.G[0].h == -1) {
            if (i == 0) {
                if (this.W0 == 2 && this.B0.getToolsView().getVisibility() != 0) {
                    this.B0.switchToOrFromEditMode();
                    return;
                }
                if (this.Y0.g() != null) {
                    int i2 = this.Y0.i();
                    float f = i2;
                    float fI1 = i1() / f;
                    float fH = this.Y0.h();
                    float fG1 = g1() / fH;
                    float fJ1 = j1(0) / f;
                    float fH1 = h1(0) / fH;
                    if (fI1 > fG1) {
                        fI1 = fG1;
                    }
                    if (fJ1 > fH1) {
                        fJ1 = fH1;
                    }
                    this.z1 = fJ1 / fI1;
                    this.x1 = 0.0f;
                    int i3 = this.W0;
                    if (i3 == 1) {
                        this.y1 = AbstractC7426Rr.z(24.0f);
                    } else if (i3 == 2) {
                        this.y1 = AbstractC7426Rr.z(62.0f);
                    } else if (i3 == 3) {
                        this.y1 = (AbstractC7426Rr.z(48.0f) - ActionBar.getCurrentActionBarHeight()) / 2;
                    }
                    this.y1 -= AbstractC7426Rr.H() / 2;
                    this.A1 = System.currentTimeMillis();
                    this.Z1 = true;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                this.B1 = animatorSet;
                int i4 = this.W0;
                if (i4 == 1) {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.D, "translationY", AbstractC7426Rr.z(48.0f)), ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.A0, "alpha", 0.0f));
                } else if (i4 == 2) {
                    this.B0.shutdown();
                    this.B1.playTogether(ObjectAnimator.ofFloat(this.B0.getToolsView(), "translationY", AbstractC7426Rr.z(126.0f)), ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f));
                } else if (i4 == 3) {
                    this.C0.b0();
                    this.B1.playTogether(ObjectAnimator.ofFloat(this.C0.getToolsView(), "translationY", AbstractC7426Rr.z(126.0f)), ObjectAnimator.ofFloat(this.C0.getColorPicker(), "translationX", AbstractC7426Rr.z(60.0f)), ObjectAnimator.ofFloat(this.C0.getActionBar(), "translationY", (-ActionBar.getCurrentActionBarHeight()) - AbstractC7426Rr.H()), ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f));
                }
                this.B1.setDuration(200L);
                this.B1.addListener(new C20181j(i));
                this.B1.start();
                return;
            }
            if (i == 1) {
                PhotoCropView photoCropView = new PhotoCropView(this.i);
                this.A0 = photoCropView;
                photoCropView.setVisibility(8);
                this.n.addView(this.A0, C14433hu3.b(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
                this.A0.setDelegate(new C20182k());
                this.D.doneButton.setText(AbstractC12217eE5.Crop);
                this.D.doneButton.setTextColor(C5495Jo7.a.t2());
                this.C1 = new AnimatorSet();
                ArrayList arrayList = new ArrayList();
                arrayList.add(ObjectAnimator.ofFloat(this.B, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                arrayList.add(ObjectAnimator.ofFloat(this.k, "translationY", 0.0f, -r6.getHeight()));
                if (this.K0) {
                    arrayList.add(ObjectAnimator.ofFloat(this.E0, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                }
                if (this.J0 == 0) {
                    arrayList.add(ObjectAnimator.ofFloat(this.A, "alpha", 1.0f, 0.0f));
                }
                this.C1.playTogether(arrayList);
                this.C1.setDuration(200L);
                this.C1.addListener(new C20183l(i));
                this.C1.start();
                return;
            }
            if (i == 2) {
                if (this.B0 == null) {
                    PhotoFilterView photoFilterView = new PhotoFilterView(this.h, this.Y0.g(), this.Y0.u());
                    this.B0 = photoFilterView;
                    this.n.addView(photoFilterView, C14433hu3.a(-1, -1.0f));
                    this.B0.getDoneTextView().setOnClickListener(new ViewOnClickListenerC20184m());
                    this.B0.getCancelTextView().setOnClickListener(new ViewOnClickListenerC20185n());
                    this.B0.getToolsView().setTranslationY(AbstractC7426Rr.z(126.0f));
                }
                this.C1 = new AnimatorSet();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(ObjectAnimator.ofFloat(this.B, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                arrayList2.add(ObjectAnimator.ofFloat(this.k, "translationY", 0.0f, -r6.getHeight()));
                if (this.K0) {
                    arrayList2.add(ObjectAnimator.ofFloat(this.E0, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                }
                if (this.J0 == 0) {
                    arrayList2.add(ObjectAnimator.ofFloat(this.A, "alpha", 1.0f, 0.0f));
                }
                this.C1.playTogether(arrayList2);
                this.C1.setDuration(200L);
                this.C1.addListener(new C20186o(i));
                this.C1.start();
                return;
            }
            if (i == 3) {
                if (this.C0 == null) {
                    PhotoPaintView photoPaintView = new PhotoPaintView(this.h, this.Y0.g(), this.Y0.u());
                    this.C0 = photoPaintView;
                    this.n.addView(photoPaintView, C14433hu3.a(-1, -1.0f));
                    this.C0.getDoneTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.S95
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.a.p1(view);
                        }
                    });
                    this.C0.getCancelTextView().setOnClickListener(new ViewOnClickListenerC20187p());
                    this.C0.getToolsView().setTranslationY(AbstractC7426Rr.z(126.0f));
                    this.C0.getActionBar().setTranslationY((-ActionBar.getCurrentActionBarHeight()) - AbstractC7426Rr.H());
                }
                this.C1 = new AnimatorSet();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(ObjectAnimator.ofFloat(this.B, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                arrayList3.add(ObjectAnimator.ofFloat(this.k, "translationY", 0.0f, -r6.getHeight()));
                if (this.K0) {
                    arrayList3.add(ObjectAnimator.ofFloat(this.E0, "translationY", 0.0f, AbstractC7426Rr.z(96.0f)));
                }
                if (this.J0 == 0) {
                    arrayList3.add(ObjectAnimator.ofFloat(this.A, "alpha", 1.0f, 0.0f));
                }
                this.C1.playTogether(arrayList3);
                this.C1.setDuration(50L);
                this.C1.addListener(new q(i));
                this.C1.start();
            }
        }
    }

    private void D1(boolean z2, boolean z3) {
        if (z2) {
            this.k.setVisibility(0);
            if (this.I0) {
                this.q.setVisibility(0);
                if (this.E0.getTag() != null) {
                    this.E0.setVisibility(0);
                }
            }
        }
        this.l = z2;
        this.k.setEnabled(z2);
        this.q.setEnabled(z2);
        if (z3) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.k, "alpha", z2 ? 1.0f : 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.q, "alpha", z2 ? 1.0f : 0.0f));
            if (this.E0.getTag() != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.E0, "alpha", z2 ? 1.0f : 0.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.z0 = animatorSet;
            animatorSet.playTogether(arrayList);
            if (!z2) {
                this.z0.addListener(new r());
            }
            this.z0.setDuration(200L);
            this.z0.start();
            return;
        }
        this.k.setAlpha(z2 ? 1.0f : 0.0f);
        this.q.setAlpha(z2 ? 1.0f : 0.0f);
        if (this.E0.getTag() != null) {
            this.E0.setAlpha(z2 ? 1.0f : 0.0f);
        }
        if (z2) {
            return;
        }
        this.k.setVisibility(8);
        if (this.I0) {
            this.q.setVisibility(8);
            if (this.E0.getTag() != null) {
                this.E0.setVisibility(4);
            }
        }
    }

    private void E1(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.B, "alpha", z2 ? 1.0f : 0.0f));
        if (this.K0) {
            arrayList.add(ObjectAnimator.ofFloat(this.E0, "alpha", z2 ? 1.0f : 0.0f));
        }
        if (this.J0 == 0) {
            arrayList.add(ObjectAnimator.ofFloat(this.A, "alpha", z2 ? 1.0f : 0.0f));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private void F1(Object obj) {
        boolean z2;
        CharSequence charSequence;
        if (obj instanceof AbstractC14815iX3.b) {
            AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) obj;
            charSequence = bVar.a;
            z2 = bVar.D;
        } else {
            z2 = false;
            charSequence = null;
        }
        this.o2 = z2;
        if (charSequence == null || charSequence.length() == 0) {
            this.H0.setFieldText("");
        } else {
            this.H0.setFieldText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(float f) {
        int iQ = ((int) ((this.Y0.q() * f) - i1())) / 2;
        int iO = ((int) ((this.Y0.o() * f) - g1())) / 2;
        if (iQ > 0) {
            this.N1 = -iQ;
            this.O1 = iQ;
        } else {
            this.O1 = 0.0f;
            this.N1 = 0.0f;
        }
        if (iO > 0) {
            this.P1 = -iO;
            this.Q1 = iO;
        } else {
            this.Q1 = 0.0f;
            this.P1 = 0.0f;
        }
        if (this.W0 == 1) {
            this.O1 += this.A0.getLimitX();
            this.Q1 += this.A0.getLimitY();
            this.N1 -= this.A0.getLimitWidth();
            this.P1 -= this.A0.getLimitHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs = this.f;
        if (photoViewerProviderAbs == null) {
            return;
        }
        this.B.updateSelectedCount(photoViewerProviderAbs.getSelectedCount(), false);
    }

    private boolean I1(int i, String str) {
        if (this.d1[i] == null) {
            return false;
        }
        int i2 = this.a1;
        if (i == 1) {
            i2++;
        } else if (i == 2) {
            i2--;
        }
        if (this.b1 == null || this.g2.get(i2) == null || !((C11507d74) this.g2.get(i2)).v0()) {
            return false;
        }
        ((C11507d74) this.g2.get(i2)).y = str;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(float f, float f2, float f3, boolean z2) {
        Y0(f, f2, f3, z2, Type.TSIG);
    }

    private void Y0(float f, float f2, float f3, boolean z2, int i) {
        if (this.w1 == f && this.u1 == f2 && this.v1 == f3) {
            return;
        }
        this.Z1 = z2;
        this.z1 = f;
        this.x1 = f2;
        this.y1 = f3;
        this.A1 = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.B1 = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f));
        this.B1.setInterpolator(this.E1);
        this.B1.setDuration(i);
        this.B1.addListener(new G());
        this.B1.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs;
        int i = this.W0;
        Bitmap bitmap = i == 1 ? this.A0.getBitmap() : i == 2 ? this.B0.getBitmap() : i == 3 ? this.C0.getBitmap() : null;
        if (bitmap != null) {
            H95 h95E0 = C17481n23.e0(bitmap, AbstractC7426Rr.G(), AbstractC7426Rr.G(), 80, false, 101, 101, null, null);
            if (h95E0 != null) {
                Object obj = this.l2.get(this.a1);
                boolean z2 = obj instanceof AbstractC14815iX3.b;
                if (z2) {
                    AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) obj;
                    bVar.c = C4044Dl2.p(h95E0, true).toString();
                    H95 h95E02 = C17481n23.e0(bitmap, AbstractC7426Rr.z(120.0f), AbstractC7426Rr.z(120.0f), 70, false, 101, 101, null, null);
                    if (h95E02 != null) {
                        bVar.b = C4044Dl2.p(h95E02, true).toString();
                    }
                }
                if (this.J0 == 0 && (photoViewerProviderAbs = this.f) != null) {
                    photoViewerProviderAbs.updatePhotoAtIndex(this.a1);
                    if (!this.f.isPhotoChecked(this.a1)) {
                        this.A.setChecked(this.f.setPhotoChecked(this.a1), true);
                        H1();
                    }
                    if (z2) {
                        AbstractC14815iX3.b bVar2 = (AbstractC14815iX3.b) obj;
                        this.f.onPathChanged(this.a1, bVar2.c, bVar2);
                    }
                }
                if (this.W0 == 1) {
                    float rectSizeX = this.A0.getRectSizeX() / i1();
                    float rectSizeY = this.A0.getRectSizeY() / g1();
                    if (rectSizeX <= rectSizeY) {
                        rectSizeX = rectSizeY;
                    }
                    this.w1 = rectSizeX;
                    this.u1 = (this.A0.getRectX() + (this.A0.getRectSizeX() / 2.0f)) - (i1() / 2);
                    this.v1 = (this.A0.getRectY() + (this.A0.getRectSizeY() / 2.0f)) - (g1() / 2);
                    this.Z1 = true;
                }
                this.Y0.W(null);
                this.Y0.U(0, true);
                this.Y0.O(bitmap);
                this.Y0.W(this.n);
            }
        }
    }

    private boolean a1() {
        if (this.P0 != 0 && Math.abs(this.Q0 - System.currentTimeMillis()) >= 500) {
            Runnable runnable = this.R0;
            if (runnable != null) {
                runnable.run();
                this.R0 = null;
            }
            this.P0 = 0;
        }
        return this.P0 != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[PHI: r3
      0x0022: PHI (r3v4 float) = (r3v2 float), (r3v3 float) binds: [B:9:0x0020, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011 A[PHI: r3
      0x0011: PHI (r3v5 float) = (r3v0 float), (r3v1 float) binds: [B:3:0x000f, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b1(boolean r6) {
        /*
            r5 = this;
            float r0 = r5.u1
            float r1 = r5.v1
            float r2 = r5.w1
            r5.G1(r2)
            float r2 = r5.u1
            float r3 = r5.N1
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L13
        L11:
            r0 = r3
            goto L1a
        L13:
            float r3 = r5.O1
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L11
        L1a:
            float r2 = r5.v1
            float r3 = r5.P1
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
        L22:
            r1 = r3
            goto L2b
        L24:
            float r3 = r5.Q1
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L2b
            goto L22
        L2b:
            float r2 = r5.w1
            r5.X0(r2, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.b1(boolean):void");
    }

    private void c1(int i, boolean z2) {
        if (this.d1[i] == null) {
            this.G[i].d(-1, z2);
            return;
        }
        int i2 = this.a1;
        boolean z3 = true;
        if (i == 1) {
            i2++;
        } else if (i == 2) {
            i2--;
        }
        File file = null;
        if (this.b1 != null) {
            C11507d74 c11507d74 = (C11507d74) this.g2.get(i2);
            if (!TextUtils.isEmpty(c11507d74.y)) {
                File file2 = new File(c11507d74.y);
                if (file2.exists()) {
                    file = file2;
                }
            }
            if (file == null) {
                String strQ = C4044Dl2.q(c11507d74);
                c11507d74.y = strQ;
                if (strQ == null) {
                    strQ = "";
                }
                file = new File(strQ);
            }
        } else if (this.c1 != null) {
            file = C4044Dl2.p((AbstractC4761Gl2) this.i2.get(i2), this.h1 != 0);
        } else if (this.f1 != null) {
            file = new File(C4044Dl2.m().j(3), this.d1[i]);
            if (!file.exists()) {
                file = new File(C4044Dl2.m().j(4), this.d1[i]);
            }
        }
        if (file == null || !file.exists()) {
            this.G[i].d(0, z2);
            Float fQ = C17481n23.T().Q(this.d1[i]);
            if (fQ == null) {
                fQ = Float.valueOf(0.0f);
            }
            this.G[i].e(fQ.floatValue(), false);
        } else {
            this.G[i].d(-1, z2);
        }
        if (i == 0) {
            if (this.l2.isEmpty() && (this.d1[0] == null || this.G[0].h == 0)) {
                z3 = false;
            }
            this.R1 = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(boolean z2) {
        int i = this.a1;
        if (i < 0 || i >= this.l2.size()) {
            return;
        }
        Object obj = this.l2.get(this.a1);
        if (z2) {
            if (obj instanceof AbstractC14815iX3.b) {
                ((AbstractC14815iX3.b) obj).a = this.H0.getFieldCharSequence();
            }
            if (this.H0.getFieldCharSequence().length() != 0 && !this.f.isPhotoChecked(this.a1)) {
                this.A.setChecked(this.f.setPhotoChecked(this.a1), true);
                H1();
            }
        }
        PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs = this.f;
        if (photoViewerProviderAbs != null) {
            photoViewerProviderAbs.onCaptionChanged(this.a1, this.H0.getFieldCharSequence());
        }
        if (!(obj instanceof AbstractC14815iX3.b) || !((AbstractC14815iX3.b) obj).D) {
            this.J.setVisibility(0);
            this.H.setVisibility(0);
            this.Y.setVisibility(0);
        }
        if (this.J0 == 0) {
            this.A.setVisibility(0);
        }
        this.Z.setVisibility(8);
        this.B.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H0.getLayoutParams();
        layoutParams.bottomMargin = -AbstractC7426Rr.z(400.0f);
        this.H0.setLayoutParams(layoutParams);
        String str = this.V0;
        if (str != null) {
            this.k.setTitle(str);
            this.V0 = null;
        }
        F1(obj);
        x1(this.H0.getFieldCharSequence());
        if (this.H0.isPopupShowing()) {
            this.H0.hidePopup();
        } else {
            this.H0.closeKeyboard();
        }
    }

    private int e1() {
        int i = this.W0;
        if (i == 0 || i == 3) {
            return 0;
        }
        return AbstractC7426Rr.z(14.0f);
    }

    private int f1() {
        int iZ;
        int iH;
        int i = this.W0;
        if (i == 3) {
            iZ = ActionBar.getCurrentActionBarHeight();
            iH = AbstractC7426Rr.H();
        } else {
            if (i == 0) {
                return 0;
            }
            iZ = AbstractC7426Rr.z(14.0f);
            iH = AbstractC7426Rr.H();
        }
        return iZ + iH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g1() {
        return h1(this.W0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h1(int i) {
        int iZ;
        int iH = AbstractC7426Rr.C().y;
        if (i == 0) {
            iH += AbstractC7426Rr.H();
        }
        if (i == 1) {
            iZ = AbstractC7426Rr.z(76.0f);
        } else if (i == 2) {
            iZ = AbstractC7426Rr.z(154.0f);
        } else {
            if (i != 3) {
                return iH;
            }
            iZ = AbstractC7426Rr.z(48.0f) + ActionBar.getCurrentActionBarHeight();
        }
        return iH - iZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i1() {
        return j1(this.W0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j1(int i) {
        int width = this.n.getWidth();
        return (i == 0 || i == 3) ? width : width - AbstractC7426Rr.z(28.0f);
    }

    private AbstractC4761Gl2 k1(int i, int[] iArr) {
        if (i < 0) {
            return null;
        }
        if (!this.i2.isEmpty()) {
            if (i >= this.i2.size()) {
                return null;
            }
            iArr[0] = ((Integer) this.k2.get(i)).intValue();
            return (AbstractC4761Gl2) this.i2.get(i);
        }
        if (this.g2.isEmpty() || i >= this.g2.size()) {
            return null;
        }
        C11507d74 c11507d74 = (C11507d74) this.g2.get(i);
        if (c11507d74.u0() || c11507d74.v0()) {
            H95 h95H = C4044Dl2.h(c11507d74.z, AbstractC7426Rr.G());
            if (h95H != null) {
                int i2 = h95H.e;
                iArr[0] = i2;
                if (i2 == 0) {
                    iArr[0] = -1;
                }
                return h95H.b;
            }
            iArr[0] = -1;
        }
        return null;
    }

    private String l1(int i) {
        if (i < 0) {
            return null;
        }
        if (!this.i2.isEmpty() || !this.g2.isEmpty()) {
            if (this.i2.isEmpty()) {
                if (this.g2.isEmpty() || i >= this.g2.size()) {
                    return null;
                }
                return C4044Dl2.n((C11507d74) this.g2.get(i));
            }
            if (i >= this.i2.size()) {
                return null;
            }
            AbstractC4761Gl2 abstractC4761Gl2 = (AbstractC4761Gl2) this.i2.get(i);
            return abstractC4761Gl2.b + "_" + abstractC4761Gl2.c + ".jpg";
        }
        if (this.l2.isEmpty() || i >= this.l2.size()) {
            return null;
        }
        this.l2.get(i);
        return null;
    }

    private void m1() {
        float fI1 = this.w1 != 1.0f ? ((i1() - this.Y0.q()) / 2) * this.w1 : 0.0f;
        this.b2 = 1;
        X0(this.w1, ((this.N1 - i1()) - fI1) - (AbstractC7426Rr.z(30.0f) / 2), this.v1, false);
    }

    private void n1() {
        float fI1 = this.w1 != 1.0f ? ((i1() - this.Y0.q()) / 2) * this.w1 : 0.0f;
        this.b2 = 2;
        X0(this.w1, this.O1 + i1() + fI1 + (AbstractC7426Rr.z(30.0f) / 2), this.v1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(View view) {
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(View view) {
        Z0();
        C1(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs) {
        this.g = false;
        this.U0 = true;
        this.b1 = null;
        this.c1 = null;
        this.f1 = null;
        this.g1 = null;
        C8610Ws c8610Ws = this.L0;
        if (c8610Ws != null) {
            c8610Ws.T(null);
            this.L0 = null;
        }
        for (int i = 0; i < 3; i++) {
            P p = this.G[i];
            if (p != null) {
                p.d(-1, false);
            }
        }
        this.Y0.O(null);
        this.X0.O(null);
        this.Z0.O(null);
        this.n.post(new E());
        PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs = this.f;
        if (photoViewerProviderAbs != null) {
            photoViewerProviderAbs.willHidePhotoViewer();
        }
        this.f = null;
        this.U0 = false;
        if (placeProviderObjectAbs != null) {
            placeProviderObjectAbs.imageReceiverOld.Z(true, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r1(ir.nasim.C11507d74 r17, ir.nasim.AbstractC4761Gl2 r18, java.util.ArrayList r19, java.util.ArrayList r20, int r21, ir.nasim.features.media.components.PhotoViewerAbs.PlaceProviderObjectAbs r22) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.r1(ir.nasim.d74, ir.nasim.Gl2, java.util.ArrayList, java.util.ArrayList, int, ir.nasim.features.media.components.PhotoViewerAbs$PlaceProviderObjectAbs):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        File fileP;
        boolean zV0;
        if (this.h == null || !this.M0) {
            return;
        }
        try {
            C11507d74 c11507d74 = this.b1;
            if (c11507d74 != null) {
                zV0 = c11507d74.v0();
                String strQ = C4044Dl2.q(this.b1);
                fileP = strQ != null ? new File(strQ) : new File("");
            } else {
                AbstractC4761Gl2 abstractC4761Gl2 = this.c1;
                if (abstractC4761Gl2 != null) {
                    fileP = C4044Dl2.p(abstractC4761Gl2, this.h1 != 0);
                } else {
                    fileP = null;
                }
                zV0 = false;
            }
            if (fileP == null || !fileP.exists()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.h, AbstractC23035wE5.AlertDialogStyle);
                builder.setTitle(AbstractC12217eE5.app_name);
                builder.setPositiveButton(AbstractC12217eE5.OK, (DialogInterface.OnClickListener) null);
                builder.setMessage(AbstractC12217eE5.PleaseDownload);
                showAlertDialog(builder);
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (zV0) {
                intent.setType("video/mp4");
            } else {
                intent.setType("image/jpeg");
            }
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", FileProvider.h(this.i, this.i.getApplicationContext().getPackageName() + ".provider", fileP));
            this.h.startActivityForResult(Intent.createChooser(intent, C5721Ko.b.getString(AbstractC12217eE5.menu_share)), SIPTransactionStack.BASE_TIMER_INTERVAL);
            closePhoto(false, true);
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:133:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02fc A[PHI: r2
      0x02fc: PHI (r2v39 float) = (r2v34 float), (r2v35 float) binds: [B:164:0x02fa, B:167:0x0302] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x030b A[PHI: r2
      0x030b: PHI (r2v38 float) = (r2v36 float), (r2v37 float) binds: [B:170:0x0309, B:173:0x0311] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d1 A[PHI: r3
      0x03d1: PHI (r3v6 float) = (r3v1 float), (r3v2 float) binds: [B:214:0x03cf, B:217:0x03d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03e2 A[PHI: r3
      0x03e2: PHI (r3v5 float) = (r3v3 float), (r3v4 float) binds: [B:220:0x03e0, B:223:0x03e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean t1(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.t1(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        if (this.B1 == null && this.C1 == null) {
            this.H.setVisibility(8);
            this.J.setVisibility(8);
            this.Y.setVisibility(8);
            this.A.setVisibility(8);
            this.Z.setVisibility(0);
            this.B.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H0.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.H0.setLayoutParams(layoutParams);
            this.E0.setVisibility(4);
            this.H0.openKeyboard();
            this.V0 = this.k.getTitle();
            if (this.o2) {
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.VideoCaption));
            } else {
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.PhotoCaption));
            }
        }
    }

    private boolean v1(C11507d74 c11507d74, AbstractC4761Gl2 abstractC4761Gl2, ArrayList arrayList, ArrayList arrayList2, int i, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType, long j) {
        if (this.h != null && !this.g && ((photoViewerProviderAbs != null || !a1()) && (c11507d74 != null || abstractC4761Gl2 != null || arrayList != null || arrayList2 != null))) {
            PhotoViewerAbs.PlaceProviderObjectAbs placeForPhoto = photoViewerProviderAbs.getPlaceForPhoto(i);
            if (placeForPhoto == null && arrayList2 == null) {
                return false;
            }
            WindowManager windowManager = (WindowManager) this.h.getSystemService("window");
            if (this.p1) {
                try {
                    windowManager.removeView(this.o);
                } catch (Exception unused) {
                }
            }
            try {
                WindowManager.LayoutParams layoutParams = this.m;
                layoutParams.type = 99;
                layoutParams.flags = -2147417848;
                layoutParams.softInputMode = 272;
                this.o.setFocusable(false);
                this.n.setFocusable(false);
                windowManager.addView(this.o, this.m);
                this.p2 = c11458d25;
                this.q2 = exPeerType;
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, 1, 1));
                C15225jD4.b().a(this, C15225jD4.v);
                C15225jD4.b().a(this, C15225jD4.u);
                C15225jD4.b().a(this, C15225jD4.t);
                C15225jD4.b().a(this, C15225jD4.r);
                C15225jD4.b().a(this, C15225jD4.i);
                this.f = photoViewerProviderAbs;
                this.i1 = j;
                if (this.c2 == null) {
                    this.c2 = VelocityTracker.obtain();
                }
                this.g = true;
                D1(true, false);
                if (placeForPhoto != null) {
                    this.U0 = true;
                    this.P0 = 1;
                    if (c11507d74 != null) {
                        this.L0 = placeForPhoto.imageReceiverOld.f();
                    }
                    r1(c11507d74, abstractC4761Gl2, arrayList, arrayList2, i, placeForPhoto);
                    Rect rectK = placeForPhoto.imageReceiverOld.k();
                    int iU = placeForPhoto.imageReceiverOld.u();
                    int iE = placeForPhoto.imageReceiverOld.e();
                    if (iE != 0) {
                        iU = iE;
                    }
                    this.p.setVisibility(0);
                    this.p.setRadius(placeForPhoto.radiusAll);
                    this.p.setOrientation(iU);
                    this.p.setNeedRadius(placeForPhoto.radiusAll != 0);
                    this.p.setImageBitmap(placeForPhoto.thumbBitmap);
                    this.p.setAlpha(1.0f);
                    this.p.setPivotX(0.0f);
                    this.p.setPivotY(0.0f);
                    this.p.setScaleX(placeForPhoto.scale);
                    this.p.setScaleY(placeForPhoto.scale);
                    this.p.setTranslationX(placeForPhoto.viewX + (rectK.left * placeForPhoto.scale));
                    this.p.setTranslationY(placeForPhoto.viewY + (rectK.top * placeForPhoto.scale));
                    ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
                    layoutParams2.width = rectK.right - rectK.left;
                    layoutParams2.height = rectK.bottom - rectK.top;
                    this.p.setLayoutParams(layoutParams2);
                    float f = AbstractC7426Rr.C().x / AbstractC7426Rr.C().y;
                    float fH = (AbstractC7426Rr.C().y + AbstractC7426Rr.H()) / AbstractC7426Rr.C().x;
                    if (f > fH) {
                        f = fH;
                    }
                    if (f >= Float.MAX_VALUE) {
                        f = Float.MAX_VALUE;
                    }
                    float f2 = (AbstractC7426Rr.C().x - (layoutParams2.width * f)) / 2.0f;
                    float fH2 = ((AbstractC7426Rr.C().y + AbstractC7426Rr.H()) - (layoutParams2.height * f)) / 2.0f;
                    int iAbs = Math.abs(rectK.left - placeForPhoto.imageReceiverOld.r());
                    int iAbs2 = Math.abs(rectK.top - placeForPhoto.imageReceiverOld.s());
                    int[] iArr = new int[2];
                    placeForPhoto.parentView.getLocationInWindow(iArr);
                    int i2 = iArr[1];
                    int i3 = placeForPhoto.viewY;
                    int i4 = rectK.top;
                    int i5 = (i2 - (i3 + i4)) + placeForPhoto.clipTopAddition;
                    int i6 = i5 < 0 ? 0 : i5;
                    int height = (((i3 + i4) + layoutParams2.height) - (i2 + placeForPhoto.parentView.getHeight())) + placeForPhoto.clipBottomAddition;
                    if (height < 0) {
                        height = 0;
                    }
                    int iMax = Math.max(i6, iAbs2);
                    int iMax2 = Math.max(height, iAbs2);
                    this.O0[0][0] = this.p.getScaleX();
                    this.O0[0][1] = this.p.getScaleY();
                    this.O0[0][2] = this.p.getTranslationX();
                    this.O0[0][3] = this.p.getTranslationY();
                    float[] fArr = this.O0[0];
                    float f3 = placeForPhoto.scale;
                    fArr[4] = iAbs * f3;
                    fArr[5] = iMax * f3;
                    fArr[6] = iMax2 * f3;
                    fArr[7] = this.p.getRadius();
                    float[] fArr2 = this.O0[1];
                    fArr2[0] = f;
                    fArr2[1] = f;
                    fArr2[2] = f2;
                    fArr2[3] = fH2;
                    fArr2[4] = 0.0f;
                    fArr2[5] = 0.0f;
                    fArr2[6] = 0.0f;
                    fArr2[7] = 0.0f;
                    this.p.setAnimationProgress(0.0f);
                    this.y.setAlpha(0);
                    this.n.setAlpha(0.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.p, "animationProgress", 0.0f, 1.0f), ObjectAnimator.ofInt(this.y, "alpha", 0, 255), ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f));
                    this.R0 = new t(arrayList2);
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new u());
                    this.Q0 = System.currentTimeMillis();
                    AbstractC7426Rr.P(new x(animatorSet));
                    this.n.setLayerType(2, null);
                    this.y.a = new y(placeForPhoto);
                } else {
                    if (arrayList2 != null && this.J0 != 3) {
                        WindowManager.LayoutParams layoutParams3 = this.m;
                        layoutParams3.flags = -2147417856;
                        layoutParams3.softInputMode = 272;
                        windowManager.updateViewLayout(this.o, layoutParams3);
                        this.o.setFocusable(true);
                        this.n.setFocusable(true);
                    }
                    this.y.setAlpha(255);
                    this.n.setAlpha(1.0f);
                    r1(c11507d74, abstractC4761Gl2, arrayList, arrayList2, i, placeForPhoto);
                }
                return true;
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(int i) {
        O o;
        if (i >= 6 || (o = this.n) == null) {
            return;
        }
        o.invalidate();
        AbstractC7426Rr.Q(new F(i), 100L);
    }

    private void x1(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            TextView textView = this.F0;
            this.E0 = textView;
            this.F0 = this.G0;
            this.G0 = textView;
            textView.setTag(charSequence);
            this.E0.setText(charSequence);
            this.E0.setTextColor(C5495Jo7.a.l2());
            this.E0.setAlpha((this.q.getVisibility() == 0 || this.B.getVisibility() == 0) ? 1.0f : 0.0f);
            AbstractC7426Rr.P(new s());
            return;
        }
        if (!this.K0) {
            this.E0.setTextColor(C5495Jo7.a.l2());
            this.E0.setTag(null);
            this.E0.setVisibility(4);
            return;
        }
        try {
            this.E0.setText(AbstractC12217eE5.AddCaption);
        } catch (Exception e) {
            C19406qI3.d("PhotoViewer", e);
        }
        this.E0.setTag("empty");
        this.E0.setVisibility(0);
        TextView textView2 = this.E0;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.y0(c5495Jo7.l2(), 70));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(int i, boolean z2) {
        boolean zV0;
        boolean z3;
        CharSequence charSequence;
        boolean z4;
        boolean z5;
        C11507d74 c11507d74;
        if (this.a1 == i || this.f == null) {
            return;
        }
        if (!z2) {
            this.g1 = null;
        }
        this.d1[0] = l1(i);
        this.d1[1] = l1(i + 1);
        this.d1[2] = l1(i - 1);
        this.f.willSwitchFromPhoto(this.a1);
        int i2 = this.a1;
        this.a1 = i;
        if (!this.g2.isEmpty()) {
            int i3 = this.a1;
            if (i3 < 0 || i3 >= this.g2.size()) {
                closePhoto(false, false);
                return;
            }
            C11507d74 c11507d742 = (C11507d74) this.g2.get(this.a1);
            C11507d74 c11507d743 = this.b1;
            z3 = c11507d743 != null && c11507d743.r0() == c11507d742.r0();
            this.b1 = c11507d742;
            zV0 = c11507d742.v0();
            this.w.setVisibility(8);
            this.u.d(6);
            if (zV0) {
                this.u.i(11);
            } else {
                this.u.d(11);
            }
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(this.b1.U());
            if (c21231tK7 != null) {
                this.r.setText((CharSequence) c21231tK7.r().b());
            } else {
                this.r.setText("");
            }
            this.s.r(c21231tK7);
            long jH = this.b1.h();
            String string = C5721Ko.b.getString(AbstractC12217eE5.formatDateAtTime, C14593iA1.f(this.i, jH), C14593iA1.A(jH));
            C24967zW1 c24967zW1H = this.b1.H();
            if (this.d1[0] == null || !zV0) {
                this.t.setText(string);
            } else {
                this.t.setText(String.format("%s (%s)", string, C20877sl2.a(this.i, c24967zW1H.z().f())));
            }
            x1(c24967zW1H.t().v());
            if (this.L0 != null) {
                this.u.d(1);
                this.u.d(10);
                this.M0 = true;
                this.x.setVisibility(0);
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.AttachGif));
            } else {
                if (this.j1 + this.k1 != 0 && !this.l1) {
                    if (this.o1) {
                        if (this.g2.size() < this.j1 + this.k1 && !this.m1 && this.a1 > this.g2.size() - 5) {
                            if (this.g2.isEmpty()) {
                                c11507d74 = null;
                            } else {
                                ArrayList arrayList = this.g2;
                                c11507d74 = (C11507d74) arrayList.get(arrayList.size() - 1);
                            }
                            AbstractC24061xy6.f(this.i1, 0, c11507d74, 0, true, this.e);
                            this.m1 = true;
                        }
                        this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, Integer.valueOf(this.a1 + 1), Integer.valueOf(this.j1 + this.k1)));
                    } else {
                        if (this.g2.size() < this.j1 + this.k1 && !this.m1 && this.a1 < 5) {
                            AbstractC24061xy6.f(this.i1, 0, this.g2.isEmpty() ? null : (C11507d74) this.g2.get(0), 0, true, this.e);
                            this.m1 = true;
                        }
                        this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, Integer.valueOf(((this.j1 + this.k1) - this.g2.size()) + this.a1 + 1), Integer.valueOf(this.j1 + this.k1)));
                    }
                }
                this.M0 = true;
                this.u.i(1);
                this.x.setVisibility(0);
                if (this.x.getVisibility() == 0) {
                    this.u.d(10);
                } else {
                    this.u.i(10);
                }
            }
        } else if (!this.i2.isEmpty()) {
            this.r.setText("");
            this.t.setText("");
            if (this.h1 != X25.b() || this.j2.isEmpty()) {
                this.u.d(6);
            } else {
                this.u.i(6);
            }
            AbstractC4761Gl2 abstractC4761Gl2 = this.c1;
            if (i < 0 || i >= this.i2.size()) {
                closePhoto(false, false);
                return;
            }
            AbstractC4761Gl2 abstractC4761Gl22 = (AbstractC4761Gl2) this.i2.get(i);
            this.c1 = abstractC4761Gl22;
            z3 = abstractC4761Gl2 != null && abstractC4761Gl22 != null && abstractC4761Gl2.c == abstractC4761Gl22.c && abstractC4761Gl2.b == abstractC4761Gl22.b;
            this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, Integer.valueOf(this.a1 + 1), Integer.valueOf(this.i2.size())));
            this.u.i(1);
            this.M0 = true;
            this.x.setVisibility(0);
            if (this.x.getVisibility() == 0) {
                this.u.d(10);
            } else {
                this.u.i(10);
            }
            zV0 = false;
        } else if (this.l2.isEmpty()) {
            zV0 = false;
            z3 = false;
        } else {
            if (i < 0 || i >= this.l2.size()) {
                closePhoto(false, false);
                return;
            }
            Object obj = this.l2.get(i);
            if (obj instanceof AbstractC14815iX3.b) {
                AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) obj;
                this.f1 = bVar.A;
                z5 = bVar.t == 0 && bVar.v == 0 && this.l2.size() == 1;
                charSequence = bVar.a;
                z4 = bVar.D;
            } else {
                charSequence = null;
                z4 = false;
                z5 = false;
            }
            if (!z5) {
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, Integer.valueOf(this.a1 + 1), Integer.valueOf(this.l2.size())));
            } else if (z4) {
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.AttachVideo));
            } else {
                this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.AttachPhoto));
            }
            if (this.J0 == 0) {
                this.A.setChecked(this.f.isPhotoChecked(this.a1), false);
            }
            if (z4) {
                this.H.setVisibility(8);
                this.J.setVisibility(8);
                this.Y.setVisibility(8);
            } else {
                this.H.setVisibility(0);
                this.J.setVisibility(0);
                this.Y.setVisibility(0);
            }
            x1(charSequence);
            F1(obj);
            zV0 = z4;
            z3 = false;
        }
        PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs = this.e1;
        if (placeProviderObjectAbs != null) {
            if (this.P0 == 0) {
                placeProviderObjectAbs.imageReceiverOld.Z(true, true);
            } else {
                this.S0 = placeProviderObjectAbs;
            }
        }
        PhotoViewerAbs.PlaceProviderObjectAbs placeForPhoto = this.f.getPlaceForPhoto(this.a1);
        this.e1 = placeForPhoto;
        if (placeForPhoto != null) {
            if (this.P0 == 0) {
                placeForPhoto.imageReceiverOld.Z(false, true);
            } else {
                this.T0 = placeForPhoto;
            }
        }
        if (!z3) {
            this.s1 = false;
            this.u1 = 0.0f;
            this.v1 = 0.0f;
            this.w1 = 1.0f;
            this.x1 = 0.0f;
            this.y1 = 0.0f;
            this.z1 = 1.0f;
            this.A1 = 0L;
            this.B1 = null;
            this.C1 = null;
            this.F1 = 0.0f;
            this.G1 = 1.0f;
            this.H1 = 0.0f;
            this.I1 = 0.0f;
            this.J1 = 0.0f;
            this.K1 = 0.0f;
            this.L1 = 0.0f;
            this.M1 = 0.0f;
            this.U1 = false;
            this.V1 = false;
            this.W1 = false;
            this.X1 = false;
            this.Y1 = true;
            this.S1 = false;
            this.b2 = 0;
            this.R1 = (this.l2.isEmpty() && (this.d1[0] == null || zV0 || this.G[0].h == 0)) ? false : true;
            G1(this.w1);
        }
        if (i2 == -1) {
            z1();
            for (int i4 = 0; i4 < 3; i4++) {
                c1(i4, false);
            }
            return;
        }
        c1(0, false);
        int i5 = this.a1;
        if (i2 > i5) {
            S23 s23 = this.Z0;
            this.Z0 = this.Y0;
            this.Y0 = this.X0;
            this.X0 = s23;
            P[] pArr = this.G;
            P p = pArr[0];
            pArr[0] = pArr[2];
            pArr[2] = p;
            A1(s23, i5 - 1);
            c1(1, false);
            c1(2, false);
            return;
        }
        if (i2 < i5) {
            S23 s232 = this.X0;
            this.X0 = this.Y0;
            this.Y0 = this.Z0;
            this.Z0 = s232;
            P[] pArr2 = this.G;
            P p2 = pArr2[0];
            pArr2[0] = pArr2[1];
            pArr2[1] = p2;
            A1(s232, i5 + 1);
            c1(1, false);
            c1(2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1() {
        if (this.P0 == 0) {
            A1(this.Y0, this.a1);
            A1(this.Z0, this.a1 + 1);
            A1(this.X0, this.a1 - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.graphics.drawable.Drawable, android.view.View, ir.nasim.Ws] */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void closePhoto(boolean z2, boolean z3) {
        ?? r3;
        Rect rectK;
        int i;
        PhotoPaintView photoPaintView;
        SA2 sa2 = this.d;
        if (sa2 != null) {
            sa2.invoke();
            this.d = null;
        }
        if (!z3 && (i = this.W0) != 0) {
            if (i == 3 && (photoPaintView = this.C0) != null) {
                photoPaintView.R(this, this.h, new z());
                return;
            }
            if (i == 1) {
                this.A0.cancelAnimationRunnable();
            }
            C1(0);
            return;
        }
        try {
            AlertDialog alertDialog = this.D0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.D0 = null;
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        int i2 = this.W0;
        if (i2 != 0) {
            if (i2 == 2) {
                this.B0.shutdown();
                this.n.removeView(this.B0);
                this.B0 = null;
            } else if (i2 == 1) {
                this.D.setVisibility(8);
                this.A0.setVisibility(8);
            }
            this.W0 = 0;
        }
        if (this.h == null || !this.g || a1() || this.f == null) {
            return;
        }
        if (!this.H0.hideActionMode() || z3) {
            this.H0.onDestroy();
            C15225jD4.b().e(this, C15225jD4.v);
            C15225jD4.b().e(this, C15225jD4.u);
            C15225jD4.b().e(this, C15225jD4.t);
            C15225jD4.b().e(this, C15225jD4.r);
            C15225jD4.b().e(this, C15225jD4.i);
            this.l = false;
            VelocityTracker velocityTracker = this.c2;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.c2 = null;
            }
            PhotoViewerAbs.PlaceProviderObjectAbs placeForPhoto = this.f.getPlaceForPhoto(this.a1);
            if (z2) {
                this.P0 = 1;
                this.p.setVisibility(0);
                this.n.invalidate();
                AnimatorSet animatorSet = new AnimatorSet();
                ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                if (placeForPhoto != null) {
                    this.p.setNeedRadius(placeForPhoto.radiusAll != 0);
                    rectK = placeForPhoto.imageReceiverOld.k();
                    layoutParams.width = rectK.right - rectK.left;
                    layoutParams.height = rectK.bottom - rectK.top;
                    this.p.setImageBitmap(placeForPhoto.thumbBitmap);
                } else {
                    this.p.setNeedRadius(false);
                    layoutParams.width = this.Y0.q();
                    layoutParams.height = this.Y0.o();
                    this.p.setImageBitmap(this.Y0.g());
                    rectK = null;
                }
                this.p.setLayoutParams(layoutParams);
                float f = AbstractC7426Rr.C().x / AbstractC7426Rr.C().y;
                float fH = (AbstractC7426Rr.C().y + AbstractC7426Rr.H()) / AbstractC7426Rr.C().x;
                if (f > fH) {
                    f = fH;
                }
                float f2 = layoutParams.width;
                float f3 = this.w1;
                float f4 = layoutParams.height * f3 * f;
                this.p.setTranslationX(((AbstractC7426Rr.C().x - ((f2 * f3) * f)) / 2.0f) + this.u1);
                this.p.setTranslationY((((AbstractC7426Rr.C().y + AbstractC7426Rr.H()) - f4) / 2.0f) + this.v1);
                float f5 = this.w1;
                if (f5 >= Float.MAX_VALUE) {
                    f5 = Float.MAX_VALUE;
                }
                this.w1 = f5;
                this.p.setScaleX(f5 * f);
                this.p.setScaleY(this.w1 * f);
                if (placeForPhoto != null) {
                    placeForPhoto.imageReceiverOld.Z(false, true);
                    int iAbs = Math.abs(rectK.left - placeForPhoto.imageReceiverOld.r());
                    int iAbs2 = Math.abs(rectK.top - placeForPhoto.imageReceiverOld.s());
                    int[] iArr = new int[2];
                    placeForPhoto.parentView.getLocationInWindow(iArr);
                    int i3 = iArr[1];
                    int i4 = placeForPhoto.viewY;
                    int i5 = rectK.top;
                    int i6 = (i3 - (i4 + i5)) + placeForPhoto.clipTopAddition;
                    int i7 = i6 < 0 ? 0 : i6;
                    int height = ((((i4 + i5) + rectK.bottom) - i5) - (i3 + placeForPhoto.parentView.getHeight())) + placeForPhoto.clipBottomAddition;
                    if (height < 0) {
                        height = 0;
                    }
                    int iMax = Math.max(i7, iAbs2);
                    int iMax2 = Math.max(height, iAbs2);
                    this.O0[0][0] = this.p.getScaleX();
                    this.O0[0][1] = this.p.getScaleY();
                    this.O0[0][2] = this.p.getTranslationX();
                    this.O0[0][3] = this.p.getTranslationY();
                    float[][] fArr = this.O0;
                    float[] fArr2 = fArr[0];
                    fArr2[4] = 0.0f;
                    fArr2[5] = 0.0f;
                    fArr2[6] = 0.0f;
                    fArr2[7] = 0.0f;
                    float[] fArr3 = fArr[1];
                    float f6 = placeForPhoto.scale;
                    fArr3[0] = f6;
                    fArr3[1] = f6;
                    fArr3[2] = placeForPhoto.viewX + (rectK.left * f6);
                    fArr3[3] = placeForPhoto.viewY + (rectK.top * f6);
                    fArr3[4] = iAbs * f6;
                    fArr3[5] = iMax * f6;
                    fArr3[6] = iMax2 * f6;
                    fArr3[7] = placeForPhoto.radiusAll;
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.p, "animationProgress", 0.0f, 1.0f), ObjectAnimator.ofInt(this.y, "alpha", 0), ObjectAnimator.ofFloat(this.n, "alpha", 0.0f));
                } else {
                    int iH = AbstractC7426Rr.C().y + AbstractC7426Rr.H();
                    ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.y, "alpha", 0);
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.p, "alpha", 0.0f);
                    ClippingImageView clippingImageView = this.p;
                    if (this.v1 < 0.0f) {
                        iH = -iH;
                    }
                    animatorSet.playTogether(objectAnimatorOfInt, objectAnimatorOfFloat, ObjectAnimator.ofFloat(clippingImageView, "translationY", iH), ObjectAnimator.ofFloat(this.n, "alpha", 0.0f));
                }
                this.R0 = new A(placeForPhoto);
                animatorSet.setDuration(200L);
                animatorSet.addListener(new B());
                this.Q0 = System.currentTimeMillis();
                this.n.setLayerType(2, null);
                animatorSet.start();
                r3 = 0;
            } else {
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.n, "scaleX", 0.9f), ObjectAnimator.ofFloat(this.n, "scaleY", 0.9f), ObjectAnimator.ofInt(this.y, "alpha", 0), ObjectAnimator.ofFloat(this.n, "alpha", 0.0f));
                this.P0 = 2;
                this.R0 = new C(placeForPhoto);
                animatorSet2.setDuration(200L);
                animatorSet2.addListener(new D());
                this.Q0 = System.currentTimeMillis();
                r3 = 0;
                this.n.setLayerType(2, null);
                animatorSet2.start();
            }
            C8610Ws c8610Ws = this.L0;
            if (c8610Ws != 0) {
                c8610Ws.T(r3);
                this.L0 = r3;
                this.Y0.P(r3);
            }
            PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs = this.f;
            if (photoViewerProviderAbs instanceof PhotoViewerAbs.EmptyPhotoViewerProviderAbs) {
                photoViewerProviderAbs.cancelButtonPressed();
            }
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void destroyPhotoViewer() {
        FrameLayout frameLayout;
        if (this.h == null || (frameLayout = this.o) == null) {
            return;
        }
        try {
            if (frameLayout.getParent() != null) {
                ((WindowManager) this.h.getSystemService("window")).removeViewImmediate(this.o);
            }
            this.o = null;
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.H0;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.onDestroy();
        }
        resetInstance();
        ActionBar actionBar = this.k;
        if (actionBar != null) {
            actionBar.i(this.n2);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs, ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i, Object... objArr) {
        TextView textView;
        int i2 = 0;
        if (i == C15225jD4.v) {
            String str = (String) objArr[0];
            while (i2 < 3) {
                String str2 = this.d1[i2];
                if (str2 != null && str2.equals(str)) {
                    this.G[i2].e(1.0f, true);
                    c1(i2, true);
                    return;
                }
                i2++;
            }
            return;
        }
        if (i == C15225jD4.u) {
            String str3 = (String) objArr[0];
            String str4 = (String) objArr[1];
            long jLongValue = ((Long) objArr[2]).longValue();
            for (int i3 = 0; i3 < 3; i3++) {
                String str5 = this.d1[i3];
                if (str5 != null && str5.contains("_")) {
                    String str6 = this.d1[i3];
                    if (str6.substring(0, str6.indexOf("_")).equals(jLongValue + "")) {
                        this.d1[i3] = str4;
                        I1(i3, str3);
                    }
                }
                String str7 = this.d1[i3];
                if (str7 != null && str7.equals(str4)) {
                    this.G[i3].e(1.0f, true);
                    c1(i3, true);
                    return;
                }
            }
            return;
        }
        if (i == C15225jD4.t) {
            String str8 = (String) objArr[0];
            while (i2 < 3) {
                String str9 = this.d1[i2];
                if (str9 != null && str9.equals(str8)) {
                    this.G[i2].e(((Float) objArr[1]).floatValue(), true);
                }
                i2++;
            }
            return;
        }
        if (i != C15225jD4.r) {
            if (i != C15225jD4.i || (textView = this.E0) == null) {
                return;
            }
            textView.invalidate();
            return;
        }
        long jLongValue2 = ((Long) objArr[0]).longValue();
        int iIntValue = ((Integer) objArr[3]).intValue();
        long j = this.i1;
        if ((jLongValue2 == j || jLongValue2 == 0.0d) && iIntValue == this.e) {
            this.m1 = false;
            char c = jLongValue2 == j ? (char) 0 : (char) 1;
            ArrayList arrayList = (ArrayList) objArr[2];
            this.n1[c] = ((Boolean) objArr[5]).booleanValue();
            if (!this.l1) {
                Iterator it = arrayList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    C11507d74 c11507d74 = (C11507d74) it.next();
                    if (!this.h2[c].containsKey(Long.valueOf(c11507d74.i()))) {
                        i4++;
                        if (this.o1) {
                            this.g2.add(c11507d74);
                        } else {
                            this.g2.add(0, c11507d74);
                        }
                        this.h2[c].put(Long.valueOf(c11507d74.r0()), c11507d74);
                    }
                }
                if (this.o1) {
                    if (i4 == 0) {
                        this.j1 = this.g2.size();
                        this.k1 = 0;
                        return;
                    }
                    return;
                }
                if (i4 == 0) {
                    this.j1 = this.g2.size();
                    this.k1 = 0;
                    return;
                } else {
                    int i5 = this.a1;
                    this.a1 = -1;
                    y1(i5 + i4, true);
                    return;
                }
            }
            if (arrayList.isEmpty()) {
                this.l1 = false;
                return;
            }
            C11507d74 c11507d742 = (C11507d74) this.g2.get(this.a1);
            int size = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                C11507d74 c11507d743 = (C11507d74) arrayList.get(i7);
                if (!this.f2[c].containsKey(Long.valueOf(c11507d743.r0()))) {
                    this.f2[c].put(Long.valueOf(c11507d743.r0()), c11507d743);
                    if (this.o1) {
                        this.e2.add(c11507d743);
                        if (c11507d743.r0() == c11507d742.r0()) {
                            size = i6;
                        }
                        i6++;
                    } else {
                        i6++;
                        this.e2.add(0, c11507d743);
                        if (c11507d743.r0() == c11507d742.r0()) {
                            size = arrayList.size() - i6;
                        }
                    }
                }
            }
            if (i6 == 0) {
                this.j1 = this.g2.size();
                this.k1 = 0;
            }
            if (size == -1) {
                C11507d74 c11507d744 = null;
                if (this.o1) {
                    if (!this.e2.isEmpty()) {
                        ArrayList arrayList2 = this.e2;
                        c11507d744 = (C11507d74) arrayList2.get(arrayList2.size() - 1);
                    }
                } else if (!this.e2.isEmpty()) {
                    c11507d744 = (C11507d74) this.e2.get(0);
                }
                C11507d74 c11507d745 = c11507d744;
                if (this.n1[c]) {
                    return;
                }
                this.m1 = true;
                AbstractC24061xy6.f(c == 0 ? this.i1 : 0L, 0, c11507d745, 0, true, this.e);
                return;
            }
            this.g2.clear();
            this.g2.addAll(this.e2);
            for (int i8 = 0; i8 < 2; i8++) {
                this.h2[i8].clear();
                this.h2[i8].putAll(this.f2[i8]);
                this.f2[i8].clear();
            }
            this.e2.clear();
            this.l1 = false;
            this.a1 = -1;
            if (size >= this.g2.size()) {
                size = this.g2.size() - 1;
            }
            y1(size, true);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean isShowingImage(String str) {
        return this.g && !this.U0 && str != null && str.equals(this.f1);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean isVisible() {
        return this.g && this.f != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[PHI: r10
      0x007c: PHI (r10v10 float) = (r10v5 float), (r10v6 float) binds: [B:19:0x007a, B:22:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[PHI: r10
      0x008b: PHI (r10v9 float) = (r10v7 float), (r10v8 float) binds: [B:25:0x0089, B:28:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onDoubleTap(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.R1
            r1 = 0
            if (r0 == 0) goto L9d
            float r0 = r9.w1
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r4 = 0
            if (r3 != 0) goto L1c
            float r3 = r9.v1
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L9d
            float r3 = r9.u1
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L1c
            goto L9d
        L1c:
            long r5 = r9.A1
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L9d
            int r3 = r9.P0
            if (r3 == 0) goto L2a
            goto L9d
        L2a:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 != 0) goto L98
            float r0 = r10.getX()
            int r2 = r9.i1()
            int r2 = r2 / 2
            float r2 = (float) r2
            float r0 = r0 - r2
            float r2 = r10.getX()
            int r3 = r9.i1()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r2 = r2 - r3
            float r3 = r9.u1
            float r2 = r2 - r3
            float r3 = r9.w1
            r4 = 1077936128(0x40400000, float:3.0)
            float r3 = r4 / r3
            float r2 = r2 * r3
            float r0 = r0 - r2
            float r2 = r10.getY()
            int r3 = r9.g1()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r2 = r2 - r3
            float r10 = r10.getY()
            int r3 = r9.g1()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r10 = r10 - r3
            float r3 = r9.v1
            float r10 = r10 - r3
            float r3 = r9.w1
            float r3 = r4 / r3
            float r10 = r10 * r3
            float r2 = r2 - r10
            r9.G1(r4)
            float r10 = r9.N1
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 >= 0) goto L7e
        L7c:
            r0 = r10
            goto L85
        L7e:
            float r10 = r9.O1
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 <= 0) goto L85
            goto L7c
        L85:
            float r10 = r9.P1
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 >= 0) goto L8d
        L8b:
            r2 = r10
            goto L94
        L8d:
            float r10 = r9.Q1
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 <= 0) goto L94
            goto L8b
        L94:
            r9.X0(r4, r0, r2, r1)
            goto L9b
        L98:
            r9.X0(r2, r4, r4, r1)
        L9b:
            r9.W1 = r1
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.onDoubleTap(android.view.MotionEvent):boolean");
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e  */
    @Override // ir.nasim.features.media.components.PhotoViewerAbs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20171rb5.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.w1 == 1.0f) {
            return false;
        }
        this.d2.abortAnimation();
        this.d2.fling(Math.round(this.u1), Math.round(this.v1), Math.round(f), Math.round(f2), (int) this.N1, (int) this.O1, (int) this.P1, (int) this.Q1);
        this.n.postInvalidate();
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void onPause() {
        if (this.L0 != null) {
            closePhoto(false, false);
        } else if (this.Z.getVisibility() != 8) {
            d1(true);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void onResume() {
        w1(0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        int i;
        if (this.a2) {
            return false;
        }
        if (this.I0) {
            P p = this.G[0];
            if (p != null && this.n != null && (i = p.h) > 0 && i <= 3) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (x2 >= (i1() - AbstractC7426Rr.z(100.0f)) / 2.0f && x2 <= (i1() + AbstractC7426Rr.z(100.0f)) / 2.0f && y2 >= (g1() - AbstractC7426Rr.z(100.0f)) / 2.0f && y2 <= (g1() + AbstractC7426Rr.z(100.0f)) / 2.0f) {
                    c1(0, true);
                    return true;
                }
            }
            D1(!this.l, true);
        } else if (this.J0 == 0) {
            this.A.performClick();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList arrayList, int i, int i2, boolean z2, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType) {
        return openPhotoForSelect(arrayList, i, i2, z2, false, photoViewerProviderAbs, c11458d25, exPeerType);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void setParentActivity(Activity activity) {
        if (this.h == activity) {
            return;
        }
        this.j = true;
        this.h = activity;
        this.i = new ContextThemeWrapper(this.h, AbstractC23035wE5.Theme_TMessages);
        if (r2 == null) {
            Drawable[] drawableArr = new Drawable[4];
            r2 = drawableArr;
            drawableArr[0] = this.h.getResources().getDrawable(KB5.circle_big);
            r2[1] = this.h.getResources().getDrawable(KB5.cancel_big);
            r2[2] = this.h.getResources().getDrawable(KB5.load_big);
            r2[3] = this.h.getResources().getDrawable(KB5.play_big);
        }
        this.d2 = new Scroller(activity);
        C20172a c20172a = new C20172a(activity);
        this.o = c20172a;
        c20172a.setBackgroundDrawable(this.y);
        this.o.setClipChildren(true);
        this.o.setFocusable(false);
        ClippingImageView clippingImageView = new ClippingImageView(activity);
        this.p = clippingImageView;
        clippingImageView.setAnimationValues(this.O0);
        this.o.addView(this.p, C14433hu3.a(40, 40.0f));
        O o = new O(activity);
        this.n = o;
        o.setFocusable(false);
        this.o.addView(this.n, C14433hu3.c(-1, -1, 51));
        this.n.setOnApplyWindowInsetsListener(new v());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.m = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 51;
        layoutParams.type = 99;
        layoutParams.flags = -2147417848;
        ActionBar actionBar = new ActionBar(activity);
        this.k = actionBar;
        actionBar.setTitleCenter(false);
        ActionBar actionBar2 = this.k;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        actionBar2.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.k.setItemsBackgroundColor(c5495Jo7.y0(c5495Jo7.f0(), 25));
        this.k.setBackButtonImage(KB5.ic_arrow_back_white_24dp);
        this.k.setTitle(C5721Ko.b.getString(AbstractC12217eE5.Of, 1, 1));
        this.n.addView(this.k, C14433hu3.a(-1, -2.0f));
        ActionBar actionBar3 = this.k;
        w wVar = new w();
        this.n2 = wVar;
        actionBar3.a(wVar);
        ActionBarMenu actionBarMenuD = this.k.d();
        this.w = actionBarMenuD.a(13, KB5.ic_masks_msk1);
        this.v = actionBarMenuD.a(12, KB5.volume_on);
        ActionBarMenuItem actionBarMenuItemA = actionBarMenuD.a(0, KB5.ic_more_vert_white_24dp);
        this.u = actionBarMenuItemA;
        actionBarMenuItemA.a(11, C5721Ko.b.getString(AbstractC12217eE5.OpenInExternalApp), 0);
        this.u.a(2, C5721Ko.b.getString(AbstractC12217eE5.ShowAllMedia), 0);
        this.u.a(10, C5721Ko.b.getString(AbstractC12217eE5.menu_share), 0);
        this.u.a(1, C5721Ko.b.getString(AbstractC12217eE5.SaveToGallery), 0);
        this.u.a(6, C5721Ko.b.getString(AbstractC12217eE5.Delete), 0);
        this.Z = actionBarMenuD.d(9, KB5.ic_done_white_24dp, AbstractC7426Rr.z(56.0f));
        FrameLayout frameLayout = new FrameLayout(this.i);
        this.q = frameLayout;
        frameLayout.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.n.addView(this.q, C14433hu3.c(-1, 48, 83));
        TextView textView = new TextView(this.i);
        this.F0 = textView;
        textView.setTypeface(C6011Lu2.k());
        this.F0.setTextDirection(2);
        this.F0.setMaxLines(10);
        this.F0.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.F0.setPadding(AbstractC7426Rr.z(20.0f), AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(20.0f), AbstractC7426Rr.z(8.0f));
        this.F0.setLinkTextColor(c5495Jo7.f0());
        this.F0.setTextColor(c5495Jo7.f0());
        this.F0.setGravity(17);
        this.F0.setTextSize(1, 16.0f);
        this.F0.setVisibility(4);
        this.n.addView(this.F0, C14433hu3.b(-1, -2.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        this.F0.setOnClickListener(new H());
        TextView textView2 = new TextView(this.i);
        this.G0 = textView2;
        this.E0 = textView2;
        textView2.setTypeface(C6011Lu2.k());
        this.G0.setTypeface(C6011Lu2.k());
        this.E0.setTextDirection(2);
        this.G0.setTextDirection(2);
        this.G0.setMaxLines(10);
        this.G0.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.G0.setPadding(AbstractC7426Rr.z(20.0f), AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(20.0f), AbstractC7426Rr.z(8.0f));
        this.G0.setLinkTextColor(c5495Jo7.f0());
        this.G0.setTextColor(c5495Jo7.f0());
        this.G0.setGravity(17);
        this.G0.setTextSize(1, 16.0f);
        this.G0.setVisibility(4);
        this.n.addView(this.G0, C14433hu3.b(-1, -2.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        this.G0.setOnClickListener(new I());
        this.G[0] = new P(this.n);
        this.G[0].d(0, false);
        this.G[1] = new P(this.n);
        this.G[1].d(0, false);
        this.G[2] = new P(this.n);
        this.G[2].d(0, false);
        AvatarViewGlide avatarViewGlide = new AvatarViewGlide(this.n.getContext());
        this.s = avatarViewGlide;
        avatarViewGlide.B(18.0f, true);
        FrameLayout frameLayout2 = new FrameLayout(this.i);
        frameLayout2.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        frameLayout2.addView(this.s, C14433hu3.b(48, 48.0f, 83, 4.0f, 0.0f, 0.0f, 0.0f));
        this.q.addView(frameLayout2, C14433hu3.b(52, 48.0f, 83, 0.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout frameLayout3 = new FrameLayout(this.i);
        frameLayout3.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.q.addView(frameLayout3, C14433hu3.b(-1, 48.0f, 83, 52.0f, 0.0f, 0.0f, 0.0f));
        TextView textView3 = new TextView(this.n.getContext());
        this.r = textView3;
        textView3.setTextSize(1, 14.0f);
        this.r.setTypeface(C6011Lu2.k());
        this.r.setSingleLine(true);
        this.r.setMaxLines(1);
        TextView textView4 = this.r;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.r.setTextColor(c5495Jo7.f0());
        this.r.setGravity(3);
        frameLayout3.addView(this.r, C14433hu3.b(-1, -2.0f, 51, 4.0f, 5.0f, 60.0f, 0.0f));
        TextView textView5 = new TextView(this.n.getContext());
        this.t = textView5;
        textView5.setTextSize(1, 13.0f);
        this.t.setSingleLine(true);
        this.t.setMaxLines(1);
        this.t.setEllipsize(truncateAt);
        this.t.setTextColor(c5495Jo7.f0());
        this.t.setTypeface(C6011Lu2.k());
        this.t.setGravity(3);
        frameLayout3.addView(this.t, C14433hu3.b(-1, -2.0f, 51, 4.0f, 25.0f, 50.0f, 0.0f));
        ImageView imageView = new ImageView(this.n.getContext());
        this.x = imageView;
        imageView.setImageResource(KB5.ic_share_white_24dp);
        ImageView imageView2 = this.x;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView2.setScaleType(scaleType);
        this.x.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        this.q.addView(this.x, C14433hu3.c(50, -1, 53));
        this.x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ea5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.o1(view);
            }
        });
        PickerBottomLayoutViewer pickerBottomLayoutViewer = new PickerBottomLayoutViewer(this.i, true);
        this.B = pickerBottomLayoutViewer;
        pickerBottomLayoutViewer.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.n.addView(this.B, C14433hu3.c(-1, 58, 83));
        this.B.cancelButton.setOnClickListener(new J());
        K k = new K();
        this.B.doneButton.setOnClickListener(k);
        this.B.newDoneButton.setOnClickListener(k);
        LinearLayout linearLayout = new LinearLayout(this.h);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(this.c ? 0 : 4);
        this.B.addView(linearLayout, C14433hu3.c(-2, 48, 49));
        ImageView imageView3 = new ImageView(this.h);
        this.Y = imageView3;
        imageView3.setScaleType(scaleType);
        this.Y.setImageResource(KB5.photo_tools);
        this.Y.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        linearLayout.addView(this.Y, C14433hu3.d(56, 48));
        this.Y.setOnClickListener(new L());
        ImageView imageView4 = new ImageView(this.h);
        this.H = imageView4;
        imageView4.setScaleType(scaleType);
        this.H.setImageResource(KB5.photo_paint);
        this.H.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        linearLayout.addView(this.H, C14433hu3.d(56, 48));
        this.H.setOnClickListener(new M());
        ImageView imageView5 = new ImageView(this.h);
        this.J = imageView5;
        imageView5.setScaleType(scaleType);
        this.J.setImageResource(KB5.ic_crop_white_24dp);
        this.J.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        linearLayout.addView(this.J, C14433hu3.d(56, 48));
        this.J.setOnClickListener(new ViewOnClickListenerC20173b());
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = new PickerBottomLayoutViewer(this.i, false);
        this.D = pickerBottomLayoutViewer2;
        pickerBottomLayoutViewer2.setBackgroundColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        this.D.updateSelectedCount(0, false);
        this.D.setVisibility(8);
        this.n.addView(this.D, C14433hu3.c(-1, 48, 83));
        this.D.cancelButton.setOnClickListener(new ViewOnClickListenerC20174c());
        this.D.doneButton.setOnClickListener(new ViewOnClickListenerC20175d());
        ImageView imageView6 = new ImageView(this.i);
        imageView6.setScaleType(scaleType);
        imageView6.setImageResource(KB5.tool_rotate);
        imageView6.setBackgroundDrawable(AbstractC4310Eo7.b(c5495Jo7.y0(c5495Jo7.f0(), 25)));
        this.D.addView(imageView6, C14433hu3.c(48, 48, 17));
        imageView6.setOnClickListener(new ViewOnClickListenerC20176e());
        GestureDetector gestureDetector = new GestureDetector(this.n.getContext(), this);
        this.D1 = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        C20177f c20177f = new C20177f();
        this.Y0.W(this.n);
        this.Y0.K((byte) 2);
        this.Y0.S(true);
        this.Y0.L(c20177f);
        this.X0.W(this.n);
        this.X0.K((byte) 2);
        this.X0.S(true);
        this.X0.L(c20177f);
        this.Z0.W(this.n);
        this.Z0.K((byte) 2);
        this.Z0.S(true);
        this.Z0.L(c20177f);
        int rotation = ((WindowManager) C5721Ko.b.getSystemService("window")).getDefaultDisplay().getRotation();
        CheckBox checkBox = new CheckBox(this.n.getContext(), KB5.selectphoto_large);
        this.A = checkBox;
        checkBox.setDrawBackground(true);
        this.A.setSize(45);
        this.A.setCheckOffset(AbstractC7426Rr.z(1.0f));
        this.A.setColor(AbstractC4043Dl1.c(this.i, TA5.secondary));
        this.A.setVisibility(8);
        this.n.addView(this.A, C14433hu3.b(45, 45.0f, 53, 0.0f, (rotation == 3 || rotation == 1) ? 58.0f : 68.0f, 10.0f, 0.0f));
        ((FrameLayout.LayoutParams) this.A.getLayoutParams()).topMargin += AbstractC7426Rr.H();
        this.A.setOnClickListener(new ViewOnClickListenerC20178g());
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = new PhotoViewerCaptionEnterView(this.i, this.n, this.o);
        this.H0 = photoViewerCaptionEnterView;
        photoViewerCaptionEnterView.setDelegate(new C20179h());
        this.n.addView(this.H0, C14433hu3.b(-1, -2.0f, 83, 0.0f, 0.0f, 0.0f, -400.0f));
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void showAlertDialog(AlertDialog.Builder builder) {
        if (this.h == null) {
            return;
        }
        try {
            AlertDialog alertDialog = this.D0;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.D0 = null;
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        try {
            AlertDialog alertDialogShow = builder.show();
            this.D0 = alertDialogShow;
            alertDialogShow.setCanceledOnTouchOutside(true);
            this.D0.setOnDismissListener(new DialogInterfaceOnDismissListenerC20180i());
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList arrayList, int i, int i2, boolean z2, boolean z3, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType) {
        this.J0 = i2;
        this.isPurchaseType = z2;
        this.isWallpaperType = z3;
        PickerBottomLayoutViewer pickerBottomLayoutViewer = this.B;
        if (pickerBottomLayoutViewer != null) {
            pickerBottomLayoutViewer.doneButton.setText((i2 == 1 || z2 || z3) ? C5721Ko.b.getString(AbstractC12217eE5.Set).toUpperCase() : C5721Ko.b.getString(AbstractC12217eE5.Send).toUpperCase());
        }
        return v1(null, null, null, arrayList, i, photoViewerProviderAbs, c11458d25, exPeerType, 0L);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList arrayList, int i, int i2, boolean z2, boolean z3, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType, SA2 sa2) {
        this.d = sa2;
        return openPhotoForSelect(arrayList, i, i2, z2, z3, photoViewerProviderAbs, c11458d25, exPeerType);
    }

    /* renamed from: ir.nasim.rb5$o, reason: case insensitive filesystem */
    class C20186o extends AbstractC9160Yt {
        final /* synthetic */ int a;

        C20186o(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C20171rb5.this.C1 = null;
            C20171rb5.this.B.setVisibility(8);
            C20171rb5.this.k.setVisibility(8);
            if (C20171rb5.this.K0) {
                C20171rb5.this.E0.setVisibility(4);
            }
            if (C20171rb5.this.J0 == 0) {
                C20171rb5.this.A.setVisibility(8);
            }
            if (C20171rb5.this.Y0.g() != null) {
                int i = C20171rb5.this.Y0.i();
                float f = i;
                float fI1 = C20171rb5.this.i1() / f;
                float fH = C20171rb5.this.Y0.h();
                float fG1 = C20171rb5.this.g1() / fH;
                float fJ1 = C20171rb5.this.j1(2) / f;
                float fH1 = C20171rb5.this.h1(2) / fH;
                if (fI1 > fG1) {
                    fI1 = fG1;
                }
                if (fJ1 > fH1) {
                    fJ1 = fH1;
                }
                C20171rb5.this.z1 = fJ1 / fI1;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = (-AbstractC7426Rr.z(62.0f)) + (AbstractC7426Rr.H() / 2);
                C20171rb5.this.A1 = System.currentTimeMillis();
                C20171rb5.this.Z1 = true;
            }
            C20171rb5.this.B1 = new AnimatorSet();
            C20171rb5.this.B1.playTogether(ObjectAnimator.ofFloat(C20171rb5.this, "animationValue", 0.0f, 1.0f), ObjectAnimator.ofFloat(C20171rb5.this.B0.getToolsView(), "translationY", AbstractC7426Rr.z(126.0f), 0.0f));
            C20171rb5.this.B1.setDuration(200L);
            C20171rb5.this.B1.addListener(new a());
            C20171rb5.this.B1.start();
        }

        /* renamed from: ir.nasim.rb5$o$a */
        class a extends AbstractC9160Yt {
            a() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C20171rb5.this.B0.init();
                C20171rb5.this.B1 = null;
                C20186o c20186o = C20186o.this;
                C20171rb5.this.W0 = c20186o.a;
                C20171rb5.this.z1 = 1.0f;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = 0.0f;
                C20171rb5.this.w1 = 1.0f;
                C20171rb5 c20171rb5 = C20171rb5.this;
                c20171rb5.G1(c20171rb5.w1);
                C20171rb5.this.n.invalidate();
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }

    /* renamed from: ir.nasim.rb5$q */
    class q extends AbstractC9160Yt {
        final /* synthetic */ int a;

        q(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C20171rb5.this.C1 = null;
            C20171rb5.this.B.setVisibility(8);
            if (C20171rb5.this.K0) {
                C20171rb5.this.E0.setVisibility(4);
            }
            if (C20171rb5.this.J0 == 0) {
                C20171rb5.this.A.setVisibility(8);
            }
            if (C20171rb5.this.Y0.g() != null) {
                int i = C20171rb5.this.Y0.i();
                float f = i;
                float fI1 = C20171rb5.this.i1() / f;
                float fH = C20171rb5.this.Y0.h();
                float fG1 = C20171rb5.this.g1() / fH;
                float fJ1 = C20171rb5.this.j1(3) / f;
                float fH1 = C20171rb5.this.h1(3) / fH;
                if (fI1 > fG1) {
                    fI1 = fG1;
                }
                if (fJ1 > fH1) {
                    fJ1 = fH1;
                }
                C20171rb5.this.z1 = fJ1 / fI1;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = ((ActionBar.getCurrentActionBarHeight() - AbstractC7426Rr.z(48.0f)) + AbstractC7426Rr.H()) / 2;
                C20171rb5.this.A1 = System.currentTimeMillis();
                C20171rb5.this.Z1 = true;
            }
            C20171rb5.this.B1 = new AnimatorSet();
            C20171rb5.this.B1.playTogether(ObjectAnimator.ofFloat(C20171rb5.this, "animationValue", 0.0f, 1.0f), ObjectAnimator.ofFloat(C20171rb5.this.C0.getColorPicker(), "translationX", AbstractC7426Rr.z(60.0f), 0.0f), ObjectAnimator.ofFloat(C20171rb5.this.C0.getToolsView(), "translationY", AbstractC7426Rr.z(126.0f), 0.0f), ObjectAnimator.ofFloat(C20171rb5.this.C0.getActionBar(), "translationY", (-ActionBar.getCurrentActionBarHeight()) - AbstractC7426Rr.H(), 0.0f));
            C20171rb5.this.B1.setDuration(200L);
            C20171rb5.this.B1.addListener(new a());
            C20171rb5.this.B1.start();
        }

        /* renamed from: ir.nasim.rb5$q$a */
        class a extends AbstractC9160Yt {
            a() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C20171rb5.this.C0.P();
                C20171rb5.this.B1 = null;
                q qVar = q.this;
                C20171rb5.this.W0 = qVar.a;
                C20171rb5.this.z1 = 1.0f;
                C20171rb5.this.x1 = 0.0f;
                C20171rb5.this.y1 = 0.0f;
                C20171rb5.this.w1 = 1.0f;
                C20171rb5 c20171rb5 = C20171rb5.this;
                c20171rb5.G1(c20171rb5.w1);
                C20171rb5.this.n.invalidate();
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
