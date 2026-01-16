package ir.nasim;

/* renamed from: ir.nasim.Dj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC4031Dj7 extends InterfaceC7645Sp2 {
    static /* synthetic */ Object c(InterfaceC4031Dj7 interfaceC4031Dj7, InterfaceC8748Xd6 interfaceC8748Xd6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        return interfaceC4031Dj7.b(interfaceC8748Xd6, f, AbstractC4265Ej7.a, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC7645Sp2
    default Object a(InterfaceC8748Xd6 interfaceC8748Xd6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        return c(this, interfaceC8748Xd6, f, interfaceC20295rm1);
    }

    Object b(InterfaceC8748Xd6 interfaceC8748Xd6, float f, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1);
}
