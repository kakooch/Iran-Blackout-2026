package ir.nasim.features.firebase.newPush.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.C11458d25;
import ir.nasim.C19406qI3;
import ir.nasim.C5735Kp4;
import ir.nasim.GE4;
import ir.nasim.features.firebase.newPush.receiver.ReadActionReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lir/nasim/features/firebase/newPush/receiver/ReadActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "", "peerId", "Lir/nasim/rB7;", "d", "(J)V", "Landroid/content/Context;", "context", "Lir/nasim/d25;", "peer", "c", "(Landroid/content/Context;Lir/nasim/d25;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ReadActionReceiver extends BroadcastReceiver {
    private final void c(Context context, C11458d25 peer) {
        Object systemService = context.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        GE4.e((NotificationManager) systemService, peer.getPeerId(), null, 2, null);
    }

    private final void d(final long peerId) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.tI5
            @Override // java.lang.Runnable
            public final void run() {
                ReadActionReceiver.e(peerId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j, ReadActionReceiver readActionReceiver) {
        String name;
        AbstractC13042fc3.i(readActionReceiver, "this$0");
        try {
            C5735Kp4.w().D();
            C5735Kp4.w().i().b1(C11458d25.r(j), true);
        } catch (Exception e) {
            if (readActionReceiver.getClass().isAnonymousClass()) {
                name = ReadActionReceiver.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = ReadActionReceiver.class.getSimpleName();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Intent intent, ReadActionReceiver readActionReceiver, Context context) {
        AbstractC13042fc3.i(intent, "$intent");
        AbstractC13042fc3.i(readActionReceiver, "this$0");
        AbstractC13042fc3.i(context, "$context");
        long longExtra = intent.getLongExtra("PEER_ID", 0L);
        C11458d25 c11458d25R = C11458d25.r(longExtra);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        readActionReceiver.c(context, c11458d25R);
        readActionReceiver.d(longExtra);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.sI5
            @Override // java.lang.Runnable
            public final void run() {
                ReadActionReceiver.f(intent, this, context);
            }
        });
    }
}
