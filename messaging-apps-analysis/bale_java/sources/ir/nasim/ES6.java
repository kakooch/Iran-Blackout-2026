package ir.nasim;

/* loaded from: classes7.dex */
public final class ES6 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final InterfaceC3570Bk5 a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public ES6(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = interfaceC3570Bk5;
    }

    public final int a() {
        return this.a.getInt("POST_TO_STORY_ONBOARDING_COUNT", 0);
    }

    public final void b(int i) {
        this.a.putInt("POST_TO_STORY_ONBOARDING_COUNT", i);
    }
}
