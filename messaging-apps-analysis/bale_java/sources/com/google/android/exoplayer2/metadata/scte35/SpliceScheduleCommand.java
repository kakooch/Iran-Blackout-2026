package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.EW4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    public static final class b {
        public final int a;
        public final long b;

        /* synthetic */ b(int i, long j, a aVar) {
            this(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }

        private b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    static SpliceScheduleCommand a(EW4 ew4) {
        int iF = ew4.F();
        ArrayList arrayList = new ArrayList(iF);
        for (int i = 0; i < iF; i++) {
            arrayList.add(c.e(ew4));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((c) this.a.get(i2)).f(parcel);
        }
    }

    private SpliceScheduleCommand(List list) {
        this.a = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(c.d(parcel));
        }
        this.a = Collections.unmodifiableList(arrayList);
    }

    public static final class c {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private c(long j, boolean z, boolean z2, boolean z3, List list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.a = j;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c e(EW4 ew4) {
            ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int iF;
            boolean z3;
            boolean z4;
            long jH;
            long jH2 = ew4.H();
            boolean z5 = (ew4.F() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                iF = 0;
                z3 = false;
            } else {
                int iF2 = ew4.F();
                boolean z6 = (iF2 & 128) != 0;
                boolean z7 = (iF2 & 64) != 0;
                boolean z8 = (iF2 & 32) != 0;
                long jH3 = z7 ? ew4.H() : -9223372036854775807L;
                if (!z7) {
                    int iF3 = ew4.F();
                    ArrayList arrayList3 = new ArrayList(iF3);
                    for (int i3 = 0; i3 < iF3; i3++) {
                        arrayList3.add(new b(ew4.F(), ew4.H(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long jF = ew4.F();
                    boolean z9 = (128 & jF) != 0;
                    jH = ((((jF & 1) << 32) | ew4.H()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    jH = -9223372036854775807L;
                }
                int iL = ew4.L();
                int iF4 = ew4.F();
                z3 = z7;
                iF = ew4.F();
                j2 = jH;
                arrayList = arrayList2;
                long j3 = jH3;
                i = iL;
                i2 = iF4;
                j = j3;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new c(jH2, z5, z, z3, arrayList, j, z2, j2, i, i2, iF);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            int size = this.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((b) this.f.get(i)).d(parcel);
            }
            parcel.writeLong(this.e);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        private c(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(b.c(parcel));
            }
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }
}
