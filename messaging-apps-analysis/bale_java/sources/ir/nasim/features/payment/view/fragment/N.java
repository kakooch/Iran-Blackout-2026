package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.SapOuterClass$ResponseTransferMoneyByCard;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.j;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16613la3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5830La0;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C10333bU0;
import ir.nasim.C16358l82;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C23076wJ1;
import ir.nasim.C23381wp3;
import ir.nasim.C3343Am;
import ir.nasim.C4100Dr4;
import ir.nasim.C4178Ea1;
import ir.nasim.C5495Jo7;
import ir.nasim.C5589Jz2;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13497gK4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14681iJ4;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.Q45;
import ir.nasim.SA2;
import ir.nasim.SF6;
import ir.nasim.SR7;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.model.CardToCardReceipt;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.util.SmsBroadcastReceiver;
import ir.nasim.features.payment.view.fragment.B;
import ir.nasim.features.payment.view.fragment.G;
import ir.nasim.features.payment.view.fragment.N;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001|B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0005J)\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u0010\u0005J\u0017\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\bH\u0002¢\u0006\u0004\b:\u0010\u0005R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010a\u001a\u00020Z8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010i\u001a\u00020b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010lR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010v\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010x\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010uR\u0014\u0010z\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010u¨\u0006}"}, d2 = {"Lir/nasim/features/payment/view/fragment/N;", "Lir/nasim/La0;", "Lir/nasim/Jz2;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "k7", "R6", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "p0", "onClick", "(Landroid/view/View;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "attachToParent", "T8", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/Jz2;", "U8", "h9", "f9", "X8", "W8", "O8", "v9", "Y8", "d9", "e9", "s9", "r9", "b9", "q9", "i9", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Z8", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "V8", "j9", "E9", "A9", "w9", "Lir/nasim/SR7;", "Y0", "Lir/nasim/SR7;", "viewModel", "Lir/nasim/features/payment/view/fragment/B$b;", "Z0", "Lir/nasim/features/payment/view/fragment/B$b;", "type", "Lir/nasim/J44;", "a1", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "", "b1", "Ljava/lang/Long;", "peerUniqueId", "Lir/nasim/features/payment/data/response/Bank;", "c1", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "Lir/nasim/features/payment/data/model/BankCreditCard;", "d1", "Lir/nasim/features/payment/data/model/BankCreditCard;", "sourceCreditCard", "", "e1", "Ljava/lang/String;", "desc", "f1", "Z", "isSavedDestination", "Lir/nasim/n10;", "g1", "Lir/nasim/n10;", "S8", "()Lir/nasim/n10;", "u9", "(Lir/nasim/n10;)V", "snackBar", "Lir/nasim/wJ1;", "h1", "Lir/nasim/wJ1;", "R8", "()Lir/nasim/wJ1;", "t9", "(Lir/nasim/wJ1;)V", "response", "Landroid/os/CountDownTimer;", "i1", "Landroid/os/CountDownTimer;", "otpTimer", "j1", "verifyTimer", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "k1", "Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "smsBroadcastReceiver", "l1", "Landroid/view/View$OnClickListener;", "cvv2InputVisibleClickListener", "m1", "pin2InputVisibleClickListener", "n1", "cvv2InputClearSavedClickListener", "o1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class N extends AbstractC5830La0<C5589Jz2> implements View.OnClickListener {

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int p1 = 8;

    /* renamed from: Y0, reason: from kotlin metadata */
    private SR7 viewModel;

    /* renamed from: Z0, reason: from kotlin metadata */
    private B.b type;

    /* renamed from: a1, reason: from kotlin metadata */
    private J44 message;

    /* renamed from: b1, reason: from kotlin metadata */
    private Long peerUniqueId;

    /* renamed from: c1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: d1, reason: from kotlin metadata */
    private BankCreditCard sourceCreditCard;

    /* renamed from: e1, reason: from kotlin metadata */
    private String desc;

    /* renamed from: f1, reason: from kotlin metadata */
    private boolean isSavedDestination;

    /* renamed from: g1, reason: from kotlin metadata */
    public C17468n10 snackBar;

    /* renamed from: h1, reason: from kotlin metadata */
    public C23076wJ1 response;

    /* renamed from: i1, reason: from kotlin metadata */
    private CountDownTimer otpTimer;

    /* renamed from: j1, reason: from kotlin metadata */
    private CountDownTimer verifyTimer;

    /* renamed from: k1, reason: from kotlin metadata */
    private SmsBroadcastReceiver smsBroadcastReceiver;

    /* renamed from: l1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.OR7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.N.Q8(this.a, view);
        }
    };

    /* renamed from: m1, reason: from kotlin metadata */
    private final View.OnClickListener pin2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.zR7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.N.g9(this.a, view);
        }
    };

    /* renamed from: n1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputClearSavedClickListener = new View.OnClickListener() { // from class: ir.nasim.AR7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.payment.view.fragment.N.P8(this.a, view);
        }
    };

    /* renamed from: ir.nasim.features.payment.view.fragment.N$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final N a(int i, byte[] bArr, Long l, Bank bank, BankCreditCard bankCreditCard, String str, boolean z) {
            AbstractC13042fc3.i(bank, "destBank");
            AbstractC13042fc3.i(bankCreditCard, "sourceCreditCard");
            AbstractC13042fc3.i(str, "desc");
            N n = new N();
            Bundle bundle = new Bundle();
            bundle.putInt("type_param", i);
            if (bArr != null) {
                bundle.putByteArray("message_param", bArr);
            }
            if (l != null) {
                bundle.putLong("peer_unique_id_param", l.longValue());
            }
            bundle.putParcelable("dest_logo_param", bank);
            bundle.putParcelable("src_source_card_param", bankCreditCard);
            bundle.putString("desc_param", str);
            bundle.putBoolean("saved_dest_param", z);
            n.a8(bundle);
            return n;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ N c;

            /* renamed from: ir.nasim.features.payment.view.fragment.N$b$a$a, reason: collision with other inner class name */
            static final class C1192a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ N d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1192a(N n, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = n;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1192a c1192a = new C1192a(this.d, interfaceC20295rm1);
                    c1192a.c = obj;
                    return c1192a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    SR7.a aVar = (SR7.a) this.c;
                    if (AbstractC13042fc3.d(aVar, SR7.a.C0620a.a)) {
                        ((C5589Jz2) this.d.r8()).o.setText(this.d.h6(AbstractC12217eE5.card_payment_receive_dynamic_password));
                    } else if (AbstractC13042fc3.d(aVar, SR7.a.b.a)) {
                        ((C5589Jz2) this.d.r8()).o.setText(this.d.h6(AbstractC12217eE5.sending_request));
                    } else {
                        if (!(aVar instanceof SR7.a.c)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        SR7.a.c cVar = (SR7.a.c) aVar;
                        ((C5589Jz2) this.d.r8()).o.setText(XY6.e(AbstractC16613la3.a(cVar.a() / 60) + ":" + AbstractC16613la3.a(cVar.a() % 60)));
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(SR7.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1192a) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(N n, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = n;
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
                    SR7 sr7 = this.c.viewModel;
                    if (sr7 == null) {
                        AbstractC13042fc3.y("viewModel");
                        sr7 = null;
                    }
                    InterfaceC10258bL6 interfaceC10258bL6Y0 = sr7.Y0();
                    C1192a c1192a = new C1192a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6Y0, c1192a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return N.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                N n = N.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(n, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(n, bVar, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 7) {
                return;
            }
            N.this.i9();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
            N.this.q9();
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
            N.this.s9();
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
            ((C5589Jz2) N.this.r8()).z.requestFocus();
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
            C23381wp3.f(((C5589Jz2) N.this.r8()).z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class h implements SmsBroadcastReceiver.b {
        h() {
        }

        @Override // ir.nasim.features.payment.util.SmsBroadcastReceiver.b
        public void a(Intent intent) {
            if (intent != null) {
                try {
                    N.this.startActivityForResult(intent, 100);
                } catch (Exception e) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e);
                }
            }
        }
    }

    static final class i implements InterfaceC15796kB2 {
        final /* synthetic */ Exception b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ Exception a;
            final /* synthetic */ N b;

            a(Exception exc, N n) {
                this.a = exc;
                this.b = n;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String strC;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String localizedMessage = this.a.getLocalizedMessage();
                if (localizedMessage != null) {
                    Context contextS7 = this.b.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    strC = GY6.c(localizedMessage, contextS7);
                } else {
                    strC = null;
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

        i(Exception exc) {
            this.b = exc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog, N n) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(n, "this$0");
            dialog.dismiss();
            n.Q7().onBackPressed();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC14603iB2 interfaceC14603iB2D = C4178Ea1.a.d();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1568594517, true, new a(this.b, N.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1895698248);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(N.this);
            final N n = N.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.O
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return N.i.c(dialog, n);
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

    private final void A9() {
        final C10333bU0 c10333bU0 = new C10333bU0();
        SR7 sr7 = null;
        c10333bU0.K8(Q7().B0(), null);
        String strB = GY6.b(ZY6.a(((C5589Jz2) r8()).d.getText().toString()));
        String strB2 = GY6.b(ZY6.a(((C5589Jz2) r8()).z.getText().toString()));
        BankCreditCard bankCreditCard = this.sourceCreditCard;
        if (bankCreditCard == null) {
            AbstractC13042fc3.y("sourceCreditCard");
            bankCreditCard = null;
        }
        String id = bankCreditCard.getId();
        String strJ = R8().j();
        Integer numValueOf = Integer.valueOf(Integer.parseInt(((C5589Jz2) r8()).v.getText().toString()));
        Integer numValueOf2 = Integer.valueOf(Integer.parseInt(((C5589Jz2) r8()).G.getText().toString()));
        BankCreditCard bankCreditCard2 = this.sourceCreditCard;
        if (bankCreditCard2 == null) {
            AbstractC13042fc3.y("sourceCreditCard");
            bankCreditCard2 = null;
        }
        BankCreditCard bankCreditCard3 = new BankCreditCard(id, strJ, numValueOf, numValueOf2, bankCreditCard2.getCvv2(), null, false, BankCreditCard.c.a, false, false, false, 1888, null);
        Long lA = R8().a();
        String str = strB + "|" + strB2 + "|" + String.valueOf(lA != null ? (int) lA.longValue() : 0) + "|" + GY6.b(AbstractC20153rZ6.M(R8().f(), Separators.SP, "", false, 4, null));
        SR7 sr72 = this.viewModel;
        if (sr72 == null) {
            AbstractC13042fc3.y("viewModel");
        } else {
            sr7 = sr72;
        }
        String strB3 = GY6.b(AbstractC20153rZ6.M(R8().f(), Separators.SP, "", false, 4, null));
        Long lA2 = R8().a();
        int iLongValue = lA2 != null ? (int) lA2.longValue() : 0;
        String strB4 = R8().b();
        String strC = R8().c();
        C16358l82 c16358l82 = C16358l82.a;
        String strH = AbstractC19902r80.h();
        AbstractC13042fc3.h(strH, "getShaparakPublicKey(...)");
        sr7.c1(bankCreditCard3, strB3, iLongValue, strB4, strB2, strB, strC, c16358l82.g(str, strH), R8().g(), R8().k(), ((C5589Jz2) r8()).A.isChecked(), R8().d()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.yR7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.N.B9(this.a, (SapOuterClass$ResponseTransferMoneyByCard) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.GR7
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ir.nasim.features.payment.view.fragment.N.C9(c10333bU0, (SapOuterClass$ResponseTransferMoneyByCard) obj, (Exception) obj2);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.HR7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.N.D9(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(N n, SapOuterClass$ResponseTransferMoneyByCard sapOuterClass$ResponseTransferMoneyByCard) {
        AbstractC13042fc3.i(n, "this$0");
        G.Companion companion = G.INSTANCE;
        B.b bVar = n.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        int iOrdinal = bVar.ordinal();
        J44 j44 = n.message;
        byte[] byteArray = j44 != null ? j44.toByteArray() : null;
        Long l = n.peerUniqueId;
        String traceNumber = sapOuterClass$ResponseTransferMoneyByCard.getTraceNumber();
        AbstractC13042fc3.h(traceNumber, "getTraceNumber(...)");
        String strA = GY6.a(traceNumber);
        String str = XY6.c(GY6.a(String.valueOf(n.R8().a())), (char) 0, 2, null) + Separators.SP + n.h6(AbstractC12217eE5.amount_rial);
        String strA2 = GY6.a(n.R8().j());
        String strA3 = GY6.a(n.R8().f());
        String strC = n.R8().c();
        String transactionTime = sapOuterClass$ResponseTransferMoneyByCard.getTransactionTime();
        AbstractC13042fc3.h(transactionTime, "getTransactionTime(...)");
        companion.b(iOrdinal, byteArray, l, new CardToCardReceipt(strA, str, strA2, strA3, strC, transactionTime, n.R8().d())).K8(n.Q7().B0(), null);
        C3343Am.g("c2c_submit_successful");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(C10333bU0 c10333bU0, SapOuterClass$ResponseTransferMoneyByCard sapOuterClass$ResponseTransferMoneyByCard, Exception exc) {
        AbstractC13042fc3.i(c10333bU0, "$loadingDialogFragment");
        AbstractC16494lN1.a(c10333bU0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(N n, Exception exc) {
        AbstractC13042fc3.i(n, "this$0");
        Context contextS7 = n.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AbstractC21375tZ.c(contextS7, n, null, AbstractC19242q11.c(1585830426, true, n.new i(exc)), 4, null).show();
        C3343Am.g("c2c_submit_failure");
    }

    private final void E9() {
        boolean z;
        boolean z2 = true;
        if (!R8().l() || (((C5589Jz2) r8()).c.getText().length() != 0 && ((C5589Jz2) r8()).c.getText().length() >= 4)) {
            z = false;
        } else {
            ((C5589Jz2) r8()).c.setErrorStroke(true);
            z = true;
        }
        if (((C5589Jz2) r8()).d.getText().length() == 0 || ((C5589Jz2) r8()).d.getText().length() < 3) {
            ((C5589Jz2) r8()).d.setErrorStroke(true);
            z = true;
        }
        if (((C5589Jz2) r8()).v.getText().length() == 0 || ((C5589Jz2) r8()).v.getText().length() < 2 || Integer.parseInt(((C5589Jz2) r8()).v.getText().toString()) > 12) {
            ((C5589Jz2) r8()).v.setErrorStroke(true);
            z = true;
        }
        if (((C5589Jz2) r8()).G.getText().length() == 0 || ((C5589Jz2) r8()).G.getText().length() < 2) {
            ((C5589Jz2) r8()).G.setErrorStroke(true);
            z = true;
        }
        if (((C5589Jz2) r8()).z.getText().length() != 0 && ((C5589Jz2) r8()).z.getText().length() >= 5) {
            z2 = z;
        } else {
            ((C5589Jz2) r8()).z.setErrorStroke(true);
        }
        if (z2) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            A9();
            return;
        }
        C17468n10 c17468n10S8 = S8();
        String strH6 = h6(AbstractC12217eE5.do_not_access);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10S8.o(strH6);
    }

    private final void O8() {
        ((C5589Jz2) r8()).c.clearFocus();
        ((C5589Jz2) r8()).d.clearFocus();
        ((C5589Jz2) r8()).v.clearFocus();
        ((C5589Jz2) r8()).G.clearFocus();
        ((C5589Jz2) r8()).z.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P8(N n, View view) {
        AbstractC13042fc3.i(n, "this$0");
        ((C5589Jz2) n.r8()).d.setDrawableEndFirstClickListener(n.cvv2InputVisibleClickListener);
        ((C5589Jz2) n.r8()).d.setText(null);
        ((C5589Jz2) n.r8()).d.setDrawableEndFirst(AbstractC4043Dl1.f(n.S7(), KB5.ic_card_payment_baseline_visibility_24));
        ((C5589Jz2) n.r8()).d.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(N n, View view) {
        AbstractC13042fc3.i(n, "this$0");
        if (AbstractC13042fc3.d(((C5589Jz2) n.r8()).d.getTag(), 0)) {
            ((C5589Jz2) n.r8()).d.M(true);
            ((C5589Jz2) n.r8()).d.setTag(1);
            ((C5589Jz2) n.r8()).d.setDrawableEndFirst(AbstractC4043Dl1.f(n.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            ((C5589Jz2) n.r8()).d.M(false);
            ((C5589Jz2) n.r8()).d.setTag(0);
            ((C5589Jz2) n.r8()).d.setDrawableEndFirst(AbstractC4043Dl1.f(n.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void U8() {
        SR7 sr7 = this.viewModel;
        if (sr7 == null) {
            AbstractC13042fc3.y("viewModel");
            sr7 = null;
        }
        BankCreditCard bankCreditCard = this.sourceCreditCard;
        if (bankCreditCard == null) {
            AbstractC13042fc3.y("sourceCreditCard");
            bankCreditCard = null;
        }
        sr7.Z0(bankCreditCard.getNumber());
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new b(null), 3, null);
    }

    private final void V8() {
        ((C5589Jz2) r8()).o.setOnClickListener(this);
        ((C5589Jz2) r8()).x.setOnClickListener(this);
        ((C5589Jz2) r8()).p.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [ir.nasim.rB7] */
    private final void W8() {
        String str = "NON_FATAL_EXCEPTION";
        if (this.response == null) {
            Q7().B0().k1();
            return;
        }
        try {
            if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.R3)) {
                if (this.sourceCreditCard == null) {
                    AbstractC13042fc3.y("sourceCreditCard");
                }
                try {
                    BankCreditCard bankCreditCard = this.sourceCreditCard;
                    BankCreditCard bankCreditCard2 = null;
                    if (bankCreditCard == null) {
                        AbstractC13042fc3.y("sourceCreditCard");
                        bankCreditCard = null;
                    }
                    String cvv2 = bankCreditCard.getCvv2();
                    if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.S3) && cvv2 != null && cvv2.length() != 0) {
                        ((C5589Jz2) r8()).d.setText(cvv2);
                        ((C5589Jz2) r8()).d.setDrawableEndFirstClickListener(this.cvv2InputClearSavedClickListener);
                        ((C5589Jz2) r8()).d.setDrawableEndFirst(AbstractC4043Dl1.f(S7(), KB5.ic_card_payment_close));
                        ((C5589Jz2) r8()).d.setEnabled(false);
                        ((C5589Jz2) r8()).d.setBackgroundTint(C5495Jo7.a.G0());
                        O8();
                    }
                    BankCreditCard bankCreditCard3 = this.sourceCreditCard;
                    if (bankCreditCard3 == null) {
                        AbstractC13042fc3.y("sourceCreditCard");
                        bankCreditCard3 = null;
                    }
                    if (bankCreditCard3.getExpirationMonth() != null) {
                        CustomInputView customInputView = ((C5589Jz2) r8()).v;
                        BankCreditCard bankCreditCard4 = this.sourceCreditCard;
                        if (bankCreditCard4 == null) {
                            AbstractC13042fc3.y("sourceCreditCard");
                            bankCreditCard4 = null;
                        }
                        customInputView.setText(bankCreditCard4.getRealExpirationMonth());
                    }
                    BankCreditCard bankCreditCard5 = this.sourceCreditCard;
                    if (bankCreditCard5 == null) {
                        AbstractC13042fc3.y("sourceCreditCard");
                        bankCreditCard5 = null;
                    }
                    if (bankCreditCard5.getExpirationYear() != null) {
                        CustomInputView customInputView2 = ((C5589Jz2) r8()).G;
                        BankCreditCard bankCreditCard6 = this.sourceCreditCard;
                        if (bankCreditCard6 == null) {
                            AbstractC13042fc3.y("sourceCreditCard");
                        } else {
                            bankCreditCard2 = bankCreditCard6;
                        }
                        customInputView2.setText(bankCreditCard2.getRealExpirationYear());
                        str = C19938rB7.a;
                    }
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            }
        } catch (Exception e3) {
            C19406qI3.d(str, e3);
        }
    }

    private final void X8() {
        if (this.isSavedDestination) {
            ((C5589Jz2) r8()).A.setVisibility(8);
            ((C5589Jz2) r8()).n.setVisibility(8);
        }
    }

    private final void Y8() {
        ((C5589Jz2) r8()).t.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).l.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).s.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).k.setTypeface(C6011Lu2.k());
        ((C5589Jz2) r8()).A.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).u.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).E.setTypeface(C6011Lu2.k());
        ((C5589Jz2) r8()).r.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).b.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).g.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).f.setTypeface(C6011Lu2.k());
        ((C5589Jz2) r8()).o.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).p.setTypeface(C6011Lu2.i());
        ((C5589Jz2) r8()).h.setTypeface(C6011Lu2.k());
        ((C5589Jz2) r8()).c.setTextTypeFace(C6011Lu2.k());
        ((C5589Jz2) r8()).d.setTextTypeFace(C6011Lu2.k());
        ((C5589Jz2) r8()).v.setTextTypeFace(C6011Lu2.k());
        ((C5589Jz2) r8()).G.setTextTypeFace(C6011Lu2.k());
        ((C5589Jz2) r8()).z.setTextTypeFace(C6011Lu2.k());
        ((C5589Jz2) r8()).y.setTypeface(C6011Lu2.i());
    }

    private final void Z8(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.NR7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.N.a9(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a9(N n, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(n, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            ((C5589Jz2) n.r8()).w.V((int) customInputView.getX(), (int) customInputView.getY());
        }
    }

    private final void b9() {
        ((C5589Jz2) r8()).z.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.IR7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.N.c9(this.a, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c9(N n, View view, boolean z) {
        AbstractC13042fc3.i(n, "this$0");
        if (z) {
            ((C5589Jz2) n.r8()).w.V((int) ((C5589Jz2) n.r8()).B.getX(), (int) ((C5589Jz2) n.r8()).B.getY());
        }
    }

    private final void d9() {
        ((C5589Jz2) r8()).d.setTag(0);
        ((C5589Jz2) r8()).z.setTag(0);
        ((C5589Jz2) r8()).d.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
        ((C5589Jz2) r8()).z.setDrawableEndFirstClickListener(this.pin2InputVisibleClickListener);
    }

    private final void e9() {
        CustomInputView customInputView = ((C5589Jz2) r8()).c;
        CustomInputView customInputView2 = ((C5589Jz2) r8()).c;
        AbstractC13042fc3.h(customInputView2, "confirmCodeInput");
        customInputView.b(new Q45(customInputView2));
        CustomInputView customInputView3 = ((C5589Jz2) r8()).d;
        CustomInputView customInputView4 = ((C5589Jz2) r8()).d;
        AbstractC13042fc3.h(customInputView4, "cvv2Input");
        customInputView3.b(new Q45(customInputView4));
        CustomInputView customInputView5 = ((C5589Jz2) r8()).v;
        CustomInputView customInputView6 = ((C5589Jz2) r8()).v;
        AbstractC13042fc3.h(customInputView6, "monthInput");
        customInputView5.b(new Q45(customInputView6));
        CustomInputView customInputView7 = ((C5589Jz2) r8()).G;
        CustomInputView customInputView8 = ((C5589Jz2) r8()).G;
        AbstractC13042fc3.h(customInputView8, "yearInput");
        customInputView7.b(new Q45(customInputView8));
        CustomInputView customInputView9 = ((C5589Jz2) r8()).z;
        CustomInputView customInputView10 = ((C5589Jz2) r8()).z;
        AbstractC13042fc3.h(customInputView10, "pin2Input");
        customInputView9.b(new Q45(customInputView10));
        ((C5589Jz2) r8()).c.b(new c());
        CustomInputView customInputView11 = ((C5589Jz2) r8()).c;
        AbstractC13042fc3.h(customInputView11, "confirmCodeInput");
        Z8(customInputView11);
        ((C5589Jz2) r8()).d.b(new d());
        CustomInputView customInputView12 = ((C5589Jz2) r8()).d;
        AbstractC13042fc3.h(customInputView12, "cvv2Input");
        Z8(customInputView12);
        ((C5589Jz2) r8()).v.b(new e());
        CustomInputView customInputView13 = ((C5589Jz2) r8()).v;
        AbstractC13042fc3.h(customInputView13, "monthInput");
        Z8(customInputView13);
        ((C5589Jz2) r8()).G.b(new f());
        CustomInputView customInputView14 = ((C5589Jz2) r8()).G;
        AbstractC13042fc3.h(customInputView14, "yearInput");
        Z8(customInputView14);
        ((C5589Jz2) r8()).z.b(new g());
        b9();
    }

    private final void f9() {
        ConstraintLayout root = ((C5589Jz2) r8()).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        u9(new C17468n10(root, null, 0, 6, null));
        S8().k(((C5589Jz2) r8()).x);
        ((C5589Jz2) r8()).l.setSelected(true);
        ((C5589Jz2) r8()).k.setSelected(true);
        ((C5589Jz2) r8()).E.setSelected(true);
        ((C5589Jz2) r8()).b.setSelected(true);
        ((C5589Jz2) r8()).p.setSelected(true);
        v9();
        Y8();
        d9();
        e9();
        V8();
        X8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g9(N n, View view) {
        AbstractC13042fc3.i(n, "this$0");
        if (AbstractC13042fc3.d(((C5589Jz2) n.r8()).z.getTag(), 0)) {
            ((C5589Jz2) n.r8()).z.M(true);
            ((C5589Jz2) n.r8()).z.setTag(1);
            ((C5589Jz2) n.r8()).z.setDrawableEndFirst(AbstractC4043Dl1.f(n.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            ((C5589Jz2) n.r8()).z.M(false);
            ((C5589Jz2) n.r8()).z.setTag(0);
            ((C5589Jz2) n.r8()).z.setDrawableEndFirst(AbstractC4043Dl1.f(n.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void h9() {
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();
            smsBroadcastReceiver.b(new h());
            this.smsBroadcastReceiver = smsBroadcastReceiver;
            Q7().registerReceiver(this.smsBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i9() {
        if (((C5589Jz2) r8()).d.getText().length() > 0) {
            q9();
        } else {
            ((C5589Jz2) r8()).d.requestFocus();
        }
    }

    private final void j9() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (!C4100Dr4.a(contextS7)) {
            C17468n10 c17468n10S8 = S8();
            String strH6 = h6(AbstractC12217eE5.do_not_access);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10S8.o(strH6);
            return;
        }
        SR7 sr7 = this.viewModel;
        SR7 sr72 = null;
        if (sr7 == null) {
            AbstractC13042fc3.y("viewModel");
            sr7 = null;
        }
        if (!(sr7.Y0().getValue() instanceof SR7.a.C0620a)) {
            C17468n10 c17468n10S82 = S8();
            String strH62 = h6(AbstractC12217eE5.otp_request_interval_error);
            AbstractC13042fc3.h(strH62, "getString(...)");
            c17468n10S82.o(strH62);
            return;
        }
        try {
            SR7 sr73 = this.viewModel;
            if (sr73 == null) {
                AbstractC13042fc3.y("viewModel");
                sr73 = null;
            }
            sr73.g1(new UA2() { // from class: ir.nasim.JR7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.N.k9((SR7.a) obj);
                }
            });
            SR7 sr74 = this.viewModel;
            if (sr74 == null) {
                AbstractC13042fc3.y("viewModel");
                sr74 = null;
            }
            String strI = R8().i();
            String strB = GY6.b(AbstractC20153rZ6.M(R8().f(), Separators.SP, "", false, 4, null));
            Long lA = R8().a();
            AbstractC13042fc3.f(lA);
            sr74.w0(strI, strB, (int) lA.longValue(), R8().b()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.KR7
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.payment.view.fragment.N.l9(this.a, (Misc$ResponseVoid) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.LR7
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.payment.view.fragment.N.n9(this.a, (Exception) obj);
                }
            });
        } catch (Exception e2) {
            SR7 sr75 = this.viewModel;
            if (sr75 == null) {
                AbstractC13042fc3.y("viewModel");
            } else {
                sr72 = sr75;
            }
            sr72.g1(new UA2() { // from class: ir.nasim.MR7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.N.p9((SR7.a) obj);
                }
            });
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SR7.a k9(SR7.a aVar) {
        AbstractC13042fc3.i(aVar, "it");
        return SR7.a.b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l9(N n, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(n, "this$0");
        n.w9();
        n.h9();
        SR7 sr7 = n.viewModel;
        BankCreditCard bankCreditCard = null;
        if (sr7 == null) {
            AbstractC13042fc3.y("viewModel");
            sr7 = null;
        }
        sr7.g1(new UA2() { // from class: ir.nasim.BR7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.N.m9((SR7.a) obj);
            }
        });
        SR7 sr72 = n.viewModel;
        if (sr72 == null) {
            AbstractC13042fc3.y("viewModel");
            sr72 = null;
        }
        BankCreditCard bankCreditCard2 = n.sourceCreditCard;
        if (bankCreditCard2 == null) {
            AbstractC13042fc3.y("sourceCreditCard");
        } else {
            bankCreditCard = bankCreditCard2;
        }
        sr72.b1(bankCreditCard.getNumber());
        C3343Am.g("c2c_otp_successful");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SR7.a m9(SR7.a aVar) {
        AbstractC13042fc3.i(aVar, "it");
        return new SR7.a.c(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n9(N n, final Exception exc) {
        AbstractC13042fc3.i(n, "this$0");
        if (exc instanceof DuplicateTransactionException) {
            SR7 sr7 = n.viewModel;
            if (sr7 == null) {
                AbstractC13042fc3.y("viewModel");
                sr7 = null;
            }
            sr7.g1(new UA2() { // from class: ir.nasim.CR7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.N.o9(exc, (SR7.a) obj);
                }
            });
        } else {
            C17468n10 c17468n10S8 = n.S8();
            String strH6 = n.h6(AbstractC12217eE5.system_is_unstable);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10S8.o(strH6);
        }
        C3343Am.g("c2c_otp_failure");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SR7.a o9(Exception exc, SR7.a aVar) {
        AbstractC13042fc3.i(aVar, "<unused var>");
        return new SR7.a.c(((DuplicateTransactionException) exc).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SR7.a p9(SR7.a aVar) {
        AbstractC13042fc3.i(aVar, "it");
        return SR7.a.C0620a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q9() {
        if (((C5589Jz2) r8()).v.getText().length() > 0) {
            s9();
        } else {
            ((C5589Jz2) r8()).v.requestFocus();
        }
    }

    private final void r9() {
        ((C5589Jz2) r8()).z.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s9() {
        if (((C5589Jz2) r8()).G.getText().length() > 0) {
            r9();
        } else {
            ((C5589Jz2) r8()).G.requestFocus();
        }
    }

    private final void v9() {
        try {
            ((C5589Jz2) r8()).l.setText(R8().c());
            TextView textView = ((C5589Jz2) r8()).k;
            ir.nasim.core.modules.banking.l lVarE = R8().e();
            AbstractC13042fc3.f(lVarE);
            textView.setText(lVarE.c());
            ImageView imageView = ((C5589Jz2) r8()).i;
            Context contextS7 = S7();
            Bank bank = this.destBank;
            if (bank == null) {
                AbstractC13042fc3.y("destBank");
                bank = null;
            }
            Integer drawableId = bank.getDrawableId();
            AbstractC13042fc3.f(drawableId);
            imageView.setImageDrawable(AbstractC4043Dl1.f(contextS7, drawableId.intValue()));
            TextView textView2 = ((C5589Jz2) r8()).E;
            ir.nasim.core.modules.banking.l lVarH = R8().h();
            AbstractC13042fc3.f(lVarH);
            textView2.setText(lVarH.c());
            ((C5589Jz2) r8()).b.setText(i6(AbstractC12217eE5.card_payment_rial_param, XY6.e(GY6.g(String.valueOf(R8().a())))));
            ImageView imageView2 = ((C5589Jz2) r8()).C;
            Context contextS72 = S7();
            BankCreditCard bankCreditCard = this.sourceCreditCard;
            if (bankCreditCard == null) {
                AbstractC13042fc3.y("sourceCreditCard");
                bankCreditCard = null;
            }
            Bank bank2 = bankCreditCard.getBank();
            Integer drawableId2 = bank2 != null ? bank2.getDrawableId() : null;
            AbstractC13042fc3.f(drawableId2);
            imageView2.setImageDrawable(AbstractC4043Dl1.f(contextS72, drawableId2.intValue()));
            if (R8().l()) {
                ((C5589Jz2) r8()).g.setText(h6(AbstractC12217eE5.card_payment_verify_code_sended));
                return;
            }
            ((C5589Jz2) r8()).g.setVisibility(8);
            ((C5589Jz2) r8()).f.setVisibility(8);
            ((C5589Jz2) r8()).c.setVisibility(8);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            F5().m1();
        }
    }

    private final void w9() {
        try {
            Task taskA = SF6.a(Q7()).A(null);
            final UA2 ua2 = new UA2() { // from class: ir.nasim.DR7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.N.x9((Void) obj);
                }
            };
            taskA.f(new InterfaceC13497gK4() { // from class: ir.nasim.ER7
                @Override // ir.nasim.InterfaceC13497gK4
                public final void onSuccess(Object obj) {
                    ir.nasim.features.payment.view.fragment.N.y9(ua2, obj);
                }
            }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.FR7
                @Override // ir.nasim.InterfaceC14681iJ4
                public final void a(Exception exc) {
                    ir.nasim.features.payment.view.fragment.N.z9(exc);
                }
            });
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x9(Void r0) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y9(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(Exception exc) {
        AbstractC13042fc3.i(exc, "it");
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1 && data != null) {
            String stringExtra = data.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            String strA = stringExtra != null ? SmsBroadcastReceiver.INSTANCE.a(stringExtra) : null;
            if (strA != null) {
                ((C5589Jz2) r8()).z.setText(strA);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = B.b.values()[bundleE5.getInt("type_param")];
            if (bundleE5.getByteArray("message_param") != null) {
                this.message = J44.v.a(bundleE5.getByteArray("message_param"));
            }
            if (bundleE5.getLong("peer_unique_id_param", -1L) != -1) {
                this.peerUniqueId = Long.valueOf(bundleE5.getLong("peer_unique_id_param"));
            }
            Parcelable parcelable = bundleE5.getParcelable("dest_logo_param");
            AbstractC13042fc3.f(parcelable);
            this.destBank = (Bank) parcelable;
            Parcelable parcelable2 = bundleE5.getParcelable("src_source_card_param");
            AbstractC13042fc3.f(parcelable2);
            this.sourceCreditCard = (BankCreditCard) parcelable2;
            String string = bundleE5.getString("desc_param");
            AbstractC13042fc3.f(string);
            this.desc = string;
            this.isSavedDestination = bundleE5.getBoolean("saved_dest_param");
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        this.viewModel = (SR7) new androidx.lifecycle.G(fragmentActivityQ7).b(SR7.class);
    }

    @Override // ir.nasim.AbstractC5830La0, androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        CountDownTimer countDownTimer = this.otpTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.verifyTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    public final C23076wJ1 R8() {
        C23076wJ1 c23076wJ1 = this.response;
        if (c23076wJ1 != null) {
            return c23076wJ1;
        }
        AbstractC13042fc3.y("response");
        return null;
    }

    public final C17468n10 S8() {
        C17468n10 c17468n10 = this.snackBar;
        if (c17468n10 != null) {
            return c17468n10;
        }
        AbstractC13042fc3.y("snackBar");
        return null;
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: T8, reason: merged with bridge method [inline-methods] */
    public C5589Jz2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C5589Jz2 c5589Jz2C = C5589Jz2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c5589Jz2C, "inflate(...)");
        return c5589Jz2C;
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
        f9();
        W8();
        U8();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View p0) {
        if (AbstractC13042fc3.d(p0, ((C5589Jz2) r8()).o)) {
            j9();
            return;
        }
        if (AbstractC13042fc3.d(p0, ((C5589Jz2) r8()).x)) {
            E9();
        } else if (AbstractC13042fc3.d(p0, ((C5589Jz2) r8()).p)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AbstractC21375tZ.c(contextS7, this, null, C4178Ea1.a.c(), 4, null).show();
        }
    }

    public final void t9(C23076wJ1 c23076wJ1) {
        AbstractC13042fc3.i(c23076wJ1, "<set-?>");
        this.response = c23076wJ1;
    }

    public final void u9(C17468n10 c17468n10) {
        AbstractC13042fc3.i(c17468n10, "<set-?>");
        this.snackBar = c17468n10;
    }
}
