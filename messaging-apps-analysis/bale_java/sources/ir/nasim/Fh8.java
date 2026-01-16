package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* loaded from: classes3.dex */
public final class Fh8 extends Gg8 implements Mh8 {
    Fh8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // ir.nasim.Mh8
    public final zzq N1(zzo zzoVar) {
        Parcel parcelC2 = C2();
        Ek8.c(parcelC2, zzoVar);
        Parcel parcelB2 = B2(6, parcelC2);
        zzq zzqVar = (zzq) Ek8.a(parcelB2, zzq.CREATOR);
        parcelB2.recycle();
        return zzqVar;
    }

    @Override // ir.nasim.Mh8
    public final zzq Y1(zzo zzoVar) {
        Parcel parcelC2 = C2();
        Ek8.c(parcelC2, zzoVar);
        Parcel parcelB2 = B2(8, parcelC2);
        zzq zzqVar = (zzq) Ek8.a(parcelB2, zzq.CREATOR);
        parcelB2.recycle();
        return zzqVar;
    }

    @Override // ir.nasim.Mh8
    public final boolean f0(zzs zzsVar, XZ2 xz2) {
        Parcel parcelC2 = C2();
        Ek8.c(parcelC2, zzsVar);
        Ek8.d(parcelC2, xz2);
        Parcel parcelB2 = B2(5, parcelC2);
        boolean zE = Ek8.e(parcelB2);
        parcelB2.recycle();
        return zE;
    }

    @Override // ir.nasim.Mh8
    public final boolean j() {
        Parcel parcelB2 = B2(7, C2());
        boolean zE = Ek8.e(parcelB2);
        parcelB2.recycle();
        return zE;
    }
}
