package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;

/* loaded from: classes2.dex */
public class YG4 {
    private static final Matrix B = new Matrix();
    private C17470n12 A;
    private Canvas a;
    private a b;
    private b c;
    private RectF d;
    private RectF e;
    private Rect f;
    private RectF g;
    private RectF h;
    private Rect i;
    private RectF j;
    private Paint k;
    private Bitmap l;
    private Canvas m;
    private Rect n;
    private C7430Rr3 o;
    Matrix p;
    float[] q;
    private Bitmap r;
    private Bitmap s;
    private Canvas t;
    private Canvas u;
    private C7430Rr3 v;
    private BlurMaskFilter w;
    private float x = 0.0f;
    private RenderNode y;
    private RenderNode z;

    public static class a {
        public int a;
        public EnumC8503Wg0 b;
        public ColorFilter c;
        public C17470n12 d;

        public a() {
            f();
        }

        public boolean a() {
            EnumC8503Wg0 enumC8503Wg0 = this.b;
            return (enumC8503Wg0 == null || enumC8503Wg0 == EnumC8503Wg0.SRC_OVER) ? false : true;
        }

        public boolean b() {
            return this.c != null;
        }

        public boolean c() {
            return this.d != null;
        }

        public boolean d() {
            return (e() || a() || c() || b()) ? false : true;
        }

        public boolean e() {
            return this.a < 255;
        }

        public void f() {
            this.a = 255;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    protected enum b {
        DIRECT,
        SAVE_LAYER,
        BITMAP,
        RENDER_NODE
    }

    private Bitmap a(RectF rectF, Bitmap.Config config) {
        return Bitmap.createBitmap(Math.max((int) Math.ceil(rectF.width() * 1.05d), 1), Math.max((int) Math.ceil(rectF.height() * 1.05d), 1), config);
    }

    private RectF b(RectF rectF, C17470n12 c17470n12) {
        if (this.e == null) {
            this.e = new RectF();
        }
        if (this.g == null) {
            this.g = new RectF();
        }
        this.e.set(rectF);
        this.e.offsetTo(rectF.left + c17470n12.f(), rectF.top + c17470n12.g());
        this.e.inset(-c17470n12.h(), -c17470n12.h());
        this.g.set(rectF);
        this.e.union(this.g);
        return this.e;
    }

    private b c(Canvas canvas, a aVar) {
        if (aVar.d()) {
            return b.DIRECT;
        }
        if (!aVar.c()) {
            return b.SAVE_LAYER;
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 29 || !canvas.isHardwareAccelerated()) ? b.BITMAP : i <= 31 ? b.BITMAP : b.RENDER_NODE;
    }

    private void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    private boolean g(Bitmap bitmap, RectF rectF) {
        return bitmap == null || rectF.width() >= ((float) bitmap.getWidth()) || rectF.height() >= ((float) bitmap.getHeight()) || rectF.width() < ((float) bitmap.getWidth()) * 0.75f || rectF.height() < ((float) bitmap.getHeight()) * 0.75f;
    }

    private void h(Canvas canvas, C17470n12 c17470n12) {
        C7430Rr3 c7430Rr3;
        RectF rectF = this.d;
        if (rectF == null || this.l == null) {
            throw new IllegalStateException("Cannot render to bitmap outside a start()/finish() block");
        }
        RectF rectFB = b(rectF, c17470n12);
        if (this.f == null) {
            this.f = new Rect();
        }
        this.f.set((int) Math.floor(rectFB.left), (int) Math.floor(rectFB.top), (int) Math.ceil(rectFB.right), (int) Math.ceil(rectFB.bottom));
        float[] fArr = this.q;
        float f = fArr != null ? fArr[0] : 1.0f;
        float f2 = fArr != null ? fArr[4] : 1.0f;
        if (this.h == null) {
            this.h = new RectF();
        }
        this.h.set(rectFB.left * f, rectFB.top * f2, rectFB.right * f, rectFB.bottom * f2);
        if (this.i == null) {
            this.i = new Rect();
        }
        this.i.set(0, 0, Math.round(this.h.width()), Math.round(this.h.height()));
        if (g(this.r, this.h)) {
            Bitmap bitmap = this.r;
            if (bitmap != null) {
                d(bitmap);
            }
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                d(bitmap2);
            }
            this.r = a(this.h, Bitmap.Config.ARGB_8888);
            this.s = a(this.h, Bitmap.Config.ALPHA_8);
            this.t = new Canvas(this.r);
            this.u = new Canvas(this.s);
        } else {
            Canvas canvas2 = this.t;
            if (canvas2 == null || this.u == null || (c7430Rr3 = this.o) == null) {
                throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas and bitmap ready");
            }
            canvas2.drawRect(this.i, c7430Rr3);
            this.u.drawRect(this.i, this.o);
        }
        if (this.s == null) {
            throw new IllegalStateException("Expected to have allocated a shadow mask bitmap");
        }
        if (this.v == null) {
            this.v = new C7430Rr3(1);
        }
        RectF rectF2 = this.d;
        this.u.drawBitmap(this.l, Math.round((rectF2.left - rectFB.left) * f), Math.round((rectF2.top - rectFB.top) * f2), (Paint) null);
        if (this.w == null || this.x != c17470n12.h()) {
            float fH = (c17470n12.h() * (f + f2)) / 2.0f;
            if (fH > 0.0f) {
                this.w = new BlurMaskFilter(fH, BlurMaskFilter.Blur.NORMAL);
            } else {
                this.w = null;
            }
            this.x = c17470n12.h();
        }
        this.v.setColor(c17470n12.e());
        if (c17470n12.h() > 0.0f) {
            this.v.setMaskFilter(this.w);
        } else {
            this.v.setMaskFilter(null);
        }
        this.v.setFilterBitmap(true);
        this.t.drawBitmap(this.s, Math.round(c17470n12.f() * f), Math.round(c17470n12.g() * f2), this.v);
        canvas.drawBitmap(this.r, this.i, this.f, this.k);
    }

