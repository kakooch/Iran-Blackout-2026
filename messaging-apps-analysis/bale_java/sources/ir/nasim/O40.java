package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class O40 extends RecyclerView.h {
    private final a d;
    private final UA2 e;
    private final UA2 f;
    private final UA2 g;
    private final UA2 h;
    private final UA2 i;
    private ArrayList j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("SELECT_MODE", 0);
        public static final a b = new a("MANAGEMENT_MODE", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ O40(a aVar, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, int i, ED1 ed1) {
        this(aVar, (i & 2) != 0 ? new UA2() { // from class: ir.nasim.J40
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return O40.E((BankCreditCard) obj);
            }
        } : ua2, (i & 4) != 0 ? new UA2() { // from class: ir.nasim.K40
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return O40.F((BankCreditCard) obj);
            }
        } : ua22, (i & 8) != 0 ? new UA2() { // from class: ir.nasim.L40
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return O40.G((BankCreditCard) obj);
            }
        } : ua23, (i & 16) != 0 ? new UA2() { // from class: ir.nasim.M40
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return O40.H((BankCreditCard) obj);
            }
        } : ua24, (i & 32) != 0 ? new UA2() { // from class: ir.nasim.N40
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return O40.I((BankCreditCard) obj);
            }
        } : ua25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "it");
        return C19938rB7.a;
    }

    public final ArrayList J() {
        return this.j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C10719c50 c10719c50, int i) {
        AbstractC13042fc3.i(c10719c50, "holder");
        Object obj = this.j.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c10719c50.M0((BankCreditCard) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public C10719c50 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        int i2 = b.a[this.d.ordinal()];
        if (i2 == 1) {
            return C10719c50.G.b(viewGroup, this.f, this.g, this.e);
        }
        if (i2 == 2) {
            return C10719c50.G.a(viewGroup, this.f, this.g, this.h, this.i, this.e);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void M(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.j = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.j.size();
    }

    public O40(a aVar, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25) {
        AbstractC13042fc3.i(aVar, "type");
        AbstractC13042fc3.i(ua2, "shaparakAuthentication");
        AbstractC13042fc3.i(ua22, "onClickListener");
        AbstractC13042fc3.i(ua23, "onDeleteClickListener");
        AbstractC13042fc3.i(ua24, "onDefaultClickListener");
        AbstractC13042fc3.i(ua25, "onEditClickListener");
        this.d = aVar;
        this.e = ua2;
        this.f = ua22;
        this.g = ua23;
        this.h = ua24;
        this.i = ua25;
        this.j = new ArrayList();
    }
}
