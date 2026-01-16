package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C3583Bm0;
import ir.nasim.C8292Vi5;
import ir.nasim.EW4;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.P12;

/* loaded from: classes2.dex */
public final class BundledChunkExtractor implements InterfaceC10465bf2, ChunkExtractor {
    public static final ChunkExtractor.Factory j = new C3583Bm0();
    private static final C8292Vi5 k = new C8292Vi5();
    private final InterfaceC9262Ze2 a;
    private final int b;
    private final X c;
    private final SparseArray d;
    private boolean e;
    private ChunkExtractor.TrackOutputProvider f;
    private long g;
    private InterfaceC22148uk6 h;
    private X[] i;

    private static final class BindingTrackOutput implements InterfaceC4589Ft7 {
        private final int a;
        private final int b;
        private final X c;
        private final P12 d = new P12();
        public X e;
        private InterfaceC4589Ft7 f;
        private long g;

        public BindingTrackOutput(int i, int i2, X x) {
            this.a = i;
            this.b = i2;
            this.c = x;
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void a(EW4 ew4, int i, int i2) {
            ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).d(ew4, i);
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void b(long j, int i, int i2, int i3, InterfaceC4589Ft7.a aVar) {
            long j2 = this.g;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f = this.d;
            }
            ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).b(j, i, i2, i3, aVar);
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void c(X x) {
            X x2 = this.c;
            if (x2 != null) {
                x = x.l(x2);
            }
            this.e = x;
            ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).c(this.e);
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public int e(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z, int i2) {
            return ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).f(interfaceC18631oz1, i, z);
        }

        public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.f = this.d;
                return;
            }
            this.g = j;
            InterfaceC4589Ft7 interfaceC4589Ft7B = trackOutputProvider.b(this.a, this.b);
            this.f = interfaceC4589Ft7B;
            X x = this.e;
            if (x != null) {
                interfaceC4589Ft7B.c(x);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean a(InterfaceC9845af2 interfaceC9845af2) {
        int iE = this.a.e(interfaceC9845af2, k);
        AbstractC20011rK.g(iE != 1);
        return iE == 0;
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public InterfaceC4589Ft7 b(int i, int i2) {
        BindingTrackOutput bindingTrackOutput = (BindingTrackOutput) this.d.get(i);
        if (bindingTrackOutput == null) {
            AbstractC20011rK.g(this.i == null);
            bindingTrackOutput = new BindingTrackOutput(i, i2, i2 == this.b ? this.c : null);
            bindingTrackOutput.g(this.f, this.g);
            this.d.put(i, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void c(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j2, long j3) {
        this.f = trackOutputProvider;
        this.g = j3;
        if (!this.e) {
            this.a.b(this);
            if (j2 != -9223372036854775807L) {
                this.a.a(0L, j2);
            }
            this.e = true;
            return;
        }
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.a;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        interfaceC9262Ze2.a(0L, j2);
        for (int i = 0; i < this.d.size(); i++) {
            ((BindingTrackOutput) this.d.valueAt(i)).g(trackOutputProvider, j3);
        }
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void o(InterfaceC22148uk6 interfaceC22148uk6) {
        this.h = interfaceC22148uk6;
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void s() {
        X[] xArr = new X[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            xArr[i] = (X) AbstractC20011rK.i(((BindingTrackOutput) this.d.valueAt(i)).e);
        }
        this.i = xArr;
    }
}
