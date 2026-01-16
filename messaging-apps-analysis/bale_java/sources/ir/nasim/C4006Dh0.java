package ir.nasim;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import ir.nasim.features.call.audioManager.bluetooth.BluetoothHeadsetBroadcastReceiver;
import java.util.List;

/* renamed from: ir.nasim.Dh0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4006Dh0 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final TN a;
    private final BluetoothAdapter b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;
    private BluetoothHeadsetBroadcastReceiver e;
    private BluetoothHeadset f;
    private BluetoothProfile.ServiceListener g;

    /* renamed from: ir.nasim.Dh0$a */
    public static final class a {
        private a() {
        }

        public final C4006Dh0 a(Context context, TN tn) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(tn, "androidAudioManager");
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            ED1 ed1 = null;
            if (defaultAdapter != null && tn.g()) {
                return new C4006Dh0(context, tn, defaultAdapter, ed1);
            }
            return null;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Dh0$b */
    public static final class b implements BluetoothProfile.ServiceListener {
        b() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i != 1) {
                return;
            }
            if (C4006Dh0.this.c.getValue() == WK6.a) {
                C19406qI3.b("BluetoothManager", "closeProfileProxy");
                C4006Dh0.this.b.closeProfileProxy(1, bluetoothProfile);
            } else {
                C4006Dh0.this.f = bluetoothProfile instanceof BluetoothHeadset ? (BluetoothHeadset) bluetoothProfile : null;
                C4006Dh0.this.o();
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            if (i != 1) {
                return;
            }
            C4006Dh0.this.n();
            C4006Dh0.this.f = null;
            C4006Dh0.this.o();
        }
    }

    /* renamed from: ir.nasim.Dh0$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, C4006Dh0.class, "onConnectionChanged", "onConnectionChanged(I)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Number) obj).intValue());
            return C19938rB7.a;
        }

        public final void y(int i) {
            ((C4006Dh0) this.receiver).k(i);
        }
    }

    /* renamed from: ir.nasim.Dh0$d */
    /* synthetic */ class d extends EB2 implements InterfaceC14603iB2 {
        d(Object obj) {
            super(2, obj, C4006Dh0.class, "onAudioChanged", "onAudioChanged(IZ)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }

        public final void y(int i, boolean z) {
            ((C4006Dh0) this.receiver).i(i, z);
        }
    }

    public /* synthetic */ C4006Dh0(Context context, TN tn, BluetoothAdapter bluetoothAdapter, ED1 ed1) {
        this(context, tn, bluetoothAdapter);
    }

    private final BluetoothHeadsetBroadcastReceiver g(Context context) {
        return new BluetoothHeadsetBroadcastReceiver(context, new c(this), new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int i2, boolean z) {
        Object value;
        C19406qI3.a("BluetoothManager", "onAudioChanged: " + i2, new Object[0]);
        if (i2 == 10) {
            if (z) {
                return;
            }
            o();
        } else {
            if (i2 != 12) {
                return;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, WK6.f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i2) {
        Object value;
        C19406qI3.a("BluetoothManager", "onConnectionChanged : " + i2, new Object[0]);
        if (i2 == 0) {
            n();
            o();
        } else {
            if (i2 != 2) {
                return;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, WK6.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        Object value;
        Object value2;
        Object value3;
        List<BluetoothDevice> connectedDevices;
        C19406qI3.a("BluetoothManager", "updateDevice", new Object[0]);
        try {
            BluetoothHeadset bluetoothHeadset = this.f;
            if (((bluetoothHeadset == null || (connectedDevices = bluetoothHeadset.getConnectedDevices()) == null) ? null : (BluetoothDevice) AbstractC15401jX0.s0(connectedDevices)) == null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
                do {
                    value3 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value3, WK6.b));
                return;
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.c;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, WK6.c));
        } catch (SecurityException unused) {
            C19406qI3.b("BluetoothManager", "SecurityException");
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.c;
            do {
                value = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value, WK6.g));
        }
    }

    private final void p() {
        Object value;
        if (this.d.getValue() == WK6.c && this.a.h()) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, WK6.f));
        }
    }

    public final InterfaceC10258bL6 h() {
        return this.d;
    }

    public final void j() {
        C19406qI3.a("BluetoothManager", "onBluetoothPermissionGranted", new Object[0]);
        o();
        p();
    }

    public final void l(Context context) {
        Object value;
        AbstractC13042fc3.i(context, "context");
        C19406qI3.a("BluetoothManager", "onDestroy", new Object[0]);
        n();
        BluetoothHeadsetBroadcastReceiver bluetoothHeadsetBroadcastReceiver = this.e;
        if (bluetoothHeadsetBroadcastReceiver != null) {
            bluetoothHeadsetBroadcastReceiver.a(context);
        }
        this.e = null;
        BluetoothHeadset bluetoothHeadset = this.f;
        if (bluetoothHeadset != null) {
            this.b.closeProfileProxy(1, bluetoothHeadset);
        }
        this.f = null;
        this.g = null;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, WK6.a));
    }

    public final void m() {
        Object value;
        C19406qI3.a("BluetoothManager", "startScoAudio", new Object[0]);
        if (this.c.getValue() != WK6.c) {
            C19406qI3.a("BluetoothManager", "SCO connection failed as no headset available", new Object[0]);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, WK6.e));
        this.a.r();
        this.a.o(true);
    }

    public final void n() {
        Object value;
        C19406qI3.a("BluetoothManager", "stopScoAudio", new Object[0]);
        this.a.s();
        this.a.o(false);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, WK6.d));
    }

    private C4006Dh0(Context context, TN tn, BluetoothAdapter bluetoothAdapter) {
        Object value;
        this.a = tn;
        this.b = bluetoothAdapter;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(WK6.a);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        b bVar = new b();
        this.g = bVar;
        if (bluetoothAdapter.getProfileProxy(context, bVar, 1)) {
            this.e = g(context);
        } else {
            C19406qI3.b("BluetoothManager", "BluetoothAdapter.getProfileProxy(HEADSET) failed");
        }
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, WK6.b));
    }
}
