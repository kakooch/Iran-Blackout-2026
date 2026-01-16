package ir.nasim;

/* loaded from: classes8.dex */
public interface MC6 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final YE1 a(Runnable runnable, UA2 ua2) {
            return (runnable == null || ua2 == null) ? new YE1(null, 1, null) : new PE0(runnable, ua2);
        }
    }

    void lock();

    void unlock();
}
