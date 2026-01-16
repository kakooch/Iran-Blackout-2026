package ir.nasim;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* renamed from: ir.nasim.xg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class BinderC23886xg8 extends AbstractBinderC20240rg8 {
    private final Context a;

    public BinderC23886xg8(Context context) {
        this.a = context;
    }

    private final void C2() {
        if (SA7.a(this.a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // ir.nasim.InterfaceC20833sg8
    public final void E() {
        C2();
        C19042pg8.a(this.a).b();
    }

    @Override // ir.nasim.InterfaceC20833sg8
    public final void S() {
        C2();
        LN6 ln6B = LN6.b(this.a);
        GoogleSignInAccount googleSignInAccountC = ln6B.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.l;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = ln6B.d();
        }
        com.google.android.gms.auth.api.signin.b bVarA = com.google.android.gms.auth.api.signin.a.a(this.a, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            bVarA.z();
        } else {
            bVarA.A();
        }
    }
}
