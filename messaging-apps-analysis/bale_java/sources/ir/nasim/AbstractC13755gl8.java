package ir.nasim;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC17687nO3;

/* renamed from: ir.nasim.gl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC13755gl8 {
    private static final String a = "gl8";
    private static Context b;
    private static Cn8 c;

    public static Cn8 a(Context context, AbstractC17687nO3.a aVar) throws GooglePlayServicesNotAvailableException {
        Cn8 om8;
        AbstractC3795Cj5.j(context);
        String str = a;
        Log.d(str, "preferredRenderer: ".concat(String.valueOf(aVar)));
        Cn8 cn8 = c;
        if (cn8 != null) {
            return cn8;
        }
        int iF = com.google.android.gms.common.c.f(context, 13400000);
        if (iF != 0) {
            throw new GooglePlayServicesNotAvailableException(iF);
        }
        Log.i(str, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) d(((ClassLoader) AbstractC3795Cj5.j(c(context, aVar).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                om8 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                om8 = iInterfaceQueryLocalInterface instanceof Cn8 ? (Cn8) iInterfaceQueryLocalInterface : new Om8(iBinder);
            }
            c = om8;
            try {
                Context contextC = c(context, aVar);
                contextC.getClass();
                om8.n0(CG4.E2(contextC.getResources()), com.google.android.gms.common.c.f);
                return c;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl");
        }
    }

    private static Context b(Exception exc, Context context) {
        Log.e(a, "Failed to load maps module, use pre-Chimera", exc);
        return com.google.android.gms.common.c.c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.Context c(android.content.Context r2, ir.nasim.AbstractC17687nO3.a r3) {
        /*
            android.content.Context r0 = ir.nasim.AbstractC13755gl8.b
            if (r0 != 0) goto L4d
            r2.getApplicationContext()
            java.lang.String r0 = "com.google.android.gms.maps_dynamite"
            if (r3 == 0) goto L1b
            int r3 = r3.ordinal()
            if (r3 == 0) goto L18
            r1 = 1
            if (r3 == r1) goto L15
            goto L1b
        L15:
            java.lang.String r3 = "com.google.android.gms.maps_core_dynamite"
            goto L1c
        L18:
            java.lang.String r3 = "com.google.android.gms.maps_legacy_dynamite"
            goto L1c
        L1b:
            r3 = r0
        L1c:
            com.google.android.gms.dynamite.DynamiteModule$a r1 = com.google.android.gms.dynamite.DynamiteModule.b     // Catch: java.lang.Exception -> L27
            com.google.android.gms.dynamite.DynamiteModule r1 = com.google.android.gms.dynamite.DynamiteModule.e(r2, r1, r3)     // Catch: java.lang.Exception -> L27
            android.content.Context r2 = r1.b()     // Catch: java.lang.Exception -> L27
            goto L4a
        L27:
            r1 = move-exception
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L46
            java.lang.String r3 = ir.nasim.AbstractC13755gl8.a     // Catch: java.lang.Exception -> L40
            java.lang.String r1 = "Attempting to load maps_dynamite again."
            android.util.Log.d(r3, r1)     // Catch: java.lang.Exception -> L40
            com.google.android.gms.dynamite.DynamiteModule$a r3 = com.google.android.gms.dynamite.DynamiteModule.b     // Catch: java.lang.Exception -> L40
            com.google.android.gms.dynamite.DynamiteModule r3 = com.google.android.gms.dynamite.DynamiteModule.e(r2, r3, r0)     // Catch: java.lang.Exception -> L40
            android.content.Context r2 = r3.b()     // Catch: java.lang.Exception -> L40
            goto L4a
        L40:
            r3 = move-exception
            android.content.Context r2 = b(r3, r2)
            goto L4a
        L46:
            android.content.Context r2 = b(r1, r2)
        L4a:
            ir.nasim.AbstractC13755gl8.b = r2
            return r2
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13755gl8.c(android.content.Context, ir.nasim.nO3$a):android.content.Context");
    }

    private static Object d(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(cls.getName()));
        } catch (InstantiationException unused2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(cls.getName()));
        }
    }
}
