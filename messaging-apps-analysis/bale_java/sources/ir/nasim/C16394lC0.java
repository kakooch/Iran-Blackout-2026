package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import ir.nasim.AbstractC6718Or3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import livekit.org.webrtc.Camera1Capturer;
import livekit.org.webrtc.Camera1Enumerator;
import livekit.org.webrtc.Camera1Helper;
import livekit.org.webrtc.Camera2Capturer;
import livekit.org.webrtc.Camera2Enumerator;
import livekit.org.webrtc.CameraEnumerator;
import livekit.org.webrtc.CameraVideoCapturer;
import livekit.org.webrtc.VideoCapturer;

/* renamed from: ir.nasim.lC0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16394lC0 {
    public static final C16394lC0 a;
    private static final List b;

    /* renamed from: ir.nasim.lC0$a */
    public static final class a {
        private final String a;
        private final EnumC23021wD0 b;

        public a(String str, EnumC23021wD0 enumC23021wD0) {
            AbstractC13042fc3.i(str, "deviceId");
            this.a = str;
            this.b = enumC23021wD0;
        }

        public final String a() {
            return this.a;
        }

        public final EnumC23021wD0 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            EnumC23021wD0 enumC23021wD0 = this.b;
            return iHashCode + (enumC23021wD0 == null ? 0 : enumC23021wD0.hashCode());
        }

        public String toString() {
            return "CameraDeviceInfo(deviceId=" + this.a + ", position=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.lC0$b */
    public interface b {
        int a();

        CameraEnumerator b(Context context);

        boolean c(Context context);

        VideoCapturer d(Context context, C23060wH3 c23060wH3, C9586aD0 c9586aD0);
    }

    /* renamed from: ir.nasim.lC0$c */
    public static final class c implements b {
        private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(a.e);
        private final int b = 1;

        /* renamed from: ir.nasim.lC0$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            public static final a e = new a();

            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Camera1Enumerator invoke() {
                return new Camera1Enumerator(true);
            }
        }

        c() {
        }

        private final Camera1Enumerator e() {
            return (Camera1Enumerator) this.a.getValue();
        }

        @Override // ir.nasim.C16394lC0.b
        public int a() {
            return this.b;
        }

        @Override // ir.nasim.C16394lC0.b
        public boolean c(Context context) {
            AbstractC13042fc3.i(context, "context");
            return true;
        }

        @Override // ir.nasim.C16394lC0.b
        public VideoCapturer d(Context context, C23060wH3 c23060wH3, C9586aD0 c9586aD0) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c23060wH3, "options");
            AbstractC13042fc3.i(c9586aD0, "eventsHandler");
            a aVarH = C16394lC0.h(C16394lC0.a, e(), c23060wH3.d(), c23060wH3.e(), false, 4, null);
            Camera1Helper.Companion companion = Camera1Helper.INSTANCE;
            companion.getSupportedFormats(companion.getCameraId(aVarH != null ? aVarH.a() : null));
            CameraVideoCapturer cameraVideoCapturerCreateCapturer = e().createCapturer(aVarH != null ? aVarH.a() : null, c9586aD0);
            AbstractC13042fc3.g(cameraVideoCapturerCreateCapturer, "null cannot be cast to non-null type livekit.org.webrtc.Camera1Capturer");
            return new C22398vA0((Camera1Capturer) cameraVideoCapturerCreateCapturer, aVarH != null ? aVarH.a() : null, c9586aD0);
        }

        @Override // ir.nasim.C16394lC0.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Camera1Enumerator b(Context context) {
            AbstractC13042fc3.i(context, "context");
            return e();
        }
    }

    /* renamed from: ir.nasim.lC0$d */
    public static final class d implements b {
        private Camera2Enumerator a;
        private final int b = 2;

        d() {
        }

        @Override // ir.nasim.C16394lC0.b
        public int a() {
            return this.b;
        }

        @Override // ir.nasim.C16394lC0.b
        public CameraEnumerator b(Context context) {
            AbstractC13042fc3.i(context, "context");
            Camera2Enumerator camera2Enumerator = this.a;
            if (camera2Enumerator != null) {
                return camera2Enumerator;
            }
            Camera2Enumerator camera2Enumerator2 = new Camera2Enumerator(context);
            this.a = camera2Enumerator2;
            return camera2Enumerator2;
        }

        @Override // ir.nasim.C16394lC0.b
        public boolean c(Context context) {
            AbstractC13042fc3.i(context, "context");
            return Camera2Enumerator.isSupported(context);
        }

        @Override // ir.nasim.C16394lC0.b
        public VideoCapturer d(Context context, C23060wH3 c23060wH3, C9586aD0 c9586aD0) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c23060wH3, "options");
            AbstractC13042fc3.i(c9586aD0, "eventsHandler");
            CameraEnumerator cameraEnumeratorB = b(context);
            a aVarH = C16394lC0.h(C16394lC0.a, cameraEnumeratorB, c23060wH3.d(), c23060wH3.e(), false, 4, null);
            CameraVideoCapturer cameraVideoCapturerCreateCapturer = cameraEnumeratorB.createCapturer(aVarH != null ? aVarH.a() : null, c9586aD0);
            AbstractC13042fc3.g(cameraVideoCapturerCreateCapturer, "null cannot be cast to non-null type livekit.org.webrtc.Camera2Capturer");
            Camera2Capturer camera2Capturer = (Camera2Capturer) cameraVideoCapturerCreateCapturer;
            Object systemService = context.getSystemService("camera");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return new C22407vB0(camera2Capturer, (CameraManager) systemService, aVarH != null ? aVarH.a() : null, c9586aD0);
        }
    }

    /* renamed from: ir.nasim.lC0$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(2);
            this.e = str;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str, EnumC23021wD0 enumC23021wD0) {
            AbstractC13042fc3.i(str, "id");
            return Boolean.valueOf(AbstractC13042fc3.d(str, this.e));
        }
    }

    /* renamed from: ir.nasim.lC0$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ EnumC23021wD0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(EnumC23021wD0 enumC23021wD0) {
            super(2);
            this.e = enumC23021wD0;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str, EnumC23021wD0 enumC23021wD0) {
            AbstractC13042fc3.i(str, "<anonymous parameter 0>");
            return Boolean.valueOf(enumC23021wD0 == this.e);
        }
    }

    /* renamed from: ir.nasim.lC0$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final g e = new g();

        g() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str, EnumC23021wD0 enumC23021wD0) {
            AbstractC13042fc3.i(str, "<anonymous parameter 0>");
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.lC0$h */
    public static final class h implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((b) obj2).a()), Integer.valueOf(((b) obj).a()));
        }
    }

    static {
        C16394lC0 c16394lC0 = new C16394lC0();
        a = c16394lC0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c16394lC0.a());
        arrayList.add(c16394lC0.b());
        b = arrayList;
    }

    private C16394lC0() {
    }

    private final c a() {
        return new c();
    }

    private final d b() {
        return new d();
    }

    private final XV4 c(Context context, b bVar, C23060wH3 c23060wH3) {
        CameraEnumerator cameraEnumeratorB = bVar.b(context);
        C9586aD0 c9586aD0 = new C9586aD0();
        a aVarH = h(this, cameraEnumeratorB, c23060wH3.d(), c23060wH3.e(), false, 4, null);
        if (aVarH == null) {
            return null;
        }
        VideoCapturer videoCapturerD = bVar.d(context, c23060wH3, c9586aD0);
        C23060wH3 c23060wH3B = C23060wH3.b(c23060wH3, false, aVarH.a(), aVarH.b(), null, 9, null);
        if (!(videoCapturerD instanceof BS7)) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.l(null, "unknown CameraCapturer class: " + videoCapturerD.getClass().getCanonicalName() + ". Reported dimensions may be inaccurate.", new Object[0]);
            }
        }
        return new XV4(videoCapturerD, c23060wH3B);
    }

    public static /* synthetic */ a h(C16394lC0 c16394lC0, CameraEnumerator cameraEnumerator, String str, EnumC23021wD0 enumC23021wD0, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            enumC23021wD0 = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return c16394lC0.g(cameraEnumerator, str, enumC23021wD0, z);
    }

    private final b i(Context context) {
        for (b bVar : AbstractC15401jX0.a1(b, new h())) {
            if (bVar.c(context)) {
                return bVar;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final XV4 d(Context context, C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c23060wH3, "options");
        XV4 xv4C = c(context, i(context), c23060wH3);
        if (xv4C != null) {
            return xv4C;
        }
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.d(null, "Failed to open camera", new Object[0]);
        }
        return null;
    }

    public final CameraEnumerator e(Context context) {
        AbstractC13042fc3.i(context, "context");
        return i(context).b(context);
    }

    public final a f(CameraEnumerator cameraEnumerator, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(cameraEnumerator, "<this>");
        AbstractC13042fc3.i(interfaceC14603iB2, "predicate");
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        AbstractC13042fc3.h(deviceNames, "getDeviceNames(...)");
        int length = deviceNames.length;
        int i = 0;
        while (true) {
            EnumC23021wD0 enumC23021wD0 = null;
            if (i >= length) {
                return null;
            }
            String str = deviceNames[i];
            if (cameraEnumerator.isFrontFacing(str)) {
                enumC23021wD0 = EnumC23021wD0.a;
            } else if (cameraEnumerator.isBackFacing(str)) {
                enumC23021wD0 = EnumC23021wD0.b;
            }
            AbstractC13042fc3.f(str);
            if (((Boolean) interfaceC14603iB2.invoke(str, enumC23021wD0)).booleanValue()) {
                return new a(str, enumC23021wD0);
            }
            i++;
        }
    }

    public final a g(CameraEnumerator cameraEnumerator, String str, EnumC23021wD0 enumC23021wD0, boolean z) {
        AbstractC13042fc3.i(cameraEnumerator, "<this>");
        a aVarF = str != null ? f(cameraEnumerator, new e(str)) : null;
        if (aVarF == null && enumC23021wD0 != null) {
            aVarF = f(cameraEnumerator, new f(enumC23021wD0));
        }
        return (aVarF == null && z) ? f(cameraEnumerator, g.e) : aVarF;
    }
}
