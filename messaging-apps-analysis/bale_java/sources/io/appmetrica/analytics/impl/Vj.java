package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class Vj {
    public static final String d = "SESSION_SLEEP_START";
    public static final String e = "SESSION_LAST_EVENT_OFFSET";
    public static final String f = "SESSION_ID";
    public static final String g = "SESSION_COUNTER_ID";
    public static final String h = "SESSION_INIT_TIME";
    public static final String i = "SESSION_IS_ALIVE_REPORT_NEEDED";
    public final String a;
    protected final C2661ke b;
    public Xa c;

    public Vj(C2661ke c2661ke, String str) {
        this.b = c2661ke;
        this.a = str;
        Xa xa = new Xa();
        try {
            String strH = c2661ke.h(str);
            if (!TextUtils.isEmpty(strH)) {
                xa = new Xa(strH);
            }
        } catch (Throwable unused) {
        }
        this.c = xa;
    }

    public final Vj a(long j) {
        a(h, Long.valueOf(j));
        return this;
    }

    public final Vj b(long j) {
        a(e, Long.valueOf(j));
        return this;
    }

    public final Long c() {
        return this.c.a(h);
    }

    public final Vj d(long j) {
        a(f, Long.valueOf(j));
        return this;
    }

    public final Long e() {
        return this.c.a(g);
    }

    public final Long f() {
        return this.c.a(f);
    }

    public final Long g() {
        return this.c.a(d);
    }

    public final boolean h() {
        return this.c.length() > 0;
    }

    public final Boolean i() {
        Xa xa = this.c;
        xa.getClass();
        try {
            return Boolean.valueOf(xa.getBoolean(i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Vj a(boolean z) {
        a(i, Boolean.valueOf(z));
        return this;
    }

    public final void b() {
        this.b.e(this.a, this.c.toString());
        this.b.b();
    }

    public final Vj c(long j) {
        a(g, Long.valueOf(j));
        return this;
    }

    public final Long d() {
        return this.c.a(e);
    }

    public final Vj e(long j) {
        a(d, Long.valueOf(j));
        return this;
    }

    public final void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.c = new Xa();
        b();
    }
}
