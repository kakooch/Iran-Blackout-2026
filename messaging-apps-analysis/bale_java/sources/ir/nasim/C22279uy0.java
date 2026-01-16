package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* renamed from: ir.nasim.uy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22279uy0 {
    private final Map a;

    public C22279uy0(Map map) {
        AbstractC13042fc3.i(map, "configs");
        this.a = map;
    }

    public final Map a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22279uy0) && AbstractC13042fc3.d(this.a, ((C22279uy0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "CallRemoteConfigs2(configs=" + this.a + Separators.RPAREN;
    }
}
