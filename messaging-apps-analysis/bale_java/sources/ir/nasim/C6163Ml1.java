package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.F5;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Ml1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6163Ml1 extends androidx.recyclerview.widget.q {
    private final SA2 f;
    private final InterfaceC20315ro1 g;
    private int h;
    private final InterfaceC9173Yu3 i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Ml1$a */
    private static final class a {
        public static final C0502a b;
        public static final a c = new a("REGULAR", 0, AbstractC17008mE5.Bale_ContextMenu_Item_Regular);
        public static final a d = new a("ALERT", 1, AbstractC17008mE5.Bale_ContextMenu_Item_Alert);
        public static final a e = new a("CUSTOM", 2, AbstractC17008mE5.Bale_ContextMenu_Item_Custom);
        public static final a f = new a("FOCUS", 3, AbstractC17008mE5.Bale_ContextMenu_Item_Focus);
        public static final a g = new a("REACTION", 4, AbstractC17008mE5.Bale_ContextMenu_Item_Regular);
        public static final a h = new a("SEEN", 5, AbstractC17008mE5.Bale_ContextMenu_Item_Regular);
        private static final /* synthetic */ a[] i;
        private static final /* synthetic */ F92 j;
        private final int a;

        /* renamed from: ir.nasim.Ml1$a$a, reason: collision with other inner class name */
        public static final class C0502a {
            private C0502a() {
            }

            public final a a(F5 f5) {
                AbstractC13042fc3.i(f5, "item");
                if (f5 instanceof F5.c.a) {
                    return a.d;
                }
                if (f5 instanceof F5.c.C0355c) {
                    return a.c;
                }
                if (f5 instanceof F5.a) {
                    return a.e;
                }
                if (f5 instanceof F5.c.b) {
                    return a.f;
                }
                if (f5 instanceof F5.b) {
                    return a.g;
                }
                if (f5 instanceof F5.d) {
                    return a.h;
                }
                throw new NoWhenBranchMatchedException();
            }

            public final a b(int i) {
                return a.values()[i];
            }

            public /* synthetic */ C0502a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrA = a();
            i = aVarArrA;
            j = G92.a(aVarArrA);
            b = new C0502a(null);
        }

        private a(String str, int i2, int i3) {
            this.a = i3;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{c, d, e, f, g, h};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) i.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6163Ml1(final Context context, SA2 sa2) {
        super(C7374Rl1.a);
        AbstractC13042fc3.i(context, "parentContext");
        AbstractC13042fc3.i(sa2, "onItemClick");
        this.f = sa2;
        this.g = AbstractC20906so1.a(C12366eV1.c().X(P17.b(null, 1, null)));
        this.h = a.c.j();
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ll1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6163Ml1.G(context, this);
            }
        });
    }

    private final Context F(Context context, int i) {
        if (this.h != i) {
            context.getTheme().applyStyle(i, true);
            this.h = i;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16731lm1 G(Context context, C6163Ml1 c6163Ml1) {
        AbstractC13042fc3.i(context, "$parentContext");
        AbstractC13042fc3.i(c6163Ml1, "this$0");
        return new C16731lm1(context, c6163Ml1.h);
    }

    private final C16731lm1 H() {
        return (C16731lm1) this.i.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C16673lg3 c16673lg3, int i) {
        AbstractC13042fc3.i(c16673lg3, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        c16673lg3.Q0((F5) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public C16673lg3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C5696Kl1 c5696Kl1C = C5696Kl1.c(LayoutInflater.from(F(H(), a.b.b(i).j())), viewGroup, false);
        AbstractC13042fc3.h(c5696Kl1C, "inflate(...)");
        return new C16673lg3(c5696Kl1C, this.f, this.g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C16673lg3 c16673lg3) {
        AbstractC13042fc3.i(c16673lg3, "holder");
        AbstractC20906so1.d(this.g, null, 1, null);
        super.onViewDetachedFromWindow(c16673lg3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        a.C0502a c0502a = a.b;
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        return c0502a.a((F5) objA).ordinal();
    }
}
