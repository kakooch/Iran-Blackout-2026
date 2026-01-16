package ir.nasim;

/* renamed from: ir.nasim.pY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18958pY2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long a(float f, boolean z, boolean z2) {
        return UV1.b((((z ? 1L : 0L) | (z2 ? 2L : 0L)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    static /* synthetic */ long b(float f, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return a(f, z, z2);
    }
}
