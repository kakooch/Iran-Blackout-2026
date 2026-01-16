package ir.nasim;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J!\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0003R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u0002090\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u0002090\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010C\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lir/nasim/ZS6;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "oa", "ja", "fa", "ha", "ia", "da", "na", "aa", "", "Lir/nasim/Be1;", "list", "", "pa", "(Ljava/util/List;)Ljava/util/List;", "Y9", "la", "ma", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "i9", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/bX6;", "c1", "Lir/nasim/Yu3;", "ca", "()Lir/nasim/bX6;", "viewModel", "d1", "ba", "()Ljava/util/List;", "Lir/nasim/zz2;", "e1", "Lir/nasim/zz2;", "_binding", "Lir/nasim/US6;", "f1", "Lir/nasim/US6;", "storyPrivacyListAdapter", "Lir/nasim/Hr5;", "g1", "Lir/nasim/Hr5;", "privacyExceptionType", "", "h1", "Ljava/util/List;", "exceptionList", "i1", "resultExceptionList", "j1", "filteredList", "Z9", "()Lir/nasim/zz2;", "binding", "k1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class ZS6 extends C22042ua0 {

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: e1, reason: from kotlin metadata */
    private C25250zz2 _binding;

    /* renamed from: f1, reason: from kotlin metadata */
    private US6 storyPrivacyListAdapter;

    /* renamed from: g1, reason: from kotlin metadata */
    private EnumC5052Hr5 privacyExceptionType;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ZS6.qa(this.a);
        }
    });

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 list = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ZS6.ka(this.a);
        }
    });

    /* renamed from: h1, reason: from kotlin metadata */
    private List exceptionList = new ArrayList();

    /* renamed from: i1, reason: from kotlin metadata */
    private List resultExceptionList = new ArrayList();

    /* renamed from: j1, reason: from kotlin metadata */
    private List filteredList = AbstractC10360bX0.m();

    /* renamed from: ir.nasim.ZS6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ZS6 a(EnumC5052Hr5 enumC5052Hr5) {
            AbstractC13042fc3.i(enumC5052Hr5, "privacyExceptionType");
            ZS6 zs6 = new ZS6();
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_PRIVACY_EXCEPTION_TYPE", enumC5052Hr5.name());
            zs6.a8(bundle);
            return zs6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5052Hr5.values().length];
            try {
                iArr[EnumC5052Hr5.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5052Hr5.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private final void Y9() {
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null) {
            Object systemService = fragmentActivityA5.getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(Z9().getRoot().getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C25250zz2 Z9() {
        C25250zz2 c25250zz2 = this._binding;
        AbstractC13042fc3.f(c25250zz2);
        return c25250zz2;
    }

    private final void aa() {
        C10366bX6 c10366bX6Ca = ca();
        EnumC5052Hr5 enumC5052Hr5 = this.privacyExceptionType;
        if (enumC5052Hr5 == null) {
            AbstractC13042fc3.y("privacyExceptionType");
            enumC5052Hr5 = null;
        }
        List listC = c10366bX6Ca.b4(enumC5052Hr5).c();
        this.exceptionList = listC;
        this.resultExceptionList.addAll(listC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List ba() {
        return (List) this.list.getValue();
    }

    private final C10366bX6 ca() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final void da() {
        FullWidthButtonPrimary fullWidthButtonPrimary = Z9().b;
        fullWidthButtonPrimary.setEnabled(false);
        la();
        fullWidthButtonPrimary.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.VS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZS6.ea(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(ZS6 zs6, View view) {
        AbstractC13042fc3.i(zs6, "this$0");
        zs6.na();
        zs6.Q7().onBackPressed();
    }

    private final void fa() {
        this.storyPrivacyListAdapter = new US6(pa(ba()), this.exceptionList, new InterfaceC14603iB2() { // from class: ir.nasim.YS6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ZS6.ga(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ga(ZS6 zs6, int i, boolean z) {
        AbstractC13042fc3.i(zs6, "this$0");
        US6 us6 = zs6.storyPrivacyListAdapter;
        if (us6 != null) {
            if (zs6.resultExceptionList.contains(Integer.valueOf(i)) && !z) {
                zs6.resultExceptionList.remove(Integer.valueOf(i));
            } else if (!zs6.resultExceptionList.contains(Integer.valueOf(i)) && z) {
                zs6.resultExceptionList.add(Integer.valueOf(i));
            }
            us6.E(zs6.resultExceptionList);
            if (!zs6.filteredList.isEmpty()) {
                EditText editText = zs6.Z9().g;
                editText.getText().clear();
                editText.clearFocus();
                us6.F(zs6.pa(zs6.ba()));
                us6.notifyDataSetChanged();
                zs6.Y9();
                zs6.filteredList = AbstractC10360bX0.m();
            }
            FullWidthButtonPrimary fullWidthButtonPrimary = zs6.Z9().b;
            if (!fullWidthButtonPrimary.isEnabled()) {
                fullWidthButtonPrimary.setEnabled(true);
                zs6.ma();
            }
            us6.notifyDataSetChanged();
        }
        return C19938rB7.a;
    }

    private final void ha() {
        RecyclerView recyclerView = Z9().d;
        recyclerView.setLayoutManager(new LinearLayoutManager(S7(), 1, false));
        recyclerView.setAdapter(this.storyPrivacyListAdapter);
    }

    private final void ia() {
        EditText editText = Z9().g;
        AbstractC13042fc3.h(editText, "searchText");
        editText.addTextChangedListener(new c());
    }

    private final void ja() {
        EnumC5052Hr5 enumC5052Hr5 = this.privacyExceptionType;
        if (enumC5052Hr5 == null) {
            AbstractC13042fc3.y("privacyExceptionType");
            enumC5052Hr5 = null;
        }
        int i = b.a[enumC5052Hr5.ordinal()];
        if (i == 1) {
            Z9().c.setText(h6(AbstractC12217eE5.story_privacy_select_exclude));
        } else {
            if (i != 2) {
                return;
            }
            Z9().c.setText(h6(AbstractC12217eE5.story_privacy_select_include));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List ka(ZS6 zs6) {
        AbstractC13042fc3.i(zs6, "this$0");
        return zs6.ca().g5();
    }

    private final void la() {
        FullWidthButtonPrimary fullWidthButtonPrimary = Z9().b;
        fullWidthButtonPrimary.setBackgroundColor(AbstractC4043Dl1.c(fullWidthButtonPrimary.getContext(), TA5.color10));
        fullWidthButtonPrimary.setTextColor(AbstractC4043Dl1.c(fullWidthButtonPrimary.getContext(), TA5.color12));
    }

    private final void ma() {
        FullWidthButtonPrimary fullWidthButtonPrimary = Z9().b;
        fullWidthButtonPrimary.setBackgroundColor(AbstractC4043Dl1.c(fullWidthButtonPrimary.getContext(), TA5.primary));
        fullWidthButtonPrimary.setTextColor(AbstractC4043Dl1.c(fullWidthButtonPrimary.getContext(), TA5.color3_2));
    }

    private final void na() {
        C10366bX6 c10366bX6Ca = ca();
        EnumC5052Hr5 enumC5052Hr5 = this.privacyExceptionType;
        if (enumC5052Hr5 == null) {
            AbstractC13042fc3.y("privacyExceptionType");
            enumC5052Hr5 = null;
        }
        c10366bX6Ca.Y5(new ZI7(enumC5052Hr5, 0, this.resultExceptionList, true, 2, null));
    }

    private final void oa() {
        EnumC5052Hr5 enumC5052Hr5 = this.privacyExceptionType;
        if (enumC5052Hr5 == null) {
            AbstractC13042fc3.y("privacyExceptionType");
            enumC5052Hr5 = null;
        }
        int i = b.a[enumC5052Hr5.ordinal()];
        if (i == 1) {
            Z9().i.setTitle(h6(AbstractC12217eE5.story_privacy_contacts_exclude));
        } else if (i == 2) {
            Z9().i.setTitle(h6(AbstractC12217eE5.story_privacy_contacts_include));
        }
        BaleToolbar baleToolbar = Z9().i;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List pa(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C3512Be1 c3512Be1 = (C3512Be1) it.next();
            if (this.resultExceptionList.contains(Integer.valueOf(c3512Be1.r()))) {
                arrayList2.add(c3512Be1);
            } else {
                arrayList.add(c3512Be1);
            }
        }
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 qa(ZS6 zs6) {
        AbstractC13042fc3.i(zs6, "this$0");
        FragmentActivity fragmentActivityQ7 = zs6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        AbstractC13042fc3.i(inflater, "inflater");
        Bundle bundleE5 = E5();
        if (bundleE5 != null && (string = bundleE5.getString("EXTRA_PRIVACY_EXCEPTION_TYPE")) != null) {
            this.privacyExceptionType = EnumC5052Hr5.valueOf(string);
        }
        aa();
        this._binding = C25250zz2.c(inflater);
        ConstraintLayout root = Z9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
        this.storyPrivacyListAdapter = null;
        ca().d6();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        ca().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        oa();
        ja();
        fa();
        ha();
        ia();
        da();
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            US6 us6 = ZS6.this.storyPrivacyListAdapter;
            if (us6 != null) {
                if (!AbstractC20762sZ6.n0(String.valueOf(editable))) {
                    ZS6 zs6 = ZS6.this;
                    List listBa = zs6.ba();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listBa) {
                        String name = ((C3512Be1) obj).getName();
                        AbstractC13042fc3.h(name, "getName(...)");
                        Locale locale = Locale.ROOT;
                        String lowerCase = name.toLowerCase(locale);
                        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = String.valueOf(editable).toLowerCase(locale);
                        AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                        if (AbstractC20762sZ6.X(lowerCase, lowerCase2, false, 2, null)) {
                            arrayList.add(obj);
                        }
                    }
                    zs6.filteredList = arrayList;
                    ZS6 zs62 = ZS6.this;
                    us6.F(zs62.pa(zs62.filteredList));
                    if (ZS6.this.filteredList.isEmpty()) {
                        ZS6.this.Z9().e.setVisibility(0);
                    } else {
                        ZS6.this.Z9().e.setVisibility(8);
                    }
                } else {
                    ZS6 zs63 = ZS6.this;
                    us6.F(zs63.pa(zs63.ba()));
                    ZS6.this.Z9().e.setVisibility(8);
                }
                us6.notifyDataSetChanged();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
