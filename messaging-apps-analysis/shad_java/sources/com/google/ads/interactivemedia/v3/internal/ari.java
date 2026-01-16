package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ari<E> {
    Object[] a;
    int b;
    boolean c;

    ari() {
    }

    ari(byte[] bArr) {
        this();
        ary.n(4, "initialCapacity");
        this.a = new Object[4];
        this.b = 0;
    }

    private void c(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        if (length < i) {
            this.a = Arrays.copyOf(objArr, a(length, i));
            this.c = false;
        } else if (this.c) {
            this.a = (Object[]) objArr.clone();
            this.c = false;
        }
    }

    public void b(Object obj) {
        aqd.j(obj);
        c(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    static int a(int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i3 = i + (i >> 1) + 1;
        if (i3 < i2) {
            int iHighestOneBit = Integer.highestOneBit(i2 - 1);
            i3 = iHighestOneBit + iHighestOneBit;
        }
        return i3 < 0 ? ConnectionsManager.DEFAULT_DATACENTER_ID : i3;
    }
}
