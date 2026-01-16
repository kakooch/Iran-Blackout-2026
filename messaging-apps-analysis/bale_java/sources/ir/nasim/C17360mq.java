package ir.nasim;

import android.graphics.Typeface;
import ir.nasim.AbstractC9998au2;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC19228pz7;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.mq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17360mq implements InterfaceC12378eW4 {
    private final String a;
    private final C9348Zn7 b;
    private final List c;
    private final List d;
    private final AbstractC9998au2.b e;
    private final WH1 f;
    private final C13806gr g;
    private final CharSequence h;
    private final C18586ou3 i;
    private C16273kz7 j;
    private final boolean k;
    private final int l;

    /* renamed from: ir.nasim.mq$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        a() {
            super(4);
        }

        public final Typeface a(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2) {
            InterfaceC9664aL6 interfaceC9664aL6B = C17360mq.this.g().b(abstractC9998au2, c4593Fu2, i, i2);
            if (interfaceC9664aL6B instanceof InterfaceC19228pz7.b) {
                Object value = interfaceC9664aL6B.getValue();
                AbstractC13042fc3.g(value, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) value;
            }
            C16273kz7 c16273kz7 = new C16273kz7(interfaceC9664aL6B, C17360mq.this.j);
            C17360mq.this.j = c16273kz7;
            return c16273kz7.a();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return a((AbstractC9998au2) obj, (C4593Fu2) obj2, ((C3418Au2) obj3).i(), ((C3657Bu2) obj4).m());
        }
    }

    public C17360mq(String str, C9348Zn7 c9348Zn7, List list, List list2, AbstractC9998au2.b bVar, WH1 wh1) {
        Object obj;
        List list3;
        this.a = str;
        this.b = c9348Zn7;
        this.c = list;
        this.d = list2;
        this.e = bVar;
        this.f = wh1;
        C13806gr c13806gr = new C13806gr(1, wh1.getDensity());
        this.g = c13806gr;
        this.k = !AbstractC17951nq.c(c9348Zn7) ? false : ((Boolean) P52.a.a().getValue()).booleanValue();
        this.l = AbstractC17951nq.d(c9348Zn7.B(), c9348Zn7.u());
        a aVar = new a();
        AbstractC23955xn7.e(c13806gr, c9348Zn7.E());
        C12863fI6 c12863fI6N = c9348Zn7.N();
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (((C13245fu.d) obj).g() instanceof C12863fI6) {
                break;
            } else {
                i++;
            }
        }
        C12863fI6 c12863fI6A = AbstractC23955xn7.a(c13806gr, c12863fI6N, aVar, wh1, obj != null);
        if (c12863fI6A != null) {
            int size2 = this.c.size() + 1;
            ArrayList arrayList = new ArrayList(size2);
            int i2 = 0;
            while (i2 < size2) {
                arrayList.add(i2 == 0 ? new C13245fu.d(c12863fI6A, 0, this.a.length()) : (C13245fu.d) this.c.get(i2 - 1));
                i2++;
            }
            list3 = arrayList;
        } else {
            list3 = this.c;
        }
        CharSequence charSequenceA = AbstractC16769lq.a(this.a, this.g.getTextSize(), this.b, list3, this.d, this.f, aVar, this.k);
        this.h = charSequenceA;
        this.i = new C18586ou3(charSequenceA, this.g, this.l);
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public boolean a() {
        C16273kz7 c16273kz7 = this.j;
        return (c16273kz7 != null ? c16273kz7.b() : false) || (!this.k && AbstractC17951nq.c(this.b) && ((Boolean) P52.a.a().getValue()).booleanValue());
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public float c() {
        return this.i.i();
    }

    @Override // ir.nasim.InterfaceC12378eW4
    public float e() {
        return this.i.j();
    }

    public final CharSequence f() {
        return this.h;
    }

    public final AbstractC9998au2.b g() {
        return this.e;
    }

    public final C18586ou3 h() {
        return this.i;
    }

    public final C9348Zn7 i() {
        return this.b;
    }

    public final int j() {
        return this.l;
    }

    public final C13806gr k() {
        return this.g;
    }
}
