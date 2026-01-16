package ir.nasim;

/* renamed from: ir.nasim.ml1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17312ml1 {
    private final androidx.compose.animation.h a;
    private final androidx.compose.animation.j b;
    private final InterfaceC14354hm4 c;
    private InterfaceC10195bE6 d;

    public C17312ml1(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar, float f, InterfaceC10195bE6 interfaceC10195bE6) {
        this.a = hVar;
        this.b = jVar;
        this.c = AbstractC4326Eq5.a(f);
        this.d = interfaceC10195bE6;
    }

    public final androidx.compose.animation.j a() {
        return this.b;
    }

    public final InterfaceC10195bE6 b() {
        return this.d;
    }

    public final androidx.compose.animation.h c() {
        return this.a;
    }

    public final float d() {
        return this.c.a();
    }

    public /* synthetic */ C17312ml1(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar, float f, InterfaceC10195bE6 interfaceC10195bE6, int i, ED1 ed1) {
        this(hVar, jVar, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? androidx.compose.animation.a.c(false, null, 3, null) : interfaceC10195bE6);
    }
}
