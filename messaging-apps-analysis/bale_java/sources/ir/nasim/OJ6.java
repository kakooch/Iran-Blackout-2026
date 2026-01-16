package ir.nasim;

import android.graphics.Bitmap;
import android.util.Log;
import ir.nasim.InterfaceC9624aH2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class OJ6 implements InterfaceC9624aH2 {
    private static final String u = "OJ6";
    private int[] a;
    private final int[] b;
    private final InterfaceC9624aH2.a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private C21199tH2 l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    public OJ6(InterfaceC9624aH2.a aVar, C21199tH2 c21199tH2, ByteBuffer byteBuffer, int i) {
        this(aVar);
        p(c21199tH2, byteBuffer, i);
    }

    private int h(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.p + i; i9++) {
            byte[] bArr = this.i;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.a[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.p + i11; i12++) {
            byte[] bArr2 = this.i;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.a[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private void i(C19396qH2 c19396qH2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.j;
        int i6 = c19396qH2.d;
        int i7 = this.p;
        int i8 = i6 / i7;
        int i9 = c19396qH2.b / i7;
        int i10 = c19396qH2.c / i7;
        int i11 = c19396qH2.a / i7;
        boolean z = this.k == 0;
        int i12 = this.r;
        int i13 = this.q;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        Boolean bool = this.s;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            Boolean bool2 = bool;
            if (c19396qH2.e) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i15 = 4;
                    } else if (i18 == 3) {
                        i14 = 4;
                        i17 = i18;
                        i15 = 2;
                    } else if (i18 == 4) {
                        i17 = i18;
                        i15 = 1;
                        i14 = 2;
                    }
                    i17 = i18;
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i16 * i7 * c19396qH2.c;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i9;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i26;
                    }
                } else {
                    i5 = i9;
                    int i28 = ((i22 - i21) * i7) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i10;
                        if (i29 >= i22) {
                            break;
                        }
                        int iH = h(i24, i28, c19396qH2.c);
                        if (iH != 0) {
                            iArr[i29] = iH;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i29++;
                        i10 = i4;
                    }
                    bool = bool2;
                    i16++;
                    i9 = i5;
                    i8 = i;
                    i10 = i4;
                    i15 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i16++;
            i9 = i5;
            i8 = i;
            i10 = i4;
            i15 = i3;
        }
        Boolean bool3 = bool;
        if (this.s == null) {
            this.s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void j(C19396qH2 c19396qH2) {
        C19396qH2 c19396qH22 = c19396qH2;
        int[] iArr = this.j;
        int i = c19396qH22.d;
        int i2 = c19396qH22.b;
        int i3 = c19396qH22.c;
        int i4 = c19396qH22.a;
        boolean z = this.k == 0;
        int i5 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = c19396qH22.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            c19396qH22 = c19396qH2;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void k(C19396qH2 c19396qH2) {
        int i;
        int i2;
        short s;
        OJ6 oj6 = this;
        if (c19396qH2 != null) {
            oj6.d.position(c19396qH2.j);
        }
        if (c19396qH2 == null) {
            C21199tH2 c21199tH2 = oj6.l;
            i = c21199tH2.f;
            i2 = c21199tH2.g;
        } else {
            i = c19396qH2.c;
            i2 = c19396qH2.d;
        }
        int i3 = i * i2;
        byte[] bArr = oj6.i;
        if (bArr == null || bArr.length < i3) {
            oj6.i = oj6.c.b(i3);
        }
        byte[] bArr2 = oj6.i;
        if (oj6.f == null) {
            oj6.f = new short[4096];
        }
        short[] sArr = oj6.f;
        if (oj6.g == null) {
            oj6.g = new byte[4096];
        }
        byte[] bArr3 = oj6.g;
        if (oj6.h == null) {
            oj6.h = new byte[4097];
        }
        byte[] bArr4 = oj6.h;
        int iO = o();
        int i4 = 1 << iO;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iO + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = oj6.e;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int iN = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (iN == 0) {
                iN = n();
                if (iN <= 0) {
                    oj6.o = 3;
                    break;
                }
                i14 = 0;
            }
            i16 += (bArr5[i14] & 255) << i15;
            i14++;
            iN--;
            int i21 = i15 + 8;
            int i22 = i12;
            int i23 = i11;
            int i24 = i20;
            int i25 = i7;
            int i26 = i18;
            while (true) {
                if (i21 < i23) {
                    i20 = i24;
                    i12 = i22;
                    i15 = i21;
                    oj6 = this;
                    i18 = i26;
                    i7 = i25;
                    i11 = i23;
                    break;
                }
                int i27 = i6;
                int i28 = i16 & i13;
                i16 >>= i23;
                i21 -= i23;
                if (i28 == i4) {
                    i13 = i8;
                    i23 = i25;
                    i22 = i27;
                    i6 = i22;
                    i24 = -1;
                } else {
                    if (i28 == i5) {
                        i15 = i21;
                        i18 = i26;
                        i12 = i22;
                        i7 = i25;
                        i6 = i27;
                        i20 = i24;
                        i11 = i23;
                        oj6 = this;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i17] = bArr3[i28];
                        i17++;
                        i9++;
                        i24 = i28;
                        i26 = i24;
                        i6 = i27;
                        i21 = i21;
                    } else {
                        if (i28 >= i22) {
                            bArr4[i19] = (byte) i26;
                            i19++;
                            s = i24;
                        } else {
                            s = i28;
                        }
                        while (s >= i4) {
                            bArr4[i19] = bArr3[s];
                            i19++;
                            s = sArr[s];
                        }
                        i26 = bArr3[s] & 255;
                        byte b = (byte) i26;
                        bArr2[i17] = b;
                        while (true) {
                            i17++;
                            i9++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr2[i17] = bArr4[i19];
                        }
                        byte[] bArr6 = bArr4;
                        if (i22 < 4096) {
                            sArr[i22] = (short) i24;
                            bArr3[i22] = b;
                            i22++;
                            if ((i22 & i13) == 0 && i22 < 4096) {
                                i23++;
                                i13 += i22;
                            }
                        }
                        i24 = i28;
                        i6 = i27;
                        i21 = i21;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i17, i3, (byte) 0);
    }

    private Bitmap m() {
        Boolean bool = this.s;
        Bitmap bitmapC = this.c.c(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    private int n() {
        int iO = o();
        if (iO <= 0) {
            return iO;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(iO, byteBuffer.remaining()));
        return iO;
    }

    private int o() {
        return this.d.get() & 255;
    }

    private Bitmap q(C19396qH2 c19396qH2, C19396qH2 c19396qH22) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i3 = 0;
        if (c19396qH22 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.a(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (c19396qH22 != null && c19396qH22.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (c19396qH22 != null && (i2 = c19396qH22.g) > 0) {
            if (i2 == 2) {
                if (!c19396qH2.f) {
                    C21199tH2 c21199tH2 = this.l;
                    int i4 = c21199tH2.l;
                    if (c19396qH2.k == null || c21199tH2.j != c19396qH2.h) {
                        i3 = i4;
                    }
                }
                int i5 = c19396qH22.d;
                int i6 = this.p;
                int i7 = i5 / i6;
                int i8 = c19396qH22.b / i6;
                int i9 = c19396qH22.c / i6;
                int i10 = c19396qH22.a / i6;
                int i11 = this.r;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.r;
                }
            } else if (i2 == 3 && (bitmap = this.m) != null) {
                int i16 = this.r;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.q);
            }
        }
        k(c19396qH2);
        if (c19396qH2.e || this.p != 1) {
            i(c19396qH2);
        } else {
            j(c19396qH2);
        }
        if (this.n && ((i = c19396qH2.g) == 0 || i == 1)) {
            if (this.m == null) {
                this.m = m();
            }
            Bitmap bitmap3 = this.m;
            int i17 = this.r;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.q);
        }
        Bitmap bitmapM = m();
        int i18 = this.r;
        bitmapM.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        return bitmapM;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public void a() {
        this.k = (this.k + 1) % this.l.c;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public int b() {
        return this.l.c;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.c.e(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.c.a(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.e(bArr2);
        }
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public int d() {
        int i;
        if (this.l.c <= 0 || (i = this.k) < 0) {
            return 0;
        }
        return l(i);
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public void e() {
        this.k = -1;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public int f() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public int g() {
        return this.d.limit() + this.i.length + (this.j.length * 4);
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public ByteBuffer getData() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC9624aH2
    public synchronized Bitmap getNextFrame() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                String str = u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k);
                }
                this.o = 1;
            }
            int i = this.o;
            if (i != 1 && i != 2) {
                this.o = 0;
                if (this.e == null) {
                    this.e = this.c.b(255);
                }
                C19396qH2 c19396qH2 = (C19396qH2) this.l.e.get(this.k);
                int i2 = this.k - 1;
                C19396qH2 c19396qH22 = i2 >= 0 ? (C19396qH2) this.l.e.get(i2) : null;
                int[] iArr = c19396qH2.k;
                if (iArr == null) {
                    iArr = this.l.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    String str2 = u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.k);
                    }
                    this.o = 1;
                    return null;
                }
                if (c19396qH2.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[c19396qH2.h] = 0;
                    if (c19396qH2.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return q(c19396qH2, c19396qH22);
            }
            String str3 = u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int l(int i) {
        if (i >= 0) {
            C21199tH2 c21199tH2 = this.l;
            if (i < c21199tH2.c) {
                return ((C19396qH2) c21199tH2.e.get(i)).i;
            }
        }
        return -1;
    }

    public synchronized void p(C21199tH2 c21199tH2, ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int iHighestOneBit = Integer.highestOneBit(i);
            this.o = 0;
            this.l = c21199tH2;
            this.k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator it = c21199tH2.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((C19396qH2) it.next()).g == 3) {
                    this.n = true;
                    break;
                }
            }
            this.p = iHighestOneBit;
            int i2 = c21199tH2.f;
            this.r = i2 / iHighestOneBit;
            int i3 = c21199tH2.g;
            this.q = i3 / iHighestOneBit;
            this.i = this.c.b(i2 * i3);
            this.j = this.c.d(this.r * this.q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public OJ6(InterfaceC9624aH2.a aVar) {
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.l = new C21199tH2();
    }
}
