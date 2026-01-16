package ir.nasim;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.c;

/* loaded from: classes3.dex */
public final class Eq8 extends com.google.android.gms.common.internal.c {
    public Eq8(Context context, Looper looper, C23773xV0 c23773xV0, c.a aVar, c.b bVar) {
        super(context, looper, 40, c23773xV0, aVar, bVar);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.clearcut.service.START";
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC22230us8 ? (InterfaceC22230us8) iInterfaceQueryLocalInterface : new Zs8(iBinder);
    }
}
