package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.nl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17902nl0 {
    private static final String TAG = "BserObject";
    private C18818pI6 unmappedObjects;

    public C18818pI6 getUnmappedObjects() {
        return this.unmappedObjects;
    }

    protected void load(byte[] bArr) {
        try {
            parse(new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length))));
        } catch (IOException e) {
            C19406qI3.d(TAG, e);
            throw new RuntimeException("Unexpected IO exception in parse: " + toString());
        }
    }

    public abstract void parse(C19084pl0 c19084pl0);

    public abstract void serialize(C19675ql0 c19675ql0);

    public void setUnmappedObjects(C18818pI6 c18818pI6) {
        this.unmappedObjects = c18818pI6;
    }

    public byte[] toByteArray() {
        C12658ez1 c12658ez1 = new C12658ez1();
        try {
            serialize(new C19675ql0(c12658ez1));
            return c12658ez1.c();
        } catch (IOException unused) {
            throw new RuntimeException("Unexpected IO exception in serialize: " + toString());
        }
    }
}
