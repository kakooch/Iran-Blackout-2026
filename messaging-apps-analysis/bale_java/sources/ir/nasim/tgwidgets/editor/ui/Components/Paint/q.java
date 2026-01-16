package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.RectF;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;

/* loaded from: classes7.dex */
public class q {
    public final a.g a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public boolean l;

    public q(a.g gVar) {
        this.a = gVar;
    }

    public void a(RectF rectF) {
        if (b() == 4) {
            float f = this.b;
            float f2 = this.k;
            float f3 = this.c;
            rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
            rectF.union(this.d, this.e);
            rectF.union(this.i, this.j);
        } else {
            float fMax = Math.max(Math.abs(this.d), Math.abs(this.e));
            float f4 = this.b;
            float f5 = fMax * 1.42f;
            float f6 = this.c;
            rectF.set(f4 - f5, f6 - f5, f4 + f5, f6 + f5);
            if (b() == 3) {
                rectF.union(this.i, this.j);
            }
        }
        float f7 = this.f;
        rectF.inset((-f7) - 3.0f, (-f7) - 3.0f);
    }

    public int b() {
        return this.a.p();
    }
}
