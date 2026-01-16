package ir.nasim.features.conversation.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC14659iH0;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C13003fY2;
import ir.nasim.C17330mn;
import ir.nasim.C5495Jo7;
import ir.nasim.D50;
import ir.nasim.FJ4;
import ir.nasim.GJ4;
import ir.nasim.HJ4;
import ir.nasim.KB5;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.Y50;
import ir.nasim.core.modules.banking.l;
import ir.nasim.core.modules.banking.m;
import ir.nasim.features.bank.otp.OtpAndPin2View;
import ir.nasim.features.conversation.view.BankCardView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class BankCardView extends RelativeLayout implements D50 {
    private AbstractC20471s40 A;
    private MovementMethod B;
    private KeyListener D;
    private List G;
    private boolean H;
    private OtpAndPin2View J;
    private Y50 a;
    private Y50 b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private TextView i;
    private EditText j;
    private EditText k;
    private EditText l;
    private EditText m;
    private EditText n;
    private int o;
    private ImageView p;
    private View q;
    private View r;
    private View s;
    private View t;
    private ImageButton u;
    private TextView v;
    private CheckBox w;
    private boolean x;
    private boolean y;
    private AbstractC14659iH0 z;
    private boolean z0;

    class a extends AbstractC14659iH0 {
        final /* synthetic */ Context d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EditText editText, Context context) {
            super(editText);
            this.d = context;
        }

        @Override // ir.nasim.AbstractC14659iH0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BankCardView.this.H = true;
            BankCardView.this.z0 = false;
            BankCardView.this.J.u();
            String strQ = XY6.q(editable.toString());
            BankCardView.this.b = AbstractC19902r80.e(strQ.length() >= 6 ? strQ.substring(0, 6) : strQ);
            int iA = C17330mn.a(BankCardView.this.b);
            if (!TitledBankCardView.u0(this.d, BankCardView.this.p, iA)) {
                BankCardView.this.p.setImageResource(iA);
            }
            if (BankCardView.this.b != BankCardView.this.a) {
                BankCardView bankCardView = BankCardView.this;
                bankCardView.a = bankCardView.b;
            }
            boolean zContains = BankCardView.this.G.contains(BankCardView.this.b);
            BankCardView.this.c = false;
            if (zContains && strQ.length() >= 16) {
                BankCardView.this.c = true;
                if (BankCardView.this.j.getSelectionEnd() == 19) {
                    if (BankCardView.this.x && BankCardView.this.m != null) {
                        BankCardView.this.m.requestFocus();
                    } else if (BankCardView.this.y && BankCardView.this.n != null) {
                        BankCardView.this.n.requestFocus();
                    }
                }
            }
            BankCardView.this.e0();
            if (zContains || strQ.length() < 6) {
                BankCardView.this.j.setTextColor(BankCardView.this.o);
            } else {
                BankCardView.this.j.setTextColor(C5495Jo7.a.J0());
                if (strQ.length() > 6) {
                    BankCardView.this.j.removeTextChangedListener(this);
                    if (editable.length() >= 7) {
                        editable.replace(0, editable.length(), editable.subSequence(0, 7));
                    }
                    BankCardView.this.j.setSelection(editable.length());
                    BankCardView.this.j.addTextChangedListener(this);
                }
            }
            super.afterTextChanged(editable);
        }
    }

    class b extends C13003fY2 {
        b(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws NumberFormatException {
            BankCardView.this.d = false;
            try {
                int i = Integer.parseInt(XY6.h(editable.toString()));
                if (i > 0 && i <= 12) {
                    BankCardView.this.d = true;
                    if (editable.length() == 2) {
                        BankCardView.this.l.requestFocus();
                    }
                }
            } catch (NumberFormatException unused) {
            }
            if (BankCardView.this.d || editable.length() != 2) {
                BankCardView.this.k.setTextColor(BankCardView.this.o);
            } else {
                BankCardView.this.k.setTextColor(C5495Jo7.a.J0());
            }
            super.afterTextChanged(editable);
            BankCardView.this.e0();
        }
    }

    class c extends C13003fY2 {
        c(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws NumberFormatException {
            BankCardView.this.e = false;
            if (editable.length() == 2) {
                try {
                    int i = Integer.parseInt(XY6.h(editable.toString()));
                    if (i >= 0 && i <= 99) {
                        BankCardView.this.e = true;
                        if (BankCardView.this.y && BankCardView.this.n != null) {
                            BankCardView.this.n.requestFocus();
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (BankCardView.this.e || editable.length() != 2) {
                BankCardView.this.l.setTextColor(BankCardView.this.o);
            } else {
                BankCardView.this.l.setTextColor(C5495Jo7.a.J0());
            }
            super.afterTextChanged(editable);
            BankCardView.this.e0();
        }
    }

    class d extends C13003fY2 {
        d(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BankCardView.this.f = false;
            if (editable.length() >= 3 && editable.length() <= 4) {
                BankCardView.this.f = true;
                BankCardView.this.m.setTextColor(BankCardView.this.o);
                if (editable.length() == 4) {
                    if (BankCardView.this.s != null && BankCardView.this.s.getVisibility() == 0 && BankCardView.this.k != null) {
                        BankCardView.this.k.requestFocus();
                    } else if (BankCardView.this.y && BankCardView.this.n != null) {
                        BankCardView.this.n.requestFocus();
                    }
                }
            }
            super.afterTextChanged(editable);
            BankCardView.this.e0();
        }
    }

    class e extends C13003fY2 {
        e(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            BankCardView.this.g = false;
            if (editable.length() >= 5 && editable.length() <= 12) {
                BankCardView.this.n.setTextColor(BankCardView.this.o);
                BankCardView.this.g = true;
            }
            super.afterTextChanged(editable);
            BankCardView.this.e0();
        }
    }

    public interface f {
    }

    public BankCardView(Context context) {
        super(context);
        this.A = null;
        this.H = false;
        this.z0 = false;
        setWillNotDraw(false);
        Q(context);
    }

    private void L() {
        if (this.c && this.d && this.e && this.f && this.g) {
            if (this.h) {
                return;
            }
            this.h = true;
        } else if (this.h) {
            this.h = false;
        }
    }

    private void M() {
        if (this.y) {
            setFinalField(this.n);
        } else if (this.x) {
            setFinalField(this.l);
        } else {
            setFinalField(this.j);
        }
    }

    private void O() {
        this.G = new ArrayList();
        for (int i = 1; i < Y50.b.b(); i++) {
            this.G.add(Y50.p(i));
        }
    }

    private void Q(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(AbstractC12208eD5.bank_card_input, this);
        this.h = false;
        this.a = Y50.d;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.x = true;
        this.y = true;
        this.o = C5495Jo7.a.N0();
        O();
        this.i = (TextView) findViewById(BC5.tv_card_number_hint);
        this.j = (EditText) findViewById(BC5.et_card_number);
        this.k = (EditText) findViewById(BC5.et_card_expire_date_month);
        this.l = (EditText) findViewById(BC5.et_card_expire_date_year);
        this.m = (EditText) findViewById(BC5.et_card_cvv2);
        this.n = (EditText) findViewById(BC5.et_card_pin2);
        this.r = findViewById(BC5.more_info_container);
        this.q = findViewById(BC5.card_number_container);
        this.s = findViewById(BC5.expire_month_container);
        this.t = findViewById(BC5.card_pin2_container);
        this.j.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.k.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.l.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.m.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.n.setBackgroundResource(KB5.edittext_normal_background_selector);
        f0();
        this.p = (ImageView) findViewById(BC5.image_bank_logo);
        TextView textView = (TextView) findViewById(BC5.tv_default_card);
        this.v = textView;
        textView.setVisibility(8);
        ImageButton imageButton = (ImageButton) findViewById(BC5.icon_more_options);
        this.u = imageButton;
        imageButton.setVisibility(8);
        ((ImageButton) findViewById(BC5.icon_more_cards)).setVisibility(8);
        ((ImageButton) findViewById(BC5.icon_recent_cards)).setVisibility(8);
        CheckBox checkBox = (CheckBox) findViewById(BC5.check_box);
        this.w = checkBox;
        checkBox.setVisibility(8);
        a aVar = new a(this.j, context);
        this.z = aVar;
        this.j.addTextChangedListener(aVar);
        this.j.setRawInputType(2);
        this.j.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.t50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.S(view, z);
            }
        });
        this.B = this.j.getMovementMethod();
        this.D = this.j.getKeyListener();
        this.k.setRawInputType(2);
        EditText editText = this.k;
        editText.addTextChangedListener(new b(editText));
        this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.u50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.U(view, z);
            }
        });
        this.l.setRawInputType(2);
        EditText editText2 = this.l;
        editText2.addTextChangedListener(new c(editText2));
        this.l.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.v50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.V(view, z);
            }
        });
        this.m.setRawInputType(2);
        this.m.setTransformationMethod(new PasswordTransformationMethod());
        EditText editText3 = this.m;
        editText3.addTextChangedListener(new d(editText3));
        this.m.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.w50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.X(view, z);
            }
        });
        this.n.setTextColor(this.o);
        this.n.setRawInputType(2);
        this.n.setTransformationMethod(PasswordTransformationMethod.getInstance());
        EditText editText4 = this.n;
        editText4.addTextChangedListener(new e(editText4));
        this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.x50
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.Y(view, z);
            }
        });
        OtpAndPin2View otpAndPin2View = (OtpAndPin2View) findViewById(BC5.otp_view);
        this.J = otpAndPin2View;
        otpAndPin2View.setBankCardView(this);
        this.J.setOnCloseCallback(new UA2() { // from class: ir.nasim.y50
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return BankCardView.Z((View) obj);
            }
        });
        this.J.setOnGetPasscodeFromDialogClicked(new UA2() { // from class: ir.nasim.z50
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.a0((View) obj);
            }
        });
        this.J.setOnOTPResponseReceived(new GJ4() { // from class: ir.nasim.A50
            @Override // ir.nasim.GJ4
            public final void a(View view, String str) {
                BankCardView.b0(view, str);
            }
        });
        this.J.setOnOTPClickValidationChecker(new FJ4() { // from class: ir.nasim.B50
            @Override // ir.nasim.FJ4
            public final boolean a() {
                return BankCardView.d0();
            }
        });
        this.J.setOnOtpClickedSrcCardValidatorListener(new HJ4() { // from class: ir.nasim.C50
            @Override // ir.nasim.HJ4
            public final void a() {
                this.a.g0();
            }
        });
        i0();
    }

    private boolean R() {
        return ((l) this.A).e() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view, boolean z) {
        if (!z && !this.c && !this.j.getText().toString().isEmpty()) {
            this.j.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view, boolean z) {
        if (!z && !this.d && !this.k.getText().toString().isEmpty()) {
            this.k.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view, boolean z) {
        if (!z && !this.e && !this.l.getText().toString().isEmpty()) {
            this.l.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view, boolean z) {
        if (!z && !this.f && !this.m.getText().toString().isEmpty()) {
            this.m.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view, boolean z) {
        if (!z && !this.g && !this.n.getText().toString().isEmpty()) {
            this.n.setTextColor(C5495Jo7.a.J0());
        }
        if (!z || getOnFocusChangeListener() == null) {
            return;
        }
        getOnFocusChangeListener().onFocusChange(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void Z(View view) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void a0(View view) {
        this.z0 = true;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(View view, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        L();
    }

    private void f0() {
        EditText editText = this.j;
        if (editText != null) {
            editText.setNextFocusForwardId(BC5.et_card_cvv2);
            this.m.setNextFocusForwardId(BC5.et_card_expire_date_month);
            this.k.setNextFocusForwardId(BC5.et_card_expire_date_year);
            this.l.setNextFocusForwardId(BC5.et_card_pin2);
        }
    }

    private void h0() {
        String strB0 = AbstractC5969Lp4.d().b0();
        if (strB0.isEmpty() || strB0.equals("EMPTY_OTP_MESSAGE")) {
            return;
        }
        this.J.x(strB0);
    }

    private void setFinalField(EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setImeOptions(5);
        editText.setOnEditorActionListener(null);
        EditText editText2 = this.j;
        if (editText2 != null && editText2 != editText && editText2.getVisibility() == 0) {
            this.j.setImeOptions(5);
        }
        EditText editText3 = this.m;
        if (editText3 != null && editText3 != editText && editText3.getVisibility() == 0) {
            this.m.setImeOptions(5);
        }
        EditText editText4 = this.k;
        if (editText4 != null && editText4 != editText && editText4.getVisibility() == 0) {
            this.k.setImeOptions(5);
        }
        EditText editText5 = this.l;
        if (editText5 != null && editText5 != editText && editText5.getVisibility() == 0) {
            this.l.setImeOptions(5);
        }
        EditText editText6 = this.n;
        if (editText6 == null || editText6 == editText || editText6.getVisibility() != 0) {
            return;
        }
        this.n.setImeOptions(5);
    }

    public void N() {
        this.J.n();
    }

    public boolean equals(Object obj) {
        return obj instanceof String ? obj.equals(getCardNumber()) : obj instanceof l ? obj.equals(this.A) : super.equals(obj);
    }

    public void g0() {
        AbstractC7426Rr.T(this.q, 4.0f, 3);
        EditText editText = this.j;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setTextColor(c5495Jo7.J0());
        this.j.setHintTextColor(c5495Jo7.J0());
        this.i.setTextColor(c5495Jo7.J0());
    }

    @Override // ir.nasim.D50
    public AbstractC20471s40 getBankCard() {
        if (this.H || this.A == null) {
            this.A = l.a(getCardNumber());
            this.H = false;
        }
        if (this.z0 && !(this.A instanceof m) && !R()) {
            this.A = l.b(getCardNumber(), this.z0);
        }
        return this.A;
    }

    public String getCardNumber() {
        EditText editText = this.j;
        return editText != null ? XY6.q(editText.getText().toString().trim()) : "";
    }

    public void i0() {
        this.J.z();
        h0();
    }

    public BankCardView j0(l lVar) {
        this.A = lVar;
        Y50 y50D = Y50.d;
        if (lVar != null) {
            this.j.removeTextChangedListener(this.z);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("XXXX XXXX XXXX ");
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.85f), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) XY6.e(lVar.h()));
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.9f), 0, spannableStringBuilder.length(), 33);
            this.j.setText(spannableStringBuilder);
            this.j.addTextChangedListener(this.z);
            y50D = lVar.d();
            this.p.setImageResource(C17330mn.a(y50D));
        }
        this.c = true;
        if (!this.G.contains(y50D)) {
            this.j.setTextColor(C5495Jo7.a.J0());
            this.c = false;
        }
        L();
        this.H = false;
        return this;
    }

    public BankCardView k0(boolean z) {
        CheckBox checkBox = this.w;
        if (checkBox != null) {
            checkBox.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    public BankCardView l0(boolean z) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    public BankCardView m0(boolean z) {
        EditText editText = this.j;
        if (editText != null) {
            editText.setEnabled(z);
            this.j.setFocusableInTouchMode(z);
            this.j.setFocusable(z);
            this.j.setClickable(z);
            this.j.setMovementMethod(z ? this.B : null);
            this.j.setKeyListener(z ? this.D : null);
            if (z) {
                this.j.setRawInputType(2);
            }
            setClickable(!z);
        }
        return this;
    }

    public BankCardView o0(boolean z) {
        if (!z) {
            this.f = true;
            this.d = true;
            this.e = true;
        }
        if (this.x == z) {
            return this;
        }
        this.x = z;
        if (z) {
            View view = this.r;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.r;
            if (view2 != null) {
                view2.setVisibility(8);
                this.f = true;
                this.d = true;
                this.e = true;
                L();
            }
        }
        M();
        return this;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        EditText editText = this.j;
        if (editText != null && editText.getVisibility() == 0 && this.j.isEnabled()) {
            return this.j.requestFocus();
        }
        View view = this.r;
        if (view == null || view.getVisibility() != 0) {
            EditText editText2 = this.n;
            if (editText2 != null && editText2.getVisibility() == 0) {
                return this.n.requestFocus();
            }
        } else {
            EditText editText3 = this.m;
            if (editText3 != null && editText3.getVisibility() == 0) {
                return this.m.requestFocus();
            }
            EditText editText4 = this.k;
            if (editText4 != null && editText4.getVisibility() == 0) {
                return this.k.requestFocus();
            }
            EditText editText5 = this.l;
            if (editText5 != null && editText5.getVisibility() == 0) {
                return this.l.requestFocus();
            }
        }
        return super.requestFocus(i, rect);
    }

    public BankCardView s0(String str, boolean z) {
        if (this.i != null) {
            if (!z || str == null || str.isEmpty()) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(str);
            }
        }
        EditText editText = this.j;
        if (editText != null && str != null) {
            editText.setHint(str);
        }
        return this;
    }

    public void setValidationChangeListener(f fVar) {
    }

    public BankCardView t0(boolean z) {
        return u0(z, null);
    }

    public BankCardView u0(boolean z, View.OnClickListener onClickListener) {
        ImageButton imageButton = this.u;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
            if (z) {
                this.u.setOnClickListener(onClickListener);
            }
        }
        return this;
    }

    public BankCardView v0(boolean z) {
        if (!z) {
            this.g = true;
        }
        if (this.y == z) {
            return this;
        }
        this.y = z;
        if (z) {
            View view = this.t;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.t;
            if (view2 != null) {
                view2.setVisibility(8);
                this.g = true;
                L();
            }
        }
        if (z) {
            i0();
        } else {
            N();
        }
        M();
        return this;
    }

    public BankCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = null;
        this.H = false;
        this.z0 = false;
        setWillNotDraw(false);
        Q(context);
    }

    public BankCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A = null;
        this.H = false;
        this.z0 = false;
        setWillNotDraw(false);
        Q(context);
    }
}
