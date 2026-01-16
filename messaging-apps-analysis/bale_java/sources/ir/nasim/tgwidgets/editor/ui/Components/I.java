package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import ir.nasim.FH3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class I extends Drawable {
    private static final int[] r = {10, 7, 26, 16, 10, 25};
    private boolean d;
    private boolean e;
    private Path f;
    private int g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private a n;
    private long o;
    private String p;
    private Paint a = new Paint(1);
    private TextPaint b = new TextPaint(1);
    private Path c = new Path();
    private float q = 1.0f;

    public interface a {
        void a();

        void invalidate();
    }

    public I(boolean z) {
        this.e = z;
        this.a.setColor(-1);
        this.b.setColor(-1);
        this.b.setTextSize(AbstractC21455b.F(12.0f));
        this.b.setTextAlign(Paint.Align.CENTER);
        this.c.reset();
        int i = 0;
        while (true) {
            if (i >= r.length / 2) {
                this.c.close();
                return;
            }
            if (i == 0) {
                int i2 = i * 2;
                this.c.moveTo(AbstractC21455b.F(r0[i2]), AbstractC21455b.F(r0[i2 + 1]));
            } else {
                int i3 = i * 2;
                this.c.lineTo(AbstractC21455b.F(r0[i3]), AbstractC21455b.F(r0[i3 + 1]));
            }
            i++;
        }
    }

    private void b() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.invalidate();
        } else {
            invalidateSelf();
        }
    }

    public void a(long j) {
        long j2 = this.o + j;
        this.o = j2;
        this.p = FH3.o("Seconds", (int) (j2 / 1000), new Object[0]);
    }

    public boolean c() {
        return this.j;
    }

    public void d(a aVar) {
        this.n = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x0281  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.I.draw(android.graphics.Canvas):void");
    }

    public void e(boolean z) {
        boolean z2 = this.d;
        if (z2 == z && this.h >= 1.0f && this.k) {
            return;
        }
        if (z2 != z) {
            this.o = 0L;
            this.p = null;
        }
        this.d = z;
        j();
    }

    public void f(boolean z) {
        if (this.k != z) {
            this.k = z;
            this.p = null;
            this.o = 0L;
            this.h = 0.0f;
        }
    }

    public void g(float f) {
        this.q = f;
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AbstractC21455b.F(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AbstractC21455b.F(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return AbstractC21455b.F(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return AbstractC21455b.F(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void h(boolean z) {
        this.l = z;
        b();
    }

    public void i(long j) {
        this.o = j;
        if (j >= 1000) {
            this.p = FH3.o("Seconds", (int) (j / 1000), new Object[0]);
        } else {
            this.p = null;
        }
    }

    public void j() {
        this.j = true;
        this.h = 0.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
