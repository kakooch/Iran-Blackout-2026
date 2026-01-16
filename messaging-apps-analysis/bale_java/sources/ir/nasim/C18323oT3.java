package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C20096rT3;
import ir.nasim.core.modules.market.model.MarketSlideItem;

/* renamed from: ir.nasim.oT3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18323oT3 extends AbstractC16640ld0 {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C6605Of3 v;
    private final C20096rT3.a w;
    private final UA2 x;
    private final UA2 y;
    private MarketSlideItem z;

    /* renamed from: ir.nasim.oT3$a */
    public static final class a {
        private a() {
        }

        public final C18323oT3 a(ViewGroup viewGroup, C20096rT3.a aVar, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C6605Of3 c6605Of3C = C6605Of3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c6605Of3C, "inflate(...)");
            b(c6605Of3C);
            return new C18323oT3(c6605Of3C, aVar, ua2, ua22, null);
        }

        public final void b(C6605Of3 c6605Of3) {
            AbstractC13042fc3.i(c6605Of3, "binding");
            if (C5495Jo7.a.J2()) {
                c6605Of3.b.setElevation(0.0f);
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C18323oT3(C6605Of3 c6605Of3, C20096rT3.a aVar, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c6605Of3, aVar, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C18323oT3 c18323oT3, MarketSlideItem marketSlideItem, View view) {
        AbstractC13042fc3.i(c18323oT3, "this$0");
        AbstractC13042fc3.i(marketSlideItem, "$item");
        C20096rT3.a aVar = c18323oT3.w;
        if (aVar != null) {
            aVar.U4(marketSlideItem);
        }
    }

    public final void E0(final MarketSlideItem marketSlideItem) {
        AbstractC13042fc3.i(marketSlideItem, "item");
        this.x.invoke(marketSlideItem);
        this.z = marketSlideItem;
        try {
            if (AbstractC13042fc3.d(marketSlideItem.getImageUrl(), "landingGif")) {
                int i = AbstractC19954rD5.gif_market_landing;
                ImageView imageView = this.v.c;
                AbstractC13042fc3.h(imageView, "image");
                QI2.e(i, imageView);
            } else if (AbstractC20153rZ6.C(marketSlideItem.getImageUrl(), ".gif", false, 2, null)) {
                String imageUrl = marketSlideItem.getImageUrl();
                ImageView imageView2 = this.v.c;
                AbstractC13042fc3.h(imageView2, "image");
                QI2.f(imageUrl, imageView2);
            } else {
                String imageUrl2 = marketSlideItem.getImageUrl();
                ImageView imageView3 = this.v.c;
                AbstractC13042fc3.h(imageView3, "image");
                QI2.p(imageUrl2, imageView3, null, 4, null);
            }
            this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nT3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C18323oT3.F0(this.a, marketSlideItem, view);
                }
            });
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void a() {
        MarketSlideItem marketSlideItem = this.z;
        if (marketSlideItem != null) {
            this.y.invoke(marketSlideItem);
        }
        this.v.b.setOnClickListener(null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C18323oT3(C6605Of3 c6605Of3, C20096rT3.a aVar, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c6605Of3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c6605Of3;
        this.w = aVar;
        this.x = ua2;
        this.y = ua22;
    }
}
