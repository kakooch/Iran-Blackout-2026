package ir.nasim.features.bank;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC24223yF4;
import ir.nasim.BC5;
import ir.nasim.C19406qI3;
import ir.nasim.C20644sM5;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.XY6;
import ir.nasim.features.bank.BankiMoneyAmountView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\r2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0014J\u000f\u0010.\u001a\u00020\rH\u0016¢\u0006\u0004\b.\u0010\u0014R\u0014\u00101\u001a\u00020&8\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lir/nasim/features/bank/BankiMoneyAmountView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "q0", "", "s", "x0", "(Ljava/lang/CharSequence;)V", "n0", "()V", "o0", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "getAmount", "()J", "maxAmount", "setMaxAmount", "(J)V", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "", "requestFocus", "(ILandroid/graphics/Rect;)Z", "", "amount", "setFixedAmount", "(Ljava/lang/String;)V", "setVariableAmount", "t0", "()Z", "p0", "w0", "y", "Ljava/lang/String;", "TAG", "Landroid/widget/EditText;", "z", "Landroid/widget/EditText;", "moneyAmountEditText", "Landroid/widget/TextView;", "A", "Landroid/widget/TextView;", "rialsTextView", "B", "persianAmount", "D", "J", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BankiMoneyAmountView extends ConstraintLayout {

    /* renamed from: A, reason: from kotlin metadata */
    private TextView rialsTextView;

    /* renamed from: B, reason: from kotlin metadata */
    private TextView persianAmount;

    /* renamed from: D, reason: from kotlin metadata */
    private long maxAmount;

    /* renamed from: y, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: z, reason: from kotlin metadata */
    private EditText moneyAmountEditText;

    public static final class a implements TextWatcher {
        final /* synthetic */ Context b;

        a(Context context) {
            this.b = context;
        }

        private final String a(Editable editable) {
            String string = editable.toString();
            if (AbstractC20153rZ6.S(string, "0", false, 2, null)) {
                string = new C20644sM5("^0*").l(string, "");
            }
            return XY6.e(XY6.b(new C20644sM5(",").k(string, ""), ",".charAt(0)));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws NumberFormatException {
            AbstractC13042fc3.i(editable, "s");
            EditText editText = BankiMoneyAmountView.this.moneyAmountEditText;
            if (editText == null) {
                AbstractC13042fc3.y("moneyAmountEditText");
                editText = null;
            }
            editText.removeTextChangedListener(this);
            if (editable.toString().length() > 0) {
                BankiMoneyAmountView.this.x0(editable);
                EditText editText2 = BankiMoneyAmountView.this.moneyAmountEditText;
                if (editText2 == null) {
                    AbstractC13042fc3.y("moneyAmountEditText");
                    editText2 = null;
                }
                editText2.setText(a(editable));
                EditText editText3 = BankiMoneyAmountView.this.moneyAmountEditText;
                if (editText3 == null) {
                    AbstractC13042fc3.y("moneyAmountEditText");
                    editText3 = null;
                }
                EditText editText4 = BankiMoneyAmountView.this.moneyAmountEditText;
                if (editText4 == null) {
                    AbstractC13042fc3.y("moneyAmountEditText");
                    editText4 = null;
                }
                Editable text = editText4.getText();
                editText3.setSelection(text != null ? text.length() : 0);
                BankiMoneyAmountView.this.p0();
            }
            EditText editText5 = BankiMoneyAmountView.this.moneyAmountEditText;
            if (editText5 == null) {
                AbstractC13042fc3.y("moneyAmountEditText");
                editText5 = null;
            }
            editText5.addTextChangedListener(this);
            if (BankiMoneyAmountView.this.getAmount() <= BankiMoneyAmountView.this.maxAmount || BankiMoneyAmountView.this.maxAmount < 0) {
                return;
            }
            BankiMoneyAmountView.this.w0();
            TextView textView = BankiMoneyAmountView.this.persianAmount;
            if (textView == null) {
                AbstractC13042fc3.y("persianAmount");
                textView = null;
            }
            textView.setText(this.b.getString(AbstractC12217eE5.amount_view_max_amount_reached, XY6.e(XY6.c(String.valueOf(BankiMoneyAmountView.this.maxAmount), (char) 0, 2, null))));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            if (AbstractC20762sZ6.n0(charSequence)) {
                BankiMoneyAmountView.this.n0();
            } else {
                if (charSequence.length() != 1 || i3 == 0) {
                    return;
                }
                BankiMoneyAmountView.this.o0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankiMoneyAmountView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.TAG = "MoneyAmountView";
        this.maxAmount = -1L;
        q0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setHint(AbstractC12217eE5.empty_amount_rial_text);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setHintTextColor(c5495Jo7.K0());
        editText.setTextColor(c5495Jo7.N0());
        editText.setTextSize(1, 14.0f);
        editText.setTypeface(C6011Lu2.i());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView2 = null;
        }
        textView2.setText("");
        TextView textView3 = this.persianAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("persianAmount");
        } else {
            textView = textView3;
        }
        textView.setText(AbstractC12217eE5.amount_hint_enter_amount);
        textView.setTextColor(c5495Jo7.K0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setTypeface(C6011Lu2.k());
        editText.setTextSize(1, 19.0f);
        editText.setHint("");
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setTextColor(c5495Jo7.g0());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView2 = null;
        }
        textView2.setText(AbstractC12217eE5.amount_rial);
        textView2.setTextColor(c5495Jo7.g0());
        TextView textView3 = this.persianAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("persianAmount");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c5495Jo7.K0());
    }

    private final void q0(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(AbstractC12208eD5.new_money_entry_layout, this);
        this.moneyAmountEditText = (EditText) findViewById(BC5.bank_transaction_value_edit_text);
        TextView textView = (TextView) findViewById(BC5.rials);
        this.rialsTextView = textView;
        EditText editText = null;
        if (textView == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        TextView textView2 = (TextView) findViewById(BC5.persian_amount);
        this.persianAmount = textView2;
        if (textView2 == null) {
            AbstractC13042fc3.y("persianAmount");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.i());
        EditText editText2 = this.moneyAmountEditText;
        if (editText2 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText2 = null;
        }
        editText2.setRawInputType(2);
        EditText editText3 = this.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText3 = null;
        }
        editText3.setTypeface(C6011Lu2.i());
        EditText editText4 = this.moneyAmountEditText;
        if (editText4 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText4 = null;
        }
        editText4.setMaxLines(1);
        EditText editText5 = this.moneyAmountEditText;
        if (editText5 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText5 = null;
        }
        editText5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.d70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankiMoneyAmountView.r0(this.a, view);
            }
        });
        EditText editText6 = this.moneyAmountEditText;
        if (editText6 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText = editText6;
        }
        editText.addTextChangedListener(new a(context));
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.e70
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BankiMoneyAmountView.s0(this.a, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(BankiMoneyAmountView bankiMoneyAmountView, View view) {
        AbstractC13042fc3.i(bankiMoneyAmountView, "this$0");
        EditText editText = bankiMoneyAmountView.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        EditText editText3 = bankiMoneyAmountView.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText2 = editText3;
        }
        editText2.setSelection(text.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BankiMoneyAmountView bankiMoneyAmountView, View view, boolean z) {
        AbstractC13042fc3.i(bankiMoneyAmountView, "this$0");
        if (bankiMoneyAmountView.hasFocus()) {
            EditText editText = bankiMoneyAmountView.moneyAmountEditText;
            if (editText == null) {
                AbstractC13042fc3.y("moneyAmountEditText");
                editText = null;
            }
            editText.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(View.OnClickListener onClickListener, BankiMoneyAmountView bankiMoneyAmountView, View view) {
        AbstractC13042fc3.i(bankiMoneyAmountView, "this$0");
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EditText editText = bankiMoneyAmountView.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.requestFocus();
        EditText editText3 = bankiMoneyAmountView.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText2 = editText3;
        }
        C23381wp3.d(editText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(CharSequence s) throws NumberFormatException {
        TextView textView = null;
        try {
            String strQ = XY6.q(s.toString());
            if (strQ != null && !AbstractC20762sZ6.n0(strQ)) {
                long j = Long.parseLong(strQ);
                long j2 = j / 10;
                if (j2 > 0) {
                    String strA = AbstractC24223yF4.a(j2, true);
                    TextView textView2 = this.persianAmount;
                    if (textView2 == null) {
                        AbstractC13042fc3.y("persianAmount");
                        textView2 = null;
                    }
                    textView2.setText(getContext().getString(AbstractC12217eE5.card_to_card_amount_string_full_text, strA));
                    return;
                }
                if (j > 0) {
                    TextView textView3 = this.persianAmount;
                    if (textView3 == null) {
                        AbstractC13042fc3.y("persianAmount");
                        textView3 = null;
                    }
                    textView3.setText("");
                }
            }
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
            TextView textView4 = this.persianAmount;
            if (textView4 == null) {
                AbstractC13042fc3.y("persianAmount");
            } else {
                textView = textView4;
            }
            textView.setText(AbstractC12217eE5.amount_hint_enter_amount);
        }
    }

    public final long getAmount() {
        EditText editText = this.moneyAmountEditText;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        String string = editText.getText().toString();
        if (AbstractC20762sZ6.n0(string)) {
            string = "0";
        }
        return Long.parseLong(XY6.q(XY6.h(string)));
    }

    public final void p0() {
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setTextColor(c5495Jo7.g0());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView2 = null;
        }
        textView2.setTextColor(c5495Jo7.g0());
        TextView textView3 = this.persianAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("persianAmount");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c5495Jo7.o0());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        EditText editText = this.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        if (editText.getVisibility() == 0) {
            EditText editText3 = this.moneyAmountEditText;
            if (editText3 == null) {
                AbstractC13042fc3.y("moneyAmountEditText");
                editText3 = null;
            }
            if (editText3.isEnabled()) {
                EditText editText4 = this.moneyAmountEditText;
                if (editText4 == null) {
                    AbstractC13042fc3.y("moneyAmountEditText");
                } else {
                    editText2 = editText4;
                }
                return editText2.requestFocus();
            }
        }
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    public final void setFixedAmount(String amount) {
        AbstractC13042fc3.i(amount, "amount");
        EditText editText = this.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setText(amount);
        EditText editText3 = this.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText2 = editText3;
        }
        editText2.setEnabled(false);
    }

    public final void setMaxAmount(long maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener l) {
        super.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.c70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankiMoneyAmountView.v0(l, this, view);
            }
        });
    }

    public final void setVariableAmount(String amount) {
        AbstractC13042fc3.i(amount, "amount");
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setText(amount);
        editText.setTypeface(C6011Lu2.k());
        editText.setTextSize(1, 19.0f);
        editText.setHint("");
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setTextColor(c5495Jo7.g0());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView2 = null;
        }
        textView2.setText(AbstractC12217eE5.amount_rial);
        textView2.setTextColor(c5495Jo7.g0());
        TextView textView3 = this.persianAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("persianAmount");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c5495Jo7.o0());
    }

    public boolean t0() {
        EditText editText = this.moneyAmountEditText;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        AbstractC13042fc3.h(editText.getText(), "getText(...)");
        return !AbstractC20762sZ6.n0(r0);
    }

    public void w0() {
        int iB0 = C5495Jo7.a.B0();
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setTextColor(iB0);
        EditText editText2 = this.moneyAmountEditText;
        if (editText2 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText2 = null;
        }
        editText2.setHintTextColor(iB0);
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
            textView2 = null;
        }
        textView2.setTextColor(iB0);
        TextView textView3 = this.persianAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("persianAmount");
        } else {
            textView = textView3;
        }
        textView.setTextColor(iB0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankiMoneyAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "MoneyAmountView";
        this.maxAmount = -1L;
        q0(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankiMoneyAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "MoneyAmountView";
        this.maxAmount = -1L;
        q0(context);
    }
}
