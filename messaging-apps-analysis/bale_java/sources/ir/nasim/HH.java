package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14056hH;
import ir.nasim.C21753u45;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.root.RootActivity;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001TB\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0011J+\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b.\u0010/J)\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00072\u0006\u00106\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b<\u00108J\u000f\u0010=\u001a\u00020\u0007H\u0016¢\u0006\u0004\b=\u0010\u0006R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lir/nasim/HH;", "Lir/nasim/ua0;", "Lir/nasim/hH$c;", "Lir/nasim/hH$b;", "Lir/nasim/hH$d;", "<init>", "()V", "Lir/nasim/rB7;", "fa", "ea", "W9", "la", "ka", "Y9", "", DialogEntity.COLUMN_MESSAGE, "pa", "(Ljava/lang/String;)V", "ca", "Lir/nasim/components/textfield/view/CustomInputView;", "inputView", "ma", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "ba", "aa", "ha", "Landroid/content/Intent;", "data", "qa", "(Landroid/content/Intent;)V", "phoneNumber", "", "oa", "(Ljava/lang/String;)Z", "number", "ra", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/fH;", "item", "D2", "(Lir/nasim/fH;)V", "Lir/nasim/gH;", "j2", "(Lir/nasim/gH;)V", "B4", "c7", "Lir/nasim/vx2;", "c1", "Lir/nasim/vx2;", "_binding", "Lir/nasim/IH;", "d1", "Lir/nasim/Yu3;", "ja", "()Lir/nasim/IH;", "viewModel", "Lir/nasim/hH;", "e1", "Lir/nasim/hH;", "suggestAdapter", "Landroid/view/View$OnClickListener;", "f1", "Landroid/view/View$OnClickListener;", "contactIconClickListener", "ia", "()Lir/nasim/vx2;", "binding", "g1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class HH extends C22042ua0 implements C14056hH.c, C14056hH.b, C14056hH.d {

    /* renamed from: g1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int h1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C22868vx2 _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.EH
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return HH.sa(this.a);
        }
    });

    /* renamed from: e1, reason: from kotlin metadata */
    private final C14056hH suggestAdapter = new C14056hH();

    /* renamed from: f1, reason: from kotlin metadata */
    private final View.OnClickListener contactIconClickListener = new View.OnClickListener() { // from class: ir.nasim.FH
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            HH.ga(this.a, view);
        }
    };

    /* renamed from: ir.nasim.HH$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final HH a() {
            return new HH();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return HH.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(3000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            HH.this.ja().T0((String) this.d.a);
            HH.this.ia().g.setText("");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            HH.this.ia().e.setEnabled(AbstractC20762sZ6.n1(charSequence).length() > 0);
            if (AbstractC20762sZ6.n1(charSequence).length() > 0) {
                HH.this.ia().e.setTextColor(C5495Jo7.a.b0());
            } else {
                HH.this.ia().e.setTextColor(C5495Jo7.a.e0());
            }
        }
    }

    public static final class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            Context contextS7 = HH.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = HH.this.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, R11.a.c(), 4, null).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ CustomInputView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CustomInputView customInputView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = customInputView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return HH.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
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
            NestedScrollView nestedScrollView = HH.this.ia().h;
            AbstractC13042fc3.h(nestedScrollView, "nestedScrollView");
            AbstractC4808Gq4.a(nestedScrollView, this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void W9() {
        BaleButton baleButton = ia().e;
        ia().e.setEnabled(false);
        ia().e.setTextColor(C5495Jo7.a.e0());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HH.X9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(HH hh, View view) {
        AbstractC13042fc3.i(hh, "this$0");
        C12889fL5 c12889fL5 = new C12889fL5();
        String string = AbstractC20762sZ6.n1(hh.ia().g.getText()).toString();
        c12889fL5.a = string;
        if (string.length() <= 0) {
            hh.ka();
            return;
        }
        String strH = XY6.h((String) c12889fL5.a);
        c12889fL5.a = strH;
        if (!hh.oa(strH)) {
            hh.ka();
            return;
        }
        if (!hh.ja().d1((String) c12889fL5.a)) {
            hh.la();
            return;
        }
        hh.ja().a1("arbaeen_view_other_status_send");
        hh.pa((String) c12889fL5.a);
        C23381wp3.f(hh.ia().g);
        hh.ia().g.clearFocus();
        AbstractC10533bm0.d(AbstractC9773aX7.a(hh.ja()), null, null, hh.new b(c12889fL5, null), 3, null);
    }

    private final void Y9() {
        final CustomInputView customInputView = ia().g;
        AbstractC13042fc3.f(customInputView);
        customInputView.b(new Q45(customInputView));
        customInputView.b(new c());
        customInputView.q(new View.OnClickListener() { // from class: ir.nasim.DH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HH.Z9(this.a, customInputView, view);
            }
        });
        customInputView.setDrawableEndFirstClickListener(this.contactIconClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(HH hh, CustomInputView customInputView, View view) {
        AbstractC13042fc3.i(hh, "this$0");
        AbstractC13042fc3.i(customInputView, "$this_with");
        AbstractC13042fc3.g(view, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) view;
        editText.setSelection(editText.length());
        NestedScrollView nestedScrollView = hh.ia().h;
        AbstractC13042fc3.h(nestedScrollView, "nestedScrollView");
        AbstractC4808Gq4.a(nestedScrollView, customInputView);
    }

    private final void aa() {
        ia().j.setText(i6(AbstractC12217eE5.powered_by, AbstractC5969Lp4.e().S().q0()));
    }

    private final void ba() {
        TextView textView = ia().f;
        SpannableString spannableString = new SpannableString(n6(AbstractC12217eE5.arbaeen_view_message_body));
        String strH6 = h6(AbstractC12217eE5.price_free);
        AbstractC13042fc3.h(strH6, "getString(...)");
        int iL0 = AbstractC20762sZ6.l0(spannableString, strH6, 0, false, 6, null);
        int i = iL0 + 6;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C5495Jo7.a.h0());
        d dVar = new d();
        spannableString.setSpan(foregroundColorSpan, iL0, i, 33);
        spannableString.setSpan(dVar, iL0, i, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
    }

    private final void ca() {
        RecyclerView recyclerView = ia().d;
        ja().X0().j(p6(), new QG4() { // from class: ir.nasim.CH
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                HH.da(this.a, (ArrayList) obj);
            }
        });
        recyclerView.setAdapter(this.suggestAdapter);
        ja().c1();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        this.suggestAdapter.A(this);
        this.suggestAdapter.B(this);
        this.suggestAdapter.C(this);
        CustomInputView customInputView = ia().g;
        AbstractC13042fc3.h(customInputView, "mobileInput");
        ma(customInputView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(HH hh, ArrayList arrayList) {
        AbstractC13042fc3.i(hh, "this$0");
        hh.suggestAdapter.z(arrayList);
        hh.suggestAdapter.notifyDataSetChanged();
        if (arrayList.size() > 0) {
            hh.ia().k.setVisibility(0);
        } else {
            hh.ia().k.setVisibility(8);
        }
    }

    private final void ea() {
        BaleToolbar baleToolbar = ia().l;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void fa() {
        W9();
        Y9();
        ea();
        ca();
        ba();
        aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(HH hh, View view) {
        AbstractC13042fc3.i(hh, "this$0");
        hh.ia().g.clearFocus();
        hh.ha();
        hh.ja().a1("arbaeen_contact_picker_click");
    }

    private final void ha() {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (AbstractC4043Dl1.a(fragmentActivityQ7, "android.permission.READ_CONTACTS") != 0) {
            C21753u45.R0(C21753u45.a, this, 7, Integer.valueOf(AbstractC12217eE5.contact_permission_desctiption_arbaeen), null, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 24, null);
        } else {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22868vx2 ia() {
        C22868vx2 c22868vx2 = this._binding;
        AbstractC13042fc3.f(c22868vx2);
        return c22868vx2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IH ja() {
        return (IH) this.viewModel.getValue();
    }

    private final void ka() {
        Toast.makeText(C5721Ko.a.d(), AbstractC12217eE5.arbaeen_view_message_digit_error_phone_number, 1).show();
    }

    private final void la() {
        Toast.makeText(C5721Ko.a.d(), AbstractC12217eE5.arbaeen_view_message_sim_error_phone_number, 1).show();
    }

    private final void ma(final CustomInputView inputView) {
        inputView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.GH
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                HH.na(this.a, inputView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(HH hh, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(hh, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputView");
        if (!z) {
            customInputView.setHintTextColor(AbstractC4043Dl1.c(hh.S7(), TA5.color8));
        } else {
            AbstractC10533bm0.d(AbstractC19224pz3.a(hh), null, null, hh.new e(customInputView, null), 3, null);
            customInputView.setHintTextColor(AbstractC4043Dl1.c(hh.S7(), TA5.c11));
        }
    }

    private final boolean oa(String phoneNumber) {
        return phoneNumber.length() == 11 || phoneNumber.length() == 10;
    }

    private final void pa(String message) {
        if (message.length() == 0) {
            RootActivity.Companion companion = RootActivity.INSTANCE;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            companion.e(contextS7, AbstractC5969Lp4.e().S().t0());
            return;
        }
        String str = AbstractC5969Lp4.e().S().t0() + message + Separators.POUND;
        RootActivity.Companion companion2 = RootActivity.INSTANCE;
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        companion2.e(contextS72, str);
    }

    private final void qa(Intent data) {
        String name;
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            ContentResolver contentResolver = fragmentActivityA5.getContentResolver();
            AbstractC13042fc3.f(data2);
            Cursor cursorQuery = contentResolver.query(data2, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst() || !AbstractC20153rZ6.D(cursorQuery.getString(cursorQuery.getColumnIndex("has_phone_number")), "1", true)) {
                return;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    int columnIndex = cursor2.getColumnIndex("data1");
                    do {
                        String string = cursor2.getString(columnIndex);
                        AbstractC13042fc3.h(string, "getString(...)");
                        ra(string);
                    } while (cursor2.moveToNext());
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(cursor, null);
            } finally {
            }
        } catch (Exception e2) {
            if (HH.class.isAnonymousClass()) {
                name = HH.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = HH.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e2);
        }
    }

    private final void ra(String number) {
        if (!ja().d1(number)) {
            ia().g.setText("");
            Toast.makeText(G5(), AbstractC12217eE5.arbaeen_view_message_sim_error_phone_number, 1).show();
        } else {
            ia().g.setText(new C20644sM5("^(\\+989|989|00989|9)").l(new C20644sM5("[^\\d]").k(number, ""), "09"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IH sa(HH hh) {
        AbstractC13042fc3.i(hh, "this$0");
        return (IH) new androidx.lifecycle.G(hh).b(IH.class);
    }

    @Override // ir.nasim.C14056hH.d
    public void B4(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        ja().Z0(item.a());
    }

    @Override // ir.nasim.C14056hH.c
    public void D2(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        if (item.a().length() <= 0) {
            ja().c1();
            return;
        }
        String strH = XY6.h(item.a());
        if (oa(strH) && ja().d1(strH)) {
            ja().a1("arbaeen_view_other_status_send");
            ja().T0(strH);
            pa(strH);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (data != null) {
                qa(data);
            }
        } else if (requestCode == 7 && resultCode == 0) {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C22868vx2.c(inflater, container, false);
        ConstraintLayout root = ia().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        ia().g.clearFocus();
        super.c7();
    }

    @Override // ir.nasim.C14056hH.b
    public void j2(C13465gH item) {
        AbstractC13042fc3.i(item, "item");
        C23381wp3.f(ia().g);
        C18802pH c18802pHA = C18802pH.INSTANCE.a();
        c18802pHA.W9(this);
        C22042ua0.A9(this, c18802pHA, false, null, 6, null);
        ia().g.clearFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        fa();
    }
}
