package androidMessenger.utilites;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import j$.util.Map;
import j$.util.function.Function;

/* loaded from: classes.dex */
public class RBiMap<T, K> {
    private final Object syncLock = new Object();
    private BiMap<T, K> map = HashBiMap.create();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$putId$0(Object obj, Object obj2) {
        return obj;
    }

    public K putId(T t, final K k) {
        K k2;
        if (t == null || k == null) {
            FirebaseEventSender.setKey("IdStorage", "null " + t + " " + k);
            return null;
        }
        try {
            synchronized (this.syncLock) {
                k2 = (K) Map.EL.computeIfAbsent(this.map, t, new Function() { // from class: androidMessenger.utilites.RBiMap$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Function
                    public /* synthetic */ Function andThen(Function function) {
                        return Function.CC.$default$andThen(this, function);
                    }

                    @Override // j$.util.function.Function
                    public final Object apply(Object obj) {
                        return RBiMap.lambda$putId$0(k, obj);
                    }

                    @Override // j$.util.function.Function
                    public /* synthetic */ Function compose(Function function) {
                        return Function.CC.$default$compose(this, function);
                    }
                });
            }
            return k2;
        } catch (Exception e) {
            MyLog.handleExceptionThrowOnDebug(e);
            FirebaseEventSender.setKey("IdStorage", "exception " + t + " " + k + " " + e.getMessage());
            return null;
        }
    }

    public K getValue(T t) {
        K k;
        if (t == null) {
            return null;
        }
        synchronized (this.syncLock) {
            k = (K) Map.EL.getOrDefault(this.map, t, null);
        }
        return k;
    }

    public T getId(K k) {
        T t;
        if (k == null) {
            return null;
        }
        synchronized (this.syncLock) {
            t = (T) Map.EL.getOrDefault(this.map.inverse(), k, null);
        }
        return t;
    }
}
