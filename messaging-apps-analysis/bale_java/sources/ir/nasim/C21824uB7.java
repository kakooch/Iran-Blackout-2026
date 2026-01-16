package ir.nasim;

import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;

/* renamed from: ir.nasim.uB7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C21824uB7 implements InterfaceC13701gg4 {
    private static final C21824uB7 a = new C21824uB7();

    /* renamed from: ir.nasim.uB7$a */
    public static class a implements InterfaceC14292hg4 {
        private static final a a = new a();

        public static a a() {
            return a;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return C21824uB7.c();
        }
    }

    public static C21824uB7 c() {
        return a;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public boolean a(Object obj) {
        return true;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public InterfaceC13701gg4.a b(Object obj, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(obj), new b(obj));
    }

    /* renamed from: ir.nasim.uB7$b */
    private static class b implements InterfaceC8666Wy1 {
        private final Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.a.getClass();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            aVar.f(this.a);
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
