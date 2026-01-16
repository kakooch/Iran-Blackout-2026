package ir.nasim;

/* renamed from: ir.nasim.Ux5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8193Ux5 {

    /* renamed from: ir.nasim.Ux5$a */
    class a implements InterfaceC7486Rx5 {
        final /* synthetic */ InterfaceC7720Sx5 a;

        a(InterfaceC7720Sx5 interfaceC7720Sx5) {
            this.a = interfaceC7720Sx5;
        }

        @Override // ir.nasim.InterfaceC7720Sx5
        public Object get() {
            return this.a.get();
        }
    }

    public static InterfaceC7486Rx5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC4746Gj5.b(interfaceC7720Sx5);
        return new a(interfaceC7720Sx5);
    }
}
