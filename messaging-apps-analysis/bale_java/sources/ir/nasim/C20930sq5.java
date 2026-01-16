package ir.nasim;

import ir.nasim.C23802xY2;
import ir.nasim.C6373Ni;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.sq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20930sq5 implements WL3 {
    private static final byte[] e = {0};
    private final InterfaceC19139pq5 a;
    private final int b;
    private final byte[] c;
    private final byte[] d;

    public C20930sq5(InterfaceC19139pq5 interfaceC19139pq5, int i) throws InvalidAlgorithmParameterException {
        this.a = interfaceC19139pq5;
        this.b = i;
        this.c = new byte[0];
        this.d = new byte[0];
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        interfaceC19139pq5.a(new byte[0], i);
    }

    public static WL3 c(C4965Hi c4965Hi) {
        return new C20930sq5(c4965Hi);
    }

    public static WL3 d(C20140rY2 c20140rY2) {
        return new C20930sq5(c20140rY2);
    }

    @Override // ir.nasim.WL3
    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!AbstractC8841Xo0.b(b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // ir.nasim.WL3
    public byte[] b(byte[] bArr) {
        byte[] bArr2 = this.d;
        return bArr2.length > 0 ? AbstractC8841Xo0.a(this.c, this.a.a(AbstractC8841Xo0.a(bArr, bArr2), this.b)) : AbstractC8841Xo0.a(this.c, this.a.a(bArr, this.b));
    }

    private C20930sq5(C4965Hi c4965Hi) {
        this.a = new C19730qq5(c4965Hi.d().c(J93.a()));
        this.b = c4965Hi.b().c();
        this.c = c4965Hi.a().d();
        if (c4965Hi.b().f().equals(C6373Ni.c.d)) {
            byte[] bArr = e;
            this.d = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.d = new byte[0];
        }
    }

    private C20930sq5(C20140rY2 c20140rY2) {
        this.a = new C20339rq5("HMAC" + c20140rY2.b().d(), new SecretKeySpec(c20140rY2.d().c(J93.a()), "HMAC"));
        this.b = c20140rY2.b().c();
        this.c = c20140rY2.a().d();
        if (c20140rY2.b().g().equals(C23802xY2.d.d)) {
            byte[] bArr = e;
            this.d = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.d = new byte[0];
        }
    }
}
