package ir.nasim;

import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import java.util.Hashtable;

/* loaded from: classes8.dex */
public class WS2 {
    private static Hashtable h;
    private BT1 a;
    private int b;
    private int c;
    private H34 d;
    private H34 e;
    private byte[] f;
    private byte[] g;

    static {
        Hashtable hashtable = new Hashtable();
        h = hashtable;
        hashtable.put("GOST3411", AbstractC7748Ta3.a(32));
        h.put("MD2", AbstractC7748Ta3.a(16));
        h.put("MD4", AbstractC7748Ta3.a(64));
        h.put(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM, AbstractC7748Ta3.a(64));
        h.put("RIPEMD128", AbstractC7748Ta3.a(64));
        h.put("RIPEMD160", AbstractC7748Ta3.a(64));
        h.put("SHA-1", AbstractC7748Ta3.a(64));
        h.put("SHA-224", AbstractC7748Ta3.a(64));
        h.put("SHA-256", AbstractC7748Ta3.a(64));
        h.put("SHA-384", AbstractC7748Ta3.a(128));
        h.put("SHA-512", AbstractC7748Ta3.a(128));
        h.put("Tiger", AbstractC7748Ta3.a(64));
        h.put("Whirlpool", AbstractC7748Ta3.a(64));
    }

    public WS2(BT1 bt1) {
        this(bt1, b(bt1));
    }

    private static int b(BT1 bt1) {
        if (bt1 instanceof InterfaceC4698Ge2) {
            return ((InterfaceC4698Ge2) bt1).g();
        }
        Integer num = (Integer) h.get(bt1.e());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + bt1.e());
    }

    private static void f(byte[] bArr, int i, byte b) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b);
        }
    }

    public int a(byte[] bArr, int i) {
        this.a.a(this.g, this.c);
        H34 h34 = this.e;
        if (h34 != null) {
            ((H34) this.a).f(h34);
            BT1 bt1 = this.a;
            bt1.c(this.g, this.c, bt1.b());
        } else {
            BT1 bt12 = this.a;
            byte[] bArr2 = this.g;
            bt12.c(bArr2, 0, bArr2.length);
        }
        int iA = this.a.a(bArr, i);
        int i2 = this.c;
        while (true) {
            byte[] bArr3 = this.g;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        H34 h342 = this.d;
        if (h342 != null) {
            ((H34) this.a).f(h342);
        } else {
            BT1 bt13 = this.a;
            byte[] bArr4 = this.f;
            bt13.c(bArr4, 0, bArr4.length);
        }
        return iA;
    }

    public void c(TT0 tt0) {
        byte[] bArr;
        this.a.reset();
        byte[] bArrA = ((C4540Fo3) tt0).a();
        int length = bArrA.length;
        if (length > this.c) {
            this.a.c(bArrA, 0, length);
            this.a.a(this.f, 0);
            length = this.b;
        } else {
            System.arraycopy(bArrA, 0, this.f, 0, length);
        }
        while (true) {
            bArr = this.f;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.g, 0, this.c);
        f(this.f, this.c, (byte) 54);
        f(this.g, this.c, (byte) 92);
        BT1 bt1 = this.a;
        if (bt1 instanceof H34) {
            H34 h34D = ((H34) bt1).d();
            this.e = h34D;
            ((BT1) h34D).c(this.g, 0, this.c);
        }
        BT1 bt12 = this.a;
        byte[] bArr2 = this.f;
        bt12.c(bArr2, 0, bArr2.length);
        BT1 bt13 = this.a;
        if (bt13 instanceof H34) {
            this.d = ((H34) bt13).d();
        }
    }

    public void d() {
        this.a.reset();
        BT1 bt1 = this.a;
        byte[] bArr = this.f;
        bt1.c(bArr, 0, bArr.length);
    }

    public void e(byte[] bArr, int i, int i2) {
        this.a.c(bArr, i, i2);
    }

    private WS2(BT1 bt1, int i) {
        this.a = bt1;
        int iB = bt1.b();
        this.b = iB;
        this.c = i;
        this.f = new byte[i];
        this.g = new byte[i + iB];
    }
}
