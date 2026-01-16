package ir.nasim.auth.smsretriever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.N76;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lir/nasim/auth/smsretriever/SMSRetrieverBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class SMSRetrieverBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static N76 b;

    /* renamed from: ir.nasim.auth.smsretriever.SMSRetrieverBroadcastReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void a(N76 n76) {
            SMSRetrieverBroadcastReceiver.b = n76;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Status status;
        N76 n76;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (AbstractC13042fc3.d("com.google.android.gms.auth.api.phone.SMS_RETRIEVED", intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
                status = (Status) obj;
            } else {
                status = null;
            }
            if (status != null) {
                int iS = status.S();
                if (iS != 0) {
                    if (iS == 15 && (n76 = b) != null) {
                        n76.a("Failed to extract from Broadcast Receiver");
                        return;
                    }
                    return;
                }
                String string = extras != null ? extras.getString("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE") : null;
                N76 n762 = b;
                if (n762 != null) {
                    n762.b(string);
                }
            }
        }
    }
}
