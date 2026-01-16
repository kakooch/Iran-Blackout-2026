package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.e;
import ir.nasim.AbstractC14178hU4;

/* loaded from: classes2.dex */
class d implements e.InterfaceC0085e {
    private static final ThreadLocal b = new ThreadLocal();
    private final TextPaint a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.InterfaceC0085e
    public boolean a(CharSequence charSequence, int i, int i2, int i3) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i < i2) {
            sbB.append(charSequence.charAt(i));
            i++;
        }
        return AbstractC14178hU4.a(this.a, sbB.toString());
    }
}
