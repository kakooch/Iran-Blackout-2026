package ir.nasim;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;

/* loaded from: classes3.dex */
public final class Xl8 extends com.google.android.gms.common.internal.c {
    protected Xl8(Context context, Looper looper, C23773xV0 c23773xV0, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        super(context, looper, 300, c23773xV0, interfaceC17823nd1, zi4);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.appset.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final boolean I() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b
    public final boolean S() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 212800000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService");
        return iInterfaceQueryLocalInterface instanceof C17940no8 ? (C17940no8) iInterfaceQueryLocalInterface : new C17940no8(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final Feature[] v() {
        return AbstractC11314cn8.b;
    }
}
