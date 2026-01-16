package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleQueue;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19093pm;
import ir.nasim.C8171Uv1;
import ir.nasim.EW4;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC4589Ft7;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
class SampleDataQueue {
    private final InterfaceC19684qm a;
    private final int b;
    private final EW4 c;
    private AllocationNode d;
    private AllocationNode e;
    private AllocationNode f;
    private long g;

    private static final class AllocationNode implements InterfaceC19684qm.a {
        public long a;
        public long b;
        public C19093pm c;
        public AllocationNode d;

        public AllocationNode(long j, int i) {
            d(j, i);
        }

        @Override // ir.nasim.InterfaceC19684qm.a
        public C19093pm a() {
            return (C19093pm) AbstractC20011rK.e(this.c);
        }

        public AllocationNode b() {
            this.c = null;
            AllocationNode allocationNode = this.d;
            this.d = null;
            return allocationNode;
        }

        public void c(C19093pm c19093pm, AllocationNode allocationNode) {
            this.c = c19093pm;
            this.d = allocationNode;
        }

        public void d(long j, int i) {
            AbstractC20011rK.g(this.c == null);
            this.a = j;
            this.b = j + i;
        }

        public int e(long j) {
            return ((int) (j - this.a)) + this.c.b;
        }

        @Override // ir.nasim.InterfaceC19684qm.a
        public InterfaceC19684qm.a next() {
            AllocationNode allocationNode = this.d;
            if (allocationNode == null || allocationNode.c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(InterfaceC19684qm interfaceC19684qm) {
        this.a = interfaceC19684qm;
        int iE = interfaceC19684qm.e();
        this.b = iE;
        this.c = new EW4(32);
        AllocationNode allocationNode = new AllocationNode(0L, iE);
        this.d = allocationNode;
        this.e = allocationNode;
        this.f = allocationNode;
    }

    private void a(AllocationNode allocationNode) {
        if (allocationNode.c == null) {
            return;
        }
        this.a.c(allocationNode);
        allocationNode.b();
    }

    private static AllocationNode d(AllocationNode allocationNode, long j) {
        while (j >= allocationNode.b) {
            allocationNode = allocationNode.d;
        }
        return allocationNode;
    }

    private void g(int i) {
        long j = this.g + i;
        this.g = j;
        AllocationNode allocationNode = this.f;
        if (j == allocationNode.b) {
            this.f = allocationNode.d;
        }
    }

    private int h(int i) {
        AllocationNode allocationNode = this.f;
        if (allocationNode.c == null) {
            allocationNode.c(this.a.b(), new AllocationNode(this.f.b, this.b));
        }
        return Math.min(i, (int) (this.f.b - this.g));
    }

    private static AllocationNode i(AllocationNode allocationNode, long j, ByteBuffer byteBuffer, int i) {
        AllocationNode allocationNodeD = d(allocationNode, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (allocationNodeD.b - j));
            byteBuffer.put(allocationNodeD.c.a, allocationNodeD.e(j), iMin);
            i -= iMin;
            j += iMin;
            if (j == allocationNodeD.b) {
                allocationNodeD = allocationNodeD.d;
            }
        }
        return allocationNodeD;
    }

    private static AllocationNode j(AllocationNode allocationNode, long j, byte[] bArr, int i) {
        AllocationNode allocationNodeD = d(allocationNode, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (allocationNodeD.b - j));
            System.arraycopy(allocationNodeD.c.a, allocationNodeD.e(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += iMin;
            if (j == allocationNodeD.b) {
                allocationNodeD = allocationNodeD.d;
            }
        }
        return allocationNodeD;
    }

    private static AllocationNode k(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, EW4 ew4) {
        long j = sampleExtrasHolder.b;
        int iL = 1;
        ew4.O(1);
        AllocationNode allocationNodeJ = j(allocationNode, j, ew4.e(), 1);
        long j2 = j + 1;
        byte b = ew4.e()[0];
        boolean z = (b & 128) != 0;
        int i = b & 127;
        C8171Uv1 c8171Uv1 = decoderInputBuffer.b;
        byte[] bArr = c8171Uv1.a;
        if (bArr == null) {
            c8171Uv1.a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode allocationNodeJ2 = j(allocationNodeJ, j2, c8171Uv1.a, i);
        long j3 = j2 + i;
        if (z) {
            ew4.O(2);
            allocationNodeJ2 = j(allocationNodeJ2, j3, ew4.e(), 2);
            j3 += 2;
            iL = ew4.L();
        }
        int i2 = iL;
        int[] iArr = c8171Uv1.d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = c8171Uv1.e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            ew4.O(i3);
            allocationNodeJ2 = j(allocationNodeJ2, j3, ew4.e(), i3);
            j3 += i3;
            ew4.S(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = ew4.L();
                iArr4[i4] = ew4.J();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.a - ((int) (j3 - sampleExtrasHolder.b));
        }
        InterfaceC4589Ft7.a aVar = (InterfaceC4589Ft7.a) AbstractC9683aN7.j(sampleExtrasHolder.c);
        c8171Uv1.c(i2, iArr2, iArr4, aVar.b, c8171Uv1.a, aVar.a, aVar.c, aVar.d);
        long j4 = sampleExtrasHolder.b;
        int i5 = (int) (j3 - j4);
        sampleExtrasHolder.b = j4 + i5;
        sampleExtrasHolder.a -= i5;
        return allocationNodeJ2;
    }

    private static AllocationNode l(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, EW4 ew4) {
        if (decoderInputBuffer.B()) {
            allocationNode = k(allocationNode, decoderInputBuffer, sampleExtrasHolder, ew4);
        }
        if (!decoderInputBuffer.s()) {
            decoderInputBuffer.z(sampleExtrasHolder.a);
            return i(allocationNode, sampleExtrasHolder.b, decoderInputBuffer.c, sampleExtrasHolder.a);
        }
        ew4.O(4);
        AllocationNode allocationNodeJ = j(allocationNode, sampleExtrasHolder.b, ew4.e(), 4);
        int iJ = ew4.J();
        sampleExtrasHolder.b += 4;
        sampleExtrasHolder.a -= 4;
        decoderInputBuffer.z(iJ);
        AllocationNode allocationNodeI = i(allocationNodeJ, sampleExtrasHolder.b, decoderInputBuffer.c, iJ);
        sampleExtrasHolder.b += iJ;
        int i = sampleExtrasHolder.a - iJ;
        sampleExtrasHolder.a = i;
        decoderInputBuffer.D(i);
        return i(allocationNodeI, sampleExtrasHolder.b, decoderInputBuffer.f, sampleExtrasHolder.a);
    }

    public void b(long j) {
        AllocationNode allocationNode;
        if (j == -1) {
            return;
        }
        while (true) {
            allocationNode = this.d;
            if (j < allocationNode.b) {
                break;
            }
            this.a.a(allocationNode.c);
            this.d = this.d.b();
        }
        if (this.e.a < allocationNode.a) {
            this.e = allocationNode;
        }
    }

    public void c(long j) {
        AbstractC20011rK.a(j <= this.g);
        this.g = j;
        if (j != 0) {
            AllocationNode allocationNode = this.d;
            if (j != allocationNode.a) {
                while (this.g > allocationNode.b) {
                    allocationNode = allocationNode.d;
                }
                AllocationNode allocationNode2 = (AllocationNode) AbstractC20011rK.e(allocationNode.d);
                a(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.b, this.b);
                allocationNode.d = allocationNode3;
                if (this.g == allocationNode.b) {
                    allocationNode = allocationNode3;
                }
                this.f = allocationNode;
                if (this.e == allocationNode2) {
                    this.e = allocationNode3;
                    return;
                }
                return;
            }
        }
        a(this.d);
        AllocationNode allocationNode4 = new AllocationNode(this.g, this.b);
        this.d = allocationNode4;
        this.e = allocationNode4;
        this.f = allocationNode4;
    }

    public long e() {
        return this.g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        l(this.e, decoderInputBuffer, sampleExtrasHolder, this.c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.e = l(this.e, decoderInputBuffer, sampleExtrasHolder, this.c);
    }

    public void n() {
        a(this.d);
        this.d.d(0L, this.b);
        AllocationNode allocationNode = this.d;
        this.e = allocationNode;
        this.f = allocationNode;
        this.g = 0L;
        this.a.d();
    }

    public void o() {
        this.e = this.d;
    }

    public int p(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z) throws EOFException {
        int iH = h(i);
        AllocationNode allocationNode = this.f;
        int i2 = interfaceC18631oz1.read(allocationNode.c.a, allocationNode.e(this.g), iH);
        if (i2 != -1) {
            g(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(EW4 ew4, int i) {
        while (i > 0) {
            int iH = h(i);
            AllocationNode allocationNode = this.f;
            ew4.j(allocationNode.c.a, allocationNode.e(this.g), iH);
            i -= iH;
            g(iH);
        }
    }
}
