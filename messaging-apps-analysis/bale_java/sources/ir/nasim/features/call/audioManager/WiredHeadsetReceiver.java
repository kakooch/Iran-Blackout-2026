package ir.nasim.features.call.audioManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.TN;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018¨\u0006\u001a"}, d2 = {"Lir/nasim/features/call/audioManager/WiredHeadsetReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Lir/nasim/TN;", "audioManager", "<init>", "(Landroid/content/Context;Lir/nasim/TN;)V", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "b", "(Landroid/content/Context;)V", "a", "Lir/nasim/TN;", "Lir/nasim/Zm4;", "", "Lir/nasim/Zm4;", "_state", "Lir/nasim/Fq2;", "c", "Lir/nasim/Fq2;", "()Lir/nasim/Fq2;", "state", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WiredHeadsetReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private final TN audioManager;

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC9336Zm4 _state;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC4557Fq2 state;

    public WiredHeadsetReceiver(Context context, TN tn) {
        Object value;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(tn, "audioManager");
        this.audioManager = tn;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        this._state = interfaceC9336Zm4A;
        this.state = interfaceC9336Zm4A;
        do {
            value = interfaceC9336Zm4A.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4A.f(value, Boolean.valueOf(this.audioManager.j())));
        context.registerReceiver(this, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    /* renamed from: a, reason: from getter */
    public final InterfaceC4557Fq2 getState() {
        return this.state;
    }

    public final void b(Context context) {
        AbstractC13042fc3.i(context, "context");
        context.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object value;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        boolean z = intent.getIntExtra("state", 0) == 1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this._state;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }
}
