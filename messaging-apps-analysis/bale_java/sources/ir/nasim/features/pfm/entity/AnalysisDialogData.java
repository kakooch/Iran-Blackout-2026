package ir.nasim.features.pfm.entity;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0011\u001a\u00020\u0012H×\u0001J\t\u0010\u0013\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lir/nasim/features/pfm/entity/AnalysisDialogData;", "", "title", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "isEmpty", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class AnalysisDialogData {
    public static final int $stable = 0;

    @InterfaceC23984xq6("description")
    private final String description;

    @InterfaceC23984xq6("title")
    private final String title;

    public AnalysisDialogData(String str, String str2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        this.title = str;
        this.description = str2;
    }

    public static /* synthetic */ AnalysisDialogData copy$default(AnalysisDialogData analysisDialogData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analysisDialogData.title;
        }
        if ((i & 2) != 0) {
            str2 = analysisDialogData.description;
        }
        return analysisDialogData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AnalysisDialogData copy(String title, String description) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(description, "description");
        return new AnalysisDialogData(title, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisDialogData)) {
            return false;
        }
        AnalysisDialogData analysisDialogData = (AnalysisDialogData) other;
        return AbstractC13042fc3.d(this.title, analysisDialogData.title) && AbstractC13042fc3.d(this.description, analysisDialogData.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.description.hashCode();
    }

    public final boolean isEmpty() {
        return AbstractC13042fc3.d(this.title, "") || AbstractC13042fc3.d(this.description, "");
    }

    public String toString() {
        return "AnalysisDialogData(title=" + this.title + ", description=" + this.description + Separators.RPAREN;
    }
}
