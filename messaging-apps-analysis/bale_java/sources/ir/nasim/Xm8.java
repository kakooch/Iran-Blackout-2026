package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
public abstract class Xm8 extends Xi8 implements InterfaceC22770vn8 {
    public Xm8() {
        super("com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    @Override // ir.nasim.Xi8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        x0((Status) Zk8.a(parcel, Status.CREATOR), (zzc) Zk8.a(parcel, zzc.CREATOR));
        return true;
    }
}
