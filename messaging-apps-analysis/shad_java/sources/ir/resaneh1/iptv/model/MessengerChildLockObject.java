package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import java.util.HashSet;
import java.util.Set;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class MessengerChildLockObject {
    public Set<String> exceptionsPlus = new HashSet();
    public Set<String> exceptionsMines = new HashSet();
    public AccessLevelEnum accessLevel = AccessLevelEnum.Everybody;

    public enum AccessLevelEnum {
        Everybody,
        Nobody
    }

    public String getAccessString() {
        AccessLevelEnum accessLevelEnum = this.accessLevel;
        if (accessLevelEnum == AccessLevelEnum.Everybody) {
            String string = LocaleController.getString(R.string.LastSeenEverybody);
            Set<String> set = this.exceptionsMines;
            if (set == null || set.size() <= 0) {
                return string;
            }
            return string + " (-" + NumberUtils.toPersian(this.exceptionsMines.size()) + ")";
        }
        if (accessLevelEnum != AccessLevelEnum.Nobody) {
            return BuildConfig.FLAVOR;
        }
        String string2 = LocaleController.getString(R.string.LastSeenNobody);
        Set<String> set2 = this.exceptionsPlus;
        if (set2 == null || set2.size() <= 0) {
            return string2;
        }
        return string2 + " (+" + NumberUtils.toPersian(this.exceptionsPlus.size()) + ")";
    }
}
