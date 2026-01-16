package ir.nasim;

import android.view.View;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.story.ui.viewfragment.views.ReactionButton;
import ir.nasim.story.ui.viewfragment.views.a;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20135rX6 extends AbstractC16640ld0 {
    private final IW7 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20135rX6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        IW7 iw7A = IW7.a(view);
        AbstractC13042fc3.h(iw7A, "bind(...)");
        this.v = iw7A;
        iw7A.b.B(22.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(C20744sX6 c20744sX6, final C20135rX6 c20135rX6, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c20744sX6, "$item");
        AbstractC13042fc3.i(c20135rX6, "this$0");
        AbstractC5969Lp4.d().k0().k(c20744sX6.c()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qX6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C20135rX6.L0(this.a, (C21231tK7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C20135rX6 c20135rX6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c20135rX6, "this$0");
        AvatarViewGlide avatarViewGlide = c20135rX6.v.b;
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
        c20135rX6.v.d.setText((CharSequence) c21231tK7.r().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(UA2 ua2, C20744sX6 c20744sX6, View view) {
        AbstractC13042fc3.i(ua2, "$itemClick");
        AbstractC13042fc3.i(c20744sX6, "$item");
        ua2.invoke(Integer.valueOf(c20744sX6.c()));
    }

    public final void H0(final C20744sX6 c20744sX6, final UA2 ua2) {
        AbstractC13042fc3.i(c20744sX6, "item");
        AbstractC13042fc3.i(ua2, "itemClick");
        C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(c20744sX6.c());
        if (c3512Be1K0 != null) {
            this.v.b.o(c3512Be1K0);
            this.v.d.setText(c3512Be1K0.getName());
        } else {
            AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(c20744sX6.c()))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.oX6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C20135rX6.J0(c20744sX6, this, (C14505i18) obj);
                }
            });
        }
        String strJ = C14593iA1.j(C0(), AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT * c20744sX6.b(), false, 4, null);
        if (!AbstractC13042fc3.d(strJ, this.a.getContext().getString(AbstractC12217eE5.story_date_now))) {
            strJ = strJ + this.a.getContext().getString(AbstractC12217eE5.story_date_ago);
        }
        if (JF5.g()) {
            strJ = XY6.e(strJ);
        }
        this.v.f.setText(strJ);
        ReactionButton reactionButton = this.v.c;
        AbstractC11710dT6 abstractC11710dT6A = c20744sX6.a();
        int i = 8;
        if (AbstractC13042fc3.d(abstractC11710dT6A, AbstractC11710dT6.a.a)) {
            reactionButton.setState(new a.c(false, 1, null));
        } else if (abstractC11710dT6A instanceof AbstractC11710dT6.b) {
            reactionButton.setState(AbstractC19455qN7.e(((AbstractC11710dT6.b) c20744sX6.a()).a()) ? new a.C1549a(false, 1, null) : new a.b(((AbstractC11710dT6.b) c20744sX6.a()).a(), false, 2, null));
            i = 0;
        } else {
            if (!AbstractC13042fc3.d(abstractC11710dT6A, AbstractC11710dT6.c.a)) {
                throw new NoWhenBranchMatchedException();
            }
            reactionButton.setState(new a.c(false, 1, null));
        }
        reactionButton.setVisibility(i);
        this.v.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pX6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20135rX6.M0(ua2, c20744sX6, view);
            }
        });
    }

    public final void a() {
        this.v.b.D();
    }
}
