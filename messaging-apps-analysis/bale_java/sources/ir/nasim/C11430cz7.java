package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import ir.nasim.AbstractC20967su2;
import ir.nasim.AbstractC6245Mu2;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: ir.nasim.cz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C11430cz7 extends AbstractC15091iz7 {
    private static final Class b;
    private static final Constructor c;
    private static final Method d;
    private static final Method e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        d = method2;
        e = method;
    }

    C11430cz7() {
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        Method method = d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // ir.nasim.AbstractC15091iz7
    public Typeface a(Context context, AbstractC20967su2.c cVar, Resources resources, int i) {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (AbstractC20967su2.d dVar : cVar.a()) {
            ByteBuffer byteBufferB = AbstractC15682jz7.b(context, resources, dVar.b());
            if (byteBufferB == null || !h(objK, byteBufferB, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(objK);
    }

    @Override // ir.nasim.AbstractC15091iz7
    public Typeface b(Context context, CancellationSignal cancellationSignal, AbstractC6245Mu2.b[] bVarArr, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objK = k();
        if (objK == null) {
            return null;
        }
        C24792zC6 c24792zC6 = new C24792zC6();
        for (AbstractC6245Mu2.b bVar : bVarArr) {
            Uri uriD = bVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) c24792zC6.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = AbstractC15682jz7.f(context, cancellationSignal, uriD);
                c24792zC6.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !h(objK, byteBufferF, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface typefaceI = i(objK);
        if (typefaceI == null) {
            return null;
        }
        return Typeface.create(typefaceI, i);
    }
}
