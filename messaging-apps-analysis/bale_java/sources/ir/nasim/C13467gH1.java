package ir.nasim;

import ai.bale.proto.KifpoolOuterClass$ResponseGetMyKifpools;
import ai.bale.proto.KifpoolStruct$Kifpool;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C13467gH1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006="}, d2 = {"Lir/nasim/gH1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "na", "", "rialValue", "qa", "(J)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "ea", "(Ljava/lang/Exception;)Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "Landroid/widget/LinearLayout;", "h1", "Landroid/widget/LinearLayout;", "rootLayout", "Landroid/widget/Button;", "i1", "Landroid/widget/Button;", "deleteAccountButton", "j1", "sendCodeButton", "Landroid/widget/EditText;", "k1", "Landroid/widget/EditText;", "editText", "l1", "Ljava/lang/String;", "transactionHash", "Landroid/os/CountDownTimer;", "m1", "Landroid/os/CountDownTimer;", "countDownTimer", "", "n1", TokenNames.I, "disableColor", "Lir/nasim/RB6;", "o1", "Lir/nasim/RB6;", "fa", "()Lir/nasim/RB6;", "setSignOutUseCase", "(Lir/nasim/RB6;)V", "signOutUseCase", "p1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.gH1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13467gH1 extends AbstractC20731sW2 {

    /* renamed from: p1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;
    private static final String r1 = "last_delete_account_attempt_key";
    private static final String s1 = "delete_transaction_hash";
    private static final int t1 = 5;

    /* renamed from: h1, reason: from kotlin metadata */
    private LinearLayout rootLayout;

    /* renamed from: i1, reason: from kotlin metadata */
    private Button deleteAccountButton;

    /* renamed from: j1, reason: from kotlin metadata */
    private Button sendCodeButton;

    /* renamed from: k1, reason: from kotlin metadata */
    private EditText editText;

    /* renamed from: l1, reason: from kotlin metadata */
    private String transactionHash;

    /* renamed from: m1, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: n1, reason: from kotlin metadata */
    private final int disableColor;

    /* renamed from: o1, reason: from kotlin metadata */
    public RB6 signOutUseCase;

    /* renamed from: ir.nasim.gH1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13467gH1 a() {
            return new C13467gH1();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gH1$b */
    public static final class b implements TextWatcher {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ C13467gH1 b;

        b(boolean[] zArr, C13467gH1 c13467gH1) {
            this.a = zArr;
            this.b = c13467gH1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 5) {
                if (this.a[0]) {
                    Button button = this.b.deleteAccountButton;
                    if (button != null) {
                        button.setTextColor(this.b.disableColor);
                    }
                    Button button2 = this.b.deleteAccountButton;
                    if (button2 != null) {
                        button2.setEnabled(false);
                    }
                    this.a[0] = false;
                    return;
                }
                return;
            }
            if (this.a[0]) {
                return;
            }
            Button button3 = this.b.deleteAccountButton;
            if (button3 != null) {
                button3.setTextColor(C5495Jo7.a.f0());
            }
            Button button4 = this.b.deleteAccountButton;
            if (button4 != null) {
                button4.setEnabled(true);
            }
            this.a[0] = true;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }
    }

    /* renamed from: ir.nasim.gH1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13467gH1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RB6 rb6Fa = C13467gH1.this.fa();
                this.b = 1;
                if (rb6Fa.a(this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gH1$d */
    public static final class d extends CountDownTimer {
        d() {
            super(120000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Button button = C13467gH1.this.sendCodeButton;
            if (button != null) {
                button.setEnabled(true);
            }
            Button button2 = C13467gH1.this.sendCodeButton;
            if (button2 != null) {
                button2.setText(AbstractC12217eE5.deleteAccount_sendActivationCodeAgain_button);
            }
            Button button3 = C13467gH1.this.sendCodeButton;
            if (button3 != null) {
                button3.setBackground(AbstractC4310Eo7.i(C5495Jo7.a.B0(), -1711276033));
            }
            Button button4 = C13467gH1.this.sendCodeButton;
            if (button4 != null) {
                button4.setTextColor(C5495Jo7.a.f0());
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String strE;
            int i = (int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            if (i >= 60) {
                int i2 = i - 60;
                if (i2 < 10) {
                    if (JF5.g()) {
                        strE = XY6.e("1:0" + i2);
                    } else {
                        strE = "1:0" + i2;
                    }
                } else if (JF5.g()) {
                    strE = XY6.e("1:" + i2);
                } else {
                    strE = "1:" + i2;
                }
            } else if (i < 10) {
                if (JF5.g()) {
                    strE = XY6.e("0:0" + i);
                } else {
                    strE = "0:0" + i;
                }
            } else if (JF5.g()) {
                strE = XY6.e("0:" + i);
            } else {
                strE = "0:" + i;
            }
            Button button = C13467gH1.this.sendCodeButton;
            AbstractC13042fc3.f(button);
            button.setText(strE);
        }
    }

    /* renamed from: ir.nasim.gH1$e */
    public static final class e implements InputFilter {
        private final String a = "1234567890";

        e() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AbstractC13042fc3.i(charSequence, "source");
            AbstractC13042fc3.i(spanned, "dest");
            String strH = XY6.h(charSequence.toString());
            StringBuilder sb = new StringBuilder();
            for (int i5 = i; i5 < i2; i5++) {
                char cCharAt = strH.charAt(i5);
                char cCharAt2 = charSequence.charAt(i5);
                if (AbstractC20762sZ6.k0(this.a, cCharAt, 0, false, 6, null) != -1) {
                    sb.append(cCharAt2);
                }
            }
            if (sb.length() == i2 - i) {
                return null;
            }
            return sb.toString();
        }
    }

    /* renamed from: ir.nasim.gH1$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ long b;

        /* renamed from: ir.nasim.gH1$f$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ long a;

            a(long j) {
                this.a = j;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.d(AbstractC12217eE5.wallet_amount_not_empty_delete_account_desc, new Object[]{((long) Math.rint(((double) this.a) / 10000.0d)) <= 1 ? "" : AbstractC12152e76.b(String.valueOf((long) Math.rint(this.a / 10000.0d)))}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f(long j) {
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C13467gH1 c13467gH1, Dialog dialog) {
            AbstractC13042fc3.i(c13467gH1, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            C22042ua0.m9(c13467gH1, c13467gH1, false, 2, null);
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2A = C16317l41.a.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(902600072, true, new a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-516418821);
            boolean zD = interfaceC22053ub1.D(C13467gH1.this) | interfaceC22053ub1.D(dialog);
            final C13467gH1 c13467gH1 = C13467gH1.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.hH1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13467gH1.f.d(c13467gH1, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(AbstractC12217eE5.Done, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-516410318);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.iH1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13467gH1.f.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.Cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public C13467gH1() {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.disableColor = c5495Jo7.y0(c5495Jo7.f0(), 60);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String ea(java.lang.Exception r3) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13467gH1.ea(java.lang.Exception):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final C13467gH1 c13467gH1, View view) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        C6517Nv5 c6517Nv5E = AbstractC5969Lp4.d().o2().y().G1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.ZG1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.ha(this.a, (KifpoolOuterClass$ResponseGetMyKifpools) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.aH1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.ia(this.a, (Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        c13467gH1.T8(c6517Nv5E, AbstractC12217eE5.progress_common);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(C13467gH1 c13467gH1, KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        List<KifpoolStruct$Kifpool> myWalletsList = kifpoolOuterClass$ResponseGetMyKifpools.getMyWalletsList();
        AbstractC13042fc3.f(myWalletsList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : myWalletsList) {
            if (!((KifpoolStruct$Kifpool) obj).getIsMerchant()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        long balance = 0;
        for (int i = 0; i < size; i++) {
            KifpoolStruct$Kifpool kifpoolStruct$Kifpool = (KifpoolStruct$Kifpool) arrayList.get(i);
            if (kifpoolStruct$Kifpool.getBalance() > balance) {
                balance = kifpoolStruct$Kifpool.getBalance();
            }
        }
        if (AbstractC5969Lp4.d().o2().S().U3() < balance) {
            c13467gH1.qa(balance);
        } else {
            c13467gH1.na();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(C13467gH1 c13467gH1, Exception exc) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        c13467gH1.na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(final C13467gH1 c13467gH1, View view) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        FragmentActivity fragmentActivityQ7 = c13467gH1.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        AlertDialog alertDialogA = new AlertDialog.a(fragmentActivityQ7).i(c13467gH1.h6(AbstractC12217eE5.deleteAccount_dialog_message)).j(c13467gH1.h6(AbstractC12217eE5.dialog_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.bH1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C13467gH1.ka(this.a, dialogInterface, i);
            }
        }).l(c13467gH1.h6(AbstractC12217eE5.dialog_no), null).a();
        c13467gH1.q9(alertDialogA);
        alertDialogA.setCanceledOnTouchOutside(true);
        alertDialogA.R(C5495Jo7.a.B0(), -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(final C13467gH1 c13467gH1, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        if (TextUtils.isEmpty(c13467gH1.transactionHash)) {
            Context contextS7 = c13467gH1.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            String strH6 = c13467gH1.h6(AbstractC12217eE5.toast_unable_delete_account);
            AbstractC13042fc3.h(strH6, "getString(...)");
            C24398yZ.h(contextS7, c13467gH1, "", strH6);
            C19406qI3.b("DeleteAccountFragment", "transaction hash is NULL!");
            return;
        }
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        EditText editText = c13467gH1.editText;
        AbstractC13042fc3.f(editText);
        String strH = XY6.h(editText.getText().toString());
        String str = c13467gH1.transactionHash;
        AbstractC13042fc3.f(str);
        C6517Nv5 c6517Nv5M0 = c11335cqD.x(strH, str).E(new InterfaceC24449ye1() { // from class: ir.nasim.cH1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.la(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dH1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.ma(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        c13467gH1.T8(c6517Nv5M0, AbstractC12217eE5.progress_common);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(C13467gH1 c13467gH1, Exception exc) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        AbstractC13042fc3.i(exc, "e");
        Context contextS7 = c13467gH1.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        C24398yZ.h(contextS7, c13467gH1, "", c13467gH1.ea(exc));
        C19406qI3.d("DeleteAccountFragment", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(C13467gH1 c13467gH1, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        AbstractC10533bm0.d(AbstractC19224pz3.a(c13467gH1), null, null, c13467gH1.new c(null), 3, null);
    }

    private final void na() {
        C6517Nv5 c6517Nv5M0 = AbstractC5969Lp4.d().m1().E(new InterfaceC24449ye1() { // from class: ir.nasim.eH1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.oa(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.fH1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13467gH1.pa(this.a, (String) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        T8(c6517Nv5M0, AbstractC12217eE5.progress_common);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(C13467gH1 c13467gH1, Exception exc) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        int i = AbstractC13042fc3.d(exc != null ? exc.getMessage() : null, "Invalid phone number.") ? AbstractC12217eE5.toast_unable_send_delete_account_invalid_phone : AbstractC12217eE5.toast_unable_send_delete_account_activation_code;
        Context contextS7 = c13467gH1.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        String strH6 = c13467gH1.h6(i);
        AbstractC13042fc3.h(strH6, "getString(...)");
        C24398yZ.h(contextS7, c13467gH1, "", strH6);
        C19406qI3.d("DeleteAccountFragment", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(C13467gH1 c13467gH1, String str) {
        AbstractC13042fc3.i(c13467gH1, "this$0");
        AbstractC13042fc3.i(str, "res");
        c13467gH1.transactionHash = str;
        AbstractC5969Lp4.d().d0().putString(s1, c13467gH1.transactionHash);
        AbstractC5969Lp4.d().d0().putLong(r1, System.currentTimeMillis());
        Button button = c13467gH1.deleteAccountButton;
        if (button != null) {
            button.setVisibility(0);
        }
        EditText editText = c13467gH1.editText;
        if (editText != null) {
            editText.setVisibility(0);
        }
        CountDownTimer countDownTimer = c13467gH1.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        Button button2 = c13467gH1.sendCodeButton;
        if (button2 != null) {
            button2.setEnabled(false);
        }
        Button button3 = c13467gH1.sendCodeButton;
        if (button3 != null) {
            button3.setBackgroundDrawable(null);
        }
        Button button4 = c13467gH1.sendCodeButton;
        if (button4 != null) {
            button4.setTextColor(C5495Jo7.a.B0());
        }
    }

    private final void qa(long rialValue) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1411365798, true, new f(rialValue)), 4, null).show();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EditText editText;
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(G5());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackgroundColor(c5495Jo7.n());
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -1));
        this.rootLayout = linearLayout;
        BaleToolbar.Companion companion = BaleToolbar.INSTANCE;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        String strH6 = h6(AbstractC12217eE5.deleteAccount_header);
        AbstractC13042fc3.h(strH6, "getString(...)");
        BaleToolbar baleToolbarD = BaleToolbar.Companion.d(companion, fragmentActivityQ7, strH6, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AppBarLayout appBarLayoutA = companion.a(contextS7);
        appBarLayoutA.addView(baleToolbarD);
        LinearLayout linearLayout2 = this.rootLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(appBarLayoutA);
        }
        long j = AbstractC5969Lp4.d().d0().getLong(r1, -1L);
        boolean z = j != -1 && System.currentTimeMillis() - j > 0 && System.currentTimeMillis() - j < 3600000;
        if (z) {
            this.transactionHash = AbstractC5969Lp4.d().d0().e(s1);
        } else {
            this.transactionHash = null;
            AbstractC5969Lp4.d().d0().putString(s1, null);
        }
        TextView textView = new TextView(S7());
        textView.setText(AbstractC12217eE5.deleteAccount_description);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(c5495Jo7.g0());
        textView.setTypeface(C6011Lu2.k());
        textView.setGravity(JF5.g() ? 5 : 3);
        textView.setLayoutParams(C14433hu3.f(-1, -2, 4.0f, 8.0f, 4.0f, 8.0f));
        textView.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f));
        LinearLayout linearLayout3 = this.rootLayout;
        if (linearLayout3 != null) {
            linearLayout3.addView(textView);
        }
        EditText editText2 = new EditText(G5());
        if (!z) {
            editText2.setVisibility(8);
        }
        editText2.setHint(AbstractC12217eE5.deleteAccount_code_hint);
        editText2.setMaxLines(1);
        editText2.setTypeface(C6011Lu2.k());
        editText2.setTextSize(1, 14.0f);
        editText2.setRawInputType(2);
        editText2.setGravity(17);
        this.editText = editText2;
        e eVar = new e();
        EditText editText3 = this.editText;
        if (editText3 != null) {
            editText3.setFilters(new InputFilter[]{eVar, new InputFilter.LengthFilter(t1)});
        }
        EditText editText4 = this.editText;
        if (editText4 != null) {
            editText4.setLayoutParams(C14433hu3.f(-1, -2, 16.0f, 16.0f, 16.0f, 4.0f));
        }
        if (JF5.g() && (editText = this.editText) != null) {
            editText.addTextChangedListener(new C13003fY2(editText));
        }
        boolean[] zArr = {false};
        EditText editText5 = this.editText;
        if (editText5 != null) {
            editText5.addTextChangedListener(new b(zArr, this));
        }
        LinearLayout linearLayout4 = this.rootLayout;
        if (linearLayout4 != null) {
            linearLayout4.addView(this.editText);
        }
        Button button = new Button(S7());
        if (!z) {
            button.setVisibility(8);
        }
        button.setEnabled(false);
        button.setTextColor(this.disableColor);
        button.setBackground(AbstractC4310Eo7.i(c5495Jo7.B0(), -1711276033));
        button.setText(AbstractC12217eE5.deleteAccount_button);
        button.setTextSize(1, 14.0f);
        button.setTypeface(C6011Lu2.i());
        button.setGravity(17);
        button.setPadding(C22078ud6.a(8.0f), 0, C22078ud6.a(8.0f), 0);
        button.setLayoutParams(C14433hu3.i(-2, -2, 1, 8, 8, 8, 8));
        this.deleteAccountButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.XG1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13467gH1.ja(this.a, view);
            }
        });
        LinearLayout linearLayout5 = this.rootLayout;
        if (linearLayout5 != null) {
            linearLayout5.addView(this.deleteAccountButton);
        }
        Button button2 = new Button(Q7());
        if (z) {
            button2.setText(AbstractC12217eE5.deleteAccount_sendActivationCodeAgain_button);
        } else {
            button2.setText(AbstractC12217eE5.deleteAccount_sendActivationCode_button);
        }
        button2.setBackground(AbstractC4310Eo7.i(c5495Jo7.B0(), -1711276033));
        button2.setTextColor(c5495Jo7.f0());
        button2.setTextSize(1, 14.0f);
        button2.setTypeface(C6011Lu2.i());
        button2.setGravity(17);
        button2.setPadding(C22078ud6.a(48.0f), 0, C22078ud6.a(48.0f), 0);
        button2.setLayoutParams(C14433hu3.i(-2, -2, 1, 8, 24, 8, 8));
        this.sendCodeButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.YG1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13467gH1.ga(this.a, view);
            }
        });
        LinearLayout linearLayout6 = this.rootLayout;
        if (linearLayout6 != null) {
            linearLayout6.addView(this.sendCodeButton);
        }
        this.countDownTimer = new d();
        return this.rootLayout;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.rootLayout = null;
    }

    public final RB6 fa() {
        RB6 rb6 = this.signOutUseCase;
        if (rb6 != null) {
            return rb6;
        }
        AbstractC13042fc3.y("signOutUseCase");
        return null;
    }
}
