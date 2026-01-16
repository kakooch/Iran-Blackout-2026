package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.C5045Hq7;
import ir.nasim.EW4;

/* loaded from: classes2.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();
    public final long a;
    public final long b;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    }

    /* synthetic */ TimeSignalCommand(long j, long j2, a aVar) {
        this(j, j2);
    }

    static TimeSignalCommand a(EW4 ew4, long j, C5045Hq7 c5045Hq7) {
        long jB = b(ew4, j);
        return new TimeSignalCommand(jB, c5045Hq7.b(jB));
    }

    static long b(EW4 ew4, long j) {
        long jF = ew4.F();
        if ((128 & jF) != 0) {
            return 8589934591L & ((((jF & 1) << 32) | ew4.H()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }

    private TimeSignalCommand(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
