package ir.nasim;

import ir.nasim.GD0;
import ir.nasim.InterfaceC15221jD0;
import java.util.Objects;

/* loaded from: classes.dex */
class HD0 {
    private final KD0 a;
    private final C20298rm4 b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InterfaceC15221jD0.a.values().length];
            a = iArr;
            try {
                iArr[InterfaceC15221jD0.a.PENDING_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InterfaceC15221jD0.a.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InterfaceC15221jD0.a.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[InterfaceC15221jD0.a.CONFIGURED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[InterfaceC15221jD0.a.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[InterfaceC15221jD0.a.RELEASING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[InterfaceC15221jD0.a.CLOSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[InterfaceC15221jD0.a.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    HD0(KD0 kd0) {
        this.a = kd0;
        C20298rm4 c20298rm4 = new C20298rm4();
        this.b = c20298rm4;
        c20298rm4.n(GD0.a(GD0.b.CLOSED));
    }

    private GD0 b() {
        return this.a.c() ? GD0.a(GD0.b.OPENING) : GD0.a(GD0.b.PENDING_OPEN);
    }

    public androidx.lifecycle.r a() {
        return this.b;
    }

    public void c(InterfaceC15221jD0.a aVar, GD0.a aVar2) {
        GD0 gd0B;
        switch (a.a[aVar.ordinal()]) {
            case 1:
                gd0B = b();
                break;
            case 2:
                gd0B = GD0.b(GD0.b.OPENING, aVar2);
                break;
            case 3:
            case 4:
                gd0B = GD0.b(GD0.b.OPEN, aVar2);
                break;
            case 5:
            case 6:
                gd0B = GD0.b(GD0.b.CLOSING, aVar2);
                break;
            case 7:
            case 8:
                gd0B = GD0.b(GD0.b.CLOSED, aVar2);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + aVar);
        }
        PI3.a("CameraStateMachine", "New public camera state " + gd0B + " from " + aVar + " and " + aVar2);
        if (Objects.equals((GD0) this.b.f(), gd0B)) {
            return;
        }
        PI3.a("CameraStateMachine", "Publishing new public camera state " + gd0B);
        this.b.n(gd0B);
    }
}
