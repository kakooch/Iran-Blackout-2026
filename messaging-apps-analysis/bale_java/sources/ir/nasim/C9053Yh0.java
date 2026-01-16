package ir.nasim;

/* renamed from: ir.nasim.Yh0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C9053Yh0 {
    private Y03 a;
    private UE0 b;
    private C20576sF0 c;
    private V05 d;

    public C9053Yh0(Y03 y03, UE0 ue0, C20576sF0 c20576sF0, V05 v05) {
        this.a = y03;
        this.b = ue0;
        this.c = c20576sF0;
        this.d = v05;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9053Yh0)) {
            return false;
        }
        C9053Yh0 c9053Yh0 = (C9053Yh0) obj;
        return AbstractC13042fc3.d(this.a, c9053Yh0.a) && AbstractC13042fc3.d(this.b, c9053Yh0.b) && AbstractC13042fc3.d(this.c, c9053Yh0.c) && AbstractC13042fc3.d(this.d, c9053Yh0.d);
    }

    public final V05 g() {
        V05 v05 = this.d;
        if (v05 != null) {
            return v05;
        }
        V05 v05A = AbstractC21611tq.a();
        this.d = v05A;
        return v05A;
    }

    public int hashCode() {
        Y03 y03 = this.a;
        int iHashCode = (y03 == null ? 0 : y03.hashCode()) * 31;
        UE0 ue0 = this.b;
        int iHashCode2 = (iHashCode + (ue0 == null ? 0 : ue0.hashCode())) * 31;
        C20576sF0 c20576sF0 = this.c;
        int iHashCode3 = (iHashCode2 + (c20576sF0 == null ? 0 : c20576sF0.hashCode())) * 31;
        V05 v05 = this.d;
        return iHashCode3 + (v05 != null ? v05.hashCode() : 0);
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.a + ", canvas=" + this.b + ", canvasDrawScope=" + this.c + ", borderPath=" + this.d + ')';
    }

    public /* synthetic */ C9053Yh0(Y03 y03, UE0 ue0, C20576sF0 c20576sF0, V05 v05, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : y03, (i & 2) != 0 ? null : ue0, (i & 4) != 0 ? null : c20576sF0, (i & 8) != 0 ? null : v05);
    }
}
