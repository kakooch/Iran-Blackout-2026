package ir.nasim;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.smiles.widget.StickerView;

/* renamed from: ir.nasim.kt, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16208kt extends IM6 {
    private final C14891if3 l;
    private final ConstraintLayout m;
    private C22007uW1 n;

    /* renamed from: ir.nasim.kt$a */
    public static class a implements InterfaceC22152ul0 {
        private final boolean a;
        private final AbstractC23538x54 b;

        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public final InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_sticker_bubble);
            C14891if3 c14891if3A = C14891if3.a(viewStub.inflate());
            AbstractC13042fc3.h(c14891if3A, "bind(...)");
            return new C16208kt(c14891if3A, this.a, this.b, null);
        }
    }

    public /* synthetic */ C16208kt(C14891if3 c14891if3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c14891if3, z, abstractC23538x54);
    }

    private final Drawable Y() {
        Context context = this.l.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third));
    }

    @Override // ir.nasim.IM6
    public void K(C8967Xz7 c8967Xz7, AbstractC17757nW1.c.AbstractC1416c abstractC1416c) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC1416c, "document");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        C22007uW1 c22007uW1 = new C22007uW1(c14970in2D, abstractC1416c, null, 4, null);
        LottieAnimationView lottieAnimationView = this.l.b;
        AbstractC13042fc3.h(lottieAnimationView, "animationView");
        c22007uW1.I(new C15617jt((AbstractC17757nW1.c.AbstractC1416c.a) abstractC1416c, lottieAnimationView, abstractC1416c.d(), Y()));
        c22007uW1.l();
        this.n = c22007uW1;
    }

    @Override // ir.nasim.IM6, ir.nasim.InterfaceC20284rl0
    /* renamed from: R */
    public ConstraintLayout d() {
        return this.m;
    }

    @Override // ir.nasim.IM6, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        C22007uW1 c22007uW1 = this.n;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        this.n = null;
    }

    @Override // ir.nasim.IM6, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (!(n15 instanceof N15.i)) {
            super.z(n15);
            return;
        }
        C22007uW1 c22007uW1 = this.n;
        if (c22007uW1 != null) {
            c22007uW1.K(((N15.i) n15).b());
        }
    }

    private C16208kt(C14891if3 c14891if3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c14891if3, z, abstractC23538x54);
        this.l = c14891if3;
        ConstraintLayout constraintLayout = c14891if3.e;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.m = constraintLayout;
        StickerView stickerView = c14891if3.g;
        AbstractC13042fc3.h(stickerView, "sticker");
        stickerView.setVisibility(8);
        LottieAnimationView lottieAnimationView = c14891if3.b;
        AbstractC13042fc3.h(lottieAnimationView, "animationView");
        lottieAnimationView.setVisibility(0);
    }
}
