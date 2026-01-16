package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC9683aN7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();
    public final String a;
    public final Uri b;
    public final String c;
    public final List d;
    public final byte[] e;
    public final String f;
    public final byte[] g;

    public static class UnsupportedRequestException extends IOException {
    }

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    }

    DownloadRequest(Parcel parcel) {
        this.a = (String) AbstractC9683aN7.j(parcel.readString());
        this.b = Uri.parse((String) AbstractC9683aN7.j(parcel.readString()));
        this.c = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.d = Collections.unmodifiableList(arrayList);
        this.e = parcel.createByteArray();
        this.f = parcel.readString();
        this.g = (byte[]) AbstractC9683aN7.j(parcel.createByteArray());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.a.equals(downloadRequest.a) && this.b.equals(downloadRequest.b) && AbstractC9683aN7.c(this.c, downloadRequest.c) && this.d.equals(downloadRequest.d) && Arrays.equals(this.e, downloadRequest.e) && AbstractC9683aN7.c(this.f, downloadRequest.f) && Arrays.equals(this.g, downloadRequest.g);
    }

    public final int hashCode() {
        int iHashCode = ((this.a.hashCode() * 961) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + Arrays.hashCode(this.e)) * 31;
        String str2 = this.f;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.g);
    }

    public String toString() {
        return this.c + ":" + this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b.toString());
        parcel.writeString(this.c);
        parcel.writeInt(this.d.size());
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            parcel.writeParcelable((Parcelable) this.d.get(i2), 0);
        }
        parcel.writeByteArray(this.e);
        parcel.writeString(this.f);
        parcel.writeByteArray(this.g);
    }
}
