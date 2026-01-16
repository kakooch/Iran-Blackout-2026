package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] a;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.a = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long a() {
        long jMin = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.a) {
            long jA = sequenceableLoader.a();
            if (jA != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jA);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        for (SequenceableLoader sequenceableLoader : this.a) {
            if (sequenceableLoader.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        boolean zD;
        boolean z = false;
        do {
            long jA = a();
            if (jA == Long.MIN_VALUE) {
                break;
            }
            zD = false;
            for (SequenceableLoader sequenceableLoader : this.a) {
                long jA2 = sequenceableLoader.a();
                boolean z2 = jA2 != Long.MIN_VALUE && jA2 <= j;
                if (jA2 == jA || z2) {
                    zD |= sequenceableLoader.d(j);
                }
            }
            z |= zD;
        } while (zD);
        return z;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long e() {
        long jMin = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.a) {
            long jE = sequenceableLoader.e();
            if (jE != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jE);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final void f(long j) {
        for (SequenceableLoader sequenceableLoader : this.a) {
            sequenceableLoader.f(j);
        }
    }
}
