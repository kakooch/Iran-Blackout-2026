package ir.nasim.features.call.service;

import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C4627Fy0;
import ir.nasim.C5735Kp4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lir/nasim/features/call/service/CallActionsReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lir/nasim/Fy0;", "c", "Lir/nasim/Fy0;", "b", "()Lir/nasim/Fy0;", "setCallRepository", "(Lir/nasim/Fy0;)V", "callRepository", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CallActionsReceiver extends Hilt_CallActionsReceiver {

    /* renamed from: c, reason: from kotlin metadata */
    public C4627Fy0 callRepository;

    public final C4627Fy0 b() {
        C4627Fy0 c4627Fy0 = this.callRepository;
        if (c4627Fy0 != null) {
            return c4627Fy0;
        }
        AbstractC13042fc3.y("callRepository");
        return null;
    }

    @Override // ir.nasim.features.call.service.Hilt_CallActionsReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        C5735Kp4.w().D();
        b().F0(intent);
    }
}
