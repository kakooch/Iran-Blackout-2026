package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.ArrayList;

/* renamed from: ir.nasim.g50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13353g50 extends RecyclerView.h {
    public static final b m = new b(null);
    public static final int n = 8;
    private UA2 d;
    private UA2 e;
    private UA2 f;
    private UA2 g;
    private final SA2 h;
    private ArrayList i;
    private d j;
    private e k;
    private c l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ir.nasim.g50$a */
    public static final class a implements SA2 {
        public static final a a = new a();

        a() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    /* renamed from: ir.nasim.g50$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.g50$c */
    public interface c {
        void t(C13944h50 c13944h50);
    }

    /* renamed from: ir.nasim.g50$d */
    public interface d {
        void Z0(BankCreditCard bankCreditCard);
    }

    /* renamed from: ir.nasim.g50$e */
    public interface e {
        void i5(BankCreditCard bankCreditCard);
    }

    /* renamed from: ir.nasim.g50$f */
    public static final class f implements c {
        final /* synthetic */ UA2 a;

        f(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.C13353g50.c
        public void t(C13944h50 c13944h50) {
            AbstractC13042fc3.i(c13944h50, "button");
            this.a.invoke(c13944h50);
        }
    }

    /* renamed from: ir.nasim.g50$g */
    public static final class g implements d {
        final /* synthetic */ UA2 a;

        g(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.C13353g50.d
        public void Z0(BankCreditCard bankCreditCard) {
            AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
            this.a.invoke(bankCreditCard);
        }
    }

    /* renamed from: ir.nasim.g50$h */
    public static final class h implements e {
        final /* synthetic */ UA2 a;

        h(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.C13353g50.e
        public void i5(BankCreditCard bankCreditCard) {
            AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
            this.a.invoke(bankCreditCard);
        }
    }

    public /* synthetic */ C13353g50(UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, SA2 sa2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : ua2, (i & 2) != 0 ? null : ua22, (i & 4) == 0 ? ua23 : null, (i & 8) != 0 ? new UA2() { // from class: ir.nasim.f50
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13353g50.A((String) obj);
            }
        } : ua24, (i & 16) != 0 ? a.a : sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    public final void B(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "data");
        this.i.clear();
        String str = (String) this.h.invoke();
        if (str == null || str.length() == 0) {
            this.i = arrayList;
            return;
        }
        this.i.add(new C21748u40(str));
        if (arrayList.size() > 2) {
            this.i.add(arrayList.get(0));
            this.i.add(arrayList.get(2));
        } else if (arrayList.size() > 1) {
            this.i.add(arrayList.get(0));
            this.i.add(arrayList.get(1));
        } else if (arrayList.size() == 1) {
            this.i.add(arrayList.get(0));
        }
    }

    public final void C(d dVar) {
        this.j = dVar;
    }

    public final void D(e eVar) {
        this.k = eVar;
    }

    public final void E(c cVar) {
        this.l = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        Object obj = this.i.get(i);
        if (obj instanceof BankCreditCard) {
            return 7;
        }
        if (obj instanceof C13944h50) {
            return 10;
        }
        return obj instanceof C21748u40 ? 11 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i) {
        AbstractC13042fc3.i(c2, "holder");
        int itemViewType = getItemViewType(i);
        if (itemViewType == 7) {
            Object obj = this.i.get(i);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCreditCard");
            ((C19872r50) c2).E0((BankCreditCard) obj);
        } else if (itemViewType == 10) {
            Object obj2 = this.i.get(i);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCardSuggestButton");
            ((C16326l50) c2).D0((C13944h50) obj2);
        } else {
            if (itemViewType != 11) {
                return;
            }
            Object obj3 = this.i.get(i);
            AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCardCopied");
            ((C22934w40) c2).D0((C21748u40) obj3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        UA2 ua2 = this.d;
        if (ua2 != null) {
            this.l = new f(ua2);
        }
        UA2 ua22 = this.e;
        if (ua22 != null) {
            this.j = new g(ua22);
        }
        UA2 ua23 = this.f;
        if (ua23 != null) {
            this.k = new h(ua23);
        }
        return i != 7 ? i != 11 ? C16326l50.v.a(viewGroup, this.l) : C22934w40.v.a(viewGroup, this.g) : C19872r50.w.a(viewGroup, this.j, this.k);
    }

    public C13353g50(UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, SA2 sa2) {
        AbstractC13042fc3.i(ua24, "onCopiedCardClickListener");
        AbstractC13042fc3.i(sa2, "canShowCopiedCard");
        this.d = ua2;
        this.e = ua22;
        this.f = ua23;
        this.g = ua24;
        this.h = sa2;
        this.i = new ArrayList();
    }
}
