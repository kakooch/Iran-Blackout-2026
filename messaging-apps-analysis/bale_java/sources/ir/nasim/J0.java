package ir.nasim;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes3.dex */
public abstract class J0 extends AbstractC20202rd0 implements InterfaceC4984Hk0 {
    InterfaceC12511ek1 h;
    protected String i;
    protected boolean j;

    public J0(String str) {
        this.i = str;
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public long f() {
        long jC = c();
        return jC + ((this.j || 8 + jC >= 4294967296L) ? 16 : 8);
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public void g(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(l());
        e(writableByteChannel);
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public void k(InterfaceC12511ek1 interfaceC12511ek1) {
        this.h = interfaceC12511ek1;
    }

    protected ByteBuffer l() {
        ByteBuffer byteBufferWrap;
        if (this.j || f() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.i.getBytes()[0];
            bArr[5] = this.i.getBytes()[1];
            bArr[6] = this.i.getBytes()[2];
            bArr[7] = this.i.getBytes()[3];
            byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(8);
            AbstractC5869Le3.i(byteBufferWrap, f());
        } else {
            byteBufferWrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.i.getBytes()[0], this.i.getBytes()[1], this.i.getBytes()[2], this.i.getBytes()[3]});
            AbstractC5869Le3.g(byteBufferWrap, f());
        }
        byteBufferWrap.rewind();
        return byteBufferWrap;
    }
}
