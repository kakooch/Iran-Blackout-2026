package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.Task;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15251jG3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16613la3;
import ir.nasim.AbstractC18623oy2;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BC5;
import ir.nasim.C10333bU0;
import ir.nasim.C13353g50;
import ir.nasim.C13396g93;
import ir.nasim.C13944h50;
import ir.nasim.C14819iX7;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C20644sM5;
import ir.nasim.C21700tz2;
import ir.nasim.C23381wp3;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C3641Bs4;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC13497gK4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14681iJ4;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.N91;
import ir.nasim.OU3;
import ir.nasim.PX2;
import ir.nasim.Q45;
import ir.nasim.QG4;
import ir.nasim.SA2;
import ir.nasim.SF6;
import ir.nasim.SL6;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.util.SmsBroadcastReceiver;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.K;
import ir.nasim.features.payment.view.fragment.M;
import ir.nasim.features.payment.view.fragment.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u007f\b\u0007\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0099\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0005J'\u0010\u0011\u001a\u00020\t2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010 J)\u0010&\u001a\u00020\t2\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002¢\u0006\u0004\b&\u0010\u0012J\u000f\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\u0005J\u0017\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\tH\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\tH\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\tH\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b1\u0010\u0005J!\u00106\u001a\u00020\t2\u0006\u00103\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\t2\u0006\u00108\u001a\u000204H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b@\u0010 J\u0015\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u000e¢\u0006\u0004\bB\u0010CJ\u0015\u0010D\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u000e¢\u0006\u0004\bD\u0010CJ\u0015\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ)\u0010M\u001a\u00020\t2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020)2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\tH\u0016¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010P\u001a\u00020\tH\u0016¢\u0006\u0004\bP\u0010\u0005J\u0019\u0010Q\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\bQ\u0010:J+\u0010V\u001a\u0002022\u0006\u0010S\u001a\u00020R2\b\u0010U\u001a\u0004\u0018\u00010T2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001b\u0010c\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010n\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010tR\u0014\u0010z\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010|\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010yR\u0014\u0010~\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010yR\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u0093\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010`\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u009a\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/K;", "Lir/nasim/ua0;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "Ba", "()Ljava/lang/String;", "Lir/nasim/rB7;", "Ya", "Pa", "Qa", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/BankCreditCard;", "Lkotlin/collections/ArrayList;", "suggestList", "Oa", "(Ljava/util/ArrayList;)V", "hb", "Ga", "Xa", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Va", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "Aa", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "cardNumber", "Ka", "(Ljava/lang/String;)V", "Ha", "gb", "Da", "kb", "list", "ib", "vb", "bb", "", "timeout", "db", "(I)V", "pb", "lb", "fb", "wb", "La", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "i7", "(Landroid/os/Bundle;)V", "", "B1", "()Z", "onClick", "(Landroid/view/View;)V", "m3", ParameterNames.CARD, "i5", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Z0", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "k7", "R6", "M6", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/tz2;", "h1", "Lir/nasim/bW7;", "Ia", "()Lir/nasim/tz2;", "binding", "Lir/nasim/SL6;", "i1", "Lir/nasim/Yu3;", "Na", "()Lir/nasim/SL6;", "viewModel", "Lir/nasim/g50;", "j1", "Lir/nasim/g50;", "suggestAdapter", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "k1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "l1", "Lir/nasim/features/payment/data/response/Bank;", "bankOfCard", "Lir/nasim/bU0;", "m1", "Lir/nasim/bU0;", "loadingInitData", "n1", "Z", "loadDefaultCard", "o1", "isLoadSavedCardData", "p1", "Landroid/view/View$OnClickListener;", "cvv2InputVisibleClickListener", "q1", "pin2InputVisibleClickListener", "r1", "cvv2InputClearSavedClickListener", "ir/nasim/features/payment/view/fragment/K$b", "s1", "Lir/nasim/features/payment/view/fragment/K$b;", "cardTextWatcher", "Landroid/os/CountDownTimer;", "t1", "Landroid/os/CountDownTimer;", "otpTimer", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "u1", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "getSmsBroadcastReceiver", "()Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "setSmsBroadcastReceiver", "(Lir/nasim/features/payment/util/SmsBroadcastReceiver;)V", "smsBroadcastReceiver", "Lir/nasim/Bs4;", "v1", "Ja", "()Lir/nasim/Bs4;", "cardsViewModel", "Lir/nasim/n10;", "w1", "Lir/nasim/n10;", "snackBar", "x1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class K extends PX2 implements CardPaymentActivity.b, View.OnClickListener {

    /* renamed from: k1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: l1, reason: from kotlin metadata */
    private Bank bankOfCard;

    /* renamed from: n1, reason: from kotlin metadata */
    private boolean loadDefaultCard;

    /* renamed from: o1, reason: from kotlin metadata */
    private boolean isLoadSavedCardData;

    /* renamed from: t1, reason: from kotlin metadata */
    private CountDownTimer otpTimer;

    /* renamed from: u1, reason: from kotlin metadata */
    private SmsBroadcastReceiver smsBroadcastReceiver;

    /* renamed from: w1, reason: from kotlin metadata */
    private C17468n10 snackBar;
    static final /* synthetic */ InterfaceC5239Im3[] y1 = {AbstractC10882cM5.i(new C25226zw5(K.class, "binding", "getBinding()Lir/nasim/databinding/FragmentStatementBinding;", 0))};
    public static final int z1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new s(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(SL6.class), new m(this), new n(null, this), new o(this));

    /* renamed from: j1, reason: from kotlin metadata */
    private final C13353g50 suggestAdapter = new C13353g50(new UA2() { // from class: ir.nasim.EL6
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.K.qb(this.a, (C13944h50) obj);
        }
    }, new UA2() { // from class: ir.nasim.FL6
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.K.rb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.GL6
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.K.sb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.HL6
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.K.tb(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.IL6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.payment.view.fragment.K.ub(this.a);
        }
    });

    /* renamed from: m1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: p1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.JL6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.K.Fa(this.a, view);
        }
    };

    /* renamed from: q1, reason: from kotlin metadata */
    private final View.OnClickListener pin2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.KL6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.K.eb(this.a, view);
        }
    };

    /* renamed from: r1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputClearSavedClickListener = new View.OnClickListener() { // from class: ir.nasim.LL6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.K.Ea(this.a, view);
        }
    };

    /* renamed from: s1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cardsViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new p(this), new q(null, this), new r(this));

    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            K.this.pb();
            K.this.Ia().c.setVisibility(0);
            Drawable drawableF = null;
            if (editable != null) {
                if (ZY6.a(editable.toString()).length() < 6) {
                    K.this.gb();
                    K.this.Ia().b.setMaxLength(-1);
                    K.this.Ia().b.setErrorStroke(false);
                    K.this.Ia().b.setDrawableStart(AbstractC4043Dl1.f(K.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                    K.this.Ia().b.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                } else if (ZY6.a(editable.toString()).length() >= 6) {
                    K k = K.this;
                    String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankAa = k.Aa(strSubstring);
                    if (bankAa == null) {
                        K.this.Ia().b.setMaxLength(7);
                        CustomInputView customInputView = K.this.Ia().b;
                        String strH6 = K.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView.setInputError(strH6);
                        K.this.Ia().c.setVisibility(8);
                    } else {
                        if (editable.length() == 19) {
                            C3343Am.g("new_statement_insert_card_complete");
                            K.this.Ia().b.setMaxLength(19);
                            K.this.Ia().c.setVisibility(8);
                            if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.R3)) {
                                K k2 = K.this;
                                k2.Ka(ZY6.a(k2.Ia().b.getText().toString()));
                            } else {
                                K.this.Ha();
                            }
                            K.this.Ia().b.setDrawableEndFirst(AbstractC4043Dl1.f(K.this.S7(), KB5.ic_card_payment_close));
                        } else {
                            K.this.Ia().b.setDrawableEndFirst(null);
                            if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.R3) && K.this.isLoadSavedCardData) {
                                K.this.gb();
                            }
                        }
                        if (bankAa.getDestinationStatus().isEnable()) {
                            K.this.Ia().b.setErrorStroke(false);
                            K.this.bankOfCard = bankAa;
                        } else {
                            K.this.Ia().c.setVisibility(8);
                            K.this.Ia().b.setMaxLength(7);
                            CustomInputView customInputView2 = K.this.Ia().b;
                            String strI6 = K.this.i6(AbstractC12217eE5.card_payment_unable_statement, bankAa.getName());
                            AbstractC13042fc3.h(strI6, "getString(...)");
                            customInputView2.setStartDrawableError(strI6);
                        }
                        K.this.Ia().b.setDrawableStartTint(null);
                        CustomInputView customInputView3 = K.this.Ia().b;
                        Integer drawableId = bankAa.getDrawableId();
                        if (drawableId != null) {
                            K k3 = K.this;
                            drawableF = AbstractC4043Dl1.f(k3.S7(), drawableId.intValue());
                        }
                        customInputView3.setDrawableStart(drawableF);
                    }
                }
                K.this.kb(editable.toString());
            } else {
                K.jb(K.this, null, 1, null);
            }
            if (editable == null || editable.length() == 0) {
                K.this.Ia().b.setErrorStroke(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ C5354Iz1 a;
        final /* synthetic */ K b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5354Iz1 a;
            final /* synthetic */ K b;

            a(C5354Iz1 c5354Iz1, K k) {
                this.a = c5354Iz1;
                this.b = k;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String strC;
                String localizedMessage;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Throwable thB = this.a.b();
                if (thB == null || (localizedMessage = thB.getLocalizedMessage()) == null) {
                    strC = null;
                } else {
                    Context contextS7 = this.b.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    strC = GY6.c(localizedMessage, contextS7);
                }
                if (strC == null) {
                    strC = "";
                }
                AbstractC19555qZ.e0(strC, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(C5354Iz1 c5354Iz1, K k) {
            this.a = c5354Iz1;
            this.b = k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC14603iB2 interfaceC14603iB2D = N91.a.d();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1129514322, true, new a(this.a, this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1263792589);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.L
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return K.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC14603iB2D, c0905b, interfaceC18060o11E, cVar, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
            dialog.setCancelable(false);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 4) {
                return;
            }
            K.this.Ia().o.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 2) {
                return;
            }
            K.this.Ia().u.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 2) {
                return;
            }
            K.this.Ia().q.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 12) {
                return;
            }
            C23381wp3.f(K.this.Ia().q);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class h implements x.a {
        final /* synthetic */ BankCreditCard b;

        h(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            K.this.Ja().a1(this.b);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ K c;

            /* renamed from: ir.nasim.features.payment.view.fragment.K$i$a$a, reason: collision with other inner class name */
            static final class C1190a implements InterfaceC4806Gq2 {
                final /* synthetic */ K a;

                /* renamed from: ir.nasim.features.payment.view.fragment.K$i$a$a$a, reason: collision with other inner class name */
                static final class C1191a implements InterfaceC4806Gq2 {
                    final /* synthetic */ K a;

                    C1191a(K k) {
                        this.a = k;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                            Object objA = ((AbstractC15251jG3.b) abstractC15251jG3).a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                            this.a.Oa((ArrayList) objA);
                        } else if (abstractC15251jG3 instanceof AbstractC15251jG3.c) {
                            C10333bU0 c10333bU0 = this.a.loadingInitData;
                            FragmentManager fragmentManagerB0 = this.a.Q7().B0();
                            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                            AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                        } else {
                            if (!(abstractC15251jG3 instanceof AbstractC15251jG3.d) && !(abstractC15251jG3 instanceof AbstractC15251jG3.a)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            AbstractC16494lN1.a(this.a.loadingInitData);
                        }
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.payment.view.fragment.K$i$a$a$b */
                static final class b extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return C1190a.this.a(null, this);
                    }
                }

                C1190a(K k) {
                    this.a = k;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.AbstractC15251jG3 r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.features.payment.view.fragment.K.i.a.C1190a.b
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.payment.view.fragment.K$i$a$a$b r0 = (ir.nasim.features.payment.view.fragment.K.i.a.C1190a.b) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.features.payment.view.fragment.K$i$a$a$b r0 = new ir.nasim.features.payment.view.fragment.K$i$a$a$b
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 == r3) goto L2d
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2d:
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L64
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        boolean r6 = r5 instanceof ir.nasim.AbstractC15251jG3.b
                        if (r6 == 0) goto L6a
                        ir.nasim.features.payment.view.fragment.K r6 = r4.a
                        ir.nasim.jG3$b r5 = (ir.nasim.AbstractC15251jG3.b) r5
                        java.lang.Object r5 = r5.a()
                        java.lang.String r2 = "null cannot be cast to non-null type ir.nasim.features.payment.data.response.CardToCardConfig"
                        ir.nasim.AbstractC13042fc3.g(r5, r2)
                        ir.nasim.features.payment.data.response.CardToCardConfig r5 = (ir.nasim.features.payment.data.response.CardToCardConfig) r5
                        ir.nasim.features.payment.view.fragment.K.xa(r6, r5)
                        ir.nasim.features.payment.view.fragment.K r5 = r4.a
                        ir.nasim.Bs4 r5 = ir.nasim.features.payment.view.fragment.K.qa(r5)
                        ir.nasim.Vm4 r5 = r5.l1()
                        ir.nasim.features.payment.view.fragment.K$i$a$a$a r6 = new ir.nasim.features.payment.view.fragment.K$i$a$a$a
                        ir.nasim.features.payment.view.fragment.K r2 = r4.a
                        r6.<init>(r2)
                        r0.c = r3
                        java.lang.Object r5 = r5.b(r6, r0)
                        if (r5 != r1) goto L64
                        return r1
                    L64:
                        kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
                        r5.<init>()
                        throw r5
                    L6a:
                        boolean r6 = r5 instanceof ir.nasim.AbstractC15251jG3.c
                        if (r6 == 0) goto L87
                        ir.nasim.features.payment.view.fragment.K r5 = r4.a
                        ir.nasim.bU0 r5 = ir.nasim.features.payment.view.fragment.K.ra(r5)
                        ir.nasim.features.payment.view.fragment.K r6 = r4.a
                        androidx.fragment.app.FragmentActivity r6 = r6.Q7()
                        androidx.fragment.app.FragmentManager r6 = r6.B0()
                        java.lang.String r0 = "getSupportFragmentManager(...)"
                        ir.nasim.AbstractC13042fc3.h(r6, r0)
                        ir.nasim.AbstractC16494lN1.b(r5, r6)
                        goto L9e
                    L87:
                        boolean r5 = r5 instanceof ir.nasim.AbstractC15251jG3.a
                        if (r5 == 0) goto L95
                        ir.nasim.features.payment.view.fragment.K r5 = r4.a
                        ir.nasim.bU0 r5 = ir.nasim.features.payment.view.fragment.K.ra(r5)
                        ir.nasim.AbstractC16494lN1.a(r5)
                        goto L9e
                    L95:
                        ir.nasim.features.payment.view.fragment.K r5 = r4.a
                        ir.nasim.bU0 r5 = ir.nasim.features.payment.view.fragment.K.ra(r5)
                        ir.nasim.AbstractC16494lN1.a(r5)
                    L9e:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.K.i.a.C1190a.a(ir.nasim.jG3, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(K k, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = k;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8327Vm4 interfaceC8327Vm4F1 = this.c.Ja().f1();
                    C1190a c1190a = new C1190a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4F1.b(c1190a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return K.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                K k = K.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(k, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(k, bVar, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class j extends CountDownTimer {
        j(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            K.this.pb();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            int i = (int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            K.this.Ia().k.setText(XY6.e(AbstractC16613la3.a(i / 60) + ":" + AbstractC16613la3.a(i % 60)));
        }
    }

    public static final class k implements SmsBroadcastReceiver.b {
        k() {
        }

        @Override // ir.nasim.features.payment.util.SmsBroadcastReceiver.b
        public void a(Intent intent) {
            if (intent != null) {
                K.this.startActivityForResult(intent, 100);
            }
        }
    }

    static final class l implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        l(UA2 ua2) {
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

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    public static final class s extends AbstractC8614Ws3 implements UA2 {
        public s() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C21700tz2.a(fragment.V7());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank Aa(String pattern) {
        Exception e2;
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = this.config;
            if (cardToCardConfig == null) {
                AbstractC13042fc3.y("config");
                cardToCardConfig = null;
            }
            for (Bank bank2 : cardToCardConfig.getBankList()) {
                try {
                } catch (Exception e3) {
                    bank2 = bank;
                    e2 = e3;
                }
                if (bank2.getCardNumberPattern().contains(XY6.h(pattern))) {
                    try {
                        if (!AbstractC13042fc3.d(ZY6.a(pattern), "603799")) {
                            bank2.getDestinationStatus().setEnable(false);
                            bank2.getSourceStatus().setEnable(false);
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        try {
                            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                            bank = bank2;
                        } catch (Exception e5) {
                            e = e5;
                            bank = bank2;
                            C19406qI3.d("NON_FATAL_EXCEPTION", e);
                            return bank;
                        }
                    }
                    bank = bank2;
                }
            }
        } catch (Exception e6) {
            e = e6;
        }
        return bank;
    }

    private final String Ba() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) S7().getSystemService("clipboard");
            CharSequence text = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText();
            if (text == null || text.length() == 0 || !Ja().Y0(text.toString())) {
                return null;
            }
            List<String> listK = AbstractC11342cq6.K(AbstractC11342cq6.C(C20644sM5.e(new C20644sM5("\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}"), text, 0, 2, null), new UA2() { // from class: ir.nasim.uL6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.K.Ca((OU3) obj);
                }
            }));
            if (listK.isEmpty()) {
                return null;
            }
            for (String str : listK) {
                C20481s50 c20481s50 = C20481s50.a;
                if (c20481s50.g(str)) {
                    String strSubstring = XY6.k(str).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    if (c20481s50.c(strSubstring) != null && AbstractC13042fc3.d(CustomInputView.INSTANCE.a(str), Boolean.TRUE)) {
                        return str;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Ca(OU3 ou3) {
        AbstractC13042fc3.i(ou3, "it");
        return ou3.getValue();
    }

    private final void Da() {
        Ia().f.clearFocus();
        Ia().o.clearFocus();
        Ia().u.clearFocus();
        Ia().q.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(K k2, View view) {
        AbstractC13042fc3.i(k2, "this$0");
        k2.Ia().f.setDrawableEndFirstClickListener(k2.cvv2InputVisibleClickListener);
        k2.Ia().f.setText(null);
        k2.Ia().f.setDrawableEndFirst(AbstractC4043Dl1.f(k2.S7(), KB5.ic_card_payment_baseline_visibility_24));
        k2.Ia().f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(K k2, View view) {
        AbstractC13042fc3.i(k2, "this$0");
        if (AbstractC13042fc3.d(k2.Ia().f.getTag(), 0)) {
            k2.Ia().f.M(true);
            k2.Ia().f.setTag(1);
            k2.Ia().f.setDrawableEndFirst(AbstractC4043Dl1.f(k2.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            k2.Ia().f.M(false);
            k2.Ia().f.setTag(0);
            k2.Ia().f.setDrawableEndFirst(AbstractC4043Dl1.f(k2.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void Ga() {
        AbstractC16494lN1.a(this.loadingInitData);
        Ia().b.clearFocus();
        Ia().f.clearFocus();
        Ia().o.clearFocus();
        Ia().u.clearFocus();
        Ia().q.clearFocus();
        Ia().p.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha() {
        if (Ia().f.getText().length() == 0) {
            Ia().f.requestFocus();
            return;
        }
        if (Ia().o.getText().length() == 0) {
            Ia().o.requestFocus();
            return;
        }
        if (Ia().u.getText().length() == 0) {
            Ia().u.requestFocus();
        } else if (Ia().q.getText().length() == 0) {
            Ia().q.requestFocus();
        } else {
            C23381wp3.f(Ia().b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C21700tz2 Ia() {
        return (C21700tz2) this.binding.a(this, y1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 Ja() {
        return (C3641Bs4) this.cardsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka(String cardNumber) {
        String cvv2;
        BankCreditCard bankCreditCard = null;
        boolean z = false;
        boolean z2 = false;
        for (BankCreditCard bankCreditCard2 : Ja().k1()) {
            if (AbstractC13042fc3.d(bankCreditCard2.getNumber(), cardNumber) && ((bankCreditCard2.getExpirationYear() != null && bankCreditCard2.getExpirationMonth() != null) || bankCreditCard2.getCvv2() != null)) {
                z = bankCreditCard2.getCvv2() != null;
                z2 = (bankCreditCard2.getExpirationYear() == null || bankCreditCard2.getExpirationMonth() == null) ? false : true;
                bankCreditCard = bankCreditCard2;
            }
        }
        if (bankCreditCard == null) {
            Ha();
            return;
        }
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.S3) && z && (cvv2 = bankCreditCard.getCvv2()) != null && cvv2.length() != 0) {
            Ia().f.setText(bankCreditCard.getCvv2());
            Ia().f.setDrawableEndFirstClickListener(this.cvv2InputClearSavedClickListener);
            Ia().f.setDrawableEndFirst(AbstractC4043Dl1.f(S7(), KB5.ic_card_payment_close));
            CustomInputView customInputView = Ia().f;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(c5495Jo7.L0());
            AbstractC13042fc3.h(colorStateListValueOf, "valueOf(...)");
            customInputView.setDrawableEndFirstTint(colorStateListValueOf);
            Ia().f.setEnabled(false);
            Ia().f.setBackgroundTint(c5495Jo7.G0());
            Da();
        }
        if (z2) {
            Ia().u.setText(bankCreditCard.getRealExpirationYear());
            Ia().o.setText(bankCreditCard.getRealExpirationMonth());
            Da();
        }
        if (Ia().q.getText().length() == 0) {
            Ia().q.requestFocus();
        } else {
            C23381wp3.f(Ia().b);
        }
        this.isLoadSavedCardData = true;
    }

    private final void La() throws NumberFormatException {
        final C10333bU0 c10333bU0 = new C10333bU0();
        String id = null;
        c10333bU0.K8(Q7().B0(), null);
        String strA = ZY6.a(XY6.h(Ia().b.getText().toString()));
        while (true) {
            String str = id;
            for (BankCreditCard bankCreditCard : Ja().k1()) {
                if (AbstractC13042fc3.d(strA, bankCreditCard.getNumber())) {
                    break;
                }
            }
            String strA2 = ZY6.a(XY6.h(Ia().b.getText().toString()));
            int i2 = Integer.parseInt(Ia().u.getText().toString());
            int i3 = Integer.parseInt(Ia().o.getText().toString());
            Na().U0(new BankCreditCard(str, strA2, Integer.valueOf(i3), Integer.valueOf(i2), Ia().f.getText().toString(), null, false, BankCreditCard.c.a, false, false, false, 1888, null), Ia().q.getText().toString()).j(p6(), new l(new UA2() { // from class: ir.nasim.rL6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.K.Ma(c10333bU0, this, (C5354Iz1) obj);
                }
            }));
            return;
            id = bankCreditCard.getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C10333bU0 c10333bU0, K k2, C5354Iz1 c5354Iz1) throws NumberFormatException {
        AbstractC13042fc3.i(c10333bU0, "$loadingDialogFragment");
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC16494lN1.a(c10333bU0);
        if (c5354Iz1.c()) {
            Context contextS7 = k2.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AbstractC21375tZ.c(contextS7, k2, null, AbstractC19242q11.c(2146638849, true, new c(c5354Iz1, k2)), 4, null).show();
            C3343Am.g("new_statement_request_failure");
        } else {
            for (BankCreditCard bankCreditCard : k2.Ja().k1()) {
                if (AbstractC13042fc3.d(bankCreditCard.getNumber(), ZY6.a(k2.Ia().b.getText().toString()))) {
                    String string = k2.Ia().f.getText().toString();
                    int i2 = Integer.parseInt(k2.Ia().u.getText().toString());
                    k2.Ja().b1(bankCreditCard, Integer.parseInt(k2.Ia().o.getText().toString()), i2, string);
                }
            }
            CountDownTimer countDownTimer = k2.otpTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            SmsBroadcastReceiver smsBroadcastReceiver = k2.smsBroadcastReceiver;
            if (smsBroadcastReceiver != null) {
                try {
                    k2.Q7().unregisterReceiver(smsBroadcastReceiver);
                } catch (Exception unused) {
                }
            }
            M.Companion companion = M.INSTANCE;
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            M mA = companion.a((ArrayList) AbstractC15401jX0.i1((Iterable) objA, new ArrayList()));
            androidx.fragment.app.x xVarS = k2.Q7().B0().s();
            AbstractC13042fc3.h(xVarS, "beginTransaction(...)");
            xVarS.q(BC5.fragment_container, mA);
            xVarS.h();
            C3343Am.g("new_statement_request_successful");
        }
        return C19938rB7.a;
    }

    private final SL6 Na() {
        return (SL6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(ArrayList suggestList) {
        try {
            if (Ia().b.getText().length() == 0) {
                ib(suggestList);
            } else {
                kb(Ia().b.getText().toString());
            }
            if (this.loadDefaultCard) {
                return;
            }
            hb();
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            AbstractC16494lN1.a(this.loadingInitData);
            Q7().finish();
        }
    }

    private final void Pa() {
        Ia().b.setHintTypeFace(C6011Lu2.i());
        Ia().b.setTextTypeFace(C6011Lu2.k());
        Ia().f.setTextTypeFace(C6011Lu2.k());
        Ia().u.setTextTypeFace(C6011Lu2.k());
        Ia().o.setTextTypeFace(C6011Lu2.k());
        Ia().q.setTextTypeFace(C6011Lu2.k());
        Ia().k.setTypeface(C6011Lu2.i());
        Ia().l.setTypeface(C6011Lu2.i());
        Ia().h.setTypeface(C6011Lu2.k());
        Ia().i.setTypeface(C6011Lu2.k());
        Ia().s.setTypeface(C6011Lu2.i());
        Ia().t.setTypeface(C6011Lu2.k());
    }

    private final void Qa() {
        CustomInputView customInputView = Ia().b;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(C5495Jo7.a.L0());
        AbstractC13042fc3.h(colorStateListValueOf, "valueOf(...)");
        customInputView.setDrawableEndFirstTint(colorStateListValueOf);
        Ia().b.setDrawableEndFirstClickListener(new View.OnClickListener() { // from class: ir.nasim.vL6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.K.Ra(this.a, view);
            }
        });
        CustomInputView customInputView2 = Ia().b;
        CustomInputView customInputView3 = Ia().b;
        AbstractC13042fc3.h(customInputView3, "cardNumberInput");
        customInputView2.b(new C13396g93(customInputView3));
        Ia().b.b(this.cardTextWatcher);
        Ia().p.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.wL6
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ir.nasim.features.payment.view.fragment.K.Sa(this.a, view, i2, i3, i4, i5);
            }
        });
        Ia().b.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.xL6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.K.Ta(this.a, view, z);
            }
        });
        CustomInputView customInputView4 = Ia().f;
        CustomInputView customInputView5 = Ia().f;
        AbstractC13042fc3.h(customInputView5, "cvv2Input");
        customInputView4.b(new Q45(customInputView5));
        CustomInputView customInputView6 = Ia().o;
        CustomInputView customInputView7 = Ia().o;
        AbstractC13042fc3.h(customInputView7, "monthInput");
        customInputView6.b(new Q45(customInputView7));
        CustomInputView customInputView8 = Ia().u;
        CustomInputView customInputView9 = Ia().u;
        AbstractC13042fc3.h(customInputView9, "yearInput");
        customInputView8.b(new Q45(customInputView9));
        CustomInputView customInputView10 = Ia().q;
        CustomInputView customInputView11 = Ia().q;
        AbstractC13042fc3.h(customInputView11, "pin2Input");
        customInputView10.b(new Q45(customInputView11));
        Ia().f.b(new d());
        CustomInputView customInputView12 = Ia().f;
        AbstractC13042fc3.h(customInputView12, "cvv2Input");
        Va(customInputView12);
        Ia().o.b(new e());
        CustomInputView customInputView13 = Ia().o;
        AbstractC13042fc3.h(customInputView13, "monthInput");
        Va(customInputView13);
        Ia().u.b(new f());
        CustomInputView customInputView14 = Ia().u;
        AbstractC13042fc3.h(customInputView14, "yearInput");
        Va(customInputView14);
        Ia().q.b(new g());
        CustomInputView customInputView15 = Ia().q;
        AbstractC13042fc3.h(customInputView15, "pin2Input");
        Va(customInputView15);
        Ia().f.setTag(0);
        Ia().q.setTag(0);
        Ia().f.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
        Ia().q.setDrawableEndFirstClickListener(this.pin2InputVisibleClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(K k2, View view) {
        AbstractC13042fc3.i(k2, "this$0");
        k2.Ia().b.setDrawableEndFirst(null);
        k2.Ia().b.setText(null);
        k2.Ia().c.setVisibility(8);
        k2.Ia().f.setDrawableEndFirst(null);
        k2.Ia().f.setText(null);
        k2.Ia().o.setText(null);
        k2.Ia().u.setText(null);
        k2.Ia().b.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(K k2, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(k2, "this$0");
        if (i5 > 50) {
            k2.Ia().b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(final K k2, View view, boolean z) {
        AbstractC13042fc3.i(k2, "this$0");
        if (!z) {
            k2.Ia().c.setVisibility(8);
            return;
        }
        k2.Ia().getRoot().post(new Runnable() { // from class: ir.nasim.BL6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.payment.view.fragment.K.Ua(this.a);
            }
        });
        if (k2.Ia().b.getText().toString().length() == 0) {
            jb(k2, null, 1, null);
        }
        k2.Ia().c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(K k2) {
        AbstractC13042fc3.i(k2, "this$0");
        k2.Ia().p.V((int) k2.Ia().b.getX(), (int) k2.Ia().b.getY());
    }

    private final void Va(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.DL6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.K.Wa(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(K k2, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            k2.Ia().p.V((int) customInputView.getX(), (int) customInputView.getY());
        }
    }

    private final void Xa() {
        Ia().d.setAdapter(this.suggestAdapter);
        RecyclerView recyclerView = Ia().d;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
    }

    private final void Ya() {
        Pa();
        Qa();
        Ia().k.setOnClickListener(this);
        Ia().e.setOnClickListener(this);
        Ia().l.setOnClickListener(this);
        Ia().p.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.sL6
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ir.nasim.features.payment.view.fragment.K.Za(this.a, view, i2, i3, i4, i5);
            }
        });
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.V3)) {
            Ia().j.setVisibility(8);
            Ia().k.setVisibility(8);
            Ia().l.setVisibility(8);
        }
        Ia().i.setText(i6(AbstractC12217eE5.card_statement_wage_description, XY6.e(String.valueOf(AbstractC5969Lp4.e().S().Z0()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(K k2, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(k2, "this$0");
        if (i5 > 50) {
            k2.Ia().b.c();
            k2.Ia().f.c();
            k2.Ia().o.c();
            k2.Ia().u.c();
            k2.Ia().q.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ab(K k2, String str, Bundle bundle) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(str, "str");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("src_card_clicked");
        if (string != null) {
            k2.m3(string);
        }
        return C19938rB7.a;
    }

    private final void bb() {
        Ia().k.setEnabled(false);
        Na().U(ZY6.a(Ia().b.getText().toString())).j(p6(), new l(new UA2() { // from class: ir.nasim.CL6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.K.cb(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 cb(K k2, C5354Iz1 c5354Iz1) {
        String strC;
        String localizedMessage;
        AbstractC13042fc3.i(k2, "this$0");
        if (c5354Iz1.c()) {
            if (c5354Iz1.b() instanceof DuplicateTransactionException) {
                Throwable thB = c5354Iz1.b();
                AbstractC13042fc3.g(thB, "null cannot be cast to non-null type ir.nasim.core.modules.banking.entity.DuplicateTransactionException");
                k2.db(((DuplicateTransactionException) thB).a());
            } else {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Context contextG5 = k2.G5();
                Throwable thB2 = c5354Iz1.b();
                if (thB2 == null || (localizedMessage = thB2.getLocalizedMessage()) == null) {
                    strC = null;
                } else {
                    Context contextS7 = k2.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    strC = GY6.c(localizedMessage, contextS7);
                }
                aVar.U(contextG5, strC);
                k2.Ia().k.setEnabled(true);
            }
            C3343Am.g("new_statement_otp_failure");
        } else {
            k2.lb();
            k2.fb();
            k2.db(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            C3343Am.g("new_statement_otp_successful");
        }
        return C19938rB7.a;
    }

    private final void db(int timeout) {
        Ia().k.setEnabled(false);
        int i2 = timeout / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        Ia().k.setText(XY6.e(AbstractC16613la3.a(i2 / 60) + ":" + AbstractC16613la3.a(i2 % 60)));
        j jVar = new j(((long) timeout) * 1000);
        this.otpTimer = jVar;
        jVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(K k2, View view) {
        AbstractC13042fc3.i(k2, "this$0");
        if (AbstractC13042fc3.d(k2.Ia().q.getTag(), 0)) {
            k2.Ia().q.M(true);
            k2.Ia().q.setTag(1);
            k2.Ia().q.setDrawableEndFirst(AbstractC4043Dl1.f(k2.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            k2.Ia().q.M(false);
            k2.Ia().q.setTag(0);
            k2.Ia().q.setDrawableEndFirst(AbstractC4043Dl1.f(k2.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void fb() {
        SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();
        smsBroadcastReceiver.b(new k());
        this.smsBroadcastReceiver = smsBroadcastReceiver;
        Q7().registerReceiver(this.smsBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gb() {
        Ia().f.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
        Ia().f.setText(null);
        Ia().o.setText(null);
        Ia().u.setText(null);
        Ia().f.setDrawableEndFirst(AbstractC4043Dl1.f(S7(), KB5.ic_card_payment_baseline_visibility_24));
        Ia().f.setEnabled(true);
        this.isLoadSavedCardData = false;
    }

    private final void hb() {
        this.loadDefaultCard = true;
        BankCreditCard bankCreditCardG1 = Ja().g1();
        if (bankCreditCardG1 != null) {
            String strSubstring = bankCreditCardG1.getNumber().substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            if (AbstractC13042fc3.d(ZY6.a(strSubstring), "603799")) {
                Ia().b.setText(bankCreditCardG1.getNumber());
            }
        }
        Ga();
    }

    private final void ib(ArrayList list) {
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
        Ia().p.V((int) Ia().b.getX(), (int) Ia().b.getY());
    }

    static /* synthetic */ void jb(K k2, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = k2.Ja().k1();
        }
        k2.ib(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kb(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : Ja().k1()) {
                if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                    arrayList.add(bankCreditCard);
                }
            }
            ib(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void lb() {
        Task taskA = SF6.a(Q7()).A(null);
        final UA2 ua2 = new UA2() { // from class: ir.nasim.yL6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.K.mb((Void) obj);
            }
        };
        taskA.f(new InterfaceC13497gK4() { // from class: ir.nasim.zL6
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                ir.nasim.features.payment.view.fragment.K.nb(ua2, obj);
            }
        }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.AL6
            @Override // ir.nasim.InterfaceC14681iJ4
            public final void a(Exception exc) {
                ir.nasim.features.payment.view.fragment.K.ob(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 mb(Void r0) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ob(Exception exc) {
        AbstractC13042fc3.i(exc, "it");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pb() {
        CountDownTimer countDownTimer = this.otpTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Ia().k.setEnabled(true);
        Ia().k.setText(h6(AbstractC12217eE5.card_payment_receive_dynamic_password));
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = this.smsBroadcastReceiver;
            if (smsBroadcastReceiver != null) {
                Q7().unregisterReceiver(smsBroadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qb(K k2, C13944h50 c13944h50) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(c13944h50, "btn");
        k2.t(c13944h50);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 rb(K k2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        k2.Z0(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sb(K k2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        k2.i5(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 tb(K k2, String str) {
        AbstractC13042fc3.i(k2, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        k2.m3(str);
        k2.Ja().q1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ub(K k2) {
        AbstractC13042fc3.i(k2, "this$0");
        return k2.Ba();
    }

    private final void vb() {
        C23381wp3.f(Ia().b);
        Ia().c.setVisibility(8);
        Ia().b.clearFocus();
        if (Ia().b.getText().length() != 0 && Ia().b.getText().length() >= 19) {
            bb();
            return;
        }
        CustomInputView customInputView = Ia().b;
        String strH6 = h6(AbstractC12217eE5.card_payment_insert_card_number);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    private final void wb() throws NumberFormatException {
        boolean z;
        C23381wp3.f(Ia().b);
        Ia().c.setVisibility(8);
        Ia().b.clearFocus();
        Ia().f.clearFocus();
        Ia().o.clearFocus();
        Ia().u.clearFocus();
        Ia().q.clearFocus();
        boolean z2 = true;
        if (Ia().b.getText().length() != 0 && Ia().b.getText().length() >= 19) {
            z = false;
        } else {
            CustomInputView customInputView = Ia().b;
            String strH6 = h6(AbstractC12217eE5.card_payment_insert_card_number);
            AbstractC13042fc3.h(strH6, "getString(...)");
            customInputView.setInputError(strH6);
            z = true;
        }
        if (Ia().f.getText().length() == 0 || Ia().f.getText().length() < 3) {
            Ia().f.setErrorStroke(true);
            z = true;
        }
        if (Ia().o.getText().length() == 0 || Ia().o.getText().length() < 2 || Integer.parseInt(Ia().o.getText().toString()) > 12) {
            Ia().o.setErrorStroke(true);
            z = true;
        }
        if (Ia().u.getText().length() == 0 || Ia().u.getText().length() < 2) {
            Ia().u.setErrorStroke(true);
            z = true;
        }
        if (Ia().q.getText().length() != 0 && Ia().q.getText().length() >= 5) {
            z2 = z;
        } else {
            Ia().q.setErrorStroke(true);
        }
        if (!Ia().b.r()) {
            Ia().b.requestFocus();
        } else {
            if (z2) {
                return;
            }
            La();
        }
    }

    @Override // ir.nasim.features.payment.view.activity.CardPaymentActivity.b
    public boolean B1() {
        if (!u6() || Ia().c.getVisibility() != 0) {
            return true;
        }
        Ia().c.setVisibility(8);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1 && data != null) {
            String stringExtra = data.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            String strA = stringExtra != null ? SmsBroadcastReceiver.INSTANCE.a(stringExtra) : null;
            if (strA != null) {
                Ia().q.setText(strA);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "card_clicked", new InterfaceC14603iB2() { // from class: ir.nasim.tL6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ir.nasim.features.payment.view.fragment.K.ab(this.a, (String) obj, (Bundle) obj2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C21700tz2.c(inflater).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        CountDownTimer countDownTimer = this.otpTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void Z0(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        Ia().c.setVisibility(8);
        if (card.getType() == BankCreditCard.c.a) {
            m3(card.getNumber());
        }
    }

    public final void i5(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        if (card.getType() == BankCreditCard.c.a) {
            x xVar = new x();
            xVar.S8(new h(card));
            xVar.K8(Q7().B0(), null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        super.i7(outState);
        KS2 ks2 = new KS2();
        CardToCardConfig cardToCardConfig = this.config;
        if (cardToCardConfig == null) {
            AbstractC13042fc3.y("config");
            cardToCardConfig = null;
        }
        outState.putString(CardToCardConfig.CONFIG_KEY, ks2.t(cardToCardConfig));
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        SmsBroadcastReceiver smsBroadcastReceiver = this.smsBroadcastReceiver;
        if (smsBroadcastReceiver != null) {
            try {
                Q7().unregisterReceiver(smsBroadcastReceiver);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Ya();
        Xa();
        ConstraintLayout root = Ia().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        this.snackBar = c17468n10;
        c17468n10.k(Ia().e);
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC19224pz3.a(interfaceC18633oz3P6).b(new i(null));
    }

    public final void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        Ia().b.setMaxLength(19);
        Ia().b.setText(cardNumber);
        Ia().b.setErrorStroke(false);
        Ia().b.setSelection(19);
        ib(new ArrayList());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (AbstractC13042fc3.d(view, Ia().k)) {
            vb();
            return;
        }
        if (AbstractC13042fc3.d(view, Ia().e)) {
            wb();
        } else if (AbstractC13042fc3.d(view, Ia().l)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AbstractC21375tZ.c(contextS7, this, null, N91.a.c(), 4, null).show();
        }
    }

    public final void t(C13944h50 button) {
        AbstractC13042fc3.i(button, "button");
        int iA = button.a();
        if (iA == 2880) {
            J.INSTANCE.a(0).K8(Q7().B0(), null);
        } else if (iA == 2881) {
            C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
        }
        Ia().c.setVisibility(8);
    }
}
