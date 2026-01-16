package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.nasim.AbstractC16500lN7;
import ir.nasim.AbstractC3581Bl7;
import ir.nasim.AbstractC6219Mr3;
import ir.nasim.AbstractC7323Rf4;
import ir.nasim.AbstractC7682St3;
import ir.nasim.AbstractC8622Wt2;
import ir.nasim.C13505gL3;
import ir.nasim.C23677xK3;
import ir.nasim.C35;
import ir.nasim.C5023Ho3;
import ir.nasim.C7430Rr3;
import ir.nasim.C8388Vt2;
import ir.nasim.C8725Xb1;
import ir.nasim.C8888Xt2;
import ir.nasim.ChoreographerFrameCallbackC12887fL3;
import ir.nasim.GL;
import ir.nasim.InterfaceC9661aL3;
import ir.nasim.JI3;
import ir.nasim.NO3;
import ir.nasim.Q03;
import ir.nasim.QN5;
import ir.nasim.R03;
import ir.nasim.SK3;
import ir.nasim.ThreadFactoryC11635dL3;
import ir.nasim.VK3;
import ir.nasim.WK5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class q extends Drawable implements Drawable.Callback, Animatable {
    private static final boolean K0;
    private static final List L0;
    private static final Executor M0;
    private Canvas A;
    private float[] A0;
    private Rect B;
    private Matrix B0;
    private boolean C0;
    private RectF D;
    private GL D0;
    private final ValueAnimator.AnimatorUpdateListener E0;
    private final Semaphore F0;
    private Paint G;
    private Handler G0;
    private Rect H;
    private Runnable H0;
    private final Runnable I0;
    private Rect J;
    private float J0;
    private RectF Y;
    private RectF Z;
    private C23677xK3 a;
    private final ChoreographerFrameCallbackC12887fL3 b;
    private boolean c;
    private boolean d;
    private boolean e;
    private b f;
    private final ArrayList g;
    private R03 h;
    private String i;
    private C8888Xt2 j;
    private Map k;
    String l;
    private final r m;
    private boolean n;
    private boolean o;
    private C8725Xb1 p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private QN5 w;
    private boolean x;
    private final Matrix y;
    private Bitmap z;
    private Matrix z0;

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        void a(C23677xK3 c23677xK3);
    }

    private enum b {
        NONE,
        PLAY,
        RESUME
    }

    static {
        K0 = Build.VERSION.SDK_INT <= 25;
        L0 = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        M0 = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC11635dL3());
    }

    public q() {
        ChoreographerFrameCallbackC12887fL3 choreographerFrameCallbackC12887fL3 = new ChoreographerFrameCallbackC12887fL3();
        this.b = choreographerFrameCallbackC12887fL3;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = b.NONE;
        this.g = new ArrayList();
        this.m = new r();
        this.n = false;
        this.o = true;
        this.q = 255;
        this.v = false;
        this.w = QN5.AUTOMATIC;
        this.x = false;
        this.y = new Matrix();
        this.A0 = new float[9];
        this.C0 = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.PK3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.n0(valueAnimator);
            }
        };
        this.E0 = animatorUpdateListener;
        this.F0 = new Semaphore(1);
        this.I0 = new Runnable() { // from class: ir.nasim.QK3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p0();
            }
        };
        this.J0 = -3.4028235E38f;
        choreographerFrameCallbackC12887fL3.addUpdateListener(animatorUpdateListener);
    }

    private void A(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(int i, C23677xK3 c23677xK3) {
        f1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(String str, C23677xK3 c23677xK3) {
        g1(str);
    }

    private void C(Canvas canvas, Matrix matrix, C8725Xb1 c8725Xb1, int i) {
        if (!this.x) {
            c8725Xb1.i(canvas, matrix, i, null);
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        G0(canvas, c8725Xb1);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(float f, C23677xK3 c23677xK3) {
        h1(f);
    }

    private void D(Canvas canvas) {
        C8725Xb1 c8725Xb1 = this.p;
        C23677xK3 c23677xK3 = this.a;
        if (c8725Xb1 == null || c23677xK3 == null) {
            return;
        }
        this.y.reset();
        if (!getBounds().isEmpty()) {
            this.y.preTranslate(r2.left, r2.top);
            this.y.preScale(r2.width() / c23677xK3.b().width(), r2.height() / c23677xK3.b().height());
        }
        c8725Xb1.i(canvas, this.y, this.q, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(float f, C23677xK3 c23677xK3) {
        k1(f);
    }

    private void G(int i, int i2) {
        Bitmap bitmap = this.z;
        if (bitmap == null || bitmap.getWidth() < i || this.z.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.z = bitmapCreateBitmap;
            this.A.setBitmap(bitmapCreateBitmap);
            this.C0 = true;
            return;
        }
        if (this.z.getWidth() > i || this.z.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.z, 0, 0, i, i2);
            this.z = bitmapCreateBitmap2;
            this.A.setBitmap(bitmapCreateBitmap2);
            this.C0 = true;
        }
    }

    private void G0(Canvas canvas, C8725Xb1 c8725Xb1) {
        if (this.a == null || c8725Xb1 == null) {
            return;
        }
        H();
        canvas.getMatrix(this.z0);
        canvas.getClipBounds(this.B);
        z(this.B, this.D);
        this.z0.mapRect(this.D);
        A(this.D, this.B);
        if (this.o) {
            this.Z.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            c8725Xb1.g(this.Z, null, false);
        }
        this.z0.mapRect(this.Z);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        J0(this.Z, fWidth, fHeight);
        if (!g0()) {
            RectF rectF = this.Z;
            Rect rect = this.B;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.Z.width());
        int iCeil2 = (int) Math.ceil(this.Z.height());
        if (iCeil <= 0 || iCeil2 <= 0) {
            return;
        }
        G(iCeil, iCeil2);
        if (this.C0) {
            this.z0.getValues(this.A0);
            float[] fArr = this.A0;
            float f = fArr[0];
            float f2 = fArr[4];
            this.y.set(this.z0);
            this.y.preScale(fWidth, fHeight);
            Matrix matrix = this.y;
            RectF rectF2 = this.Z;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.y.postScale(1.0f / f, 1.0f / f2);
            this.z.eraseColor(0);
            this.A.setMatrix(AbstractC16500lN7.a);
            this.A.scale(f, f2);
            c8725Xb1.i(this.A, this.y, this.q, null);
            this.z0.invert(this.B0);
            this.B0.mapRect(this.Y, this.Z);
            A(this.Y, this.J);
        }
        this.H.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.z, this.H, this.J, this.G);
    }

    private void H() {
        if (this.A != null) {
            return;
        }
        this.A = new Canvas();
        this.Z = new RectF();
        this.z0 = new Matrix();
        this.B0 = new Matrix();
        this.B = new Rect();
        this.D = new RectF();
        this.G = new C7430Rr3();
        this.H = new Rect();
        this.J = new Rect();
        this.Y = new RectF();
    }

    private void J0(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private Context O() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private C8888Xt2 P() {
        if (getCallback() == null) {
            return null;
        }
        if (this.j == null) {
            C8888Xt2 c8888Xt2 = new C8888Xt2(getCallback(), null);
            this.j = c8888Xt2;
            String str = this.l;
            if (str != null) {
                c8888Xt2.c(str);
            }
        }
        return this.j;
    }

    private R03 R() {
        R03 r03 = this.h;
        if (r03 != null && !r03.b(O())) {
            this.h = null;
        }
        if (this.h == null) {
            this.h = new R03(getCallback(), this.i, null, this.a.j());
        }
        return this.h;
    }

    private boolean g0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(C5023Ho3 c5023Ho3, Object obj, C13505gL3 c13505gL3, C23677xK3 c23677xK3) {
        t(c5023Ho3, obj, c13505gL3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ValueAnimator valueAnimator) {
        if (J()) {
            invalidateSelf();
            return;
        }
        C8725Xb1 c8725Xb1 = this.p;
        if (c8725Xb1 != null) {
            c8725Xb1.O(this.b.n());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0() {
        C8725Xb1 c8725Xb1 = this.p;
        if (c8725Xb1 == null) {
            return;
        }
        try {
            this.F0.acquire();
            c8725Xb1.O(this.b.n());
            if (K0 && this.C0) {
                if (this.G0 == null) {
                    this.G0 = new Handler(Looper.getMainLooper());
                    this.H0 = new Runnable() { // from class: ir.nasim.OK3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.o0();
                        }
                    };
                }
                this.G0.post(this.H0);
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.F0.release();
            throw th;
        }
        this.F0.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(C23677xK3 c23677xK3) {
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(C23677xK3 c23677xK3) {
        I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i, C23677xK3 c23677xK3) {
        T0(i);
    }

    private boolean s1() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return false;
        }
        float f = this.J0;
        float fN = this.b.n();
        this.J0 = fN;
        return Math.abs(fN - f) * c23677xK3.d() >= 50.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, C23677xK3 c23677xK3) {
        Z0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int i, C23677xK3 c23677xK3) {
        Y0(i);
    }

    private void v() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return;
        }
        C8725Xb1 c8725Xb1 = new C8725Xb1(this, AbstractC7682St3.b(c23677xK3), c23677xK3.k(), c23677xK3);
        this.p = c8725Xb1;
        if (this.s) {
            c8725Xb1.M(true);
        }
        this.p.S(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(float f, C23677xK3 c23677xK3) {
        a1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(String str, C23677xK3 c23677xK3) {
        c1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(String str, String str2, boolean z, C23677xK3 c23677xK3) {
        d1(str, str2, z);
    }

    private void y() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return;
        }
        this.x = this.w.j(Build.VERSION.SDK_INT, c23677xK3.q(), c23677xK3.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(int i, int i2, C23677xK3 c23677xK3) {
        b1(i, i2);
    }

    private void z(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(float f, float f2, C23677xK3 c23677xK3) {
        e1(f, f2);
    }

    public void B(Canvas canvas, Matrix matrix) {
        C8725Xb1 c8725Xb1 = this.p;
        C23677xK3 c23677xK3 = this.a;
        if (c8725Xb1 == null || c23677xK3 == null) {
            return;
        }
        boolean zJ = J();
        if (zJ) {
            try {
                this.F0.acquire();
                if (s1()) {
                    k1(this.b.n());
                }
            } catch (InterruptedException unused) {
                if (!zJ) {
                    return;
                }
                this.F0.release();
                if (c8725Xb1.R() == this.b.n()) {
                    return;
                }
            } catch (Throwable th) {
                if (zJ) {
                    this.F0.release();
                    if (c8725Xb1.R() != this.b.n()) {
                        M0.execute(this.I0);
                    }
                }
                throw th;
            }
        }
        if (this.e) {
            try {
                C(canvas, matrix, c8725Xb1, this.q);
            } catch (Throwable th2) {
                JI3.b("Lottie crashed in draw!", th2);
            }
        } else {
            C(canvas, matrix, c8725Xb1, this.q);
        }
        this.C0 = false;
        if (zJ) {
            this.F0.release();
            if (c8725Xb1.R() == this.b.n()) {
                return;
            }
            M0.execute(this.I0);
        }
    }

    public void E(SK3 sk3, boolean z) {
        boolean zA = this.m.a(sk3, z);
        if (this.a == null || !zA) {
            return;
        }
        v();
    }

    public void E0() {
        this.g.clear();
        this.b.u();
        if (isVisible()) {
            return;
        }
        this.f = b.NONE;
    }

    public void F() {
        this.g.clear();
        this.b.m();
        if (isVisible()) {
            return;
        }
        this.f = b.NONE;
    }

    public void F0() {
        if (this.p == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.q0(c23677xK3);
                }
            });
            return;
        }
        y();
        if (u(O()) || b0() == 0) {
            if (isVisible()) {
                this.b.v();
                this.f = b.NONE;
            } else {
                this.f = b.PLAY;
            }
        }
        if (u(O())) {
            return;
        }
        NO3 no3V = V();
        if (no3V != null) {
            T0((int) no3V.b);
        } else {
            T0((int) (d0() < 0.0f ? X() : W()));
        }
        this.b.m();
        if (isVisible()) {
            return;
        }
        this.f = b.NONE;
    }

    public List H0(C5023Ho3 c5023Ho3) {
        if (this.p == null) {
            JI3.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.p.f(c5023Ho3, 0, arrayList, new C5023Ho3(new String[0]));
        return arrayList;
    }

    public GL I() {
        GL gl = this.D0;
        return gl != null ? gl : AbstractC6219Mr3.d();
    }

    public void I0() {
        if (this.p == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.j
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.r0(c23677xK3);
                }
            });
            return;
        }
        y();
        if (u(O()) || b0() == 0) {
            if (isVisible()) {
                this.b.z();
                this.f = b.NONE;
            } else {
                this.f = b.RESUME;
            }
        }
        if (u(O())) {
            return;
        }
        T0((int) (d0() < 0.0f ? X() : W()));
        this.b.m();
        if (isVisible()) {
            return;
        }
        this.f = b.NONE;
    }

    public boolean J() {
        return I() == GL.ENABLED;
    }

    public Bitmap K(String str) {
        R03 r03R = R();
        if (r03R != null) {
            return r03R.a(str);
        }
        return null;
    }

    public void K0(boolean z) {
        this.t = z;
    }

    public boolean L() {
        return this.v;
    }

    public void L0(boolean z) {
        this.u = z;
    }

    public boolean M() {
        return this.o;
    }

    public void M0(GL gl) {
        this.D0 = gl;
    }

    public C23677xK3 N() {
        return this.a;
    }

    public void N0(boolean z) {
        if (z != this.v) {
            this.v = z;
            invalidateSelf();
        }
    }

    public void O0(boolean z) {
        if (z != this.o) {
            this.o = z;
            C8725Xb1 c8725Xb1 = this.p;
            if (c8725Xb1 != null) {
                c8725Xb1.S(z);
            }
            invalidateSelf();
        }
    }

    public boolean P0(C23677xK3 c23677xK3) {
        if (this.a == c23677xK3) {
            return false;
        }
        this.C0 = true;
        x();
        this.a = c23677xK3;
        v();
        this.b.B(c23677xK3);
        k1(this.b.getAnimatedFraction());
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(c23677xK3);
            }
            it.remove();
        }
        this.g.clear();
        c23677xK3.w(this.r);
        y();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public int Q() {
        return (int) this.b.o();
    }

    public void Q0(String str) {
        this.l = str;
        C8888Xt2 c8888Xt2P = P();
        if (c8888Xt2P != null) {
            c8888Xt2P.c(str);
        }
    }

    public void R0(AbstractC8622Wt2 abstractC8622Wt2) {
        C8888Xt2 c8888Xt2 = this.j;
        if (c8888Xt2 != null) {
            c8888Xt2.d(abstractC8622Wt2);
        }
    }

    public String S() {
        return this.i;
    }

    public void S0(Map map) {
        if (map == this.k) {
            return;
        }
        this.k = map;
        invalidateSelf();
    }

    public VK3 T(String str) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return null;
        }
        return (VK3) c23677xK3.j().get(str);
    }

    public void T0(final int i) {
        if (this.a == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.c
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.s0(i, c23677xK3);
                }
            });
        } else {
            this.b.C(i);
        }
    }

    public boolean U() {
        return this.n;
    }

    public void U0(boolean z) {
        this.d = z;
    }

    public NO3 V() {
        Iterator it = L0.iterator();
        NO3 no3L = null;
        while (it.hasNext()) {
            no3L = this.a.l((String) it.next());
            if (no3L != null) {
                break;
            }
        }
        return no3L;
    }

    public void V0(Q03 q03) {
        R03 r03 = this.h;
        if (r03 != null) {
            r03.d(q03);
        }
    }

    public float W() {
        return this.b.q();
    }

    public void W0(String str) {
        this.i = str;
    }

    public float X() {
        return this.b.r();
    }

    public void X0(boolean z) {
        this.n = z;
    }

    public C35 Y() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 != null) {
            return c23677xK3.n();
        }
        return null;
    }

    public void Y0(final int i) {
        if (this.a == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.f
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.u0(i, c23677xK3);
                }
            });
        } else {
            this.b.D(i + 0.99f);
        }
    }

    public float Z() {
        return this.b.n();
    }

    public void Z0(final String str) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.l
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.t0(str, c23677xK32);
                }
            });
            return;
        }
        NO3 no3L = c23677xK3.l(str);
        if (no3L != null) {
            Y0((int) (no3L.b + no3L.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + Separators.DOT);
    }

    public QN5 a0() {
        return this.x ? QN5.SOFTWARE : QN5.HARDWARE;
    }

    public void a1(final float f) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.v0(f, c23677xK32);
                }
            });
        } else {
            this.b.D(AbstractC7323Rf4.i(c23677xK3.p(), this.a.f(), f));
        }
    }

    public int b0() {
        return this.b.getRepeatCount();
    }

    public void b1(final int i, final int i2) {
        if (this.a == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.e
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.y0(i, i2, c23677xK3);
                }
            });
        } else {
            this.b.E(i, i2 + 0.99f);
        }
    }

    public int c0() {
        return this.b.getRepeatMode();
    }

    public void c1(final String str) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.b
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.w0(str, c23677xK32);
                }
            });
            return;
        }
        NO3 no3L = c23677xK3.l(str);
        if (no3L != null) {
            int i = (int) no3L.b;
            b1(i, ((int) no3L.c) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + Separators.DOT);
        }
    }

    public float d0() {
        return this.b.s();
    }

    public void d1(final String str, final String str2, final boolean z) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.k
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.x0(str, str2, z, c23677xK32);
                }
            });
            return;
        }
        NO3 no3L = c23677xK3.l(str);
        if (no3L == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + Separators.DOT);
        }
        int i = (int) no3L.b;
        NO3 no3L2 = this.a.l(str2);
        if (no3L2 != null) {
            b1(i, (int) (no3L2.b + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + Separators.DOT);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C8725Xb1 c8725Xb1 = this.p;
        if (c8725Xb1 == null) {
            return;
        }
        boolean zJ = J();
        if (zJ) {
            try {
                this.F0.acquire();
            } catch (InterruptedException unused) {
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("Drawable#draw");
                }
                if (!zJ) {
                    return;
                }
                this.F0.release();
                if (c8725Xb1.R() == this.b.n()) {
                    return;
                }
            } catch (Throwable th) {
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("Drawable#draw");
                }
                if (zJ) {
                    this.F0.release();
                    if (c8725Xb1.R() != this.b.n()) {
                        M0.execute(this.I0);
                    }
                }
                throw th;
            }
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Drawable#draw");
        }
        if (zJ && s1()) {
            k1(this.b.n());
        }
        if (this.e) {
            try {
                if (this.x) {
                    G0(canvas, c8725Xb1);
                } else {
                    D(canvas);
                }
            } catch (Throwable th2) {
                JI3.b("Lottie crashed in draw!", th2);
            }
        } else if (this.x) {
            G0(canvas, c8725Xb1);
        } else {
            D(canvas);
        }
        this.C0 = false;
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Drawable#draw");
        }
        if (zJ) {
            this.F0.release();
            if (c8725Xb1.R() == this.b.n()) {
                return;
            }
            M0.execute(this.I0);
        }
    }

    public AbstractC3581Bl7 e0() {
        return null;
    }

    public void e1(final float f, final float f2) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.d
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.z0(f, f2, c23677xK32);
                }
            });
        } else {
            b1((int) AbstractC7323Rf4.i(c23677xK3.p(), this.a.f(), f), (int) AbstractC7323Rf4.i(this.a.p(), this.a.f(), f2));
        }
    }

    public Typeface f0(C8388Vt2 c8388Vt2) {
        Map map = this.k;
        if (map != null) {
            String strA = c8388Vt2.a();
            if (map.containsKey(strA)) {
                return (Typeface) map.get(strA);
            }
            String strB = c8388Vt2.b();
            if (map.containsKey(strB)) {
                return (Typeface) map.get(strB);
            }
            String str = c8388Vt2.a() + "-" + c8388Vt2.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        C8888Xt2 c8888Xt2P = P();
        if (c8888Xt2P != null) {
            return c8888Xt2P.b(c8388Vt2);
        }
        return null;
    }

    public void f1(final int i) {
        if (this.a == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.g
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.A0(i, c23677xK3);
                }
            });
        } else {
            this.b.F(i);
        }
    }

    public void g1(final String str) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.B0(str, c23677xK32);
                }
            });
            return;
        }
        NO3 no3L = c23677xK3.l(str);
        if (no3L != null) {
            f1((int) no3L.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + Separators.DOT);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return -1;
        }
        return c23677xK3.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return -1;
        }
        return c23677xK3.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        ChoreographerFrameCallbackC12887fL3 choreographerFrameCallbackC12887fL3 = this.b;
        if (choreographerFrameCallbackC12887fL3 == null) {
            return false;
        }
        return choreographerFrameCallbackC12887fL3.isRunning();
    }

    public void h1(final float f) {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK32) {
                    this.a.C0(f, c23677xK32);
                }
            });
        } else {
            f1((int) AbstractC7323Rf4.i(c23677xK3.p(), this.a.f(), f));
        }
    }

    boolean i0() {
        if (isVisible()) {
            return this.b.isRunning();
        }
        b bVar = this.f;
        return bVar == b.PLAY || bVar == b.RESUME;
    }

    public void i1(boolean z) {
        if (this.s == z) {
            return;
        }
        this.s = z;
        C8725Xb1 c8725Xb1 = this.p;
        if (c8725Xb1 != null) {
            c8725Xb1.M(z);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.C0) {
            return;
        }
        this.C0 = true;
        if ((!K0 || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return h0();
    }

    public boolean j0() {
        return this.t;
    }

    public void j1(boolean z) {
        this.r = z;
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 != null) {
            c23677xK3.w(z);
        }
    }

    public boolean k0() {
        return this.u;
    }

    public void k1(final float f) {
        if (this.a == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.D0(f, c23677xK3);
                }
            });
            return;
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("Drawable#setProgress");
        }
        this.b.C(this.a.h(f));
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("Drawable#setProgress");
        }
    }

    public boolean l0(SK3 sk3) {
        return this.m.b(sk3);
    }

    public void l1(QN5 qn5) {
        this.w = qn5;
        y();
    }

    public void m1(int i) {
        this.b.setRepeatCount(i);
    }

    public void n1(int i) {
        this.b.setRepeatMode(i);
    }

    public void o1(boolean z) {
        this.e = z;
    }

    public void p1(float f) {
        this.b.G(f);
    }

    public void r1(boolean z) {
        this.b.H(z);
    }

    public void s(Animator.AnimatorListener animatorListener) {
        this.b.addListener(animatorListener);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.q = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        JI3.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            b bVar = this.f;
            if (bVar == b.PLAY) {
                F0();
            } else if (bVar == b.RESUME) {
                I0();
            }
        } else if (this.b.isRunning()) {
            E0();
            this.f = b.RESUME;
        } else if (!z3) {
            this.f = b.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        F0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        F();
    }

    public void t(final C5023Ho3 c5023Ho3, final Object obj, final C13505gL3 c13505gL3) {
        C8725Xb1 c8725Xb1 = this.p;
        if (c8725Xb1 == null) {
            this.g.add(new a() { // from class: com.airbnb.lottie.h
                @Override // com.airbnb.lottie.q.a
                public final void a(C23677xK3 c23677xK3) {
                    this.a.m0(c5023Ho3, obj, c13505gL3, c23677xK3);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (c5023Ho3 == C5023Ho3.c) {
            c8725Xb1.c(obj, c13505gL3);
        } else if (c5023Ho3.d() != null) {
            c5023Ho3.d().c(obj, c13505gL3);
        } else {
            List listH0 = H0(c5023Ho3);
            for (int i = 0; i < listH0.size(); i++) {
                ((C5023Ho3) listH0.get(i)).d().c(obj, c13505gL3);
            }
            zIsEmpty = true ^ listH0.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == InterfaceC9661aL3.E) {
                k1(Z());
            }
        }
    }

    public boolean t1() {
        return this.k == null && this.a.c().o() > 0;
    }

    public boolean u(Context context) {
        if (this.d) {
            return true;
        }
        return this.c && AbstractC6219Mr3.f().a(context) == WK5.STANDARD_MOTION;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void w() {
        this.g.clear();
        this.b.cancel();
        if (isVisible()) {
            return;
        }
        this.f = b.NONE;
    }

    public void x() {
        if (this.b.isRunning()) {
            this.b.cancel();
            if (!isVisible()) {
                this.f = b.NONE;
            }
        }
        this.a = null;
        this.p = null;
        this.h = null;
        this.J0 = -3.4028235E38f;
        this.b.l();
        invalidateSelf();
    }

    public void q1(AbstractC3581Bl7 abstractC3581Bl7) {
    }
}
