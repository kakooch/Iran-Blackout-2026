package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC18940pW2;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24063xz;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.B02;
import ir.nasim.BC5;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C11474d41;
import ir.nasim.C11909dl1;
import ir.nasim.C11920dm2;
import ir.nasim.C13388g85;
import ir.nasim.C16247kx;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C22078ud6;
import ir.nasim.C23880xg2;
import ir.nasim.C24967zW1;
import ir.nasim.C3343Am;
import ir.nasim.C4512Fl2;
import ir.nasim.C5495Jo7;
import ir.nasim.C5505Jq;
import ir.nasim.C6011Lu2;
import ir.nasim.C6752Ov1;
import ir.nasim.C9199Yx2;
import ir.nasim.ED1;
import ir.nasim.EnumC16838lx;
import ir.nasim.EnumC19739qr4;
import ir.nasim.EnumC5425Jh0;
import ir.nasim.GY6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18505om2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC5552Jv1;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC8807Xk2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.QG4;
import ir.nasim.QI2;
import ir.nasim.SA2;
import ir.nasim.T46;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import ir.nasim.features.payment.view.fragment.C13081n;
import ir.nasim.features.payment.view.fragment.C13082o;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g;
import ir.nasim.features.payment.view.fragment.u;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003opqB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0000H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0000H\u0002¢\u0006\u0004\b'\u0010&J!\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020(H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u0010$J\u0017\u00104\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b4\u0010$J\u0017\u00105\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b5\u0010$J\u0017\u00106\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b6\u0010$J\u0017\u00107\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b7\u0010$J\u0017\u00108\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b8\u0010$J\u0017\u00109\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b9\u0010$J\u0017\u0010:\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u001aH\u0002¢\u0006\u0004\b=\u0010$J#\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0>2\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010D\u001a\u00020\u000fH\u0002¢\u0006\u0004\bD\u0010\u0004J\u000f\u0010E\u001a\u00020\u000fH\u0002¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010F\u001a\u00020\u000fH\u0002¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010G\u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010\u0004J\u0017\u0010H\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\bH\u0010 R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010Y\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001b\u0010_\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u00060hR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010T¨\u0006r"}, d2 = {"Lir/nasim/features/payment/view/fragment/o;", "Lir/nasim/La0;", "Lir/nasim/Yx2;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "attachToParent", "h9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/Yx2;", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "c7", "d9", "enable", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "contentInfo", "N9", "(ZLir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)V", ParameterNames.INFO, "t9", "(Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)V", "K9", "crowdfundingContentInfo", "o9", "(Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Lir/nasim/features/payment/view/fragment/o;", "l9", "()Lir/nasim/features/payment/view/fragment/o;", "m9", "", "quantity", "G9", "(Ljava/lang/Integer;Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Lir/nasim/features/payment/view/fragment/o;", "quantityChange", "b9", "(ILir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Lir/nasim/features/payment/view/fragment/o;", "H9", "(I)V", "g9", "()I", "C9", "J9", "I9", "F9", "w9", "E9", "z9", "e9", "(Landroid/view/View;)V", "content", "x9", "Landroidx/lifecycle/r;", "Lir/nasim/Iz1;", "Lai/bale/proto/Crowdfunding$ResponseGetTotalPaidAmount;", "v9", "(Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Landroidx/lifecycle/r;", "c9", "k9", "M9", "L9", "j9", "u9", "d1", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "", "e1", "J", "peerUniqueId", "", "f1", "Ljava/lang/String;", "link", "g1", "Z", "f9", "()Z", "B9", "(Z)V", "handleQuantity", "Lir/nasim/Jv1;", "h1", "Lir/nasim/Yu3;", "i9", "()Lir/nasim/Jv1;", "viewModel", "Landroid/os/CountDownTimer;", "i1", "Landroid/os/CountDownTimer;", "autoUpdateTimer", "Lir/nasim/xg2;", "j1", "Lir/nasim/xg2;", "fastThumbLoader", "Lir/nasim/features/payment/view/fragment/o$c;", "k1", "Lir/nasim/features/payment/view/fragment/o$c;", "thumbDownloadVMCallback", "l1", "isNotDownloaded", "m1", "b", "c", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.o, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13082o extends AbstractC18940pW2<C9199Yx2> {

    /* renamed from: m1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: d1, reason: from kotlin metadata */
    private CrowdfundingContentInfo content;

    /* renamed from: f1, reason: from kotlin metadata */
    private String link;

    /* renamed from: g1, reason: from kotlin metadata */
    private boolean handleQuantity;

    /* renamed from: i1, reason: from kotlin metadata */
    private CountDownTimer autoUpdateTimer;

    /* renamed from: j1, reason: from kotlin metadata */
    private C23880xg2 fastThumbLoader;

    /* renamed from: e1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ov1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13082o.O9(this.a);
        }
    });

    /* renamed from: k1, reason: from kotlin metadata */
    private final c thumbDownloadVMCallback = new c();

    /* renamed from: l1, reason: from kotlin metadata */
    private boolean isNotDownloaded = true;

    /* renamed from: ir.nasim.features.payment.view.fragment.o$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13082o a(CrowdfundingContentInfo crowdfundingContentInfo, long j, String str) {
            AbstractC13042fc3.i(crowdfundingContentInfo, "contentInfo");
            C13082o c13082o = new C13082o();
            Bundle bundle = new Bundle();
            bundle.putParcelable("param_data", crowdfundingContentInfo);
            bundle.putLong("param_unique_id", j);
            if (str != null) {
                bundle.putString("param_link", str);
            }
            c13082o.a8(bundle);
            return c13082o;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$b */
    private final class b implements InterfaceC8091Um2 {
        private final C24967zW1 a;
        private boolean b;
        private boolean c;
        final /* synthetic */ C13082o d;

        public b(C13082o c13082o, C24967zW1 c24967zW1) {
            AbstractC13042fc3.i(c24967zW1, "doc");
            this.d = c13082o;
            this.a = c24967zW1;
            this.b = true;
            this.b = JF5.g();
        }

        private final void a() {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.a.v() != null && this.a.v().a() != null) {
                AbstractC5969Lp4.d().q(this.a.v().a().b(), true, this.d.thumbDownloadVMCallback);
                return;
            }
            if (this.a.v() != null) {
                C23880xg2 c23880xg2 = this.d.fastThumbLoader;
                if (c23880xg2 == null) {
                    AbstractC13042fc3.y("fastThumbLoader");
                    c23880xg2 = null;
                }
                c23880xg2.p(this.a.v().c());
            }
        }

        private final void b() {
            if (C5505Jq.F()) {
                ((C9199Yx2) this.d.r8()).k.setImageResource(KB5.conv_media_download);
            } else {
                ((C9199Yx2) this.d.r8()).k.setImageResource(KB5.ic_lock_white_24dp);
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            this.d.isNotDownloaded = false;
            try {
                a();
                AbstractC14828iY7.l(((C9199Yx2) this.d.r8()).B);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).k);
                int i = (int) (100 * f);
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                String string = sb.toString();
                if (this.b) {
                    string = XY6.e(string);
                }
                ((C9199Yx2) this.d.r8()).C.setText(string);
                ((C9199Yx2) this.d.r8()).D.setValue(i);
                AbstractC14828iY7.l(((C9199Yx2) this.d.r8()).D);
                AbstractC14828iY7.l(((C9199Yx2) this.d.r8()).C);
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.d.isNotDownloaded = false;
            try {
                ((C9199Yx2) this.d.r8()).A.destroyDrawingCache();
                ((C9199Yx2) this.d.r8()).A.buildDrawingCache();
                Bitmap drawingCache = ((C9199Yx2) this.d.r8()).A.getDrawingCache();
                if (drawingCache != null && !drawingCache.isRecycled()) {
                    ImageView imageView = ((C9199Yx2) this.d.r8()).A;
                    AbstractC13042fc3.h(imageView, "photoImg");
                    QI2.k(drawingCache, imageView);
                }
                String descriptor = interfaceC3346Am2.getDescriptor();
                Context contextS7 = this.d.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                ((com.bumptech.glide.g) QI2.i(descriptor, contextS7, ((C9199Yx2) this.d.r8()).A.getHeight(), ((C9199Yx2) this.d.r8()).A.getWidth()).u0(new T46(C22078ud6.a(13.0f), 0))).Q0(((C9199Yx2) this.d.r8()).A);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).B);
                ((C9199Yx2) this.d.r8()).C.setText(this.b ? XY6.e("100") : "100");
                ((C9199Yx2) this.d.r8()).D.setValue(100);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).B);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).D);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).C);
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            this.d.isNotDownloaded = true;
            try {
                a();
                AbstractC14828iY7.l(((C9199Yx2) this.d.r8()).B);
                b();
                AbstractC14828iY7.l(((C9199Yx2) this.d.r8()).k);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).D);
                AbstractC14828iY7.c(((C9199Yx2) this.d.r8()).C);
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$c */
    private final class c implements InterfaceC8091Um2 {
        public c() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            String name;
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            if (C13082o.this.isNotDownloaded) {
                try {
                    C23880xg2 c23880xg2 = C13082o.this.fastThumbLoader;
                    if (c23880xg2 == null) {
                        AbstractC13042fc3.y("fastThumbLoader");
                        c23880xg2 = null;
                    }
                    c23880xg2.o(interfaceC3346Am2);
                } catch (Exception e) {
                    if (c.class.isAnonymousClass()) {
                        name = c.class.getName();
                        int length = name.length();
                        AbstractC13042fc3.f(name);
                        if (length > 23) {
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = c.class.getSimpleName();
                        int length2 = name.length();
                        AbstractC13042fc3.f(name);
                        if (length2 > 23) {
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.d(name, e);
                }
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$d */
    static final class d implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.o$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            a(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_edit_quoted_title);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.payment.view.fragment.o$d$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            b(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_edit_quoted_description);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-55965361, true, new a(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-291238899, true, new b(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(1079444893);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.p
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13082o.d.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$e */
    public static final class e extends CountDownTimer {
        e() {
            super(30000L, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:87:0x016f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final ir.nasim.C19938rB7 b(ir.nasim.features.payment.view.fragment.C13082o r8, ir.nasim.C5354Iz1 r9) {
            /*
                Method dump skipped, instructions count: 396
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.C13082o.e.b(ir.nasim.features.payment.view.fragment.o, ir.nasim.Iz1):ir.nasim.rB7");
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            C13082o c13082o = C13082o.this;
            CrowdfundingContentInfo crowdfundingContentInfo = c13082o.content;
            CrowdfundingContentInfo crowdfundingContentInfo2 = null;
            if (crowdfundingContentInfo == null) {
                AbstractC13042fc3.y("content");
                crowdfundingContentInfo = null;
            }
            c13082o.N9(true, crowdfundingContentInfo);
            ((C9199Yx2) C13082o.this.r8()).x.setVisibility(8);
            C13082o c13082o2 = C13082o.this;
            CrowdfundingContentInfo crowdfundingContentInfo3 = c13082o2.content;
            if (crowdfundingContentInfo3 == null) {
                AbstractC13042fc3.y("content");
            } else {
                crowdfundingContentInfo2 = crowdfundingContentInfo3;
            }
            androidx.lifecycle.r rVarV9 = c13082o2.v9(crowdfundingContentInfo2);
            InterfaceC18633oz3 interfaceC18633oz3P6 = C13082o.this.p6();
            final C13082o c13082o3 = C13082o.this;
            rVarV9.j(interfaceC18633oz3P6, new i(new UA2() { // from class: ir.nasim.wv1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13082o.e.b(c13082o3, (C5354Iz1) obj);
                }
            }));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$f */
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws NumberFormatException {
            CrowdfundingContentInfo crowdfundingContentInfo = null;
            try {
                if (C13082o.this.getHandleQuantity()) {
                    C13082o.this.B9(false);
                    return;
                }
                if (editable != null && editable.length() != 0) {
                    int i = Integer.parseInt(GY6.b(editable.toString()));
                    CrowdfundingContentInfo crowdfundingContentInfo2 = C13082o.this.content;
                    if (crowdfundingContentInfo2 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo2 = null;
                    }
                    if (i < crowdfundingContentInfo2.o()) {
                        C13082o c13082o = C13082o.this;
                        Integer numValueOf = Integer.valueOf(i);
                        CrowdfundingContentInfo crowdfundingContentInfo3 = C13082o.this.content;
                        if (crowdfundingContentInfo3 == null) {
                            AbstractC13042fc3.y("content");
                            crowdfundingContentInfo3 = null;
                        }
                        c13082o.G9(numValueOf, crowdfundingContentInfo3);
                        C13082o.this.B9(true);
                        if (editable.length() > 0) {
                            editable.replace(0, editable.length(), XY6.e(GY6.g(XY6.h(GY6.b(editable.toString())))));
                            return;
                        }
                        return;
                    }
                    C13082o c13082o2 = C13082o.this;
                    CrowdfundingContentInfo crowdfundingContentInfo4 = c13082o2.content;
                    if (crowdfundingContentInfo4 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo4 = null;
                    }
                    Integer numValueOf2 = Integer.valueOf(crowdfundingContentInfo4.o() - 1);
                    CrowdfundingContentInfo crowdfundingContentInfo5 = C13082o.this.content;
                    if (crowdfundingContentInfo5 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo5 = null;
                    }
                    c13082o2.G9(numValueOf2, crowdfundingContentInfo5);
                    C13082o c13082o3 = C13082o.this;
                    CrowdfundingContentInfo crowdfundingContentInfo6 = c13082o3.content;
                    if (crowdfundingContentInfo6 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo6 = null;
                    }
                    c13082o3.H9(crowdfundingContentInfo6.o() - 1);
                    return;
                }
                C13082o.this.B9(true);
                ((C9199Yx2) C13082o.this.r8()).E.setText("");
            } catch (Exception unused) {
                C13082o c13082o4 = C13082o.this;
                CrowdfundingContentInfo crowdfundingContentInfo7 = C13082o.this.content;
                if (crowdfundingContentInfo7 == null) {
                    AbstractC13042fc3.y("content");
                } else {
                    crowdfundingContentInfo = crowdfundingContentInfo7;
                }
                c13082o4.G9(1, crowdfundingContentInfo);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$g */
    public static final class g implements CrowdfundingActivity.b {
        g() {
        }

        @Override // ir.nasim.features.payment.view.activity.CrowdfundingActivity.b
        public void a(int i, int i2) {
            if (i2 == 0) {
                C13082o.this.c9();
            } else if (i2 == 1) {
                C13082o.this.M9();
            } else {
                if (i2 != 2) {
                    return;
                }
                C13082o.this.K9();
            }
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$h */
    public static final class h implements InterfaceC8807Xk2 {
        final /* synthetic */ FileReference b;
        final /* synthetic */ CrowdfundingContentInfo c;

        /* renamed from: ir.nasim.features.payment.view.fragment.o$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13082o c;
            final /* synthetic */ CrowdfundingContentInfo d;
            final /* synthetic */ InterfaceC3346Am2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13082o c13082o, CrowdfundingContentInfo crowdfundingContentInfo, InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13082o;
                this.d = crowdfundingContentInfo;
                this.e = interfaceC3346Am2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Context contextS7 = this.c.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                C22055ub3.m(contextS7, this.d.j(), this.c.peerUniqueId, ExPeerType.UNKNOWN, this.e, false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(FileReference fileReference, CrowdfundingContentInfo crowdfundingContentInfo) {
            this.b = fileReference;
            this.c = crowdfundingContentInfo;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            AbstractC5969Lp4.d().s(this.b.getFileId());
            C13082o.this.isNotDownloaded = false;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            String name;
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            C13082o.this.isNotDownloaded = false;
            try {
                AbstractC10533bm0.d(AbstractC16751lo1.a(C13082o.this), null, null, new a(C13082o.this, this.c, interfaceC3346Am2, null), 3, null);
            } catch (Exception e) {
                if (h.class.isAnonymousClass()) {
                    name = h.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = h.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, e);
            }
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            C13082o.this.isNotDownloaded = true;
            if (C5505Jq.F()) {
                AbstractC5969Lp4.d().F1(this.b);
                return;
            }
            C21753u45 c21753u45 = C21753u45.a;
            FragmentActivity fragmentActivityQ7 = C13082o.this.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            C21753u45.O0(c21753u45, fragmentActivityQ7, 0, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$i */
    static final class i implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        i(UA2 ua2) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.o$j */
    static final class j implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.o$j$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            a(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_show_paid_list_title);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.payment.view.fragment.o$j$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            b(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_show_paid_list_description);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-45538535, true, new a(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(2144114331, true, new b(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-607556135);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.q
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13082o.j.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$k */
    static final class k implements InterfaceC15796kB2 {
        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C13082o c13082o) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c13082o, "this$0");
            dialog.dismiss();
            CrowdfundingContentInfo crowdfundingContentInfo = c13082o.content;
            if (crowdfundingContentInfo == null) {
                AbstractC13042fc3.y("content");
                crowdfundingContentInfo = null;
            }
            J44 j44J = crowdfundingContentInfo.j();
            AbstractC17457n0 abstractC17457n0F = j44J.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.CrowdfundingContent");
            C11909dl1 c11909dl1V = ((ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0F).v();
            AbstractC13042fc3.f(c11909dl1V);
            AbstractC24063xz abstractC24063xzC = c11909dl1V.c();
            AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiCrowdFundingMessage");
            C16247kx c16247kx = (C16247kx) abstractC24063xzC;
            c13082o.i9().a(c13082o.peerUniqueId, j44J.i(), j44J.h(), new C16247kx(c16247kx.F(), c16247kx.u(), c16247kx.C(), c16247kx.E(), c16247kx.w(), c16247kx.y(), EnumC16838lx.STOPPED, c16247kx.z()));
            c13082o.Q7().finish();
            C3343Am.g("crowdfunding_stop_dialog_yes");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f() {
            C3343Am.g("crowdfunding_stop_dialog_no");
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C11474d41 c11474d41 = C11474d41.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c11474d41.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c11474d41.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(1842697092);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C13082o.this);
            final C13082o c13082o = C13082o.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.r
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13082o.k.d(dialog, c13082o);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.crowdfunding_stop_the_crowdfunding;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1842730468);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.payment.view.fragment.s
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13082o.k.f();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.dialog_cancel, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 100663686 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.o$l */
    static final class l implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.o$l$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            a(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_edit_quoted_title);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.payment.view.fragment.o$l$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C13082o a;

            b(C13082o c13082o) {
                this.a = c13082o;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_cant_edit_quoted_description);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1812944983, true, new a(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1577671445, true, new b(C13082o.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-1535605051);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.t
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13082o.l.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(C13082o c13082o, View view) {
        AbstractC13042fc3.i(c13082o, "this$0");
        AbstractC13042fc3.f(view);
        c13082o.e9(view);
    }

    private final C13082o C9(final CrowdfundingContentInfo crowdfundingContentInfo) {
        AbstractC14828iY7.c(((C9199Yx2) r8()).B);
        AbstractC17457n0 abstractC17457n0N = AbstractC17457n0.n(crowdfundingContentInfo.getPhotoContent());
        AbstractC13042fc3.g(abstractC17457n0N, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.DocumentContent");
        C24967zW1 c24967zW1 = (C24967zW1) abstractC17457n0N;
        if (c24967zW1 instanceof C13388g85) {
            C23880xg2 c23880xg2 = new C23880xg2(((C9199Yx2) r8()).A, EnumC5425Jh0.BITMAP_BLUR);
            this.fastThumbLoader = c23880xg2;
            c23880xg2.m();
            Drawable drawableF = AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_divider_line);
            Bitmap bitmapB = drawableF != null ? B02.b(drawableF, 0, 0, null, 7, null) : null;
            if (bitmapB != null) {
                C13388g85 c13388g85 = (C13388g85) c24967zW1;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(b6(), Bitmap.createScaledBitmap(bitmapB, c13388g85.E(), c13388g85.D(), true));
                AbstractC21710u02.h(bitmapDrawable, C5495Jo7.a.G0());
                ((C9199Yx2) r8()).A.setImageDrawable(bitmapDrawable);
            }
            C13388g85 c13388g852 = (C13388g85) c24967zW1;
            InterfaceC18505om2 interfaceC18505om2Z = c13388g852.z();
            if (interfaceC18505om2Z instanceof C11920dm2) {
                boolean zO0 = AbstractC5969Lp4.d().o0(AbstractC5969Lp4.d().Y().v().E().h().b() == EnumC19739qr4.MOBILE);
                C11335cq c11335cqD = AbstractC5969Lp4.d();
                InterfaceC18505om2 interfaceC18505om2Z2 = c13388g852.z();
                AbstractC13042fc3.g(interfaceC18505om2Z2, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
                AbstractC13042fc3.f(c11335cqD.q(((C11920dm2) interfaceC18505om2Z2).b(), zO0, new b(this, c24967zW1)));
            } else {
                if (!(interfaceC18505om2Z instanceof C4512Fl2)) {
                    throw new RuntimeException("Unknown file source type: " + c13388g852.z());
                }
                InterfaceC18505om2 interfaceC18505om2Z3 = c13388g852.z();
                AbstractC13042fc3.g(interfaceC18505om2Z3, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileLocalSource");
                Uri uriFromFile = Uri.fromFile(new File(((C4512Fl2) interfaceC18505om2Z3).c));
                AbstractC13042fc3.h(uriFromFile, "fromFile(...)");
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                AbstractC13042fc3.f(((com.bumptech.glide.g) QI2.h(uriFromFile, contextS7, ((C9199Yx2) r8()).A.getHeight(), ((C9199Yx2) r8()).A.getWidth()).u0(new T46(C22078ud6.a(13.0f), 0))).Q0(((C9199Yx2) r8()).A));
            }
            ((C9199Yx2) r8()).A.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vv1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C13082o.D9(this.a, crowdfundingContentInfo, view);
                }
            });
        } else {
            ((C9199Yx2) r8()).A.setVisibility(8);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(C13082o c13082o, CrowdfundingContentInfo crowdfundingContentInfo, View view) {
        AbstractC13042fc3.i(c13082o, "this$0");
        AbstractC13042fc3.i(crowdfundingContentInfo, "$crowdfundingContentInfo");
        c13082o.u9(crowdfundingContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o E9(CrowdfundingContentInfo crowdfundingContentInfo) {
        ((C9199Yx2) r8()).h.setProgress(crowdfundingContentInfo.m(crowdfundingContentInfo.k()));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o F9(CrowdfundingContentInfo crowdfundingContentInfo) {
        if (crowdfundingContentInfo.getStatus() == EnumC16838lx.DONE) {
            Drawable drawableF = AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_complete);
            if (drawableF != null) {
                Drawable drawableL = AbstractC21710u02.l(drawableF);
                AbstractC13042fc3.h(drawableL, "wrap(...)");
                AbstractC21710u02.h(drawableL, C5495Jo7.a.e2());
            }
            TextView textView = ((C9199Yx2) r8()).g;
            textView.setTextColor(C5495Jo7.a.e2());
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableF, (Drawable) null);
            textView.setText(h6(AbstractC12217eE5.crowdfunding_complete));
            AbstractC13042fc3.f(textView);
        } else {
            String str = Separators.PERCENT + XY6.e(String.valueOf(crowdfundingContentInfo.m(crowdfundingContentInfo.k())));
            SpannableString spannableString = new SpannableString(i6(AbstractC12217eE5.crowdfunding_completed_percent_param, str));
            spannableString.setSpan(new AbsoluteSizeSpan(AbstractC7426Rr.a.f(16.0f)), 0, str.length(), 18);
            spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.e2()), 0, str.length(), 18);
            ((C9199Yx2) r8()).g.setText(spannableString);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o G9(Integer quantity, CrowdfundingContentInfo crowdfundingContentInfo) {
        if (quantity == null) {
            return this;
        }
        long jIntValue = quantity.intValue() * crowdfundingContentInfo.getQuotaAmount();
        if (quantity.intValue() <= 1) {
            Drawable drawable = ((C9199Yx2) r8()).m.getDrawable();
            AbstractC21710u02.h(drawable, C5495Jo7.a.n0());
            ((C9199Yx2) r8()).m.setImageDrawable(drawable);
            ((C9199Yx2) r8()).m.setEnabled(false);
        } else if (quantity.intValue() >= crowdfundingContentInfo.o() - 1) {
            Drawable drawable2 = ((C9199Yx2) r8()).t.getDrawable();
            AbstractC21710u02.h(drawable2, C5495Jo7.a.n0());
            ((C9199Yx2) r8()).t.setImageDrawable(drawable2);
            ((C9199Yx2) r8()).t.setEnabled(false);
        } else {
            ((C9199Yx2) r8()).m.setEnabled(true);
            ((C9199Yx2) r8()).t.setEnabled(true);
            ((C9199Yx2) r8()).m.setImageDrawable(AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_decrease));
            ((C9199Yx2) r8()).t.setImageDrawable(AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_increase));
        }
        String strG = GY6.g(String.valueOf(jIntValue));
        SpannableString spannableString = new SpannableString(XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, strG)));
        spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.e2()), 0, strG.length(), 18);
        spannableString.setSpan(new AbsoluteSizeSpan(AbstractC7426Rr.a.f(16.0f)), 0, strG.length(), 18);
        ((C9199Yx2) r8()).s.setText(spannableString);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(int quantity) {
        ((C9199Yx2) r8()).E.setText(XY6.e(String.valueOf(quantity)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o I9(CrowdfundingContentInfo crowdfundingContentInfo) {
        String strE;
        SpannableString spannableString;
        if (crowdfundingContentInfo.getStatus() == EnumC16838lx.DONE) {
            ((C9199Yx2) r8()).J.setVisibility(8);
            ((C9199Yx2) r8()).M.setVisibility(8);
        } else if (crowdfundingContentInfo.getStatus() == EnumC16838lx.STOPPED) {
            TextView textView = ((C9199Yx2) r8()).J;
            textView.setText(h6(AbstractC12217eE5.crowdfunding_stopped));
            textView.setTextColor(C5495Jo7.a.B0());
            AbstractC13042fc3.f(textView);
        } else if (crowdfundingContentInfo.getStatus() == EnumC16838lx.EXPIRED) {
            TextView textView2 = ((C9199Yx2) r8()).J;
            textView2.setText(h6(AbstractC12217eE5.crowdfunding_incompleted));
            textView2.setTextColor(C5495Jo7.a.B0());
            AbstractC13042fc3.f(textView2);
        } else {
            CrowdfundingContentInfo.c cVarP = crowdfundingContentInfo.p();
            if (cVarP == null) {
                TextView textView3 = ((C9199Yx2) r8()).J;
                textView3.setText(h6(AbstractC12217eE5.crowdfunding_incompleted));
                textView3.setTextColor(C5495Jo7.a.B0());
                AbstractC13042fc3.f(textView3);
            } else {
                if (cVarP.a() > 0) {
                    strE = XY6.e(String.valueOf(cVarP.a()));
                    spannableString = new SpannableString(i6(AbstractC12217eE5.crowdfunding_days_remain, strE));
                } else {
                    strE = XY6.e(cVarP.b() + ":" + cVarP.c());
                    spannableString = new SpannableString(i6(AbstractC12217eE5.crowdfunding_hours_minutes_remain, strE));
                }
                if (strE != null) {
                    spannableString.setSpan(new AbsoluteSizeSpan(AbstractC7426Rr.a.f(16.0f)), 0, strE.length(), 18);
                }
                ((C9199Yx2) r8()).J.setText(spannableString);
            }
        }
        return this;
    }

    private final C13082o J9(CrowdfundingContentInfo crowdfundingContentInfo) {
        ((C9199Yx2) r8()).N.setText(crowdfundingContentInfo.getTitle());
        ((C9199Yx2) r8()).N.setSelected(true);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        C13081n.Companion aVar = C13081n.INSTANCE;
        String str = this.link;
        AbstractC13042fc3.f(str);
        aVar.a(str).K8(Q7().B0(), null);
    }

    private final void L9() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-2017377558, true, new k()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        if (!crowdfundingContentInfo.getIsForwarded()) {
            L9();
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1315725242, true, new l()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(boolean enable, CrowdfundingContentInfo contentInfo) {
        int i2 = 4;
        int i3 = 0;
        if (enable) {
            i3 = 4;
            i2 = 0;
        }
        ((C9199Yx2) r8()).b.getRoot().setVisibility(i2);
        ((C9199Yx2) r8()).f.getRoot().setVisibility(i2);
        ((C9199Yx2) r8()).I.getRoot().setVisibility(i2);
        ((C9199Yx2) r8()).i.getRoot().setVisibility(i2);
        ((C9199Yx2) r8()).c.setVisibility(i3);
        ((C9199Yx2) r8()).e.setVisibility(i3);
        ((C9199Yx2) r8()).h.setVisibility(i3);
        if (contentInfo.getStatus() != EnumC16838lx.INPROGRESS || contentInfo.p() == null || contentInfo.t()) {
            return;
        }
        ((C9199Yx2) r8()).J.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6752Ov1 O9(C13082o c13082o) {
        AbstractC13042fc3.i(c13082o, "this$0");
        FragmentActivity fragmentActivityQ7 = c13082o.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C6752Ov1) new androidx.lifecycle.G(fragmentActivityQ7).b(C6752Ov1.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o b9(int quantityChange, CrowdfundingContentInfo crowdfundingContentInfo) {
        int iG9 = g9() + quantityChange;
        G9(Integer.valueOf(iG9), crowdfundingContentInfo);
        H9(iG9);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c9() {
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        if (!crowdfundingContentInfo.getIsForwarded()) {
            k9();
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1110331710, true, new d()), 4, null).show();
    }

    private final void d9() {
        this.autoUpdateTimer = new e();
    }

    private final void e9(View view) {
        CrowdfundingContentInfo crowdfundingContentInfo = null;
        if (AbstractC13042fc3.d(view.getTag(), 0)) {
            view.setTag(1);
            ((C9199Yx2) r8()).n.setImageDrawable(AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_keyboard_arrow_up));
            ((C9199Yx2) r8()).p.setVisibility(0);
            CrowdfundingContentInfo crowdfundingContentInfo2 = this.content;
            if (crowdfundingContentInfo2 == null) {
                AbstractC13042fc3.y("content");
            } else {
                crowdfundingContentInfo = crowdfundingContentInfo2;
            }
            if (crowdfundingContentInfo.d()) {
                C3343Am.g("crowdfunding_less_description_creator");
                return;
            } else {
                C3343Am.g("crowdfunding_less_description");
                return;
            }
        }
        view.setTag(0);
        ((C9199Yx2) r8()).n.setImageDrawable(AbstractC4043Dl1.f(S7(), KB5.ic_crowdfunding_keyboard_arrow_down));
        ((C9199Yx2) r8()).p.setVisibility(8);
        CrowdfundingContentInfo crowdfundingContentInfo3 = this.content;
        if (crowdfundingContentInfo3 == null) {
            AbstractC13042fc3.y("content");
        } else {
            crowdfundingContentInfo = crowdfundingContentInfo3;
        }
        if (crowdfundingContentInfo.d()) {
            C3343Am.g("crowdfunding_more_description_creator");
        } else {
            C3343Am.g("crowdfunding_more_description");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g9() {
        Editable text = ((C9199Yx2) r8()).E.getText();
        if (text == null || text.length() == 0) {
            return 1;
        }
        return Integer.parseInt(XY6.h(((C9199Yx2) r8()).E.getText().toString()));
    }

    private final void j9() {
        u.Companion aVar = u.INSTANCE;
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        Q7().B0().s().q(BC5.fragment_container, aVar.a(crowdfundingContentInfo, this.peerUniqueId, this.link)).g(null).h();
    }

    private final void k9() {
        ViewOnClickListenerC13074g.Companion aVar = ViewOnClickListenerC13074g.INSTANCE;
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        Q7().B0().s().q(BC5.fragment_container, aVar.a(crowdfundingContentInfo, this.peerUniqueId)).g(null).h();
    }

    private final C13082o l9() {
        ((C9199Yx2) r8()).getRoot().getLayoutTransition().enableTransitionType(4);
        return this;
    }

    private final C13082o m9() {
        ((C9199Yx2) r8()).N.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).J.setTypeface(C6011Lu2.k());
        ((C9199Yx2) r8()).g.setTypeface(C6011Lu2.k());
        ((C9199Yx2) r8()).c.setTypeface(C6011Lu2.k());
        ((C9199Yx2) r8()).q.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).p.setTypeface(C6011Lu2.k());
        ((C9199Yx2) r8()).w.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).z.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).E.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).G.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).H.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).r.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).s.setTypeface(C6011Lu2.i());
        ((C9199Yx2) r8()).E.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.nv1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C13082o.n9(this.a, view, z);
            }
        });
        EditText editText = ((C9199Yx2) r8()).E;
        AbstractC13042fc3.h(editText, "quantityTxt");
        editText.addTextChangedListener(new f());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n9(C13082o c13082o, View view, boolean z) {
        AbstractC13042fc3.i(c13082o, "this$0");
        if (z) {
            ((C9199Yx2) c13082o.r8()).F.setStrokeWidth(AbstractC7426Rr.a.f(1.5f));
            ((C9199Yx2) c13082o.r8()).F.setStrokeColor(C5495Jo7.a.t2());
        } else {
            ((C9199Yx2) c13082o.r8()).F.setStrokeWidth(AbstractC7426Rr.a.f(1.0f));
            ((C9199Yx2) c13082o.r8()).F.setStrokeColor(C5495Jo7.a.t0());
        }
    }

    private final C13082o o9(final CrowdfundingContentInfo crowdfundingContentInfo) {
        String strG = GY6.g(String.valueOf(crowdfundingContentInfo.getQuotaAmount()));
        SpannableString spannableString = new SpannableString(XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, strG)));
        spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.g0()), 0, strG.length(), 18);
        ((C9199Yx2) r8()).H.setText(spannableString);
        ((C9199Yx2) r8()).t.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13082o.p9(this.a, crowdfundingContentInfo, view);
            }
        });
        ((C9199Yx2) r8()).m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13082o.q9(this.a, crowdfundingContentInfo, view);
            }
        });
        ((C9199Yx2) r8()).x.setVisibility(0);
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.tv1
            @Override // java.lang.Runnable
            public final void run() {
                C13082o.r9(this.a);
            }
        }, 100L);
        ((C9199Yx2) r8()).y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13082o.s9(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p9(C13082o c13082o, CrowdfundingContentInfo crowdfundingContentInfo, View view) {
        AbstractC13042fc3.i(c13082o, "this$0");
        AbstractC13042fc3.i(crowdfundingContentInfo, "$crowdfundingContentInfo");
        c13082o.b9(1, crowdfundingContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q9(C13082o c13082o, CrowdfundingContentInfo crowdfundingContentInfo, View view) {
        AbstractC13042fc3.i(c13082o, "this$0");
        AbstractC13042fc3.i(crowdfundingContentInfo, "$crowdfundingContentInfo");
        c13082o.b9(-1, crowdfundingContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r9(C13082o c13082o) {
        AbstractC13042fc3.i(c13082o, "this$0");
        ((C9199Yx2) c13082o.r8()).u.setPadding(0, 0, 0, ((C9199Yx2) c13082o.r8()).x.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s9(C13082o c13082o, View view) {
        AbstractC13042fc3.i(c13082o, "this$0");
        C3343Am.g("crowdfunding_pay_button");
        CardPaymentActivity.Companion aVar = CardPaymentActivity.INSTANCE;
        Context contextS7 = c13082o.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        CrowdfundingContentInfo crowdfundingContentInfo = c13082o.content;
        CrowdfundingContentInfo crowdfundingContentInfo2 = null;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        String cardNumber = crowdfundingContentInfo.getCardNumber();
        CrowdfundingContentInfo crowdfundingContentInfo3 = c13082o.content;
        if (crowdfundingContentInfo3 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo3 = null;
        }
        Long lValueOf = Long.valueOf(crowdfundingContentInfo3.getQuotaAmount() * c13082o.g9());
        CrowdfundingContentInfo crowdfundingContentInfo4 = c13082o.content;
        if (crowdfundingContentInfo4 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo4 = null;
        }
        byte[] byteArray = crowdfundingContentInfo4.j().toByteArray();
        AbstractC13042fc3.h(byteArray, "toByteArray(...)");
        long j2 = c13082o.peerUniqueId;
        CrowdfundingContentInfo crowdfundingContentInfo5 = c13082o.content;
        if (crowdfundingContentInfo5 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo5 = null;
        }
        long jH = crowdfundingContentInfo5.j().h();
        CrowdfundingContentInfo crowdfundingContentInfo6 = c13082o.content;
        if (crowdfundingContentInfo6 == null) {
            AbstractC13042fc3.y("content");
        } else {
            crowdfundingContentInfo2 = crowdfundingContentInfo6;
        }
        aVar.k(contextS7, cardNumber, lValueOf, byteArray, new HistoryMessageData(j2, jH, crowdfundingContentInfo2.j().i()));
        c13082o.Q7().finish();
    }

    private final void t9(CrowdfundingContentInfo info) {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.g(fragmentActivityQ7, "null cannot be cast to non-null type ir.nasim.features.payment.view.activity.CrowdfundingActivity");
        CrowdfundingActivity crowdfundingActivity = (CrowdfundingActivity) fragmentActivityQ7;
        crowdfundingActivity.M1(true);
        boolean z = (info.t() || info.getStatus() != EnumC16838lx.INPROGRESS || info.p() == null) ? false : true;
        if (z && !info.d() && this.link == null) {
            z = false;
        }
        if (z) {
            crowdfundingActivity.O1(true, info.d(), this.link != null);
        }
        crowdfundingActivity.N1(new g());
        crowdfundingActivity.S1(h6(AbstractC12217eE5.crowdfunding_title));
    }

    private final void u9(CrowdfundingContentInfo info) {
        AbstractC17457n0 abstractC17457n0N = AbstractC17457n0.n(info.getPhotoContent());
        AbstractC13042fc3.g(abstractC17457n0N, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.DocumentContent");
        C24967zW1 c24967zW1 = (C24967zW1) abstractC17457n0N;
        if (c24967zW1.z() instanceof C11920dm2) {
            InterfaceC18505om2 interfaceC18505om2Z = c24967zW1.z();
            AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
            FileReference fileReferenceB = ((C11920dm2) interfaceC18505om2Z).b();
            AbstractC5969Lp4.d().v1(fileReferenceB.getFileId(), fileReferenceB.getAccessHash(), new h(fileReferenceB, info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.lifecycle.r v9(CrowdfundingContentInfo crowdfundingContentInfo) {
        J44 j44J = crowdfundingContentInfo.j();
        InterfaceC5552Jv1 interfaceC5552Jv1I9 = i9();
        C11458d25 c11458d25R = C11458d25.r(this.peerUniqueId);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        return interfaceC5552Jv1I9.k0(c11458d25R, j44J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13082o w9(CrowdfundingContentInfo crowdfundingContentInfo) {
        String strE = XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, GY6.g(String.valueOf(crowdfundingContentInfo.k()))));
        SpannableString spannableString = new SpannableString(i6(AbstractC12217eE5.crowdfunding_paid_amount_from_whole_amount, strE, XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, GY6.g(String.valueOf(crowdfundingContentInfo.getAmount()))))));
        spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.e2()), 0, strE.length(), 18);
        ((C9199Yx2) r8()).c.setText(spannableString);
        return this;
    }

    private final C13082o x9(final CrowdfundingContentInfo content) {
        if (content.d()) {
            ((C9199Yx2) r8()).l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pv1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C13082o.y9(content, this, view);
                }
            });
        } else {
            ((C9199Yx2) r8()).l.setVisibility(4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y9(CrowdfundingContentInfo crowdfundingContentInfo, C13082o c13082o, View view) {
        AbstractC13042fc3.i(crowdfundingContentInfo, "$content");
        AbstractC13042fc3.i(c13082o, "this$0");
        if (crowdfundingContentInfo.getIsForwarded()) {
            Context contextS7 = c13082o.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = c13082o.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-983247798, true, c13082o.new j()), 4, null).show();
        } else {
            c13082o.j9();
        }
        C3343Am.g("crowdfunding_button_contributors");
    }

    private final C13082o z9(CrowdfundingContentInfo crowdfundingContentInfo) {
        ((C9199Yx2) r8()).p.setText(crowdfundingContentInfo.getDescription());
        CardView cardView = ((C9199Yx2) r8()).o;
        int i2 = 0;
        if (!crowdfundingContentInfo.d()) {
            ((C9199Yx2) r8()).o.setTag(0);
            CardView cardView2 = ((C9199Yx2) r8()).o;
            AbstractC13042fc3.h(cardView2, "descriptionCard");
            e9(cardView2);
            i2 = 1;
        }
        cardView.setTag(i2);
        ((C9199Yx2) r8()).o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13082o.A9(this.a, view);
            }
        });
        return this;
    }

    public final void B9(boolean z) {
        this.handleQuantity = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            if (bundleE5.getParcelable("param_data") == null) {
                Q7().finish();
            }
            Parcelable parcelable = bundleE5.getParcelable("param_data");
            AbstractC13042fc3.f(parcelable);
            this.content = (CrowdfundingContentInfo) parcelable;
            if (bundleE5.getLong("param_unique_id", -1L) == -1) {
                Q7().finish();
            }
            this.link = bundleE5.getString("param_link");
            this.peerUniqueId = bundleE5.getLong("param_unique_id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        CountDownTimer countDownTimer = this.autoUpdateTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: f9, reason: from getter */
    public final boolean getHandleQuantity() {
        return this.handleQuantity;
    }

    @Override // ir.nasim.AbstractC5830La0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        t9(crowdfundingContentInfo);
        CountDownTimer countDownTimer = this.autoUpdateTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: h9, reason: merged with bridge method [inline-methods] */
    public C9199Yx2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C9199Yx2 c9199Yx2C = C9199Yx2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c9199Yx2C, "inflate(...)");
        return c9199Yx2C;
    }

    public final InterfaceC5552Jv1 i9() {
        return (InterfaceC5552Jv1) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        C13082o c13082oM9 = l9().m9();
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        CrowdfundingContentInfo crowdfundingContentInfo2 = null;
        if (crowdfundingContentInfo == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo = null;
        }
        C13082o c13082oC9 = c13082oM9.C9(crowdfundingContentInfo);
        CrowdfundingContentInfo crowdfundingContentInfo3 = this.content;
        if (crowdfundingContentInfo3 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo3 = null;
        }
        C13082o c13082oJ9 = c13082oC9.J9(crowdfundingContentInfo3);
        CrowdfundingContentInfo crowdfundingContentInfo4 = this.content;
        if (crowdfundingContentInfo4 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo4 = null;
        }
        C13082o c13082oI9 = c13082oJ9.I9(crowdfundingContentInfo4);
        CrowdfundingContentInfo crowdfundingContentInfo5 = this.content;
        if (crowdfundingContentInfo5 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo5 = null;
        }
        C13082o c13082oZ9 = c13082oI9.z9(crowdfundingContentInfo5);
        CrowdfundingContentInfo crowdfundingContentInfo6 = this.content;
        if (crowdfundingContentInfo6 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo6 = null;
        }
        C13082o c13082oF9 = c13082oZ9.F9(crowdfundingContentInfo6);
        CrowdfundingContentInfo crowdfundingContentInfo7 = this.content;
        if (crowdfundingContentInfo7 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo7 = null;
        }
        C13082o c13082oW9 = c13082oF9.w9(crowdfundingContentInfo7);
        CrowdfundingContentInfo crowdfundingContentInfo8 = this.content;
        if (crowdfundingContentInfo8 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo8 = null;
        }
        C13082o c13082oE9 = c13082oW9.E9(crowdfundingContentInfo8);
        CrowdfundingContentInfo crowdfundingContentInfo9 = this.content;
        if (crowdfundingContentInfo9 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo9 = null;
        }
        c13082oE9.x9(crowdfundingContentInfo9);
        CrowdfundingContentInfo crowdfundingContentInfo10 = this.content;
        if (crowdfundingContentInfo10 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo10 = null;
        }
        if (!crowdfundingContentInfo10.d()) {
            CrowdfundingContentInfo crowdfundingContentInfo11 = this.content;
            if (crowdfundingContentInfo11 == null) {
                AbstractC13042fc3.y("content");
                crowdfundingContentInfo11 = null;
            }
            if (crowdfundingContentInfo11.getStatus() == EnumC16838lx.INPROGRESS) {
                CrowdfundingContentInfo crowdfundingContentInfo12 = this.content;
                if (crowdfundingContentInfo12 == null) {
                    AbstractC13042fc3.y("content");
                    crowdfundingContentInfo12 = null;
                }
                if (crowdfundingContentInfo12.p() != null) {
                    CrowdfundingContentInfo crowdfundingContentInfo13 = this.content;
                    if (crowdfundingContentInfo13 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo13 = null;
                    }
                    C13082o c13082oO9 = o9(crowdfundingContentInfo13);
                    CrowdfundingContentInfo crowdfundingContentInfo14 = this.content;
                    if (crowdfundingContentInfo14 == null) {
                        AbstractC13042fc3.y("content");
                        crowdfundingContentInfo14 = null;
                    }
                    c13082oO9.b9(1, crowdfundingContentInfo14);
                }
            }
        }
        CrowdfundingContentInfo crowdfundingContentInfo15 = this.content;
        if (crowdfundingContentInfo15 == null) {
            AbstractC13042fc3.y("content");
            crowdfundingContentInfo15 = null;
        }
        if (crowdfundingContentInfo15.getStatus() == EnumC16838lx.INPROGRESS) {
            CrowdfundingContentInfo crowdfundingContentInfo16 = this.content;
            if (crowdfundingContentInfo16 == null) {
                AbstractC13042fc3.y("content");
            } else {
                crowdfundingContentInfo2 = crowdfundingContentInfo16;
            }
            if (crowdfundingContentInfo2.p() != null) {
                d9();
            }
        }
    }
}
