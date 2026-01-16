package ir.nasim;

import android.content.Context;
import java.io.File;
import java.util.List;

/* renamed from: ir.nasim.ok5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18488ok5 implements InterfaceC23661xI5 {
    private final String a;
    private final UA2 b;
    private final InterfaceC20315ro1 c;
    private final Object d;
    private volatile InterfaceC23475wz1 e;

    /* renamed from: ir.nasim.ok5$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Context e;
        final /* synthetic */ C18488ok5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, C18488ok5 c18488ok5) {
            super(0);
            this.e = context;
            this.f = c18488ok5;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context context = this.e;
            AbstractC13042fc3.h(context, "applicationContext");
            return AbstractC17897nk5.a(context, this.f.a);
        }
    }

    public C18488ok5(String str, KO5 ko5, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(ua2, "produceMigrations");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = str;
        this.b = ua2;
        this.c = interfaceC20315ro1;
        this.d = new Object();
    }

    @Override // ir.nasim.InterfaceC23661xI5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC23475wz1 a(Context context, InterfaceC5239Im3 interfaceC5239Im3) {
        InterfaceC23475wz1 interfaceC23475wz1;
        AbstractC13042fc3.i(context, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        InterfaceC23475wz1 interfaceC23475wz12 = this.e;
        if (interfaceC23475wz12 != null) {
            return interfaceC23475wz12;
        }
        synchronized (this.d) {
            try {
                if (this.e == null) {
                    Context applicationContext = context.getApplicationContext();
                    C17306mk5 c17306mk5 = C17306mk5.a;
                    UA2 ua2 = this.b;
                    AbstractC13042fc3.h(applicationContext, "applicationContext");
                    this.e = c17306mk5.a(null, (List) ua2.invoke(applicationContext), this.c, new a(applicationContext, this));
                }
                interfaceC23475wz1 = this.e;
                AbstractC13042fc3.f(interfaceC23475wz1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC23475wz1;
    }
}
