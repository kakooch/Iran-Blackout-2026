package ir.nasim.features.bank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.a;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20471s40;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.KB5;
import ir.nasim.S64;
import ir.nasim.V50;
import ir.nasim.W50;
import ir.nasim.core.modules.banking.l;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.BankContentView;
import ir.nasim.features.conversation.view.BankCardView;
import ir.nasim.features.conversation.view.TitledBankCardView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB!\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\u0018J\u000f\u0010\"\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010\u0018J\u0017\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'R$\u0010.\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0016R\"\u00106\u001a\u00020/8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010J\u001a\u00020?8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\"\u0010R\u001a\u00020K8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010AR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006a"}, d2 = {"Lir/nasim/features/bank/BankContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/W50;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/S64;", "messageIdentifier", "Lir/nasim/rB7;", "v", "(Lir/nasim/S64;)V", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "l", "()V", "", "Lir/nasim/s40;", "savedCards", "e2", "(Ljava/util/List;)V", "title", "t2", "(I)V", "R4", "M2", "w2", "Lir/nasim/core/modules/banking/l;", "bankCard", "h1", "(Lir/nasim/core/modules/banking/l;)V", "L4", "a", "Lir/nasim/i0;", "getBottomSheet", "()Lir/nasim/i0;", "setBottomSheet", "bottomSheet", "Lir/nasim/V50;", "b", "Lir/nasim/V50;", "getPresenter", "()Lir/nasim/V50;", "setPresenter", "(Lir/nasim/V50;)V", "presenter", "Lir/nasim/features/conversation/view/TitledBankCardView;", "c", "Lir/nasim/features/conversation/view/TitledBankCardView;", "getSourceCardView", "()Lir/nasim/features/conversation/view/TitledBankCardView;", "setSourceCardView", "(Lir/nasim/features/conversation/view/TitledBankCardView;)V", "sourceCardView", "Landroid/view/View;", "d", "Landroid/view/View;", "getShadow", "()Landroid/view/View;", "setShadow", "(Landroid/view/View;)V", "shadow", "e", "getProgressBar", "setProgressBar", "progressBar", "Lir/nasim/designsystem/button/BaleButton;", "f", "Lir/nasim/designsystem/button/BaleButton;", "getOkButton", "()Lir/nasim/designsystem/button/BaleButton;", "setOkButton", "(Lir/nasim/designsystem/button/BaleButton;)V", "okButton", "Landroid/widget/LinearLayout;", "g", "Landroid/widget/LinearLayout;", "savedCardsContainer", "h", "dialogView", "Lcom/google/android/material/bottomsheet/a;", "i", "Lcom/google/android/material/bottomsheet/a;", "savedCardsBottomSheetDialog", "Landroid/view/View$OnClickListener;", "j", "Landroid/view/View$OnClickListener;", "onSavedCardsClickListener", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public abstract class BankContentView extends RelativeLayout implements InterfaceC16866m0, W50 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 bottomSheet;

    /* renamed from: b, reason: from kotlin metadata */
    protected V50 presenter;

    /* renamed from: c, reason: from kotlin metadata */
    protected TitledBankCardView sourceCardView;

    /* renamed from: d, reason: from kotlin metadata */
    protected View shadow;

    /* renamed from: e, reason: from kotlin metadata */
    protected View progressBar;

    /* renamed from: f, reason: from kotlin metadata */
    protected BaleButton okButton;

    /* renamed from: g, reason: from kotlin metadata */
    private LinearLayout savedCardsContainer;

    /* renamed from: h, reason: from kotlin metadata */
    private View dialogView;

    /* renamed from: i, reason: from kotlin metadata */
    private a savedCardsBottomSheetDialog;

    /* renamed from: j, reason: from kotlin metadata */
    private final View.OnClickListener onSavedCardsClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected BankContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.onSavedCardsClickListener = new View.OnClickListener() { // from class: ir.nasim.F50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankContentView.m(this.a, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final BankContentView bankContentView, View view) {
        View viewFindViewById;
        View viewFindViewById2;
        AbstractC13042fc3.i(bankContentView, "this$0");
        a aVar = bankContentView.savedCardsBottomSheetDialog;
        if (aVar != null) {
            AbstractC13042fc3.f(aVar);
            if (aVar.isShowing()) {
                return;
            }
        }
        Context context = bankContentView.getContext();
        bankContentView.savedCardsBottomSheetDialog = new a(context);
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.choose_card_container_abol, (ViewGroup) null);
        bankContentView.dialogView = viewInflate;
        View viewFindViewById3 = viewInflate != null ? viewInflate.findViewById(BC5.abolTitle) : null;
        AbstractC13042fc3.g(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById3).setText(AbstractC12217eE5.bank_use_saved_cards);
        View view2 = bankContentView.dialogView;
        View viewFindViewById4 = view2 != null ? view2.findViewById(BC5.abolCardsContainer) : null;
        AbstractC13042fc3.g(viewFindViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById4;
        bankContentView.savedCardsContainer = linearLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        bankContentView.getPresenter().r();
        View view3 = bankContentView.dialogView;
        if (view3 != null && (viewFindViewById2 = view3.findViewById(BC5.abolClose)) != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.G50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    BankContentView.n(this.a, view4);
                }
            });
        }
        View view4 = bankContentView.dialogView;
        if (view4 == null || (viewFindViewById = view4.findViewById(BC5.abolButtonUseNewCard)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.H50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                BankContentView.o(this.a, view5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(BankContentView bankContentView, View view) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        a aVar = bankContentView.savedCardsBottomSheetDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final BankContentView bankContentView, View view) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        bankContentView.getPresenter().n();
        bankContentView.getSourceCardView().postDelayed(new Runnable() { // from class: ir.nasim.K50
            @Override // java.lang.Runnable
            public final void run() {
                BankContentView.p(this.a);
            }
        }, 200L);
        a aVar = bankContentView.savedCardsBottomSheetDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(BankContentView bankContentView) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        bankContentView.getSourceCardView().requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final BankContentView bankContentView, AbstractC20471s40 abstractC20471s40, View view) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        AbstractC13042fc3.i(abstractC20471s40, "$card");
        bankContentView.getPresenter().k(abstractC20471s40);
        bankContentView.getSourceCardView().postDelayed(new Runnable() { // from class: ir.nasim.M50
            @Override // java.lang.Runnable
            public final void run() {
                BankContentView.s(this.a);
            }
        }, 200L);
        a aVar = bankContentView.savedCardsBottomSheetDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(BankContentView bankContentView) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        bankContentView.getSourceCardView().requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(BankContentView bankContentView, View view) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        bankContentView.onSavedCardsClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(BankContentView bankContentView, View view) {
        AbstractC13042fc3.i(bankContentView, "this$0");
        bankContentView.onSavedCardsClickListener.onClick(view);
    }

    @Override // ir.nasim.W50
    public void L4(l bankCard) {
        AbstractC13042fc3.i(bankCard, "bankCard");
        getSourceCardView().M0().V0(false).T0(bankCard).a1(KB5.more_cards, new View.OnClickListener() { // from class: ir.nasim.J50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankContentView.u(this.a, view);
            }
        }).W0(false);
    }

    @Override // ir.nasim.W50
    public void M2() {
        getSourceCardView().M0().W0(true).V0(true).U0("").a1(KB5.more_cards, this.onSavedCardsClickListener).setOnClickListener(null);
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void R4() {
        getShadow().setVisibility(8);
        getProgressBar().setVisibility(8);
    }

    @Override // ir.nasim.W50
    public void e2(List savedCards) {
        a aVar;
        AbstractC13042fc3.i(savedCards, "savedCards");
        Iterator it = savedCards.iterator();
        while (it.hasNext()) {
            final AbstractC20471s40 abstractC20471s40 = (AbstractC20471s40) it.next();
            BankCardView bankCardView = new BankCardView(getContext());
            AbstractC13042fc3.g(abstractC20471s40, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
            BankCardView bankCardViewT0 = bankCardView.j0((l) abstractC20471s40).s0(getResources().getString(AbstractC12217eE5.bank_card_number), false).m0(false).k0(false).l0(false).o0(false).v0(false).t0(false);
            bankCardViewT0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BankContentView.r(this.a, abstractC20471s40, view);
                }
            });
            LinearLayout linearLayout = this.savedCardsContainer;
            if (linearLayout != null) {
                linearLayout.addView(bankCardViewT0);
            }
        }
        View view = this.dialogView;
        if (view != null && (aVar = this.savedCardsBottomSheetDialog) != null) {
            aVar.setContentView(view);
        }
        a aVar2 = this.savedCardsBottomSheetDialog;
        if (aVar2 != null) {
            aVar2.show();
        }
        View view2 = this.dialogView;
        if (view2 != null) {
            f(view2);
        }
    }

    protected final C14486i0 getBottomSheet() {
        return this.bottomSheet;
    }

    protected final BaleButton getOkButton() {
        BaleButton baleButton = this.okButton;
        if (baleButton != null) {
            return baleButton;
        }
        AbstractC13042fc3.y("okButton");
        return null;
    }

    protected final V50 getPresenter() {
        V50 v50 = this.presenter;
        if (v50 != null) {
            return v50;
        }
        AbstractC13042fc3.y("presenter");
        return null;
    }

    protected final View getProgressBar() {
        View view = this.progressBar;
        if (view != null) {
            return view;
        }
        AbstractC13042fc3.y("progressBar");
        return null;
    }

    protected final View getShadow() {
        View view = this.shadow;
        if (view != null) {
            return view;
        }
        AbstractC13042fc3.y("shadow");
        return null;
    }

    protected final TitledBankCardView getSourceCardView() {
        TitledBankCardView titledBankCardView = this.sourceCardView;
        if (titledBankCardView != null) {
            return titledBankCardView;
        }
        AbstractC13042fc3.y("sourceCardView");
        return null;
    }

    @Override // ir.nasim.W50
    public void h1(l bankCard) {
        AbstractC13042fc3.i(bankCard, "bankCard");
        getSourceCardView().M0().V0(false).T0(bankCard).a1(KB5.more_cards, new View.OnClickListener() { // from class: ir.nasim.I50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankContentView.t(this.a, view);
            }
        }).W0(true);
    }

    protected final void l() {
        C14486i0 c14486i0 = this.bottomSheet;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    public final void setAbolInstance(C14486i0 abol) {
        this.bottomSheet = abol;
    }

    protected final void setBottomSheet(C14486i0 c14486i0) {
        this.bottomSheet = c14486i0;
    }

    protected final void setOkButton(BaleButton baleButton) {
        AbstractC13042fc3.i(baleButton, "<set-?>");
        this.okButton = baleButton;
    }

    protected final void setPresenter(V50 v50) {
        AbstractC13042fc3.i(v50, "<set-?>");
        this.presenter = v50;
    }

    protected final void setProgressBar(View view) {
        AbstractC13042fc3.i(view, "<set-?>");
        this.progressBar = view;
    }

    protected final void setShadow(View view) {
        AbstractC13042fc3.i(view, "<set-?>");
        this.shadow = view;
    }

    protected final void setSourceCardView(TitledBankCardView titledBankCardView) {
        AbstractC13042fc3.i(titledBankCardView, "<set-?>");
        this.sourceCardView = titledBankCardView;
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void t2(int title) {
        getShadow().setVisibility(0);
        getProgressBar().setVisibility(0);
    }

    public final void v(S64 messageIdentifier) {
        AbstractC13042fc3.i(messageIdentifier, "messageIdentifier");
        getPresenter().t(messageIdentifier);
    }

    @Override // ir.nasim.W50
    public void w2() {
        getSourceCardView().M0().W0(true).V0(true).U0("").c1(false).setOnClickListener(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected BankContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.onSavedCardsClickListener = new View.OnClickListener() { // from class: ir.nasim.F50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankContentView.m(this.a, view);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected BankContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.onSavedCardsClickListener = new View.OnClickListener() { // from class: ir.nasim.F50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankContentView.m(this.a, view);
            }
        };
    }
}
