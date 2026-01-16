package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.engine.q;
import ir.nasim.AbstractC21437tf2;
import ir.nasim.C10751c82;
import ir.nasim.C14902ig4;
import ir.nasim.C15492jg4;
import ir.nasim.C23435wu7;
import ir.nasim.DW5;
import ir.nasim.HW5;
import ir.nasim.IW5;
import ir.nasim.InterfaceC14292hg4;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.KW5;
import ir.nasim.LW5;
import ir.nasim.RW5;
import ir.nasim.S13;
import ir.nasim.XF3;
import ir.nasim.Z72;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Registry {
    private final C14902ig4 a;
    private final C10751c82 b;
    private final IW5 c;
    private final LW5 d;
    private final com.bumptech.glide.load.data.b e;
    private final C23435wu7 f;
    private final S13 g;
    private final C15492jg4 h = new C15492jg4();
    private final XF3 i = new XF3();
    private final InterfaceC20850si5 j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public NoModelLoaderAvailableException(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }

        public NoModelLoaderAvailableException(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        InterfaceC20850si5 interfaceC20850si5E = AbstractC21437tf2.e();
        this.j = interfaceC20850si5E;
        this.a = new C14902ig4(interfaceC20850si5E);
        this.b = new C10751c82();
        this.c = new IW5();
        this.d = new LW5();
        this.e = new com.bumptech.glide.load.data.b();
        this.f = new C23435wu7();
        this.g = new S13();
        r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    private List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.d(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.i(cls, cls4, cls5, this.c.b(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public Registry a(Class cls, Z72 z72) {
        this.b.a(cls, z72);
        return this;
    }

    public Registry b(Class cls, KW5 kw5) {
        this.d.a(cls, kw5);
        return this;
    }

    public Registry c(Class cls, Class cls2, InterfaceC14292hg4 interfaceC14292hg4) {
        this.a.a(cls, cls2, interfaceC14292hg4);
        return this;
    }

    public Registry d(Class cls, Class cls2, HW5 hw5) {
        e("legacy_append", cls, cls2, hw5);
        return this;
    }

    public Registry e(String str, Class cls, Class cls2, HW5 hw5) {
        this.c.a(str, hw5, cls, cls2);
        return this;
    }

    public List g() {
        List listB = this.g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    public q h(Class cls, Class cls2, Class cls3) {
        q qVarA = this.i.a(cls, cls2, cls3);
        if (this.i.c(qVarA)) {
            return null;
        }
        if (qVarA == null) {
            List listF = f(cls, cls2, cls3);
            qVarA = listF.isEmpty() ? null : new q(cls, cls2, cls3, listF, this.j);
            this.i.d(cls, cls2, cls3, qVarA);
        }
        return qVarA;
    }

    public List i(Object obj) {
        return this.a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList();
            Iterator it = this.a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.c.d((Class) it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public KW5 k(DW5 dw5) {
        KW5 kw5B = this.d.b(dw5.b());
        if (kw5B != null) {
            return kw5B;
        }
        throw new NoResultEncoderAvailableException(dw5.b());
    }

    public com.bumptech.glide.load.data.a l(Object obj) {
        return this.e.a(obj);
    }

    public Z72 m(Object obj) {
        Z72 z72B = this.b.b(obj.getClass());
        if (z72B != null) {
            return z72B;
        }
        throw new NoSourceEncoderAvailableException(obj.getClass());
    }

    public boolean n(DW5 dw5) {
        return this.d.b(dw5.b()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry p(a.InterfaceC0146a interfaceC0146a) {
        this.e.b(interfaceC0146a);
        return this;
    }

    public Registry q(Class cls, Class cls2, RW5 rw5) {
        this.f.c(cls, cls2, rw5);
        return this;
    }

    public final Registry r(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.c.e(arrayList);
        return this;
    }
}
