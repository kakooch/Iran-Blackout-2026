package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C19034pg0;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.C8876Xs;
import ir.nasim.HU1;
import ir.nasim.QU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class AnimatedFileDrawable extends BitmapDrawable implements Animatable, C19034pg0.e {
    private boolean A;
    private BitmapShader[] A0;
    private int B;
    private BitmapShader[] B0;
    private BitmapShader[] C0;
    private boolean D;
    ArrayList D0;
    private int[] E0;
    private int[] F0;
    private final Object G;
    private Matrix[] G0;
    private boolean H;
    private Path[] H0;
    private float I0;
    public boolean J;
    private float J0;
    private boolean K0;
    private final RectF L0;
    private volatile boolean M0;
    private volatile boolean N0;
    public volatile long O0;
    private HU1 P0;
    private float Q0;
    private float R0;
    private int S0;
    private int T0;
    private boolean U0;
    private float V0;
    public boolean W0;
    private final AbstractC18106o57 X0;
    private long Y;
    private RectF[] Y0;
    private RectF Z;
    private Paint[] Z0;
    public boolean a;
    private Matrix[] a1;
    private long b;
    private Path[] b1;
    private int c;
    private View c1;
    private int d;
    private ArrayList d1;
    private final int[] e;
    private ArrayList e1;
    private Runnable f;
    private C8876Xs f1;
    private Bitmap g;
    private boolean g1;
    private int h;
    private boolean h1;
    private Bitmap i;
    private boolean i1;
    private Bitmap j;
    public int j1;
    private int k;
    C19034pg0 k1;
    private int l;
    C19034pg0.g l1;
    private Bitmap m;
    private Runnable m1;
    private int n;
    boolean n1;
    private boolean o;
    Runnable o1;
    private boolean p;
    private Runnable p1;
    private boolean q;
    private Runnable q1;
    private boolean r;
    private Runnable r1;
    private boolean s;
    private final Runnable s1;
    private File t;
    private Runnable t1;
    private long u;
    long u1;
    private int v;
    Bitmap v1;
    private int w;
    long w1;
    private boolean x;
    int x1;
    private volatile long y;
    int y1;
    private volatile long z;
    private BitmapShader[] z0;
    private static float[] z1 = new float[8];
    private static ScheduledThreadPoolExecutor A1 = new ScheduledThreadPoolExecutor(8, new ThreadPoolExecutor.DiscardPolicy());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            AnimatedFileDrawable.this.r0();
            AnimatedFileDrawable.this.f = null;
            AnimatedFileDrawable.this.S0();
            AnimatedFileDrawable.this.J0();
        }
    }

    class b implements Runnable {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() throws InterruptedException {
            if (AnimatedFileDrawable.this.o1 != null) {
                C19034pg0.h();
                AnimatedFileDrawable.this.o1 = null;
            }
            AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
            animatedFileDrawable.n1 = false;
            animatedFileDrawable.r0();
            AnimatedFileDrawable.this.S0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            AnimatedFileDrawable.this.k1.g();
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.d
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.a.c();
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AnimatedFileDrawable.this.N0 || AnimatedFileDrawable.this.o) {
                return;
            }
            AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
            if (animatedFileDrawable.n1 || animatedFileDrawable.o1 != null) {
                return;
            }
            animatedFileDrawable.Q0 = System.currentTimeMillis();
            if (RLottieDrawable.w1 == null) {
                RLottieDrawable.C();
            }
            AnimatedFileDrawable animatedFileDrawable2 = AnimatedFileDrawable.this;
            animatedFileDrawable2.n1 = true;
            animatedFileDrawable2.f = null;
            C19034pg0.n();
            HU1 hu1 = RLottieDrawable.w1;
            AnimatedFileDrawable animatedFileDrawable3 = AnimatedFileDrawable.this;
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d();
                }
            };
            animatedFileDrawable3.o1 = runnable;
            hu1.i(runnable);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            AnimatedFileDrawable.this.r0();
            if (AnimatedFileDrawable.this.f1 != null && AnimatedFileDrawable.this.A) {
                C4278El2.H(AnimatedFileDrawable.this.w).d0(AnimatedFileDrawable.this.f1.c(), false, false);
            }
            if (AnimatedFileDrawable.this.B <= 0) {
                AnimatedFileDrawable.this.A = true;
            } else {
                AnimatedFileDrawable.this.B--;
            }
            if (AnimatedFileDrawable.this.s) {
                AnimatedFileDrawable.this.s = false;
            } else {
                AnimatedFileDrawable.this.r = true;
            }
            AnimatedFileDrawable.this.f = null;
            if (AnimatedFileDrawable.this.i == null && AnimatedFileDrawable.this.j == null) {
                AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
                animatedFileDrawable.i = animatedFileDrawable.m;
                AnimatedFileDrawable animatedFileDrawable2 = AnimatedFileDrawable.this;
                animatedFileDrawable2.k = animatedFileDrawable2.n;
                for (int i = 0; i < AnimatedFileDrawable.this.C0.length; i++) {
                    AnimatedFileDrawable.this.A0[i] = AnimatedFileDrawable.this.C0[i];
                }
            } else if (AnimatedFileDrawable.this.i == null) {
                AnimatedFileDrawable animatedFileDrawable3 = AnimatedFileDrawable.this;
                animatedFileDrawable3.i = animatedFileDrawable3.j;
                AnimatedFileDrawable animatedFileDrawable4 = AnimatedFileDrawable.this;
                animatedFileDrawable4.k = animatedFileDrawable4.l;
                AnimatedFileDrawable animatedFileDrawable5 = AnimatedFileDrawable.this;
                animatedFileDrawable5.j = animatedFileDrawable5.m;
                AnimatedFileDrawable animatedFileDrawable6 = AnimatedFileDrawable.this;
                animatedFileDrawable6.l = animatedFileDrawable6.n;
                for (int i2 = 0; i2 < AnimatedFileDrawable.this.C0.length; i2++) {
                    AnimatedFileDrawable.this.A0[i2] = AnimatedFileDrawable.this.B0[i2];
                    AnimatedFileDrawable.this.B0[i2] = AnimatedFileDrawable.this.C0[i2];
                }
            } else {
                AnimatedFileDrawable animatedFileDrawable7 = AnimatedFileDrawable.this;
                animatedFileDrawable7.j = animatedFileDrawable7.m;
                AnimatedFileDrawable animatedFileDrawable8 = AnimatedFileDrawable.this;
                animatedFileDrawable8.l = animatedFileDrawable8.n;
                for (int i3 = 0; i3 < AnimatedFileDrawable.this.C0.length; i3++) {
                    AnimatedFileDrawable.this.B0[i3] = AnimatedFileDrawable.this.C0[i3];
                }
            }
            AnimatedFileDrawable.this.m = null;
            for (int i4 = 0; i4 < AnimatedFileDrawable.this.C0.length; i4++) {
                AnimatedFileDrawable.this.C0[i4] = null;
            }
            if (AnimatedFileDrawable.this.D) {
                AnimatedFileDrawable.this.D = false;
                AnimatedFileDrawable animatedFileDrawable9 = AnimatedFileDrawable.this;
                animatedFileDrawable9.j1++;
                animatedFileDrawable9.q0();
            }
            if (AnimatedFileDrawable.this.e[3] < AnimatedFileDrawable.this.c) {
                AnimatedFileDrawable animatedFileDrawable10 = AnimatedFileDrawable.this;
                animatedFileDrawable10.c = animatedFileDrawable10.Q0 > 0.0f ? (int) (AnimatedFileDrawable.this.Q0 * 1000.0f) : 0;
            }
            if (AnimatedFileDrawable.this.e[3] - AnimatedFileDrawable.this.c != 0) {
                AnimatedFileDrawable animatedFileDrawable11 = AnimatedFileDrawable.this;
                animatedFileDrawable11.d = animatedFileDrawable11.e[3] - AnimatedFileDrawable.this.c;
                if (AnimatedFileDrawable.this.i1 && AnimatedFileDrawable.this.d < 32) {
                    AnimatedFileDrawable.this.d = 32;
                }
            }
            if (AnimatedFileDrawable.this.z >= 0 && AnimatedFileDrawable.this.y == -1) {
                AnimatedFileDrawable.this.z = -1L;
                AnimatedFileDrawable.this.d = 0;
            }
            AnimatedFileDrawable animatedFileDrawable12 = AnimatedFileDrawable.this;
            animatedFileDrawable12.c = animatedFileDrawable12.e[3];
            if (!AnimatedFileDrawable.this.d1.isEmpty()) {
                int size = AnimatedFileDrawable.this.d1.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((View) AnimatedFileDrawable.this.d1.get(i5)).invalidate();
                }
            }
            AnimatedFileDrawable.this.J0();
            AnimatedFileDrawable.this.S0();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AnimatedFileDrawable.this.N0) {
                boolean z = false;
                if (!AnimatedFileDrawable.this.p && AnimatedFileDrawable.this.O0 == 0) {
                    AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
                    animatedFileDrawable.O0 = AnimatedFileDrawable.createDecoder(animatedFileDrawable.t.getAbsolutePath(), AnimatedFileDrawable.this.e, AnimatedFileDrawable.this.w, AnimatedFileDrawable.this.u, AnimatedFileDrawable.this.f1, false);
                    if (AnimatedFileDrawable.this.O0 != 0 && (AnimatedFileDrawable.this.e[0] > 3840 || AnimatedFileDrawable.this.e[1] > 3840)) {
                        AnimatedFileDrawable.destroyDecoder(AnimatedFileDrawable.this.O0);
                        AnimatedFileDrawable.this.O0 = 0L;
                    }
                    AnimatedFileDrawable.this.e1();
                    AnimatedFileDrawable.this.p = true;
                }
                try {
                    AnimatedFileDrawable animatedFileDrawable2 = AnimatedFileDrawable.this;
                    if (animatedFileDrawable2.k1 != null) {
                        if (animatedFileDrawable2.m == null) {
                            if (AnimatedFileDrawable.this.D0.isEmpty()) {
                                AnimatedFileDrawable animatedFileDrawable3 = AnimatedFileDrawable.this;
                                animatedFileDrawable3.m = Bitmap.createBitmap(animatedFileDrawable3.T0, AnimatedFileDrawable.this.S0, Bitmap.Config.ARGB_8888);
                            } else {
                                AnimatedFileDrawable animatedFileDrawable4 = AnimatedFileDrawable.this;
                                animatedFileDrawable4.m = (Bitmap) animatedFileDrawable4.D0.remove(0);
                            }
                        }
                        AnimatedFileDrawable animatedFileDrawable5 = AnimatedFileDrawable.this;
                        if (animatedFileDrawable5.l1 == null) {
                            animatedFileDrawable5.l1 = new C19034pg0.g();
                        }
                        AnimatedFileDrawable.this.Y = System.currentTimeMillis();
                        AnimatedFileDrawable animatedFileDrawable6 = AnimatedFileDrawable.this;
                        int i = animatedFileDrawable6.l1.a;
                        int iL = animatedFileDrawable6.k1.l(animatedFileDrawable6.m, AnimatedFileDrawable.this.l1);
                        if (iL != -1) {
                            AnimatedFileDrawable animatedFileDrawable7 = AnimatedFileDrawable.this;
                            if (animatedFileDrawable7.l1.a < i) {
                                animatedFileDrawable7.D = true;
                            }
                        }
                        int[] iArr = AnimatedFileDrawable.this.e;
                        AnimatedFileDrawable animatedFileDrawable8 = AnimatedFileDrawable.this;
                        int iMax = animatedFileDrawable8.l1.a * Math.max(16, animatedFileDrawable8.e[4] / Math.max(1, AnimatedFileDrawable.this.k1.m()));
                        animatedFileDrawable8.n = iMax;
                        iArr[3] = iMax;
                        if (AnimatedFileDrawable.this.k1.q()) {
                            AbstractC21455b.m1(AnimatedFileDrawable.this.p1);
                        }
                        if (iL == -1) {
                            AbstractC21455b.m1(AnimatedFileDrawable.this.m1);
                            return;
                        } else {
                            AbstractC21455b.m1(AnimatedFileDrawable.this.q1);
                            return;
                        }
                    }
                    if (animatedFileDrawable2.O0 == 0 && AnimatedFileDrawable.this.e[0] != 0 && AnimatedFileDrawable.this.e[1] != 0) {
                        AbstractC21455b.m1(AnimatedFileDrawable.this.m1);
                        return;
                    }
                    if (AnimatedFileDrawable.this.m == null && AnimatedFileDrawable.this.e[0] > 0 && AnimatedFileDrawable.this.e[1] > 0) {
                        try {
                            if (AnimatedFileDrawable.this.D0.isEmpty()) {
                                AnimatedFileDrawable.this.m = Bitmap.createBitmap((int) (r0.e[0] * AnimatedFileDrawable.this.V0), (int) (AnimatedFileDrawable.this.e[1] * AnimatedFileDrawable.this.V0), Bitmap.Config.ARGB_8888);
                            } else {
                                AnimatedFileDrawable animatedFileDrawable9 = AnimatedFileDrawable.this;
                                animatedFileDrawable9.m = (Bitmap) animatedFileDrawable9.D0.remove(0);
                            }
                        } catch (Throwable th) {
                            AbstractC6403Nl2.d(th);
                        }
                        if (AnimatedFileDrawable.this.C0[0] == null && AnimatedFileDrawable.this.m != null && AnimatedFileDrawable.this.I0()) {
                            BitmapShader[] bitmapShaderArr = AnimatedFileDrawable.this.C0;
                            Bitmap bitmap = AnimatedFileDrawable.this.m;
                            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                            bitmapShaderArr[0] = new BitmapShader(bitmap, tileMode, tileMode);
                        }
                    }
                    if (AnimatedFileDrawable.this.y >= 0) {
                        AnimatedFileDrawable.this.e[3] = (int) AnimatedFileDrawable.this.y;
                        long j = AnimatedFileDrawable.this.y;
                        synchronized (AnimatedFileDrawable.this.G) {
                            AnimatedFileDrawable.this.y = -1L;
                        }
                        if (AnimatedFileDrawable.this.f1 != null) {
                            AnimatedFileDrawable.this.f1.g();
                        }
                        AnimatedFileDrawable.seekToMs(AnimatedFileDrawable.this.O0, j, true);
                        z = true;
                    }
                    if (AnimatedFileDrawable.this.m != null) {
                        AnimatedFileDrawable.this.Y = System.currentTimeMillis();
                        if (AnimatedFileDrawable.getVideoFrame(AnimatedFileDrawable.this.O0, AnimatedFileDrawable.this.m, AnimatedFileDrawable.this.e, AnimatedFileDrawable.this.m.getRowBytes(), false, AnimatedFileDrawable.this.Q0, AnimatedFileDrawable.this.R0) == 0) {
                            AbstractC21455b.m1(AnimatedFileDrawable.this.m1);
                            return;
                        }
                        if (AnimatedFileDrawable.this.e[3] < AnimatedFileDrawable.this.c) {
                            AnimatedFileDrawable.this.D = true;
                        }
                        if (z) {
                            AnimatedFileDrawable animatedFileDrawable10 = AnimatedFileDrawable.this;
                            animatedFileDrawable10.c = animatedFileDrawable10.e[3];
                        }
                        AnimatedFileDrawable animatedFileDrawable11 = AnimatedFileDrawable.this;
                        animatedFileDrawable11.n = animatedFileDrawable11.e[3];
                    }
                } catch (Throwable th2) {
                    AbstractC6403Nl2.d(th2);
                }
            }
            AbstractC21455b.m1(AnimatedFileDrawable.this.q1);
        }
    }

    public AnimatedFileDrawable(File file, boolean z, long j, int i, AbstractC18106o57 abstractC18106o57, C24687z23 c24687z23, Object obj, long j2, int i2, boolean z2, C19034pg0.d dVar) {
        this(file, z, j, i, abstractC18106o57, c24687z23, obj, j2, i2, z2, 0, 0, dVar);
    }

    public static void G0(String str, int[] iArr) {
        getVideoInfo(Build.VERSION.SDK_INT, str, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0() {
        int i = 0;
        while (true) {
            int[] iArr = this.E0;
            if (i >= iArr.length) {
                return false;
            }
            if (iArr[i] != 0) {
                return true;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        for (int i = 0; i < this.e1.size(); i++) {
            ((ImageReceiver) this.e1.get(i)).h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        C19034pg0 c19034pg0 = this.k1;
        if (c19034pg0 != null) {
            c19034pg0.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        View view;
        if (!this.d1.isEmpty()) {
            int size = this.d1.size();
            for (int i = 0; i < size; i++) {
                ((View) this.d1.get(i)).invalidate();
            }
        }
        if ((this.d1.isEmpty() || this.H) && (view = this.c1) != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() throws InterruptedException {
        if (this.f == null) {
            if ((this.j == null || this.i == null) && o0() && !this.o) {
                if (!this.M0) {
                    boolean z = this.q;
                    if (!z) {
                        return;
                    }
                    if (z && this.r) {
                        return;
                    }
                }
                if ((this.e1.size() != 0 || this.J) && !this.n1) {
                    long jMin = 0;
                    if (this.Y != 0) {
                        int i = this.d;
                        jMin = Math.min(i, Math.max(0L, i - (System.currentTimeMillis() - this.Y)));
                    }
                    if (this.g1) {
                        if (this.i1) {
                            Runnable runnable = this.r1;
                            this.f = runnable;
                            QU1.k(runnable);
                            return;
                        } else {
                            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = A1;
                            Runnable runnable2 = this.r1;
                            this.f = runnable2;
                            scheduledThreadPoolExecutor.schedule(runnable2, jMin, TimeUnit.MILLISECONDS);
                            return;
                        }
                    }
                    if (this.P0 == null) {
                        this.P0 = new HU1("decodeQueue" + this);
                    }
                    HU1 hu1 = this.P0;
                    Runnable runnable3 = this.r1;
                    this.f = runnable3;
                    hu1.j(runnable3, jMin);
                }
            }
        }
    }

    public static native long createDecoder(String str, int[] iArr, int i, long j, Object obj, boolean z);

    public static native void destroyDecoder(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        if (this.W0 || (i = this.S0) <= 0 || (i2 = this.T0) <= 0 || (i3 = (iArr = this.e)[0]) <= 0 || (i4 = iArr[1]) <= 0) {
            this.V0 = 1.0f;
            return;
        }
        float fMax = Math.max(i2 / i3, i / i4);
        this.V0 = fMax;
        if (fMax <= 0.0f || fMax > 0.7d) {
            this.V0 = 1.0f;
        }
    }

    private static native int getFrameAtTime(long j, long j2, Bitmap bitmap, int[] iArr, int i);

    public static native int getVideoFrame(long j, Bitmap bitmap, int[] iArr, int i, boolean z, float f, float f2);

    public static native void getVideoInfo(int i, String str, int[] iArr);

    private static native void prepareToSeek(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.r1 == null && this.o && this.O0 != 0 && !this.n1) {
            destroyDecoder(this.O0);
            this.O0 = 0L;
        }
        if (o0()) {
            return;
        }
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.m = null;
        }
        HU1 hu1 = this.P0;
        if (hu1 != null) {
            hu1.k();
            this.P0 = null;
        }
        for (int i = 0; i < this.D0.size(); i++) {
            ((Bitmap) this.D0.get(i)).recycle();
        }
        this.D0.clear();
        J0();
    }

    public static native void seekToMs(long j, long j2, boolean z);

    private static native void stopDecoder(long j);

    public Bitmap A0(long j, boolean z) {
        if (!this.p || this.O0 == 0) {
            return null;
        }
        C8876Xs c8876Xs = this.f1;
        if (c8876Xs != null) {
            c8876Xs.a(false);
            this.f1.g();
        }
        if (!z) {
            seekToMs(this.O0, j, z);
        }
        int[] iArr = this.e;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
        if ((z ? getFrameAtTime(this.O0, j, bitmapCreateBitmap, this.e, bitmapCreateBitmap.getRowBytes()) : getVideoFrame(this.O0, bitmapCreateBitmap, this.e, bitmapCreateBitmap.getRowBytes(), true, 0.0f, 0.0f)) != 0) {
            return bitmapCreateBitmap;
        }
        return null;
    }

    public long B0() {
        return this.c;
    }

    public Bitmap C0() {
        if (this.O0 == 0) {
            return this.m;
        }
        if (this.m == null) {
            if (this.D0.isEmpty()) {
                float f = this.e[0];
                float f2 = this.V0;
                this.m = Bitmap.createBitmap((int) (f * f2), (int) (r0[1] * f2), Bitmap.Config.ARGB_8888);
            } else {
                this.m = (Bitmap) this.D0.remove(0);
            }
        }
        long j = this.O0;
        Bitmap bitmap = this.m;
        getVideoFrame(j, bitmap, this.e, bitmap.getRowBytes(), false, this.Q0, this.R0);
        return this.m;
    }

    public int D0() {
        return this.e[2];
    }

    public ArrayList E0() {
        return this.e1;
    }

    public long F0() {
        return (long) (this.Q0 * 1000.0f);
    }

    public boolean H0() {
        return o0() && !(this.g == null && this.i == null);
    }

    public boolean K0() {
        return this.N0;
    }

    public AnimatedFileDrawable N0() {
        AnimatedFileDrawable animatedFileDrawable;
        C8876Xs c8876Xs = this.f1;
        if (c8876Xs != null) {
            File file = this.t;
            long j = this.u;
            int i = this.v;
            AbstractC18106o57 abstractC18106o57C = c8876Xs.c();
            C24687z23 c24687z23D = this.f1.d();
            Object objE = this.f1.e();
            long j2 = this.z;
            int i2 = this.w;
            C8876Xs c8876Xs2 = this.f1;
            animatedFileDrawable = new AnimatedFileDrawable(file, false, j, i, abstractC18106o57C, c24687z23D, objE, j2, i2, c8876Xs2 != null && c8876Xs2.f(), null);
        } else {
            File file2 = this.t;
            long j3 = this.u;
            int i3 = this.v;
            AbstractC18106o57 abstractC18106o57 = this.X0;
            long j4 = this.z;
            int i4 = this.w;
            C8876Xs c8876Xs3 = this.f1;
            animatedFileDrawable = new AnimatedFileDrawable(file2, false, j3, i3, abstractC18106o57, null, null, j4, i4, c8876Xs3 != null && c8876Xs3.f(), null);
        }
        AnimatedFileDrawable animatedFileDrawable2 = animatedFileDrawable;
        int[] iArr = animatedFileDrawable2.e;
        int[] iArr2 = this.e;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        return animatedFileDrawable2;
    }

    public void O0() throws InterruptedException {
        if (!this.d1.isEmpty()) {
            this.x = true;
            return;
        }
        this.M0 = false;
        this.N0 = true;
        if (this.o1 != null) {
            C19034pg0.h();
            RLottieDrawable.w1.b(this.o1);
            this.o1 = null;
        }
        if (this.f == null) {
            if (this.O0 != 0) {
                destroyDecoder(this.O0);
                this.O0 = 0L;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.g);
            arrayList.add(this.i);
            arrayList.add(this.j);
            arrayList.add(this.m);
            arrayList.addAll(this.D0);
            this.D0.clear();
            this.g = null;
            this.i = null;
            this.j = null;
            this.m = null;
            HU1 hu1 = this.P0;
            if (hu1 != null) {
                hu1.k();
                this.P0 = null;
            }
            getPaint().setShader(null);
            AbstractC21455b.h1(arrayList);
        } else {
            this.o = true;
        }
        C8876Xs c8876Xs = this.f1;
        if (c8876Xs != null) {
            c8876Xs.a(true);
            this.f1 = null;
        }
        J0();
    }

    public void P0(ImageReceiver imageReceiver) {
        this.e1.remove(imageReceiver);
        if (this.e1.size() == 0) {
            this.j1 = 0;
        }
        p0();
    }

    public void Q0(View view) throws InterruptedException {
        this.d1.remove(view);
        if (this.d1.isEmpty()) {
            if (this.x) {
                O0();
                return;
            }
            int[] iArr = this.F0;
            if (iArr != null) {
                a1(iArr);
            }
        }
    }

    public void R0(boolean z) {
        C8876Xs c8876Xs = this.f1;
        if (c8876Xs != null) {
            c8876Xs.a(true);
        }
        if (this.O0 != 0) {
            if (z) {
                stopDecoder(this.O0);
            } else {
                prepareToSeek(this.O0);
            }
        }
    }

    public void T0(long j, boolean z) {
        U0(j, z, false);
    }

    public void U0(long j, boolean z, boolean z2) {
        C8876Xs c8876Xs;
        synchronized (this.G) {
            try {
                this.y = j;
                this.z = j;
                if (this.O0 != 0) {
                    prepareToSeek(this.O0);
                }
                if (this.p && (c8876Xs = this.f1) != null) {
                    c8876Xs.a(z);
                    this.A = z;
                    this.B = z ? 0 : 10;
                }
                if (z2 && this.q) {
                    this.r = false;
                    if (this.f == null) {
                        S0();
                    } else {
                        this.s = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void V0(float f, float f2, float f3, float f4) {
        float f5 = f4 + f2;
        float f6 = f3 + f;
        RectF rectF = this.Z;
        if (rectF.left == f && rectF.top == f2 && rectF.right == f6 && rectF.bottom == f5) {
            return;
        }
        rectF.set(f, f2, f6, f5);
        this.h1 = true;
    }

    public void W0(boolean z) throws InterruptedException {
        this.q = z;
        if (z) {
            S0();
        }
    }

    public void X0(boolean z) {
        this.W0 = z;
        if (z) {
            this.g1 = true;
        }
    }

    public void Y0(boolean z) {
        this.i1 = z;
    }

    public void Z0(View view) {
        if (this.c1 != null) {
            return;
        }
        this.c1 = view;
    }

    @Override // ir.nasim.C19034pg0.e
    public int a(Bitmap bitmap) {
        int i;
        if (this.w1 == 0) {
            return -1;
        }
        Canvas canvas = new Canvas(bitmap);
        if (this.v1 == null) {
            int[] iArr = this.e;
            this.v1 = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
        }
        long j = this.w1;
        Bitmap bitmap2 = this.v1;
        getVideoFrame(j, bitmap2, this.e, bitmap2.getRowBytes(), false, this.Q0, this.R0);
        long j2 = this.u1;
        if (j2 != 0 && ((i = this.e[3]) == 0 || j2 > i)) {
            return 0;
        }
        int i2 = this.y1;
        int i3 = this.e[3];
        if (i2 == i3) {
            int i4 = this.x1 + 1;
            this.x1 = i4;
            if (i4 > 5) {
                return 0;
            }
        }
        this.y1 = i3;
        bitmap.eraseColor(0);
        canvas.save();
        float width = this.T0 / this.v1.getWidth();
        canvas.scale(width, width);
        canvas.drawBitmap(this.v1, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        this.u1 = this.e[3];
        return 1;
    }

    public void a1(int[] iArr) {
        if (!this.d1.isEmpty()) {
            if (this.F0 == null) {
                this.F0 = new int[4];
            }
            int[] iArr2 = this.E0;
            int[] iArr3 = this.F0;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr3.length);
        }
        for (int i = 0; i < 4; i++) {
            if (!this.h1 && iArr[i] != this.E0[i]) {
                this.h1 = true;
            }
            this.E0[i] = iArr[i];
        }
    }

    @Override // ir.nasim.C19034pg0.e
    public void b() {
        this.w1 = createDecoder(this.t.getAbsolutePath(), this.e, this.w, this.u, this.f1, false);
    }

    public void b1(long j, long j2) {
        this.Q0 = j / 1000.0f;
        this.R0 = j2 / 1000.0f;
        if (w0() < j) {
            T0(j, true);
        }
    }

    @Override // ir.nasim.C19034pg0.e
    public void c() {
        long j = this.w1;
        if (j != 0) {
            destroyDecoder(j);
        }
    }

    public void c1(boolean z) {
        if (this.W0) {
            return;
        }
        this.g1 = z;
    }

    public void d1(long j, boolean z) throws InterruptedException {
        if (!this.M0) {
            if (this.M0 || !this.q || Math.abs(j - this.b) < this.d || this.i == null) {
                return;
            }
            this.D0.add(this.g);
            this.g = this.i;
            this.h = this.k;
            for (int i = 0; i < this.C0.length; i++) {
                BitmapShader[] bitmapShaderArr = this.z0;
                BitmapShader[] bitmapShaderArr2 = this.A0;
                bitmapShaderArr[i] = bitmapShaderArr2[i];
                BitmapShader[] bitmapShaderArr3 = this.B0;
                bitmapShaderArr2[i] = bitmapShaderArr3[i];
                bitmapShaderArr3[i] = null;
            }
            this.i = this.j;
            this.k = this.l;
            this.j = null;
            this.l = 0;
            this.b = j;
            S0();
            return;
        }
        Bitmap bitmap = this.g;
        if (bitmap == null && this.i == null) {
            S0();
            return;
        }
        if (this.i == null || (bitmap != null && (Math.abs(j - this.b) < this.d || this.a))) {
            J0();
            return;
        }
        this.D0.add(this.g);
        this.g = this.i;
        this.h = this.k;
        for (int i2 = 0; i2 < this.C0.length; i2++) {
            BitmapShader[] bitmapShaderArr4 = this.z0;
            BitmapShader[] bitmapShaderArr5 = this.A0;
            bitmapShaderArr4[i2] = bitmapShaderArr5[i2];
            BitmapShader[] bitmapShaderArr6 = this.B0;
            bitmapShaderArr5[i2] = bitmapShaderArr6[i2];
            bitmapShaderArr6[i2] = null;
        }
        this.i = this.j;
        this.k = this.l;
        this.j = null;
        this.l = 0;
        this.b = j;
        S0();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) throws InterruptedException {
        t0(canvas, false, System.currentTimeMillis(), 0);
    }

    protected void finalize() throws Throwable {
        try {
            O0();
        } finally {
            super.finalize();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        if (this.p) {
            int[] iArr = this.e;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[0] : iArr[1];
        }
        return i == 0 ? AbstractC21455b.F(100.0f) : (int) (i * this.V0);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        if (this.p) {
            int[] iArr = this.e;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[1] : iArr[0];
        }
        return i == 0 ? AbstractC21455b.F(100.0f) : (int) (i * this.V0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int i = 0;
        if (this.p) {
            int[] iArr = this.e;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[0] : iArr[1];
        }
        return i == 0 ? AbstractC21455b.F(100.0f) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int i = 0;
        if (this.p) {
            int[] iArr = this.e;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[1] : iArr[0];
        }
        return i == 0 ? AbstractC21455b.F(100.0f) : i;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.M0;
    }

    public void m0(ImageReceiver imageReceiver) throws InterruptedException {
        if (imageReceiver != null && !this.e1.contains(imageReceiver)) {
            this.e1.add(imageReceiver);
            if (this.M0) {
                S0();
            }
        }
        p0();
    }

    public void n0(View view) {
        if (view == null || this.d1.contains(view)) {
            return;
        }
        this.d1.add(view);
    }

    public boolean o0() {
        return this.U0 ? this.k1 != null : (this.O0 == 0 && this.p) ? false : true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.K0 = true;
    }

    public void p0() {
        Runnable runnable;
        if (this.k1 == null) {
            return;
        }
        boolean zIsEmpty = this.e1.isEmpty();
        if (zIsEmpty && this.t1 == null) {
            Runnable runnable2 = new Runnable() { // from class: ir.nasim.Ss
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.L0();
                }
            };
            this.t1 = runnable2;
            AbstractC21455b.n1(runnable2, 600L);
        } else {
            if (zIsEmpty || (runnable = this.t1) == null) {
                return;
            }
            AbstractC21455b.t(runnable);
            this.t1 = null;
        }
    }

    public void q0() throws InterruptedException {
        if (this.J) {
            start();
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.e1.size()) {
            ImageReceiver imageReceiver = (ImageReceiver) this.e1.get(i);
            if (!imageReceiver.i0()) {
                this.e1.remove(i);
                i--;
            }
            int i3 = imageReceiver.b2;
            if (i3 > 0 && this.j1 >= i3) {
                i2++;
            }
            i++;
        }
        if (this.e1.size() == i2) {
            stop();
        } else {
            start();
        }
    }

    public void s0(Canvas canvas, float f, float f2, float f3, float f4, int i, ColorFilter colorFilter, int i2) throws InterruptedException {
        RectF[] rectFArr = this.Y0;
        if (rectFArr[i2] == null) {
            rectFArr[i2] = new RectF();
            this.Z0[i2] = new Paint();
            this.Z0[i2].setFilterBitmap(true);
        }
        this.Z0[i2].setAlpha(i);
        this.Z0[i2].setColorFilter(colorFilter);
        this.Y0[i2].set(f, f2, f3 + f, f4 + f2);
        t0(canvas, true, 0L, i2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() throws InterruptedException {
        if (this.M0) {
            return;
        }
        if (this.e1.size() != 0 || this.J) {
            this.M0 = true;
            S0();
            AbstractC21455b.m1(this.s1);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.M0 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t0(android.graphics.Canvas r19, boolean r20, long r21, int r23) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable.t0(android.graphics.Canvas, boolean, long, int):void");
    }

    public Bitmap u0() {
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = this.i;
        if (bitmap2 != null) {
            return bitmap2;
        }
        Bitmap bitmap3 = this.j;
        if (bitmap3 != null) {
            return bitmap3;
        }
        return null;
    }

    public Bitmap v0() {
        return this.m;
    }

    public int w0() {
        if (this.z >= 0) {
            return (int) this.z;
        }
        int i = this.k;
        return i != 0 ? i : this.h;
    }

    public int x0() {
        return this.e[4];
    }

    public int y0() {
        return this.e[5];
    }

    public Bitmap z0(long j) {
        return A0(j, false);
    }

    public AnimatedFileDrawable(File file, boolean z, long j, int i, AbstractC18106o57 abstractC18106o57, C24687z23 c24687z23, Object obj, long j2, int i2, boolean z2, int i3, int i4, C19034pg0.d dVar) {
        long j3;
        boolean z3;
        this.d = 50;
        int[] iArr = new int[6];
        this.e = iArr;
        this.y = -1L;
        this.z = -1L;
        this.G = new Object();
        this.Z = new RectF();
        this.z0 = new BitmapShader[3];
        this.A0 = new BitmapShader[3];
        this.B0 = new BitmapShader[3];
        this.C0 = new BitmapShader[3];
        this.D0 = new ArrayList();
        this.E0 = new int[4];
        this.G0 = new Matrix[3];
        this.H0 = new Path[3];
        this.I0 = 1.0f;
        this.J0 = 1.0f;
        this.L0 = new RectF();
        this.V0 = 1.0f;
        this.Y0 = new RectF[2];
        this.Z0 = new Paint[2];
        this.a1 = new Matrix[2];
        this.b1 = new Path[2];
        this.d1 = new ArrayList();
        this.e1 = new ArrayList();
        this.h1 = true;
        this.m1 = new a();
        this.p1 = new b();
        this.q1 = new c();
        this.r1 = new d();
        this.s1 = new Runnable() { // from class: ir.nasim.Ts
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M0();
            }
        };
        this.t = file;
        this.u = j;
        this.v = i;
        this.w = i2;
        this.S0 = i4;
        this.T0 = i3;
        this.U0 = dVar != null && i3 > 0 && i4 > 0;
        this.X0 = abstractC18106o57;
        getPaint().setFlags(3);
        if (j == 0 || (abstractC18106o57 == null && c24687z23 == null)) {
            j3 = 0;
        } else {
            j3 = 0;
            this.f1 = new C8876Xs(abstractC18106o57, c24687z23, obj, i2, z2, i);
        }
        if (z && !this.U0) {
            this.O0 = createDecoder(file.getAbsolutePath(), iArr, this.w, this.u, this.f1, z2);
            if (this.O0 != j3) {
                if (iArr[0] <= 3840) {
                    z3 = true;
                    if (iArr[1] > 3840) {
                    }
                } else {
                    z3 = true;
                }
                destroyDecoder(this.O0);
                this.O0 = j3;
            } else {
                z3 = true;
            }
            e1();
            this.p = z3;
        }
        if (this.U0) {
            this.O0 = createDecoder(file.getAbsolutePath(), iArr, this.w, this.u, this.f1, z2);
            if (this.O0 == j3 || (iArr[0] <= 3840 && iArr[1] <= 3840)) {
                this.k1 = new C19034pg0(file, this, dVar, this.T0, this.S0, !this.i1);
            } else {
                destroyDecoder(this.O0);
                this.O0 = j3;
            }
        }
        if (j2 != j3) {
            T0(j2, false);
        }
    }
}
