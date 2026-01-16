package ir.nasim.features.bank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C15581jp3;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.UA2;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.AmountAbolContentView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u001a\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lir/nasim/features/bank/AmountAbolContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "e", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "Lkotlin/Function1;", "", "Ljava/lang/Void;", "finishCallback", "i", "(Lir/nasim/UA2;)Lir/nasim/features/bank/AmountAbolContentView;", "", "title", "setTitle", "(Ljava/lang/String;)V", "a", "Lir/nasim/i0;", "b", "Lir/nasim/UA2;", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AmountAbolContentView extends RelativeLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private UA2 finishCallback;

    /* renamed from: c, reason: from kotlin metadata */
    private TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountAbolContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        e(context);
    }

    private final void e(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(AbstractC12208eD5.sdk_amount_abol, this);
        setBackgroundColor(C5495Jo7.a.j0());
        C15581jp3 c15581jp3 = new C15581jp3();
        TextView textView = (TextView) findViewById(BC5.bankAbolTitle);
        this.title = textView;
        if (textView == null) {
            AbstractC13042fc3.y("title");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        TextView textView2 = (TextView) findViewById(BC5.bankAbolClose);
        textView2.setTypeface(C6011Lu2.k());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmountAbolContentView.g(this.a, view);
            }
        });
        View viewFindViewById = findViewById(BC5.bankAbolMoneyAmountView);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        final MoneyAmountView moneyAmountView = (MoneyAmountView) viewFindViewById;
        moneyAmountView.setImeOptions(6);
        View viewFindViewById2 = findViewById(BC5.ok_button);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        BaleButton baleButton = (BaleButton) viewFindViewById2;
        baleButton.setTypeface(C6011Lu2.i());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmountAbolContentView.h(moneyAmountView, this, view);
            }
        });
        C23381wp3.e(c15581jp3, moneyAmountView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AmountAbolContentView amountAbolContentView, View view) {
        AbstractC13042fc3.i(amountAbolContentView, "this$0");
        C14486i0 c14486i0 = amountAbolContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MoneyAmountView moneyAmountView, AmountAbolContentView amountAbolContentView, View view) {
        AbstractC13042fc3.i(moneyAmountView, "$amountView");
        AbstractC13042fc3.i(amountAbolContentView, "this$0");
        String amount = moneyAmountView.getAmount();
        if (amount.length() == 0 || Long.parseLong(amount) < 10000) {
            moneyAmountView.k0();
            return;
        }
        C14486i0 c14486i0 = amountAbolContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
        UA2 ua2 = amountAbolContentView.finishCallback;
        if (ua2 != null) {
        }
    }

    public final AmountAbolContentView i(UA2 finishCallback) {
        AbstractC13042fc3.i(finishCallback, "finishCallback");
        this.finishCallback = finishCallback;
        return this;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    public final void setTitle(String title) {
        AbstractC13042fc3.i(title, "title");
        TextView textView = this.title;
        if (textView == null) {
            AbstractC13042fc3.y("title");
            textView = null;
        }
        textView.setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountAbolContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountAbolContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        e(context);
    }
}
