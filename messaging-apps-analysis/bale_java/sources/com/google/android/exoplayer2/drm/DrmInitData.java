package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();
    private final SchemeData[] a;
    private int b;
    public final String c;
    public final int d;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();
        private int a;
        public final UUID b;
        public final String c;
        public final String d;
        public final byte[] e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public SchemeData a(byte[] bArr) {
            return new SchemeData(this.b, this.c, this.d, bArr);
        }

        public boolean b() {
            return this.e != null;
        }

        public boolean c(UUID uuid) {
            return AbstractC9350Zo0.a.equals(this.b) || uuid.equals(this.b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return AbstractC9683aN7.c(this.c, schemeData.c) && AbstractC9683aN7.c(this.d, schemeData.d) && AbstractC9683aN7.c(this.b, schemeData.b) && Arrays.equals(this.e, schemeData.e);
        }

        public int hashCode() {
            if (this.a == 0) {
                int iHashCode = this.b.hashCode() * 31;
                String str = this.c;
                this.a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d.hashCode()) * 31) + Arrays.hashCode(this.e);
            }
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.b.getMostSignificantBits());
            parcel.writeLong(this.b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeByteArray(this.e);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            this.b = (UUID) AbstractC20011rK.e(uuid);
            this.c = str;
            this.d = (String) AbstractC20011rK.e(str2);
            this.e = bArr;
        }

        SchemeData(Parcel parcel) {
            this.b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            this.d = (String) AbstractC9683aN7.j(parcel.readString());
            this.e = parcel.createByteArray();
        }
    }

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    }

    public DrmInitData(List list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    private static boolean b(ArrayList arrayList, int i, UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (((SchemeData) arrayList.get(i2)).b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static DrmInitData d(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.c;
            for (SchemeData schemeData : drmInitData.a) {
                if (schemeData.b()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.c;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.a) {
                if (schemeData2.b() && !b(arrayList, size, schemeData2.b)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = AbstractC9350Zo0.a;
        return uuid.equals(schemeData.b) ? uuid.equals(schemeData2.b) ? 0 : 1 : schemeData.b.compareTo(schemeData2.b);
    }

    public DrmInitData c(String str) {
        return AbstractC9683aN7.c(this.c, str) ? this : new DrmInitData(str, false, this.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SchemeData e(int i) {
        return this.a[i];
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return AbstractC9683aN7.c(this.c, drmInitData.c) && Arrays.equals(this.a, drmInitData.a);
    }

    public DrmInitData f(DrmInitData drmInitData) {
        String str;
        String str2 = this.c;
        AbstractC20011rK.g(str2 == null || (str = drmInitData.c) == null || TextUtils.equals(str2, str));
        String str3 = this.c;
        if (str3 == null) {
            str3 = drmInitData.c;
        }
        return new DrmInitData(str3, (SchemeData[]) AbstractC9683aN7.F0(this.a, drmInitData.a));
    }

    public int hashCode() {
        if (this.b == 0) {
            String str = this.c;
            this.b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.a);
        }
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeTypedArray(this.a, 0);
    }

    public DrmInitData(String str, List list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    private DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.c = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.a = schemeDataArr;
        this.d = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    DrmInitData(Parcel parcel) {
        this.c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) AbstractC9683aN7.j((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.a = schemeDataArr;
        this.d = schemeDataArr.length;
    }
}
