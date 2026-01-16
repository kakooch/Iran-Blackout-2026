package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.contact.data.ContactItem;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.fj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13137fj1 extends OT4 {
    private final SA2 h;
    private final SA2 i;
    private final UA2 j;
    private final SA2 k;
    private final XI4 l;
    private final EJ4 m;
    private final InterfaceC22483vJ4 n;
    private final InterfaceC22483vJ4 o;
    private final boolean p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.fj1$a */
    private static final class a {
        public static final C1237a a;
        public static final a b = new a("BALE_CONTACT", 0);
        public static final a c = new a("PHONE_BOOK_CONTACT", 1);
        public static final a d = new a("SEPARATOR_TITLE", 2);
        public static final a e = new a("INVITATION_CARD", 3);
        public static final a f = new a("PERMISSION_CARD", 4);
        public static final a g = new a("INVITATION_VIA_LINK", 5);
        public static final a h = new a("MXP_PUPPET_CONTACT", 6);
        public static final a i = new a("UNKNOWN", 7);
        private static final /* synthetic */ a[] j;
        private static final /* synthetic */ F92 k;

        /* renamed from: ir.nasim.fj1$a$a, reason: collision with other inner class name */
        public static final class C1237a {
            private C1237a() {
            }

            public final a a(int i) {
                a aVar;
                a.j().get(i);
                a[] aVarArrValues = a.values();
                int length = aVarArrValues.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        aVar = null;
                        break;
                    }
                    aVar = aVarArrValues[i2];
                    if (aVar.ordinal() == i) {
                        break;
                    }
                    i2++;
                }
                return aVar == null ? a.i : aVar;
            }

            public /* synthetic */ C1237a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrA = a();
            j = aVarArrA;
            k = G92.a(aVarArrA);
            a = new C1237a(null);
        }

        private a(String str, int i2) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d, e, f, g, h, i};
        }

        public static F92 j() {
            return k;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) j.clone();
        }
    }

    /* renamed from: ir.nasim.fj1$b */
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
            try {
                iArr[a.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a.i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ C13137fj1(SA2 sa2, SA2 sa22, UA2 ua2, SA2 sa23, XI4 xi4, EJ4 ej4, InterfaceC22483vJ4 interfaceC22483vJ4, InterfaceC22483vJ4 interfaceC22483vJ42, boolean z, int i, ED1 ed1) {
        this(sa2, sa22, ua2, sa23, xi4, ej4, interfaceC22483vJ4, (i & 128) != 0 ? null : interfaceC22483vJ42, z);
    }

    private final LayoutInflater R(View view) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(view.getContext());
        AbstractC13042fc3.h(layoutInflaterFrom, "from(...)");
        return layoutInflaterFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(C13137fj1 c13137fj1, View view) {
        AbstractC13042fc3.i(c13137fj1, "this$0");
        SA2 sa2 = c13137fj1.i;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V(C13137fj1 c13137fj1) {
        AbstractC13042fc3.i(c13137fj1, "this$0");
        SA2 sa2 = c13137fj1.k;
        if (sa2 != null) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(C13137fj1 c13137fj1, View view) {
        AbstractC13042fc3.i(c13137fj1, "this$0");
        c13137fj1.h.invoke();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC20225rf3 abstractC20225rf3, int i) {
        ContactItem contactItem;
        AbstractC13042fc3.i(abstractC20225rf3, "holder");
        if (i < 0 || i >= getItemCount() || (contactItem = (ContactItem) D(i)) == null) {
            return;
        }
        if (contactItem instanceof ContactItem.BaleContactItem) {
            ((C21366tY) abstractC20225rf3).E0(contactItem);
            return;
        }
        if (contactItem instanceof ContactItem.PhoneBookContactItem) {
            ((R75) abstractC20225rf3).E0(contactItem);
            return;
        }
        if (contactItem instanceof ContactItem.SeparatorTitleItem) {
            ((C8770Xg1) abstractC20225rf3).E0(contactItem);
        } else if (contactItem instanceof ContactItem.MxpPuppetContactItem) {
            ((C13190fo4) abstractC20225rf3).E0(contactItem);
        } else {
            C19406qI3.a("ContactAdapter", "UnknownType", new Object[0]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public AbstractC20225rf3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        LayoutInflater layoutInflaterR = R(viewGroup);
        switch (b.a[a.a.a(i).ordinal()]) {
            case 1:
                C6341Ne3 c6341Ne3C = C6341Ne3.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c6341Ne3C, "inflate(...)");
                return new C21366tY(c6341Ne3C, this.l, this.p, null, 8, null);
            case 2:
                C7088Qf3 c7088Qf3C = C7088Qf3.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c7088Qf3C, "inflate(...)");
                return new R75(c7088Qf3C, this.n, this.o);
            case 3:
                C5678Kj1 c5678Kj1C = C5678Kj1.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c5678Kj1C, "inflate(...)");
                return new C8770Xg1(c5678Kj1C, this.j, C15542jl4.a.a());
            case 4:
                C23309wi1 c23309wi1C = C23309wi1.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c23309wi1C, "inflate(...)");
                return new C14872id3(c23309wi1C, new View.OnClickListener() { // from class: ir.nasim.cj1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C13137fj1.U(this.a, view);
                    }
                });
            case 5:
                C8788Xi1 c8788Xi1C = C8788Xi1.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c8788Xi1C, "inflate(...)");
                return new E35(c8788Xi1C, new SA2() { // from class: ir.nasim.dj1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13137fj1.V(this.a);
                    }
                });
            case 6:
                C23899xi1 c23899xi1C = C23899xi1.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c23899xi1C, "inflate(...)");
                return new C15461jd3(c23899xi1C, new View.OnClickListener() { // from class: ir.nasim.ej1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C13137fj1.W(this.a, view);
                    }
                });
            case 7:
                C6844Pf3 c6844Pf3C = C6844Pf3.c(layoutInflaterR, viewGroup, false);
                AbstractC13042fc3.h(c6844Pf3C, "inflate(...)");
                return new C13190fo4(c6844Pf3C, this.m);
            case 8:
                return new C24780zB7(new View(viewGroup.getContext()));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(AbstractC20225rf3 abstractC20225rf3) {
        AbstractC13042fc3.i(abstractC20225rf3, "holder");
        super.onViewAttachedToWindow(abstractC20225rf3);
        abstractC20225rf3.J0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(AbstractC20225rf3 abstractC20225rf3) {
        AbstractC13042fc3.i(abstractC20225rf3, "holder");
        super.onViewDetachedFromWindow(abstractC20225rf3);
        abstractC20225rf3.L0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(AbstractC20225rf3 abstractC20225rf3) {
        AbstractC13042fc3.i(abstractC20225rf3, "holder");
        abstractC20225rf3.a();
        super.onViewRecycled(abstractC20225rf3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        a aVar;
        if (i >= getItemCount() || i < 0) {
            return a.i.ordinal();
        }
        ContactItem contactItem = (ContactItem) D(i);
        if (contactItem instanceof ContactItem.BaleContactItem) {
            aVar = a.b;
        } else if (contactItem instanceof ContactItem.PhoneBookContactItem) {
            aVar = a.c;
        } else if (contactItem instanceof ContactItem.MxpPuppetContactItem) {
            aVar = a.h;
        } else if (contactItem instanceof ContactItem.SeparatorTitleItem) {
            aVar = a.d;
        } else if (AbstractC13042fc3.d(contactItem, ContactItem.InvitationCard.a)) {
            aVar = a.e;
        } else if (AbstractC13042fc3.d(contactItem, ContactItem.PermissionCard.a)) {
            aVar = a.f;
        } else if (AbstractC13042fc3.d(contactItem, ContactItem.InvitationViaLink.a)) {
            aVar = a.g;
        } else {
            if (contactItem != null) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = a.i;
        }
        return aVar.ordinal();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13137fj1(SA2 sa2, SA2 sa22, UA2 ua2, SA2 sa23, XI4 xi4, EJ4 ej4, InterfaceC22483vJ4 interfaceC22483vJ4, InterfaceC22483vJ4 interfaceC22483vJ42, boolean z) {
        super(C13097ff1.a, null, null, 6, null);
        AbstractC13042fc3.i(sa2, "onInvitationViaLink");
        AbstractC13042fc3.i(xi4, "onBaleContactItemClickedListener");
        AbstractC13042fc3.i(ej4, "onMxpClickListener");
        AbstractC13042fc3.i(interfaceC22483vJ4, "onPhoneBookContactItemClickedListener");
        this.h = sa2;
        this.i = sa22;
        this.j = ua2;
        this.k = sa23;
        this.l = xi4;
        this.m = ej4;
        this.n = interfaceC22483vJ4;
        this.o = interfaceC22483vJ42;
        this.p = z;
    }
}