    private void i(Canvas canvas, C17470n12 c17470n12) {
        if (this.y == null || this.z == null) {
            throw new IllegalStateException("Cannot render to render node outside a start()/finish() block");
        }
        if (Build.VERSION.SDK_INT < 31) {
            throw new RuntimeException("RenderEffect is not supported on API level <31");
        }
        float[] fArr = this.q;
        float f = fArr != null ? fArr[0] : 1.0f;
        float f2 = fArr != null ? fArr[4] : 1.0f;
        C17470n12 c17470n122 = this.A;
        if (c17470n122 == null || !c17470n12.j(c17470n122)) {
            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new PorterDuffColorFilter(c17470n12.e(), PorterDuff.Mode.SRC_IN));
            if (c17470n12.h() > 0.0f) {
                float fH = (c17470n12.h() * (f + f2)) / 2.0f;
                renderEffectCreateColorFilterEffect = RenderEffect.createBlurEffect(fH, fH, renderEffectCreateColorFilterEffect, Shader.TileMode.CLAMP);
            }
            this.z.setRenderEffect(renderEffectCreateColorFilterEffect);
            this.A = c17470n12;
        }
        RectF rectFB = b(this.d, c17470n12);
        RectF rectF = new RectF(rectFB.left * f, rectFB.top * f2, rectFB.right * f, rectFB.bottom * f2);
        this.z.setPosition(0, 0, (int) rectF.width(), (int) rectF.height());
        RecordingCanvas recordingCanvasBeginRecording = this.z.beginRecording((int) rectF.width(), (int) rectF.height());
        recordingCanvasBeginRecording.translate((-rectF.left) + (c17470n12.f() * f), (-rectF.top) + (c17470n12.g() * f2));
        recordingCanvasBeginRecording.drawRenderNode(this.y);
        this.z.endRecording();
        canvas.save();
        canvas.translate(rectF.left, rectF.top);
        canvas.drawRenderNode(this.z);
        canvas.restore();
    }

