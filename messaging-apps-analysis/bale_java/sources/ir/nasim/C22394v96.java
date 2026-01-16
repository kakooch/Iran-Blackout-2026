package ir.nasim;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.v96, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C22394v96 implements InterfaceC9173Yu3, Serializable {
    public static final a d = new a(null);
    private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(C22394v96.class, Object.class, "b");
    private volatile SA2 a;
    private volatile Object b;
    private final Object c;

    /* renamed from: ir.nasim.v96$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22394v96(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "initializer");
        this.a = sa2;
        C17565nA7 c17565nA7 = C17565nA7.a;
        this.b = c17565nA7;
        this.c = c17565nA7;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public Object getValue() {
        Object obj = this.b;
        C17565nA7 c17565nA7 = C17565nA7.a;
        if (obj != c17565nA7) {
            return obj;
        }
        SA2 sa2 = this.a;
        if (sa2 != null) {
            Object objInvoke = sa2.invoke();
            if (F1.a(e, this, c17565nA7, objInvoke)) {
                this.a = null;
                return objInvoke;
            }
        }
        return this.b;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public boolean isInitialized() {
        return this.b != C17565nA7.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
