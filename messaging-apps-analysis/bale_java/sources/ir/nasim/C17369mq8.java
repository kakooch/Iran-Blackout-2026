package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.mq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C17369mq8 implements Serializable, InterfaceC16778lq8 {
    final InterfaceC16778lq8 a;
    volatile transient boolean b;
    transient Object c;

    C17369mq8(InterfaceC16778lq8 interfaceC16778lq8) {
        interfaceC16778lq8.getClass();
        this.a = interfaceC16778lq8;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.b) {
            obj = "<supplier that returned " + this.c + Separators.GREATER_THAN;
        } else {
            obj = this.a;
        }
        sb.append(obj);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }

    @Override // ir.nasim.InterfaceC16778lq8
    public final Object zza() {
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        Object objZza = this.a.zza();
                        this.c = objZza;
                        this.b = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.c;
    }
}
