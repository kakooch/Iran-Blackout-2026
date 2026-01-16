package ir.nasim;

import android.net.Uri;

/* renamed from: ir.nasim.qp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19723qp8 {
    private final C24792zC6 a;

    C19723qp8(C24792zC6 c24792zC6) {
        this.a = c24792zC6;
    }

    public final String a(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        C24792zC6 c24792zC6 = (C24792zC6) this.a.get(uri.toString());
        if (c24792zC6 == null) {
            return null;
        }
        return (String) c24792zC6.get("".concat(String.valueOf(str3)));
    }
}
