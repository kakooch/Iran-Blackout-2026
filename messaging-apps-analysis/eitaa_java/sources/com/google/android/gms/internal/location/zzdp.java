package com.google.android.gms.internal.location;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes.dex */
public abstract class zzdp extends AbstractCollection implements Serializable, Collection {
    private static final Object[] zza = new Object[0];

    zzdp() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return S1.v(a.D(this), true);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    @Deprecated
    public final boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Collection.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public final Object[] toArray() {
        return toArray(zza);
    }

    int zza(Object[] objArr, int i) {
        throw null;
    }

    int zzb() {
        throw null;
    }

    int zzc() {
        throw null;
    }

    public zzds zzd() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public abstract zzdu iterator();

    abstract boolean zzf();

    @CheckForNull
    Object[] zzg() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        int length = objArr.length;
        if (length < size) {
            Object[] objArrZzg = zzg();
            if (objArrZzg != null) {
                return Arrays.copyOfRange(objArrZzg, zzc(), zzb(), objArr.getClass());
            }
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        } else if (length > size) {
            objArr[size] = null;
        }
        zza(objArr, 0);
        return objArr;
    }
}
