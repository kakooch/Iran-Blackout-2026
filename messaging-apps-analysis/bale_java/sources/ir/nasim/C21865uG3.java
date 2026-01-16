package ir.nasim;

/* renamed from: ir.nasim.uG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21865uG3 extends AbstractC9998au2 {
    private final InterfaceC9447Zy7 h;

    public C21865uG3(InterfaceC9447Zy7 interfaceC9447Zy7) {
        super(true, null);
        this.h = interfaceC9447Zy7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C21865uG3) && AbstractC13042fc3.d(this.h, ((C21865uG3) obj).h);
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    public final InterfaceC9447Zy7 o() {
        return this.h;
    }

    public String toString() {
        return "LoadedFontFamily(typeface=" + this.h + ')';
    }
}
