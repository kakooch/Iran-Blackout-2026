package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzdy extends com.google.android.gms.internal.measurement.zzb implements zzdz {
    public zzdy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzas) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzas.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zze((zzkg) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzkg.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzf((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zzg((zzas) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzas.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzh((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkg> listZzi = zzi((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR), com.google.android.gms.internal.measurement.zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzi);
                return true;
            case 9:
                byte[] bArrZzj = zzj((zzas) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzas.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZzj);
                return true;
            case 10:
                zzk(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String strZzl = zzl((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            case 12:
                zzm((zzaa) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzaa.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzn((zzaa) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzaa.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkg> listZzo = zzo(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzc.zza(parcel), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzo);
                return true;
            case 15:
                List<zzkg> listZzp = zzp(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzp);
                return true;
            case 16:
                List<zzaa> listZzq = zzq(parcel.readString(), parcel.readString(), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzq);
                return true;
            case 17:
                List<zzaa> listZzr = zzr(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzr);
                return true;
            case 18:
                zzs((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                zzt((Bundle) com.google.android.gms.internal.measurement.zzc.zzc(parcel, Bundle.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                zzu((zzp) com.google.android.gms.internal.measurement.zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
