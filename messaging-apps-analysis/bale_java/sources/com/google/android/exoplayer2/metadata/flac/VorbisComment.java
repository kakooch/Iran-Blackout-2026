package com.google.android.exoplayer2.metadata.flac;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC9683aN7;

@Deprecated
/* loaded from: classes2.dex */
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a();
    public final String a;
    public final String b;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }
    }

    public VorbisComment(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void R0(C2020b0.b bVar) {
        String str = this.a;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.N(this.b);
                break;
            case "TITLE":
                bVar.m0(this.b);
                break;
            case "DESCRIPTION":
                bVar.U(this.b);
                break;
            case "ALBUMARTIST":
                bVar.M(this.b);
                break;
            case "ARTIST":
                bVar.O(this.b);
                break;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.a.equals(vorbisComment.a) && this.b.equals(vorbisComment.b);
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "VC: " + this.a + Separators.EQUALS + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    protected VorbisComment(Parcel parcel) {
        this.a = (String) AbstractC9683aN7.j(parcel.readString());
        this.b = (String) AbstractC9683aN7.j(parcel.readString());
    }
}
