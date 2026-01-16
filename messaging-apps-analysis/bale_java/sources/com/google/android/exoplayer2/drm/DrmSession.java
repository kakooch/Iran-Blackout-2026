package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.h;
import ir.nasim.InterfaceC7698Sv1;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {
        public final int a;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.a = i;
        }
    }

    static void g(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.a(null);
        }
        if (drmSession != null) {
            drmSession.b(null);
        }
    }

    void a(h.a aVar);

    void b(h.a aVar);

    UUID c();

    boolean d();

    DrmSessionException e();

    InterfaceC7698Sv1 f();

    int getState();

    Map h();

    boolean i(String str);
}
