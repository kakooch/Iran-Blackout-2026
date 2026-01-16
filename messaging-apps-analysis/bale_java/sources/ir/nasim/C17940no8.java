package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.appset.zza;

/* renamed from: ir.nasim.no8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17940no8 extends Bg8 implements IInterface {
    C17940no8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void D2(zza zzaVar, InterfaceC22770vn8 interfaceC22770vn8) {
        Parcel parcelB2 = B2();
        Zk8.b(parcelB2, zzaVar);
        Zk8.c(parcelB2, interfaceC22770vn8);
        C2(1, parcelB2);
    }
}
