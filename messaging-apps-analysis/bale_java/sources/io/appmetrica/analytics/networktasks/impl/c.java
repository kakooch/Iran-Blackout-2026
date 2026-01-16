package io.appmetrica.analytics.networktasks.impl;

import android.net.Uri;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public final class c {
    public final String a;

    public c(String str) {
        this.a = a(str);
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Uri uri = Uri.parse(str);
        return AbstractC13042fc3.d("http", uri.getScheme()) ? uri.buildUpon().scheme("https").build().toString() : str;
    }
}
