package ir.nasim;

/* loaded from: classes2.dex */
public interface CQ5 {

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean a;

        a(boolean z) {
            this.a = z;
        }

        boolean j() {
            return this.a;
        }
    }

    boolean a();

    void b(RP5 rp5);

    boolean c(RP5 rp5);

    boolean d(RP5 rp5);

    boolean f(RP5 rp5);

    CQ5 getRoot();

    void k(RP5 rp5);
}
