package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC7704Sv7;

/* renamed from: ir.nasim.py1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C19213py1 extends AbstractC7704Sv7 {
    private InterfaceC7720Sx5 a;
    private InterfaceC7720Sx5 b;
    private InterfaceC7720Sx5 c;
    private InterfaceC7720Sx5 d;
    private InterfaceC7720Sx5 e;
    private InterfaceC7720Sx5 f;
    private InterfaceC7720Sx5 g;
    private InterfaceC7720Sx5 h;
    private InterfaceC7720Sx5 i;
    private InterfaceC7720Sx5 j;
    private InterfaceC7720Sx5 k;
    private InterfaceC7720Sx5 l;
    private InterfaceC7720Sx5 m;

    /* renamed from: ir.nasim.py1$b */
    private static final class b implements AbstractC7704Sv7.a {
        private Context a;

        private b() {
        }

        @Override // ir.nasim.AbstractC7704Sv7.a
        public AbstractC7704Sv7 a() {
            AbstractC3561Bj5.a(this.a, Context.class);
            return new C19213py1(this.a);
        }

        @Override // ir.nasim.AbstractC7704Sv7.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b b(Context context) {
            this.a = (Context) AbstractC3561Bj5.b(context);
            return this;
        }
    }

    public static AbstractC7704Sv7.a c() {
        return new b();
    }

    private void d(Context context) {
        this.a = C14813iX1.a(C10445bd2.a());
        InterfaceC20817sf2 interfaceC20817sf2A = C11770da3.a(context);
        this.b = interfaceC20817sf2A;
        C19766qu1 c19766qu1A = C19766qu1.a(interfaceC20817sf2A, C14397hq7.a(), C15005iq7.a());
        this.c = c19766qu1A;
        this.d = C14813iX1.a(C21429te4.a(this.b, c19766qu1A));
        this.e = C17237md6.a(this.b, C14851ib2.a(), C16031kb2.a());
        this.f = C14813iX1.a(C15440jb2.a(this.b));
        this.g = C14813iX1.a(C21794u86.a(C14397hq7.a(), C15005iq7.a(), C16622lb2.a(), this.e, this.f));
        C11834dd6 c11834dd6B = C11834dd6.b(C14397hq7.a());
        this.h = c11834dd6B;
        C13055fd6 c13055fd6A = C13055fd6.a(this.b, this.g, c11834dd6B, C15005iq7.a());
        this.i = c13055fd6A;
        InterfaceC7720Sx5 interfaceC7720Sx5 = this.a;
        InterfaceC7720Sx5 interfaceC7720Sx52 = this.d;
        InterfaceC7720Sx5 interfaceC7720Sx53 = this.g;
        this.j = UE1.a(interfaceC7720Sx5, interfaceC7720Sx52, c13055fd6A, interfaceC7720Sx53, interfaceC7720Sx53);
        InterfaceC7720Sx5 interfaceC7720Sx54 = this.b;
        InterfaceC7720Sx5 interfaceC7720Sx55 = this.d;
        InterfaceC7720Sx5 interfaceC7720Sx56 = this.g;
        this.k = XH7.a(interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, this.i, this.a, interfaceC7720Sx56, C14397hq7.a(), C15005iq7.a(), this.g);
        InterfaceC7720Sx5 interfaceC7720Sx57 = this.a;
        InterfaceC7720Sx5 interfaceC7720Sx58 = this.g;
        this.l = Xa8.a(interfaceC7720Sx57, interfaceC7720Sx58, this.i, interfaceC7720Sx58);
        this.m = C14813iX1.a(C7943Tv7.a(C14397hq7.a(), C15005iq7.a(), this.j, this.k, this.l));
    }

    @Override // ir.nasim.AbstractC7704Sv7
    InterfaceC13031fb2 a() {
        return (InterfaceC13031fb2) this.g.get();
    }

    @Override // ir.nasim.AbstractC7704Sv7
    C7470Rv7 b() {
        return (C7470Rv7) this.m.get();
    }

    private C19213py1(Context context) {
        d(context);
    }
}
