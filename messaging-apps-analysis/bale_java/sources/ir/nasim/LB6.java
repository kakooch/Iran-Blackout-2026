package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import ir.nasim.AbstractC24846zI6;
import ir.nasim.C18922pU2;
import ir.nasim.InterfaceC7920Tt2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class LB6 {
    public static final a b = new a(null);
    private static final String c = LB6.class.getSimpleName();
    private final AbstractC24846zI6.b a;

    public static final class a {
        private a() {
        }

        public final int a(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC13042fc3.i(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    if (objInvoke != null) {
                        return ((Integer) objInvoke).intValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC13042fc3.i(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC13042fc3.i(sidecarWindowLayoutInfo, ParameterNames.INFO);
            try {
                try {
                    List list = sidecarWindowLayoutInfo.displayFeatures;
                    return list == null ? AbstractC10360bX0.m() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                    if (objInvoke != null) {
                        return (List) objInvoke;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return AbstractC10360bX0.m();
            }
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC13042fc3.i(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            AbstractC13042fc3.i(sidecarDisplayFeature, "$this$require");
            boolean z = true;
            if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            AbstractC13042fc3.i(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            AbstractC13042fc3.i(sidecarDisplayFeature, "$this$require");
            boolean z = true;
            if (sidecarDisplayFeature.getType() == 1 && sidecarDisplayFeature.getRect().width() != 0 && sidecarDisplayFeature.getRect().height() != 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            AbstractC13042fc3.i(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
        }
    }

    public LB6(AbstractC24846zI6.b bVar) {
        AbstractC13042fc3.i(bVar, "verificationMode");
        this.a = bVar;
    }

    private final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (AbstractC13042fc3.d(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return AbstractC13042fc3.d(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean c(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (!b((SidecarDisplayFeature) list.get(i), (SidecarDisplayFeature) list2.get(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (AbstractC13042fc3.d(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        a aVar = b;
        return aVar.b(sidecarDeviceState) == aVar.b(sidecarDeviceState2);
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (AbstractC13042fc3.d(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        a aVar = b;
        return c(aVar.c(sidecarWindowLayoutInfo), aVar.c(sidecarWindowLayoutInfo2));
    }

    public final C25010za8 e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new C25010za8(AbstractC10360bX0.m());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        a aVar = b;
        aVar.d(sidecarDeviceState2, aVar.b(sidecarDeviceState));
        return new C25010za8(f(aVar.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List f(List list, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(list, "sidecarDisplayFeatures");
        AbstractC13042fc3.i(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC20721sV1 interfaceC20721sV1G = g((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (interfaceC20721sV1G != null) {
                arrayList.add(interfaceC20721sV1G);
            }
        }
        return arrayList;
    }

    public final InterfaceC20721sV1 g(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C18922pU2.b bVarA;
        InterfaceC7920Tt2.b bVar;
        AbstractC13042fc3.i(sidecarDisplayFeature, "feature");
        AbstractC13042fc3.i(sidecarDeviceState, "deviceState");
        AbstractC24846zI6.a aVar = AbstractC24846zI6.a;
        String str = c;
        AbstractC13042fc3.h(str, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) AbstractC24846zI6.a.b(aVar, sidecarDisplayFeature, str, this.a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.e).c("Feature bounds must not be 0", c.e).c("TYPE_FOLD must have 0 area", d.e).c("Feature be pinned to either left or top", e.e).a();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            bVarA = C18922pU2.b.b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = C18922pU2.b.b.b();
        }
        int iB = b.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = InterfaceC7920Tt2.b.d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = InterfaceC7920Tt2.b.c;
        }
        Rect rect = sidecarDisplayFeature.getRect();
        AbstractC13042fc3.h(rect, "feature.rect");
        return new C18922pU2(new C3565Bk0(rect), bVarA, bVar);
    }

    public /* synthetic */ LB6(AbstractC24846zI6.b bVar, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC24846zI6.b.QUIET : bVar);
    }
}
