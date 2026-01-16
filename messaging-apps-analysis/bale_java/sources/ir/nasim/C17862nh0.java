package ir.nasim;

/* renamed from: ir.nasim.nh0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C17862nh0 extends AbstractC17271mh0 {
    private final InterfaceC15498jh0[] a;
    private int b = -1;
    private int c = -1;
    private boolean d = false;

    public C17862nh0(InterfaceC15498jh0... interfaceC15498jh0Arr) {
        this.a = interfaceC15498jh0Arr;
    }

    @Override // ir.nasim.AbstractC17271mh0
    public AbstractC17271mh0 a(int i) {
        this.c = i;
        return this;
    }

    public InterfaceC15498jh0[] d() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public boolean g() {
        return this.d;
    }
}
