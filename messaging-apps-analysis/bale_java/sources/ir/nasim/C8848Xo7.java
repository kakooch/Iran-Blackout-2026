package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.Xo7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8848Xo7 implements InterfaceC11938do1.c {
    private final ThreadLocal a;

    public C8848Xo7(ThreadLocal threadLocal) {
        this.a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C8848Xo7) && AbstractC13042fc3.d(this.a, ((C8848Xo7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ')';
    }
}
