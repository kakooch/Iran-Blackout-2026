package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Nr8 extends Pg8 implements Op8 {
    public static Op8 B2(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
        return iInterfaceQueryLocalInterface instanceof Op8 ? (Op8) iInterfaceQueryLocalInterface : new C15606jr8(iBinder);
    }
}
