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
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0011J+\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b-\u0010.J)\u00102\u001a\u00020\u00072\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00072\u0006\u00105\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b;\u00107J\u000f\u0010<\u001a\u00020\u0007H\u0016¢\u0006\u0004\b<\u0010\u0006R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lir/nasim/ZG;", "Lir/nasim/ua0;", "Lir/nasim/hH$c;", "Lir/nasim/hH$b;", "Lir/nasim/hH$d;", "<init>", "()V", "Lir/nasim/rB7;", "ea", "da", "W9", "ka", "ja", "Y9", "", DialogEntity.COLUMN_MESSAGE, "oa", "(Ljava/lang/String;)V", "ba", "aa", "Lir/nasim/components/textfield/view/CustomInputView;", "inputView", "la", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "ga", "Landroid/content/Intent;", "data", "pa", "(Landroid/content/Intent;)V", "phoneNumber", "", "na", "(Ljava/lang/String;)Z", "number", "qa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/fH;", "item", "D2", "(Lir/nasim/fH;)V", "Lir/nasim/gH;", "j2", "(Lir/nasim/gH;)V", "B4", "c7", "Lir/nasim/rx2;", "c1", "Lir/nasim/rx2;", "_binding", "Lir/nasim/eH;", "d1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/eH;", "viewModel", "Lir/nasim/hH;", "e1", "Lir/nasim/hH;", "suggestAdapter", "Landroid/view/View$OnClickListener;", "f1", "Landroid/view/View$OnClickListener;", "contactIconClickListener", "ha", "()Lir/nasim/rx2;", "binding", "g1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ZG extends C22042ua0 implements C14056hH.c, C14056hH.b, C14056hH.d {

    /* renamed from: g1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int h1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C20405rx2 _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ZG.ra(this.a);
        }
    });

    /* renamed from: e1, reason: from kotlin metadata */
    private final C14056hH suggestAdapter = new C14056hH();

    /* renamed from: f1, reason: from kotlin metadata */
    private final View.OnClickListener contactIconClickListener = new View.OnClickListener() { // from class: ir.nasim.XG
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ZG.fa(this.a, view);
        }
    };

    /* renamed from: ir.nasim.ZG$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ZG a() {
            return new ZG();
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
            return ZG.this.new b(this.d, interfaceC20295rm1);
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
            ZG.this.ia().T0((String) this.d.a);
            ZG.this.ha().g.setText("");
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
            ZG.this.ha().e.setEnabled(AbstractC20762sZ6.n1(charSequence).length() > 0);
            if (AbstractC20762sZ6.n1(charSequence).length() > 0) {
                ZG.this.ha().e.setTextColor(C5495Jo7.a.b0());
            } else {
                ZG.this.ha().e.setTextColor(C5495Jo7.a.e0());
            }
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ CustomInputView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CustomInputView customInputView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = customInputView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ZG.this.new d(this.d, interfaceC20295rm1);
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
            NestedScrollView nestedScrollView = ZG.this.ha().h;
            AbstractC13042fc3.h(nestedScrollView, "nestedScrollView");
            AbstractC4808Gq4.a(nestedScrollView, this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void W9() {
        BaleButton baleButton = ha().e;
        ha().e.setEnabled(false);
        ha().e.setTextColor(C5495Jo7.a.e0());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.VG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZG.X9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(ZG zg, View view) {
        AbstractC13042fc3.i(zg, "this$0");
        C12889fL5 c12889fL5 = new C12889fL5();
        String string = AbstractC20762sZ6.n1(zg.ha().g.getText()).toString();
        c12889fL5.a = string;
        if (string.length() <= 0) {
            zg.ja();
            return;
        }
        String strH = XY6.h((String) c12889fL5.a);
        c12889fL5.a = strH;
        if (!zg.na(strH)) {
            zg.ja();
            return;
        }
        if (!zg.ia().d1((String) c12889fL5.a)) {
            zg.ka();
            return;
        }
        zg.ia().a1("arbaeen_last_viewer_send");
        zg.oa((String) c12889fL5.a);
        C23381wp3.f(zg.ha().g);
        zg.ha().g.clearFocus();
        AbstractC10533bm0.d(AbstractC9773aX7.a(zg.ia()), null, null, zg.new b(c12889fL5, null), 3, null);
    }

    private final void Y9() {
        final CustomInputView customInputView = ha().g;
        AbstractC13042fc3.f(customInputView);
        customInputView.b(new Q45(customInputView));
        customInputView.b(new c());
        customInputView.q(new View.OnClickListener() { // from class: ir.nasim.TG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZG.Z9(this.a, customInputView, view);
            }
        });
        customInputView.setDrawableEndFirstClickListener(this.contactIconClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ZG zg, CustomInputView customInputView, View view) {
        AbstractC13042fc3.i(zg, "this$0");
        AbstractC13042fc3.i(customInputView, "$this_with");
        AbstractC13042fc3.g(view, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) view;
        editText.setSelection(editText.length());
        NestedScrollView nestedScrollView = zg.ha().h;
        AbstractC13042fc3.h(nestedScrollView, "nestedScrollView");
        AbstractC4808Gq4.a(nestedScrollView, customInputView);
    }

    private final void aa() {
        ha().j.setText(i6(AbstractC12217eE5.powered_by, AbstractC5969Lp4.e().S().q0()));
    }

    private final void ba() {
        RecyclerView recyclerView = ha().d;
        ia().X0().j(p6(), new C9621aH(new UA2() { // from class: ir.nasim.UG
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ZG.ca(this.a, (ArrayList) obj);
            }
        }));
        recyclerView.setAdapter(this.suggestAdapter);
        ia().c1();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        this.suggestAdapter.A(this);
        this.suggestAdapter.B(this);
        this.suggestAdapter.C(this);
        CustomInputView customInputView = ha().g;
        AbstractC13042fc3.h(customInputView, "mobileInput");
        la(customInputView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(ZG zg, ArrayList arrayList) {
        AbstractC13042fc3.i(zg, "this$0");
        zg.suggestAdapter.z(arrayList);
        zg.suggestAdapter.notifyDataSetChanged();
        if (arrayList.size() > 0) {
            zg.ha().k.setVisibility(0);
        } else {
            zg.ha().k.setVisibility(8);
        }
        return C19938rB7.a;
    }

    private final void da() {
        BaleToolbar baleToolbar = ha().l;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void ea() {
        W9();
        Y9();
        da();
        ba();
        aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(ZG zg, View view) {
        AbstractC13042fc3.i(zg, "this$0");
        zg.ha().g.clearFocus();
        zg.ga();
        zg.ia().a1("arbaeen_last_viewer_contact_picker_click");
    }

    private final void ga() {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (AbstractC4043Dl1.a(fragmentActivityQ7, "android.permission.READ_CONTACTS") != 0) {
            C21753u45.R0(C21753u45.a, this, 7, Integer.valueOf(AbstractC12217eE5.contact_permission_desctiption_arbaeen), null, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 24, null);
        } else {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20405rx2 ha() {
        C20405rx2 c20405rx2 = this._binding;
        AbstractC13042fc3.f(c20405rx2);
        return c20405rx2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12238eH ia() {
        return (C12238eH) this.viewModel.getValue();
    }

    private final void ja() {
        Toast.makeText(C5721Ko.a.d(), AbstractC12217eE5.arbaeen_view_message_digit_error_phone_number, 1).show();
    }

    private final void ka() {
        Toast.makeText(C5721Ko.a.d(), AbstractC12217eE5.arbaeen_view_message_sim_error_phone_number, 1).show();
    }

    private final void la(final CustomInputView inputView) {
        inputView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.YG
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ZG.ma(this.a, inputView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(ZG zg, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(zg, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputView");
        if (!z) {
            customInputView.setHintTextColor(AbstractC4043Dl1.c(zg.S7(), TA5.color8));
        } else {
            AbstractC10533bm0.d(AbstractC19224pz3.a(zg), null, null, zg.new d(customInputView, null), 3, null);
            customInputView.setHintTextColor(AbstractC4043Dl1.c(zg.S7(), TA5.c11));
        }
    }

    private final boolean na(String phoneNumber) {
        return phoneNumber.length() == 11 || phoneNumber.length() == 10;
    }

    private final void oa(String message) {
        String strP0;
        if (message.length() == 0) {
            strP0 = AbstractC5969Lp4.e().S().p0();
        } else {
            strP0 = AbstractC5969Lp4.e().S().p0() + message + Separators.POUND;
        }
        RootActivity.Companion companion = RootActivity.INSTANCE;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        companion.e(contextS7, strP0);
    }

    private final void pa(Intent data) {
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
                        qa(string);
                    } while (cursor2.moveToNext());
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(cursor, null);
            } finally {
            }
        } catch (Exception e) {
            if (ZG.class.isAnonymousClass()) {
                name = ZG.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = ZG.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "pickContact", e);
        }
    }

    private final void qa(String number) {
        if (!ia().d1(number)) {
            ha().g.setText("");
            Toast.makeText(G5(), AbstractC12217eE5.arbaeen_view_message_sim_error_phone_number, 1).show();
        } else {
            ha().g.setText(new C20644sM5("^(\\+989|989|00989|9)").l(new C20644sM5("[^\\d]").k(number, ""), "09"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12238eH ra(ZG zg) {
        AbstractC13042fc3.i(zg, "this$0");
        return (C12238eH) new androidx.lifecycle.G(zg).b(C12238eH.class);
    }

    @Override // ir.nasim.C14056hH.d
    public void B4(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        ia().Z0(item.a());
    }

    @Override // ir.nasim.C14056hH.c
    public void D2(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        if (item.a().length() <= 0) {
            ia().c1();
            return;
        }
        String strH = XY6.h(item.a());
        if (na(strH) && ia().d1(strH)) {
            ia().a1("arbaeen_view_other_status_send");
            ia().T0(strH);
            oa(strH);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (data != null) {
                pa(data);
            }
        } else if (requestCode == 7 && resultCode == 0) {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C20405rx2.c(inflater, container, false);
        ConstraintLayout root = ha().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        ha().g.clearFocus();
        super.c7();
    }

    @Override // ir.nasim.C14056hH.b
    public void j2(C13465gH item) {
        AbstractC13042fc3.i(item, "item");
        C23381wp3.f(ha().g);
        C11595dH c11595dHA = C11595dH.INSTANCE.a();
        c11595dHA.W9(this);
        C22042ua0.A9(this, c11595dHA, false, null, 6, null);
        ha().g.clearFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ea();
    }
}
