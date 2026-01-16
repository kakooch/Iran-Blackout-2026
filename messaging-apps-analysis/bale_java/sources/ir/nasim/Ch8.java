package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class Ch8 implements Iterable, InterfaceC22720vi8, InterfaceC14926ii8 {
    final SortedMap a;
    final Map b;

    public Ch8() {
        this.a = new TreeMap();
        this.b = new TreeMap();
    }

    public final String A(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            for (int i = 0; i < w(); i++) {
                InterfaceC22720vi8 interfaceC22720vi8X = x(i);
                sb.append(str);
                if (!(interfaceC22720vi8X instanceof Ii8) && !(interfaceC22720vi8X instanceof C19062pi8)) {
                    sb.append(interfaceC22720vi8X.j());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final Iterator B() {
        return this.a.keySet().iterator();
    }

    public final List C() {
        ArrayList arrayList = new ArrayList(w());
        for (int i = 0; i < w(); i++) {
            arrayList.add(x(i));
        }
        return arrayList;
    }

    public final void D() {
        this.a.clear();
    }

    public final void E(int i, InterfaceC22720vi8 interfaceC22720vi8) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i);
        }
        if (i >= w()) {
            I(i, interfaceC22720vi8);
            return;
        }
        for (int iIntValue = ((Integer) this.a.lastKey()).intValue(); iIntValue >= i; iIntValue--) {
            SortedMap sortedMap = this.a;
            Integer numValueOf = Integer.valueOf(iIntValue);
            InterfaceC22720vi8 interfaceC22720vi82 = (InterfaceC22720vi8) sortedMap.get(numValueOf);
            if (interfaceC22720vi82 != null) {
                I(iIntValue + 1, interfaceC22720vi82);
                this.a.remove(numValueOf);
            }
        }
        I(i, interfaceC22720vi8);
    }

    public final void F(int i) {
        int iIntValue = ((Integer) this.a.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        this.a.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            SortedMap sortedMap = this.a;
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf(i2);
            if (sortedMap.containsKey(numValueOf) || i2 < 0) {
                return;
            }
            this.a.put(numValueOf, InterfaceC22720vi8.r0);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) this.a.lastKey()).intValue()) {
                return;
            }
            SortedMap sortedMap2 = this.a;
            Integer numValueOf2 = Integer.valueOf(i);
            InterfaceC22720vi8 interfaceC22720vi8 = (InterfaceC22720vi8) sortedMap2.get(numValueOf2);
            if (interfaceC22720vi8 != null) {
                this.a.put(Integer.valueOf(i - 1), interfaceC22720vi8);
                this.a.remove(numValueOf2);
            }
        }
    }

    public final void I(int i, InterfaceC22720vi8 interfaceC22720vi8) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i);
        }
        if (interfaceC22720vi8 == null) {
            this.a.remove(Integer.valueOf(i));
        } else {
            this.a.put(Integer.valueOf(i), interfaceC22720vi8);
        }
    }

    public final boolean L(int i) {
        if (i >= 0 && i <= ((Integer) this.a.lastKey()).intValue()) {
            return this.a.containsKey(Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        Ch8 ch8 = new Ch8();
        for (Map.Entry entry : this.a.entrySet()) {
            if (entry.getValue() instanceof InterfaceC14926ii8) {
                ch8.a.put((Integer) entry.getKey(), (InterfaceC22720vi8) entry.getValue());
            } else {
                ch8.a.put((Integer) entry.getKey(), ((InterfaceC22720vi8) entry.getValue()).d());
            }
        }
        return ch8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ch8)) {
            return false;
        }
        Ch8 ch8 = (Ch8) obj;
        if (w() != ch8.w()) {
            return false;
        }
        if (this.a.isEmpty()) {
            return ch8.a.isEmpty();
        }
        for (int iIntValue = ((Integer) this.a.firstKey()).intValue(); iIntValue <= ((Integer) this.a.lastKey()).intValue(); iIntValue++) {
            if (!x(iIntValue).equals(ch8.x(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final boolean f(String str) {
        return "length".equals(str) || this.b.containsKey(str);
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final InterfaceC22720vi8 h(String str) {
        InterfaceC22720vi8 interfaceC22720vi8;
        return "length".equals(str) ? new Ph8(Double.valueOf(w())) : (!f(str) || (interfaceC22720vi8 = (InterfaceC22720vi8) this.b.get(str)) == null) ? InterfaceC22720vi8.r0 : interfaceC22720vi8;
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final void i(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        if (interfaceC22720vi8 == null) {
            this.b.remove(str);
        } else {
            this.b.put(str, interfaceC22720vi8);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C23896xh8(this);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return A(",");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return this.a.size() == 1 ? x(0).k() : this.a.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.TRUE;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return new C22120uh8(this, this.a.keySet().iterator(), this.b.keySet().iterator());
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? Fj8.a(str, this, c20322ro8, list) : AbstractC11264ci8.a(this, new Ei8(str), c20322ro8, list);
    }

    public final String toString() {
        return A(",");
    }

    public final int v() {
        return this.a.size();
    }

    public final int w() {
        if (this.a.isEmpty()) {
            return 0;
        }
        return ((Integer) this.a.lastKey()).intValue() + 1;
    }

    public final InterfaceC22720vi8 x(int i) {
        InterfaceC22720vi8 interfaceC22720vi8;
        if (i < w()) {
            return (!L(i) || (interfaceC22720vi8 = (InterfaceC22720vi8) this.a.get(Integer.valueOf(i))) == null) ? InterfaceC22720vi8.r0 : interfaceC22720vi8;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public Ch8(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                I(i, (InterfaceC22720vi8) list.get(i));
            }
        }
    }
}
