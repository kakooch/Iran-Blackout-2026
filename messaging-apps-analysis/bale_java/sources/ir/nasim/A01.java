package ir.nasim;

/* loaded from: classes8.dex */
public final class A01 implements InterfaceC20295rm1 {
    public static final A01 a = new A01();

    private A01() {
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
