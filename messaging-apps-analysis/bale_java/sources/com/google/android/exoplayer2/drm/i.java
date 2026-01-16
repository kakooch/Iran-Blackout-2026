package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.i;
import ir.nasim.C15493jg5;

/* loaded from: classes2.dex */
public interface i {
    public static final i a;
    public static final i b;

    public interface b {
        public static final b a = new b() { // from class: ir.nasim.d12
            @Override // com.google.android.exoplayer2.drm.i.b
            public final void release() {
                i.b.a();
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void a() {
        }

        void release();
    }

    static {
        a aVar = new a();
        a = aVar;
        b = aVar;
    }

    int a(X x);

    void b(Looper looper, C15493jg5 c15493jg5);

    DrmSession c(h.a aVar, X x);

    default b d(h.a aVar, X x) {
        return b.a;
    }

    default void r() {
    }

    default void release() {
    }

    class a implements i {
        a() {
        }

        @Override // com.google.android.exoplayer2.drm.i
        public int a(X x) {
            return x.o != null ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.drm.i
        public DrmSession c(h.a aVar, X x) {
            if (x.o == null) {
                return null;
            }
            return new l(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.i
        public void b(Looper looper, C15493jg5 c15493jg5) {
        }
    }
}
