package ir.nasim;

import ir.nasim.AB2;
import ir.nasim.AbstractC14230ha2;
import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.fa2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C13021fa2 extends KC6 {
    private final AbstractC14230ha2.d G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13021fa2(InterfaceC21331tU0 interfaceC21331tU0, AbstractC14230ha2.d dVar) {
        super(interfaceC21331tU0, null, InterfaceC4356Eu.W.b(), C6432No4.s("<ERROR FUNCTION>"), InterfaceC15194jA0.a.DECLARATION, JH6.a);
        if (interfaceC21331tU0 == null) {
            x(0);
        }
        if (dVar == null) {
            x(1);
        }
        this.G = dVar;
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC14592iA0
    public Object C0(InterfaceC14592iA0.a aVar) {
        return null;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC15194jA0
    public void D0(Collection collection) {
        if (collection == null) {
            x(8);
        }
    }

    @Override // ir.nasim.KC6, ir.nasim.BB2
    protected BB2 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(2);
        }
        if (aVar == null) {
            x(3);
        }
        if (interfaceC4356Eu == null) {
            x(4);
        }
        if (jh6 == null) {
            x(5);
        }
        return this;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean isSuspend() {
        return false;
    }

    @Override // ir.nasim.KC6, ir.nasim.BB2, ir.nasim.AB2
    public AB2.a t() {
        return new a();
    }

    /* renamed from: ir.nasim.fa2$a */
    class a implements AB2.a {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void u(int r24) {
            /*
                Method dump skipped, instructions count: 566
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13021fa2.a.u(int):void");
        }

        @Override // ir.nasim.AB2.a
        public AB2.a c(List list) {
            if (list == null) {
                u(11);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a f(AbstractC4099Dr3 abstractC4099Dr3) {
            if (abstractC4099Dr3 == null) {
                u(19);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a g(RI1 ri1) {
            if (ri1 == null) {
                u(4);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a h(AbstractC5117Hy7 abstractC5117Hy7) {
            if (abstractC5117Hy7 == null) {
                u(13);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a l(C6432No4 c6432No4) {
            if (c6432No4 == null) {
                u(9);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a n(InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC12795fB1 == null) {
                u(0);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a p(List list) {
            if (list == null) {
                u(17);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a q(InterfaceC15194jA0.a aVar) {
            if (aVar == null) {
                u(6);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a r(InterfaceC4356Eu interfaceC4356Eu) {
            if (interfaceC4356Eu == null) {
                u(29);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a s(EnumC11067cg4 enumC11067cg4) {
            if (enumC11067cg4 == null) {
                u(2);
            }
            return this;
        }

        @Override // ir.nasim.AB2.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public JC6 a() {
            return C13021fa2.this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a b() {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a i() {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a j() {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a m() {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a t() {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a d(ZI5 zi5) {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a e(ZI5 zi5) {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a k(InterfaceC15194jA0 interfaceC15194jA0) {
            return this;
        }

        @Override // ir.nasim.AB2.a
        public AB2.a o(boolean z) {
            return this;
        }
    }

    @Override // ir.nasim.KC6, ir.nasim.InterfaceC15194jA0
    /* renamed from: j1 */
    public JC6 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        return this;
    }
}
