package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asi<K, V> extends ars<K, V> {
    static final ars<Object, Object> a = new asi(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] b;
    private final transient Object c;
    private final transient int d;

    private asi(Object obj, Object[] objArr, int i) {
        this.c = obj;
        this.b = objArr;
        this.d = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
    
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cc, code lost:
    
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <K, V> com.google.ads.interactivemedia.v3.internal.asi<K, V> k(int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.asi.k(int, java.lang.Object[]):com.google.ads.interactivemedia.v3.internal.asi");
    }

    private static IllegalArgumentException l(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 39 + length2 + strValueOf3.length() + strValueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ars
    final arx<Map.Entry<K, V>> f() {
        return new asf(this, this.b, this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ars
    final arx<K> g() {
        return new asg(this, new ash(this.b, 0, this.d));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ars, java.util.Map, j$.util.Map
    public final V get(Object obj) {
        Object obj2 = this.c;
        Object[] objArr = this.b;
        int i = this.d;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iB = ary.b(obj.hashCode());
            while (true) {
                int i2 = iB & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    return null;
                }
                if (objArr[i3].equals(obj)) {
                    return (V) objArr[i3 ^ 1];
                }
                iB = i2 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iB2 = ary.b(obj.hashCode());
            while (true) {
                int i4 = iB2 & length2;
                char c = (char) sArr[i4];
                if (c == 65535) {
                    return null;
                }
                if (objArr[c].equals(obj)) {
                    return (V) objArr[c ^ 1];
                }
                iB2 = i4 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iB3 = ary.b(obj.hashCode());
            while (true) {
                int i5 = iB3 & length3;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    return null;
                }
                if (objArr[i6].equals(obj)) {
                    return (V) objArr[i6 ^ 1];
                }
                iB3 = i5 + 1;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ars
    final arj<V> i() {
        return new ash(this.b, 1, this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ars
    final boolean j() {
        return false;
    }

    @Override // java.util.Map, j$.util.Map
    public final int size() {
        return this.d;
    }
}
