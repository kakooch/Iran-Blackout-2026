package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arr<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object a;
    private final Object b;

    arr(ars<K, V> arsVar) {
        Object[] objArr = new Object[arsVar.size()];
        Object[] objArr2 = new Object[arsVar.size()];
        asp<Map.Entry<K, V>> aspVarListIterator = arsVar.entrySet().listIterator();
        int i = 0;
        while (aspVarListIterator.hasNext()) {
            Map.Entry<K, V> next = aspVarListIterator.next();
            objArr[i] = next.getKey();
            objArr2[i] = next.getValue();
            i++;
        }
        this.a = objArr;
        this.b = objArr2;
    }

    static final arq<K, V> a(int i) {
        return new arq<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final Object readResolve() {
        Object obj = this.a;
        if (obj instanceof arx) {
            arx arxVar = (arx) obj;
            arj arjVar = (arj) this.b;
            arq arqVarA = a(arxVar.size());
            asp aspVarListIterator = arxVar.listIterator();
            asp aspVarListIterator2 = arjVar.listIterator();
            while (aspVarListIterator.hasNext()) {
                arqVarA.b(aspVarListIterator.next(), aspVarListIterator2.next());
            }
            return arqVarA.a();
        }
        Object[] objArr = (Object[]) obj;
        Object[] objArr2 = (Object[]) this.b;
        arq arqVarA2 = a(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            arqVarA2.b(objArr[i], objArr2[i]);
        }
        return arqVarA2.a();
    }
}
