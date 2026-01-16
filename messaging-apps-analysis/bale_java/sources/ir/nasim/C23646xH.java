package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.D20;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.root.RootActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001SB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0013\u0010\t\u001a\u00020\u0004*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J+\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b,\u0010-J!\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0003R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010N\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010Q\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lir/nasim/xH;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ha", "qa", "ba", "Landroid/widget/TextView;", "ta", "(Landroid/widget/TextView;)V", "ga", "Y9", "la", "ea", "aa", "Landroid/widget/FrameLayout;", "frameLayout", "na", "(Landroid/widget/FrameLayout;)V", "", DialogEntity.COLUMN_MESSAGE, "ussd", "sa", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/appcompat/widget/AppCompatEditText;", "inputView", "Lcom/google/android/material/card/MaterialCardView;", "editTextCard", "oa", "(Landroidx/appcompat/widget/AppCompatEditText;Lcom/google/android/material/card/MaterialCardView;)V", "fa", "W9", "da", "ma", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "M6", "(Landroid/os/Bundle;)V", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "c7", "Lir/nasim/ux2;", "c1", "Lir/nasim/ux2;", "_binding", "Lir/nasim/yH;", "d1", "Lir/nasim/Yu3;", "ka", "()Lir/nasim/yH;", "viewModel", "Lir/nasim/n10;", "e1", "Lir/nasim/n10;", "baleSnackbar", "", "f1", TokenNames.I, "ja", "()I", "setEditTextSize", "(I)V", "editTextSize", "g1", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "setEditText", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "editText", "ia", "()Lir/nasim/ux2;", "binding", "h1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.xH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23646xH extends C22042ua0 {

    /* renamed from: h1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C22272ux2 _binding;

    /* renamed from: e1, reason: from kotlin metadata */
    private C17468n10 baleSnackbar;

    /* renamed from: g1, reason: from kotlin metadata */
    private AppCompatEditText editText;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.uH
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C23646xH.ua(this.a);
        }
    });

    /* renamed from: f1, reason: from kotlin metadata */
    private int editTextSize = 50;

    /* renamed from: ir.nasim.xH$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C23646xH a() {
            return new C23646xH();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xH$b */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            Context contextS7 = C23646xH.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = C23646xH.this.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, P11.a.c(), 4, null).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: ir.nasim.xH$c */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            HG.INSTANCE.a(true).K8(C23646xH.this.Q7().B0(), null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: ir.nasim.xH$d */
    public static final class d implements TextWatcher {
        final /* synthetic */ TextView b;

        d(TextView textView) {
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            this.b.setText(C23646xH.this.ka().T0(editable.toString(), C23646xH.this.getEditTextSize()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            C23646xH.this.ia().f.setEnabled(AbstractC20762sZ6.n1(charSequence).length() > 0);
            if (AbstractC20762sZ6.n1(charSequence).length() > 0) {
                C23646xH.this.ia().f.setTextColor(C5495Jo7.a.b0());
            } else {
                C23646xH.this.ia().f.setTextColor(C5495Jo7.a.e0());
            }
        }
    }

    /* renamed from: ir.nasim.xH$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MaterialCardView c;
        final /* synthetic */ C23646xH d;
        final /* synthetic */ AppCompatEditText e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(MaterialCardView materialCardView, C23646xH c23646xH, AppCompatEditText appCompatEditText, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = materialCardView;
            this.d = c23646xH;
            this.e = appCompatEditText;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.c.setStrokeColor(C5495Jo7.a.Y());
                this.b = 1;
                if (HG1.b(100L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            NestedScrollView nestedScrollView = this.d.ia().k;
            AbstractC13042fc3.h(nestedScrollView, "nestedScrollView");
            AbstractC4808Gq4.a(nestedScrollView, this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void W9() {
        SwitchCompat switchCompat = ia().c;
        switchCompat.setChecked(AbstractC5969Lp4.e().S().o0());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.tH
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C23646xH.X9(compoundButton, z);
            }
        });
        ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(CompoundButton compoundButton, boolean z) {
        AbstractC5969Lp4.e().S().d6(z);
    }

    private final void Y9() {
        BaleButton baleButton = ia().f;
        ia().f.setEnabled(false);
        ia().f.setTextColor(C5495Jo7.a.e0());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23646xH.Z9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(C23646xH c23646xH, View view) {
        AbstractC13042fc3.i(c23646xH, "this$0");
        int iR0 = c23646xH.ka().R0();
        if (iR0 > AbstractC5969Lp4.e().S().c4() || !c23646xH.ia().c.isChecked()) {
            c23646xH.la();
        } else {
            HG.INSTANCE.a(false).K8(c23646xH.Q7().B0(), null);
            c23646xH.ka().U0(iR0 + 1);
        }
    }

    private final void aa() {
        FrameLayout frameLayout = ia().i;
        AbstractC13042fc3.f(frameLayout);
        na(frameLayout);
    }

    private final void ba() {
        TextView textView = ia().g;
        textView.setVisibility(C8386Vt0.a.r4() ? 0 : 8);
        AbstractC13042fc3.f(textView);
        ta(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23646xH.ca(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(C23646xH c23646xH, View view) {
        AbstractC13042fc3.i(c23646xH, "this$0");
        if (C19393qH.a.a()) {
            C23381wp3.f(c23646xH.editText);
            C22042ua0.A9(c23646xH, ZG.INSTANCE.a(), false, null, 6, null);
        } else {
            C17468n10 c17468n10 = c23646xH.baleSnackbar;
            if (c17468n10 != null) {
                c17468n10.o(c23646xH.Y8(AbstractC12217eE5.arbaeen_last_viewer_snackbar));
            }
        }
    }

    private final void da() {
        ia().m.setText(i6(AbstractC12217eE5.powered_by, AbstractC5969Lp4.e().S().q0()));
    }

    private final void ea() {
        ConstraintLayout root = ia().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(ia().f);
        this.baleSnackbar = c17468n10;
    }

    private final void fa() {
        TextView textView = ia().h;
        SpannableString spannableString = new SpannableString(n6(AbstractC12217eE5.arbaeen2_send_message_body));
        String strH6 = h6(AbstractC12217eE5.price_free);
        AbstractC13042fc3.h(strH6, "getString(...)");
        int iL0 = AbstractC20762sZ6.l0(spannableString, strH6, 0, false, 6, null);
        int i = iL0 + 6;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C5495Jo7.a.h0());
        b bVar = new b();
        spannableString.setSpan(foregroundColorSpan, iL0, i, 33);
        spannableString.setSpan(bVar, iL0, i, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
    }

    private final void ga() {
        BaleToolbar baleToolbar = ia().n;
        AbstractC13042fc3.h(baleToolbar, "toolbar");
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void ha() {
        Y9();
        aa();
        ea();
        ga();
        ba();
        qa();
        fa();
        W9();
        da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22272ux2 ia() {
        C22272ux2 c22272ux2 = this._binding;
        AbstractC13042fc3.f(c22272ux2);
        return c22272ux2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24236yH ka() {
        return (C24236yH) this.viewModel.getValue();
    }

    private final void la() {
        Editable text;
        AppCompatEditText appCompatEditText = this.editText;
        if (String.valueOf((appCompatEditText == null || (text = appCompatEditText.getText()) == null) ? null : AbstractC20762sZ6.n1(text)).length() > 0) {
            AppCompatEditText appCompatEditText2 = this.editText;
            String strValueOf = String.valueOf(appCompatEditText2 != null ? appCompatEditText2.getText() : null);
            ka().S0("arbaeen_submit_status_send");
            if (ia().c.isChecked()) {
                sa(strValueOf, AbstractC5969Lp4.e().S().s0());
            } else {
                sa(strValueOf, AbstractC5969Lp4.e().S().r0());
            }
            C23381wp3.f(this.editText);
            C19393qH.a.g();
            TextView textView = ia().g;
            AbstractC13042fc3.h(textView, "lastViewer");
            ta(textView);
            Q7().onBackPressed();
        }
    }

    private final void ma() {
        TextView textView = ia().d;
        SpannableString spannableString = new SpannableString(n6(AbstractC12217eE5.arbaeen_add_story_text));
        String strH6 = h6(AbstractC12217eE5.arbaeen_add_story_text_span);
        AbstractC13042fc3.h(strH6, "getString(...)");
        int iL0 = AbstractC20762sZ6.l0(spannableString, strH6, 0, false, 6, null);
        int length = h6(AbstractC12217eE5.arbaeen_add_story_text_span).length() + iL0;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C5495Jo7.a.h0());
        c cVar = new c();
        spannableString.setSpan(foregroundColorSpan, iL0, length, 33);
        spannableString.setSpan(cVar, iL0, length, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
    }

    private final void na(FrameLayout frameLayout) {
        Object systemService = S7().getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.bale_edit_text, (ViewGroup) null);
        PZ pzA = PZ.a(viewInflate);
        AbstractC13042fc3.h(pzA, "bind(...)");
        TextView textView = pzA.d;
        this.editText = pzA.c;
        TextView textView2 = pzA.e;
        MaterialCardView materialCardView = pzA.b;
        TextView textView3 = pzA.f;
        textView.setTextSize(13.0f);
        textView.setTypeface(C6011Lu2.i());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.d());
        textView.setText(h6(AbstractC12217eE5.arabeen_send_message));
        AppCompatEditText appCompatEditText = this.editText;
        if (appCompatEditText != null) {
            appCompatEditText.setTextColor(c5495Jo7.g());
        }
        AppCompatEditText appCompatEditText2 = this.editText;
        if (appCompatEditText2 != null) {
            appCompatEditText2.setTextSize(16.0f);
        }
        AppCompatEditText appCompatEditText3 = this.editText;
        if (appCompatEditText3 != null) {
            appCompatEditText3.setHint(h6(AbstractC12217eE5.arbaeen2_send_message_hint));
        }
        AppCompatEditText appCompatEditText4 = this.editText;
        if (appCompatEditText4 != null) {
            appCompatEditText4.setTypeface(C6011Lu2.k());
        }
        AppCompatEditText appCompatEditText5 = this.editText;
        if (appCompatEditText5 != null) {
            appCompatEditText5.setHintTextColor(S7().getResources().getColor(TA5.color7));
        }
        AppCompatEditText appCompatEditText6 = this.editText;
        ViewGroup.LayoutParams layoutParams = appCompatEditText6 != null ? appCompatEditText6.getLayoutParams() : null;
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(C22078ud6.a(16.0f), C22078ud6.a(-8.0f), C22078ud6.a(16.0f), C22078ud6.a(0.0f));
        AppCompatEditText appCompatEditText7 = this.editText;
        if (appCompatEditText7 != null) {
            appCompatEditText7.setLayoutParams(marginLayoutParams);
        }
        AppCompatEditText appCompatEditText8 = this.editText;
        if (appCompatEditText8 != null) {
            appCompatEditText8.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.editTextSize)});
        }
        if (TextUtils.isEmpty(null)) {
            textView2.setText(ka().T0("", this.editTextSize));
        } else {
            AppCompatEditText appCompatEditText9 = this.editText;
            if (appCompatEditText9 != null) {
                appCompatEditText9.setText((CharSequence) null);
            }
            textView2.setText((CharSequence) null);
        }
        textView2.setTextSize(12.0f);
        textView2.setTypeface(C6011Lu2.k());
        textView2.setTextColor(c5495Jo7.d());
        textView3.setTextColor(c5495Jo7.g2());
        textView3.setTextSize(12.0f);
        textView3.setTypeface(C6011Lu2.k());
        textView3.setVisibility(8);
        materialCardView.setStrokeColor(c5495Jo7.Z());
        materialCardView.setStrokeWidth(C22078ud6.a(1.5f));
        materialCardView.setCardElevation(AbstractC14828iY7.b(materialCardView, 3.0f));
        AbstractC14828iY7.k(materialCardView, Float.valueOf(2.0f), Float.valueOf(2.0f), Float.valueOf(2.0f), null, 8, null);
        AppCompatEditText appCompatEditText10 = this.editText;
        if (appCompatEditText10 != null) {
            appCompatEditText10.addTextChangedListener(new d(textView2));
        }
        oa(this.editText, materialCardView);
        viewInflate.setVisibility(0);
        frameLayout.addView(viewInflate);
    }

    private final void oa(final AppCompatEditText inputView, final MaterialCardView editTextCard) {
        if (inputView != null) {
            inputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.rH
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    C23646xH.pa(this.a, editTextCard, inputView, view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(C23646xH c23646xH, MaterialCardView materialCardView, AppCompatEditText appCompatEditText, View view, boolean z) {
        AbstractC13042fc3.i(c23646xH, "this$0");
        AbstractC13042fc3.i(materialCardView, "$editTextCard");
        AbstractC13042fc3.i(appCompatEditText, "$it");
        if (z) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(c23646xH), null, null, new e(materialCardView, c23646xH, appCompatEditText, null), 3, null);
        }
    }

    private final void qa() {
        C19393qH c19393qH = C19393qH.a;
        if (c19393qH.d() || !C8386Vt0.a.r4()) {
            return;
        }
        D20.a aVarA = C10600bs7.a.a(this);
        String strH6 = h6(AbstractC12217eE5.arbaeen_last_viewer_tooltip);
        AbstractC13042fc3.h(strH6, "getString(...)");
        aVarA.X1(strH6);
        aVarA.c2(true);
        aVarA.a1(0.15f);
        aVarA.k2(200);
        aVarA.u1(RecyclerView.UNDEFINED_DURATION);
        aVarA.b2(5);
        D20 d20A = aVarA.a();
        TextView textView = ia().g;
        AbstractC13042fc3.h(textView, "lastViewer");
        d20A.J0(textView, 0, 0);
        c19393qH.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C23646xH c23646xH, String str, Bundle bundle) {
        AbstractC13042fc3.i(c23646xH, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (bundle.containsKey("KEY_CLICK_ON_CONFIRM")) {
            c23646xH.ia().c.setChecked(bundle.getBoolean("KEY_CLICK_ON_CONFIRM", true));
        }
        c23646xH.la();
        return C19938rB7.a;
    }

    private final void sa(String message, String ussd) {
        if (message.length() == 0) {
            RootActivity.Companion companion = RootActivity.INSTANCE;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            companion.e(contextS7, ussd);
            return;
        }
        String str = ussd + ka().P0(message) + Separators.POUND;
        RootActivity.Companion companion2 = RootActivity.INSTANCE;
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        companion2.e(contextS72, str);
    }

    private final void ta(TextView textView) {
        if (C19393qH.a.a()) {
            textView.setTextColor(AbstractC4043Dl1.c(S7(), TA5.c11));
        } else {
            textView.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonTextDisable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24236yH ua(C23646xH c23646xH) {
        AbstractC13042fc3.i(c23646xH, "this$0");
        return (C24236yH) new androidx.lifecycle.G(c23646xH).b(C24236yH.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "REQUEST_CODE_ARBAEEN_ADD_STORY_DIALOG", new InterfaceC14603iB2() { // from class: ir.nasim.wH
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C23646xH.ra(this.a, (String) obj, (Bundle) obj2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C22272ux2.c(inflater, container, false);
        ConstraintLayout root = ia().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        AppCompatEditText appCompatEditText = this.editText;
        if (appCompatEditText != null) {
            appCompatEditText.clearFocus();
        }
        super.c7();
    }

    /* renamed from: ja, reason: from getter */
    public final int getEditTextSize() {
        return this.editTextSize;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ha();
    }
}
