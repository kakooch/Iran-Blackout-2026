package ir.nasim;

import android.os.Parcel;

/* loaded from: classes3.dex */
public abstract class Yk8 {
    private static final ClassLoader a = Yk8.class.getClassLoader();

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
