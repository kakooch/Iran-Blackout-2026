package ir.nasim;

import androidx.fragment.app.FragmentActivity;
import ir.nasim.C3520Bf0;

/* renamed from: ir.nasim.gR, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13555gR {
    private static final a c = new a(null);
    public static final int d = 8;
    private final AbstractC13778go1 a;
    private final C3281Af0 b;

    /* renamed from: ir.nasim.gR$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.gR$b */
    public static final class b {
        public static final b a = new b("NO_SUPPORTED_METHOD_AVAILABLE", 0);
        public static final b b = new b("AUTHENTICATION_SUCCEEDED", 1);
        public static final b c = new b("AUTHENTICATION_FAILED", 2);
        public static final b d = new b("AUTHENTICATION_ERROR", 3);
        private static final /* synthetic */ b[] e;
        private static final /* synthetic */ F92 f;

        static {
            b[] bVarArrA = a();
            e = bVarArrA;
            f = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c, d};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.gR$c */
    public static final class c extends C3520Bf0.a {
        final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.C3520Bf0.a
        public void a(int i, CharSequence charSequence) {
            AbstractC13042fc3.i(charSequence, "errString");
            C19406qI3.c("AuthenticateBiometricUseCase", "OnBiometricResult", new Exception("errorCode: " + i + ", errString: " + ((Object) charSequence)));
            this.a.invoke(b.d);
        }

        @Override // ir.nasim.C3520Bf0.a
        public void b() {
            this.a.invoke(b.c);
        }

        @Override // ir.nasim.C3520Bf0.a
        public void c(C3520Bf0.b bVar) {
            AbstractC13042fc3.i(bVar, "result");
            this.a.invoke(b.b);
        }
    }

    public C13555gR(AbstractC13778go1 abstractC13778go1, C3281Af0 c3281Af0) {
        AbstractC13042fc3.i(abstractC13778go1, "mainDispatcher");
        AbstractC13042fc3.i(c3281Af0, "biometricManager");
        this.a = abstractC13778go1;
        this.b = c3281Af0;
    }

    private final C3520Bf0 a(FragmentActivity fragmentActivity, UA2 ua2) {
        return new C3520Bf0(fragmentActivity, AbstractC14260hd2.a(this.a), new c(ua2));
    }

    public final void b(String str, String str2, FragmentActivity fragmentActivity, String str3, UA2 ua2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "negativeButtonText");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        AbstractC13042fc3.i(ua2, "onResult");
        if (this.b.a(15) != 0) {
            ua2.invoke(b.a);
            return;
        }
        C3520Bf0.d dVarA = new C3520Bf0.d.a().e(str).c(str3).d(str2).b(15).a();
        AbstractC13042fc3.h(dVarA, "build(...)");
        a(fragmentActivity, ua2).a(dVarA);
    }
}
