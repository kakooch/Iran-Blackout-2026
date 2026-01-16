package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.jaryan.discover.model.PeerItem;

/* renamed from: ir.nasim.kZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16017kZ7 {
    private final PeerItem a;
    private final String b;
    private final int c;

    public C16017kZ7(PeerItem peerItem, String str, int i) {
        AbstractC13042fc3.i(peerItem, "peerItem");
        AbstractC13042fc3.i(str, "title");
        this.a = peerItem;
        this.b = str;
        this.c = i;
    }

    public final PeerItem a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16017kZ7)) {
            return false;
        }
        C16017kZ7 c16017kZ7 = (C16017kZ7) obj;
        return AbstractC13042fc3.d(this.a, c16017kZ7.a) && AbstractC13042fc3.d(this.b, c16017kZ7.b) && this.c == c16017kZ7.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "VitrineEventModel(peerItem=" + this.a + ", title=" + this.b + ", sectionId=" + this.c + Separators.RPAREN;
    }
}
