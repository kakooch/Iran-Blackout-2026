package ir.nasim;

import android.media.metrics.LogSessionId;

/* renamed from: ir.nasim.jg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15493jg5 {
    public static final C15493jg5 b;
    private final a a;

    /* renamed from: ir.nasim.jg5$a */
    private static final class a {
        public static final a b = new a(LogSessionId.LOG_SESSION_ID_NONE);
        public final LogSessionId a;

        public a(LogSessionId logSessionId) {
            this.a = logSessionId;
        }
    }

    static {
        b = AbstractC9683aN7.a < 31 ? new C15493jg5() : new C15493jg5(a.b);
    }

    public C15493jg5() {
        this((a) null);
        AbstractC20011rK.g(AbstractC9683aN7.a < 31);
    }

    public LogSessionId a() {
        return ((a) AbstractC20011rK.e(this.a)).a;
    }

    public C15493jg5(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private C15493jg5(a aVar) {
        this.a = aVar;
    }
}
