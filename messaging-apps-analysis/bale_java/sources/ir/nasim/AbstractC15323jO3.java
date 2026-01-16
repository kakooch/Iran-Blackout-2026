package ir.nasim;

import android.util.Pair;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Arrays;

/* renamed from: ir.nasim.jO3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15323jO3 extends AbstractC7218Qt7 {
    private a c;

    /* renamed from: ir.nasim.jO3$a */
    public static final class a {
        private final int a;
        private final String[] b;
        private final int[] c;
        private final TrackGroupArray[] d;
        private final int[] e;
        private final int[][][] f;
        private final TrackGroupArray g;

        a(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.b = strArr;
            this.c = iArr;
            this.d = trackGroupArrayArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = trackGroupArray;
            this.a = iArr.length;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.d[i].c(i2).a;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int iG = g(i, i2, i5);
                if (iG == 4 || (z && iG == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int b(int i, int i2, int[] iArr) {
            int i3 = 0;
            int iMin = 16;
            String str = null;
            boolean z = false;
            int i4 = 0;
            while (i3 < iArr.length) {
                String str2 = this.d[i].c(i2).d(iArr[i3]).l;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !AbstractC9683aN7.c(str, str2);
                }
                iMin = Math.min(iMin, InterfaceC24899zO5.p(this.f[i][i2][i3]));
                i3++;
                i4 = i5;
            }
            return z ? Math.min(iMin, this.e[i]) : iMin;
        }

        public int c(int i, int i2, int i3) {
            return this.f[i][i2][i3];
        }

        public int d() {
            return this.a;
        }

        public int e(int i) {
            return this.c[i];
        }

        public TrackGroupArray f(int i) {
            return this.d[i];
        }

        public int g(int i, int i2, int i3) {
            return InterfaceC24899zO5.F(c(i, i2, i3));
        }

        public TrackGroupArray h() {
            return this.g;
        }
    }

    private static int k(InterfaceC24899zO5[] interfaceC24899zO5Arr, TrackGroup trackGroup, int[] iArr, boolean z) {
        int length = interfaceC24899zO5Arr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < interfaceC24899zO5Arr.length; i2++) {
            InterfaceC24899zO5 interfaceC24899zO5 = interfaceC24899zO5Arr[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < trackGroup.a; i3++) {
                iMax = Math.max(iMax, InterfaceC24899zO5.F(interfaceC24899zO5.b(trackGroup.d(i3))));
            }
            boolean z3 = iArr[i2] == 0;
            if (iMax > i || (iMax == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = iMax;
            }
        }
        return length;
    }

    private static int[] l(InterfaceC24899zO5 interfaceC24899zO5, TrackGroup trackGroup) {
        int[] iArr = new int[trackGroup.a];
        for (int i = 0; i < trackGroup.a; i++) {
            iArr[i] = interfaceC24899zO5.b(trackGroup.d(i));
        }
        return iArr;
    }

    private static int[] m(InterfaceC24899zO5[] interfaceC24899zO5Arr) {
        int length = interfaceC24899zO5Arr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = interfaceC24899zO5Arr[i].A();
        }
        return iArr;
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public final void f(Object obj) {
        this.c = (a) obj;
    }

    @Override // ir.nasim.AbstractC7218Qt7
    public final C7452Rt7 h(InterfaceC24899zO5[] interfaceC24899zO5Arr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0) {
        int[] iArr = new int[interfaceC24899zO5Arr.length + 1];
        int length = interfaceC24899zO5Arr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[interfaceC24899zO5Arr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = trackGroupArray.a;
            trackGroupArr[i] = new TrackGroup[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrM = m(interfaceC24899zO5Arr);
        for (int i3 = 0; i3 < trackGroupArray.a; i3++) {
            TrackGroup trackGroupC = trackGroupArray.c(i3);
            int iK = k(interfaceC24899zO5Arr, trackGroupC, iArr, trackGroupC.c == 5);
            int[] iArrL = iK == interfaceC24899zO5Arr.length ? new int[trackGroupC.a] : l(interfaceC24899zO5Arr[iK], trackGroupC);
            int i4 = iArr[iK];
            trackGroupArr[iK][i4] = trackGroupC;
            iArr2[iK][i4] = iArrL;
            iArr[iK] = i4 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[interfaceC24899zO5Arr.length];
        String[] strArr = new String[interfaceC24899zO5Arr.length];
        int[] iArr3 = new int[interfaceC24899zO5Arr.length];
        for (int i5 = 0; i5 < interfaceC24899zO5Arr.length; i5++) {
            int i6 = iArr[i5];
            trackGroupArrayArr[i5] = new TrackGroupArray((TrackGroup[]) AbstractC9683aN7.G0(trackGroupArr[i5], i6));
            iArr2[i5] = (int[][]) AbstractC9683aN7.G0(iArr2[i5], i6);
            strArr[i5] = interfaceC24899zO5Arr[i5].getName();
            iArr3[i5] = interfaceC24899zO5Arr[i5].g();
        }
        a aVar = new a(strArr, iArr3, trackGroupArrayArr, iArrM, iArr2, new TrackGroupArray((TrackGroup[]) AbstractC9683aN7.G0(trackGroupArr[interfaceC24899zO5Arr.length], iArr[interfaceC24899zO5Arr.length])));
        Pair pairN = n(aVar, iArr2, iArrM, mediaPeriodId, j0);
        return new C7452Rt7((AO5[]) pairN.first, (InterfaceC13679ge2[]) pairN.second, AbstractC6974Pt7.a(aVar, (InterfaceC5774Kt7[]) pairN.second), aVar);
    }

    protected abstract Pair n(a aVar, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0);
}
