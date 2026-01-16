package ir.nasim;

import ir.nasim.C11982ds5;

/* renamed from: ir.nasim.xT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23754xT extends C11982ds5.b {
    private final AbstractC12595es5 a;
    private final androidx.camera.core.f b;

    C23754xT(AbstractC12595es5 abstractC12595es5, androidx.camera.core.f fVar) {
        throw new NullPointerException("Null processingRequest");
    }

    @Override // ir.nasim.C11982ds5.b
    androidx.camera.core.f a() {
        return this.b;
    }

    @Override // ir.nasim.C11982ds5.b
    AbstractC12595es5 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C11982ds5.b)) {
            return false;
        }
        C11982ds5.b bVar = (C11982ds5.b) obj;
        return this.a.equals(bVar.b()) && this.b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.a + ", imageProxy=" + this.b + "}";
    }
}
