package ir.nasim;

import ir.nasim.UK6;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.nV2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17749nV2 extends C13060fe1 implements InterfaceC17844nf2 {
    protected final UK6 j0;
    final UK6.e k0;
    protected ArrayList l0;
    private C18931pV2 m0;

    public C17749nV2(UK6 uk6, UK6.e eVar) {
        super(uk6);
        this.l0 = new ArrayList();
        this.j0 = uk6;
        this.k0 = eVar;
    }

    public C17749nV2 W(Object... objArr) {
        Collections.addAll(this.l0, objArr);
        return this;
    }

    public C18931pV2 X() {
        return this.m0;
    }

    @Override // ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5
    public C16651le1 a() {
        return X();
    }

    @Override // ir.nasim.C13060fe1, ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
    }
}
