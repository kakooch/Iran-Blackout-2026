package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.O40;
import ir.nasim.UB3;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.c50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10719c50 extends RecyclerView.C {
    public static final a G = new a(null);
    public static final int H = 8;
    private C7079Qe3 A;
    private C6835Pe3 B;
    private UA2 D;
    private O40.a u;
    private Boolean v;
    private UA2 w;
    private UA2 x;
    public UA2 y;
    public UA2 z;

    /* renamed from: ir.nasim.c50$a */
    public static final class a {
        private a() {
        }

        public final C10719c50 a(ViewGroup viewGroup, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onClickListener");
            AbstractC13042fc3.i(ua22, "onDeleteClickListener");
            AbstractC13042fc3.i(ua23, "onDefaultClickListener");
            AbstractC13042fc3.i(ua24, "onEditClickListener");
            AbstractC13042fc3.i(ua25, "shaparakAuthentication");
            C6835Pe3 c6835Pe3C = C6835Pe3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c6835Pe3C, "inflate(...)");
            return new C10719c50(c6835Pe3C, ua2, ua22, ua23, ua24, ua25, null);
        }

        public final C10719c50 b(ViewGroup viewGroup, UA2 ua2, UA2 ua22, UA2 ua23) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onClickListener");
            AbstractC13042fc3.i(ua22, "onDeleteClickListener");
            AbstractC13042fc3.i(ua23, "shaparakAuthentication");
            C7079Qe3 c7079Qe3C = C7079Qe3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c7079Qe3C, "inflate(...)");
            return new C10719c50(c7079Qe3C, ua2, ua22, ua23, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.c50$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[O40.a.values().length];
            try {
                iArr[O40.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[O40.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ C10719c50(C6835Pe3 c6835Pe3, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, ED1 ed1) {
        this(c6835Pe3, ua2, ua22, ua23, ua24, ua25);
    }

    private final void N0(final BankCreditCard bankCreditCard) {
        Integer drawableId;
        C6835Pe3 c6835Pe3 = this.B;
        C6835Pe3 c6835Pe32 = null;
        if (c6835Pe3 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe3 = null;
        }
        c6835Pe3.k.setTypeface(C6011Lu2.k());
        T0(bankCreditCard);
        C6835Pe3 c6835Pe33 = this.B;
        if (c6835Pe33 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe33 = null;
        }
        c6835Pe33.g.setTypeface(C6011Lu2.k());
        C6835Pe3 c6835Pe34 = this.B;
        if (c6835Pe34 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe34 = null;
        }
        c6835Pe34.e.setTypeface(C6011Lu2.k());
        if (bankCreditCard.isDefault() && !bankCreditCard.isShaparkMigrationNeed()) {
            C6835Pe3 c6835Pe35 = this.B;
            if (c6835Pe35 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe35 = null;
            }
            TextView textView = c6835Pe35.e;
            textView.setText(this.a.getContext().getString(AbstractC12217eE5.card_payment_default));
            textView.setBackgroundColor(C5495Jo7.a.c1());
            textView.setVisibility(0);
            AbstractC13042fc3.f(textView);
        } else if (!bankCreditCard.isShaparkMigrationNeed() || bankCreditCard.isSavedInServerSide()) {
            C6835Pe3 c6835Pe36 = this.B;
            if (c6835Pe36 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe36 = null;
            }
            c6835Pe36.e.setVisibility(8);
        } else {
            C6835Pe3 c6835Pe37 = this.B;
            if (c6835Pe37 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe37 = null;
            }
            TextView textView2 = c6835Pe37.e;
            textView2.setText(this.a.getContext().getString(AbstractC12217eE5.card_payment_card_shapark_register_need));
            textView2.setBackgroundColor(C5495Jo7.a.a());
            textView2.setVisibility(0);
            AbstractC13042fc3.f(textView2);
        }
        Bank bank = bankCreditCard.getBank();
        C6835Pe3 c6835Pe38 = this.B;
        if (c6835Pe38 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe38 = null;
        }
        c6835Pe38.f.setImageDrawable((bank == null || (drawableId = bank.getDrawableId()) == null) ? null : AbstractC4043Dl1.f(this.a.getContext(), drawableId.intValue()));
        String name = bank != null ? bank.getName() : null;
        if (name == null || name.length() == 0) {
            C6835Pe3 c6835Pe39 = this.B;
            if (c6835Pe39 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe39 = null;
            }
            c6835Pe39.k.setVisibility(8);
        } else {
            C6835Pe3 c6835Pe310 = this.B;
            if (c6835Pe310 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe310 = null;
            }
            c6835Pe310.k.setVisibility(0);
            C6835Pe3 c6835Pe311 = this.B;
            if (c6835Pe311 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe311 = null;
            }
            c6835Pe311.k.setText(bank != null ? bank.getName() : null);
        }
        C6835Pe3 c6835Pe312 = this.B;
        if (c6835Pe312 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe312 = null;
        }
        c6835Pe312.g.setText(XY6.e(bankCreditCard.getSpacedNumber()));
        C6835Pe3 c6835Pe313 = this.B;
        if (c6835Pe313 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
        } else {
            c6835Pe32 = c6835Pe313;
        }
        ImageButton imageButton = c6835Pe32.j;
        AbstractC13042fc3.h(imageButton, "more");
        a1(imageButton, bankCreditCard);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.V40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C10719c50.O0(this.a, bankCreditCard, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(C10719c50 c10719c50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        c10719c50.w.invoke(bankCreditCard);
    }

    private final void P0(final BankCreditCard bankCreditCard) {
        Integer drawableId;
        C7079Qe3 c7079Qe3 = this.A;
        C7079Qe3 c7079Qe32 = null;
        if (c7079Qe3 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe3 = null;
        }
        c7079Qe3.e.setTypeface(C6011Lu2.k());
        C7079Qe3 c7079Qe33 = this.A;
        if (c7079Qe33 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe33 = null;
        }
        c7079Qe33.c.setTypeface(C6011Lu2.k());
        Bank bank = bankCreditCard.getBank();
        C7079Qe3 c7079Qe34 = this.A;
        if (c7079Qe34 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe34 = null;
        }
        c7079Qe34.b.setImageDrawable((bank == null || (drawableId = bank.getDrawableId()) == null) ? null : AbstractC4043Dl1.f(this.a.getContext(), drawableId.intValue()));
        String ownerName = bankCreditCard.getOwnerName();
        if (ownerName == null || ownerName.length() == 0) {
            C7079Qe3 c7079Qe35 = this.A;
            if (c7079Qe35 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe35 = null;
            }
            c7079Qe35.e.setVisibility(8);
        } else {
            C7079Qe3 c7079Qe36 = this.A;
            if (c7079Qe36 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe36 = null;
            }
            c7079Qe36.e.setVisibility(0);
            C7079Qe3 c7079Qe37 = this.A;
            if (c7079Qe37 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe37 = null;
            }
            c7079Qe37.e.setText(bankCreditCard.getOwnerName());
        }
        C7079Qe3 c7079Qe38 = this.A;
        if (c7079Qe38 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe38 = null;
        }
        c7079Qe38.c.setText(XY6.e(bankCreditCard.getSpacedNumber()));
        C7079Qe3 c7079Qe39 = this.A;
        if (c7079Qe39 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
        } else {
            c7079Qe32 = c7079Qe39;
        }
        c7079Qe32.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.W40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C10719c50.Q0(this.a, bankCreditCard, view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.X40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C10719c50.S0(this.a, bankCreditCard, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(C10719c50 c10719c50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        c10719c50.x.invoke(bankCreditCard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(C10719c50 c10719c50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        c10719c50.w.invoke(bankCreditCard);
    }

    private final void T0(final BankCreditCard bankCreditCard) {
        C6835Pe3 c6835Pe3 = this.B;
        if (c6835Pe3 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe3 = null;
        }
        if (bankCreditCard.isEnrolled() && this.v.booleanValue()) {
            c6835Pe3.n.setVisibility(0);
            c6835Pe3.l.setVisibility(8);
            c6835Pe3.o.setTypeface(C6011Lu2.k());
        } else if (!bankCreditCard.isEnrolled() || this.v.booleanValue()) {
            c6835Pe3.n.setVisibility(8);
            c6835Pe3.l.setVisibility(8);
        } else {
            c6835Pe3.n.setVisibility(8);
            c6835Pe3.l.setVisibility(0);
            c6835Pe3.m.setTypeface(C6011Lu2.k());
        }
        c6835Pe3.d.setTypeface(C6011Lu2.i());
        c6835Pe3.m.setTypeface(C6011Lu2.i());
        if (!bankCreditCard.isEnrolled()) {
            c6835Pe3.h.setVisibility(0);
            c6835Pe3.n.setVisibility(8);
            c6835Pe3.l.setVisibility(8);
            c6835Pe3.c.setColorFilter(AbstractC4043Dl1.c(this.a.getContext(), TA5.secondary_2));
            c6835Pe3.b.setVisibility(0);
            c6835Pe3.d.setText(this.a.getContext().getString(AbstractC12217eE5.register_in_shaparak));
            c6835Pe3.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.a50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C10719c50.U0(this.a, bankCreditCard, view);
                }
            });
            c6835Pe3.c.setImageResource(KB5.fingerprint);
            return;
        }
        if (this.v.booleanValue()) {
            c6835Pe3.h.setVisibility(4);
            c6835Pe3.b.setVisibility(8);
            return;
        }
        c6835Pe3.c.setColorFilter(AbstractC4043Dl1.c(this.a.getContext(), TA5.secondary_2));
        c6835Pe3.n.setVisibility(8);
        c6835Pe3.b.setVisibility(0);
        c6835Pe3.h.setVisibility(0);
        c6835Pe3.l.setVisibility(0);
        c6835Pe3.m.setText(this.a.getContext().getString(AbstractC12217eE5.need_verfied));
        c6835Pe3.c.setImageResource(KB5.restore);
        c6835Pe3.d.setText(this.a.getContext().getString(AbstractC12217eE5.re_authentication_in_Shapark_system));
        c6835Pe3.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.b50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C10719c50.V0(this.a, bankCreditCard, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C10719c50 c10719c50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        c10719c50.D.invoke(bankCreditCard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(C10719c50 c10719c50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        c10719c50.D.invoke(bankCreditCard);
    }

    private final void a1(View view, final BankCreditCard bankCreditCard) {
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this.a.getContext());
        final ArrayList arrayList = new ArrayList();
        if (!bankCreditCard.isDefault()) {
            String string = this.a.getContext().getString(AbstractC12217eE5.card_payment_set_for_default_card);
            AbstractC13042fc3.h(string, "getString(...)");
            int i = KB5.ic_card_payment_star;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            arrayList.add(new C18684p44(0, string, i, c5495Jo7.g0(), c5495Jo7.o0(), 0, 32, null));
        }
        String string2 = this.a.getContext().getString(AbstractC12217eE5.card_payment_edit_card);
        AbstractC13042fc3.h(string2, "getString(...)");
        int i2 = KB5.ic_card_payment_edit;
        C5495Jo7 c5495Jo72 = C5495Jo7.a;
        arrayList.add(new C18684p44(1, string2, i2, c5495Jo72.g0(), c5495Jo72.o0(), 0, 32, null));
        String string3 = this.a.getContext().getString(AbstractC12217eE5.card_payment_delete_card);
        AbstractC13042fc3.h(string3, "getString(...)");
        arrayList.add(new C18684p44(2, string3, KB5.ic_card_payment_delete_icon_classic, c5495Jo72.X0(), c5495Jo72.X0(), 0, 32, null));
        UB3 ub3 = new UB3(this.a.getContext(), arrayList, false, 4, null);
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setAdapter(ub3);
        UB3.a aVar = UB3.d;
        listPopupWindow.setContentWidth(aVar.a());
        listPopupWindow.setWidth(aVar.a());
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.Y40
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i3, long j) {
                C10719c50.c1(this.a, arrayList, bankCreditCard, listPopupWindow, adapterView, view2, i3, j);
            }
        });
        C6835Pe3 c6835Pe3 = this.B;
        if (c6835Pe3 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe3 = null;
        }
        c6835Pe3.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Z40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C10719c50.d1(listPopupWindow, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(C10719c50 c10719c50, ArrayList arrayList, BankCreditCard bankCreditCard, ListPopupWindow listPopupWindow, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(c10719c50, "this$0");
        AbstractC13042fc3.i(arrayList, "$itemList");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        AbstractC13042fc3.i(listPopupWindow, "$popupWindow");
        int iD = ((C18684p44) arrayList.get(i)).d();
        if (iD == 0) {
            c10719c50.W0().invoke(bankCreditCard);
        } else if (iD == 1) {
            c10719c50.X0().invoke(bankCreditCard);
        } else if (iD == 2) {
            c10719c50.x.invoke(bankCreditCard);
        }
        try {
            listPopupWindow.dismiss();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(ListPopupWindow listPopupWindow, View view) {
        AbstractC13042fc3.i(listPopupWindow, "$popupWindow");
        listPopupWindow.show();
    }

    public final void M0(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        this.v = AbstractC19902r80.a();
        int i = b.a[this.u.ordinal()];
        if (i == 1) {
            P0(bankCreditCard);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            N0(bankCreditCard);
        }
    }

    public final UA2 W0() {
        UA2 ua2 = this.y;
        if (ua2 != null) {
            return ua2;
        }
        AbstractC13042fc3.y("onDefaultClickListener");
        return null;
    }

    public final UA2 X0() {
        UA2 ua2 = this.z;
        if (ua2 != null) {
            return ua2;
        }
        AbstractC13042fc3.y("onEditClickListener");
        return null;
    }

    public final void Y0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "<set-?>");
        this.y = ua2;
    }

    public final void Z0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "<set-?>");
        this.z = ua2;
    }

    public /* synthetic */ C10719c50(C7079Qe3 c7079Qe3, UA2 ua2, UA2 ua22, UA2 ua23, ED1 ed1) {
        this(c7079Qe3, ua2, ua22, ua23);
    }

    private C10719c50(C7079Qe3 c7079Qe3, UA2 ua2, UA2 ua22, UA2 ua23) {
        super(c7079Qe3.getRoot());
        this.v = AbstractC19902r80.a();
        this.A = c7079Qe3;
        this.u = O40.a.a;
        this.w = ua2;
        this.x = ua22;
        this.D = ua23;
    }

    private C10719c50(C6835Pe3 c6835Pe3, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25) {
        super(c6835Pe3.getRoot());
        this.v = AbstractC19902r80.a();
        this.B = c6835Pe3;
        this.u = O40.a.b;
        this.w = ua2;
        this.x = ua22;
        Y0(ua23);
        Z0(ua24);
        this.D = ua25;
    }
}
