package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry[] newArray(int i) {
            return new MdtaMetadataEntry[i];
        }
    }

    /* synthetic */ MdtaMetadataEntry(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.a.equals(mdtaMetadataEntry.a) && Arrays.equals(this.b, mdtaMetadataEntry.b) && this.c == mdtaMetadataEntry.c && this.d == mdtaMetadataEntry.d;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "mdta: key=" + this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i, int i2) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.a = (String) AbstractC9683aN7.j(parcel.readString());
        this.b = (byte[]) AbstractC9683aN7.j(parcel.createByteArray());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
}
