package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.image.view.BouncerImageView;

/* renamed from: ir.nasim.dH5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11601dH5 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private final BouncerImageView u;
    private final RJ4 v;

    /* renamed from: ir.nasim.dH5$a */
    public static final class a {
        private a() {
        }

        public final C11601dH5 a(ViewGroup viewGroup, RJ4 rj4) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(rj4, "onReactionClickListener");
            Context context = viewGroup.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            return new C11601dH5(new BouncerImageView(context, null, 0, 6, null), rj4, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C11601dH5(BouncerImageView bouncerImageView, RJ4 rj4, ED1 ed1) {
        this(bouncerImageView, rj4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C11601dH5 c11601dH5, C13471gH5 c13471gH5, View view) {
        AbstractC13042fc3.i(c11601dH5, "this$0");
        AbstractC13042fc3.i(c13471gH5, "$item");
        c11601dH5.v.a(c13471gH5.a(), c13471gH5.d());
    }

    public final void D0(final C13471gH5 c13471gH5) {
        AbstractC13042fc3.i(c13471gH5, "item");
        BouncerImageView bouncerImageView = this.u;
        bouncerImageView.setBackground(c13471gH5.c());
        bouncerImageView.setImageDrawable(c13471gH5.b());
        bouncerImageView.setContentDescription(c13471gH5.a());
        bouncerImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cH5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C11601dH5.E0(this.a, c13471gH5, view);
            }
        });
    }

    public final void a() {
        BouncerImageView bouncerImageView = this.u;
        bouncerImageView.setBackground(null);
        bouncerImageView.setImageDrawable(null);
        bouncerImageView.setOnClickListener(null);
    }

    private C11601dH5(BouncerImageView bouncerImageView, RJ4 rj4) {
        super(bouncerImageView);
        this.u = bouncerImageView;
        this.v = rj4;
        double d = 40;
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d));
        double d2 = 1;
        double d3 = 6;
        layoutParams.setMargins((int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d));
        bouncerImageView.setLayoutParams(layoutParams);
        AbstractC12990fW7.F0(bouncerImageView, (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d), (int) ((d3 * AbstractC3742Cd6.c()) + 0.5d));
    }
}
