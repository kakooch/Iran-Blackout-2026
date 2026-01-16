package io.sentry.android.replay.util;

import android.content.Context;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public abstract class c {
    public static final Context a(Context context) {
        AbstractC13042fc3.i(context, "<this>");
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
