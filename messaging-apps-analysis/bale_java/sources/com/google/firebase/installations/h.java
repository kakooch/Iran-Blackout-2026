package com.google.firebase.installations;

import android.text.TextUtils;
import ir.nasim.J47;
import ir.nasim.PV0;
import ir.nasim.W45;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class h {
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    private static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");
    private static h d;
    private final PV0 a;

    private h(PV0 pv0) {
        this.a = pv0;
    }

    public static h c() {
        return d(J47.a());
    }

    public static h d(PV0 pv0) {
        if (d == null) {
            d = new h(pv0);
        }
        return d;
    }

    static boolean g(String str) {
        return c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(W45 w45) {
        return TextUtils.isEmpty(w45.b()) || w45.h() + w45.c() < b() + b;
    }
}
