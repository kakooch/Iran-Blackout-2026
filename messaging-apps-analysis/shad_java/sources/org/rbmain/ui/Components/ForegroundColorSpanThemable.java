package org.rbmain.ui.Components;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class ForegroundColorSpanThemable extends CharacterStyle implements UpdateAppearance {
    private int color;
    private int colorKey;

    public ForegroundColorSpanThemable(int i) {
        this.colorKey = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.color = Theme.getColor(this.colorKey);
        int color = textPaint.getColor();
        int i = this.color;
        if (color != i) {
            textPaint.setColor(i);
        }
    }
}
