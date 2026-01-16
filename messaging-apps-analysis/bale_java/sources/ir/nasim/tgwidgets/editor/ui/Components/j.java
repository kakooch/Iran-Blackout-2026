package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.HU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class j implements E.d {
    public static c w;
    boolean a;
    Bitmap b;
    Canvas c;
    Bitmap d;
    Canvas e;
    private boolean f;
    private int h;
    protected boolean i;
    int k;
    int l;
    int m;
    int n;
    private final HU1 o;
    boolean p;
    boolean r;
    private boolean t;
    private int u;
    public final int v;
    private int g = 1;
    private Paint j = new Paint(1);
    private final Runnable q = new a();
    Runnable s = new b();

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[Catch: Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x0015, B:15:0x0042, B:11:0x0020, B:13:0x0026, B:14:0x0029), top: B:20:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r4 = this;
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                int r1 = r0.l     // Catch: java.lang.Exception -> L1e
                int r2 = r0.n     // Catch: java.lang.Exception -> L1e
                int r1 = r1 + r2
                android.graphics.Bitmap r0 = r0.b     // Catch: java.lang.Exception -> L1e
                if (r0 == 0) goto L20
                int r0 = r0.getWidth()     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r2 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                int r3 = r2.m     // Catch: java.lang.Exception -> L1e
                if (r0 != r3) goto L20
                android.graphics.Bitmap r0 = r2.b     // Catch: java.lang.Exception -> L1e
                int r0 = r0.getHeight()     // Catch: java.lang.Exception -> L1e
                if (r0 == r1) goto L42
                goto L20
            L1e:
                r0 = move-exception
                goto L6b
            L20:
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Bitmap r0 = r0.b     // Catch: java.lang.Exception -> L1e
                if (r0 == 0) goto L29
                r0.recycle()     // Catch: java.lang.Exception -> L1e
            L29:
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                int r2 = r0.m     // Catch: java.lang.Exception -> L1e
                android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Exception -> L1e
                android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r1, r3)     // Catch: java.lang.Exception -> L1e
                r0.b = r1     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Canvas r1 = new android.graphics.Canvas     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r2 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Bitmap r2 = r2.b     // Catch: java.lang.Exception -> L1e
                r1.<init>(r2)     // Catch: java.lang.Exception -> L1e
                r0.c = r1     // Catch: java.lang.Exception -> L1e
            L42:
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Bitmap r0 = r0.b     // Catch: java.lang.Exception -> L1e
                r1 = 0
                r0.eraseColor(r1)     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Canvas r0 = r0.c     // Catch: java.lang.Exception -> L1e
                r0.save()     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Canvas r1 = r0.c     // Catch: java.lang.Exception -> L1e
                int r0 = r0.n     // Catch: java.lang.Exception -> L1e
                float r0 = (float) r0     // Catch: java.lang.Exception -> L1e
                r2 = 0
                r1.translate(r2, r0)     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Canvas r1 = r0.c     // Catch: java.lang.Exception -> L1e
                r0.f(r1)     // Catch: java.lang.Exception -> L1e
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this     // Catch: java.lang.Exception -> L1e
                android.graphics.Canvas r0 = r0.c     // Catch: java.lang.Exception -> L1e
                r0.restore()     // Catch: java.lang.Exception -> L1e
                goto L73
            L6b:
                ir.nasim.AbstractC6403Nl2.d(r0)
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this
                r1 = 1
                r0.p = r1
            L73:
                ir.nasim.tgwidgets.editor.ui.Components.j r0 = ir.nasim.tgwidgets.editor.ui.Components.j.this
                java.lang.Runnable r0 = r0.s
                ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.m1(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.j.a.run():void");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f = false;
            j.this.j();
            j jVar = j.this;
            if (!jVar.a) {
                jVar.n();
            } else {
                if (jVar.k != jVar.u) {
                    return;
                }
                j.this.r = true;
            }
        }
    }

    public static class c {
        final int a;
        int b;
        public final HU1[] c;

        public HU1 a() {
            int i = this.b + 1;
            this.b = i;
            if (i > this.a - 1) {
                this.b = 0;
            }
            HU1[] hu1Arr = this.c;
            int i2 = this.b;
            HU1 hu1 = hu1Arr[i2];
            if (hu1 != null) {
                return hu1;
            }
            HU1 hu12 = new HU1("draw_background_queue_" + this.b);
            hu1Arr[i2] = hu12;
            return hu12;
        }

        private c(int i) {
            this.a = i;
            this.c = new HU1[i];
        }
    }

    public j() {
        if (w == null) {
            w = new c(2);
        }
        this.o = w.a();
        this.v = w.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList arrayList = new ArrayList();
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            arrayList.add(bitmap);
        }
        Bitmap bitmap2 = this.b;
        if (bitmap2 != null) {
            arrayList.add(bitmap2);
        }
        this.d = null;
        this.b = null;
        this.c = null;
        this.e = null;
        AbstractC21455b.h1(arrayList);
    }

    public void d(Canvas canvas, long j, int i, int i2, float f) {
        if (this.p) {
            if (AbstractC8814Xl0.c) {
                canvas.drawRect(0.0f, 0.0f, i, i2, ir.nasim.tgwidgets.editor.ui.ActionBar.m.ei);
                return;
            }
            return;
        }
        this.l = i2;
        this.m = i;
        if (this.r) {
            this.r = false;
            Bitmap bitmap = this.d;
            Canvas canvas2 = this.e;
            this.d = this.b;
            this.e = this.c;
            this.b = bitmap;
            this.c = canvas2;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null || this.t) {
            this.t = false;
            if (bitmap2 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.d);
                AbstractC21455b.h1(arrayList);
                this.d = null;
            }
            int i3 = this.l + this.n;
            Bitmap bitmap3 = this.d;
            if (bitmap3 != null && bitmap3.getHeight() == i3 && this.d.getWidth() == this.m) {
                this.d.eraseColor(0);
            } else {
                this.d = Bitmap.createBitmap(this.m, i3, Bitmap.Config.ARGB_8888);
                this.e = new Canvas(this.d);
            }
            this.e.save();
            this.e.translate(0.0f, this.n);
            g(this.e, f);
            this.e.restore();
        }
        if (!this.f && !this.i) {
            this.f = true;
            m(j);
            this.u = this.k;
            this.o.i(this.q);
        }
        Bitmap bitmap4 = this.d;
        if (bitmap4 != null) {
            this.j.setAlpha((int) (f * 255.0f));
            canvas.save();
            canvas.translate(0.0f, -this.n);
            e(canvas, bitmap4, this.j);
            canvas.restore();
        }
    }

    protected void e(Canvas canvas, Bitmap bitmap, Paint paint) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
    }

    public abstract void f(Canvas canvas);

    protected abstract void g(Canvas canvas, float f);

    public void h() {
        if (this.a) {
            return;
        }
        this.a = true;
        this.p = false;
        int i = ir.nasim.tgwidgets.editor.messenger.E.j().i() & (~this.g);
        this.h = i;
        if (i == 0 && this.i) {
            this.i = false;
            l();
        }
        ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.d1);
        ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.e1);
    }

    public void i() {
        if (this.a) {
            if (!this.f) {
                n();
            }
            this.a = false;
            ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.d1);
            ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.e1);
        }
    }

    public abstract void j();

    public void k() {
    }

    public abstract void l();

    public abstract void m(long j);

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        int i3;
        if (i == ir.nasim.tgwidgets.editor.messenger.E.d1) {
            Integer num = (Integer) objArr[0];
            if (this.g < num.intValue()) {
                if (num.intValue() != 512 || AbstractC8662Wx6.h() < 2) {
                    int iIntValue = num.intValue() | this.h;
                    this.h = iIntValue;
                    if (iIntValue == 0 || this.i) {
                        return;
                    }
                    this.i = true;
                    k();
                    return;
                }
                return;
            }
            return;
        }
        if (i == ir.nasim.tgwidgets.editor.messenger.E.e1) {
            Integer num2 = (Integer) objArr[0];
            if (this.g >= num2.intValue() || (i3 = this.h) == 0) {
                return;
            }
            int i4 = (~num2.intValue()) & i3;
            this.h = i4;
            if (i4 == 0 && this.i) {
                this.i = false;
                l();
            }
        }
    }
}
