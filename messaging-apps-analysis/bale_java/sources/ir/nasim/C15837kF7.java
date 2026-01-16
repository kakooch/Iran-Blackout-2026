package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.kF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15837kF7 extends AbstractC20556sC7 {
    private final int a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15837kF7(int i, List list) {
        super(null);
        AbstractC13042fc3.i(list, "pinnedPeers");
        this.a = i;
        this.b = list;
    }

    public final int a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15837kF7)) {
            return false;
        }
        C15837kF7 c15837kF7 = (C15837kF7) obj;
        return this.a == c15837kF7.a && AbstractC13042fc3.d(this.b, c15837kF7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdatePinnedDialogsChanged(folderId=" + this.a + ", pinnedPeers=" + this.b + Separators.RPAREN;
    }
}
