package ir.nasim;

import android.hardware.camera2.CameraDevice;
import ir.nasim.C15248jG0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.jG0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C15248jG0 {
    final Executor a;
    final Object b = new Object();
    final Set c = new LinkedHashSet();
    final Set d = new LinkedHashSet();
    final Set e = new LinkedHashSet();
    private final CameraDevice.StateCallback f = new a();

    C15248jG0(Executor executor) {
        this.a = executor;
    }

    private void a(InterfaceC18096o47 interfaceC18096o47) {
        InterfaceC18096o47 interfaceC18096o472;
        Iterator it = f().iterator();
        while (it.hasNext() && (interfaceC18096o472 = (InterfaceC18096o47) it.next()) != interfaceC18096o47) {
            interfaceC18096o472.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            InterfaceC18096o47 interfaceC18096o47 = (InterfaceC18096o47) it.next();
            interfaceC18096o47.c().q(interfaceC18096o47);
        }
    }

    CameraDevice.StateCallback c() {
        return this.f;
    }

    List d() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.c);
        }
        return arrayList;
    }

    List e() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.e);
        }
        return arrayList;
    }

    List f() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList();
            arrayList.addAll(d());
            arrayList.addAll(e());
        }
        return arrayList;
    }

    void g(InterfaceC18096o47 interfaceC18096o47) {
        synchronized (this.b) {
            this.c.remove(interfaceC18096o47);
            this.d.remove(interfaceC18096o47);
        }
    }

    void h(InterfaceC18096o47 interfaceC18096o47) {
        synchronized (this.b) {
            this.d.add(interfaceC18096o47);
        }
    }

    void i(InterfaceC18096o47 interfaceC18096o47) {
        a(interfaceC18096o47);
        synchronized (this.b) {
            this.e.remove(interfaceC18096o47);
        }
    }

    void j(InterfaceC18096o47 interfaceC18096o47) {
        synchronized (this.b) {
            this.c.add(interfaceC18096o47);
            this.e.remove(interfaceC18096o47);
        }
        a(interfaceC18096o47);
    }

    void k(InterfaceC18096o47 interfaceC18096o47) {
        synchronized (this.b) {
            this.e.add(interfaceC18096o47);
        }
    }

    /* renamed from: ir.nasim.jG0$a */
    class a extends CameraDevice.StateCallback {
        a() {
        }

        private void c() {
            List listF;
            synchronized (C15248jG0.this.b) {
                listF = C15248jG0.this.f();
                C15248jG0.this.e.clear();
                C15248jG0.this.c.clear();
                C15248jG0.this.d.clear();
            }
            Iterator it = listF.iterator();
            while (it.hasNext()) {
                ((InterfaceC18096o47) it.next()).e();
            }
        }

        private void d(final int i) {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (C15248jG0.this.b) {
                linkedHashSet.addAll(C15248jG0.this.e);
                linkedHashSet.addAll(C15248jG0.this.c);
            }
            C15248jG0.this.a.execute(new Runnable() { // from class: ir.nasim.iG0
                @Override // java.lang.Runnable
                public final void run() {
                    C15248jG0.a.f(linkedHashSet, i);
                }
            });
        }

        private void e() {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (C15248jG0.this.b) {
                linkedHashSet.addAll(C15248jG0.this.e);
                linkedHashSet.addAll(C15248jG0.this.c);
            }
            C15248jG0.this.a.execute(new Runnable() { // from class: ir.nasim.hG0
                @Override // java.lang.Runnable
                public final void run() {
                    C15248jG0.b(linkedHashSet);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(LinkedHashSet linkedHashSet, int i) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((InterfaceC18096o47) it.next()).g(i);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            e();
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            e();
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            e();
            d(i);
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
        }
    }
}
