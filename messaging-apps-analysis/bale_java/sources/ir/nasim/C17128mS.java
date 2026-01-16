package ir.nasim;

import ir.nasim.InterfaceC13330g27;

/* renamed from: ir.nasim.mS, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17128mS implements InterfaceC13330g27.c {
    private final InterfaceC13330g27.c a;
    private final C15946kS b;

    public C17128mS(InterfaceC13330g27.c cVar, C15946kS c15946kS) {
        AbstractC13042fc3.i(cVar, "delegate");
        AbstractC13042fc3.i(c15946kS, "autoCloser");
        this.a = cVar;
        this.b = c15946kS;
    }

    @Override // ir.nasim.InterfaceC13330g27.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C16537lS a(InterfaceC13330g27.b bVar) {
        AbstractC13042fc3.i(bVar, "configuration");
        return new C16537lS(this.a.a(bVar), this.b);
    }
}
