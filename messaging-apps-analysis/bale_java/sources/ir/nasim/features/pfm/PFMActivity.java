package ir.nasim.features.pfm;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20423rz2;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC7562Sg0;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.BC5;
import ir.nasim.C10600bs7;
import ir.nasim.C11458d25;
import ir.nasim.C14505i18;
import ir.nasim.C17213mb2;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C23142wQ4;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8433Vy2;
import ir.nasim.D20;
import ir.nasim.ED1;
import ir.nasim.EnumC13506gL4;
import ir.nasim.EnumC14097hL4;
import ir.nasim.EnumC20036rM6;
import ir.nasim.EnumC8503Wg0;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.KB5;
import ir.nasim.L65;
import ir.nasim.NY;
import ir.nasim.PH3;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.pfm.PFMActivity;
import ir.nasim.features.pfm.entity.AnalysisData;
import ir.nasim.features.pfm.entity.AnalysisDialogData;
import ir.nasim.features.pfm.entity.PFMTransaction;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 _2\u00020\u0001:\u0002`aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0003J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020#H\u0014¢\u0006\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010\\\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010^\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010W¨\u0006b"}, d2 = {"Lir/nasim/features/pfm/PFMActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "Lir/nasim/rB7;", "h3", "r3", "H2", "K2", "I2", "", "command", "e3", "(Ljava/lang/String;)V", "Lir/nasim/features/pfm/entity/PFMTransaction;", "pfmTransaction", "d3", "(Lir/nasim/features/pfm/entity/PFMTransaction;)V", "Lir/nasim/XV4;", "", "S2", "()Lir/nasim/XV4;", "T2", "o3", "k3", "", "G2", "()Z", "W1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "title", "Landroid/content/Context;", "context", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "P2", "(ILandroid/content/Context;)Lir/nasim/designsystem/modal/dialog/AlertDialog;", "Landroid/view/View;", "v", "expand", "(Landroid/view/View;)V", "onBackPressed", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Lir/nasim/features/pfm/PFMActivity$b;", "K0", "Lir/nasim/features/pfm/PFMActivity$b;", "viewPagerAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "L0", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/TabLayout;", "M0", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lir/nasim/features/pfm/h;", "N0", "Lir/nasim/features/pfm/h;", "viewModel", "O0", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "progressDialog", "Lir/nasim/Vy2;", "P0", "Lir/nasim/Vy2;", "Q2", "()Lir/nasim/Vy2;", "g3", "(Lir/nasim/Vy2;)V", "binding", "Lir/nasim/hL4;", "Q0", "Lir/nasim/hL4;", "openedPFMFrom", "R0", "Lir/nasim/features/pfm/entity/PFMTransaction;", "pfmTransactionForSetTag", "Lir/nasim/gL4;", "S0", "Lir/nasim/gL4;", "openPFMDestination", "T0", TokenNames.I, "getDefaultTabIndex", "()I", "setDefaultTabIndex", "(I)V", "defaultTabIndex", "U0", "PFM_REPORT_BOT_ID", "V0", "a", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PFMActivity extends BaseActivity {

    /* renamed from: V0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int W0 = 8;

    /* renamed from: K0, reason: from kotlin metadata */
    private b viewPagerAdapter;

    /* renamed from: L0, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: M0, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: N0, reason: from kotlin metadata */
    private h viewModel;

    /* renamed from: O0, reason: from kotlin metadata */
    private AlertDialog progressDialog;

    /* renamed from: P0, reason: from kotlin metadata */
    public C8433Vy2 binding;

    /* renamed from: Q0, reason: from kotlin metadata */
    private EnumC14097hL4 openedPFMFrom;

    /* renamed from: R0, reason: from kotlin metadata */
    private PFMTransaction pfmTransactionForSetTag;

    /* renamed from: S0, reason: from kotlin metadata */
    private EnumC13506gL4 openPFMDestination;

    /* renamed from: T0, reason: from kotlin metadata */
    private int defaultTabIndex;

    /* renamed from: U0, reason: from kotlin metadata */
    private final int PFM_REPORT_BOT_ID = 1213505698;

    /* renamed from: ir.nasim.features.pfm.PFMActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context, EnumC14097hL4 enumC14097hL4) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(enumC14097hL4, "openedPFMFrom");
            return b(context, enumC14097hL4, null, null);
        }

        public final Intent b(Context context, EnumC14097hL4 enumC14097hL4, EnumC13506gL4 enumC13506gL4, PFMTransaction pFMTransaction) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(enumC14097hL4, "openedPFMFrom");
            Intent intentPutExtra = new Intent(context, (Class<?>) PFMActivity.class).addFlags(268435456).putExtra("opened_from", enumC14097hL4).putExtra("open_pfm_destination", enumC13506gL4).putExtra("extra_transaction", pFMTransaction);
            AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AbstractC20423rz2 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            AbstractC13042fc3.i(fragmentActivity, "fragmentActivity");
        }

        @Override // ir.nasim.AbstractC20423rz2
        public Fragment B(int i) {
            return i != 0 ? i != 1 ? ir.nasim.features.pfm.b.INSTANCE.a() : ir.nasim.features.pfm.d.INSTANCE.a() : ir.nasim.features.pfm.b.INSTANCE.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return 2;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC20036rM6.values().length];
            try {
                iArr[EnumC20036rM6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC20036rM6.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC20036rM6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC20036rM6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC20036rM6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC14097hL4.values().length];
            try {
                iArr2[EnumC14097hL4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC14097hL4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    public static final class d extends Animation {
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        d(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            this.a.getLayoutParams().height = f == 1.0f ? -2 : (int) (this.b * f);
            this.a.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public static final class e implements TabLayout.d {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            Drawable drawableF;
            if (gVar == null || gVar.h() != 0) {
                C3343Am.i("pfm_page", AbstractC20051rO3.n(new XV4("page_type", 1), PFMActivity.this.S2()));
            } else {
                C3343Am.i("pfm_page", AbstractC20051rO3.n(new XV4("page_type", 0), PFMActivity.this.S2()));
            }
            if (gVar == null || (drawableF = gVar.f()) == null) {
                return;
            }
            drawableF.setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.a0(), EnumC8503Wg0.SRC_IN));
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            Drawable drawableF;
            if (gVar == null || (drawableF = gVar.f()) == null) {
                return;
            }
            drawableF.setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.b1(), EnumC8503Wg0.SRC_IN));
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    private final boolean G2() {
        EnumC14097hL4 enumC14097hL4 = this.openedPFMFrom;
        if (enumC14097hL4 == null) {
            AbstractC13042fc3.y("openedPFMFrom");
            enumC14097hL4 = null;
        }
        if (enumC14097hL4 != EnumC14097hL4.d) {
            return false;
        }
        int size = B0().C0().size();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Fragment fragment : B0().C0()) {
            if (fragment instanceof ir.nasim.features.pfm.d) {
                z = true;
            }
            if (fragment instanceof ir.nasim.features.pfm.b) {
                z2 = true;
            }
            if (fragment instanceof C23142wQ4) {
                z3 = true;
            }
        }
        if (z && z2 && z3 && size == 3) {
            return true;
        }
        if (z && z3 && size == 2) {
            return true;
        }
        return z2 && z3 && size == 2;
    }

    private final void H2() {
        EnumC14097hL4 enumC14097hL4 = this.openedPFMFrom;
        if (enumC14097hL4 == null) {
            AbstractC13042fc3.y("openedPFMFrom");
            enumC14097hL4 = null;
        }
        if (enumC14097hL4 == EnumC14097hL4.c) {
            return;
        }
        K2();
        I2();
    }

    private final void I2() {
        h hVar = this.viewModel;
        if (hVar == null) {
            AbstractC13042fc3.y("viewModel");
            hVar = null;
        }
        final AnalysisData analysisDataT1 = hVar.T1();
        if (analysisDataT1 != null) {
            Q2().m.setVisibility(0);
            Q2().m.setText(analysisDataT1.getText());
            Q2().m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KO4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PFMActivity.J2(this.a, analysisDataT1, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(PFMActivity pFMActivity, AnalysisData analysisData, View view) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        AbstractC13042fc3.i(analysisData, "$data");
        pFMActivity.e3(analysisData.getCommand());
    }

    private final void K2() {
        h hVar = this.viewModel;
        if (hVar == null) {
            AbstractC13042fc3.y("viewModel");
            hVar = null;
        }
        AnalysisDialogData analysisDialogDataS1 = hVar.S1();
        if (analysisDialogDataS1 != null) {
            new NY(this).B(analysisDialogDataS1.getTitle()).i(analysisDialogDataS1.getDescription()).p(KB5.ic_pfm_analysis_report).w(AbstractC12217eE5.pfm_report_dialog_positive).E(4).k(4).t(AbstractC12217eE5.pfm_report_dialog_negative).c(true).v(new View.OnClickListener() { // from class: ir.nasim.JO4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PFMActivity.O2(this.a, view);
                }
            }).b(false).z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(PFMActivity pFMActivity, View view) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        pFMActivity.e3(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 S2() {
        EnumC14097hL4 enumC14097hL4 = this.openedPFMFrom;
        if (enumC14097hL4 == null) {
            AbstractC13042fc3.y("openedPFMFrom");
            enumC14097hL4 = null;
        }
        int i = c.b[enumC14097hL4.ordinal()];
        return new XV4("back_stage", i != 1 ? i != 2 ? C19938rB7.a : 1 : 0);
    }

    private final void T2() {
        LinearLayout linearLayout = Q2().h;
        AbstractC13042fc3.h(linearLayout, "pfmEmptyLayoutDefault");
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(PFMActivity pFMActivity, View view) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        pFMActivity.Q2().o.setVisibility(4);
        RelativeLayout relativeLayout = pFMActivity.Q2().i;
        AbstractC13042fc3.h(relativeLayout, "pfmEmptyLayoutExpanded");
        pFMActivity.expand(relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V2(final PFMActivity pFMActivity, EnumC20036rM6 enumC20036rM6) {
        AlertDialog alertDialog;
        AbstractC13042fc3.i(pFMActivity, "this$0");
        int i = enumC20036rM6 == null ? -1 : c.a[enumC20036rM6.ordinal()];
        if (i == 1) {
            pFMActivity.o3();
            ConstraintLayout constraintLayout = pFMActivity.Q2().j;
            AbstractC13042fc3.h(constraintLayout, "pfmLayout");
            constraintLayout.setVisibility(8);
            ProgressBar progressBar = pFMActivity.Q2().l;
            AbstractC13042fc3.h(progressBar, "pfmPb");
            progressBar.setVisibility(8);
        } else if (i == 2) {
            pFMActivity.T2();
            pFMActivity.h3();
            ConstraintLayout constraintLayout2 = pFMActivity.Q2().j;
            AbstractC13042fc3.h(constraintLayout2, "pfmLayout");
            constraintLayout2.setVisibility(0);
            ProgressBar progressBar2 = pFMActivity.Q2().l;
            AbstractC13042fc3.h(progressBar2, "pfmPb");
            progressBar2.setVisibility(8);
            pFMActivity.H2();
            try {
                h hVar = pFMActivity.viewModel;
                ViewPager2 viewPager2 = null;
                if (hVar == null) {
                    AbstractC13042fc3.y("viewModel");
                    hVar = null;
                }
                if (hVar.O2()) {
                    EnumC14097hL4 enumC14097hL4 = pFMActivity.openedPFMFrom;
                    if (enumC14097hL4 == null) {
                        AbstractC13042fc3.y("openedPFMFrom");
                        enumC14097hL4 = null;
                    }
                    if (enumC14097hL4 != EnumC14097hL4.c) {
                        EnumC14097hL4 enumC14097hL42 = pFMActivity.openedPFMFrom;
                        if (enumC14097hL42 == null) {
                            AbstractC13042fc3.y("openedPFMFrom");
                            enumC14097hL42 = null;
                        }
                        if (enumC14097hL42 != EnumC14097hL4.d) {
                            Serializable serializableExtra = pFMActivity.getIntent().getSerializableExtra("open_pfm_destination");
                            if ((serializableExtra instanceof EnumC13506gL4 ? (EnumC13506gL4) serializableExtra : null) != EnumC13506gL4.b) {
                                new Handler().postDelayed(new Runnable() { // from class: ir.nasim.UO4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        PFMActivity.W2(this.a);
                                    }
                                }, 200L);
                            }
                        }
                    }
                }
                ViewPager2 viewPager22 = pFMActivity.viewPager;
                if (viewPager22 == null) {
                    AbstractC13042fc3.y("viewPager");
                } else {
                    viewPager2 = viewPager22;
                }
                viewPager2.setCurrentItem(pFMActivity.defaultTabIndex, false);
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
        } else if (i == 3) {
            pFMActivity.T2();
            ConstraintLayout constraintLayout3 = pFMActivity.Q2().j;
            AbstractC13042fc3.h(constraintLayout3, "pfmLayout");
            constraintLayout3.setVisibility(8);
            ProgressBar progressBar3 = pFMActivity.Q2().l;
            AbstractC13042fc3.h(progressBar3, "pfmPb");
            progressBar3.setVisibility(0);
        } else if (i == 4) {
            AlertDialog alertDialogP2 = pFMActivity.P2(AbstractC12217eE5.progress_common, pFMActivity);
            pFMActivity.progressDialog = alertDialogP2;
            if (alertDialogP2 != null) {
                alertDialogP2.show();
            }
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            AlertDialog alertDialog2 = pFMActivity.progressDialog;
            if (alertDialog2 != null) {
                AbstractC13042fc3.f(alertDialog2);
                if (alertDialog2.isShowing() && (alertDialog = pFMActivity.progressDialog) != null) {
                    alertDialog.dismiss();
                }
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(PFMActivity pFMActivity) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        pFMActivity.r3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X2(PFMActivity pFMActivity, boolean z) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        TabLayout tabLayout = pFMActivity.tabLayout;
        if (tabLayout == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout = null;
        }
        TabLayout.g gVarY = tabLayout.y(1);
        AbstractC13042fc3.f(gVarY);
        gVarY.n();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(PFMActivity pFMActivity, TabLayout.g gVar, int i) throws Resources.NotFoundException {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        AbstractC13042fc3.i(gVar, "tab");
        if (i == 0) {
            gVar.y(pFMActivity.getString(AbstractC12217eE5.pfm_diagram_tab_title));
            gVar.t(AbstractC4043Dl1.f(pFMActivity.getBaseContext(), KB5.data_usage_black_24dp));
            Drawable drawableF = gVar.f();
            if (drawableF != null) {
                drawableF.setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.b1(), EnumC8503Wg0.SRC_IN));
                return;
            }
            return;
        }
        if (i != 1) {
            return;
        }
        gVar.y(pFMActivity.getString(AbstractC12217eE5.pfm_text_tab_title));
        gVar.t(AbstractC4043Dl1.f(pFMActivity.getBaseContext(), KB5.receipt_black_24dp));
        Drawable drawableF2 = gVar.f();
        if (drawableF2 != null) {
            drawableF2.setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.b1(), EnumC8503Wg0.SRC_IN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(PFMActivity pFMActivity, PFMTransaction pFMTransaction) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$it");
        pFMActivity.d3(pFMTransaction);
        pFMActivity.pfmTransactionForSetTag = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a3(PFMActivity pFMActivity) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        TabLayout tabLayout = pFMActivity.tabLayout;
        if (tabLayout == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout = null;
        }
        TabLayout.g gVarY = tabLayout.y(1);
        AbstractC13042fc3.f(gVarY);
        gVarY.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b3(final int i, final PFMActivity pFMActivity, View view) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        if (i == pFMActivity.defaultTabIndex) {
            return false;
        }
        PopupMenu popupMenu = new PopupMenu(pFMActivity, view);
        popupMenu.inflate(AbstractC15226jD5.select_default_tab_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.nasim.VO4
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return PFMActivity.c3(this.a, i, menuItem);
            }
        });
        popupMenu.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c3(PFMActivity pFMActivity, int i, MenuItem menuItem) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        AbstractC13042fc3.i(menuItem, "item");
        if (menuItem.getItemId() != BC5.popup_menu_action_default) {
            return false;
        }
        h hVar = pFMActivity.viewModel;
        if (hVar == null) {
            AbstractC13042fc3.y("viewModel");
            hVar = null;
        }
        hVar.s3(i);
        pFMActivity.defaultTabIndex = i;
        return false;
    }

    private final void d3(PFMTransaction pfmTransaction) {
        C23142wQ4 c23142wQ4B = C23142wQ4.Companion.b(C23142wQ4.INSTANCE, pfmTransaction, false, 2, null);
        b2(BC5.pfm_container, c23142wQ4B, c23142wQ4B.getClass().getSimpleName());
    }

    private final void e3(final String command) {
        AbstractC5969Lp4.d().V0(new ArrayList(AbstractC9766aX0.e(Integer.valueOf(this.PFM_REPORT_BOT_ID)))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.LO4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                PFMActivity.f3(this.a, command, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(PFMActivity pFMActivity, String str, C14505i18 c14505i18) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25R = C11458d25.r(pFMActivity.PFM_REPORT_BOT_ID);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        c18987pb3.v1(c11458d25R, str);
        pFMActivity.finish();
    }

    private final void h3() {
        BaleToolbar.setHasBackButton$default(Q2().d, this, true, false, 4, null);
        Q2().d.y(AbstractC15226jD5.pfm_activity_menu);
        Q2().d.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.WO4
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return PFMActivity.i3(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i3(PFMActivity pFMActivity, MenuItem menuItem) {
        AbstractC13042fc3.i(pFMActivity, "this$0");
        if (menuItem.getItemId() != BC5.menu_item_kebab) {
            return false;
        }
        pFMActivity.k3();
        return true;
    }

    private final void k3() {
        L65 l65C = L65.c(getLayoutInflater());
        AbstractC13042fc3.h(l65C, "inflate(...)");
        AlertDialog.a aVar = new AlertDialog.a(this);
        aVar.n(l65C.getRoot());
        MaterialCardView materialCardView = l65C.f;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        materialCardView.setBackgroundColor(c5495Jo7.c());
        l65C.e.setTypeface(C6011Lu2.k());
        l65C.e.setTextColor(c5495Jo7.N0());
        l65C.h.setTypeface(C6011Lu2.k());
        l65C.h.setTextColor(c5495Jo7.N0());
        aVar.b(true);
        aVar.c(true);
        final AlertDialog alertDialogA = aVar.a();
        l65C.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MO4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PFMActivity.l3(alertDialogA, this, view);
            }
        });
        l65C.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NO4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PFMActivity.m3(alertDialogA, this, view);
            }
        });
        alertDialogA.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l3(AlertDialog alertDialog, PFMActivity pFMActivity, View view) {
        AbstractC13042fc3.i(alertDialog, "$alertDialog");
        AbstractC13042fc3.i(pFMActivity, "this$0");
        alertDialog.dismiss();
        Fragment fragmentB = i.INSTANCE.b();
        pFMActivity.b2(BC5.pfm_container, fragmentB, fragmentB.getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m3(AlertDialog alertDialog, PFMActivity pFMActivity, View view) {
        AbstractC13042fc3.i(alertDialog, "$alertDialog");
        AbstractC13042fc3.i(pFMActivity, "this$0");
        alertDialog.dismiss();
        pFMActivity.e3(null);
    }

    private final void o3() {
        LinearLayout linearLayout = Q2().h;
        AbstractC13042fc3.h(linearLayout, "pfmEmptyLayoutDefault");
        linearLayout.setVisibility(0);
        C3343Am.i("pfm_page", AbstractC20051rO3.n(new XV4("page_type", 2), S2()));
    }

    private final void r3() {
        if (isDestroyed()) {
            return;
        }
        h hVar = this.viewModel;
        h hVar2 = null;
        if (hVar == null) {
            AbstractC13042fc3.y("viewModel");
            hVar = null;
        }
        if (hVar.P2()) {
            return;
        }
        if (Q2().e.getCurrentItem() == 1) {
            h hVar3 = this.viewModel;
            if (hVar3 == null) {
                AbstractC13042fc3.y("viewModel");
                hVar3 = null;
            }
            if (hVar3.h2()) {
                return;
            }
        }
        D20.a aVarA = C10600bs7.a.a(this);
        aVarA.X1("<b>تغییر تب پیش\u200cفرض  <br> </b>با لمس طولانی، میتوانید تب پیش\u200cفرض خود را تغییر دهید.");
        aVarA.c2(true);
        aVarA.a1(0.15f);
        aVarA.k2(200);
        aVarA.u1(100);
        aVarA.b2(5);
        D20 d20A = aVarA.a();
        TabLayout tabLayout = Q2().n;
        AbstractC13042fc3.h(tabLayout, "tabLayout");
        d20A.J0(tabLayout, 0, 0);
        h hVar4 = this.viewModel;
        if (hVar4 == null) {
            AbstractC13042fc3.y("viewModel");
        } else {
            hVar2 = hVar4;
        }
        hVar2.z3(false);
    }

    public final AlertDialog P2(int title, Context context) {
        AbstractC13042fc3.i(context, "context");
        AlertDialog alertDialog = new AlertDialog(context, 1);
        alertDialog.S(context.getString(title));
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    public final C8433Vy2 Q2() {
        C8433Vy2 c8433Vy2 = this.binding;
        if (c8433Vy2 != null) {
            return c8433Vy2;
        }
        AbstractC13042fc3.y("binding");
        return null;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.b(PH3.a, base, null, 1, null));
    }

    public final void expand(View v) {
        AbstractC13042fc3.i(v, "v");
        v.measure(-1, -2);
        int measuredHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 0;
        v.setVisibility(0);
        d dVar = new d(v, measuredHeight);
        dVar.setDuration(110L);
        v.startAnimation(dVar);
    }

    public final void g3(C8433Vy2 c8433Vy2) {
        AbstractC13042fc3.i(c8433Vy2, "<set-?>");
        this.binding = c8433Vy2;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (B0().C0().isEmpty()) {
            super.onBackPressed();
            return;
        }
        if (G2()) {
            finish();
        }
        super.onBackPressed();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g3(C8433Vy2.c(getLayoutInflater()));
        setContentView(Q2().getRoot());
        Serializable serializableExtra = getIntent().getSerializableExtra("opened_from");
        AbstractC13042fc3.g(serializableExtra, "null cannot be cast to non-null type ir.nasim.features.pfm.entity.OpenedPFMFrom");
        this.openedPFMFrom = (EnumC14097hL4) serializableExtra;
        Serializable serializableExtra2 = getIntent().getSerializableExtra("open_pfm_destination");
        TabLayout tabLayout = null;
        this.openPFMDestination = serializableExtra2 instanceof EnumC13506gL4 ? (EnumC13506gL4) serializableExtra2 : null;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_transaction");
        this.pfmTransactionForSetTag = parcelableExtra instanceof PFMTransaction ? (PFMTransaction) parcelableExtra : null;
        g3(C8433Vy2.c(getLayoutInflater()));
        setContentView(Q2().getRoot());
        BaleToolbar.setHasBackButton$default(Q2().b, this, true, false, 4, null);
        h hVar = (h) new G(this).b(h.class);
        this.viewModel = hVar;
        if (hVar == null) {
            AbstractC13042fc3.y("viewModel");
            hVar = null;
        }
        this.defaultTabIndex = hVar.Y1();
        this.viewPagerAdapter = new b(this);
        this.viewPager = Q2().e;
        this.tabLayout = Q2().n;
        Q2().o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IO4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PFMActivity.U2(this.a, view);
            }
        });
        g.G.b(false);
        h hVar2 = this.viewModel;
        if (hVar2 == null) {
            AbstractC13042fc3.y("viewModel");
            hVar2 = null;
        }
        hVar2.C2().j(this, new a(new UA2() { // from class: ir.nasim.OO4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PFMActivity.V2(this.a, (EnumC20036rM6) obj);
            }
        }));
        h hVar3 = this.viewModel;
        if (hVar3 == null) {
            AbstractC13042fc3.y("viewModel");
            hVar3 = null;
        }
        hVar3.j2().j(this, new a(new UA2() { // from class: ir.nasim.PO4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PFMActivity.X2(this.a, ((Boolean) obj).booleanValue());
            }
        }));
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            AbstractC13042fc3.y("viewPager");
            viewPager2 = null;
        }
        b bVar = this.viewPagerAdapter;
        if (bVar == null) {
            AbstractC13042fc3.y("viewPagerAdapter");
            bVar = null;
        }
        viewPager2.setAdapter(bVar);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout2 = null;
        }
        tabLayout2.setInlineLabel(true);
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout3 = null;
        }
        tabLayout3.setTabIndicatorFullWidth(false);
        TabLayout tabLayout4 = this.tabLayout;
        if (tabLayout4 == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout4 = null;
        }
        tabLayout4.d(new e());
        TabLayout tabLayout5 = this.tabLayout;
        if (tabLayout5 == null) {
            AbstractC13042fc3.y("tabLayout");
            tabLayout5 = null;
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            AbstractC13042fc3.y("viewPager");
            viewPager22 = null;
        }
        new com.google.android.material.tabs.d(tabLayout5, viewPager22, new d.b() { // from class: ir.nasim.QO4
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i) throws Resources.NotFoundException {
                PFMActivity.Y2(this.a, gVar, i);
            }
        }).a();
        Q2().e.setUserInputEnabled(true);
        final PFMTransaction pFMTransaction = this.pfmTransactionForSetTag;
        long j = pFMTransaction == null ? 0L : 900L;
        if (pFMTransaction != null) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.RO4
                @Override // java.lang.Runnable
                public final void run() {
                    PFMActivity.Z2(this.a, pFMTransaction);
                }
            }, 0L);
        }
        if (this.openPFMDestination == EnumC13506gL4.b) {
            TabLayout tabLayout6 = this.tabLayout;
            if (tabLayout6 == null) {
                AbstractC13042fc3.y("tabLayout");
                tabLayout6 = null;
            }
            tabLayout6.postDelayed(new Runnable() { // from class: ir.nasim.SO4
                @Override // java.lang.Runnable
                public final void run() {
                    PFMActivity.a3(this.a);
                }
            }, j);
            this.openPFMDestination = null;
        }
        C17213mb2.j("open_pfm");
        TabLayout tabLayout7 = this.tabLayout;
        if (tabLayout7 == null) {
            AbstractC13042fc3.y("tabLayout");
        } else {
            tabLayout = tabLayout7;
        }
        View childAt = tabLayout.getChildAt(0);
        AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) childAt;
        int childCount = linearLayout.getChildCount();
        for (final int i = 0; i < childCount; i++) {
            linearLayout.getChildAt(i).setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.TO4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return PFMActivity.b3(i, this, view);
                }
            });
        }
    }
}
