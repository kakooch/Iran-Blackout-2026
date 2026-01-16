package ir.nasim;

import ir.nasim.C9475a16;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.m96, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16963m96 implements InterfaceC20295rm1, InterfaceC23369wo1 {
    private static final a b = new a(null);
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C16963m96.class, Object.class, "result");
    private final InterfaceC20295rm1 a;
    private volatile Object result;

    /* renamed from: ir.nasim.m96$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C16963m96(InterfaceC20295rm1 interfaceC20295rm1, Object obj) {
        AbstractC13042fc3.i(interfaceC20295rm1, "delegate");
        this.a = interfaceC20295rm1;
        this.result = obj;
    }

    public final Object a() {
        Object obj = this.result;
        EnumC22773vo1 enumC22773vo1 = EnumC22773vo1.b;
        if (obj == enumC22773vo1) {
            if (F1.a(c, this, enumC22773vo1, AbstractC14862ic3.e())) {
                return AbstractC14862ic3.e();
            }
            obj = this.result;
        }
        if (obj == EnumC22773vo1.c) {
            return AbstractC14862ic3.e();
        }
        if (obj instanceof C9475a16.b) {
            throw ((C9475a16.b) obj).a;
        }
        return obj;
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.a;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return this.a.getContext();
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            EnumC22773vo1 enumC22773vo1 = EnumC22773vo1.b;
            if (obj2 == enumC22773vo1) {
                if (F1.a(c, this, enumC22773vo1, obj)) {
                    return;
                }
            } else {
                if (obj2 != AbstractC14862ic3.e()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (F1.a(c, this, AbstractC14862ic3.e(), EnumC22773vo1.c)) {
                    this.a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C16963m96(InterfaceC20295rm1 interfaceC20295rm1) {
        this(interfaceC20295rm1, EnumC22773vo1.b);
        AbstractC13042fc3.i(interfaceC20295rm1, "delegate");
    }
}
