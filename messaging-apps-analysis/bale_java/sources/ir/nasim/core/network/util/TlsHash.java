package ir.nasim.core.network.util;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import java.util.ArrayList;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0003j\b\u0012\u0004\u0012\u00020\u0002`\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lir/nasim/core/network/util/TlsHash;", "Lkotlin/collections/ArrayList;", "Lir/nasim/core/network/util/TlsHashItem;", "Ljava/util/ArrayList;", "<init>", "()V", "base_productionRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final class TlsHash extends ArrayList<TlsHashItem> {
    public /* bridge */ boolean contains(TlsHashItem tlsHashItem) {
        return super.contains((Object) tlsHashItem);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(TlsHashItem tlsHashItem) {
        return super.indexOf((Object) tlsHashItem);
    }

    public /* bridge */ int lastIndexOf(TlsHashItem tlsHashItem) {
        return super.lastIndexOf((Object) tlsHashItem);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ TlsHashItem remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ TlsHashItem removeAt(int i) {
        return (TlsHashItem) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof TlsHashItem) {
            return contains((TlsHashItem) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof TlsHashItem) {
            return indexOf((TlsHashItem) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof TlsHashItem) {
            return lastIndexOf((TlsHashItem) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(TlsHashItem tlsHashItem) {
        return super.remove((Object) tlsHashItem);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof TlsHashItem) {
            return remove((TlsHashItem) obj);
        }
        return false;
    }
}
