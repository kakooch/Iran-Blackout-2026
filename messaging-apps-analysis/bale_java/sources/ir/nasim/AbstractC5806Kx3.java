package ir.nasim;

import android.text.Spanned;

/* renamed from: ir.nasim.Kx3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5806Kx3 {
    public static boolean a(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i;
    }

    public static boolean b(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i;
    }
}
