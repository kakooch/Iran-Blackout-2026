package ir.nasim;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

/* renamed from: ir.nasim.sp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20917sp2 extends AbstractC11828dd0 {
    private final int h;
    private final Object i;

    public C20917sp2(TrackGroup trackGroup, int i, int i2) {
        this(trackGroup, i, i2, 0, null);
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public int a() {
        return 0;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public Object i() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public int s() {
        return this.h;
    }

    public C20917sp2(TrackGroup trackGroup, int i, int i2, int i3, Object obj) {
        super(trackGroup, new int[]{i}, i2);
        this.h = i3;
        this.i = obj;
    }

    @Override // ir.nasim.InterfaceC13679ge2
    public void p(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }
}
