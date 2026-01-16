package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import ir.nasim.C22301v03;
import ir.nasim.C3351Am7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class D20 implements DefaultLifecycleObserver {
    public static final d n = new d(null);
    private static final InterfaceC9173Yu3 o = AbstractC13269fw3.a(b.e);
    private static final InterfaceC9173Yu3 p = AbstractC13269fw3.a(c.e);
    private final Context a;
    private final a b;
    private final P20 c;
    private final R20 d;
    private final PopupWindow e;
    private final PopupWindow f;
    private E20 g;
    private boolean h;
    private boolean i;
    public DI4 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;

    public static final class a {
        private int A;
        private boolean A0;
        private int B;
        private boolean B0;
        private int C;
        private boolean C0;
        private int D;
        private long D0;
        private int E;
        private InterfaceC18633oz3 E0;
        private float F;
        private InterfaceC18042nz3 F0;
        private float G;
        private int G0;
        private int H;
        private int H0;
        private Drawable I;
        private F20 I0;
        private float J;
        private S20 J0;
        private CharSequence K;
        private long K0;
        private int L;
        private I20 L0;
        private boolean M;
        private int M0;
        private MovementMethod N;
        private long N0;
        private float O;
        private String O0;
        private int P;
        private int P0;
        private Typeface Q;
        private SA2 Q0;
        private Float R;
        private boolean R0;
        private Float S;
        private int S0;
        private boolean T;
        private boolean T0;
        private int U;
        private boolean U0;
        private C3351Am7 V;
        private boolean V0;
        private Drawable W;
        private boolean W0;
        private EnumC22897w03 X;
        private int Y;
        private int Z;
        private final Context a;
        private int a0;
        private int b;
        private int b0;
        private int c;
        private C22301v03 c0;
        private int d;
        private CharSequence d0;
        private float e;
        private float e0;
        private float f;
        private float f0;
        private float g;
        private View g0;
        private int h;
        private Integer h0;
        private int i;
        private boolean i0;
        private int j;
        private int j0;
        private int k;
        private float k0;
        private int l;
        private int l0;
        private int m;
        private Point m0;
        private int n;
        private U20 n0;
        private int o;
        private int o0;
        private int p;
        private BI4 p0;
        private int q;
        private CI4 q0;
        private boolean r;
        private DI4 r0;
        private int s;
        private EI4 s0;
        private boolean t;
        private View.OnTouchListener t0;
        private int u;
        private View.OnTouchListener u0;
        private float v;
        private FI4 v0;
        private EnumC12874fK w;
        private boolean w0;
        private EnumC12265eK x;
        private boolean x0;
        private EnumC11622dK y;
        private boolean y0;
        private Drawable z;
        private boolean z0;

        public a(Context context) {
            AbstractC13042fc3.i(context, "context");
            this.a = context;
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.d = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
            this.h = RecyclerView.UNDEFINED_DURATION;
            this.i = RecyclerView.UNDEFINED_DURATION;
            this.r = true;
            this.s = RecyclerView.UNDEFINED_DURATION;
            this.u = AbstractC20723sV3.d(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
            this.v = 0.5f;
            this.w = EnumC12874fK.a;
            this.x = EnumC12265eK.a;
            this.y = EnumC11622dK.b;
            this.F = 2.5f;
            this.H = -16777216;
            this.J = TypedValue.applyDimension(1, 5.0f, Resources.getSystem().getDisplayMetrics());
            DY6 dy6 = DY6.a;
            this.K = "";
            this.L = -1;
            this.O = 12.0f;
            this.T = true;
            this.U = 17;
            this.X = EnumC22897w03.a;
            float f = 28;
            this.Y = AbstractC20723sV3.d(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.Z = AbstractC20723sV3.d(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.a0 = AbstractC20723sV3.d(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
            this.b0 = RecyclerView.UNDEFINED_DURATION;
            this.d0 = "";
            this.e0 = 1.0f;
            this.f0 = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
            this.n0 = T20.a;
            this.o0 = 17;
            this.w0 = true;
            this.x0 = true;
            this.A0 = true;
            this.D0 = -1L;
            this.G0 = RecyclerView.UNDEFINED_DURATION;
            this.H0 = RecyclerView.UNDEFINED_DURATION;
            this.I0 = F20.c;
            this.J0 = S20.b;
            this.K0 = 500L;
            this.L0 = I20.a;
            this.M0 = RecyclerView.UNDEFINED_DURATION;
            this.P0 = 1;
            boolean z = context.getResources().getConfiguration().getLayoutDirection() == 1;
            this.R0 = z;
            this.S0 = FG1.b(1, z);
            this.T0 = true;
            this.U0 = true;
            this.V0 = true;
        }

        public final int A() {
            return this.H0;
        }

        public final int A0() {
            return this.P0;
        }

        public final a A1(int i) {
            this.Y = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final X20 B() {
            return null;
        }

        public final int B0() {
            return this.S0;
        }

        public final a B1(boolean z) {
            this.W0 = z;
            return this;
        }

        public final long C() {
            return this.K0;
        }

        public final CharSequence C0() {
            return this.K;
        }

        public final a C1(boolean z) {
            this.U0 = z;
            return this;
        }

        public final float D() {
            return this.J;
        }

        public final int D0() {
            return this.L;
        }

        public final a D1(boolean z) {
            this.r = z;
            return this;
        }

        public final boolean E() {
            return this.z0;
        }

        public final C3351Am7 E0() {
            return this.V;
        }

        public final a E1(int i) {
            this.h0 = Integer.valueOf(i);
            return this;
        }

        public final boolean F() {
            return this.B0;
        }

        public final int F0() {
            return this.U;
        }

        public final a F1(View view) {
            AbstractC13042fc3.i(view, "layout");
            this.g0 = view;
            return this;
        }

        public final boolean G() {
            return this.A0;
        }

        public final boolean G0() {
            return this.M;
        }

        public final a G1(InterfaceC18633oz3 interfaceC18633oz3) {
            this.E0 = interfaceC18633oz3;
            return this;
        }

        public final boolean H() {
            return this.y0;
        }

        public final Float H0() {
            return this.S;
        }

        public final a H1(int i) {
            this.q = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final boolean I() {
            return this.x0;
        }

        public final Float I0() {
            return this.R;
        }

        public final a I1(int i) {
            this.o = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final boolean J() {
            return this.w0;
        }

        public final float J0() {
            return this.O;
        }

        public final a J1(int i) {
            this.n = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final float K() {
            return this.f0;
        }

        public final int K0() {
            return this.P;
        }

        public final a K1(int i) {
            this.p = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int L() {
            return this.i;
        }

        public final Typeface L0() {
            return this.Q;
        }

        public final a L1(int i) {
            this.d = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int M() {
            return this.b0;
        }

        public final int M0() {
            return this.b;
        }

        public final a M1(int i) {
            if (i <= 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The width of the balloon must bigger than zero.".toString());
            }
            this.h = i;
            return this;
        }

        public final Drawable N() {
            return this.W;
        }

        public final float N0() {
            return this.e;
        }

        public final /* synthetic */ a N1(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "block");
            this.p0 = new K20(ua2);
            return this;
        }

        public final C22301v03 O() {
            return this.c0;
        }

        public final boolean O0() {
            return this.V0;
        }

        public final a O1(int i) {
            this.m = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final EnumC22897w03 P() {
            return this.X;
        }

        public final boolean P0() {
            return this.T0;
        }

        public final a P1(int i) {
            Q1(i);
            S1(i);
            return this;
        }

        public final int Q() {
            return this.Z;
        }

        public final boolean Q0() {
            return this.R0;
        }

        public final a Q1(int i) {
            this.j = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int R() {
            return this.a0;
        }

        public final boolean R0() {
            return this.U0;
        }

        public final /* synthetic */ void R1(int i) {
            this.j = i;
        }

        public final int S() {
            return this.Y;
        }

        public final boolean S0() {
            return this.r;
        }

        public final a S1(int i) {
            this.l = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final View T() {
            return this.g0;
        }

        public final boolean T0() {
            return this.i0;
        }

        public final /* synthetic */ void T1(int i) {
            this.l = i;
        }

        public final Integer U() {
            return this.h0;
        }

        public final a U0(int i) {
            this.s = i;
            return this;
        }

        public final a U1(int i) {
            this.k = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final InterfaceC18042nz3 V() {
            return this.F0;
        }

        public final a V0(Drawable drawable) {
            this.z = drawable != null ? drawable.mutate() : null;
            if (drawable != null && this.u == Integer.MIN_VALUE) {
                this.u = Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            return this;
        }

        public final a V1(int i) {
            U1(i);
            O1(i);
            return this;
        }

        public final InterfaceC18633oz3 W() {
            return this.E0;
        }

        public final a W0(int i) {
            V0(AbstractC4511Fl1.a(this.a, i));
            return this;
        }

        public final /* synthetic */ void W1(int i) {
            this.S0 = i;
        }

        public final int X() {
            return this.q;
        }

        public final a X0(EnumC11622dK enumC11622dK) {
            AbstractC13042fc3.i(enumC11622dK, "value");
            this.y = enumC11622dK;
            return this;
        }

        public final a X1(CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "value");
            this.K = charSequence;
            return this;
        }

        public final int Y() {
            return this.o;
        }

        public final /* synthetic */ void Y0(EnumC11622dK enumC11622dK) {
            AbstractC13042fc3.i(enumC11622dK, "<set-?>");
            this.y = enumC11622dK;
        }

        public final /* synthetic */ void Y1(CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "<set-?>");
            this.K = charSequence;
        }

        public final int Z() {
            return this.n;
        }

        public final /* synthetic */ void Z0(EnumC12265eK enumC12265eK) {
            AbstractC13042fc3.i(enumC12265eK, "<set-?>");
            this.x = enumC12265eK;
        }

        public final a Z1(int i) {
            this.L = i;
            return this;
        }

        public final D20 a() {
            return new D20(this.a, this, null);
        }

        public final int a0() {
            return this.p;
        }

        public final a a1(float f) {
            this.v = f;
            return this;
        }

        public final /* synthetic */ void a2(int i) {
            this.L = i;
        }

        public final float b() {
            return this.e0;
        }

        public final int b0() {
            return this.d;
        }

        public final /* synthetic */ void b1(float f) {
            this.v = f;
        }

        public final a b2(int i) {
            this.U = i;
            return this;
        }

        public final int c() {
            return this.E;
        }

        public final float c0() {
            return this.g;
        }

        public final a c1(EnumC12874fK enumC12874fK) {
            AbstractC13042fc3.i(enumC12874fK, "value");
            this.w = enumC12874fK;
            return this;
        }

        public final a c2(boolean z) {
            this.M = z;
            return this;
        }

        public final float d() {
            return this.F;
        }

        public final int d0() {
            return this.c;
        }

        public final a d1(int i) {
            int iD = RecyclerView.UNDEFINED_DURATION;
            if (i != Integer.MIN_VALUE) {
                iD = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            }
            this.u = iD;
            return this;
        }

        public final a d2(int i) {
            String string = this.a.getString(i);
            AbstractC13042fc3.h(string, "getString(...)");
            this.K = string;
            return this;
        }

        public final int e() {
            return this.D;
        }

        public final float e0() {
            return this.f;
        }

        public final a e1(int i) {
            this.C = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final a e2(float f) {
            this.O = f;
            return this;
        }

        public final int f() {
            return this.s;
        }

        public final MovementMethod f0() {
            return this.N;
        }

        public final a f1(long j) {
            this.D0 = j;
            return this;
        }

        public final /* synthetic */ void f2(float f) {
            this.O = f;
        }

        public final boolean g() {
            return this.t;
        }

        public final BI4 g0() {
            return this.p0;
        }

        public final a g1(int i) {
            this.H = i;
            return this;
        }

        public final a g2(int i) {
            this.P = i;
            return this;
        }

        public final Drawable h() {
            return this.z;
        }

        public final CI4 h0() {
            return this.q0;
        }

        public final /* synthetic */ void h1(int i) {
            this.H = i;
        }

        public final a h2(Typeface typeface) {
            AbstractC13042fc3.i(typeface, "value");
            this.Q = typeface;
            return this;
        }

        public final float i() {
            return this.G;
        }

        public final DI4 i0() {
            return this.r0;
        }

        public final a i1(F20 f20) {
            AbstractC13042fc3.i(f20, "value");
            this.I0 = f20;
            if (f20 == F20.d) {
                s1(false);
            }
            return this;
        }

        public final /* synthetic */ void i2(Typeface typeface) {
            this.Q = typeface;
        }

        public final int j() {
            return this.A;
        }

        public final EI4 j0() {
            return this.s0;
        }

        public final /* synthetic */ void j1(F20 f20) {
            AbstractC13042fc3.i(f20, "<set-?>");
            this.I0 = f20;
        }

        public final /* synthetic */ void j2(boolean z) {
            this.i0 = z;
        }

        public final EnumC11622dK k() {
            return this.y;
        }

        public final FI4 k0() {
            return this.v0;
        }

        public final a k1(I20 i20, long j) {
            AbstractC13042fc3.i(i20, "value");
            this.L0 = i20;
            this.N0 = j;
            return this;
        }

        public final a k2(int i) {
            if (i <= 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The width of the balloon must bigger than zero.".toString());
            }
            this.b = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final EnumC12265eK l() {
            return this.x;
        }

        public final View.OnTouchListener l0() {
            return this.u0;
        }

        public final a l1(float f) {
            this.J = TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
            return this;
        }

        public final /* synthetic */ void l2(int i) {
            this.b = i;
        }

        public final float m() {
            return this.v;
        }

        public final View.OnTouchListener m0() {
            return this.t0;
        }

        public final /* synthetic */ void m1(float f) {
            this.J = f;
        }

        public final EnumC12874fK n() {
            return this.w;
        }

        public final int n0() {
            return this.j0;
        }

        public final a n1(boolean z) {
            this.z0 = z;
            return this;
        }

        public final int o() {
            return this.B;
        }

        public final int o0() {
            return this.o0;
        }

        public final a o1(boolean z) {
            this.A0 = z;
            return this;
        }

        public final int p() {
            return this.u;
        }

        public final float p0() {
            return this.k0;
        }

        public final a p1(boolean z) {
            this.y0 = z;
            return this;
        }

        public final int q() {
            return this.C;
        }

        public final int q0() {
            return this.l0;
        }

        public final a q1(boolean z) {
            this.w0 = z;
            if (!z) {
                s1(z);
            }
            return this;
        }

        public final long r() {
            return this.D0;
        }

        public final Point r0() {
            return this.m0;
        }

        public final /* synthetic */ void r1(boolean z) {
            this.w0 = z;
        }

        public final int s() {
            return this.H;
        }

        public final U20 s0() {
            return this.n0;
        }

        public final a s1(boolean z) {
            this.T0 = z;
            return this;
        }

        public final Drawable t() {
            return this.I;
        }

        public final int t0() {
            return this.m;
        }

        public final /* synthetic */ void t1(boolean z) {
            this.T0 = z;
        }

        public final F20 u() {
            return this.I0;
        }

        public final int u0() {
            return this.j;
        }

        public final a u1(int i) {
            if (i <= 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
            }
            this.i = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final int v() {
            return this.G0;
        }

        public final int v0() {
            return this.l;
        }

        public final a v1(int i) {
            this.b0 = i;
            return this;
        }

        public final I20 w() {
            return this.L0;
        }

        public final int w0() {
            return this.k;
        }

        public final a w1(int i) {
            Drawable drawableA = AbstractC4511Fl1.a(this.a, i);
            this.W = drawableA != null ? drawableA.mutate() : null;
            return this;
        }

        public final long x() {
            return this.N0;
        }

        public final boolean x0() {
            return this.C0;
        }

        public final a x1(EnumC22897w03 enumC22897w03) {
            AbstractC13042fc3.i(enumC22897w03, "value");
            this.X = enumC22897w03;
            return this;
        }

        public final int y() {
            return this.M0;
        }

        public final String y0() {
            return this.O0;
        }

        public final a y1(int i) {
            this.Z = AbstractC20723sV3.d(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
            return this;
        }

        public final S20 z() {
            return this.J0;
        }

        public final SA2 z0() {
            return this.Q0;
        }

        public final a z1(int i) {
            A1(i);
            y1(i);
            return this;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC17639nJ0 invoke() {
            return DJ0.b(0, null, null, 7, null);
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20315ro1 invoke() {
            return AbstractC20906so1.a(C12366eV1.c());
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;
        public static final /* synthetic */ int[] h;

        static {
            int[] iArr = new int[EnumC11622dK.values().length];
            try {
                iArr[EnumC11622dK.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC11622dK.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC11622dK.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC11622dK.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC12874fK.values().length];
            try {
                iArr2[EnumC12874fK.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC12874fK.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
            int[] iArr3 = new int[F20.values().length];
            try {
                iArr3[F20.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[F20.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[F20.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[F20.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[F20.a.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            c = iArr3;
            int[] iArr4 = new int[S20.values().length];
            try {
                iArr4[S20.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            d = iArr4;
            int[] iArr5 = new int[I20.values().length];
            try {
                iArr5[I20.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr5[I20.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[I20.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[I20.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            e = iArr5;
            int[] iArr6 = new int[EnumC4935He5.values().length];
            try {
                iArr6[EnumC4935He5.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[EnumC4935He5.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[EnumC4935He5.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            f = iArr6;
            int[] iArr7 = new int[E20.values().length];
            try {
                iArr7[E20.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[E20.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[E20.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr7[E20.b.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            g = iArr7;
            int[] iArr8 = new int[G20.values().length];
            try {
                iArr8[G20.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr8[G20.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr8[G20.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr8[G20.b.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            h = iArr8;
        }
    }

    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RunnableC17719nS invoke() {
            return new RunnableC17719nS(D20.this);
        }
    }

    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final V20 invoke() {
            return V20.a.a(D20.this.a);
        }
    }

    public static final class h implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ long b;
        final /* synthetic */ SA2 c;

        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ SA2 a;

            public a(SA2 sa2) {
                this.a = sa2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC13042fc3.i(animator, "animation");
                super.onAnimationEnd(animator);
                this.a.invoke();
            }
        }

        public h(View view, long j, SA2 sa2) {
            this.a = view;
            this.b = j;
            this.c = sa2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.isAttachedToWindow()) {
                View view = this.a;
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + this.a.getRight()) / 2, (this.a.getTop() + this.a.getBottom()) / 2, Math.max(this.a.getWidth(), this.a.getHeight()), 0.0f);
                animatorCreateCircularReveal.setDuration(this.b);
                animatorCreateCircularReveal.start();
                animatorCreateCircularReveal.addListener(new a(this.c));
            }
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        public final void a() {
            D20.this.h = false;
            D20.this.g = null;
            D20.this.O().dismiss();
            D20.this.Y().dismiss();
            D20.this.T().removeCallbacks(D20.this.K());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        public static final j e = new j();

        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(View view) {
            super(2);
            this.e = view;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(View view, MotionEvent motionEvent) {
            boolean z;
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(motionEvent, "event");
            view.performClick();
            Rect rect = new Rect();
            this.e.getGlobalVisibleRect(rect);
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.e.getRootView().dispatchTouchEvent(motionEvent);
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class l implements View.OnTouchListener {
        final /* synthetic */ EI4 b;

        l(EI4 ei4) {
            this.b = ei4;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(motionEvent, "event");
            if (motionEvent.getAction() == 4) {
                if (D20.this.b.J()) {
                    D20.this.E();
                }
                EI4 ei4 = this.b;
                if (ei4 != null) {
                    ei4.a(view, motionEvent);
                }
                return true;
            }
            if (!D20.this.b.I() || motionEvent.getAction() != 1) {
                return false;
            }
            AbstractC13042fc3.h(D20.this.c.g, "balloonWrapper");
            if (AbstractC23199wW7.e(r0).x <= motionEvent.getRawX()) {
                AbstractC13042fc3.h(D20.this.c.g, "balloonWrapper");
                if (AbstractC23199wW7.e(r0).x + D20.this.c.g.getMeasuredWidth() >= motionEvent.getRawX()) {
                    return false;
                }
            }
            if (D20.this.b.J()) {
                D20.this.E();
            }
            EI4 ei42 = this.b;
            if (ei42 != null) {
                ei42.a(view, motionEvent);
            }
            return true;
        }
    }

    public /* synthetic */ D20(Context context, a aVar, ED1 ed1) {
        this(context, aVar);
    }

    private final XV4 A(W20 w20) {
        View viewB = w20.b();
        int iD = AbstractC20723sV3.d(viewB.getMeasuredWidth() * 0.5f);
        int iD2 = AbstractC20723sV3.d(viewB.getMeasuredHeight() * 0.5f);
        int iD3 = AbstractC20723sV3.d(W() * 0.5f);
        int iD4 = AbstractC20723sV3.d(U() * 0.5f);
        int iE = w20.e();
        int iF = w20.f();
        int i2 = e.g[w20.a().ordinal()];
        if (i2 == 1) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((iD - iD3) + iE)), Integer.valueOf((-(U() + iD2)) + iF));
        }
        if (i2 == 2) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((iD - iD3) + iE)), Integer.valueOf((-iD2) + iF));
        }
        if (i2 == 3) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((iD - W()) + iE)), Integer.valueOf(((-iD4) - iD2) + iF));
        }
        if (i2 == 4) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * (iD + iE)), Integer.valueOf(((-iD4) - iD2) + iF));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final XV4 B(W20 w20) {
        int i2 = e.f[w20.d().ordinal()];
        if (i2 == 1) {
            return AbstractC4616Fw7.a(Integer.valueOf(w20.e()), Integer.valueOf(w20.f()));
        }
        if (i2 == 2) {
            return z(w20);
        }
        if (i2 == 3) {
            return A(w20);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean C(View view) {
        if (!this.h && !this.i) {
            Context context = this.a;
            if ((!(context instanceof Activity) || !((Activity) context).isFinishing()) && this.e.getContentView().getParent() == null && AbstractC12990fW7.S(view)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(FI4 fi4, D20 d20, View view) {
        AbstractC13042fc3.i(d20, "this$0");
        if (fi4 != null) {
            fi4.a();
        }
        if (d20.b.G()) {
            d20.E();
        }
    }

    private final void D() {
        androidx.lifecycle.j lifecycle;
        c0();
        h0();
        i0();
        e0();
        d0();
        g0();
        f0();
        FrameLayout frameLayoutB = this.c.getRoot();
        AbstractC13042fc3.h(frameLayoutB, "getRoot(...)");
        v(frameLayoutB);
        if (this.b.W() == null) {
            Object obj = this.a;
            if (obj instanceof InterfaceC18633oz3) {
                this.b.G1((InterfaceC18633oz3) obj);
                androidx.lifecycle.j lifecycle2 = ((InterfaceC18633oz3) this.a).getLifecycle();
                InterfaceC18042nz3 interfaceC18042nz3V = this.b.V();
                if (interfaceC18042nz3V == null) {
                    interfaceC18042nz3V = this;
                }
                lifecycle2.a(interfaceC18042nz3V);
                return;
            }
        }
        InterfaceC18633oz3 interfaceC18633oz3W = this.b.W();
        if (interfaceC18633oz3W == null || (lifecycle = interfaceC18633oz3W.getLifecycle()) == null) {
            return;
        }
        InterfaceC18042nz3 interfaceC18042nz3V2 = this.b.V();
        if (interfaceC18042nz3V2 == null) {
            interfaceC18042nz3V2 = this;
        }
        lifecycle.a(interfaceC18042nz3V2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F0(InterfaceC14603iB2 interfaceC14603iB2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Boolean) interfaceC14603iB2.invoke(view, motionEvent)).booleanValue();
    }

    private final Bitmap G(Drawable drawable, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private final float H(View view) {
        FrameLayout frameLayout = this.c.e;
        AbstractC13042fc3.h(frameLayout, "balloonContent");
        int i2 = AbstractC23199wW7.e(frameLayout).x;
        int i3 = AbstractC23199wW7.e(view).x;
        float fX = X();
        float fW = ((W() - fX) - this.b.Z()) - this.b.Y();
        int i4 = e.b[this.b.n().ordinal()];
        if (i4 == 1) {
            return (this.c.g.getWidth() * this.b.m()) - (this.b.p() * 0.5f);
        }
        if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (view.getWidth() + i3 < i2) {
            return fX;
        }
        if (W() + i2 >= i3) {
            float f2 = i3;
            float f3 = i2;
            float width = (((view.getWidth() * this.b.m()) + f2) - f3) - (this.b.p() * 0.5f);
            float width2 = f2 + (view.getWidth() * this.b.m());
            if (width2 - (this.b.p() * 0.5f) <= f3) {
                return 0.0f;
            }
            if (width2 - (this.b.p() * 0.5f) > f3 && view.getWidth() <= (W() - this.b.Z()) - this.b.Y()) {
                return (width2 - (this.b.p() * 0.5f)) - f3;
            }
            if (width <= S()) {
                return fX;
            }
            if (width <= W() - S()) {
                return width;
            }
        }
        return fW;
    }

    private final void H0(final W20 w20) {
        final View viewB = w20.b();
        if (C(viewB)) {
            viewB.post(new Runnable() { // from class: ir.nasim.x20
                @Override // java.lang.Runnable
                public final void run() {
                    D20.I0(this.a, viewB, w20);
                }
            });
        } else if (this.b.H()) {
            E();
        }
    }

    private final float I(View view) {
        int iD = AbstractC23199wW7.d(view, this.b.R0());
        FrameLayout frameLayout = this.c.e;
        AbstractC13042fc3.h(frameLayout, "balloonContent");
        int i2 = AbstractC23199wW7.e(frameLayout).y - iD;
        int i3 = AbstractC23199wW7.e(view).y - iD;
        float fX = X();
        float fU = ((U() - fX) - this.b.a0()) - this.b.X();
        int iP = this.b.p() / 2;
        int i4 = e.b[this.b.n().ordinal()];
        if (i4 == 1) {
            return (this.c.g.getHeight() * this.b.m()) - iP;
        }
        if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (view.getHeight() + i3 < i2) {
            return fX;
        }
        if (U() + i2 >= i3) {
            float height = (((view.getHeight() * this.b.m()) + i3) - i2) - iP;
            if (height <= S()) {
                return fX;
            }
            if (height <= U() - S()) {
                return height;
            }
        }
        return fU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(D20 d20, View view, W20 w20) {
        AbstractC13042fc3.i(d20, "this$0");
        AbstractC13042fc3.i(view, "$mainAnchor");
        AbstractC13042fc3.i(w20, "$placement");
        boolean zC = d20.C(view);
        Boolean boolValueOf = Boolean.valueOf(zC);
        if (!zC) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            String strY0 = d20.b.y0();
            if (strY0 != null) {
                if (!d20.N().g(strY0, d20.b.A0())) {
                    SA2 sa2Z0 = d20.b.z0();
                    if (sa2Z0 != null) {
                        sa2Z0.invoke();
                        return;
                    }
                    return;
                }
                d20.N().f(strY0);
            }
            d20.h = true;
            d20.g = w20.a();
            long jR = d20.b.r();
            if (jR != -1) {
                d20.F(jR);
            }
            if (d20.Z()) {
                RadiusLayout radiusLayout = d20.c.d;
                AbstractC13042fc3.h(radiusLayout, "balloonCard");
                d20.T0(radiusLayout);
            } else {
                VectorTextView vectorTextView = d20.c.f;
                AbstractC13042fc3.h(vectorTextView, "balloonText");
                RadiusLayout radiusLayout2 = d20.c.d;
                AbstractC13042fc3.h(radiusLayout2, "balloonCard");
                d20.n0(vectorTextView, radiusLayout2);
            }
            d20.c.getRoot().measure(0, 0);
            d20.e.setWidth(d20.W());
            d20.e.setHeight(d20.U());
            d20.c.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            d20.a0(view);
            d20.d0();
            d20.x();
            d20.O0(view, w20.c());
            d20.o0(view);
            d20.w();
            d20.P0();
            XV4 xv4B = d20.B(w20);
            d20.e.showAsDropDown(view, ((Number) xv4B.a()).intValue(), ((Number) xv4B.b()).intValue());
        }
    }

    private final BitmapDrawable J(ImageView imageView, float f2, float f3) {
        if (this.b.g() && AbstractC12868fJ2.a()) {
            return new BitmapDrawable(imageView.getResources(), t(imageView, f2, f3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RunnableC17719nS K() {
        return (RunnableC17719nS) this.l.getValue();
    }

    public static /* synthetic */ void K0(D20 d20, View view, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        d20.J0(view, i2, i3);
    }

    private final Animation M() {
        int iY;
        if (this.b.y() == Integer.MIN_VALUE) {
            int i2 = e.e[this.b.w().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = e.a[this.b.k().ordinal()];
                    if (i3 == 1) {
                        iY = AbstractC8699Wz5.balloon_shake_top;
                    } else if (i3 == 2) {
                        iY = AbstractC8699Wz5.balloon_shake_bottom;
                    } else if (i3 == 3) {
                        iY = AbstractC8699Wz5.balloon_shake_right;
                    } else {
                        if (i3 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        iY = AbstractC8699Wz5.balloon_shake_left;
                    }
                } else {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        this.b.B();
                        return null;
                    }
                    iY = AbstractC8699Wz5.balloon_fade;
                }
            } else if (this.b.S0()) {
                int i4 = e.a[this.b.k().ordinal()];
                if (i4 == 1) {
                    iY = AbstractC8699Wz5.balloon_heartbeat_top;
                } else if (i4 == 2) {
                    iY = AbstractC8699Wz5.balloon_heartbeat_bottom;
                } else if (i4 == 3) {
                    iY = AbstractC8699Wz5.balloon_heartbeat_right;
                } else {
                    if (i4 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    iY = AbstractC8699Wz5.balloon_heartbeat_left;
                }
            } else {
                iY = AbstractC8699Wz5.balloon_heartbeat_center;
            }
        } else {
            iY = this.b.y();
        }
        return AnimationUtils.loadAnimation(this.a, iY);
    }

    private final V20 N() {
        return (V20) this.m.getValue();
    }

    public static /* synthetic */ void N0(D20 d20, View view, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        d20.M0(view, i2, i3);
    }

    private final void O0(View view, List list) {
        if (this.b.T0()) {
            if (list.isEmpty()) {
                this.d.b.setAnchorView(view);
            } else {
                this.d.b.setAnchorViewList(AbstractC15401jX0.S0(list, view));
            }
            this.f.showAtLocation(view, this.b.o0(), 0, 0);
        }
    }

    private final XV4 P(float f2, float f3) {
        int pixel;
        int pixel2;
        Drawable background = this.c.d.getBackground();
        AbstractC13042fc3.h(background, "getBackground(...)");
        Bitmap bitmapG = G(background, this.c.d.getWidth() + 1, this.c.d.getHeight() + 1);
        int i2 = e.a[this.b.k().ordinal()];
        if (i2 == 1 || i2 == 2) {
            int i3 = (int) f3;
            pixel = bitmapG.getPixel((int) ((this.b.p() * 0.5f) + f2), i3);
            pixel2 = bitmapG.getPixel((int) (f2 - (this.b.p() * 0.5f)), i3);
        } else {
            if (i2 != 3 && i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int i4 = (int) f2;
            pixel = bitmapG.getPixel(i4, (int) ((this.b.p() * 0.5f) + f3));
            pixel2 = bitmapG.getPixel(i4, (int) (f3 - (this.b.p() * 0.5f)));
        }
        return new XV4(Integer.valueOf(pixel), Integer.valueOf(pixel2));
    }

    private final void P0() {
        this.c.b.post(new Runnable() { // from class: ir.nasim.A20
            @Override // java.lang.Runnable
            public final void run() {
                D20.Q0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(final D20 d20) {
        AbstractC13042fc3.i(d20, "this$0");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ir.nasim.C20
            @Override // java.lang.Runnable
            public final void run() {
                D20.R0(this.a);
            }
        }, d20.b.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(D20 d20) {
        AbstractC13042fc3.i(d20, "this$0");
        Animation animationM = d20.M();
        if (animationM != null) {
            d20.c.b.startAnimation(animationM);
        }
    }

    private final int S() {
        return this.b.p() * 2;
    }

    private final void S0() {
        FrameLayout frameLayout = this.c.b;
        Animation animation = frameLayout.getAnimation();
        if (animation != null) {
            AbstractC13042fc3.f(animation);
            animation.cancel();
            animation.reset();
        }
        frameLayout.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler T() {
        return (Handler) this.k.getValue();
    }

    private final void T0(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            AbstractC13042fc3.h(childAt, "getChildAt(index)");
            if (childAt instanceof TextView) {
                n0((TextView) childAt, viewGroup);
            } else if (childAt instanceof ViewGroup) {
                T0((ViewGroup) childAt);
            }
        }
    }

    private final void U0(W20 w20) {
        if (this.h) {
            W0(w20.b());
            XV4 xv4B = B(w20);
            this.e.update(w20.b(), ((Number) xv4B.a()).intValue(), ((Number) xv4B.b()).intValue(), W(), U());
            if (this.b.T0()) {
                this.d.b.b();
            }
        }
    }

    private final int V(int i2, View view) {
        int iZ;
        int iP;
        int iN0;
        int i3 = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        if (this.b.N() != null) {
            iZ = this.b.S();
            iP = this.b.R();
        } else {
            iZ = this.b.Z() + this.b.Y();
            iP = this.b.p() * 2;
        }
        int i4 = paddingLeft + iZ + iP;
        int iB0 = this.b.b0() - i4;
        if (this.b.N0() != 0.0f) {
            iN0 = (int) (i3 * this.b.N0());
        } else {
            if (this.b.e0() != 0.0f || this.b.c0() != 0.0f) {
                return AbstractC23053wG5.i(i2, ((int) (i3 * (this.b.c0() == 0.0f ? 1.0f : this.b.c0()))) - i4);
            }
            if (this.b.M0() == Integer.MIN_VALUE || this.b.M0() > i3) {
                return AbstractC23053wG5.i(i2, iB0);
            }
            iN0 = this.b.M0();
        }
        return iN0 - i4;
    }

    private final void W0(View view) {
        ImageView imageView = this.c.c;
        int i2 = e.a[EnumC11622dK.a.a(this.b.k(), this.b.Q0()).ordinal()];
        if (i2 == 1) {
            imageView.setRotation(180.0f);
            imageView.setX(H(view));
            imageView.setY((this.c.d.getY() + this.c.d.getHeight()) - 1);
            AbstractC12990fW7.x0(imageView, this.b.i());
            AbstractC13042fc3.f(imageView);
            imageView.setForeground(J(imageView, imageView.getX(), this.c.d.getHeight()));
            return;
        }
        if (i2 == 2) {
            imageView.setRotation(0.0f);
            imageView.setX(H(view));
            imageView.setY((this.c.d.getY() - this.b.p()) + 1);
            AbstractC13042fc3.f(imageView);
            imageView.setForeground(J(imageView, imageView.getX(), 0.0f));
            return;
        }
        if (i2 == 3) {
            imageView.setRotation(-90.0f);
            imageView.setX((this.c.d.getX() - this.b.p()) + 1);
            imageView.setY(I(view));
            AbstractC13042fc3.f(imageView);
            imageView.setForeground(J(imageView, 0.0f, imageView.getY()));
            return;
        }
        if (i2 != 4) {
            return;
        }
        imageView.setRotation(90.0f);
        imageView.setX((this.c.d.getX() + this.c.d.getWidth()) - 1);
        imageView.setY(I(view));
        AbstractC13042fc3.f(imageView);
        imageView.setForeground(J(imageView, this.c.d.getWidth(), imageView.getY()));
    }

    private final float X() {
        return (this.b.p() * this.b.d()) + this.b.c();
    }

    private final boolean Z() {
        return (this.b.U() == null && this.b.T() == null) ? false : true;
    }

    private final void a0(final View view) {
        final ImageView imageView = this.c.c;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(this.b.p(), this.b.p()));
        imageView.setAlpha(this.b.b());
        Drawable drawableH = this.b.h();
        if (drawableH != null) {
            imageView.setImageDrawable(drawableH);
        }
        imageView.setPadding(this.b.j(), this.b.q(), this.b.o(), this.b.e());
        if (this.b.f() != Integer.MIN_VALUE) {
            AbstractC14525i33.c(imageView, ColorStateList.valueOf(this.b.f()));
        } else {
            AbstractC14525i33.c(imageView, ColorStateList.valueOf(this.b.s()));
        }
        imageView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        this.c.d.post(new Runnable() { // from class: ir.nasim.B20
            @Override // java.lang.Runnable
            public final void run() {
                D20.b0(this.a, view, imageView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(D20 d20, View view, ImageView imageView) {
        AbstractC13042fc3.i(d20, "this$0");
        AbstractC13042fc3.i(view, "$anchor");
        AbstractC13042fc3.i(imageView, "$this_with");
        DI4 di4 = d20.j;
        if (di4 != null) {
            di4.a(d20.Q());
        }
        d20.u(view);
        d20.W0(view);
        AbstractC23199wW7.f(imageView, d20.b.S0());
    }

    private final void c0() {
        RadiusLayout radiusLayout = this.c.d;
        radiusLayout.setAlpha(this.b.b());
        radiusLayout.setRadius(this.b.D());
        AbstractC12990fW7.x0(radiusLayout, this.b.K());
        Drawable drawableT = this.b.t();
        Drawable drawable = drawableT;
        if (drawableT == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.b.s());
            gradientDrawable.setCornerRadius(this.b.D());
            drawable = gradientDrawable;
        }
        radiusLayout.setBackground(drawable);
        radiusLayout.setPadding(this.b.u0(), this.b.w0(), this.b.v0(), this.b.t0());
    }

    private final void d0() {
        int iP = this.b.p() - 1;
        int iK = (int) this.b.K();
        FrameLayout frameLayout = this.c.e;
        int i2 = e.a[this.b.k().ordinal()];
        if (i2 == 1) {
            frameLayout.setPadding(iK, iP, iK, AbstractC23053wG5.e(iP, iK));
            return;
        }
        if (i2 == 2) {
            frameLayout.setPadding(iK, iP, iK, AbstractC23053wG5.e(iP, iK));
        } else if (i2 == 3) {
            frameLayout.setPadding(iP, iK, iP, iK);
        } else {
            if (i2 != 4) {
                return;
            }
            frameLayout.setPadding(iP, iK, iP, iK);
        }
    }

    private final void e0() {
        if (Z()) {
            j0();
        } else {
            k0();
            l0();
        }
    }

    private final void f0() {
        r0(this.b.g0());
        u0(this.b.h0());
        z0(this.b.j0());
        G0(this.b.m0());
        B0(this.b.k0());
        D0(this.b.l0());
    }

    private final void g0() {
        if (this.b.T0()) {
            BalloonAnchorOverlayView balloonAnchorOverlayView = this.d.b;
            balloonAnchorOverlayView.setOverlayColor(this.b.n0());
            balloonAnchorOverlayView.setOverlayPadding(this.b.p0());
            balloonAnchorOverlayView.setOverlayPosition(this.b.r0());
            balloonAnchorOverlayView.setBalloonOverlayShape(this.b.s0());
            balloonAnchorOverlayView.setOverlayPaddingColor(this.b.q0());
            this.f.setClippingEnabled(false);
        }
    }

    private final void h0() {
        ViewGroup.LayoutParams layoutParams = this.c.g.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(this.b.Y(), this.b.a0(), this.b.Z(), this.b.X());
    }

    private final void i0() {
        PopupWindow popupWindow = this.e;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(this.b.P0());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(this.b.K());
        p0(this.b.O0());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j0() {
        /*
            r4 = this;
            ir.nasim.D20$a r0 = r4.b
            java.lang.Integer r0 = r0.U()
            if (r0 == 0) goto L1d
            int r0 = r0.intValue()
            android.content.Context r1 = r4.a
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            ir.nasim.P20 r2 = r4.c
            com.skydoves.balloon.radius.RadiusLayout r2 = r2.d
            r3 = 0
            android.view.View r0 = r1.inflate(r0, r2, r3)
            if (r0 != 0) goto L25
        L1d:
            ir.nasim.D20$a r0 = r4.b
            android.view.View r0 = r0.T()
            if (r0 == 0) goto L51
        L25:
            android.view.ViewParent r1 = r0.getParent()
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L30
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L31
        L30:
            r1 = 0
        L31:
            if (r1 == 0) goto L36
            r1.removeView(r0)
        L36:
            ir.nasim.P20 r1 = r4.c
            com.skydoves.balloon.radius.RadiusLayout r1 = r1.d
            r1.removeAllViews()
            ir.nasim.P20 r1 = r4.c
            com.skydoves.balloon.radius.RadiusLayout r1 = r1.d
            r1.addView(r0)
            ir.nasim.P20 r0 = r4.c
            com.skydoves.balloon.radius.RadiusLayout r0 = r0.d
            java.lang.String r1 = "balloonCard"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            r4.T0(r0)
            return
        L51:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The custom layout is null."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D20.j0():void");
    }

    private final void k0() {
        C19938rB7 c19938rB7;
        VectorTextView vectorTextView = this.c.f;
        C22301v03 c22301v03O = this.b.O();
        if (c22301v03O != null) {
            AbstractC13042fc3.f(vectorTextView);
            AbstractC16166ko7.b(vectorTextView, c22301v03O);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            AbstractC13042fc3.f(vectorTextView);
            Context context = vectorTextView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            C22301v03.a aVar = new C22301v03.a(context);
            aVar.j(this.b.N());
            aVar.o(this.b.S());
            aVar.m(this.b.Q());
            aVar.l(this.b.M());
            aVar.n(this.b.R());
            aVar.k(this.b.P());
            AbstractC16166ko7.b(vectorTextView, aVar.a());
        }
        vectorTextView.s(this.b.Q0());
    }

    private final void l0() {
        C19938rB7 c19938rB7;
        VectorTextView vectorTextView = this.c.f;
        C3351Am7 c3351Am7E0 = this.b.E0();
        if (c3351Am7E0 != null) {
            AbstractC13042fc3.f(vectorTextView);
            AbstractC16166ko7.c(vectorTextView, c3351Am7E0);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            AbstractC13042fc3.f(vectorTextView);
            Context context = vectorTextView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            C3351Am7.a aVar = new C3351Am7.a(context);
            aVar.m(this.b.C0());
            aVar.s(this.b.J0());
            aVar.n(this.b.D0());
            aVar.p(this.b.G0());
            aVar.o(this.b.F0());
            aVar.t(this.b.K0());
            aVar.u(this.b.L0());
            aVar.r(this.b.I0());
            aVar.q(this.b.H0());
            vectorTextView.setMovementMethod(this.b.f0());
            AbstractC16166ko7.c(vectorTextView, aVar.a());
        }
        AbstractC13042fc3.f(vectorTextView);
        RadiusLayout radiusLayout = this.c.d;
        AbstractC13042fc3.h(radiusLayout, "balloonCard");
        n0(vectorTextView, radiusLayout);
    }

    private final void n0(TextView textView, View view) {
        int iC;
        int compoundPaddingStart;
        int compoundPaddingEnd;
        int iMeasureText = (int) textView.getPaint().measureText(textView.getText().toString());
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        AbstractC13042fc3.h(compoundDrawablesRelative, "getCompoundDrawablesRelative(...)");
        if (!AbstractC24076y02.e(compoundDrawablesRelative)) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            AbstractC13042fc3.h(compoundDrawables, "getCompoundDrawables(...)");
            if (AbstractC24076y02.e(compoundDrawables)) {
                Drawable[] compoundDrawables2 = textView.getCompoundDrawables();
                AbstractC13042fc3.h(compoundDrawables2, "getCompoundDrawables(...)");
                textView.setMinHeight(AbstractC24076y02.b(compoundDrawables2));
                Drawable[] compoundDrawables3 = textView.getCompoundDrawables();
                AbstractC13042fc3.h(compoundDrawables3, "getCompoundDrawables(...)");
                iC = AbstractC24076y02.c(compoundDrawables3);
                compoundPaddingStart = textView.getCompoundPaddingStart();
                compoundPaddingEnd = textView.getCompoundPaddingEnd();
            }
            textView.setMaxWidth(V(iMeasureText, view));
        }
        Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
        AbstractC13042fc3.h(compoundDrawablesRelative2, "getCompoundDrawablesRelative(...)");
        textView.setMinHeight(AbstractC24076y02.b(compoundDrawablesRelative2));
        Drawable[] compoundDrawablesRelative3 = textView.getCompoundDrawablesRelative();
        AbstractC13042fc3.h(compoundDrawablesRelative3, "getCompoundDrawablesRelative(...)");
        iC = AbstractC24076y02.c(compoundDrawablesRelative3);
        compoundPaddingStart = textView.getCompoundPaddingStart();
        compoundPaddingEnd = textView.getCompoundPaddingEnd();
        iMeasureText += iC + compoundPaddingStart + compoundPaddingEnd;
        textView.setMaxWidth(V(iMeasureText, view));
    }

    private final void o0(View view) {
        if (this.b.x0()) {
            E0(new k(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BI4 bi4, D20 d20, View view) {
        AbstractC13042fc3.i(d20, "this$0");
        if (bi4 != null) {
            AbstractC13042fc3.f(view);
            bi4.a(view);
        }
        if (d20.b.E()) {
            d20.E();
        }
    }

    private final Bitmap t(ImageView imageView, float f2, float f3) {
        LinearGradient linearGradient;
        int iS = this.b.s();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(iS, mode);
        Drawable drawable = imageView.getDrawable();
        AbstractC13042fc3.h(drawable, "getDrawable(...)");
        Bitmap bitmapG = G(drawable, imageView.getDrawable().getIntrinsicWidth(), imageView.getDrawable().getIntrinsicHeight());
        try {
            XV4 xv4P = P(f2, f3);
            int iIntValue = ((Number) xv4P.e()).intValue();
            int iIntValue2 = ((Number) xv4P.f()).intValue();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapG.getWidth(), bitmapG.getHeight(), Bitmap.Config.ARGB_8888);
            AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapG, 0.0f, 0.0f, (Paint) null);
            Paint paint = new Paint();
            int i2 = e.a[this.b.k().ordinal()];
            if (i2 == 1) {
                linearGradient = new LinearGradient((bitmapG.getWidth() / 2) - (this.b.p() * 0.5f), 0.0f, bitmapG.getWidth(), 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    linearGradient = new LinearGradient((bitmapG.getWidth() / 2) - (this.b.p() * 0.5f), 0.0f, bitmapG.getWidth(), 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
                }
                linearGradient = new LinearGradient((this.b.p() * 0.5f) + (bitmapG.getWidth() / 2), 0.0f, 0.0f, 0.0f, iIntValue, iIntValue2, Shader.TileMode.CLAMP);
            }
            paint.setShader(linearGradient);
            paint.setXfermode(new PorterDuffXfermode(mode));
            canvas.drawRect(0.0f, 0.0f, bitmapG.getWidth(), bitmapG.getHeight(), paint);
            imageView.setColorFilter(0, mode);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Arrow attached outside balloon. Could not get a matching color.");
        }
    }

    private final void u(View view) {
        if (this.b.l() == EnumC12265eK.b) {
            return;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int[] iArr = {0, 0};
        this.e.getContentView().getLocationOnScreen(iArr);
        EnumC11622dK enumC11622dKK = this.b.k();
        EnumC11622dK enumC11622dK = EnumC11622dK.c;
        if (enumC11622dKK == enumC11622dK && iArr[1] < rect.bottom) {
            this.b.X0(EnumC11622dK.b);
        } else if (this.b.k() == EnumC11622dK.b && iArr[1] > rect.top) {
            this.b.X0(enumC11622dK);
        }
        EnumC11622dK enumC11622dKK2 = this.b.k();
        EnumC11622dK enumC11622dK2 = EnumC11622dK.d;
        if (enumC11622dKK2 == enumC11622dK2 && iArr[0] < rect.right) {
            this.b.X0(EnumC11622dK.e);
        } else if (this.b.k() == EnumC11622dK.e && iArr[0] > rect.left) {
            this.b.X0(enumC11622dK2);
        }
        d0();
    }

    private final void v(ViewGroup viewGroup) {
        viewGroup.setFitsSystemWindows(false);
        C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, viewGroup.getChildCount());
        ArrayList<View> arrayList = new ArrayList(AbstractC10976cX0.x(c24411ya3Y, 10));
        Iterator it = c24411ya3Y.iterator();
        while (it.hasNext()) {
            arrayList.add(viewGroup.getChildAt(((AbstractC18386oa3) it).b()));
        }
        for (View view : arrayList) {
            view.setFitsSystemWindows(false);
            if (view instanceof ViewGroup) {
                v((ViewGroup) view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(D20 d20, CI4 ci4) {
        AbstractC13042fc3.i(d20, "this$0");
        d20.S0();
        d20.E();
        if (ci4 != null) {
            ci4.a();
        }
    }

    private final void w() {
        if (this.b.v() != Integer.MIN_VALUE) {
            this.e.setAnimationStyle(this.b.v());
            return;
        }
        int i2 = e.c[this.b.u().ordinal()];
        if (i2 == 1) {
            this.e.setAnimationStyle(AbstractC21849uE5.Balloon_Elastic_Anim);
            return;
        }
        if (i2 == 2) {
            View contentView = this.e.getContentView();
            AbstractC13042fc3.h(contentView, "getContentView(...)");
            AbstractC23199wW7.b(contentView, this.b.C());
            this.e.setAnimationStyle(AbstractC21849uE5.Balloon_Normal_Dispose_Anim);
            return;
        }
        if (i2 == 3) {
            this.e.setAnimationStyle(AbstractC21849uE5.Balloon_Fade_Anim);
        } else if (i2 == 4) {
            this.e.setAnimationStyle(AbstractC21849uE5.Balloon_Overshoot_Anim);
        } else {
            if (i2 != 5) {
                return;
            }
            this.e.setAnimationStyle(AbstractC21849uE5.Balloon_None_Anim);
        }
    }

    private final void x() {
        if (this.b.A() != Integer.MIN_VALUE) {
            this.f.setAnimationStyle(this.b.v());
            return;
        }
        if (e.d[this.b.z().ordinal()] == 1) {
            this.f.setAnimationStyle(AbstractC21849uE5.Balloon_Fade_Anim);
        } else {
            this.f.setAnimationStyle(AbstractC21849uE5.Balloon_Normal_Anim);
        }
    }

    private final XV4 z(W20 w20) {
        View viewB = w20.b();
        int iD = AbstractC20723sV3.d(viewB.getMeasuredWidth() * 0.5f);
        int iD2 = AbstractC20723sV3.d(viewB.getMeasuredHeight() * 0.5f);
        int iD3 = AbstractC20723sV3.d(W() * 0.5f);
        int iD4 = AbstractC20723sV3.d(U() * 0.5f);
        int iE = w20.e();
        int iF = w20.f();
        int i2 = e.g[w20.a().ordinal()];
        if (i2 == 1) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((iD - iD3) + iE)), Integer.valueOf((-(U() + viewB.getMeasuredHeight())) + iF));
        }
        if (i2 == 2) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((iD - iD3) + iE)), Integer.valueOf(iF));
        }
        if (i2 == 3) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * ((-W()) + iE)), Integer.valueOf((-(iD4 + iD2)) + iF));
        }
        if (i2 == 4) {
            return AbstractC4616Fw7.a(Integer.valueOf(this.b.B0() * (viewB.getMeasuredWidth() + iE)), Integer.valueOf((-(iD4 + iD2)) + iF));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final /* synthetic */ void A0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "block");
        B0(new O20(sa2));
    }

    public final void B0(final FI4 fi4) {
        this.d.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.w20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                D20.C0(fi4, this, view);
            }
        });
    }

    public final void D0(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.f.setTouchInterceptor(onTouchListener);
        }
    }

    public final void E() {
        if (this.h) {
            i iVar = new i();
            if (this.b.u() != F20.d) {
                iVar.invoke();
                return;
            }
            View contentView = this.e.getContentView();
            AbstractC13042fc3.h(contentView, "getContentView(...)");
            contentView.post(new h(contentView, this.b.C(), iVar));
        }
    }

    public final void E0(final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        D0(new View.OnTouchListener() { // from class: ir.nasim.v20
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return D20.F0(interfaceC14603iB2, view, motionEvent);
            }
        });
    }

    public final boolean F(long j2) {
        return T().postDelayed(K(), j2);
    }

    public final void G0(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.e.setTouchInterceptor(onTouchListener);
        }
    }

    public final void J0(View view, int i2, int i3) {
        AbstractC13042fc3.i(view, "anchor");
        H0(new W20(view, null, E20.d, i2, i3, null, 34, null));
    }

    public final View L() {
        ImageView imageView = this.c.c;
        AbstractC13042fc3.h(imageView, "balloonArrow");
        return imageView;
    }

    public final void L0(View view, int i2, int i3) {
        AbstractC13042fc3.i(view, "anchor");
        H0(new W20(view, null, E20.b, i2, i3, null, 34, null));
    }

    public final void M0(View view, int i2, int i3) {
        AbstractC13042fc3.i(view, "anchor");
        H0(new W20(view, null, E20.c, i2, i3, null, 34, null));
    }

    public final PopupWindow O() {
        return this.e;
    }

    public final ViewGroup Q() {
        RadiusLayout radiusLayout = this.c.d;
        AbstractC13042fc3.h(radiusLayout, "balloonCard");
        return radiusLayout;
    }

    public final E20 R() {
        return this.g;
    }

    public final int U() {
        return this.b.L() != Integer.MIN_VALUE ? this.b.L() : this.c.getRoot().getMeasuredHeight();
    }

    public final void V0(E20 e20, View view, int i2, int i3) {
        AbstractC13042fc3.i(e20, "align");
        AbstractC13042fc3.i(view, "anchor");
        U0(new W20(view, null, e20, i2, i3, null, 34, null));
    }

    public final int W() {
        int i2 = new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels).x;
        if (this.b.N0() != 0.0f) {
            return (int) (i2 * this.b.N0());
        }
        if (this.b.e0() == 0.0f && this.b.c0() == 0.0f) {
            return this.b.M0() != Integer.MIN_VALUE ? AbstractC23053wG5.i(this.b.M0(), i2) : AbstractC23053wG5.m(this.c.getRoot().getMeasuredWidth(), this.b.d0(), this.b.b0());
        }
        float f2 = i2;
        return AbstractC23053wG5.m(this.c.getRoot().getMeasuredWidth(), (int) (this.b.e0() * f2), (int) (f2 * (this.b.c0() == 0.0f ? 1.0f : this.b.c0())));
    }

    public final void X0(int i2, int i3) {
        this.b.M1(i2);
        if (this.c.d.getChildCount() != 0) {
            RadiusLayout radiusLayout = this.c.d;
            AbstractC13042fc3.h(radiusLayout, "balloonCard");
            View viewA = AbstractC24379yW7.a(radiusLayout, 0);
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = i2;
            layoutParams.height = i3;
            viewA.setLayoutParams(layoutParams);
        }
    }

    public final PopupWindow Y() {
        return this.f;
    }

    public final boolean m0() {
        return this.h;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        androidx.lifecycle.j lifecycle;
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        super.onDestroy(interfaceC18633oz3);
        this.i = true;
        this.f.dismiss();
        this.e.dismiss();
        InterfaceC18633oz3 interfaceC18633oz3W = this.b.W();
        if (interfaceC18633oz3W == null || (lifecycle = interfaceC18633oz3W.getLifecycle()) == null) {
            return;
        }
        lifecycle.d(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        super.onPause(interfaceC18633oz3);
        if (this.b.F()) {
            E();
        }
    }

    public final D20 p0(boolean z) {
        this.e.setAttachedInDecor(z);
        return this;
    }

    public final /* synthetic */ void q0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        r0(new K20(ua2));
    }

    public final void r0(final BI4 bi4) {
        if (bi4 != null || this.b.E()) {
            this.c.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.y20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    D20.s0(bi4, this, view);
                }
            });
        }
    }

    public final /* synthetic */ void t0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "block");
        u0(new L20(sa2));
    }

    public final void u0(final CI4 ci4) {
        this.e.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.z20
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                D20.v0(this.a, ci4);
            }
        });
    }

    public final /* synthetic */ void w0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        x0(new M20(ua2));
    }

    public final void x0(DI4 di4) {
        this.j = di4;
    }

    public final /* synthetic */ void y0(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        z0(new N20(interfaceC14603iB2));
    }

    public final void z0(EI4 ei4) {
        this.e.setTouchInterceptor(new l(ei4));
    }

    private D20(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
        P20 p20C = P20.c(LayoutInflater.from(context), null, false);
        AbstractC13042fc3.h(p20C, "inflate(...)");
        this.c = p20C;
        R20 r20C = R20.c(LayoutInflater.from(context), null, false);
        AbstractC13042fc3.h(r20C, "inflate(...)");
        this.d = r20C;
        this.e = new PopupWindow(p20C.getRoot(), -2, -2);
        this.f = new PopupWindow(r20C.getRoot(), -1, -1);
        this.j = aVar.i0();
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.k = AbstractC13269fw3.b(enumC4870Gx3, j.e);
        this.l = AbstractC13269fw3.b(enumC4870Gx3, new f());
        this.m = AbstractC13269fw3.b(enumC4870Gx3, new g());
        D();
    }
}
