package ir.nasim;

import ir.nasim.YT4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class ZT4 {
    private final List a;
    private final Integer b;
    private final MT4 c;
    private final int d;

    public ZT4(List list, Integer num, MT4 mt4, int i) {
        AbstractC13042fc3.i(list, "pages");
        AbstractC13042fc3.i(mt4, "config");
        this.a = list;
        this.b = num;
        this.c = mt4;
        this.d = i;
    }

    public final YT4.b.c b(int i) {
        List list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((YT4.b.c) it.next()).f().isEmpty()) {
                int size = i - this.d;
                int i2 = 0;
                while (i2 < AbstractC10360bX0.o(e()) && size > AbstractC10360bX0.o(((YT4.b.c) e().get(i2)).f())) {
                    size -= ((YT4.b.c) e().get(i2)).f().size();
                    i2++;
                }
                return size < 0 ? (YT4.b.c) AbstractC15401jX0.q0(this.a) : (YT4.b.c) this.a.get(i2);
            }
        }
        return null;
    }

    public final Integer c() {
        return this.b;
    }

    public final MT4 d() {
        return this.c;
    }

    public final List e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ZT4) {
            ZT4 zt4 = (ZT4) obj;
            if (AbstractC13042fc3.d(this.a, zt4.a) && AbstractC13042fc3.d(this.b, zt4.b) && AbstractC13042fc3.d(this.c, zt4.c) && this.d == zt4.d) {
                return true;
            }
        }
        return false;
    }

    public final Object f() {
        Object objPrevious;
        List listF;
        List list = this.a;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (!((YT4.b.c) objPrevious).f().isEmpty()) {
                break;
            }
        }
        YT4.b.c cVar = (YT4.b.c) objPrevious;
        if (cVar == null || (listF = cVar.f()) == null) {
            return null;
        }
        return AbstractC15401jX0.F0(listF);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0) + this.c.hashCode() + Integer.hashCode(this.d);
    }

    public String toString() {
        return "PagingState(pages=" + this.a + ", anchorPosition=" + this.b + ", config=" + this.c + ", leadingPlaceholderCount=" + this.d + ')';
    }
}
