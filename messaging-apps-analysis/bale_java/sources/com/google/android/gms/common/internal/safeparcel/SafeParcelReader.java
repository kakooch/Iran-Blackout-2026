package com.google.android.gms.common.internal.safeparcel;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static void A(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + z(parcel, i));
    }

    public static int B(Parcel parcel) {
        int iT = t(parcel);
        int iZ = z(parcel, iT);
        int iL = l(iT);
        int iDataPosition = parcel.dataPosition();
        if (iL != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iT))), parcel);
        }
        int i = iZ + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
    }

    private static void C(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        throw new ParseException("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + Separators.RPAREN, parcel);
    }

    private static void D(Parcel parcel, int i, int i2) {
        int iZ = z(parcel, i);
        if (iZ == i2) {
            return;
        }
        throw new ParseException("Expected size " + i2 + " got " + iZ + " (0x" + Integer.toHexString(iZ) + Separators.RPAREN, parcel);
    }

    public static Bundle a(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iZ);
        return bundle;
    }

    public static byte[] b(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iZ);
        return bArrCreateByteArray;
    }

    public static byte[][] c(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        byte[][] bArr = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iZ);
        return bArr;
    }

    public static int[] d(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iZ);
        return iArrCreateIntArray;
    }

    public static Parcelable e(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iZ);
        return parcelable;
    }

    public static String f(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iZ);
        return string;
    }

    public static String[] g(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iZ);
        return strArrCreateStringArray;
    }

    public static ArrayList h(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iZ);
        return arrayListCreateStringArrayList;
    }

    public static Object[] i(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iZ);
        return objArrCreateTypedArray;
    }

    public static ArrayList j(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iZ);
        return arrayListCreateTypedArrayList;
    }

    public static void k(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i, parcel);
    }

    public static int l(int i) {
        return (char) i;
    }

    public static boolean m(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean n(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        if (iZ == 0) {
            return null;
        }
        C(parcel, i, iZ, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte o(Parcel parcel, int i) {
        D(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static double p(Parcel parcel, int i) {
        D(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double q(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        if (iZ == 0) {
            return null;
        }
        C(parcel, i, iZ, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float r(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float s(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        if (iZ == 0) {
            return null;
        }
        C(parcel, i, iZ, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int t(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder u(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iZ);
        return strongBinder;
    }

    public static int v(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer w(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        if (iZ == 0) {
            return null;
        }
        C(parcel, i, iZ, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long x(Parcel parcel, int i) {
        D(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long y(Parcel parcel, int i) {
        int iZ = z(parcel, i);
        if (iZ == 0) {
            return null;
        }
        C(parcel, i, iZ, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int z(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }
}
