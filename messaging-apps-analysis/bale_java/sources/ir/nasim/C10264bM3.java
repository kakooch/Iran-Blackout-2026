package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC23983xq5;
import ir.nasim.C4092Dq5;
import ir.nasim.InterfaceC7584Si4;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bM3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C10264bM3 implements InterfaceC5277Iq5 {
    private static final C10264bM3 a = new C10264bM3();
    private static final AbstractC23983xq5 b = AbstractC23983xq5.b(new AbstractC23983xq5.b() { // from class: ir.nasim.aM3
        @Override // ir.nasim.AbstractC23983xq5.b
        public final Object a(AbstractC14981io3 abstractC14981io3) {
            return C23468wy3.c((C6048Ly3) abstractC14981io3);
        }
    }, C6048Ly3.class, WL3.class);

    /* renamed from: ir.nasim.bM3$b */
    private static class b implements WL3 {
        private final C4092Dq5 a;
        private final InterfaceC7584Si4.a b;
        private final InterfaceC7584Si4.a c;

        @Override // ir.nasim.WL3
        public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length <= 5) {
                this.c.b();
                throw new GeneralSecurityException("tag too short");
            }
            for (C4092Dq5.c cVar : this.a.g(Arrays.copyOf(bArr, 5))) {
                try {
                    ((WL3) cVar.a()).a(bArr, bArr2);
                    this.c.a(cVar.d(), bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            for (C4092Dq5.c cVar2 : this.a.i()) {
                try {
                    ((WL3) cVar2.a()).a(bArr, bArr2);
                    this.c.a(cVar2.d(), bArr2.length);
                    return;
                } catch (GeneralSecurityException unused2) {
                }
            }
            this.c.b();
            throw new GeneralSecurityException("invalid MAC");
        }

        @Override // ir.nasim.WL3
        public byte[] b(byte[] bArr) throws GeneralSecurityException {
            try {
                byte[] bArrB = ((WL3) this.a.f().a()).b(bArr);
                this.b.a(this.a.f().d(), bArr.length);
                return bArrB;
            } catch (GeneralSecurityException e) {
                this.b.b();
                throw e;
            }
        }

        private b(C4092Dq5 c4092Dq5) {
            this.a = c4092Dq5;
            if (!c4092Dq5.j()) {
                InterfaceC7584Si4.a aVar = AbstractC14322hj4.a;
                this.b = aVar;
                this.c = aVar;
            } else {
                InterfaceC7584Si4 interfaceC7584Si4A = C24532ym4.b().a();
                C9066Yi4 c9066Yi4A = AbstractC14322hj4.a(c4092Dq5);
                this.b = interfaceC7584Si4A.a(c9066Yi4A, "mac", "compute");
                this.c = interfaceC7584Si4A.a(c9066Yi4A, "mac", "verify");
            }
        }
    }

    C10264bM3() {
    }

    public static void d() {
        AbstractC24881zM5.i(a);
        C5006Hm4.c().d(b);
    }

    private void e(C4092Dq5 c4092Dq5) throws GeneralSecurityException {
        Iterator it = c4092Dq5.d().iterator();
        while (it.hasNext()) {
            for (C4092Dq5.c cVar : (List) it.next()) {
                if (cVar.c() instanceof YL3) {
                    YL3 yl3 = (YL3) cVar.c();
                    C8575Wo0 c8575Wo0A = C8575Wo0.a(cVar.b());
                    if (!c8575Wo0A.equals(yl3.a())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + yl3.b() + " has wrong output prefix (" + yl3.a() + ") instead of (" + c8575Wo0A + Separators.RPAREN);
                    }
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class a() {
        return WL3.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    public Class b() {
        return WL3.class;
    }

    @Override // ir.nasim.InterfaceC5277Iq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public WL3 c(C4092Dq5 c4092Dq5) throws GeneralSecurityException {
        e(c4092Dq5);
        return new b(c4092Dq5);
    }
}
