package ir.nasim;

/* renamed from: ir.nasim.Wx7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C8663Wx7 {
    private final AbstractC4099Dr3 a;
    private final C9876ai3 b;
    private final InterfaceC22882vy7 c;
    private final boolean d;

    public C8663Wx7(AbstractC4099Dr3 abstractC4099Dr3, C9876ai3 c9876ai3, InterfaceC22882vy7 interfaceC22882vy7, boolean z) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        this.a = abstractC4099Dr3;
        this.b = c9876ai3;
        this.c = interfaceC22882vy7;
        this.d = z;
    }

    public final AbstractC4099Dr3 a() {
        return this.a;
    }

    public final C9876ai3 b() {
        return this.b;
    }

    public final InterfaceC22882vy7 c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final AbstractC4099Dr3 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8663Wx7)) {
            return false;
        }
        C8663Wx7 c8663Wx7 = (C8663Wx7) obj;
        return AbstractC13042fc3.d(this.a, c8663Wx7.a) && AbstractC13042fc3.d(this.b, c8663Wx7.b) && AbstractC13042fc3.d(this.c, c8663Wx7.c) && this.d == c8663Wx7.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C9876ai3 c9876ai3 = this.b;
        int iHashCode2 = (iHashCode + (c9876ai3 == null ? 0 : c9876ai3.hashCode())) * 31;
        InterfaceC22882vy7 interfaceC22882vy7 = this.c;
        int iHashCode3 = (iHashCode2 + (interfaceC22882vy7 != null ? interfaceC22882vy7.hashCode() : 0)) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.a + ", defaultQualifiers=" + this.b + ", typeParameterForArgument=" + this.c + ", isFromStarProjection=" + this.d + ')';
    }
}
