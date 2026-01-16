package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import ir.nasim.InterfaceC18096o47;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.z47, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24711z47 extends InterfaceC18096o47.c {
    private final List a;

    C24711z47(List list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
    }

    static InterfaceC18096o47.c w(InterfaceC18096o47.c... cVarArr) {
        return new C24711z47(Arrays.asList(cVarArr));
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void o(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).o(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void p(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).p(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void q(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).q(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void r(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).r(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void s(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).s(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void t(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).t(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    void u(InterfaceC18096o47 interfaceC18096o47) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).u(interfaceC18096o47);
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void v(InterfaceC18096o47 interfaceC18096o47, Surface surface) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47.c) it.next()).v(interfaceC18096o47, surface);
        }
    }

    /* renamed from: ir.nasim.z47$a */
    static class a extends InterfaceC18096o47.c {
        private final CameraCaptureSession.StateCallback a;

        a(CameraCaptureSession.StateCallback stateCallback) {
            this.a = stateCallback;
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void o(InterfaceC18096o47 interfaceC18096o47) {
            this.a.onActive(interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void p(InterfaceC18096o47 interfaceC18096o47) {
            AbstractC10024ax.a(this.a, interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void q(InterfaceC18096o47 interfaceC18096o47) {
            this.a.onClosed(interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void r(InterfaceC18096o47 interfaceC18096o47) {
            this.a.onConfigureFailed(interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void s(InterfaceC18096o47 interfaceC18096o47) {
            this.a.onConfigured(interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void t(InterfaceC18096o47 interfaceC18096o47) {
            this.a.onReady(interfaceC18096o47.m().c());
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void v(InterfaceC18096o47 interfaceC18096o47, Surface surface) {
            AbstractC8932Xw.a(this.a, interfaceC18096o47.m().c(), surface);
        }

        a(List list) {
            this(AbstractC15803kC0.a(list));
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        void u(InterfaceC18096o47 interfaceC18096o47) {
        }
    }
}
