package ir.nasim;

/* renamed from: ir.nasim.be8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10461be8 {
    static void a(Vd8 vd8, Vd8 vd82, int i) {
        AbstractC18421od8.a(vd8.a, vd82.a, i);
        AbstractC18421od8.a(vd8.b, vd82.b, i);
        AbstractC18421od8.a(vd8.c, vd82.c, i);
    }

    static int b(byte b, byte b2) {
        return ((b ^ b2) - 1) >>> 31;
    }

    public static void c(Qd8 qd8, byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        Kd8 kd8 = new Kd8();
        Nd8 nd8 = new Nd8();
        Vd8 vd8 = new Vd8();
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) ((bArr[i2] >>> 4) & 15);
            i2++;
        }
        int i4 = 0;
        byte b = 0;
        while (i4 < 63) {
            byte b2 = (byte) (bArr2[i4] + b);
            bArr2[i4] = b2;
            byte b3 = (byte) (((byte) (b2 + 8)) >> 4);
            bArr2[i4] = (byte) (b2 - (b3 << 4));
            i4++;
            b = b3;
        }
        bArr2[63] = (byte) (bArr2[63] + b);
        Rd8.a(qd8);
        for (i = 1; i < 64; i += 2) {
            e(vd8, i / 2, bArr2[i]);
            Id8.a(kd8, qd8, vd8);
            Md8.a(qd8, kd8);
        }
        Sd8.a(kd8, qd8);
        Ld8.a(nd8, kd8);
        Pd8.a(kd8, nd8);
        Ld8.a(nd8, kd8);
        Pd8.a(kd8, nd8);
        Ld8.a(nd8, kd8);
        Pd8.a(kd8, nd8);
        Md8.a(qd8, kd8);
        for (int i5 = 0; i5 < 64; i5 += 2) {
            e(vd8, i5 / 2, bArr2[i5]);
            Id8.a(kd8, qd8, vd8);
            Md8.a(qd8, kd8);
        }
    }

    static int d(byte b) {
        return (int) (b >>> 63);
    }

    static void e(Vd8 vd8, int i, byte b) {
        Vd8[][] vd8Arr = i <= 7 ? Xd8.a : i <= 15 ? AbstractC9841ae8.a : i <= 23 ? Yd8.a : Zd8.a;
        Vd8 vd82 = new Vd8();
        int iD = d(b);
        Wd8.a(vd8);
        byte b2 = (byte) (b - (((-iD) & b) << 1));
        a(vd8, vd8Arr[i][0], b(b2, (byte) 1));
        a(vd8, vd8Arr[i][1], b(b2, (byte) 2));
        a(vd8, vd8Arr[i][2], b(b2, (byte) 3));
        a(vd8, vd8Arr[i][3], b(b2, (byte) 4));
        a(vd8, vd8Arr[i][4], b(b2, (byte) 5));
        a(vd8, vd8Arr[i][5], b(b2, (byte) 6));
        a(vd8, vd8Arr[i][6], b(b2, (byte) 7));
        a(vd8, vd8Arr[i][7], b(b2, (byte) 8));
        AbstractC19012pd8.a(vd82.a, vd8.b);
        AbstractC19012pd8.a(vd82.b, vd8.a);
        AbstractC23856xd8.a(vd82.c, vd8.c);
        a(vd8, vd82, iD);
    }
}
