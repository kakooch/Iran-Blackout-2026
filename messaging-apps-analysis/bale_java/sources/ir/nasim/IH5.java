package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.ViewGroup;
import ir.nasim.AbstractC13863gw6;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class IH5 extends androidx.recyclerview.widget.q {
    private final UA2 f;
    private final UA2 g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class a {
        public static final C0415a a;
        public static final a b = new a(TokenNames.OPTIONS, 0);
        public static final a c = new a("DESCRIPTION", 1);
        public static final a d = new a("TITLE_DIVIDER", 2);
        public static final a e = new a("REACTION_ITEM", 3);
        private static final /* synthetic */ a[] f;
        private static final /* synthetic */ F92 g;

        /* renamed from: ir.nasim.IH5$a$a, reason: collision with other inner class name */
        public static final class C0415a {
            private C0415a() {
            }

            public final a a(AbstractC13863gw6 abstractC13863gw6) {
                AbstractC13042fc3.i(abstractC13863gw6, "settingsItem");
                if (abstractC13863gw6 instanceof AbstractC13863gw6.c) {
                    return a.b;
                }
                if (abstractC13863gw6 instanceof AbstractC13863gw6.b) {
                    return a.c;
                }
                if (abstractC13863gw6 instanceof AbstractC13863gw6.e) {
                    return a.d;
                }
                if (abstractC13863gw6 instanceof AbstractC13863gw6.d) {
                    return a.e;
                }
                throw new NoWhenBranchMatchedException();
            }

            public final a b(int i) {
                return a.values()[i];
            }

            public /* synthetic */ C0415a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrA = a();
            f = aVarArrA;
            g = G92.a(aVarArrA);
            a = new C0415a(null);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d, e};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        public final int j() {
            return ordinal();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IH5(UA2 ua2, UA2 ua22) {
        super(new C14456hw6());
        AbstractC13042fc3.i(ua2, "onOptionClicked");
        AbstractC13042fc3.i(ua22, "onReactionItemClicked");
        this.f = ua2;
        this.g = ua22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC15063iw6 abstractC15063iw6, int i) {
        AbstractC13042fc3.i(abstractC15063iw6, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        abstractC15063iw6.C0((AbstractC13863gw6) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC15063iw6 abstractC15063iw6, int i, List list) {
        AbstractC13042fc3.i(abstractC15063iw6, "holder");
        AbstractC13042fc3.i(list, "payloads");
        Object objS0 = AbstractC15401jX0.s0(list);
        List list2 = objS0 instanceof List ? (List) objS0 : null;
        if (list2 == null) {
            super.onBindViewHolder(abstractC15063iw6, i, list);
            return;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            abstractC15063iw6.D0((AbstractC19200pw6) it.next());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public AbstractC15063iw6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        int i2 = b.a[a.a.b(i).ordinal()];
        if (i2 == 1) {
            return AL4.w.a(viewGroup, this.f);
        }
        if (i2 == 2) {
            return C21207tI1.v.a(viewGroup);
        }
        if (i2 == 3) {
            return C9636aI5.v.a(viewGroup);
        }
        if (i2 == 4) {
            return C16444lH5.w.a(viewGroup, this.g);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(AbstractC15063iw6 abstractC15063iw6) {
        AbstractC13042fc3.i(abstractC15063iw6, "holder");
        super.onViewRecycled(abstractC15063iw6);
        abstractC15063iw6.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        a.C0415a c0415a = a.a;
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        return c0415a.a((AbstractC13863gw6) objA).j();
    }
}
