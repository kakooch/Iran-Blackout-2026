package ir.nasim.features.firebase.newPush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.KV0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lir/nasim/features/firebase/newPush/receiver/CopyActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CopyActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (AbstractC13042fc3.d(intent.getAction(), "ACTION_COPY")) {
            String stringExtra = intent.getStringExtra("KEY_TEXT_TO_COPY");
            if (stringExtra == null) {
                stringExtra = "";
            }
            KV0.a(context, stringExtra);
        }
    }
}
