package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.C9151Ys;
import ir.nasim.G37;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView;

/* loaded from: classes7.dex */
public class PaintWeightChooserView extends View {
    private Paint a;
    private Paint b;
    private Path c;
    private GestureDetectorCompat d;
    private RectF e;
    private boolean f;
    private boolean g;
    private float h;
    private float i;
    private long j;
    private boolean k;
    private C9151Ys l;
    private C9151Ys m;
    private C9151Ys n;
    private RenderView o;
    private float p;
    private float q;
    private G37 r;
    private Runnable s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private b y;

    class a extends GestureDetector.SimpleOnGestureListener {
        float a;
        boolean b;
        float c;

        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            boolean zContains = PaintWeightChooserView.this.e.contains(motionEvent.getX(), motionEvent.getY());
            if (PaintWeightChooserView.this.f != zContains) {
                PaintWeightChooserView.this.f = zContains;
                PaintWeightChooserView.this.invalidate();
                if (zContains) {
                    this.a = PaintWeightChooserView.this.y != null ? PaintWeightChooserView.this.y.get() : PaintWeightChooserView.this.r.c;
                    this.b = false;
                }
            }
            return PaintWeightChooserView.this.f;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (PaintWeightChooserView.this.f) {
                if (!this.b) {
                    this.c = motionEvent.getY() - motionEvent2.getY();
                    this.b = true;
                }
                float fA = AbstractC22000uV3.a(this.a + ((((motionEvent.getY() - motionEvent2.getY()) - this.c) / PaintWeightChooserView.this.e.height()) * (PaintWeightChooserView.this.q - PaintWeightChooserView.this.p)), PaintWeightChooserView.this.p, PaintWeightChooserView.this.q);
                if (PaintWeightChooserView.this.y != null) {
                    PaintWeightChooserView.this.y.a(fA);
                } else {
                    PaintWeightChooserView.this.r.c = fA;
                }
                PaintWeightChooserView.this.l.d(fA, true);
                PaintWeightChooserView.this.s.run();
                PaintWeightChooserView.this.invalidate();
            }
            return PaintWeightChooserView.this.f;
        }
    }

    public interface b {
        void a(float f);

        float get();
    }

    public PaintWeightChooserView(Context context) {
        super(context);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = new Path();
        this.e = new RectF();
        this.k = true;
        this.l = new C9151Ys(this);
        this.m = new C9151Ys(this);
        this.n = new C9151Ys(this);
        this.r = new G37(-1, 1.0f, 0.016773745f);
        this.t = true;
        this.d = new GestureDetectorCompat(context, new a());
        this.b.setColor(-1);
        this.b.setShadowLayer(AbstractC21455b.F(4.0f), 0.0f, AbstractC21455b.F(2.0f), 1342177280);
        this.a.setColor(1090519039);
        this.a.setShadowLayer(AbstractC21455b.F(3.0f), 0.0f, AbstractC21455b.F(1.0f), 637534208);
    }

    private void j(Canvas canvas, float f, float f2, float f3, boolean z) {
        if (z) {
            RectF rectF = AbstractC21455b.x;
            rectF.set((f - f3) - AbstractC21455b.F(6.0f), (f2 - f3) - AbstractC21455b.F(6.0f), f + f3 + AbstractC21455b.F(6.0f), f2 + f3 + AbstractC21455b.F(6.0f));
            canvas.saveLayerAlpha(rectF, (int) (this.i * 255.0f), 31);
        }
        canvas.drawCircle(f, f2, f3, this.b);
        if (z) {
            canvas.restore();
        }
    }

    public void k(int i, int i2) {
        this.u = true;
        this.v = i;
        this.w = i2;
        invalidate();
    }

    public void l() {
        this.u = false;
        invalidate();
    }

    public void m(float f, float f2) {
        if (this.u) {
            if (this.v < this.w) {
                f2 = 1.0f - f2;
            }
            this.x = f2;
            setTranslationY(f);
            int iU0 = (int) (AbstractC21455b.U0(this.v, this.w, this.x) * 0.3f);
            this.e.set(0.0f, (r5 - iU0) / 2.0f, AbstractC21455b.F(32.0f), (r5 + iU0) / 2.0f);
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.PaintWeightChooserView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.u) {
            return;
        }
        int height = (int) (getHeight() * 0.3f);
        this.e.set(0.0f, (getHeight() - height) / 2.0f, AbstractC21455b.F(32.0f), (getHeight() + height) / 2.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zA = this.d.a(motionEvent);
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            this.f = false;
            invalidate();
        }
        return zA;
    }

    public void setColorSwatch(G37 g37) {
        this.r = g37;
        invalidate();
    }

    public void setDrawCenter(boolean z) {
        this.t = z;
        invalidate();
    }

    public void setMinMax(float f, float f2) {
        this.p = f;
        this.q = f2;
        invalidate();
    }

    public void setOnUpdate(Runnable runnable) {
        this.s = runnable;
    }

    public void setRenderView(RenderView renderView) {
        this.o = renderView;
    }

    public void setShowPreview(boolean z) {
        this.k = z;
        invalidate();
    }

    public void setValueOverride(b bVar) {
        this.y = bVar;
        invalidate();
    }

    public void setViewHidden(boolean z) {
        this.g = z;
        invalidate();
    }
}
