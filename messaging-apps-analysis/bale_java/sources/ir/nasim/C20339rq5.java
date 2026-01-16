package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* renamed from: ir.nasim.rq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20339rq5 implements InterfaceC19139pq5 {
    public static final AbstractC5747Kq7.b e = AbstractC5747Kq7.b.b;
    private final ThreadLocal a;
    private final String b;
    private final Key c;
    private final int d;

    /* renamed from: ir.nasim.rq5$a */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mac initialValue() throws InvalidKeyException {
            try {
                Mac mac = (Mac) P82.c.a(C20339rq5.this.b);
                mac.init(C20339rq5.this.c);
                return mac;
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public C20339rq5(String str, Key key) throws GeneralSecurityException {
        a aVar = new a();
        this.a = aVar;
        if (!e.a()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.b = str;
        this.c = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                this.d = 20;
                break;
            case "HMACSHA224":
                this.d = 28;
                break;
            case "HMACSHA256":
                this.d = 32;
                break;
            case "HMACSHA384":
                this.d = 48;
                break;
            case "HMACSHA512":
                this.d = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        aVar.get();
    }

    @Override // ir.nasim.InterfaceC19139pq5
    public byte[] a(byte[] bArr, int i) throws IllegalStateException, InvalidAlgorithmParameterException {
        if (i > this.d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.a.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.a.get()).doFinal(), i);
    }
}
