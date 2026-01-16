package ir.nasim.app;

import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.InterfaceC18033ny3;
import ir.nasim.InterfaceC7720Sx5;
import ir.nasim.PH3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lir/nasim/app/ApplicationBale;", "Lir/nasim/app/ApplicationCore;", "<init>", "()V", "Lir/nasim/rB7;", TokenNames.L, "onCreate", "Lir/nasim/Sx5;", "Lir/nasim/ny3;", "i", "Lir/nasim/Sx5;", TokenNames.K, "()Lir/nasim/Sx5;", "setLeakCanaryInstallerProvider", "(Lir/nasim/Sx5;)V", "leakCanaryInstallerProvider", "app_productionMyketRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class ApplicationBale extends Hilt_ApplicationBale {

    /* renamed from: i, reason: from kotlin metadata */
    public InterfaceC7720Sx5 leakCanaryInstallerProvider;

    public ApplicationBale() {
        if (AbstractC20762sZ6.X("release", "benchmark", false, 2, null)) {
            PH3.a.g("en");
        }
    }

    private final void L() {
        ((InterfaceC18033ny3) K().get()).a(this);
    }

    public final InterfaceC7720Sx5 K() {
        InterfaceC7720Sx5 interfaceC7720Sx5 = this.leakCanaryInstallerProvider;
        if (interfaceC7720Sx5 != null) {
            return interfaceC7720Sx5;
        }
        AbstractC13042fc3.y("leakCanaryInstallerProvider");
        return null;
    }

    @Override // ir.nasim.app.Hilt_ApplicationBale, ir.nasim.app.ApplicationCore, android.app.Application
    public void onCreate() throws Resources.NotFoundException, NumberFormatException {
        super.onCreate();
        if (getIsTestMode()) {
            return;
        }
        L();
    }
}
