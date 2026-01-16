package ir.nasim;

import android.app.job.JobInfo;
import ir.nasim.C24938zT;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Gc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4684Gc6 {

    /* renamed from: ir.nasim.Gc6$a */
    public static class a {
        private QV0 a;
        private Map b = new HashMap();

        public a a(EnumC5979Lq5 enumC5979Lq5, b bVar) {
            this.b.put(enumC5979Lq5, bVar);
            return this;
        }

        public AbstractC4684Gc6 b() {
            if (this.a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.b.keySet().size() < EnumC5979Lq5.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.b;
            this.b = new HashMap();
            return AbstractC4684Gc6.d(this.a, map);
        }

        public a c(QV0 qv0) {
            this.a = qv0;
            return this;
        }
    }

    /* renamed from: ir.nasim.Gc6$b */
    public static abstract class b {

        /* renamed from: ir.nasim.Gc6$b$a */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j);

            public abstract a c(Set set);

            public abstract a d(long j);
        }

        public static a a() {
            return new C24938zT.b().c(Collections.emptySet());
        }

        abstract long b();

        abstract Set c();

        abstract long d();
    }

    /* renamed from: ir.nasim.Gc6$c */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i, long j) {
        return (long) (Math.pow(3.0d, i - 1) * j * Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * r7)));
    }

    public static a b() {
        return new a();
    }

    static AbstractC4684Gc6 d(QV0 qv0, Map map) {
        return new C24344yT(qv0, map);
    }

    public static AbstractC4684Gc6 f(QV0 qv0) {
        return b().a(EnumC5979Lq5.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(EnumC5979Lq5.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(EnumC5979Lq5.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(qv0).b();
    }

    private static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, EnumC5979Lq5 enumC5979Lq5, long j, int i) {
        builder.setMinimumLatency(g(enumC5979Lq5, j, i));
        j(builder, ((b) h().get(enumC5979Lq5)).c());
        return builder;
    }

    abstract QV0 e();

    public long g(EnumC5979Lq5 enumC5979Lq5, long j, int i) {
        long time = j - e().getTime();
        b bVar = (b) h().get(enumC5979Lq5);
        return Math.min(Math.max(a(i, bVar.b()), time), bVar.d());
    }

    abstract Map h();
}