    public void e() {
        if (this.a == null || this.b == null || this.q == null || this.d == null) {
            throw new IllegalStateException("OffscreenBitmap: finish() call without matching start()");
        }
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            this.a.restore();
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                if (this.y == null) {
                    throw new IllegalStateException("RenderNode is not ready; should've been initialized at start() time");
                }
                if (Build.VERSION.SDK_INT < 29) {
                    throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
                }
                this.a.save();
                Canvas canvas = this.a;
                float[] fArr = this.q;
                canvas.scale(1.0f / fArr[0], 1.0f / fArr[4]);
                this.y.endRecording();
                if (this.b.c()) {
                    i(this.a, this.b.d);
                }
                this.a.drawRenderNode(this.y);
                this.a.restore();
            }
        } else {
            if (this.l == null) {
                throw new IllegalStateException("Bitmap is not ready; should've been initialized at start() time");
            }
            if (this.b.c()) {
                h(this.a, this.b.d);
            }
            if (this.n == null) {
                this.n = new Rect();
            }
            this.n.set(0, 0, (int) (this.d.width() * this.q[0]), (int) (this.d.height() * this.q[4]));
            this.a.drawBitmap(this.l, this.n, this.d, this.k);
        }
        this.a = null;
    }

    public boolean f() {
        return this.c == b.RENDER_NODE;
    }

    public Canvas j(Canvas canvas, RectF rectF, a aVar) {
        if (this.a != null) {
            throw new IllegalStateException("Cannot nest start() calls on a single OffscreenBitmap - call finish() first");
        }
        if (this.q == null) {
            this.q = new float[9];
        }
        if (this.p == null) {
            this.p = new Matrix();
        }
        canvas.getMatrix(this.p);
        this.p.getValues(this.q);
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[4];
        if (this.j == null) {
            this.j = new RectF();
        }
        this.j.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
        this.a = canvas;
        this.b = aVar;
        this.c = c(canvas, aVar);
        if (this.d == null) {
            this.d = new RectF();
        }
        this.d.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.k == null) {
            this.k = new C7430Rr3();
        }
        this.k.reset();
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            canvas.save();
            return canvas;
        }
        if (iOrdinal == 1) {
            this.k.setAlpha(aVar.a);
            this.k.setColorFilter(aVar.c);
            if (aVar.a()) {
                AbstractC14178hU4.b(this.k, aVar.b);
            }
            AbstractC16500lN7.n(canvas, rectF, this.k);
            return canvas;
        }
        if (iOrdinal == 2) {
            if (this.o == null) {
                C7430Rr3 c7430Rr3 = new C7430Rr3();
                this.o = c7430Rr3;
                c7430Rr3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            if (g(this.l, this.j)) {
                Bitmap bitmap = this.l;
                if (bitmap != null) {
                    d(bitmap);
                }
                this.l = a(this.j, Bitmap.Config.ARGB_8888);
                this.m = new Canvas(this.l);
            } else {
                Canvas canvas2 = this.m;
                if (canvas2 == null) {
                    throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas ready");
                }
                canvas2.setMatrix(B);
                this.m.drawRect(-1.0f, -1.0f, this.j.width() + 1.0f, this.j.height() + 1.0f, this.o);
            }
            AbstractC14178hU4.b(this.k, aVar.b);
            this.k.setColorFilter(aVar.c);
            this.k.setAlpha(aVar.a);
            Canvas canvas3 = this.m;
            canvas3.scale(f, f2);
            canvas3.translate(-rectF.left, -rectF.top);
            return canvas3;
        }
        if (iOrdinal != 3) {
            throw new RuntimeException("Invalid render strategy for OffscreenLayer");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
        }
        if (this.y == null) {
            this.y = AbstractC23216wY6.a("OffscreenLayer.main");
        }
        if (aVar.c() && this.z == null) {
            this.z = AbstractC23216wY6.a("OffscreenLayer.shadow");
            this.A = null;
        }
        if (aVar.a() || aVar.b()) {
            if (this.k == null) {
                this.k = new C7430Rr3();
            }
            this.k.reset();
            AbstractC14178hU4.b(this.k, aVar.b);
            this.k.setColorFilter(aVar.c);
            this.y.setUseCompositingLayer(true, this.k);
            if (aVar.c()) {
                RenderNode renderNode = this.z;
                if (renderNode == null) {
                    throw new IllegalStateException("Must initialize shadowRenderNode when we have shadow");
                }
                renderNode.setUseCompositingLayer(true, this.k);
            }
        }
        this.y.setAlpha(aVar.a / 255.0f);
        if (aVar.c()) {
            RenderNode renderNode2 = this.z;
            if (renderNode2 == null) {
                throw new IllegalStateException("Must initialize shadowRenderNode when we have shadow");
            }
            renderNode2.setAlpha(aVar.a / 255.0f);
        }
        this.y.setHasOverlappingRendering(true);
        RenderNode renderNode3 = this.y;
        RectF rectF2 = this.j;
        renderNode3.setPosition((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
        RecordingCanvas recordingCanvasBeginRecording = this.y.beginRecording((int) this.j.width(), (int) this.j.height());
        recordingCanvasBeginRecording.setMatrix(B);
        recordingCanvasBeginRecording.scale(f, f2);
        recordingCanvasBeginRecording.translate(-rectF.left, -rectF.top);
        return recordingCanvasBeginRecording;
    }
}
