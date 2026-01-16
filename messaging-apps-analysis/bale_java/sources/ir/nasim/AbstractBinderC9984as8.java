package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: ir.nasim.as8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC9984as8 extends Zi8 implements Gr8 {
    public AbstractBinderC9984as8() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // ir.nasim.Zi8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                J0((Status) AbstractC10531bl8.a(parcel, Status.CREATOR));
                return true;
            case 2:
                a((Status) AbstractC10531bl8.a(parcel, Status.CREATOR));
                return true;
            case 3:
                G((Status) AbstractC10531bl8.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 4:
                Y0((Status) AbstractC10531bl8.a(parcel, Status.CREATOR));
                return true;
            case 5:
                c1((Status) AbstractC10531bl8.a(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 6:
                d2((Status) AbstractC10531bl8.a(parcel, Status.CREATOR), (zze[]) parcel.createTypedArray(zze.CREATOR));
                return true;
            case 7:
                L((DataHolder) AbstractC10531bl8.a(parcel, DataHolder.CREATOR));
                return true;
            case 8:
                E0((Status) AbstractC10531bl8.a(parcel, Status.CREATOR), (zzc) AbstractC10531bl8.a(parcel, zzc.CREATOR));
                return true;
            case 9:
                a1((Status) AbstractC10531bl8.a(parcel, Status.CREATOR), (zzc) AbstractC10531bl8.a(parcel, zzc.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
