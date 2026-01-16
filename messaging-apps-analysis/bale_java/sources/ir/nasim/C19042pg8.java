package ir.nasim;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* renamed from: ir.nasim.pg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19042pg8 {
    private static C19042pg8 d;
    final LN6 a;
    GoogleSignInAccount b;
    GoogleSignInOptions c;

    private C19042pg8(Context context) {
        LN6 ln6B = LN6.b(context);
        this.a = ln6B;
        this.b = ln6B.c();
        this.c = ln6B.d();
    }

    public static synchronized C19042pg8 a(Context context) {
        return d(context.getApplicationContext());
    }

    private static synchronized C19042pg8 d(Context context) {
        C19042pg8 c19042pg8 = d;
        if (c19042pg8 != null) {
            return c19042pg8;
        }
        C19042pg8 c19042pg82 = new C19042pg8(context);
        d = c19042pg82;
        return c19042pg82;
    }

    public final synchronized void b() {
        this.a.a();
        this.b = null;
        this.c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.a.f(googleSignInAccount, googleSignInOptions);
        this.b = googleSignInAccount;
        this.c = googleSignInOptions;
    }
}
