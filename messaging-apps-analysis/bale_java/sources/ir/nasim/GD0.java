package ir.nasim;

/* loaded from: classes.dex */
public abstract class GD0 {

    public static abstract class a {
        public static a a(int i) {
            return b(i, null);
        }

        public static a b(int i, Throwable th) {
            return new US(i, th);
        }

        public abstract Throwable c();

        public abstract int d();
    }

    public enum b {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public static GD0 a(b bVar) {
        return b(bVar, null);
    }

    public static GD0 b(b bVar, a aVar) {
        return new TS(bVar, aVar);
    }

    public abstract a c();

    public abstract b d();
}
