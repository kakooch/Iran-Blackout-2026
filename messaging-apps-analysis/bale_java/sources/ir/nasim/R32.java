package ir.nasim;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.network.RpcException;
import ir.nasim.designsystem.base.activity.PasscodeRequiredActivity;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class R32 extends C22042ua0 {
    private C15581jp3 d1;
    private EditText e1;
    private TextView f1;
    private int g1;
    private int h1;
    private TextView i1;
    private ZN2 j1;
    private final String c1 = "EditNameFragment";
    private InputFilter k1 = new a();

    class a implements InputFilter {
        private final String a = "abcdefghijklmnopqrstuvwxyz1234567890_";

        a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            String lowerCase = charSequence.toString() != null ? charSequence.toString().toLowerCase() : "";
            StringBuilder sb = new StringBuilder();
            for (int i5 = i; i5 < i2; i5++) {
                char cCharAt = lowerCase.charAt(i5);
                if ("abcdefghijklmnopqrstuvwxyz1234567890_".indexOf(cCharAt) != -1) {
                    sb.append(cCharAt);
                }
            }
            if (sb.length() == i2 - i && lowerCase.equals(charSequence.toString())) {
                return null;
            }
            return sb.toString();
        }
    }

    class c implements InterfaceC15419jZ0 {
        c() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            R32.this.A5().finish();
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            Toast.makeText(R32.this.A5(), UN2.a(exc, R32.this.j1), 0).show();
        }
    }

    class d implements InterfaceC15419jZ0 {
        d() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            R32.this.A5().finish();
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            Toast.makeText(R32.this.A5(), UN2.a(exc, R32.this.j1), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(View view) {
        String strTrim = this.e1.getText().toString().trim();
        int i = this.g1;
        if (i == 0) {
            ia(strTrim);
            return;
        }
        if (i == 4) {
            ja(strTrim);
            return;
        }
        if (i == 1) {
            la(strTrim);
            return;
        }
        if (i == 5) {
            Toast.makeText(A5(), AbstractC12217eE5.toast_unable_change_bank_account, 0).show();
        } else if (i == 2) {
            ha(strTrim);
        } else if (i == 6) {
            ga(strTrim);
        }
    }

    private void ga(String str) {
        R8(AbstractC5969Lp4.d().B(this.h1, str), AbstractC12217eE5.edit_channel_nick_process, new c());
    }

    private void ha(String str) {
        R8(AbstractC5969Lp4.d().C(this.h1, str), AbstractC12217eE5.edit_name_process, new d());
    }

    private void ia(String str) {
        T8(AbstractC5969Lp4.d().D(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.J32
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.oa((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.K32
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.qa((Exception) obj);
            }
        }), AbstractC12217eE5.edit_name_process);
    }

    private void ja(String str) {
        if (C14225hZ6.b(str)) {
            T8(AbstractC5969Lp4.e().W().f0(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.N32
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.sa((C14505i18) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.O32
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.ua((Exception) obj);
                }
            }), AbstractC12217eE5.edit_nick_process);
        } else {
            Toast.makeText(G5(), AbstractC12217eE5.error_wrong_pattern_id, 0).show();
        }
    }

    public static R32 ka(int i, int i2, String str, ZN2 zn2) {
        Bundle bundle = new Bundle();
        bundle.putInt("EXTRA_TYPE", i);
        bundle.putInt("EXTRA_ID", i2);
        bundle.putString("TITLE", str);
        if (zn2 != null) {
            bundle.putSerializable("GROUP_TYPE", zn2);
        }
        R32 r32 = new R32();
        r32.a8(bundle);
        return r32;
    }

    private void la(String str) {
        T8(AbstractC5969Lp4.d().F(this.h1, str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.L32
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.wa((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.M32
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.ya((Exception) obj);
            }
        }), AbstractC12217eE5.edit_name_process);
    }

    private void ma(View view) {
        BaleToolbar baleToolbar = (BaleToolbar) view.findViewById(BC5.edit_name_toolbar);
        baleToolbar.setHasBackButton(Q7(), true);
        baleToolbar.setTitle(E5().getString("TITLE", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na() {
        try {
            A5().finish();
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(C14505i18 c14505i18) {
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.P32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.na();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa() {
        try {
            Toast.makeText(A5(), AbstractC12217eE5.toast_unable_change, 0).show();
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qa(Exception exc) {
        C19406qI3.d("EditNameFragment", exc);
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.E32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.pa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ra() {
        try {
            A5().finish();
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sa(C14505i18 c14505i18) {
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.F32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.ra();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ta(Exception exc) {
        try {
            if (exc instanceof RpcException) {
                RpcException rpcException = (RpcException) exc;
                if (rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String().equals("NICKNAME_BUSY")) {
                    Toast.makeText(A5(), h6(AbstractC12217eE5.toast_nickname_already_taken), 1).show();
                } else if (rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String().equals("NICKNAME_INVALID")) {
                    Toast.makeText(A5(), h6(AbstractC12217eE5.toast_invalid_nickname), 1).show();
                } else {
                    Toast.makeText(A5(), h6(AbstractC12217eE5.toast_unable_change_nick), 1).show();
                }
            } else {
                Toast.makeText(A5(), AbstractC12217eE5.toast_unable_change_nick, 0).show();
            }
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ua(final Exception exc) {
        C19406qI3.d("EditNameFragment", exc);
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.G32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.ta(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void va() {
        try {
            A5().finish();
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(C14505i18 c14505i18) {
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.Q32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.va();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa() {
        try {
            Toast.makeText(A5(), AbstractC12217eE5.toast_unable_change, 0).show();
        } catch (Exception e) {
            C19406qI3.d("EditNameFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ya(Exception exc) {
        C19406qI3.d("EditNameFragment", exc);
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.H32
            @Override // java.lang.Runnable
            public final void run() {
                this.a.xa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(View view) {
        A5().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C10410bZ6 c10410bZ6R;
        this.g1 = E5().getInt("EXTRA_TYPE");
        this.h1 = E5().getInt("EXTRA_ID");
        Serializable serializable = E5().getSerializable("GROUP_TYPE");
        if (serializable instanceof ZN2) {
            this.j1 = (ZN2) serializable;
        }
        this.d1 = new C15581jp3();
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_edit_name, viewGroup, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.n());
        this.i1 = (TextView) viewInflate.findViewById(BC5.ok);
        this.e1 = (EditText) viewInflate.findViewById(BC5.nameEdit);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(BC5.name_edit_text_input_layout);
        this.e1.addTextChangedListener(new F62(this.e1));
        this.e1.setTextColor(c5495Jo7.g0());
        TextView textView = (TextView) viewInflate.findViewById(BC5.hint);
        this.f1 = textView;
        textView.setTextColor(c5495Jo7.n0());
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(AbstractC5969Lp4.f());
        int i = this.g1;
        if (i == 0) {
            c10410bZ6R = c21231tK7 != null ? c21231tK7.r() : null;
            String str = c10410bZ6R != null ? (String) c10410bZ6R.b() : "";
            this.e1.setText(str != null ? str : "");
            this.e1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(64)});
        } else if (i == 4) {
            c10410bZ6R = c21231tK7 != null ? c21231tK7.s() : null;
            String str2 = c10410bZ6R != null ? (String) c10410bZ6R.b() : "";
            this.e1.setText(str2 != null ? str2.toLowerCase() : "");
            this.e1.setHint(h6(AbstractC12217eE5.nickname_edittext_hint));
            this.e1.setFilters(new InputFilter[]{this.k1, new InputFilter.LengthFilter(32)});
            textInputLayout.setCounterEnabled(true);
            textInputLayout.setCounterMaxLength(32);
            this.f1.setText(h6(AbstractC12217eE5.nickname_hint).replace("{appName}", C5735Kp4.w().f()));
        } else if (i == 1) {
            C21231tK7 c21231tK72 = (C21231tK7) AbstractC5969Lp4.g().n(this.h1);
            c10410bZ6R = c21231tK72 != null ? c21231tK72.r() : null;
            String str3 = c10410bZ6R != null ? (String) c10410bZ6R.b() : "";
            this.e1.setText(str3 != null ? str3 : "");
            this.e1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(64)});
        } else if (i == 2) {
            this.e1.setText((CharSequence) ((C14733iO2) AbstractC5969Lp4.b().n(this.h1)).v().b());
            this.e1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(255)});
        } else if (i == 6) {
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(this.h1);
            this.e1.setFilters(new InputFilter[]{this.k1, new InputFilter.LengthFilter(32)});
            this.e1.setText((CharSequence) c14733iO2.w().b());
            this.e1.setHint(h6(AbstractC12217eE5.channel_nick_edittext_hint));
            this.f1.setText(h6(AbstractC12217eE5.channel_nick_hint));
            textInputLayout.setCounterEnabled(true);
            textInputLayout.setCounterMaxLength(32);
        } else if (i == 5) {
            C21231tK7 c21231tK73 = (C21231tK7) AbstractC5969Lp4.g().n(this.h1);
            if (c21231tK73.k().b() != null) {
                this.e1.setText(XY6.e((String) c21231tK73.k().b()));
            }
            this.e1.setHint(h6(AbstractC12217eE5.defaultBankAccount_edittext_hint));
            this.e1.setRawInputType(2);
            this.f1.setText(h6(AbstractC12217eE5.defaultBankAccount_hint));
        }
        String string = this.e1.getText().toString();
        this.i1.setEnabled(false);
        this.i1.setTextColor(c5495Jo7.n0());
        this.e1.addTextChangedListener(new b(string));
        viewInflate.findViewById(BC5.dividerTop).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
        viewInflate.findViewById(BC5.dividerBot).setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
        viewInflate.findViewById(BC5.cancel).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.D32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.za(view);
            }
        });
        ((TextView) viewInflate.findViewById(BC5.cancel)).setTextColor(c5495Jo7.g0());
        viewInflate.findViewById(BC5.ok).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.I32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Aa(view);
            }
        });
        ma(viewInflate);
        return viewInflate;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.d1 = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        this.d1.c(this.e1, false);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        EditText editText;
        super.h7();
        if (((A5() instanceof PasscodeRequiredActivity) && ((PasscodeRequiredActivity) A5()).K0 != null && ((PasscodeRequiredActivity) A5()).K0.getVisibility() == 0) || (editText = this.e1) == null) {
            return;
        }
        editText.requestFocus();
        EditText editText2 = this.e1;
        editText2.setSelection(editText2.getText().length());
        if (this.d1 == null) {
            this.d1 = new C15581jp3();
        }
        if (this.g1 != 4) {
            this.d1.c(this.e1, true);
        } else {
            this.e1.setInputType(524432);
            this.d1.c(this.e1, false);
        }
    }

    class b implements TextWatcher {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onTextChanged(java.lang.CharSequence r5, int r6, int r7, int r8) {
            /*
                r4 = this;
                java.lang.String r6 = r5.toString()
                java.lang.String r7 = r4.a
                boolean r6 = r6.equals(r7)
                r7 = 1
                r8 = 0
                if (r6 != 0) goto L82
                ir.nasim.R32 r6 = ir.nasim.R32.this
                int r6 = ir.nasim.R32.fa(r6)
                r0 = 5
                if (r6 != r0) goto L67
                java.lang.String r6 = r5.toString()
                java.lang.String r6 = ir.nasim.XY6.h(r6)
                ir.nasim.j30 r6 = ir.nasim.AbstractC19902r80.b(r6)
                ir.nasim.j30 r0 = ir.nasim.EnumC15124j30.INVALID
                boolean r0 = r6.equals(r0)
                if (r0 == 0) goto L3e
                ir.nasim.R32 r6 = ir.nasim.R32.this
                android.widget.TextView r6 = ir.nasim.R32.da(r6)
                ir.nasim.R32 r0 = ir.nasim.R32.this
                int r1 = ir.nasim.AbstractC12217eE5.defaultBankAccount_edittext_hint
                java.lang.String r0 = r0.h6(r1)
                r6.setText(r0)
                r6 = r8
                goto L68
            L3e:
                ir.nasim.R32 r0 = ir.nasim.R32.this
                android.widget.TextView r0 = ir.nasim.R32.da(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                ir.nasim.R32 r2 = ir.nasim.R32.this
                int r3 = ir.nasim.AbstractC12217eE5.account
                java.lang.String r2 = r2.h6(r3)
                r1.append(r2)
                java.lang.String r2 = " "
                r1.append(r2)
                java.lang.String r6 = ir.nasim.AbstractC19902r80.c(r6)
                r1.append(r6)
                java.lang.String r6 = r1.toString()
                r0.setText(r6)
            L67:
                r6 = r7
            L68:
                int r0 = r5.length()
                if (r0 != 0) goto L6f
                r6 = r7
            L6f:
                ir.nasim.R32 r0 = ir.nasim.R32.this
                int r0 = ir.nasim.R32.fa(r0)
                r1 = 4
                if (r0 != r1) goto L83
                java.lang.String r5 = r5.toString()
                boolean r5 = ir.nasim.C14225hZ6.b(r5)
                if (r5 != 0) goto L83
            L82:
                r6 = r8
            L83:
                if (r6 == 0) goto L9e
                ir.nasim.R32 r5 = ir.nasim.R32.this
                android.widget.TextView r5 = ir.nasim.R32.ea(r5)
                r5.setEnabled(r7)
                ir.nasim.R32 r5 = ir.nasim.R32.this
                android.widget.TextView r5 = ir.nasim.R32.ea(r5)
                ir.nasim.Jo7 r6 = ir.nasim.C5495Jo7.a
                int r6 = r6.g0()
                r5.setTextColor(r6)
                goto Lb6
            L9e:
                ir.nasim.R32 r5 = ir.nasim.R32.this
                android.widget.TextView r5 = ir.nasim.R32.ea(r5)
                r5.setEnabled(r8)
                ir.nasim.R32 r5 = ir.nasim.R32.this
                android.widget.TextView r5 = ir.nasim.R32.ea(r5)
                ir.nasim.Jo7 r6 = ir.nasim.C5495Jo7.a
                int r6 = r6.n0()
                r5.setTextColor(r6)
            Lb6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.R32.b.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
