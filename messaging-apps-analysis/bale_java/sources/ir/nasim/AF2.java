package ir.nasim;

/* loaded from: classes4.dex */
public final class AF2 {
    public static final a b = new a(null);
    private final InterfaceC7720Sx5 a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AF2(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "preferencesStorageProvider");
        this.a = interfaceC7720Sx5;
    }

    public final String a(String str) {
        AbstractC13042fc3.i(str, "key");
        return ((InterfaceC3570Bk5) this.a.get()).e("app.settings." + str);
    }
}
