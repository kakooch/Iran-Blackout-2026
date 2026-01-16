package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class Bh8 {
    private static final Object h = new Object();
    private static Context i = null;
    private static boolean j = false;
    private static volatile Boolean k;
    private static volatile Boolean l;
    private final C22130ui8 a;
    final String b;
    private final String c;
    private final Object d;
    private Object e;
    private volatile C17870nh8 f;
    private volatile SharedPreferences g;

    private Bh8(C22130ui8 c22130ui8, String str, Object obj) {
        this.e = null;
        this.f = null;
        this.g = null;
        if (c22130ui8.a == null && c22130ui8.b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (c22130ui8.a != null && c22130ui8.b != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.a = c22130ui8;
        String strValueOf = String.valueOf(c22130ui8.c);
        String strValueOf2 = String.valueOf(str);
        this.c = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        String strValueOf3 = String.valueOf(c22130ui8.d);
        String strValueOf4 = String.valueOf(str);
        this.b = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
        this.d = obj;
    }

    public static void b(Context context) {
        Context applicationContext;
        if (i == null) {
            synchronized (h) {
                try {
                    if (!context.isDeviceProtectedStorage() && (applicationContext = context.getApplicationContext()) != null) {
                        context = applicationContext;
                    }
                    if (i != context) {
                        k = null;
                    }
                    i = context;
                } catch (Throwable th) {
                    throw th;
                }
            }
            j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bh8 c(C22130ui8 c22130ui8, String str, Object obj, InterfaceC20262ri8 interfaceC20262ri8) {
        return new C16107ki8(c22130ui8, str, obj, interfaceC20262ri8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bh8 d(C22130ui8 c22130ui8, String str, String str2) {
        return new C14316hi8(c22130ui8, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bh8 e(C22130ui8 c22130ui8, String str, boolean z) {
        return new C10501bi8(c22130ui8, str, Boolean.valueOf(z));
    }

    private static Object g(InterfaceC18471oi8 interfaceC18471oi8) {
        try {
            return interfaceC18471oi8.b();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return interfaceC18471oi8.b();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    static boolean h(final String str, boolean z) {
        final boolean z2 = false;
        if (p()) {
            return ((Boolean) g(new InterfaceC18471oi8(str, z2) { // from class: ir.nasim.Oh8
                private final String a;
                private final boolean b = false;

                {
                    this.a = str;
                }

                @Override // ir.nasim.InterfaceC18471oi8
                public final Object b() {
                    return Boolean.valueOf(Iv8.h(Bh8.i.getContentResolver(), this.a, this.b));
                }
            })).booleanValue();
        }
        return false;
    }

    private final Object n() {
        boolean zBooleanValue;
        if (h("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String strValueOf = String.valueOf(this.b);
            Log.w("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else if (this.a.b != null) {
            if (this.f == null) {
                this.f = C17870nh8.a(i.getContentResolver(), this.a.b);
            }
            final C17870nh8 c17870nh8 = this.f;
            String str = (String) g(new InterfaceC18471oi8(this, c17870nh8) { // from class: ir.nasim.Hh8
                private final Bh8 a;
                private final C17870nh8 b;

                {
                    this.a = this;
                    this.b = c17870nh8;
                }

                @Override // ir.nasim.InterfaceC18471oi8
                public final Object b() {
                    return (String) this.b.c().get(this.a.b);
                }
            });
            if (str != null) {
                return m(str);
            }
        } else if (this.a.a != null) {
            if (i.isDeviceProtectedStorage()) {
                zBooleanValue = true;
            } else {
                if (l == null || !l.booleanValue()) {
                    l = Boolean.valueOf(((UserManager) i.getSystemService(UserManager.class)).isUserUnlocked());
                }
                zBooleanValue = l.booleanValue();
            }
            if (!zBooleanValue) {
                return null;
            }
            if (this.g == null) {
                this.g = i.getSharedPreferences(this.a.a, 0);
            }
            SharedPreferences sharedPreferences = this.g;
            if (sharedPreferences.contains(this.b)) {
                return f(sharedPreferences);
            }
        }
        return null;
    }

    private final Object o() {
        String str;
        if (this.a.e || !p() || (str = (String) g(new InterfaceC18471oi8(this) { // from class: ir.nasim.Kh8
            private final Bh8 a;

            {
                this.a = this;
            }

            @Override // ir.nasim.InterfaceC18471oi8
            public final Object b() {
                return this.a.q();
            }
        })) == null) {
            return null;
        }
        return m(str);
    }

    private static boolean p() {
        if (k == null) {
            Context context = i;
            if (context == null) {
                return false;
            }
            k = Boolean.valueOf(F35.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return k.booleanValue();
    }

    public final Object a() {
        if (i == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        if (this.a.f) {
            Object objO = o();
            if (objO != null) {
                return objO;
            }
            Object objN = n();
            if (objN != null) {
                return objN;
            }
        } else {
            Object objN2 = n();
            if (objN2 != null) {
                return objN2;
            }
            Object objO2 = o();
            if (objO2 != null) {
                return objO2;
            }
        }
        return this.d;
    }

    protected abstract Object f(SharedPreferences sharedPreferences);

    protected abstract Object m(String str);

    final /* synthetic */ String q() {
        return Iv8.c(i.getContentResolver(), this.c, null);
    }

    /* synthetic */ Bh8(C22130ui8 c22130ui8, String str, Object obj, Uh8 uh8) {
        this(c22130ui8, str, obj);
    }
}
