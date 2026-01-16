package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: ir.nasim.nm1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17913nm1 {
    public static final C17913nm1 a = new C17913nm1();

    private C17913nm1() {
    }

    public static final boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static final void b(Context context) {
        String name;
        AbstractC13042fc3.i(context, "context");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=ir.nasim")));
        } catch (Exception e) {
            if (X25.a.getClass().isAnonymousClass()) {
                name = X25.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = X25.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "openDownload", e);
        }
    }
}
