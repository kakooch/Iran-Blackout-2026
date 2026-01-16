package ir.nasim;

/* renamed from: ir.nasim.xP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23718xP extends AbstractC20521s90 {
    private final Integer a;
    private final boolean b;
    private final boolean c;

    public /* synthetic */ C23718xP(Integer num, boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? Integer.valueOf(EnumC24299yO.d.j()) : num, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2);
    }

    @Override // ir.nasim.AbstractC20521s90
    public Integer a() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC20521s90
    public boolean b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC20521s90
    public boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23718xP)) {
            return false;
        }
        C23718xP c23718xP = (C23718xP) obj;
        return AbstractC13042fc3.d(this.a, c23718xP.a) && this.b == c23718xP.b && this.c == c23718xP.c;
    }

    public int hashCode() {
        Integer num = this.a;
        return ((((num == null ? 0 : num.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "AudioTrackPublishDefaults(audioBitrate=" + this.a + ", dtx=" + this.b + ", red=" + this.c + ')';
    }

    public C23718xP(Integer num, boolean z, boolean z2) {
        this.a = num;
        this.b = z;
        this.c = z2;
    }
}
