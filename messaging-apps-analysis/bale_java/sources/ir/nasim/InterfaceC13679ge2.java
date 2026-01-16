package ir.nasim;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

/* renamed from: ir.nasim.ge2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC13679ge2 extends InterfaceC5774Kt7 {

    /* renamed from: ir.nasim.ge2$a */
    public static final class a {
        public final TrackGroup a;
        public final int[] b;
        public final int c;

        public a(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public a(TrackGroup trackGroup, int[] iArr, int i) {
            if (iArr.length == 0) {
                AbstractC18815pI3.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.a = trackGroup;
            this.b = iArr;
            this.c = i;
        }
    }

    /* renamed from: ir.nasim.ge2$b */
    public interface b {
        InterfaceC13679ge2[] a(a[] aVarArr, InterfaceC10699c30 interfaceC10699c30, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0);
    }

    int a();

    boolean b(int i, long j);

    boolean c(int i, long j);

    default boolean d(long j, Chunk chunk, List list) {
        return false;
    }

    void f();

    void h(float f);

    Object i();

    void n();

    int o(long j, List list);

    void p(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr);

    int q();

    com.google.android.exoplayer2.X r();

    int s();

    default void j() {
    }

    default void t() {
    }

    default void m(boolean z) {
    }
}
