package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public interface C08 {
    static /* synthetic */ void g(C08 c08, long j, String str, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinGroupCall");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        c08.i(j, str, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3);
    }

    void b(long j, boolean z);

    void d(List list);

    void e(long j, K04 k04);

    void h(boolean z);

    void i(long j, String str, boolean z, boolean z2, boolean z3);

    void k(String str);

    void o(long j);

    void onDestroy();

    void p(C11458d25 c11458d25);

    void q(long j);
}
