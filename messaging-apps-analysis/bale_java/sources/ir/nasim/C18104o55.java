package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.o55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18104o55 extends G0 implements InterfaceC9502a43 {
    private final C9514a55 a;

    public C18104o55(C9514a55 c9514a55) {
        this.a = c9514a55;
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new C18695p55(this.a.o());
    }
}
