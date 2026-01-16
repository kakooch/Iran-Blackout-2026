package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public abstract class F extends Drawable {
    public static String a(float f) {
        Math.abs(f - 0.25f);
        float fRound = Math.round(f * 10.0f) / 10.0f;
        long j = (long) fRound;
        if (fRound == j) {
            return "" + j;
        }
        return "" + fRound;
    }
}
