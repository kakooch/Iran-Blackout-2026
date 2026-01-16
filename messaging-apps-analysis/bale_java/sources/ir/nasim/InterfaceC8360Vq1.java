package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Vq1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC8360Vq1 extends InterfaceC24754z90 {
    static /* synthetic */ void s0(InterfaceC8360Vq1 interfaceC8360Vq1, Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        interfaceC8360Vq1.p(context, j, (i & 4) != 0 ? "empty.jpg" : str, (i & 8) != 0 ? "empty.jpg" : str2, str3, str4, j2, j3, j4, str5);
    }

    void p(Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5);
}
