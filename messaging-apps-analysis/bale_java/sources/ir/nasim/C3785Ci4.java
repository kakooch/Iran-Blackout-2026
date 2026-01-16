package ir.nasim;

import ai.bale.proto.BankOuterClass$ResponseGetSadadPSPPaymentToken;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.bank.AmountAbolContentView;
import ir.nasim.features.bank.MelliLoanBottomSheetContentView;
import ir.nasim.features.bank.PaymentListAbolContentView;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.root.RootActivity;

/* renamed from: ir.nasim.Ci4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3785Ci4 implements InterfaceC21596to4 {
    public static final C3785Ci4 a = new C3785Ci4();
    private static final String b = "MONEY_REQUEST_HOLDER";

    /* renamed from: ir.nasim.Ci4$a */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Resources resources;
            int iMin = Math.min(C22078ud6.b(), this.a.getHeight());
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            Object parent = this.a.getParent();
            AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.View");
            ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) layoutParams).f();
            Object parent2 = this.a.getParent();
            AbstractC13042fc3.g(parent2, "null cannot be cast to non-null type android.view.View");
            View view = (View) parent2;
            Context context = this.a.getContext();
            view.setBackgroundColor((context == null || (resources = context.getResources()) == null) ? 0 : resources.getColor(android.R.color.transparent));
            if (behaviorF instanceof BottomSheetBehavior) {
                ((BottomSheetBehavior) behaviorF).F0(iMin);
            }
        }
    }

    private C3785Ci4() {
    }

    private final void A(final Activity activity, J44 j44, C11458d25 c11458d25, long j) {
        if (C4100Dr4.a(activity)) {
            AbstractC5969Lp4.d().f0(j, c11458d25, j44.i(), j44.h(), null).E(new InterfaceC24449ye1() { // from class: ir.nasim.yi4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C3785Ci4.B(activity, (Exception) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.zi4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C3785Ci4.C(activity, (BankOuterClass$ResponseGetSadadPSPPaymentToken) obj);
                }
            });
        } else {
            Toast.makeText(activity, AbstractC12217eE5.bank_second_toast_for_check_network_description, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Activity activity, Exception exc) {
        AbstractC13042fc3.i(activity, "$finalActivity");
        C19406qI3.d(b, exc);
        Toast.makeText(activity, activity.getResources().getString(AbstractC12217eE5.bank_not_supported_puchase_message), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Activity activity, BankOuterClass$ResponseGetSadadPSPPaymentToken bankOuterClass$ResponseGetSadadPSPPaymentToken) {
        AbstractC13042fc3.i(activity, "$finalActivity");
        RootActivity.Companion.i(RootActivity.INSTANCE, null, "action_set_payment_original_token_and_set_payment_end_point", AbstractC23348wm0.b(new XV4("arg_payment_original_token", bankOuterClass$ResponseGetSadadPSPPaymentToken.getToken()), new XV4("arg_payment_end_point", bankOuterClass$ResponseGetSadadPSPPaymentToken.getEndpoint())), 1, null);
        C22055ub3.a.o("https://sadad.shaparak.ir/VPG/Purchase?Token=" + bankOuterClass$ResponseGetSadadPSPPaymentToken.getToken(), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(com.google.android.material.bottomsheet.a aVar, View view) {
        AbstractC13042fc3.i(aVar, "$bottomSheetDialog");
        aVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View view, LayoutInflater layoutInflater, LinearLayout linearLayout, Context context, View view2, C17876ni4 c17876ni4) {
        AbstractC13042fc3.i(linearLayout, "$detailsContainer");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(view2, "$listButtonContainer");
        view.findViewById(BC5.bottom_sheet_progress_bar).setVisibility(8);
        if (c17876ni4.c() == EnumC16694li4.b) {
            C3785Ci4 c3785Ci4 = a;
            AbstractC13042fc3.f(layoutInflater);
            String string = context.getString(AbstractC12217eE5.money_request_detail_total_paid_amount);
            AbstractC13042fc3.h(string, "getString(...)");
            c3785Ci4.l(layoutInflater, linearLayout, string, XY6.c(String.valueOf(c17876ni4.d()), (char) 0, 2, null) + " ریال");
            String string2 = context.getString(AbstractC12217eE5.money_request_detail_pay_count);
            AbstractC13042fc3.h(string2, "getString(...)");
            c3785Ci4.l(layoutInflater, linearLayout, string2, c17876ni4.b() + " بار");
            linearLayout.setMinimumHeight(C22078ud6.a(70.0f));
            linearLayout.invalidate();
        } else if (c17876ni4.c() == EnumC16694li4.c) {
            C3785Ci4 c3785Ci42 = a;
            AbstractC13042fc3.f(layoutInflater);
            String string3 = context.getString(AbstractC12217eE5.money_request_detail_your_paid_amount);
            AbstractC13042fc3.h(string3, "getString(...)");
            c3785Ci42.l(layoutInflater, linearLayout, string3, XY6.c(String.valueOf(c17876ni4.d()), (char) 0, 2, null) + " ریال");
            String string4 = context.getString(AbstractC12217eE5.money_request_detail_your_pay_count);
            AbstractC13042fc3.h(string4, "getString(...)");
            c3785Ci42.l(layoutInflater, linearLayout, string4, c17876ni4.b() + " بار");
            if (c17876ni4.b() > 0) {
                String string5 = context.getString(AbstractC12217eE5.money_request_detail_your_last_pay_date);
                AbstractC13042fc3.h(string5, "getString(...)");
                String string6 = context.getString(AbstractC12217eE5.formatDateAtTime, C14593iA1.h(context, c17876ni4.a(), false, 4, null), C14593iA1.A(c17876ni4.a()));
                AbstractC13042fc3.h(string6, "getString(...)");
                c3785Ci42.l(layoutInflater, linearLayout, string5, string6);
            }
        }
        if (c17876ni4.b() <= 0) {
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Activity activity, com.google.android.material.bottomsheet.a aVar, Context context, J44 j44, C11458d25 c11458d25, View view) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(aVar, "$bottomSheetDialog");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c11458d25, "$peer");
        if (activity instanceof AppCompatActivity) {
            C14486i0 c14486i0A = C14486i0.f.a((FragmentActivity) activity);
            aVar.cancel();
            PaymentListAbolContentView paymentListAbolContentView = new PaymentListAbolContentView(context);
            paymentListAbolContentView.setCurrentMessage(j44);
            paymentListAbolContentView.setCurrentPeer(c11458d25);
            paymentListAbolContentView.j();
            paymentListAbolContentView.setAbolInstance(c14486i0A);
            c14486i0A.o(paymentListAbolContentView);
        }
    }

    private final void H(final Context context) {
        InterfaceC12737f70 interfaceC12737f70A = InterfaceC13373g70.a.a(context);
        String string = context.getString(AbstractC12217eE5.wallet_pay_amount_is_not_suffcient_for_charging);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = context.getString(AbstractC12217eE5.bank_operation_failed);
        AbstractC13042fc3.h(string2, "getString(...)");
        String string3 = context.getString(AbstractC12217eE5.card_statement_understood_button_text);
        AbstractC13042fc3.h(string3, "getString(...)");
        String string4 = context.getString(AbstractC12217eE5.wallet_charging);
        AbstractC13042fc3.h(string4, "getString(...)");
        InterfaceC12737f70.a(interfaceC12737f70A, string, string2, string3, string4, null, new SA2() { // from class: ir.nasim.si4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3785Ci4.I(context);
            }
        }, 0, 0, 208, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void I(Context context) {
        AbstractC13042fc3.i(context, "$context");
        a.k2(context, (FragmentActivity) context);
        return null;
    }

    private final void J(Context context) {
        InterfaceC12737f70 interfaceC12737f70A = InterfaceC13373g70.a.a(context);
        String string = context.getString(AbstractC12217eE5.wallet_pay_is_not_registered);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = context.getString(AbstractC12217eE5.wallet_pay_amount_with_wallet_failed);
        AbstractC13042fc3.h(string2, "getString(...)");
        InterfaceC12737f70.l(interfaceC12737f70A, string, string2, null, 4, null);
    }

    private final void l(LayoutInflater layoutInflater, LinearLayout linearLayout, String str, String str2) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.label_data_pair, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(BC5.label)).setText(str);
        TextView textView = (TextView) viewInflate.findViewById(BC5.title);
        textView.setText(XY6.e(str2));
        textView.setTypeface(C6011Lu2.i());
        textView.setTextDirection(4);
        linearLayout.addView(viewInflate);
    }

    private final void m(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    private final Long n(C18626oy5 c18626oy5) {
        if (c18626oy5.u() instanceof C17944np2) {
            return Long.valueOf(((C17944np2) c18626oy5.u()).c());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Activity activity, J44 j44, C11458d25 c11458d25, C14486i0 c14486i0, long j, int i) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(j44, "$currentMessage");
        AbstractC13042fc3.i(c11458d25, "$peer");
        a.o(activity, j44, c11458d25, false, c14486i0, j, i);
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Activity activity, J44 j44, int i) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(j44, "$currentMessage");
        a.z(activity, j44, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void r(Activity activity, J44 j44, C11458d25 c11458d25, long j) {
        AbstractC13042fc3.i(activity, "$finalActivity");
        AbstractC13042fc3.i(j44, "$currentMessage");
        AbstractC13042fc3.i(c11458d25, "$peer");
        a.A(activity, j44, c11458d25, j);
        return null;
    }

    private final boolean s(J44 j44) {
        if (!(j44.F() instanceof C18626oy5)) {
            return false;
        }
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PurchaseContent");
        return ((C18626oy5) abstractC17457n0F).v() instanceof C14057hH0;
    }

    private final boolean t(C18626oy5 c18626oy5) {
        return c18626oy5.s().containsKey("CHARGE_TYPE");
    }

    private final void u(Activity activity, J44 j44, C11458d25 c11458d25, C18626oy5 c18626oy5) {
        if (activity instanceof AppCompatActivity) {
            C14486i0 c14486i0A = C14486i0.f.a((AppCompatActivity) activity);
            MelliLoanBottomSheetContentView melliLoanBottomSheetContentView = new MelliLoanBottomSheetContentView(activity);
            AbstractC13130fi4 abstractC13130fi4U = c18626oy5.u();
            C17944np2 c17944np2 = abstractC13130fi4U instanceof C17944np2 ? (C17944np2) abstractC13130fi4U : null;
            MelliLoanBottomSheetContentView melliLoanBottomSheetContentViewQ = melliLoanBottomSheetContentView.Q(c17944np2 != null ? Long.valueOf(c17944np2.c()) : null);
            AbstractC4970Hi4 abstractC4970Hi4V = c18626oy5.v();
            AbstractC13042fc3.g(abstractC4970Hi4V, "null cannot be cast to non-null type ir.nasim.core.modules.banking.MelliLoanMoneyRequestReceiver");
            String strA = ((C24678z14) abstractC4970Hi4V).a();
            AbstractC13042fc3.h(strA, "getLoanId(...)");
            MelliLoanBottomSheetContentView melliLoanBottomSheetContentViewR = melliLoanBottomSheetContentViewQ.R(Long.parseLong(strA));
            melliLoanBottomSheetContentViewR.v(new S64(c11458d25, j44.i(), j44.h()));
            melliLoanBottomSheetContentViewR.setAbolInstance(c14486i0A);
            c14486i0A.o(melliLoanBottomSheetContentViewR);
        }
    }

    private final void v(Activity activity, J44 j44, C11458d25 c11458d25) {
        if (activity instanceof AppCompatActivity) {
            AbstractC17457n0 abstractC17457n0F = j44.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PurchaseContent");
            C18626oy5 c18626oy5 = (C18626oy5) abstractC17457n0F;
            if (c18626oy5.v() instanceof C14057hH0) {
                String strA = ((C14057hH0) c18626oy5.v()).a();
                Long lValueOf = c18626oy5.u() instanceof C17944np2 ? Long.valueOf(((C17944np2) c18626oy5.u()).c()) : null;
                CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
                AbstractC13042fc3.f(strA);
                byte[] byteArray = j44.toByteArray();
                AbstractC13042fc3.h(byteArray, "toByteArray(...)");
                companion.l(activity, strA, lValueOf, byteArray, new HistoryMessageData(c11458d25.u(), j44.h(), j44.i()));
            }
        }
    }

    private final void w(final Activity activity, final C14486i0 c14486i0, final J44 j44, final C11458d25 c11458d25, final Context context, final long j, final int i) {
        r3(context, c14486i0, new InterfaceC21596to4.b() { // from class: ir.nasim.Ai4
            @Override // ir.nasim.InterfaceC21596to4.b
            public final void a() {
                C3785Ci4.y(activity, j44, c11458d25, c14486i0, j, i);
            }
        }, new InterfaceC21596to4.b() { // from class: ir.nasim.Bi4
            @Override // ir.nasim.InterfaceC21596to4.b
            public final void a() {
                C3785Ci4.x(j44, c14486i0, j, context, c11458d25);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(J44 j44, C14486i0 c14486i0, long j, Context context, C11458d25 c11458d25) {
        AbstractC13042fc3.i(j44, "$currentMessage");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PurchaseContent");
        C18626oy5 c18626oy5 = (C18626oy5) abstractC17457n0F;
        C3785Ci4 c3785Ci4 = a;
        Long lN = c3785Ci4.n(c18626oy5);
        if (c14486i0 != null) {
            if (lN == null) {
                c3785Ci4.K0(context, c14486i0, c18626oy5.x(), j44, c11458d25);
            } else if (lN.longValue() > j) {
                c3785Ci4.H(context);
            } else {
                c3785Ci4.Q2(context, c14486i0, c18626oy5.x(), lN, j44, c11458d25);
            }
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Activity activity, J44 j44, C11458d25 c11458d25, C14486i0 c14486i0, long j, int i) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(j44, "$currentMessage");
        AbstractC13042fc3.i(c11458d25, "$peer");
        a.o(activity, j44, c11458d25, false, c14486i0, j, i);
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void z(Activity activity, J44 j44, int i) {
        CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
        byte[] byteArray = j44.toByteArray();
        AbstractC13042fc3.h(byteArray, "toByteArray(...)");
        companion.n(activity, byteArray, i);
    }

    public final void D(final Context context, final J44 j44, final C11458d25 c11458d25, final Activity activity) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(activity, "activity");
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context);
        final LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        final View viewInflate = layoutInflaterFrom.inflate(AbstractC12208eD5.money_request_detail_small_bottomsheet_layout, (ViewGroup) null);
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.bank_small_bottomsheet_background);
        if (drawableF != null) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.q());
            viewInflate.setBackground(drawableF);
        }
        final View viewFindViewById = viewInflate.findViewById(BC5.list_button_container);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = viewInflate.findViewById(BC5.list_button_text_view);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        textView.setTypeface(C6011Lu2.i());
        textView.setText(AbstractC12217eE5.bank_payment_list_title);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.a0());
        View viewFindViewById3 = viewInflate.findViewById(BC5.details_title);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        ((TextView) viewFindViewById3).setTypeface(C6011Lu2.i());
        View viewFindViewById4 = viewInflate.findViewById(BC5.details_close);
        AbstractC13042fc3.h(viewFindViewById4, "findViewById(...)");
        ImageButton imageButton = (ImageButton) viewFindViewById4;
        imageButton.setColorFilter(c5495Jo7.a0());
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3785Ci4.E(aVar, view);
            }
        });
        View viewFindViewById5 = viewInflate.findViewById(BC5.details_container);
        AbstractC13042fc3.h(viewFindViewById5, "findViewById(...)");
        final LinearLayout linearLayout = (LinearLayout) viewFindViewById5;
        AbstractC5969Lp4.d().Z(c11458d25, Long.valueOf(j44.i()), Long.valueOf(j44.h())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wi4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C3785Ci4.F(viewInflate, layoutInflaterFrom, linearLayout, context, viewFindViewById, (C17876ni4) obj);
            }
        });
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3785Ci4.G(activity, aVar, context, j44, c11458d25, view);
            }
        });
        aVar.setContentView(viewInflate);
        aVar.show();
        AbstractC13042fc3.f(viewInflate);
        m(viewInflate);
        viewFindViewById.requestFocus();
    }

    public final void o(final Activity activity, final J44 j44, final C11458d25 c11458d25, boolean z, final C14486i0 c14486i0, final long j, final int i) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(j44, "currentMessage");
        AbstractC13042fc3.i(c11458d25, "peer");
        C11461d28 c11461d28Y = C5735Kp4.w().i().Y().Y();
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PurchaseContent");
        C18626oy5 c18626oy5 = (C18626oy5) abstractC17457n0F;
        String str = (String) c11461d28Y.B().b();
        if (s(j44)) {
            v(activity, j44, c11458d25);
            return;
        }
        if ((c18626oy5.x() != null || (c18626oy5.v() instanceof C12104e28)) && z) {
            if (c18626oy5.x() == null || (c18626oy5.v() instanceof C12104e28)) {
                z(activity, j44, i);
                return;
            } else {
                r3(activity, c14486i0, new InterfaceC21596to4.b() { // from class: ir.nasim.ri4
                    @Override // ir.nasim.InterfaceC21596to4.b
                    public final void a() {
                        C3785Ci4.p(activity, j44, c11458d25, c14486i0, j, i);
                    }
                }, new InterfaceC21596to4.b() { // from class: ir.nasim.ti4
                    @Override // ir.nasim.InterfaceC21596to4.b
                    public final void a() {
                        C3785Ci4.q(activity, j44, i);
                    }
                });
                return;
            }
        }
        if ((c18626oy5.v() instanceof C12104e28) && z) {
            if (str == null) {
                J(activity);
                return;
            } else {
                K0(activity, c14486i0, c18626oy5.x(), j44, c11458d25);
                return;
            }
        }
        if (c18626oy5.x() != null && z) {
            if (str == null) {
                J(activity);
                return;
            } else {
                w(activity, c14486i0, j44, c11458d25, activity, j, i);
                return;
            }
        }
        if (c18626oy5.v() instanceof C24678z14) {
            u(activity, j44, c11458d25, c18626oy5);
            return;
        }
        if (c18626oy5.u() instanceof C17944np2) {
            A(activity, j44, c11458d25, ((C17944np2) c18626oy5.u()).c());
            return;
        }
        if (c14486i0 != null) {
            AmountAbolContentView amountAbolContentViewI = new AmountAbolContentView((AppCompatActivity) activity).i(new UA2() { // from class: ir.nasim.ui4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C3785Ci4.r(activity, j44, c11458d25, ((Long) obj).longValue());
                }
            });
            if (a.t(c18626oy5)) {
                String string = activity.getString(AbstractC12217eE5.sdk_charge_amount_title);
                AbstractC13042fc3.h(string, "getString(...)");
                amountAbolContentViewI.setTitle(string);
            }
            amountAbolContentViewI.setAbolInstance(c14486i0);
            if (c14486i0.j()) {
                C14486i0.i(c14486i0, amountAbolContentViewI, false, 2, null);
            } else {
                c14486i0.o(amountAbolContentViewI);
            }
        }
    }
}
