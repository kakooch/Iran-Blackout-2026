package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC18633oz3;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1968d implements n {
    private final DefaultLifecycleObserver a;
    private final n b;

    /* renamed from: androidx.lifecycle.d$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.a.values().length];
            try {
                iArr[j.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[j.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[j.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[j.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[j.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public C1968d(DefaultLifecycleObserver defaultLifecycleObserver, n nVar) {
        AbstractC13042fc3.i(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.a = defaultLifecycleObserver;
        this.b = nVar;
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "event");
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.a.onCreate(interfaceC18633oz3);
                break;
            case 2:
                this.a.onStart(interfaceC18633oz3);
                break;
            case 3:
                this.a.onResume(interfaceC18633oz3);
                break;
            case 4:
                this.a.onPause(interfaceC18633oz3);
                break;
            case 5:
                this.a.onStop(interfaceC18633oz3);
                break;
            case 6:
                this.a.onDestroy(interfaceC18633oz3);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        n nVar = this.b;
        if (nVar != null) {
            nVar.s(interfaceC18633oz3, aVar);
        }
    }
}
