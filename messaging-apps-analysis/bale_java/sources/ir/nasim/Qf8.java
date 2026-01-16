package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;

/* loaded from: classes3.dex */
public final class Qf8 extends com.google.android.gms.common.internal.c {
    private final C17899nk7 z0;

    public Qf8(Context context, Looper looper, C23773xV0 c23773xV0, C17899nk7 c17899nk7, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        super(context, looper, 270, c23773xV0, interfaceC17823nd1, zi4);
        this.z0 = c17899nk7;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle A() {
        return this.z0.b();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final boolean I() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof Hf8 ? (Hf8) iInterfaceQueryLocalInterface : new Hf8(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final Feature[] v() {
        return AbstractC25060zf8.b;
    }
}
