package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.aA3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9562aA3 {
    public static final int f = J44.w;
    private final long a;
    private final long b;
    private final J44 c;
    private final int d;
    private final ExPeerType e;

    public C9562aA3(long j, long j2, J44 j44, int i, ExPeerType exPeerType) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = j;
        this.b = j2;
        this.c = j44;
        this.d = i;
        this.e = exPeerType;
    }

    public final C9562aA3 a(long j, long j2, J44 j44, int i, ExPeerType exPeerType) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        return new C9562aA3(j, j2, j44, i, exPeerType);
    }

    public final long c() {
        return this.b;
    }

    public final ExPeerType d() {
        return this.e;
    }

    public final J44 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9562aA3)) {
            return false;
        }
        C9562aA3 c9562aA3 = (C9562aA3) obj;
        return this.a == c9562aA3.a && this.b == c9562aA3.b && AbstractC13042fc3.d(this.c, c9562aA3.c) && this.d == c9562aA3.d && this.e == c9562aA3.e;
    }

    public final long f() {
        return this.a;
    }

    public final int g() {
        return this.d;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "Link(rid=" + this.a + ", date=" + this.b + ", message=" + this.c + ", senderId=" + this.d + ", exPeerType=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C9562aA3(long j, long j2, J44 j44, int i, ExPeerType exPeerType, int i2, ED1 ed1) {
        this(j, j2, j44, i, (i2 & 16) != 0 ? ExPeerType.UNKNOWN : exPeerType);
    }
}
