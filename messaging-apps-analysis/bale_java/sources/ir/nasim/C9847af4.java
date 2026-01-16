package ir.nasim;

/* renamed from: ir.nasim.af4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9847af4 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final InterfaceC3570Bk5 a;

    /* renamed from: ir.nasim.af4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C9847af4(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = interfaceC3570Bk5;
        if (C8386Vt0.a.S3()) {
            return;
        }
        a();
    }

    public final void a() {
        this.a.g("is_new_download_manager_migration_done", false);
    }

    public final boolean b() {
        return this.a.h("is_new_download_manager_migration_done", false) && C8386Vt0.a.S3();
    }

    public final void c() {
        if (C8386Vt0.a.S3()) {
            this.a.g("is_new_download_manager_migration_done", true);
        }
    }
}
