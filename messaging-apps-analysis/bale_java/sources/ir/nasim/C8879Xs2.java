package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Xs2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8879Xs2 {
    public static final a c = new a(null);
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.Xs2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C8879Xs2(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8879Xs2)) {
            return false;
        }
        C8879Xs2 c8879Xs2 = (C8879Xs2) obj;
        return this.a == c8879Xs2.a && this.b == c8879Xs2.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "FolderUnreadPeerCountExcludingArchivedEntity(folderId=" + this.a + ", unreadPeerCount=" + this.b + Separators.RPAREN;
    }
}
