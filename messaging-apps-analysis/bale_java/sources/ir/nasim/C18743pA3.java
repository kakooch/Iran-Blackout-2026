package ir.nasim;

import ir.nasim.InterfaceC22581vU3;
import ir.nasim.core.markdown.mention.MentionSpans;

/* renamed from: ir.nasim.pA3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18743pA3 extends AbstractC16876m1 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final X34 a;

    /* renamed from: ir.nasim.pA3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C18743pA3(X34 x34) {
        AbstractC13042fc3.i(x34, "mentionData");
        this.a = x34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(C18743pA3 c18743pA3, C18332oU3 c18332oU3, InterfaceC17689nO5 interfaceC17689nO5) {
        AbstractC13042fc3.i(c18743pA3, "this$0");
        AbstractC13042fc3.i(c18332oU3, "<unused var>");
        AbstractC13042fc3.i(interfaceC17689nO5, "props");
        Object objC = AbstractC7392Rn1.e.c(interfaceC17689nO5);
        AbstractC13042fc3.h(objC, "require(...)");
        String str = (String) objC;
        if (!AbstractC20153rZ6.S(str, "uid:", false, 2, null)) {
            return new C24276yL3(true, new C23686xL3(str, str));
        }
        Integer numO = AbstractC19562qZ6.o(AbstractC20762sZ6.C0(str, "uid:"));
        return new MentionSpans("", X34.b(c18743pA3.a, null, false, 1, null), numO != null ? numO.intValue() : 0);
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void f(InterfaceC22581vU3.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        aVar.b(C9452Zz3.class, new InterfaceC12254eI6() { // from class: ir.nasim.oA3
            @Override // ir.nasim.InterfaceC12254eI6
            public final Object a(C18332oU3 c18332oU3, InterfaceC17689nO5 interfaceC17689nO5) {
                return C18743pA3.k(this.a, c18332oU3, interfaceC17689nO5);
            }
        });
    }
}
