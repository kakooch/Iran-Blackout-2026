package ir.nasim;

import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.g43, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC13346g43 extends List, Collection, InterfaceC17915nm3 {

    /* renamed from: ir.nasim.g43$a */
    public static final class a {
        public static InterfaceC13346g43 a(InterfaceC13346g43 interfaceC13346g43, int i, int i2) {
            return new b(interfaceC13346g43, i, i2);
        }
    }

    /* renamed from: ir.nasim.g43$b */
    private static final class b extends AbstractC11442d1 implements InterfaceC13346g43 {
        private final InterfaceC13346g43 a;
        private final int b;
        private final int c;
        private int d;

        public b(InterfaceC13346g43 interfaceC13346g43, int i, int i2) {
            AbstractC13042fc3.i(interfaceC13346g43, "source");
            this.a = interfaceC13346g43;
            this.b = i;
            this.c = i2;
            LB3.c(i, i2, interfaceC13346g43.size());
            this.d = i2 - i;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public InterfaceC13346g43 subList(int i, int i2) {
            LB3.c(i, i2, this.d);
            InterfaceC13346g43 interfaceC13346g43 = this.a;
            int i3 = this.b;
            return new b(interfaceC13346g43, i + i3, i3 + i2);
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public Object get(int i) {
            LB3.a(i, this.d);
            return this.a.get(this.b + i);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return this.d;
        }
    }
}
