package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.C24452ye4;
import ir.nasim.C5045Hq7;
import ir.nasim.DW4;
import ir.nasim.EW4;
import ir.nasim.NC6;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class a extends NC6 {
    private final EW4 a = new EW4();
    private final DW4 b = new DW4();
    private C5045Hq7 c;

    @Override // ir.nasim.NC6
    protected Metadata b(C24452ye4 c24452ye4, ByteBuffer byteBuffer) {
        C5045Hq7 c5045Hq7 = this.c;
        if (c5045Hq7 == null || c24452ye4.i != c5045Hq7.e()) {
            C5045Hq7 c5045Hq72 = new C5045Hq7(c24452ye4.e);
            this.c = c5045Hq72;
            c5045Hq72.a(c24452ye4.e - c24452ye4.i);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.a.Q(bArrArray, iLimit);
        this.b.o(bArrArray, iLimit);
        this.b.r(39);
        long jH = (this.b.h(1) << 32) | this.b.h(32);
        this.b.r(20);
        int iH = this.b.h(12);
        int iH2 = this.b.h(8);
        this.a.T(14);
        Metadata.Entry entryA = iH2 != 0 ? iH2 != 255 ? iH2 != 4 ? iH2 != 5 ? iH2 != 6 ? null : TimeSignalCommand.a(this.a, jH, this.c) : SpliceInsertCommand.a(this.a, jH, this.c) : SpliceScheduleCommand.a(this.a) : PrivateCommand.a(this.a, iH, jH) : new SpliceNullCommand();
        return entryA == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entryA);
    }
}
