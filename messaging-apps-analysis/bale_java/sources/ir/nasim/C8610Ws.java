package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import java.io.File;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.Ws, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8610Ws extends BitmapDrawable implements Animatable {
    private static final Handler B0 = new Handler(Looper.getMainLooper());
    private volatile boolean A;
    private final Runnable A0;
    public volatile long B;
    private NZ D;
    private WeakReference G;
    private View H;
    protected final Runnable J;
    private Runnable Y;
    private Runnable Z;
    private long a;
    private int b;
    private int c;
    private final int[] d;
    private Runnable e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private boolean i;
    private boolean j;
    private File k;
    private long l;
    private int m;
    private boolean n;
    private volatile long o;
    private volatile long p;
    private int q;
    private final Object r;
    private long s;
    private int t;
    private int u;
    private float v;
    private float w;
    private boolean x;
    private final Rect y;
    private volatile boolean z;
    private Runnable z0;

    /* renamed from: ir.nasim.Ws$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (C8610Ws.this.i && C8610Ws.this.B != 0) {
                AnimatedFileDrawable.destroyDecoder(C8610Ws.this.B);
                C8610Ws.this.B = 0L;
            }
            if (C8610Ws.this.B != 0) {
                C8610Ws.this.e = null;
                C8610Ws.this.R();
                return;
            }
            if (C8610Ws.this.f != null) {
                C8610Ws.this.f.recycle();
                C8610Ws.this.f = null;
            }
            if (C8610Ws.this.h != null) {
                C8610Ws.this.h.recycle();
                C8610Ws.this.h = null;
            }
            if (C8610Ws.this.D != null) {
                C8610Ws.this.D.recycle();
                C8610Ws.this.D = null;
            }
        }
    }

    /* renamed from: ir.nasim.Ws$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (C8610Ws.this.i && C8610Ws.this.B != 0) {
                AnimatedFileDrawable.destroyDecoder(C8610Ws.this.B);
                C8610Ws.this.B = 0L;
            }
            if (C8610Ws.this.B == 0) {
                if (C8610Ws.this.f != null) {
                    C8610Ws.this.f.recycle();
                    C8610Ws.this.f = null;
                }
                if (C8610Ws.this.h != null) {
                    C8610Ws.this.h.recycle();
                    C8610Ws.this.h = null;
                }
                if (C8610Ws.this.D != null) {
                    C8610Ws.this.D.recycle();
                    C8610Ws.this.D = null;
                    return;
                }
                return;
            }
            if (C8610Ws.this.q > 0) {
                C8610Ws c8610Ws = C8610Ws.this;
                c8610Ws.q--;
            }
            C8610Ws.this.e = null;
            C8610Ws c8610Ws2 = C8610Ws.this;
            c8610Ws2.g = c8610Ws2.h;
            if (C8610Ws.this.d[3] < C8610Ws.this.b) {
                C8610Ws.this.b = 0;
            }
            if (C8610Ws.this.d[3] - C8610Ws.this.b != 0) {
                C8610Ws c8610Ws3 = C8610Ws.this;
                c8610Ws3.c = c8610Ws3.d[3] - C8610Ws.this.b;
            }
            if (C8610Ws.this.p >= 0 && C8610Ws.this.o == -1) {
                C8610Ws.this.p = -1L;
                C8610Ws.this.c = 0;
            }
            C8610Ws c8610Ws4 = C8610Ws.this;
            c8610Ws4.b = c8610Ws4.d[3];
            if (C8610Ws.this.H != null) {
                C8610Ws.this.H.invalidate();
            } else if (C8610Ws.this.K() != null) {
                C8610Ws.this.K().invalidate();
            }
            C8610Ws.this.R();
        }
    }

    /* renamed from: ir.nasim.Ws$c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C8610Ws.this.A) {
                boolean z = true;
                if (!C8610Ws.this.j && C8610Ws.this.B == 0) {
                    C8610Ws c8610Ws = C8610Ws.this;
                    c8610Ws.B = AnimatedFileDrawable.createDecoder(c8610Ws.k.getAbsolutePath(), C8610Ws.this.d, C8610Ws.this.m, C8610Ws.this.l, null, false);
                    C8610Ws.this.j = true;
                }
                try {
                    if (C8610Ws.this.B == 0 && C8610Ws.this.d[0] != 0 && C8610Ws.this.d[1] != 0) {
                        AbstractC21455b.m1(C8610Ws.this.Y);
                        return;
                    }
                    if (C8610Ws.this.h == null && C8610Ws.this.d[0] > 0 && C8610Ws.this.d[1] > 0) {
                        try {
                            C8610Ws c8610Ws2 = C8610Ws.this;
                            c8610Ws2.h = Bitmap.createBitmap(c8610Ws2.d[0], C8610Ws.this.d[1], Bitmap.Config.ARGB_8888);
                        } catch (Throwable th) {
                            C19406qI3.d("baleMessenger", th);
                        }
                    }
                    if (C8610Ws.this.o >= 0) {
                        C8610Ws.this.d[3] = (int) C8610Ws.this.o;
                        long j = C8610Ws.this.o;
                        synchronized (C8610Ws.this.r) {
                            C8610Ws.this.o = -1L;
                        }
                        AnimatedFileDrawable.seekToMs(C8610Ws.this.B, j, false);
                    } else {
                        z = false;
                    }
                    if (C8610Ws.this.h != null) {
                        C8610Ws.this.s = System.currentTimeMillis();
                        if (AnimatedFileDrawable.getVideoFrame(C8610Ws.this.B, C8610Ws.this.h, C8610Ws.this.d, C8610Ws.this.h.getRowBytes(), false, -1.0f, -1.0f) == 0) {
                            AbstractC21455b.m1(C8610Ws.this.Y);
                            return;
                        } else if (z) {
                            C8610Ws c8610Ws3 = C8610Ws.this;
                            c8610Ws3.b = c8610Ws3.d[3];
                        }
                    }
                } catch (Throwable th2) {
                    C19406qI3.d("baleMessenger", th2);
                }
            }
            AbstractC21455b.m1(C8610Ws.this.Z);
        }
    }

    public C8610Ws(File file) {
        this(file, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View K() {
        WeakReference weakReference = this.G;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        View view = this.H;
        if (view != null) {
            view.invalidate();
        } else if (K() != null) {
            K().invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        View view = this.H;
        if (view != null) {
            view.invalidate();
        } else if (K() != null) {
            K().invalidate();
        }
    }

    protected static void Q(Runnable runnable) {
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = B0;
        if (looperMyLooper == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() throws InterruptedException {
        if (this.e == null) {
            long jMin = 0;
            if ((this.B == 0 && this.j) || this.i || !this.z) {
                return;
            }
            if (this.s != 0) {
                int i = this.c;
                jMin = Math.min(i, Math.max(0L, i - (System.currentTimeMillis() - this.s)));
            }
            if (this.D == null) {
                this.D = SZ.g("Q_AFD_GetFrame");
            }
            NZ nz = this.D;
            Runnable runnable = this.z0;
            this.e = runnable;
            nz.postRunnable(runnable, jMin);
        }
    }

    public Bitmap I() {
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null) {
            return bitmap2;
        }
        return null;
    }

    public int J() {
        return this.d[2];
    }

    public boolean L() {
        return (this.B == 0 || (this.f == null && this.g == null)) ? false : true;
    }

    public C8610Ws O() {
        C8610Ws c8610Ws = new C8610Ws(this.k, false);
        int[] iArr = c8610Ws.d;
        int[] iArr2 = this.d;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        return c8610Ws;
    }

    public void P() {
        if (this.H != null) {
            this.n = true;
            return;
        }
        this.z = false;
        this.A = true;
        if (this.e != null) {
            this.i = true;
            return;
        }
        if (this.B != 0) {
            AnimatedFileDrawable.destroyDecoder(this.B);
            this.B = 0L;
        }
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.g = null;
        }
        NZ nz = this.D;
        if (nz != null) {
            nz.recycle();
            this.D = null;
        }
    }

    public void S(View view) {
        if (K() != null) {
            return;
        }
        this.G = new WeakReference(view);
    }

    public void T(View view) {
        this.H = view;
        if (view == null && this.n) {
            P();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) throws InterruptedException {
        if ((this.B == 0 && this.j) || this.i) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.z) {
            Bitmap bitmap = this.f;
            if (bitmap == null && this.g == null) {
                R();
            } else if (this.g != null && (bitmap == null || Math.abs(jCurrentTimeMillis - this.a) >= this.c)) {
                this.f = this.g;
                this.g = null;
                this.a = jCurrentTimeMillis;
            }
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 != null) {
            if (this.x) {
                int width = bitmap2.getWidth();
                int height = this.f.getHeight();
                int i = this.d[2];
                if (i == 90 || i == 270) {
                    height = width;
                    width = height;
                }
                this.y.set(getBounds());
                this.v = this.y.width() / width;
                this.w = this.y.height() / height;
                this.x = false;
            }
            Rect rect = this.y;
            canvas.translate(rect.left, rect.top);
            int i2 = this.d[2];
            if (i2 == 90) {
                canvas.rotate(90.0f);
                canvas.translate(0.0f, -this.y.width());
            } else if (i2 == 180) {
                canvas.rotate(180.0f);
                canvas.translate(-this.y.width(), -this.y.height());
            } else if (i2 == 270) {
                canvas.rotate(270.0f);
                canvas.translate(-this.y.height(), 0.0f);
            }
            canvas.scale(this.v, this.w);
            canvas.drawBitmap(this.f, 0.0f, 0.0f, getPaint());
            if (this.z) {
                long jMax = Math.max(1L, (this.c - (jCurrentTimeMillis - this.a)) - 17);
                Handler handler = B0;
                handler.removeCallbacks(this.J);
                handler.postDelayed(this.J, Math.min(jMax, this.c));
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            P();
        } finally {
            super.finalize();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        if (this.j) {
            int[] iArr = this.d;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[0] : iArr[1];
        }
        return i == 0 ? AbstractC21455b.F(this.u) : i;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        if (this.j) {
            int[] iArr = this.d;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[1] : iArr[0];
        }
        return i == 0 ? AbstractC21455b.F(this.t) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int i = 0;
        if (this.j) {
            int[] iArr = this.d;
            int i2 = iArr[2];
            i = (i2 == 90 || i2 == 270) ? iArr[0] : iArr[1];
        }
        return i == 0 ? AbstractC21455b.F(100.0f) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int i = 0;
        if (this.j) {
            int[] iArr = this.d;
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
        return this.z;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.x = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() throws InterruptedException {
        if (this.z) {
            return;
        }
        this.z = true;
        R();
        Q(this.A0);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.z = false;
    }

    public C8610Ws(File file, boolean z) {
        this.c = 50;
        int[] iArr = new int[5];
        this.d = iArr;
        this.o = -1L;
        this.p = -1L;
        this.r = new Object();
        this.t = 100;
        this.u = 100;
        this.v = 1.0f;
        this.w = 1.0f;
        this.y = new Rect();
        this.H = null;
        this.J = new Runnable() { // from class: ir.nasim.Us
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        };
        this.Y = new a();
        this.Z = new b();
        this.z0 = new c();
        this.A0 = new Runnable() { // from class: ir.nasim.Vs
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N();
            }
        };
        this.k = file;
        this.l = 0L;
        this.m = 1;
        getPaint().setFlags(2);
        if (z) {
            this.B = AnimatedFileDrawable.createDecoder(file.getAbsolutePath(), iArr, this.m, this.l, null, false);
            this.j = true;
        }
    }

    public C8610Ws(File file, boolean z, int i, int i2) {
        this.c = 50;
        int[] iArr = new int[5];
        this.d = iArr;
        this.o = -1L;
        this.p = -1L;
        this.r = new Object();
        this.t = 100;
        this.u = 100;
        this.v = 1.0f;
        this.w = 1.0f;
        this.y = new Rect();
        this.H = null;
        this.J = new Runnable() { // from class: ir.nasim.Us
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        };
        this.Y = new a();
        this.Z = new b();
        this.z0 = new c();
        this.A0 = new Runnable() { // from class: ir.nasim.Vs
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N();
            }
        };
        this.k = file;
        this.l = 0L;
        this.m = 1;
        this.t = i;
        this.u = i2;
        getPaint().setFlags(2);
        if (z) {
            this.B = AnimatedFileDrawable.createDecoder(file.getAbsolutePath(), iArr, this.m, this.l, null, false);
            this.j = true;
        }
    }
}
