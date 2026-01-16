package ir.nasim;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.pfm.tags.PFMTag;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import org.xbill.DNS.WKSRecord;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R.\u0010<\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R.\u0010@\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\u0014\u0010C\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lir/nasim/lP4;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/rB7;", "u8", "E8", "J8", "B8", "D8", "N8", "K8", "C8", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "Lir/nasim/Wy2;", "W0", "Lir/nasim/Wy2;", "_binding", "Lir/nasim/features/pfm/h;", "X0", "Lir/nasim/Yu3;", "A8", "()Lir/nasim/features/pfm/h;", "viewModel", "Lir/nasim/nR4;", "Y0", "Lir/nasim/nR4;", "y8", "()Lir/nasim/nR4;", "H8", "(Lir/nasim/nR4;)V", "tagsAdapter", "Lir/nasim/hu7;", "Z0", "Lir/nasim/hu7;", "z8", "()Lir/nasim/hu7;", "I8", "(Lir/nasim/hu7;)V", "transactionType", "", "Lir/nasim/features/pfm/tags/PFMTag;", "", "a1", "Ljava/util/Map;", "w8", "()Ljava/util/Map;", "F8", "(Ljava/util/Map;)V", "finalDepositTags", "b1", "x8", "G8", "finalWithdrawTags", "v8", "()Lir/nasim/Wy2;", "binding", "c1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.lP4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16515lP4 extends Fragment {

    /* renamed from: c1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int d1 = 8;

    /* renamed from: W0, reason: from kotlin metadata */
    private C8667Wy2 _binding;

    /* renamed from: X0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kP4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C16515lP4.O8(this.a);
        }
    });

    /* renamed from: Y0, reason: from kotlin metadata */
    public C17715nR4 tagsAdapter;

    /* renamed from: Z0, reason: from kotlin metadata */
    public EnumC14437hu7 transactionType;

    /* renamed from: a1, reason: from kotlin metadata */
    public Map finalDepositTags;

    /* renamed from: b1, reason: from kotlin metadata */
    public Map finalWithdrawTags;

    /* renamed from: ir.nasim.lP4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C16515lP4 a(EnumC14437hu7 enumC14437hu7) {
            AbstractC13042fc3.i(enumC14437hu7, "transactionType");
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARG_TRANSACTION_TYPE", enumC14437hu7);
            C16515lP4 c16515lP4 = new C16515lP4();
            c16515lP4.a8(bundle);
            return c16515lP4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.lP4$b */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            XV4 xv4 = (XV4) obj2;
            Long lValueOf = Long.valueOf(((Number) xv4.b()).longValue());
            XV4 xv42 = (XV4) obj;
            return AbstractC18050o01.d(lValueOf, Long.valueOf(((Number) xv42.b()).longValue()));
        }
    }

    /* renamed from: ir.nasim.lP4$c */
    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            XV4 xv4 = (XV4) obj2;
            Long lValueOf = Long.valueOf(((Number) xv4.b()).longValue());
            XV4 xv42 = (XV4) obj;
            return AbstractC18050o01.d(lValueOf, Long.valueOf(((Number) xv42.b()).longValue()));
        }
    }

    private final ir.nasim.features.pfm.h A8() {
        return (ir.nasim.features.pfm.h) this.viewModel.getValue();
    }

    private final void B8() {
        if (z8() == EnumC14437hu7.a) {
            y8().C(AbstractC15401jX0.p1(w8().keySet()));
            y8().B(AbstractC15401jX0.p1(w8().values()));
        } else if (z8() == EnumC14437hu7.b) {
            y8().C(AbstractC15401jX0.p1(x8().keySet()));
            y8().B(AbstractC15401jX0.p1(x8().values()));
        }
        y8().D(A8().A2());
        y8().notifyDataSetChanged();
    }

    private final void C8() {
        if (z8() == EnumC14437hu7.a) {
            v8().g.setTitle(h6(AbstractC12217eE5.toolbar_detail_tags_deposit));
        } else if (z8() == EnumC14437hu7.b) {
            v8().g.setTitle(h6(AbstractC12217eE5.toolbar_detail_tags_withdraw));
        }
    }

    private final void D8() {
        String strM2;
        if (z8() == EnumC14437hu7.a) {
            strM2 = A8().g2();
            v8().j.setTextColor(C5495Jo7.a.U0());
            v8().j.setText(h6(AbstractC12217eE5.total_deposit));
        } else if (z8() == EnumC14437hu7.b) {
            strM2 = A8().M2();
            v8().j.setTextColor(C5495Jo7.a.X0());
            v8().j.setText(h6(AbstractC12217eE5.total_withdraw));
        } else {
            strM2 = "";
        }
        v8().h.setText(S7().getString(AbstractC12217eE5.bank_rial_amount, XY6.e(GY6.g(strM2))));
    }

    private final void E8() {
        TextView textView = v8().h;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g1());
        v8().h.setTypeface(C6011Lu2.i());
        v8().d.setTextColor(c5495Jo7.f1());
        v8().d.setTypeface(C6011Lu2.i());
        v8().b.setTextColor(c5495Jo7.f1());
        v8().b.setTypeface(C6011Lu2.i());
        BaleToolbar baleToolbar = v8().g;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void J8() {
        H8(new C17715nR4());
    }

    private final void K8() {
        int[][] iArr = {new int[]{-16842912}, new int[]{android.R.attr.state_checked}};
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{c5495Jo7.e(), c5495Jo7.M0()});
        v8().b.setButtonTintList(colorStateList);
        v8().d.setButtonTintList(colorStateList);
        v8().b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.iP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C16515lP4.L8(this.a, compoundButton, z);
            }
        });
        v8().d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.jP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C16515lP4.M8(this.a, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L8(C16515lP4 c16515lP4, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c16515lP4, "this$0");
        if (z) {
            c16515lP4.I8(EnumC14437hu7.a);
            c16515lP4.B8();
            c16515lP4.D8();
            c16515lP4.C8();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M8(C16515lP4 c16515lP4, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c16515lP4, "this$0");
        if (z) {
            c16515lP4.I8(EnumC14437hu7.b);
            c16515lP4.B8();
            c16515lP4.D8();
            c16515lP4.C8();
        }
    }

    private final void N8() {
        v8().c.setAdapter(y8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.pfm.h O8(C16515lP4 c16515lP4) {
        AbstractC13042fc3.i(c16515lP4, "this$0");
        FragmentActivity fragmentActivityQ7 = c16515lP4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (ir.nasim.features.pfm.h) new androidx.lifecycle.G(fragmentActivityQ7).b(ir.nasim.features.pfm.h.class);
    }

    private final void u8() {
        Map mapA = AbstractC20051rO3.A(A8().e2());
        long j = Long.parseLong(A8().g2()) - AbstractC15401jX0.e1(mapA.values());
        if (j > 0) {
            mapA.put(new PFMTag(0, Long.MAX_VALUE, null, EnumC18897pR4.c, null, KB5.ic_deposit_no_tag, C5495Jo7.a.a2(), null, WKSRecord.Service.CISCO_SYS, null), Long.valueOf(j));
        }
        F8(AbstractC20051rO3.w(AbstractC15401jX0.a1(AbstractC21263tO3.C(mapA), new b())));
        Map mapA2 = AbstractC20051rO3.A(A8().K2());
        long j2 = Long.parseLong(A8().M2()) - AbstractC15401jX0.e1(mapA2.values());
        if (j2 > 0) {
            mapA2.put(new PFMTag(0, Long.MAX_VALUE, null, EnumC18897pR4.d, null, KB5.ic_withdraw_no_tag, C5495Jo7.a.b2(), null, WKSRecord.Service.CISCO_SYS, null), Long.valueOf(j2));
        }
        G8(AbstractC20051rO3.w(AbstractC15401jX0.a1(AbstractC21263tO3.C(mapA2), new c())));
    }

    private final C8667Wy2 v8() {
        C8667Wy2 c8667Wy2 = this._binding;
        AbstractC13042fc3.f(c8667Wy2);
        return c8667Wy2;
    }

    public final void F8(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.finalDepositTags = map;
    }

    public final void G8(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.finalWithdrawTags = map;
    }

    public final void H8(C17715nR4 c17715nR4) {
        AbstractC13042fc3.i(c17715nR4, "<set-?>");
        this.tagsAdapter = c17715nR4;
    }

    public final void I8(EnumC14437hu7 enumC14437hu7) {
        AbstractC13042fc3.i(enumC14437hu7, "<set-?>");
        this.transactionType = enumC14437hu7;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        Serializable serializable = bundleE5 != null ? bundleE5.getSerializable("ARG_TRANSACTION_TYPE") : null;
        AbstractC13042fc3.g(serializable, "null cannot be cast to non-null type ir.nasim.features.pfm.TransactionType");
        I8((EnumC14437hu7) serializable);
        c8(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C8667Wy2.c(inflater, container, false);
        u8();
        E8();
        J8();
        N8();
        K8();
        if (z8() == EnumC14437hu7.a) {
            v8().b.setChecked(true);
        } else if (z8() == EnumC14437hu7.b) {
            v8().d.setChecked(true);
        }
        ConstraintLayout root = v8().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final Map w8() {
        Map map = this.finalDepositTags;
        if (map != null) {
            return map;
        }
        AbstractC13042fc3.y("finalDepositTags");
        return null;
    }

    public final Map x8() {
        Map map = this.finalWithdrawTags;
        if (map != null) {
            return map;
        }
        AbstractC13042fc3.y("finalWithdrawTags");
        return null;
    }

    public final C17715nR4 y8() {
        C17715nR4 c17715nR4 = this.tagsAdapter;
        if (c17715nR4 != null) {
            return c17715nR4;
        }
        AbstractC13042fc3.y("tagsAdapter");
        return null;
    }

    public final EnumC14437hu7 z8() {
        EnumC14437hu7 enumC14437hu7 = this.transactionType;
        if (enumC14437hu7 != null) {
            return enumC14437hu7;
        }
        AbstractC13042fc3.y("transactionType");
        return null;
    }
}
