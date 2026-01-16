package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.mK7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17064mK7 extends Z6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17064mK7(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().e("users/router", new V6() { // from class: ir.nasim.lK7
            @Override // ir.nasim.V6
            public final K6 create() {
                return C17064mK7.k(c9057Yh4);
            }
        }, true));
        AbstractC13042fc3.i(c9057Yh4, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 k(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "$context");
        return new C15882kK7(c9057Yh4);
    }

    public final C6517Nv5 l(List list) {
        AbstractC13042fc3.i(list, "users");
        C6517Nv5 c6517Nv5C = c(new Q56(list));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 m(List list) {
        AbstractC13042fc3.i(list, "users");
        C6517Nv5 c6517Nv5C = c(new Y56(list));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 n(List list) {
        AbstractC13042fc3.i(list, "users");
        C6517Nv5 c6517Nv5C = c(new C9525a66(list));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final C6517Nv5 o(int i) {
        C6517Nv5 c6517Nv5C = c(new C11499d66(i));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }

    public final void p() {
        i(new C17524n66());
    }

    public final C6517Nv5 q(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        C6517Nv5 c6517Nv5C = c(new A66(abstractC20556sC7));
        AbstractC13042fc3.h(c6517Nv5C, "ask(...)");
        return c6517Nv5C;
    }
}
