package ir.nasim.tgwidgets.editor.messenger;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.AbstractC12724f57;
import ir.nasim.AbstractC18106o57;
import ir.nasim.C10743c74;
import ir.nasim.C20792sc7;
import ir.nasim.C22477vI7;
import ir.nasim.C24687z23;
import ir.nasim.PK5;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ImageReceiver implements E.d {
    private static PorterDuffColorFilter c2;
    private static PorterDuffColorFilter d2;
    private static float[] e2;
    private Drawable A;
    public BitmapShader A0;
    private Path A1;
    private BitmapShader B;
    private int B0;
    private float B1;
    private int C0;
    private int C1;
    protected int D;
    private C24687z23 D0;
    private boolean D1;
    private String E0;
    private c E1;
    private String F0;
    private float F1;
    protected int G;
    private int G0;
    private float G1;
    private C24687z23 H;
    private Drawable H0;
    private long H1;
    private BitmapShader I0;
    private byte I1;
    private String J;
    private boolean J0;
    private boolean J1;
    private Drawable K0;
    private boolean K1;
    private String L0;
    private float L1;
    private boolean M0;
    private ColorFilter M1;
    private int N0;
    private boolean N1;
    private long O0;
    private long O1;
    private int P0;
    private long P1;
    private boolean Q0;
    private int Q1;
    private boolean R0;
    private float R1;
    private boolean S0;
    private int S1;
    private boolean T0;
    private boolean U0;
    private String U1;
    private int V0;
    private ArrayList V1;
    private int W0;
    private boolean W1;
    private long X0;
    private boolean X1;
    private String Y;
    private boolean Y0;
    private boolean Y1;
    private int Z;
    private boolean Z0;
    private boolean Z1;
    List a;
    private boolean a1;
    public boolean a2;
    private int b;
    private Drawable b1;
    public int b2;
    private View c;
    private String c1;
    private int d;
    private BitmapShader d1;
    private Object e;
    private boolean e1;
    private boolean f;
    private boolean f1;
    private boolean g;
    private AbstractC18106o57 g1;
    private long h;
    private boolean h1;
    private int i;
    private boolean i1;
    private int j;
    private float j1;
    public boolean k;
    private float k1;
    private int l;
    private float l1;
    private e m;
    private float m1;
    private Object n;
    private float n1;
    private Bitmap o;
    private RectF o1;
    private BitmapShader p;
    private boolean p1;
    private ComposeShader q;
    private boolean q1;
    private Bitmap r;
    private boolean r1;
    private BitmapShader s;
    private boolean s1;
    private Canvas t;
    private int[] t1;
    private Paint u;
    private boolean u1;
    private C24687z23 v;
    private Object v1;
    private C24687z23 w;
    private Paint w1;
    private String x;
    private RectF x1;
    private String y;
    private RectF y1;
    private int z;
    private Drawable z0;
    private Matrix z1;

    public static class a {
        Paint A;
        private Path B;
        public boolean a;
        public float b;
        public long c;
        public int d;
        private AnimatedFileDrawable e;
        private RLottieDrawable f;
        private BitmapShader h;
        private Drawable i;
        private BitmapShader j;
        private Drawable k;
        private Drawable l;
        private BitmapShader m;
        private Drawable n;
        private float o;
        private float p;
        private BitmapShader q;
        public float r;
        public float s;
        public float t;
        public float u;
        private boolean v;
        private boolean w;
        private Drawable x;
        public ColorFilter z;
        private int[] g = new int[4];
        public RectF y = new RectF();

        public void H() {
            this.e = null;
            this.f = null;
            for (int i = 0; i < 4; i++) {
                int[] iArr = this.g;
                iArr[i] = iArr[i];
            }
            this.i = null;
            this.h = null;
            this.k = null;
            this.j = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.x = null;
            this.z = null;
        }

        public void I(Rect rect) {
            if (rect != null) {
                this.t = rect.left;
                this.u = rect.top;
                this.s = rect.width();
                this.r = rect.height();
            }
        }
    }

    public interface c {
        void a(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3);

        default void b(ImageReceiver imageReceiver) {
        }
    }

    public static class d extends BitmapDrawable {
        public d(Bitmap bitmap) {
            super(bitmap);
        }
    }

    private static class e {
        public C24687z23 a;
        public String b;
        public C24687z23 c;
        public String d;
        public C24687z23 e;
        public String f;
        public Drawable g;
        public long h;
        public int i;
        public Object j;
        public String k;

        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.a = null;
            this.c = null;
            this.e = null;
            this.g = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            return (this.a == null && this.c == null && this.e == null && this.g == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            C24687z23 c24687z23;
            C24687z23 c24687z232;
            C24687z23 c24687z233 = this.a;
            return ((c24687z233 == null || (c24687z233.t == null && c24687z233.g == null)) && ((c24687z23 = this.c) == null || (c24687z23.t == null && c24687z23.g == null)) && ((c24687z232 = this.e) == null || (c24687z232.t == null && c24687z232.g == null))) ? false : true;
        }
    }

    static {
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        c2 = new PorterDuffColorFilter(-2236963, mode);
        d2 = new PorterDuffColorFilter(-4473925, mode);
        e2 = new float[8];
    }

    public ImageReceiver() {
        this(null);
    }

    private void J0(Drawable drawable, BitmapShader bitmapShader) {
        if (drawable == this.z0 || drawable == this.K0) {
            this.A0 = bitmapShader;
            return;
        }
        if (drawable == this.H0) {
            this.I0 = bitmapShader;
            return;
        }
        if (drawable == this.A) {
            this.B = bitmapShader;
            if (this.p == null || !(drawable instanceof BitmapDrawable)) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.q = new ComposeShader(this.p, this.B, PorterDuff.Mode.DST_IN);
                return;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            int width = bitmapDrawable.getBitmap().getWidth();
            int height = bitmapDrawable.getBitmap().getHeight();
            Bitmap bitmap = this.r;
            if (bitmap != null && bitmap.getWidth() == width && this.r.getHeight() == height) {
                return;
            }
            Bitmap bitmap2 = this.r;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.r = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.t = new Canvas(this.r);
            Bitmap bitmap3 = this.r;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.s = new BitmapShader(bitmap3, tileMode, tileMode);
            if (this.u == null) {
                Paint paint = new Paint();
                this.u = paint;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
        }
    }

    private void b(boolean z, a aVar) throws InterruptedException {
        if (this.J1) {
            return;
        }
        float f = this.F1;
        if (f != 1.0f) {
            if (!z) {
                if (aVar != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = this.H1;
                    long j2 = jCurrentTimeMillis - j;
                    if (j == 0) {
                        j2 = 16;
                    }
                    if (j2 > 30 && AbstractC21455b.i > 60.0f) {
                        j2 = 30;
                    }
                    this.F1 += j2 / this.Q1;
                } else {
                    this.F1 = f + (16.0f / this.Q1);
                }
                if (this.F1 > 1.0f) {
                    this.F1 = 1.0f;
                    this.G1 = 1.0f;
                    if (this.b1 != null) {
                        t0(null, 2);
                        this.d1 = null;
                    }
                }
            }
            if (aVar != null) {
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.R23
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h0();
                    }
                });
            } else {
                h0();
            }
        }
    }

    private void g(Canvas canvas, BitmapDrawable bitmapDrawable, a aVar, int i) throws InterruptedException {
        if (aVar == null) {
            bitmapDrawable.setAlpha(i);
            if (bitmapDrawable instanceof RLottieDrawable) {
                ((RLottieDrawable) bitmapDrawable).F(canvas, null, false, this.h, 0);
                return;
            } else if (bitmapDrawable instanceof AnimatedFileDrawable) {
                ((AnimatedFileDrawable) bitmapDrawable).t0(canvas, false, this.h, 0);
                return;
            } else {
                bitmapDrawable.draw(canvas);
                return;
            }
        }
        if (bitmapDrawable instanceof RLottieDrawable) {
            ((RLottieDrawable) bitmapDrawable).E(canvas, aVar.t, aVar.u, aVar.s, aVar.r, i, aVar.z, aVar.d);
            return;
        }
        if (bitmapDrawable instanceof AnimatedFileDrawable) {
            ((AnimatedFileDrawable) bitmapDrawable).s0(canvas, aVar.t, aVar.u, aVar.s, aVar.r, i, aVar.z, aVar.d);
            return;
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (bitmap != null) {
            if (aVar.A == null) {
                aVar.A = new Paint(1);
            }
            aVar.A.setAlpha(i);
            aVar.A.setColorFilter(aVar.z);
            canvas.save();
            canvas.translate(aVar.t, aVar.u);
            canvas.scale(aVar.s / bitmap.getWidth(), aVar.r / bitmap.getHeight());
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, aVar.A);
            canvas.restore();
        }
    }

    private boolean g0() {
        return true;
    }

    private void i(Canvas canvas, Drawable drawable, int i, BitmapShader bitmapShader, int i2, int i3, a aVar) throws InterruptedException {
        if (this.C1 == 0) {
            float f = this.R1;
            if (f != 0.0f) {
                float f2 = f - 0.10666667f;
                this.R1 = f2;
                if (f2 < 0.0f) {
                    this.R1 = 0.0f;
                }
                h0();
            }
        }
        int i4 = this.C1;
        if (i4 != 0) {
            this.R1 = 1.0f;
            this.S1 = i4;
        }
        float f3 = this.R1;
        if (f3 == 0.0f || f3 == 1.0f) {
            h(canvas, drawable, i, bitmapShader, i2, i3, i4, aVar);
        } else {
            h(canvas, drawable, i, bitmapShader, i2, i3, i4, aVar);
            h(canvas, drawable, (int) (i * this.R1), bitmapShader, i2, i3, this.S1, aVar);
        }
    }

    private void o1(Drawable drawable) {
        if (drawable == this.K0) {
            return;
        }
        this.K0 = drawable;
    }

    private void p0() throws InterruptedException {
        C21457d.g0().C0(this, this.a);
        h0();
    }

    private void r0(Drawable drawable) throws InterruptedException {
        if (drawable == this.H0 && this.F0 != null) {
            C21457d.g0().F0(this.F0);
            this.F0 = null;
        } else if (drawable == this.A && this.y != null) {
            C21457d.g0().F0(this.y);
            this.y = null;
        } else if (drawable == this.z0 && this.Y != null) {
            C21457d.g0().F0(this.Y);
            this.Y = null;
        }
        S0(this.D0, this.E0, this.w, this.x, this.H, this.J, this.z0, this.O0, this.L0, this.e, this.P0);
    }

    private void w1(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if ((!g0() && this.p == null) || !(drawable instanceof BitmapDrawable)) {
            J0(drawable, null);
            return;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable instanceof RLottieDrawable) {
            return;
        }
        if (bitmapDrawable instanceof AnimatedFileDrawable) {
            ((AnimatedFileDrawable) drawable).a1(this.t1);
        } else if (bitmapDrawable.getBitmap() != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            J0(drawable, new BitmapShader(bitmap, tileMode, tileMode));
        }
    }

    public String A() {
        return this.x;
    }

    public void A0(int i) {
        this.W0 = i;
        if (J() != null) {
            J().e0(i);
            return;
        }
        this.b2 = i;
        if (k() != null) {
            k().j1 = 0;
        }
    }

    public float B() {
        return this.m1;
    }

    public boolean B0() {
        e eVar = this.m;
        if (eVar == null || !eVar.e()) {
            return false;
        }
        e eVar2 = this.m;
        this.m = null;
        Drawable drawable = eVar2.g;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (!(bitmapDrawable instanceof RLottieDrawable) && !(bitmapDrawable instanceof AnimatedFileDrawable) && bitmapDrawable.getBitmap() != null && bitmapDrawable.getBitmap().isRecycled()) {
                eVar2.g = null;
            }
        }
        S0(eVar2.e, eVar2.f, eVar2.a, eVar2.b, eVar2.c, eVar2.d, eVar2.g, eVar2.h, eVar2.k, eVar2.j, eVar2.i);
        eVar2.d();
        this.m = eVar2;
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null) {
            rLottieDrawableJ.c0(this.Q0);
        }
        if (rLottieDrawableJ == null || !this.S0) {
            return true;
        }
        if (rLottieDrawableJ.N() && this.l != 0) {
            return true;
        }
        rLottieDrawableJ.start();
        return true;
    }

    public String C() {
        return this.y;
    }

    public void C0(ColorFilter colorFilter) {
        this.M1 = colorFilter;
    }

    public C24687z23 D() {
        return this.w;
    }

    public void D0(byte b2) {
        this.I1 = b2;
    }

    public float E() {
        return this.l1;
    }

    public void E0(boolean z) {
        this.Z0 = z;
    }

    public float F() {
        return this.j1;
    }

    public void F0(int i) {
        this.b = i;
    }

    public float G() {
        return this.k1;
    }

    public void G0(long j) {
        this.h = j;
    }

    public int H() {
        return this.G;
    }

    public void H0(c cVar) {
        this.E1 = cVar;
    }

    public ArrayList I() {
        return this.V1;
    }

    public a I0(a aVar, int i) {
        if (aVar == null) {
            aVar = new a();
        }
        aVar.d = i;
        aVar.e = k();
        aVar.f = J();
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            aVar.g[i2] = this.t1[i2];
        }
        aVar.i = this.H0;
        aVar.h = this.I0;
        aVar.k = this.A;
        aVar.j = this.B;
        aVar.l = this.z0;
        aVar.m = this.A0;
        aVar.n = this.K0;
        aVar.x = this.b1;
        aVar.z = this.M1;
        aVar.w = this.a1;
        aVar.v = this.Z0;
        aVar.o = this.F1;
        aVar.p = this.G1;
        aVar.q = this.d1;
        if ((aVar.e != null && !aVar.e.H0()) || (aVar.f != null && !aVar.f.K())) {
            z = true;
        }
        aVar.a = z;
        aVar.t = this.j1;
        aVar.u = this.k1;
        aVar.s = this.l1;
        aVar.r = this.m1;
        aVar.b = this.B1;
        return aVar;
    }

    public RLottieDrawable J() {
        Drawable drawable = this.H0;
        if (drawable instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable;
        }
        Drawable drawable2 = this.A;
        if (drawable2 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable2;
        }
        Drawable drawable3 = this.z0;
        if (drawable3 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable3;
        }
        Drawable drawable4 = this.K0;
        if (drawable4 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable4;
        }
        return null;
    }

    public Object K() {
        return this.v1;
    }

    public void K0(int i) {
        if (this.i != i) {
            this.i = i;
            if (this.W1) {
                C21457d.g0().P(this);
            }
        }
    }

    public Drawable L() {
        return this.H0;
    }

    public void L0(AbstractC12724f57 abstractC12724f57, Drawable drawable) throws InterruptedException {
        M0(abstractC12724f57, drawable, null);
    }

    public String M() {
        return this.E0;
    }

    public void M0(AbstractC12724f57 abstractC12724f57, Drawable drawable, Object obj) throws InterruptedException {
        N0(abstractC12724f57, drawable, obj, false, 0, false);
    }

    public String N() {
        return this.F0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N0(ir.nasim.AbstractC12724f57 r9, android.graphics.drawable.Drawable r10, java.lang.Object r11, boolean r12, int r13, boolean r14) throws java.lang.InterruptedException {
        /*
            r8 = this;
            if (r11 != 0) goto L3
            r11 = r9
        L3:
            r13 = 1
            r8.r1(r13)
            boolean r0 = r9 instanceof ir.nasim.AbstractC19652qi7
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L2f
            r0 = r9
            ir.nasim.qi7 r0 = (ir.nasim.AbstractC19652qi7) r0
            boolean r3 = r0.B
            ir.nasim.si7 r0 = r0.h
            if (r0 == 0) goto L2b
            android.graphics.drawable.BitmapDrawable r2 = r0.j
            byte[] r3 = r0.g
            if (r3 == 0) goto L1e
            r3 = r13
            goto L1f
        L1e:
            r3 = r1
        L1f:
            if (r12 == 0) goto L2c
            boolean r12 = r0.c
            if (r12 == 0) goto L2c
            r12 = 1024(0x400, float:1.435E-42)
            ir.nasim.tgwidgets.editor.messenger.v.e(r12)
            goto L2c
        L2b:
            r3 = r1
        L2c:
            r12 = r3
        L2d:
            r3 = r2
            goto L48
        L2f:
            boolean r12 = r9 instanceof ir.nasim.AbstractC15742k57
            if (r12 == 0) goto L46
            r12 = r9
            ir.nasim.k57 r12 = (ir.nasim.AbstractC15742k57) r12
            ir.nasim.l57 r12 = r12.m
            if (r12 == 0) goto L46
            android.graphics.drawable.BitmapDrawable r0 = r12.i
            byte[] r12 = r12.f
            if (r12 == 0) goto L42
            r3 = r13
            goto L43
        L42:
            r3 = r1
        L43:
            r12 = r3
            r3 = r0
            goto L48
        L46:
            r12 = r1
            goto L2d
        L48:
            if (r14 != 0) goto L53
            ir.nasim.z23 r13 = ir.nasim.C24687z23.k(r9, r13)
            java.lang.String r14 = "50_50"
        L50:
            r1 = r13
            r2 = r14
            goto L5a
        L53:
            ir.nasim.z23 r13 = ir.nasim.C24687z23.k(r9, r1)
            java.lang.String r14 = "100_100"
            goto L50
        L5a:
            if (r3 == 0) goto L64
            r4 = 0
            r6 = 0
            r0 = r8
            r5 = r11
            r0.O0(r1, r2, r3, r4, r5, r6)
            goto L7d
        L64:
            if (r12 == 0) goto L75
            r12 = 2
            ir.nasim.z23 r3 = ir.nasim.C24687z23.k(r9, r12)
            java.lang.String r4 = "50_50_b"
            r7 = 0
            r0 = r8
            r5 = r10
            r6 = r11
            r0.R0(r1, r2, r3, r4, r5, r6, r7)
            goto L7d
        L75:
            r4 = 0
            r6 = 0
            r0 = r8
            r3 = r10
            r5 = r11
            r0.O0(r1, r2, r3, r4, r5, r6)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.ImageReceiver.N0(ir.nasim.f57, android.graphics.drawable.Drawable, java.lang.Object, boolean, int, boolean):void");
    }

    public C24687z23 O() {
        return this.D0;
    }

    public void O0(C24687z23 c24687z23, String str, Drawable drawable, String str2, Object obj, int i) throws InterruptedException {
        Q0(c24687z23, str, null, null, drawable, 0L, str2, obj, i);
    }

    public int P() {
        int i = this.N0 + 1;
        this.N0 = i;
        return i;
    }

    public void P0(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, long j, String str3, Object obj, int i) throws InterruptedException {
        Q0(c24687z23, str, c24687z232, str2, null, j, str3, obj, i);
    }

    public int Q() {
        return this.D;
    }

    public void Q0(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, Drawable drawable, long j, String str3, Object obj, int i) throws InterruptedException {
        S0(null, null, c24687z23, str, c24687z232, str2, drawable, j, str3, obj, i);
    }

    public int R() {
        return this.d;
    }

    public void R0(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, Drawable drawable, Object obj, int i) throws InterruptedException {
        S0(null, null, c24687z23, str, c24687z232, str2, drawable, 0L, null, obj, i);
    }

    public Object S() {
        return this.e;
    }

    public void S0(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, C24687z23 c24687z233, String str3, Drawable drawable, long j, String str4, Object obj, int i) throws InterruptedException {
        String str5;
        boolean z;
        boolean z2;
        String str6;
        e eVar;
        C24687z23 c24687z234 = c24687z23;
        C24687z23 c24687z235 = c24687z232;
        if (this.Y1 && !this.W1) {
            if (this.m == null) {
                this.m = new e();
            }
            e eVar2 = this.m;
            eVar2.e = c24687z234;
            eVar2.f = str;
            eVar2.a = c24687z235;
            eVar2.b = str2;
            eVar2.c = c24687z233;
            eVar2.d = str3;
            eVar2.g = drawable;
            eVar2.h = j;
            eVar2.k = str4;
            eVar2.i = i;
            eVar2.j = obj;
            return;
        }
        if (this.M0) {
            return;
        }
        if (this.Z0 && (eVar = this.m) != null && eVar.f()) {
            B0();
        }
        e eVar3 = this.m;
        if (eVar3 != null) {
            eVar3.d();
        }
        if (c24687z235 == null && c24687z233 == null && c24687z234 == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                t0(null, i2);
            }
            this.w = null;
            this.x = null;
            this.y = null;
            this.D0 = null;
            this.E0 = null;
            this.F0 = null;
            this.H = null;
            this.J = null;
            this.Y = null;
            this.H0 = null;
            this.I0 = null;
            this.A = null;
            this.B = null;
            this.q = null;
            this.A0 = null;
            this.d1 = null;
            this.s = null;
            this.t = null;
            Bitmap bitmap = this.r;
            if (bitmap != null) {
                bitmap.recycle();
                this.r = null;
            }
            this.L0 = str4;
            this.e = null;
            this.P0 = 0;
            this.w1.setShader(null);
            o1(drawable);
            this.F1 = 1.0f;
            this.G1 = 1.0f;
            this.O0 = 0L;
            w1(this.K0);
            C21457d.g0().O(this, true);
            h0();
            c cVar = this.E1;
            if (cVar != null) {
                Drawable drawable2 = this.A;
                cVar.a(this, (drawable2 == null && this.z0 == null && this.K0 == null && this.H0 == null) ? false : true, drawable2 == null && this.H0 == null, false);
                return;
            }
            return;
        }
        String strM = c24687z235 != null ? c24687z235.m(obj, null, false) : null;
        if (strM == null && c24687z235 != null) {
            c24687z235 = null;
        }
        this.b2 = Math.max(this.W0, 0);
        this.h1 = false;
        if (strM == null && this.e1 && ((obj instanceof C10743c74) || this.g1 != null)) {
            AbstractC18106o57 abstractC18106o57I = this.g1;
            if (abstractC18106o57I == null) {
                abstractC18106o57I = ((C10743c74) obj).I();
            }
            if (abstractC18106o57I != null && abstractC18106o57I.m != 0 && abstractC18106o57I.c != 0) {
                strM = "q_" + abstractC18106o57I.m + "_" + abstractC18106o57I.c;
                this.h1 = true;
            }
        }
        String str7 = strM;
        if (str7 != null && str2 != null) {
            str7 = str7 + Separators.AT + str2;
        }
        if (this.U1 != null) {
            str7 = this.U1 + str7;
        }
        String strM2 = c24687z234 != null ? c24687z234.m(obj, null, false) : null;
        if (strM2 == null && c24687z234 != null) {
            c24687z234 = null;
        }
        if (strM2 != null && str != null) {
            strM2 = strM2 + Separators.AT + str;
        }
        if (this.U1 != null) {
            strM2 = this.U1 + strM2;
        }
        if ((strM2 == null && (str6 = this.y) != null && str6.equals(str7)) || ((str5 = this.F0) != null && str5.equals(strM2))) {
            c cVar2 = this.E1;
            if (cVar2 != null) {
                Drawable drawable3 = this.A;
                cVar2.a(this, (drawable3 == null && this.z0 == null && this.K0 == null && this.H0 == null) ? false : true, drawable3 == null && this.H0 == null, false);
            }
            if (!this.f) {
                return;
            }
        }
        C24687z23 c24687z236 = this.v;
        if (c24687z236 == null) {
            c24687z236 = c24687z234 != null ? c24687z234 : c24687z235;
        }
        if (c24687z236 == null) {
            c24687z236 = c24687z233;
        }
        String strM3 = c24687z233 != null ? c24687z233.m(obj, c24687z236, false) : null;
        if (strM3 != null && str3 != null) {
            strM3 = strM3 + Separators.AT + str3;
        }
        if (this.Z0) {
            Object obj2 = this.e;
            if ((obj2 instanceof C10743c74) && ((C10743c74) obj2).T != null && (C10743c74.V((C10743c74) obj2) instanceof C20792sc7)) {
                Object obj3 = this.e;
                ((C10743c74) obj3).U = ((C10743c74) obj3).T;
            }
            Drawable drawable4 = this.H0;
            if (drawable4 != null) {
                if (drawable4 instanceof AnimatedFileDrawable) {
                    ((AnimatedFileDrawable) drawable4).stop();
                    ((AnimatedFileDrawable) this.H0).P0(this);
                }
                t0(strM3, 1);
                t0(null, 2);
                t0(strM2, 0);
                this.b1 = this.H0;
                this.d1 = this.I0;
                this.c1 = this.y;
                this.a1 = false;
                this.H0 = null;
                this.F0 = null;
            } else if (this.A != null) {
                t0(strM3, 1);
                t0(null, 2);
                t0(strM2, 3);
                this.d1 = this.B;
                this.b1 = this.A;
                this.c1 = this.y;
                this.a1 = false;
                this.A = null;
                this.y = null;
            } else if (this.z0 != null) {
                t0(str7, 0);
                t0(null, 2);
                t0(strM2, 3);
                this.d1 = this.A0;
                this.b1 = this.z0;
                this.c1 = this.Y;
                this.a1 = false;
                this.z0 = null;
                this.Y = null;
            } else if (this.K0 != null) {
                t0(str7, 0);
                t0(strM3, 1);
                t0(null, 2);
                t0(strM2, 3);
                this.d1 = this.A0;
                this.b1 = this.K0;
                this.a1 = false;
                this.c1 = null;
                this.z0 = null;
                this.Y = null;
            } else {
                t0(str7, 0);
                z = true;
                t0(strM3, 1);
                t0(null, 2);
                t0(strM2, 3);
                this.d1 = null;
            }
            z = true;
        } else {
            z = true;
            t0(str7, 0);
            t0(strM3, 1);
            t0(null, 2);
            t0(strM2, 3);
            this.d1 = null;
        }
        this.w = c24687z235;
        this.x = str2;
        this.y = str7;
        this.D0 = c24687z234;
        this.E0 = str;
        this.F0 = strM2;
        this.H = c24687z233;
        this.J = str3;
        this.Y = strM3;
        this.e = obj;
        this.L0 = str4;
        this.O0 = j;
        this.P0 = i;
        o1(drawable);
        this.B = null;
        this.q = null;
        this.A0 = null;
        this.I0 = null;
        this.s = null;
        this.t = null;
        this.w1.setShader(null);
        Bitmap bitmap2 = this.r;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.r = null;
        }
        this.F1 = 1.0f;
        this.G1 = 1.0f;
        w1(this.K0);
        c cVar3 = this.E1;
        if (cVar3 != null) {
            Drawable drawable5 = this.A;
            z2 = false;
            cVar3.a(this, (drawable5 == null && this.z0 == null && this.K0 == null && this.H0 == null) ? false : z, (drawable5 == null && this.H0 == null) ? z : false, false);
        } else {
            z2 = false;
        }
        p0();
        this.N1 = ((obj instanceof C10743c74) && ((C10743c74) obj).R0()) ? z : z2;
    }

    public void T(int[] iArr) {
        View view = this.c;
        if (view == null) {
            return;
        }
        view.getLocationInWindow(iArr);
    }

    public void T0(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, String str3, Object obj, int i) throws InterruptedException {
        Q0(c24687z23, str, c24687z232, str2, null, 0L, str3, obj, i);
    }

    public AbstractC18106o57 U() {
        return this.g1;
    }

    public void U0(String str, String str2, Drawable drawable, String str3, long j) throws InterruptedException {
        Q0(C24687z23.g(str), str2, null, null, drawable, j, str3, null, 1);
    }

    public long V() {
        return this.O0;
    }

    public void V0(Bitmap bitmap) throws InterruptedException {
        W0(bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null);
    }

    public Drawable W() {
        return this.K0;
    }

    public void W0(Drawable drawable) throws InterruptedException {
        boolean z = true;
        C21457d.g0().O(this, true);
        if (!this.Z0) {
            for (int i = 0; i < 4; i++) {
                t0(null, i);
            }
        } else if (this.A != null) {
            t0(null, 1);
            t0(null, 2);
            t0(null, 3);
            this.d1 = this.B;
            this.b1 = this.A;
            this.c1 = this.y;
            this.a1 = true;
        } else if (this.z0 != null) {
            t0(null, 0);
            t0(null, 2);
            t0(null, 3);
            this.d1 = this.A0;
            this.b1 = this.z0;
            this.c1 = this.Y;
            this.a1 = true;
        } else if (this.K0 != null) {
            t0(null, 0);
            t0(null, 1);
            t0(null, 2);
            t0(null, 3);
            this.d1 = this.A0;
            this.b1 = this.K0;
            this.a1 = true;
            this.c1 = null;
        } else {
            for (int i2 = 0; i2 < 4; i2++) {
                t0(null, i2);
            }
            this.d1 = null;
        }
        Drawable drawable2 = this.K0;
        if (drawable2 instanceof PK5) {
            ((PK5) drawable2).a();
        }
        if (drawable instanceof AnimatedFileDrawable) {
            AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
            animatedFileDrawable.Z0(this.c);
            if (this.W1) {
                animatedFileDrawable.m0(this);
            }
            animatedFileDrawable.c1(this.T0 || animatedFileDrawable.W0);
            if (this.R0 && this.l == 0) {
                animatedFileDrawable.q0();
            }
            animatedFileDrawable.W0(this.U0);
        } else if (drawable instanceof RLottieDrawable) {
            RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
            if (this.W1) {
                rLottieDrawable.v(this);
            }
            if (rLottieDrawable != null) {
                rLottieDrawable.c0(this.Q0);
            }
            if (this.S0 && (!rLottieDrawable.N() || this.l == 0)) {
                rLottieDrawable.start();
            }
            rLottieDrawable.b0(true);
        }
        this.A0 = null;
        this.w1.setShader(null);
        o1(drawable);
        w1(drawable);
        this.D0 = null;
        this.E0 = null;
        Drawable drawable3 = this.H0;
        if (drawable3 instanceof AnimatedFileDrawable) {
            ((AnimatedFileDrawable) drawable3).P0(this);
        }
        this.H0 = null;
        this.F0 = null;
        this.I0 = null;
        this.w = null;
        this.x = null;
        this.A = null;
        this.y = null;
        this.B = null;
        this.q = null;
        this.s = null;
        this.t = null;
        Bitmap bitmap = this.r;
        if (bitmap != null) {
            bitmap.recycle();
            this.r = null;
        }
        this.H = null;
        this.J = null;
        this.Y = null;
        this.h1 = false;
        this.L0 = null;
        this.O0 = 0L;
        this.P0 = 0;
        this.F1 = 1.0f;
        this.G1 = 1.0f;
        e eVar = this.m;
        if (eVar != null) {
            eVar.d();
        }
        c cVar = this.E1;
        if (cVar != null) {
            cVar.a(this, (this.z0 == null && this.K0 == null) ? false : true, true, false);
        }
        h0();
        if (this.s1 && this.Z0 && this.b1 != null) {
            this.F1 = 0.0f;
            this.H1 = System.currentTimeMillis();
            if (this.z0 == null && this.K0 == null) {
                z = false;
            }
            this.K1 = z;
        }
    }

    public C24687z23 X() {
        return this.v;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean X0(android.graphics.drawable.Drawable r8, java.lang.String r9, int r10, boolean r11, int r12) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.ImageReceiver.X0(android.graphics.drawable.Drawable, java.lang.String, int, boolean, int):boolean");
    }

    protected int Y(int i) {
        return i == 1 ? this.Z : i == 3 ? this.G0 : this.z;
    }

    public void Y0(float f, float f2, float f3, float f4) {
        this.j1 = f;
        this.k1 = f2;
        this.l1 = f3;
        this.m1 = f4;
    }

    public String Z() {
        return this.J;
    }

    public void Z0(Rect rect) {
        if (rect != null) {
            this.j1 = rect.left;
            this.k1 = rect.top;
            this.l1 = rect.width();
            this.m1 = rect.height();
        }
    }

    public void a(Runnable runnable) {
        this.V1.add(runnable);
    }

    public String a0() {
        return this.Y;
    }

    public void a1(int i) {
        this.l1 = i;
    }

    public C24687z23 b0() {
        return this.H;
    }

    public void b1(int i) {
        this.j1 = i;
    }

    public void c() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            t0(null, i);
        }
        C21457d.g0().O(this, true);
    }

    public String c0() {
        return this.U1;
    }

    public void c1(boolean z) {
        this.i1 = z;
    }

    protected boolean d(Canvas canvas, AnimatedFileDrawable animatedFileDrawable, RLottieDrawable rLottieDrawable, Drawable drawable, BitmapShader bitmapShader, Drawable drawable2, BitmapShader bitmapShader2, Drawable drawable3, BitmapShader bitmapShader3, boolean z, boolean z2, Drawable drawable4, BitmapShader bitmapShader4, Drawable drawable5, float f, float f2, float f3, int[] iArr, a aVar) {
        return false;
    }

    public boolean d0() {
        return this.p1;
    }

    public void d1(int i) {
        this.j = i;
        if (this.W1) {
            this.l = E.j().i() & (~this.j);
        }
    }

    public boolean e(Canvas canvas) {
        return f(canvas, null);
    }

    public boolean e0() {
        return (this.A == null && this.z0 == null && this.K0 == null && this.H0 == null) ? false : true;
    }

    public void e1(Object obj) {
        this.v1 = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a6 A[Catch: Exception -> 0x0389, TryCatch #2 {Exception -> 0x0389, blocks: (B:170:0x03c2, B:174:0x03ce, B:161:0x036a, B:165:0x0390, B:167:0x03a6, B:168:0x03aa, B:178:0x03db, B:179:0x03f1), top: B:198:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x040c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(android.graphics.Canvas r42, ir.nasim.tgwidgets.editor.messenger.ImageReceiver.a r43) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.ImageReceiver.f(android.graphics.Canvas, ir.nasim.tgwidgets.editor.messenger.ImageReceiver$a):boolean");
    }

    public boolean f0() {
        return (this.A == null && this.H0 == null && this.z0 == null && this.K0 == null && this.y == null && this.F0 == null) ? false : true;
    }

    public void f1(boolean z) {
        this.e1 = z;
    }

    public void g1(int i, int i2, boolean z) {
        while (i < 0) {
            i += 360;
        }
        while (i > 360) {
            i -= 360;
        }
        this.B0 = i;
        this.D = i;
        this.C0 = i2;
        this.G = i2;
        this.D1 = z;
    }

    @Keep
    public float getAlpha() {
        return this.B1;
    }

    @Keep
    public float getCurrentAlpha() {
        return this.F1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:405:0x08af  */
    /* JADX WARN: Removed duplicated region for block: B:431:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v159, types: [android.graphics.RectF] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [ir.nasim.tgwidgets.editor.messenger.G$j] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.graphics.RectF] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [ir.nasim.tgwidgets.editor.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r32v0, types: [ir.nasim.tgwidgets.editor.messenger.ImageReceiver] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void h(android.graphics.Canvas r33, android.graphics.drawable.Drawable r34, int r35, android.graphics.BitmapShader r36, int r37, int r38, int r39, ir.nasim.tgwidgets.editor.messenger.ImageReceiver.a r40) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 2227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.ImageReceiver.h(android.graphics.Canvas, android.graphics.drawable.Drawable, int, android.graphics.BitmapShader, int, int, int, ir.nasim.tgwidgets.editor.messenger.ImageReceiver$a):void");
    }

    public void h0() {
        View view = this.c;
        if (view == null) {
            return;
        }
        if (this.i1) {
            view.invalidate();
            return;
        }
        float f = this.j1;
        float f2 = this.k1;
        view.invalidate((int) f, (int) f2, (int) (f + this.l1), (int) (f2 + this.m1));
    }

    public void h1(int i, boolean z) {
        g1(i, 0, z);
    }

    public boolean i0() {
        return this.W1;
    }

    public void i1(int i) {
        this.d = i;
    }

    public int j() {
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            return animatedFileDrawableK.D0();
        }
        return 0;
    }

    public boolean j0() {
        return this.h1;
    }

    public void j1(View view) {
        this.c = view;
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK == null || !this.W1) {
            return;
        }
        animatedFileDrawableK.Z0(this.c);
    }

    public AnimatedFileDrawable k() {
        Drawable drawable = this.H0;
        if (drawable instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable;
        }
        Drawable drawable2 = this.A;
        if (drawable2 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable2;
        }
        Drawable drawable3 = this.z0;
        if (drawable3 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable3;
        }
        Drawable drawable4 = this.K0;
        if (drawable4 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable4;
        }
        return null;
    }

    public boolean k0() {
        return this.g;
    }

    public void k1(int i) {
        m1(new int[]{i, i, i, i});
    }

    public Bitmap l() {
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null && rLottieDrawableJ.K()) {
            return rLottieDrawableJ.G();
        }
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null && animatedFileDrawableK.H0()) {
            return animatedFileDrawableK.u0();
        }
        Drawable drawable = this.H0;
        if ((drawable instanceof BitmapDrawable) && !(drawable instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Drawable drawable2 = this.A;
        if ((drawable2 instanceof BitmapDrawable) && !(drawable2 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        Drawable drawable3 = this.z0;
        if ((drawable3 instanceof BitmapDrawable) && !(drawable3 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable3).getBitmap();
        }
        Drawable drawable4 = this.K0;
        if (drawable4 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable4).getBitmap();
        }
        return null;
    }

    public boolean l0() {
        return this.r1;
    }

    public void l1(int i, int i2, int i3, int i4) {
        m1(new int[]{i, i2, i3, i4});
    }

    public int m() {
        v();
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            int i = this.D;
            return (i % 360 == 0 || i % 360 == 180) ? animatedFileDrawableK.getIntrinsicHeight() : animatedFileDrawableK.getIntrinsicWidth();
        }
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null) {
            return rLottieDrawableJ.getIntrinsicHeight();
        }
        Bitmap bitmapL = l();
        if (bitmapL != null) {
            int i2 = this.D;
            return (i2 % 360 == 0 || i2 % 360 == 180) ? bitmapL.getHeight() : bitmapL.getWidth();
        }
        Drawable drawable = this.K0;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 1;
    }

    public boolean m0(float f, float f2) {
        float f3 = this.j1;
        if (f >= f3 && f <= f3 + this.l1) {
            float f4 = this.k1;
            if (f2 >= f4 && f2 <= f4 + this.m1) {
                return true;
            }
        }
        return false;
    }

    public void m1(int[] iArr) {
        int i = iArr[0];
        this.u1 = true;
        int i2 = 0;
        boolean z = false;
        while (true) {
            int[] iArr2 = this.t1;
            if (i2 >= iArr2.length) {
                break;
            }
            int i3 = iArr2[i2];
            int i4 = iArr[i2];
            if (i3 != i4) {
                z = true;
            }
            if (i != i4) {
                this.u1 = false;
            }
            iArr2[i2] = i4;
            i2++;
        }
        if (z) {
            Drawable drawable = this.A;
            if (drawable != null && this.B == null) {
                w1(drawable);
            }
            Drawable drawable2 = this.H0;
            if (drawable2 != null && this.I0 == null) {
                w1(drawable2);
            }
            Drawable drawable3 = this.z0;
            if (drawable3 != null) {
                w1(drawable3);
            }
            Drawable drawable4 = this.K0;
            if (drawable4 != null) {
                w1(drawable4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.tgwidgets.editor.messenger.ImageReceiver.b n() {
        /*
            r5 = this;
            ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable r0 = r5.k()
            ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable r1 = r5.J()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L19
            boolean r4 = r1.K()
            if (r4 == 0) goto L19
            android.graphics.Bitmap r0 = r1.G()
        L16:
            r1 = r2
            goto L8b
        L19:
            if (r0 == 0) goto L37
            boolean r1 = r0.H0()
            if (r1 == 0) goto L37
            android.graphics.Bitmap r1 = r0.u0()
            int r3 = r0.D0()
            if (r3 == 0) goto L35
            ir.nasim.tgwidgets.editor.messenger.ImageReceiver$b r0 = new ir.nasim.tgwidgets.editor.messenger.ImageReceiver$b
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1)
            r0.<init>(r1, r2, r3)
            return r0
        L35:
            r0 = r1
            goto L16
        L37:
            android.graphics.drawable.Drawable r0 = r5.H0
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L4e
            boolean r1 = r0 instanceof ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable
            if (r1 != 0) goto L4e
            boolean r1 = r0 instanceof ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable
            if (r1 != 0) goto L4e
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            java.lang.String r1 = r5.F0
            goto L8b
        L4e:
            android.graphics.drawable.Drawable r1 = r5.A
            boolean r4 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 == 0) goto L65
            boolean r4 = r1 instanceof ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable
            if (r4 != 0) goto L65
            boolean r4 = r0 instanceof ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable
            if (r4 != 0) goto L65
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.Bitmap r0 = r1.getBitmap()
            java.lang.String r1 = r5.y
            goto L8b
        L65:
            android.graphics.drawable.Drawable r1 = r5.z0
            boolean r4 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 == 0) goto L7c
            boolean r4 = r1 instanceof ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable
            if (r4 != 0) goto L7c
            boolean r0 = r0 instanceof ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable
            if (r0 != 0) goto L7c
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.Bitmap r0 = r1.getBitmap()
            java.lang.String r1 = r5.Y
            goto L8b
        L7c:
            android.graphics.drawable.Drawable r0 = r5.K0
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L89
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            goto L16
        L89:
            r0 = r2
            r1 = r0
        L8b:
            if (r0 == 0) goto L92
            ir.nasim.tgwidgets.editor.messenger.ImageReceiver$b r2 = new ir.nasim.tgwidgets.editor.messenger.ImageReceiver$b
            r2.<init>(r0, r1, r3)
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.ImageReceiver.n():ir.nasim.tgwidgets.editor.messenger.ImageReceiver$b");
    }

    public boolean n0() {
        return this.e1;
    }

    public void n1(boolean z) {
        this.f1 = z;
    }

    public int o() {
        v();
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            int i = this.D;
            return (i % 360 == 0 || i % 360 == 180) ? animatedFileDrawableK.getIntrinsicWidth() : animatedFileDrawableK.getIntrinsicHeight();
        }
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null) {
            return rLottieDrawableJ.getIntrinsicWidth();
        }
        Bitmap bitmapL = l();
        if (bitmapL != null) {
            int i2 = this.D;
            return (i2 % 360 == 0 || i2 % 360 == 180) ? bitmapL.getWidth() : bitmapL.getHeight();
        }
        Drawable drawable = this.K0;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 1;
    }

    public boolean o0() {
        return this.f1;
    }

    public int p() {
        return this.P0;
    }

    protected void p1(int i, int i2) {
        if (i2 == 1) {
            this.Z = i;
        } else if (i2 == 3) {
            this.G0 = i;
        } else {
            this.z = i;
        }
    }

    public float q() {
        return this.j1 + (this.l1 / 2.0f);
    }

    public boolean q0() throws InterruptedException {
        if (this.W1) {
            return false;
        }
        this.W1 = true;
        this.l = E.j().i() & (~this.j);
        if (!this.k) {
            E.j().e(this, E.O2);
            E.j().e(this, E.d1);
            E.j().e(this, E.e1);
        }
        if (B0()) {
            return true;
        }
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null) {
            rLottieDrawableJ.v(this);
            rLottieDrawableJ.c0(this.Q0);
        }
        if (rLottieDrawableJ != null && this.S0 && (!rLottieDrawableJ.N() || this.l == 0)) {
            rLottieDrawableJ.start();
        }
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            animatedFileDrawableK.m0(this);
        }
        if (animatedFileDrawableK != null && this.R0 && this.l == 0) {
            animatedFileDrawableK.q0();
            h0();
        }
        if (E.j().l()) {
            t(E.d1, this.b, 512);
        }
        return false;
    }

    public void q1(String str) {
        this.U1 = str;
    }

    public float r() {
        return this.k1 + (this.m1 / 2.0f);
    }

    public void r1(boolean z) {
        this.J0 = z;
    }

    public int s() {
        return this.b;
    }

    public void s0() throws InterruptedException {
        if (this.W1) {
            this.W1 = false;
            if (this.w != null || this.D0 != null || this.H != null || this.K0 != null) {
                if (this.m == null) {
                    this.m = new e();
                }
                e eVar = this.m;
                eVar.e = this.D0;
                eVar.f = this.E0;
                eVar.a = this.w;
                eVar.b = this.x;
                eVar.c = this.H;
                eVar.d = this.J;
                eVar.g = this.K0;
                eVar.h = this.O0;
                eVar.k = this.L0;
                eVar.i = this.P0;
                eVar.j = this.e;
            }
            if (!this.k) {
                E.j().u(this, E.O2);
                E.j().u(this, E.d1);
                E.j().u(this, E.e1);
            }
            if (this.K0 != null) {
                o1(null);
                this.A0 = null;
                this.w1.setShader(null);
            }
            c();
            if (this.C1 == 0) {
                this.R1 = 0.0f;
            }
            AnimatedFileDrawable animatedFileDrawableK = k();
            if (animatedFileDrawableK != null) {
                animatedFileDrawableK.P0(this);
            }
            RLottieDrawable rLottieDrawableJ = J();
            if (rLottieDrawableJ != null) {
                rLottieDrawableJ.W(this);
            }
        }
    }

    public void s1(boolean z) {
        this.X1 = z;
    }

    @Keep
    public void setAlpha(float f) {
        this.B1 = f;
    }

    @Keep
    public void setCurrentAlpha(float f) {
        this.F1 = f;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) throws InterruptedException {
        int i3;
        if (i == E.O2) {
            String str = (String) objArr[0];
            String str2 = this.F0;
            if (str2 != null && str2.equals(str)) {
                this.F0 = (String) objArr[1];
                Object obj = objArr[2];
                this.D0 = (C24687z23) obj;
                e eVar = this.m;
                if (eVar != null) {
                    eVar.e = (C24687z23) obj;
                }
            }
            String str3 = this.y;
            if (str3 != null && str3.equals(str)) {
                this.y = (String) objArr[1];
                Object obj2 = objArr[2];
                this.w = (C24687z23) obj2;
                e eVar2 = this.m;
                if (eVar2 != null) {
                    eVar2.a = (C24687z23) obj2;
                }
            }
            String str4 = this.Y;
            if (str4 == null || !str4.equals(str)) {
                return;
            }
            this.Y = (String) objArr[1];
            Object obj3 = objArr[2];
            this.H = (C24687z23) obj3;
            e eVar3 = this.m;
            if (eVar3 != null) {
                eVar3.c = (C24687z23) obj3;
                return;
            }
            return;
        }
        if (i == E.d1) {
            Integer num = (Integer) objArr[0];
            if (this.j >= num.intValue()) {
                return;
            }
            int iIntValue = num.intValue() | this.l;
            this.l = iIntValue;
            if (iIntValue != 0) {
                RLottieDrawable rLottieDrawableJ = J();
                if (rLottieDrawableJ != null && rLottieDrawableJ.N()) {
                    rLottieDrawableJ.stop();
                }
                AnimatedFileDrawable animatedFileDrawableK = k();
                if (animatedFileDrawableK != null) {
                    animatedFileDrawableK.stop();
                    return;
                }
                return;
            }
            return;
        }
        if (i == E.e1) {
            Integer num2 = (Integer) objArr[0];
            if (this.j >= num2.intValue() || (i3 = this.l) == 0) {
                return;
            }
            int i4 = (~num2.intValue()) & i3;
            this.l = i4;
            if (i4 == 0) {
                RLottieDrawable rLottieDrawableJ2 = J();
                if (rLottieDrawableJ2 != null) {
                    rLottieDrawableJ2.c0(this.Q0);
                }
                if (this.S0 && rLottieDrawableJ2 != null && rLottieDrawableJ2.N()) {
                    rLottieDrawableJ2.start();
                }
                AnimatedFileDrawable animatedFileDrawableK2 = k();
                if (!this.R0 || animatedFileDrawableK2 == null) {
                    return;
                }
                animatedFileDrawableK2.q0();
                h0();
            }
        }
    }

    public void t0(String str, int i) throws InterruptedException {
        String str2;
        Drawable drawable;
        String strI0;
        if (i == 3) {
            str2 = this.F0;
            drawable = this.H0;
        } else if (i == 2) {
            str2 = this.c1;
            drawable = this.b1;
        } else if (i == 1) {
            str2 = this.Y;
            drawable = this.z0;
        } else {
            str2 = this.y;
            drawable = this.A;
        }
        if (str2 != null && ((str2.startsWith("-") || str2.startsWith("strippedmessage-")) && (strI0 = C21457d.g0().i0(str2)) != null)) {
            str2 = strI0;
        }
        if (drawable instanceof RLottieDrawable) {
            ((RLottieDrawable) drawable).W(this);
        }
        if (drawable instanceof AnimatedFileDrawable) {
            ((AnimatedFileDrawable) drawable).P0(this);
        }
        if (str2 != null && ((str == null || !str.equals(str2)) && drawable != null)) {
            if (drawable instanceof RLottieDrawable) {
                RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                boolean zW = C21457d.g0().W(str2);
                if (!C21457d.g0().q0(str2, true) && zW) {
                    rLottieDrawable.T(false);
                }
            } else if (drawable instanceof AnimatedFileDrawable) {
                AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
                if (animatedFileDrawable.W0) {
                    boolean zW2 = C21457d.g0().W(str2);
                    if (C21457d.g0().q0(str2, true)) {
                        if (zW2) {
                            animatedFileDrawable.stop();
                        }
                    } else if (zW2) {
                        animatedFileDrawable.O0();
                    }
                } else if (animatedFileDrawable.E0().isEmpty()) {
                    animatedFileDrawable.O0();
                }
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                boolean zW3 = C21457d.g0().W(str2);
                if (!C21457d.g0().q0(str2, false) && zW3) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bitmap);
                    AbstractC21455b.h1(arrayList);
                }
            }
        }
        if (i == 3) {
            this.F0 = null;
            this.H0 = null;
            this.I0 = null;
        } else if (i == 2) {
            this.c1 = null;
            this.b1 = null;
            this.d1 = null;
        } else if (i == 1) {
            this.z0 = null;
            this.Y = null;
            this.A0 = null;
        } else {
            this.A = null;
            this.y = null;
            this.B = null;
        }
    }

    public void t1(boolean z, boolean z2) {
        if (this.p1 == z) {
            return;
        }
        this.p1 = z;
        if (z2) {
            h0();
        }
    }

    public RectF u() {
        return this.o1;
    }

    public void u0(boolean z) {
        this.U0 = z;
    }

    public void u1() throws InterruptedException {
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            animatedFileDrawableK.c1(this.T0);
            animatedFileDrawableK.start();
            return;
        }
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ == null || rLottieDrawableJ.isRunning()) {
            return;
        }
        rLottieDrawableJ.Y();
    }

    public Drawable v() {
        Drawable drawable = this.H0;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawable3 = this.z0;
        if (drawable3 != null) {
            return drawable3;
        }
        Drawable drawable4 = this.K0;
        if (drawable4 != null) {
            return drawable4;
        }
        return null;
    }

    public void v0(boolean z) {
        this.Y1 = z;
    }

    public void v1() {
        AnimatedFileDrawable animatedFileDrawableK = k();
        if (animatedFileDrawableK != null) {
            animatedFileDrawableK.stop();
            return;
        }
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ == null || rLottieDrawableJ.isRunning()) {
            return;
        }
        rLottieDrawableJ.stop();
    }

    public String w() {
        return this.L0;
    }

    public void w0(boolean z) {
        this.R0 = z;
    }

    public int x() {
        return this.i;
    }

    public void x0(boolean z) {
        this.S0 = z;
    }

    public float y() {
        float fWidth;
        float fHeight;
        if (this.D % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER != 0) {
            fWidth = this.o1.height();
            fHeight = this.o1.width();
        } else {
            fWidth = this.o1.width();
            fHeight = this.o1.height();
        }
        return fWidth / fHeight;
    }

    public void y0(boolean z) {
        this.q1 = z;
    }

    public Drawable z() {
        return this.A;
    }

    public void z0(int i) {
        this.V0 = i;
        RLottieDrawable rLottieDrawableJ = J();
        if (rLottieDrawableJ != null) {
            rLottieDrawableJ.d0(i);
        }
    }

    public ImageReceiver(View view) {
        this.i = 1;
        this.J0 = true;
        this.Q0 = true;
        this.R0 = true;
        this.S0 = true;
        this.V0 = 1;
        this.W0 = -1;
        this.o1 = new RectF();
        this.p1 = true;
        this.t1 = new int[4];
        this.u1 = true;
        this.x1 = new RectF();
        this.y1 = new RectF();
        this.z1 = new Matrix();
        this.A1 = new Path();
        this.B1 = 1.0f;
        this.G1 = 1.0f;
        this.I1 = (byte) 1;
        this.L1 = 0.05f;
        this.Q1 = 150;
        this.V1 = new ArrayList();
        this.Y1 = false;
        this.a2 = true;
        this.c = view;
        this.w1 = new Paint(3);
        this.b = C22477vI7.f;
    }

    public static class b {
        private String a;
        private boolean b;
        public Bitmap c;
        public Drawable d;
        public int e;

        public b(Bitmap bitmap, String str, int i) {
            this.c = bitmap;
            this.a = str;
            this.e = i;
            if (str != null) {
                C21457d.g0().o0(this.a);
            }
        }

        public int a() {
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            return 0;
        }

        public int b() {
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            return 0;
        }

        public boolean c() {
            Bitmap bitmap = this.c;
            return bitmap == null || bitmap.isRecycled();
        }

        public void d() throws InterruptedException {
            Bitmap bitmap;
            if (this.a == null) {
                if (this.b && (bitmap = this.c) != null) {
                    bitmap.recycle();
                }
                this.c = null;
                this.d = null;
                return;
            }
            boolean zW = C21457d.g0().W(this.a);
            if (!C21457d.g0().q0(this.a, false) && zW) {
                Bitmap bitmap2 = this.c;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                } else {
                    Drawable drawable = this.d;
                    if (drawable != null) {
                        if (drawable instanceof RLottieDrawable) {
                            ((RLottieDrawable) drawable).T(false);
                        } else if (drawable instanceof AnimatedFileDrawable) {
                            ((AnimatedFileDrawable) drawable).O0();
                        } else if (drawable instanceof BitmapDrawable) {
                            ((BitmapDrawable) drawable).getBitmap().recycle();
                        }
                    }
                }
            }
            this.a = null;
            this.c = null;
            this.d = null;
        }

        public b(Bitmap bitmap) {
            this.c = bitmap;
            this.b = true;
        }
    }
}
