package com.google.i18n.phonenumbers;

import ir.nasim.C9544a85;
import ir.nasim.InterfaceC3515Be4;
import ir.nasim.Z75;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
abstract class c {
    static final InterfaceC3515Be4 a = new a();
    private static final Logger b = Logger.getLogger(c.class.getName());
    private static final ConcurrentHashMap c = new ConcurrentHashMap();
    private static final ConcurrentHashMap d = new ConcurrentHashMap();
    private static final Set e = com.google.i18n.phonenumbers.a.a();
    private static final Set f = h.a();

    class a implements InterfaceC3515Be4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC3515Be4
        public InputStream a(String str) {
            return c.class.getResourceAsStream(str);
        }
    }

    static Z75 a(Object obj, ConcurrentHashMap concurrentHashMap, String str, InterfaceC3515Be4 interfaceC3515Be4) {
        Z75 z75 = (Z75) concurrentHashMap.get(obj);
        if (z75 != null) {
            return z75;
        }
        String str2 = str + "_" + obj;
        List listB = b(str2, interfaceC3515Be4);
        if (listB.size() > 1) {
            b.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        Z75 z752 = (Z75) listB.get(0);
        Z75 z753 = (Z75) concurrentHashMap.putIfAbsent(obj, z752);
        return z753 != null ? z753 : z752;
    }

    private static List b(String str, InterfaceC3515Be4 interfaceC3515Be4) {
        InputStream inputStreamA = interfaceC3515Be4.a(str);
        if (inputStreamA == null) {
            throw new IllegalStateException("missing metadata: " + str);
        }
        List listB = c(inputStreamA).b();
        if (listB.size() != 0) {
            return listB;
        }
        throw new IllegalStateException("empty metadata: " + str);
    }

    private static C9544a85 c(InputStream inputStream) throws Throwable {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e2) {
                throw new RuntimeException("cannot load/parse metadata", e2);
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            C9544a85 c9544a85 = new C9544a85();
            try {
                c9544a85.readExternal(objectInputStream);
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                    b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e3);
                }
                return c9544a85;
            } catch (IOException e4) {
                throw new RuntimeException("cannot load/parse metadata", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            try {
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                } else {
                    inputStream.close();
                }
            } catch (IOException e5) {
                b.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e5);
            }
            throw th;
        }
    }
}
