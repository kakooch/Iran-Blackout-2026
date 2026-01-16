package ir.nasim;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.Mt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6241Mt7 implements InterfaceC2029g {
    private static final String c = AbstractC9683aN7.r0(0);
    private static final String d = AbstractC9683aN7.r0(1);
    public static final InterfaceC2029g.a e = new InterfaceC2029g.a() { // from class: ir.nasim.Lt7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C6241Mt7.d(bundle);
        }
    };
    public final TrackGroup a;
    public final AbstractC12710f43 b;

    public C6241Mt7(TrackGroup trackGroup, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.a)) {
            throw new IndexOutOfBoundsException();
        }
        this.a = trackGroup;
        this.b = AbstractC12710f43.O(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6241Mt7 d(Bundle bundle) {
        return new C6241Mt7((TrackGroup) TrackGroup.h.a((Bundle) AbstractC20011rK.e(bundle.getBundle(c))), AbstractC8236Vc3.c((int[]) AbstractC20011rK.e(bundle.getIntArray(d))));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c, this.a.a());
        bundle.putIntArray(d, AbstractC8236Vc3.l(this.b));
        return bundle;
    }

    public int c() {
        return this.a.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C6241Mt7.class != obj.getClass()) {
            return false;
        }
        C6241Mt7 c6241Mt7 = (C6241Mt7) obj;
        return this.a.equals(c6241Mt7.a) && this.b.equals(c6241Mt7.b);
    }

    public int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }
}
