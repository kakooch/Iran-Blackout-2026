package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Wt6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8626Wt6 {
    private final c a;

    /* renamed from: ir.nasim.Wt6$b */
    private static final class b implements c {
        private final List a;
        private final CameraCaptureSession.StateCallback b;
        private final Executor c;
        private final int d;
        private C13987h93 e = null;
        private CaptureRequest f = null;

        b(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.d = i;
            this.a = Collections.unmodifiableList(new ArrayList(list));
            this.b = stateCallback;
            this.c = executor;
        }

        @Override // ir.nasim.C8626Wt6.c
        public C13987h93 a() {
            return this.e;
        }

        @Override // ir.nasim.C8626Wt6.c
        public Executor b() {
            return this.c;
        }

        @Override // ir.nasim.C8626Wt6.c
        public CameraCaptureSession.StateCallback c() {
            return this.b;
        }

        @Override // ir.nasim.C8626Wt6.c
        public void d(C13987h93 c13987h93) {
            if (this.d == 1) {
                throw new UnsupportedOperationException("Method not supported for high speed session types");
            }
            this.e = c13987h93;
        }

        @Override // ir.nasim.C8626Wt6.c
        public List e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Objects.equals(this.e, bVar.e) && this.d == bVar.d && this.a.size() == bVar.a.size()) {
                    for (int i = 0; i < this.a.size(); i++) {
                        if (!((C15315jN4) this.a.get(i)).equals(bVar.a.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // ir.nasim.C8626Wt6.c
        public Object f() {
            return null;
        }

        @Override // ir.nasim.C8626Wt6.c
        public int g() {
            return this.d;
        }

        @Override // ir.nasim.C8626Wt6.c
        public void h(CaptureRequest captureRequest) {
            this.f = captureRequest;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            C13987h93 c13987h93 = this.e;
            int iHashCode2 = (c13987h93 == null ? 0 : c13987h93.hashCode()) ^ i;
            return this.d ^ ((iHashCode2 << 5) - iHashCode2);
        }
    }

    /* renamed from: ir.nasim.Wt6$c */
    private interface c {
        C13987h93 a();

        Executor b();

        CameraCaptureSession.StateCallback c();

        void d(C13987h93 c13987h93);

        List e();

        Object f();

        int g();

        void h(CaptureRequest captureRequest);
    }

    public C8626Wt6(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.a = new b(i, list, executor, stateCallback);
        } else {
            this.a = new a(i, list, executor, stateCallback);
        }
    }

    public static List h(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) ((C15315jN4) it.next()).i());
        }
        return arrayList;
    }

    static List i(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(C15315jN4.j((OutputConfiguration) it.next()));
        }
        return arrayList;
    }

    public Executor a() {
        return this.a.b();
    }

    public C13987h93 b() {
        return this.a.a();
    }

    public List c() {
        return this.a.e();
    }

    public int d() {
        return this.a.g();
    }

    public CameraCaptureSession.StateCallback e() {
        return this.a.c();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8626Wt6) {
            return this.a.equals(((C8626Wt6) obj).a);
        }
        return false;
    }

    public void f(C13987h93 c13987h93) {
        this.a.d(c13987h93);
    }

    public void g(CaptureRequest captureRequest) {
        this.a.h(captureRequest);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object j() {
        return this.a.f();
    }

    /* renamed from: ir.nasim.Wt6$a */
    private static final class a implements c {
        private final SessionConfiguration a;
        private final List b;

        a(Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.a = sessionConfiguration;
            this.b = Collections.unmodifiableList(C8626Wt6.i(sessionConfiguration.getOutputConfigurations()));
        }

        @Override // ir.nasim.C8626Wt6.c
        public C13987h93 a() {
            return C13987h93.b(this.a.getInputConfiguration());
        }

        @Override // ir.nasim.C8626Wt6.c
        public Executor b() {
            return this.a.getExecutor();
        }

        @Override // ir.nasim.C8626Wt6.c
        public CameraCaptureSession.StateCallback c() {
            return this.a.getStateCallback();
        }

        @Override // ir.nasim.C8626Wt6.c
        public void d(C13987h93 c13987h93) {
            this.a.setInputConfiguration((InputConfiguration) c13987h93.a());
        }

        @Override // ir.nasim.C8626Wt6.c
        public List e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Objects.equals(this.a, ((a) obj).a);
            }
            return false;
        }

        @Override // ir.nasim.C8626Wt6.c
        public Object f() {
            return this.a;
        }

        @Override // ir.nasim.C8626Wt6.c
        public int g() {
            return this.a.getSessionType();
        }

        @Override // ir.nasim.C8626Wt6.c
        public void h(CaptureRequest captureRequest) {
            this.a.setSessionParameters(captureRequest);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        a(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i, C8626Wt6.h(list), executor, stateCallback));
        }
    }
}
