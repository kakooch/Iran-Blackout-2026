package ir.nasim;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12710f43;
import ir.nasim.InterfaceC13679ge2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.z7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24733z7 extends AbstractC11828dd0 {
    private final InterfaceC10699c30 h;
    private final long i;
    private final long j;
    private final long k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final AbstractC12710f43 p;
    private final NV0 q;
    private float r;
    private int s;
    private int t;
    private long u;
    private MediaChunk v;

    /* renamed from: ir.nasim.z7$a */
    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    /* renamed from: ir.nasim.z7$b */
    public static class b implements InterfaceC13679ge2.b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final float f;
        private final float g;
        private final NV0 h;

        public b() {
            this(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND, 25000, 25000, 0.7f);
        }

        @Override // ir.nasim.InterfaceC13679ge2.b
        public final InterfaceC13679ge2[] a(InterfaceC13679ge2.a[] aVarArr, InterfaceC10699c30 interfaceC10699c30, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0) {
            AbstractC12710f43 abstractC12710f43B = C24733z7.B(aVarArr);
            InterfaceC13679ge2[] interfaceC13679ge2Arr = new InterfaceC13679ge2[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                InterfaceC13679ge2.a aVar = aVarArr[i];
                if (aVar != null) {
                    int[] iArr = aVar.b;
                    if (iArr.length != 0) {
                        interfaceC13679ge2Arr[i] = iArr.length == 1 ? new C20917sp2(aVar.a, iArr[0], aVar.c) : b(aVar.a, iArr, aVar.c, interfaceC10699c30, (AbstractC12710f43) abstractC12710f43B.get(i));
                    }
                }
            }
            return interfaceC13679ge2Arr;
        }

        protected C24733z7 b(TrackGroup trackGroup, int[] iArr, int i, InterfaceC10699c30 interfaceC10699c30, AbstractC12710f43 abstractC12710f43) {
            return new C24733z7(trackGroup, iArr, i, interfaceC10699c30, this.a, this.b, this.c, this.d, this.e, this.f, this.g, abstractC12710f43, this.h);
        }

        public b(int i, int i2, int i3, float f) {
            this(i, i2, i3, 1279, 719, f, 0.75f, NV0.a);
        }

        public b(int i, int i2, int i3, int i4, int i5, float f, float f2, NV0 nv0) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = f;
            this.g = f2;
            this.h = nv0;
        }
    }

    protected C24733z7(TrackGroup trackGroup, int[] iArr, int i, InterfaceC10699c30 interfaceC10699c30, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, NV0 nv0) {
        InterfaceC10699c30 interfaceC10699c302;
        long j4;
        super(trackGroup, iArr, i);
        if (j3 < j) {
            AbstractC18815pI3.k("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            interfaceC10699c302 = interfaceC10699c30;
            j4 = j;
        } else {
            interfaceC10699c302 = interfaceC10699c30;
            j4 = j3;
        }
        this.h = interfaceC10699c302;
        this.i = j * 1000;
        this.j = j2 * 1000;
        this.k = j4 * 1000;
        this.l = i2;
        this.m = i3;
        this.n = f;
        this.o = f2;
        this.p = AbstractC12710f43.O(list);
        this.q = nv0;
        this.r = 1.0f;
        this.t = 0;
        this.u = -9223372036854775807L;
    }

    private int A(long j, long j2) {
        long jC = C(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !c(i2, j)) {
                com.google.android.exoplayer2.X xE = e(i2);
                if (z(xE, xE.h, jC)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AbstractC12710f43 B(InterfaceC13679ge2.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC13679ge2.a aVar : aVarArr) {
            if (aVar == null || aVar.b.length <= 1) {
                arrayList.add(null);
            } else {
                AbstractC12710f43.a aVarL = AbstractC12710f43.L();
                aVarL.a(new a(0L, 0L));
                arrayList.add(aVarL);
            }
        }
        long[][] jArrG = G(aVarArr);
        int[] iArr = new int[jArrG.length];
        long[] jArr = new long[jArrG.length];
        for (int i = 0; i < jArrG.length; i++) {
            long[] jArr2 = jArrG[i];
            jArr[i] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        y(arrayList, jArr);
        AbstractC12710f43 abstractC12710f43H = H(jArrG);
        for (int i2 = 0; i2 < abstractC12710f43H.size(); i2++) {
            int iIntValue = ((Integer) abstractC12710f43H.get(i2)).intValue();
            int i3 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i3;
            jArr[iIntValue] = jArrG[iIntValue][i3];
            y(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        y(arrayList, jArr);
        AbstractC12710f43.a aVarL2 = AbstractC12710f43.L();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            AbstractC12710f43.a aVar2 = (AbstractC12710f43.a) arrayList.get(i5);
            aVarL2.a(aVar2 == null ? AbstractC12710f43.V() : aVar2.h());
        }
        return aVarL2.h();
    }

    private long C(long j) {
        long jI = I(j);
        if (this.p.isEmpty()) {
            return jI;
        }
        int i = 1;
        while (i < this.p.size() - 1 && ((a) this.p.get(i)).a < jI) {
            i++;
        }
        a aVar = (a) this.p.get(i - 1);
        a aVar2 = (a) this.p.get(i);
        long j2 = aVar.a;
        float f = (jI - j2) / (aVar2.a - j2);
        return aVar.b + ((long) (f * (aVar2.b - r2)));
    }

    private long D(List list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        MediaChunk mediaChunk = (MediaChunk) AbstractC17264mg3.c(list);
        long j = mediaChunk.g;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = mediaChunk.h;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private long F(MediaChunkIterator[] mediaChunkIteratorArr, List list) {
        int i = this.s;
        if (i < mediaChunkIteratorArr.length && mediaChunkIteratorArr[i].next()) {
            MediaChunkIterator mediaChunkIterator = mediaChunkIteratorArr[this.s];
            return mediaChunkIterator.b() - mediaChunkIterator.a();
        }
        for (MediaChunkIterator mediaChunkIterator2 : mediaChunkIteratorArr) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.b() - mediaChunkIterator2.a();
            }
        }
        return D(list);
    }

    private static long[][] G(InterfaceC13679ge2.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            InterfaceC13679ge2.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.b.length];
                int i2 = 0;
                while (true) {
                    int[] iArr = aVar.b;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    long j = aVar.a.d(iArr[i2]).h;
                    long[] jArr2 = jArr[i];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i2] = j;
                    i2++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static AbstractC12710f43 H(long[][] jArr) {
        TB3 tb3E = AbstractC7377Rl4.c().a().e();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double dLog = 0.0d;
                    if (i2 >= jArr3.length) {
                        break;
                    }
                    long j = jArr3[i2];
                    if (j != -1) {
                        dLog = Math.log(j);
                    }
                    dArr[i2] = dLog;
                    i2++;
                }
                int i3 = length - 1;
                double d = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d2 = dArr[i4];
                    i4++;
                    tb3E.put(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i4]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i));
                }
            }
        }
        return AbstractC12710f43.O(tb3E.values());
    }

    private long I(long j) {
        long jE = (long) (this.h.e() * this.n);
        long jA = this.h.a();
        if (jA == -9223372036854775807L || j == -9223372036854775807L) {
            return (long) (jE / this.r);
        }
        float f = j;
        return (long) ((jE * Math.max((f / this.r) - jA, 0.0f)) / f);
    }

    private long J(long j, long j2) {
        if (j == -9223372036854775807L) {
            return this.i;
        }
        if (j2 != -9223372036854775807L) {
            j -= j2;
        }
        return Math.min((long) (j * this.o), this.i);
    }

    private static void y(List list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            AbstractC12710f43.a aVar = (AbstractC12710f43.a) list.get(i);
            if (aVar != null) {
                aVar.a(new a(j, jArr[i]));
            }
        }
    }

    protected long E() {
        return this.k;
    }

    protected boolean K(long j, List list) {
        long j2 = this.u;
        return j2 == -9223372036854775807L || j - j2 >= 1000 || !(list.isEmpty() || ((MediaChunk) AbstractC17264mg3.c(list)).equals(this.v));
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public int a() {
        return this.s;
    }

    @Override // ir.nasim.AbstractC11828dd0, ir.nasim.InterfaceC13679ge2
    public void f() {
        this.v = null;
    }

    @Override // ir.nasim.AbstractC11828dd0, ir.nasim.InterfaceC13679ge2
    public void h(float f) {
        this.r = f;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public Object i() {
        return null;
    }

    @Override // ir.nasim.AbstractC11828dd0, ir.nasim.InterfaceC13679ge2
    public void n() {
        this.u = -9223372036854775807L;
        this.v = null;
    }

    @Override // ir.nasim.AbstractC11828dd0, ir.nasim.InterfaceC13679ge2
    public int o(long j, List list) {
        int i;
        int i2;
        long jElapsedRealtime = this.q.elapsedRealtime();
        if (!K(jElapsedRealtime, list)) {
            return list.size();
        }
        this.u = jElapsedRealtime;
        this.v = list.isEmpty() ? null : (MediaChunk) AbstractC17264mg3.c(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jD0 = AbstractC9683aN7.d0(((MediaChunk) list.get(size - 1)).g - j, this.r);
        long jE = E();
        if (jD0 < jE) {
            return size;
        }
        com.google.android.exoplayer2.X xE = e(A(jElapsedRealtime, D(list)));
        for (int i3 = 0; i3 < size; i3++) {
            MediaChunk mediaChunk = (MediaChunk) list.get(i3);
            com.google.android.exoplayer2.X x = mediaChunk.d;
            if (AbstractC9683aN7.d0(mediaChunk.g - j, this.r) >= jE && x.h < xE.h && (i = x.r) != -1 && i <= this.m && (i2 = x.q) != -1 && i2 <= this.l && i < xE.r) {
                return i3;
            }
        }
        return size;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public void p(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = this.q.elapsedRealtime();
        long jF = F(mediaChunkIteratorArr, list);
        int i = this.t;
        if (i == 0) {
            this.t = 1;
            this.s = A(jElapsedRealtime, jF);
            return;
        }
        int i2 = this.s;
        int iV = list.isEmpty() ? -1 : v(((MediaChunk) AbstractC17264mg3.c(list)).d);
        if (iV != -1) {
            i = ((MediaChunk) AbstractC17264mg3.c(list)).e;
            i2 = iV;
        }
        int iA = A(jElapsedRealtime, jF);
        if (!c(i2, jElapsedRealtime)) {
            com.google.android.exoplayer2.X xE = e(i2);
            com.google.android.exoplayer2.X xE2 = e(iA);
            long J = J(j3, jF);
            int i3 = xE2.h;
            int i4 = xE.h;
            if ((i3 > i4 && j2 < J) || (i3 < i4 && j2 >= this.j)) {
                iA = i2;
            }
        }
        if (iA != i2) {
            i = 3;
        }
        this.t = i;
        this.s = iA;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public int s() {
        return this.t;
    }

    protected boolean z(com.google.android.exoplayer2.X x, int i, long j) {
        return ((long) i) <= j;
    }
}
