package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wu7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23435wu7 {
    private final List a = new ArrayList();

    /* renamed from: ir.nasim.wu7$a */
    private static final class a {
        final Class a;
        final Class b;
        final RW5 c;

        a(Class cls, Class cls2, RW5 rw5) {
            this.a = cls;
            this.b = cls2;
            this.c = rw5;
        }

        public boolean a(Class cls, Class cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized RW5 a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return C23010wB7.b();
        }
        for (a aVar : this.a) {
            if (aVar.a(cls, cls2)) {
                return aVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a aVar : this.a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, RW5 rw5) {
        this.a.add(new a(cls, cls2, rw5));
    }
}
