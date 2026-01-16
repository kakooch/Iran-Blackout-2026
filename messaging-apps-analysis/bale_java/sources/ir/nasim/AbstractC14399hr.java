package ir.nasim;

import android.text.TextPaint;

/* renamed from: ir.nasim.hr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14399hr {
    public static final void a(TextPaint textPaint, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        textPaint.setAlpha(Math.round(f * 255));
    }
}
