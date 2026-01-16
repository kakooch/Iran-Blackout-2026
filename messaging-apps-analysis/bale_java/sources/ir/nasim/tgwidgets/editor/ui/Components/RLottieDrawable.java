package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C19034pg0;
import ir.nasim.HU1;
import ir.nasim.KS2;
import ir.nasim.LU1;
import ir.nasim.QU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
public class RLottieDrawable extends BitmapDrawable implements Animatable, C19034pg0.e {
    public static KS2 r1;
    protected static final Handler s1 = new Handler(Looper.getMainLooper());
    private static ThreadLocal t1 = new ThreadLocal();
    private static ThreadLocal u1 = new ThreadLocal();
    private static final LU1 v1 = new LU1(4);
    public static HU1 w1;
    protected Runnable A;
    private boolean A0;
    protected Runnable B;
    private boolean B0;
    private boolean C0;
    protected volatile Bitmap D;
    protected int D0;
    private boolean E0;
    private boolean F0;
    protected volatile Bitmap G;
    private float G0;
    protected volatile Bitmap H;
    private float H0;
    private boolean I0;
    protected boolean J;
    private boolean J0;
    private final RectF K0;
    private RectF[] L0;
    private Paint[] M0;
    protected volatile boolean N0;
    protected volatile boolean O0;
    protected volatile long P0;
    protected volatile long Q0;
    protected boolean R0;
    protected boolean S0;
    protected boolean T0;
    protected int U0;
    protected volatile boolean V0;
    private boolean W0;
    private boolean X0;
    protected CountDownLatch Y;
    private boolean Y0;
    protected boolean Z;
    private boolean Z0;
    public boolean a;
    File a1;
    protected final int b;
    boolean b1;
    protected final int c;
    private Runnable c1;
    protected final int[] d;
    private Runnable d1;
    protected int e;
    private View e1;
    protected int f;
    g f1;
    protected boolean g;
    protected Runnable g1;
    private int[] h;
    protected Runnable h1;
    private int[] i;
    boolean i1;
    private HashMap j;
    private Runnable j1;
    private volatile HashMap k;
    private Runnable k1;
    private HashMap l;
    C19034pg0 l1;
    private boolean m;
    int m1;
    private boolean n;
    private boolean n1;
    protected WeakReference o;
    protected Runnable o1;
    private int p;
    long p1;
    private View q;
    private int q1;
    private ArrayList r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected long x;
    private long y;
    protected volatile boolean z;
    private boolean z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            RLottieDrawable rLottieDrawable = RLottieDrawable.this;
            rLottieDrawable.B = null;
            rLottieDrawable.D();
            if (RLottieDrawable.this.d1 != null) {
                RLottieDrawable.this.d1.run();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            RLottieDrawable.this.A0 = true;
            RLottieDrawable.this.M();
            RLottieDrawable.this.D();
            if (RLottieDrawable.this.d1 != null) {
                RLottieDrawable.this.d1.run();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            try {
                C19034pg0 c19034pg0 = RLottieDrawable.this.l1;
                if (c19034pg0 != null) {
                    c19034pg0.g();
                }
            } catch (Throwable unused) {
            }
            RLottieDrawable.s1.post(RLottieDrawable.this.k1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RLottieDrawable.this.O0) {
                return;
            }
            RLottieDrawable rLottieDrawable = RLottieDrawable.this;
            if (rLottieDrawable.Z || !rLottieDrawable.x()) {
                return;
            }
            RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
            if (rLottieDrawable2.A == null) {
                rLottieDrawable2.i1 = true;
                if (RLottieDrawable.w1 == null) {
                    RLottieDrawable.C();
                }
                C19034pg0.n();
                HU1 hu1 = RLottieDrawable.w1;
                RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                };
                rLottieDrawable3.A = runnable;
                hu1.i(runnable);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (RLottieDrawable.this.A != null) {
                C19034pg0.h();
                RLottieDrawable.this.A = null;
            }
            RLottieDrawable rLottieDrawable = RLottieDrawable.this;
            rLottieDrawable.i1 = false;
            rLottieDrawable.D();
        }
    }

