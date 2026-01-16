package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c;
import ir.nasim.GP;

/* renamed from: ir.nasim.qg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19633qg8 extends com.google.android.gms.common.internal.c {
    private final GP.a z0;

    public C19633qg8(Context context, Looper looper, C23773xV0 c23773xV0, GP.a aVar, c.a aVar2, c.b bVar) {
        super(context, looper, 68, c23773xV0, aVar2, bVar);
        GP.a.C0390a c0390a = new GP.a.C0390a(aVar == null ? GP.a.d : aVar);
        c0390a.a(AbstractC11866dg8.a());
        this.z0 = new GP.a(c0390a);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle A() {
        return this.z0.a();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof C23296wg8 ? (C23296wg8) iInterfaceQueryLocalInterface : new C23296wg8(iBinder);
    }
}
