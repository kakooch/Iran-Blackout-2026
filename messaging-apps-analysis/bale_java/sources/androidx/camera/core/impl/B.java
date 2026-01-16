package androidx.camera.core.impl;

import androidx.camera.core.impl.B;
import androidx.camera.core.impl.v;
import ir.nasim.PI3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class B {
    private final String a;
    private final Map b = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        boolean a(b bVar);
    }

    public static final class b {
        private final v a;
        private final C b;
        private final w c;
        private final List d;
        private boolean e = false;
        private boolean f = false;

        b(v vVar, C c, w wVar, List list) {
            this.a = vVar;
            this.b = c;
            this.c = wVar;
            this.d = list;
        }

        boolean a() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b() {
            return this.e;
        }

        public List c() {
            return this.d;
        }

        public v d() {
            return this.a;
        }

        public w e() {
            return this.c;
        }

        public C f() {
            return this.b;
        }

        void g(boolean z) {
            this.f = z;
        }

        void h(boolean z) {
            this.e = z;
        }

        public String toString() {
            return "UseCaseAttachInfo{mSessionConfig=" + this.a + ", mUseCaseConfig=" + this.b + ", mStreamSpec=" + this.c + ", mCaptureTypes=" + this.d + ", mAttached=" + this.e + ", mActive=" + this.f + '}';
        }
    }

    public B(String str) {
        this.a = str;
    }

    private b k(String str, v vVar, C c, w wVar, List list) {
        b bVar = (b) this.b.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(vVar, c, wVar, list);
        this.b.put(str, bVar2);
        return bVar2;
    }

    private Collection l(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add(((b) entry.getValue()).d());
            }
        }
        return arrayList;
    }

    private Collection m(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add(((b) entry.getValue()).f());
            }
        }
        return arrayList;
    }

    private Collection n(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add((b) entry.getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(b bVar) {
        return bVar.a() && bVar.b();
    }

    public v.h e() {
        v.h hVar = new v.h();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar.a() && bVar.b()) {
                String str = (String) entry.getKey();
                hVar.b(bVar.d());
                arrayList.add(str);
            }
        }
        PI3.a("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + this.a);
        return hVar;
    }

    public Collection f() {
        return Collections.unmodifiableCollection(l(new a() { // from class: androidx.camera.core.impl.z
            @Override // androidx.camera.core.impl.B.a
            public final boolean a(B.b bVar) {
                return B.p(bVar);
            }
        }));
    }

    public v.h g() {
        v.h hVar = new v.h();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar.b()) {
                hVar.b(bVar.d());
                arrayList.add((String) entry.getKey());
            }
        }
        PI3.a("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + this.a);
        return hVar;
    }

    public Collection h() {
        return Collections.unmodifiableCollection(l(new a() { // from class: androidx.camera.core.impl.x
            @Override // androidx.camera.core.impl.B.a
            public final boolean a(B.b bVar) {
                return bVar.b();
            }
        }));
    }

    public Collection i() {
        return Collections.unmodifiableCollection(m(new a() { // from class: androidx.camera.core.impl.y
            @Override // androidx.camera.core.impl.B.a
            public final boolean a(B.b bVar) {
                return bVar.b();
            }
        }));
    }

    public Collection j() {
        return Collections.unmodifiableCollection(n(new a() { // from class: androidx.camera.core.impl.A
            @Override // androidx.camera.core.impl.B.a
            public final boolean a(B.b bVar) {
                return bVar.b();
            }
        }));
    }

    public boolean o(String str) {
        if (this.b.containsKey(str)) {
            return ((b) this.b.get(str)).b();
        }
        return false;
    }

    public void t(String str) {
        this.b.remove(str);
    }

    public void u(String str, v vVar, C c, w wVar, List list) {
        k(str, vVar, c, wVar, list).g(true);
    }

    public void v(String str, v vVar, C c, w wVar, List list) {
        k(str, vVar, c, wVar, list).h(true);
        y(str, vVar, c, wVar, list);
    }

    public void w(String str) {
        if (this.b.containsKey(str)) {
            b bVar = (b) this.b.get(str);
            bVar.h(false);
            if (bVar.a()) {
                return;
            }
            this.b.remove(str);
        }
    }

    public void x(String str) {
        if (this.b.containsKey(str)) {
            b bVar = (b) this.b.get(str);
            bVar.g(false);
            if (bVar.b()) {
                return;
            }
            this.b.remove(str);
        }
    }

    public void y(String str, v vVar, C c, w wVar, List list) {
        if (this.b.containsKey(str)) {
            b bVar = new b(vVar, c, wVar, list);
            b bVar2 = (b) this.b.get(str);
            bVar.h(bVar2.b());
            bVar.g(bVar2.a());
            this.b.put(str, bVar);
        }
    }
}
