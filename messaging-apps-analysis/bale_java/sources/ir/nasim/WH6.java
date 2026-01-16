package ir.nasim;

/* loaded from: classes2.dex */
public final class WH6 extends AbstractC22144uk2 {
    private final AbstractC10086b33 a;
    private final String b;
    private final EnumC21699tz1 c;

    public WH6(AbstractC10086b33 abstractC10086b33, String str, EnumC21699tz1 enumC21699tz1) {
        super(null);
        this.a = abstractC10086b33;
        this.b = str;
        this.c = enumC21699tz1;
    }

    public final EnumC21699tz1 a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final AbstractC10086b33 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WH6) {
            WH6 wh6 = (WH6) obj;
            if (AbstractC13042fc3.d(this.a, wh6.a) && AbstractC13042fc3.d(this.b, wh6.b) && this.c == wh6.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.c.hashCode();
    }
}
