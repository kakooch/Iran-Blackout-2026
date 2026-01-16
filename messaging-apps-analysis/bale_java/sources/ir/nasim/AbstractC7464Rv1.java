package ir.nasim;

/* renamed from: ir.nasim.Rv1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7464Rv1 {
    private static final InterfaceC10017aw1 a = new C10634bw1();
    private static final InterfaceC18799pG5 b = new C19390qG5();

    public static byte[] a(InterfaceC11073ch0 interfaceC11073ch0, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i += 16) {
            interfaceC11073ch0.c(bArr, i, bArr2, i);
        }
        int i2 = length - 1;
        int i3 = bArr2[i2] & 255;
        if (i3 < 0 || i3 >= 16) {
            return null;
        }
        int i4 = i2 - i3;
        if (!new C20088rS4().a(bArr2, i4, i3)) {
            return null;
        }
        byte[] bArr3 = new byte[i4];
        AbstractC8107Uo0.i(bArr3, 0, bArr2, 0, i4);
        return bArr3;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32 && bArr2 != null) {
            return a(g(bArr), bArr2);
        }
        return null;
    }

    public static byte[] c(InterfaceC11073ch0 interfaceC11073ch0, byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        C20088rS4 c20088rS4 = new C20088rS4();
        int length = (bArr.length + 1) % 16 == 0 ? 0 : 16 - ((bArr.length + 1) % 16);
        int length2 = bArr.length + 1 + length;
        byte[] bArr2 = new byte[length2];
        AbstractC8107Uo0.i(bArr2, 0, bArr, 0, bArr.length);
        bArr2[length2 - 1] = (byte) length;
        c20088rS4.b(bArr2, bArr.length, length);
        byte[] bArr3 = new byte[length2];
        for (int i = 0; i < length2; i += 16) {
            interfaceC11073ch0.b(bArr2, i, bArr3, i);
        }
        return bArr3;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length == 0 || bArr == null || bArr.length != 32) {
            return null;
        }
        return c(g(bArr), bArr2);
    }

    public static byte[] e(byte[] bArr) {
        C21910uL3 c21910uL3 = new C21910uL3();
        c21910uL3.c(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[16];
        c21910uL3.a(bArr2, 0);
        return bArr2;
    }

    public static byte[] f(byte[] bArr) {
        CT1 ct1H = h();
        ct1H.c(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[32];
        ct1H.a(bArr2, 0);
        return bArr2;
    }

    public static InterfaceC11073ch0 g(byte[] bArr) {
        return a.a(bArr);
    }

    public static CT1 h() {
        return a.b();
    }

    public static String i(byte[] bArr) {
        return AbstractC22589vV2.c(bArr);
    }

    public static void j(byte[] bArr) {
        b.a(bArr);
    }

    public static byte[] k(int i) {
        return b.b(i);
    }
}
