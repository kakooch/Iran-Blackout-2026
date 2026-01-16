package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.image.view.BouncerImageView;

/* renamed from: ir.nasim.eH5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12244eH5 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = BouncerImageView.h;
    private final BouncerImageView u;
    private final UA2 v;

    /* renamed from: ir.nasim.eH5$a */
    public static final class a {
        private a() {
        }

        public final C12244eH5 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onItemClick");
            Context context = viewGroup.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            return new C12244eH5(new BouncerImageView(context, null, 0, 6, null), ua2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12244eH5(BouncerImageView bouncerImageView, UA2 ua2) {
        super(bouncerImageView);
        AbstractC13042fc3.i(bouncerImageView, "imageView");
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.u = bouncerImageView;
        this.v = ua2;
        double d = 40;
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d));
        double d2 = 1;
        double d3 = 6;
        layoutParams.setMargins((int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d));
        bouncerImageView.setLayoutParams(layoutParams);
        AbstractC12990fW7.F0(bouncerImageView, (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((d3 * AbstractC3742Cd6.c()) + 0.5d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C12244eH5 c12244eH5, C12853fH5 c12853fH5, View view) {
        AbstractC13042fc3.i(c12244eH5, "this$0");
        AbstractC13042fc3.i(c12853fH5, "$item");
        c12244eH5.v.invoke(c12853fH5);
    }

    private final Drawable F0(Context context, boolean z) {
        int iC = (int) ((10 * AbstractC3742Cd6.c()) + 0.5d);
        int iK = QY0.k(AbstractC4043Dl1.c(context, GA5.n10_dark), 99);
        if (!z) {
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{iK}), null, AbstractC4310Eo7.d(iC, iK));
        }
        Drawable drawableD = AbstractC4310Eo7.d(iC, iK);
        AbstractC13042fc3.f(drawableD);
        return drawableD;
    }

    public final void D0(final C12853fH5 c12853fH5) {
        AbstractC13042fc3.i(c12853fH5, "item");
        BouncerImageView bouncerImageView = this.u;
        Context context = bouncerImageView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        bouncerImageView.setBackground(F0(context, c12853fH5.b()));
        bouncerImageView.setImageDrawable(R62.A(c12853fH5.a()));
        bouncerImageView.setContentDescription(c12853fH5.a());
        bouncerImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bH5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12244eH5.E0(this.a, c12853fH5, view);
            }
        });
    }

    public final void a() {
        BouncerImageView bouncerImageView = this.u;
        bouncerImageView.setBackground(null);
        bouncerImageView.setImageDrawable(null);
        bouncerImageView.setOnClickListener(null);
    }
}
