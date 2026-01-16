package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.nasim.C19044ph0;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lir/nasim/uh0;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/View;", "res", "Lir/nasim/rB7;", "da", "(Landroid/view/View;)V", "W9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/ph0;", "h1", "Lir/nasim/ph0;", "getAdapter", "()Lir/nasim/ph0;", "setAdapter", "(Lir/nasim/ph0;)V", "adapter", "Lir/nasim/Ax2;", "i1", "Lir/nasim/bW7;", "Z9", "()Lir/nasim/Ax2;", "binding", "Lir/nasim/OK7;", "j1", "Lir/nasim/OK7;", "aa", "()Lir/nasim/OK7;", "setUsersModel", "(Lir/nasim/OK7;)V", "usersModel", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.uh0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22112uh0 extends TV2 {
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C22112uh0.class, "binding", "getBinding()Lir/nasim/databinding/FragmentBlockedSettingsBinding;", 0))};
    public static final int l1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private C19044ph0 adapter;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new a(), AbstractC20046rN7.c());

    /* renamed from: j1, reason: from kotlin metadata */
    public OK7 usersModel;

    /* renamed from: ir.nasim.uh0$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3445Ax2.a(fragment.V7());
        }
    }

    private final void W9() {
        final TextView textView = Z9().c;
        AbstractC13042fc3.h(textView, "emptyView");
        aa().s0().m0(new InterfaceC24449ye1() { // from class: ir.nasim.rh0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22112uh0.X9(this.a, textView, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(final C22112uh0 c22112uh0, final TextView textView, final List list) {
        AbstractC13042fc3.i(c22112uh0, "this$0");
        AbstractC13042fc3.i(textView, "$emptyView");
        AbstractC13042fc3.i(list, "users");
        if (c22112uh0.u6()) {
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.sh0
                @Override // java.lang.Runnable
                public final void run() {
                    C22112uh0.Y9(list, c22112uh0, textView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(List list, C22112uh0 c22112uh0, TextView textView) {
        AbstractC13042fc3.i(list, "$users");
        AbstractC13042fc3.i(c22112uh0, "this$0");
        AbstractC13042fc3.i(textView, "$emptyView");
        if (!list.isEmpty()) {
            c22112uh0.d9(textView);
            c22112uh0.K9(c22112uh0.Z9().d);
        } else {
            c22112uh0.d9(c22112uh0.Z9().d);
            c22112uh0.K9(textView);
            textView.setText(AbstractC12217eE5.blocked_empty_list);
        }
        C19044ph0 c19044ph0 = c22112uh0.adapter;
        if (c19044ph0 != null) {
            c19044ph0.C(list);
        }
    }

    private final C3445Ax2 Z9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C3445Ax2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(final C22112uh0 c22112uh0, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c22112uh0, "this$0");
        AbstractC13042fc3.i(c21231tK7, "u");
        C6517Nv5 c6517Nv5M0 = c22112uh0.aa().C0(c21231tK7.o()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.th0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22112uh0.ca(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        c22112uh0.S8(c6517Nv5M0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(C22112uh0 c22112uh0, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c22112uh0, "this$0");
        c22112uh0.W9();
    }

    private final void da(View res) {
        BaleToolbar baleToolbar = (BaleToolbar) res.findViewById(BC5.block_list_toolbar);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout root = C3445Ax2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final OK7 aa() {
        OK7 ok7 = this.usersModel;
        if (ok7 != null) {
            return ok7;
        }
        AbstractC13042fc3.y("usersModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        C3445Ax2 c3445Ax2Z9 = Z9();
        super.l7(view, savedInstanceState);
        c3445Ax2Z9.d.setLayoutManager(new LinearLayoutManager(A5()));
        c3445Ax2Z9.c.setText(AbstractC12217eE5.blocked_loading);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackgroundColor(c5495Jo7.o());
        c3445Ax2Z9.c.setTextColor(c5495Jo7.o());
        C19044ph0 c19044ph0 = new C19044ph0(new ArrayList(), new C19044ph0.b() { // from class: ir.nasim.qh0
            @Override // ir.nasim.C19044ph0.b
            public final void a(C21231tK7 c21231tK7) {
                C22112uh0.ba(this.a, c21231tK7);
            }
        });
        this.adapter = c19044ph0;
        c3445Ax2Z9.d.setAdapter(c19044ph0);
        W9();
        da(view);
    }
}
