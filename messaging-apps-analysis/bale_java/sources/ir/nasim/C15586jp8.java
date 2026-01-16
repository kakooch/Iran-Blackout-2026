package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.jp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C15586jp8 extends Mp8 {
    private final Context a;
    private final InterfaceC16778lq8 b;

    C15586jp8(Context context, InterfaceC16778lq8 interfaceC16778lq8) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.a = context;
        this.b = interfaceC16778lq8;
    }

    @Override // ir.nasim.Mp8
    final Context a() {
        return this.a;
    }

    @Override // ir.nasim.Mp8
    final InterfaceC16778lq8 b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        InterfaceC16778lq8 interfaceC16778lq8;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Mp8) {
            Mp8 mp8 = (Mp8) obj;
            if (this.a.equals(mp8.a()) && ((interfaceC16778lq8 = this.b) != null ? interfaceC16778lq8.equals(mp8.b()) : mp8.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        InterfaceC16778lq8 interfaceC16778lq8 = this.b;
        return iHashCode ^ (interfaceC16778lq8 == null ? 0 : interfaceC16778lq8.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.b) + "}";
    }
}
