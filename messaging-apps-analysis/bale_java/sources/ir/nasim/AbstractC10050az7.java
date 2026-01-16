package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import ir.nasim.AbstractC20967su2;
import ir.nasim.AbstractC6245Mu2;
import ir.nasim.VW5;

/* renamed from: ir.nasim.az7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10050az7 {
    private static final AbstractC15091iz7 a;
    private static final C17660nL3 b;

    /* renamed from: ir.nasim.az7$a */
    public static class a extends AbstractC6245Mu2.c {
        private VW5.e a;

        public a(VW5.e eVar) {
            this.a = eVar;
        }

        @Override // ir.nasim.AbstractC6245Mu2.c
        public void a(int i) {
            VW5.e eVar = this.a;
            if (eVar != null) {
                eVar.f(i);
            }
        }

        @Override // ir.nasim.AbstractC6245Mu2.c
        public void b(Typeface typeface) {
            VW5.e eVar = this.a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new C14484hz7();
        } else if (i >= 28) {
            a = new C13891gz7();
        } else if (i >= 26) {
            a = new C13300fz7();
        } else if (C11430cz7.j()) {
            a = new C11430cz7();
        } else {
            a = new C10666bz7();
        }
        b = new C17660nL3(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, AbstractC6245Mu2.b[] bVarArr, int i) {
        return a.b(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface c(Context context, AbstractC20967su2.b bVar, Resources resources, int i, String str, int i2, int i3, VW5.e eVar, Handler handler, boolean z) {
        Typeface typefaceA;
        if (bVar instanceof AbstractC20967su2.e) {
            AbstractC20967su2.e eVar2 = (AbstractC20967su2.e) bVar;
            Typeface typefaceG = g(eVar2.c());
            if (typefaceG != null) {
                if (eVar != null) {
                    eVar.d(typefaceG, handler);
                }
                return typefaceG;
            }
            typefaceA = AbstractC6245Mu2.c(context, eVar2.b(), i3, !z ? eVar != null : eVar2.a() != 0, z ? eVar2.d() : -1, VW5.e.e(handler), new a(eVar));
        } else {
            typefaceA = a.a(context, (AbstractC20967su2.c) bVar, resources, i3);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            b.f(e(resources, i, str, i2, i3), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface typefaceD = a.d(context, resources, i, str, i3);
        if (typefaceD != null) {
            b.f(e(resources, i, str, i2, i3), typefaceD);
        }
        return typefaceD;
    }

    private static String e(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface f(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) b.d(e(resources, i, str, i2, i3));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
