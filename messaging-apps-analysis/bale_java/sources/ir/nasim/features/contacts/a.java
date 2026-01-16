package ir.nasim.features.contacts;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.A90;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC21435tf0;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.BC5;
import ir.nasim.C13708gh1;
import ir.nasim.C17655nK7;
import ir.nasim.C19024pf0;
import ir.nasim.C21231tK7;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C3512Be1;
import ir.nasim.C5495Jo7;
import ir.nasim.DJ;
import ir.nasim.ED1;
import ir.nasim.InterfaceC22483vJ4;
import ir.nasim.ZN2;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 [2\u00020\u0001:\u0002\\]B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0003J1\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020)0(2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$2\u0006\u0010'\u001a\u00020&H\u0014¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R*\u0010<\u001a\u0016\u0012\u0004\u0012\u000208\u0018\u000107j\n\u0012\u0004\u0012\u000208\u0018\u0001`98\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010R\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010Z\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006^"}, d2 = {"Lir/nasim/features/contacts/a;", "Lir/nasim/A90;", "<init>", "()V", "Landroid/view/View;", "res", "Lir/nasim/rB7;", "Ma", "(Landroid/view/View;)V", "Landroid/text/Editable;", "editable", "Ga", "(Landroid/text/Editable;)V", "", "force", "Fa", "(Z)V", "Lir/nasim/Be1;", "contact", "Ja", "(Lir/nasim/Be1;)V", "Ha", "Oa", "Lir/nasim/features/contacts/a$b;", "listener", "Ka", "(Lir/nasim/features/contacts/a$b;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "h7", "Lir/nasim/pf0;", "displayList", "Landroid/content/Context;", "context", "Lir/nasim/tf0;", "Lir/nasim/df1;", "ia", "(Lir/nasim/pf0;Landroid/content/Context;)Lir/nasim/tf0;", "Landroid/widget/EditText;", "r1", "Landroid/widget/EditText;", "searchField", "Landroid/text/TextWatcher;", "s1", "Landroid/text/TextWatcher;", "textWatcher", "t1", "Z", "isDoneButtonEnable", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "u1", "Ljava/util/ArrayList;", "userIdList", "v1", "Lir/nasim/features/contacts/a$b;", "onContactPickerListener", "Lir/nasim/ZN2;", "w1", "Lir/nasim/ZN2;", "groupType", "Lir/nasim/components/appbar/view/BaleToolbar;", "x1", "Lir/nasim/components/appbar/view/BaleToolbar;", "Ia", "()Lir/nasim/components/appbar/view/BaleToolbar;", "La", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "toolbar", "y1", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "type", "", "z1", "Ljava/lang/String;", "getSingleSelectionContactName", "()Ljava/lang/String;", "setSingleSelectionContactName", "(Ljava/lang/String;)V", "singleSelectionContactName", "A1", "b", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class a extends A90 {

    /* renamed from: A1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int B1 = 8;
    private static int C1;
    private static boolean D1;
    private static boolean E1;

    /* renamed from: r1, reason: from kotlin metadata */
    private EditText searchField;

    /* renamed from: s1, reason: from kotlin metadata */
    private TextWatcher textWatcher;

    /* renamed from: t1, reason: from kotlin metadata */
    private boolean isDoneButtonEnable;

    /* renamed from: u1, reason: from kotlin metadata */
    private ArrayList userIdList;

    /* renamed from: v1, reason: from kotlin metadata */
    private b onContactPickerListener;

    /* renamed from: w1, reason: from kotlin metadata */
    private ZN2 groupType;

    /* renamed from: x1, reason: from kotlin metadata */
    public BaleToolbar toolbar;

    /* renamed from: y1, reason: from kotlin metadata */
    private Integer type;

    /* renamed from: z1, reason: from kotlin metadata */
    private String singleSelectionContactName;

    /* renamed from: ir.nasim.features.contacts.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final a a(int i, boolean z, String str, boolean z2, boolean z3, int i2) {
            a.C1 = i;
            a.D1 = z2;
            a.E1 = z3;
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putInt("group_id", i);
            bundle.putInt("ir.nasim.features.contacts.contact_title", i2);
            bundle.putBoolean("is_group_admin", z);
            if (str == null) {
                bundle.putString("group_type", "GROUP");
            } else {
                bundle.putString("group_type", str);
            }
            aVar.a8(bundle);
            AbstractC5969Lp4.d().R();
            return aVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void D(ArrayList arrayList, String str);
    }

    public static final class c implements InterfaceC22483vJ4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(C3512Be1 c3512Be1) {
            AbstractC13042fc3.i(c3512Be1, "item");
            a.this.Ja(c3512Be1);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(C3512Be1 c3512Be1) {
            AbstractC13042fc3.i(c3512Be1, "item");
            return false;
        }
    }

    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            a.this.Ga(editable);
            String string = editable.toString();
            int length = string.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = AbstractC13042fc3.k(string.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String string2 = string.subSequence(i, length + 1).toString();
            while (string2.length() > 0 && string2.charAt(0) == '!') {
                string2 = string2.substring(1);
                AbstractC13042fc3.h(string2, "substring(...)");
            }
            a.this.ra(string2);
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

    public a() {
        super(true, D1, C1);
        this.type = 0;
        this.singleSelectionContactName = "";
    }

    private final void Fa(boolean force) {
        if (!force) {
            if (this.isDoneButtonEnable == (ua() > 0)) {
                return;
            }
        }
        this.isDoneButtonEnable = ua() > 0;
        Integer num = this.type;
        if (num != null && num.intValue() == 2002) {
            Ia().getMenu().findItem(BC5.done).setEnabled(this.isDoneButtonEnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        ir.nasim.AbstractC13042fc3.f(r4);
        ya(r4.intValue());
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Ga(android.text.Editable r10) {
        /*
            r9 = this;
            java.lang.Integer[] r0 = r9.ta()
            int r1 = r10.length()
            java.lang.Class<ir.nasim.nK7> r2 = ir.nasim.C17655nK7.class
            r3 = 0
            java.lang.Object[] r1 = r10.getSpans(r3, r1, r2)
            ir.nasim.nK7[] r1 = (ir.nasim.C17655nK7[]) r1
            java.util.Iterator r0 = ir.nasim.DJ.a(r0)
            r2 = r3
        L16:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L57
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.util.Iterator r5 = ir.nasim.DJ.a(r1)
        L26:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L4b
            java.lang.Object r6 = r5.next()
            ir.nasim.nK7 r6 = (ir.nasim.C17655nK7) r6
            ir.nasim.tK7 r7 = r6.a
            int r7 = r7.o()
            if (r4 != 0) goto L3b
            goto L26
        L3b:
            int r8 = r4.intValue()
            if (r7 != r8) goto L26
            int r5 = r10.getSpanStart(r6)
            int r6 = r10.getSpanEnd(r6)
            if (r5 != r6) goto L16
        L4b:
            ir.nasim.AbstractC13042fc3.f(r4)
            int r2 = r4.intValue()
            r9.ya(r2)
            r2 = 1
            goto L16
        L57:
            if (r2 == 0) goto L63
            r9.Fa(r3)
            ir.nasim.tf0 r10 = r9.ba()
            r10.notifyDataSetChanged()
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.contacts.a.Ga(android.text.Editable):void");
    }

    private final void Ha() {
        C1 = R7().getInt("group_id");
        Integer[] numArrTa = ta();
        this.userIdList = new ArrayList();
        Iterator itA = DJ.a(numArrTa);
        while (itA.hasNext()) {
            Integer num = (Integer) itA.next();
            ArrayList arrayList = this.userIdList;
            if (arrayList != null) {
                arrayList.add(num);
            }
        }
        C23381wp3.f(this.searchField);
        b bVar = this.onContactPickerListener;
        if (bVar != null) {
            bVar.D(this.userIdList, this.singleSelectionContactName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(C3512Be1 contact) {
        if (va(contact.r())) {
            ya(contact.r());
        } else {
            this.singleSelectionContactName = contact.getName();
            xa(contact.r());
        }
        if (!D1) {
            Ha();
        } else {
            Fa(false);
            Oa();
        }
    }

    private final void Ma(View res) {
        String strH6;
        La((BaleToolbar) res.findViewById(BC5.add_group_member_toolbar));
        BaleToolbar baleToolbarIa = Ia();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbarIa, fragmentActivityQ7, true, false, 4, null);
        Fa(true);
        Integer num = this.type;
        if (num != null && num.intValue() == 2002) {
            Ia().y(AbstractC15226jD5.done_menu);
            strH6 = h6(AbstractC12217eE5.group_add_title);
        } else {
            strH6 = (num != null && num.intValue() == 2001) ? h6(AbstractC12217eE5.select_contact) : (num != null && num.intValue() == 2003) ? h6(AbstractC12217eE5.contact_picker_group_add_admin) : "";
        }
        Ia().setTitle(strH6);
        Ia().setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.yY
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return ir.nasim.features.contacts.a.Na(this.a, menuItem);
            }
        });
        Fa(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Na(a aVar, MenuItem menuItem) {
        AbstractC13042fc3.i(aVar, "this$0");
        if (menuItem.getItemId() != BC5.done) {
            return false;
        }
        if (aVar.ua() <= 0) {
            return true;
        }
        aVar.Ha();
        return true;
    }

    private final void Oa() {
        Integer[] numArrTa = ta();
        String str = "";
        for (int i = 0; i < numArrTa.length; i++) {
            str = str + "!";
        }
        SpannableString spannableString = new SpannableString(str);
        int length = numArrTa.length;
        for (int i2 = 0; i2 < length; i2++) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(numArrTa[i2].intValue());
            if (c21231tK7 != null) {
                spannableString.setSpan(new C17655nK7(c21231tK7, C22078ud6.a(200.0f)), i2, i2 + 1, 17);
            }
        }
        EditText editText = this.searchField;
        if (editText != null) {
            editText.removeTextChangedListener(this.textWatcher);
        }
        EditText editText2 = this.searchField;
        if (editText2 != null) {
            editText2.setText(spannableString);
        }
        EditText editText3 = this.searchField;
        if (editText3 != null) {
            editText3.setSelection(spannableString.length());
        }
        EditText editText4 = this.searchField;
        if (editText4 != null) {
            editText4.addTextChangedListener(this.textWatcher);
        }
        ra("");
        ba().notifyDataSetChanged();
    }

    public final BaleToolbar Ia() {
        BaleToolbar baleToolbar = this.toolbar;
        if (baleToolbar != null) {
            return baleToolbar;
        }
        AbstractC13042fc3.y("toolbar");
        return null;
    }

    public final void Ka(b listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onContactPickerListener = listener;
    }

    public final void La(BaleToolbar baleToolbar) {
        AbstractC13042fc3.i(baleToolbar, "<set-?>");
        this.toolbar = baleToolbar;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        String string = R7().getString("group_type", "GROUP");
        AbstractC13042fc3.h(string, "getString(...)");
        this.groupType = ZN2.valueOf(string);
        Bundle bundleE5 = E5();
        this.type = bundleE5 != null ? Integer.valueOf(bundleE5.getInt("ir.nasim.features.contacts.contact_title", 2002)) : null;
        View viewWa = wa(AbstractC12208eD5.fragment_create_group_participants, inflater, container);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewWa.setBackgroundColor(c5495Jo7.f0());
        View viewFindViewById = viewWa.findViewById(BC5.searchField);
        AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById;
        this.searchField = editText;
        if (editText != null) {
            editText.setTextColor(c5495Jo7.g0());
        }
        EditText editText2 = this.searchField;
        if (editText2 != null) {
            editText2.setHintTextColor(c5495Jo7.n0());
        }
        this.textWatcher = new d();
        AbstractC13042fc3.f(viewWa);
        Ma(viewWa);
        return viewWa;
    }

    @Override // ir.nasim.AV1, ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        EditText editText = this.searchField;
        if (editText != null) {
            editText.addTextChangedListener(this.textWatcher);
        }
    }

    @Override // ir.nasim.AV1
    protected AbstractC21435tf0 ia(C19024pf0 displayList, Context context) {
        AbstractC13042fc3.i(displayList, "displayList");
        AbstractC13042fc3.i(context, "context");
        return new C13708gh1(displayList, context, D1, C1, new c(), E1);
    }
}
