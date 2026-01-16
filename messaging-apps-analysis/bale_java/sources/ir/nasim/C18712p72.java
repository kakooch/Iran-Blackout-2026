package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import java.io.Serializable;

/* renamed from: ir.nasim.p72, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18712p72 implements InterfaceC11938do1, Serializable {
    public static final C18712p72 a = new C18712p72();

    private C18712p72() {
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        return interfaceC11938do1;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        AbstractC13042fc3.i(cVar, "key");
        return null;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "operation");
        return obj;
    }

    public int hashCode() {
        return 0;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        AbstractC13042fc3.i(cVar, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
