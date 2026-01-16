package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.AbstractC7304Rd3;
import java.util.List;

/* renamed from: ir.nasim.Ud3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8011Ud3 extends OT4 {
    public static final a i = new a(null);
    private final UA2 h;

    /* renamed from: ir.nasim.Ud3$a */
    public static final class a {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* renamed from: ir.nasim.Ud3$a$a, reason: collision with other inner class name */
        public static final class EnumC0692a {
            public static final EnumC0692a a = new EnumC0692a("SELECTED_USERS", 0);
            public static final EnumC0692a b = new EnumC0692a("FIRST", 1);
            public static final EnumC0692a c = new EnumC0692a("MIDDLE", 2);
            public static final EnumC0692a d = new EnumC0692a("LAST", 3);
            public static final EnumC0692a e = new EnumC0692a("FIRST_LAST", 4);
            private static final /* synthetic */ EnumC0692a[] f;
            private static final /* synthetic */ F92 g;

            static {
                EnumC0692a[] enumC0692aArrA = a();
                f = enumC0692aArrA;
                g = G92.a(enumC0692aArrA);
            }

            private EnumC0692a(String str, int i) {
            }

            private static final /* synthetic */ EnumC0692a[] a() {
                return new EnumC0692a[]{a, b, c, d, e};
            }

            public static EnumC0692a valueOf(String str) {
                return (EnumC0692a) Enum.valueOf(EnumC0692a.class, str);
            }

            public static EnumC0692a[] values() {
                return (EnumC0692a[]) f.clone();
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8011Ud3(UA2 ua2) {
        super(C7070Qd3.a, null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onItemClickListener");
        this.h = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C7775Td3 c7775Td3, int i2) {
        AbstractC13042fc3.i(c7775Td3, "holder");
        C22613vY c22613vY = (C22613vY) D(i2);
        if (c22613vY == null) {
            return;
        }
        c7775Td3.F0(c22613vY);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C7775Td3 c7775Td3, int i2, List list) {
        AbstractC13042fc3.i(c7775Td3, "holder");
        AbstractC13042fc3.i(list, "payloads");
        if (!(!list.isEmpty())) {
            super.onBindViewHolder(c7775Td3, i2, list);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof AbstractC7304Rd3.a) {
                c7775Td3.J0(((AbstractC7304Rd3.a) obj).a());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C7775Td3 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C22095uf3 c22095uf3C = C22095uf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c22095uf3C, "inflate(...)");
        return new C7775Td3(c22095uf3C, this.h, a.EnumC0692a.values()[i2]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C7775Td3 c7775Td3) {
        AbstractC13042fc3.i(c7775Td3, "holder");
        c7775Td3.a();
        super.onViewRecycled(c7775Td3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i2) {
        return (i2 == 0 && getItemCount() == 1) ? a.EnumC0692a.e.ordinal() : (i2 != 0 || getItemCount() <= 1) ? i2 == getItemCount() - 1 ? a.EnumC0692a.d.ordinal() : a.EnumC0692a.c.ordinal() : a.EnumC0692a.b.ordinal();
    }
}
