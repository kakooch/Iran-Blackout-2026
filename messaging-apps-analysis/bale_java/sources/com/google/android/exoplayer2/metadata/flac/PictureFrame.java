package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC12884fL0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EW4;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final byte[] h;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureFrame[] newArray(int i) {
            return new PictureFrame[i];
        }
    }

    public PictureFrame(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = bArr;
    }

    public static PictureFrame a(EW4 ew4) {
        int iO = ew4.o();
        String strD = ew4.D(ew4.o(), AbstractC12884fL0.a);
        String strC = ew4.C(ew4.o());
        int iO2 = ew4.o();
        int iO3 = ew4.o();
        int iO4 = ew4.o();
        int iO5 = ew4.o();
        int iO6 = ew4.o();
        byte[] bArr = new byte[iO6];
        ew4.j(bArr, 0, iO6);
        return new PictureFrame(iO, strD, strC, iO2, iO3, iO4, iO5, bArr);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void R0(C2020b0.b bVar) {
        bVar.I(this.h, this.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.a == pictureFrame.a && this.b.equals(pictureFrame.b) && this.c.equals(pictureFrame.c) && this.d == pictureFrame.d && this.e == pictureFrame.e && this.f == pictureFrame.f && this.g == pictureFrame.g && Arrays.equals(this.h, pictureFrame.h);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + Arrays.hashCode(this.h);
    }

    public String toString() {
        return "Picture: mimeType=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeByteArray(this.h);
    }

    PictureFrame(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = (String) AbstractC9683aN7.j(parcel.readString());
        this.c = (String) AbstractC9683aN7.j(parcel.readString());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (byte[]) AbstractC9683aN7.j(parcel.createByteArray());
    }
}
