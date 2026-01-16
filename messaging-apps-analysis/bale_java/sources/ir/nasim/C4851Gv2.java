package ir.nasim;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.Gv2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4851Gv2 {
    public static final C4851Gv2 a = new C4851Gv2();

    private C4851Gv2() {
    }

    public static /* synthetic */ void c(C4851Gv2 c4851Gv2, String str, String str2, UA2 ua2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        c4851Gv2.b(str, str2, ua2);
    }

    public final void a(String str, Activity activity) {
        AbstractC13042fc3.i(str, "postLink");
        AbstractC13042fc3.i(activity, "activity");
        Object systemService = activity.getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Post Link", str));
    }

    public final void b(String str, String str2, UA2 ua2) {
        String name;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(ua2, "result");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            Intent intentCreateChooser = Intent.createChooser(intent, str2);
            AbstractC13042fc3.f(intentCreateChooser);
            ua2.invoke(intentCreateChooser);
        } catch (Exception e) {
            if (C4851Gv2.class.isAnonymousClass()) {
                name = C4851Gv2.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C4851Gv2.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "Failed to share text", e);
        }
    }
}
