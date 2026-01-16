package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* renamed from: ir.nasim.e33, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12109e33 extends ImageSpan {
    private final float a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12109e33(Drawable drawable, int i) {
        super(drawable);
        AbstractC13042fc3.i(drawable, "drawable");
        this.a = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        float f2 = i4 + this.a;
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            getDrawable().draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
