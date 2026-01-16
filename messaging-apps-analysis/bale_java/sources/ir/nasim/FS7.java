package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Map;

/* loaded from: classes4.dex */
public final class FS7 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final C11458d25 a;
    private final long b;
    private final Long c;
    private final ExPeerType d;
    private final boolean e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public FS7(C11458d25 c11458d25, long j, Long l, ExPeerType exPeerType, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = j;
        this.c = l;
        this.d = exPeerType;
        this.e = z;
    }

    public final Map a() {
        XV4 xv4A = AbstractC4616Fw7.a("peer_id", Integer.valueOf(this.a.getPeerId()));
        XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", AbstractC7042Qa2.a(this.d));
        XV4 xv4A3 = AbstractC4616Fw7.a("initial_size", Integer.valueOf((int) this.b));
        Long l = this.c;
        return AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("compressed_size", Integer.valueOf(l != null ? (int) l.longValue() : -1)), AbstractC4616Fw7.a("selected_format", Integer.valueOf(this.c == null ? 1 : 2)), AbstractC4616Fw7.a("has_compressed_option", Boolean.valueOf(this.e)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FS7)) {
            return false;
        }
        FS7 fs7 = (FS7) obj;
        return AbstractC13042fc3.d(this.a, fs7.a) && this.b == fs7.b && AbstractC13042fc3.d(this.c, fs7.c) && this.d == fs7.d && this.e == fs7.e;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        Long l = this.c;
        return ((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "VideoCompressionEvent(peer=" + this.a + ", initialSize=" + this.b + ", compressedSize=" + this.c + ", exPeerType=" + this.d + ", compressWasEnabled=" + this.e + Separators.RPAREN;
    }
}
