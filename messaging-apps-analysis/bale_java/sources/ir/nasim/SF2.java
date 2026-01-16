package ir.nasim;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public final class SF2 {
    private final C11590dG3 a;
    private final C15842kG3 b;
    private final D44 c;
    private final AbstractC13778go1 d;

    static final class a extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;

        /* renamed from: ir.nasim.SF2$a$a, reason: collision with other inner class name */
        static final class C0618a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ SF2 d;
            final /* synthetic */ Map e;
            final /* synthetic */ Map f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0618a(SF2 sf2, Map map, Map map2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = sf2;
                this.e = map;
                this.f = map2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0618a c0618a = new C0618a(this.d, this.e, this.f, interfaceC20295rm1);
                c0618a.c = obj;
                return c0618a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return this.d.c((C4743Gj2) this.c, this.e, this.f);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4743Gj2 c4743Gj2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0618a) create(c4743Gj2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.g((NT4) this.c, new C0618a(SF2.this, (Map) this.d, (Map) this.e, null));
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object e(NT4 nt4, Map map, Map map2, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = SF2.this.new a(interfaceC20295rm1);
            aVar.c = nt4;
            aVar.d = map;
            aVar.e = map2;
            return aVar.invokeSuspend(C19938rB7.a);
        }
    }

    public SF2(C11590dG3 c11590dG3, C15842kG3 c15842kG3, D44 d44, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c11590dG3, "loadReactionUseCase");
        AbstractC13042fc3.i(c15842kG3, "loadSuggester");
        AbstractC13042fc3.i(d44, "mergeFeedReactions");
        AbstractC13042fc3.i(abstractC13778go1, "defaultDispatcher");
        this.a = c11590dG3;
        this.b = c15842kG3;
        this.c = d44;
        this.d = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4743Gj2 c(C4743Gj2 c4743Gj2, Map map, Map map2) {
        C8755Xe4 c8755Xe4 = new C8755Xe4(c4743Gj2.e().f().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null);
        List<C15759k74> listK = (List) map.get(c8755Xe4);
        if (listK == null) {
            listK = c4743Gj2.e().k();
        }
        Set setA = this.c.a(c4743Gj2.e().k(), listK);
        List listJ = (List) map2.get(c8755Xe4);
        if (listJ == null) {
            listJ = c4743Gj2.j();
        }
        List list = listJ;
        C5886Lg2 c5886Lg2E = c4743Gj2.e();
        C5886Lg2 c5886Lg2B = c5886Lg2E.b((16375 & 1) != 0 ? c5886Lg2E.a : 0L, (16375 & 2) != 0 ? c5886Lg2E.b : 0L, (16375 & 4) != 0 ? c5886Lg2E.c : null, (16375 & 8) != 0 ? c5886Lg2E.d : AbstractC15401jX0.m1(setA), (16375 & 16) != 0 ? c5886Lg2E.e : null, (16375 & 32) != 0 ? c5886Lg2E.f : null, (16375 & 64) != 0 ? c5886Lg2E.g : 0, (16375 & 128) != 0 ? c5886Lg2E.h : null, (16375 & 256) != 0 ? c5886Lg2E.i : null, (16375 & 512) != 0 ? c5886Lg2E.j : null, (16375 & 1024) != 0 ? c5886Lg2E.k : null, (16375 & 2048) != 0 ? c5886Lg2E.l : null, (16375 & 4096) != 0 ? c5886Lg2E.m : null, (16375 & 8192) != 0 ? c5886Lg2E.n : null);
        long jA = 0;
        long jA2 = 0;
        String strB = "";
        for (C15759k74 c15759k74 : listK) {
            if (AbstractC13042fc3.d(c15759k74.b(), "👁️")) {
                jA2 += c15759k74.a();
            } else {
                jA += c15759k74.a();
                if (c15759k74.c()) {
                    strB = c15759k74.b();
                }
            }
        }
        return c4743Gj2.b((134 & 1) != 0 ? c4743Gj2.a : c5886Lg2B, (134 & 2) != 0 ? c4743Gj2.b : null, (134 & 4) != 0 ? c4743Gj2.c : null, (134 & 8) != 0 ? c4743Gj2.d : jA, (134 & 16) != 0 ? c4743Gj2.e : jA2, (134 & 32) != 0 ? c4743Gj2.f : list, (134 & 64) != 0 ? c4743Gj2.g : strB, (134 & 128) != 0 ? c4743Gj2.h : null);
    }

    public final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "feedPagingData");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.o(interfaceC4557Fq2, this.a.c(), this.b.d(), new a(null)), this.d);
    }
}
