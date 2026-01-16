package ir.nasim;

/* loaded from: classes5.dex */
public interface HC6 {
    static /* synthetic */ void b(HC6 hc6, com.google.android.exoplayer2.E0 e0, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: share");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        hc6.d(e0, obj);
    }

    static /* synthetic */ com.google.android.exoplayer2.E0 e(HC6 hc6, String str, Object obj, boolean z, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: obtainShared");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return hc6.f(str, obj, z);
    }

    void a(Object obj, com.google.android.exoplayer2.E0 e0);

    com.google.android.exoplayer2.E0 c();

    void d(com.google.android.exoplayer2.E0 e0, Object obj);

    com.google.android.exoplayer2.E0 f(String str, Object obj, boolean z);
}
