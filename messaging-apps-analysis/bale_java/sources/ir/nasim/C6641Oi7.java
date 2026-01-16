package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC5909Li7;
import ir.nasim.C19528qW;
import ir.nasim.JW;
import ir.nasim.premium.ui.badge.BadgeView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Oi7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6641Oi7 extends androidx.recyclerview.widget.q {
    private final InterfaceC18633oz3 f;
    private final InterfaceC14603iB2 g;

    /* renamed from: ir.nasim.Oi7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11895dj7.values().length];
            try {
                iArr[EnumC11895dj7.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC11895dj7.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6641Oi7(InterfaceC18633oz3 interfaceC18633oz3, InterfaceC14603iB2 interfaceC14603iB2) {
        super(new C6875Pi7());
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSelectItem");
        this.f = interfaceC18633oz3;
        this.g = interfaceC14603iB2;
    }

    private final void E(BadgeView badgeView, ViewGroup viewGroup) {
        C19528qW.b bVar = C19528qW.p;
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        badgeView.setShimmerEffect(bVar.e(context));
        badgeView.setLayoutParams(new FrameLayout.LayoutParams(bVar.d(), bVar.d(), 16));
        badgeView.setPadding(bVar.c(), bVar.c(), bVar.c(), bVar.c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(JW jw, int i) {
        AbstractC13042fc3.i(jw, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        jw.C0((AbstractC5909Li7) objA, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public JW onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        int i2 = a.a[EnumC11895dj7.b.a(i).ordinal()];
        if (i2 == 1) {
            AbstractC13042fc3.f(context);
            BadgeView badgeView = new BadgeView(context, null, 0, 6, null);
            badgeView.setAutoRepeat();
            E(badgeView, viewGroup);
            return new JW.a(badgeView, this.f, this.g);
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC13042fc3.f(context);
        BadgeView badgeView2 = new BadgeView(context, null, 0, 6, null);
        E(badgeView2, viewGroup);
        return new JW.b(badgeView2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(JW jw) {
        AbstractC13042fc3.i(jw, "holder");
        super.onViewRecycled(jw);
        jw.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        EnumC11895dj7 enumC11895dj7;
        AbstractC5909Li7 abstractC5909Li7 = (AbstractC5909Li7) A(i);
        if (abstractC5909Li7 instanceof AbstractC5909Li7.a) {
            enumC11895dj7 = EnumC11895dj7.c;
        } else {
            if (!(abstractC5909Li7 instanceof AbstractC5909Li7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            enumC11895dj7 = EnumC11895dj7.d;
        }
        return enumC11895dj7.getNumber();
    }
}
