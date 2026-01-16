package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle createBundle(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + size);
        return bundle;
    }

    public static int[] createIntArray(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + size);
        return iArrCreateIntArray;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + size);
        return tCreateFromParcel;
    }

    public static String createString(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + size);
        return string;
    }

    public static String[] createStringArray(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + size);
        return strArrCreateStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + size);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + size);
        return tArr;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + size);
        return arrayListCreateTypedArrayList;
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i, parcel);
    }

    public static int getFieldId(int i) {
        return (char) i;
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static double readDouble(Parcel parcel, int i) {
        zzb(parcel, i, 8);
        return parcel.readDouble();
    }

    public static float readFloat(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readFloat();
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + size);
        return strongBinder;
    }

    public static int readInt(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt();
    }

    public static long readLong(Parcel parcel, int i) {
        zzb(parcel, i, 8);
        return parcel.readLong();
    }

    public static int readSize(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    public static int validateObjectHeader(Parcel parcel) {
        int header = readHeader(parcel);
        int size = readSize(parcel, header);
        int iDataPosition = parcel.dataPosition();
        if (getFieldId(header) != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(header))), parcel);
        }
        int i = size + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
    }

    private static void zzb(Parcel parcel, int i, int i2) {
        int size = readSize(parcel, i);
        if (size == i2) {
            return;
        }
        throw new ParseException("Expected size " + i2 + " got " + size + " (0x" + Integer.toHexString(size) + ")", parcel);
    }
}
