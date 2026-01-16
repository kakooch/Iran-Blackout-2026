package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.I40;
import ir.nasim.UB3;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class U40 extends RecyclerView.C {
    private I40.d u;
    private I40.a v;
    private I40.c w;
    private C7079Qe3 x;
    private C6835Pe3 y;
    public static final a z = new a(null);
    public static final int A = 8;

    public static final class a {
        private a() {
        }

        public final U40 a(ViewGroup viewGroup, I40.a aVar, I40.c cVar, I40.b bVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C6835Pe3 c6835Pe3C = C6835Pe3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c6835Pe3C, "inflate(...)");
            return new U40(c6835Pe3C, aVar, cVar, bVar, null);
        }

        public final U40 b(ViewGroup viewGroup, I40.a aVar, I40.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C7079Qe3 c7079Qe3C = C7079Qe3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c7079Qe3C, "inflate(...)");
            return new U40(c7079Qe3C, aVar, cVar, (ED1) null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[I40.d.values().length];
            try {
                iArr[I40.d.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[I40.d.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ U40(C6835Pe3 c6835Pe3, I40.a aVar, I40.c cVar, I40.b bVar, ED1 ed1) {
        this(c6835Pe3, aVar, cVar, bVar);
    }

    private final void L0(final H40 h40) {
        C6835Pe3 c6835Pe3 = this.y;
        C6835Pe3 c6835Pe32 = null;
        if (c6835Pe3 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe3 = null;
        }
        c6835Pe3.k.setTypeface(C6011Lu2.k());
        C6835Pe3 c6835Pe33 = this.y;
        if (c6835Pe33 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe33 = null;
        }
        c6835Pe33.g.setTypeface(C6011Lu2.k());
        C6835Pe3 c6835Pe34 = this.y;
        if (c6835Pe34 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe34 = null;
        }
        c6835Pe34.e.setTypeface(C6011Lu2.k());
        if (h40.f() && !h40.h()) {
            C6835Pe3 c6835Pe35 = this.y;
            if (c6835Pe35 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe35 = null;
            }
            TextView textView = c6835Pe35.e;
            textView.setText(this.a.getContext().getString(AbstractC12217eE5.card_payment_default));
            textView.setBackgroundColor(C5495Jo7.a.c1());
            textView.setVisibility(0);
            AbstractC13042fc3.f(textView);
        } else if (!h40.h() || h40.g()) {
            C6835Pe3 c6835Pe36 = this.y;
            if (c6835Pe36 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe36 = null;
            }
            c6835Pe36.e.setVisibility(8);
        } else {
            C6835Pe3 c6835Pe37 = this.y;
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
        C6835Pe3 c6835Pe38 = this.y;
        if (c6835Pe38 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe38 = null;
        }
        c6835Pe38.f.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), h40.b()));
        String strE = h40.e();
        if (strE == null || strE.length() == 0) {
            C6835Pe3 c6835Pe39 = this.y;
            if (c6835Pe39 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe39 = null;
            }
            c6835Pe39.k.setVisibility(8);
        } else {
            C6835Pe3 c6835Pe310 = this.y;
            if (c6835Pe310 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe310 = null;
            }
            c6835Pe310.k.setVisibility(0);
            C6835Pe3 c6835Pe311 = this.y;
            if (c6835Pe311 == null) {
                AbstractC13042fc3.y("bindingManagementCard");
                c6835Pe311 = null;
            }
            c6835Pe311.k.setText(h40.e());
        }
        C6835Pe3 c6835Pe312 = this.y;
        if (c6835Pe312 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe312 = null;
        }
        c6835Pe312.g.setText(h40.d());
        C6835Pe3 c6835Pe313 = this.y;
        if (c6835Pe313 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
        } else {
            c6835Pe32 = c6835Pe313;
        }
        ImageButton imageButton = c6835Pe32.j;
        AbstractC13042fc3.h(imageButton, "more");
        Q0(imageButton, h40);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.P40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                U40.M0(this.a, h40, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(U40 u40, H40 h40, View view) {
        AbstractC13042fc3.i(u40, "this$0");
        AbstractC13042fc3.i(h40, "$saved");
        I40.a aVar = u40.v;
        if (aVar != null) {
            aVar.u4(h40);
        }
    }

    private final void N0(final H40 h40) {
        C7079Qe3 c7079Qe3 = this.x;
        C7079Qe3 c7079Qe32 = null;
        if (c7079Qe3 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe3 = null;
        }
        c7079Qe3.e.setTypeface(C6011Lu2.k());
        C7079Qe3 c7079Qe33 = this.x;
        if (c7079Qe33 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe33 = null;
        }
        c7079Qe33.c.setTypeface(C6011Lu2.k());
        C7079Qe3 c7079Qe34 = this.x;
        if (c7079Qe34 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe34 = null;
        }
        c7079Qe34.b.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), h40.b()));
        String strE = h40.e();
        if (strE == null || strE.length() == 0) {
            C7079Qe3 c7079Qe35 = this.x;
            if (c7079Qe35 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe35 = null;
            }
            c7079Qe35.e.setVisibility(8);
        } else {
            C7079Qe3 c7079Qe36 = this.x;
            if (c7079Qe36 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe36 = null;
            }
            c7079Qe36.e.setVisibility(0);
            C7079Qe3 c7079Qe37 = this.x;
            if (c7079Qe37 == null) {
                AbstractC13042fc3.y("bindingSelectCard");
                c7079Qe37 = null;
            }
            c7079Qe37.e.setText(h40.e());
        }
        C7079Qe3 c7079Qe38 = this.x;
        if (c7079Qe38 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
            c7079Qe38 = null;
        }
        c7079Qe38.c.setText(h40.d());
        C7079Qe3 c7079Qe39 = this.x;
        if (c7079Qe39 == null) {
            AbstractC13042fc3.y("bindingSelectCard");
        } else {
            c7079Qe32 = c7079Qe39;
        }
        c7079Qe32.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                U40.O0(this.a, h40, view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.R40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                U40.P0(this.a, h40, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(U40 u40, H40 h40, View view) {
        AbstractC13042fc3.i(u40, "this$0");
        AbstractC13042fc3.i(h40, "$saved");
        I40.c cVar = u40.w;
        if (cVar != null) {
            cVar.W4(h40);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(U40 u40, H40 h40, View view) {
        AbstractC13042fc3.i(u40, "this$0");
        AbstractC13042fc3.i(h40, "$saved");
        I40.a aVar = u40.v;
        if (aVar != null) {
            aVar.u4(h40);
        }
    }

    private final void Q0(View view, final H40 h40) {
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this.a.getContext());
        ArrayList arrayList = new ArrayList();
        String string = this.a.getContext().getString(AbstractC12217eE5.card_payment_set_for_default_card);
        AbstractC13042fc3.h(string, "getString(...)");
        int i = KB5.ic_card_payment_star;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        arrayList.add(new C18684p44(0, string, i, c5495Jo7.g0(), c5495Jo7.o0(), 0, 32, null));
        String string2 = this.a.getContext().getString(AbstractC12217eE5.card_payment_delete_card);
        AbstractC13042fc3.h(string2, "getString(...)");
        arrayList.add(new C18684p44(1, string2, KB5.ic_card_payment_delete_icon_classic, c5495Jo7.X0(), c5495Jo7.X0(), 0, 32, null));
        UB3 ub3 = new UB3(this.a.getContext(), arrayList, false, 4, null);
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setAdapter(ub3);
        UB3.a aVar = UB3.d;
        listPopupWindow.setContentWidth(aVar.a());
        listPopupWindow.setWidth(aVar.a());
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.S40
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                U40.S0(this.a, h40, listPopupWindow, adapterView, view2, i2, j);
            }
        });
        C6835Pe3 c6835Pe3 = this.y;
        if (c6835Pe3 == null) {
            AbstractC13042fc3.y("bindingManagementCard");
            c6835Pe3 = null;
        }
        c6835Pe3.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.T40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                U40.T0(listPopupWindow, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(U40 u40, H40 h40, ListPopupWindow listPopupWindow, AdapterView adapterView, View view, int i, long j) {
        I40.c cVar;
        AbstractC13042fc3.i(u40, "this$0");
        AbstractC13042fc3.i(h40, "$saved");
        AbstractC13042fc3.i(listPopupWindow, "$popupWindow");
        if (i == 0) {
            u40.getClass();
        } else if (i == 1 && (cVar = u40.w) != null) {
            cVar.W4(h40);
        }
        try {
            listPopupWindow.dismiss();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ListPopupWindow listPopupWindow, View view) {
        AbstractC13042fc3.i(listPopupWindow, "$popupWindow");
        listPopupWindow.show();
    }

    public final void J0(H40 h40) {
        AbstractC13042fc3.i(h40, "saved");
        int i = b.a[this.u.ordinal()];
        if (i == 1) {
            N0(h40);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            L0(h40);
        }
    }

    public /* synthetic */ U40(C7079Qe3 c7079Qe3, I40.a aVar, I40.c cVar, ED1 ed1) {
        this(c7079Qe3, aVar, cVar);
    }

    private U40(C7079Qe3 c7079Qe3, I40.a aVar, I40.c cVar) {
        super(c7079Qe3.getRoot());
        this.x = c7079Qe3;
        this.u = I40.d.a;
        this.v = aVar;
        this.w = cVar;
    }

    private U40(C6835Pe3 c6835Pe3, I40.a aVar, I40.c cVar, I40.b bVar) {
        super(c6835Pe3.getRoot());
        this.y = c6835Pe3;
        this.u = I40.d.b;
        this.v = aVar;
        this.w = cVar;
    }
}