    class e implements Runnable {
        private long a = 0;

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            int frame;
            C19034pg0 c19034pg0;
            if (RLottieDrawable.this.O0) {
                return;
            }
            if (RLottieDrawable.this.x()) {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                if (rLottieDrawable.s != 2 || rLottieDrawable.Q0 != 0) {
                    if (RLottieDrawable.this.H == null) {
                        try {
                            RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                            rLottieDrawable2.H = Bitmap.createBitmap(rLottieDrawable2.b, rLottieDrawable2.c, Bitmap.Config.ARGB_8888);
                        } catch (Throwable th) {
                            AbstractC6403Nl2.d(th);
                        }
                    }
                    if (RLottieDrawable.this.H != null) {
                        try {
                            if (!RLottieDrawable.this.k.isEmpty()) {
                                for (Map.Entry entry : RLottieDrawable.this.k.entrySet()) {
                                    RLottieDrawable.setLayerColor(RLottieDrawable.this.P0, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                                }
                                RLottieDrawable.this.k.clear();
                            }
                        } catch (Exception unused) {
                        }
                        if (RLottieDrawable.this.i != null && RLottieDrawable.this.P0 != 0) {
                            RLottieDrawable.replaceColors(RLottieDrawable.this.P0, RLottieDrawable.this.i);
                            RLottieDrawable.this.i = null;
                        }
                        try {
                            RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                            int i = rLottieDrawable3.s;
                            if (i != 1 && i == 2) {
                                j = rLottieDrawable3.Q0;
                                if (RLottieDrawable.this.V0) {
                                    RLottieDrawable rLottieDrawable4 = RLottieDrawable.this;
                                    rLottieDrawable4.D0 = rLottieDrawable4.U0 - 1;
                                }
                            } else {
                                j = rLottieDrawable3.P0;
                            }
                            long j2 = j;
                            int i2 = RLottieDrawable.this.E0 ? 2 : 1;
                            RLottieDrawable rLottieDrawable5 = RLottieDrawable.this;
                            if (!rLottieDrawable5.b1 || (c19034pg0 = rLottieDrawable5.l1) == null) {
                                int i3 = rLottieDrawable5.D0;
                                Bitmap bitmap = rLottieDrawable5.H;
                                RLottieDrawable rLottieDrawable6 = RLottieDrawable.this;
                                frame = RLottieDrawable.getFrame(j2, i3, bitmap, rLottieDrawable6.b, rLottieDrawable6.c, rLottieDrawable6.H.getRowBytes(), true);
                            } else {
                                try {
                                    frame = c19034pg0.k(rLottieDrawable5.D0 / i2, rLottieDrawable5.H);
                                } catch (Exception e) {
                                    AbstractC6403Nl2.d(e);
                                    frame = 0;
                                }
                            }
                            C19034pg0 c19034pg02 = RLottieDrawable.this.l1;
                            if (c19034pg02 != null && c19034pg02.q()) {
                                if (!RLottieDrawable.this.n1) {
                                    RLottieDrawable.this.n1 = true;
                                    RLottieDrawable.s1.post(RLottieDrawable.this.j1);
                                }
                                frame = -1;
                            }
                            if (frame == -1) {
                                RLottieDrawable.s1.post(RLottieDrawable.this.g1);
                                CountDownLatch countDownLatch = RLottieDrawable.this.Y;
                                if (countDownLatch != null) {
                                    countDownLatch.countDown();
                                    return;
                                }
                                return;
                            }
                            RLottieDrawable rLottieDrawable7 = RLottieDrawable.this;
                            rLottieDrawable7.G = rLottieDrawable7.H;
                            RLottieDrawable rLottieDrawable8 = RLottieDrawable.this;
                            int i4 = rLottieDrawable8.s;
                            if (i4 == 1) {
                                int i5 = rLottieDrawable8.D0;
                                int i6 = i5 + i2;
                                int i7 = rLottieDrawable8.t;
                                if (i7 == -1) {
                                    i7 = rLottieDrawable8.d[0];
                                }
                                if (i6 < i7) {
                                    rLottieDrawable8.D0 = i5 + i2;
                                } else {
                                    rLottieDrawable8.D0 = 0;
                                    rLottieDrawable8.z = false;
                                    if (RLottieDrawable.this.Q0 != 0) {
                                        RLottieDrawable.this.s = 2;
                                    }
                                    if (RLottieDrawable.this.m) {
                                        RLottieDrawable.this.l = null;
                                        RLottieDrawable.this.m = false;
                                    }
                                }
                            } else if (i4 == 2) {
                                int i8 = rLottieDrawable8.D0;
                                if (i8 + i2 < rLottieDrawable8.U0) {
                                    rLottieDrawable8.D0 = i8 + i2;
                                } else {
                                    rLottieDrawable8.z = true;
                                    RLottieDrawable.this.w++;
                                }
                            } else {
                                int i9 = rLottieDrawable8.f;
                                if (i9 < 0 || !rLottieDrawable8.g) {
                                    int i10 = rLottieDrawable8.D0;
                                    int i11 = i10 + i2;
                                    if (i9 < 0) {
                                        i9 = rLottieDrawable8.d[0];
                                    }
                                    if (i11 >= i9) {
                                        int i12 = rLottieDrawable8.u;
                                        if (i12 == 1) {
                                            rLottieDrawable8.D0 = 0;
                                            rLottieDrawable8.z = false;
                                            if (RLottieDrawable.this.m) {
                                                RLottieDrawable.this.l = null;
                                                RLottieDrawable.this.m = false;
                                            }
                                            RLottieDrawable rLottieDrawable9 = RLottieDrawable.this;
                                            int i13 = rLottieDrawable9.v;
                                            if (i13 > 0) {
                                                rLottieDrawable9.v = i13 - 1;
                                            }
                                        } else if (i12 == 2) {
                                            rLottieDrawable8.D0 = 0;
                                            rLottieDrawable8.z = true;
                                            RLottieDrawable rLottieDrawable10 = RLottieDrawable.this;
                                            rLottieDrawable10.w++;
                                            if (rLottieDrawable10.m) {
                                                RLottieDrawable.this.l = null;
                                                RLottieDrawable.this.m = false;
                                            }
                                        } else {
                                            rLottieDrawable8.z = true;
                                            RLottieDrawable.this.z();
                                        }
                                    } else if (rLottieDrawable8.u == 3) {
                                        rLottieDrawable8.z = true;
                                        RLottieDrawable.this.w++;
                                    } else {
                                        rLottieDrawable8.D0 = i10 + i2;
                                        rLottieDrawable8.z = false;
                                    }
                                } else {
                                    int i14 = rLottieDrawable8.D0;
                                    if (i14 > i9) {
                                        if (i14 - i2 >= i9) {
                                            rLottieDrawable8.D0 = i14 - i2;
                                            rLottieDrawable8.z = false;
                                        } else {
                                            rLottieDrawable8.z = true;
                                            RLottieDrawable.this.z();
                                        }
                                    } else if (i14 + i2 < i9) {
                                        rLottieDrawable8.D0 = i14 + i2;
                                        rLottieDrawable8.z = false;
                                    } else {
                                        rLottieDrawable8.z = true;
                                        RLottieDrawable.this.z();
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            AbstractC6403Nl2.d(e2);
                        }
                    }
                    RLottieDrawable.s1.post(RLottieDrawable.this.h1);
                    CountDownLatch countDownLatch2 = RLottieDrawable.this.Y;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                        return;
                    }
                    return;
                }
            }
            CountDownLatch countDownLatch3 = RLottieDrawable.this.Y;
            if (countDownLatch3 != null) {
                countDownLatch3.countDown();
            }
            RLottieDrawable.s1.post(RLottieDrawable.this.g1);
        }
    }

    private class f {
    }

    private class g {
        public int[] a;
        public int b;
        File c;
        String d;

        private g() {
        }
    }

    public RLottieDrawable(File file, int i, int i2, C19034pg0.d dVar, boolean z, int[] iArr, int i3) throws IOException {
        char c2;
        int[] iArr2;
        int[] iArr3 = new int[3];
        this.d = iArr3;
        this.f = -1;
        this.j = new HashMap();
        this.k = new HashMap();
        this.m = false;
        this.n = true;
        this.r = new ArrayList();
        this.t = -1;
        this.u = 1;
        this.v = -1;
        this.G0 = 1.0f;
        this.H0 = 1.0f;
        this.K0 = new RectF();
        this.L0 = new RectF[2];
        this.M0 = new Paint[2];
        this.g1 = new a();
        this.h1 = new b();
        this.j1 = new c();
        this.k1 = new d();
        this.o1 = new e();
        this.q1 = -1;
        this.b = i;
        this.c = i2;
        this.E0 = z;
        this.b1 = dVar != null;
        this.W0 = dVar != null && dVar.b;
        this.F0 = dVar != null && dVar.c;
        getPaint().setFlags(2);
        this.a1 = file;
        if (this.b1 && w1 == null) {
            C();
        }
        if (this.b1) {
            g gVar = new g();
            this.f1 = gVar;
            gVar.c = file.getAbsoluteFile();
            g gVar2 = this.f1;
            gVar2.d = null;
            gVar2.a = iArr;
            gVar2.b = i3;
            if (this.F0) {
                return;
            }
            R(file, null, iArr3);
            if (this.E0 && iArr3[1] < 60) {
                this.E0 = false;
            }
            this.l1 = new C19034pg0(file, this, dVar, i, i2, !z);
            c2 = 1;
            iArr2 = iArr3;
        } else {
            c2 = 1;
            iArr2 = iArr3;
            this.P0 = create(file.getAbsolutePath(), null, i, i2, iArr3, this.b1, iArr, this.E0, i3);
            if (this.P0 == 0) {
                AbstractC6403Nl2.a("RLottieDrawable nativePtr == 0 " + file.getAbsolutePath() + " remove file");
                file.delete();
            }
            if (this.E0 && iArr2[1] < 60) {
                this.E0 = false;
            }
        }
        this.e = Math.max(this.E0 ? 33 : 16, (int) (1000.0f / iArr2[c2]));
    }

    public static void C() {
        w1 = new HU1("cache generator queue");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(long j, long j2) {
        if (j != 0) {
            destroy(j);
        }
        if (j2 != 0) {
            destroy(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(long j, long j2) {
        if (j != 0) {
            destroy(j);
        }
        if (j2 != 0) {
            destroy(j2);
        }
    }

    private void R(File file, String str, int[] iArr) throws IOException {
        if (r1 == null) {
            r1 = new KS2();
        }
        try {
            if (file != null) {
                FileReader fileReader = new FileReader(file.getAbsolutePath());
                AbstractC18350oW3.a(r1.i(fileReader, f.class));
                try {
                    fileReader.close();
                } catch (Exception unused) {
                }
            } else {
                AbstractC18350oW3.a(r1.k(str, f.class));
            }
            throw null;
        } catch (Exception e2) {
            AbstractC6403Nl2.e(e2, false);
            String absolutePath = file.getAbsolutePath();
            int i = this.b;
            int i2 = this.c;
            g gVar = this.f1;
            long jCreate = create(absolutePath, str, i, i2, iArr, false, gVar.a, this.E0, gVar.b);
            if (jCreate != 0) {
                destroy(jCreate);
            }
        }
    }

    public static String S(File file, int i) {
        InputStream fileInputStream;
        byte[] bArr = (byte[]) t1.get();
        if (bArr == null) {
            bArr = new byte[65536];
            t1.set(bArr);
        }
        try {
            fileInputStream = file != null ? new FileInputStream(file) : AbstractC14047hG.a.getResources().openRawResource(i);
            try {
                byte[] bArr2 = (byte[]) u1.get();
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                    u1.set(bArr2);
                }
                int i2 = 0;
                while (true) {
                    int i3 = fileInputStream.read(bArr2, 0, bArr2.length);
                    if (i3 >= 0) {
                        int i4 = i2 + i3;
                        if (bArr.length < i4) {
                            byte[] bArr3 = new byte[bArr.length * 2];
                            System.arraycopy(bArr, 0, bArr3, 0, i2);
                            t1.set(bArr3);
                            bArr = bArr3;
                        }
                        if (i3 > 0) {
                            System.arraycopy(bArr2, 0, bArr, i2, i3);
                            i2 = i4;
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable unused) {
                        }
                    }
                }
                fileInputStream.close();
                return new String(bArr, 0, i2);
            } catch (Throwable unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }

    private void U(boolean z) {
        final long j = this.P0;
        final long j2 = this.Q0;
        this.P0 = 0L;
        this.Q0 = 0L;
        if (j == 0 && j2 == 0) {
            return;
        }
        if (z) {
            QU1.k(new Runnable() { // from class: ir.nasim.aF5
                @Override // java.lang.Runnable
                public final void run() {
                    RLottieDrawable.O(j, j2);
                }
            });
        } else {
            Utilities.e.i(new Runnable() { // from class: ir.nasim.bF5
                @Override // java.lang.Runnable
                public final void run() {
                    RLottieDrawable.P(j, j2);
                }
            });
        }
    }

    private void X() {
        if (!this.C0 && !this.N0 && this.z0) {
            if (this.D0 <= 2) {
                this.D0 = 0;
            }
            this.z = false;
            this.A0 = false;
            if (!a0()) {
                this.B0 = true;
            }
        }
        M();
    }

    public static native long create(String str, String str2, int i, int i2, int[] iArr, boolean z, int[] iArr2, boolean z2, int i3);

    protected static native long createWithJson(String str, String str2, int[] iArr, int[] iArr2);

    public static native void destroy(long j);

    public static native int getFrame(long j, int i, Bitmap bitmap, int i2, int i3, int i4, boolean z);

    public static native long getFramesCount(String str, String str2);

    private void j0(long j, long j2, long j3, boolean z) {
        WeakReference weakReference;
        Runnable runnable;
        WeakReference weakReference2;
        this.H = this.D;
        this.D = this.G;
        this.G = null;
        if (this.s == 2 && (weakReference2 = this.o) != null && this.D0 - 1 >= this.p) {
            Runnable runnable2 = (Runnable) weakReference2.get();
            if (runnable2 != null) {
                runnable2.run();
            }
            this.o = null;
        }
        if (this.z || (this.v == 0 && this.u == 1)) {
            stop();
        }
        this.B = null;
        if (this.Z0) {
            this.Z0 = false;
        } else if (this.Y0) {
            this.Y0 = false;
        }
        this.A0 = true;
        this.J = false;
        if (AbstractC21455b.i <= 60.0f) {
            this.y = j;
        } else {
            this.y = j - Math.min(16L, j2 - j3);
        }
        if (z && this.B0) {
            this.A0 = false;
            this.B0 = false;
        }
        if (this.s == 0 && (weakReference = this.o) != null && this.D0 >= this.p && (runnable = (Runnable) weakReference.get()) != null) {
            runnable.run();
        }
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void replaceColors(long j, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void setLayerColor(long j, String str, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Runnable runnable = this.c1;
        if (runnable != null) {
            runnable.run();
            this.c1 = null;
        }
    }

    protected void A() throws InterruptedException {
        Runnable runnable = this.A;
        if (runnable != null) {
            w1.b(runnable);
            C19034pg0.h();
            this.A = null;
        }
        if (L() || this.G == null || this.B == null) {
            return;
        }
        this.B = null;
        this.G = null;
    }

    public void B() {
        if (this.C0) {
            this.C0 = false;
            if (!this.N0 && this.z0) {
                if (this.D0 <= 2) {
                    this.D0 = 0;
                }
                this.z = false;
                this.A0 = false;
                if (!a0()) {
                    this.B0 = true;
                }
            }
            M();
        }
    }

    protected void D() throws InterruptedException {
        if (this.Z) {
            A();
            if (this.B == null && this.A == null && this.P0 != 0) {
                U(true);
            }
        }
        if ((this.P0 == 0 || this.W0) && this.Q0 == 0 && this.l1 == null) {
            V();
            return;
        }
        this.J = true;
        if (!L()) {
            stop();
        }
        if (this.N0) {
            a0();
        }
    }

    public void E(Canvas canvas, float f2, float f3, float f4, float f5, int i, ColorFilter colorFilter, int i2) {
        RectF[] rectFArr = this.L0;
        if (rectFArr[i2] == null) {
            rectFArr[i2] = new RectF();
            this.M0[i2] = new Paint(1);
            this.M0[i2].setFilterBitmap(true);
        }
        this.M0[i2].setAlpha(i);
        this.M0[i2].setColorFilter(colorFilter);
        this.L0[i2].set(f2, f3, f4 + f2, f5 + f3);
        F(canvas, null, true, 0L, i2);
    }

    public void F(Canvas canvas, Paint paint, boolean z, long j, int i) {
        boolean z2;
        float f2;
        float f3;
        if (!x() || this.Z) {
            return;
        }
        if (!z) {
            u0(j, false);
        }
        RectF rectF = z ? this.L0[i] : this.K0;
        if (paint == null) {
            paint = z ? this.M0[i] : getPaint();
        }
        if (paint.getAlpha() == 0 || this.Y0 || this.D == null) {
            return;
        }
        if (z) {
            float fWidth = rectF.width() / this.b;
            float fHeight = rectF.height() / this.c;
            z2 = Math.abs(rectF.width() - ((float) this.b)) >= ((float) AbstractC21455b.F(1.0f)) || Math.abs(rectF.height() - ((float) this.c)) >= ((float) AbstractC21455b.F(1.0f));
            f2 = fWidth;
            f3 = fHeight;
        } else {
            rectF.set(getBounds());
            if (this.I0) {
                this.G0 = rectF.width() / this.b;
                this.H0 = rectF.height() / this.c;
                this.I0 = false;
                this.J0 = Math.abs(rectF.width() - ((float) this.b)) >= ((float) AbstractC21455b.F(1.0f)) || Math.abs(rectF.height() - ((float) this.c)) >= ((float) AbstractC21455b.F(1.0f));
            }
            f2 = this.G0;
            f3 = this.H0;
            z2 = this.J0;
        }
        if (z2) {
            canvas.save();
            canvas.translate(rectF.left, rectF.top);
            canvas.scale(f2, f3);
            canvas.drawBitmap(this.D, 0.0f, 0.0f, paint);
            canvas.restore();
        } else {
            canvas.drawBitmap(this.D, rectF.left, rectF.top, paint);
        }
        if (!this.N0 || z) {
            return;
        }
        M();
    }

    public Bitmap G() {
        if (this.D != null) {
            return this.D;
        }
        if (this.G != null) {
            return this.G;
        }
        return null;
    }

    public int H() {
        return this.D0;
    }

    public long I() {
        int[] iArr = this.d;
        return (long) ((iArr[0] / iArr[1]) * 1000.0f);
    }

    public int J() {
        return this.d[0];
    }

    public boolean K() {
        return (this.O0 || (this.D == null && this.G == null) || this.Y0) ? false : true;
    }

    protected boolean L() {
        return (this.r.isEmpty() && this.e1 == null && getCallback() == null) ? false : true;
    }

    protected void M() {
        if (this.O0) {
            return;
        }
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            ((ImageReceiver) this.r.get(i)).h0();
        }
        View view = this.e1;
        if (view != null) {
            view.invalidate();
        }
        if (getCallback() != null) {
            invalidateSelf();
        }
    }

    public boolean N() {
        return this.s == 0;
    }

    public void Q(float f2) {
        this.e = (int) (this.e * (1.0f / f2));
    }

    public void T(boolean z) {
        this.N0 = false;
        this.O0 = true;
        A();
        if (this.R0 || this.S0) {
            this.T0 = true;
            return;
        }
        if (this.B != null || this.A != null || this.i1) {
            this.Z = true;
            return;
        }
        U(z);
        C19034pg0 c19034pg0 = this.l1;
        if (c19034pg0 != null) {
            c19034pg0.r();
            this.l1 = null;
        }
        V();
    }

    protected void V() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.D);
        arrayList.add(this.H);
        arrayList.add(this.G);
        this.G = null;
        this.D = null;
        this.H = null;
        AbstractC21455b.h1(arrayList);
        if (this.c1 != null) {
            this.c1 = null;
        }
    }

    public void W(ImageReceiver imageReceiver) {
        if (imageReceiver == null) {
            return;
        }
        this.r.remove(imageReceiver);
        y();
    }

    public boolean Y() {
        return Z(false);
    }

    public boolean Z(boolean z) {
        if (!z && ((this.u < 2 || this.w == 0) && this.v < 0)) {
            return false;
        }
        this.w = 0;
        this.u = 2;
        start();
        return true;
    }

    @Override // ir.nasim.C19034pg0.e
    public int a(Bitmap bitmap) {
        long j = this.p1;
        if (j == 0) {
            return -1;
        }
        int i = this.E0 ? 2 : 1;
        if (getFrame(j, this.m1, bitmap, this.b, this.c, bitmap.getRowBytes(), true) == -5) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            return a(bitmap);
        }
        int i2 = this.m1 + i;
        this.m1 = i2;
        return i2 > this.d[0] ? 0 : 1;
    }

    protected boolean a0() {
        boolean z;
        if (this.B != null || this.G != null || !x() || this.R0 || this.Z || ((!this.N0 && (!(z = this.z0) || (z && this.A0))) || this.i1)) {
            return false;
        }
        if (!this.j.isEmpty()) {
            this.k.putAll(this.j);
            this.j.clear();
        }
        int[] iArr = this.h;
        if (iArr != null) {
            this.i = iArr;
            this.h = null;
        }
        this.B = this.o1;
        if (this.E0 && Thread.currentThread() == AbstractC14047hG.b.getLooper().getThread()) {
            QU1.l(this.B, this.Y != null);
        } else {
            v1.h(this.B);
        }
        return true;
    }

    @Override // ir.nasim.C19034pg0.e
    public void b() {
        File file;
        String string = this.f1.c.toString();
        g gVar = this.f1;
        long jCreate = create(string, gVar.d, this.b, this.c, this.F0 ? this.d : new int[3], false, gVar.a, false, gVar.b);
        this.p1 = jCreate;
        if (jCreate != 0 || (file = this.a1) == null) {
            return;
        }
        file.delete();
    }

    public void b0(boolean z) {
        this.z0 = z;
        if (z) {
            a0();
        }
    }

    @Override // ir.nasim.C19034pg0.e
    public void c() {
        long j = this.p1;
        if (j != 0) {
            destroy(j);
            this.p1 = 0L;
        }
    }

    public void c0(boolean z) {
        this.n = z;
    }

    public void d0(int i) {
        if (this.u == 2 && i == 3 && this.D0 != 0) {
            return;
        }
        this.u = i;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        F(canvas, null, false, 0L, 0);
    }

    public void e0(int i) {
        this.v = i;
    }

    public void f0(long j) {
        this.x = j;
    }

    protected void finalize() throws Throwable {
        try {
            T(false);
        } finally {
            super.finalize();
        }
    }

    public void g0(int i) {
        h0(i, true);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void h0(int i, boolean z) {
        i0(i, z, false);
    }

    public void i0(int i, boolean z, boolean z2) throws InterruptedException {
        if (i < 0 || i > this.d[0]) {
            return;
        }
        if (this.D0 != i || z2) {
            this.D0 = i;
            this.z = false;
            this.A0 = false;
            if (this.X0) {
                this.Y0 = true;
                if (this.B != null) {
                    this.Z0 = true;
                }
            }
            if ((!z || z2) && this.J && this.G != null) {
                this.H = this.G;
                this.G = null;
                this.B = null;
                this.J = false;
            }
            if (!z && this.B == null) {
                this.Y = new CountDownLatch(1);
            }
            if (z2 && !this.N0) {
                this.N0 = true;
            }
            if (!a0()) {
                this.B0 = true;
            } else if (!z) {
                try {
                    this.Y.await();
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
                this.Y = null;
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.N0;
    }

    public void k0(View view) {
        this.q = view;
    }

    public boolean l0(int i) {
        if (this.f == i || i > this.d[0]) {
            return false;
        }
        this.f = i;
        return true;
    }

    public void m0(int i) {
        this.m1 = i;
    }

    public void n0(String str, int i) {
        this.j.put(str, Integer.valueOf(i));
        X();
    }

    public void o0(View view) {
        this.e1 = view;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.I0 = true;
    }

    public void p0(Runnable runnable) {
        this.c1 = runnable;
    }

    public void q0(boolean z) {
        this.g = z;
    }

    public void r0(float f2) {
        s0(f2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v6 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s0(float r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L7
        L5:
            r3 = r0
            goto Le
        L7:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto Le
            goto L5
        Le:
            int[] r0 = r2.d
            r1 = 0
            r0 = r0[r1]
            float r0 = (float) r0
            float r0 = r0 * r3
            int r3 = (int) r0
            r2.h0(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable.s0(float, boolean):void");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.N0) {
            return;
        }
        if ((this.u < 2 || this.w == 0) && this.f != this.D0) {
            this.N0 = true;
            if (this.X0) {
                this.Y0 = true;
                if (this.B != null) {
                    this.Z0 = true;
                }
            }
            a0();
            M();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.N0 = false;
    }

    public void t0(long j) throws InterruptedException {
        i0((int) ((Math.max(0L, j) / this.e) % this.d[0]), true, true);
    }

    public void u0(long j, boolean z) {
        int i;
        Integer num;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        long j3 = j2 - this.y;
        if (!z || this.E0) {
            float f2 = AbstractC21455b.i;
            i = (f2 <= 60.0f || (z && f2 <= 80.0f)) ? this.e - 6 : this.e;
        } else {
            i = this.e - 16;
        }
        if (!this.N0) {
            if ((this.B0 || (this.z0 && j3 >= i)) && this.G != null) {
                j0(j2, j3, i, true);
                return;
            }
            return;
        }
        if (this.D == null && this.G == null) {
            a0();
            return;
        }
        if (this.G != null) {
            if (this.D == null || (j3 >= i && !this.a)) {
                HashMap map = this.l;
                if (map != null && this.q != null && this.n && (num = (Integer) map.get(Integer.valueOf(this.D0 - 1))) != null) {
                    this.q.performHapticFeedback(num.intValue() == 1 ? 0 : 3, 2);
                }
                j0(j2, j3, i, false);
            }
        }
    }

    public void v(ImageReceiver imageReceiver) {
        if (imageReceiver == null) {
            return;
        }
        this.r.add(imageReceiver);
    }

    public void w() {
        this.C0 = true;
    }

    public boolean x() {
        return this.b1 ? this.l1 != null || this.W0 : this.P0 != 0;
    }

    public void y() throws InterruptedException {
        if (this.l1 == null || w1 == null || this.A == null) {
            return;
        }
        if (this.r.isEmpty() && getCallback() == null) {
            View view = this.e1;
            if (view == null || !view.isAttachedToWindow()) {
                Runnable runnable = this.A;
                if (runnable != null) {
                    w1.b(runnable);
                    C19034pg0.h();
                    this.A = null;
                }
                this.i1 = false;
                this.n1 = false;
            }
        }
    }

    public RLottieDrawable(File file, String str, int i, int i2, C19034pg0.d dVar, boolean z, int[] iArr, int i3) throws IOException {
        char c2;
        int[] iArr2;
        int[] iArr3 = new int[3];
        this.d = iArr3;
        this.f = -1;
        this.j = new HashMap();
        this.k = new HashMap();
        this.m = false;
        this.n = true;
        this.r = new ArrayList();
        this.t = -1;
        this.u = 1;
        this.v = -1;
        this.G0 = 1.0f;
        this.H0 = 1.0f;
        this.K0 = new RectF();
        this.L0 = new RectF[2];
        this.M0 = new Paint[2];
        this.g1 = new a();
        this.h1 = new b();
        this.j1 = new c();
        this.k1 = new d();
        this.o1 = new e();
        this.q1 = -1;
        this.b = i;
        this.c = i2;
        this.E0 = z;
        this.b1 = dVar != null;
        this.F0 = dVar != null && dVar.c;
        getPaint().setFlags(2);
        if (this.b1 && w1 == null) {
            C();
        }
        if (this.b1) {
            g gVar = new g();
            this.f1 = gVar;
            gVar.c = file.getAbsoluteFile();
            g gVar2 = this.f1;
            gVar2.d = str;
            gVar2.a = iArr;
            gVar2.b = i3;
            if (this.F0) {
                return;
            }
            R(file, str, iArr3);
            if (this.E0 && iArr3[1] < 60) {
                this.E0 = false;
            }
            this.l1 = new C19034pg0(file, this, dVar, i, i2, !z);
            c2 = 1;
            iArr2 = iArr3;
        } else {
            c2 = 1;
            iArr2 = iArr3;
            this.P0 = create(file.getAbsolutePath(), str, i, i2, iArr3, this.b1, iArr, this.E0, i3);
            if (this.P0 == 0) {
                AbstractC6403Nl2.a("RLottieDrawable nativePtr == 0 " + file.getAbsolutePath() + " remove file");
                file.delete();
            }
            if (this.E0 && iArr2[1] < 60) {
                this.E0 = false;
            }
        }
        this.e = Math.max(this.E0 ? 33 : 16, (int) (1000.0f / iArr2[c2]));
    }

    public RLottieDrawable(int i, String str, int i2, int i3) {
        this(i, str, i2, i3, true, (int[]) null);
    }

    public RLottieDrawable(int i, String str, int i2, int i3, boolean z, int[] iArr) {
        int[] iArr2 = new int[3];
        this.d = iArr2;
        this.f = -1;
        this.j = new HashMap();
        this.k = new HashMap();
        this.m = false;
        this.n = true;
        this.r = new ArrayList();
        this.t = -1;
        this.u = 1;
        this.v = -1;
        this.G0 = 1.0f;
        this.H0 = 1.0f;
        this.K0 = new RectF();
        this.L0 = new RectF[2];
        this.M0 = new Paint[2];
        this.g1 = new a();
        this.h1 = new b();
        this.j1 = new c();
        this.k1 = new d();
        this.o1 = new e();
        this.q1 = -1;
        this.b = i2;
        this.c = i3;
        this.u = 0;
        String strS = S(null, i);
        if (TextUtils.isEmpty(strS)) {
            return;
        }
        getPaint().setFlags(2);
        this.P0 = createWithJson(strS, str, iArr2, iArr);
        this.e = Math.max(16, (int) (1000.0f / iArr2[1]));
        if (z) {
            b0(true);
        }
    }

    public RLottieDrawable(String str, String str2, int i, int i2, boolean z, int[] iArr) {
        int[] iArr2 = new int[3];
        this.d = iArr2;
        this.f = -1;
        this.j = new HashMap();
        this.k = new HashMap();
        this.m = false;
        this.n = true;
        this.r = new ArrayList();
        this.t = -1;
        this.u = 1;
        this.v = -1;
        this.G0 = 1.0f;
        this.H0 = 1.0f;
        this.K0 = new RectF();
        this.L0 = new RectF[2];
        this.M0 = new Paint[2];
        this.g1 = new a();
        this.h1 = new b();
        this.j1 = new c();
        this.k1 = new d();
        this.o1 = new e();
        this.q1 = -1;
        this.b = i;
        this.c = i2;
        this.u = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getPaint().setFlags(2);
        this.P0 = createWithJson(str, str2, iArr2, iArr);
        this.e = Math.max(16, (int) (1000.0f / iArr2[1]));
        if (z) {
            b0(true);
        }
    }
}
