package ir.nasim;

/* loaded from: classes3.dex */
public final class Ks8 implements Js8 {
    public static final AbstractC11344cq8 A;
    public static final AbstractC11344cq8 B;
    public static final AbstractC11344cq8 C;
    public static final AbstractC11344cq8 D;
    public static final AbstractC11344cq8 E;
    public static final AbstractC11344cq8 F;
    public static final AbstractC11344cq8 G;
    public static final AbstractC11344cq8 H;
    public static final AbstractC11344cq8 I;
    public static final AbstractC11344cq8 J;
    public static final AbstractC11344cq8 K;
    public static final AbstractC11344cq8 L;
    public static final AbstractC11344cq8 M;
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;
    public static final AbstractC11344cq8 e;
    public static final AbstractC11344cq8 f;
    public static final AbstractC11344cq8 g;
    public static final AbstractC11344cq8 h;
    public static final AbstractC11344cq8 i;
    public static final AbstractC11344cq8 j;
    public static final AbstractC11344cq8 k;
    public static final AbstractC11344cq8 l;
    public static final AbstractC11344cq8 m;
    public static final AbstractC11344cq8 n;
    public static final AbstractC11344cq8 o;
    public static final AbstractC11344cq8 p;
    public static final AbstractC11344cq8 q;
    public static final AbstractC11344cq8 r;
    public static final AbstractC11344cq8 s;
    public static final AbstractC11344cq8 t;
    public static final AbstractC11344cq8 u;
    public static final AbstractC11344cq8 v;
    public static final AbstractC11344cq8 w;
    public static final AbstractC11344cq8 x;
    public static final AbstractC11344cq8 y;
    public static final AbstractC11344cq8 z;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.d("measurement.ad_id_cache_time", 10000L);
        b = lp8A.d("measurement.max_bundles_per_iteration", 100L);
        c = lp8A.d("measurement.config.cache_time", 86400000L);
        d = lp8A.e("measurement.log_tag", "FA");
        e = lp8A.e("measurement.config.url_authority", "app-measurement.com");
        f = lp8A.e("measurement.config.url_scheme", "https");
        g = lp8A.d("measurement.upload.debug_upload_interval", 1000L);
        h = lp8A.d("measurement.lifetimevalue.max_currency_tracked", 4L);
        i = lp8A.d("measurement.store.max_stored_events_per_app", 100000L);
        j = lp8A.d("measurement.experiment.max_ids", 50L);
        k = lp8A.d("measurement.audience.filter_result_max_count", 200L);
        l = lp8A.d("measurement.alarm_manager.minimum_interval", 60000L);
        m = lp8A.d("measurement.upload.minimum_delay", 500L);
        n = lp8A.d("measurement.monitoring.sample_period_millis", 86400000L);
        o = lp8A.d("measurement.upload.realtime_upload_interval", 10000L);
        p = lp8A.d("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        q = lp8A.d("measurement.config.cache_time.service", 3600000L);
        r = lp8A.d("measurement.service_client.idle_disconnect_millis", 5000L);
        s = lp8A.e("measurement.log_tag.service", "FA-SVC");
        t = lp8A.d("measurement.upload.stale_data_deletion_interval", 86400000L);
        u = lp8A.d("measurement.sdk.attribution.cache.ttl", 604800000L);
        v = lp8A.d("measurement.redaction.app_instance_id.ttl", 7200000L);
        w = lp8A.d("measurement.upload.backoff_period", 43200000L);
        x = lp8A.d("measurement.upload.initial_upload_delay_time", 15000L);
        y = lp8A.d("measurement.upload.interval", 3600000L);
        z = lp8A.d("measurement.upload.max_bundle_size", 65536L);
        A = lp8A.d("measurement.upload.max_bundles", 100L);
        B = lp8A.d("measurement.upload.max_conversions_per_day", 500L);
        C = lp8A.d("measurement.upload.max_error_events_per_day", 1000L);
        D = lp8A.d("measurement.upload.max_events_per_bundle", 1000L);
        E = lp8A.d("measurement.upload.max_events_per_day", 100000L);
        F = lp8A.d("measurement.upload.max_public_events_per_day", 50000L);
        G = lp8A.d("measurement.upload.max_queue_time", 2419200000L);
        H = lp8A.d("measurement.upload.max_realtime_events_per_day", 10L);
        I = lp8A.d("measurement.upload.max_batch_size", 65536L);
        J = lp8A.d("measurement.upload.retry_count", 6L);
        K = lp8A.d("measurement.upload.retry_time", 1800000L);
        L = lp8A.e("measurement.upload.url", "https://app-measurement.com/a");
        M = lp8A.d("measurement.upload.window_interval", 3600000L);
    }

    @Override // ir.nasim.Js8
    public final String A() {
        return (String) f.b();
    }

    @Override // ir.nasim.Js8
    public final long B() {
        return ((Long) r.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long C() {
        return ((Long) t.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long D() {
        return ((Long) G.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long E() {
        return ((Long) H.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long F() {
        return ((Long) x.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long G() {
        return ((Long) z.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long H() {
        return ((Long) A.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long I() {
        return ((Long) F.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long J() {
        return ((Long) y.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long b() {
        return ((Long) u.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long c() {
        return ((Long) b.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long d() {
        return ((Long) g.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long e() {
        return ((Long) c.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long f() {
        return ((Long) p.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long g() {
        return ((Long) h.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long h() {
        return ((Long) n.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long i() {
        return ((Long) v.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long j() {
        return ((Long) l.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long k() {
        return ((Long) k.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long l() {
        return ((Long) w.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long m() {
        return ((Long) m.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long n() {
        return ((Long) i.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long o() {
        return ((Long) j.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long p() {
        return ((Long) K.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long q() {
        return ((Long) D.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long r() {
        return ((Long) o.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long s() {
        return ((Long) E.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long t() {
        return ((Long) M.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long u() {
        return ((Long) B.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long v() {
        return ((Long) I.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long w() {
        return ((Long) J.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final long x() {
        return ((Long) C.b()).longValue();
    }

    @Override // ir.nasim.Js8
    public final String y() {
        return (String) L.b();
    }

    @Override // ir.nasim.Js8
    public final String z() {
        return (String) e.b();
    }

    @Override // ir.nasim.Js8
    public final long zza() {
        return ((Long) a.b()).longValue();
    }
}
