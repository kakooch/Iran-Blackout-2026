package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.rh3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20245rh3 extends VW7 {
    private final SettingsModule b;
    private final QQ3 c;
    private InterfaceC9336Zm4 d;
    private InterfaceC10258bL6 e;

    /* renamed from: ir.nasim.rh3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20245rh3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20245rh3.this.d;
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
            QQ3 qq3 = C20245rh3.this.c;
            String strB = SearchSuggestion.INSTANCE.b(new ArrayList());
            if (strB == null) {
                strB = "";
            }
            qq3.b0(strB);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rh3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SearchSuggestion d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SearchSuggestion searchSuggestion, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = searchSuggestion;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20245rh3.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20245rh3.this.d;
                List listO0 = AbstractC15401jX0.O0((Iterable) C20245rh3.this.d.getValue(), this.d);
                AbstractC13042fc3.g(listO0, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.core.modules.market.model.SearchSuggestion>");
                this.b = 1;
                if (interfaceC9336Zm4.a((ArrayList) listO0, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            QQ3 qq3 = C20245rh3.this.c;
            String strB = SearchSuggestion.INSTANCE.b((ArrayList) C20245rh3.this.d.getValue());
            if (strB == null) {
                strB = "";
            }
            qq3.b0(strB);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C20245rh3(SettingsModule settingsModule, QQ3 qq3) {
        AbstractC13042fc3.i(settingsModule, "settingsModel");
        AbstractC13042fc3.i(qq3, "marketModule");
        this.b = settingsModule;
        this.c = qq3;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.d = interfaceC9336Zm4A;
        this.e = interfaceC9336Zm4A;
        X0();
    }

    private final void X0() {
        ArrayList arrayListA;
        Object value;
        String strW = this.c.W();
        if (strW == null || (arrayListA = SearchSuggestion.INSTANCE.a(strW)) == null) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, arrayListA));
    }

    public final void S0(String str, int i) {
        Object next;
        String str2 = str;
        AbstractC13042fc3.i(str2, "title");
        Iterator it = ((Iterable) this.d.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SearchSuggestion.Peer peer = ((SearchSuggestion) next).getPeer();
            if (peer != null && peer.getId() == i) {
                break;
            }
        }
        if (((SearchSuggestion) next) == null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            while (true) {
                Object value = interfaceC9336Zm4.getValue();
                List listS0 = AbstractC15401jX0.S0((ArrayList) value, new SearchSuggestion(SearchSuggestion.a.b, null, "tv", new SearchSuggestion.Peer("", str2, i), L17.b, null, null, 96, null));
                AbstractC13042fc3.g(listS0, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.core.modules.market.model.SearchSuggestion>");
                if (interfaceC9336Zm4.f(value, (ArrayList) listS0)) {
                    break;
                } else {
                    str2 = str;
                }
            }
            QQ3 qq3 = this.c;
            String strB = SearchSuggestion.INSTANCE.b((ArrayList) this.d.getValue());
            if (strB == null) {
                strB = "";
            }
            qq3.b0(strB);
        }
    }

    public final void T0(String str) {
        Object next;
        Object value;
        List listS0;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        Iterator it = ((Iterable) this.d.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (AbstractC13042fc3.d(((SearchSuggestion) next).getTerm(), str)) {
                    break;
                }
            }
        }
        if (((SearchSuggestion) next) == null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                listS0 = AbstractC15401jX0.S0((ArrayList) value, new SearchSuggestion(SearchSuggestion.a.a, str, null, null, L17.b, null, null, 96, null));
                AbstractC13042fc3.g(listS0, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.core.modules.market.model.SearchSuggestion>");
            } while (!interfaceC9336Zm4.f(value, (ArrayList) listS0));
            QQ3 qq3 = this.c;
            String strB = SearchSuggestion.INSTANCE.b((ArrayList) this.d.getValue());
            if (strB == null) {
                strB = "";
            }
            qq3.b0(strB);
        }
    }

    public final void U0() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    public final List V0() {
        ArrayList arrayListA = SearchSuggestion.INSTANCE.a(this.b.E2());
        if (arrayListA == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListA) {
            String term = ((SearchSuggestion) obj).getTerm();
            if (!(term == null || term.length() == 0)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final InterfaceC10258bL6 W0() {
        return this.e;
    }

    public final void Y0(SearchSuggestion searchSuggestion) {
        AbstractC13042fc3.i(searchSuggestion, "value");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(searchSuggestion, null), 3, null);
    }
}
