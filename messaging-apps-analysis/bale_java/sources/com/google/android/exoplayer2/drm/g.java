package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC8236Vc3;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.DB7;
import ir.nasim.InterfaceC12088e12;
import java.util.Map;

/* loaded from: classes2.dex */
public final class g implements InterfaceC12088e12 {
    private final Object a = new Object();
    private C2018a0.f b;
    private i c;
    private a.InterfaceC0163a d;
    private String e;

    private i b(C2018a0.f fVar) {
        a.InterfaceC0163a interfaceC0163aC = this.d;
        if (interfaceC0163aC == null) {
            interfaceC0163aC = new e.b().c(this.e);
        }
        Uri uri = fVar.c;
        o oVar = new o(uri == null ? null : uri.toString(), fVar.h, interfaceC0163aC);
        DB7 it = fVar.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            oVar.e((String) entry.getKey(), (String) entry.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().e(fVar.a, n.d).b(fVar.f).c(fVar.g).d(AbstractC8236Vc3.l(fVar.j)).a(oVar);
        defaultDrmSessionManagerA.F(0, fVar.c());
        return defaultDrmSessionManagerA;
    }

    @Override // ir.nasim.InterfaceC12088e12
    public i a(C2018a0 c2018a0) {
        i iVar;
        AbstractC20011rK.e(c2018a0.b);
        C2018a0.f fVar = c2018a0.b.c;
        if (fVar == null || AbstractC9683aN7.a < 18) {
            return i.a;
        }
        synchronized (this.a) {
            try {
                if (!AbstractC9683aN7.c(fVar, this.b)) {
                    this.b = fVar;
                    this.c = b(fVar);
                }
                iVar = (i) AbstractC20011rK.e(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }
}
