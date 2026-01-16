package ir.nasim;

import android.text.Layout;

/* renamed from: ir.nasim.bu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10616bu3 {
    public static final int a(Layout layout, int i, boolean z) {
        if (i <= 0) {
            return 0;
        }
        if (i >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int lineStart = layout.getLineStart(lineForOffset);
        return (lineStart == i || layout.getLineEnd(lineForOffset) == i) ? lineStart == i ? z ? lineForOffset - 1 : lineForOffset : z ? lineForOffset : lineForOffset + 1 : lineForOffset;
    }
}
