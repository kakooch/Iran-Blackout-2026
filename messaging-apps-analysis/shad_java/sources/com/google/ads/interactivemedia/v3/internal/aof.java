package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aof implements gl {
    final /* synthetic */ aoh a;

    aof(aoh aohVar) {
        this.a = aohVar;
    }

    private final void R(AdMediaInfo adMediaInfo) {
        if (adMediaInfo == null || this.a.g.contains(adMediaInfo)) {
            return;
        }
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onEnded(adMediaInfo);
        }
        this.a.g.add(adMediaInfo);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void A(int i) {
        AdMediaInfo adMediaInfoJ = this.a.j();
        if (adMediaInfoJ == null) {
            return;
        }
        if (i == 2) {
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onBuffering(adMediaInfoJ);
            }
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            R(adMediaInfoJ);
        } else {
            Iterator it2 = this.a.f.iterator();
            while (it2.hasNext()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) it2.next()).onLoaded(adMediaInfoJ);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void B(int i) {
        if (i != 0) {
            return;
        }
        if (this.a.m == null) {
            Log.d("IMASDK", "Position discontinuity occurred when there is no active media source.");
            return;
        }
        int iM = this.a.a.m();
        for (int i2 = 0; i2 < iM; i2++) {
            R(this.a.m(i2));
        }
        AdMediaInfo adMediaInfoM = this.a.m(iM);
        if (adMediaInfoM != null) {
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : this.a.f) {
                videoAdPlayerCallback.onLoaded(adMediaInfoM);
                videoAdPlayerCallback.onPlay(adMediaInfoM);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void C() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void D() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void E() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void F() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void G() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void H() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void I() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void J() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void K() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void L() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void M() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void N() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void O() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void P() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void Q() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void a(gk gkVar, bn bnVar) {
        AdMediaInfo adMediaInfoM = this.a.m(gkVar.c);
        this.a.g.add(adMediaInfoM);
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onError(adMediaInfoM);
        }
        String strValueOf = String.valueOf(bnVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Player Error:");
        sb.append(strValueOf);
        Log.e("IMASDK", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void b() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void c() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void d() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void e() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void g() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void h() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void i() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void j() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void k() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void l() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void m() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void n() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void o() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void p() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void q() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void r() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void s() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void t() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void u() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void v() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void w() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void x() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void y() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gl
    public final void z() {
    }
}
