package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.RootActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J-\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lir/nasim/JP1;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/View;", "view", "Lir/nasim/rB7;", "Z9", "(Landroid/view/View;)V", "Y9", "aa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "Lir/nasim/core/modules/settings/SettingsModule;", "h1", "Lir/nasim/core/modules/settings/SettingsModule;", "X9", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lir/nasim/cy2;", "i1", "Lir/nasim/cy2;", "_binding", "W9", "()Lir/nasim/cy2;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class JP1 extends AbstractC22008uW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: i1, reason: from kotlin metadata */
    private C11416cy2 _binding;

    private final C11416cy2 W9() {
        C11416cy2 c11416cy2 = this._binding;
        AbstractC13042fc3.f(c11416cy2);
        return c11416cy2;
    }

    private final void Y9() {
        CheckBox checkBox = W9().b;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        checkBox.setTextColor(c5495Jo7.g1());
        W9().d.setTextColor(c5495Jo7.g1());
        W9().e.setTextColor(c5495Jo7.g1());
        W9().f.setTextColor(c5495Jo7.g1());
        W9().c.setTextColor(c5495Jo7.g1());
        W9().b.setChecked(true);
        W9().d.setChecked(AbstractC5969Lp4.d().t0());
        W9().e.setChecked(AbstractC5969Lp4.d().u0());
        W9().f.setChecked(AbstractC5969Lp4.d().v0());
        W9().c.setChecked(AbstractC5969Lp4.d().s0());
    }

    private final void Z9(View view) {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackgroundColor(c5495Jo7.o());
        W9().j.setTextColor(c5495Jo7.W0());
        W9().g.setBackgroundColor(c5495Jo7.O0());
    }

    private final void aa() {
        final AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        AbstractC13042fc3.h(abstractC13089gK, "getRootFragment(...)");
        W9().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FP1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JP1.ba(this.a, abstractC13089gK, view);
            }
        });
        W9().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GP1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JP1.ca(this.a, abstractC13089gK, view);
            }
        });
        W9().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HP1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JP1.da(this.a, abstractC13089gK, view);
            }
        });
        W9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IP1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JP1.ea(this.a, abstractC13089gK, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(JP1 jp1, AbstractC13089g abstractC13089g, View view) {
        AbstractC13042fc3.i(jp1, "this$0");
        AbstractC13042fc3.i(abstractC13089g, "$rootFragment");
        jp1.X9().L6(!jp1.X9().x5());
        jp1.W9().d.setChecked(jp1.X9().x5());
        RootActivity.INSTANCE.d(true);
        abstractC13089g.O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(JP1 jp1, AbstractC13089g abstractC13089g, View view) {
        AbstractC13042fc3.i(jp1, "this$0");
        AbstractC13042fc3.i(abstractC13089g, "$rootFragment");
        jp1.X9().M6(!jp1.X9().y5());
        jp1.W9().e.setChecked(jp1.X9().y5());
        RootActivity.INSTANCE.d(true);
        abstractC13089g.O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(JP1 jp1, AbstractC13089g abstractC13089g, View view) {
        AbstractC13042fc3.i(jp1, "this$0");
        AbstractC13042fc3.i(abstractC13089g, "$rootFragment");
        jp1.X9().N6(!jp1.X9().z5());
        jp1.W9().f.setChecked(jp1.X9().z5());
        RootActivity.INSTANCE.d(true);
        abstractC13089g.O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(JP1 jp1, AbstractC13089g abstractC13089g, View view) {
        AbstractC13042fc3.i(jp1, "this$0");
        AbstractC13042fc3.i(abstractC13089g, "$rootFragment");
        jp1.X9().K6(!jp1.X9().w5());
        jp1.W9().c.setChecked(jp1.X9().w5());
        RootActivity.INSTANCE.d(true);
        abstractC13089g.O9();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C11416cy2.c(inflater, container, false);
        LinearLayout root = W9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        BaleToolbar baleToolbar = W9().h;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        Z9(root);
        aa();
        Y9();
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
    }

    public final SettingsModule X9() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }
}
