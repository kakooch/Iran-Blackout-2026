package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;

/* loaded from: classes2.dex */
public abstract class Id3Frame implements Metadata.Entry {
    public final String a;

    public Id3Frame(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.a;
    }
}
