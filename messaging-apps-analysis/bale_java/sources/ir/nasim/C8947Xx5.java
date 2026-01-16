package ir.nasim;

import android.gov.nist.core.Separators;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.PowerManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import ir.nasim.Q12;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8947Xx5 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final PowerManager a;
    private final SensorManager b;
    private final InterfaceC18633oz3 c;
    private UA2 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9173Yu3 f;
    private InterfaceC18042nz3 g;
    private SensorEventListener h;
    private boolean i;

    /* renamed from: ir.nasim.Xx5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Xx5$b */
    public static final class b {
        public static final b a = new b("NEAR", 0);
        public static final b b = new b("FAR", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.Xx5$c */
    public interface c {
        C8947Xx5 a(InterfaceC18633oz3 interfaceC18633oz3);
    }

    /* renamed from: ir.nasim.Xx5$d */
    public static final class d implements DefaultLifecycleObserver {
        d() {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("ProximitySensorListener", "onDestroy", new Object[0]);
            C8947Xx5.this.r();
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("ProximitySensorListener", "onStart(isEnabled: " + C8947Xx5.this.i + Separators.RPAREN, new Object[0]);
            if (C8947Xx5.this.i) {
                C8947Xx5.this.q();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            C19406qI3.a("ProximitySensorListener", "onStop", new Object[0]);
            C8947Xx5.this.v();
        }
    }

    public C8947Xx5(PowerManager powerManager, SensorManager sensorManager, InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(powerManager, "powerManager");
        AbstractC13042fc3.i(sensorManager, "sensorManager");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        this.a = powerManager;
        this.b = sensorManager;
        this.c = interfaceC18633oz3;
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Vx5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8947Xx5.w(this.a);
            }
        });
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Wx5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8947Xx5.t(this.a);
            }
        });
    }

    private final void h() {
        PowerManager.WakeLock wakeLockN = n();
        C19406qI3.a("ProximitySensorListener", "acquireLock()", new Object[0]);
        if (wakeLockN.isHeld()) {
            return;
        }
        Q12.a aVar = Q12.b;
        wakeLockN.acquire(Q12.A(T12.s(30, W12.f)));
    }

    private final InterfaceC18042nz3 i() {
        return new d();
    }

    private final SensorEventListener j() {
        return new e();
    }

    private final Sensor m() {
        return (Sensor) this.f.getValue();
    }

    private final PowerManager.WakeLock n() {
        return (PowerManager.WakeLock) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        UA2 ua2 = this.d;
        if (ua2 != null) {
            ua2.invoke(b.b);
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        h();
        UA2 ua2 = this.d;
        if (ua2 != null) {
            ua2.invoke(b.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        v();
        SensorEventListener sensorEventListenerJ = j();
        this.h = sensorEventListenerJ;
        this.b.registerListener(sensorEventListenerJ, m(), 0, 1, new Handler());
    }

    private final void s() {
        PowerManager.WakeLock wakeLockN = n();
        C19406qI3.a("ProximitySensorListener", "releaseLock()", new Object[0]);
        if (wakeLockN.isHeld()) {
            wakeLockN.release(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sensor t(C8947Xx5 c8947Xx5) {
        AbstractC13042fc3.i(c8947Xx5, "this$0");
        return c8947Xx5.b.getDefaultSensor(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        SensorEventListener sensorEventListener = this.h;
        if (sensorEventListener != null) {
            this.b.unregisterListener(sensorEventListener, m());
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerManager.WakeLock w(C8947Xx5 c8947Xx5) {
        AbstractC13042fc3.i(c8947Xx5, "this$0");
        return c8947Xx5.a.newWakeLock(32, "bale:proximity_manager");
    }

    public final void k() {
        if (this.i) {
            this.i = false;
            C19406qI3.a("ProximitySensorListener", "disable()", new Object[0]);
            InterfaceC18042nz3 interfaceC18042nz3 = this.g;
            if (interfaceC18042nz3 != null) {
                this.c.getLifecycle().d(interfaceC18042nz3);
                this.g = null;
            }
            v();
            s();
        }
    }

    public final void l() {
        if (this.i) {
            return;
        }
        this.i = true;
        C19406qI3.a("ProximitySensorListener", "enable()", new Object[0]);
        InterfaceC18042nz3 interfaceC18042nz3I = i();
        this.g = interfaceC18042nz3I;
        this.c.getLifecycle().a(interfaceC18042nz3I);
    }

    public final void r() {
        C19406qI3.a("ProximitySensorListener", "release()", new Object[0]);
        k();
        v();
        s();
    }

    public final void u(UA2 ua2) {
        this.d = ua2;
    }

    /* renamed from: ir.nasim.Xx5$e */
    public static final class e implements SensorEventListener {
        private b a;

        /* renamed from: ir.nasim.Xx5$e$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        e() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Sensor sensor2;
            if (C8947Xx5.this.i) {
                if (sensorEvent == null || (sensor2 = sensorEvent.sensor) == null || sensor2.getType() != 8) {
                    C19406qI3.j("ProximitySensorListener", "onSensorChanged(type: " + ((sensorEvent == null || (sensor = sensorEvent.sensor) == null) ? null : Integer.valueOf(sensor.getType())) + Separators.RPAREN, new Object[0]);
                    return;
                }
                float maximumRange = sensorEvent.sensor.getMaximumRange();
                float[] fArr = sensorEvent.values;
                AbstractC13042fc3.h(fArr, "values");
                Float fC0 = AbstractC10242bK.c0(fArr);
                if (fC0 != null) {
                    float fFloatValue = fC0.floatValue();
                    C19406qI3.a("ProximitySensorListener", "distance: " + fFloatValue + ", maxRange: " + maximumRange + ", accuracy: " + sensorEvent.accuracy, new Object[0]);
                    if (sensorEvent.accuracy <= 1) {
                        C19406qI3.j("ProximitySensorListener", "Sensor value change ignored because of low accuracy!!", new Object[0]);
                        return;
                    }
                    b bVar = fFloatValue < maximumRange ? b.a : b.b;
                    if (bVar != this.a) {
                        int i = a.a[bVar.ordinal()];
                        if (i == 1) {
                            C8947Xx5.this.p();
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            C8947Xx5.this.o();
                        }
                        this.a = bVar;
                    }
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }
}
