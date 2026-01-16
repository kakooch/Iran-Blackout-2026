package ir.nasim;

import android.os.Build;
import android.text.TextPaint;

/* renamed from: ir.nasim.zl6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25118zl6 {
    public static final InterfaceC24524yl6 a(CharSequence charSequence, TextPaint textPaint) {
        return Build.VERSION.SDK_INT >= 29 ? new C16468lK2(charSequence, textPaint) : new C17059mK2(charSequence);
    }
}
