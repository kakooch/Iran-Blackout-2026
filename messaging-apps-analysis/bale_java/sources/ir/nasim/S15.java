package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes5.dex */
public final class S15 extends AbstractC22092uf0 {
    private TextView A;
    private P15 B;
    private AvatarViewGlide w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S15(View view, final InterfaceC22483vJ4 interfaceC22483vJ4, final InterfaceC22483vJ4 interfaceC22483vJ42) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(interfaceC22483vJ4, "onItemClickedListener");
        AbstractC13042fc3.i(interfaceC22483vJ42, "onItemProfileClickedListener");
        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) view.findViewById(BC5.payer_avatar_view);
        this.w = avatarViewGlide;
        avatarViewGlide.B(10.0f, true);
        TextView textView = (TextView) view.findViewById(BC5.name_text_view);
        this.x = textView;
        textView.setTypeface(C6011Lu2.i());
        View viewFindViewById = view.findViewById(BC5.amount_pair);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById.findViewById(BC5.title);
        textView2.setTextSize(1, 12.0f);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView2.setTextColor(c5495Jo7.n0());
        textView2.setTextDirection(1);
        this.y = textView2;
        TextView textView3 = (TextView) viewFindViewById.findViewById(BC5.label);
        textView3.setTextSize(1, 12.0f);
        textView3.setTextColor(c5495Jo7.n0());
        textView3.setText(textView3.getContext().getString(AbstractC12217eE5.money_request_detail_paid_amount));
        View viewFindViewById2 = view.findViewById(BC5.date_pair);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById2.findViewById(BC5.title);
        textView4.setTextSize(1, 12.0f);
        textView4.setTextColor(c5495Jo7.n0());
        textView4.setTextDirection(1);
        this.z = textView4;
        TextView textView5 = (TextView) viewFindViewById2.findViewById(BC5.label);
        textView5.setTextSize(1, 12.0f);
        textView5.setTextColor(c5495Jo7.n0());
        textView5.setText(textView5.getContext().getString(AbstractC12217eE5.money_request_detail_pay_date));
        View viewFindViewById3 = view.findViewById(BC5.trace_number_pair);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        TextView textView6 = (TextView) viewFindViewById3.findViewById(BC5.title);
        textView6.setTextSize(1, 12.0f);
        textView6.setTextColor(c5495Jo7.n0());
        textView6.setTypeface(C6011Lu2.i());
        this.A = textView6;
        TextView textView7 = (TextView) viewFindViewById3.findViewById(BC5.label);
        textView7.setTextSize(1, 12.0f);
        textView7.setTextColor(c5495Jo7.n0());
        textView7.setTypeface(C6011Lu2.i());
        textView7.setText(textView7.getContext().getString(AbstractC12217eE5.money_request_detail_receipt_trace_number));
        this.w.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                S15.E0(this.a, interfaceC22483vJ42, view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.R15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                S15.F0(this.a, interfaceC22483vJ4, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(S15 s15, InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        AbstractC13042fc3.i(s15, "this$0");
        AbstractC13042fc3.i(interfaceC22483vJ4, "$onItemProfileClickedListener");
        P15 p15 = s15.B;
        if (p15 != null) {
            interfaceC22483vJ4.e(p15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(S15 s15, InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        AbstractC13042fc3.i(s15, "this$0");
        AbstractC13042fc3.i(interfaceC22483vJ4, "$onItemClickedListener");
        P15 p15 = s15.B;
        if (p15 != null) {
            interfaceC22483vJ4.e(p15);
        }
    }

    public final void H0(P15 p15) {
        String str;
        C10410bZ6 c10410bZ6R;
        AbstractC13042fc3.i(p15, "data");
        this.B = p15;
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        Integer numS = p15.s();
        AbstractC13042fc3.h(numS, "getPayerUserId(...)");
        C21231tK7 c21231tK7I0 = c11335cqD.i0(numS.intValue());
        if (c21231tK7I0 != null) {
            AvatarViewGlide.u(this.w, c21231tK7I0, null, 2, null);
        }
        if (p15.z() == EnumC6786Oz.OTHERS) {
            this.x.setVisibility(8);
        } else if (p15.z() == EnumC6786Oz.MINE) {
            TextView textView = this.x;
            C11335cq c11335cqD2 = AbstractC5969Lp4.d();
            Integer numS2 = p15.s();
            AbstractC13042fc3.h(numS2, "getPayerUserId(...)");
            C21231tK7 c21231tK7I02 = c11335cqD2.i0(numS2.intValue());
            if (c21231tK7I02 == null || (c10410bZ6R = c21231tK7I02.r()) == null || (str = (String) c10410bZ6R.b()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        this.y.setText(XY6.e(XY6.c(String.valueOf(p15.q().longValue()), (char) 0, 2, null)) + " ریال");
        Context context = this.z.getContext();
        TextView textView2 = this.z;
        int i = AbstractC12217eE5.formatDateAtTime;
        AbstractC13042fc3.f(context);
        Long lR = p15.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        String strH = C14593iA1.h(context, lR.longValue(), false, 4, null);
        Long lR2 = p15.r();
        AbstractC13042fc3.h(lR2, "getDate(...)");
        textView2.setText(context.getString(i, strH, C14593iA1.A(lR2.longValue())));
        this.A.setText(XY6.e(String.valueOf(p15.y().longValue())));
    }

    public final void a() {
        this.w.D();
        this.B = null;
    }
}
