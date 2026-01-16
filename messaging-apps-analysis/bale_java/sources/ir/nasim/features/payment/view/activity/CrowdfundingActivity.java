package ir.nasim.features.payment.view.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5830La0;
import ir.nasim.BC5;
import ir.nasim.C13362g6;
import ir.nasim.C18684p44;
import ir.nasim.C18902pS0;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14778iT2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.KB5;
import ir.nasim.UB3;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import ir.nasim.features.payment.view.fragment.C13082o;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13077j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0003cdeB\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u0007H\u0014¢\u0006\u0004\b(\u0010\u0006J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020#H\u0014¢\u0006\u0004\b*\u0010&J\r\u0010+\u001a\u00020\u0007¢\u0006\u0004\b+\u0010\u0006J)\u00100\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.H\u0014¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b3\u00104J)\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b6\u00107R\u001a\u0010;\u001a\u0006\u0012\u0002\b\u0003088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR*\u0010J\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010C\u001a\u0004\bG\u0010H\"\u0004\bI\u0010 R*\u0010Q\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010a\u001a\u00020Z8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006f"}, d2 = {"Lir/nasim/features/payment/view/activity/CrowdfundingActivity;", "Lir/nasim/features/payment/base/BaseActivity;", "Lir/nasim/g6;", "Landroid/view/View$OnClickListener;", "Lir/nasim/iT2;", "<init>", "()V", "Lir/nasim/rB7;", "I1", "Q1", "", "C1", "()I", "", "peerUniqueId", "W1", "(J)V", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "contentInfo", "", "link", "T1", "(Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;JLjava/lang/String;)V", "Landroid/view/View;", "anchor", "", "isCreator", "showLinkShare", "E1", "(Landroid/view/View;ZZ)V", "isVisible", "L1", "(Z)V", "D1", "()Lir/nasim/g6;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "onStop", "outState", "onSaveInstanceState", "A1", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "view", "onClick", "(Landroid/view/View;)V", "moreEnable", "O1", "(ZZZ)V", "Lir/nasim/La0;", "B0", "Lir/nasim/La0;", "starterFragment", "Landroid/widget/ListPopupWindow;", "C0", "Landroid/widget/ListPopupWindow;", "popupWindow", "D0", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "E0", "Z", "showInfo", "value", "F0", "getBackMode", "()Z", "M1", "backMode", "G0", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "S1", "(Ljava/lang/String;)V", "title", "Lir/nasim/features/payment/view/activity/CrowdfundingActivity$b;", "H0", "Lir/nasim/features/payment/view/activity/CrowdfundingActivity$b;", "getListItemClickListener", "()Lir/nasim/features/payment/view/activity/CrowdfundingActivity$b;", "N1", "(Lir/nasim/features/payment/view/activity/CrowdfundingActivity$b;)V", "listItemClickListener", "Lir/nasim/pS0;", "I0", "Lir/nasim/pS0;", "B1", "()Lir/nasim/pS0;", "setCheckMigrateCardsUseCase", "(Lir/nasim/pS0;)V", "checkMigrateCardsUseCase", "J0", "a", "b", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class CrowdfundingActivity extends Hilt_CrowdfundingActivity<C13362g6> implements View.OnClickListener, InterfaceC14778iT2 {

    /* renamed from: J0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int K0 = 8;
    private static boolean L0;

    /* renamed from: B0, reason: from kotlin metadata */
    private AbstractC5830La0 starterFragment;

    /* renamed from: C0, reason: from kotlin metadata */
    private ListPopupWindow popupWindow;

    /* renamed from: D0, reason: from kotlin metadata */
    private CrowdfundingContentInfo contentInfo;

    /* renamed from: E0, reason: from kotlin metadata */
    private boolean showInfo;

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean backMode;

    /* renamed from: G0, reason: from kotlin metadata */
    private String title = "";

    /* renamed from: H0, reason: from kotlin metadata */
    private b listItemClickListener;

    /* renamed from: I0, reason: from kotlin metadata */
    public C18902pS0 checkMigrateCardsUseCase;

    /* renamed from: ir.nasim.features.payment.view.activity.CrowdfundingActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void a(Context context, long j, boolean z) {
            AbstractC13042fc3.i(context, "context");
            if (b()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CrowdfundingActivity.class);
            intent.putExtra("TYPE_PARAM", c.a.ordinal());
            intent.putExtra("PEER_UNIQUE_ID", j);
            intent.putExtra("from_my_bank", z);
            context.startActivity(intent);
        }

        public final boolean b() {
            return CrowdfundingActivity.L0;
        }

        public final void c(Context context, CrowdfundingContentInfo crowdfundingContentInfo, long j, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(crowdfundingContentInfo, "contentInfo");
            if (b()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CrowdfundingActivity.class);
            intent.putExtra("TYPE_PARAM", c.b.ordinal());
            intent.putExtra("CONTENT_PARAM", crowdfundingContentInfo);
            intent.putExtra("PEER_UNIQUE_ID", j);
            if (str != null) {
                intent.putExtra("LINK", str);
            }
            context.startActivity(intent);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(int i, int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {
        public static final c a = new c("CREATE", 0);
        public static final c b = new c("SHOW", 1);
        private static final /* synthetic */ c[] c;
        private static final /* synthetic */ F92 d;

        static {
            c[] cVarArrA = a();
            c = cVarArrA;
            d = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) c.clone();
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CrowdfundingActivity.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18902pS0 c18902pS0B1 = CrowdfundingActivity.this.B1();
                this.b = 1;
                if (c18902pS0B1.f(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final int C1() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void E1(View anchor, boolean isCreator, boolean showLinkShare) {
        this.popupWindow = new ListPopupWindow(this);
        final ArrayList arrayList = new ArrayList();
        UB3 ub3 = new UB3(this, arrayList, false, 4, null);
        if (isCreator) {
            String string = getString(AbstractC12217eE5.crowdfunding_edit);
            AbstractC13042fc3.h(string, "getString(...)");
            int i = KB5.ic_crowdfunding_edit;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            arrayList.add(new C18684p44(0, string, i, c5495Jo7.g0(), c5495Jo7.o0(), 0, 32, null));
            String string2 = getString(AbstractC12217eE5.crowdfunding_stop);
            AbstractC13042fc3.h(string2, "getString(...)");
            arrayList.add(new C18684p44(1, string2, KB5.ic_crowdfunding_stop, c5495Jo7.X0(), c5495Jo7.X0(), 0, 32, null));
        }
        if (showLinkShare) {
            if (!arrayList.isEmpty()) {
                String string3 = getString(AbstractC12217eE5.crowdfunding_share);
                AbstractC13042fc3.h(string3, "getString(...)");
                int i2 = KB5.ic_crowdfunding_share;
                C5495Jo7 c5495Jo72 = C5495Jo7.a;
                arrayList.add(new C18684p44(2, string3, i2, c5495Jo72.g0(), c5495Jo72.o0(), 0, 32, null));
            } else {
                ((C13362g6) l1()).h.setImageDrawable(AbstractC4043Dl1.f(this, KB5.ic_crowdfunding_share));
                ((C13362g6) l1()).h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cv1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CrowdfundingActivity.F1(this.a, view);
                    }
                });
            }
        }
        final ListPopupWindow listPopupWindow = this.popupWindow;
        if (listPopupWindow != null) {
            listPopupWindow.setAnchorView(anchor);
            listPopupWindow.setAdapter(ub3);
            UB3.a aVar = UB3.d;
            listPopupWindow.setContentWidth(aVar.a());
            listPopupWindow.setWidth(aVar.a());
            listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.dv1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                    CrowdfundingActivity.H1(arrayList, this, listPopupWindow, adapterView, view, i3, j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(CrowdfundingActivity crowdfundingActivity, View view) {
        AbstractC13042fc3.i(crowdfundingActivity, "this$0");
        b bVar = crowdfundingActivity.listItemClickListener;
        if (bVar != null) {
            bVar.a(-1, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(ArrayList arrayList, CrowdfundingActivity crowdfundingActivity, ListPopupWindow listPopupWindow, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(arrayList, "$itemList");
        AbstractC13042fc3.i(crowdfundingActivity, "this$0");
        AbstractC13042fc3.i(listPopupWindow, "$this_apply");
        Object obj = arrayList.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        C18684p44 c18684p44 = (C18684p44) obj;
        b bVar = crowdfundingActivity.listItemClickListener;
        if (bVar != null) {
            bVar.a(i, c18684p44.d());
        }
        long jD = c18684p44.d();
        if (jD == 0) {
            C3343Am.g("crowdfunding_overflow_edit");
        } else if (jD == 1) {
            C3343Am.g("crowdfunding_overflow_stop");
        } else if (jD == 2) {
            C3343Am.g("crowdfunding_overflow_share");
        }
        try {
            listPopupWindow.dismiss();
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void I1() {
        Q1();
        ((C13362g6) l1()).g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ev1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CrowdfundingActivity.J1(this.a, view);
            }
        });
        ((C13362g6) l1()).d.setOnClickListener(this);
        ((C13362g6) l1()).b.setOnClickListener(this);
        ((C13362g6) l1()).h.setOnClickListener(this);
        ((C13362g6) l1()).j.setTypeface(C6011Lu2.i());
        ((C13362g6) l1()).d.setTypeface(C6011Lu2.k());
        ((C13362g6) l1()).f.setColorFilter(C5495Jo7.a.u2());
        ((C13362g6) l1()).k.setTypeface(C6011Lu2.i());
        ((C13362g6) l1()).g.setVisibility(8);
        ((C13362g6) l1()).g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CrowdfundingActivity.K1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(CrowdfundingActivity crowdfundingActivity, View view) {
        AbstractC13042fc3.i(crowdfundingActivity, "this$0");
        AbstractC5830La0 abstractC5830La0 = crowdfundingActivity.starterFragment;
        if (abstractC5830La0 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La0 = null;
        }
        abstractC5830La0.H6(4, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(CrowdfundingActivity crowdfundingActivity, View view) {
        AbstractC13042fc3.i(crowdfundingActivity, "this$0");
        AbstractC5830La0 abstractC5830La0 = crowdfundingActivity.starterFragment;
        if (abstractC5830La0 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La0 = null;
        }
        abstractC5830La0.H6(4, -1, null);
    }

    private final void L1(boolean isVisible) {
        if (isVisible) {
            ((C13362g6) l1()).b.setVisibility(0);
            ((C13362g6) l1()).d.setVisibility(8);
        } else {
            ((C13362g6) l1()).b.setVisibility(8);
            ((C13362g6) l1()).d.setVisibility(0);
        }
    }

    public static /* synthetic */ void P1(CrowdfundingActivity crowdfundingActivity, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        crowdfundingActivity.O1(z, z2, z3);
    }

    private final void Q1() {
        ViewGroup.LayoutParams layoutParams = ((C13362g6) l1()).i.getLayoutParams();
        AbstractC13042fc3.h(layoutParams, "getLayoutParams(...)");
        layoutParams.height = C1();
        ((C13362g6) l1()).i.setLayoutParams(layoutParams);
    }

    private final void T1(CrowdfundingContentInfo contentInfo, long peerUniqueId, String link) {
        this.starterFragment = C13082o.INSTANCE.a(contentInfo, peerUniqueId, link);
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        AbstractC5830La0 abstractC5830La0 = this.starterFragment;
        if (abstractC5830La0 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La0 = null;
        }
        xVarS.q(i, abstractC5830La0).i();
        if (contentInfo.d()) {
            C3343Am.g("open_crowdfunding_creator");
        } else {
            C3343Am.g("open_crowdfunding");
        }
    }

    private final void W1(long peerUniqueId) {
        Bundle extras = getIntent().getExtras();
        AbstractC5830La0 abstractC5830La0 = null;
        this.starterFragment = ViewOnClickListenerC13077j.F1.a(null, peerUniqueId, extras != null ? extras.getBoolean("from_my_bank", false) : false);
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        AbstractC5830La0 abstractC5830La02 = this.starterFragment;
        if (abstractC5830La02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            abstractC5830La0 = abstractC5830La02;
        }
        xVarS.q(i, abstractC5830La0).i();
        C3343Am.g("open_create_crowdfunding");
    }

    public final void A1() {
        getWindow().addFlags(RecyclerView.UNDEFINED_DURATION);
        getWindow().setStatusBarColor(AbstractC4043Dl1.c(this, R.color.transparent));
        getWindow().setBackgroundDrawableResource(KB5.app_bar_background_c2c);
    }

    public final C18902pS0 B1() {
        C18902pS0 c18902pS0 = this.checkMigrateCardsUseCase;
        if (c18902pS0 != null) {
            return c18902pS0;
        }
        AbstractC13042fc3.y("checkMigrateCardsUseCase");
        return null;
    }

    @Override // ir.nasim.features.payment.base.BaseActivity
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public C13362g6 n1() {
        C13362g6 c13362g6C = C13362g6.c(getLayoutInflater());
        AbstractC13042fc3.h(c13362g6C, "inflate(...)");
        return c13362g6C;
    }

    public final void M1(boolean z) {
        this.backMode = z;
        L1(z);
    }

    public final void N1(b bVar) {
        this.listItemClickListener = bVar;
    }

    public final void O1(boolean moreEnable, boolean isCreator, boolean showLinkShare) {
        if (!moreEnable) {
            ((C13362g6) l1()).h.setVisibility(8);
            return;
        }
        ((C13362g6) l1()).h.setVisibility(0);
        ImageButton imageButton = ((C13362g6) l1()).h;
        AbstractC13042fc3.h(imageButton, "more");
        E1(imageButton, isCreator, showLinkShare);
    }

    public final void S1(String str) {
        AbstractC13042fc3.i(str, "value");
        this.title = str;
        ((C13362g6) l1()).j.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5003 || requestCode == 5004) {
            AbstractC5830La0 abstractC5830La0 = this.starterFragment;
            if (abstractC5830La0 == null) {
                AbstractC13042fc3.y("starterFragment");
                abstractC5830La0 = null;
            }
            abstractC5830La0.H6(requestCode, resultCode, data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ListPopupWindow listPopupWindow;
        CrowdfundingContentInfo crowdfundingContentInfo;
        if (!AbstractC13042fc3.d(view, ((C13362g6) l1()).d)) {
            if (AbstractC13042fc3.d(view, ((C13362g6) l1()).b)) {
                onBackPressed();
                return;
            } else {
                if (!AbstractC13042fc3.d(view, ((C13362g6) l1()).h) || (listPopupWindow = this.popupWindow) == null) {
                    return;
                }
                listPopupWindow.show();
                return;
            }
        }
        AbstractC5830La0 abstractC5830La0 = this.starterFragment;
        if (abstractC5830La0 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La0 = null;
        }
        if (abstractC5830La0 instanceof ViewOnClickListenerC13074g) {
            C3343Am.g("create_crowdfunding_close_button");
        } else {
            AbstractC5830La0 abstractC5830La02 = this.starterFragment;
            if (abstractC5830La02 == null) {
                AbstractC13042fc3.y("starterFragment");
                abstractC5830La02 = null;
            }
            if ((abstractC5830La02 instanceof C13082o) && (crowdfundingContentInfo = this.contentInfo) != null) {
                if (crowdfundingContentInfo.d()) {
                    C3343Am.g("crowdfunding_creator_close_button");
                } else {
                    C3343Am.g("crowdfunding_close_button");
                }
            }
        }
        if (!this.showInfo) {
            finish();
            return;
        }
        AbstractC5830La0 abstractC5830La03 = this.starterFragment;
        if (abstractC5830La03 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La03 = null;
        }
        abstractC5830La03.H6(5001, -1, null);
    }

    @Override // ir.nasim.features.payment.view.activity.Hilt_CrowdfundingActivity, ir.nasim.features.payment.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
        A1();
        I1();
        if (savedInstanceState != null) {
            Fragment fragmentZ0 = B0().z0(savedInstanceState, "starterFragment");
            AbstractC13042fc3.g(fragmentZ0, "null cannot be cast to non-null type ir.nasim.features.payment.base.BasePaymentFragment<*>");
            this.starterFragment = (AbstractC5830La0) fragmentZ0;
            return;
        }
        if (getIntent().getExtras() == null || !getIntent().hasExtra("TYPE_PARAM")) {
            return;
        }
        long longExtra = getIntent().getLongExtra("PEER_UNIQUE_ID", -1L);
        int i = d.a[c.values()[getIntent().getIntExtra("TYPE_PARAM", 0)].ordinal()];
        if (i == 1) {
            if (longExtra == -1) {
                finish();
            }
            W1(longExtra);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String stringExtra = getIntent().getStringExtra("LINK");
            if (!getIntent().hasExtra("CONTENT_PARAM")) {
                finish();
                return;
            }
            CrowdfundingContentInfo crowdfundingContentInfo = (CrowdfundingContentInfo) getIntent().getParcelableExtra("CONTENT_PARAM");
            if (crowdfundingContentInfo == null) {
                finish();
            }
            if (longExtra == -1) {
                finish();
            }
            this.contentInfo = crowdfundingContentInfo;
            AbstractC13042fc3.f(crowdfundingContentInfo);
            T1(crowdfundingContentInfo, longExtra, stringExtra);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        super.onSaveInstanceState(outState);
        FragmentManager fragmentManagerB0 = B0();
        AbstractC5830La0 abstractC5830La0 = this.starterFragment;
        if (abstractC5830La0 == null) {
            AbstractC13042fc3.y("starterFragment");
            abstractC5830La0 = null;
        }
        fragmentManagerB0.s1(outState, "starterFragment", abstractC5830La0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        L0 = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        L0 = false;
    }
}
