package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Size;
import ir.nasim.GD0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.pB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18749pB0 implements InterfaceC14623iD0 {
    private final String a;
    private final C19349qC0 b;
    private final C17567nB0 c;
    private PA0 e;
    private final a h;
    private final C6293Mz5 j;
    private final InterfaceC10135b82 k;
    private final C17585nD0 l;
    private final Object d = new Object();
    private a f = null;
    private a g = null;
    private List i = null;

    /* renamed from: ir.nasim.pB0$a */
    static class a extends androidx.lifecycle.s {
        private androidx.lifecycle.r m;
        private final Object n;

        a(Object obj) {
            this.n = obj;
        }

        @Override // androidx.lifecycle.r
        public Object f() {
            androidx.lifecycle.r rVar = this.m;
            return rVar == null ? this.n : rVar.f();
        }

        @Override // androidx.lifecycle.s
        public void q(androidx.lifecycle.r rVar, QG4 qg4) {
            throw new UnsupportedOperationException();
        }

        void s(androidx.lifecycle.r rVar) {
            androidx.lifecycle.r rVar2 = this.m;
            if (rVar2 != null) {
                super.r(rVar2);
            }
            this.m = rVar;
            super.q(rVar, new QG4() { // from class: ir.nasim.oB0
                @Override // ir.nasim.QG4
                public final void a(Object obj) {
                    this.a.p(obj);
                }
            });
        }
    }

    public C18749pB0(String str, C17585nD0 c17585nD0) {
        String str2 = (String) AbstractC4980Hj5.g(str);
        this.a = str2;
        this.l = c17585nD0;
        C19349qC0 c19349qC0C = c17585nD0.c(str2);
        this.b = c19349qC0C;
        this.c = new C17567nB0(this);
        C6293Mz5 c6293Mz5A = androidx.camera.camera2.internal.compat.quirk.a.a(str, c19349qC0C);
        this.j = c6293Mz5A;
        this.k = new AB0(str, c6293Mz5A);
        this.h = new a(GD0.a(GD0.b.CLOSED));
    }

    private void q() {
        r();
    }

    private void r() {
        String str;
        int iO = o();
        if (iO == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (iO == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (iO == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (iO == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (iO != 4) {
            str = "Unknown value: " + iO;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        PI3.e("Camera2CameraInfo", "Device Level: " + str);
    }

    @Override // ir.nasim.InterfaceC14021hD0
    public int a() {
        return k(0);
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public String b() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public void c(Executor executor, JB0 jb0) {
        synchronized (this.d) {
            try {
                PA0 pa0 = this.e;
                if (pa0 != null) {
                    pa0.q(executor, jb0);
                    return;
                }
                if (this.i == null) {
                    this.i = new ArrayList();
                }
                this.i.add(new Pair(jb0, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC14021hD0
    public int d() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.LENS_FACING);
        AbstractC4980Hj5.b(num != null, "Unable to get the lens facing of the camera.");
        return AbstractC7493Ry3.a(num.intValue());
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public List e(int i) {
        Size[] sizeArrA = this.b.b().a(i);
        return sizeArrA != null ? Arrays.asList(sizeArrA) : Collections.emptyList();
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public void f(JB0 jb0) {
        synchronized (this.d) {
            try {
                PA0 pa0 = this.e;
                if (pa0 != null) {
                    pa0.P(jb0);
                    return;
                }
                List list = this.i;
                if (list == null) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == jb0) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public C6293Mz5 g() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC14623iD0
    public List h(int i) {
        Size[] sizeArrC = this.b.b().c(i);
        return sizeArrC != null ? Arrays.asList(sizeArrC) : Collections.emptyList();
    }

    @Override // ir.nasim.InterfaceC14021hD0
    public String j() {
        return o() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // ir.nasim.InterfaceC14021hD0
    public int k(int i) {
        return AbstractC22425vD0.a(AbstractC22425vD0.b(i), n(), 1 == d());
    }

    public C17567nB0 l() {
        return this.c;
    }

    public C19349qC0 m() {
        return this.b;
    }

    int n() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        AbstractC4980Hj5.g(num);
        return num.intValue();
    }

    int o() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        AbstractC4980Hj5.g(num);
        return num.intValue();
    }

    void p(PA0 pa0) {
        synchronized (this.d) {
            try {
                this.e = pa0;
                a aVar = this.g;
                if (aVar != null) {
                    aVar.s(pa0.B().d());
                }
                a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.s(this.e.z().b());
                }
                List<Pair> list = this.i;
                if (list != null) {
                    for (Pair pair : list) {
                        this.e.q((Executor) pair.second, (JB0) pair.first);
                    }
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        q();
    }

    void s(androidx.lifecycle.r rVar) {
        this.h.s(rVar);
    }
}
