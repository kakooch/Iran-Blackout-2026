package ir.nasim;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: ir.nasim.al8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9911al8 {
    private static final ClassLoader a = AbstractC9911al8.class.getClassLoader();

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
