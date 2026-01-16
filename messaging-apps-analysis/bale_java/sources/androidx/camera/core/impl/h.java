package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraValidator;
import ir.nasim.C4094Dq7;
import ir.nasim.InterfaceC21050t16;
import ir.nasim.InterfaceC22314v16;
import ir.nasim.PI3;

/* loaded from: classes.dex */
public final class h implements InterfaceC22314v16 {
    private final InterfaceC21050t16 d;

    class a implements InterfaceC21050t16 {
        final /* synthetic */ long d;

        a(long j) {
            this.d = j;
        }

        @Override // ir.nasim.InterfaceC21050t16
        public long a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC21050t16
        public InterfaceC21050t16.c d(InterfaceC21050t16.b bVar) {
            return bVar.j() == 1 ? InterfaceC21050t16.c.d : InterfaceC21050t16.c.e;
        }
    }

    public static final class b implements InterfaceC22314v16 {
        private final InterfaceC21050t16 d;

        public b(long j) {
            this.d = new h(j);
        }

        @Override // ir.nasim.InterfaceC21050t16
        public long a() {
            return this.d.a();
        }

        @Override // ir.nasim.InterfaceC22314v16
        public InterfaceC21050t16 c(long j) {
            return new b(j);
        }

        @Override // ir.nasim.InterfaceC21050t16
        public InterfaceC21050t16.c d(InterfaceC21050t16.b bVar) {
            if (this.d.d(bVar).d()) {
                return InterfaceC21050t16.c.e;
            }
            Throwable thA = bVar.a();
            if (thA instanceof CameraValidator.CameraIdListIncorrectException) {
                PI3.c("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                if (((CameraValidator.CameraIdListIncorrectException) thA).a() > 0) {
                    return InterfaceC21050t16.c.g;
                }
            }
            return InterfaceC21050t16.c.d;
        }
    }

    public h(long j) {
        this.d = new C4094Dq7(j, new a(j));
    }

    @Override // ir.nasim.InterfaceC21050t16
    public long a() {
        return this.d.a();
    }

    @Override // ir.nasim.InterfaceC22314v16
    public InterfaceC21050t16 c(long j) {
        return new h(j);
    }

    @Override // ir.nasim.InterfaceC21050t16
    public InterfaceC21050t16.c d(InterfaceC21050t16.b bVar) {
        return this.d.d(bVar);
    }
}
