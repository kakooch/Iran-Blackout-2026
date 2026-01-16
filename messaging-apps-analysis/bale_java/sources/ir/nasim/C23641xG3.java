package ir.nasim;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.G;
import ir.nasim.AbstractC22455vG3;
import ir.nasim.AbstractC23051wG3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: ir.nasim.xG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C23641xG3 extends AbstractC23051wG3 {
    static boolean c = false;
    private final InterfaceC18633oz3 a;
    private final c b;

    /* renamed from: ir.nasim.xG3$a */
    public static class a extends C20298rm4 implements AbstractC22455vG3.a {
        private final int l;
        private final Bundle m;
        private final AbstractC22455vG3 n;
        private InterfaceC18633oz3 o;
        private b p;
        private AbstractC22455vG3 q;

        a(int i, Bundle bundle, AbstractC22455vG3 abstractC22455vG3, AbstractC22455vG3 abstractC22455vG32) {
            this.l = i;
            this.m = bundle;
            this.n = abstractC22455vG3;
            this.q = abstractC22455vG32;
            abstractC22455vG3.q(i, this);
        }

        @Override // ir.nasim.AbstractC22455vG3.a
        public void a(AbstractC22455vG3 abstractC22455vG3, Object obj) {
            if (C23641xG3.c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                p(obj);
                return;
            }
            if (C23641xG3.c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            n(obj);
        }

        @Override // androidx.lifecycle.r
        protected void l() {
            if (C23641xG3.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.t();
        }

        @Override // androidx.lifecycle.r
        protected void m() {
            if (C23641xG3.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.u();
        }

        @Override // androidx.lifecycle.r
        public void o(QG4 qg4) {
            super.o(qg4);
            this.o = null;
            this.p = null;
        }

        @Override // ir.nasim.C20298rm4, androidx.lifecycle.r
        public void p(Object obj) {
            super.p(obj);
            AbstractC22455vG3 abstractC22455vG3 = this.q;
            if (abstractC22455vG3 != null) {
                abstractC22455vG3.r();
                this.q = null;
            }
        }

        AbstractC22455vG3 q(boolean z) {
            if (C23641xG3.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.b();
            this.n.a();
            b bVar = this.p;
            if (bVar != null) {
                o(bVar);
                if (z) {
                    bVar.d();
                }
            }
            this.n.v(this);
            if ((bVar == null || bVar.c()) && !z) {
                return this.n;
            }
            this.n.r();
            return this.q;
        }

        public void r(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                this.p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(s().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        AbstractC22455vG3 s() {
            return this.n;
        }

        void t() {
            InterfaceC18633oz3 interfaceC18633oz3 = this.o;
            b bVar = this.p;
            if (interfaceC18633oz3 == null || bVar == null) {
                return;
            }
            super.o(bVar);
            j(interfaceC18633oz3, bVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            ZA1.a(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }

        AbstractC22455vG3 u(InterfaceC18633oz3 interfaceC18633oz3, AbstractC23051wG3.a aVar) {
            b bVar = new b(this.n, aVar);
            j(interfaceC18633oz3, bVar);
            QG4 qg4 = this.p;
            if (qg4 != null) {
                o(qg4);
            }
            this.o = interfaceC18633oz3;
            this.p = bVar;
            return this.n;
        }
    }

    /* renamed from: ir.nasim.xG3$b */
    static class b implements QG4 {
        private final AbstractC22455vG3 a;
        private final AbstractC23051wG3.a b;
        private boolean c = false;

        b(AbstractC22455vG3 abstractC22455vG3, AbstractC23051wG3.a aVar) {
            this.a = abstractC22455vG3;
            this.b = aVar;
        }

        @Override // ir.nasim.QG4
        public void a(Object obj) {
            if (C23641xG3.c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.d(obj));
            }
            this.b.c(this.a, obj);
            this.c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean c() {
            return this.c;
        }

        void d() {
            if (this.c) {
                if (C23641xG3.c) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    /* renamed from: ir.nasim.xG3$c */
    static class c extends VW7 {
        private static final G.c d = new a();
        private C19409qI6 b = new C19409qI6();
        private boolean c = false;

        /* renamed from: ir.nasim.xG3$c$a */
        static class a implements G.c {
            a() {
            }

            @Override // androidx.lifecycle.G.c
            public VW7 b(Class cls) {
                return new c();
            }
        }

        c() {
        }

        static c S0(C14819iX7 c14819iX7) {
            return (c) new androidx.lifecycle.G(c14819iX7, d).b(c.class);
        }

        @Override // ir.nasim.VW7
        protected void L0() {
            super.L0();
            int iO = this.b.o();
            for (int i = 0; i < iO; i++) {
                ((a) this.b.p(i)).q(true);
            }
            this.b.c();
        }

        public void P0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.o() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.o(); i++) {
                    a aVar = (a) this.b.p(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.k(i));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.r(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void R0() {
            this.c = false;
        }

        a T0(int i) {
            return (a) this.b.f(i);
        }

        boolean U0() {
            return this.c;
        }

        void V0() {
            int iO = this.b.o();
            for (int i = 0; i < iO; i++) {
                ((a) this.b.p(i)).t();
            }
        }

        void W0(int i, a aVar) {
            this.b.l(i, aVar);
        }

        void X0() {
            this.c = true;
        }
    }

    C23641xG3(InterfaceC18633oz3 interfaceC18633oz3, C14819iX7 c14819iX7) {
        this.a = interfaceC18633oz3;
        this.b = c.S0(c14819iX7);
    }

    private AbstractC22455vG3 e(int i, Bundle bundle, AbstractC23051wG3.a aVar, AbstractC22455vG3 abstractC22455vG3) {
        try {
            this.b.X0();
            AbstractC22455vG3 abstractC22455vG3B = aVar.b(i, bundle);
            if (abstractC22455vG3B == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (abstractC22455vG3B.getClass().isMemberClass() && !Modifier.isStatic(abstractC22455vG3B.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + abstractC22455vG3B);
            }
            a aVar2 = new a(i, bundle, abstractC22455vG3B, abstractC22455vG3);
            if (c) {
                Log.v("LoaderManager", "  Created new loader " + aVar2);
            }
            this.b.W0(i, aVar2);
            this.b.R0();
            return aVar2.u(this.a, aVar);
        } catch (Throwable th) {
            this.b.R0();
            throw th;
        }
    }

    @Override // ir.nasim.AbstractC23051wG3
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.P0(str, fileDescriptor, printWriter, strArr);
    }

    @Override // ir.nasim.AbstractC23051wG3
    public AbstractC22455vG3 c(int i, Bundle bundle, AbstractC23051wG3.a aVar) {
        if (this.b.U0()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a aVarT0 = this.b.T0(i);
        if (c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarT0 == null) {
            return e(i, bundle, aVar, null);
        }
        if (c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarT0);
        }
        return aVarT0.u(this.a, aVar);
    }

    @Override // ir.nasim.AbstractC23051wG3
    public void d() {
        this.b.V0();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        ZA1.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
