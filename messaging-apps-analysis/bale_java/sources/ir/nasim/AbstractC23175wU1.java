package ir.nasim;

/* renamed from: ir.nasim.wU1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23175wU1 {
    public static final AbstractC23175wU1 a = new a();
    public static final AbstractC23175wU1 b = new b();
    public static final AbstractC23175wU1 c = new c();
    public static final AbstractC23175wU1 d = new d();
    public static final AbstractC23175wU1 e = new e();

    /* renamed from: ir.nasim.wU1$a */
    class a extends AbstractC23175wU1 {
        a() {
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean b() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean c(EnumC21012sz1 enumC21012sz1) {
            return enumC21012sz1 == EnumC21012sz1.REMOTE;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72) {
            return (enumC21012sz1 == EnumC21012sz1.RESOURCE_DISK_CACHE || enumC21012sz1 == EnumC21012sz1.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: ir.nasim.wU1$b */
    class b extends AbstractC23175wU1 {
        b() {
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean b() {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean c(EnumC21012sz1 enumC21012sz1) {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72) {
            return false;
        }
    }

    /* renamed from: ir.nasim.wU1$c */
    class c extends AbstractC23175wU1 {
        c() {
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean b() {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean c(EnumC21012sz1 enumC21012sz1) {
            return (enumC21012sz1 == EnumC21012sz1.DATA_DISK_CACHE || enumC21012sz1 == EnumC21012sz1.MEMORY_CACHE) ? false : true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72) {
            return false;
        }
    }

    /* renamed from: ir.nasim.wU1$d */
    class d extends AbstractC23175wU1 {
        d() {
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean b() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean c(EnumC21012sz1 enumC21012sz1) {
            return false;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72) {
            return (enumC21012sz1 == EnumC21012sz1.RESOURCE_DISK_CACHE || enumC21012sz1 == EnumC21012sz1.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: ir.nasim.wU1$e */
    class e extends AbstractC23175wU1 {
        e() {
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean b() {
            return true;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean c(EnumC21012sz1 enumC21012sz1) {
            return enumC21012sz1 == EnumC21012sz1.REMOTE;
        }

        @Override // ir.nasim.AbstractC23175wU1
        public boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72) {
            return ((z && enumC21012sz1 == EnumC21012sz1.DATA_DISK_CACHE) || enumC21012sz1 == EnumC21012sz1.LOCAL) && t72 == T72.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(EnumC21012sz1 enumC21012sz1);

    public abstract boolean d(boolean z, EnumC21012sz1 enumC21012sz1, T72 t72);
}
