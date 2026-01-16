package com.twilio.audioswitch.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC4240Eh0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3299Ah0;
import ir.nasim.InterfaceC3538Bh0;
import ir.nasim.InterfaceC3772Ch0;
import ir.nasim.NI3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0004\t\u000b\u0014\u000eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010%R0\u0010.\u001a\u00020&2\u0006\u0010'\u001a\u00020&8\u0000@@X\u0081\u000e¢\u0006\u0018\n\u0004\b\t\u0010(\u0012\u0004\b-\u0010\n\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u00060/R\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000b\u00100\u0012\u0004\b3\u0010\n\u001a\u0004\b1\u00102R$\u0010:\u001a\u000605R\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0014\u00106\u0012\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010<R$\u0010D\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010I¨\u0006K"}, d2 = {"Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager;", "Landroid/bluetooth/BluetoothProfile$ServiceListener;", "Landroid/content/BroadcastReceiver;", "", "intentAction", "", "h", "(Ljava/lang/String;)Z", "Lir/nasim/rB7;", "a", "()V", "b", "f", "()Z", "d", "()Ljava/lang/String;", "e", "g", "Landroid/content/Intent;", "Lir/nasim/Ah0;", "c", "(Landroid/content/Intent;)Lir/nasim/Ah0;", "deviceWrapper", "i", "(Lir/nasim/Ah0;)Z", "", "profile", "Landroid/bluetooth/BluetoothProfile;", "bluetoothProfile", "onServiceConnected", "(ILandroid/bluetooth/BluetoothProfile;)V", "onServiceDisconnected", "(I)V", "Landroid/content/Context;", "context", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$d;", "value", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$d;", "getHeadsetState$audioswitch_release", "()Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$d;", "j", "(Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$d;)V", "getHeadsetState$audioswitch_release$annotations", "headsetState", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$c;", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$c;", "getEnableBluetoothScoJob$audioswitch_release", "()Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$c;", "getEnableBluetoothScoJob$audioswitch_release$annotations", "enableBluetoothScoJob", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$b;", "Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$b;", "getDisableBluetoothScoJob$audioswitch_release", "()Lcom/twilio/audioswitch/bluetooth/BluetoothHeadsetManager$b;", "getDisableBluetoothScoJob$audioswitch_release$annotations", "disableBluetoothScoJob", "Lir/nasim/NI3;", "Lir/nasim/NI3;", "logger", "Lir/nasim/Bh0;", "Lir/nasim/Bh0;", "getHeadsetListener", "()Lir/nasim/Bh0;", "setHeadsetListener", "(Lir/nasim/Bh0;)V", "headsetListener", "Lir/nasim/Ch0;", "Lir/nasim/Ch0;", "bluetoothIntentProcessor", "Landroid/bluetooth/BluetoothHeadset;", "Landroid/bluetooth/BluetoothHeadset;", "headsetProxy", "audioswitch_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class BluetoothHeadsetManager extends BroadcastReceiver implements BluetoothProfile.ServiceListener {

    /* renamed from: a, reason: from kotlin metadata */
    private d headsetState;

    /* renamed from: b, reason: from kotlin metadata */
    private final c enableBluetoothScoJob;

    /* renamed from: c, reason: from kotlin metadata */
    private final b disableBluetoothScoJob;

    /* renamed from: d, reason: from kotlin metadata */
    private final NI3 logger;

    /* renamed from: e, reason: from kotlin metadata */
    private InterfaceC3538Bh0 headsetListener;

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC3772Ch0 bluetoothIntentProcessor;

    /* renamed from: g, reason: from kotlin metadata */
    private BluetoothHeadset headsetProxy;

    public final class b extends AbstractC4240Eh0 {
    }

    public final class c extends AbstractC4240Eh0 {
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = new a();

            private a() {
                super(null);
            }
        }

        public static final class b extends d {
            public static final b a = new b();

            private b() {
                super(null);
            }
        }

        public static final class c extends d {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    private final void a() {
        if (e()) {
            return;
        }
        j(d.b.a);
    }

    private final void b() {
        j(e() ? d.a.a : g() ? d.b.a : d.c.a);
    }

    private final InterfaceC3299Ah0 c(Intent intent) {
        InterfaceC3299Ah0 interfaceC3299Ah0A = this.bluetoothIntentProcessor.a(intent);
        if (interfaceC3299Ah0A == null) {
            return null;
        }
        if (!i(interfaceC3299Ah0A)) {
            interfaceC3299Ah0A = null;
        }
        return interfaceC3299Ah0A;
    }

    private final String d() {
        List<BluetoothDevice> connectedDevices;
        Object next;
        BluetoothHeadset bluetoothHeadset = this.headsetProxy;
        if (bluetoothHeadset == null || (connectedDevices = bluetoothHeadset.getConnectedDevices()) == null) {
            return null;
        }
        if (connectedDevices.size() <= 1 || !e()) {
            if (connectedDevices.size() != 1) {
                this.logger.a("BluetoothHeadsetManager", "Device size 0");
                return null;
            }
            Object objQ0 = AbstractC15401jX0.q0(connectedDevices);
            AbstractC13042fc3.h(objQ0, "devices.first()");
            String name = ((BluetoothDevice) objQ0).getName();
            this.logger.a("BluetoothHeadsetManager", "Device size 1 with device name: " + name);
            return name;
        }
        Iterator<T> it = connectedDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (bluetoothHeadset.isAudioConnected((BluetoothDevice) next)) {
                break;
            }
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) next;
        String name2 = bluetoothDevice != null ? bluetoothDevice.getName() : null;
        this.logger.a("BluetoothHeadsetManager", "Device size > 1 with device name: " + name2);
        return name2;
    }

    private final boolean e() {
        Boolean boolValueOf;
        boolean z;
        BluetoothHeadset bluetoothHeadset = this.headsetProxy;
        if (bluetoothHeadset == null) {
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        if (connectedDevices != null) {
            List<BluetoothDevice> list = connectedDevices;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = false;
                boolValueOf = Boolean.valueOf(z);
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (bluetoothHeadset.isAudioConnected((BluetoothDevice) it.next())) {
                        z = true;
                        break;
                    }
                }
                z = false;
                boolValueOf = Boolean.valueOf(z);
            }
        } else {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    private final boolean f() {
        return AbstractC13042fc3.d(this.headsetState, d.a.a) && g() && !e();
    }

    private final boolean g() {
        BluetoothHeadset bluetoothHeadset = this.headsetProxy;
        if (bluetoothHeadset != null) {
            Boolean boolValueOf = bluetoothHeadset.getConnectedDevices() != null ? Boolean.valueOf(!r0.isEmpty()) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return false;
    }

    private final boolean h(String intentAction) {
        return AbstractC13042fc3.d(intentAction, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") || AbstractC13042fc3.d(intentAction, "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    }

    private final boolean i(InterfaceC3299Ah0 deviceWrapper) {
        Integer numA = deviceWrapper.a();
        if (numA == null) {
            return false;
        }
        int iIntValue = numA.intValue();
        return iIntValue == 1032 || iIntValue == 1028 || iIntValue == 1056 || iIntValue == 1048 || iIntValue == 7936;
    }

    public final void j(d dVar) {
        AbstractC13042fc3.i(dVar, "value");
        if (!AbstractC13042fc3.d(this.headsetState, dVar)) {
            this.headsetState = dVar;
            this.logger.a("BluetoothHeadsetManager", "Headset state changed to " + AbstractC10882cM5.b(this.headsetState.getClass()).p());
            if (AbstractC13042fc3.d(dVar, d.c.a)) {
                this.enableBluetoothScoJob.a();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InterfaceC3299Ah0 interfaceC3299Ah0C;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "intent");
        if (!h(intent.getAction()) || (interfaceC3299Ah0C = c(intent)) == null) {
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        if (intExtra == 0) {
            this.logger.a("BluetoothHeadsetManager", "Bluetooth headset " + interfaceC3299Ah0C + " disconnected");
            b();
            InterfaceC3538Bh0 interfaceC3538Bh0 = this.headsetListener;
            if (interfaceC3538Bh0 != null) {
                InterfaceC3538Bh0.a.a(interfaceC3538Bh0, null, 1, null);
                return;
            }
            return;
        }
        if (intExtra == 2) {
            this.logger.a("BluetoothHeadsetManager", "Bluetooth headset " + interfaceC3299Ah0C + " connected");
            a();
            InterfaceC3538Bh0 interfaceC3538Bh02 = this.headsetListener;
            if (interfaceC3538Bh02 != null) {
                interfaceC3538Bh02.a(interfaceC3299Ah0C.getName());
                return;
            }
            return;
        }
        if (intExtra == 10) {
            this.logger.a("BluetoothHeadsetManager", "Bluetooth audio disconnected on device " + interfaceC3299Ah0C);
            this.disableBluetoothScoJob.a();
            if (f()) {
                this.enableBluetoothScoJob.b();
            }
            InterfaceC3538Bh0 interfaceC3538Bh03 = this.headsetListener;
            if (interfaceC3538Bh03 != null) {
                InterfaceC3538Bh0.a.a(interfaceC3538Bh03, null, 1, null);
                return;
            }
            return;
        }
        if (intExtra != 12) {
            return;
        }
        this.logger.a("BluetoothHeadsetManager", "Bluetooth audio connected on device " + interfaceC3299Ah0C);
        this.enableBluetoothScoJob.a();
        j(d.a.a);
        InterfaceC3538Bh0 interfaceC3538Bh04 = this.headsetListener;
        if (interfaceC3538Bh04 != null) {
            InterfaceC3538Bh0.a.a(interfaceC3538Bh04, null, 1, null);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int profile, BluetoothProfile bluetoothProfile) {
        AbstractC13042fc3.i(bluetoothProfile, "bluetoothProfile");
        BluetoothHeadset bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
        this.headsetProxy = bluetoothHeadset;
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        AbstractC13042fc3.h(connectedDevices, "bluetoothProfile.connectedDevices");
        for (BluetoothDevice bluetoothDevice : connectedDevices) {
            NI3 ni3 = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Bluetooth ");
            AbstractC13042fc3.h(bluetoothDevice, "device");
            sb.append(bluetoothDevice.getName());
            sb.append(" connected");
            ni3.a("BluetoothHeadsetManager", sb.toString());
        }
        if (g()) {
            a();
            InterfaceC3538Bh0 interfaceC3538Bh0 = this.headsetListener;
            if (interfaceC3538Bh0 != null) {
                interfaceC3538Bh0.a(d());
            }
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int profile) {
        this.logger.a("BluetoothHeadsetManager", "Bluetooth disconnected");
        j(d.c.a);
        InterfaceC3538Bh0 interfaceC3538Bh0 = this.headsetListener;
        if (interfaceC3538Bh0 != null) {
            InterfaceC3538Bh0.a.a(interfaceC3538Bh0, null, 1, null);
        }
    }
}
