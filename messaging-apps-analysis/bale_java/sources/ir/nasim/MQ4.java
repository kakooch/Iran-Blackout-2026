package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.features.pfm.tags.PFMTag;
import ir.nasim.features.pfm.tags.PFMTransactionsInfoLayout;
import java.util.Map;

/* loaded from: classes6.dex */
public final class MQ4 extends KQ4 {
    private final View A;
    private final TextView B;
    private final LinearLayout D;
    private final ImageView v;
    private final TextView w;
    private final View x;
    private final TextView y;
    private final MaterialCardView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MQ4(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.v = (ImageView) view.findViewById(BC5.tag_image);
        this.w = (TextView) view.findViewById(BC5.tag_title);
        View viewFindViewById = view.findViewById(BC5.inner_container);
        this.x = viewFindViewById;
        this.y = (TextView) view.findViewById(BC5.tag_amount);
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(BC5.tag_card_view);
        this.z = materialCardView;
        this.A = view.findViewById(BC5.divider);
        this.B = (TextView) view.findViewById(BC5.no_sub_tag_alert);
        this.D = (LinearLayout) view.findViewById(BC5.linearContainer);
        viewFindViewById.setBackgroundColor(C5495Jo7.a.X());
        materialCardView.setCardElevation(C22078ud6.a(1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C9663aL5 c9663aL5, MQ4 mq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(c9663aL5, "$expanded");
        AbstractC13042fc3.i(mq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$tag");
        if (c9663aL5.a) {
            Map mapD0 = mq4.D0();
            if (mapD0 == null || mapD0.isEmpty()) {
                mq4.B.setVisibility(8);
            } else {
                mq4.D.setVisibility(8);
            }
            mq4.A.setVisibility(4);
        } else {
            Map mapD02 = mq4.D0();
            if (mapD02 == null || mapD02.isEmpty()) {
                mq4.B.setVisibility(0);
            } else {
                mq4.D.setVisibility(0);
            }
            mq4.A.setVisibility(0);
            ir.nasim.features.pfm.h.S0.a(pFMTag.getTransactionType());
        }
        c9663aL5.a = !c9663aL5.a;
    }

    @Override // ir.nasim.KQ4
    public void C0(final PFMTag pFMTag, boolean z, Long l) {
        long jLongValue;
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
        Context context = this.a.getContext();
        this.D.removeAllViews();
        this.D.setVisibility(8);
        this.B.setVisibility(8);
        this.B.setTypeface(C6011Lu2.k());
        final C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = z;
        Map mapD0 = D0();
        if (mapD0 != null) {
            jLongValue = 0;
            for (Map.Entry entry : mapD0.entrySet()) {
                jLongValue += ((Number) entry.getValue()).longValue();
                LinearLayout linearLayout = this.D;
                AbstractC13042fc3.f(context);
                linearLayout.addView(new PFMTransactionsInfoLayout(context, ((PFMTag) entry.getKey()).getLabel(), ((Number) entry.getValue()).longValue()));
            }
        } else {
            jLongValue = 0;
        }
        AbstractC13042fc3.f(l);
        if (l.longValue() - jLongValue != 0) {
            LinearLayout linearLayout2 = this.D;
            AbstractC13042fc3.f(context);
            String string = context.getString(AbstractC12217eE5.without_sub_tag);
            AbstractC13042fc3.h(string, "getString(...)");
            linearLayout2.addView(new PFMTransactionsInfoLayout(context, string, l.longValue() - jLongValue));
        }
        if (pFMTag.getId() == Long.MAX_VALUE) {
            this.B.setText(context.getString(AbstractC12217eE5.without_tag_hint));
            this.B.setTextColor(C5495Jo7.a.K0());
        }
        this.D.setVisibility(8);
        if (c9663aL5.a) {
            Map mapD02 = D0();
            if (mapD02 == null || mapD02.isEmpty()) {
                this.B.setVisibility(0);
            } else {
                this.D.setVisibility(0);
            }
            this.A.setVisibility(0);
        }
        this.x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MQ4.H0(c9663aL5, this, pFMTag, view);
            }
        });
        if (pFMTag.getIconId() != 0) {
            this.v.setImageDrawable(AbstractC4043Dl1.f(context, pFMTag.getIconId()));
        } else {
            this.v.setImageDrawable(AbstractC4043Dl1.f(context, KB5.pfm_default_tag));
        }
        if (pFMTag.getUserId() == 0) {
            this.v.setColorFilter(C5495Jo7.a.B2());
        } else {
            this.v.setColorFilter(pFMTag.getColor());
        }
        this.w.setText(pFMTag.getLabel());
        this.w.setTypeface(C6011Lu2.k());
        TextView textView = this.w;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g0());
        this.a.setEnabled(false);
        TextView textView2 = this.y;
        AbstractC13042fc3.h(textView2, "tagAmountTv");
        textView2.setVisibility(0);
        this.y.setTypeface(C6011Lu2.i());
        this.y.setTextColor(c5495Jo7.g1());
        this.y.setText(context.getString(AbstractC12217eE5.bank_rial_amount, XY6.e(GY6.g(l.toString()))));
    }
}
