package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: ir.nasim.cb2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11015cb2 extends NC6 {
    @Override // ir.nasim.NC6
    protected Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer) {
        return new Metadata(c(new EW4(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(EW4 ew4) {
        return new EventMessage((String) AbstractC20011rK.e(ew4.z()), (String) AbstractC20011rK.e(ew4.z()), ew4.y(), ew4.y(), Arrays.copyOfRange(ew4.e(), ew4.f(), ew4.g()));
    }
}
