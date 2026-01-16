package ir.nasim;

/* renamed from: ir.nasim.vb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22643vb1 {
    public final InterfaceC6075Mb3 a;
    private boolean b;

    public C22643vb1(InterfaceC6075Mb3 interfaceC6075Mb3) {
        AbstractC13042fc3.i(interfaceC6075Mb3, "writer");
        this.a = interfaceC6075Mb3;
        this.b = true;
    }

    public final boolean a() {
        return this.b;
    }

    public void b() {
        this.b = true;
    }

    public void c() {
        this.b = false;
    }

    public void d() {
        this.b = false;
    }

    public void e(byte b) {
        this.a.writeLong(b);
    }

    public final void f(char c) {
        this.a.a(c);
    }

    public void g(double d) {
        this.a.c(String.valueOf(d));
    }

    public void h(float f) {
        this.a.c(String.valueOf(f));
    }

    public void i(int i) {
        this.a.writeLong(i);
    }

    public void j(long j) {
        this.a.writeLong(j);
    }

    public final void k(String str) {
        AbstractC13042fc3.i(str, "v");
        this.a.c(str);
    }

    public void l(short s) {
        this.a.writeLong(s);
    }

    public void m(boolean z) {
        this.a.c(String.valueOf(z));
    }

    public void n(String str) {
        AbstractC13042fc3.i(str, "value");
        this.a.b(str);
    }

    protected final void o(boolean z) {
        this.b = z;
    }

    public void p() {
    }

    public void q() {
    }
}
