package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.Ki0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5668Ki0 {
    private final ExPeerType a;
    private C11458d25 b;

    public C5668Ki0(ExPeerType exPeerType, C11458d25 c11458d25) {
        this.a = exPeerType;
        this.b = c11458d25;
    }

    public final ExPeerType a() {
        return this.a;
    }

    public final C11458d25 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5668Ki0)) {
            return false;
        }
        C5668Ki0 c5668Ki0 = (C5668Ki0) obj;
        return this.a == c5668Ki0.a && AbstractC13042fc3.d(this.b, c5668Ki0.b);
    }

    public int hashCode() {
        ExPeerType exPeerType = this.a;
        int iHashCode = (exPeerType == null ? 0 : exPeerType.hashCode()) * 31;
        C11458d25 c11458d25 = this.b;
        return iHashCode + (c11458d25 != null ? c11458d25.hashCode() : 0);
    }

    public String toString() {
        return "BotData(exPeerType=" + this.a + ", peer=" + this.b + Separators.RPAREN;
    }
}
