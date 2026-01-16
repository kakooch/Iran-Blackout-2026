package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.clearcut.zze;

/* loaded from: classes3.dex */
public final class Zs8 extends Eg8 implements InterfaceC22230us8 {
    Zs8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // ir.nasim.InterfaceC22230us8
    public final void J1(Gr8 gr8, zze zzeVar) {
        Parcel parcelB2 = B2();
        AbstractC10531bl8.b(parcelB2, gr8);
        AbstractC10531bl8.c(parcelB2, zzeVar);
        C2(1, parcelB2);
    }
}
