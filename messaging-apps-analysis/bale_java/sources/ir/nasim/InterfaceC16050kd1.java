package ir.nasim;

/* renamed from: ir.nasim.kd1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC16050kd1 {

    /* renamed from: ir.nasim.kd1$a */
    public enum a {
        MTPROTO_VERSION,
        APIMAJOR_VERSION,
        APIMINOR_VERSION,
        NONE,
        UNKNOWN
    }

    void a();

    void b(byte[] bArr, int i, int i2);

    void close();

    boolean isClosed();
}
