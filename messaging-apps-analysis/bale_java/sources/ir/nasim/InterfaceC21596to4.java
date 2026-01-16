package ir.nasim;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.designsystem.RamzRialMoreOptionsBottomsheetContentView;
import ir.nasim.designsystem.WalletMoreOptionsBottomsheetContentView;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.bank.MoneyTransferPayTypeBottomSheetContentView;
import ir.nasim.features.bank.wallet.WalletChargeBottomsheetContentView;
import ir.nasim.features.bank.wallet.WalletPayBottomsheetContentView;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: ir.nasim.to4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC21596to4 {

    /* renamed from: ir.nasim.to4$a */
    class a extends HashMap {
        a() {
            put("back_stage", 0);
        }
    }

    /* renamed from: ir.nasim.to4$b */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ C19938rB7 H3(b bVar) {
        bVar.a();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void W2(C11458d25 c11458d25, C14505i18 c14505i18) {
        if (c11458d25 != null) {
            K1(c11458d25);
            C18987pb3.a.r1(c11458d25);
            i4(c11458d25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ C19938rB7 Y3(b bVar) {
        bVar.a();
        return C19938rB7.a;
    }

    private default void i4(C11458d25 c11458d25) {
        if (c11458d25.getPeerId() == 270066638) {
            C3343Am.i("sapta_page", new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void t4(ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.a.r1(c11458d25);
            progressDialog.dismiss();
        }
    }

    default void G0(Context context, C11458d25 c11458d25) {
        CardPaymentActivity.INSTANCE.i(context, c11458d25.u());
        C3343Am.g("c2c_open_from_money_transfer");
    }

    default void K0(Context context, C14486i0 c14486i0, String str, J44 j44, C11458d25 c11458d25) {
        WalletPayBottomsheetContentView walletPayBottomsheetContentView = new WalletPayBottomsheetContentView(context);
        walletPayBottomsheetContentView.setAbolInstance(c14486i0);
        walletPayBottomsheetContentView.setWalletId(str);
        if (c14486i0.j()) {
            c14486i0.h(walletPayBottomsheetContentView, false);
        } else {
            c14486i0.o(walletPayBottomsheetContentView);
        }
        walletPayBottomsheetContentView.W(j44, c11458d25);
    }

    default void K1(C11458d25 c11458d25) {
        if (c11458d25.getPeerId() == 41) {
            C17213mb2.j("my_bank_charge");
        }
    }

    default void P1(Context context, FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            CardPaymentActivity.INSTANCE.m(context);
        }
    }

    default void Q2(Context context, C14486i0 c14486i0, String str, Long l, J44 j44, C11458d25 c11458d25) {
        WalletPayBottomsheetContentView walletPayBottomsheetContentView = new WalletPayBottomsheetContentView(context);
        walletPayBottomsheetContentView.setAbolInstance(c14486i0);
        walletPayBottomsheetContentView.setWalletId(str);
        walletPayBottomsheetContentView.setAmount(l);
        c14486i0.h(walletPayBottomsheetContentView, false);
        walletPayBottomsheetContentView.Q(j44, c11458d25);
    }

    default void Y(Context context, Uri uri, Boolean bool) {
        if (bool.booleanValue()) {
            AbstractC7426Rr.O(context, uri);
        } else {
            AbstractC7426Rr.N(context, uri);
        }
    }

    default void d2(BaseActivity baseActivity, C22186uo4 c22186uo4) {
        if (baseActivity != null) {
            C14486i0 c14486i0F = C14486i0.f(baseActivity);
            RamzRialMoreOptionsBottomsheetContentView ramzRialMoreOptionsBottomsheetContentView = new RamzRialMoreOptionsBottomsheetContentView(baseActivity, c22186uo4);
            ramzRialMoreOptionsBottomsheetContentView.setAbolInstance(c14486i0F);
            c14486i0F.o(ramzRialMoreOptionsBottomsheetContentView);
        }
    }

    default void e4(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            C19406qI3.j("MyBankHandlers", "Activity is NULL!", new Object[0]);
            return;
        }
        C17213mb2.j("my_bank_card_to_card");
        CardPaymentActivity.INSTANCE.g(fragmentActivity);
        C3343Am.g("c2c_open_from_my_bank");
    }

    default void f0(Context context, BaseActivity baseActivity, String str) {
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        if (!C4100Dr4.a(context)) {
            Toast.makeText(context, AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
        } else {
            C14486i0 c14486i0F = C14486i0.f(baseActivity);
            c14486i0F.o(new BottomSheetWebView(context, baseActivity, str, c14486i0F, null));
        }
    }

    default void f2(Context context, FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            CardPaymentActivity.INSTANCE.d(context);
        } else {
            C19406qI3.j("MyBankHandlers", "Parent activity is NULL!", new Object[0]);
        }
    }

    default void g0(long j, Context context) {
        final ProgressDialog progressDialogE = C8920Xu5.e(context, false);
        progressDialogE.show();
        try {
            AbstractC5969Lp4.b().k(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.oo4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    InterfaceC21596to4.t4(progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.po4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    progressDialogE.dismiss();
                }
            });
        } catch (Exception e) {
            C19406qI3.d("MyBankHandlers", e);
            progressDialogE.dismiss();
        }
    }

    default void k0(Context context) {
        CardPaymentActivity.INSTANCE.d(context);
    }

    default void k2(Context context, FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            C14486i0 c14486i0F = C14486i0.f(fragmentActivity);
            WalletChargeBottomsheetContentView walletChargeBottomsheetContentView = new WalletChargeBottomsheetContentView(context);
            walletChargeBottomsheetContentView.setAbolInstance(c14486i0F);
            c14486i0F.o(walletChargeBottomsheetContentView);
        }
    }

    default void m4() {
        try {
            C18987pb3.L1(EnumC14097hL4.a);
        } catch (Exception e) {
            C19406qI3.d("MyBankHandlers", e);
        }
    }

    default void o5(C11458d25 c11458d25, Long l, Long l2) {
        try {
            C18987pb3.a.s1(c11458d25, l, l2);
        } catch (Exception e) {
            C19406qI3.d("MyBankHandlers", e);
        }
    }

    default void r3(Context context, C14486i0 c14486i0, final b bVar, final b bVar2) {
        MoneyTransferPayTypeBottomSheetContentView moneyTransferPayTypeBottomSheetContentView = new MoneyTransferPayTypeBottomSheetContentView(context);
        moneyTransferPayTypeBottomSheetContentView.setAbolInstance(c14486i0);
        moneyTransferPayTypeBottomSheetContentView.setCardButtonClickListener(new SA2() { // from class: ir.nasim.ro4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return InterfaceC21596to4.H3(bVar);
            }
        });
        moneyTransferPayTypeBottomSheetContentView.setWalletButtonClickListener(new SA2() { // from class: ir.nasim.so4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return InterfaceC21596to4.Y3(bVar2);
            }
        });
        c14486i0.o(moneyTransferPayTypeBottomSheetContentView);
    }

    default void s4(final C11458d25 c11458d25) {
        try {
            if (AbstractC5969Lp4.g() == null || AbstractC5969Lp4.g().n(c11458d25.getPeerId()) == null) {
                AbstractC5969Lp4.d().Y().V().t0(Arrays.asList(new C18766pD(c11458d25.getPeerId(), 0L)), new ArrayList(), true).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qo4
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        this.a.W2(c11458d25, (C14505i18) obj);
                    }
                });
            } else {
                K1(c11458d25);
                C18987pb3.a.r1(c11458d25);
                i4(c11458d25);
            }
        } catch (Exception e) {
            C19406qI3.d("MyBankHandlers", e);
        }
    }

    default void w1(Context context, BaseActivity baseActivity, WalletMoreOptionsBottomsheetContentView.a aVar) {
        if (baseActivity != null) {
            C14486i0 c14486i0F = C14486i0.f(baseActivity);
            WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView = new WalletMoreOptionsBottomsheetContentView(context, baseActivity);
            walletMoreOptionsBottomsheetContentView.setAbolInstance(c14486i0F);
            walletMoreOptionsBottomsheetContentView.setCallback(aVar);
            c14486i0F.o(walletMoreOptionsBottomsheetContentView);
        }
    }
}
