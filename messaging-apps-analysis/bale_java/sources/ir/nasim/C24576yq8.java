package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.face.internal.client.FaceParcel;

/* renamed from: ir.nasim.yq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24576yq8 extends AbstractC15526jj8 implements Oo8 {
    C24576yq8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // ir.nasim.Oo8
    public final FaceParcel[] b1(XZ2 xz2, XZ2 xz22, XZ2 xz23, int i, int i2, int i3, int i4, int i5, int i6, zzs zzsVar) {
        Parcel parcelB2 = B2();
        Ml8.a(parcelB2, xz2);
        Ml8.a(parcelB2, xz22);
        Ml8.a(parcelB2, xz23);
        parcelB2.writeInt(i);
        parcelB2.writeInt(i2);
        parcelB2.writeInt(i3);
        parcelB2.writeInt(i4);
        parcelB2.writeInt(i5);
        parcelB2.writeInt(i6);
        Ml8.b(parcelB2, zzsVar);
        Parcel parcelC2 = C2(4, parcelB2);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelC2.createTypedArray(FaceParcel.CREATOR);
        parcelC2.recycle();
        return faceParcelArr;
    }

    @Override // ir.nasim.Oo8
    public final FaceParcel[] u0(XZ2 xz2, zzs zzsVar) {
        Parcel parcelB2 = B2();
        Ml8.a(parcelB2, xz2);
        Ml8.b(parcelB2, zzsVar);
        Parcel parcelC2 = C2(1, parcelB2);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelC2.createTypedArray(FaceParcel.CREATOR);
        parcelC2.recycle();
        return faceParcelArr;
    }

    @Override // ir.nasim.Oo8
    public final void zza() {
        D2(3, B2());
    }
}
