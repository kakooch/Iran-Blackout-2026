package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.media.MediaFormat;
import ir.nasim.C22239ut7;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.ut7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22239ut7 {
    private static Map r;
    private long a;
    private int[] d;
    private String e;
    private AbstractC17467n1 f;
    private C12416ea6 g;
    private LinkedList h;
    private int i;
    private int k;
    private int l;
    private float m;
    private long[] n;
    private boolean p;
    private ArrayList b = new ArrayList();
    private long c = 0;
    private Date j = new Date();
    private ArrayList o = new ArrayList();
    private boolean q = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.ut7$a */
    static class a {
        private int a;
        private long b;
        private long c;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    static {
        HashMap map = new HashMap();
        r = map;
        map.put(96000, 0);
        r.put(88200, 1);
        r.put(64000, 2);
        r.put(48000, 3);
        r.put(44100, 4);
        r.put(32000, 5);
        r.put(24000, 6);
        r.put(22050, 7);
        r.put(16000, 8);
        r.put(12000, 9);
        r.put(11025, 10);
        r.put(8000, 11);
    }

    public C22239ut7(int i, MediaFormat mediaFormat, boolean z) {
        this.h = null;
        this.m = 0.0f;
        this.a = i;
        this.p = z;
        if (z) {
            this.m = 1.0f;
            this.i = mediaFormat.getInteger("sample-rate");
            this.e = "soun";
            this.f = new HH6();
            this.g = new C12416ea6();
            C17692nP c17692nP = new C17692nP("mp4a");
            c17692nP.q(mediaFormat.getInteger("channel-count"));
            c17692nP.s(mediaFormat.getInteger("sample-rate"));
            c17692nP.m(1);
            c17692nP.u(16);
            H22 h22 = new H22();
            G22 g22 = new G22();
            g22.i(0);
            M76 m76 = new M76();
            m76.h(2);
            g22.j(m76);
            String string = mediaFormat.containsKey("mime") ? mediaFormat.getString("mime") : "audio/mp4-latm";
            IB1 ib1 = new IB1();
            if ("audio/mpeg".equals(string)) {
                ib1.l(105);
            } else {
                ib1.l(64);
            }
            ib1.m(5);
            ib1.j(1536);
            if (mediaFormat.containsKey("max-bitrate")) {
                ib1.k(mediaFormat.getInteger("max-bitrate"));
            } else {
                ib1.k(96000L);
            }
            ib1.i(this.i);
            C18283oP c18283oP = new C18283oP();
            c18283oP.p(2);
            c18283oP.r(((Integer) r.get(Integer.valueOf((int) c17692nP.p()))).intValue());
            c18283oP.q(c17692nP.n());
            ib1.h(c18283oP);
            g22.h(ib1);
            h22.u(g22.f());
            c17692nP.a(h22);
            this.g.a(c17692nP);
            return;
        }
        this.l = mediaFormat.getInteger("width");
        this.k = mediaFormat.getInteger("height");
        this.i = 90000;
        this.h = new LinkedList();
        this.e = "vide";
        this.f = new BT7();
        this.g = new C12416ea6();
        String string2 = mediaFormat.getString("mime");
        if (!string2.equals("video/avc")) {
            if (string2.equals("video/mp4v")) {
                OY7 oy7 = new OY7("mp4v");
                oy7.m(1);
                oy7.z(24);
                oy7.G(1);
                oy7.J(72.0d);
                oy7.K(72.0d);
                oy7.M(this.l);
                oy7.H(this.k);
                this.g.a(oy7);
                return;
            }
            if (!string2.equals("video/hevc") || mediaFormat.getByteBuffer("csd-0") == null) {
                return;
            }
            byte[] bArrArray = mediaFormat.getByteBuffer("csd-0").array();
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            for (int i6 = 0; i6 < bArrArray.length; i6++) {
                if (i4 == 3 && bArrArray[i6] == 1) {
                    if (i5 == -1) {
                        i5 = i6 - 3;
                    } else if (i2 == -1) {
                        i2 = i6 - 3;
                    } else if (i3 == -1) {
                        i3 = i6 - 3;
                    }
                }
                i4 = bArrArray[i6] == 0 ? i4 + 1 : 0;
            }
            byte[] bArr = new byte[i2 - 4];
            byte[] bArr2 = new byte[(i3 - i2) - 4];
            byte[] bArr3 = new byte[(bArrArray.length - i3) - 4];
            for (int i7 = 0; i7 < bArrArray.length; i7++) {
                if (i7 < i2) {
                    int i8 = i7 - 4;
                    if (i8 >= 0) {
                        bArr[i8] = bArrArray[i7];
                    }
                } else if (i7 < i3) {
                    int i9 = (i7 - i2) - 4;
                    if (i9 >= 0) {
                        bArr2[i9] = bArrArray[i7];
                    }
                } else {
                    int i10 = (i7 - i3) - 4;
                    if (i10 >= 0) {
                        bArr3[i10] = bArrArray[i7];
                    }
                }
            }
            try {
                OY7 oy7E = C20722sV2.e(Arrays.asList(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr3), ByteBuffer.wrap(bArr2)));
                oy7E.M(this.l);
                oy7E.H(this.k);
                this.g.a(oy7E);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        OY7 oy72 = new OY7("avc1");
        oy72.m(1);
        oy72.z(24);
        oy72.G(1);
        oy72.J(72.0d);
        oy72.K(72.0d);
        oy72.M(this.l);
        oy72.H(this.k);
        C21996uV c21996uV = new C21996uV();
        if (mediaFormat.getByteBuffer("csd-0") != null) {
            ArrayList arrayList = new ArrayList();
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
            byteBuffer.position(4);
            byte[] bArr4 = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr4);
            arrayList.add(bArr4);
            ArrayList arrayList2 = new ArrayList();
            ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
            byteBuffer2.position(4);
            byte[] bArr5 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr5);
            arrayList2.add(bArr5);
            c21996uV.x(arrayList);
            c21996uV.v(arrayList2);
        }
        if (mediaFormat.containsKey("level")) {
            int integer = mediaFormat.getInteger("level");
            if (integer == 1) {
                c21996uV.o(1);
            } else if (integer == 32) {
                c21996uV.o(2);
            } else if (integer == 4) {
                c21996uV.o(11);
            } else if (integer == 8) {
                c21996uV.o(12);
            } else if (integer == 16) {
                c21996uV.o(13);
            } else if (integer == 64) {
                c21996uV.o(21);
            } else if (integer == 128) {
                c21996uV.o(22);
            } else if (integer == 256) {
                c21996uV.o(3);
            } else if (integer == 512) {
                c21996uV.o(31);
            } else if (integer == 1024) {
                c21996uV.o(32);
            } else if (integer == 2048) {
                c21996uV.o(4);
            } else if (integer == 4096) {
                c21996uV.o(41);
            } else if (integer == 8192) {
                c21996uV.o(42);
            } else if (integer == 16384) {
                c21996uV.o(5);
            } else if (integer == 32768) {
                c21996uV.o(51);
            } else if (integer == 65536) {
                c21996uV.o(52);
            } else if (integer == 2) {
                c21996uV.o(27);
            }
        } else {
            c21996uV.o(13);
        }
        if (mediaFormat.containsKey("profile")) {
            int integer2 = mediaFormat.getInteger("profile");
            if (integer2 == 1) {
                c21996uV.p(66);
            } else if (integer2 == 2) {
                c21996uV.p(77);
            } else if (integer2 == 4) {
                c21996uV.p(88);
            } else if (integer2 == 8) {
                c21996uV.p(100);
            } else if (integer2 == 16) {
                c21996uV.p(110);
            } else if (integer2 == 32) {
                c21996uV.p(122);
            } else if (integer2 == 64) {
                c21996uV.p(SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER);
            }
        } else {
            c21996uV.p(100);
        }
        c21996uV.r(-1);
        c21996uV.q(-1);
        c21996uV.s(-1);
        c21996uV.t(1);
        c21996uV.u(3);
        c21996uV.w(0);
        oy72.a(c21996uV);
        this.g.a(oy72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int s(a aVar, a aVar2) {
        if (aVar.b > aVar2.b) {
            return 1;
        }
        return aVar.b < aVar2.b ? -1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r6, android.media.MediaCodec.BufferInfo r8) {
        /*
            r5 = this;
            boolean r0 = r5.p
            if (r0 != 0) goto Lb
            int r0 = r8.flags
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto Lb
            goto Lc
        Lb:
            r1 = 0
        Lc:
            java.util.ArrayList r0 = r5.b
            ir.nasim.da6 r2 = new ir.nasim.da6
            int r3 = r8.size
            long r3 = (long) r3
            r2.<init>(r6, r3)
            r0.add(r2)
            java.util.LinkedList r6 = r5.h
            if (r6 == 0) goto L2c
            if (r1 == 0) goto L2c
            java.util.ArrayList r7 = r5.b
            int r7 = r7.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
        L2c:
            java.util.ArrayList r6 = r5.o
            ir.nasim.ut7$a r7 = new ir.nasim.ut7$a
            int r0 = r6.size()
            long r1 = r8.presentationTimeUs
            int r8 = r5.i
            long r3 = (long) r8
            long r1 = r1 * r3
            r3 = 500000(0x7a120, double:2.47033E-318)
            long r1 = r1 + r3
            r3 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r1 / r3
            r7.<init>(r0, r1)
            r6.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22239ut7.b(long, android.media.MediaCodec$BufferInfo):void");
    }

    public Date c() {
        return this.j;
    }

    public long d() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.k;
    }

    public long g() {
        return (((this.c - this.n[r2.length - 1]) * 1000000) - 500000) / this.i;
    }

    public AbstractC17467n1 h() {
        return this.f;
    }

    public int[] i() {
        return this.d;
    }

    public C12416ea6 j() {
        return this.g;
    }

    public long[] k() {
        return this.n;
    }

    public ArrayList l() {
        return this.b;
    }

    public long[] m() {
        LinkedList linkedList = this.h;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        long[] jArr = new long[this.h.size()];
        for (int i = 0; i < this.h.size(); i++) {
            jArr[i] = ((Integer) this.h.get(i)).intValue();
        }
        return jArr;
    }

    public int n() {
        return this.i;
    }

    public long o() {
        return this.a;
    }

    public float p() {
        return this.m;
    }

    public int q() {
        return this.l;
    }

    public boolean r() {
        return this.p;
    }

    public void t() {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList(this.o);
        Collections.sort(this.o, new Comparator() { // from class: ir.nasim.st7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C22239ut7.s((C22239ut7.a) obj, (C22239ut7.a) obj2);
            }
        });
        this.n = new long[this.o.size()];
        long jMin = Long.MAX_VALUE;
        long j = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (i3 >= this.o.size()) {
                break;
            }
            a aVar = (a) this.o.get(i3);
            long j2 = aVar.b - j;
            j = aVar.b;
            this.n[aVar.a] = j2;
            int i4 = i3;
            if (aVar.a != 0) {
                this.c += j2;
            }
            if (j2 > 0 && j2 < TTL.MAX_VALUE) {
                jMin = Math.min(jMin, j2);
            }
            if (aVar.a != i4) {
                z = true;
            }
            i3 = i4 + 1;
        }
        long[] jArr = this.n;
        if (jArr.length > 0) {
            i2 = 0;
            jArr[0] = jMin;
            this.c += jMin;
        } else {
            i2 = 0;
        }
        for (i = 1; i < arrayList.size(); i++) {
            ((a) arrayList.get(i)).c = this.n[i] + ((a) arrayList.get(i - 1)).c;
        }
        if (z) {
            this.d = new int[this.o.size()];
            for (int i5 = i2; i5 < this.o.size(); i5++) {
                a aVar2 = (a) this.o.get(i5);
                this.d[aVar2.a] = (int) (aVar2.b - aVar2.c);
            }
        }
    }
}
