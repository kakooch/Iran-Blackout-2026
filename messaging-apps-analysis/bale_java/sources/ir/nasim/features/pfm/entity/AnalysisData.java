package ir.nasim.features.pfm.entity;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lir/nasim/features/pfm/entity/AnalysisData;", "", ParameterNames.TEXT, "", "command", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getCommand", "getTime", "()J", "isEmpty", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class AnalysisData {
    public static final int $stable = 0;

    @InterfaceC23984xq6("command")
    private final String command;

    @InterfaceC23984xq6(ParameterNames.TEXT)
    private final String text;

    @InterfaceC23984xq6("timeInMS")
    private final long time;

    public AnalysisData(String str, String str2, long j) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(str2, "command");
        this.text = str;
        this.command = str2;
        this.time = j;
    }

    public static /* synthetic */ AnalysisData copy$default(AnalysisData analysisData, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analysisData.text;
        }
        if ((i & 2) != 0) {
            str2 = analysisData.command;
        }
        if ((i & 4) != 0) {
            j = analysisData.time;
        }
        return analysisData.copy(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final AnalysisData copy(String text, String command, long time) {
        AbstractC13042fc3.i(text, ParameterNames.TEXT);
        AbstractC13042fc3.i(command, "command");
        return new AnalysisData(text, command, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisData)) {
            return false;
        }
        AnalysisData analysisData = (AnalysisData) other;
        return AbstractC13042fc3.d(this.text, analysisData.text) && AbstractC13042fc3.d(this.command, analysisData.command) && this.time == analysisData.time;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getText() {
        return this.text;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.command.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public final boolean isEmpty() {
        return AbstractC13042fc3.d(this.text, "") || AbstractC13042fc3.d(this.command, "") || this.time == 0;
    }

    public String toString() {
        return "AnalysisData(text=" + this.text + ", command=" + this.command + ", time=" + this.time + Separators.RPAREN;
    }
}
