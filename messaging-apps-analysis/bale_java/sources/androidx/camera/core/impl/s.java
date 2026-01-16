package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class s implements C, o, u {
    private final r H;

    public s(r rVar) {
        this.H = rVar;
    }

    @Override // androidx.camera.core.impl.u
    public j getConfig() {
        return this.H;
    }

    @Override // androidx.camera.core.impl.n
    public int getInputFormat() {
        return ((Integer) a(n.h)).intValue();
    }
}
