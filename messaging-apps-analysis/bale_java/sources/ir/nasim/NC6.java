package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class NC6 implements InterfaceC22086ue4 {
    @Override // ir.nasim.InterfaceC22086ue4
    public final Metadata a(C24452ye4 c24452ye4) {
        ByteBuffer byteBuffer = (ByteBuffer) AbstractC20011rK.e(c24452ye4.c);
        AbstractC20011rK.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (c24452ye4.t()) {
            return null;
        }
        return b(c24452ye4, byteBuffer);
    }

    protected abstract Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer);
}
