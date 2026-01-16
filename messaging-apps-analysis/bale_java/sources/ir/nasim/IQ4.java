package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.features.pfm.tags.PFMTag;

/* loaded from: classes6.dex */
public final class IQ4 extends KQ4 {
    private final SQ4 v;
    private final TextView w;
    private final ImageButton x;
    private final ImageButton y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IQ4(View view, SQ4 sq4) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.v = sq4;
        this.w = (TextView) view.findViewById(BC5.pfm_sub_tag_title);
        this.x = (ImageButton) view.findViewById(BC5.sub_tag_remove);
        this.y = (ImageButton) view.findViewById(BC5.sub_tag_edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(IQ4 iq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(iq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$tag");
        SQ4 sq4 = iq4.v;
        if (sq4 != null) {
            sq4.A1(pFMTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(IQ4 iq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(iq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$tag");
        SQ4 sq4 = iq4.v;
        if (sq4 != null) {
            sq4.h3(pFMTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(IQ4 iq4, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(iq4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$tag");
        SQ4 sq4 = iq4.v;
        if (sq4 != null) {
            sq4.S3(pFMTag);
        }
    }

    @Override // ir.nasim.KQ4
    public void C0(final PFMTag pFMTag, boolean z, Long l) {
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IQ4.L0(this.a, pFMTag, view);
            }
        });
        this.w.setText(pFMTag.getLabel());
        this.w.setTypeface(C6011Lu2.k());
        if (pFMTag.h() || l != null) {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IQ4.M0(this.a, pFMTag, view);
                }
            });
            this.y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IQ4.N0(this.a, pFMTag, view);
                }
            });
        }
        if (!z) {
            View view = this.a;
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
            ((MaterialCardView) view).setStrokeWidth(C22078ud6.a(0.0f));
        } else {
            View view2 = this.a;
            AbstractC13042fc3.g(view2, "null cannot be cast to non-null type com.google.android.material.card.MaterialCardView");
            MaterialCardView materialCardView = (MaterialCardView) view2;
            materialCardView.setStrokeColor(C5495Jo7.a.a0());
            materialCardView.setStrokeWidth(C22078ud6.a(1.5f));
        }
    }
}
