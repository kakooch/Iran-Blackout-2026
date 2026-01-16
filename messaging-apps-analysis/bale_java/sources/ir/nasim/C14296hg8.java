package ir.nasim;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import java.util.Iterator;

/* renamed from: ir.nasim.hg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14296hg8 extends com.google.android.gms.common.internal.c {
    private final GoogleSignInOptions z0;

    public C14296hg8(Context context, Looper looper, C23773xV0 c23773xV0, GoogleSignInOptions googleSignInOptions, c.a aVar, c.b bVar) {
        super(context, looper, 91, c23773xV0, aVar, bVar);
        GoogleSignInOptions.a aVar2 = googleSignInOptions != null ? new GoogleSignInOptions.a(googleSignInOptions) : new GoogleSignInOptions.a();
        aVar2.e(AbstractC11866dg8.a());
        if (!c23773xV0.d().isEmpty()) {
            Iterator it = c23773xV0.d().iterator();
            while (it.hasNext()) {
                aVar2.d((Scope) it.next(), new Scope[0]);
            }
        }
        this.z0 = aVar2.a();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final GoogleSignInOptions m0() {
        return this.z0;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof C22700vg8 ? (C22700vg8) iInterfaceQueryLocalInterface : new C22700vg8(iBinder);
    }
}
