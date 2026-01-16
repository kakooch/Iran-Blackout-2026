package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.C5045Hq7;
import ir.nasim.EW4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    }

    public static final class b {
        public final int a;
        public final long b;
        public final long c;

        /* synthetic */ b(int i, long j, long j2, a aVar) {
            this(i, j, j2);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }

        private b(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }
    }

    /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    static SpliceInsertCommand a(EW4 ew4, long j, C5045Hq7 c5045Hq7) {
        List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int iL;
        int iF;
        int iF2;
        boolean z4;
        boolean z5;
        long jH;
        long jH2 = ew4.H();
        boolean z6 = (ew4.F() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z6) {
            list = listEmptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            iL = 0;
            iF = 0;
            iF2 = 0;
            z4 = false;
        } else {
            int iF3 = ew4.F();
            boolean z7 = (iF3 & 128) != 0;
            boolean z8 = (iF3 & 64) != 0;
            boolean z9 = (iF3 & 32) != 0;
            boolean z10 = (iF3 & 16) != 0;
            long jB = (!z8 || z10) ? -9223372036854775807L : TimeSignalCommand.b(ew4, j);
            if (!z8) {
                int iF4 = ew4.F();
                ArrayList arrayList = new ArrayList(iF4);
                for (int i = 0; i < iF4; i++) {
                    int iF5 = ew4.F();
                    long jB2 = !z10 ? TimeSignalCommand.b(ew4, j) : -9223372036854775807L;
                    arrayList.add(new b(iF5, jB2, c5045Hq7.b(jB2), null));
                }
                listEmptyList = arrayList;
            }
            if (z9) {
                long jF = ew4.F();
                boolean z11 = (128 & jF) != 0;
                jH = ((((jF & 1) << 32) | ew4.H()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                jH = -9223372036854775807L;
            }
            iL = ew4.L();
            z4 = z8;
            iF = ew4.F();
            iF2 = ew4.F();
            list = listEmptyList;
            long j4 = jB;
            z3 = z5;
            j3 = jH;
            z2 = z10;
            z = z7;
            j2 = j4;
        }
        return new SpliceInsertCommand(jH2, z6, z, z4, z2, j2, c5045Hq7.b(j2), list, z3, j3, iL, iF, iF2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((b) this.h.get(i2)).b(parcel);
        }
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List list, boolean z5, long j4, int i, int i2, int i3) {
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(b.a(parcel));
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }
}
