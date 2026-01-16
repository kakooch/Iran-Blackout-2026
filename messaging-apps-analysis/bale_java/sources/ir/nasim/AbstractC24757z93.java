package ir.nasim;

import android.view.inputmethod.ExtractedText;

/* renamed from: ir.nasim.z93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24757z93 {
    public static final ExtractedText a(C23945xm7 c23945xm7) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = c23945xm7.h();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = c23945xm7.h().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = C4301En7.l(c23945xm7.g());
        extractedText.selectionEnd = C4301En7.k(c23945xm7.g());
        extractedText.flags = !AbstractC20762sZ6.W(c23945xm7.h(), '\n', false, 2, null) ? 1 : 0;
        return extractedText;
    }
}
