package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.features.audioplayer.audioinfo.mp3.MP3Exception;

/* renamed from: ir.nasim.zL3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24870zL3 {
    private final byte[] a;
    private final b b;

    /* renamed from: ir.nasim.zL3$a */
    static final class a {
        private short a = -1;

        a() {
        }

        public short a() {
            return this.a;
        }

        public void b(byte b) {
            c(b, 8);
        }

        public void c(int i, int i2) {
            int i3 = 1 << (i2 - 1);
            do {
                short s = this.a;
                if (((Short.MIN_VALUE & s) == 0) ^ ((i & i3) == 0)) {
                    this.a = (short) (((short) (s << 1)) ^ 32773);
                } else {
                    this.a = (short) (s << 1);
                }
                i3 >>>= 1;
            } while (i3 != 0);
        }
    }

    /* renamed from: ir.nasim.zL3$b */
    public static class b {
        private static final int[][] h = {new int[]{11025, -1, 22050, 44100}, new int[]{12000, -1, 24000, 48000}, new int[]{8000, -1, 16000, 32000}, new int[]{-1, -1, -1, -1}};
        private static final int[][] i = {new int[]{0, 0, 0, 0, 0}, new int[]{32000, 32000, 32000, 32000, 8000}, new int[]{64000, 48000, 40000, 48000, 16000}, new int[]{96000, 56000, 48000, 56000, 24000}, new int[]{128000, 64000, 56000, 64000, 32000}, new int[]{160000, 80000, 64000, 80000, 40000}, new int[]{192000, 96000, 80000, 96000, 48000}, new int[]{224000, 112000, 96000, 112000, 56000}, new int[]{256000, 128000, 112000, 128000, 64000}, new int[]{288000, 160000, 128000, 144000, 80000}, new int[]{320000, 192000, 160000, 160000, 96000}, new int[]{352000, 224000, 192000, 176000, 112000}, new int[]{384000, 256000, 224000, 192000, 128000}, new int[]{416000, 320000, 256000, 224000, 144000}, new int[]{448000, 384000, 320000, 256000, 160000}, new int[]{-1, -1, -1, -1, -1}};
        private static final int[][] j = {new int[]{-1, 4, 4, 3}, new int[]{-1, -1, -1, -1}, new int[]{-1, 4, 4, 3}, new int[]{-1, 2, 1, 0}};
        private static final int[][] k = {new int[]{-1, 72, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 12}, new int[]{-1, -1, -1, -1}, new int[]{-1, 72, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 12}, new int[]{-1, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 12}};
        private static final int[] l = {-1, 1, 1, 4};
        private static final int[][] m = {new int[]{17, -1, 17, 32}, new int[]{17, -1, 17, 32}, new int[]{17, -1, 17, 32}, new int[]{9, -1, 9, 17}};
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public b(int i2, int i3, int i4) throws MP3Exception {
            int i5 = (i2 >> 3) & 3;
            this.a = i5;
            if (i5 == 1) {
                throw new MP3Exception("Reserved version");
            }
            int i6 = (i2 >> 1) & 3;
            this.b = i6;
            if (i6 == 0) {
                throw new MP3Exception("Reserved layer");
            }
            int i7 = (i3 >> 4) & 15;
            this.d = i7;
            if (i7 == 15) {
                throw new MP3Exception("Reserved bitrate");
            }
            if (i7 == 0) {
                throw new MP3Exception("Free bitrate");
            }
            int i8 = (i3 >> 2) & 3;
            this.c = i8;
            if (i8 == 3) {
                throw new MP3Exception("Reserved frequency");
            }
            this.e = (i4 >> 6) & 3;
            this.f = (i3 >> 1) & 1;
            int i9 = i2 & 1;
            this.g = i9;
            int i10 = i9 != 0 ? 4 : 6;
            i10 = i6 == 1 ? i10 + i() : i10;
            if (d() >= i10) {
                return;
            }
            throw new MP3Exception("Frame size must be at least " + i10);
        }

        public int a() {
            return i[this.d][j[this.a][this.b]];
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return (int) j(d());
        }

        public int d() {
            return (((k[this.a][this.b] * a()) / e()) + this.f) * l[this.b];
        }

        public int e() {
            return h[this.c][this.a];
        }

        public int f() {
            return this.b;
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.b == 3 ? 384 : 1152;
        }

        public int i() {
            return m[this.e][this.a];
        }

        public long j(long j2) {
            long jH = ((h() * j2) * 1000) / (d() * e());
            return (l() == 3 || b() != 3) ? jH : jH / 2;
        }

        public int k() {
            return 36;
        }

        public int l() {
            return this.a;
        }

        public int m() {
            return i() + 4;
        }

        public boolean n(b bVar) {
            return this.b == bVar.b && this.a == bVar.a && this.c == bVar.c && this.e == bVar.e;
        }
    }

    C24870zL3(b bVar, byte[] bArr) {
        this.b = bVar;
        this.a = bArr;
    }

    public b a() {
        return this.b;
    }

    public int b() {
        int i;
        byte b2;
        if (f()) {
            int iM = this.b.m();
            byte[] bArr = this.a;
            if ((bArr[iM + 7] & 1) == 0) {
                return -1;
            }
            i = ((bArr[iM + 8] & 255) << 24) | ((bArr[iM + 9] & 255) << 16) | ((bArr[iM + 10] & 255) << 8);
            b2 = bArr[iM + 11];
        } else {
            if (!e()) {
                return -1;
            }
            int iK = this.b.k();
            byte[] bArr2 = this.a;
            i = ((bArr2[iK + 14] & 255) << 24) | ((bArr2[iK + 15] & 255) << 16) | ((bArr2[iK + 16] & 255) << 8);
            b2 = bArr2[iK + 17];
        }
        return (b2 & 255) | i;
    }

    public int c() {
        return this.a.length;
    }

    boolean d() {
        if (this.b.g() != 0 || this.b.f() != 1) {
            return false;
        }
        a aVar = new a();
        aVar.b(this.a[2]);
        aVar.b(this.a[3]);
        int i = this.b.i();
        for (int i2 = 0; i2 < i; i2++) {
            aVar.b(this.a[i2 + 6]);
        }
        byte[] bArr = this.a;
        return ((bArr[5] & 255) | ((bArr[4] & 255) << 8)) != aVar.a();
    }

    boolean e() {
        int iK = this.b.k();
        byte[] bArr = this.a;
        return bArr.length >= iK + 26 && bArr[iK] == 86 && bArr[iK + 1] == 66 && bArr[iK + 2] == 82 && bArr[iK + 3] == 73;
    }

    boolean f() {
        int iM = this.b.m();
        byte[] bArr = this.a;
        if (bArr.length >= iM + 12 && iM >= 0 && bArr.length >= iM + 8) {
            byte b2 = bArr[iM];
            if (b2 == 88 && bArr[iM + 1] == 105 && bArr[iM + 2] == 110 && bArr[iM + 3] == 103) {
                return true;
            }
            if (b2 == 73 && bArr[iM + 1] == 110 && bArr[iM + 2] == 102 && bArr[iM + 3] == 111) {
                return true;
            }
        }
        return false;
    }
}
