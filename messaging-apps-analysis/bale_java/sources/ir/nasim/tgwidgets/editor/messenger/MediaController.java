package ir.nasim.tgwidgets.editor.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.graphics.Matrix;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C22102ug0;
import ir.nasim.C22697vg5;
import ir.nasim.C4278El2;
import ir.nasim.FT7;
import ir.nasim.HU1;
import ir.nasim.U00;
import ir.nasim.ZO1;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class MediaController implements E.d, SensorEventListener {
    public static ArrayList M0 = new ArrayList();
    private static final String[] N0;
    private static final String[] O0;
    private static final ConcurrentHashMap P0;
    private static Runnable Q0;
    public static h R0;
    public static h S0;
    private static Runnable T0;
    private static volatile MediaController U0;
    private int A;
    private AspectRatioFrameLayout B;
    private boolean D;
    private HU1 D0;
    private Activity E0;
    private boolean F0;
    private FrameLayout G;
    private float G0;
    private float H;
    private int H0;
    private boolean I0;
    private SensorManager b;
    private PowerManager.WakeLock c;
    private Sensor d;
    private Sensor e;
    private boolean f;
    private ArrayList i;
    private SparseArray j;
    private int o;
    private String p;
    private long q;
    private float r;
    private C10743c74 t;
    private boolean w;
    private FT7 x;
    private boolean y;
    private TextureView z;
    private final Object a = new Object();
    private int g = 0;
    private ArrayList h = new ArrayList();
    public boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private FT7 n = null;
    private long s = 0;
    private Timer u = null;
    private final Object v = new Object();
    private ArrayList J = new ArrayList();
    private HashMap Y = new HashMap();
    private ArrayList Z = new ArrayList();
    private boolean[] z0 = {false, false};
    private int[] A0 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private Runnable B0 = new a();
    private final Object C0 = new Object();
    private float J0 = 1.0f;
    private float K0 = 1.0f;
    AudioManager.OnAudioFocusChangeListener L0 = new AudioManager.OnAudioFocusChangeListener() { // from class: ir.nasim.LW3
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            this.a.n0(i2);
        }
    };

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MediaController.this.t == null) {
                return;
            }
            C4278El2.H(MediaController.this.t.N).f0(MediaController.this.t.I(), true, false);
        }
    }

    class b extends TimerTask {
        final /* synthetic */ C10743c74 a;

        b(C10743c74 c10743c74) {
            this.a = c10743c74;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, float f) {
            AbstractC14047hG.a.getSharedPreferences("media_saved_pos", 0).edit().putFloat(str, f).commit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(C10743c74 c10743c74) {
            long jU1;
            long jS1;
            final float f;
            float fQ1;
            if ((MediaController.this.n == null && MediaController.this.x == null) || MediaController.this.l) {
                return;
            }
            try {
                if (MediaController.this.x != null) {
                    jU1 = MediaController.this.x.u1();
                    jS1 = MediaController.this.x.s1();
                    if (jS1 >= 0 && jU1 > 0) {
                        float f2 = jU1;
                        fQ1 = MediaController.this.x.q1() / f2;
                        f = jS1 / f2;
                        if (f >= 1.0f) {
                            return;
                        }
                    }
                    return;
                }
                jU1 = MediaController.this.n.u1();
                jS1 = MediaController.this.n.s1();
                float f3 = jU1 >= 0 ? jS1 / jU1 : 0.0f;
                float fQ12 = MediaController.this.n.q1() / jU1;
                if (jU1 != -9223372036854775807L && jS1 >= 0 && MediaController.this.r == 0.0f) {
                    f = f3;
                    fQ1 = fQ12;
                }
                return;
                MediaController.this.s = jS1;
                c10743c74.x = (int) (jU1 / 1000);
                c10743c74.s = f;
                c10743c74.w = (int) (MediaController.this.s / 1000);
                c10743c74.v = fQ1;
                if (f >= 0.0f && MediaController.this.p != null && SystemClock.elapsedRealtime() - MediaController.this.q >= 1000) {
                    final String str = MediaController.this.p;
                    MediaController.this.q = SystemClock.elapsedRealtime();
                    Utilities.e.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaController.b.c(str, f);
                        }
                    });
                }
                E.k(c10743c74.N).s(E.S1, Integer.valueOf(c10743c74.T()), Float.valueOf(f));
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (MediaController.this.C0) {
                final C10743c74 c10743c74 = this.a;
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(c10743c74);
                    }
                });
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ FT7 a;

        c(FT7 ft7) {
            this.a = ft7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                this.a.H1(true);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
    }

    class d implements FT7.d {
        final /* synthetic */ int a;
        final /* synthetic */ C10743c74 b;
        final /* synthetic */ int[] c;
        final /* synthetic */ boolean d;

        d(int i, C10743c74 c10743c74, int[] iArr, boolean z) {
            this.a = i;
            this.b = c10743c74;
            this.c = iArr;
            this.d = z;
        }

        @Override // ir.nasim.FT7.d
        public void c(boolean z, int i) {
            if (this.a != MediaController.this.o) {
                return;
            }
            MediaController.this.N0(this.b, this.c, this.d, z, i);
        }

        @Override // ir.nasim.FT7.d
        public void e(int i, int i2, int i3, float f) {
            MediaController.this.H0 = i3;
            if (i3 != 90 && i3 != 270) {
                i2 = i;
                i = i2;
            }
            MediaController.this.H = i == 0 ? 1.0f : (i2 * f) / i;
            if (MediaController.this.B != null) {
                MediaController.this.B.setAspectRatio(MediaController.this.H);
            }
        }

        @Override // ir.nasim.FT7.d
        public void s() {
        }
    }

    class e implements FT7.d {
        final /* synthetic */ int a;
        final /* synthetic */ C10743c74 b;

        e(int i, C10743c74 c10743c74) {
            this.a = i;
            this.b = c10743c74;
        }

        @Override // ir.nasim.FT7.d
        public void c(boolean z, int i) {
            if (this.a != MediaController.this.o) {
                return;
            }
            if (i == 4 || ((i == 1 || i == 2) && z && this.b.s >= 0.999f)) {
                C10743c74 c10743c74 = this.b;
                c10743c74.s = 1.0f;
                E.k(c10743c74.N).s(E.S1, Integer.valueOf(this.b.T()), 0);
                if (MediaController.this.J.isEmpty() || (MediaController.this.J.size() <= 1 && this.b.i1())) {
                    MediaController.this.R(true, true, this.b.i1(), false);
                    return;
                }
                return;
            }
            if (MediaController.this.n == null || MediaController.this.r == 0.0f) {
                return;
            }
            if (i == 3 || i == 1) {
                long jU1 = (int) (MediaController.this.n.u1() * MediaController.this.r);
                MediaController.this.n.I1(jU1);
                MediaController.this.s = jU1;
                MediaController.this.r = 0.0f;
            }
        }

        @Override // ir.nasim.FT7.d
        public void e(int i, int i2, int i3, float f) {
        }

        @Override // ir.nasim.FT7.d
        public void s() {
        }
    }

    class f implements FT7.b {
        f() {
        }

        @Override // ir.nasim.FT7.b
        public void a(boolean z, boolean z2, float[] fArr) {
        }

        @Override // ir.nasim.FT7.b
        public boolean b() {
            return false;
        }
    }

    class g implements r {
        private long a = 0;

        g() {
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.r
        public void b(long j, float f) {
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.r
        public boolean c() {
            return false;
        }
    }

    public static class h {
        public int a;
        public boolean b;
        public String c;
        public m d;
        public ArrayList e = new ArrayList();
        public SparseArray f = new SparseArray();

        public h(int i, String str, m mVar) {
            this.a = i;
            this.c = str;
            this.d = mVar;
        }

        public void a(m mVar) {
            this.e.add(mVar);
            this.f.put(mVar.u, mVar);
        }
    }

    public static class i {
        public float a;
        public float b;
        public float d;
        public int g;
        public int h;
        public int i;
        public boolean j;
        public float k;
        public float l;
        public Matrix m;
        public int n;
        public int o;
        public boolean p;
        public float q;
        public Matrix r;
        public boolean s;
        public float c = 1.0f;
        public float e = 1.0f;
        public float f = 1.0f;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i clone() {
            i iVar = new i();
            iVar.a = this.a;
            iVar.b = this.b;
            iVar.c = this.c;
            iVar.d = this.d;
            iVar.e = this.e;
            iVar.f = this.f;
            iVar.g = this.g;
            iVar.h = this.h;
            iVar.i = this.i;
            iVar.j = this.j;
            iVar.k = this.k;
            iVar.l = this.l;
            iVar.m = this.m;
            iVar.n = this.n;
            iVar.o = this.o;
            iVar.p = this.p;
            iVar.q = this.q;
            iVar.s = this.s;
            iVar.r = this.r;
            return iVar;
        }

        public boolean b() {
            Matrix matrix;
            Matrix matrix2 = this.m;
            return (matrix2 == null || matrix2.isIdentity()) && ((matrix = this.r) == null || matrix.isIdentity()) && this.e == 1.0f && this.f == 1.0f && this.c == 1.0f && this.d == 0.0f && this.g == 0 && this.h == 0 && this.i == 0 && !this.j && this.k == 0.0f && this.l == 0.0f && this.n == 0 && this.o == 0 && !this.p && this.q == 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class j extends ContentObserver {
        public j() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b() {
            MediaController.Q0 = null;
            MediaController.x0(0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (MediaController.Q0 != null) {
                AbstractC21455b.t(MediaController.Q0);
            }
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.z
                @Override // java.lang.Runnable
                public final void run() {
                    MediaController.j.b();
                }
            };
            MediaController.Q0 = runnable;
            AbstractC21455b.n1(runnable, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class k extends ContentObserver {
        public k() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (PhotoViewer.k8().C8()) {
                c();
            } else {
                MediaController.Q0 = null;
                MediaController.x0(0);
            }
        }

        private void c() {
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            };
            MediaController.Q0 = runnable;
            AbstractC21455b.n1(runnable, 2000L);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (MediaController.Q0 != null) {
                AbstractC21455b.t(MediaController.Q0);
            }
            c();
        }
    }

    public static class l {
        public CharSequence a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public ArrayList h;
        public n i;
        public ArrayList j;
        public ArrayList k;
        public ArrayList l;
        public H m;
        public long n;
        public boolean o;
        public boolean p;
        public boolean q;
        public int r;
        public i s;

        public void a(l lVar) {
            this.a = lVar.a;
            this.b = lVar.b;
            this.c = lVar.c;
            this.d = lVar.d;
            this.e = lVar.e;
            this.f = lVar.f;
            this.g = lVar.g;
            this.h = lVar.h;
            this.i = lVar.i;
            this.j = lVar.j;
            this.k = lVar.k;
            this.l = lVar.l;
            this.m = lVar.m;
            this.n = lVar.n;
            this.o = lVar.o;
            this.p = lVar.p;
            this.q = lVar.q;
            this.r = lVar.r;
            this.s = lVar.s;
        }

        public abstract String b();
    }

    public static class m extends l {
        public String A;
        public int B;
        public int C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public int t;
        public int u;
        public long v;
        public int w;
        public int x;
        public int y;
        public long z;

        public m(int i, int i2, long j, String str, int i3, boolean z, int i4, int i5, long j2) {
            this.t = i;
            this.u = i2;
            this.v = j;
            this.A = str;
            this.x = i4;
            this.y = i5;
            this.z = j2;
            if (z) {
                this.w = i3;
            } else {
                this.B = i3;
            }
            this.D = z;
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.l
        public void a(l lVar) {
            super.a(lVar);
            this.E = (lVar instanceof m) && ((m) lVar).E;
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.MediaController.l
        public String b() {
            return this.A;
        }

        public m c(Pair pair) {
            this.B = ((Integer) pair.first).intValue();
            this.C = ((Integer) pair.second).intValue();
            return this;
        }
    }

    public static class n {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public int h;
        public int i;
        public float j;
        public float k;
        public float l;
        public float m;
        public int n;
        public float o;
        public PhotoFilterView.b p = new PhotoFilterView.b();
        public float q;
        public C22697vg5 r;
        public float s;
        public float t;

        public boolean a() {
            return Math.abs(this.a) < 0.1f && Math.abs(this.b) < 0.1f && Math.abs(this.c) < 0.1f && Math.abs(this.d) < 0.1f && Math.abs(this.e) < 0.1f && Math.abs(this.f) < 0.1f && Math.abs(this.g) < 0.1f && this.h == 0 && this.i == 0 && Math.abs(this.j) < 0.1f && Math.abs(this.k) < 0.1f && Math.abs(this.l) < 0.1f && Math.abs(this.m) < 0.1f && this.n == 0 && Math.abs(this.o) < 0.1f && Math.abs(this.q) < 0.1f;
        }
    }

    public static class o extends l {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class p {
        public C10743c74 a;
        public H b;
        public int c;
        public boolean d;

        public p(C10743c74 c10743c74, H h, boolean z) {
            this.a = c10743c74;
            this.c = c10743c74.N;
            this.b = h;
            this.d = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class q implements Runnable {
        private p a;

        private q(p pVar) {
            this.a = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(p pVar) throws InterruptedException {
            try {
                Thread thread = new Thread(new q(pVar), "VideoConvertRunnable");
                thread.start();
                thread.join();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        public static void c(final p pVar) {
            new Thread(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.B
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    MediaController.q.b(pVar);
                }
            }).start();
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaController.Y().T(this.a);
        }
    }

    public interface r {
        default void a(long j) {
            b(j, 1.0f);
        }

        void b(long j, float f);

        boolean c();
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        N0 = new String[]{"_id", "bucket_id", "bucket_display_name", "_data", i2 > 28 ? "date_modified" : "datetaken", "orientation", "width", "height", "_size"};
        O0 = new String[]{"_id", "bucket_id", "bucket_display_name", "_data", i2 > 28 ? "date_modified" : "datetaken", "duration", "width", "height", "_size"};
        P0 = new ConcurrentHashMap();
    }

    public MediaController() {
        HU1 hu1 = new HU1("fileEncodingQueue");
        this.D0 = hu1;
        hu1.setPriority(10);
        Utilities.e.i(new Runnable() { // from class: ir.nasim.TW3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l0();
            }
        });
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.UW3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m0();
            }
        });
        ContentResolver contentResolver = AbstractC14047hG.a.getContentResolver();
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, new j());
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, new k());
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, new j());
        } catch (Exception e4) {
            AbstractC6403Nl2.d(e4);
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.INTERNAL_CONTENT_URI, true, new k());
        } catch (Exception e5) {
            AbstractC6403Nl2.d(e5);
        }
    }

    private boolean C0(C10743c74 c10743c74) {
        if ((this.n != null || this.x != null) && c10743c74 != null && this.t != null && f0(c10743c74)) {
            try {
                J0(this.t);
                this.G0 = 1.0f;
                I0();
                FT7 ft7 = this.n;
                if (ft7 != null) {
                    ft7.E1();
                } else {
                    FT7 ft72 = this.x;
                    if (ft72 != null) {
                        ft72.E1();
                    }
                }
                this.l = false;
                E.k(this.t.N).s(E.U1, Integer.valueOf(this.t.T()));
                return true;
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        }
        return false;
    }

    public static void D0(String str, Context context, int i2, String str2, String str3, Utilities.b bVar) {
        E0(str, context, i2, str2, str3, bVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void E0(java.lang.String r15, android.content.Context r16, final int r17, final java.lang.String r18, final java.lang.String r19, final ir.nasim.tgwidgets.editor.messenger.Utilities.b r20, boolean r21) {
        /*
            r0 = r15
            r1 = r16
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L82
            if (r1 != 0) goto Lb
            goto L82
        Lb:
            boolean r4 = android.text.TextUtils.isEmpty(r15)
            r5 = 0
            if (r4 != 0) goto L2a
            java.io.File r4 = new java.io.File
            r4.<init>(r15)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L2a
            android.net.Uri r0 = android.net.Uri.fromFile(r4)
            boolean r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.A0(r0)
            if (r0 == 0) goto L28
            goto L2a
        L28:
            r8 = r4
            goto L2b
        L2a:
            r8 = r5
        L2b:
            if (r8 != 0) goto L2e
            return
        L2e:
            boolean[] r11 = new boolean[r2]
            r11[r3] = r3
            boolean r0 = r8.exists()
            if (r0 == 0) goto L82
            boolean[] r14 = new boolean[r2]
            if (r17 == 0) goto L6b
            ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog r0 = new ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog     // Catch: java.lang.Exception -> L67
            r4 = 2
            r0.<init>(r1, r4)     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = "Loading"
            int r4 = ir.nasim.TD5.tgwidget_Loading     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = ir.nasim.FH3.E(r1, r4)     // Catch: java.lang.Exception -> L67
            r0.J0(r1)     // Catch: java.lang.Exception -> L67
            r0.setCanceledOnTouchOutside(r3)     // Catch: java.lang.Exception -> L67
            r0.setCancelable(r2)     // Catch: java.lang.Exception -> L67
            ir.nasim.XW3 r1 = new ir.nasim.XW3     // Catch: java.lang.Exception -> L67
            r1.<init>()     // Catch: java.lang.Exception -> L67
            r0.setOnCancelListener(r1)     // Catch: java.lang.Exception -> L67
            ir.nasim.YW3 r1 = new ir.nasim.YW3     // Catch: java.lang.Exception -> L67
            r1.<init>()     // Catch: java.lang.Exception -> L67
            r2 = 250(0xfa, double:1.235E-321)
            ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.n1(r1, r2)     // Catch: java.lang.Exception -> L67
            r10 = r0
            goto L6c
        L67:
            r0 = move-exception
            ir.nasim.AbstractC6403Nl2.d(r0)
        L6b:
            r10 = r5
        L6c:
            java.lang.Thread r0 = new java.lang.Thread
            ir.nasim.ZW3 r1 = new ir.nasim.ZW3
            r6 = r1
            r7 = r17
            r9 = r18
            r12 = r19
            r13 = r20
            r6.<init>()
            r0.<init>(r1)
            r0.start()
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.MediaController.E0(java.lang.String, android.content.Context, int, java.lang.String, java.lang.String, ir.nasim.tgwidgets.editor.messenger.Utilities$b, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2 A[Catch: Exception -> 0x0015, TRY_LEAVE, TryCatch #0 {Exception -> 0x0015, blocks: (B:3:0x0001, B:5:0x000c, B:22:0x003f, B:23:0x0043, B:39:0x00e3, B:41:0x00f2, B:28:0x006b, B:29:0x006f, B:33:0x0097, B:34:0x009b, B:37:0x00bd, B:38:0x00c1, B:13:0x0021, B:16:0x002a), top: B:45:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.net.Uri F0(int r10, java.io.File r11, java.lang.String r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.MediaController.F0(int, java.io.File, java.lang.String):android.net.Uri");
    }

    private void I0() {
        try {
            float f2 = this.k ? 0.0f : this.g != 1 ? 1.0f : 0.2f;
            FT7 ft7 = this.n;
            if (ft7 != null) {
                ft7.S1(f2 * 0.0f);
                return;
            }
            FT7 ft72 = this.x;
            if (ft72 != null) {
                ft72.S1(f2);
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    private void J0(C10743c74 c10743c74) {
        synchronized (this.v) {
            Timer timer = this.u;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.u = null;
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
                c10743c74.N();
                Timer timer2 = new Timer();
                this.u = timer2;
                timer2.schedule(new b(c10743c74), 0L, 17L);
            } else {
                c10743c74.N();
                Timer timer22 = new Timer();
                this.u = timer22;
                timer22.schedule(new b(c10743c74), 0L, 17L);
            }
        }
    }

    private boolean K0() {
        if (this.h.isEmpty()) {
            return false;
        }
        p pVar = (p) this.h.get(0);
        H h2 = pVar.b;
        synchronized (this.a) {
            if (h2 != null) {
                try {
                    h2.J = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        q.c(pVar);
        return true;
    }

    private void L0() {
        synchronized (this.v) {
            Timer timer = this.u;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.u = null;
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(C10743c74 c10743c74, int[] iArr, boolean z, boolean z2, int i2) {
        C10743c74 c10743c742;
        if (this.x == null) {
            return;
        }
        if (i2 == 4 || i2 == 1) {
            try {
                this.E0.getWindow().clearFlags(128);
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        } else {
            try {
                this.E0.getWindow().addFlags(128);
            } catch (Exception e3) {
                AbstractC6403Nl2.d(e3);
            }
        }
        if (i2 == 3) {
            this.y = true;
            C10743c74 c10743c743 = this.t;
            if (c10743c743 != null) {
                if (c10743c743.c1() || this.t.R0()) {
                    AbstractC21455b.t(this.B0);
                    C4278El2.H(c10743c74.N).d0(this.t.I(), true, false);
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (!z2 || (c10743c742 = this.t) == null) {
                return;
            }
            if (c10743c742.c1() || this.t.R0()) {
                if (this.y) {
                    this.B0.run();
                    return;
                } else {
                    AbstractC21455b.n1(this.B0, 1000L);
                    return;
                }
            }
            return;
        }
        if (this.x.A1() && i2 == 4) {
            if (!this.t.c1() || z || (iArr != null && iArr[0] >= 4)) {
                R(true, true, true, false);
                return;
            }
            this.x.I1(0L);
            if (iArr != null) {
                iArr[0] = iArr[0] + 1;
            }
        }
    }

    private static void O(final int i2, final ArrayList arrayList, final ArrayList arrayList2, final Integer num, final h hVar, final h hVar2, final h hVar3, int i3) {
        Runnable runnable = T0;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.nasim.SW3
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.g0(i2, arrayList, arrayList2, num, hVar, hVar2, hVar3);
            }
        };
        T0 = runnable2;
        AbstractC21455b.n1(runnable2, i3);
    }

    private void S() {
        this.J.clear();
        this.Y.clear();
        this.Z.clear();
        boolean[] zArr = this.z0;
        zArr[1] = false;
        zArr[0] = false;
        int[] iArr = this.A0;
        iArr[1] = Integer.MAX_VALUE;
        iArr[0] = Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean T(ir.nasim.tgwidgets.editor.messenger.MediaController.p r51) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.MediaController.T(ir.nasim.tgwidgets.editor.messenger.MediaController$p):boolean");
    }

    private void U(final p pVar, final File file, final boolean z, final long j2, final long j3, final boolean z2, final float f2) {
        H h2 = pVar.b;
        final boolean z3 = h2.K;
        if (z3) {
            h2.K = false;
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.w
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i0(z2, z, pVar, file, f2, j2, z3, j3);
            }
        });
    }

    public static int V(int i2, int i3, int i4) {
        return W(i2, i3, i4, false);
    }

    public static int W(int i2, int i3, int i4, boolean z) throws IOException {
        MediaCodec mediaCodecCreateEncoderByType;
        String str = i2 + "" + i3 + "" + i4;
        Integer num = (Integer) P0.get(str);
        if (num != null) {
            return num.intValue();
        }
        if (z) {
            try {
                mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/hevc");
            } catch (Exception unused) {
            }
        } else {
            mediaCodecCreateEncoderByType = null;
        }
        if (mediaCodecCreateEncoderByType == null) {
            try {
                mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
            } catch (Exception unused2) {
                return i4;
            }
        }
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("max-bitrate", i4);
        mediaFormatCreateVideoFormat.setInteger("bitrate", i4);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        int integer = mediaCodecCreateEncoderByType.getOutputFormat().getInteger("bitrate");
        P0.put(str, Integer.valueOf(integer));
        mediaCodecCreateEncoderByType.release();
        return integer;
    }

    public static int X(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = mediaExtractor.getTrackFormat(i2).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i2;
                }
            } else if (string.startsWith("video/")) {
                return i2;
            }
        }
        return -5;
    }

    public static MediaController Y() {
        MediaController mediaController = U0;
        if (mediaController == null) {
            synchronized (MediaController.class) {
                try {
                    mediaController = U0;
                    if (mediaController == null) {
                        mediaController = new MediaController();
                        U0 = mediaController;
                    }
                } finally {
                }
            }
        }
        return mediaController;
    }

    public static int a0(String str) throws IllegalArgumentException {
        int i2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            i2 = 0;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
        return i2;
    }

    private static int b0(float f2) {
        return (int) (f2 * 2000.0f * 1000.0f * 1.13f);
    }

    public static boolean c0(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        boolean z = false;
        try {
            mediaExtractor.setDataSource(str);
            int iX = X(mediaExtractor, false);
            if (iX >= 0) {
                if (mediaExtractor.getTrackFormat(iX).getString("mime").equals("video/avc")) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return false;
        } finally {
            mediaExtractor.release();
        }
    }

    private boolean f0(C10743c74 c10743c74) {
        C10743c74 c10743c742 = this.t;
        if (c10743c742 != null && c10743c742.F() == c10743c74.F() && this.t.T() == c10743c74.T()) {
            return ((this.t.p > 0L ? 1 : (this.t.p == 0L ? 0 : -1)) == 0) == ((c10743c74.p > 0L ? 1 : (c10743c74.p == 0L ? 0 : -1)) == 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(int i2, ArrayList arrayList, ArrayList arrayList2, Integer num, h hVar, h hVar2, h hVar3) {
        if (PhotoViewer.k8().C8()) {
            O(i2, arrayList, arrayList2, num, hVar, hVar2, hVar3, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            return;
        }
        T0 = null;
        S0 = hVar2;
        R0 = hVar;
        E.j().s(E.d2, Integer.valueOf(i2), arrayList, arrayList2, num);
    }

    public static native byte[] getWaveform(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(FT7 ft7, ValueAnimator valueAnimator) {
        ft7.S1((this.g != 1 ? 1.0f : 0.2f) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(boolean z, boolean z2, p pVar, File file, float f2, long j2, boolean z3, long j3) {
        if (z || z2) {
            synchronized (this.a) {
                pVar.b.J = false;
            }
            this.h.remove(pVar);
            K0();
        }
        if (z) {
            E.k(pVar.c).s(E.Q1, pVar.a, file.toString(), Float.valueOf(f2), Long.valueOf(j2));
            return;
        }
        if (z3) {
            E.k(pVar.c).s(E.O1, pVar.a, file.toString(), Float.valueOf(f2), Long.valueOf(j2));
        }
        E.k(pVar.c).s(E.P1, pVar.a, file.toString(), Long.valueOf(j3), Long.valueOf(z2 ? file.length() : 0L), Float.valueOf(f2), Long.valueOf(j2));
    }

    public static native int isOpusFile(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j0(m mVar, m mVar2) {
        long j2 = mVar.v;
        long j3 = mVar2.v;
        if (j2 < j3) {
            return 1;
        }
        return j2 > j3 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(3:275|3|4)|(3:279|5|6)|263|12|(6:14|15|(1:17)(1:18)|241|19|(41:265|21|22|251|23|24|239|25|26|233|27|28|(1:30)(1:31)|285|32|33|277|34|35|271|36|37|257|38|39|(7:42|261|43|(3:300|45|303)(12:299|46|(3:48|255|49)(1:54)|(3:56|229|57)(1:61)|283|62|(2:64|(1:71)(1:70))|72|(5:74|75|269|76|(1:85)(1:82))(1:88)|89|90|302)|301|40|253)|298|91|(2:243|122)|127|247|134|(4:136|(1:138)(1:139)|140|(5:142|(1:144)(1:145)|146|(4:149|(3:293|151|296)(10:292|152|(5:154|(1:156)(1:157)|(1:159)|237|160)(1:166)|(3:168|273|169)(1:173)|267|174|(2:176|(2:186|189)(3:182|259|183))(1:190)|191|192|295)|294|147)|291))|193|(2:231|195)|200|207|(2:210|208)|297|211|212)(1:113))(1:120)|114|(0)|127|247|134|(0)|193|(0)|200|207|(1:208)|297|211|212|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0282, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0283, code lost:
    
        r33 = "_size";
        r28 = "height";
        r26 = "width";
        r24 = "_data";
        r23 = "bucket_display_name";
        r22 = "bucket_id";
        r21 = "_id";
        r25 = " DESC";
        r27 = "android.permission.READ_EXTERNAL_STORAGE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03b0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d3 A[Catch: all -> 0x03b0, TryCatch #9 {all -> 0x03b0, blocks: (B:134:0x02c7, B:136:0x02d3, B:140:0x02eb, B:142:0x02ff, B:146:0x0320, B:147:0x033c, B:149:0x0342, B:152:0x034d, B:154:0x038d), top: B:247:0x02c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x0282, TRY_LEAVE, TryCatch #17 {all -> 0x0282, blocks: (B:12:0x005d, B:14:0x0067), top: B:263:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x044e A[LOOP:1: B:208:0x0448->B:210:0x044e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x042b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x02c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0440 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void k0(int r49) {
        /*
            Method dump skipped, instructions count: 1157
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.MediaController.k0(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0() {
        try {
            SensorManager sensorManager = (SensorManager) AbstractC14047hG.a.getSystemService("sensor");
            this.b = sensorManager;
            this.d = sensorManager.getDefaultSensor(10);
            Sensor defaultSensor = this.b.getDefaultSensor(9);
            this.e = defaultSensor;
            if (this.d == null || defaultSensor == null) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("gravity or linear sensor not found");
                }
                this.d = null;
                this.e = null;
            }
            this.c = ((PowerManager) AbstractC14047hG.a.getSystemService("power")).newWakeLock(32, "Bale-tgwidget:proximity_lock");
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        E.k(0).e(this, E.M1);
        E.k(0).e(this, E.F1);
        E.k(0).e(this, E.s);
        E.k(0).e(this, E.w);
        E.k(0).e(this, E.c0);
        E.k(0).e(this, E.H0);
        E.k(0).e(this, E.T);
        E.j().e(this, E.j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(int i2) {
        if (i2 != 1) {
            this.F0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(C10743c74 c10743c74, File file) {
        E.k(c10743c74.N).s(E.M1, C4278El2.u(c10743c74.I()), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(C10743c74 c10743c74, File file) {
        E.k(c10743c74.N).s(E.M1, C4278El2.u(c10743c74.I()), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0(AlertDialog alertDialog, boolean[] zArr) {
        try {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            } else {
                zArr[0] = true;
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ee A[Catch: Exception -> 0x001b, TryCatch #10 {Exception -> 0x001b, blocks: (B:3:0x000a, B:5:0x0013, B:129:0x022d, B:12:0x0023, B:32:0x00e0, B:34:0x00e6, B:35:0x00e9, B:116:0x01ea, B:118:0x01ee, B:123:0x01f9, B:124:0x021d, B:125:0x0224, B:115:0x01e5, B:14:0x0042, B:16:0x0061, B:18:0x006e, B:20:0x0083, B:26:0x0095, B:28:0x00cf, B:31:0x00dc, B:27:0x00b8, B:17:0x0068), top: B:151:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[Catch: all -> 0x01b8, SYNTHETIC, TRY_LEAVE, TryCatch #12 {all -> 0x01b8, blocks: (B:106:0x01d6, B:105:0x01d3, B:84:0x01ad, B:101:0x01cd), top: B:153:0x00f5, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r26v15 */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r26v4, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void r0(int r24, java.io.File r25, java.lang.String r26, final ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog r27, boolean[] r28, java.lang.String r29, final ir.nasim.tgwidgets.editor.messenger.Utilities.b r30, final boolean[] r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.MediaController.r0(int, java.io.File, java.lang.String, ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog, boolean[], java.lang.String, ir.nasim.tgwidgets.editor.messenger.Utilities$b, boolean[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(boolean[] zArr, DialogInterface dialogInterface) {
        zArr[0] = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t0(boolean[] zArr, AlertDialog alertDialog) {
        if (zArr[0]) {
            return;
        }
        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v0(AlertDialog alertDialog, int i2) {
        try {
            alertDialog.K0(i2);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static void x0(final int i2) {
        Thread thread = new Thread(new Runnable() { // from class: ir.nasim.QW3
            @Override // java.lang.Runnable
            public final void run() {
                MediaController.k0(i2);
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    public static int y0(int i2, int i3, int i4, int i5, int i6) {
        return z0(i2, i3, i4, i5, i6, C22102ug0.a());
    }

    public static int z0(int i2, int i3, int i4, int i5, int i6, List list) {
        int iC;
        float fB;
        float fD;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iC = 0;
                fB = 0.0f;
                fD = 0.0f;
                break;
            }
            C22102ug0 c22102ug0 = (C22102ug0) it.next();
            if (Math.min(i5, i6) >= c22102ug0.e()) {
                iC = c22102ug0.c();
                fB = c22102ug0.b();
                fD = c22102ug0.d();
                break;
            }
        }
        int iMin = (int) (((int) (i4 / Math.min(i2 / i5, i3 / i6))) * fB);
        int iB0 = (int) (b0(fD) / (921600.0f / (i6 * i5)));
        return i4 < iB0 ? iMin : iMin > iC ? iC : Math.max(iMin, iB0);
    }

    public boolean A0(C10743c74 c10743c74) {
        return B0(c10743c74, false);
    }

    public boolean B0(final C10743c74 c10743c74, boolean z) {
        File file;
        boolean zExists;
        PowerManager.WakeLock wakeLock;
        if (c10743c74 == null) {
            return false;
        }
        this.k = z;
        if (!(this.n == null && this.x == null) && f0(c10743c74)) {
            if (this.l) {
                C0(c10743c74);
            }
            return true;
        }
        C10743c74 c10743c742 = this.t;
        Q(c10743c742 == null, false);
        this.p = null;
        this.q = 0L;
        this.r = 0.0f;
        String str = c10743c74.e.M;
        if (str == null || str.length() <= 0) {
            file = null;
            zExists = false;
        } else {
            File file2 = new File(c10743c74.e.M);
            zExists = file2.exists();
            file = !zExists ? null : file2;
        }
        final File fileR = file != null ? file : C4278El2.H(c10743c74.N).R(c10743c74.e);
        boolean z2 = AbstractC8662Wx6.a0 && (c10743c74.G0() || c10743c74.R0() || (c10743c74.c1() && c10743c74.m())) && !ZO1.c(c10743c74.F());
        if (fileR != file && !(zExists = fileR.exists()) && !z2) {
            C4278El2.H(c10743c74.N).a0(c10743c74.I(), c10743c74, 0, 0);
            this.w = true;
            this.l = false;
            this.s = 0L;
            this.t = c10743c74;
            E.k(c10743c74.N).s(E.U1, Integer.valueOf(this.t.T()));
            return true;
        }
        boolean z3 = zExists;
        this.w = false;
        if (this.B != null) {
            this.D = false;
        }
        boolean zC1 = c10743c74.c1();
        if (c10743c74.R0() || zC1) {
            int[] iArr = null;
            C4278El2.H(c10743c74.N).g0(c10743c74.I(), true);
            this.y = false;
            boolean z4 = !zC1 || (c10743c74.e.d.d == 0 && c10743c74.s <= 0.1f);
            if (zC1 && c10743c74.M() <= 30.0d) {
                iArr = new int[]{1};
            }
            S();
            FT7 ft7 = new FT7();
            this.x = ft7;
            ft7.L1(z);
            int i2 = this.o + 1;
            this.o = i2;
            final File file3 = fileR;
            File file4 = file;
            this.x.K1(new d(i2, c10743c74, iArr, z4));
            this.I0 = false;
            TextureView textureView = this.z;
            if (textureView != null) {
                this.x.R1(textureView);
            }
            if (z3) {
                if (!c10743c74.G && file3 != file4) {
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.VW3
                        @Override // java.lang.Runnable
                        public final void run() {
                            MediaController.o0(c10743c74, file3);
                        }
                    });
                }
                this.x.F1(Uri.fromFile(file3), "other");
            } else {
                try {
                    int iG = C4278El2.H(c10743c74.N).G(c10743c74);
                    AbstractC18106o57 abstractC18106o57I = c10743c74.I();
                    StringBuilder sb = new StringBuilder();
                    sb.append("?account=");
                    sb.append(c10743c74.N);
                    sb.append("&id=");
                    sb.append(abstractC18106o57I.c);
                    sb.append("&hash=");
                    sb.append(abstractC18106o57I.d);
                    sb.append("&dc=");
                    sb.append(abstractC18106o57I.m);
                    sb.append("&size=");
                    sb.append(abstractC18106o57I.j);
                    sb.append("&mime=");
                    sb.append(URLEncoder.encode(abstractC18106o57I.i, "UTF-8"));
                    sb.append("&rid=");
                    sb.append(iG);
                    sb.append("&name=");
                    sb.append(URLEncoder.encode(C4278El2.C(abstractC18106o57I), "UTF-8"));
                    sb.append("&reference=");
                    byte[] bArr = abstractC18106o57I.e;
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    sb.append(Utilities.b(bArr));
                    this.x.F1(Uri.parse("tg://" + c10743c74.N() + sb.toString()), "other");
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
            if (c10743c74.R0()) {
                this.x.P1(this.f ? 0 : 3);
                if (Math.abs(this.J0 - 1.0f) > 0.001f) {
                    this.x.O1(Math.round(this.J0 * 10.0f) / 10.0f);
                }
                float f2 = c10743c74.t;
                if (f2 >= 0.0f) {
                    this.r = f2;
                    c10743c74.s = f2;
                    c10743c74.t = -1.0f;
                }
            } else {
                this.x.P1(3);
            }
        } else {
            try {
                FT7 ft72 = new FT7();
                this.n = ft72;
                int i3 = this.o + 1;
                this.o = i3;
                ft72.K1(new e(i3, c10743c74));
                this.n.J1(new f());
                if (z3) {
                    if (!c10743c74.G && fileR != file) {
                        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.WW3
                            @Override // java.lang.Runnable
                            public final void run() {
                                MediaController.p0(c10743c74, fileR);
                            }
                        });
                    }
                    this.n.F1(Uri.fromFile(fileR), "other");
                } else {
                    int iG2 = C4278El2.H(c10743c74.N).G(c10743c74);
                    AbstractC18106o57 abstractC18106o57I2 = c10743c74.I();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("?account=");
                    sb2.append(c10743c74.N);
                    sb2.append("&id=");
                    sb2.append(abstractC18106o57I2.c);
                    sb2.append("&hash=");
                    sb2.append(abstractC18106o57I2.d);
                    sb2.append("&dc=");
                    sb2.append(abstractC18106o57I2.m);
                    sb2.append("&size=");
                    sb2.append(abstractC18106o57I2.j);
                    sb2.append("&mime=");
                    sb2.append(URLEncoder.encode(abstractC18106o57I2.i, "UTF-8"));
                    sb2.append("&rid=");
                    sb2.append(iG2);
                    sb2.append("&name=");
                    sb2.append(URLEncoder.encode(C4278El2.C(abstractC18106o57I2), "UTF-8"));
                    sb2.append("&reference=");
                    byte[] bArr2 = abstractC18106o57I2.e;
                    if (bArr2 == null) {
                        bArr2 = new byte[0];
                    }
                    sb2.append(Utilities.b(bArr2));
                    this.n.F1(Uri.parse("tg://" + c10743c74.N() + sb2.toString()), "other");
                }
                if (c10743c74.i1()) {
                    String strN = c10743c74.N();
                    if (strN != null && c10743c74.M() >= 300.0d) {
                        float f3 = AbstractC14047hG.a.getSharedPreferences("media_saved_pos", 0).getFloat(strN, -1.0f);
                        if (f3 > 0.0f && f3 < 0.99f) {
                            this.r = f3;
                            c10743c74.s = f3;
                        }
                        this.p = strN;
                    }
                    if (Math.abs(this.J0 - 1.0f) > 0.001f) {
                        this.n.O1(Math.round(this.J0 * 10.0f) / 10.0f);
                    }
                    S();
                } else {
                    String strN2 = c10743c74.N();
                    if (!TextUtils.isEmpty(strN2) && c10743c74.M() >= 600.0d) {
                        float f4 = AbstractC14047hG.a.getSharedPreferences("media_saved_pos", 0).getFloat(strN2, -1.0f);
                        if (f4 > 0.0f && f4 < 0.999f) {
                            this.r = f4;
                            c10743c74.s = f4;
                        }
                        this.p = strN2;
                        if (Math.abs(this.K0 - 1.0f) > 0.001f) {
                            this.n.O1(Math.round(this.K0 * 10.0f) / 10.0f);
                        }
                    }
                }
                float f5 = c10743c74.t;
                if (f5 >= 0.0f) {
                    this.r = f5;
                    c10743c74.s = f5;
                    c10743c74.t = -1.0f;
                }
                this.n.P1(this.f ? 0 : 3);
                this.n.E1();
                if (c10743c74.i1()) {
                    this.G0 = 1.0f;
                    I0();
                }
            } catch (Exception e3) {
                AbstractC6403Nl2.d(e3);
                E eK = E.k(c10743c74.N);
                int i4 = E.U1;
                C10743c74 c10743c743 = this.t;
                eK.s(i4, Integer.valueOf(c10743c743 != null ? c10743c743.T() : 0));
                FT7 ft73 = this.n;
                if (ft73 == null) {
                    return false;
                }
                ft73.H1(true);
                this.n = null;
                ir.nasim.tgwidgets.editor.ui.ActionBar.m.j1(this.t);
                this.l = false;
                this.t = null;
                this.w = false;
                return false;
            }
        }
        I0();
        this.l = false;
        this.s = 0L;
        this.t = c10743c74;
        AbstractC8662Wx6.f(true);
        if (!AbstractC14047hG.c && (wakeLock = this.c) != null && !wakeLock.isHeld() && (this.t.i1() || this.t.R0())) {
            AbstractC8662Wx6.f(false);
        }
        J0(this.t);
        E.k(c10743c74.N).s(E.V1, c10743c74, c10743c742);
        FT7 ft74 = this.x;
        if (ft74 == null) {
            FT7 ft75 = this.n;
            if (ft75 == null) {
                return true;
            }
            try {
                if (this.t.s == 0.0f) {
                    return true;
                }
                long jU1 = ft75.u1();
                if (jU1 == -9223372036854775807L) {
                    jU1 = ((long) this.t.M()) * 1000;
                }
                this.n.I1((int) (jU1 * this.t.s));
                return true;
            } catch (Exception e4) {
                this.t.x1();
                E.k(c10743c74.N).s(E.S1, Integer.valueOf(this.t.T()), 0);
                AbstractC6403Nl2.d(e4);
                return true;
            }
        }
        try {
            if (this.t.s != 0.0f) {
                long jU12 = ft74.u1();
                if (jU12 == -9223372036854775807L) {
                    jU12 = ((long) this.t.M()) * 1000;
                }
                C10743c74 c10743c744 = this.t;
                int i5 = (int) (jU12 * c10743c744.s);
                int i6 = c10743c744.u;
                if (i6 != 0) {
                    c10743c744.u = 0;
                    i5 = i6;
                }
                this.x.I1(i5);
            }
        } catch (Exception e5) {
            C10743c74 c10743c745 = this.t;
            c10743c745.s = 0.0f;
            c10743c745.w = 0;
            E.k(c10743c74.N).s(E.S1, Integer.valueOf(this.t.T()), 0);
            AbstractC6403Nl2.d(e5);
        }
        this.x.E1();
        return true;
    }

    public void G0(C10743c74 c10743c74) {
        H0(c10743c74, false, true);
    }

    public boolean H0(C10743c74 c10743c74, boolean z, boolean z2) {
        if (c10743c74 == null || c10743c74.D == null) {
            return false;
        }
        if (z && !this.h.isEmpty()) {
            return false;
        }
        if (z) {
            new File(c10743c74.e.M).delete();
        }
        this.h.add(new p(c10743c74, c10743c74.D, z2));
        if (this.h.size() == 1) {
            K0();
        }
        return true;
    }

    public void M0() {
        C10743c74 c10743c74Z = Z();
        if (c10743c74Z != null && d0() && this.m && (c10743c74Z.i1() || c10743c74Z.G0())) {
            A0(c10743c74Z);
        }
        this.m = false;
    }

    public void P(C10743c74 c10743c74) {
        if (c10743c74 == null || this.h.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            p pVar = (p) this.h.get(i2);
            C10743c74 c10743c742 = pVar.a;
            if (c10743c742.v(c10743c74) && c10743c742.N == c10743c74.N) {
                if (i2 != 0) {
                    this.h.remove(i2);
                    return;
                }
                synchronized (this.a) {
                    pVar.b.J = true;
                }
                return;
            }
        }
    }

    public void Q(boolean z, boolean z2) {
        R(z, z2, false, false);
    }

    public void R(boolean z, boolean z2, boolean z3, boolean z4) {
        C10743c74 c10743c74;
        FT7 ft7 = this.n;
        if (ft7 != null) {
            if (!ft7.A1() || (c10743c74 = this.t) == null || c10743c74.i1()) {
                try {
                    this.n.H1(true);
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            } else {
                final FT7 ft72 = this.n;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.aX3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.a.h0(ft72, valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new c(ft72));
                valueAnimatorOfFloat.setDuration(300L);
                valueAnimatorOfFloat.start();
            }
            this.n = null;
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.j1(this.t);
        } else {
            FT7 ft73 = this.x;
            if (ft73 != null) {
                this.B = null;
                this.G = null;
                this.D = false;
                this.z = null;
                if (z4) {
                    PhotoViewer.k8().x8(this.x);
                    E.k(this.t.N).s(E.X1, this.t, Boolean.TRUE);
                } else {
                    long jS1 = ft73.s1();
                    C10743c74 c10743c742 = this.t;
                    if (c10743c742 != null && c10743c742.c1() && jS1 > 0) {
                        C10743c74 c10743c743 = this.t;
                        c10743c743.u = (int) jS1;
                        E.k(c10743c743.N).s(E.X1, this.t, Boolean.FALSE);
                    }
                    this.x.H1(true);
                    this.x = null;
                }
                try {
                    this.E0.getWindow().clearFlags(128);
                } catch (Exception e3) {
                    AbstractC6403Nl2.d(e3);
                }
                if (this.t != null && !z4) {
                    AbstractC21455b.t(this.B0);
                    C4278El2.H(this.t.N).d0(this.t.I(), true, false);
                }
            }
        }
        L0();
        this.s = 0L;
        this.l = false;
        PowerManager.WakeLock wakeLock = this.c;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.c.release();
        }
        C10743c74 c10743c744 = this.t;
        if (c10743c744 != null) {
            if (this.w) {
                C4278El2.H(c10743c744.N).j(this.t.I());
            }
            C10743c74 c10743c745 = this.t;
            if (z) {
                c10743c745.x1();
                E.k(c10743c745.N).s(E.S1, Integer.valueOf(this.t.T()), 0);
            }
            this.t = null;
            this.w = false;
            if (z) {
                ArrayList arrayList = this.i;
                int iIndexOf = -1;
                if (arrayList != null) {
                    if (!z3 || (iIndexOf = arrayList.indexOf(c10743c745)) < 0) {
                        this.i = null;
                        this.j = null;
                    } else {
                        this.i.remove(iIndexOf);
                        this.j.remove(c10743c745.T());
                        if (this.i.isEmpty()) {
                            this.i = null;
                            this.j = null;
                        }
                    }
                }
                ArrayList arrayList2 = this.i;
                if (arrayList2 != null && iIndexOf < arrayList2.size()) {
                    A0((C10743c74) this.i.get(iIndexOf));
                    return;
                }
                if (c10743c745.i1() || c10743c745.R0()) {
                    c10743c745.T();
                }
                E.k(c10743c745.N).s(E.T1, Integer.valueOf(c10743c745.T()), Boolean.valueOf(z2));
                this.A = 0;
            }
        }
    }

    public C10743c74 Z() {
        return this.t;
    }

    public boolean d0() {
        return this.l || this.w;
    }

    public boolean e0(C10743c74 c10743c74) {
        C10743c74 c10743c742;
        if ((this.n != null || this.x != null) && c10743c74 != null && (c10743c742 = this.t) != null) {
            long j2 = c10743c742.p;
            if (j2 != 0 && j2 == c10743c74.p) {
                return !this.w;
            }
            if (f0(c10743c74)) {
                return !this.w;
            }
        }
        return false;
    }

    public native byte[] getWaveform2(short[] sArr, int i2);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
    }

    public native int startRecord(String str, int i2);

    public native void stopRecord();

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i2, int i3, Object... objArr) {
        if (i2 == E.M1 || i2 == E.F1) {
            String str = (String) objArr[0];
            C10743c74 c10743c74 = this.t;
            if (c10743c74 != null && c10743c74.N == i3) {
                C4278El2.u(c10743c74.I()).equals(str);
            }
        }
        if (i2 == E.T) {
            U00.d(AbstractC14047hG.a, "mediaDidLoad");
        }
    }

    public native int writeFrame(ByteBuffer byteBuffer, int i2);
}
