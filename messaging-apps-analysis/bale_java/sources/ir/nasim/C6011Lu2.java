package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.Lu2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6011Lu2 {
    private static Context b;
    public static final C6011Lu2 a = new C6011Lu2();
    private static String c = "SHABNAM";
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ju2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C6011Lu2.l();
        }
    });
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ku2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C6011Lu2.j();
        }
    });
    public static final int f = 8;

    private C6011Lu2() {
    }

    private final Typeface c(int i) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            Context context = b;
            if (context == null) {
                AbstractC13042fc3.y("applicationContext");
                context = null;
            }
            objB = C9475a16.b(VW5.h(context, i));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Typeface typeface = Typeface.DEFAULT;
        if (C9475a16.g(objB)) {
            objB = typeface;
        }
        return (Typeface) objB;
    }

    private final Typeface e() {
        return (Typeface) e.getValue();
    }

    private final Typeface f() {
        return (Typeface) d.getValue();
    }

    public static final Typeface h() {
        return a.c(NB5.iran_sans_regular);
    }

    public static final Typeface i() {
        Typeface typefaceE = a.e();
        AbstractC13042fc3.f(typefaceE);
        return typefaceE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static final Typeface j() {
        String str = c;
        switch (str.hashCode()) {
            case -2037087204:
                if (str.equals("IRAN_SANS")) {
                    return a.c(NB5.iran_sans_medium);
                }
                break;
            case -1872373947:
                if (str.equals("ROBOTO")) {
                    return a.c(NB5.roboto_medium);
                }
                break;
            case -1523234812:
                if (str.equals("SHABNAM")) {
                    return a.c(NB5.shabnam_medium);
                }
                break;
            case 1275002209:
                if (str.equals("IRAN_SHARP")) {
                    return a.c(NB5.iran_sharp_regular);
                }
                break;
        }
        return a.c(NB5.shabnam_medium);
    }

    public static final Typeface k() {
        Typeface typefaceF = a.f();
        AbstractC13042fc3.f(typefaceF);
        return typefaceF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static final Typeface l() {
        String str = c;
        switch (str.hashCode()) {
            case -2037087204:
                if (str.equals("IRAN_SANS")) {
                    return a.c(NB5.iran_sans_regular);
                }
                break;
            case -1872373947:
                if (str.equals("ROBOTO")) {
                    return a.c(NB5.roboto_regular);
                }
                break;
            case -1523234812:
                if (str.equals("SHABNAM")) {
                    return a.c(NB5.shabnam_regular);
                }
                break;
            case 1275002209:
                if (str.equals("IRAN_SHARP")) {
                    return a.c(NB5.iran_sharp);
                }
                break;
        }
        return a.c(NB5.shabnam_regular);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(androidx.appcompat.app.AppCompatActivity r2) {
        /*
            java.lang.String r0 = "appCompatActivity"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            java.lang.String r0 = ir.nasim.C6011Lu2.c
            int r1 = r0.hashCode()
            switch(r1) {
                case -2037087204: goto L33;
                case -1872373947: goto L27;
                case -1523234812: goto L1b;
                case 1275002209: goto Lf;
                default: goto Le;
            }
        Le:
            goto L3b
        Lf:
            java.lang.String r1 = "IRAN_SHARP"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L18
            goto L3b
        L18:
            int r0 = ir.nasim.AbstractC17008mE5.IranSharp
            goto L40
        L1b:
            java.lang.String r1 = "SHABNAM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L24
            goto L3b
        L24:
            int r0 = ir.nasim.AbstractC17008mE5.Shabnam
            goto L40
        L27:
            java.lang.String r1 = "ROBOTO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L30
            goto L3b
        L30:
            int r0 = ir.nasim.AbstractC17008mE5.Roboto
            goto L40
        L33:
            java.lang.String r1 = "IRAN_SANS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3e
        L3b:
            int r0 = ir.nasim.AbstractC17008mE5.Shabnam
            goto L40
        L3e:
            int r0 = ir.nasim.AbstractC17008mE5.IranSans
        L40:
            android.content.res.Resources$Theme r2 = r2.getTheme()
            r1 = 1
            r2.applyStyle(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6011Lu2.m(androidx.appcompat.app.AppCompatActivity):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int d() {
        String str = c;
        switch (str.hashCode()) {
            case -2037087204:
                if (str.equals("IRAN_SANS")) {
                    return AbstractC17008mE5.IranSans;
                }
                break;
            case -1872373947:
                if (str.equals("ROBOTO")) {
                    return AbstractC17008mE5.Roboto;
                }
                break;
            case -1523234812:
                if (str.equals("SHABNAM")) {
                    return AbstractC17008mE5.Shabnam;
                }
                break;
            case 1275002209:
                if (str.equals("IRAN_SHARP")) {
                    return AbstractC17008mE5.IranSharp;
                }
                break;
        }
        return AbstractC17008mE5.Shabnam;
    }

    public final void g(Context context, String str) {
        AbstractC13042fc3.i(context, "applicationContext");
        b = context;
        if (str == null) {
            str = "SHABNAM";
        }
        c = str;
    }
}
