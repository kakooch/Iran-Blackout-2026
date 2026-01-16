package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.jG4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
class C15252jG4 implements InterfaceC14654iG4 {
    private Map a = new HashMap();

    C15252jG4() {
    }

    private long d(C13461gG4 c13461gG4) {
        Long l = (Long) this.a.get(c13461gG4);
        if (l != null) {
            return l.longValue() - System.currentTimeMillis();
        }
        return 0L;
    }

    private boolean e(C13461gG4 c13461gG4) {
        Map map = this.a;
        if (map == null || c13461gG4 == null) {
            return false;
        }
        return map.containsKey(c13461gG4);
    }

    private void f(C13461gG4 c13461gG4, long j) {
        this.a.put(c13461gG4, Long.valueOf(System.currentTimeMillis() + j));
    }

    private void g() {
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            if (d((C13461gG4) ((Map.Entry) it.next()).getKey()) <= 0) {
                it.remove();
            }
        }
    }

    @Override // ir.nasim.InterfaceC14654iG4
    public void a(C13461gG4 c13461gG4, long j) {
        try {
            if (this.a == null) {
                this.a = new HashMap();
            }
            f(c13461gG4, j);
            g();
        } catch (Exception e) {
            C19406qI3.a("OTPTransactionsManagerImpl", e.getMessage(), new Object[0]);
        }
    }

    @Override // ir.nasim.InterfaceC14654iG4
    public int b(C13461gG4 c13461gG4) {
        try {
            if (e(c13461gG4)) {
                long jD = d(c13461gG4);
                if (jD > 0) {
                    return (int) (jD / 1000);
                }
            }
        } catch (Exception e) {
            C19406qI3.a("OTPTransactionsManagerImpl", e.getMessage(), new Object[0]);
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC14654iG4
    public boolean c(C13461gG4 c13461gG4) {
        return b(c13461gG4) > 0;
    }
}
