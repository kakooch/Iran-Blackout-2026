package ir.nasim;

import ir.nasim.C4092Dq5;
import ir.nasim.InterfaceC7584Si4;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class KJ1 implements InterfaceC5277Iq5 {
    private static final KJ1 a = new KJ1();

    private static class a implements GJ1 {
        private final C4092Dq5 a;
        private final InterfaceC7584Si4.a b;
        private final InterfaceC7584Si4.a c;

        public a(C4092Dq5 c4092Dq5) {
            this.a = c4092Dq5;
            if (!c4092Dq5.j()) {
                InterfaceC7584Si4.a aVar = AbstractC14322hj4.a;
                this.b = aVar;
                this.c = aVar;
            } else {
                InterfaceC7584Si4 interfaceC7584Si4A = C24532ym4.b().a();
                C9066Yi4 c9066Yi4A = AbstractC14322hj4.a(c4092Dq5);
                this.b = interfaceC7584Si4A.a(c9066Yi4A, "daead", "encrypt");
                this.c = interfaceC7584Si4A.a(c9066Yi4A, "daead", "decrypt");
            }
        }

        @Override // ir.nasim.GJ1
        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrA = AbstractC8841Xo0.a(this.a.f().b(), ((GJ1) this.a.f().g()).a(bArr, bArr2));
                this.b.a(this.a.f().d(), bArr.length);
                return bArrA;
            } catch (GeneralSecurityException e) {
                this.b.b();
                throw e;
            }
        }

        @Override // ir.nasim.GJ1
        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (C4092Dq5.c cVar : this.a.g(bArrCopyOf)) {
                    try {
                        byte[] bArrB = ((GJ1) cVar.g()).b(bArrCopyOfRange, bArr2);
                        this.c.a(cVar.d(), bArrCopyOfRange.length);
                        return bArrB;
                    } catch (GeneralSecurityException unused) {
                    }
                }
            }
            for (C4092Dq5.c cVar2 : this.a.i()) {
                try {
                    byte[] bArrB2 = ((GJ1) cVar2.g()).b(bArr, bArr2);
                    this.c.a(cVar2.d(), bArr.length);
                    return bArrB2;
                } catch (GeneralSecurityException unused2) {
                }
            }
            this.c.b();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    KJ1() {
    }

    public static void d() {
        AbstractC24881zM5.i(a);
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class a() {
        return GJ1.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class b() {
        return GJ1.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public GJ1 c(C4092Dq5 c4092Dq5) {
        return new a(c4092Dq5);
    }
}
