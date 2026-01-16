package ir.nasim;

/* renamed from: ir.nasim.Aq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C3386Aq6 extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3386Aq6(String str) {
        super(str);
        AbstractC13042fc3.i(str, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3386Aq6(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32) {
        this("Serializer for " + interfaceC11299cm32 + " already registered in the scope of " + interfaceC11299cm3);
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm32, "concreteClass");
    }
}
