package ir.nasim.features.smiles.panel.sticker;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.q;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C23698xM6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.features.smiles.panel.sticker.e;
import ir.nasim.features.smiles.panel.sticker.l;
import ir.nasim.features.smiles.widget.StickerView;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class m extends q {
    private InterfaceC14603iB2 f;
    private final HashMap g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[o.values().length];
            try {
                iArr[o.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[o.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(InterfaceC14603iB2 interfaceC14603iB2) {
        super(new n());
        AbstractC13042fc3.i(interfaceC14603iB2, "onSelectItem");
        this.f = interfaceC14603iB2;
        this.g = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(m mVar, int i, String str) {
        AbstractC13042fc3.i(mVar, "this$0");
        AbstractC13042fc3.i(str, "reference");
        mVar.g.put(Integer.valueOf(i), str);
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i) {
        C23698xM6 c23698xM6B;
        AbstractC13042fc3.i(eVar, "holder");
        l lVar = (l) A(i);
        if (eVar instanceof e.c) {
            e.c cVar = (e.c) eVar;
            HashMap map = this.g;
            Integer numValueOf = null;
            l.a aVar = lVar instanceof l.a ? (l.a) lVar : null;
            if (aVar != null && (c23698xM6B = aVar.b()) != null) {
                numValueOf = Integer.valueOf(c23698xM6B.y());
            }
            cVar.N0((String) map.get(numValueOf));
        }
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        eVar.E0((l) objA, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        int i2 = a.a[o.b.a(i).ordinal()];
        if (i2 == 1) {
            AbstractC13042fc3.f(context);
            return new e.c(new StickerTabVHParent(context, new StickerView(context, null, 0, 6, null)), new InterfaceC14603iB2() { // from class: ir.nasim.Ni7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return ir.nasim.features.smiles.panel.sticker.m.H(this.a, ((Integer) obj).intValue(), (String) obj2);
                }
            }, this.f);
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC13042fc3.f(context);
        return new e.b(new StickerTabVHParent(context, new ImageView(context)), this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(e eVar) {
        AbstractC13042fc3.i(eVar, "holder");
        super.onViewRecycled(eVar);
        eVar.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        o oVar;
        l lVar = (l) A(i);
        if (lVar instanceof l.a) {
            oVar = o.c;
        } else {
            if (!(lVar instanceof l.b)) {
                throw new NoWhenBranchMatchedException();
            }
            oVar = o.d;
        }
        return oVar.getNumber();
    }
}
