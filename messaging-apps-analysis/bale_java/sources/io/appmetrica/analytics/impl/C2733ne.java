package io.appmetrica.analytics.impl;

import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.ne, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2733ne extends Yc implements xn {
    public static final C2709me d = new C2709me("LOCATION_TRACKING_ENABLED", null);
    public static final C2709me e = new C2709me("PREF_KEY_OFFSET", null);
    public static final C2709me f = new C2709me("UNCHECKED_TIME", null);
    public static final C2709me g = new C2709me("STATISTICS_RESTRICTED_IN_MAIN", null);
    public static final C2709me h = new C2709me("LAST_IDENTITY_LIGHT_SEND_TIME", null);
    public static final C2709me i = new C2709me("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
    public static final C2709me j = new C2709me("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
    public static final C2709me k = new C2709me("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
    public static final C2709me l = new C2709me("LAST_REPORT_SEND_ATTEMPT_TIME", null);
    public static final C2709me m = new C2709me("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
    public static final C2709me n = new C2709me("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
    public static final C2709me o = new C2709me("SATELLITE_PRELOAD_INFO_CHECKED", null);
    public static final C2709me p = new C2709me("SATELLITE_CLIDS_CHECKED", null);
    public static final C2709me q = new C2709me("VITAL_DATA", null);
    public static final C2709me r = new C2709me("LAST_KOTLIN_VERSION_SEND_TIME", null);

    public C2733ne(Ba ba) {
        super(ba);
    }

    public final long a(int i2) {
        return this.a.getLong(e.b, i2);
    }

    public final C2733ne b(boolean z) {
        return (C2733ne) b(g.b, z);
    }

    public final C2733ne c(boolean z) {
        return (C2733ne) b(f.b, z);
    }

    public final void d(boolean z) {
        b(d.b, z).b();
    }

    public final boolean e() {
        return this.a.getBoolean(d.b, false);
    }

    public final long f() {
        return this.a.getLong(r.b, 0L);
    }

    public final C2733ne g() {
        return (C2733ne) b(p.b, true);
    }

    public final C2733ne h() {
        return (C2733ne) b(o.b, true);
    }

    public final boolean i() {
        return this.a.getBoolean(o.b, false);
    }

    public final boolean j() {
        return this.a.getBoolean(p.b, false);
    }

    public final boolean a(boolean z) {
        return this.a.getBoolean(f.b, z);
    }

    public final C2733ne b(long j2) {
        return (C2733ne) b(h.b, j2);
    }

    public final C2733ne c(long j2) {
        return (C2733ne) b(r.b, j2);
    }

    public final C2733ne d(long j2) {
        return (C2733ne) b(e.b, j2);
    }

    @Override // io.appmetrica.analytics.impl.Yc
    public final String f(String str) {
        return new C2709me(str, null).b;
    }

    public final long a(long j2) {
        return this.a.getLong(h.b, j2);
    }

    public final C2733ne b(EnumC2684ld enumC2684ld, int i2) {
        C2709me c2709me;
        int iOrdinal = enumC2684ld.ordinal();
        if (iOrdinal == 0) {
            c2709me = i;
        } else if (iOrdinal != 1) {
            c2709me = iOrdinal != 2 ? null : k;
        } else {
            c2709me = j;
        }
        return c2709me != null ? (C2733ne) b(c2709me.b, i2) : this;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2685le
    public final Set<String> c() {
        return this.a.a();
    }

    public final Boolean d() {
        C2709me c2709me = g;
        if (!this.a.a(c2709me.b)) {
            return null;
        }
        return Boolean.valueOf(this.a.getBoolean(c2709me.b, true));
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final String a() {
        return this.a.getString(q.b, null);
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final void a(String str) {
        b(q.b, str).b();
    }

    public final C2733ne b(EnumC2684ld enumC2684ld, long j2) {
        C2709me c2709me;
        int iOrdinal = enumC2684ld.ordinal();
        if (iOrdinal == 0) {
            c2709me = l;
        } else if (iOrdinal != 1) {
            c2709me = iOrdinal != 2 ? null : n;
        } else {
            c2709me = m;
        }
        return c2709me != null ? (C2733ne) b(c2709me.b, j2) : this;
    }

    public final int a(EnumC2684ld enumC2684ld, int i2) {
        C2709me c2709me;
        int iOrdinal = enumC2684ld.ordinal();
        if (iOrdinal == 0) {
            c2709me = i;
        } else if (iOrdinal != 1) {
            c2709me = iOrdinal != 2 ? null : k;
        } else {
            c2709me = j;
        }
        if (c2709me == null) {
            return i2;
        }
        return this.a.getInt(c2709me.b, i2);
    }

    public final long a(EnumC2684ld enumC2684ld, long j2) {
        C2709me c2709me;
        int iOrdinal = enumC2684ld.ordinal();
        if (iOrdinal == 0) {
            c2709me = l;
        } else if (iOrdinal != 1) {
            c2709me = iOrdinal != 2 ? null : n;
        } else {
            c2709me = m;
        }
        if (c2709me == null) {
            return j2;
        }
        return this.a.getLong(c2709me.b, j2);
    }
}
