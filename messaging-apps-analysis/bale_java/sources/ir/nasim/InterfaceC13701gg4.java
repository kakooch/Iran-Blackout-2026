package ir.nasim;

import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.gg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC13701gg4 {

    /* renamed from: ir.nasim.gg4$a */
    public static class a {
        public final InterfaceC14373ho3 a;
        public final List b;
        public final InterfaceC8666Wy1 c;

        public a(InterfaceC14373ho3 interfaceC14373ho3, InterfaceC8666Wy1 interfaceC8666Wy1) {
            this(interfaceC14373ho3, Collections.emptyList(), interfaceC8666Wy1);
        }

        public a(InterfaceC14373ho3 interfaceC14373ho3, List list, InterfaceC8666Wy1 interfaceC8666Wy1) {
            this.a = (InterfaceC14373ho3) AbstractC3322Aj5.d(interfaceC14373ho3);
            this.b = (List) AbstractC3322Aj5.d(list);
            this.c = (InterfaceC8666Wy1) AbstractC3322Aj5.d(interfaceC8666Wy1);
        }
    }

    boolean a(Object obj);

    a b(Object obj, int i, int i2, HL4 hl4);
}
