package ir.nasim;

import android.net.Uri;

/* renamed from: ir.nasim.Xk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC8806Xk1 {
    static long a(InterfaceC8806Xk1 interfaceC8806Xk1) {
        return interfaceC8806Xk1.c("exo_len", -1L);
    }

    static Uri b(InterfaceC8806Xk1 interfaceC8806Xk1) {
        String strD = interfaceC8806Xk1.d("exo_redir", null);
        if (strD == null) {
            return null;
        }
        return Uri.parse(strD);
    }

    long c(String str, long j);

    String d(String str, String str2);
}
