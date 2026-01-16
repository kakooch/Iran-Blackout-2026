package ir.nasim;

import ir.nasim.InterfaceC4589Ft7;
import java.io.EOFException;

/* loaded from: classes2.dex */
public final class P12 implements InterfaceC4589Ft7 {
    private final byte[] a = new byte[4096];

    @Override // ir.nasim.InterfaceC4589Ft7
    public void a(EW4 ew4, int i, int i2) {
        ew4.T(i);
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public int e(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z, int i2) throws EOFException {
        int i3 = interfaceC18631oz1.read(this.a, 0, Math.min(this.a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public void c(com.google.android.exoplayer2.X x) {
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public void b(long j, int i, int i2, int i3, InterfaceC4589Ft7.a aVar) {
    }
}
