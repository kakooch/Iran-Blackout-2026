package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    private final Id3Frame[] f;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = strArr;
        this.f = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.c == chapterTocFrame.c && this.d == chapterTocFrame.d && AbstractC9683aN7.c(this.b, chapterTocFrame.b) && Arrays.equals(this.e, chapterTocFrame.e) && Arrays.equals(this.f, chapterTocFrame.f);
    }

    public int hashCode() {
        int i = (((527 + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.e);
        parcel.writeInt(this.f.length);
        for (Id3Frame id3Frame : this.f) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.b = (String) AbstractC9683aN7.j(parcel.readString());
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = (String[]) AbstractC9683aN7.j(parcel.createStringArray());
        int i = parcel.readInt();
        this.f = new Id3Frame[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
