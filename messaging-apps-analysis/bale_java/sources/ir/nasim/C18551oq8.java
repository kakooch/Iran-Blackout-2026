package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;
import java.util.Arrays;

/* renamed from: ir.nasim.oq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C18551oq8 implements Serializable, InterfaceC16778lq8 {
    final Object a;

    C18551oq8(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C18551oq8)) {
            return false;
        }
        Object obj2 = this.a;
        Object obj3 = ((C18551oq8) obj).a;
        return obj2 == obj3 || obj2.equals(obj3);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.a + Separators.RPAREN;
    }

    @Override // ir.nasim.InterfaceC16778lq8
    public final Object zza() {
        return this.a;
    }
}
