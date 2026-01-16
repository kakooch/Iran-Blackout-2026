package ir.nasim;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Build;

/* loaded from: classes8.dex */
public final class KV0 {
    public static final KV0 a = new KV0();

    private KV0() {
    }

    public static final boolean a(Context context, CharSequence charSequence) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
        Object systemService = context.getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Messages", charSequence));
        return true;
    }

    public static final boolean b() {
        return C15456jc8.c() || Build.VERSION.SDK_INT < 33;
    }
}
