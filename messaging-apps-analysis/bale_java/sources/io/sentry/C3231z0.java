package io.sentry;

import android.gov.nist.core.Separators;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: io.sentry.z0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3231z0 {
    private final Set a = new HashSet();
    private final int b;

    C3231z0(int i) {
        this.b = i;
    }

    private List a(Collection collection, ILogger iLogger) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next(), iLogger));
        }
        return arrayList;
    }

    private List b(Object[] objArr, ILogger iLogger) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(d(obj, iLogger));
        }
        return arrayList;
    }

    private Map c(Map map, ILogger iLogger) {
        HashMap map2 = new HashMap();
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                map2.put(obj.toString(), d(obj2, iLogger));
            } else {
                map2.put(obj.toString(), null);
            }
        }
        return map2;
    }

    public Object d(Object obj, ILogger iLogger) {
        Object string;
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof Locale) {
            return obj.toString();
        }
        if (obj instanceof AtomicIntegerArray) {
            return io.sentry.util.p.a((AtomicIntegerArray) obj);
        }
        if (obj instanceof AtomicBoolean) {
            return Boolean.valueOf(((AtomicBoolean) obj).get());
        }
        if (obj instanceof URI) {
            return obj.toString();
        }
        if (obj instanceof InetAddress) {
            return obj.toString();
        }
        if (obj instanceof UUID) {
            return obj.toString();
        }
        if (obj instanceof Currency) {
            return obj.toString();
        }
        if (obj instanceof Calendar) {
            return io.sentry.util.p.c((Calendar) obj);
        }
        if (obj.getClass().isEnum()) {
            return obj.toString();
        }
        if (this.a.contains(obj)) {
            iLogger.c(Y2.INFO, "Cyclic reference detected. Calling toString() on object.", new Object[0]);
            return obj.toString();
        }
        this.a.add(obj);
        try {
            if (this.a.size() > this.b) {
                this.a.remove(obj);
                iLogger.c(Y2.INFO, "Max depth exceeded. Calling toString() on object.", new Object[0]);
                return obj.toString();
            }
            try {
            } catch (Exception e) {
                iLogger.b(Y2.INFO, "Not serializing object due to throwing sub-path.", e);
            }
            if (obj.getClass().isArray()) {
                string = b((Object[]) obj, iLogger);
            } else if (obj instanceof Collection) {
                string = a((Collection) obj, iLogger);
            } else if (obj instanceof Map) {
                string = c((Map) obj, iLogger);
            } else {
                Map mapE = e(obj, iLogger);
                if (!mapE.isEmpty()) {
                    obj2 = mapE;
                    return obj2;
                }
                string = obj.toString();
            }
            obj2 = string;
            return obj2;
        } finally {
            this.a.remove(obj);
        }
    }

    public Map e(Object obj, ILogger iLogger) throws SecurityException {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        HashMap map = new HashMap();
        for (Field field : declaredFields) {
            if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                try {
                    field.setAccessible(true);
                    map.put(name, d(field.get(obj), iLogger));
                    field.setAccessible(false);
                } catch (Exception unused) {
                    iLogger.c(Y2.INFO, "Cannot access field " + name + Separators.DOT, new Object[0]);
                }
            }
        }
        return map;
    }
}
