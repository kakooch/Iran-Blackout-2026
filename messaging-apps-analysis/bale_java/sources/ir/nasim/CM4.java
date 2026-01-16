package ir.nasim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.CX1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class CM4 extends PK5 implements CX1.a {
    private static Paint r = new Paint();
    private static Paint s = new Paint(1);
    private static TextPaint t = new TextPaint(1);
    private static TextPaint u = new TextPaint(1);
    private static TextPaint v = new TextPaint(1);
    private static TextPaint w = new TextPaint(1);
    private static TextPaint x = new TextPaint(1);
    private static TextPaint y = new TextPaint(1);
    private static DecelerateInterpolator z = new DecelerateInterpolator();
    private long a = 0;
    private float b = 0.0f;
    private float c = 0.0f;
    private long d = 0;
    private float e = 0.0f;
    private float f = 1.0f;
    private boolean g;
    private View h;
    private C10743c74 i;
    private int j;
    private boolean k;
    private boolean l;
    private Drawable m;
    private String n;
    private String o;
    private String p;
    private String q;

    static {
        s.setStrokeCap(Paint.Cap.ROUND);
        r.setColor(-14209998);
        t.setColor(-1);
        u.setColor(-1);
        v.setColor(-10327179);
        w.setColor(-10327179);
        x.setColor(-1);
        y.setColor(-1);
        t.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        u.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        w.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        x.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        y.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
    }

    public CM4(Context context, View view, C10743c74 c10743c74) {
        t.setTextSize(AbstractC21455b.F(14.0f));
        u.setTextSize(AbstractC21455b.F(19.0f));
        v.setTextSize(AbstractC21455b.F(15.0f));
        w.setTextSize(AbstractC21455b.F(15.0f));
        x.setTextSize(AbstractC21455b.F(15.0f));
        y.setTextSize(AbstractC21455b.F(15.0f));
        s.setStrokeWidth(AbstractC21455b.F(2.0f));
        this.h = view;
        this.i = c10743c74;
        this.j = CX1.e(c10743c74.N).c();
        AbstractC18106o57 abstractC18106o57I = c10743c74.I();
        if (abstractC18106o57I != null) {
            String strC = C4278El2.C(c10743c74.I());
            this.o = strC;
            if (TextUtils.isEmpty(strC)) {
                this.o = "name";
            }
            int iLastIndexOf = this.o.lastIndexOf(46);
            this.n = iLastIndexOf == -1 ? "" : this.o.substring(iLastIndexOf + 1).toUpperCase();
            if (((int) Math.ceil(t.measureText(r0))) > AbstractC21455b.F(40.0f)) {
                this.n = TextUtils.ellipsize(this.n, t, AbstractC21455b.F(40.0f), TextUtils.TruncateAt.END).toString();
            }
            this.m = context.getResources().getDrawable(AbstractC21455b.n0(this.o, c10743c74.I().i, true)).mutate();
            this.p = AbstractC21455b.M(abstractC18106o57I.j);
            if (((int) Math.ceil(u.measureText(this.o))) > AbstractC21455b.F(320.0f)) {
                this.o = TextUtils.ellipsize(this.o, u, AbstractC21455b.F(320.0f), TextUtils.TruncateAt.END).toString();
            }
        }
        b();
    }

    private void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.a;
        this.a = jCurrentTimeMillis;
        float f = this.e;
        if (f != 1.0f) {
            float f2 = this.b;
            if (f != f2) {
                float f3 = this.c;
                float f4 = f2 - f3;
                if (f4 > 0.0f) {
                    long j2 = this.d + j;
                    this.d = j2;
                    if (j2 >= 300) {
                        this.e = f2;
                        this.c = f2;
                        this.d = 0L;
                    } else {
                        this.e = f3 + (f4 * z.getInterpolation(j2 / 300.0f));
                    }
                }
                this.h.invalidate();
            }
        }
        float f5 = this.e;
        if (f5 < 1.0f || f5 != 1.0f) {
            return;
        }
        float f6 = this.f;
        if (f6 != 0.0f) {
            float f7 = f6 - (j / 200.0f);
            this.f = f7;
            if (f7 <= 0.0f) {
                this.f = 0.0f;
            }
            this.h.invalidate();
        }
    }

    @Override // ir.nasim.PK5
    public void a() {
        CX1.e(this.i.N).h(this);
        this.h = null;
        this.i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r5 = this;
            ir.nasim.c74 r0 = r5.i
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L92
            ir.nasim.L57 r0 = r0.e
            ir.nasim.Q57 r4 = r0.h
            if (r4 == 0) goto L92
            java.lang.String r0 = r0.M
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L26
            java.io.File r0 = new java.io.File
            ir.nasim.c74 r4 = r5.i
            ir.nasim.L57 r4 = r4.e
            java.lang.String r4 = r4.M
            r0.<init>(r4)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L45
        L26:
            int r0 = ir.nasim.C22477vI7.f
            ir.nasim.El2 r0 = ir.nasim.C4278El2.H(r0)
            ir.nasim.c74 r4 = r5.i
            ir.nasim.L57 r4 = r4.e
            java.io.File r0 = r0.R(r4)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L45
            ir.nasim.c74 r0 = r5.i
            ir.nasim.o57 r0 = r0.I()
            java.lang.String r0 = ir.nasim.C4278El2.u(r0)
            goto L46
        L45:
            r0 = 0
        L46:
            r5.l = r3
            if (r0 != 0) goto L5c
            r5.g = r3
            r5.k = r3
            r5.l = r2
            ir.nasim.c74 r0 = r5.i
            int r0 = r0.N
            ir.nasim.CX1 r0 = ir.nasim.CX1.e(r0)
            r0.h(r5)
            goto La6
        L5c:
            ir.nasim.c74 r4 = r5.i
            int r4 = r4.N
            ir.nasim.CX1 r4 = ir.nasim.CX1.e(r4)
            r4.a(r0, r5)
            ir.nasim.c74 r4 = r5.i
            int r4 = r4.N
            ir.nasim.El2 r4 = ir.nasim.C4278El2.H(r4)
            boolean r4 = r4.T(r0)
            r5.k = r4
            if (r4 == 0) goto L8f
            r5.g = r2
            ir.nasim.tgwidgets.editor.messenger.d r2 = ir.nasim.tgwidgets.editor.messenger.C21457d.g0()
            java.lang.Float r0 = r2.b0(r0)
            if (r0 != 0) goto L87
            java.lang.Float r0 = java.lang.Float.valueOf(r1)
        L87:
            float r0 = r0.floatValue()
            r5.c(r0, r3)
            goto La6
        L8f:
            r5.g = r3
            goto La6
        L92:
            r5.k = r3
            r5.l = r2
            r5.g = r3
            r5.c(r1, r3)
            ir.nasim.c74 r0 = r5.i
            int r0 = r0.N
            ir.nasim.CX1 r0 = ir.nasim.CX1.e(r0)
            r0.h(r5)
        La6:
            android.view.View r0 = r5.h
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CM4.b():void");
    }

    public void c(float f, boolean z2) {
        if (z2) {
            this.c = this.e;
        } else {
            this.e = f;
            this.c = f;
        }
        this.q = String.format("%d%%", Integer.valueOf((int) (100.0f * f)));
        if (f != 1.0f) {
            this.f = 1.0f;
        }
        this.b = f;
        this.d = 0L;
        this.a = System.currentTimeMillis();
        this.h.invalidate();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String upperCase;
        int iF;
        TextPaint textPaint;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        canvas.save();
        canvas.translate(bounds.left, bounds.top);
        canvas.drawRect(0.0f, 0.0f, iWidth, iHeight, r);
        int iF2 = (iHeight - AbstractC21455b.F(240.0f)) / 2;
        int iF3 = (iWidth - AbstractC21455b.F(48.0f)) / 2;
        this.m.setBounds(iF3, iF2, AbstractC21455b.F(48.0f) + iF3, AbstractC21455b.F(48.0f) + iF2);
        this.m.draw(canvas);
        canvas.drawText(this.n, (iWidth - ((int) Math.ceil(t.measureText(this.n)))) / 2, AbstractC21455b.F(31.0f) + iF2, t);
        canvas.drawText(this.o, (iWidth - ((int) Math.ceil(u.measureText(this.o)))) / 2, AbstractC21455b.F(96.0f) + iF2, u);
        canvas.drawText(this.p, (iWidth - ((int) Math.ceil(v.measureText(this.p)))) / 2, AbstractC21455b.F(125.0f) + iF2, v);
        if (this.l) {
            upperCase = FH3.E("OpenFile", TD5.tgwidget_OpenFile);
            textPaint = y;
            iF = 0;
        } else {
            upperCase = this.k ? FH3.E("Cancel", TD5.tgwidget_Cancel).toUpperCase() : FH3.E("TapToDownload", TD5.tgwidget_TapToDownload);
            iF = AbstractC21455b.F(28.0f);
            textPaint = w;
        }
        canvas.drawText(upperCase, (iWidth - ((int) Math.ceil(textPaint.measureText(upperCase)))) / 2, AbstractC21455b.F(235.0f) + iF2 + iF, textPaint);
        if (this.g) {
            if (this.q != null) {
                canvas.drawText(this.q, (iWidth - ((int) Math.ceil(x.measureText(r3)))) / 2, AbstractC21455b.F(210.0f) + iF2, x);
            }
            int iF4 = (iWidth - AbstractC21455b.F(240.0f)) / 2;
            int iF5 = iF2 + AbstractC21455b.F(232.0f);
            s.setColor(-10327179);
            s.setAlpha((int) (this.f * 255.0f));
            float f = iF5;
            canvas.drawRect(((int) (AbstractC21455b.F(240.0f) * this.e)) + iF4, f, AbstractC21455b.F(240.0f) + iF4, AbstractC21455b.F(2.0f) + iF5, s);
            s.setColor(-1);
            s.setAlpha((int) (this.f * 255.0f));
            float f2 = iF4;
            canvas.drawRect(f2, f, f2 + (AbstractC21455b.F(240.0f) * this.e), iF5 + AbstractC21455b.F(2.0f), s);
            d();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h.getMeasuredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h.getMeasuredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.h.getMeasuredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.h.getMeasuredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        r.setAlpha(i);
        t.setAlpha(i);
        u.setAlpha(i);
        v.setAlpha(i);
        w.setAlpha(i);
        x.setAlpha(i);
        y.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
