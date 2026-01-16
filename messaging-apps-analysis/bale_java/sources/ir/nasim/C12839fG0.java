package ir.nasim;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.utils.SurfaceUtil;
import androidx.camera.core.impl.v;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.C24711z47;
import ir.nasim.IB0;
import ir.nasim.InterfaceC18096o47;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.fG0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12839fG0 implements InterfaceC13457gG0 {
    final Object a;
    private final List b;
    private final d c;
    InterfaceC18096o47.a d;
    InterfaceC18096o47 e;
    androidx.camera.core.impl.v f;
    private final Map g;
    List h;
    c i;
    InterfaceFutureC15215jC3 j;
    AbstractC16967mA0.a k;
    private Map l;
    private final FN6 m;
    private final C14427ht7 n;
    private final C17743nU5 o;
    private final C19253q22 p;
    private final C24515yk7 q;
    private final boolean r;

    /* renamed from: ir.nasim.fG0$b */
    class b extends CameraCaptureSession.CaptureCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            synchronized (C12839fG0.this.a) {
                try {
                    androidx.camera.core.impl.v vVar = C12839fG0.this.f;
                    if (vVar == null) {
                        return;
                    }
                    androidx.camera.core.impl.i iVarJ = vVar.j();
                    PI3.a("CaptureSession", "Submit FLASH_MODE_OFF request");
                    C12839fG0 c12839fG0 = C12839fG0.this;
                    c12839fG0.a(Collections.singletonList(c12839fG0.n.a(iVarJ)));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: ir.nasim.fG0$c */
    enum c {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    /* renamed from: ir.nasim.fG0$d */
    final class d extends InterfaceC18096o47.c {
        d() {
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void r(InterfaceC18096o47 interfaceC18096o47) {
            synchronized (C12839fG0.this.a) {
                try {
                    switch (C12839fG0.this.i) {
                        case UNINITIALIZED:
                        case INITIALIZED:
                        case GET_SURFACE:
                        case OPENED:
                            throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + C12839fG0.this.i);
                        case OPENING:
                        case CLOSED:
                        case RELEASING:
                            C12839fG0.this.r();
                            break;
                        case RELEASED:
                            PI3.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                            break;
                    }
                    PI3.c("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + C12839fG0.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void s(InterfaceC18096o47 interfaceC18096o47) {
            synchronized (C12839fG0.this.a) {
                try {
                    switch (C12839fG0.this.i) {
                        case UNINITIALIZED:
                        case INITIALIZED:
                        case GET_SURFACE:
                        case OPENED:
                        case RELEASED:
                            throw new IllegalStateException("onConfigured() should not be possible in state: " + C12839fG0.this.i);
                        case OPENING:
                            C12839fG0 c12839fG0 = C12839fG0.this;
                            c12839fG0.i = c.OPENED;
                            c12839fG0.e = interfaceC18096o47;
                            PI3.a("CaptureSession", "Attempting to send capture request onConfigured");
                            C12839fG0 c12839fG02 = C12839fG0.this;
                            c12839fG02.x(c12839fG02.f);
                            C12839fG0.this.w();
                            break;
                        case CLOSED:
                            C12839fG0.this.e = interfaceC18096o47;
                            break;
                        case RELEASING:
                            interfaceC18096o47.close();
                            break;
                    }
                    PI3.a("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + C12839fG0.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void t(InterfaceC18096o47 interfaceC18096o47) {
            synchronized (C12839fG0.this.a) {
                try {
                    if (C12839fG0.this.i.ordinal() == 0) {
                        throw new IllegalStateException("onReady() should not be possible in state: " + C12839fG0.this.i);
                    }
                    PI3.a("CaptureSession", "CameraCaptureSession.onReady() " + C12839fG0.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.InterfaceC18096o47.c
        public void u(InterfaceC18096o47 interfaceC18096o47) {
            synchronized (C12839fG0.this.a) {
                try {
                    if (C12839fG0.this.i == c.UNINITIALIZED) {
                        throw new IllegalStateException("onSessionFinished() should not be possible in state: " + C12839fG0.this.i);
                    }
                    PI3.a("CaptureSession", "onSessionFinished()");
                    C12839fG0.this.r();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    C12839fG0(C19253q22 c19253q22) {
        this(c19253q22, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object B(AbstractC16967mA0.a aVar) {
        String str;
        synchronized (this.a) {
            AbstractC4980Hj5.j(this.k == null, "Release completer expected to be null");
            this.k = aVar;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public InterfaceFutureC15215jC3 A(List list, androidx.camera.core.impl.v vVar, CameraDevice cameraDevice) {
        synchronized (this.a) {
            try {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal != 0 && iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        this.g.clear();
                        for (int i = 0; i < list.size(); i++) {
                            this.g.put((DeferrableSurface) this.h.get(i), (Surface) list.get(i));
                        }
                        this.i = c.OPENING;
                        PI3.a("CaptureSession", "Opening capture session.");
                        InterfaceC18096o47.c cVarW = C24711z47.w(this.c, new C24711z47.a(vVar.k()));
                        BB0 bb0 = new BB0(vVar.f());
                        i.a aVarJ = i.a.j(vVar.j());
                        Map map = new HashMap();
                        if (this.r && Build.VERSION.SDK_INT >= 35) {
                            map = q(u(vVar.h()), this.g);
                        }
                        ArrayList arrayList = new ArrayList();
                        String strZ = bb0.Z(null);
                        for (v.f fVar : vVar.h()) {
                            C15315jN4 c15315jN4S = (!this.r || Build.VERSION.SDK_INT < 35) ? null : (C15315jN4) map.get(fVar);
                            if (c15315jN4S == null) {
                                c15315jN4S = s(fVar, this.g, strZ);
                                if (this.l.containsKey(fVar.f())) {
                                    c15315jN4S.h(((Long) this.l.get(fVar.f())).longValue());
                                }
                            }
                            arrayList.add(c15315jN4S);
                        }
                        C8626Wt6 c8626Wt6K = this.d.k(vVar.l(), t(arrayList), cVarW);
                        if (vVar.o() == 5 && vVar.g() != null) {
                            c8626Wt6K.f(C13987h93.b(vVar.g()));
                        }
                        try {
                            CaptureRequest captureRequestF = AbstractC21817uB0.f(aVarJ.h(), cameraDevice, this.q);
                            if (captureRequestF != null) {
                                c8626Wt6K.g(captureRequestF);
                            }
                            return this.d.f(cameraDevice, c8626Wt6K, this.h);
                        } catch (CameraAccessException e) {
                            return WB2.j(e);
                        }
                    }
                    if (iOrdinal != 4) {
                        return WB2.j(new CancellationException("openCaptureSession() not execute in state: " + this.i));
                    }
                }
                return WB2.j(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private CameraCaptureSession.CaptureCallback o(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(GF0.a((JB0) it.next()));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return AbstractC19340qB0.a(arrayList);
    }

    private static List p(List list, int i) {
        try {
            return (List) OutputConfiguration.class.getMethod("createInstancesForMultiResolutionOutput", Collection.class, Integer.TYPE).invoke(null, list, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            PI3.c("CaptureSession", "Failed to create instances for multi-resolution output, " + e.getMessage());
            return null;
        }
    }

    private static Map q(Map map, Map map2) {
        HashMap map3 = new HashMap();
        for (Integer num : map.keySet()) {
            num.intValue();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (v.f fVar : (List) map.get(num)) {
                SurfaceUtil.a aVarA = SurfaceUtil.a((Surface) map2.get(fVar.f()));
                if (i == 0) {
                    i = aVarA.a;
                }
                AbstractC9613aG0.a();
                int i2 = aVarA.b;
                int i3 = aVarA.c;
                String strD = fVar.d();
                Objects.requireNonNull(strD);
                arrayList.add(ZF0.a(i2, i3, strD));
            }
            if (i == 0 || arrayList.isEmpty()) {
                PI3.c("CaptureSession", "Skips to create instances for multi-resolution output. imageFormat: " + i + ", streamInfos size: " + arrayList.size());
            } else {
                List listP = p(arrayList, i);
                if (listP != null) {
                    for (v.f fVar2 : (List) map.get(num)) {
                        OutputConfiguration outputConfiguration = (OutputConfiguration) listP.remove(0);
                        outputConfiguration.addSurface((Surface) map2.get(fVar2.f()));
                        map3.put(fVar2, new C15315jN4(outputConfiguration));
                    }
                }
            }
        }
        return map3;
    }

    private C15315jN4 s(v.f fVar, Map map, String str) {
        long jLongValue;
        DynamicRangeProfiles dynamicRangeProfilesD;
        Surface surface = (Surface) map.get(fVar.f());
        AbstractC4980Hj5.h(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        C15315jN4 c15315jN4 = new C15315jN4(fVar.g(), surface);
        if (str != null) {
            c15315jN4.g(str);
        } else {
            c15315jN4.g(fVar.d());
        }
        if (fVar.c() == 0) {
            c15315jN4.f(1);
        } else if (fVar.c() == 1) {
            c15315jN4.f(2);
        }
        if (!fVar.e().isEmpty()) {
            c15315jN4.b();
            Iterator it = fVar.e().iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) map.get((DeferrableSurface) it.next());
                AbstractC4980Hj5.h(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                c15315jN4.a(surface2);
            }
        }
        if (Build.VERSION.SDK_INT < 33 || (dynamicRangeProfilesD = this.p.d()) == null) {
            jLongValue = 1;
        } else {
            C15116j22 c15116j22B = fVar.b();
            Long lA = AbstractC16298l22.a(c15116j22B, dynamicRangeProfilesD);
            if (lA == null) {
                PI3.c("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + c15116j22B);
                jLongValue = 1;
            } else {
                jLongValue = lA.longValue();
            }
        }
        c15315jN4.e(jLongValue);
        return c15315jN4;
    }

    private List t(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C15315jN4 c15315jN4 = (C15315jN4) it.next();
            if (!arrayList.contains(c15315jN4.d())) {
                arrayList.add(c15315jN4.d());
                arrayList2.add(c15315jN4);
            }
        }
        return arrayList2;
    }

    private static Map u(Collection collection) {
        HashMap map = new HashMap();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            v.f fVar = (v.f) it.next();
            if (fVar.g() > 0 && fVar.e().isEmpty()) {
                List arrayList = (List) map.get(Integer.valueOf(fVar.g()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Integer.valueOf(fVar.g()), arrayList);
                }
                arrayList.add(fVar);
            }
        }
        HashMap map2 = new HashMap();
        for (Integer num : map.keySet()) {
            num.intValue();
            if (((List) map.get(num)).size() >= 2) {
                map2.put(num, (List) map.get(num));
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.a) {
            try {
                if (this.i == c.OPENED) {
                    x(this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        synchronized (this.a) {
            if (this.b.isEmpty()) {
                return;
            }
            try {
                v(this.b);
            } finally {
                this.b.clear();
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public void a(List list) {
        synchronized (this.a) {
            try {
                switch (this.i) {
                    case UNINITIALIZED:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.i);
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENING:
                        this.b.addAll(list);
                        break;
                    case OPENED:
                        this.b.addAll(list);
                        w();
                        break;
                    case CLOSED:
                    case RELEASING:
                    case RELEASED:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } finally {
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public boolean b() {
        boolean z;
        synchronized (this.a) {
            try {
                c cVar = this.i;
                z = cVar == c.OPENED || cVar == c.OPENING;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public void c() {
        ArrayList<androidx.camera.core.impl.i> arrayList;
        synchronized (this.a) {
            try {
                if (this.b.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(this.b);
                    this.b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            for (androidx.camera.core.impl.i iVar : arrayList) {
                Iterator it = iVar.c().iterator();
                while (it.hasNext()) {
                    ((JB0) it.next()).a(iVar.f());
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public void close() {
        synchronized (this.a) {
            try {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal == 0) {
                    throw new IllegalStateException("close() should not be possible in state: " + this.i);
                }
                if (iOrdinal == 1) {
                    this.i = c.RELEASED;
                } else if (iOrdinal == 2) {
                    AbstractC4980Hj5.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                    this.i = c.RELEASED;
                } else if (iOrdinal == 3 || iOrdinal == 4) {
                    AbstractC4980Hj5.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                    this.i = c.CLOSED;
                    this.o.i();
                    this.f = null;
                }
            } finally {
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public InterfaceFutureC15215jC3 d(boolean z) {
        synchronized (this.a) {
            switch (this.i) {
                case UNINITIALIZED:
                    throw new IllegalStateException("release() should not be possible in state: " + this.i);
                case GET_SURFACE:
                    AbstractC4980Hj5.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                case INITIALIZED:
                    this.i = c.RELEASED;
                    return WB2.l(null);
                case OPENED:
                case CLOSED:
                    InterfaceC18096o47 interfaceC18096o47 = this.e;
                    if (interfaceC18096o47 != null) {
                        if (z) {
                            try {
                                interfaceC18096o47.a();
                            } catch (CameraAccessException e) {
                                PI3.d("CaptureSession", "Unable to abort captures.", e);
                            }
                        }
                        this.e.close();
                    }
                case OPENING:
                    this.i = c.RELEASING;
                    this.o.i();
                    AbstractC4980Hj5.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    if (this.d.stop()) {
                        r();
                        return WB2.l(null);
                    }
                case RELEASING:
                    if (this.j == null) {
                        this.j = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.bG0
                            @Override // ir.nasim.AbstractC16967mA0.c
                            public final Object a(AbstractC16967mA0.a aVar) {
                                return this.a.B(aVar);
                            }
                        });
                    }
                    return this.j;
                default:
                    return WB2.l(null);
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public List e() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = Collections.unmodifiableList(this.b);
        }
        return listUnmodifiableList;
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public androidx.camera.core.impl.v f() {
        androidx.camera.core.impl.v vVar;
        synchronized (this.a) {
            vVar = this.f;
        }
        return vVar;
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public void g(androidx.camera.core.impl.v vVar) {
        synchronized (this.a) {
            try {
                switch (this.i) {
                    case UNINITIALIZED:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.i);
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENING:
                        this.f = vVar;
                        break;
                    case OPENED:
                        this.f = vVar;
                        if (vVar != null) {
                            if (!this.g.keySet().containsAll(vVar.n())) {
                                PI3.c("CaptureSession", "Does not have the proper configured lists");
                                return;
                            } else {
                                PI3.a("CaptureSession", "Attempting to submit CaptureRequest after setting");
                                x(this.f);
                                break;
                            }
                        } else {
                            return;
                        }
                    case CLOSED:
                    case RELEASING:
                    case RELEASED:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } finally {
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public InterfaceFutureC15215jC3 h(final androidx.camera.core.impl.v vVar, final CameraDevice cameraDevice, InterfaceC18096o47.a aVar) {
        synchronized (this.a) {
            try {
                if (this.i.ordinal() == 1) {
                    this.i = c.GET_SURFACE;
                    ArrayList arrayList = new ArrayList(vVar.n());
                    this.h = arrayList;
                    this.d = aVar;
                    NB2 nb2E = NB2.a(aVar.j(arrayList, 5000L)).e(new FK() { // from class: ir.nasim.cG0
                        @Override // ir.nasim.FK
                        public final InterfaceFutureC15215jC3 apply(Object obj) {
                            return this.a.A(vVar, cameraDevice, (List) obj);
                        }
                    }, this.d.b());
                    WB2.g(nb2E, new a(), this.d.b());
                    return WB2.t(nb2E);
                }
                PI3.c("CaptureSession", "Open not allowed in state: " + this.i);
                return WB2.j(new IllegalStateException("open() should not allow the state: " + this.i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC13457gG0
    public void i(Map map) {
        synchronized (this.a) {
            this.l = map;
        }
    }

    void r() {
        c cVar = this.i;
        c cVar2 = c.RELEASED;
        if (cVar == cVar2) {
            PI3.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.i = cVar2;
        this.e = null;
        AbstractC16967mA0.a aVar = this.k;
        if (aVar != null) {
            aVar.c(null);
            this.k = null;
        }
    }

    int v(List list) {
        IB0 ib0;
        ArrayList arrayList;
        boolean z;
        synchronized (this.a) {
            try {
                if (this.i != c.OPENED) {
                    PI3.a("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return -1;
                }
                if (list.isEmpty()) {
                    return -1;
                }
                try {
                    ib0 = new IB0();
                    arrayList = new ArrayList();
                    PI3.a("CaptureSession", "Issuing capture request.");
                    Iterator it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        androidx.camera.core.impl.i iVar = (androidx.camera.core.impl.i) it.next();
                        if (iVar.i().isEmpty()) {
                            PI3.a("CaptureSession", "Skipping issuing empty capture request.");
                        } else {
                            Iterator it2 = iVar.i().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    DeferrableSurface deferrableSurface = (DeferrableSurface) it2.next();
                                    if (!this.g.containsKey(deferrableSurface)) {
                                        PI3.a("CaptureSession", "Skipping capture request with invalid surface: " + deferrableSurface);
                                        break;
                                    }
                                } else {
                                    if (iVar.k() == 2) {
                                        z = true;
                                    }
                                    i.a aVarJ = i.a.j(iVar);
                                    if (iVar.k() == 5 && iVar.d() != null) {
                                        aVarJ.n(iVar.d());
                                    }
                                    androidx.camera.core.impl.v vVar = this.f;
                                    if (vVar != null) {
                                        aVarJ.e(vVar.j().g());
                                    }
                                    aVarJ.e(iVar.g());
                                    CaptureRequest captureRequestE = AbstractC21817uB0.e(aVarJ.h(), this.e.h(), this.g, false, this.q);
                                    if (captureRequestE == null) {
                                        PI3.a("CaptureSession", "Skipping issuing request without surface.");
                                        return -1;
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator it3 = iVar.c().iterator();
                                    while (it3.hasNext()) {
                                        GF0.b((JB0) it3.next(), arrayList2);
                                    }
                                    ib0.a(captureRequestE, arrayList2);
                                    arrayList.add(captureRequestE);
                                }
                            }
                        }
                    }
                } catch (CameraAccessException e) {
                    PI3.c("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                if (arrayList.isEmpty()) {
                    PI3.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                    return -1;
                }
                if (this.m.a(arrayList, z)) {
                    this.e.d();
                    ib0.c(new IB0.a() { // from class: ir.nasim.eG0
                        @Override // ir.nasim.IB0.a
                        public final void a(CameraCaptureSession cameraCaptureSession, int i, boolean z2) {
                            this.a.y(cameraCaptureSession, i, z2);
                        }
                    });
                }
                if (this.n.b(arrayList, z)) {
                    ib0.a((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new b()));
                }
                return this.e.l(arrayList, ib0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void w() {
        this.o.e().j(new Runnable() { // from class: ir.nasim.dG0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        }, AbstractC20567sE0.a());
    }

    int x(androidx.camera.core.impl.v vVar) {
        synchronized (this.a) {
            try {
            } catch (Throwable th) {
                throw th;
            }
            if (vVar == null) {
                PI3.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            }
            if (this.i != c.OPENED) {
                PI3.a("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                return -1;
            }
            androidx.camera.core.impl.i iVarJ = vVar.j();
            if (iVarJ.i().isEmpty()) {
                PI3.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                try {
                    this.e.d();
                } catch (CameraAccessException e) {
                    PI3.c("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
                return -1;
            }
            try {
                PI3.a("CaptureSession", "Issuing request for session.");
                CaptureRequest captureRequestE = AbstractC21817uB0.e(iVarJ, this.e.h(), this.g, true, this.q);
                if (captureRequestE == null) {
                    PI3.a("CaptureSession", "Skipping issuing empty request for session.");
                    return -1;
                }
                return this.e.i(captureRequestE, this.o.d(o(iVarJ.c(), new CameraCaptureSession.CaptureCallback[0])));
            } catch (CameraAccessException e2) {
                PI3.c("CaptureSession", "Unable to access camera: " + e2.getMessage());
                Thread.dumpStack();
                return -1;
            }
            throw th;
        }
    }

    C12839fG0(C19253q22 c19253q22, boolean z) {
        this(c19253q22, new C6293Mz5(Collections.emptyList()), z);
    }

    C12839fG0(C19253q22 c19253q22, C6293Mz5 c6293Mz5) {
        this(c19253q22, c6293Mz5, false);
    }

    C12839fG0(C19253q22 c19253q22, C6293Mz5 c6293Mz5, boolean z) {
        this.a = new Object();
        this.b = new ArrayList();
        this.g = new HashMap();
        this.h = Collections.emptyList();
        this.i = c.UNINITIALIZED;
        this.l = new HashMap();
        this.m = new FN6();
        this.n = new C14427ht7();
        this.i = c.INITIALIZED;
        this.p = c19253q22;
        this.c = new d();
        this.o = new C17743nU5(c6293Mz5.a(CaptureNoResponseQuirk.class));
        this.q = new C24515yk7(c6293Mz5);
        this.r = z;
    }

    /* renamed from: ir.nasim.fG0$a */
    class a implements MB2 {
        a() {
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            synchronized (C12839fG0.this.a) {
                try {
                    C12839fG0.this.d.stop();
                    int iOrdinal = C12839fG0.this.i.ordinal();
                    if ((iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 6) && !(th instanceof CancellationException)) {
                        PI3.m("CaptureSession", "Opening session with fail " + C12839fG0.this.i, th);
                        C12839fG0.this.r();
                    }
                } finally {
                }
            }
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }
}
