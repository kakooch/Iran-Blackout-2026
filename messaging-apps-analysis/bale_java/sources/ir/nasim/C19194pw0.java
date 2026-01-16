package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19785qw0;
import ir.nasim.InterfaceC16239kw0;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.pw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19194pw0 extends OT4 {
    private final InterfaceC23079wJ4 h;
    private final SA2 i;
    private final SA2 j;
    private final SA2 k;
    private final UA2 l;
    private final InterfaceC10258bL6 m;
    private final InterfaceC10258bL6 n;
    private final SA2 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19194pw0(InterfaceC23079wJ4 interfaceC23079wJ4, SA2 sa2, SA2 sa22, SA2 sa23, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, SA2 sa24) {
        super(C14450hw0.a, null, null, 6, null);
        AbstractC13042fc3.i(interfaceC23079wJ4, "onItemClickedListener");
        AbstractC13042fc3.i(sa2, "refreshCallLogClicked");
        AbstractC13042fc3.i(sa22, "selectAllCheckboxClicked");
        AbstractC13042fc3.i(sa23, "showContactCallFragment");
        AbstractC13042fc3.i(ua2, "showStoryFragment");
        AbstractC13042fc3.i(interfaceC10258bL6, "isCallLogListEmpty");
        AbstractC13042fc3.i(interfaceC10258bL62, "permissionState");
        AbstractC13042fc3.i(sa24, "showPermissionDialog");
        this.h = interfaceC23079wJ4;
        this.i = sa2;
        this.j = sa22;
        this.k = sa23;
        this.l = ua2;
        this.m = interfaceC10258bL6;
        this.n = interfaceC10258bL62;
        this.o = sa24;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        InterfaceC16239kw0 interfaceC16239kw0 = (InterfaceC16239kw0) D(i);
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.f) {
            return RI4.z.a();
        }
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.d) {
            return QU2.w.a();
        }
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.a) {
            return C3907Cw0.w.a();
        }
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.b) {
            return C18213oH1.w.a();
        }
        throw new IllegalStateException("this type is not found! " + D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "holder");
        InterfaceC16239kw0 interfaceC16239kw0 = (InterfaceC16239kw0) D(i);
        if (interfaceC16239kw0 == null) {
            return;
        }
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.d) {
            ((QU2) c).E0();
            return;
        }
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.a) {
            ((C3907Cw0) c).M0((InterfaceC16239kw0.a) interfaceC16239kw0);
        } else if (interfaceC16239kw0 instanceof InterfaceC16239kw0.b) {
            ((C18213oH1) c).F0((InterfaceC16239kw0.b) interfaceC16239kw0);
        } else if (!(interfaceC16239kw0 instanceof InterfaceC16239kw0.f)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == RI4.z.a()) {
            GI4 gi4C = GI4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(gi4C, "inflate(...)");
            return new RI4(gi4C, this.k, this.l, this.m, this.n, this.o);
        }
        if (i == C3907Cw0.w.a()) {
            C16830lw0 c16830lw0C = C16830lw0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c16830lw0C, "inflate(...)");
            return new C3907Cw0(c16830lw0C, this.h);
        }
        if (i == QU2.w.a()) {
            OU2 ou2C = OU2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(ou2C, "inflate(...)");
            return new QU2(ou2C, this.i);
        }
        if (i != C18213oH1.w.a()) {
            throw new IllegalStateException("this type is not found!");
        }
        C17031mH1 c17031mH1C = C17031mH1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c17031mH1C, "inflate(...)");
        return new C18213oH1(c17031mH1C, this.j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C3907Cw0) {
            ((C3907Cw0) c).a();
        }
        super.onViewRecycled(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i, List list) {
        AbstractC13042fc3.i(c, "holder");
        AbstractC13042fc3.i(list, "payloads");
        if (!list.isEmpty()) {
            ArrayList<AbstractC19785qw0> arrayList = new ArrayList();
            for (Object obj : list) {
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.collections.List<ir.nasim.call.ui.calllog.adapters.CallLogPayload>");
                AbstractC13610gX0.D(arrayList, (List) obj);
            }
            for (AbstractC19785qw0 abstractC19785qw0 : arrayList) {
                if (c instanceof C3907Cw0) {
                    if (abstractC19785qw0 instanceof AbstractC19785qw0.a) {
                        ((C3907Cw0) c).V0(((AbstractC19785qw0.a) abstractC19785qw0).a());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return;
        }
        super.onBindViewHolder(c, i, list);
    }
}
