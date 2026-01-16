package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;

/* renamed from: ir.nasim.ok7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC18490ok7 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.ok7$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public static /* synthetic */ InterfaceC18490ok7 b(a aVar, Context context, boolean z, UA2 ua2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                ua2 = null;
            }
            return aVar.a(context, z, ua2);
        }

        public final InterfaceC18490ok7 a(Context context, boolean z, UA2 ua2) {
            AbstractC13042fc3.i(context, "context");
            return Build.VERSION.SDK_INT >= 31 ? new b(context, ua2, z) : new c(context, ua2, z);
        }
    }

    /* renamed from: ir.nasim.ok7$b */
    public static final class b extends TelephonyCallback implements TelephonyCallback.CallStateListener, InterfaceC18490ok7 {
        private final UA2 b;
        private final boolean c;
        private final TelephonyManager d;

        public b(Context context, UA2 ua2, boolean z) {
            AbstractC13042fc3.i(context, "context");
            this.b = ua2;
            this.c = z;
            Object systemService = context.getSystemService("phone");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            this.d = telephonyManager;
            if (C5505Jq.H()) {
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), AbstractC19081pk7.a(this));
            }
        }

        @Override // ir.nasim.InterfaceC18490ok7
        public void a() {
            if (C5505Jq.H()) {
                this.d.unregisterTelephonyCallback(AbstractC19081pk7.a(this));
            }
        }

        @Override // ir.nasim.InterfaceC18490ok7
        public boolean b() {
            return !C5505Jq.H() || this.d.getCallState() == 0;
        }

        public void onCallStateChanged(int i) {
            UA2 ua2 = this.b;
            if (ua2 != null) {
                ua2.invoke(Integer.valueOf(i));
            }
            if (this.c) {
                a();
            }
        }
    }

    /* renamed from: ir.nasim.ok7$c */
    public static final class c extends PhoneStateListener implements InterfaceC18490ok7 {
        private final UA2 b;
        private final boolean c;
        private final TelephonyManager d;

        public c(Context context, UA2 ua2, boolean z) {
            AbstractC13042fc3.i(context, "context");
            this.b = ua2;
            this.c = z;
            Object systemService = context.getSystemService("phone");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            this.d = telephonyManager;
            telephonyManager.listen(this, 32);
        }

        @Override // ir.nasim.InterfaceC18490ok7
        public void a() {
            this.d.listen(this, 0);
        }

        @Override // ir.nasim.InterfaceC18490ok7
        public boolean b() {
            return this.d.getCallState() == 0;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            UA2 ua2 = this.b;
            if (ua2 != null) {
                ua2.invoke(Integer.valueOf(i));
            }
            if (this.c) {
                a();
            }
        }
    }

    void a();

    boolean b();
}
