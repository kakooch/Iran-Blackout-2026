package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import ir.nasim.AbstractC20967su2;
import ir.nasim.AbstractC6245Mu2;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.iz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC15091iz7 {
    private ConcurrentHashMap a = new ConcurrentHashMap();

    /* renamed from: ir.nasim.iz7$a */
    class a implements b {
        a() {
        }

        @Override // ir.nasim.AbstractC15091iz7.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(AbstractC6245Mu2.b bVar) {
            return bVar.e();
        }

        @Override // ir.nasim.AbstractC15091iz7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(AbstractC6245Mu2.b bVar) {
            return bVar.f();
        }
    }

    /* renamed from: ir.nasim.iz7$b */
    private interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    AbstractC15091iz7() {
    }

    private static Object e(Object[] objArr, int i, b bVar) {
        return f(objArr, (i & 1) == 0 ? 400 : 700, (i & 2) != 0, bVar);
    }

    private static Object f(Object[] objArr, int i, boolean z, b bVar) {
        Object obj = null;
        int i2 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.b(obj2) - i) * 2) + (bVar.a(obj2) == z ? 0 : 1);
            if (obj == null || i2 > iAbs) {
                obj = obj2;
                i2 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, AbstractC20967su2.c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, AbstractC6245Mu2.b[] bVarArr, int i);

    protected Typeface c(Context context, InputStream inputStream) {
        File fileE = AbstractC15682jz7.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (AbstractC15682jz7.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File fileE = AbstractC15682jz7.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (AbstractC15682jz7.c(fileE, resources, i)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected AbstractC6245Mu2.b g(AbstractC6245Mu2.b[] bVarArr, int i) {
        return (AbstractC6245Mu2.b) e(bVarArr, i, new a());
    }
}
