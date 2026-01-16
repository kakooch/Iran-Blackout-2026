package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import ir.nasim.AbstractC11436d03;
import ir.nasim.AbstractC12384eX1;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.C5713Kn0;
import ir.nasim.C9151Ys;
import ir.nasim.FT7;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView;
import ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public class PreviewView extends FrameLayout {
    public static long a1 = 59500;
    private boolean A;
    private boolean A0;
    private final PointF B;
    private Matrix B0;
    private Matrix C0;
    private final PointF D;
    private float D0;
    private boolean E0;
    private boolean F0;
    private float G;
    private boolean G0;
    private double H;
    private float[] H0;
    private AbstractC11436d03 I0;
    private boolean J;
    private boolean J0;
    private boolean K0;
    private float L0;
    private float M0;
    private boolean N0;
    private int O0;
    private boolean P0;
    private C9151Ys Q0;
    private float R0;
    private float S0;
    private Matrix T0;
    private float[] U0;
    private long V0;
    private float W0;
    private float X0;
    private Runnable Y0;
    private final HashSet Z0;
    private Bitmap a;
    private Bitmap b;
    private l c;
    private FT7 d;
    private int e;
    private int f;
    private VideoEditTextureView g;
    public TextureView h;
    private VideoTimelinePlayView i;
    private final Paint j;
    private final HashMap k;
    private final HashMap l;
    private long m;
    private final Runnable n;
    private Runnable o;
    private final Paint p;
    private final Paint q;
    private final Matrix r;
    private final float[] s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private final C9151Ys z;
    private boolean z0;

    class a implements VideoTimelinePlayView.c {
        private Runnable a;
        private boolean b;
        private long c;
        private Runnable d;
        private int e;

        a() {
        }

        private void h(long j) {
            this.c = j;
            if (this.b) {
                PreviewView.this.J(false, j, false);
            } else if (this.a == null) {
                Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k();
                    }
                };
                this.a = runnable;
                AbstractC21455b.n1(runnable, 150L);
            }
        }

        private long i() {
            return PreviewView.this.getDuration() == -9223372036854775807L ? PreviewView.this.c.y : PreviewView.this.getDuration();
        }

        private float j(long j) {
            return j / (PreviewView.this.getDuration() == -9223372036854775807L ? PreviewView.this.c.y : PreviewView.this.getDuration());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            this.b = true;
            this.a = null;
            PreviewView.this.J(true, this.c, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            if (PreviewView.this.d != null) {
                PreviewView.this.d.I1(this.e);
            }
            PreviewView.this.t();
            this.d = null;
        }

        private void m(float f) {
            if (PreviewView.this.d == null) {
                return;
            }
            this.e = (int) (PreviewView.this.getDuration() * f);
            if (AbstractC8662Wx6.h() == 2) {
                if (PreviewView.this.d != null) {
                    PreviewView.this.d.I1(this.e);
                }
                PreviewView.this.t();
                this.d = null;
                return;
            }
            if (this.d == null) {
                Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l();
                    }
                };
                this.d = runnable;
                AbstractC21455b.n1(runnable, 100L);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void a(float f) {
            if (PreviewView.this.d != null) {
                if (PreviewView.this.d.A1()) {
                    PreviewView.this.d.D1();
                }
                PreviewView.this.c.v = f;
                PreviewView.this.c.u = Utilities.c(Math.max(PreviewView.this.c.u, PreviewView.this.c.v - j(PreviewView.a1)), 1.0f, 0.0f);
                PreviewView.this.c.v = Utilities.c(Math.max(PreviewView.this.c.v, PreviewView.this.c.u + j(1000L)), 1.0f, 0.0f);
                PreviewView.this.i.setLeftRightProgress(PreviewView.this.c.u, PreviewView.this.c.v);
                m(PreviewView.this.c.v);
                PreviewView.this.i.setProgress(PreviewView.this.c.v);
                h((long) (PreviewView.this.c.v * i()));
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void b(int i) {
            if (PreviewView.this.d == null) {
                return;
            }
            PreviewView.this.O(-1, true);
            h((long) (PreviewView.this.i.j(i) * i()));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void c(int i) {
            Runnable runnable = this.d;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
                this.d.run();
            }
            if (PreviewView.this.d != null && !PreviewView.this.d.A1()) {
                float fS1 = PreviewView.this.d.s1() / PreviewView.this.getDuration();
                if (fS1 < PreviewView.this.c.u || fS1 > PreviewView.this.c.v) {
                    m(PreviewView.this.c.u * PreviewView.this.getDuration());
                }
                PreviewView.this.O(-1, false);
            }
            this.b = false;
            Runnable runnable2 = this.a;
            if (runnable2 != null) {
                AbstractC21455b.t(runnable2);
                this.a = null;
            }
            PreviewView.this.J(false, this.c, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void d(float f) {
            if (PreviewView.this.d != null) {
                if (PreviewView.this.d.A1()) {
                    PreviewView.this.d.D1();
                }
                PreviewView.this.c.u = f;
                PreviewView.this.c.v = Utilities.c(Math.min(PreviewView.this.c.v, PreviewView.this.c.u + j(PreviewView.a1)), 1.0f, 0.0f);
                PreviewView.this.c.u = Utilities.c(Math.min(PreviewView.this.c.u, PreviewView.this.c.v - j(1000L)), 1.0f, 0.0f);
                PreviewView.this.i.setLeftRightProgress(PreviewView.this.c.u, PreviewView.this.c.v);
                m(PreviewView.this.c.u);
                PreviewView.this.i.setProgress(PreviewView.this.c.u);
                h((long) (PreviewView.this.c.u * i()));
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.VideoTimelinePlayView.c
        public void e(float f) {
            if (PreviewView.this.d != null) {
                m(f);
            }
            h((long) (f * i()));
        }
    }

    class b implements FT7.d {
        final /* synthetic */ l a;
        final /* synthetic */ Runnable[] b;

        b(l lVar, Runnable[] runnableArr) {
            this.a = lVar;
            this.b = runnableArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(l lVar) {
            if (PreviewView.this.a != null) {
                PreviewView.this.a.recycle();
                if (lVar.H == PreviewView.this.a) {
                    lVar.H = null;
                }
                PreviewView.this.a = null;
                PreviewView.this.invalidate();
            }
        }

        @Override // ir.nasim.FT7.d
        public void c(boolean z, int i) {
            if (PreviewView.this.d == null) {
                return;
            }
            if (PreviewView.this.d == null || !PreviewView.this.d.A1()) {
                AbstractC21455b.t(PreviewView.this.n);
            } else {
                AbstractC21455b.m1(PreviewView.this.n);
            }
        }

        @Override // ir.nasim.FT7.d
        public void e(int i, int i2, int i3, float f) {
            l lVar = this.a;
            if (lVar != null) {
                lVar.S = PreviewView.this.d.v1(this.a.S);
                if (PreviewView.this.g != null) {
                    PreviewView.this.g.setHDRInfo(this.a.S);
                }
            }
            PreviewView.this.e = (int) (i * f);
            PreviewView.this.f = (int) (i2 * f);
            l lVar2 = this.a;
            if (lVar2 != null && (lVar2.b != PreviewView.this.e || this.a.c != PreviewView.this.f)) {
                this.a.b = PreviewView.this.e;
                this.a.c = PreviewView.this.f;
                this.a.K();
            }
            PreviewView.this.t();
            if (PreviewView.this.g != null) {
                PreviewView.this.g.setVideoSize(PreviewView.this.e, PreviewView.this.f);
            }
        }

        @Override // ir.nasim.FT7.d
        public void s() {
            Runnable runnable = this.b[0];
            if (runnable == null) {
                if (PreviewView.this.g != null) {
                    ViewPropertyAnimator duration = PreviewView.this.g.animate().alpha(1.0f).setDuration(180L);
                    final l lVar = this.a;
                    duration.withEndAction(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.g(lVar);
                        }
                    }).start();
                    return;
                }
                return;
            }
            PreviewView.this.post(runnable);
            this.b[0] = null;
            if (PreviewView.this.a != null) {
                PreviewView.this.a.recycle();
                if (this.a.H == PreviewView.this.a) {
                    this.a.H = null;
                }
                PreviewView.this.a = null;
                PreviewView.this.invalidate();
            }
        }
    }

    public PreviewView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.j = paint;
        this.k = new HashMap();
        this.l = new HashMap();
        this.n = new Runnable() { // from class: ir.nasim.fq5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        };
        this.p = new Paint(7);
        this.q = new Paint(1);
        this.r = new Matrix();
        this.s = new float[2];
        this.y = true;
        this.z = new C9151Ys(this, 0L, 320L, InterpolatorC12631ew1.g);
        this.A = true;
        this.B = new PointF();
        this.D = new PointF();
        this.B0 = new Matrix();
        this.C0 = new Matrix();
        this.H0 = new float[4];
        this.Q0 = new C9151Ys(this, 0L, 280L, InterpolatorC12631ew1.h);
        this.U0 = new float[2];
        this.Z0 = new HashSet();
        VideoTimelinePlayView videoTimelinePlayView = new VideoTimelinePlayView(context);
        this.i = videoTimelinePlayView;
        videoTimelinePlayView.setMode(0);
        this.i.setDelegate(new a());
        paint.setStrokeWidth(AbstractC21455b.F(1.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        paint.setShadowLayer(AbstractC21455b.F(3.0f), 0.0f, AbstractC21455b.F(1.0f), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap A(l lVar, long j, String str, BitmapFactory.Options options) {
        if (!lVar.p) {
            return BitmapFactory.decodeFile(str, options);
        }
        String str2 = lVar.s;
        if (str2 != null) {
            return BitmapFactory.decodeFile(str2, options);
        }
        try {
            return MediaStore.Video.Thumbnails.getThumbnail(getContext().getContentResolver(), j, 1, options);
        } catch (Throwable unused) {
            invalidate();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        VideoEditTextureView videoEditTextureView = this.g;
        if (videoEditTextureView != null) {
            videoEditTextureView.f();
            removeView(this.g);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(l.b bVar) {
        VideoEditTextureView videoEditTextureView = this.g;
        if (videoEditTextureView != null) {
            videoEditTextureView.setHDRInfo(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        final int measuredHeight = getMeasuredHeight() > 0 ? getMeasuredHeight() : AbstractC21455b.h.y;
        l lVar = this.c;
        if (lVar.D == 0 || lVar.E == 0) {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                AbstractC12384eX1.b(true, bitmap, true, new Utilities.b() { // from class: ir.nasim.jq5
                    @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                    public final void a(Object obj) {
                        this.a.y(measuredHeight, (int[]) obj);
                    }
                });
            } else {
                Bitmap bitmap2 = this.b;
                if (bitmap2 != null) {
                    AbstractC12384eX1.b(true, bitmap2, true, new Utilities.b() { // from class: ir.nasim.kq5
                        @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                        public final void a(Object obj) {
                            this.a.z(measuredHeight, (int[]) obj);
                        }
                    });
                } else {
                    this.q.setShader(null);
                }
            }
        } else {
            Paint paint = this.q;
            float f = measuredHeight;
            l lVar2 = this.c;
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f, new int[]{lVar2.D, lVar2.E}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        }
        invalidate();
    }

    private void L(l lVar, Runnable runnable, long j) {
        if (lVar == null) {
            FT7 ft7 = this.d;
            if (ft7 != null) {
                ft7.D1();
                this.d.H1(true);
                this.d = null;
            }
            VideoEditTextureView videoEditTextureView = this.g;
            if (videoEditTextureView != null) {
                videoEditTextureView.clearAnimation();
                this.g.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: ir.nasim.hq5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.B();
                    }
                }).start();
            }
            AbstractC21455b.t(this.n);
            if (runnable != null) {
                AbstractC21455b.m1(runnable);
                return;
            }
            return;
        }
        FT7 ft72 = this.d;
        if (ft72 != null) {
            ft72.H1(true);
            this.d = null;
        }
        FT7 ft73 = new FT7();
        this.d = ft73;
        ft73.K1(new b(lVar, new Runnable[]{runnable}));
        VideoEditTextureView videoEditTextureView2 = this.g;
        if (videoEditTextureView2 != null) {
            videoEditTextureView2.clearAnimation();
            this.g.f();
            removeView(this.g);
            this.g = null;
        }
        VideoEditTextureView videoEditTextureView3 = new VideoEditTextureView(getContext(), this.d);
        this.g = videoEditTextureView3;
        videoEditTextureView3.setAlpha(runnable != null ? 1.0f : 0.0f);
        this.g.setOpaque(false);
        t();
        addView(this.g, AbstractC13840gu3.d(-2, -2, 51));
        lVar.q(new Utilities.b() { // from class: ir.nasim.iq5
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.C((l.b) obj);
            }
        });
        Uri uriFromFile = Uri.fromFile(lVar.u());
        this.d.F1(uriFromFile, "other");
        this.d.N1(this.Z0.isEmpty());
        this.d.L1(true);
        if (j > 0) {
            this.d.I1(j);
        }
        this.i.setVideoPath(uriFromFile.toString(), lVar.u, lVar.v);
    }

    private boolean M(MotionEvent motionEvent) {
        Runnable runnable;
        if (motionEvent.getAction() == 0) {
            this.V0 = System.currentTimeMillis();
            this.W0 = motionEvent.getX();
            this.X0 = motionEvent.getY();
            return true;
        }
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() != 3) {
                return false;
            }
            this.V0 = 0L;
            return false;
        }
        if (System.currentTimeMillis() - this.V0 <= ViewConfiguration.getTapTimeout() && (runnable = this.Y0) != null) {
            runnable.run();
        }
        this.V0 = 0L;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean N(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 859
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView.N(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setupImage(final ir.nasim.tgwidgets.editor.ui.stories.recorder.l r12) throws java.lang.NumberFormatException {
        /*
            r11 = this;
            android.graphics.Bitmap r0 = r11.a
            r1 = 0
            if (r0 == 0) goto La
            r0.recycle()
            r11.a = r1
        La:
            android.graphics.Bitmap r0 = r11.b
            if (r0 == 0) goto L13
            r0.recycle()
            r11.b = r1
        L13:
            if (r12 == 0) goto Lcd
            int r0 = r11.getMeasuredWidth()
            if (r0 > 0) goto L20
            android.graphics.Point r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.h
            int r0 = r0.x
            goto L24
        L20:
            int r0 = r11.getMeasuredWidth()
        L24:
            int r2 = r0 * 16
            float r2 = (float) r2
            r3 = 1091567616(0x41100000, float:9.0)
            float r2 = r2 / r3
            int r2 = (int) r2
            boolean r3 = r12.p
            if (r3 == 0) goto L81
            android.graphics.Bitmap r3 = r12.H
            if (r3 == 0) goto L35
            r11.a = r3
        L35:
            android.graphics.Bitmap r3 = r11.a
            if (r3 != 0) goto L81
            java.lang.String r3 = r12.s
            if (r3 == 0) goto L81
            java.lang.String r4 = "vthumb://"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L81
            java.lang.String r3 = r12.s
            r4 = 9
            java.lang.String r3 = r3.substring(r4)
            long r3 = java.lang.Long.parseLong(r3)
            android.graphics.Bitmap r5 = r11.a
            if (r5 != 0) goto L7f
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r5 < r6) goto L7f
            boolean r5 = r12.p     // Catch: java.lang.Exception -> L7f
            if (r5 == 0) goto L66
            android.net.Uri r5 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L7f
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r5, r3)     // Catch: java.lang.Exception -> L7f
            goto L6c
        L66:
            android.net.Uri r5 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L7f
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r5, r3)     // Catch: java.lang.Exception -> L7f
        L6c:
            android.content.Context r6 = r11.getContext()     // Catch: java.lang.Exception -> L7f
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Exception -> L7f
            android.util.Size r7 = new android.util.Size     // Catch: java.lang.Exception -> L7f
            r7.<init>(r0, r2)     // Catch: java.lang.Exception -> L7f
            android.graphics.Bitmap r1 = ir.nasim.AbstractC10578bq5.a(r6, r5, r7, r1)     // Catch: java.lang.Exception -> L7f
            r11.a = r1     // Catch: java.lang.Exception -> L7f
        L7f:
            r8 = r3
            goto L84
        L81:
            r3 = -1
            goto L7f
        L84:
            r3 = 0
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 >= 0) goto L96
            boolean r1 = r12.p
            if (r1 == 0) goto L96
            java.lang.String r1 = r12.s
            if (r1 != 0) goto L96
            r11.invalidate()
            return
        L96:
            android.graphics.Bitmap r1 = r11.a
            if (r1 != 0) goto Lb2
            java.io.File r1 = r12.u()
            java.lang.String r10 = r1.getPath()
            ir.nasim.gq5 r1 = new ir.nasim.gq5
            r5 = r1
            r6 = r11
            r7 = r12
            r5.<init>()
            r12 = 0
            android.graphics.Bitmap r12 = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.v(r1, r0, r2, r12)
            r11.a = r12
            return
        Lb2:
            boolean r0 = r12.j
            if (r0 != 0) goto Lcd
            boolean r0 = r12.p
            if (r0 == 0) goto Lcd
            if (r1 == 0) goto Lcd
            int r0 = r1.getWidth()
            r12.b = r0
            android.graphics.Bitmap r0 = r11.a
            int r0 = r0.getHeight()
            r12.c = r0
            r12.K()
        Lcd:
            r11.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.PreviewView.setupImage(ir.nasim.tgwidgets.editor.ui.stories.recorder.l):void");
    }

    private void v(Matrix matrix) {
        if (this.c == null) {
            return;
        }
        float[] fArr = this.s;
        fArr[0] = r0.b / 2.0f;
        fArr[1] = r0.c / 2.0f;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.s;
        this.t = fArr2[0];
        this.u = fArr2[1];
        l lVar = this.c;
        fArr2[0] = lVar.b;
        fArr2[1] = lVar.c / 2.0f;
        matrix.mapPoints(fArr2);
        float[] fArr3 = this.s;
        this.v = (float) Math.toDegrees(Math.atan2(fArr3[1] - this.u, fArr3[0] - this.t));
        float f = this.t;
        float f2 = this.u;
        float[] fArr4 = this.s;
        this.w = AbstractC23776xV3.a(f, f2, fArr4[0], fArr4[1]) * 2.0f;
        float[] fArr5 = this.s;
        l lVar2 = this.c;
        fArr5[0] = lVar2.b / 2.0f;
        fArr5[1] = lVar2.c;
        matrix.mapPoints(fArr5);
        float f3 = this.t;
        float f4 = this.u;
        float[] fArr6 = this.s;
        this.x = AbstractC23776xV3.a(f3, f4, fArr6[0], fArr6[1]) * 2.0f;
    }

    private AbstractC11436d03 w(float f, float f2) {
        for (int size = this.c.C.size() - 1; size >= 0; size--) {
            AbstractC11436d03 abstractC11436d03 = (AbstractC11436d03) this.c.C.get(size);
            this.U0[0] = (f / getWidth()) * this.c.z;
            this.U0[1] = (f2 / getHeight()) * this.c.A;
            if (this.T0 == null) {
                this.T0 = new Matrix();
            }
            abstractC11436d03.d.invert(this.T0);
            this.T0.mapPoints(this.U0);
            float[] fArr = this.U0;
            float f3 = fArr[0];
            if (f3 >= 0.0f && f3 <= abstractC11436d03.b) {
                float f4 = fArr[1];
                if (f4 >= 0.0f && f4 <= abstractC11436d03.c) {
                    return abstractC11436d03;
                }
            }
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        if (this.d == null) {
            return;
        }
        float fS1 = r0.s1() / getDuration();
        if (!this.i.k()) {
            l lVar = this.c;
            if ((fS1 < lVar.u || fS1 > lVar.v) && System.currentTimeMillis() - this.m > 500) {
                this.m = System.currentTimeMillis();
                this.d.I1((long) (this.c.u * getDuration()));
            }
        }
        this.i.setProgress(Utilities.c(fS1, this.i.getRightProgress(), this.i.getLeftProgress()));
        if (this.d.A1()) {
            AbstractC21455b.t(this.n);
            AbstractC21455b.n1(this.n, (long) (1000.0f / AbstractC21455b.i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(int i, int[] iArr) {
        l lVar = this.c;
        lVar.D = iArr[0];
        lVar.E = iArr[1];
        this.q.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i, iArr, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i, int[] iArr) {
        l lVar = this.c;
        lVar.D = iArr[0];
        lVar.E = iArr[1];
        this.q.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, i, iArr, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        invalidate();
    }

    public void D(boolean z) {
        FT7 ft7 = this.d;
        if (ft7 == null) {
            return;
        }
        ft7.M1(z);
    }

    public void E(boolean z) {
    }

    public void G(boolean z) {
    }

    public void H(boolean z) {
    }

    public void I(boolean z) {
    }

    protected void J(boolean z, long j, boolean z2) {
    }

    public void O(int i, boolean z) {
        if (z) {
            this.Z0.add(Integer.valueOf(i));
        } else {
            this.Z0.remove(Integer.valueOf(i));
        }
        FT7 ft7 = this.d;
        if (ft7 != null) {
            ft7.N1(this.Z0.isEmpty());
        }
    }

    public void P(Runnable runnable) {
        this.o = runnable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.q);
        if (this.y && this.c != null) {
            float fE = this.z.e(this.a != null);
            if (this.b != null && 1.0f - fE > 0.0f) {
                this.r.set(this.c.d);
                this.r.preScale(this.c.b / this.b.getWidth(), this.c.c / this.b.getHeight());
                this.r.postScale(getWidth() / this.c.z, getHeight() / this.c.A);
                this.p.setAlpha(255);
                canvas.drawBitmap(this.b, this.r, this.p);
            }
            if (this.a != null) {
                this.r.set(this.c.d);
                this.r.preScale(this.c.b / this.a.getWidth(), this.c.c / this.a.getHeight());
                this.r.postScale(getWidth() / this.c.z, getHeight() / this.c.A);
                this.p.setAlpha((int) (fE * 255.0f));
                canvas.drawBitmap(this.a, this.r, this.p);
            }
        }
        super.dispatchDraw(canvas);
        if (!this.y || this.c == null) {
            return;
        }
        float fE2 = this.Q0.e(!this.P0);
        for (int i = 0; i < this.c.C.size(); i++) {
            l.c cVar = (l.c) this.c.C.get(i);
            if (cVar != null && (bitmap = (Bitmap) this.k.get(Integer.valueOf(cVar.a))) != null) {
                C5713Kn0 c5713Kn0 = (C5713Kn0) this.l.get(Integer.valueOf(cVar.a));
                float fE3 = c5713Kn0 != null ? c5713Kn0.e(0.05f) : 1.0f;
                this.r.set(cVar.d);
                canvas.save();
                if (fE3 != 1.0f) {
                    float[] fArr = this.U0;
                    fArr[0] = cVar.b / 2.0f;
                    fArr[1] = cVar.c / 2.0f;
                    this.r.mapPoints(fArr);
                    canvas.scale(fE3, fE3, (this.U0[0] / this.c.z) * getWidth(), (this.U0[1] / this.c.A) * getHeight());
                }
                if (this.O0 == cVar.a) {
                    float fT0 = AbstractC21455b.T0(0.2f, 1.0f, fE2);
                    canvas.scale(fT0, fT0, this.R0, this.S0);
                }
                this.r.preScale(cVar.b / bitmap.getWidth(), cVar.c / bitmap.getHeight());
                this.r.postScale(getWidth() / this.c.z, getHeight() / this.c.A);
                canvas.drawBitmap(bitmap, this.r, this.p);
                canvas.restore();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zN = N(motionEvent);
        if (!(this.I0 instanceof l.c)) {
            zN = s(motionEvent) || zN;
            M(motionEvent);
        }
        if (!zN) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public long getDuration() {
        l lVar = this.c;
        if (lVar != null) {
            double d = lVar.m;
            if (d >= 0.0d) {
                return (long) (d * 1000.0d);
            }
        }
        FT7 ft7 = this.d;
        if (ft7 != null) {
            return ft7.u1();
        }
        return 0L;
    }

    public int getOrientation() {
        l lVar = this.c;
        if (lVar == null) {
            return 0;
        }
        return lVar.w;
    }

    public Pair<Integer, Integer> getPaintSize() {
        return this.c == null ? new Pair<>(1080, 1920) : new Pair<>(Integer.valueOf(this.c.z), Integer.valueOf(this.c.A));
    }

    public Bitmap getPhotoBitmap() {
        return this.a;
    }

    public VideoEditTextureView getTextureView() {
        return this.g;
    }

    public VideoTimelinePlayView getTimelineView() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.A) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        N(motionEvent);
        return true;
    }

    public boolean s(MotionEvent motionEvent) {
        return false;
    }

    public void set(l lVar) {
        set(lVar, null, 0L);
    }

    public void setAllowCropping(boolean z) {
        this.A = z;
    }

    public void setDraw(boolean z) {
        this.y = z;
        invalidate();
    }

    public void setFilterTextureView(TextureView textureView) {
        TextureView textureView2 = this.h;
        if (textureView2 != null) {
            removeView(textureView2);
            this.h = null;
        }
        this.h = textureView;
        if (textureView != null) {
            addView(textureView);
        }
    }

    public void setOnTapListener(Runnable runnable) {
        this.Y0 = runnable;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            set(null);
        }
    }

    public void setupParts(l lVar) {
        if (lVar == null) {
            for (Bitmap bitmap : this.k.values()) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            this.k.clear();
            this.l.clear();
            return;
        }
        int measuredWidth = getMeasuredWidth() <= 0 ? AbstractC21455b.h.x : getMeasuredWidth();
        int i = (int) ((measuredWidth * 16) / 9.0f);
        for (int i2 = 0; i2 < lVar.C.size(); i2++) {
            l.c cVar = (l.c) lVar.C.get(i2);
            if (cVar != null && ((Bitmap) this.k.get(Integer.valueOf(cVar.a))) == null) {
                String path = cVar.f.getPath();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(path, options);
                options.inJustDecodeBounds = false;
                options.inSampleSize = l.k(options, measuredWidth, i);
                this.k.put(Integer.valueOf(cVar.a), BitmapFactory.decodeFile(path, options));
            }
        }
        Iterator it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int i3 = 0;
            while (true) {
                if (i3 >= lVar.C.size()) {
                    it.remove();
                    this.l.remove(entry.getKey());
                    break;
                } else if (((l.c) lVar.C.get(i3)).a == ((Integer) entry.getKey()).intValue()) {
                    break;
                } else {
                    i3++;
                }
            }
        }
    }

    public void t() {
        l lVar = this.c;
        if (lVar == null) {
            return;
        }
        if (this.g != null) {
            this.r.set(lVar.d);
            Matrix matrix = this.r;
            float width = 1.0f / getWidth();
            int i = this.c.b;
            if (i < 0) {
                i = this.e;
            }
            float f = width * i;
            float height = 1.0f / getHeight();
            int i2 = this.c.c;
            if (i2 < 0) {
                i2 = this.f;
            }
            matrix.preScale(f, height * i2);
            this.r.postScale(getWidth() / this.c.z, getHeight() / this.c.A);
            this.g.setTransform(this.r);
            this.g.invalidate();
        }
        invalidate();
    }

    public void u() {
        AbstractC11436d03 abstractC11436d03 = this.I0;
        if (abstractC11436d03 != null) {
            this.c.C.remove(abstractC11436d03);
            setupParts(this.c);
        }
    }

    public void set(l lVar, Runnable runnable, long j) {
        this.c = lVar;
        if (lVar == null) {
            L(null, runnable, j);
            setupImage(null);
            setupParts(null);
            this.q.setShader(null);
            return;
        }
        if (lVar.p) {
            setupImage(lVar);
            L(lVar, runnable, j);
            if (lVar.D == 0 && lVar.E == 0) {
                lVar.J(new Runnable() { // from class: ir.nasim.dq5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.K();
                    }
                });
            } else {
                K();
            }
        } else {
            L(null, runnable, 0L);
            setupImage(lVar);
            K();
        }
        setupParts(lVar);
        t();
    }

    public void F(AbstractC11436d03 abstractC11436d03) {
    }
}
