package ir.nasim.features.map.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13822gs5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.C19938rB7;
import ir.nasim.GJ0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
final class GetLocationStateUseCase$isLocationOnState$1 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ GetLocationStateUseCase d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetLocationStateUseCase$isLocationOnState$1(GetLocationStateUseCase getLocationStateUseCase, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.d = getLocationStateUseCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(GetLocationStateUseCase getLocationStateUseCase, GetLocationStateUseCase$isLocationOnState$1$tracker$1 getLocationStateUseCase$isLocationOnState$1$tracker$1) {
        getLocationStateUseCase.a.unregisterReceiver(getLocationStateUseCase$isLocationOnState$1$tracker$1);
        return C19938rB7.a;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        GetLocationStateUseCase$isLocationOnState$1 getLocationStateUseCase$isLocationOnState$1 = new GetLocationStateUseCase$isLocationOnState$1(this.d, interfaceC20295rm1);
        getLocationStateUseCase$isLocationOnState$1.c = obj;
        return getLocationStateUseCase$isLocationOnState$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.BroadcastReceiver, ir.nasim.features.map.data.GetLocationStateUseCase$isLocationOnState$1$tracker$1] */
    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        Object objE = AbstractC14862ic3.e();
        int i = this.b;
        if (i == 0) {
            AbstractC10685c16.b(obj);
            final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
            final GetLocationStateUseCase getLocationStateUseCase = this.d;
            final ?? r1 = new BroadcastReceiver() { // from class: ir.nasim.features.map.data.GetLocationStateUseCase$isLocationOnState$1$tracker$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    AbstractC13042fc3.i(context, "context");
                    interfaceC16204ks5.h(Boolean.valueOf(getLocationStateUseCase.f()));
                }
            };
            Intent intentRegisterReceiver = this.d.a.registerReceiver(r1, new IntentFilter("android.location.PROVIDERS_CHANGED"));
            if (intentRegisterReceiver != null && intentRegisterReceiver.getAction() != null) {
                GJ0.b(interfaceC16204ks5.h(AbstractC6392Nk0.a(this.d.f())));
            }
            final GetLocationStateUseCase getLocationStateUseCase2 = this.d;
            SA2 sa2 = new SA2() { // from class: ir.nasim.features.map.data.a
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return GetLocationStateUseCase$isLocationOnState$1.y(getLocationStateUseCase2, r1);
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
        return ((GetLocationStateUseCase$isLocationOnState$1) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
