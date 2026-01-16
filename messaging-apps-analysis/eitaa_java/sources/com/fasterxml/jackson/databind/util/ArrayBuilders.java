package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class ArrayBuilders {
    public static Object getArrayComparator(final Object obj) {
        final int length = Array.getLength(obj);
        final Class<?> cls = obj.getClass();
        return new Object() { // from class: com.fasterxml.jackson.databind.util.ArrayBuilders.1
            public boolean equals(Object obj2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
                if (obj2 == this) {
                    return true;
                }
                if (!ClassUtil.hasClass(obj2, cls) || Array.getLength(obj2) != length) {
                    return false;
                }
                for (int i = 0; i < length; i++) {
                    Object obj3 = Array.get(obj, i);
                    Object obj4 = Array.get(obj2, i);
                    if (obj3 != obj4 && obj3 != null && !obj3.equals(obj4)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
