package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001AB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\rJ+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0003R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00108\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082D¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lir/nasim/TS6;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ga", "fa", "ja", "wa", "va", "Lir/nasim/Hr5;", "exceptionType", "sa", "(Lir/nasim/Hr5;)V", "", "enabled", "ia", "(Z)V", "ha", "ta", "ca", "privacyExceptionType", "ea", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "i9", "T6", "Lir/nasim/bX6;", "c1", "Lir/nasim/Yu3;", "da", "()Lir/nasim/bX6;", "viewModel", "Lir/nasim/lm1;", "d1", "ba", "()Lir/nasim/lm1;", "contextThemeWrapper", "Lir/nasim/yz2;", "e1", "Lir/nasim/yz2;", "_binding", "", "Lir/nasim/ZI7;", "f1", "Ljava/util/List;", "userPrivacyConfigList", "", "g1", TokenNames.F, "iconRtlRotationDegree", "aa", "()Lir/nasim/yz2;", "binding", "h1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class TS6 extends C22042ua0 {

    /* renamed from: h1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i1 = 8;

    /* renamed from: e1, reason: from kotlin metadata */
    private C24656yz2 _binding;

    /* renamed from: f1, reason: from kotlin metadata */
    private List userPrivacyConfigList;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.IS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return TS6.xa(this.a);
        }
    });

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contextThemeWrapper = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.KS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return TS6.Z9(this.a);
        }
    });

    /* renamed from: g1, reason: from kotlin metadata */
    private final float iconRtlRotationDegree = 180.0f;

    /* renamed from: ir.nasim.TS6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final TS6 a() {
            return new TS6();
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
                iArr[EnumC5052Hr5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5052Hr5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5052Hr5.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class c implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16731lm1 Z9(TS6 ts6) {
        AbstractC13042fc3.i(ts6, "this$0");
        return new C16731lm1(ts6.S7(), AbstractC23035wE5.Theme_Bale_Base);
    }

    private final C24656yz2 aa() {
        C24656yz2 c24656yz2 = this._binding;
        AbstractC13042fc3.f(c24656yz2);
        return c24656yz2;
    }

    private final C16731lm1 ba() {
        return (C16731lm1) this.contextThemeWrapper.getValue();
    }

    private final void ca() {
        da().J4();
    }

    private final C10366bX6 da() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final void ea(EnumC5052Hr5 privacyExceptionType) {
        sa(privacyExceptionType);
        da().Y5(new ZI7(privacyExceptionType, 0, da().b4(privacyExceptionType).c(), true, 2, null));
    }

    private final void fa() {
        if (JF5.g()) {
            return;
        }
        aa().c.setRotationY(this.iconRtlRotationDegree);
        aa().b.setRotationY(this.iconRtlRotationDegree);
    }

    private final void ga() {
        BaleToolbar baleToolbar = aa().q;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void ha() {
        RadioButton radioButton = aa().h;
        if (radioButton.isChecked()) {
            radioButton.setChecked(false);
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        radioButton.setTextColor(c5495Jo7.g());
        RadioButton radioButton2 = aa().i;
        if (radioButton2.isChecked()) {
            radioButton2.setChecked(false);
        }
        radioButton2.setTextColor(c5495Jo7.g());
        RadioButton radioButton3 = aa().j;
        if (radioButton3.isChecked()) {
            radioButton3.setChecked(false);
        }
        radioButton3.setTextColor(c5495Jo7.g());
    }

    private final void ia(boolean enabled) {
        aa().h.setEnabled(enabled);
        aa().i.setEnabled(enabled);
        aa().j.setEnabled(enabled);
        aa().b.setEnabled(enabled);
        aa().c.setEnabled(enabled);
    }

    private final void ja() {
        aa().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.la(this.a, view);
            }
        });
        aa().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.ma(this.a, view);
            }
        });
        aa().h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.na(this.a, view);
            }
        });
        aa().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.oa(this.a, view);
            }
        });
        aa().j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.pa(this.a, view);
            }
        });
        aa().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.qa(this.a, view);
            }
        });
        aa().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.ra(this.a, view);
            }
        });
        aa().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.SS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TS6.ka(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        ts6.aa().h.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        C22042ua0.A9(ts6, ZS6.INSTANCE.a(EnumC5052Hr5.b), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        C22042ua0.A9(ts6, ZS6.INSTANCE.a(EnumC5052Hr5.c), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        ts6.ea(EnumC5052Hr5.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        if (AbstractC13042fc3.d(ts6.aa().l.getText(), ts6.h6(AbstractC12217eE5.story_privacy_contacts_exclude_subtitle))) {
            ts6.aa().b.performClick();
            ts6.aa().i.setChecked(false);
            return;
        }
        List list = ts6.userPrivacyConfigList;
        if (list == null || list.isEmpty()) {
            return;
        }
        ts6.ea(EnumC5052Hr5.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        if (AbstractC13042fc3.d(ts6.aa().m.getText(), ts6.h6(AbstractC12217eE5.story_privacy_contacts_include_subtitle))) {
            ts6.aa().c.performClick();
            ts6.aa().j.setChecked(false);
            return;
        }
        List list = ts6.userPrivacyConfigList;
        if (list == null || list.isEmpty()) {
            return;
        }
        ts6.ea(EnumC5052Hr5.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        if (AbstractC13042fc3.d(ts6.aa().l.getText(), ts6.h6(AbstractC12217eE5.story_privacy_contacts_exclude_subtitle))) {
            ts6.aa().b.performClick();
        } else {
            ts6.aa().i.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(TS6 ts6, View view) {
        AbstractC13042fc3.i(ts6, "this$0");
        if (AbstractC13042fc3.d(ts6.aa().m.getText(), ts6.h6(AbstractC12217eE5.story_privacy_contacts_include_subtitle))) {
            ts6.aa().c.performClick();
        } else {
            ts6.aa().j.performClick();
        }
    }

    private final void sa(EnumC5052Hr5 exceptionType) {
        ha();
        int i = b.a[exceptionType.ordinal()];
        if (i == 1) {
            aa().h.setChecked(true);
            aa().h.setTextColor(OY0.b(ba(), AbstractC21139tA5.colorPrimary));
        } else if (i == 2) {
            aa().i.setChecked(true);
            aa().i.setTextColor(OY0.b(ba(), AbstractC21139tA5.colorPrimary));
        } else {
            if (i != 3) {
                return;
            }
            aa().j.setChecked(true);
            aa().j.setTextColor(OY0.b(ba(), AbstractC21139tA5.colorPrimary));
        }
    }

    private final void ta() {
        da().K4().j(p6(), new c(new UA2() { // from class: ir.nasim.JS6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TS6.ua(this.a, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(TS6 ts6, List list) {
        AbstractC13042fc3.i(ts6, "this$0");
        ts6.userPrivacyConfigList = list;
        ts6.wa();
        ts6.va();
        ts6.ia(true);
        ts6.aa().g.setVisibility(8);
        return C19938rB7.a;
    }

    private final void va() {
        List<ZI7> list = this.userPrivacyConfigList;
        if (list != null) {
            for (ZI7 zi7 : list) {
                if (zi7.d()) {
                    sa(zi7.a());
                    return;
                }
            }
            sa(EnumC5052Hr5.a);
        }
    }

    private final void wa() {
        List<ZI7> list = this.userPrivacyConfigList;
        if (list != null) {
            for (ZI7 zi7 : list) {
                String strE = JF5.g() ? XY6.e(String.valueOf(zi7.b())) : String.valueOf(zi7.b());
                if (zi7.a() == EnumC5052Hr5.b) {
                    if (zi7.b() > 0) {
                        aa().l.setText(i6(AbstractC12217eE5.story_privacy_exception_count, strE));
                    } else {
                        aa().l.setText(h6(AbstractC12217eE5.story_privacy_contacts_exclude_subtitle));
                    }
                } else if (zi7.a() == EnumC5052Hr5.c) {
                    if (zi7.b() > 0) {
                        aa().m.setText(i6(AbstractC12217eE5.story_privacy_exception_count, strE));
                    } else {
                        aa().m.setText(h6(AbstractC12217eE5.story_privacy_contacts_include_subtitle));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 xa(TS6 ts6) {
        AbstractC13042fc3.i(ts6, "this$0");
        FragmentActivity fragmentActivityQ7 = ts6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C24656yz2.c(inflater);
        ca();
        ConstraintLayout root = aa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
        da().d6();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        da().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        ga();
        fa();
        ja();
        ia(false);
        ta();
    }
}
