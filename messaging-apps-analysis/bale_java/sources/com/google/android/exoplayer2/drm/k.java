package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import com.google.android.exoplayer2.drm.m;
import ir.nasim.InterfaceC7698Sv1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k implements m {
    @Override // com.google.android.exoplayer2.drm.m
    public Map a(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public m.d b() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public byte[] c() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void d(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void e(m.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void f(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public int g() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.m
    public InterfaceC7698Sv1 i(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public boolean j(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void k(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.m
    public byte[] l(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public m.a m(byte[] bArr, List list, int i, HashMap map) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.m
    public void release() {
    }
}
