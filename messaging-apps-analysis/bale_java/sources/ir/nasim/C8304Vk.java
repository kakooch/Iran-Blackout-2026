package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Vk, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8304Vk {
    private final List a;

    public C8304Vk(List list) {
        AbstractC13042fc3.i(list, "albumItems");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C8304Vk) && AbstractC13042fc3.d(this.a, ((C8304Vk) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Album(albumItems=" + this.a + Separators.RPAREN;
    }
}
