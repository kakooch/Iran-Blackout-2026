package ir.nasim;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.features.pfm.tags.PFMTag;

/* loaded from: classes6.dex */
public final class QQ4 extends KQ4 {
    private final View A;
    private final TextView B;
    private final MaterialCardView D;
    private final SQ4 v;
    private final ImageView w;
    private final TextView x;
    private final ImageButton y;
    private final ImageButton z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQ4(View view, SQ4 sq4) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.v = sq4;
        this.w = (ImageView) view.findViewById(BC5.tag_image);
        this.x = (TextView) view.findViewById(BC5.tag_title);
        this.y = (ImageButton) view.findViewById(BC5.tag_remove);
        this.z = (ImageButton) view.findViewById(BC5.tag_edit);
        View viewFindViewById = view.findViewById(BC5.inner_container);
        this.A = viewFindViewById;
        this.B = (TextView) view.findViewById(BC5.tag_amount);
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(BC5.tag_card_view);
        this.D = materialCardView;
        viewFindViewById.setBackgroundColor(C5495Jo7.a.X());
        if (sq4 != null) {
            materialCardView.setCardElevation(C22078ud6.a(1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(QQ4 qq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(qq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        SQ4 sq4 = qq4.v;
        if (sq4 != null) {
            sq4.A1(pFMTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QQ4 qq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(qq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        SQ4 sq4 = qq4.v;
        if (sq4 != null) {
            sq4.h3(pFMTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(QQ4 qq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(qq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        SQ4 sq4 = qq4.v;
        if (sq4 != null) {
            sq4.S3(pFMTag);
        }
    }

    @Override // ir.nasim.KQ4
    public void C0(final PFMTag pFMTag, boolean z, Long l) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQ4.L0(this.a, pFMTag, view);
            }
        });
        if (pFMTag.getIconId() != 0) {
            this.w.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), pFMTag.getIconId()));
        } else {
            this.w.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), KB5.pfm_default_tag));
        }
        if (pFMTag.getUserId() == 0) {
            this.w.setColorFilter(C5495Jo7.a.B2());
        } else {
            this.w.setColorFilter(pFMTag.getColor());
        }
        this.x.setText(pFMTag.getLabel());
        this.x.setTypeface(C6011Lu2.k());
        TextView textView = this.x;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g0());
        if (z) {
            View view = this.a;
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
            MaterialCardView materialCardView = (MaterialCardView) view;
            materialCardView.setStrokeColor(c5495Jo7.a0());
            materialCardView.setStrokeWidth(C22078ud6.a(1.5f));
        } else {
            View view2 = this.a;
            AbstractC13042fc3.g(view2, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
            ((MaterialCardView) view2).setStrokeWidth(C22078ud6.a(0.0f));
        }
        if (pFMTag.h() || l != null) {
            this.y.setVisibility(8);
            this.z.setVisibility(8);
        } else {
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QQ4.M0(this.a, pFMTag, view3);
                }
            });
            this.z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QQ4.N0(this.a, pFMTag, view3);
                }
            });
        }
        if (l == null) {
            TextView textView2 = this.B;
            AbstractC13042fc3.h(textView2, "tagAmountTv");
            textView2.setVisibility(8);
            this.a.setEnabled(true);
            return;
        }
        this.a.setEnabled(false);
        TextView textView3 = this.B;
        AbstractC13042fc3.h(textView3, "tagAmountTv");
        textView3.setVisibility(0);
        this.B.setTypeface(C6011Lu2.i());
        this.B.setTextColor(c5495Jo7.g1());
        this.B.setText(this.a.getContext().getString(AbstractC12217eE5.bank_rial_amount, XY6.e(GY6.g(l.toString()))));
    }
}
