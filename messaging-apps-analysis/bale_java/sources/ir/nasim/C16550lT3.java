package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.market.model.GetMarketDataResponse;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.market.model.SearchSuggestionRow;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.lT3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16550lT3 extends VW7 {
    private QQ3 b;
    private final UG7 c;
    private final SettingsModule d;
    private InterfaceC10258bL6 e;
    private InterfaceC9336Zm4 f;
    private InterfaceC10258bL6 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC9336Zm4 i;
    private List j;

    /* renamed from: ir.nasim.lT3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.lT3$a$a, reason: collision with other inner class name */
        static final class C1374a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            C1374a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ArrayList arrayList = (ArrayList) this.c;
                ArrayList arrayList2 = (ArrayList) this.d;
                C5721Ko c5721Ko = C5721Ko.a;
                String string = c5721Ko.d().getString(JD5.market_search_recent_search_list);
                AbstractC13042fc3.h(string, "getString(...)");
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                SearchSuggestionRow searchSuggestionRow = new SearchSuggestionRow(string, arrayList, true);
                String string2 = c5721Ko.d().getString(JD5.market_popular_searches);
                AbstractC13042fc3.h(string2, "getString(...)");
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayListG = AbstractC10360bX0.g(searchSuggestionRow, new SearchSuggestionRow(string2, arrayList2, false));
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : arrayListG) {
                    if (!((SearchSuggestionRow) obj2).getItems().isEmpty()) {
                        arrayList3.add(obj2);
                    }
                }
                return arrayList3;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(ArrayList arrayList, ArrayList arrayList2, InterfaceC20295rm1 interfaceC20295rm1) {
                C1374a c1374a = new C1374a(interfaceC20295rm1);
                c1374a.c = arrayList;
                c1374a.d = arrayList2;
                return c1374a.invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C16550lT3 c16550lT3;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16550lT3 c16550lT32 = C16550lT3.this;
                InterfaceC4557Fq2 interfaceC4557Fq2S = AbstractC6459Nq2.S(c16550lT32.h, C16550lT3.this.i, new C1374a(null));
                InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(C16550lT3.this);
                this.b = c16550lT32;
                this.c = 1;
                Object objP0 = AbstractC6459Nq2.p0(interfaceC4557Fq2S, interfaceC20315ro1A, this);
                if (objP0 == objE) {
                    return objE;
                }
                c16550lT3 = c16550lT32;
                obj = objP0;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c16550lT3 = (C16550lT3) this.b;
                AbstractC10685c16.b(obj);
            }
            c16550lT3.e1((InterfaceC10258bL6) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lT3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List listM;
            ArrayList<MarketProductItem> products;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            GetMarketDataResponse getMarketDataResponseL = C16550lT3.this.b.L();
            if (getMarketDataResponseL != null) {
                boolean z = false;
                if ((!getMarketDataResponseL.getMarketRows().get(0).getItems().isEmpty()) || ((products = getMarketDataResponseL.getMarketRows().get(0).getProducts()) != null && (!products.isEmpty()))) {
                    z = true;
                }
                C16550lT3 c16550lT3 = C16550lT3.this;
                if (z) {
                    ArrayList<MarketSection> marketRows = C14788iU3.g.a(getMarketDataResponseL).getMarketRows();
                    listM = new ArrayList(AbstractC10976cX0.x(marketRows, 10));
                    for (MarketSection marketSection : marketRows) {
                        listM.add(new C4711Gf6(marketSection.getTitle(), AbstractC6392Nk0.d(marketSection.getDrawableIdResource())));
                    }
                } else {
                    c16550lT3.b.Z();
                    listM = AbstractC10360bX0.m();
                }
                c16550lT3.j = listM;
            } else {
                C16550lT3.this.j = AbstractC10360bX0.m();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lT3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String strD3 = C16550lT3.this.d.d3();
                if (strD3 == null || strD3.length() == 0) {
                    return C19938rB7.a;
                }
                ArrayList arrayListA = SearchSuggestion.INSTANCE.a(strD3);
                if (arrayListA != null) {
                    C16550lT3 c16550lT3 = C16550lT3.this;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(arrayListA, 10));
                    Iterator it = arrayListA.iterator();
                    while (it.hasNext()) {
                        arrayList.add(SearchSuggestion.copy$default((SearchSuggestion) it.next(), null, null, null, null, L17.c, null, null, WKSRecord.Service.SUNRPC, null));
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c16550lT3.i;
                    this.b = 1;
                    if (interfaceC9336Zm4.a(arrayList, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lT3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ArrayList d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = arrayList;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C16550lT3.this.h;
                ArrayList arrayList = this.d;
                this.b = 1;
                if (interfaceC9336Zm4.a(arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lT3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C16550lT3.this.h;
                ArrayList arrayList = new ArrayList();
                this.b = 1;
                if (interfaceC9336Zm4.a(arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lT3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16550lT3.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List list = C16550lT3.this.j;
                String str = this.d;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (AbstractC20762sZ6.V(((C4711Gf6) obj2).b(), str, true)) {
                        arrayList.add(obj2);
                    }
                }
                arrayList.add(0, new C4711Gf6(this.d, AbstractC6392Nk0.d(AbstractC19345qB5.drawable_market_search)));
                InterfaceC9336Zm4 interfaceC9336Zm4 = C16550lT3.this.f;
                this.b = 1;
                if (interfaceC9336Zm4.a(arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16550lT3(QQ3 qq3, UG7 ug7, SettingsModule settingsModule) {
        AbstractC13042fc3.i(qq3, "marketModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = qq3;
        this.c = ug7;
        this.d = settingsModule;
        this.e = AbstractC12281eL6.a(new ArrayList());
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.f = interfaceC9336Zm4A;
        this.g = interfaceC9336Zm4A;
        this.h = AbstractC12281eL6.a(null);
        this.i = AbstractC12281eL6.a(null);
        this.j = AbstractC10360bX0.m();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(null), 2, null);
    }

    public final void X0(SearchSuggestion searchSuggestion) {
        String strW;
        ArrayList arrayListA;
        AbstractC13042fc3.i(searchSuggestion, "newSuggestion");
        ArrayList arrayList = new ArrayList();
        if (this.b.W() != null && (strW = this.b.W()) != null && (arrayListA = SearchSuggestion.INSTANCE.a(strW)) != null && !arrayListA.isEmpty()) {
            arrayList.addAll(arrayListA);
        }
        int i = 0;
        Integer numValueOf = null;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            SearchSuggestion searchSuggestion2 = (SearchSuggestion) obj;
            if (searchSuggestion.getAction() == SearchSuggestion.a.a && AbstractC13042fc3.d(searchSuggestion2.getTerm(), searchSuggestion.getTerm())) {
                numValueOf = Integer.valueOf(i);
            } else if (searchSuggestion.getAction() == SearchSuggestion.a.b) {
                SearchSuggestion.Peer peer = searchSuggestion2.getPeer();
                Integer numValueOf2 = peer != null ? Integer.valueOf(peer.getId()) : null;
                SearchSuggestion.Peer peer2 = searchSuggestion.getPeer();
                if (AbstractC13042fc3.d(numValueOf2, peer2 != null ? Integer.valueOf(peer2.getId()) : null)) {
                    numValueOf = Integer.valueOf(i);
                }
            }
            i = i2;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            if (iIntValue == 0) {
                return;
            }
        }
        arrayList.add(0, searchSuggestion);
        if (arrayList.size() > 10) {
            arrayList = new ArrayList(arrayList.subList(0, 10));
        }
        String strB = SearchSuggestion.INSTANCE.b(arrayList);
        if (strB != null) {
            this.b.b0(strB);
        }
    }

    public final InterfaceC10258bL6 Y0() {
        return this.g;
    }

    public final InterfaceC10258bL6 Z0() {
        return this.e;
    }

    public final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void b1() {
        String strW;
        ArrayList arrayListA;
        if (this.b.W() == null || (strW = this.b.W()) == null || (arrayListA = SearchSuggestion.INSTANCE.a(strW)) == null) {
            return;
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(arrayListA, null), 3, null);
    }

    public final void c1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
        this.b.a0();
    }

    public final void d1(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(str, null), 3, null);
    }

    public final void e1(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "<set-?>");
        this.e = interfaceC10258bL6;
    }
}
