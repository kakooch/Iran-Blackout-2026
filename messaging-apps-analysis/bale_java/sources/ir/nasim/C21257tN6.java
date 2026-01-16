package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.BN6;
import ir.nasim.C21257tN6;
import ir.nasim.features.smiles.widget.StickerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tN6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21257tN6 extends RecyclerView.h {
    private ArrayList d = new ArrayList();
    private final HashMap e = new HashMap();
    private final ArrayList f = new ArrayList();
    private InterfaceC11627dK4 g;

    /* renamed from: ir.nasim.tN6$a */
    public final class a extends RecyclerView.C {
        private C23698xM6 u;
        private StickerView v;
        final /* synthetic */ C21257tN6 w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final C21257tN6 c21257tN6, View view) {
            super(view);
            AbstractC13042fc3.i(view, "itemView");
            this.w = c21257tN6;
            if (view instanceof StickerView) {
                int iA = C22078ud6.a(5.0f);
                StickerView stickerView = (StickerView) view;
                this.v = stickerView;
                StickerView stickerView2 = null;
                if (stickerView == null) {
                    AbstractC13042fc3.y("stickerView");
                    stickerView = null;
                }
                stickerView.setPadding(iA, iA, iA, iA);
                StickerView stickerView3 = this.v;
                if (stickerView3 == null) {
                    AbstractC13042fc3.y("stickerView");
                    stickerView3 = null;
                }
                stickerView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rN6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        C21257tN6.a.E0(this.a, c21257tN6, view2);
                    }
                });
                StickerView stickerView4 = this.v;
                if (stickerView4 == null) {
                    AbstractC13042fc3.y("stickerView");
                } else {
                    stickerView2 = stickerView4;
                }
                stickerView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.sN6
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return C21257tN6.a.F0(view2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E0(a aVar, C21257tN6 c21257tN6, View view) {
            InterfaceC11627dK4 interfaceC11627dK4;
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(c21257tN6, "this$1");
            C23698xM6 c23698xM6 = aVar.u;
            if (c23698xM6 == null || (interfaceC11627dK4 = c21257tN6.g) == null) {
                return;
            }
            interfaceC11627dK4.P3(c23698xM6, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean F0(View view) {
            return false;
        }

        public final void H0(C23698xM6 c23698xM6) {
            AbstractC13042fc3.i(c23698xM6, "s");
            this.u = c23698xM6;
            StickerView stickerView = this.v;
            if (stickerView == null) {
                AbstractC13042fc3.y("stickerView");
                stickerView = null;
            }
            StickerView.b(stickerView, c23698xM6.z(), null, 2, null);
        }

        public final C23698xM6 J0() {
            return this.u;
        }

        public final void a() {
            StickerView stickerView = null;
            this.u = null;
            StickerView stickerView2 = this.v;
            if (stickerView2 == null) {
                AbstractC13042fc3.y("stickerView");
            } else {
                stickerView = stickerView2;
            }
            stickerView.m();
        }
    }

    public C21257tN6() {
        BN6.b bVar = BN6.e;
        C6287Mz c6287MzS = C5735Kp4.w().i().o2().s();
        AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
        InterfaceC3570Bk5 interfaceC3570Bk5C = C5735Kp4.w().i().o2().c();
        AbstractC13042fc3.h(interfaceC3570Bk5C, "<get-preferences>(...)");
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        B((List) bVar.a(c6287MzS, interfaceC3570Bk5C, interfaceC3570Bk5Q).p().getValue());
    }

    private final void B(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List<C23698xM6> listW = ((OM6) it.next()).w();
            AbstractC13042fc3.h(listW, "getStickers(...)");
            for (C23698xM6 c23698xM6 : listW) {
                if (c23698xM6.w() != null) {
                    String strW = c23698xM6.w();
                    AbstractC13042fc3.f(strW);
                    if (strW.length() != 0) {
                        ArrayList arrayList = (ArrayList) this.e.get(c23698xM6.w());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c23698xM6);
                        this.e.put(c23698xM6.w(), arrayList);
                    }
                }
            }
        }
    }

    public final void A(String str) {
        ArrayList arrayList = (ArrayList) this.e.get(str);
        if (arrayList != null) {
            this.d = arrayList;
            notifyDataSetChanged();
        } else {
            if (this.d.isEmpty()) {
                return;
            }
            this.d = this.f;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        aVar.H0((C23698xM6) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        StickerView stickerView = new StickerView(context, null, 0, 6, null);
        int iA = C22078ud6.a(70.0f);
        stickerView.setLayoutParams(new FrameLayout.LayoutParams(iA, iA));
        return new a(this, stickerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(a aVar) {
        AbstractC13042fc3.i(aVar, "holder");
        super.onViewRecycled(aVar);
        aVar.a();
    }

    public final void F() {
        this.g = null;
    }

    public final void G(InterfaceC11627dK4 interfaceC11627dK4) {
        AbstractC13042fc3.i(interfaceC11627dK4, "onStickerClickListener");
        this.g = interfaceC11627dK4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }
}
