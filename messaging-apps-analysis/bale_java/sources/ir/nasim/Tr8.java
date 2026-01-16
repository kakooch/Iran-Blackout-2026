package ir.nasim;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class Tr8 extends AbstractList implements Yq8, RandomAccess {
    private final Yq8 a;

    public Tr8(Yq8 yq8) {
        this.a = yq8;
    }

    @Override // ir.nasim.Yq8
    public final void A1(com.google.android.gms.internal.vision.K k) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.Yq8
    public final List d() {
        return this.a.d();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.a.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C14418hs8(this);
    }

    @Override // ir.nasim.Yq8
    public final Object l(int i) {
        return this.a.l(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new Sr8(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // ir.nasim.Yq8
    public final Yq8 g() {
        return this;
    }
}
