package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Xh8;

/* renamed from: com.google.android.gms.measurement.internal.q1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2292q1 extends AbstractC2218b2 {
    static final Pair y = new Pair("", 0L);
    private SharedPreferences c;
    public C2282o1 d;
    public final C2277n1 e;
    public final C2277n1 f;
    public final C2287p1 g;
    private String h;
    private boolean i;
    private long j;
    public final C2277n1 k;
    public final C2267l1 l;
    public final C2287p1 m;
    public final C2267l1 n;
    public final C2277n1 o;
    public final C2277n1 p;
    public boolean q;
    public final C2267l1 r;
    public final C2267l1 s;
    public final C2277n1 t;
    public final C2287p1 u;
    public final C2287p1 v;
    public final C2277n1 w;
    public final C2272m1 x;

    C2292q1(H1 h1) {
        super(h1);
        this.k = new C2277n1(this, "session_timeout", 1800000L);
        this.l = new C2267l1(this, "start_new_session", true);
        this.o = new C2277n1(this, "last_pause_time", 0L);
        this.p = new C2277n1(this, "session_id", 0L);
        this.m = new C2287p1(this, "non_personalized_ads", null);
        this.n = new C2267l1(this, "allow_remote_dynamite", false);
        this.e = new C2277n1(this, "first_open_time", 0L);
        this.f = new C2277n1(this, "app_install_time", 0L);
        this.g = new C2287p1(this, "app_instance_id", null);
        this.r = new C2267l1(this, "app_backgrounded", false);
        this.s = new C2267l1(this, "deep_link_retrieval_complete", false);
        this.t = new C2277n1(this, "deep_link_retrieval_attempts", 0L);
        this.u = new C2287p1(this, "firebase_feature_rollouts", null);
        this.v = new C2287p1(this, "deferred_attribution_cache", null);
        this.w = new C2277n1(this, "deferred_attribution_cache_timestamp", 0L);
        this.x = new C2272m1(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2218b2
    protected final void i() {
        SharedPreferences sharedPreferences = this.a.f().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.q = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.a.z();
        this.d = new C2282o1(this, "health_monitor", Math.max(0L, ((Long) S0.d.a(null)).longValue()), null);
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2218b2
    protected final boolean j() {
        return true;
    }

    protected final SharedPreferences o() {
        h();
        k();
        AbstractC3795Cj5.j(this.c);
        return this.c;
    }

    final Pair p(String str) {
        h();
        long jElapsedRealtime = this.a.c().elapsedRealtime();
        String str2 = this.h;
        if (str2 != null && jElapsedRealtime < this.j) {
            return new Pair(str2, Boolean.valueOf(this.i));
        }
        this.j = jElapsedRealtime + this.a.z().r(str, S0.c);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.f());
            this.h = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.h = id;
            }
            this.i = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            this.a.b().q().b("Unable to get advertising id", e);
            this.h = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.h, Boolean.valueOf(this.i));
    }

    final Xh8 q() {
        h();
        return Xh8.b(o().getString("consent_settings", "G1"));
    }

    final Boolean r() {
        h();
        if (o().contains("measurement_enabled")) {
            return Boolean.valueOf(o().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    final void s(Boolean bool) {
        h();
        SharedPreferences.Editor editorEdit = o().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    final void t(boolean z) {
        h();
        this.a.b().v().b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = o().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean u() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    final boolean v(long j) {
        return j - this.k.a() > this.o.a();
    }

    final boolean w(int i) {
        return Xh8.j(i, o().getInt("consent_source", 100));
    }
}
