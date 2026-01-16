package ir.nasim;

/* renamed from: ir.nasim.Oi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6637Oi3 {
    private final EnumC7263Qy7 a;
    private final EnumC7349Ri3 b;
    private final boolean c;
    private final InterfaceC22882vy7 d;

    public C6637Oi3(EnumC7263Qy7 enumC7263Qy7, EnumC7349Ri3 enumC7349Ri3, boolean z, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(enumC7263Qy7, "howThisTypeIsUsed");
        AbstractC13042fc3.i(enumC7349Ri3, "flexibility");
        this.a = enumC7263Qy7;
        this.b = enumC7349Ri3;
        this.c = z;
        this.d = interfaceC22882vy7;
    }

    public static /* synthetic */ C6637Oi3 b(C6637Oi3 c6637Oi3, EnumC7263Qy7 enumC7263Qy7, EnumC7349Ri3 enumC7349Ri3, boolean z, InterfaceC22882vy7 interfaceC22882vy7, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC7263Qy7 = c6637Oi3.a;
        }
        if ((i & 2) != 0) {
            enumC7349Ri3 = c6637Oi3.b;
        }
        if ((i & 4) != 0) {
            z = c6637Oi3.c;
        }
        if ((i & 8) != 0) {
            interfaceC22882vy7 = c6637Oi3.d;
        }
        return c6637Oi3.a(enumC7263Qy7, enumC7349Ri3, z, interfaceC22882vy7);
    }

    public final C6637Oi3 a(EnumC7263Qy7 enumC7263Qy7, EnumC7349Ri3 enumC7349Ri3, boolean z, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(enumC7263Qy7, "howThisTypeIsUsed");
        AbstractC13042fc3.i(enumC7349Ri3, "flexibility");
        return new C6637Oi3(enumC7263Qy7, enumC7349Ri3, z, interfaceC22882vy7);
    }

    public final EnumC7349Ri3 c() {
        return this.b;
    }

    public final EnumC7263Qy7 d() {
        return this.a;
    }

    public final InterfaceC22882vy7 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6637Oi3)) {
            return false;
        }
        C6637Oi3 c6637Oi3 = (C6637Oi3) obj;
        return this.a == c6637Oi3.a && this.b == c6637Oi3.b && this.c == c6637Oi3.c && AbstractC13042fc3.d(this.d, c6637Oi3.d);
    }

    public final boolean f() {
        return this.c;
    }

    public final C6637Oi3 g(EnumC7349Ri3 enumC7349Ri3) {
        AbstractC13042fc3.i(enumC7349Ri3, "flexibility");
        return b(this, null, enumC7349Ri3, false, null, 13, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        InterfaceC22882vy7 interfaceC22882vy7 = this.d;
        return i2 + (interfaceC22882vy7 == null ? 0 : interfaceC22882vy7.hashCode());
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.a + ", flexibility=" + this.b + ", isForAnnotationParameter=" + this.c + ", upperBoundOfTypeParameter=" + this.d + ')';
    }

    public /* synthetic */ C6637Oi3(EnumC7263Qy7 enumC7263Qy7, EnumC7349Ri3 enumC7349Ri3, boolean z, InterfaceC22882vy7 interfaceC22882vy7, int i, ED1 ed1) {
        this(enumC7263Qy7, (i & 2) != 0 ? EnumC7349Ri3.INFLEXIBLE : enumC7349Ri3, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : interfaceC22882vy7);
    }
}
