package com.google.ads.interactivemedia.v3.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ei implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, afu, hi, be, ba, el, dw {
    final /* synthetic */ ej a;

    /* synthetic */ ei(ej ejVar) {
        this.a = ejVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void A(String str, long j, long j2) {
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).A(str, j, j2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void B(cy cyVar) {
        this.a.s = cyVar;
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).B(cyVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void C(long j) {
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).C(j);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void D(int i, long j, long j2) {
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).D(i, j, j2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void E(iu iuVar) {
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).E(iuVar);
        }
        this.a.s = null;
        this.a.A = null;
        this.a.B = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void F(boolean z) {
        if (this.a.E == z) {
            return;
        }
        this.a.E = z;
        ej.E(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void a(iu iuVar) {
        this.a.z = iuVar;
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).a(iuVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void b(String str, long j, long j2) {
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).b(str, j, j2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void c(cy cyVar) {
        this.a.r = cyVar;
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).c(cyVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void d(int i, long j) {
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).d(i, j);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void e(int i, int i2, int i3, float f) {
        Iterator it = this.a.e.iterator();
        while (it.hasNext()) {
            afk afkVar = (afk) it.next();
            if (!this.a.i.contains(afkVar)) {
                afkVar.e(i, i2, i3, f);
            }
        }
        Iterator it2 = this.a.i.iterator();
        while (it2.hasNext()) {
            ((afu) it2.next()).e(i, i2, i3, f);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void f(Surface surface) {
        if (this.a.t == surface) {
            Iterator it = this.a.e.iterator();
            while (it.hasNext()) {
                ((afk) it.next()).L();
            }
        }
        Iterator it2 = this.a.i.iterator();
        while (it2.hasNext()) {
            ((afu) it2.next()).f(surface);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void g(es esVar, int i) {
        if (esVar.s() == 1) {
            Object obj = esVar.v(0, new er()).d;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void h(dg dgVar, int i) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void i(vj vjVar, abb abbVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void j(List list) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void l(boolean z, int i) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void m(int i) {
        ej.P(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void n(boolean z, int i) {
        ej.P(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void o(int i) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.aa(new Surface(surfaceTexture), true);
        this.a.ab(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.a.aa(null, true);
        this.a.ab(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.ab(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void p(boolean z) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void q(bn bnVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void r(int i) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void s(dv dvVar) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.a.ab(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.aa(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.aa(null, false);
        this.a.ab(0, 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void t() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void u() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void v() {
        ej.P(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void w(iu iuVar) {
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).w(iuVar);
        }
        this.a.r = null;
        this.a.z = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void x(long j, int i) {
        Iterator it = this.a.i.iterator();
        while (it.hasNext()) {
            ((afu) it.next()).x(j, i);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void y(iu iuVar) {
        this.a.A = iuVar;
        Iterator it = this.a.j.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).y(iuVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void z(int i) {
        if (this.a.B == i) {
            return;
        }
        this.a.B = i;
        ej.C(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void k(boolean z) {
        if (ej.Y(this.a) != null) {
            if (z) {
                if (!ej.O(this.a)) {
                    throw null;
                }
            } else if (ej.O(this.a)) {
                throw null;
            }
        }
    }
}
