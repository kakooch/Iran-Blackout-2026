package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import io.livekit.android.renderer.TextureViewRenderer;
import io.livekit.android.room.Room;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.RendererCommon;

/* loaded from: classes5.dex */
public abstract class UU7 {

    public static final class b implements KV1 {
        final /* synthetic */ C21396tb1 a;
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        public b(C21396tb1 c21396tb1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
            this.a = c21396tb1;
            this.b = interfaceC9102Ym4;
            this.c = interfaceC9102Ym42;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            this.a.e();
            UU7.j(this.b, this.c);
        }
    }

    public static final class c implements KV1 {
        final /* synthetic */ InterfaceC9102Ym4 a;

        public c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9102Ym4;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            TextureViewRenderer textureViewRendererV = UU7.v(this.a);
            if (textureViewRendererV != null) {
                textureViewRendererV.j();
            }
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC19000pc6.values().length];
            try {
                iArr[EnumC19000pc6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC19000pc6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final io.livekit.android.room.Room r22, final ir.nasim.EV7 r23, androidx.compose.ui.e r24, boolean r25, ir.nasim.EnumC19000pc6 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UU7.i(io.livekit.android.room.Room, ir.nasim.EV7, androidx.compose.ui.e, boolean, ir.nasim.pc6, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
        EV7 ev7T;
        TextureViewRenderer textureViewRendererV = v(interfaceC9102Ym4);
        if (textureViewRendererV != null && (ev7T = t(interfaceC9102Ym42)) != null) {
            ev7T.u(textureViewRendererV);
        }
        u(interfaceC9102Ym42, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(Room room, EV7 ev7, androidx.compose.ui.e eVar, boolean z, EnumC19000pc6 enumC19000pc6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(room, "$room");
        i(room, ev7, eVar, z, enumC19000pc6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 l(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, LV1 lv1) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$view$delegate");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        TextureViewRenderer textureViewRendererV = v(interfaceC9102Ym4);
        if (textureViewRendererV != null) {
            textureViewRendererV.setMirror(z);
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 m(C21396tb1 c21396tb1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, LV1 lv1) {
        AbstractC13042fc3.i(c21396tb1, "$videoSinkVisibility");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$view$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$boundVideoTrack$delegate");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        return new b(c21396tb1, interfaceC9102Ym4, interfaceC9102Ym42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 n(InterfaceC9102Ym4 interfaceC9102Ym4, LV1 lv1) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$view$delegate");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        return new c(interfaceC9102Ym4);
    }

    private static final int o(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C21396tb1 c21396tb1, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(c21396tb1, "$videoSinkVisibility");
        AbstractC13042fc3.i(interfaceC11379cu3, "it");
        c21396tb1.f(interfaceC11379cu3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View q(Room room, EV7 ev7, EnumC19000pc6 enumC19000pc6, InterfaceC9102Ym4 interfaceC9102Ym4, C21396tb1 c21396tb1, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, Context context) {
        AbstractC13042fc3.i(room, "$room");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$localId$delegate");
        AbstractC13042fc3.i(c21396tb1, "$videoSinkVisibility");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$boundVideoTrack$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym43, "$view$delegate");
        AbstractC13042fc3.i(context, "context");
        try {
            TextureViewRenderer textureViewRenderer = new TextureViewRenderer(context);
            textureViewRenderer.setId(o(interfaceC9102Ym4));
            room.W0(textureViewRenderer);
            x(c21396tb1, interfaceC9102Ym42, interfaceC9102Ym43, ev7, textureViewRenderer);
            int i = d.a[enumC19000pc6.ordinal()];
            if (i == 1) {
                textureViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                textureViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
            }
            w(interfaceC9102Ym43, textureViewRenderer);
            return textureViewRenderer;
        } catch (Exception e) {
            C19406qI3.a("VideoRenderer", "exception " + e, new Object[0]);
            return new FrameLayout(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC9102Ym4 interfaceC9102Ym4, EV7 ev7, C21396tb1 c21396tb1, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, View view) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$localId$delegate");
        AbstractC13042fc3.i(c21396tb1, "$videoSinkVisibility");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$boundVideoTrack$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym43, "$view$delegate");
        AbstractC13042fc3.i(view, "v");
        TextureViewRenderer textureViewRenderer = (TextureViewRenderer) view.findViewById(o(interfaceC9102Ym4));
        if (textureViewRenderer != null) {
            try {
                x(c21396tb1, interfaceC9102Ym42, interfaceC9102Ym43, ev7, textureViewRenderer);
            } catch (Exception e) {
                C19406qI3.a("VideoRenderer", "exception " + e, new Object[0]);
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(Room room, EV7 ev7, androidx.compose.ui.e eVar, boolean z, EnumC19000pc6 enumC19000pc6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(room, "$room");
        i(room, ev7, eVar, z, enumC19000pc6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final EV7 t(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (EV7) interfaceC9102Ym4.getValue();
    }

    private static final void u(InterfaceC9102Ym4 interfaceC9102Ym4, EV7 ev7) {
        interfaceC9102Ym4.setValue(ev7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextureViewRenderer v(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (TextureViewRenderer) interfaceC9102Ym4.getValue();
    }

    private static final void w(InterfaceC9102Ym4 interfaceC9102Ym4, TextureViewRenderer textureViewRenderer) {
        interfaceC9102Ym4.setValue(textureViewRenderer);
    }

    private static final void x(C21396tb1 c21396tb1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, EV7 ev7, TextureViewRenderer textureViewRenderer) {
        if (AbstractC13042fc3.d(t(interfaceC9102Ym4), ev7)) {
            return;
        }
        j(interfaceC9102Ym42, interfaceC9102Ym4);
        u(interfaceC9102Ym4, ev7);
        if (ev7 != null) {
            if (ev7 instanceof CN5) {
                ((CN5) ev7).w(textureViewRenderer, c21396tb1);
            } else {
                ev7.r(textureViewRenderer);
            }
        }
    }

    public static final class a implements KV1 {
        @Override // ir.nasim.KV1
        public void dispose() {
        }
    }
}
