package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Kq1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC5741Kq1 {
    static /* synthetic */ void h0(InterfaceC5741Kq1 interfaceC5741Kq1, Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        interfaceC5741Kq1.p(context, j, (i & 4) != 0 ? "empty.jpg" : str, (i & 8) != 0 ? "empty.jpg" : str2, str3, str4, j2, j3, j4, str5);
    }

    void a(long j, long j2, long j3, C16247kx c16247kx);

    androidx.lifecycle.r a0(long j);

    androidx.lifecycle.r e();

    androidx.lifecycle.r getConfig();

    androidx.lifecycle.r h();

    void p(Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5);

    androidx.lifecycle.r q0(AbstractC20471s40 abstractC20471s40);
}
