package ir.nasim;

import com.google.android.gms.internal.measurement.C2135n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Yp8 {
    public static InterfaceC22720vi8 a(C2135n0 c2135n0) {
        if (c2135n0 == null) {
            return InterfaceC22720vi8.r0;
        }
        int iJ = c2135n0.J() - 1;
        if (iJ == 1) {
            return c2135n0.I() ? new Ei8(c2135n0.D()) : InterfaceC22720vi8.y0;
        }
        if (iJ == 2) {
            return c2135n0.H() ? new Ph8(Double.valueOf(c2135n0.A())) : new Ph8(null);
        }
        if (iJ == 3) {
            return c2135n0.G() ? new Ih8(Boolean.valueOf(c2135n0.F())) : new Ih8(null);
        }
        if (iJ != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List listE = c2135n0.E();
        ArrayList arrayList = new ArrayList();
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(a((C2135n0) it.next()));
        }
        return new C23906xi8(c2135n0.C(), arrayList);
    }

    public static InterfaceC22720vi8 b(Object obj) {
        if (obj == null) {
            return InterfaceC22720vi8.s0;
        }
        if (obj instanceof String) {
            return new Ei8((String) obj);
        }
        if (obj instanceof Double) {
            return new Ph8((Double) obj);
        }
        if (obj instanceof Long) {
            return new Ph8(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new Ph8(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new Ih8((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            Ch8 ch8 = new Ch8();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                ch8.I(ch8.w(), b(it.next()));
            }
            return ch8;
        }
        C17289mi8 c17289mi8 = new C17289mi8();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            InterfaceC22720vi8 interfaceC22720vi8B = b(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                c17289mi8.i((String) string, interfaceC22720vi8B);
            }
        }
        return c17289mi8;
    }
}
