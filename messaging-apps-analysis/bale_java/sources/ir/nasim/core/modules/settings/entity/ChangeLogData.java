package ir.nasim.core.modules.settings.entity;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lir/nasim/core/modules/settings/entity/ChangeLogData;", "", "versionName", "", "changeLog", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVersionName", "()Ljava/lang/String;", "getChangeLog", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class ChangeLogData {
    public static final int $stable = 8;

    @InterfaceC23984xq6("changeLog")
    private final List<String> changeLog;

    @InterfaceC23984xq6("versionName")
    private final String versionName;

    /* JADX WARN: Multi-variable type inference failed */
    public ChangeLogData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeLogData copy$default(ChangeLogData changeLogData, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changeLogData.versionName;
        }
        if ((i & 2) != 0) {
            list = changeLogData.changeLog;
        }
        return changeLogData.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    public final List<String> component2() {
        return this.changeLog;
    }

    public final ChangeLogData copy(String versionName, List<String> changeLog) {
        return new ChangeLogData(versionName, changeLog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeLogData)) {
            return false;
        }
        ChangeLogData changeLogData = (ChangeLogData) other;
        return AbstractC13042fc3.d(this.versionName, changeLogData.versionName) && AbstractC13042fc3.d(this.changeLog, changeLogData.changeLog);
    }

    public final List<String> getChangeLog() {
        return this.changeLog;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        String str = this.versionName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.changeLog;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ChangeLogData(versionName=" + this.versionName + ", changeLog=" + this.changeLog + Separators.RPAREN;
    }

    public ChangeLogData(String str, List<String> list) {
        this.versionName = str;
        this.changeLog = list;
    }

    public /* synthetic */ ChangeLogData(String str, List list, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }
}
