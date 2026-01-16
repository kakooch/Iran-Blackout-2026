package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.mi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C17289mi8 implements InterfaceC22720vi8, InterfaceC14926ii8 {
    final Map a = new HashMap();

    public final List a() {
        return new ArrayList(this.a.keySet());
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        C17289mi8 c17289mi8 = new C17289mi8();
        for (Map.Entry entry : this.a.entrySet()) {
            if (entry.getValue() instanceof InterfaceC14926ii8) {
                c17289mi8.a.put((String) entry.getKey(), (InterfaceC22720vi8) entry.getValue());
            } else {
                c17289mi8.a.put((String) entry.getKey(), ((InterfaceC22720vi8) entry.getValue()).d());
            }
        }
        return c17289mi8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C17289mi8) {
            return this.a.equals(((C17289mi8) obj).a);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final boolean f(String str) {
        return this.a.containsKey(str);
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final InterfaceC22720vi8 h(String str) {
        return this.a.containsKey(str) ? (InterfaceC22720vi8) this.a.get(str) : InterfaceC22720vi8.r0;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final void i(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        if (interfaceC22720vi8 == null) {
            this.a.remove(str);
        } else {
            this.a.put(str, interfaceC22720vi8);
        }
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return "[object Object]";
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return Double.valueOf(Double.NaN);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.TRUE;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return AbstractC11264ci8.b(this.a);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        return "toString".equals(str) ? new Ei8(toString()) : AbstractC11264ci8.a(this, new Ei8(str), c20322ro8, list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!this.a.isEmpty()) {
            for (String str : this.a.keySet()) {
                sb.append(String.format("%s: %s,", str, this.a.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
