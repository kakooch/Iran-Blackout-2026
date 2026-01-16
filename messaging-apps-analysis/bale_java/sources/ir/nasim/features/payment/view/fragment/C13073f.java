package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10333bU0;
import ir.nasim.C13353g50;
import ir.nasim.C13396g93;
import ir.nasim.C13944h50;
import ir.nasim.C18683p43;
import ir.nasim.C19274q43;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C20514s83;
import ir.nasim.C21753u45;
import ir.nasim.C22042ua0;
import ir.nasim.C22055ub3;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C4053Dm2;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C6199Mp1;
import ir.nasim.C7483Rx2;
import ir.nasim.ED1;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC21545tj3;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC5966Lp1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.KB5;
import ir.nasim.QG4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.C13073f;
import ir.nasim.features.payment.view.fragment.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0002\u0081\u0001\b\u0007\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0086\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\fH\u0016¢\u0006\u0004\b/\u0010\tJ\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0004\b8\u00106J\u000f\u00109\u001a\u00020\u0000H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0000H\u0002¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u0000H\u0002¢\u0006\u0004\b<\u0010:J\u000f\u0010=\u001a\u00020\u0000H\u0002¢\u0006\u0004\b=\u0010:J\u000f\u0010>\u001a\u00020\u0000H\u0002¢\u0006\u0004\b>\u0010:J\u000f\u0010?\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010\tJ\u000f\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010\tJ\u000f\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010\tJ\u000f\u0010B\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010\tJ'\u0010F\u001a\u00020\f2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020*0Cj\b\u0012\u0004\u0012\u00020*`DH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bH\u0010-J'\u0010J\u001a\u00020\f2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020!0Cj\b\u0012\u0004\u0012\u00020!`DH\u0002¢\u0006\u0004\bJ\u0010GJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001c\u0010f\u001a\n c*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020!0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020!0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010tR\u0016\u0010z\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0087\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/f;", "Lir/nasim/ua0;", "Lir/nasim/g50$d;", "Lir/nasim/g50$e;", "Lir/nasim/g50$c;", "Lir/nasim/t40;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "Lir/nasim/q43$a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/p43;", "item", "y0", "(Lir/nasim/p43;)V", "type", "Ha", "(I)V", "Lir/nasim/features/payment/data/model/BankCreditCard;", ParameterNames.CARD, "i5", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Z0", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "", "cardNumber", "m3", "(Ljava/lang/String;)V", "a0", "Q", "", "B1", "()Z", "Lir/nasim/tj3;", "listener", "oa", "(Lir/nasim/tj3;)V", "jobListener", "la", "sa", "()Lir/nasim/features/payment/view/fragment/f;", "xa", "wa", "ra", "ta", "Ea", "ka", "Fa", "Da", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "paths", "ja", "(Ljava/util/ArrayList;)V", "Ja", "list", "Ga", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Aa", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "", "c1", "J", "peerUniqueId", "Lir/nasim/q43;", "d1", "Lir/nasim/q43;", "importedPhotoAdapter", "Lir/nasim/Lp1;", "e1", "Lir/nasim/Yu3;", "na", "()Lir/nasim/Lp1;", "viewModel", "Lir/nasim/Rx2;", "f1", "Lir/nasim/bW7;", "ma", "()Lir/nasim/Rx2;", "binding", "kotlin.jvm.PlatformType", "g1", "Ljava/lang/String;", "photoExternalFile", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "h1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "Lir/nasim/features/payment/data/response/Bank;", "i1", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "Lir/nasim/g50;", "j1", "Lir/nasim/g50;", "suggestAdapter", "k1", "Ljava/util/ArrayList;", "suggestList", "l1", "savedList", "m1", "Z", "isConfigLoaded", "n1", "isSavedListLoaded", "Lir/nasim/bU0;", "o1", "Lir/nasim/bU0;", "loadingInitData", "ir/nasim/features/payment/view/fragment/f$b", "p1", "Lir/nasim/features/payment/view/fragment/f$b;", "cardTextWatcher", "q1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.f, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13073f extends C22042ua0 implements C13353g50.d, C13353g50.e, C13353g50.c, InterfaceC21074t40, CardPaymentActivity.b, C19274q43.a {

    /* renamed from: h1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: i1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: m1, reason: from kotlin metadata */
    private boolean isConfigLoaded;

    /* renamed from: n1, reason: from kotlin metadata */
    private boolean isSavedListLoaded;
    static final /* synthetic */ InterfaceC5239Im3[] r1 = {AbstractC10882cM5.i(new C25226zw5(C13073f.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCreateAlbumMoneyRequestBinding;", 0))};

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: d1, reason: from kotlin metadata */
    private C19274q43 importedPhotoAdapter = new C19274q43();

    /* renamed from: e1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Dp1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13073f.Ka(this.a);
        }
    });

    /* renamed from: f1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new C1204f(), AbstractC20046rN7.c());

    /* renamed from: g1, reason: from kotlin metadata */
    private final String photoExternalFile = C4053Dm2.l("capture", "jpg");

    /* renamed from: j1, reason: from kotlin metadata */
    private final C13353g50 suggestAdapter = new C13353g50(null, null, null, null, null, 31, null);

    /* renamed from: k1, reason: from kotlin metadata */
    private final ArrayList suggestList = new ArrayList();

    /* renamed from: l1, reason: from kotlin metadata */
    private final ArrayList savedList = new ArrayList();

    /* renamed from: o1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: p1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: ir.nasim.features.payment.view.fragment.f$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13073f a(long j) {
            C13073f c13073f = new C13073f();
            Bundle bundle = new Bundle();
            bundle.putLong("ARG_PEER_UNIQUE_ID", j);
            c13073f.a8(bundle);
            return c13073f;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.f$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C13073f.this.ma().g.setVisibility(0);
            if (editable == null) {
                C13073f c13073f = C13073f.this;
                c13073f.Ga(c13073f.suggestList);
                C13073f.this.suggestAdapter.notifyDataSetChanged();
                return;
            }
            if (ZY6.a(editable.toString()).length() < 6) {
                C13073f.this.ma().o.setMaxLength(-1);
                C13073f.this.ma().o.setErrorStroke(false);
                C13073f.this.ma().o.setDrawableStart(AbstractC4043Dl1.f(C13073f.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                C13073f.this.ma().o.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
            } else if (ZY6.a(editable.toString()).length() >= 6) {
                C20481s50 c20481s50 = C20481s50.a;
                String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                Bank bankC = c20481s50.c(strSubstring);
                if (bankC == null) {
                    C13073f.this.ma().o.setMaxLength(7);
                    CustomInputView customInputView = C13073f.this.ma().o;
                    String strH6 = C13073f.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    customInputView.setInputError(strH6);
                } else {
                    if (editable.length() == 19) {
                        C13073f.this.ma().o.setMaxLength(19);
                        C13073f.this.ma().g.setVisibility(8);
                    }
                    if (bankC.getDestinationStatus().isEnable()) {
                        C13073f.this.ma().o.setErrorStroke(false);
                        C13073f.this.destBank = bankC;
                    } else {
                        C13073f.this.ma().o.setMaxLength(7);
                        CustomInputView customInputView2 = C13073f.this.ma().o;
                        String strI6 = C13073f.this.i6(AbstractC12217eE5.card_payment_unable_dest, bankC.getName());
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        customInputView2.setStartDrawableError(strI6);
                    }
                    Drawable drawableF = null;
                    C13073f.this.ma().o.setDrawableStartTint(null);
                    CustomInputView customInputView3 = C13073f.this.ma().o;
                    Integer drawableId = bankC.getDrawableId();
                    if (drawableId != null) {
                        C13073f c13073f2 = C13073f.this;
                        drawableF = AbstractC4043Dl1.f(c13073f2.S7(), drawableId.intValue());
                    }
                    customInputView3.setDrawableStart(drawableF);
                }
            }
            C13073f.this.Ja(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.f$c */
    public static final class c implements x.a {
        final /* synthetic */ BankCreditCard b;

        c(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C10333bU0 c10333bU0, C13073f c13073f, C5354Iz1 c5354Iz1) {
            AbstractC13042fc3.i(c10333bU0, "$loadingFragment");
            AbstractC13042fc3.i(c13073f, "this$0");
            c10333bU0.u8();
            C13073f.pa(c13073f, null, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            final C10333bU0 c10333bU0 = new C10333bU0();
            c10333bU0.K8(C13073f.this.Q7().B0(), null);
            androidx.lifecycle.r rVarQ = C13073f.this.na().Q(this.b);
            InterfaceC18633oz3 interfaceC18633oz3P6 = C13073f.this.p6();
            final C13073f c13073f = C13073f.this;
            rVarQ.j(interfaceC18633oz3P6, new e(new UA2() { // from class: ir.nasim.Kp1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13073f.c.c(c10333bU0, c13073f, (C5354Iz1) obj);
                }
            }));
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.f$d */
    public static final class d implements InterfaceC21545tj3 {
        d() {
        }

        @Override // ir.nasim.InterfaceC21545tj3
        public void a() {
            C13073f.this.wa().sa().xa().wa().ra().ta();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.f$e */
    static final class e implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        e(UA2 ua2) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.f$f, reason: collision with other inner class name */
    public static final class C1204f extends AbstractC8614Ws3 implements UA2 {
        public C1204f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C7483Rx2.a(fragment.V7());
        }
    }

    private final void Aa(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Hp1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C13073f.Ba(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(C13073f c13073f, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(c13073f, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            c13073f.ma().p.V((int) customInputView.getX(), (int) customInputView.getY());
        }
        try {
            C3343Am.g(customInputView.getTag().toString());
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(C13073f c13073f, String str, String str2) {
        AbstractC13042fc3.i(c13073f, "this$0");
        if (str != null) {
            c13073f.ja(AbstractC10360bX0.g(str));
        }
    }

    private final void Da() {
        FragmentActivity fragmentActivityQ7 = Q7();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        fragmentActivityQ7.startActivityForResult(C22055ub3.j(contextS7, false, false, true, false), 5004);
    }

    private final void Ea() {
        if (this.photoExternalFile == null) {
            Toast.makeText(G5(), AbstractC12217eE5.toast_no_sdcard, 1).show();
            return;
        }
        if (AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") == 0) {
            ka();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.i0(c21753u45, fragmentActivityQ7, 5001, C21753u45.d.f, Integer.valueOf(AbstractC12217eE5.card_payment_camera_permission_desctiption), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
        FragmentActivity fragmentActivityQ72 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
        C21753u45.P0(c21753u45, fragmentActivityQ72, 5002, Integer.valueOf(AbstractC12217eE5.card_payment_external_storage_permission_desctiption), null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 8, null);
    }

    private final void Fa() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Da();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.P0(c21753u45, fragmentActivityQ7, 5002, Integer.valueOf(AbstractC12217eE5.card_payment_external_storage_permission_desctiption), null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(ArrayList list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList.add(list.get(0));
            arrayList.add(list.get(1));
            String strH6 = h6(AbstractC12217eE5.card_payment_show_all_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            arrayList.add(new C13944h50(SetUpdatesStruct$ComposedUpdates.CHANNEL_NICK_CHANGED_FIELD_NUMBER, strH6));
        } else {
            arrayList.addAll(list);
            String strH62 = h6(AbstractC12217eE5.card_payment_add_source_card);
            AbstractC13042fc3.h(strH62, "getString(...)");
            arrayList.add(new C13944h50(SetRpcStruct$ComposedRpc.JOIN_PUBLIC_GROUP_FIELD_NUMBER, strH62));
        }
        this.suggestAdapter.B(arrayList);
        this.suggestAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(C13073f c13073f) {
        AbstractC13042fc3.i(c13073f, "this$0");
        c13073f.ma().n.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : this.savedList) {
                if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                    arrayList.add(bankCreditCard);
                }
            }
            Ga(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6199Mp1 Ka(C13073f c13073f) {
        AbstractC13042fc3.i(c13073f, "this$0");
        FragmentActivity fragmentActivityQ7 = c13073f.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C6199Mp1) new androidx.lifecycle.G(fragmentActivityQ7).b(C6199Mp1.class);
    }

    private final void ja(ArrayList paths) {
        int size = this.importedPhotoAdapter.z().size() - 1;
        Iterator it = paths.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            this.importedPhotoAdapter.z().add(new C18683p43(str, GY6.e(str)));
        }
        if (ma().l.getVisibility() != 0) {
            ma().l.setVisibility(0);
        }
        if (ma().e.getVisibility() != 4) {
            ma().e.setVisibility(4);
        }
        if (ma().c.getVisibility() != 0) {
            ma().c.setVisibility(0);
        }
        this.importedPhotoAdapter.notifyItemRangeInserted(size, paths.size());
    }

    private final void ka() {
        Uri uriH = FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.photoExternalFile));
        FragmentActivity fragmentActivityQ7 = Q7();
        Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriH);
        AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
        fragmentActivityQ7.startActivityForResult(intentPutExtra, 5003);
    }

    private final void la(InterfaceC21545tj3 jobListener) {
        if (this.isConfigLoaded && this.isSavedListLoaded) {
            if (jobListener != null) {
                jobListener.a();
            }
            AbstractC16494lN1.a(this.loadingInitData);
            ma().p.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7483Rx2 ma() {
        return (C7483Rx2) this.binding.a(this, r1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC5966Lp1 na() {
        return (InterfaceC5966Lp1) this.viewModel.getValue();
    }

    private final void oa(final InterfaceC21545tj3 listener) {
        try {
            this.isConfigLoaded = false;
            this.isSavedListLoaded = false;
            C10333bU0 c10333bU0 = this.loadingInitData;
            FragmentManager fragmentManagerB0 = Q7().B0();
            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
            AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
            na().getConfig().j(p6(), new e(new UA2() { // from class: ir.nasim.Bp1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13073f.qa(this.a, listener, (CardToCardConfig) obj);
                }
            }));
            ArrayList arrayListO0 = na().o0();
            if (arrayListO0 != null) {
                Ga(arrayListO0);
                this.savedList.addAll(arrayListO0);
                this.isSavedListLoaded = true;
                la(listener);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    static /* synthetic */ void pa(C13073f c13073f, InterfaceC21545tj3 interfaceC21545tj3, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC21545tj3 = null;
        }
        c13073f.oa(interfaceC21545tj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C13073f c13073f, InterfaceC21545tj3 interfaceC21545tj3, CardToCardConfig cardToCardConfig) {
        AbstractC13042fc3.i(c13073f, "this$0");
        c13073f.config = cardToCardConfig;
        c13073f.isConfigLoaded = true;
        c13073f.la(interfaceC21545tj3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13073f ra() {
        ma().h.setAdapter(this.suggestAdapter);
        RecyclerView recyclerView = ma().h;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        this.suggestAdapter.E(this);
        this.suggestAdapter.C(this);
        this.suggestAdapter.D(this);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13073f sa() {
        ma().q.setTypeface(C6011Lu2.i());
        ma().s.setTypeface(C6011Lu2.i());
        ma().j.setTypeface(C6011Lu2.i());
        ma().b.setTypeface(C6011Lu2.i());
        ma().c.setTypeface(C6011Lu2.k());
        ma().d.setTypeface(C6011Lu2.k());
        ma().f.setTypeface(C6011Lu2.k());
        ma().m.setHintTypeFace(C6011Lu2.k());
        ma().m.setTextTypeFace(C6011Lu2.k());
        ma().n.setTextTypeFace(C6011Lu2.k());
        ma().n.setTextTypeFace(C6011Lu2.k());
        ma().o.setTextTypeFace(C6011Lu2.k());
        ma().o.setTextTypeFace(C6011Lu2.k());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13073f ta() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.nasim.Gp1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13073f.ua(this.a, view);
            }
        };
        ma().e.setOnClickListener(onClickListener);
        this.importedPhotoAdapter.C(this);
        ma().l.setAdapter(this.importedPhotoAdapter);
        ma().c.setVisibility(8);
        ma().c.setOnClickListener(onClickListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(final C13073f c13073f, View view) {
        AbstractC13042fc3.i(c13073f, "this$0");
        new AlertDialog.Builder(c13073f.S7(), AbstractC23035wE5.AlertDialogStyle).setItems(new CharSequence[]{c13073f.Q7().getString(AbstractC12217eE5.card_payment_pick_photo_camera), c13073f.Q7().getString(AbstractC12217eE5.card_payment_pick_photo_gallery)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.Ip1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C13073f.va(this.a, dialogInterface, i);
            }
        }).show().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(C13073f c13073f, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(c13073f, "this$0");
        if (i == 0) {
            c13073f.Ea();
        } else {
            if (i != 1) {
                return;
            }
            c13073f.Fa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13073f wa() {
        ma().m.requestFocus();
        CustomInputView customInputView = ma().m;
        AbstractC13042fc3.h(customInputView, "inputAmount");
        Aa(customInputView);
        CustomInputView customInputView2 = ma().n;
        AbstractC13042fc3.h(customInputView2, "inputDescription");
        Aa(customInputView2);
        CustomInputView customInputView3 = ma().o;
        AbstractC13042fc3.h(customInputView3, "inputDestCardNumber");
        Aa(customInputView3);
        CustomInputView customInputView4 = ma().m;
        CustomInputView customInputView5 = ma().m;
        AbstractC13042fc3.h(customInputView5, "inputAmount");
        customInputView4.b(new C20514s83(customInputView5));
        CustomInputView customInputView6 = ma().o;
        CustomInputView customInputView7 = ma().o;
        AbstractC13042fc3.h(customInputView7, "inputDestCardNumber");
        customInputView6.b(new C13396g93(customInputView7));
        ma().o.b(this.cardTextWatcher);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13073f xa() {
        ma().r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ep1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13073f.ya(this.a, view);
            }
        });
        ma().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fp1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13073f.za(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(C13073f c13073f, View view) {
        AbstractC13042fc3.i(c13073f, "this$0");
        c13073f.Ha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(C13073f c13073f, View view) {
        AbstractC13042fc3.i(c13073f, "this$0");
        c13073f.Ha(1);
    }

    @Override // ir.nasim.features.payment.view.activity.CardPaymentActivity.b
    public boolean B1() {
        if (!u6() || ma().g.getVisibility() != 0) {
            return true;
        }
        ma().g.setVisibility(8);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 5003) {
            String str = this.photoExternalFile;
            if (str == null || str.length() == 0) {
                return;
            }
            AbstractC17543n85.a(this, A5(), this.photoExternalFile, 0, true, new AbstractC17543n85.b() { // from class: ir.nasim.Cp1
                @Override // ir.nasim.AbstractC17543n85.b
                public final void a(String str2, String str3) {
                    C13073f.Ca(this.a, str2, str3);
                }
            });
            return;
        }
        if (requestCode != 5004) {
            return;
        }
        ArrayList<String> arrayList = null;
        ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra("PHOTOS") : null;
        if (stringArrayListExtra != null && (!stringArrayListExtra.isEmpty())) {
            arrayList = stringArrayListExtra;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ja(arrayList);
    }

    public final void Ha(int type) {
        if (type == 0) {
            ma().s.setChecked(true);
            ma().r.setStrokeWidth(2);
            ma().j.setChecked(false);
            ma().i.setStrokeWidth(0);
            ma().m.setVisibility(0);
            ma().m.requestFocus();
            return;
        }
        if (type != 1) {
            return;
        }
        ma().s.setChecked(false);
        ma().r.setStrokeWidth(0);
        ma().j.setChecked(true);
        ma().i.setStrokeWidth(2);
        ma().n.post(new Runnable() { // from class: ir.nasim.Jp1
            @Override // java.lang.Runnable
            public final void run() {
                C13073f.Ia(this.a);
            }
        });
        ma().m.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.peerUniqueId = bundleE5.getLong("ARG_PEER_UNIQUE_ID");
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void Q() {
        pa(this, null, 1, null);
    }

    @Override // ir.nasim.C13353g50.d
    public void Z0(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        ma().g.setVisibility(8);
        if (card.getType() == BankCreditCard.c.a) {
            a0(card.getNumber());
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void a0(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        ma().o.setMaxLength(19);
        ma().o.setText(cardNumber);
        ma().o.setErrorStroke(false);
        ma().o.setSelection(19);
        Ga(new ArrayList());
    }

    @Override // ir.nasim.C13353g50.e
    public void i5(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        if (card.getType() == BankCreditCard.c.a) {
            x xVar = new x();
            xVar.S8(new c(card));
            xVar.K8(Q7().B0(), null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        oa(new d());
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        ma().o.setMaxLength(19);
        ma().o.setText(cardNumber);
        ma().o.setErrorStroke(false);
        ma().o.setSelection(19);
        Ga(new ArrayList());
    }

    @Override // ir.nasim.C13353g50.c
    public void t(C13944h50 button) {
        AbstractC13042fc3.i(button, "button");
        int iA = button.a();
        if (iA == 2880) {
            J jA = J.INSTANCE.a(0);
            jA.getSavedAdapter().M(this.suggestList);
            jA.K8(Q7().B0(), null);
        } else if (iA == 2881) {
            C3343Am.g("create_crowdfunding_add_card_button");
            C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
        }
        ma().g.setVisibility(8);
    }

    @Override // ir.nasim.C19274q43.a
    public void y0(C18683p43 item) {
        AbstractC13042fc3.i(item, "item");
        int iIndexOf = this.importedPhotoAdapter.z().indexOf(item);
        this.importedPhotoAdapter.z().remove(item);
        this.importedPhotoAdapter.notifyItemRemoved(iIndexOf);
        if (this.importedPhotoAdapter.z().isEmpty()) {
            ma().c.setVisibility(8);
            ma().e.setVisibility(0);
            ma().l.setVisibility(8);
        }
    }
}
