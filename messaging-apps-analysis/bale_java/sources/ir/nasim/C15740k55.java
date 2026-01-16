package ir.nasim;

import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.k55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15740k55 extends U1 implements InterfaceC15137j43 {
    private final C9514a55 b;

    public C15740k55(C9514a55 c9514a55) {
        this.b = c9514a55;
    }

    @Override // ir.nasim.G0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return f((Map.Entry) obj);
        }
        return false;
    }

    public boolean f(Map.Entry entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object obj = this.b.get(entry.getKey());
        return obj != null ? AbstractC13042fc3.d(obj, entry.getValue()) : entry.getValue() == null && this.b.containsKey(entry.getKey());
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.b.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C16331l55(this.b.o());
    }
}
