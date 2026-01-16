package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.InterfaceC17445my6;

/* loaded from: classes7.dex */
public final class WV7 extends AbstractC15672jy6 {
    private final UA2 l;

    public /* synthetic */ WV7(UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua22, UA2 ua23, int i, ED1 ed1) {
        this(ua2, interfaceC10258bL6, (i & 4) != 0 ? AbstractC20906so1.a(C12366eV1.c()) : interfaceC20315ro1, ua22, ua23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(WV7 wv7, int i, boolean z) {
        AbstractC13042fc3.i(wv7, "this$0");
        wv7.O().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17445my6.e Y(WV7 wv7, int i) {
        AbstractC13042fc3.i(wv7, "this$0");
        InterfaceC17445my6.e eVar = (InterfaceC17445my6.e) wv7.D(i);
        if (((Boolean) wv7.R().getValue()).booleanValue()) {
            if (eVar != null) {
                eVar.c(!eVar.a());
            }
            if (eVar != null) {
                wv7.P().invoke(eVar);
            }
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(KV7 kv7, int i) {
        AbstractC13042fc3.i(kv7, "holder");
        kv7.L0((InterfaceC17445my6) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public KV7 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C3931Cy6 c3931Cy6C = C3931Cy6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c3931Cy6C, "inflate(...)");
        return new KV7(c3931Cy6C, R(), new InterfaceC14603iB2() { // from class: ir.nasim.UV7
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return WV7.X(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, this.l, new UA2() { // from class: ir.nasim.VV7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return WV7.Y(this.a, ((Integer) obj).intValue());
            }
        }, Q());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WV7(UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua22, UA2 ua23) {
        super(interfaceC20315ro1, ua22, ua23, interfaceC10258bL6);
        AbstractC13042fc3.i(ua2, "openMediaCallback");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua22, "changeSelectedMode");
        AbstractC13042fc3.i(ua23, "onItemSelectChange");
        this.l = ua2;
    }
}
