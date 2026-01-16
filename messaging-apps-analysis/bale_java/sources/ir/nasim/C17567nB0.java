package ir.nasim;

/* renamed from: ir.nasim.nB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17567nB0 {
    private C18749pB0 a;

    public C17567nB0(C18749pB0 c18749pB0) {
        this.a = c18749pB0;
    }

    public static C17567nB0 a(InterfaceC14021hD0 interfaceC14021hD0) {
        InterfaceC14623iD0 interfaceC14623iD0I = ((InterfaceC14623iD0) interfaceC14021hD0).i();
        AbstractC4980Hj5.b(interfaceC14623iD0I instanceof C18749pB0, "CameraInfo doesn't contain Camera2 implementation.");
        return ((C18749pB0) interfaceC14623iD0I).l();
    }

    public String b() {
        return this.a.b();
    }
}
