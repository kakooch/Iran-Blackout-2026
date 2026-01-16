package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public class HW4 {
    private final List a;
    private final List b;
    private final InterfaceC10752c83 c;
    private final List d;

    public static class a {
        private final List a = new ArrayList();
        private final List b = new ArrayList();
        private final List c = new ArrayList();
        private Set d = HW1.s();
        private InterfaceC10752c83 e;

        /* renamed from: ir.nasim.HW4$a$a, reason: collision with other inner class name */
        class C0400a implements InterfaceC10752c83 {
            C0400a() {
            }

            @Override // ir.nasim.InterfaceC10752c83
            public Z73 a(InterfaceC9542a83 interfaceC9542a83) {
                return new C11516d83(interfaceC9542a83);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InterfaceC10752c83 g() {
            InterfaceC10752c83 interfaceC10752c83 = this.e;
            return interfaceC10752c83 != null ? interfaceC10752c83 : new C0400a();
        }

        public HW4 f() {
            return new HW4(this);
        }

        public a h(InterfaceC10752c83 interfaceC10752c83) {
            this.e = interfaceC10752c83;
            return this;
        }
    }

    private HW1 a() {
        return new HW1(this.a, this.c, this.b);
    }

    private TA4 c(TA4 ta4) {
        Iterator it = this.d.iterator();
        if (!it.hasNext()) {
            return ta4;
        }
        AbstractC18350oW3.a(it.next());
        throw null;
    }

    public TA4 b(String str) {
        if (str != null) {
            return c(a().u(str));
        }
        throw new NullPointerException("input must not be null");
    }

    private HW4(a aVar) {
        this.a = HW1.l(aVar.a, aVar.d);
        InterfaceC10752c83 interfaceC10752c83G = aVar.g();
        this.c = interfaceC10752c83G;
        this.d = aVar.c;
        List list = aVar.b;
        this.b = list;
        interfaceC10752c83G.a(new C10136b83(list, Collections.emptyMap()));
    }
}
