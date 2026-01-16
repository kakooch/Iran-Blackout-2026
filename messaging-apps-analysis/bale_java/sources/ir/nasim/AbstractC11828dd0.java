package ir.nasim;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.dd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11828dd0 implements InterfaceC13679ge2 {
    protected final TrackGroup a;
    protected final int b;
    protected final int[] c;
    private final int d;
    private final com.google.android.exoplayer2.X[] e;
    private final long[] f;
    private int g;

    public AbstractC11828dd0(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int w(com.google.android.exoplayer2.X x, com.google.android.exoplayer2.X x2) {
        return x2.h - x.h;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public boolean b(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zC = c(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.b && !zC) {
            zC = (i2 == i || c(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zC) {
            return false;
        }
        long[] jArr = this.f;
        jArr[i] = Math.max(jArr[i], AbstractC9683aN7.b(jElapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public boolean c(int i, long j) {
        return this.f[i] > j;
    }

    @Override // ir.nasim.InterfaceC5774Kt7
    public final com.google.android.exoplayer2.X e(int i) {
        return this.e[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC11828dd0 abstractC11828dd0 = (AbstractC11828dd0) obj;
        return this.a == abstractC11828dd0.a && Arrays.equals(this.c, abstractC11828dd0.c);
    }

    @Override // ir.nasim.InterfaceC5774Kt7
    public final int g(int i) {
        return this.c[i];
    }

    public int hashCode() {
        if (this.g == 0) {
            this.g = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        }
        return this.g;
    }

    @Override // ir.nasim.InterfaceC5774Kt7
    public final int k(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC5774Kt7
    public final TrackGroup l() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC5774Kt7
    public final int length() {
        return this.c.length;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public int o(long j, List list) {
        return list.size();
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public final int q() {
        return this.c[a()];
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public final com.google.android.exoplayer2.X r() {
        return this.e[a()];
    }

    public final int v(com.google.android.exoplayer2.X x) {
        for (int i = 0; i < this.b; i++) {
            if (this.e[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public AbstractC11828dd0(TrackGroup trackGroup, int[] iArr, int i) {
        int i2 = 0;
        AbstractC20011rK.g(iArr.length > 0);
        this.d = i;
        this.a = (TrackGroup) AbstractC20011rK.e(trackGroup);
        int length = iArr.length;
        this.b = length;
        this.e = new com.google.android.exoplayer2.X[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.e[i3] = trackGroup.d(iArr[i3]);
        }
        Arrays.sort(this.e, new Comparator() { // from class: ir.nasim.cd0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC11828dd0.w((com.google.android.exoplayer2.X) obj, (com.google.android.exoplayer2.X) obj2);
            }
        });
        this.c = new int[this.b];
        while (true) {
            int i4 = this.b;
            if (i2 >= i4) {
                this.f = new long[i4];
                return;
            } else {
                this.c[i2] = trackGroup.e(this.e[i2]);
                i2++;
            }
        }
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public void f() {
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public void n() {
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public void h(float f) {
    }
}
