package ir.nasim.features.smiles.panel.sticker;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.q;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C23698xM6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.features.smiles.panel.sticker.d;
import ir.nasim.features.smiles.panel.sticker.k;
import ir.nasim.features.smiles.widget.StickerView;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class j extends q {
    private final InterfaceC14603iB2 f;
    private final HashMap g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            try {
                iArr[i.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InterfaceC14603iB2 interfaceC14603iB2) {
        super(new ir.nasim.features.smiles.panel.sticker.a());
        AbstractC13042fc3.i(interfaceC14603iB2, "onStickerSelect");
        this.f = interfaceC14603iB2;
        this.g = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(j jVar, int i, String str) {
        AbstractC13042fc3.i(jVar, "this$0");
        AbstractC13042fc3.i(str, "reference");
        jVar.g.put(Integer.valueOf(i), str);
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(k kVar, int i) {
        C23698xM6 c23698xM6B;
        AbstractC13042fc3.i(kVar, "holder");
        d dVar = (d) A(i);
        if (kVar instanceof k.b) {
            k.b bVar = (k.b) kVar;
            HashMap map = this.g;
            Integer numValueOf = null;
            d.b bVar2 = dVar instanceof d.b ? (d.b) dVar : null;
            if (bVar2 != null && (c23698xM6B = bVar2.b()) != null) {
                numValueOf = Integer.valueOf(c23698xM6B.y());
            }
            bVar.O0((String) map.get(numValueOf));
        }
        AbstractC13042fc3.f(dVar);
        kVar.C0(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public k onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        int i2 = a.a[i.b.a(i).ordinal()];
        if (i2 == 1) {
            return new k.a(new TextView(context));
        }
        if (i2 != 2 && i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC13042fc3.f(context);
        return new k.b(new StickerView(context, null, 0, 6, null), new InterfaceC14603iB2() { // from class: ir.nasim.zN6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ir.nasim.features.smiles.panel.sticker.j.H(this.a, ((Integer) obj).intValue(), (String) obj2);
            }
        }, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(k kVar) {
        AbstractC13042fc3.i(kVar, "holder");
        super.onViewRecycled(kVar);
        kVar.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        i iVar;
        d dVar = (d) A(i);
        if (dVar instanceof d.a) {
            iVar = i.c;
        } else {
            if (!(dVar instanceof d.b)) {
                throw new NoWhenBranchMatchedException();
            }
            iVar = ((d.b) dVar).c() ? i.e : i.d;
        }
        return iVar.getNumber();
    }
}
