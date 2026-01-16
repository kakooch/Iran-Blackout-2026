package ir.nasim;

import com.google.android.gms.internal.vision.C2162b0;

/* renamed from: ir.nasim.mp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17359mp8 implements InterfaceC21630tr8 {
    @Override // ir.nasim.InterfaceC21630tr8
    public final /* synthetic */ InterfaceC21630tr8 J0(InterfaceC18561or8 interfaceC18561or8) {
        if (l().getClass().isInstance(interfaceC18561or8)) {
            return c((com.google.android.gms.internal.vision.D) interfaceC18561or8);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    protected abstract AbstractC17359mp8 c(com.google.android.gms.internal.vision.D d);

    public abstract AbstractC17359mp8 d(byte[] bArr, int i, int i2, C2162b0 c2162b0);
}
