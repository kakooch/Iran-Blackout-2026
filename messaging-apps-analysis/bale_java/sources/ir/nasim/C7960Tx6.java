package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Tx6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7960Tx6 {
    private final C11458d25 a;
    private final String b;
    private final boolean c;
    private final ExPeerType d;

    public C7960Tx6(C11458d25 c11458d25, String str, boolean z, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = c11458d25;
        this.b = str;
        this.c = z;
        this.d = exPeerType;
    }

    public static /* synthetic */ C7960Tx6 b(C7960Tx6 c7960Tx6, C11458d25 c11458d25, String str, boolean z, ExPeerType exPeerType, int i, Object obj) {
        if ((i & 1) != 0) {
            c11458d25 = c7960Tx6.a;
        }
        if ((i & 2) != 0) {
            str = c7960Tx6.b;
        }
        if ((i & 4) != 0) {
            z = c7960Tx6.c;
        }
        if ((i & 8) != 0) {
            exPeerType = c7960Tx6.d;
        }
        return c7960Tx6.a(c11458d25, str, z, exPeerType);
    }

    public final C7960Tx6 a(C11458d25 c11458d25, String str, boolean z, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        return new C7960Tx6(c11458d25, str, z, exPeerType);
    }

    public final boolean c() {
        return this.c;
    }

    public final ExPeerType d() {
        return this.d;
    }

    public final C11458d25 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7960Tx6)) {
            return false;
        }
        C7960Tx6 c7960Tx6 = (C7960Tx6) obj;
        return AbstractC13042fc3.d(this.a, c7960Tx6.a) && AbstractC13042fc3.d(this.b, c7960Tx6.b) && this.c == c7960Tx6.c && this.d == c7960Tx6.d;
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ShareToDialogState(peer=" + this.a + ", title=" + this.b + ", canSendMessage=" + this.c + ", exPeerType=" + this.d + Separators.RPAREN;
    }
}
