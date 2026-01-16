package ir.nasim;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: ir.nasim.ea6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12416ea6 extends J0 implements InterfaceC4984Hk0 {
    private int k;
    private int l;

    public C12416ea6() {
        super("stsd");
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public long f() {
        long jC = c();
        return 8 + jC + ((this.j || jC + 16 >= 4294967296L) ? 16 : 8);
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public void g(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(l());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        AbstractC5869Le3.j(byteBufferAllocate, this.k);
        AbstractC5869Le3.f(byteBufferAllocate, this.l);
        AbstractC5869Le3.g(byteBufferAllocate, b().size());
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        e(writableByteChannel);
    }
}
