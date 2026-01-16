package ir.nasim.core.modules.file.audio.output;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC13822gs5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.core.modules.file.audio.output.GetAudioOutputsUseCase;
import ir.nasim.core.modules.file.audio.output.a;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public final class GetAudioOutputsUseCase {
    private static final a f = new a(null);
    public static final int g = 8;
    private final AudioManager a;
    private final int b;
    private final Context c;
    private final AbstractC13778go1 d;
    private final boolean e;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GetAudioOutputsUseCase.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            GetAudioOutputsUseCase getAudioOutputsUseCase = GetAudioOutputsUseCase.this;
            return getAudioOutputsUseCase.i(getAudioOutputsUseCase.a);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        public static final class a extends AudioDeviceCallback {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ GetAudioOutputsUseCase b;

            a(InterfaceC16204ks5 interfaceC16204ks5, GetAudioOutputsUseCase getAudioOutputsUseCase) {
                this.a = interfaceC16204ks5;
                this.b = getAudioOutputsUseCase;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CharSequence c(GetAudioOutputsUseCase getAudioOutputsUseCase, AudioDeviceInfo audioDeviceInfo) {
                AbstractC13042fc3.i(getAudioOutputsUseCase, "this$0");
                AbstractC13042fc3.i(audioDeviceInfo, "it");
                return getAudioOutputsUseCase.m(audioDeviceInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CharSequence d(GetAudioOutputsUseCase getAudioOutputsUseCase, AudioDeviceInfo audioDeviceInfo) {
                AbstractC13042fc3.i(getAudioOutputsUseCase, "this$0");
                AbstractC13042fc3.i(audioDeviceInfo, "it");
                return getAudioOutputsUseCase.m(audioDeviceInfo);
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                String strD0;
                if (audioDeviceInfoArr != null) {
                    final GetAudioOutputsUseCase getAudioOutputsUseCase = this.b;
                    strD0 = AbstractC10242bK.D0(audioDeviceInfoArr, null, null, null, 0, null, new UA2() { // from class: ir.nasim.sF2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return GetAudioOutputsUseCase.c.a.c(getAudioOutputsUseCase, (AudioDeviceInfo) obj);
                        }
                    }, 31, null);
                } else {
                    strD0 = null;
                }
                C19406qI3.a("GetAudioOutputsUseCase", "onAudioDevicesAdded(" + strD0 + Separators.RPAREN, new Object[0]);
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                GetAudioOutputsUseCase getAudioOutputsUseCase2 = this.b;
                interfaceC16204ks5.h(getAudioOutputsUseCase2.i(getAudioOutputsUseCase2.a));
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                String strD0;
                if (audioDeviceInfoArr != null) {
                    final GetAudioOutputsUseCase getAudioOutputsUseCase = this.b;
                    strD0 = AbstractC10242bK.D0(audioDeviceInfoArr, null, null, null, 0, null, new UA2() { // from class: ir.nasim.rF2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return GetAudioOutputsUseCase.c.a.d(getAudioOutputsUseCase, (AudioDeviceInfo) obj);
                        }
                    }, 31, null);
                } else {
                    strD0 = null;
                }
                C19406qI3.a("GetAudioOutputsUseCase", "onAudioDevicesRemoved(" + strD0 + Separators.RPAREN, new Object[0]);
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                GetAudioOutputsUseCase getAudioOutputsUseCase2 = this.b;
                interfaceC16204ks5.h(getAudioOutputsUseCase2.i(getAudioOutputsUseCase2.a));
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(GetAudioOutputsUseCase getAudioOutputsUseCase, a aVar) {
            getAudioOutputsUseCase.a.unregisterAudioDeviceCallback(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = GetAudioOutputsUseCase.this.new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final a aVar = new a(interfaceC16204ks5, GetAudioOutputsUseCase.this);
                GetAudioOutputsUseCase.this.a.registerAudioDeviceCallback(aVar, null);
                final GetAudioOutputsUseCase getAudioOutputsUseCase = GetAudioOutputsUseCase.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.core.modules.file.audio.output.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return GetAudioOutputsUseCase.c.y(getAudioOutputsUseCase, aVar);
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
            return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = GetAudioOutputsUseCase.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                GetAudioOutputsUseCase getAudioOutputsUseCase = GetAudioOutputsUseCase.this;
                List listI = getAudioOutputsUseCase.i(getAudioOutputsUseCase.a);
                this.b = 1;
                if (interfaceC4806Gq2.a(listI, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a("GetAudioOutputsUseCase", "Audio outputs: " + ((List) this.c), new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public GetAudioOutputsUseCase(AudioManager audioManager, int i, Context context, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(audioManager, "audioManager");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        this.a = audioManager;
        this.b = i;
        this.c = context;
        this.d = abstractC13778go1;
        this.e = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private final InterfaceC4557Fq2 g() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.X(AbstractC6459Nq2.s(AbstractC6459Nq2.f(new GetAudioOutputsUseCase$getAudioOutputsFlowApi21$1(this, null)), 50L), new b(null)), this.d);
    }

    private final InterfaceC4557Fq2 h() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.f(new c(null)), this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List i(AudioManager audioManager) {
        boolean zIsWiredHeadsetOn;
        boolean z = true;
        List listS = AbstractC10360bX0.s(a.b.C0995b.b);
        if (this.e) {
            listS.add(a.b.C0994a.b);
        }
        if (this.b >= 23) {
            AudioDeviceInfo[] devices = audioManager.getDevices(2);
            AbstractC13042fc3.h(devices, "getDevices(...)");
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
                    zIsWiredHeadsetOn = true;
                    break;
                }
            }
            zIsWiredHeadsetOn = false;
        } else {
            zIsWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        }
        if (zIsWiredHeadsetOn) {
            listS.add(a.c.a);
        }
        if (this.b >= 23) {
            AudioDeviceInfo[] devices2 = audioManager.getDevices(2);
            AbstractC13042fc3.h(devices2, "getDevices(...)");
            for (AudioDeviceInfo audioDeviceInfo2 : devices2) {
                if (audioDeviceInfo2.getType() == 7 || audioDeviceInfo2.getType() == 8) {
                    break;
                }
            }
            z = false;
        } else if ((!audioManager.isBluetoothScoAvailableOffCall() || !audioManager.isBluetoothScoOn()) && !audioManager.isBluetoothA2dpOn()) {
            z = false;
        }
        if (z) {
            listS.add(a.C0993a.a);
        }
        return listS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(final Bundle bundle) {
        Set<String> setKeySet = bundle.keySet();
        AbstractC13042fc3.h(setKeySet, "keySet(...)");
        return AbstractC15401jX0.A0(setKeySet, null, null, null, 0, null, new UA2() { // from class: ir.nasim.qF2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return GetAudioOutputsUseCase.l(bundle, (String) obj);
            }
        }, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence l(Bundle bundle, String str) {
        AbstractC13042fc3.i(bundle, "$this_joinToString");
        return str + ": " + bundle.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(AudioDeviceInfo audioDeviceInfo) {
        int type = audioDeviceInfo.getType();
        if (type == 1) {
            return "TYPE_BUILTIN_EARPIECE";
        }
        if (type == 2) {
            return "TYPE_BUILTIN_SPEAKER";
        }
        if (type == 3) {
            return "TYPE_WIRED_HEADSET";
        }
        if (type == 4) {
            return "TYPE_WIRED_HEADPHONES";
        }
        if (type == 7) {
            return "TYPE_BLUETOOTH_SCO";
        }
        if (type == 8) {
            return "TYPE_BLUETOOTH_A2DP";
        }
        if (type == 11) {
            return "TYPE_USB_DEVICE";
        }
        if (type == 18) {
            return "TYPE_TELEPHONY";
        }
        if (type == 22) {
            return "TYPE_USB_HEADSET";
        }
        if (type == 26) {
            return "TYPE_BLE_HEADSET";
        }
        if (type == 27) {
            return "TYPE_BLE_SPEAKER";
        }
        return "Unknown(" + audioDeviceInfo.getType() + Separators.RPAREN;
    }

    public final InterfaceC4557Fq2 j() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.b0(AbstractC6459Nq2.c0(AbstractC6459Nq2.v(this.b >= 23 ? h() : g()), new d(null)), new e(null)), this.d);
    }
}
