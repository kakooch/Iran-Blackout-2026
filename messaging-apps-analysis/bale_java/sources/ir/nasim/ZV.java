package ir.nasim;

/* loaded from: classes2.dex */
public abstract class ZV {

    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static ZV a() {
        return new PS(a.FATAL_ERROR, -1L);
    }

    public static ZV d() {
        return new PS(a.INVALID_PAYLOAD, -1L);
    }

    public static ZV e(long j) {
        return new PS(a.OK, j);
    }

    public static ZV f() {
        return new PS(a.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract a c();
}
