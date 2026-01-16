package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.zat;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C23773xV0;
import ir.nasim.InterfaceC22690vf8;
import ir.nasim.InterfaceC23286wf8;
import ir.nasim.LN6;

/* loaded from: classes3.dex */
public class a extends com.google.android.gms.common.internal.c implements InterfaceC22690vf8 {
    public static final /* synthetic */ int D0 = 0;
    private final C23773xV0 A0;
    private final Bundle B0;
    private final Integer C0;
    private final boolean z0;

    public a(Context context, Looper looper, boolean z, C23773xV0 c23773xV0, Bundle bundle, c.a aVar, c.b bVar) {
        super(context, looper, 44, c23773xV0, aVar, bVar);
        this.z0 = true;
        this.A0 = c23773xV0;
        this.B0 = bundle;
        this.C0 = c23773xV0.i();
    }

    public static Bundle m0(C23773xV0 c23773xV0) {
        c23773xV0.h();
        Integer numI = c23773xV0.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c23773xV0.a());
        if (numI != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numI.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle A() {
        if (!y().getPackageName().equals(this.A0.f())) {
            this.B0.putString("com.google.android.gms.signin.internal.realClientPackageName", this.A0.f());
        }
        return this.B0;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // ir.nasim.InterfaceC22690vf8
    public final void g(InterfaceC23286wf8 interfaceC23286wf8) {
        AbstractC3795Cj5.k(interfaceC23286wf8, "Expecting a valid ISignInCallbacks");
        try {
            Account accountC = this.A0.c();
            ((c) D()).F2(new zai(1, new zat(accountC, ((Integer) AbstractC3795Cj5.j(this.C0)).intValue(), "<<default account>>".equals(accountC.name) ? LN6.b(y()).c() : null)), interfaceC23286wf8);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                interfaceC23286wf8.T(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean i() {
        return this.z0;
    }

    @Override // ir.nasim.InterfaceC22690vf8
    public final void j() {
        f(new b.d());
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
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new c(iBinder);
    }
}
