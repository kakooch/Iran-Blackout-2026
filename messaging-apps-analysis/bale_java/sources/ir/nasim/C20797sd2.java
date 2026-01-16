package ir.nasim;

import ir.nasim.C16051kd2;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.sd2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20797sd2 extends FilterOutputStream {
    private static final byte[] g = "Exif\u0000\u0000".getBytes(C15460jd2.e);
    private final C16051kd2 a;
    private final byte[] b;
    private final ByteBuffer c;
    private int d;
    private int e;
    private int f;

    /* renamed from: ir.nasim.sd2$a */
    static final class a {
        public static boolean a(short s) {
            return (s < -64 || s > -49 || s == -60 || s == -56 || s == -52) ? false : true;
        }
    }

    public C20797sd2(OutputStream outputStream, C16051kd2 c16051kd2) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.b = new byte[1];
        this.c = ByteBuffer.allocate(4);
        this.d = 0;
        this.a = c16051kd2;
    }

    private int a(int i, byte[] bArr, int i2, int i3) {
        int iMin = Math.min(i3, i - this.c.position());
        this.c.put(bArr, i2, iMin);
        return iMin;
    }

    private void b(C5956Lo0 c5956Lo0) throws IOException {
        C22074ud2[][] c22074ud2Arr = C16051kd2.i;
        int[] iArr = new int[c22074ud2Arr.length];
        int[] iArr2 = new int[c22074ud2Arr.length];
        for (C22074ud2 c22074ud2 : C16051kd2.g) {
            for (int i = 0; i < C16051kd2.i.length; i++) {
                this.a.c(i).remove(c22074ud2.b);
            }
        }
        if (!this.a.c(1).isEmpty()) {
            this.a.c(0).put(C16051kd2.g[1].b, C15460jd2.f(0L, this.a.d()));
        }
        if (!this.a.c(2).isEmpty()) {
            this.a.c(0).put(C16051kd2.g[2].b, C15460jd2.f(0L, this.a.d()));
        }
        if (!this.a.c(3).isEmpty()) {
            this.a.c(1).put(C16051kd2.g[3].b, C15460jd2.f(0L, this.a.d()));
        }
        for (int i2 = 0; i2 < C16051kd2.i.length; i2++) {
            Iterator it = this.a.c(i2).entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int iJ = ((C15460jd2) ((Map.Entry) it.next()).getValue()).j();
                if (iJ > 4) {
                    i3 += iJ;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int size = 8;
        for (int i4 = 0; i4 < C16051kd2.i.length; i4++) {
            if (!this.a.c(i4).isEmpty()) {
                iArr[i4] = size;
                size += (this.a.c(i4).size() * 12) + 6 + iArr2[i4];
            }
        }
        int i5 = size + 8;
        if (!this.a.c(1).isEmpty()) {
            this.a.c(0).put(C16051kd2.g[1].b, C15460jd2.f(iArr[1], this.a.d()));
        }
        if (!this.a.c(2).isEmpty()) {
            this.a.c(0).put(C16051kd2.g[2].b, C15460jd2.f(iArr[2], this.a.d()));
        }
        if (!this.a.c(3).isEmpty()) {
            this.a.c(1).put(C16051kd2.g[3].b, C15460jd2.f(iArr[3], this.a.d()));
        }
        c5956Lo0.g(i5);
        c5956Lo0.write(g);
        c5956Lo0.d(this.a.d() == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        c5956Lo0.a(this.a.d());
        c5956Lo0.g(42);
        c5956Lo0.e(8L);
        for (int i6 = 0; i6 < C16051kd2.i.length; i6++) {
            if (!this.a.c(i6).isEmpty()) {
                c5956Lo0.g(this.a.c(i6).size());
                int size2 = iArr[i6] + 2 + (this.a.c(i6).size() * 12) + 4;
                for (Map.Entry entry : this.a.c(i6).entrySet()) {
                    int i7 = ((C22074ud2) AbstractC4980Hj5.h((C22074ud2) ((HashMap) C16051kd2.b.f.get(i6)).get(entry.getKey()), "Tag not supported: " + ((String) entry.getKey()) + ". Tag needs to be ported from ExifInterface to ExifData.")).a;
                    C15460jd2 c15460jd2 = (C15460jd2) entry.getValue();
                    int iJ2 = c15460jd2.j();
                    c5956Lo0.g(i7);
                    c5956Lo0.g(c15460jd2.a);
                    c5956Lo0.c(c15460jd2.b);
                    if (iJ2 > 4) {
                        c5956Lo0.e(size2);
                        size2 += iJ2;
                    } else {
                        c5956Lo0.write(c15460jd2.d);
                        if (iJ2 < 4) {
                            while (iJ2 < 4) {
                                c5956Lo0.b(0);
                                iJ2++;
                            }
                        }
                    }
                }
                c5956Lo0.e(0L);
                Iterator it2 = this.a.c(i6).entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((C15460jd2) ((Map.Entry) it2.next()).getValue()).d;
                    if (bArr.length > 4) {
                        c5956Lo0.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        c5956Lo0.a(ByteOrder.BIG_ENDIAN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
    
        if (r9 <= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
    
        ((java.io.FilterOutputStream) r6).out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20797sd2.write(byte[], int, int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
