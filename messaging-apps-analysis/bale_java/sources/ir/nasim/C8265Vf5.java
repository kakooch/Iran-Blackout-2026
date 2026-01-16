package ir.nasim;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.Vf5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8265Vf5 extends Drawable {
    private final Paint a;
    private final int b;
    private boolean c;
    private float d;
    private long e;
    private View f;
    private int g = 255;
    float h = 300.0f;

    public C8265Vf5(int i) {
        this.b = AbstractC21455b.F(i);
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(View view) {
        this.f = view;
    }

    public void c(boolean z, boolean z2) {
        if (this.c != z) {
            this.c = z;
            if (!z2) {
                this.d = z ? 1.0f : 0.0f;
            }
            this.e = AnimationUtils.currentAnimationTimeMillis();
            invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8265Vf5.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
