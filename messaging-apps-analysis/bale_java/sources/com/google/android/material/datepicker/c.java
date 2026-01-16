package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
abstract class c {
    static String a(long j) {
        return b(j, Locale.getDefault());
    }

    static String b(long j, Locale locale) {
        return m.b(locale).format(new Date(j));
    }

    static String c(long j) {
        return DateUtils.formatDateTime(null, j, 8228);
    }

    static String d(long j) {
        return e(j, Locale.getDefault());
    }

    static String e(long j, Locale locale) {
        return m.k(locale).format(new Date(j));
    }
}
