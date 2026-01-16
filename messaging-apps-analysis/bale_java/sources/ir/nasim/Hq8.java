package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.internal.location.zzg;

/* loaded from: classes3.dex */
public abstract class Hq8 extends AbstractBinderC11896dj8 implements InterfaceC13224fr8 {
    public Hq8() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // ir.nasim.AbstractBinderC11896dj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzg zzgVar = (zzg) Gk8.a(parcel, zzg.CREATOR);
            Gk8.b(parcel);
            r2(zzgVar);
        } else {
            if (i != 2) {
                return false;
            }
            g();
        }
        return true;
    }
}
