package ir.nasim;

import ir.nasim.AbstractC9869ah6;
import ir.nasim.InterfaceC13730gj3;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class J17 extends VW7 {
    private final I17 b;
    private final C16686lh6 c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;
    private InterfaceC13730gj3 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return J17.this.new a(this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 409
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J17.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public J17(I17 i17, C16686lh6 c16686lh6) {
        AbstractC13042fc3.i(i17, "channelRepository");
        AbstractC13042fc3.i(c16686lh6, "contentRepository");
        this.b = i17;
        this.c = c16686lh6;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new AbstractC9869ah6.b(new ArrayList(), new ArrayList()));
        this.d = interfaceC9336Zm4A;
        this.e = interfaceC9336Zm4A;
    }

    public final InterfaceC10258bL6 U0() {
        return this.e;
    }

    public final void V0(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC13730gj3 interfaceC13730gj3 = this.f;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.f = null;
        if (str.length() != 0) {
            this.f = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(str, null), 3, null);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new AbstractC9869ah6.b(new ArrayList(), new ArrayList())));
    }
}
