package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public abstract class Ul8 extends AbstractBinderC11274cj8 implements Wk8 {
    public Ul8() {
        super("com.google.android.gms.flags.IFlagProvider");
    }

    public static Wk8 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return iInterfaceQueryLocalInterface instanceof Wk8 ? (Wk8) iInterfaceQueryLocalInterface : new Um8(iBinder);
    }

    @Override // ir.nasim.AbstractBinderC11274cj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            init(XZ2.a.C2(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), Fk8.b(parcel), parcel.readInt());
            parcel2.writeNoException();
            Fk8.a(parcel2, booleanFlagValue);
        } else if (i == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else {
            if (i != 5) {
                return false;
            }
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
