package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.contact.ui.add.widget.EditTextWithPrefix;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 L2\u00020\u0001:\u0001MB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0013\u0010\n\u001a\u00020\u0007*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u0007*\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000fJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0003J\u0013\u0010!\u001a\u00020\u0007*\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J+\u0010.\u001a\u00020-2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b.\u0010/J!\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b1\u00102J)\u00107\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00182\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108R\u001b\u0010=\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lir/nasim/CH4;", "Lir/nasim/ua0;", "<init>", "()V", "", "na", "()Z", "Lir/nasim/rB7;", "ma", "Lir/nasim/lx2;", "za", "(Lir/nasim/lx2;)V", "", "countryCode", "da", "(Ljava/lang/String;)V", "ua", "sa", "ea", "pa", "ba", "ka", "()Ljava/lang/String;", "ia", "", "userId", "qa", "(I)V", "ra", "phoneNumber", "Ca", "oa", "fa", "ta", "Landroid/widget/EditText;", "editText", "Landroid/text/TextWatcher;", "ja", "(Landroid/widget/EditText;)Landroid/text/TextWatcher;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "h1", "Lir/nasim/bW7;", "ha", "()Lir/nasim/lx2;", "binding", "Lir/nasim/GH4;", "i1", "Lir/nasim/Yu3;", "la", "()Lir/nasim/GH4;", "viewModel", "Lir/nasim/TP;", "j1", "Lir/nasim/TP;", "ga", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "k1", "a", "contact_release"}, k = 1, mv = {2, 0, 0})
@InterfaceC14067hI1
/* loaded from: classes4.dex */
public final class CH4 extends AbstractC17176mX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    public TP authNavigator;
    static final /* synthetic */ InterfaceC5239Im3[] l1 = {AbstractC10882cM5.i(new C25226zw5(CH4.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentAddContactBinding;", 0))};
    public static final int m1 = 8;

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C16841lx2.a(fragment.V7());
        }
    }

    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public CH4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(GH4.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(CH4 ch4, View view) {
        AbstractC13042fc3.i(ch4, "this$0");
        ch4.sa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ba(C16841lx2 c16841lx2, TextView textView, int i, KeyEvent keyEvent) {
        AbstractC13042fc3.i(c16841lx2, "$this_setupPhoneNumberInputs");
        if (i != 6) {
            return false;
        }
        c16841lx2.b.callOnClick();
        return true;
    }

    private final void Ca(final String phoneNumber) {
        String strH6 = h6(AbstractC12217eE5.alert_invite_phone_text);
        AbstractC13042fc3.h(strH6, "getString(...)");
        String strM = AbstractC20153rZ6.M(strH6, "{0}", XY6.v(phoneNumber), false, 4, null);
        String strF = C5735Kp4.w().f();
        AbstractC13042fc3.h(strF, "getAppName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{appName}", strF, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        new AlertDialog.a(contextS7).i(strM2).l(h6(AbstractC12217eE5.invite), new DialogInterface.OnClickListener() { // from class: ir.nasim.AH4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CH4.Da(this.a, phoneNumber, dialogInterface, i);
            }
        }).k(h6(AbstractC12217eE5.dialog_cancel), new DialogInterface.OnClickListener() { // from class: ir.nasim.BH4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CH4.Ea(dialogInterface, i);
            }
        }).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(CH4 ch4, String str, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(ch4, "this$0");
        AbstractC13042fc3.i(str, "$phoneNumber");
        ch4.oa(str);
    }

    private final void ba() {
        CharSequence charSequenceN1;
        String string;
        String strE;
        final String strB;
        Editable text = ha().f.getText();
        if (text == null || (charSequenceN1 = AbstractC20762sZ6.n1(text)) == null || (string = charSequenceN1.toString()) == null) {
            return;
        }
        X75 x75 = X75.a;
        String strB2 = GY6.b(ka());
        C13788gp1 c13788gp1A1 = la().a1();
        if (c13788gp1A1 == null || (strE = c13788gp1A1.e()) == null) {
            strE = "IR";
        }
        Long lA = x75.a(strB2, strE);
        if (lA == null || (strB = lA.toString()) == null) {
            strB = GY6.b(ia() + ka());
        }
        Long lQ = AbstractC19562qZ6.q(strB);
        if (lQ != null) {
            la().U0(string, lQ.longValue(), new UA2() { // from class: ir.nasim.zH4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return CH4.ca(this.a, strB, (C9475a16) obj);
                }
            });
        } else {
            Ca(strB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(CH4 ch4, String str, C9475a16 c9475a16) {
        AbstractC13042fc3.i(ch4, "this$0");
        AbstractC13042fc3.i(str, "$phoneNumber");
        Object objL = c9475a16.l();
        if (C9475a16.j(objL)) {
            Integer num = (Integer) objL;
            if (num != null) {
                ch4.qa(num.intValue());
            } else {
                ch4.Ca(str);
            }
        }
        if (C9475a16.e(objL) != null) {
            ch4.fa();
        }
        return C19938rB7.a;
    }

    private final void da(String countryCode) {
        String strA;
        String strC;
        C16841lx2 c16841lx2Ha = ha();
        C13788gp1 c13788gp1Z0 = la().Z0(GY6.b(countryCode));
        c16841lx2Ha.g.setFormat(c13788gp1Z0 != null ? c13788gp1Z0.d() : null);
        EditTextWithPrefix editTextWithPrefix = c16841lx2Ha.e;
        String str = "";
        if (c13788gp1Z0 == null || (strA = c13788gp1Z0.a()) == null) {
            strA = "";
        }
        editTextWithPrefix.setText(strA);
        TextView textView = c16841lx2Ha.c;
        if (c13788gp1Z0 != null && (strC = c13788gp1Z0.c()) != null) {
            str = strC;
        }
        textView.setText(str);
        la().c1(c13788gp1Z0);
    }

    private final boolean ea() {
        C16841lx2 c16841lx2Ha = ha();
        Editable text = c16841lx2Ha.g.getText();
        boolean z = !(text == null || AbstractC20762sZ6.n0(text));
        c16841lx2Ha.j.setStrokeWidth(C22078ud6.a(z ? 0.0f : 1.0f));
        if (!z) {
            c16841lx2Ha.g.requestFocus();
        }
        C19938rB7 c19938rB7 = C19938rB7.a;
        boolean z2 = z & true;
        boolean zPa = pa();
        c16841lx2Ha.i.setStrokeWidth(C22078ud6.a(zPa ? 0.0f : 1.0f));
        TextView textView = c16841lx2Ha.h;
        AbstractC13042fc3.h(textView, "nameHelper");
        textView.setVisibility(true ^ zPa ? 0 : 8);
        if (!zPa) {
            c16841lx2Ha.f.requestFocus();
        }
        return z2 & zPa;
    }

    private final void fa() {
        String strH6 = h6(AbstractC12217eE5.add_contact_request_failed);
        AbstractC13042fc3.h(strH6, "getString(...)");
        Toast.makeText(S7(), strH6, 0).show();
    }

    private final C16841lx2 ha() {
        Object objA = this.binding.a(this, l1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C16841lx2) objA;
    }

    private final String ia() {
        return String.valueOf(ha().e.getText());
    }

    private final TextWatcher ja(EditText editText) {
        return new b(editText);
    }

    private final String ka() {
        return AbstractC20153rZ6.M(String.valueOf(ha().g.getText()), Separators.SP, "", false, 4, null);
    }

    private final GH4 la() {
        return (GH4) this.viewModel.getValue();
    }

    private final void ma() {
        BaleToolbar baleToolbar = ha().m;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final boolean na() {
        C16841lx2 c16841lx2Ha = ha();
        ma();
        ta(c16841lx2Ha);
        ua(c16841lx2Ha);
        za(c16841lx2Ha);
        return c16841lx2Ha.f.requestFocus();
    }

    private final void oa(String phoneNumber) {
        String strH6 = h6(AbstractC12217eE5.invite_message);
        AbstractC13042fc3.h(strH6, "getString(...)");
        String strM = AbstractC20153rZ6.M(strH6, "{inviteUrl}", la().X0(), false, 4, null);
        String strF = C5735Kp4.w().f();
        AbstractC13042fc3.h(strF, "getAppName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{appName}", strF, false, 4, null);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", strM2);
        n8(intent);
    }

    private final boolean pa() {
        Editable text = ha().f.getText();
        String string = text != null ? text.toString() : null;
        return !(string == null || AbstractC20762sZ6.n0(string));
    }

    private final void qa(int userId) {
        C19406qI3.a(InterfaceC6118Mg1.a.a(), "Add new contact " + userId, new Object[0]);
        ra(userId);
    }

    private final void ra(int userId) {
        C22042ua0.m9(this, this, false, 2, null);
        C11458d25 c11458d25E = C11458d25.E(userId);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C18987pb3.x1(C18987pb3.a, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    private final void sa() {
        TP tpGa = ga();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        startActivityForResult(tpGa.e(contextS7, null), 789546213);
    }

    private final void ta(C16841lx2 c16841lx2) {
        c16841lx2.k.setTypeface(C6011Lu2.i());
        c16841lx2.f.setTypeface(C6011Lu2.k());
        c16841lx2.h.setTypeface(C6011Lu2.k());
        c16841lx2.l.setTypeface(C6011Lu2.i());
        c16841lx2.c.setTypeface(C6011Lu2.k());
        c16841lx2.g.setTypeface(C6011Lu2.i());
        c16841lx2.e.setTypeface(C6011Lu2.i());
        c16841lx2.b.setTypeface(C6011Lu2.i());
    }

    private final void ua(final C16841lx2 c16841lx2) {
        c16841lx2.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CH4.wa(c16841lx2, view);
            }
        });
        c16841lx2.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CH4.xa(c16841lx2, view);
            }
        });
        c16841lx2.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CH4.ya(this.a, view);
            }
        });
        c16841lx2.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CH4.va(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(CH4 ch4, View view) {
        AbstractC13042fc3.i(ch4, "this$0");
        if (ch4.ea()) {
            Context contextS7 = ch4.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            if (C4100Dr4.a(contextS7)) {
                ch4.ba();
                return;
            }
            FragmentActivity fragmentActivityQ7 = ch4.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            C24398yZ.c(fragmentActivityQ7, ch4).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(C16841lx2 c16841lx2, View view) {
        AbstractC13042fc3.i(c16841lx2, "$this_setupButtons");
        if (c16841lx2.f.isFocused()) {
            return;
        }
        c16841lx2.f.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(C16841lx2 c16841lx2, View view) {
        AbstractC13042fc3.i(c16841lx2, "$this_setupButtons");
        if (c16841lx2.g.isFocused()) {
            return;
        }
        c16841lx2.g.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(CH4 ch4, View view) {
        AbstractC13042fc3.i(ch4, "this$0");
        ch4.sa();
    }

    private final void za(final C16841lx2 c16841lx2) {
        EditText editText = c16841lx2.f;
        AbstractC13042fc3.f(editText);
        editText.addTextChangedListener(ja(editText));
        EditTextWithPrefix editTextWithPrefix = c16841lx2.e;
        AbstractC13042fc3.f(editTextWithPrefix);
        editTextWithPrefix.addTextChangedListener(ja(editTextWithPrefix));
        editTextWithPrefix.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CH4.Aa(this.a, view);
            }
        });
        c16841lx2.g.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.yH4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CH4.Ba(c16841lx2, textView, i, keyEvent);
            }
        });
        da("98");
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        if (requestCode != 789546213) {
            super.H6(requestCode, resultCode, data);
            return;
        }
        String stringExtra = data != null ? data.getStringExtra("country_code") : null;
        if (stringExtra != null) {
            da(stringExtra);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ScrollView root = C16841lx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final TP ga() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(DialogInterface dialogInterface, int i) {
    }

    public static final class b implements TextWatcher {
        private final WeakReference a;
        private int b;
        private int c;

        b(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText = (EditText) this.a.get();
            if (editText == null || !JF5.g()) {
                return;
            }
            editText.removeTextChangedListener(this);
            editText.setText(XY6.e(String.valueOf(editable)));
            editText.addTextChangedListener(this);
            editText.setSelection(this.b + this.c);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.b = i;
            this.c = i3;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
