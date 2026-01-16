package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.h;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.InterfaceC7698Sv1;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class l implements DrmSession {
    private final DrmSession.DrmSessionException a;

    public l(DrmSession.DrmSessionException drmSessionException) {
        this.a = (DrmSession.DrmSessionException) AbstractC20011rK.e(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(h.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(h.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return AbstractC9350Zo0.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public DrmSession.DrmSessionException e() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public InterfaceC7698Sv1 f() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map h() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean i(String str) {
        return false;
    }
}
