package ir.nasim;

import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.Dc6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3967Dc6 {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: ir.nasim.Dc6$a */
    public static abstract class a implements GV1 {
        public abstract GV1 a(Runnable runnable, long j, TimeUnit timeUnit);
    }

    public abstract a a();
}
