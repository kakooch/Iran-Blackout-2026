package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    private int f;
    private static final X g = new X.b().g0("application/id3").G();
    private static final X h = new X.b().g0("application/x-scte35").G();
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = bArr;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public byte[] R1() {
        if (Z() != null) {
            return this.e;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public X Z() {
        String str = this.a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return g;
            default:
                return null;
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
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.c == eventMessage.c && this.d == eventMessage.d && AbstractC9683aN7.c(this.a, eventMessage.a) && AbstractC9683aN7.c(this.b, eventMessage.b) && Arrays.equals(this.e, eventMessage.e);
    }

    public int hashCode() {
        if (this.f == 0) {
            String str = this.a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.c;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.d;
            this.f = ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.e);
        }
        return this.f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeByteArray(this.e);
    }

    EventMessage(Parcel parcel) {
        this.a = (String) AbstractC9683aN7.j(parcel.readString());
        this.b = (String) AbstractC9683aN7.j(parcel.readString());
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = (byte[]) AbstractC9683aN7.j(parcel.createByteArray());
    }
}
