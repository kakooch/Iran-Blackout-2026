package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C14506i2;
import ir.nasim.C16886m2;
import ir.nasim.C21678tw7;
import ir.nasim.C24512yk4;
import ir.nasim.C4419Fb;
import ir.nasim.C5045Hq7;
import ir.nasim.C7267Qz2;
import ir.nasim.C8292Vi5;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;

/* loaded from: classes2.dex */
public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    private static final C8292Vi5 d = new C8292Vi5();
    final InterfaceC9262Ze2 a;
    private final X b;
    private final C5045Hq7 c;

    public BundledHlsMediaChunkExtractor(InterfaceC9262Ze2 interfaceC9262Ze2, X x, C5045Hq7 c5045Hq7) {
        this.a = interfaceC9262Ze2;
        this.b = x;
        this.c = c5045Hq7;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean a(InterfaceC9845af2 interfaceC9845af2) {
        return this.a.e(interfaceC9845af2, d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.a.b(interfaceC10465bf2);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void c() {
        this.a.a(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean d() {
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.a;
        return (interfaceC9262Ze2 instanceof C21678tw7) || (interfaceC9262Ze2 instanceof C7267Qz2);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean e() {
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.a;
        return (interfaceC9262Ze2 instanceof C4419Fb) || (interfaceC9262Ze2 instanceof C14506i2) || (interfaceC9262Ze2 instanceof C16886m2) || (interfaceC9262Ze2 instanceof C24512yk4);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor f() {
        InterfaceC9262Ze2 c24512yk4;
        AbstractC20011rK.g(!d());
        InterfaceC9262Ze2 interfaceC9262Ze2 = this.a;
        if (interfaceC9262Ze2 instanceof WebvttExtractor) {
            c24512yk4 = new WebvttExtractor(this.b.c, this.c);
        } else if (interfaceC9262Ze2 instanceof C4419Fb) {
            c24512yk4 = new C4419Fb();
        } else if (interfaceC9262Ze2 instanceof C14506i2) {
            c24512yk4 = new C14506i2();
        } else if (interfaceC9262Ze2 instanceof C16886m2) {
            c24512yk4 = new C16886m2();
        } else {
            if (!(interfaceC9262Ze2 instanceof C24512yk4)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.a.getClass().getSimpleName());
            }
            c24512yk4 = new C24512yk4();
        }
        return new BundledHlsMediaChunkExtractor(c24512yk4, this.b, this.c);
    }
}
