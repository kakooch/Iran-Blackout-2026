package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.HQ3;
import ir.nasim.core.modules.market.model.MarketMenuItem;
import java.util.List;

/* loaded from: classes2.dex */
public final class JQ3 extends AbstractC16640ld0 {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C25055zf3 v;
    private final HQ3.a w;

    public static final class a {
        private a() {
        }

        private final void b(C25055zf3 c25055zf3) {
            c25055zf3.e.setTypeface(C6011Lu2.i());
            c25055zf3.b.setTypeface(C6011Lu2.k());
            TextView textView = c25055zf3.b;
            int iA = C22078ud6.a(8.0f);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setBackground(AbstractC4310Eo7.d(iA, c5495Jo7.i1()));
            if (c5495Jo7.J2()) {
                c25055zf3.c.setElevation(0.0f);
            }
        }

        public final JQ3 a(ViewGroup viewGroup, HQ3.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C25055zf3 c25055zf3C = C25055zf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c25055zf3C, "inflate(...)");
            b(c25055zf3C);
            return new JQ3(c25055zf3C, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ JQ3(C25055zf3 c25055zf3, HQ3.a aVar, ED1 ed1) {
        this(c25055zf3, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(JQ3 jq3, MarketMenuItem marketMenuItem, View view) {
        AbstractC13042fc3.i(jq3, "this$0");
        AbstractC13042fc3.i(marketMenuItem, "$item");
        HQ3.a aVar = jq3.w;
        if (aVar != null) {
            aVar.s0(marketMenuItem);
        }
    }

    public final void E0(final MarketMenuItem marketMenuItem) {
        AbstractC13042fc3.i(marketMenuItem, "item");
        try {
            this.v.e.setText(marketMenuItem.getTitle());
            if (marketMenuItem.getDrawableId() != null) {
                Integer drawableIdResource = marketMenuItem.getDrawableIdResource();
                if (drawableIdResource != null) {
                    this.v.d.setImageDrawable(AbstractC4043Dl1.f(C0(), drawableIdResource.intValue()));
                } else {
                    this.v.d.setImageDrawable(null);
                }
            } else if (marketMenuItem.getDrawableUrl() != null) {
                String drawableUrl = marketMenuItem.getDrawableUrl();
                AbstractC13042fc3.f(drawableUrl);
                if (AbstractC20762sZ6.X(drawableUrl, Separators.SEMICOLON, false, 2, null)) {
                    String drawableUrl2 = marketMenuItem.getDrawableUrl();
                    AbstractC13042fc3.f(drawableUrl2);
                    if (AbstractC20762sZ6.N0(drawableUrl2, new String[]{Separators.SEMICOLON}, false, 0, 6, null).size() < 2) {
                        String drawableUrl3 = marketMenuItem.getDrawableUrl();
                        AbstractC13042fc3.f(drawableUrl3);
                        ImageView imageView = this.v.d;
                        AbstractC13042fc3.h(imageView, ParameterNames.ICON);
                        QI2.p(drawableUrl3, imageView, null, 4, null);
                    } else {
                        String drawableUrl4 = marketMenuItem.getDrawableUrl();
                        AbstractC13042fc3.f(drawableUrl4);
                        List listN0 = AbstractC20762sZ6.N0(drawableUrl4, new String[]{Separators.SEMICOLON}, false, 0, 6, null);
                        if (C5495Jo7.a.J2()) {
                            String str = (String) listN0.get(1);
                            ImageView imageView2 = this.v.d;
                            AbstractC13042fc3.h(imageView2, ParameterNames.ICON);
                            QI2.p(str, imageView2, null, 4, null);
                        } else {
                            String str2 = (String) listN0.get(0);
                            ImageView imageView3 = this.v.d;
                            AbstractC13042fc3.h(imageView3, ParameterNames.ICON);
                            QI2.p(str2, imageView3, null, 4, null);
                        }
                    }
                } else {
                    String drawableUrl32 = marketMenuItem.getDrawableUrl();
                    AbstractC13042fc3.f(drawableUrl32);
                    ImageView imageView4 = this.v.d;
                    AbstractC13042fc3.h(imageView4, ParameterNames.ICON);
                    QI2.p(drawableUrl32, imageView4, null, 4, null);
                }
            }
            this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IQ3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JQ3.F0(this.a, marketMenuItem, view);
                }
            });
            if (marketMenuItem.getBadge() != null) {
                this.v.b.setVisibility(0);
                this.v.b.setText(marketMenuItem.getBadge());
            } else {
                this.v.b.setVisibility(8);
            }
            if (marketMenuItem.isDisable()) {
                CardView cardView = this.v.c;
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                cardView.setCardBackgroundColor(c5495Jo7.j1());
                this.v.e.setTextColor(c5495Jo7.k1());
                return;
            }
            CardView cardView2 = this.v.c;
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            cardView2.setCardBackgroundColor(c5495Jo72.P0());
            this.v.e.setTextColor(c5495Jo72.g1());
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private JQ3(C25055zf3 c25055zf3, HQ3.a aVar) {
        ConstraintLayout root = c25055zf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c25055zf3;
        this.w = aVar;
    }
}
