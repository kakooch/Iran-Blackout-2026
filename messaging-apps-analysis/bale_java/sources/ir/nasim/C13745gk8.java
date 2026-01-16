package ir.nasim;

import com.google.android.gms.common.api.internal.C2060d;

/* renamed from: ir.nasim.gk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13745gk8 implements InterfaceC13525gN5, Fl8 {
    private final InterfaceC12518ek8 a;
    private C2060d b;
    private boolean c = true;
    final /* synthetic */ C14946ik8 d;

    C13745gk8(C14946ik8 c14946ik8, C2060d c2060d, InterfaceC12518ek8 interfaceC12518ek8) {
        this.d = c14946ik8;
        this.b = c2060d;
        this.a = interfaceC12518ek8;
    }

    @Override // ir.nasim.Fl8
    public final synchronized void a(C2060d c2060d) {
        C2060d c2060d2 = this.b;
        if (c2060d2 != c2060d) {
            c2060d2.a();
            this.b = c2060d;
        }
    }

    @Override // ir.nasim.InterfaceC13525gN5
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) {
        C2060d.a aVarB;
        boolean z;
        com.google.android.gms.internal.location.i iVar = (com.google.android.gms.internal.location.i) obj;
        C4982Hj7 c4982Hj7 = (C4982Hj7) obj2;
        synchronized (this) {
            aVarB = this.b.b();
            z = this.c;
            this.b.a();
        }
        if (aVarB == null) {
            c4982Hj7.c(Boolean.FALSE);
        } else {
            this.a.a(iVar, aVarB, z, c4982Hj7);
        }
    }

    @Override // ir.nasim.Fl8
    public final void c() {
        C2060d.a aVarB;
        synchronized (this) {
            this.c = false;
            aVarB = this.b.b();
        }
        if (aVarB != null) {
            this.d.n(aVarB, 2441);
        }
    }

    @Override // ir.nasim.Fl8
    public final synchronized C2060d zza() {
        return this.b;
    }
}
