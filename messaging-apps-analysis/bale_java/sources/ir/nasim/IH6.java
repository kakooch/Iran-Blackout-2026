package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ir.nasim.AbstractC9599aE4;

/* loaded from: classes7.dex */
public final class IH6 {
    public static final IH6 a = new IH6();

    private IH6() {
    }

    public final Intent a(Context context) {
        AbstractC13042fc3.i(context, "context");
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        intent.putExtra("android.intent.extra.ringtone.TITLE", context.getText(QD5.setting_not_sound_select_tone));
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", AbstractC9599aE4.a.n(AbstractC9599aE4.a, null, 1, null));
        return intent;
    }

    public final void b(int i, Intent intent, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onUriChanged");
        if (i != -1 || intent == null) {
            return;
        }
        ua2.invoke((Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI"));
    }
}
