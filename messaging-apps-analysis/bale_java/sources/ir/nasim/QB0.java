package ir.nasim;

import android.hardware.camera2.CaptureResult;
import ir.nasim.C16051kd2;

/* loaded from: classes.dex */
public interface QB0 {

    public static final class a implements QB0 {
        public static QB0 h() {
            return new a();
        }

        @Override // ir.nasim.QB0
        public C14935ij7 b() {
            return C14935ij7.b();
        }

        @Override // ir.nasim.QB0
        public PB0 c() {
            return PB0.UNKNOWN;
        }

        @Override // ir.nasim.QB0
        public CaptureResult d() {
            return null;
        }

        @Override // ir.nasim.QB0
        public NB0 e() {
            return NB0.UNKNOWN;
        }

        @Override // ir.nasim.QB0
        public OB0 f() {
            return OB0.UNKNOWN;
        }

        @Override // ir.nasim.QB0
        public MB0 g() {
            return MB0.UNKNOWN;
        }

        @Override // ir.nasim.QB0
        public long getTimestamp() {
            return -1L;
        }
    }

    default void a(C16051kd2.b bVar) {
        bVar.g(c());
    }

    C14935ij7 b();

    PB0 c();

    default CaptureResult d() {
        return null;
    }

    NB0 e();

    OB0 f();

    MB0 g();

    long getTimestamp();
}
