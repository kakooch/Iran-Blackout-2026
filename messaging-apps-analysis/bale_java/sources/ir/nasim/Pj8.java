package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class Pj8 extends com.google.android.gms.common.internal.c {
    private final Bundle z0;

    public Pj8(Context context, Looper looper, C23773xV0 c23773xV0, KQ kq, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        super(context, looper, 16, c23773xV0, interfaceC17823nd1, zi4);
        this.z0 = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle A() {
        return this.z0;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    public final boolean S() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean i() {
        C23773xV0 c23773xV0J0 = j0();
        return (TextUtils.isEmpty(c23773xV0J0.b()) || c23773xV0J0.e(JQ.a).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* bridge */ /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof Vj8 ? (Vj8) iInterfaceQueryLocalInterface : new Vj8(iBinder);
    }
}
