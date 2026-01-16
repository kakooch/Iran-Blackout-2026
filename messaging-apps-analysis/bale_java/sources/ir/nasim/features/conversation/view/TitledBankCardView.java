package ir.nasim.features.conversation.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC14659iH0;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C13003fY2;
import ir.nasim.C17330mn;
import ir.nasim.C19406qI3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
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
import ir.nasim.features.conversation.view.TitledBankCardView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TitledBankCardView extends RelativeLayout implements D50 {
    private boolean A;
    private boolean A0;
    private AbstractC14659iH0 B;
    private OtpAndPin2View B0;
    private boolean C0;
    private AbstractC20471s40 D;
    private MovementMethod G;
    private KeyListener H;
    private List J;
    private f a;
    private Y50 b;
    private Y50 c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private TextView j;
    private EditText k;
    private EditText l;
    private TextInputLayout m;
    private EditText n;
    private TextInputLayout o;
    private EditText p;
    private TextInputLayout q;
    private EditText r;
    private int s;
    private ImageView t;
    private View u;
    private View v;
    private ImageButton w;
    private ImageButton x;
    private ImageButton y;
    private boolean z;
    private TextWatcher z0;

    class a extends AbstractC14659iH0 {
        final /* synthetic */ Context d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EditText editText, Context context) {
            super(editText);
            this.d = context;
        }

        @Override // ir.nasim.AbstractC14659iH0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TitledBankCardView.this.A0 = true;
            TitledBankCardView.this.C0 = false;
            TitledBankCardView.this.B0.u();
            TitledBankCardView.this.Z();
            String strQ = XY6.q(editable.toString());
            if (strQ.length() > 0 && TitledBankCardView.this.k.isClickable() && TitledBankCardView.this.k.hasFocus()) {
                TitledBankCardView.this.y.setVisibility(0);
            } else {
                TitledBankCardView.this.y.setVisibility(8);
            }
            TitledBankCardView.this.c = AbstractC19902r80.e(strQ.length() >= 6 ? strQ.substring(0, 6) : strQ);
            int iA = C17330mn.a(TitledBankCardView.this.c);
            if (!TitledBankCardView.u0(this.d, TitledBankCardView.this.t, iA)) {
                TitledBankCardView.this.t.setImageResource(iA);
            }
            if (TitledBankCardView.this.c != TitledBankCardView.this.b) {
                TitledBankCardView titledBankCardView = TitledBankCardView.this;
                titledBankCardView.b = titledBankCardView.c;
                if (TitledBankCardView.this.a != null) {
                    TitledBankCardView.this.a.a(TitledBankCardView.this.c);
                }
            }
            boolean zContains = TitledBankCardView.this.J.contains(TitledBankCardView.this.c);
            TitledBankCardView.this.d = false;
            if (zContains && strQ.length() >= 16) {
                TitledBankCardView.this.d = true;
                if (TitledBankCardView.this.k.getSelectionEnd() == 19) {
                    if (TitledBankCardView.this.z && TitledBankCardView.this.p != null) {
                        TitledBankCardView.this.p.requestFocus();
                    } else if (TitledBankCardView.this.A && TitledBankCardView.this.r != null) {
                        TitledBankCardView.this.r.requestFocus();
                    }
                }
            }
            TitledBankCardView.this.a0();
            if (zContains || strQ.length() < 6) {
                TitledBankCardView.this.k.setTextColor(TitledBankCardView.this.s);
                TitledBankCardView.this.j.setTextColor(C5495Jo7.a.K0());
            } else {
                EditText editText = TitledBankCardView.this.k;
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                editText.setTextColor(c5495Jo7.J0());
                TitledBankCardView.this.j.setTextColor(c5495Jo7.J0());
                if (strQ.length() > 6) {
                    TitledBankCardView.this.k.removeTextChangedListener(this);
                    if (editable.length() >= 7) {
                        editable.replace(0, editable.length(), editable.subSequence(0, 7));
                    }
                    TitledBankCardView.this.k.setSelection(editable.length());
                    TitledBankCardView.this.k.addTextChangedListener(this);
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
        public void afterTextChanged(Editable editable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            TitledBankCardView.this.d0();
            TitledBankCardView.this.e = false;
            try {
                int i = Integer.parseInt(XY6.h(editable.toString()));
                if (i > 0 && i <= 12) {
                    TitledBankCardView.this.e = true;
                    if (editable.length() == 2 && TitledBankCardView.this.n.getVisibility() == 0) {
                        TitledBankCardView.this.n.requestFocus();
                    }
                }
            } catch (NumberFormatException unused) {
            }
            TitledBankCardView.this.a0();
            TitledBankCardView.this.g0();
            super.afterTextChanged(editable);
        }
    }

    class c extends C13003fY2 {
        c(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            TitledBankCardView.this.e0();
            TitledBankCardView.this.f = false;
            if (editable.length() == 2) {
                try {
                    int i = Integer.parseInt(XY6.h(editable.toString()));
                    if (i >= 0 && i <= 99) {
                        TitledBankCardView.this.f = true;
                        if (TitledBankCardView.this.A && TitledBankCardView.this.r != null && TitledBankCardView.this.r.getVisibility() == 0) {
                            TitledBankCardView.this.r.requestFocus();
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            TitledBankCardView.this.a0();
            TitledBankCardView.this.g0();
            TitledBankCardView.this.f0(editable);
            super.afterTextChanged(editable);
            TitledBankCardView.this.n.setSelection(editable.length());
            if (editable.length() == 4) {
                editable.setSpan(new ForegroundColorSpan(C5495Jo7.a.K0()), 0, 2, 33);
            }
        }
    }

    class d extends C13003fY2 {
        d(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            TitledBankCardView.this.b0();
            TitledBankCardView.this.g = false;
            if (editable.length() >= 3 && editable.length() <= 4) {
                TitledBankCardView.this.g = true;
                TitledBankCardView.this.p.setTextColor(TitledBankCardView.this.s);
                if (editable.length() == 4 && TitledBankCardView.this.l != null && TitledBankCardView.this.l.getVisibility() == 0) {
                    TitledBankCardView.this.l.requestFocus();
                }
            }
            TitledBankCardView.this.a0();
            super.afterTextChanged(editable);
        }
    }

    class e extends C13003fY2 {
        e(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            TitledBankCardView.this.L0();
            TitledBankCardView.this.h = false;
            if (editable.length() >= 5 && editable.length() <= 12) {
                TitledBankCardView.this.r.setTextColor(TitledBankCardView.this.s);
                TitledBankCardView.this.h = true;
            }
            TitledBankCardView.this.a0();
            super.afterTextChanged(editable);
        }
    }

    public interface f {
        void a(Y50 y50);
    }

    public TitledBankCardView(Context context) {
        super(context);
        this.D = null;
        this.A0 = false;
        this.C0 = false;
        setWillNotDraw(false);
        k0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean A0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view, boolean z) {
        if (!z && !this.d && !this.k.getText().toString().isEmpty()) {
            this.k.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
        if (!z) {
            this.y.setVisibility(8);
        } else if (this.k.getText().toString().length() <= 0 || !this.k.isClickable()) {
            this.y.setVisibility(8);
        } else {
            this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view, boolean z) {
        if (!z && !this.e && !this.l.getText().toString().isEmpty()) {
            this.l.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        if (this.n.getSelectionStart() <= 2) {
            EditText editText = this.n;
            editText.setSelection(editText.getText().toString().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(View view, boolean z) {
        if (!z && !this.f && !this.n.getText().toString().isEmpty()) {
            this.n.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(View view, boolean z) {
        if (!z && !this.g && !this.p.getText().toString().isEmpty()) {
            this.p.setTextColor(C5495Jo7.a.J0());
        }
        if (getOnFocusChangeListener() != null) {
            getOnFocusChangeListener().onFocusChange(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(View view, boolean z) {
        if (!z && !this.h && !this.r.getText().toString().isEmpty()) {
            this.r.setTextColor(C5495Jo7.a.J0());
        }
        if (!z || getOnFocusChangeListener() == null) {
            return;
        }
        getOnFocusChangeListener().onFocusChange(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void H0(View view) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void J0(View view) {
        this.C0 = true;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        EditText editText = this.k;
        editText.setSelection(editText.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.B0.p();
    }

    private void O0(TextInputLayout textInputLayout, int i) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Field declaredField = textInputLayout.getClass().getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{i});
            declaredField.set(textInputLayout, colorStateList);
            Class<?> cls = textInputLayout.getClass();
            Class cls2 = Boolean.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("updateLabelState", cls2);
            declaredMethod.setAccessible(true);
            Boolean bool = Boolean.TRUE;
            declaredMethod.invoke(textInputLayout, bool);
            Field declaredField2 = textInputLayout.getClass().getDeclaredField("mFocusedTextColor");
            declaredField2.setAccessible(true);
            declaredField2.set(textInputLayout, colorStateList);
            Method declaredMethod2 = textInputLayout.getClass().getDeclaredMethod("updateLabelState", cls2);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(textInputLayout, bool);
        } catch (Exception e2) {
            C19406qI3.d("TitledBankCardView", e2);
        }
    }

    private void Q0() {
        String strB0 = AbstractC5969Lp4.d().b0();
        if (strB0.isEmpty() || strB0.equals("EMPTY_OTP_MESSAGE")) {
            return;
        }
        this.B0.x(strB0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setCardHintColor(c5495Jo7.K0());
        setTitleHintColor(c5495Jo7.K0());
        setCardNumberColor(c5495Jo7.N0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (this.d && this.e && this.f && this.g && this.h) {
            if (this.i) {
                return;
            }
            this.i = true;
        } else if (this.i) {
            this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setCvv2Color(c5495Jo7.N0());
        O0(this.q, c5495Jo7.K0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setMonthColor(c5495Jo7.N0());
        O0(this.m, c5495Jo7.K0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setYearColor(c5495Jo7.N0());
        O0(this.o, c5495Jo7.K0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(Editable editable) {
        this.n.removeTextChangedListener(this.z0);
        if (editable.length() == 2) {
            i0(editable);
        } else if (editable.length() == 3) {
            editable.replace(0, editable.length(), String.valueOf(editable.charAt(2)));
        }
        this.n.setSelection(editable.length());
        this.n.addTextChangedListener(this.z0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        this.n.removeTextChangedListener(this.z0);
        String string = this.l.getText().toString();
        String string2 = this.n.getText().toString();
        if (string.length() == 2 && string2.length() == 4 && this.e && this.f && I0(string2, string)) {
            EditText editText = this.l;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            editText.setTextColor(c5495Jo7.J0());
            this.n.setTextColor(c5495Jo7.J0());
        } else {
            if (this.f || string2.length() != 2) {
                this.n.setTextColor(this.s);
            } else {
                this.n.setTextColor(C5495Jo7.a.J0());
            }
            if (this.e || string.length() != 2) {
                this.l.setTextColor(this.s);
            } else {
                this.l.setTextColor(C5495Jo7.a.J0());
            }
        }
        this.n.addTextChangedListener(this.z0);
    }

    private void h0() {
        if (this.A) {
            setFinalField(this.r);
        } else if (this.z) {
            setFinalField(this.n);
        } else {
            setFinalField(this.k);
        }
    }

    private void i0(Editable editable) {
        if (editable.length() == 2) {
            int iIntValue = Integer.valueOf(editable.toString()).intValue();
            if (iIntValue < 90 || iIntValue > 99) {
                editable.insert(0, "14");
            } else {
                editable.insert(0, "13");
            }
        }
    }

    private void j0() {
        this.J = new ArrayList();
        for (int i = 1; i < Y50.b.b(); i++) {
            this.J.add(Y50.p(i));
        }
    }

    private void k0(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(AbstractC12208eD5.new_bank_card_input, this);
        this.i = false;
        this.b = Y50.d;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.z = true;
        this.A = true;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.s = c5495Jo7.N0();
        j0();
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(BC5.expire_year_text_input_layout);
        this.o = textInputLayout;
        textInputLayout.setTypeface(C6011Lu2.k());
        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(BC5.expire_month_text_input_layout);
        this.m = textInputLayout2;
        textInputLayout2.setTypeface(C6011Lu2.k());
        TextInputLayout textInputLayout3 = (TextInputLayout) findViewById(BC5.cvv2_text_input_layout);
        this.q = textInputLayout3;
        textInputLayout3.setTypeface(C6011Lu2.k());
        this.j = (TextView) findViewById(BC5.tv_card_number_hint);
        EditText editText = (EditText) findViewById(BC5.et_card_number);
        this.k = editText;
        editText.setTypeface(C6011Lu2.k());
        EditText editText2 = (EditText) findViewById(BC5.et_card_expire_date_month);
        this.l = editText2;
        editText2.setTypeface(C6011Lu2.k());
        EditText editText3 = (EditText) findViewById(BC5.et_card_expire_date_year);
        this.n = editText3;
        editText3.setTypeface(C6011Lu2.k());
        EditText editText4 = (EditText) findViewById(BC5.et_card_cvv2);
        this.p = editText4;
        editText4.setTypeface(C6011Lu2.k());
        EditText editText5 = (EditText) findViewById(BC5.et_card_pin2);
        this.r = editText5;
        editText5.setTypeface(C6011Lu2.k());
        this.v = findViewById(BC5.more_info_container);
        this.u = findViewById(BC5.card_number_placeholder);
        this.k.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.l.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.n.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.p.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.r.setBackgroundResource(KB5.edittext_normal_background_selector);
        this.k.setNextFocusForwardId(BC5.et_card_cvv2);
        this.p.setNextFocusForwardId(BC5.et_card_expire_date_month);
        this.l.setNextFocusForwardId(BC5.et_card_expire_date_year);
        this.n.setNextFocusForwardId(BC5.et_card_pin2);
        this.t = (ImageView) findViewById(BC5.image_bank_logo);
        ((TextView) findViewById(BC5.tv_default_card)).setVisibility(8);
        ImageButton imageButton = (ImageButton) findViewById(BC5.first_button);
        this.w = imageButton;
        imageButton.setVisibility(8);
        ImageButton imageButton2 = (ImageButton) findViewById(BC5.second_button);
        this.x = imageButton2;
        imageButton2.setVisibility(8);
        ImageButton imageButton3 = (ImageButton) findViewById(BC5.delete_input_card_number);
        this.y = imageButton3;
        imageButton3.setVisibility(8);
        this.y.setImageResource(KB5.delete_input_card_number);
        this.y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Rq7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w0(view);
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(BC5.check_box);
        checkBox.setVisibility(8);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.Zq7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TitledBankCardView.y0(compoundButton, z);
            }
        });
        this.j.setTextSize(1, 15.0f);
        this.j.setTypeface(C6011Lu2.k());
        this.j.setTextColor(c5495Jo7.K0());
        this.j.setVisibility(8);
        this.k.setRawInputType(2);
        this.k.setTypeface(C6011Lu2.i());
        this.k.setTextSize(1, 16.0f);
        this.k.setHintTextColor(c5495Jo7.K0());
        a aVar = new a(this.k, context);
        this.B = aVar;
        this.k.addTextChangedListener(aVar);
        this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.ar7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.B0(view, z);
            }
        });
        this.G = this.k.getMovementMethod();
        this.H = this.k.getKeyListener();
        b bVar = new b(this.l);
        this.z0 = new c(this.n);
        this.l.setRawInputType(2);
        this.l.addTextChangedListener(bVar);
        this.l.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.br7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.C0(view, z);
            }
        });
        this.n.setRawInputType(2);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cr7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.D0(view);
            }
        });
        this.n.addTextChangedListener(this.z0);
        this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.dr7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.E0(view, z);
            }
        });
        this.p.setRawInputType(2);
        this.p.setTransformationMethod(new PasswordTransformationMethod());
        EditText editText6 = this.p;
        editText6.addTextChangedListener(new d(editText6));
        this.p.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.er7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.F0(view, z);
            }
        });
        this.r.setTextColor(this.s);
        this.r.setRawInputType(2);
        this.r.setTransformationMethod(PasswordTransformationMethod.getInstance());
        EditText editText7 = this.r;
        editText7.addTextChangedListener(new e(editText7));
        this.r.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Sq7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.G0(view, z);
            }
        });
        OtpAndPin2View otpAndPin2View = (OtpAndPin2View) findViewById(BC5.otp_view);
        this.B0 = otpAndPin2View;
        otpAndPin2View.setBankCardView(this);
        this.B0.setOnCloseCallback(new UA2() { // from class: ir.nasim.Tq7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TitledBankCardView.H0((View) obj);
            }
        });
        this.B0.setOnGetPasscodeFromDialogClicked(new UA2() { // from class: ir.nasim.Uq7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.J0((View) obj);
            }
        });
        this.B0.setOnOTPResponseReceived(new GJ4() { // from class: ir.nasim.Wq7
            @Override // ir.nasim.GJ4
            public final void a(View view, String str) {
                TitledBankCardView.z0(view, str);
            }
        });
        this.B0.setOnOTPClickValidationChecker(new FJ4() { // from class: ir.nasim.Xq7
            @Override // ir.nasim.FJ4
            public final boolean a() {
                return TitledBankCardView.A0();
            }
        });
        this.B0.setOnOtpClickedSrcCardValidatorListener(new HJ4() { // from class: ir.nasim.Yq7
            @Override // ir.nasim.HJ4
            public final void a() {
                this.a.P0();
            }
        });
        S0();
    }

    private boolean m0() {
        return ((l) this.D).e() != null;
    }

    private void setFinalField(EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setImeOptions(6);
        editText.setOnEditorActionListener(null);
        EditText editText2 = this.k;
        if (editText2 != null && editText2 != editText && editText2.getVisibility() == 0) {
            this.k.setImeOptions(5);
        }
        EditText editText3 = this.p;
        if (editText3 != null && editText3 != editText && editText3.getVisibility() == 0) {
            this.p.setImeOptions(5);
        }
        EditText editText4 = this.l;
        if (editText4 != null && editText4 != editText && editText4.getVisibility() == 0) {
            this.l.setImeOptions(5);
        }
        EditText editText5 = this.n;
        if (editText5 != null && editText5 != editText && editText5.getVisibility() == 0) {
            this.n.setImeOptions(5);
        }
        EditText editText6 = this.r;
        if (editText6 == null || editText6 == editText || editText6.getVisibility() != 0) {
            return;
        }
        this.r.setImeOptions(5);
    }

    public static boolean u0(Context context, ImageView imageView, int i) {
        if (context != null && imageView != null && imageView.getDrawable() != null) {
            if (imageView.getDrawable().getConstantState() == context.getResources().getDrawable(i, context.getTheme()).getConstantState()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        this.k.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y0(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z0(View view, String str) {
    }

    public TitledBankCardView M0() {
        EditText editText = this.k;
        if (editText != null) {
            editText.setText("");
            this.k.setTextColor(this.s);
        }
        EditText editText2 = this.l;
        if (editText2 != null) {
            editText2.setText("");
            this.l.setTextColor(this.s);
        }
        EditText editText3 = this.n;
        if (editText3 != null) {
            editText3.setText("");
            this.n.setTextColor(this.s);
        }
        N0();
        return this;
    }

    public void N0() {
        EditText editText = this.p;
        if (editText != null && editText.getVisibility() == 0) {
            this.p.setText("");
            this.p.setTextColor(this.s);
        }
        EditText editText2 = this.r;
        if (editText2 == null || editText2.getVisibility() != 0) {
            return;
        }
        this.r.setText("");
        this.r.setTextColor(this.s);
    }

    public void P0() {
        AbstractC7426Rr.T(this.u, 4.0f, 3);
        l0();
        this.k.setTextColor(C5495Jo7.a.J0());
    }

    public void S0() {
        this.B0.z();
        Q0();
    }

    public TitledBankCardView T0(l lVar) {
        this.D = lVar;
        Y50 y50D = Y50.d;
        if (lVar != null) {
            this.k.removeTextChangedListener(this.B);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("XXXX XXXX XXXX ");
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.85f), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) XY6.e(lVar.h()));
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.9f), 0, spannableStringBuilder.length(), 33);
            this.k.setText(spannableStringBuilder);
            this.k.addTextChangedListener(this.B);
            y50D = lVar.d();
            this.t.setImageResource(C17330mn.a(y50D));
            this.c = y50D;
            if (y50D != this.b) {
                this.b = y50D;
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(y50D);
                }
            }
        }
        this.d = true;
        if (!this.J.contains(y50D)) {
            this.k.setTextColor(C5495Jo7.a.J0());
            this.d = false;
        }
        a0();
        this.A0 = false;
        return this;
    }

    public TitledBankCardView U0(String str) {
        this.d = false;
        EditText editText = this.k;
        if (editText != null) {
            editText.setText(str);
            if (str.isEmpty()) {
                this.c = Y50.d;
                this.r.setText("");
                this.p.setText("");
                this.l.setText("");
                this.n.setText("");
                this.k.setSelection(0);
                this.D = null;
            } else {
                this.c = AbstractC19902r80.d(str);
                this.k.postDelayed(new Runnable() { // from class: ir.nasim.Vq7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.K0();
                    }
                }, 50L);
            }
        }
        Y50 y50 = this.c;
        if (y50 != this.b) {
            this.b = y50;
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(y50);
            }
        }
        this.D = l.a(str);
        this.A0 = false;
        return this;
    }

    public TitledBankCardView V0(boolean z) {
        if (this.k != null) {
            X0(false);
            this.k.setEnabled(z);
            this.k.setFocusableInTouchMode(z);
            this.k.setFocusable(z);
            this.k.setClickable(z);
            this.k.setMovementMethod(z ? this.G : null);
            this.k.setKeyListener(z ? this.H : null);
            this.k.requestFocus();
            if (z) {
                this.k.setRawInputType(2);
            } else {
                this.y.setVisibility(8);
            }
            setClickable(!z);
        }
        return this;
    }

    public TitledBankCardView W0(boolean z) {
        if (!z) {
            this.g = true;
            this.e = true;
            this.f = true;
        }
        if (this.z == z) {
            if (this.p.getVisibility() == 0) {
                this.p.requestFocus();
            }
            return this;
        }
        this.z = z;
        if (z) {
            View view = this.v;
            if (view != null) {
                view.setVisibility(0);
                this.n.setVisibility(0);
                this.l.setVisibility(0);
                this.p.setVisibility(0);
                this.p.requestFocus();
            }
        } else {
            View view2 = this.v;
            if (view2 != null) {
                view2.setVisibility(8);
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                this.p.setVisibility(8);
                this.g = true;
                this.e = true;
                this.f = true;
                a0();
            }
        }
        h0();
        return this;
    }

    public TitledBankCardView X0(boolean z) {
        ImageButton imageButton = this.w;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
            this.w.bringToFront();
        }
        return this;
    }

    public TitledBankCardView Y0(String str) {
        EditText editText = this.k;
        if (editText != null && str != null) {
            editText.setHint(str);
        }
        return this;
    }

    public TitledBankCardView Z0(List list) {
        if (list == null) {
            j0();
        } else {
            this.J = list;
        }
        return this;
    }

    public TitledBankCardView a1(int i, View.OnClickListener onClickListener) {
        ImageButton imageButton = this.x;
        if (imageButton != null && i != 0) {
            imageButton.setImageResource(i);
            this.x.setOnClickListener(onClickListener);
            this.x.setVisibility(0);
            this.x.bringToFront();
        }
        return this;
    }

    public TitledBankCardView c1(boolean z) {
        ImageButton imageButton = this.x;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
            this.x.bringToFront();
        }
        return this;
    }

    public TitledBankCardView d1(String str) {
        if (this.j != null) {
            if (str == null || str.isEmpty()) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(str);
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        return obj instanceof String ? obj.equals(getCardNumber()) : obj instanceof l ? obj.equals(this.D) : super.equals(obj);
    }

    @Override // ir.nasim.D50
    public AbstractC20471s40 getBankCard() {
        if (this.A0 || this.D == null) {
            this.D = l.a(getCardNumber());
            this.A0 = false;
        }
        if (this.C0 && !(this.D instanceof m) && !m0()) {
            this.D = l.b(getCardNumber(), this.C0);
        }
        return this.D;
    }

    public String getCardNumber() {
        EditText editText = this.k;
        return editText != null ? XY6.q(editText.getText().toString().trim()) : "";
    }

    public String getCvv2() {
        EditText editText = this.p;
        return editText != null ? XY6.h(XY6.q(editText.getText().toString().trim())) : "";
    }

    public String getExpireMonth() {
        EditText editText = this.l;
        if (editText == null || editText.getVisibility() != 0) {
            return "";
        }
        String strQ = XY6.q(this.l.getText().toString().trim());
        if (strQ.length() == 1) {
            strQ = "0" + strQ;
        }
        return XY6.h(strQ);
    }

    public String getExpireYear() {
        EditText editText = this.n;
        return (editText == null || editText.getText().toString().equals("") || this.n.getVisibility() != 0) ? "" : XY6.h(XY6.q(this.n.getText().toString().substring(2, 4).trim()));
    }

    public String getPin2() {
        EditText editText = this.r;
        return editText != null ? XY6.h(XY6.q(editText.getText().toString().trim())) : "";
    }

    public void l0() {
        if (!this.d) {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            setCardHintColor(c5495Jo7.J0());
            setTitleHintColor(c5495Jo7.J0());
            setCardNumberColor(c5495Jo7.J0());
        }
        if (!this.h) {
            this.B0.o();
        }
        if (!this.e) {
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            setMonthColor(c5495Jo72.J0());
            O0(this.m, c5495Jo72.J0());
        }
        if (!this.f) {
            C5495Jo7 c5495Jo73 = C5495Jo7.a;
            setYearColor(c5495Jo73.J0());
            O0(this.o, c5495Jo73.J0());
        }
        if (this.g) {
            return;
        }
        C5495Jo7 c5495Jo74 = C5495Jo7.a;
        setCvv2Color(c5495Jo74.J0());
        O0(this.q, c5495Jo74.J0());
    }

    public boolean o0() {
        return this.g;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        EditText editText = this.k;
        if (editText != null && editText.getVisibility() == 0 && this.k.isEnabled()) {
            return this.k.requestFocus();
        }
        View view = this.v;
        if (view == null || view.getVisibility() != 0) {
            EditText editText2 = this.r;
            if (editText2 != null && editText2.getVisibility() == 0) {
                return this.r.requestFocus();
            }
        } else {
            EditText editText3 = this.p;
            if (editText3 != null && editText3.getVisibility() == 0) {
                return this.p.requestFocus();
            }
            EditText editText4 = this.l;
            if (editText4 != null && editText4.getVisibility() == 0) {
                return this.l.requestFocus();
            }
            EditText editText5 = this.n;
            if (editText5 != null && editText5.getVisibility() == 0) {
                return this.n.requestFocus();
            }
        }
        return super.requestFocus(i, rect);
    }

    public boolean s0() {
        return this.e;
    }

    public void setBankNameChangeListener(f fVar) {
        this.a = fVar;
    }

    public void setCardHintColor(int i) {
        this.k.setHintTextColor(i);
    }

    public void setCardNumberColor(int i) {
        this.k.setTextColor(i);
    }

    public void setCvv2Color(int i) {
        this.p.setTextColor(i);
        this.p.setHintTextColor(i);
    }

    public void setMonthColor(int i) {
        this.l.setTextColor(i);
        this.l.setHintTextColor(i);
    }

    public void setTitleHintColor(int i) {
        this.j.setTextColor(i);
    }

    public void setYearColor(int i) {
        this.n.setTextColor(i);
        this.n.setHintTextColor(i);
    }

    public boolean t0() {
        return this.f;
    }

    public boolean v0() {
        return this.h;
    }

    public TitledBankCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = null;
        this.A0 = false;
        this.C0 = false;
        setWillNotDraw(false);
        k0(context);
    }

    public TitledBankCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = null;
        this.A0 = false;
        this.C0 = false;
        setWillNotDraw(false);
        k0(context);
    }
}
