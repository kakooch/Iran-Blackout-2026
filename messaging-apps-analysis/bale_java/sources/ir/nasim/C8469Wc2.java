package ir.nasim;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Wc2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8469Wc2 implements InterfaceC6537Nx7, Cloneable {
    public static final C8469Wc2 g = new C8469Wc2();
    private boolean d;
    private double a = -1.0d;
    private int b = 136;
    private boolean c = true;
    private List e = Collections.emptyList();
    private List f = Collections.emptyList();

    /* renamed from: ir.nasim.Wc2$a */
    class a extends AbstractC6277Mx7 {
        private AbstractC6277Mx7 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ KS2 d;
        final /* synthetic */ TypeToken e;

        a(boolean z, boolean z2, KS2 ks2, TypeToken typeToken) {
            this.b = z;
            this.c = z2;
            this.d = ks2;
            this.e = typeToken;
        }

        private AbstractC6277Mx7 e() {
            AbstractC6277Mx7 abstractC6277Mx7 = this.a;
            if (abstractC6277Mx7 != null) {
                return abstractC6277Mx7;
            }
            AbstractC6277Mx7 abstractC6277Mx7O = this.d.o(C8469Wc2.this, this.e);
            this.a = abstractC6277Mx7O;
            return abstractC6277Mx7O;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public Object b(C12523el3 c12523el3) throws IOException {
            if (!this.b) {
                return e().b(c12523el3);
            }
            c12523el3.R();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public void d(C22155ul3 c22155ul3, Object obj) throws IOException {
            if (this.c) {
                c22155ul3.s();
            } else {
                e().d(c22155ul3, obj);
            }
        }
    }

    private boolean e(Class cls) {
        if (this.a != -1.0d && !o((InterfaceC18182oD6) cls.getAnnotation(InterfaceC18182oD6.class), (InterfaceC16992mC7) cls.getAnnotation(InterfaceC16992mC7.class))) {
            return true;
        }
        if (this.c || !k(cls)) {
            return i(cls);
        }
        return true;
    }

    private boolean f(Class cls, boolean z) {
        Iterator it = (z ? this.e : this.f).iterator();
        if (!it.hasNext()) {
            return false;
        }
        AbstractC18350oW3.a(it.next());
        throw null;
    }

    private boolean i(Class cls) {
        return (Enum.class.isAssignableFrom(cls) || l(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean k(Class cls) {
        return cls.isMemberClass() && !l(cls);
    }

    private boolean l(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean m(InterfaceC18182oD6 interfaceC18182oD6) {
        if (interfaceC18182oD6 != null) {
            return this.a >= interfaceC18182oD6.value();
        }
        return true;
    }

    private boolean n(InterfaceC16992mC7 interfaceC16992mC7) {
        if (interfaceC16992mC7 != null) {
            return this.a < interfaceC16992mC7.value();
        }
        return true;
    }

    private boolean o(InterfaceC18182oD6 interfaceC18182oD6, InterfaceC16992mC7 interfaceC16992mC7) {
        return m(interfaceC18182oD6) && n(interfaceC16992mC7);
    }

    @Override // ir.nasim.InterfaceC6537Nx7
    public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
        Class clsC = typeToken.c();
        boolean zE = e(clsC);
        boolean z = zE || f(clsC, true);
        boolean z2 = zE || f(clsC, false);
        if (z || z2) {
            return new a(z2, z, ks2, typeToken);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C8469Wc2 clone() {
        try {
            return (C8469Wc2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean d(Class cls, boolean z) {
        return e(cls) || f(cls, z);
    }

    public boolean h(Field field, boolean z) {
        InterfaceC23860xe2 interfaceC23860xe2;
        if ((this.b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.a != -1.0d && !o((InterfaceC18182oD6) field.getAnnotation(InterfaceC18182oD6.class), (InterfaceC16992mC7) field.getAnnotation(InterfaceC16992mC7.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.d && ((interfaceC23860xe2 = (InterfaceC23860xe2) field.getAnnotation(InterfaceC23860xe2.class)) == null || (!z ? interfaceC23860xe2.deserialize() : interfaceC23860xe2.serialize()))) {
            return true;
        }
        if ((!this.c && k(field.getType())) || i(field.getType())) {
            return true;
        }
        List list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        new C23920xk2(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        AbstractC18350oW3.a(it.next());
        throw null;
    }
}
