package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.settings.SettingsModule;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class S37 {
    public static final S37 a = new S37();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC13941h47.values().length];
            try {
                iArr[EnumC13941h47.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    private S37() {
    }

    public final InterfaceC24937zS7 a(EnumC13941h47 enumC13941h47, InterfaceC20315ro1 interfaceC20315ro1, Y08 y08, Context context, boolean z, boolean z2, C9728aS7 c9728aS7, C21786u78 c21786u78, OkHttpClient okHttpClient) {
        AbstractC13042fc3.i(enumC13941h47, "switchType");
        AbstractC13042fc3.i(interfaceC20315ro1, "serviceScope");
        AbstractC13042fc3.i(y08, "voiceSwitchCallback");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9728aS7, "versionCodeNumber");
        AbstractC13042fc3.i(c21786u78, "webRtcStatsRepository");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        if (a.a[enumC13941h47.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        if (z2) {
            A08 a08X = AbstractC5969Lp4.d().o2().X();
            AbstractC13042fc3.h(a08X, "getVoiceCallModule(...)");
            SettingsModule settingsModuleS = AbstractC5969Lp4.d().o2().S();
            AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
            return new C23024wD3(a08X, settingsModuleS, y08, new C17536n78(interfaceC20315ro1, c21786u78, z), interfaceC20315ro1, context, okHttpClient);
        }
        A08 a08X2 = AbstractC5969Lp4.d().o2().X();
        AbstractC13042fc3.h(a08X2, "getVoiceCallModule(...)");
        SettingsModule settingsModuleS2 = AbstractC5969Lp4.d().o2().S();
        AbstractC13042fc3.h(settingsModuleS2, "getSettingsModule(...)");
        return new C15815kD3(a08X2, settingsModuleS2, y08, new C17536n78(interfaceC20315ro1, c21786u78, z), interfaceC20315ro1, context, c9728aS7, okHttpClient);
    }
}
