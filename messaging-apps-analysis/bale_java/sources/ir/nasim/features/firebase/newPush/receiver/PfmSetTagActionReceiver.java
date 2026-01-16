package ir.nasim.features.firebase.newPush.receiver;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18306oR4;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C24614yu6;
import ir.nasim.C3343Am;
import ir.nasim.C5735Kp4;
import ir.nasim.EnumC18897pR4;
import ir.nasim.GE4;
import ir.nasim.InterfaceC7720Sx5;
import ir.nasim.UP4;
import ir.nasim.VP4;
import ir.nasim.features.firebase.newPush.receiver.PfmSetTagActionReceiver;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lir/nasim/features/firebase/newPush/receiver/PfmSetTagActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "", "peerId", "", "notificationTag", "Lir/nasim/rB7;", "d", "(Landroid/content/Context;ILjava/lang/String;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lir/nasim/Sx5;", "Lir/nasim/UP4;", "c", "Lir/nasim/Sx5;", "e", "()Lir/nasim/Sx5;", "setPfmModule", "(Lir/nasim/Sx5;)V", "pfmModule", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class PfmSetTagActionReceiver extends Hilt_PfmSetTagActionReceiver {
    public static final int e = 8;

    /* renamed from: c, reason: from kotlin metadata */
    public InterfaceC7720Sx5 pfmModule;

    private final void d(Context context, int peerId, String notificationTag) {
        Object systemService = context.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        GE4.d((NotificationManager) systemService, peerId, notificationTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Intent intent, final PfmSetTagActionReceiver pfmSetTagActionReceiver, Context context) {
        AbstractC13042fc3.i(intent, "$intent");
        AbstractC13042fc3.i(pfmSetTagActionReceiver, "this$0");
        AbstractC13042fc3.i(context, "$context");
        int intExtra = intent.getIntExtra("PEER_ID", 0);
        Parcelable parcelableExtra = intent.getParcelableExtra("PFM_TAG");
        final PFMTag pFMTag = parcelableExtra instanceof PFMTag ? (PFMTag) parcelableExtra : null;
        Parcelable parcelableExtra2 = intent.getParcelableExtra("PFM_TRANSACTION");
        final PFMTransaction pFMTransaction = parcelableExtra2 instanceof PFMTransaction ? (PFMTransaction) parcelableExtra2 : null;
        if (pFMTransaction == null || pFMTag == null) {
            return;
        }
        pfmSetTagActionReceiver.d(context, intExtra, String.valueOf(pFMTransaction.getDate()));
        C5735Kp4.w().D();
        HashMap map = new HashMap();
        map.put("label_type", pFMTag.getLabel());
        map.put("label_version", Integer.valueOf(pFMTag.getUserId() == 0 ? 1 : 2));
        map.put("action_type", 0);
        map.put("accounting_type", Integer.valueOf(pFMTransaction.getTransactionType() != EnumC18897pR4.c ? 1 : 0));
        VP4 vp4 = VP4.a;
        map.put("notif_row", Integer.valueOf(vp4.j(pFMTag)));
        map.put("notif_coulumn", Integer.valueOf(vp4.i(pFMTag)));
        map.put("is_notif", Boolean.TRUE);
        map.put("amount", Long.valueOf(Long.parseLong(pFMTransaction.getAmount())));
        map.put("transaction_date", Long.valueOf(pFMTransaction.getDate()));
        C3343Am.i("pfm_label_page", map);
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.l75
            @Override // java.lang.Runnable
            public final void run() {
                PfmSetTagActionReceiver.g(this.a, pFMTag, pFMTransaction);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PfmSetTagActionReceiver pfmSetTagActionReceiver, PFMTag pFMTag, PFMTransaction pFMTransaction) {
        AbstractC13042fc3.i(pfmSetTagActionReceiver, "this$0");
        ((UP4) pfmSetTagActionReceiver.e().get()).O(new C24614yu6(AbstractC9766aX0.e(pFMTag), AbstractC18306oR4.a(pFMTransaction)));
    }

    public final InterfaceC7720Sx5 e() {
        InterfaceC7720Sx5 interfaceC7720Sx5 = this.pfmModule;
        if (interfaceC7720Sx5 != null) {
            return interfaceC7720Sx5;
        }
        AbstractC13042fc3.y("pfmModule");
        return null;
    }

    @Override // ir.nasim.features.firebase.newPush.receiver.Hilt_PfmSetTagActionReceiver, android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        super.onReceive(context, intent);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.k75
            @Override // java.lang.Runnable
            public final void run() {
                PfmSetTagActionReceiver.f(intent, this, context);
            }
        });
    }
}
