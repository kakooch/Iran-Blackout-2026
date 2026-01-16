package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC17758nW2;
import ir.nasim.AbstractC18623oy2;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10333bU0;
import ir.nasim.C11458d25;
import ir.nasim.C13353g50;
import ir.nasim.C13396g93;
import ir.nasim.C13944h50;
import ir.nasim.C14819iX7;
import ir.nasim.C18564os1;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C20514s83;
import ir.nasim.C20644sM5;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C3641Bs4;
import ir.nasim.C4053Dm2;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8424Vx2;
import ir.nasim.ED1;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14778iT2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC19746qs1;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.KB5;
import ir.nasim.OU3;
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
import ir.nasim.features.payment.view.fragment.C13080m;
import ir.nasim.features.payment.view.fragment.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0011*\u0002\u009a\u0001\b\u0007\u0018\u0000 ¨\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002©\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\bJ'\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010\bJ\u0017\u0010&\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J'\u0010,\u001a\u00020\f2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010\bJ\u000f\u0010/\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010\bJ\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u0010\bJ\u000f\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u0010\bJ\u0017\u00103\u001a\u00020\f2\u0006\u00102\u001a\u00020\tH\u0002¢\u0006\u0004\b3\u0010'J+\u0010;\u001a\u00020:2\u0006\u00105\u001a\u0002042\b\u00107\u001a\u0004\u0018\u0001062\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010A\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010D\u001a\u00020\f2\u0006\u0010C\u001a\u00020:2\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020)H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\f2\u0006\u0010F\u001a\u00020)H\u0016¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020\fH\u0016¢\u0006\u0004\bJ\u0010\bJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\bO\u0010'J\u0017\u0010P\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\bP\u0010'J\u000f\u0010Q\u001a\u00020\fH\u0016¢\u0006\u0004\bQ\u0010\bJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ)\u0010Z\u001a\u00020\f2\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020U2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\fH\u0016¢\u0006\u0004\b\\\u0010\bJ\u0015\u0010^\u001a\u00020\f2\u0006\u0010]\u001a\u00020 ¢\u0006\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001b\u0010r\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\"\u0010\u007f\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010T\"\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010{R \u0010\u008a\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001d\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0095\u0001\u001a\u000b \u0092\u0001*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0094\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u009e\u0001\u0010k\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0005\b¡\u0001\u0010_R&\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¢\u0001\u0010\u0094\u0001\u001a\u0005\b£\u0001\u0010\u000b\"\u0005\b¤\u0001\u0010'R&\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¥\u0001\u0010\u0094\u0001\u001a\u0005\b¦\u0001\u0010\u000b\"\u0005\b§\u0001\u0010'¨\u0006ª\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/m;", "Lir/nasim/ua0;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "Lir/nasim/t40;", "Lir/nasim/g50$d;", "Lir/nasim/g50$e;", "Lir/nasim/g50$c;", "<init>", "()V", "", "wa", "()Ljava/lang/String;", "Lir/nasim/rB7;", "gb", "Ca", "Ea", "Ta", "Ia", "Ra", "Ja", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Pa", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "db", "ya", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "va", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "lb", "caption", "", "amount", "cardNumber", "cb", "(Ljava/lang/String;JLjava/lang/String;)V", "Ha", "ib", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/BankCreditCard;", "Lkotlin/collections/ArrayList;", "list", "fb", "(Ljava/util/ArrayList;)V", "Za", "ua", "ab", "Ya", "path", "eb", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "J6", "(Landroid/content/Context;)V", "M6", "(Landroid/os/Bundle;)V", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", ParameterNames.CARD, "i5", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Z0", "k7", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "m3", "a0", "Q", "", "B1", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "h7", "peer", "bb", "(J)V", "Lir/nasim/qs1;", "h1", "Lir/nasim/Yu3;", "Ba", "()Lir/nasim/qs1;", "viewModel", "Lir/nasim/iT2;", "i1", "Lir/nasim/iT2;", "handleInfoCallback", "j1", "J", "peerUniqueId", "Lir/nasim/Vx2;", "k1", "Lir/nasim/bW7;", "za", "()Lir/nasim/Vx2;", "binding", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "l1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "m1", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "n1", "Z", "getFromMyBank", "setFromMyBank", "(Z)V", "fromMyBank", "Lir/nasim/bU0;", "o1", "Lir/nasim/bU0;", "loadingInitData", "p1", "loadDefaultCard", "Lir/nasim/Bs4;", "q1", "Aa", "()Lir/nasim/Bs4;", "cardsViewModel", "Lir/nasim/g50;", "r1", "Lir/nasim/g50;", "suggestAdapter", "s1", "Ljava/util/ArrayList;", "suggestList", "kotlin.jvm.PlatformType", "t1", "Ljava/lang/String;", "photoExternalFile", "u1", "photoPath", "v1", "photoName", "ir/nasim/features/payment/view/fragment/m$b", "w1", "Lir/nasim/features/payment/view/fragment/m$b;", "cardTextWatcher", "x1", "getAmount", "()J", "setAmount", "y1", "getCaption", "setCaption", "z1", "getCardNumber", "setCardNumber", "A1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.m, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13080m extends AbstractC17758nW2 implements CardPaymentActivity.b, InterfaceC21074t40, C13353g50.d, C13353g50.e, C13353g50.c {

    /* renamed from: i1, reason: from kotlin metadata */
    private InterfaceC14778iT2 handleInfoCallback;

    /* renamed from: l1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: m1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: n1, reason: from kotlin metadata */
    private boolean fromMyBank;

    /* renamed from: p1, reason: from kotlin metadata */
    private boolean loadDefaultCard;

    /* renamed from: u1, reason: from kotlin metadata */
    private String photoPath;

    /* renamed from: v1, reason: from kotlin metadata */
    private String photoName;

    /* renamed from: x1, reason: from kotlin metadata */
    private long amount;
    static final /* synthetic */ InterfaceC5239Im3[] B1 = {AbstractC10882cM5.i(new C25226zw5(C13080m.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCreateMoneyRequestBinding;", 0))};

    /* renamed from: A1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int C1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gs1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13080m.mb(this.a);
        }
    });

    /* renamed from: j1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new h(), AbstractC20046rN7.c());

    /* renamed from: o1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cardsViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new e(this), new f(null, this), new g(this));

    /* renamed from: r1, reason: from kotlin metadata */
    private final C13353g50 suggestAdapter = new C13353g50(null, null, null, new UA2() { // from class: ir.nasim.hs1
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C13080m.jb(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.is1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C13080m.kb(this.a);
        }
    }, 7, null);

    /* renamed from: s1, reason: from kotlin metadata */
    private final ArrayList suggestList = new ArrayList();

    /* renamed from: t1, reason: from kotlin metadata */
    private final String photoExternalFile = C4053Dm2.l("capture", "jpg");

    /* renamed from: w1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: y1, reason: from kotlin metadata */
    private String caption = "";

    /* renamed from: z1, reason: from kotlin metadata */
    private String cardNumber = "";

    /* renamed from: ir.nasim.features.payment.view.fragment.m$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13080m a(long j, boolean z) {
            C13080m c13080m = new C13080m();
            Bundle bundle = new Bundle();
            bundle.putLong("ARG_PEER_UNIQUE_ID", j);
            bundle.putBoolean("ir.nasim.features.payment.view.fragment.from_my_bank", z);
            c13080m.a8(bundle);
            return c13080m;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.m$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C13080m.this.za().j.setVisibility(0);
            if (editable != null) {
                if (ZY6.a(editable.toString()).length() < 6) {
                    C13080m.this.za().i.setMaxLength(-1);
                    C13080m.this.za().i.setErrorStroke(false);
                    C13080m.this.za().i.setDrawableStart(AbstractC4043Dl1.f(C13080m.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                    C13080m.this.za().i.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                } else if (ZY6.a(editable.toString()).length() >= 6) {
                    C13080m c13080m = C13080m.this;
                    String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankVa = c13080m.va(strSubstring);
                    if (bankVa == null) {
                        C13080m.this.za().i.setMaxLength(7);
                        CustomInputView customInputView = C13080m.this.za().i;
                        String strH6 = C13080m.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView.setInputError(strH6);
                    } else {
                        if (editable.length() == 19) {
                            C13080m.this.za().i.setMaxLength(19);
                            C13080m.this.za().j.setVisibility(8);
                        }
                        if (bankVa.getDestinationStatus().isEnable()) {
                            C13080m.this.za().i.setErrorStroke(false);
                            C13080m.this.destBank = bankVa;
                        } else {
                            C13080m.this.za().i.setMaxLength(7);
                            CustomInputView customInputView2 = C13080m.this.za().i;
                            String strI6 = C13080m.this.i6(AbstractC12217eE5.card_payment_unable_dest, bankVa.getName());
                            AbstractC13042fc3.h(strI6, "getString(...)");
                            customInputView2.setStartDrawableError(strI6);
                        }
                        Drawable drawableF = null;
                        C13080m.this.za().i.setDrawableStartTint(null);
                        CustomInputView customInputView3 = C13080m.this.za().i;
                        Integer drawableId = bankVa.getDrawableId();
                        if (drawableId != null) {
                            C13080m c13080m2 = C13080m.this;
                            drawableF = AbstractC4043Dl1.f(c13080m2.S7(), drawableId.intValue());
                        }
                        customInputView3.setDrawableStart(drawableF);
                    }
                }
                C13080m.this.ib(editable.toString());
            } else {
                C13080m c13080m3 = C13080m.this;
                c13080m3.fb(c13080m3.suggestList);
                C13080m.this.suggestAdapter.notifyDataSetChanged();
            }
            if (editable == null || editable.length() == 0) {
                C13080m.this.za().i.setErrorStroke(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.m$c */
    public static final class c implements x.a {
        final /* synthetic */ BankCreditCard b;

        c(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C13080m c13080m, C10333bU0 c10333bU0, C5354Iz1 c5354Iz1) {
            String strC;
            String localizedMessage;
            AbstractC13042fc3.i(c13080m, "this$0");
            AbstractC13042fc3.i(c10333bU0, "$loadingFragment");
            if (c5354Iz1.c()) {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Context contextS7 = c13080m.S7();
                Throwable thB = c5354Iz1.b();
                if (thB == null || (localizedMessage = thB.getLocalizedMessage()) == null) {
                    strC = null;
                } else {
                    Context contextS72 = c13080m.S7();
                    AbstractC13042fc3.h(contextS72, "requireContext(...)");
                    strC = GY6.c(localizedMessage, contextS72);
                }
                aVar.U(contextS7, strC);
            } else {
                Object objA = c5354Iz1.a();
                AbstractC13042fc3.f(objA);
                if (((Boolean) objA).booleanValue()) {
                    c13080m.Ea();
                }
            }
            try {
                c10333bU0.u8();
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
                AbstractC16494lN1.a(c10333bU0);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            final C10333bU0 c10333bU0 = new C10333bU0();
            c10333bU0.K8(C13080m.this.Q7().B0(), null);
            androidx.lifecycle.r rVarQ = C13080m.this.Ba().Q(this.b);
            InterfaceC18633oz3 interfaceC18633oz3P6 = C13080m.this.p6();
            final C13080m c13080m = C13080m.this;
            rVarQ.j(interfaceC18633oz3P6, new d(new UA2() { // from class: ir.nasim.ms1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13080m.c.c(c13080m, c10333bU0, (C5354Iz1) obj);
                }
            }));
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.m$d */
    static final class d implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        d(UA2 ua2) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.m$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.m$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, Fragment fragment) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.m$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.m$h */
    public static final class h extends AbstractC8614Ws3 implements UA2 {
        public h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C8424Vx2.a(fragment.V7());
        }
    }

    private final C3641Bs4 Aa() {
        return (C3641Bs4) this.cardsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19746qs1 Ba() {
        return (InterfaceC19746qs1) this.viewModel.getValue();
    }

    private final void Ca() {
        za().m.animate().alpha(0.1f).setDuration(100L).withEndAction(new Runnable() { // from class: ir.nasim.js1
            @Override // java.lang.Runnable
            public final void run() {
                C13080m.Da(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(C13080m c13080m) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.za().g.setAlpha(0.0f);
        c13080m.za().g.setVisibility(0);
        c13080m.za().m.setVisibility(8);
        c13080m.za().g.animate().alpha(1.0f).setDuration(120L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea() {
        C10333bU0 c10333bU0 = this.loadingInitData;
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        try {
            Ba().getConfig().j(p6(), new d(new UA2() { // from class: ir.nasim.ks1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13080m.Fa(this.a, (CardToCardConfig) obj);
                }
            }));
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            try {
                this.loadingInitData.u8();
            } catch (Exception e3) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e3);
                AbstractC16494lN1.a(this.loadingInitData);
            }
            Q7().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa(final C13080m c13080m, CardToCardConfig cardToCardConfig) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.config = cardToCardConfig;
        c13080m.Ba().c0().j(c13080m.p6(), new d(new UA2() { // from class: ir.nasim.Ur1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13080m.Ga(this.a, (ArrayList) obj);
            }
        }));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga(C13080m c13080m, ArrayList arrayList) {
        AbstractC13042fc3.i(c13080m, "this$0");
        if (arrayList == null || arrayList.isEmpty()) {
            c13080m.ya();
        } else {
            c13080m.suggestList.clear();
            c13080m.suggestList.addAll(arrayList);
            if (c13080m.za().i.getText().length() == 0) {
                c13080m.fb(c13080m.suggestList);
            } else {
                c13080m.ib(c13080m.za().i.getText().toString());
            }
            if (c13080m.loadDefaultCard) {
                c13080m.ya();
            } else {
                c13080m.db();
            }
        }
        return C19938rB7.a;
    }

    private final void Ha() {
        za().k.setAdapter(this.suggestAdapter);
        RecyclerView recyclerView = za().k;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        this.suggestAdapter.C(this);
        this.suggestAdapter.D(this);
        this.suggestAdapter.E(this);
    }

    private final void Ia() {
        za().t.setHintTypeFace(C6011Lu2.i());
        za().t.setTextTypeFace(C6011Lu2.k());
        za().v.setTypeface(C6011Lu2.k());
        za().s.setTypeface(C6011Lu2.k());
        za().h.setHintTypeFace(C6011Lu2.i());
        za().h.setTextTypeFace(C6011Lu2.k());
        za().i.setHintTypeFace(C6011Lu2.i());
        za().i.setTextTypeFace(C6011Lu2.k());
        za().f.setTypeface(C6011Lu2.i());
        za().p.setTypeface(C6011Lu2.i());
        za().r.setTypeface(C6011Lu2.i());
        za().q.setTypeface(C6011Lu2.i());
    }

    private final void Ja() {
        CustomInputView customInputView = za().t;
        CustomInputView customInputView2 = za().t;
        AbstractC13042fc3.h(customInputView2, "variableAmountInput");
        customInputView.b(new C20514s83(customInputView2));
        CustomInputView customInputView3 = za().i;
        CustomInputView customInputView4 = za().i;
        AbstractC13042fc3.h(customInputView4, "destinationCardNumberInput");
        customInputView3.b(new C13396g93(customInputView4));
        za().i.b(this.cardTextWatcher);
        CustomInputView customInputView5 = za().t;
        AbstractC13042fc3.h(customInputView5, "variableAmountInput");
        Pa(customInputView5);
        CustomInputView customInputView6 = za().h;
        AbstractC13042fc3.h(customInputView6, "descriptionInput");
        Pa(customInputView6);
        za().n.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.Wr1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                C13080m.Ka(this.a, view, i, i2, i3, i4);
            }
        });
        za().i.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Xr1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C13080m.La(this.a, view, z);
            }
        });
        za().h.setDrawableEndFirstClickListener(new View.OnClickListener() { // from class: ir.nasim.Yr1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13080m.Na(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(C13080m c13080m, View view, int i, int i2, int i3, int i4) {
        AbstractC13042fc3.i(c13080m, "this$0");
        if (i4 > 50) {
            c13080m.za().t.c();
            c13080m.za().h.c();
            c13080m.za().i.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(final C13080m c13080m, View view, boolean z) {
        AbstractC13042fc3.i(c13080m, "this$0");
        if (!z) {
            c13080m.za().j.setVisibility(8);
        } else {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.cs1
                @Override // java.lang.Runnable
                public final void run() {
                    C13080m.Ma(this.a);
                }
            }, 100L);
            c13080m.za().j.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(C13080m c13080m) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.za().n.V((int) c13080m.za().i.getX(), (int) c13080m.za().i.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(final C13080m c13080m, View view) {
        AbstractC13042fc3.i(c13080m, "this$0");
        new AlertDialog.Builder(c13080m.S7(), AbstractC23035wE5.AlertDialogStyle).setItems(new CharSequence[]{c13080m.Q7().getString(AbstractC12217eE5.card_payment_pick_photo_camera), c13080m.Q7().getString(AbstractC12217eE5.card_payment_pick_photo_gallery)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.as1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C13080m.Oa(this.a, dialogInterface, i);
            }
        }).show().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(C13080m c13080m, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(c13080m, "this$0");
        if (i == 0) {
            c13080m.Za();
        } else {
            if (i != 1) {
                return;
            }
            c13080m.ab();
        }
    }

    private final void Pa(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.bs1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C13080m.Qa(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(C13080m c13080m, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(c13080m, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            c13080m.za().n.V((int) customInputView.getX(), (int) customInputView.getY());
        }
    }

    private final void Ra() {
        za().u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.Vr1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C13080m.Sa(this.a, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(C13080m c13080m, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.za().t.setEnabled(!z);
        if (!z) {
            c13080m.za().t.setHint(c13080m.h6(AbstractC12217eE5.card_payment_enter_your_amount));
        } else {
            c13080m.za().t.setText(null);
            c13080m.za().t.setHint(c13080m.h6(AbstractC12217eE5.card_payment_variable_amount_is_activated));
        }
    }

    private final void Ta() {
        Ia();
        Ra();
        Ja();
        za().o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Tr1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                C13080m.Ua(this.a, view);
            }
        });
        za().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ds1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13080m.Va(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(C13080m c13080m, View view) throws NumberFormatException {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(C13080m c13080m, View view) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.photoPath = null;
        c13080m.photoName = null;
        c13080m.za().c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(C13080m c13080m, String str, String str2) {
        AbstractC13042fc3.i(c13080m, "this$0");
        if (str != null) {
            c13080m.eb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Xa(C13080m c13080m, String str, Bundle bundle) {
        AbstractC13042fc3.i(c13080m, "this$0");
        AbstractC13042fc3.i(str, "str");
        AbstractC13042fc3.i(bundle, "bundle");
        long j = bundle.getLong("ARG_PEER_UNIQUE_ID");
        if (j != 0) {
            c13080m.bb(j);
        }
        return C19938rB7.a;
    }

    private final void Ya() {
        FragmentActivity fragmentActivityQ7 = Q7();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        fragmentActivityQ7.startActivityForResult(C22055ub3.j(contextS7, true, false, true, false), 5004);
    }

    private final void Za() {
        if (this.photoExternalFile == null) {
            Toast.makeText(G5(), AbstractC12217eE5.toast_no_sdcard, 1).show();
            return;
        }
        if (AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") == 0) {
            ua();
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

    private final void ab() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Ya();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.P0(c21753u45, fragmentActivityQ7, 5002, Integer.valueOf(AbstractC12217eE5.card_payment_external_storage_permission_desctiption), null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 8, null);
    }

    private final void cb(String caption, long amount, String cardNumber) {
        if (this.photoPath == null) {
            InterfaceC19746qs1.q(Ba(), this.peerUniqueId, null, null, caption, amount, cardNumber, 6, null);
        } else {
            InterfaceC19746qs1 interfaceC19746qs1Ba = Ba();
            long j = this.peerUniqueId;
            String str = this.photoPath;
            AbstractC13042fc3.f(str);
            String str2 = this.photoName;
            AbstractC13042fc3.f(str2);
            interfaceC19746qs1Ba.m0(j, str, str2, caption, amount, cardNumber);
        }
        C3343Am.g("new_create_money_request_send");
        if (this.fromMyBank) {
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25R = C11458d25.r(this.peerUniqueId);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            C18987pb3.x1(c18987pb3, c11458d25R, null, null, false, null, null, false, null, null, false, null, 2046, null);
        }
        Q7().finish();
    }

    private final void db() {
        this.loadDefaultCard = true;
        for (BankCreditCard bankCreditCard : this.suggestList) {
            if (bankCreditCard.isDefault()) {
                za().i.setText(bankCreditCard.getNumber());
            }
        }
        ya();
    }

    private final void eb(String path) {
        za().e.setImageURI(Uri.fromFile(new File(path)));
        this.photoName = GY6.e(path);
        this.photoPath = path;
        za().c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fb(ArrayList list) {
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
        za().n.V((int) za().i.getX(), (int) za().i.getY());
    }

    private final void gb() {
        za().g.animate().alpha(0.1f).setDuration(140L).withEndAction(new Runnable() { // from class: ir.nasim.Zr1
            @Override // java.lang.Runnable
            public final void run() {
                C13080m.hb(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hb(C13080m c13080m) {
        AbstractC13042fc3.i(c13080m, "this$0");
        c13080m.za().m.setAlpha(0.0f);
        c13080m.za().m.setVisibility(0);
        c13080m.za().g.setVisibility(8);
        c13080m.za().m.animate().alpha(1.0f).setDuration(160L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ib(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : this.suggestList) {
                if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(ZY6.a(cardNumber)), false, 2, null)) {
                    arrayList.add(bankCreditCard);
                }
            }
            fb(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 jb(C13080m c13080m, String str) {
        AbstractC13042fc3.i(c13080m, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        c13080m.a0(str);
        c13080m.Aa().q1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String kb(C13080m c13080m) {
        AbstractC13042fc3.i(c13080m, "this$0");
        return c13080m.wa();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void lb() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.C13080m.lb():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18564os1 mb(C13080m c13080m) {
        AbstractC13042fc3.i(c13080m, "this$0");
        FragmentActivity fragmentActivityQ7 = c13080m.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C18564os1) new androidx.lifecycle.G(fragmentActivityQ7).b(C18564os1.class);
    }

    private final void ua() {
        Uri uriH = FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.photoExternalFile));
        FragmentActivity fragmentActivityQ7 = Q7();
        Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriH);
        AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
        fragmentActivityQ7.startActivityForResult(intentPutExtra, 5003);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank va(String pattern) {
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = this.config;
            if (cardToCardConfig == null) {
                AbstractC13042fc3.y("config");
                cardToCardConfig = null;
            }
            for (Bank bank2 : cardToCardConfig.getBankList()) {
                try {
                    if (bank2.getCardNumberPattern().contains(XY6.h(pattern))) {
                        bank = bank2;
                    }
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                }
            }
        } catch (Exception e3) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e3);
        }
        return bank;
    }

    private final String wa() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) S7().getSystemService("clipboard");
            CharSequence text = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText();
            if (text == null || text.length() == 0 || !Aa().Y0(text.toString())) {
                return null;
            }
            List<String> listK = AbstractC11342cq6.K(AbstractC11342cq6.C(C20644sM5.e(new C20644sM5("\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}"), text, 0, 2, null), new UA2() { // from class: ir.nasim.ls1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C13080m.xa((OU3) obj);
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
    public static final String xa(OU3 ou3) {
        AbstractC13042fc3.i(ou3, "it");
        return ou3.getValue();
    }

    private final void ya() {
        try {
            this.loadingInitData.u8();
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            AbstractC16494lN1.a(this.loadingInitData);
        }
        za().t.clearFocus();
        za().h.clearFocus();
        za().i.clearFocus();
        za().n.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8424Vx2 za() {
        return (C8424Vx2) this.binding.a(this, B1[0]);
    }

    @Override // ir.nasim.features.payment.view.activity.CardPaymentActivity.b
    public boolean B1() {
        if (!u6()) {
            return true;
        }
        if (za().m.getVisibility() == 0) {
            Ca();
        } else {
            if (za().j.getVisibility() != 0) {
                return true;
            }
            za().j.setVisibility(8);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 4) {
            gb();
            return;
        }
        if (requestCode == 5003) {
            String str = this.photoExternalFile;
            if (str == null || str.length() == 0) {
                return;
            }
            AbstractC17543n85.a(this, A5(), this.photoExternalFile, 1, true, new AbstractC17543n85.b() { // from class: ir.nasim.fs1
                @Override // ir.nasim.AbstractC17543n85.b
                public final void a(String str2, String str3) {
                    C13080m.Wa(this.a, str2, str3);
                }
            });
            return;
        }
        if (requestCode != 5004) {
            return;
        }
        String str2 = null;
        ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra("PHOTOS") : null;
        if ((stringArrayListExtra == null || stringArrayListExtra.size() != 0) && stringArrayListExtra != null) {
            str2 = stringArrayListExtra.get(0);
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        eb(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.AbstractC17758nW2, androidx.fragment.app.Fragment
    public void J6(Context context) {
        AbstractC13042fc3.i(context, "context");
        super.J6(context);
        if (context instanceof InterfaceC14778iT2) {
            this.handleInfoCallback = (InterfaceC14778iT2) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.peerUniqueId = bundleE5.getLong("ARG_PEER_UNIQUE_ID");
            this.fromMyBank = bundleE5.getBoolean("ir.nasim.features.payment.view.fragment.from_my_bank", false);
        }
        AbstractC18623oy2.d(this, "money_request_selected_peer", new InterfaceC14603iB2() { // from class: ir.nasim.es1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C13080m.Xa(this.a, (String) obj, (Bundle) obj2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void Q() {
        Ea();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        FrameLayout root = C8424Vx2.c(inflater).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C13353g50.d
    public void Z0(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        za().j.setVisibility(8);
        if (card.getType() == BankCreditCard.c.a) {
            a0(card.getNumber());
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void a0(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        za().i.setMaxLength(19);
        za().i.setText(cardNumber);
        za().i.setErrorStroke(false);
        za().i.setSelection(19);
        fb(new ArrayList());
    }

    public final void bb(long peer) {
        this.peerUniqueId = peer;
        cb(this.caption, this.amount, this.cardNumber);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
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
    public void k7() {
        super.k7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Ta();
        Ea();
        Ha();
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        za().i.setMaxLength(19);
        za().i.setText(cardNumber);
        za().i.setErrorStroke(false);
        za().i.setSelection(19);
        fb(new ArrayList());
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
            C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
        }
        za().j.setVisibility(8);
    }
}
