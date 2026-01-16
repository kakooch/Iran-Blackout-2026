package ir.nasim;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public abstract class UV0 extends Drawable {
    private Paint a;
    private long b;
    private DecelerateInterpolator c;
    private RectF d;
    private float e;
    private boolean f;
    private int g;
    private int h;
    private int i;

    public UV0() {
        this(2.0f);
    }

    private void b(int i) {
        if (this.i != i) {
            this.h = Color.alpha(i);
            this.a.setColor(QY0.k(i, 255));
        }
    }

    protected abstract int a();

    /* JADX WARN: Removed duplicated region for block: B:70:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bd  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UV0.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AbstractC21455b.F(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AbstractC21455b.F(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public UV0(float f) {
        this.a = new Paint(1);
        this.c = new DecelerateInterpolator();
        this.d = new RectF();
        this.h = 255;
        this.a.setColor(-1);
        this.a.setStrokeWidth(AbstractC21455b.F(f));
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStyle(Paint.Style.STROKE);
        this.g = AbstractC21455b.F(8.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
