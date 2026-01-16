package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.m55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16922m55 extends U1 implements InterfaceC15137j43 {
    private final C9514a55 b;

    public C16922m55(C9514a55 c9514a55) {
        this.b = c9514a55;
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean contains(Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.b.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C17513n55(this.b.o());
    }
}
