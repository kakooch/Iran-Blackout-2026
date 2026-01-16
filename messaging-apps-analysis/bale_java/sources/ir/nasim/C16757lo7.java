package ir.nasim;

import android.content.ClipData;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* renamed from: ir.nasim.lo7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16757lo7 implements SJ4 {
    private static CharSequence b(Context context, ClipData.Item item, int i) {
        if ((i & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }

    private static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // ir.nasim.SJ4
    public C5219Ik1 a(View view, C5219Ik1 c5219Ik1) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c5219Ik1);
        }
        if (c5219Ik1.d() == 2) {
            return c5219Ik1;
        }
        ClipData clipDataB = c5219Ik1.b();
        int iC = c5219Ik1.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < clipDataB.getItemCount(); i++) {
            CharSequence charSequenceB = b(context, clipDataB.getItemAt(i), iC);
            if (charSequenceB != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), Separators.RETURN);
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceB);
                } else {
                    c(editable, charSequenceB);
                    z = true;
                }
            }
        }
        return null;
    }
}
