package ir.nasim.features.bank;

import android.content.Context;
import android.gov.nist.core.Separators;
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
import ir.nasim.AbstractC24223yF4;
import ir.nasim.BC5;
import ir.nasim.C15581jp3;
import ir.nasim.C19406qI3;
import ir.nasim.C20644sM5;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.XY6;
import ir.nasim.features.bank.MoneyAmountView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lir/nasim/features/bank/MoneyAmountView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "h0", "", "s", "m0", "(Ljava/lang/CharSequence;)V", "", "getAmount", "()Ljava/lang/String;", "action", "setImeOptions", "(I)V", "k0", "()V", "n0", "amount", "setFixedAmount", "(Ljava/lang/String;)V", "setVariableAmount", "y", "Ljava/lang/String;", "TAG", "Landroid/widget/EditText;", "z", "Landroid/widget/EditText;", "moneyAmountEditText", "Landroid/widget/TextView;", "A", "Landroid/widget/TextView;", "rialsTextView", "B", "persianAmount", "Lir/nasim/jp3;", "D", "Lir/nasim/jp3;", "keyboardHelper", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MoneyAmountView extends ConstraintLayout {

    /* renamed from: A, reason: from kotlin metadata */
    private TextView rialsTextView;

    /* renamed from: B, reason: from kotlin metadata */
    private TextView persianAmount;

    /* renamed from: D, reason: from kotlin metadata */
    private C15581jp3 keyboardHelper;

    /* renamed from: y, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: z, reason: from kotlin metadata */
    private EditText moneyAmountEditText;

    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            MoneyAmountView.this.n0();
            if (editable.toString().length() != 0) {
                XY6.q(editable.toString());
                String string = editable.toString();
                EditText editText = null;
                if (AbstractC20153rZ6.S(string, "0", false, 2, null)) {
                    string = new C20644sM5("^0*").l(string, "");
                }
                String strE = XY6.e(XY6.b(new C20644sM5(",").k(string, ""), ",".charAt(0)));
                if (editable.length() > 0) {
                    EditText editText2 = MoneyAmountView.this.moneyAmountEditText;
                    if (editText2 == null) {
                        AbstractC13042fc3.y("moneyAmountEditText");
                        editText2 = null;
                    }
                    editText2.removeTextChangedListener(this);
                    EditText editText3 = MoneyAmountView.this.moneyAmountEditText;
                    if (editText3 == null) {
                        AbstractC13042fc3.y("moneyAmountEditText");
                        editText3 = null;
                    }
                    editText3.setText(strE);
                    EditText editText4 = MoneyAmountView.this.moneyAmountEditText;
                    if (editText4 == null) {
                        AbstractC13042fc3.y("moneyAmountEditText");
                        editText4 = null;
                    }
                    editText4.addTextChangedListener(this);
                    EditText editText5 = MoneyAmountView.this.moneyAmountEditText;
                    if (editText5 == null) {
                        AbstractC13042fc3.y("moneyAmountEditText");
                        editText5 = null;
                    }
                    EditText editText6 = MoneyAmountView.this.moneyAmountEditText;
                    if (editText6 == null) {
                        AbstractC13042fc3.y("moneyAmountEditText");
                    } else {
                        editText = editText6;
                    }
                    Editable text = editText.getText();
                    editText5.setSelection(text != null ? text.length() : 0);
                }
            }
            MoneyAmountView.this.m0(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyAmountView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.TAG = "MoneyAmountView";
        h0(context);
    }

    private final void h0(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(AbstractC12208eD5.money_entry_layout, this);
        this.moneyAmountEditText = (EditText) findViewById(BC5.bank_transaction_value_edit_text);
        this.rialsTextView = (TextView) findViewById(BC5.rials);
        this.persianAmount = (TextView) findViewById(BC5.persian_amount);
        this.keyboardHelper = new C15581jp3();
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setRawInputType(2);
        EditText editText2 = this.moneyAmountEditText;
        if (editText2 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText2 = null;
        }
        editText2.setTypeface(C6011Lu2.i());
        EditText editText3 = this.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText3 = null;
        }
        editText3.setMaxLines(1);
        EditText editText4 = this.moneyAmountEditText;
        if (editText4 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText4 = null;
        }
        editText4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ci4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyAmountView.i0(this.a, view);
            }
        });
        EditText editText5 = this.moneyAmountEditText;
        if (editText5 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText5 = null;
        }
        editText5.addTextChangedListener(new a());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(C5495Jo7.a.t2());
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.di4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyAmountView.j0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(MoneyAmountView moneyAmountView, View view) {
        AbstractC13042fc3.i(moneyAmountView, "this$0");
        EditText editText = moneyAmountView.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        EditText editText3 = moneyAmountView.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText2 = editText3;
        }
        editText2.setSelection(text.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(MoneyAmountView moneyAmountView, View view) {
        AbstractC13042fc3.i(moneyAmountView, "this$0");
        EditText editText = moneyAmountView.moneyAmountEditText;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.requestFocus();
        C15581jp3 c15581jp3 = moneyAmountView.keyboardHelper;
        if (c15581jp3 == null) {
            AbstractC13042fc3.y("keyboardHelper");
            c15581jp3 = null;
        }
        EditText editText3 = moneyAmountView.moneyAmountEditText;
        if (editText3 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
        } else {
            editText2 = editText3;
        }
        c15581jp3.c(editText2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(CharSequence s) {
        TextView textView = null;
        try {
            String strQ = XY6.q(s.toString());
            if (strQ != null && strQ.length() > 0) {
                long j = Long.parseLong(strQ) / 10;
                if (j > 0) {
                    String strA = AbstractC24223yF4.a(j, true);
                    TextView textView2 = this.persianAmount;
                    if (textView2 == null) {
                        AbstractC13042fc3.y("persianAmount");
                        textView2 = null;
                    }
                    textView2.setText(strA + Separators.SP + getContext().getString(AbstractC12217eE5.bank_toman));
                    TextView textView3 = this.persianAmount;
                    if (textView3 == null) {
                        AbstractC13042fc3.y("persianAmount");
                        textView3 = null;
                    }
                    textView3.setVisibility(0);
                    return;
                }
            }
            TextView textView4 = this.persianAmount;
            if (textView4 == null) {
                AbstractC13042fc3.y("persianAmount");
                textView4 = null;
            }
            textView4.setText(AbstractC12217eE5.enter_amount_hint);
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
            TextView textView5 = this.persianAmount;
            if (textView5 == null) {
                AbstractC13042fc3.y("persianAmount");
            } else {
                textView = textView5;
            }
            textView.setText(AbstractC12217eE5.enter_amount_hint);
        }
    }

    public final String getAmount() {
        EditText editText = this.moneyAmountEditText;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        return XY6.q(XY6.h(editText.getText().toString()));
    }

    public final void k0() {
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setHintTextColor(c5495Jo7.B0());
        EditText editText2 = this.moneyAmountEditText;
        if (editText2 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText2 = null;
        }
        editText2.setTextColor(c5495Jo7.B0());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(c5495Jo7.B0());
    }

    public final void n0() {
        EditText editText = this.moneyAmountEditText;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setHintTextColor(c5495Jo7.t2());
        EditText editText2 = this.moneyAmountEditText;
        if (editText2 == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText2 = null;
        }
        editText2.setTextColor(c5495Jo7.t2());
        TextView textView2 = this.rialsTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("rialsTextView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(c5495Jo7.t2());
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

    public final void setImeOptions(int action) {
        EditText editText = this.moneyAmountEditText;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setImeOptions(action);
    }

    public final void setVariableAmount(String amount) {
        AbstractC13042fc3.i(amount, "amount");
        EditText editText = this.moneyAmountEditText;
        if (editText == null) {
            AbstractC13042fc3.y("moneyAmountEditText");
            editText = null;
        }
        editText.setText(amount);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "MoneyAmountView";
        h0(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "MoneyAmountView";
        h0(context);
    }
}
