package ir.nasim;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.yT1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24346yT1 {
    private final Context a;
    private final InterfaceC24940zT1 b;
    private final b c;
    private final a d;
    private VelocityTracker e;
    private float f;
    private int g;
    private int h;
    private int i;
    private final int[] j;

    /* renamed from: ir.nasim.yT1$a */
    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i);
    }

    /* renamed from: ir.nasim.yT1$b */
    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i);
    }

    public C24346yT1(Context context, InterfaceC24940zT1 interfaceC24940zT1) {
        this(context, interfaceC24940zT1, new b() { // from class: ir.nasim.wT1
            @Override // ir.nasim.C24346yT1.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i) {
                C24346yT1.c(context2, iArr, motionEvent, i);
            }
        }, new a() { // from class: ir.nasim.xT1
            @Override // ir.nasim.C24346yT1.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
                return C24346yT1.f(velocityTracker, motionEvent, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = AbstractC20736sW7.i(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
        iArr[1] = AbstractC20736sW7.h(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.h == source && this.i == deviceId && this.g == i) {
            return false;
        }
        this.c.a(this.a, this.j, motionEvent, i);
        this.h = source;
        this.i = deviceId;
        this.g = i;
        return true;
    }

    private float e(MotionEvent motionEvent, int i) {
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        return this.d.a(this.e, motionEvent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        AbstractC20691sR7.a(velocityTracker, motionEvent);
        AbstractC20691sR7.b(velocityTracker, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        return AbstractC20691sR7.d(velocityTracker, i);
    }

    public void g(MotionEvent motionEvent, int i) {
        boolean zD = d(motionEvent, i);
        if (this.j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i) * this.b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f) && fSignum != 0.0f)) {
            this.b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f = this.b.a(fMax) ? fMax : 0.0f;
    }

    C24346yT1(Context context, InterfaceC24940zT1 interfaceC24940zT1, b bVar, a aVar) {
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = new int[]{Integer.MAX_VALUE, 0};
        this.a = context;
        this.b = interfaceC24940zT1;
        this.c = bVar;
        this.d = aVar;
    }
}
