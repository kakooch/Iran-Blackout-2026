package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lir/nasim/pX4;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/widget/TextView;", "titleTextView", "Lir/nasim/rB7;", "Z9", "(Landroid/widget/TextView;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "h7", "c7", "", "c1", "Z", "isSetPasscodeMode", "", "d1", TokenNames.I, "passcodeEnteredCount", "", "e1", "Ljava/lang/String;", "firstPassword", "Landroid/widget/LinearLayout;", "f1", "Landroid/widget/LinearLayout;", "rootLayout", "Landroid/widget/EditText;", "g1", "Landroid/widget/EditText;", "passcodeEditText", "h1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.pX4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18951pX4 extends C22042ua0 {

    /* renamed from: h1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private boolean isSetPasscodeMode;

    /* renamed from: d1, reason: from kotlin metadata */
    private int passcodeEnteredCount;

    /* renamed from: e1, reason: from kotlin metadata */
    private String firstPassword = "";

    /* renamed from: f1, reason: from kotlin metadata */
    private LinearLayout rootLayout;

    /* renamed from: g1, reason: from kotlin metadata */
    private EditText passcodeEditText;

    /* renamed from: ir.nasim.pX4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C18951pX4 a(boolean z) {
            C18951pX4 c18951pX4 = new C18951pX4();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSetPasscode", z);
            c18951pX4.a8(bundle);
            return c18951pX4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pX4$b */
    public static final class b implements TextWatcher {
        private int a;
        private int b;
        final /* synthetic */ TextView d;

        b(TextView textView) {
            this.d = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            EditText editText = C18951pX4.this.passcodeEditText;
            if (editText == null) {
                return;
            }
            if (JF5.g()) {
                editText.removeTextChangedListener(this);
                editText.setText(XY6.e(editable.toString()));
                editText.addTextChangedListener(this);
                editText.setSelection(this.a + this.b);
            }
            if (editText.length() == 6) {
                EditText editText2 = C18951pX4.this.passcodeEditText;
                AbstractC13042fc3.f(editText2);
                String string = editText2.getText().toString();
                if (JF5.g()) {
                    string = XY6.h(string);
                }
                if (!C18951pX4.this.isSetPasscodeMode) {
                    if (C23073wI7.b(string)) {
                        editText.setText("");
                        C22042ua0.A9(C18951pX4.this, C22019uX4.INSTANCE.a(), false, null, 6, null);
                        return;
                    } else {
                        editText.setText("");
                        C18951pX4.this.Z9(this.d);
                        return;
                    }
                }
                if (C18951pX4.this.passcodeEnteredCount == 0) {
                    C18951pX4.this.firstPassword = string;
                    editText.setText("");
                    editText.setHint(AbstractC12217eE5.reEnter_passcode);
                    this.d.setText(AbstractC12217eE5.reEnter_passcode);
                    C18951pX4.this.passcodeEnteredCount++;
                    return;
                }
                if (C18951pX4.this.passcodeEnteredCount == 1) {
                    if (!AbstractC13042fc3.d(C18951pX4.this.firstPassword, string)) {
                        C18951pX4.this.Z9(this.d);
                        Toast.makeText(C18951pX4.this.G5(), AbstractC12217eE5.passcode_not_matched, 0).show();
                        editText.setText("");
                        return;
                    }
                    try {
                        String str = C18951pX4.this.firstPassword;
                        Charset charsetForName = Charset.forName("UTF-8");
                        AbstractC13042fc3.h(charsetForName, "forName(...)");
                        byte[] bytes = str.getBytes(charsetForName);
                        AbstractC13042fc3.h(bytes, "getBytes(...)");
                        int length = bytes.length + 32;
                        byte[] bArr = new byte[length];
                        System.arraycopy(C23073wI7.f, 0, bArr, 0, 16);
                        System.arraycopy(bytes, 0, bArr, 16, bytes.length);
                        System.arraycopy(C23073wI7.f, 0, bArr, bytes.length + 16, 16);
                        C23073wI7.g = AbstractC15318jN7.b(AbstractC15318jN7.c(bArr, 0, length));
                        C23073wI7.n = true;
                    } catch (Exception e) {
                        C19406qI3.d("PasscodeFragment", e);
                    }
                    C23073wI7.e();
                    editText.setText("");
                    C18951pX4.this.passcodeEnteredCount = 0;
                    C18951pX4.this.firstPassword = "";
                    FragmentManager fragmentManagerB0 = C18951pX4.this.Q7().B0();
                    AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                    androidx.fragment.app.x xVarS = fragmentManagerB0.s();
                    AbstractC13042fc3.h(xVarS, "beginTransaction(...)");
                    xVarS.p(C18951pX4.this);
                    xVarS.h();
                    fragmentManagerB0.k1();
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            this.a = i;
            this.b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(C18951pX4 c18951pX4) {
        AbstractC13042fc3.i(c18951pX4, "this$0");
        EditText editText = c18951pX4.passcodeEditText;
        AbstractC13042fc3.f(editText);
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(TextView titleTextView) {
        if (A5() == null) {
            return;
        }
        Object systemService = Q7().getSystemService("vibrator");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(200L);
        AbstractC7426Rr.a.S(titleTextView, 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(C18951pX4 c18951pX4) {
        AbstractC13042fc3.i(c18951pX4, "this$0");
        EditText editText = c18951pX4.passcodeEditText;
        if (editText != null) {
            AbstractC13042fc3.f(editText);
            editText.clearFocus();
            C23381wp3.f(c18951pX4.passcodeEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(C18951pX4 c18951pX4) {
        AbstractC13042fc3.i(c18951pX4, "this$0");
        EditText editText = c18951pX4.passcodeEditText;
        if (editText != null) {
            AbstractC13042fc3.f(editText);
            editText.requestFocus();
            C23381wp3.g(c18951pX4.passcodeEditText);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this.isSetPasscodeMode = R7().getBoolean("isSetPasscode", false);
        LinearLayout linearLayout = new LinearLayout(G5());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackgroundColor(c5495Jo7.n());
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -1));
        linearLayout.setGravity(48);
        this.rootLayout = linearLayout;
        BaleToolbar.Companion companion = BaleToolbar.INSTANCE;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        String strH6 = h6(AbstractC12217eE5.passcode_header);
        AbstractC13042fc3.h(strH6, "getString(...)");
        BaleToolbar baleToolbarD = BaleToolbar.Companion.d(companion, fragmentActivityQ7, strH6, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AppBarLayout appBarLayoutA = companion.a(contextS7);
        appBarLayoutA.addView(baleToolbarD);
        LinearLayout linearLayout2 = this.rootLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(appBarLayoutA);
        }
        TextView textView = new TextView(S7());
        textView.setLayoutParams(C14433hu3.i(-1, -2, 1, 8, 48, 8, 24));
        textView.setGravity(17);
        textView.setTextColor(c5495Jo7.t2());
        textView.setText(AbstractC12217eE5.enter_passcode);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(C6011Lu2.k());
        EditText editText = new EditText(G5());
        editText.setLayoutParams(C14433hu3.i(-1, -2, 1, 8, 8, 8, 24));
        editText.setHint(AbstractC12217eE5.enter_passcode);
        editText.setTypeface(C6011Lu2.k());
        editText.setTextSize(1, 16.0f);
        editText.setTextColor(c5495Jo7.g0());
        editText.setMaxLines(1);
        editText.setLines(1);
        editText.setSingleLine(true);
        editText.setGravity(JF5.g() ? 5 : 3);
        editText.setTextDirection(2);
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        editText.setInputType(3);
        editText.setKeyListener(DigitsKeyListener.getInstance("1234567890"));
        editText.post(new Runnable() { // from class: ir.nasim.nX4
            @Override // java.lang.Runnable
            public final void run() {
                C18951pX4.Y9(this.a);
            }
        });
        this.passcodeEditText = editText;
        C23381wp3.g(editText);
        EditText editText2 = this.passcodeEditText;
        if (editText2 != null) {
            editText2.addTextChangedListener(new b(textView));
        }
        LinearLayout linearLayout3 = this.rootLayout;
        AbstractC13042fc3.f(linearLayout3);
        linearLayout3.addView(textView);
        LinearLayout linearLayout4 = this.rootLayout;
        AbstractC13042fc3.f(linearLayout4);
        linearLayout4.addView(this.passcodeEditText);
        return this.rootLayout;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.rootLayout = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.oX4
            @Override // java.lang.Runnable
            public final void run() {
                C18951pX4.aa(this.a);
            }
        }, 50L);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.mX4
            @Override // java.lang.Runnable
            public final void run() {
                C18951pX4.ba(this.a);
            }
        }, 200L);
    }
}
