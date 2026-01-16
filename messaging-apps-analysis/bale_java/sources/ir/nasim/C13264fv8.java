package ir.nasim;

/* renamed from: ir.nasim.fv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13264fv8 extends AbstractC24616yu8 {
    private final Iu8 b = new Iu8();

    C13264fv8() {
    }

    @Override // ir.nasim.AbstractC24616yu8
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.b.a(th, true).add(th2);
    }
}
