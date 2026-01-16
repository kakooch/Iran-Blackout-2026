package ir.nasim;

/* loaded from: classes.dex */
public class X22 implements InterfaceC25043ze1 {
    private InterfaceC25043ze1 a;

    public void a(InterfaceC25043ze1 interfaceC25043ze1) {
        this.a = interfaceC25043ze1;
    }

    @Override // ir.nasim.InterfaceC25043ze1
    public void accept(Object obj) {
        AbstractC13042fc3.g(this.a, "Listener is not set.");
        this.a.accept(obj);
    }
}
