package ir.nasim.features.bank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C14486i0;
import ir.nasim.C17913nm1;
import ir.nasim.C4253Ei4;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.NY;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.features.bank.MoneyTransferPayTypeBottomSheetContentView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lir/nasim/features/bank/MoneyTransferPayTypeBottomSheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "h", "l", "()V", "Lkotlin/Function0;", "cardButtonClickListener", "setCardButtonClickListener", "(Lir/nasim/SA2;)V", "walletButtonClickListener", "setWalletButtonClickListener", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "Lir/nasim/Ei4;", "a", "Lir/nasim/Ei4;", "binding", "b", "Lir/nasim/i0;", "c", "Lir/nasim/SA2;", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MoneyTransferPayTypeBottomSheetContentView extends RelativeLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final C4253Ei4 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: c, reason: from kotlin metadata */
    private SA2 cardButtonClickListener;

    /* renamed from: d, reason: from kotlin metadata */
    private SA2 walletButtonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyTransferPayTypeBottomSheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        C4253Ei4 c4253Ei4C = C4253Ei4.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c4253Ei4C, "inflate(...)");
        this.binding = c4253Ei4C;
        h(context);
    }

    private final void h(final Context context) {
        l();
        this.binding.l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Li4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyTransferPayTypeBottomSheetContentView.i(context, this, view);
            }
        });
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Mi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyTransferPayTypeBottomSheetContentView.k(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final Context context, MoneyTransferPayTypeBottomSheetContentView moneyTransferPayTypeBottomSheetContentView, View view) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(moneyTransferPayTypeBottomSheetContentView, "this$0");
        if (AbstractC5969Lp4.d().s2()) {
            new NY(context).A(AbstractC12217eE5.kifpool_notice_title).h(AbstractC12217eE5.kifpool_notice_desc).F(true).w(AbstractC12217eE5.kifpool_notice_btn_title).v(new View.OnClickListener() { // from class: ir.nasim.Oi4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MoneyTransferPayTypeBottomSheetContentView.j(context, view2);
                }
            }).f(true).a().z();
            return;
        }
        SA2 sa2 = moneyTransferPayTypeBottomSheetContentView.walletButtonClickListener;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Context context, View view) {
        AbstractC13042fc3.i(context, "$context");
        C17913nm1.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MoneyTransferPayTypeBottomSheetContentView moneyTransferPayTypeBottomSheetContentView, View view) {
        AbstractC13042fc3.i(moneyTransferPayTypeBottomSheetContentView, "this$0");
        SA2 sa2 = moneyTransferPayTypeBottomSheetContentView.cardButtonClickListener;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    private final void l() {
        setBackgroundColor(AbstractC4043Dl1.c(getContext(), TA5.c5));
        this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ni4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyTransferPayTypeBottomSheetContentView.m(this.a, view);
            }
        });
        this.binding.k.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MoneyTransferPayTypeBottomSheetContentView moneyTransferPayTypeBottomSheetContentView, View view) {
        AbstractC13042fc3.i(moneyTransferPayTypeBottomSheetContentView, "this$0");
        C14486i0 c14486i0 = moneyTransferPayTypeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    public final void setCardButtonClickListener(SA2 cardButtonClickListener) {
        AbstractC13042fc3.i(cardButtonClickListener, "cardButtonClickListener");
        this.cardButtonClickListener = cardButtonClickListener;
    }

    public final void setWalletButtonClickListener(SA2 walletButtonClickListener) {
        AbstractC13042fc3.i(walletButtonClickListener, "walletButtonClickListener");
        this.walletButtonClickListener = walletButtonClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyTransferPayTypeBottomSheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C4253Ei4 c4253Ei4C = C4253Ei4.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c4253Ei4C, "inflate(...)");
        this.binding = c4253Ei4C;
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyTransferPayTypeBottomSheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C4253Ei4 c4253Ei4C = C4253Ei4.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c4253Ei4C, "inflate(...)");
        this.binding = c4253Ei4C;
        h(context);
    }
}
