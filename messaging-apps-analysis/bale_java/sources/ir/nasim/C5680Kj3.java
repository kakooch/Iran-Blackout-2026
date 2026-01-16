package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC5446Jj3;

/* renamed from: ir.nasim.Kj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C5680Kj3 implements InterfaceC5446Jj3 {
    Object a;
    Object b;
    Object[] c;
    InterfaceC5446Jj3.a d;

    /* renamed from: ir.nasim.Kj3$a */
    static class a implements InterfaceC5446Jj3.a {
        String a;
        InterfaceC16991mC6 b;
        SH6 c;
        private int d;

        public a(int i, String str, InterfaceC16991mC6 interfaceC16991mC6, SH6 sh6) {
            this.a = str;
            this.b = interfaceC16991mC6;
            this.c = sh6;
            this.d = i;
        }

        public String a() {
            return this.a;
        }

        public InterfaceC16991mC6 b() {
            return this.b;
        }

        String c(OY6 oy6) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(oy6.d(a()));
            stringBuffer.append(Separators.LPAREN);
            stringBuffer.append(((AbstractC19946rC6) b()).k(oy6));
            stringBuffer.append(Separators.RPAREN);
            return stringBuffer.toString();
        }

        @Override // ir.nasim.InterfaceC5446Jj3.a
        public final String toString() {
            return c(OY6.k);
        }
    }

    public C5680Kj3(InterfaceC5446Jj3.a aVar, Object obj, Object obj2, Object[] objArr) {
        this.d = aVar;
        this.a = obj;
        this.b = obj2;
        this.c = objArr;
    }

    @Override // ir.nasim.InterfaceC5446Jj3
    public Object a() {
        return this.b;
    }

    public final String toString() {
        return this.d.toString();
    }
}
