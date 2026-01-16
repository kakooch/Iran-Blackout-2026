package ir.nasim;

import android.os.Build;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import livekit.LivekitModels$ClientInfo;

/* renamed from: ir.nasim.vV0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22587vV0 {
    public static final LivekitModels$ClientInfo a() {
        LivekitModels$ClientInfo.a aVarNewBuilder = LivekitModels$ClientInfo.newBuilder();
        aVarNewBuilder.D(LivekitModels$ClientInfo.b.ANDROID);
        aVarNewBuilder.E("2.20.2");
        aVarNewBuilder.B(ConstantDeviceInfo.APP_PLATFORM);
        String str = Build.VERSION.RELEASE;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        aVarNewBuilder.C(str);
        String str3 = Build.MANUFACTURER;
        if (str3 == null) {
            str3 = "";
        } else {
            AbstractC13042fc3.f(str3);
        }
        String str4 = Build.MODEL;
        if (str4 != null) {
            AbstractC13042fc3.f(str4);
            str2 = str4;
        }
        aVarNewBuilder.A(AbstractC20762sZ6.n1(str3 + ' ' + str2).toString());
        return (LivekitModels$ClientInfo) aVarNewBuilder.a();
    }
}
