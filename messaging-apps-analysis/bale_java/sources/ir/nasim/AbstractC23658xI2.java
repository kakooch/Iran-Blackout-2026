package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView;

/* renamed from: ir.nasim.xI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23658xI2 implements InterfaceC21596to4 {
    private static String b(Context context, ExPeerType exPeerType, int i, int i2) {
        if (exPeerType == ExPeerType.PRIVATE) {
            i = i2;
        }
        return AbstractC5969Lp4.a(context.getResources().getString(i), exPeerType == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19938rB7 c() {
        C11458d25 c11458d25H = C5735Kp4.w().h();
        if (c11458d25H != null) {
            AbstractC5969Lp4.e().U().F(c11458d25H, EnumC5360Iz7.n);
        }
        return C19938rB7.a;
    }

    public static void d(Context context, Activity activity) {
        e(null, context, activity);
    }

    public static void e(C14486i0 c14486i0, Context context, Activity activity) {
        if (activity instanceof AppCompatActivity) {
            if (c14486i0 == null) {
                c14486i0 = C14486i0.f((AppCompatActivity) activity);
            }
            if (!C4100Dr4.a(context)) {
                Toast.makeText(context, AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            } else {
                c14486i0.o(new BottomSheetWebView(context, (BaseActivity) activity, AbstractC5969Lp4.d().o2().S().a5(), c14486i0, null, new SA2() { // from class: ir.nasim.wI2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23658xI2.c();
                    }
                }));
            }
        }
    }

    public static void f(Context context, Activity activity, C22042ua0 c22042ua0) {
        if (activity instanceof AppCompatActivity) {
            if (C4100Dr4.a(context)) {
                c22042ua0.y9(ir.nasim.features.bank.mybank.webview.a.r1.a(AbstractC5969Lp4.d().o2().S().b5(), true));
            } else {
                Toast.makeText(context, AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            }
        }
    }

    public static void g(Context context, Long l, int i, Long l2, C11458d25 c11458d25, ExPeerType exPeerType, C22472vI2 c22472vI2, String str, C22042ua0 c22042ua0, Boolean bool, Boolean bool2) {
        if (C8386Vt0.O3()) {
            c22042ua0.y9(YK4.INSTANCE.a(l.longValue(), i, l2.longValue(), c11458d25.getPeerId(), exPeerType.getValue(), c22472vI2.v(), c22472vI2.r(), c22472vI2.s().j(), c22472vI2.u().booleanValue(), bool.booleanValue(), bool2.booleanValue(), false, -1L));
            return;
        }
        C14486i0 c14486i0F = C14486i0.f((AppCompatActivity) context);
        NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView = new NewGiftPacketRecyclerResultBottomSheetContentView(context, l.longValue(), i, l2.longValue(), c11458d25, exPeerType, c22472vI2, str, c22042ua0, bool.booleanValue(), bool2.booleanValue());
        newGiftPacketRecyclerResultBottomSheetContentView.setAbolInstance(c14486i0F);
        c14486i0F.o(newGiftPacketRecyclerResultBottomSheetContentView);
    }

    public static void h(Long l, int i, Long l2, C11458d25 c11458d25, ExPeerType exPeerType, BJ2 bj2, C22042ua0 c22042ua0, Boolean bool, Boolean bool2) {
        c22042ua0.y9(YK4.INSTANCE.a(l.longValue(), i, l2.longValue(), c11458d25.getPeerId(), exPeerType.getValue(), bj2.d, bj2.e, bj2.g.j(), true, bool.booleanValue(), bool2.booleanValue(), true, bj2.c));
    }

    public static MY i(Context context, String str) {
        return j(context, str, null);
    }

    public static MY j(Context context, String str, View.OnClickListener onClickListener) {
        MY myA = new NY(context).A(AbstractC12217eE5.gift_dialogs_info).i(str).E(2).k(2).w(AbstractC12217eE5.gift_dialogs_realized_button_title).v(onClickListener).f(true).a();
        myA.z();
        return myA;
    }

    public static MY k(Context context, ExPeerType exPeerType) {
        int i = AbstractC12217eE5.gift_dialogs_chance_info;
        return i(context, b(context, exPeerType, i, i));
    }

    public static MY l(Context context, ExPeerType exPeerType) {
        int i = AbstractC12217eE5.gift_dialogs_timer_info;
        return i(context, b(context, exPeerType, i, i));
    }
}
