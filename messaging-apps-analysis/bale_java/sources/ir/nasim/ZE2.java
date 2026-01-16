package ir.nasim;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public abstract class ZE2 implements InterfaceC18799pG5 {
    private final SecureRandom a = new SecureRandom();

    @Override // ir.nasim.InterfaceC18799pG5
    public void a(byte[] bArr) {
        synchronized (this.a) {
            this.a.nextBytes(bArr);
        }
    }

    @Override // ir.nasim.InterfaceC18799pG5
    public byte[] b(int i) {
        byte[] bArr = new byte[i];
        synchronized (this.a) {
            this.a.nextBytes(bArr);
        }
        return bArr;
    }
}
