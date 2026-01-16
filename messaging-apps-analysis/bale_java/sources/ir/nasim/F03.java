package ir.nasim;

import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.E03;
import java.io.EOFException;

/* loaded from: classes2.dex */
public final class F03 {
    private final EW4 a = new EW4(10);

    public Metadata a(InterfaceC9845af2 interfaceC9845af2, E03.a aVar) {
        Metadata metadataE = null;
        int i = 0;
        while (true) {
            try {
                interfaceC9845af2.m(this.a.e(), 0, 10);
                this.a.S(0);
                if (this.a.I() != 4801587) {
                    break;
                }
                this.a.T(3);
                int iE = this.a.E();
                int i2 = iE + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a.e(), 0, bArr, 0, 10);
                    interfaceC9845af2.m(bArr, 10, iE);
                    metadataE = new E03(aVar).e(bArr, i2);
                } else {
                    interfaceC9845af2.h(iE);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        interfaceC9845af2.e();
        interfaceC9845af2.h(i);
        return metadataE;
    }
}
