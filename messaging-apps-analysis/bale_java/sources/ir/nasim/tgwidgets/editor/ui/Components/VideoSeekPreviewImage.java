package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.A77;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C4278El2;
import ir.nasim.G77;
import ir.nasim.HU1;
import ir.nasim.N77;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21456c;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.File;

/* loaded from: classes7.dex */
public class VideoSeekPreviewImage extends View {
    private int A;
    private int B;
    private int D;
    private int G;
    private Path H;
    private AnimatedFileDrawable a;
    private long b;
    private Uri c;
    private Runnable d;
    private Runnable e;
    private float f;
    private int g;
    private int h;
    private boolean i;
    private Bitmap j;
    private Bitmap k;
    private Drawable l;
    private String m;
    private int n;
    private TextPaint o;
    private BitmapShader p;
    private RectF q;
    private Paint r;
    private Paint s;
    private RectF t;
    private Matrix u;
    private a v;
    private PhotoViewerWebView w;
    private int x;
    private boolean y;
    private ImageReceiver z;

    public interface a {
        void a();
    }

    public VideoSeekPreviewImage(Context context, a aVar) {
        super(context);
        this.g = -1;
        this.o = new TextPaint(1);
        this.q = new RectF();
        this.r = new Paint(2);
        this.s = new Paint(2);
        this.t = new RectF();
        this.u = new Matrix();
        this.H = new Path();
        setVisibility(4);
        this.l = context.getResources().getDrawable(AbstractC23598xB5.videopreview);
        this.o.setTextSize(AbstractC21455b.F(13.0f));
        this.o.setColor(-1);
        this.v = aVar;
        ImageReceiver imageReceiver = new ImageReceiver();
        this.z = imageReceiver;
        imageReceiver.j1(this);
        this.z.H0(new ImageReceiver.c() { // from class: ir.nasim.aV7
            @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver.c
            public final void a(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                this.a.j(imageReceiver2, z, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() throws InterruptedException {
        this.f = 0.0f;
        AnimatedFileDrawable animatedFileDrawable = this.a;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.O0();
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        int i;
        if (!z || this.w == null) {
            return;
        }
        int iF = AbstractC21455b.F(150.0f);
        int iC = this.w.C(this.x);
        float fO = this.z.o() / Math.min(iC, 5);
        float fM = this.z.m() / ((int) Math.ceil(iC / 5.0f));
        int iMin = Math.min(this.w.D(this.x), iC - 1);
        this.A = (int) ((iMin % 5) * fO);
        this.B = (int) ((iMin / 5) * fM);
        this.D = (int) fO;
        this.G = (int) fM;
        float f = fO / fM;
        if (f > 1.0f) {
            i = (int) (iF / f);
        } else {
            i = iF;
            iF = (int) (iF * f);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getVisibility() == 0 && layoutParams.width == iF && layoutParams.height == i) {
            return;
        }
        layoutParams.width = iF;
        layoutParams.height = i;
        setVisibility(0);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.d = null;
        if (this.a != null) {
            this.i = true;
            this.v.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Uri uri) {
        String absolutePath;
        if ("tg".equals(uri.getScheme())) {
            int iIntValue = Utilities.h(uri.getQueryParameter("account")).intValue();
            Object objL = C4278El2.H(iIntValue).L(Utilities.h(uri.getQueryParameter(DialogEntity.COLUMN_RID)).intValue());
            A77 a77 = new A77();
            a77.d = Utilities.i(uri.getQueryParameter("hash")).longValue();
            a77.c = Utilities.i(uri.getQueryParameter("id")).longValue();
            a77.j = Utilities.i(uri.getQueryParameter("size")).longValue();
            a77.m = Utilities.h(uri.getQueryParameter("dc")).intValue();
            a77.i = uri.getQueryParameter("mime");
            a77.e = Utilities.g(uri.getQueryParameter("reference"));
            G77 g77 = new G77();
            g77.i = uri.getQueryParameter("name");
            a77.p.add(g77);
            a77.p.add(new N77());
            if (C4278El2.H(iIntValue).T(C4278El2.u(a77))) {
                absolutePath = new File(C4278El2.B(4), a77.m + "_" + a77.c + ".temp").getAbsolutePath();
            } else {
                absolutePath = C4278El2.H(iIntValue).Q(a77, false).getAbsolutePath();
            }
            this.a = new AnimatedFileDrawable(new File(absolutePath), true, a77.j, 1, a77, null, objL, 0L, iIntValue, true, null);
        } else {
            this.a = new AnimatedFileDrawable(new File(uri.getPath()), true, 0L, 0, null, null, null, 0L, 0, true, null);
        }
        this.b = this.a.x0();
        float f = this.f;
        if (f != 0.0f) {
            setProgress(f, this.h);
            this.f = 0.0f;
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.bV7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            if (this.k != null) {
                Bitmap bitmap2 = this.j;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.j = this.k;
            }
            this.k = bitmap;
            Bitmap bitmap3 = this.k;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap3, tileMode, tileMode);
            this.p = bitmapShader;
            bitmapShader.setLocalMatrix(this.u);
            this.s.setShader(this.p);
            invalidate();
            int iF = AbstractC21455b.F(150.0f);
            float width = bitmap.getWidth() / bitmap.getHeight();
            if (width > 1.0f) {
                i = (int) (iF / width);
            } else {
                iF = (int) (iF * width);
                i = iF;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (getVisibility() != 0 || layoutParams.width != iF || layoutParams.height != i) {
                layoutParams.width = iF;
                layoutParams.height = i;
                setVisibility(0);
                requestLayout();
            }
        }
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(float f, long j) {
        int i;
        if (this.a == null) {
            this.f = f;
            return;
        }
        int iMax = Math.max(200, AbstractC21455b.F(100.0f));
        final Bitmap bitmapZ0 = this.a.z0(j);
        if (bitmapZ0 != null) {
            int width = bitmapZ0.getWidth();
            int height = bitmapZ0.getHeight();
            if (width > height) {
                i = (int) (height / (width / iMax));
            } else {
                int i2 = (int) (width / (height / iMax));
                i = iMax;
                iMax = i2;
            }
            try {
                Bitmap bitmapA = AbstractC21456c.a(iMax, i, Bitmap.Config.ARGB_8888);
                this.q.set(0.0f, 0.0f, iMax, i);
                Canvas canvas = new Canvas(bitmapA);
                canvas.drawBitmap(bitmapZ0, (Rect) null, this.q, this.r);
                canvas.setBitmap(null);
                bitmapZ0 = bitmapA;
            } catch (Throwable unused) {
                bitmapZ0 = null;
            }
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.YU7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(bitmapZ0);
            }
        });
    }

    public void g() {
        if (this.d != null) {
            Utilities.e.b(this.d);
            this.d = null;
        }
        if (this.e != null) {
            Utilities.e.b(this.e);
            this.e = null;
        }
        AnimatedFileDrawable animatedFileDrawable = this.a;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.R0(true);
        }
        Utilities.e.i(new Runnable() { // from class: ir.nasim.WU7
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.i();
            }
        });
        setVisibility(4);
        this.k = null;
        this.p = null;
        invalidate();
        this.g = -1;
        this.c = null;
        this.i = false;
    }

    public boolean h() {
        return this.i;
    }

    public void o(final Uri uri) {
        if (uri == null || uri.equals(this.c)) {
            return;
        }
        this.c = uri;
        HU1 hu1 = Utilities.e;
        Runnable runnable = new Runnable() { // from class: ir.nasim.ZU7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(uri);
            }
        };
        this.d = runnable;
        hu1.i(runnable);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.z.q0();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.z.s0();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            bitmap.recycle();
            this.j = null;
        }
        if (this.k != null && this.p != null) {
            this.u.reset();
            float measuredWidth = getMeasuredWidth() / this.k.getWidth();
            this.u.preScale(measuredWidth, measuredWidth);
            this.t.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            canvas.drawRoundRect(this.t, AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), this.s);
            this.l.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.l.draw(canvas);
            canvas.drawText(this.m, (getMeasuredWidth() - this.n) / 2.0f, getMeasuredHeight() - AbstractC21455b.F(9.0f), this.o);
            return;
        }
        if (this.y) {
            canvas.save();
            this.H.rewind();
            RectF rectF = AbstractC21455b.x;
            rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            this.H.addRoundRect(rectF, AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), Path.Direction.CW);
            canvas.clipPath(this.H);
            canvas.scale(getWidth() / this.D, getHeight() / this.G);
            canvas.translate(-this.A, -this.B);
            this.z.Y0(0.0f, 0.0f, r0.o(), this.z.m());
            this.z.e(canvas);
            canvas.restore();
            this.l.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.l.draw(canvas);
            canvas.drawText(this.m, (getMeasuredWidth() - this.n) / 2.0f, getMeasuredHeight() - AbstractC21455b.F(9.0f), this.o);
        }
    }

    public void setProgress(final float f, int i) {
        this.w = null;
        this.y = false;
        this.z.W0(null);
        if (i != 0) {
            this.h = i;
            int i2 = ((int) (i * f)) / 5;
            if (this.g == i2) {
                return;
            } else {
                this.g = i2;
            }
        }
        final long j = (long) (this.b * f);
        this.m = AbstractC21455b.O((int) (j / 1000));
        this.n = (int) Math.ceil(this.o.measureText(r8));
        invalidate();
        if (this.e != null) {
            Utilities.e.b(this.e);
        }
        AnimatedFileDrawable animatedFileDrawable = this.a;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.R0(false);
        }
        HU1 hu1 = Utilities.e;
        Runnable runnable = new Runnable() { // from class: ir.nasim.XU7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(f, j);
            }
        };
        this.e = runnable;
        hu1.i(runnable);
    }

    public void setProgressForYouTube(PhotoViewerWebView photoViewerWebView, float f, int i) {
        this.w = photoViewerWebView;
        this.y = true;
        if (i != 0) {
            this.h = i;
            int i2 = ((int) (i * f)) / 5;
            if (this.g == i2) {
                return;
            } else {
                this.g = i2;
            }
        }
        this.m = AbstractC21455b.O((int) (((long) (photoViewerWebView.getVideoDuration() * f)) / 1000));
        this.n = (int) Math.ceil(this.o.measureText(r10));
        invalidate();
        if (this.e != null) {
            Utilities.e.b(this.e);
        }
        int videoDuration = (int) ((f * photoViewerWebView.getVideoDuration()) / 1000.0f);
        this.x = videoDuration;
        String strB = photoViewerWebView.B(videoDuration);
        if (strB != null) {
            this.z.U0(strB, null, null, null, 0L);
        }
    }
}
