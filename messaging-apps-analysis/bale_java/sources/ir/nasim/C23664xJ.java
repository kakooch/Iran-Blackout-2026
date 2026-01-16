package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.xJ, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23664xJ extends ArrayList implements InterfaceC9204Yx7 {
    public C23664xJ(int i) {
        super(i);
    }

    public /* bridge */ int C(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return super.lastIndexOf(interfaceC9438Zx7);
    }

    public /* bridge */ boolean D(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return super.remove(interfaceC9438Zx7);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof InterfaceC9438Zx7) {
            return f((InterfaceC9438Zx7) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return super.contains(interfaceC9438Zx7);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof InterfaceC9438Zx7) {
            return w((InterfaceC9438Zx7) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof InterfaceC9438Zx7) {
            return C((InterfaceC9438Zx7) obj);
        }
        return -1;
    }

    public /* bridge */ int r() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof InterfaceC9438Zx7) {
            return D((InterfaceC9438Zx7) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return r();
    }

    public /* bridge */ int w(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return super.indexOf(interfaceC9438Zx7);
    }
}
