package ir.nasim;

import ir.nasim.LT;

/* renamed from: ir.nasim.wr7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23405wr7 {

    /* renamed from: ir.nasim.wr7$a */
    public static abstract class a {
        public abstract AbstractC23405wr7 a();

        public abstract a b(b bVar);

        public abstract a c(String str);

        public abstract a d(long j);
    }

    /* renamed from: ir.nasim.wr7$b */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a a() {
        return new LT.b().d(0L);
    }

    public abstract b b();

    public abstract String c();

    public abstract long d();
}
