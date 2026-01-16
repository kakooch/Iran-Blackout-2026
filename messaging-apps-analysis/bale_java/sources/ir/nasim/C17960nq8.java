package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C17960nq8 implements InterfaceC16778lq8 {
    volatile InterfaceC16778lq8 a;
    volatile boolean b;
    Object c;

    C17960nq8(InterfaceC16778lq8 interfaceC16778lq8) {
        interfaceC16778lq8.getClass();
        this.a = interfaceC16778lq8;
    }

    public final String toString() {
        Object obj = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.c + Separators.GREATER_THAN;
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
                        InterfaceC16778lq8 interfaceC16778lq8 = this.a;
                        interfaceC16778lq8.getClass();
                        Object objZza = interfaceC16778lq8.zza();
                        this.c = objZza;
                        this.b = true;
                        this.a = null;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.c;
    }
}
