package com.google.android.exoplayer2.offline;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new a();
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StreamKey[] newArray(int i) {
            return new StreamKey[i];
        }
    }

    StreamKey(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        int i = parcel.readInt();
        this.c = i;
        this.d = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(StreamKey streamKey) {
        int i = this.a - streamKey.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - streamKey.b;
        return i2 == 0 ? this.c - streamKey.c : i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.a == streamKey.a && this.b == streamKey.b && this.c == streamKey.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return this.a + Separators.DOT + this.b + Separators.DOT + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
