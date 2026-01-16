package ir.appp.rghapp.components;

import android.os.Build;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoUsernameSpan extends ForegroundColorSpan {
    public String username;

    public RubinoUsernameSpan(int i, String str) {
        super(i);
        this.username = str;
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setTypeface(Theme.getRubinoTypeFaceMedium());
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(-0.01165f);
        }
        textPaint.setUnderlineText(false);
    }
}
