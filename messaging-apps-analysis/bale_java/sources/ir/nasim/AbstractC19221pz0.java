package ir.nasim;

import ir.nasim.features.call.service.CallService;
import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.pz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19221pz0 {
    public static void a(CallService callService, C6409Nm c6409Nm) {
        callService.analyticsRepository = c6409Nm;
    }

    public static void b(CallService callService, C15838kG c15838kG) {
        callService.applyConnectedRoomStateUserCase = c15838kG;
    }

    public static void c(CallService callService, C5344Iy0 c5344Iy0) {
        callService.callRingtoneHandler = c5344Iy0;
    }

    public static void d(CallService callService, OkHttpClient okHttpClient) {
        callService.okHttpClient = okHttpClient;
    }

    public static void e(CallService callService, InterfaceC11621dJ7 interfaceC11621dJ7) {
        callService.userRepository = interfaceC11621dJ7;
    }

    public static void f(CallService callService, C9728aS7 c9728aS7) {
        callService.versionCodeNumber = c9728aS7;
    }

    public static void g(CallService callService, C21786u78 c21786u78) {
        callService.webRtcStatsRepository = c21786u78;
    }
}
