package ir.nasim;

import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.Zj7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9312Zj7 {
    public static final String a = AbstractC10110b57.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long b = AbstractC11490d57.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int c = AbstractC11490d57.e("kotlinx.coroutines.scheduler.core.pool.size", AbstractC23053wG5.e(AbstractC10110b57.a(), 2), 1, 0, 8, null);
    public static final int d = AbstractC11490d57.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
    public static final long e = TimeUnit.SECONDS.toNanos(AbstractC11490d57.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    public static AbstractC9829ad6 f = C9120Yo4.a;
    public static final InterfaceC5216Ij7 g = new C5450Jj7(0);
    public static final InterfaceC5216Ij7 h = new C5450Jj7(1);
}
