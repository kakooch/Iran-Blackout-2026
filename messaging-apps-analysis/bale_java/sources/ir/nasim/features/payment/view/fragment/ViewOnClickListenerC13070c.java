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
import androidx.fragment.app.FragmentActivity;
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
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15251jG3;
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
import ir.nasim.AbstractC8943Xx1;
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
import ir.nasim.C22604vX;
import ir.nasim.C23381wp3;
import ir.nasim.C24048xx2;
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
import ir.nasim.InterfaceC23790xX;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.OU3;
import ir.nasim.Q45;
import ir.nasim.QG4;
import ir.nasim.QV2;
import ir.nasim.SA2;
import ir.nasim.SF6;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.Z11;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.features.payment.data.model.BalanceReceipt;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.util.SmsBroadcastReceiver;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c;
import ir.nasim.features.payment.view.fragment.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0084\u0001\b\u0007\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0099\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J'\u0010\u000e\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u0011\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010\u001eJ)\u0010&\u001a\u00020\u00062\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002¢\u0006\u0004\b&\u0010\u000fJ\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0005J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0005J\u0019\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J+\u0010;\u001a\u00020:2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u0001082\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b;\u0010<J!\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020:2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u000202H\u0016¢\u0006\u0004\bA\u00105J\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\bE\u0010\u001eJ\u0015\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u000b¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u000b¢\u0006\u0004\bI\u0010HJ\u0015\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\u0019\u0010N\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\bN\u0010OJ)\u0010T\u001a\u00020\u00062\u0006\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\b\u0010S\u001a\u0004\u0018\u00010RH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0006H\u0016¢\u0006\u0004\bV\u0010\u0005J\u000f\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0004\bW\u0010\u0005R\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u001b\u0010o\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR\u0014\u0010\u007f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u0081\u0001\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0016\u0010\u0083\u0001\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010~R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006\u009a\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/c;", "Lir/nasim/ua0;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "Lir/nasim/rB7;", "cb", "Ta", "Ua", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/BankCreditCard;", "Lkotlin/collections/ArrayList;", "suggestList", "Sa", "(Ljava/util/ArrayList;)V", "Ka", "lb", "bb", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Za", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "Ea", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "cardNumber", "Qa", "(Ljava/lang/String;)V", "La", "kb", "Fa", "()Ljava/lang/String;", "Ha", "ob", "list", "mb", "Ab", "fb", "", "timeout", "hb", "(I)V", "tb", "pb", "jb", "zb", "Ma", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "i7", "", "B1", "()Z", "m3", ParameterNames.CARD, "i5", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Z0", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "onClick", "(Landroid/view/View;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "k7", "R6", "Lir/nasim/xX;", "h1", "Lir/nasim/Yu3;", "Ra", "()Lir/nasim/xX;", "viewModel", "Lir/nasim/Bs4;", "i1", "Pa", "()Lir/nasim/Bs4;", "cardsViewModel", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "j1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "k1", "Lir/nasim/features/payment/data/response/Bank;", "bankOfCard", "Lir/nasim/xx2;", "l1", "Lir/nasim/bW7;", "Oa", "()Lir/nasim/xx2;", "binding", "Lir/nasim/g50;", "m1", "Lir/nasim/g50;", "suggestAdapter", "Lir/nasim/bU0;", "n1", "Lir/nasim/bU0;", "loadingInitData", "o1", "Z", "loadDefaultCard", "p1", "isLoadSavedCardData", "q1", "Landroid/view/View$OnClickListener;", "cvv2InputVisibleClickListener", "r1", "pin2InputVisibleClickListener", "s1", "cvv2InputClearSavedClickListener", "ir/nasim/features/payment/view/fragment/c$b", "t1", "Lir/nasim/features/payment/view/fragment/c$b;", "cardTextWatcher", "Landroid/os/CountDownTimer;", "u1", "Landroid/os/CountDownTimer;", "otpTimer", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "v1", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "getSmsBroadcastReceiver", "()Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "setSmsBroadcastReceiver", "(Lir/nasim/features/payment/util/SmsBroadcastReceiver;)V", "smsBroadcastReceiver", "Lir/nasim/n10;", "w1", "Lir/nasim/n10;", "snackBar", "x1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.c, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class ViewOnClickListenerC13070c extends QV2 implements CardPaymentActivity.b, View.OnClickListener {

    /* renamed from: j1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: k1, reason: from kotlin metadata */
    private Bank bankOfCard;

    /* renamed from: o1, reason: from kotlin metadata */
    private boolean loadDefaultCard;

    /* renamed from: p1, reason: from kotlin metadata */
    private boolean isLoadSavedCardData;

    /* renamed from: u1, reason: from kotlin metadata */
    private CountDownTimer otpTimer;

    /* renamed from: v1, reason: from kotlin metadata */
    private SmsBroadcastReceiver smsBroadcastReceiver;

    /* renamed from: w1, reason: from kotlin metadata */
    private C17468n10 snackBar;
    static final /* synthetic */ InterfaceC5239Im3[] y1 = {AbstractC10882cM5.i(new C25226zw5(ViewOnClickListenerC13070c.class, "binding", "getBinding()Lir/nasim/databinding/FragmentBalanceBinding;", 0))};
    public static final int z1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.eX
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13070c.Bb(this.a);
        }
    });

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cardsViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new m(this), new n(null, this), new o(this));

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new p(), AbstractC20046rN7.c());

    /* renamed from: m1, reason: from kotlin metadata */
    private final C13353g50 suggestAdapter = new C13353g50(new UA2() { // from class: ir.nasim.hX
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ViewOnClickListenerC13070c.ub(this.a, (C13944h50) obj);
        }
    }, new UA2() { // from class: ir.nasim.iX
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ViewOnClickListenerC13070c.vb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.jX
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ViewOnClickListenerC13070c.wb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.kX
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ViewOnClickListenerC13070c.xb(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.lX
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13070c.yb(this.a);
        }
    });

    /* renamed from: n1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: q1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.mX
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewOnClickListenerC13070c.Ja(this.a, view);
        }
    };

    /* renamed from: r1, reason: from kotlin metadata */
    private final View.OnClickListener pin2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.nX
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewOnClickListenerC13070c.ib(this.a, view);
        }
    };

    /* renamed from: s1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputClearSavedClickListener = new View.OnClickListener() { // from class: ir.nasim.oX
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewOnClickListenerC13070c.Ia(this.a, view);
        }
    };

    /* renamed from: t1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: ir.nasim.features.payment.view.fragment.c$b */
    public static final class b implements TextWatcher {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(ViewOnClickListenerC13070c viewOnClickListenerC13070c, ArrayList arrayList) {
            AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
            if (arrayList != null && !arrayList.isEmpty()) {
                viewOnClickListenerC13070c.mb(arrayList);
                viewOnClickListenerC13070c.suggestAdapter.notifyDataSetChanged();
            }
            return C19938rB7.a;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ViewOnClickListenerC13070c.this.tb();
            ViewOnClickListenerC13070c.this.Oa().c.setVisibility(0);
            if (editable != null) {
                Drawable drawableF = null;
                if (ZY6.a(editable.toString()).length() < 6) {
                    ViewOnClickListenerC13070c.this.kb();
                    ViewOnClickListenerC13070c.this.Oa().b.setMaxLength(-1);
                    ViewOnClickListenerC13070c.this.Oa().b.setErrorStroke(false);
                    CustomInputView customInputView = ViewOnClickListenerC13070c.this.Oa().b;
                    Drawable drawableF2 = AbstractC4043Dl1.f(ViewOnClickListenerC13070c.this.S7(), KB5.card);
                    if (drawableF2 != null) {
                        drawableF2.setBounds(0, 0, AbstractC8943Xx1.c(32), AbstractC8943Xx1.c(32));
                        drawableF = drawableF2;
                    }
                    customInputView.setDrawableStart(drawableF);
                    ViewOnClickListenerC13070c.this.Oa().b.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                } else if (ZY6.a(editable.toString()).length() >= 6) {
                    ViewOnClickListenerC13070c viewOnClickListenerC13070c = ViewOnClickListenerC13070c.this;
                    String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankEa = viewOnClickListenerC13070c.Ea(strSubstring);
                    if (bankEa == null) {
                        ViewOnClickListenerC13070c.this.Oa().b.setMaxLength(7);
                        CustomInputView customInputView2 = ViewOnClickListenerC13070c.this.Oa().b;
                        String strH6 = ViewOnClickListenerC13070c.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView2.setInputError(strH6);
                        ViewOnClickListenerC13070c.this.Oa().c.setVisibility(8);
                    } else {
                        if (editable.length() == 19) {
                            C3343Am.g("new_balance_insert_card_complete");
                            ViewOnClickListenerC13070c.this.Oa().b.setMaxLength(19);
                            ViewOnClickListenerC13070c.this.Oa().c.setVisibility(8);
                            if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.R3)) {
                                ViewOnClickListenerC13070c viewOnClickListenerC13070c2 = ViewOnClickListenerC13070c.this;
                                viewOnClickListenerC13070c2.Qa(ZY6.a(viewOnClickListenerC13070c2.Oa().b.getText().toString()));
                            } else {
                                ViewOnClickListenerC13070c.this.La();
                            }
                            ViewOnClickListenerC13070c.this.Oa().b.setDrawableEndFirst(AbstractC4043Dl1.f(ViewOnClickListenerC13070c.this.S7(), KB5.ic_card_payment_close));
                        } else {
                            ViewOnClickListenerC13070c.this.Oa().b.setDrawableEndFirst(null);
                            if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.R3) && ViewOnClickListenerC13070c.this.isLoadSavedCardData) {
                                ViewOnClickListenerC13070c.this.kb();
                            }
                        }
                        if (bankEa.getDestinationStatus().isEnable()) {
                            ViewOnClickListenerC13070c.this.Oa().b.setErrorStroke(false);
                            ViewOnClickListenerC13070c.this.bankOfCard = bankEa;
                        } else {
                            ViewOnClickListenerC13070c.this.Oa().c.setVisibility(8);
                            ViewOnClickListenerC13070c.this.Oa().b.setMaxLength(7);
                            CustomInputView customInputView3 = ViewOnClickListenerC13070c.this.Oa().b;
                            String strI6 = ViewOnClickListenerC13070c.this.i6(AbstractC12217eE5.card_payment_unable_balance, bankEa.getName());
                            AbstractC13042fc3.h(strI6, "getString(...)");
                            customInputView3.setStartDrawableError(strI6);
                        }
                        ViewOnClickListenerC13070c.this.Oa().b.setDrawableStartTint(null);
                        CustomInputView customInputView4 = ViewOnClickListenerC13070c.this.Oa().b;
                        Integer drawableId = bankEa.getDrawableId();
                        if (drawableId != null) {
                            ViewOnClickListenerC13070c viewOnClickListenerC13070c3 = ViewOnClickListenerC13070c.this;
                            drawableF = AbstractC4043Dl1.f(viewOnClickListenerC13070c3.S7(), drawableId.intValue());
                        }
                        customInputView4.setDrawableStart(drawableF);
                    }
                }
                ViewOnClickListenerC13070c.this.ob(editable.toString());
            } else {
                androidx.lifecycle.r rVarC0 = ViewOnClickListenerC13070c.this.Ra().c0();
                InterfaceC18633oz3 interfaceC18633oz3P6 = ViewOnClickListenerC13070c.this.p6();
                final ViewOnClickListenerC13070c viewOnClickListenerC13070c4 = ViewOnClickListenerC13070c.this;
                rVarC0.j(interfaceC18633oz3P6, new l(new UA2() { // from class: ir.nasim.pX
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return ViewOnClickListenerC13070c.b.b(viewOnClickListenerC13070c4, (ArrayList) obj);
                    }
                }));
            }
            if (editable == null || editable.length() == 0) {
                ViewOnClickListenerC13070c.this.Oa().b.setErrorStroke(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$c, reason: collision with other inner class name */
    static final class C1198c implements InterfaceC15796kB2 {
        final /* synthetic */ C5354Iz1 a;
        final /* synthetic */ ViewOnClickListenerC13070c b;

        /* renamed from: ir.nasim.features.payment.view.fragment.c$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5354Iz1 a;
            final /* synthetic */ ViewOnClickListenerC13070c b;

            a(C5354Iz1 c5354Iz1, ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
                this.a = c5354Iz1;
                this.b = viewOnClickListenerC13070c;
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

        C1198c(C5354Iz1 c5354Iz1, ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
            this.a = c5354Iz1;
            this.b = viewOnClickListenerC13070c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC14603iB2 interfaceC14603iB2D = Z11.a.d();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-861287975, true, new a(this.a, this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1111950297);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.d
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ViewOnClickListenerC13070c.C1198c.c(dialog);
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$d */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 4) {
                return;
            }
            ViewOnClickListenerC13070c.this.Oa().o.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$e */
    public static final class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 2) {
                return;
            }
            ViewOnClickListenerC13070c.this.Oa().u.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$f */
    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 2) {
                return;
            }
            ViewOnClickListenerC13070c.this.Oa().q.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$g */
    public static final class g implements TextWatcher {
        g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 12) {
                return;
            }
            C23381wp3.f(ViewOnClickListenerC13070c.this.Oa().q);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$h */
    public static final class h implements x.a {
        final /* synthetic */ BankCreditCard b;

        h(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            ViewOnClickListenerC13070c.this.Pa().a1(this.b);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.payment.view.fragment.c$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ ViewOnClickListenerC13070c c;

            /* renamed from: ir.nasim.features.payment.view.fragment.c$i$a$a, reason: collision with other inner class name */
            static final class C1199a implements InterfaceC4806Gq2 {
                final /* synthetic */ ViewOnClickListenerC13070c a;

                /* renamed from: ir.nasim.features.payment.view.fragment.c$i$a$a$a, reason: collision with other inner class name */
                static final class C1200a implements InterfaceC4806Gq2 {
                    final /* synthetic */ ViewOnClickListenerC13070c a;

                    C1200a(ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
                        this.a = viewOnClickListenerC13070c;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                            Object objA = ((AbstractC15251jG3.b) abstractC15251jG3).a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                            this.a.Sa((ArrayList) objA);
                        } else if (abstractC15251jG3 instanceof AbstractC15251jG3.c) {
                            C10333bU0 c10333bU0 = this.a.loadingInitData;
                            FragmentManager fragmentManagerB0 = this.a.Q7().B0();
                            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                            AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                        } else {
                            if (!(abstractC15251jG3 instanceof AbstractC15251jG3.a) && !(abstractC15251jG3 instanceof AbstractC15251jG3.d)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            AbstractC16494lN1.a(this.a.loadingInitData);
                        }
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.payment.view.fragment.c$i$a$a$b */
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
                        return C1199a.this.a(null, this);
                    }
                }

                C1199a(ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
                    this.a = viewOnClickListenerC13070c;
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
                        boolean r0 = r6 instanceof ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.i.a.C1199a.b
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.payment.view.fragment.c$i$a$a$b r0 = (ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.i.a.C1199a.b) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.features.payment.view.fragment.c$i$a$a$b r0 = new ir.nasim.features.payment.view.fragment.c$i$a$a$b
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
                        ir.nasim.features.payment.view.fragment.c r6 = r4.a
                        ir.nasim.jG3$b r5 = (ir.nasim.AbstractC15251jG3.b) r5
                        java.lang.Object r5 = r5.a()
                        java.lang.String r2 = "null cannot be cast to non-null type ir.nasim.features.payment.data.response.CardToCardConfig"
                        ir.nasim.AbstractC13042fc3.g(r5, r2)
                        ir.nasim.features.payment.data.response.CardToCardConfig r5 = (ir.nasim.features.payment.data.response.CardToCardConfig) r5
                        ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.Aa(r6, r5)
                        ir.nasim.features.payment.view.fragment.c r5 = r4.a
                        ir.nasim.Bs4 r5 = ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.ra(r5)
                        ir.nasim.Vm4 r5 = r5.l1()
                        ir.nasim.features.payment.view.fragment.c$i$a$a$a r6 = new ir.nasim.features.payment.view.fragment.c$i$a$a$a
                        ir.nasim.features.payment.view.fragment.c r2 = r4.a
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
                        boolean r5 = r5 instanceof ir.nasim.AbstractC15251jG3.c
                        if (r5 == 0) goto L87
                        ir.nasim.features.payment.view.fragment.c r5 = r4.a
                        ir.nasim.bU0 r5 = ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.sa(r5)
                        ir.nasim.features.payment.view.fragment.c r6 = r4.a
                        androidx.fragment.app.FragmentActivity r6 = r6.Q7()
                        androidx.fragment.app.FragmentManager r6 = r6.B0()
                        java.lang.String r0 = "getSupportFragmentManager(...)"
                        ir.nasim.AbstractC13042fc3.h(r6, r0)
                        ir.nasim.AbstractC16494lN1.b(r5, r6)
                        goto L90
                    L87:
                        ir.nasim.features.payment.view.fragment.c r5 = r4.a
                        ir.nasim.bU0 r5 = ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.sa(r5)
                        ir.nasim.AbstractC16494lN1.a(r5)
                    L90:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c.i.a.C1199a.a(ir.nasim.jG3, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ViewOnClickListenerC13070c viewOnClickListenerC13070c, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = viewOnClickListenerC13070c;
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
                    InterfaceC8327Vm4 interfaceC8327Vm4F1 = this.c.Pa().f1();
                    C1199a c1199a = new C1199a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4F1.b(c1199a, this) == objE) {
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
            return ViewOnClickListenerC13070c.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ViewOnClickListenerC13070c viewOnClickListenerC13070c = ViewOnClickListenerC13070c.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(viewOnClickListenerC13070c, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(viewOnClickListenerC13070c, bVar, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$j */
    public static final class j extends CountDownTimer {
        j(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ViewOnClickListenerC13070c.this.tb();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            int i = (int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            ViewOnClickListenerC13070c.this.Oa().k.setText(XY6.e(AbstractC16613la3.a(i / 60) + ":" + AbstractC16613la3.a(i % 60)));
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$k */
    public static final class k implements SmsBroadcastReceiver.b {
        k() {
        }

        @Override // ir.nasim.features.payment.util.SmsBroadcastReceiver.b
        public void a(Intent intent) {
            if (intent != null) {
                ViewOnClickListenerC13070c.this.startActivityForResult(intent, 100);
            }
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.c$l */
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$m */
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$n */
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$o */
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

    /* renamed from: ir.nasim.features.payment.view.fragment.c$p */
    public static final class p extends AbstractC8614Ws3 implements UA2 {
        public p() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C24048xx2.a(fragment.V7());
        }
    }

    private final void Ab() {
        C23381wp3.f(Oa().b);
        Oa().c.setVisibility(8);
        Oa().b.clearFocus();
        if (Oa().b.getText().length() != 0 && Oa().b.getText().length() >= 19) {
            fb();
            return;
        }
        CustomInputView customInputView = Oa().b;
        String strH6 = h6(AbstractC12217eE5.card_payment_insert_card_number);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22604vX Bb(ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        FragmentActivity fragmentActivityQ7 = viewOnClickListenerC13070c.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C22604vX) new androidx.lifecycle.G(fragmentActivityQ7).b(C22604vX.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank Ea(String pattern) {
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

    private final String Fa() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) S7().getSystemService("clipboard");
            CharSequence text = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText();
            if (text == null || text.length() == 0 || !Pa().Y0(text.toString())) {
                return null;
            }
            List<String> listK = AbstractC11342cq6.K(AbstractC11342cq6.C(C20644sM5.e(new C20644sM5("\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}"), text, 0, 2, null), new UA2() { // from class: ir.nasim.aX
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13070c.Ga((OU3) obj);
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
    public static final String Ga(OU3 ou3) {
        AbstractC13042fc3.i(ou3, "it");
        return ou3.getValue();
    }

    private final void Ha() {
        Oa().f.clearFocus();
        Oa().o.clearFocus();
        Oa().u.clearFocus();
        Oa().q.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        viewOnClickListenerC13070c.Oa().f.setDrawableEndFirstClickListener(viewOnClickListenerC13070c.cvv2InputVisibleClickListener);
        viewOnClickListenerC13070c.Oa().f.setText(null);
        viewOnClickListenerC13070c.Oa().f.setDrawableEndFirst(AbstractC4043Dl1.f(viewOnClickListenerC13070c.S7(), KB5.ic_card_payment_baseline_visibility_24));
        viewOnClickListenerC13070c.Oa().f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (AbstractC13042fc3.d(viewOnClickListenerC13070c.Oa().f.getTag(), 0)) {
            viewOnClickListenerC13070c.Oa().f.M(true);
            viewOnClickListenerC13070c.Oa().f.setTag(1);
            viewOnClickListenerC13070c.Oa().f.setDrawableEndFirst(AbstractC4043Dl1.f(viewOnClickListenerC13070c.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            viewOnClickListenerC13070c.Oa().f.M(false);
            viewOnClickListenerC13070c.Oa().f.setTag(0);
            viewOnClickListenerC13070c.Oa().f.setDrawableEndFirst(AbstractC4043Dl1.f(viewOnClickListenerC13070c.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void Ka() {
        AbstractC16494lN1.a(this.loadingInitData);
        Oa().b.clearFocus();
        Oa().f.clearFocus();
        Oa().o.clearFocus();
        Oa().u.clearFocus();
        Oa().q.clearFocus();
        Oa().p.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La() {
        if (Oa().f.getText().length() == 0) {
            Oa().f.requestFocus();
            return;
        }
        if (Oa().o.getText().length() == 0) {
            Oa().o.requestFocus();
            return;
        }
        if (Oa().u.getText().length() == 0) {
            Oa().u.requestFocus();
        } else if (Oa().q.getText().length() == 0) {
            Oa().q.requestFocus();
        } else {
            C23381wp3.f(Oa().b);
        }
    }

    private final void Ma() throws NumberFormatException {
        final C10333bU0 c10333bU0 = new C10333bU0();
        String id = null;
        c10333bU0.K8(Q7().B0(), null);
        String strA = ZY6.a(XY6.h(Oa().b.getText().toString()));
        while (true) {
            String str = id;
            for (BankCreditCard bankCreditCard : Pa().k1()) {
                if (AbstractC13042fc3.d(strA, bankCreditCard.getNumber())) {
                    break;
                }
            }
            String strA2 = ZY6.a(XY6.h(Oa().b.getText().toString()));
            int i2 = Integer.parseInt(Oa().u.getText().toString());
            int i3 = Integer.parseInt(Oa().o.getText().toString());
            BankCreditCard bankCreditCard2 = new BankCreditCard(str, strA2, Integer.valueOf(i3), Integer.valueOf(i2), Oa().f.getText().toString(), null, false, BankCreditCard.c.a, false, false, false, 1888, null);
            InterfaceC23790xX interfaceC23790xXRa = Ra();
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            interfaceC23790xXRa.b0(contextS7, bankCreditCard2, Oa().q.getText().toString()).j(p6(), new l(new UA2() { // from class: ir.nasim.WW
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13070c.Na(c10333bU0, this, (C5354Iz1) obj);
                }
            }));
            return;
            id = bankCreditCard.getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Na(C10333bU0 c10333bU0, ViewOnClickListenerC13070c viewOnClickListenerC13070c, C5354Iz1 c5354Iz1) throws NumberFormatException {
        AbstractC13042fc3.i(c10333bU0, "$loadingDialogFragment");
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC16494lN1.a(c10333bU0);
        if (c5354Iz1.c()) {
            Context contextS7 = viewOnClickListenerC13070c.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = viewOnClickListenerC13070c.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(772820936, true, new C1198c(c5354Iz1, viewOnClickListenerC13070c)), 4, null).show();
            C3343Am.g("new_balance_request_failure");
        } else {
            for (BankCreditCard bankCreditCard : viewOnClickListenerC13070c.Pa().k1()) {
                if (AbstractC13042fc3.d(bankCreditCard.getNumber(), ZY6.a(viewOnClickListenerC13070c.Oa().b.getText().toString()))) {
                    String string = viewOnClickListenerC13070c.Oa().f.getText().toString();
                    int i2 = Integer.parseInt(viewOnClickListenerC13070c.Oa().u.getText().toString());
                    viewOnClickListenerC13070c.Pa().b1(bankCreditCard, Integer.parseInt(viewOnClickListenerC13070c.Oa().o.getText().toString()), i2, string);
                }
            }
            CountDownTimer countDownTimer = viewOnClickListenerC13070c.otpTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            SmsBroadcastReceiver smsBroadcastReceiver = viewOnClickListenerC13070c.smsBroadcastReceiver;
            if (smsBroadcastReceiver != null) {
                try {
                    viewOnClickListenerC13070c.Q7().unregisterReceiver(smsBroadcastReceiver);
                } catch (Exception unused) {
                }
            }
            BalanceReceipt balanceReceipt = (BalanceReceipt) c5354Iz1.a();
            if (balanceReceipt != null) {
                G.INSTANCE.a(balanceReceipt).K8(viewOnClickListenerC13070c.Q7().B0(), null);
            }
            C3343Am.g("new_balance_request_successful");
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24048xx2 Oa() {
        return (C24048xx2) this.binding.a(this, y1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 Pa() {
        return (C3641Bs4) this.cardsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(String cardNumber) {
        String cvv2;
        BankCreditCard bankCreditCard = null;
        boolean z = false;
        boolean z2 = false;
        for (BankCreditCard bankCreditCard2 : Pa().k1()) {
            if (AbstractC13042fc3.d(bankCreditCard2.getNumber(), cardNumber) && ((bankCreditCard2.getExpirationYear() != null && bankCreditCard2.getExpirationMonth() != null) || bankCreditCard2.getCvv2() != null)) {
                z = bankCreditCard2.getCvv2() != null;
                z2 = (bankCreditCard2.getExpirationYear() == null || bankCreditCard2.getExpirationMonth() == null) ? false : true;
                bankCreditCard = bankCreditCard2;
            }
        }
        if (bankCreditCard == null) {
            La();
            return;
        }
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.S3) && z && (cvv2 = bankCreditCard.getCvv2()) != null && cvv2.length() != 0) {
            Oa().f.setText(bankCreditCard.getCvv2());
            Oa().f.setDrawableEndFirstClickListener(this.cvv2InputClearSavedClickListener);
            Oa().f.setDrawableEndFirst(AbstractC4043Dl1.f(S7(), KB5.ic_card_payment_close));
            CustomInputView customInputView = Oa().f;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(c5495Jo7.L0());
            AbstractC13042fc3.h(colorStateListValueOf, "valueOf(...)");
            customInputView.setDrawableEndFirstTint(colorStateListValueOf);
            Oa().f.setEnabled(false);
            Oa().f.setBackgroundTint(c5495Jo7.G0());
            Ha();
        }
        if (z2) {
            Oa().u.setText(bankCreditCard.getRealExpirationYear());
            Oa().o.setText(bankCreditCard.getRealExpirationMonth());
            Ha();
        }
        if (Oa().q.getText().length() == 0) {
            Oa().q.requestFocus();
        } else {
            C23381wp3.f(Oa().b);
        }
        this.isLoadSavedCardData = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC23790xX Ra() {
        return (InterfaceC23790xX) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(ArrayList suggestList) {
        try {
            if (Oa().b.getText().length() == 0) {
                mb(suggestList);
            } else {
                ob(Oa().b.getText().toString());
            }
            if (this.loadDefaultCard) {
                return;
            }
            lb();
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            AbstractC16494lN1.a(this.loadingInitData);
            Q7().finish();
        }
    }

    private final void Ta() {
        Oa().b.setHintTypeFace(C6011Lu2.i());
        Oa().b.setTextTypeFace(C6011Lu2.k());
        Oa().f.setTextTypeFace(C6011Lu2.k());
        Oa().u.setTextTypeFace(C6011Lu2.k());
        Oa().o.setTextTypeFace(C6011Lu2.k());
        Oa().q.setTextTypeFace(C6011Lu2.k());
        Oa().k.setTypeface(C6011Lu2.i());
        Oa().l.setTypeface(C6011Lu2.i());
        Oa().h.setTypeface(C6011Lu2.k());
        Oa().i.setTypeface(C6011Lu2.k());
        Oa().s.setTypeface(C6011Lu2.i());
        Oa().t.setTypeface(C6011Lu2.k());
    }

    private final void Ua() {
        CustomInputView customInputView = Oa().b;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(C5495Jo7.a.L0());
        AbstractC13042fc3.h(colorStateListValueOf, "valueOf(...)");
        customInputView.setDrawableEndFirstTint(colorStateListValueOf);
        Oa().b.setDrawableEndFirstClickListener(new View.OnClickListener() { // from class: ir.nasim.bX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewOnClickListenerC13070c.Va(this.a, view);
            }
        });
        CustomInputView customInputView2 = Oa().b;
        CustomInputView customInputView3 = Oa().b;
        AbstractC13042fc3.h(customInputView3, "cardNumberInput");
        customInputView2.b(new C13396g93(customInputView3));
        Oa().b.b(this.cardTextWatcher);
        Oa().p.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.cX
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ViewOnClickListenerC13070c.Wa(this.a, view, i2, i3, i4, i5);
            }
        });
        Oa().b.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.dX
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13070c.Xa(this.a, view, z);
            }
        });
        CustomInputView customInputView4 = Oa().f;
        CustomInputView customInputView5 = Oa().f;
        AbstractC13042fc3.h(customInputView5, "cvv2Input");
        customInputView4.b(new Q45(customInputView5));
        CustomInputView customInputView6 = Oa().o;
        CustomInputView customInputView7 = Oa().o;
        AbstractC13042fc3.h(customInputView7, "monthInput");
        customInputView6.b(new Q45(customInputView7));
        CustomInputView customInputView8 = Oa().u;
        CustomInputView customInputView9 = Oa().u;
        AbstractC13042fc3.h(customInputView9, "yearInput");
        customInputView8.b(new Q45(customInputView9));
        CustomInputView customInputView10 = Oa().q;
        CustomInputView customInputView11 = Oa().q;
        AbstractC13042fc3.h(customInputView11, "pin2Input");
        customInputView10.b(new Q45(customInputView11));
        Oa().f.b(new d());
        CustomInputView customInputView12 = Oa().f;
        AbstractC13042fc3.h(customInputView12, "cvv2Input");
        Za(customInputView12);
        Oa().o.b(new e());
        CustomInputView customInputView13 = Oa().o;
        AbstractC13042fc3.h(customInputView13, "monthInput");
        Za(customInputView13);
        Oa().u.b(new f());
        CustomInputView customInputView14 = Oa().u;
        AbstractC13042fc3.h(customInputView14, "yearInput");
        Za(customInputView14);
        Oa().q.b(new g());
        CustomInputView customInputView15 = Oa().q;
        AbstractC13042fc3.h(customInputView15, "pin2Input");
        Za(customInputView15);
        Oa().f.setTag(0);
        Oa().q.setTag(0);
        Oa().f.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
        Oa().q.setDrawableEndFirstClickListener(this.pin2InputVisibleClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        viewOnClickListenerC13070c.Oa().b.setDrawableEndFirst(null);
        viewOnClickListenerC13070c.Oa().b.setText(null);
        viewOnClickListenerC13070c.Oa().c.setVisibility(8);
        viewOnClickListenerC13070c.Oa().f.setDrawableEndFirst(null);
        viewOnClickListenerC13070c.Oa().f.setText(null);
        viewOnClickListenerC13070c.Oa().o.setText(null);
        viewOnClickListenerC13070c.Oa().u.setText(null);
        viewOnClickListenerC13070c.Oa().b.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (i5 > 50) {
            viewOnClickListenerC13070c.Oa().b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(final ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (!z) {
            viewOnClickListenerC13070c.Oa().c.setVisibility(8);
            return;
        }
        viewOnClickListenerC13070c.Oa().getRoot().post(new Runnable() { // from class: ir.nasim.fX
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13070c.Ya(this.a);
            }
        });
        if (viewOnClickListenerC13070c.Oa().b.getText().toString().length() == 0) {
            nb(viewOnClickListenerC13070c, null, 1, null);
        }
        viewOnClickListenerC13070c.Oa().c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        viewOnClickListenerC13070c.Oa().p.V((int) viewOnClickListenerC13070c.Oa().b.getX(), (int) viewOnClickListenerC13070c.Oa().b.getY());
    }

    private final void Za(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.gX
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13070c.ab(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ab(ViewOnClickListenerC13070c viewOnClickListenerC13070c, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            viewOnClickListenerC13070c.Oa().p.V((int) customInputView.getX(), (int) customInputView.getY());
        }
    }

    private final void bb() {
        Oa().d.setAdapter(this.suggestAdapter);
        RecyclerView recyclerView = Oa().d;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
    }

    private final void cb() {
        Ta();
        Ua();
        Oa().k.setOnClickListener(this);
        Oa().e.setOnClickListener(this);
        Oa().l.setOnClickListener(this);
        Oa().p.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.UW
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ViewOnClickListenerC13070c.db(this.a, view, i2, i3, i4, i5);
            }
        });
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.U3)) {
            Oa().j.setVisibility(8);
            Oa().k.setVisibility(8);
            Oa().l.setVisibility(8);
        }
        Oa().i.setText(i6(AbstractC12217eE5.remaining_balance_wage_description, XY6.e(String.valueOf(AbstractC5969Lp4.e().S().K3()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void db(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (i5 > 50) {
            viewOnClickListenerC13070c.Oa().b.c();
            viewOnClickListenerC13070c.Oa().f.c();
            viewOnClickListenerC13070c.Oa().o.c();
            viewOnClickListenerC13070c.Oa().u.c();
            viewOnClickListenerC13070c.Oa().q.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 eb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, String str, Bundle bundle) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(str, "str");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("src_card_clicked");
        if (string != null) {
            viewOnClickListenerC13070c.m3(string);
        }
        return C19938rB7.a;
    }

    private final void fb() {
        Oa().k.setEnabled(false);
        Ra().U(ZY6.a(XY6.h(Oa().b.getText().toString()))).j(p6(), new l(new UA2() { // from class: ir.nasim.VW
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ViewOnClickListenerC13070c.gb(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 gb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, C5354Iz1 c5354Iz1) {
        String strC;
        String localizedMessage;
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (c5354Iz1.c()) {
            if (c5354Iz1.b() instanceof DuplicateTransactionException) {
                Throwable thB = c5354Iz1.b();
                AbstractC13042fc3.g(thB, "null cannot be cast to non-null type ir.nasim.core.modules.banking.entity.DuplicateTransactionException");
                viewOnClickListenerC13070c.hb(((DuplicateTransactionException) thB).a());
            } else {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Context contextG5 = viewOnClickListenerC13070c.G5();
                Throwable thB2 = c5354Iz1.b();
                if (thB2 == null || (localizedMessage = thB2.getLocalizedMessage()) == null) {
                    strC = null;
                } else {
                    Context contextS7 = viewOnClickListenerC13070c.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    strC = GY6.c(localizedMessage, contextS7);
                }
                aVar.U(contextG5, strC);
                viewOnClickListenerC13070c.Oa().k.setEnabled(true);
            }
            C3343Am.g("new_balance_otp_failure");
        } else {
            viewOnClickListenerC13070c.pb();
            viewOnClickListenerC13070c.jb();
            viewOnClickListenerC13070c.hb(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            C3343Am.g("new_balance_otp_successful");
        }
        return C19938rB7.a;
    }

    private final void hb(int timeout) {
        Oa().k.setEnabled(false);
        int i2 = timeout / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        Oa().k.setText(XY6.e(AbstractC16613la3.a(i2 / 60) + ":" + AbstractC16613la3.a(i2 % 60)));
        j jVar = new j(((long) timeout) * 1000);
        this.otpTimer = jVar;
        jVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(ViewOnClickListenerC13070c viewOnClickListenerC13070c, View view) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        if (AbstractC13042fc3.d(viewOnClickListenerC13070c.Oa().q.getTag(), 0)) {
            viewOnClickListenerC13070c.Oa().q.M(true);
            viewOnClickListenerC13070c.Oa().q.setTag(1);
            viewOnClickListenerC13070c.Oa().q.setDrawableEndFirst(AbstractC4043Dl1.f(viewOnClickListenerC13070c.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            viewOnClickListenerC13070c.Oa().q.M(false);
            viewOnClickListenerC13070c.Oa().q.setTag(0);
            viewOnClickListenerC13070c.Oa().q.setDrawableEndFirst(AbstractC4043Dl1.f(viewOnClickListenerC13070c.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void jb() {
        SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();
        smsBroadcastReceiver.b(new k());
        this.smsBroadcastReceiver = smsBroadcastReceiver;
        Q7().registerReceiver(this.smsBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void kb() {
        Oa().f.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
        Oa().f.setText(null);
        Oa().o.setText(null);
        Oa().u.setText(null);
        Oa().f.setDrawableEndFirst(AbstractC4043Dl1.f(S7(), KB5.ic_card_payment_baseline_visibility_24));
        Oa().f.setEnabled(true);
        this.isLoadSavedCardData = false;
    }

    private final void lb() {
        this.loadDefaultCard = true;
        BankCreditCard bankCreditCardG1 = Pa().g1();
        if (bankCreditCardG1 != null) {
            String strSubstring = bankCreditCardG1.getNumber().substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            if (AbstractC13042fc3.d(ZY6.a(strSubstring), "603799")) {
                Oa().b.setText(bankCreditCardG1.getNumber());
            }
        }
        Ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mb(ArrayList list) {
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
        Oa().p.V((int) Oa().b.getX(), (int) Oa().b.getY());
    }

    static /* synthetic */ void nb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = viewOnClickListenerC13070c.Pa().k1();
        }
        viewOnClickListenerC13070c.mb(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ob(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : Pa().k1()) {
                if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                    String strSubstring = ZY6.a(bankCreditCard.getNumber()).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    if (AbstractC13042fc3.d(strSubstring, "603799")) {
                        arrayList.add(bankCreditCard);
                    }
                }
            }
            mb(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void pb() {
        Task taskA = SF6.a(Q7()).A(null);
        final UA2 ua2 = new UA2() { // from class: ir.nasim.XW
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ViewOnClickListenerC13070c.qb((Void) obj);
            }
        };
        taskA.f(new InterfaceC13497gK4() { // from class: ir.nasim.YW
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                ViewOnClickListenerC13070c.rb(ua2, obj);
            }
        }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.ZW
            @Override // ir.nasim.InterfaceC14681iJ4
            public final void a(Exception exc) {
                ViewOnClickListenerC13070c.sb(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qb(Void r0) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(Exception exc) {
        AbstractC13042fc3.i(exc, "it");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tb() {
        CountDownTimer countDownTimer = this.otpTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Oa().k.setEnabled(true);
        Oa().k.setText(h6(AbstractC12217eE5.card_payment_receive_dynamic_password));
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = this.smsBroadcastReceiver;
            if (smsBroadcastReceiver != null) {
                Q7().unregisterReceiver(smsBroadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ub(ViewOnClickListenerC13070c viewOnClickListenerC13070c, C13944h50 c13944h50) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(c13944h50, "btn");
        viewOnClickListenerC13070c.t(c13944h50);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 vb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        viewOnClickListenerC13070c.Z0(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        viewOnClickListenerC13070c.i5(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xb(ViewOnClickListenerC13070c viewOnClickListenerC13070c, String str) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        viewOnClickListenerC13070c.m3(str);
        viewOnClickListenerC13070c.Pa().q1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yb(ViewOnClickListenerC13070c viewOnClickListenerC13070c) {
        AbstractC13042fc3.i(viewOnClickListenerC13070c, "this$0");
        return viewOnClickListenerC13070c.Fa();
    }

    private final void zb() throws NumberFormatException {
        boolean z;
        C23381wp3.f(Oa().b);
        Oa().c.setVisibility(8);
        Oa().b.clearFocus();
        Oa().f.clearFocus();
        Oa().o.clearFocus();
        Oa().u.clearFocus();
        Oa().q.clearFocus();
        boolean z2 = true;
        if (Oa().b.getText().length() != 0 && Oa().b.getText().length() >= 19) {
            z = false;
        } else {
            CustomInputView customInputView = Oa().b;
            String strH6 = h6(AbstractC12217eE5.card_payment_insert_card_number);
            AbstractC13042fc3.h(strH6, "getString(...)");
            customInputView.setInputError(strH6);
            z = true;
        }
        if (Oa().f.getText().length() == 0 || Oa().f.getText().length() < 3) {
            Oa().f.setErrorStroke(true);
            z = true;
        }
        if (Oa().o.getText().length() == 0 || Oa().o.getText().length() < 2 || Integer.parseInt(Oa().o.getText().toString()) > 12) {
            Oa().o.setErrorStroke(true);
            z = true;
        }
        if (Oa().u.getText().length() == 0 || Oa().u.getText().length() < 2) {
            Oa().u.setErrorStroke(true);
            z = true;
        }
        if (Oa().q.getText().length() != 0 && Oa().q.getText().length() >= 5) {
            z2 = z;
        } else {
            Oa().q.setErrorStroke(true);
        }
        if (z2) {
            return;
        }
        if (Oa().b.r()) {
            Ma();
        } else {
            Oa().b.requestFocus();
        }
    }

    @Override // ir.nasim.features.payment.view.activity.CardPaymentActivity.b
    public boolean B1() {
        if (!u6() || Oa().c.getVisibility() != 0) {
            return true;
        }
        Oa().c.setVisibility(8);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1 && data != null) {
            String stringExtra = data.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            String strA = stringExtra != null ? SmsBroadcastReceiver.INSTANCE.a(stringExtra) : null;
            if (strA != null) {
                Oa().q.setText(strA);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "card_clicked", new InterfaceC14603iB2() { // from class: ir.nasim.TW
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ViewOnClickListenerC13070c.eb(this.a, (String) obj, (Bundle) obj2);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C24048xx2.c(inflater).getRoot();
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
        Oa().c.setVisibility(8);
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
        if (this.config == null) {
            AbstractC13042fc3.y("config");
        }
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
        cb();
        bb();
        ConstraintLayout root = Oa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        this.snackBar = c17468n10;
        c17468n10.k(Oa().e);
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC19224pz3.a(interfaceC18633oz3P6).b(new i(null));
    }

    public final void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        Oa().b.setMaxLength(19);
        Oa().b.setText(cardNumber);
        Oa().b.setErrorStroke(false);
        Oa().b.setSelection(19);
        mb(new ArrayList());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (AbstractC13042fc3.d(view, Oa().k)) {
            Ab();
            return;
        }
        if (AbstractC13042fc3.d(view, Oa().e)) {
            zb();
            return;
        }
        if (AbstractC13042fc3.d(view, Oa().l)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, Z11.a.c(), 4, null).show();
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
        Oa().c.setVisibility(8);
    }
}
