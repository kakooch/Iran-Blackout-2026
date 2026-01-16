package ir.nasim.core.modules.file.audio.output;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13822gs5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.SA2;

/* loaded from: classes5.dex */
final class GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ GetAudioOutputsUseCase d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1(GetAudioOutputsUseCase getAudioOutputsUseCase, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.d = getAudioOutputsUseCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(GetAudioOutputsUseCase getAudioOutputsUseCase, GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1$receiver$1 getAudioOutputsUseCase$getAudioOutputsFlowApi21$1$receiver$1) {
        getAudioOutputsUseCase.c.unregisterReceiver(getAudioOutputsUseCase$getAudioOutputsFlowApi21$1$receiver$1);
        return C19938rB7.a;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1 getAudioOutputsUseCase$getAudioOutputsFlowApi21$1 = new GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1(this.d, interfaceC20295rm1);
        getAudioOutputsUseCase$getAudioOutputsFlowApi21$1.c = obj;
        return getAudioOutputsUseCase$getAudioOutputsFlowApi21$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.content.BroadcastReceiver, ir.nasim.core.modules.file.audio.output.GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1$receiver$1] */
    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        Object objE = AbstractC14862ic3.e();
        int i = this.b;
        if (i == 0) {
            AbstractC10685c16.b(obj);
            final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            final GetAudioOutputsUseCase getAudioOutputsUseCase = this.d;
            final ?? r3 = new BroadcastReceiver() { // from class: ir.nasim.core.modules.file.audio.output.GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1$receiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    AbstractC13042fc3.i(context, "context");
                    String action = intent != null ? intent.getAction() : null;
                    if (action == null || !intentFilter.hasAction(action)) {
                        return;
                    }
                    Bundle extras = intent.getExtras();
                    C19406qI3.a("GetAudioOutputsUseCase", "onReceive(" + action + ") -> " + (extras != null ? getAudioOutputsUseCase.k(extras) : null), new Object[0]);
                    interfaceC16204ks5.h(C19938rB7.a);
                }
            };
            this.d.c.registerReceiver(r3, intentFilter);
            final GetAudioOutputsUseCase getAudioOutputsUseCase2 = this.d;
            SA2 sa2 = new SA2() { // from class: ir.nasim.core.modules.file.audio.output.b
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1.y(getAudioOutputsUseCase2, r3);
                }
            };
            this.b = 1;
            if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
