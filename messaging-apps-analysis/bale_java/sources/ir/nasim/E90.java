package ir.nasim;

import ir.nasim.C9475a16;
import java.io.Serializable;

/* loaded from: classes8.dex */
public abstract class E90 implements InterfaceC20295rm1, InterfaceC23369wo1, Serializable {
    private final InterfaceC20295rm1 completion;

    public E90(InterfaceC20295rm1 interfaceC20295rm1) {
        this.completion = interfaceC20295rm1;
    }

    public InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.i(interfaceC20295rm1, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.completion;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    public final InterfaceC20295rm1 getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return TA1.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    @Override // ir.nasim.InterfaceC20295rm1
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        InterfaceC20295rm1 interfaceC20295rm1 = this;
        while (true) {
            WA1.b(interfaceC20295rm1);
            E90 e90 = (E90) interfaceC20295rm1;
            InterfaceC20295rm1 interfaceC20295rm12 = e90.completion;
            AbstractC13042fc3.f(interfaceC20295rm12);
            try {
                objInvokeSuspend = e90.invokeSuspend(obj);
            } catch (Throwable th) {
                C9475a16.a aVar = C9475a16.b;
                obj = C9475a16.b(AbstractC10685c16.a(th));
            }
            if (objInvokeSuspend == AbstractC14862ic3.e()) {
                return;
            }
            obj = C9475a16.b(objInvokeSuspend);
            e90.releaseIntercepted();
            if (!(interfaceC20295rm12 instanceof E90)) {
                interfaceC20295rm12.resumeWith(obj);
                return;
            }
            interfaceC20295rm1 = interfaceC20295rm12;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.i(interfaceC20295rm1, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    protected void releaseIntercepted() {
    }
}
