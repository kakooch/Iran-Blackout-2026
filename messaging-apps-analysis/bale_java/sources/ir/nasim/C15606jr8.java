package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.vision.face.internal.client.zzf;

/* renamed from: ir.nasim.jr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15606jr8 extends AbstractC15526jj8 implements Op8 {
    C15606jr8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    @Override // ir.nasim.Op8
    public final Oo8 Y(XZ2 xz2, zzf zzfVar) {
        Oo8 c24576yq8;
        Parcel parcelB2 = B2();
        Ml8.a(parcelB2, xz2);
        Ml8.b(parcelB2, zzfVar);
        Parcel parcelC2 = C2(1, parcelB2);
        IBinder strongBinder = parcelC2.readStrongBinder();
        if (strongBinder == null) {
            c24576yq8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            c24576yq8 = iInterfaceQueryLocalInterface instanceof Oo8 ? (Oo8) iInterfaceQueryLocalInterface : new C24576yq8(strongBinder);
        }
        parcelC2.recycle();
        return c24576yq8;
    }
}
