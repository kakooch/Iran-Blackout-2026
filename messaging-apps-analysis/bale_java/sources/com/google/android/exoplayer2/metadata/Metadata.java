package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC24852zJ3;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new a();
    private final Entry[] a;
    public final long b;

    public interface Entry extends Parcelable {
        default void R0(C2020b0.b bVar) {
        }

        default byte[] R1() {
            return null;
        }

        default X Z() {
            return null;
        }
    }

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Metadata[] newArray(int i) {
            return new Metadata[i];
        }
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public Metadata a(Entry... entryArr) {
        return entryArr.length == 0 ? this : new Metadata(this.b, (Entry[]) AbstractC9683aN7.F0(this.a, entryArr));
    }

    public Metadata b(Metadata metadata) {
        return metadata == null ? this : a(metadata.a);
    }

    public Metadata c(long j) {
        return this.b == j ? this : new Metadata(j, this.a);
    }

    public Entry d(int i) {
        return this.a[i];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.a.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        return Arrays.equals(this.a, metadata.a) && this.b == metadata.b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + AbstractC24852zJ3.b(this.b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.a));
        if (this.b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.b;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (Entry entry : this.a) {
            parcel.writeParcelable(entry, 0);
        }
        parcel.writeLong(this.b);
    }

    public Metadata(long j, Entry... entryArr) {
        this.b = j;
        this.a = entryArr;
    }

    public Metadata(List list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(long j, List list) {
        this(j, (Entry[]) list.toArray(new Entry[0]));
    }

    Metadata(Parcel parcel) {
        this.a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.a;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                this.b = parcel.readLong();
                return;
            }
        }
    }
}
