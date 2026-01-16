package ir.nasim;

import android.text.TextPaint;

/* renamed from: ir.nasim.lK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16468lK2 extends AbstractC15286jK2 {
    private final CharSequence a;
    private final TextPaint b;

    public C16468lK2(CharSequence charSequence, TextPaint textPaint) {
        this.a = charSequence;
        this.b = textPaint;
    }

    @Override // ir.nasim.AbstractC15286jK2
    public int e(int i) {
        TextPaint textPaint = this.b;
        CharSequence charSequence = this.a;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 0);
    }

    @Override // ir.nasim.AbstractC15286jK2
    public int f(int i) {
        TextPaint textPaint = this.b;
        CharSequence charSequence = this.a;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i, 2);
    }
}
