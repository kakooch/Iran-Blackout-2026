package ir.nasim;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ir.nasim.ss8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20953ss8 extends AbstractList implements RandomAccess, InterfaceC23996xr8 {
    private final InterfaceC23996xr8 a;

    public C20953ss8(InterfaceC23996xr8 interfaceC23996xr8) {
        this.a = interfaceC23996xr8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((com.google.android.gms.internal.measurement.S0) this.a).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C20362rs8(this);
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final List k() {
        return this.a.k();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C19753qs8(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final void w1(com.google.android.gms.internal.measurement.A0 a0) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final Object y(int i) {
        return this.a.y(i);
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final InterfaceC23996xr8 g() {
        return this;
    }
}
