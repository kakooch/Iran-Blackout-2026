package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Unexpected interfaces in signature: [com.google.ads.interactivemedia.v3.internal.asa<K, V>] */
/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class arp<K, V> extends arv<K, V> {
    private static final long serialVersionUID = 0;

    arp(ars<K, arn<V>> arsVar, int i) {
        super(arsVar);
    }

    public static <K, V> aro<K, V> b() {
        return new aro<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, ClassNotFoundException, IOException, IllegalArgumentException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Invalid key count ");
            sb.append(i);
            throw new InvalidObjectException(sb.toString());
        }
        arq arqVarC = ars.c();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object object = objectInputStream.readObject();
            int i4 = objectInputStream.readInt();
            if (i4 <= 0) {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid value count ");
                sb2.append(i4);
                throw new InvalidObjectException(sb2.toString());
            }
            ark arkVarR = arn.r();
            for (int i5 = 0; i5 < i4; i5++) {
                arkVarR.d(objectInputStream.readObject());
            }
            arqVarC.b(object, arkVarR.c());
            i2 += i4;
        }
        try {
            aru.a.a(this, arqVarC.a());
            aru.b.b(this, i2);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(a().size());
        for (Map.Entry<K, Collection<V>> entry : a().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    public final arn<V> c(K k) {
        arn<V> arnVar = (arn) this.b.get(k);
        return arnVar == null ? arn.i() : arnVar;
    }
}
