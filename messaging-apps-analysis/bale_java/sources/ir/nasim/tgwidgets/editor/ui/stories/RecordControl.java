package ir.nasim.tgwidgets.editor.ui.stories;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.C13010fZ0;
import ir.nasim.C22697vg5;
import ir.nasim.C24687z23;
import ir.nasim.C5713Kn0;
import ir.nasim.C9151Ys;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class RecordControl extends View {
    private long A;
    private boolean A0;
    private float B;
    private final C9151Ys B0;
    private final C9151Ys C0;
    private float D;
    private boolean D0;
    private float[] E0;
    private final C9151Ys F0;
    private float G;
    private boolean G0;
    private float H;
    private long H0;
    private boolean I0;
    private final C9151Ys J;
    private boolean J0;
    private long K0;
    private float L0;
    private float M0;
    private boolean N0;
    private boolean O0;
    private final C9151Ys P0;
    private final C9151Ys Q0;
    private final C9151Ys R0;
    private final C9151Ys S0;
    private final C9151Ys T0;
    private final C9151Ys U0;
    private final Runnable V0;
    private final Runnable W0;
    private Path X0;
    private Path Y0;
    private final float Z0;
    private a a;
    private final C22697vg5 a1;
    private final ImageReceiver b;
    private final C22697vg5 b1;
    private final C13010fZ0 c;
    private final C22697vg5 c1;
    private final Drawable d;
    private final C22697vg5 d1;
    private final Drawable e;
    private final C22697vg5 e1;
    private final Drawable f;
    private final C22697vg5 f1;
    private final Drawable g;
    private final C22697vg5 g1;
    private final Drawable h;
    private final C22697vg5 h1;
    private final Paint i;
    private boolean i1;
    private final Paint j;
    private final Paint k;
    private final Paint l;
    private final Paint m;
    private final Paint n;
    private final Paint o;
    private final Paint p;
    private final Matrix q;
    private RadialGradient r;
    private final C5713Kn0 s;
    private final C5713Kn0 t;
    private final C5713Kn0 u;
    private float v;
    private final C9151Ys w;
    private boolean x;
    private final C9151Ys y;
    private long z;
    private float z0;

    public interface a {
        void a();

        boolean b();

        void c(boolean z);

        void d();

        void e();

        void f(long j);

        void g(boolean z, Runnable runnable);

        void h();

        void i(float f);

        void j();
    }

    public RecordControl(Context context) {
        super(context);
        ImageReceiver imageReceiver = new ImageReceiver();
        this.b = imageReceiver;
        this.i = new Paint(1);
        Paint paint = new Paint(1);
        this.j = paint;
        Paint paint2 = new Paint(1);
        this.k = paint2;
        Paint paint3 = new Paint(1);
        this.l = paint3;
        Paint paint4 = new Paint(1);
        this.m = paint4;
        Paint paint5 = new Paint(1);
        this.n = paint5;
        Paint paint6 = new Paint(1);
        this.o = paint6;
        Paint paint7 = new Paint(1);
        this.p = paint7;
        Matrix matrix = new Matrix();
        this.q = matrix;
        this.s = new C5713Kn0(this);
        this.t = new C5713Kn0(this);
        this.u = new C5713Kn0(this);
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.w = new C9151Ys(this, 0L, 310L, interpolatorC12631ew1);
        this.y = new C9151Ys(this, 0L, 330L, interpolatorC12631ew1);
        this.J = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
        this.z0 = -1.0f;
        this.A0 = true;
        this.B0 = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
        this.C0 = new C9151Ys(this, 0L, 850L, interpolatorC12631ew1);
        this.E0 = new float[2];
        this.F0 = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
        this.P0 = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
        this.Q0 = new C9151Ys(this, 0L, 650L, interpolatorC12631ew1);
        this.R0 = new C9151Ys(this, 0L, 160L, InterpolatorC12631ew1.i);
        this.S0 = new C9151Ys(this, 0L, 750L, interpolatorC12631ew1);
        this.T0 = new C9151Ys(this, 0L, 650L, interpolatorC12631ew1);
        this.U0 = new C9151Ys(this, 0L, 320L, interpolatorC12631ew1);
        this.V0 = new Runnable() { // from class: ir.nasim.WJ5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        };
        this.W0 = new Runnable() { // from class: ir.nasim.XJ5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l();
            }
        };
        this.X0 = new Path();
        this.Y0 = new Path();
        this.Z0 = 1.5707964f;
        this.a1 = new C22697vg5();
        this.b1 = new C22697vg5();
        this.c1 = new C22697vg5();
        this.d1 = new C22697vg5();
        this.e1 = new C22697vg5();
        this.f1 = new C22697vg5();
        this.g1 = new C22697vg5();
        this.h1 = new C22697vg5();
        setWillNotDraw(false);
        RadialGradient radialGradient = new RadialGradient(0.0f, 0.0f, AbstractC21455b.F(48.0f), new int[]{-577231, -577231, -1}, new float[]{0.0f, 0.64f, 1.0f}, Shader.TileMode.CLAMP);
        this.r = radialGradient;
        radialGradient.setLocalMatrix(matrix);
        paint5.setShader(this.r);
        paint.setColor(-1);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint2.setColor(-577231);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        paint2.setStyle(style);
        paint3.setColor(1677721600);
        paint4.setColor(-1);
        paint6.setColor(1493172223);
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        paint7.setColor(402653184);
        paint7.setStyle(style);
        paint7.setStrokeCap(cap);
        imageReceiver.j1(this);
        imageReceiver.E0(true);
        imageReceiver.k1(AbstractC21455b.F(6.0f));
        Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.msg_media_gallery).mutate();
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(1308622847, mode));
        C13010fZ0 c13010fZ0 = new C13010fZ0(m.W(AbstractC21455b.F(6.0f), -13750737), drawableMutate);
        this.c = c13010fZ0;
        c13010fZ0.d(false);
        c13010fZ0.e(AbstractC21455b.F(24.0f), AbstractC21455b.F(24.0f));
        Drawable drawableMutate2 = context.getResources().getDrawable(AbstractC23598xB5.msg_photo_switch2).mutate();
        this.d = drawableMutate2;
        drawableMutate2.setColorFilter(new PorterDuffColorFilter(-1, mode));
        Drawable drawableMutate3 = context.getResources().getDrawable(AbstractC23598xB5.msg_photo_switch2).mutate();
        this.e = drawableMutate3;
        drawableMutate3.setColorFilter(new PorterDuffColorFilter(-16777216, mode));
        Drawable drawableMutate4 = context.getResources().getDrawable(AbstractC23598xB5.msg_filled_unlockedrecord).mutate();
        this.f = drawableMutate4;
        drawableMutate4.setColorFilter(new PorterDuffColorFilter(-1, mode));
        Drawable drawableMutate5 = context.getResources().getDrawable(AbstractC23598xB5.msg_filled_lockedrecord).mutate();
        this.g = drawableMutate5;
        drawableMutate5.setColorFilter(new PorterDuffColorFilter(-16777216, mode));
        Drawable drawableMutate6 = context.getResources().getDrawable(AbstractC23598xB5.msg_round_pause_m).mutate();
        this.h = drawableMutate6;
        drawableMutate6.setColorFilter(new PorterDuffColorFilter(-1, mode));
        v();
    }

    private float f(C22697vg5 c22697vg5, C22697vg5 c22697vg52) {
        return AbstractC23776xV3.a(c22697vg5.a, c22697vg5.b, c22697vg52.a, c22697vg52.b);
    }

    private void g(float f, float f2, double d, float f3, C22697vg5 c22697vg5) {
        double d2 = f3;
        c22697vg5.a = (float) (f + (Math.cos(d) * d2));
        c22697vg5.b = (float) (f2 + (Math.sin(d) * d2));
    }

    private boolean h(float f, float f2, float f3, float f4, float f5, boolean z) {
        return this.D0 ? (!z || f4 - f2 <= ((float) AbstractC21455b.F(100.0f))) && Math.abs(f3 - f) <= f5 : AbstractC23776xV3.a(f, f2, f3, f4) <= f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.z = System.currentTimeMillis();
        this.D0 = true;
        a aVar = this.a;
        this.A = 0L;
        aVar.f(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        if (this.D0) {
            return;
        }
        if (this.a.b()) {
            this.N0 = true;
            this.O0 = true;
            this.a.g(true, new Runnable() { // from class: ir.nasim.ZJ5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j();
                }
            });
        } else {
            this.I0 = false;
            this.s.i(false);
            this.t.i(false);
            this.u.i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (this.D0) {
            return;
        }
        this.a.d();
        o(360.0f);
        this.I0 = false;
        this.s.i(false);
        this.t.i(false);
        this.u.i(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.D0 = false;
        this.N0 = false;
        this.H0 = SystemClock.elapsedRealtime();
        this.G0 = true;
        this.I0 = false;
        this.s.i(false);
        this.t.i(false);
        this.u.i(false);
        this.a.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.z = System.currentTimeMillis();
        this.A = 0L;
        this.D0 = true;
        this.a.f(0L);
    }

    private static void p(Drawable drawable, float f, float f2) {
        q(drawable, f, f2, Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()) / 2.0f);
    }

    private static void q(Drawable drawable, float f, float f2, float f3) {
        drawable.setBounds((int) (f - f3), (int) (f2 - f3), (int) (f + f3), (int) (f2 + f3));
    }

    public boolean i() {
        return this.J0;
    }

    public void o(float f) {
        this.w.g(f > 180.0f ? 620L : 310L);
        this.v += f;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.b.q0();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        this.b.s0();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0668  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r43) {
        /*
            Method dump skipped, instructions count: 1819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.RecordControl.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int iF = AbstractC21455b.F(100.0f);
        float f = size;
        this.B = f / 2.0f;
        this.D = iF / 2.0f;
        float fMin = Math.min(AbstractC21455b.F(135.0f), f * 0.35f);
        float f2 = this.B;
        this.G = f2 - fMin;
        float f3 = f2 + fMin;
        this.H = f3;
        q(this.d, f3, this.D, AbstractC21455b.F(14.0f));
        q(this.e, this.H, this.D, AbstractC21455b.F(14.0f));
        p(this.f, this.G, this.D);
        p(this.g, this.G, this.D);
        p(this.h, this.G, this.D);
        this.b.Y0(this.G - AbstractC21455b.F(20.0f), this.D - AbstractC21455b.F(20.0f), AbstractC21455b.F(40.0f), AbstractC21455b.F(40.0f));
        this.q.reset();
        this.q.postTranslate(this.B, this.D);
        this.r.setLocalMatrix(this.q);
        setMeasuredDimension(size, iF);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float fC = Utilities.c(motionEvent.getX() + 0.0f, this.H, this.G);
        float y = motionEvent.getY() + 0.0f;
        boolean zH = h(fC, y, this.H, this.D, AbstractC21455b.F(7.0f), true);
        if (this.G0) {
            this.s.i(false);
            this.t.i(false);
            this.u.i(false);
        } else if (action == 0 || this.I0) {
            this.s.i(h(fC, y, this.B, this.D, AbstractC21455b.F(60.0f), false));
            this.t.i(h(fC, y, this.H, this.D, AbstractC21455b.F(30.0f), true));
            this.u.i(h(fC, y, this.G, this.D, AbstractC21455b.F(30.0f), false));
        }
        if (action == 0) {
            this.I0 = true;
            this.J0 = this.s.g() || this.t.g();
            this.K0 = System.currentTimeMillis();
            this.L0 = fC;
            this.M0 = y;
            if (Math.abs(fC - this.B) < AbstractC21455b.F(50.0f)) {
                AbstractC21455b.n1(this.V0, ViewConfiguration.getLongPressTimeout());
            }
            if (this.t.g()) {
                AbstractC21455b.n1(this.W0, ViewConfiguration.getLongPressTimeout());
            }
        } else {
            if (action != 2) {
                if (action == 1 || action == 3) {
                    if (!this.I0) {
                        return false;
                    }
                    this.I0 = false;
                    this.J0 = false;
                    AbstractC21455b.t(this.V0);
                    AbstractC21455b.t(this.W0);
                    if (!this.D0 && this.u.g()) {
                        this.a.e();
                    } else if (this.D0 && this.N0) {
                        if (this.u.g()) {
                            this.N0 = false;
                            this.U0.d(1.0f, true);
                            this.a.a();
                        } else {
                            this.D0 = false;
                            this.H0 = SystemClock.elapsedRealtime();
                            this.G0 = true;
                            this.a.c(false);
                        }
                    } else if (this.s.g()) {
                        if (!this.A0 && !this.D0 && !this.N0) {
                            this.a.j();
                        } else if (this.D0) {
                            this.D0 = false;
                            this.H0 = SystemClock.elapsedRealtime();
                            this.G0 = true;
                            this.a.c(false);
                        } else if (this.a.b()) {
                            this.A = 0L;
                            this.z = System.currentTimeMillis();
                            this.O0 = false;
                            this.a.g(false, new Runnable() { // from class: ir.nasim.VJ5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.n();
                                }
                            });
                        }
                    }
                    this.N0 = false;
                    if (this.t.g()) {
                        o(180.0f);
                        this.a.h();
                    }
                    this.s.i(false);
                    this.t.i(false);
                    this.u.i(false);
                    invalidate();
                }
                this.i1 = zH;
                return z;
            }
            if (!this.I0) {
                return false;
            }
            this.L0 = Utilities.c(fC, this.H, this.G);
            this.M0 = y;
            invalidate();
            if (this.D0 && !this.i1 && zH) {
                o(180.0f);
                this.a.h();
            }
            if (this.D0 && this.N0) {
                this.a.i(Utilities.c(((this.D - AbstractC21455b.F(48.0f)) - y) / (AbstractC21455b.h.y / 2.0f), 1.0f, 0.0f));
            }
        }
        z = true;
        this.i1 = zH;
        return z;
    }

    public void r(boolean z) {
        this.z0 = -1.0f;
        this.A0 = z;
        invalidate();
    }

    public void s(float f) {
        this.z0 = f;
        invalidate();
    }

    public void setDelegate(a aVar) {
        this.a = aVar;
    }

    public void setDual(boolean z) {
        if (z != this.x) {
            this.x = z;
            invalidate();
        }
    }

    public void t() {
        if (this.D0) {
            this.D0 = false;
            this.H0 = SystemClock.elapsedRealtime();
            this.G0 = true;
            this.a.c(false);
            this.s.i(false);
            this.t.i(false);
            this.u.i(false);
            invalidate();
        }
    }

    public void u(boolean z) {
        this.G0 = false;
        if (!z) {
            this.F0.f(false, true);
        }
        invalidate();
    }

    public void v() {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2 = C.n(this.b.s()).r().e().b;
        this.b.g1(0, 0, true);
        if (arrayList2 != null && !arrayList2.isEmpty() && ((l) arrayList2.get(0)).J != null) {
            this.b.Q0(C24687z23.g(((l) arrayList2.get(0)).J.getAbsolutePath()), "80_80", null, null, this.c, 0L, null, null, 0);
            return;
        }
        MediaController.h hVar = MediaController.R0;
        MediaController.m mVar = (hVar == null || (arrayList = hVar.e) == null || arrayList.isEmpty()) ? null : (MediaController.m) hVar.e.get(0);
        if (mVar != null && (str = mVar.b) != null) {
            this.b.Q0(C24687z23.g(str), "80_80", null, null, this.c, 0L, null, null, 0);
            return;
        }
        if (mVar == null || mVar.A == null) {
            this.b.W0(this.c);
            return;
        }
        if (mVar.D) {
            this.b.Q0(C24687z23.g("vthumb://" + mVar.u + ":" + mVar.A), "80_80", null, null, this.c, 0L, null, null, 0);
            return;
        }
        this.b.g1(mVar.B, mVar.C, true);
        this.b.Q0(C24687z23.g("thumb://" + mVar.u + ":" + mVar.A), "80_80", null, null, this.c, 0L, null, null, 0);
    }
}
