package ir.nasim.features.firebase.newPush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import com.google.firebase.messaging.RemoteMessage;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C18862pN5;
import ir.nasim.C19406qI3;
import ir.nasim.C21165tD4;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.SA6;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.firebase.BaleFirebaseMessagingService;
import ir.nasim.features.firebase.newPush.receiver.ReplyActionReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lir/nasim/features/firebase/newPush/receiver/ReplyActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "c", "(Landroid/content/Intent;)Ljava/lang/CharSequence;", "Lir/nasim/d25;", "peer", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/rB7;", "d", "(Lir/nasim/d25;Ljava/lang/CharSequence;)V", "f", "Landroid/content/Context;", "context", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ReplyActionReceiver extends BroadcastReceiver {
    private final CharSequence c(Intent intent) {
        Bundle bundleJ = C18862pN5.j(intent);
        if (bundleJ != null) {
            return bundleJ.getCharSequence("key_text_reply");
        }
        return null;
    }

    private final void d(C11458d25 peer, CharSequence message) throws NumberFormatException {
        long jF;
        String strValueOf = C5721Ko.a.d().getString(AbstractC12217eE5.my_sender_name) + " : " + ((Object) message);
        if (SA6.a.c()) {
            if (peer.z()) {
                strValueOf = String.valueOf(message);
            }
            jF = AbstractC5969Lp4.f();
        } else {
            jF = 0;
        }
        String str = strValueOf;
        long j = jF;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(jCurrentTimeMillis);
        new BaleFirebaseMessagingService().q(new RemoteMessage(new C21165tD4("", str, j, sb.toString(), null, null, null, TokenNames.MESSAGE, null, peer, 0L, 352, null).g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Intent intent, ReplyActionReceiver replyActionReceiver) throws NumberFormatException {
        AbstractC13042fc3.i(intent, "$intent");
        AbstractC13042fc3.i(replyActionReceiver, "this$0");
        C11458d25 c11458d25R = C11458d25.r(intent.getLongExtra("PEER_UNIQUE_ID", 0L));
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        CharSequence charSequenceC = replyActionReceiver.c(intent);
        replyActionReceiver.f(c11458d25R, charSequenceC);
        replyActionReceiver.d(c11458d25R, charSequenceC);
    }

    private final void f(final C11458d25 peer, final CharSequence message) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.RO5
            @Override // java.lang.Runnable
            public final void run() {
                ReplyActionReceiver.g(peer, message, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(C11458d25 c11458d25, CharSequence charSequence, ReplyActionReceiver replyActionReceiver) {
        String name;
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(replyActionReceiver, "this$0");
        try {
            C5735Kp4.w().D();
            C5735Kp4.w().i().D1(c11458d25, String.valueOf(charSequence), null);
            C5735Kp4.w().i().a1();
        } catch (Exception e) {
            if (replyActionReceiver.getClass().isAnonymousClass()) {
                name = ReplyActionReceiver.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = ReplyActionReceiver.class.getSimpleName();
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.QO5
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                ReplyActionReceiver.e(intent, this);
            }
        });
    }
}
