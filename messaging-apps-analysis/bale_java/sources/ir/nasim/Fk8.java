package ir.nasim;

import android.os.Parcel;

/* loaded from: classes3.dex */
public abstract class Fk8 {
    private static final ClassLoader a = Fk8.class.getClassLoader();

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
