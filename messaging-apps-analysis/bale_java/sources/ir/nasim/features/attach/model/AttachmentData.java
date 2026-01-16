package ir.nasim.features.attach.model;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import java.util.ArrayList;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u00020\u0007`\u0003¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u00020\u0007`\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJB\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u00020\u0007`\u0003HÇ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001R(\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR(\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u00020\u0007`\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lir/nasim/features/attach/model/AttachmentData;", "", "bankAttachments", "Lkotlin/collections/ArrayList;", "Lir/nasim/features/attach/model/BankAttachment;", "Ljava/util/ArrayList;", "shareAttachments", "Lir/nasim/features/attach/model/ShareAttachment;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getBankAttachments", "()Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "getShareAttachments", "component1", "component2", "copy", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)Lir/nasim/features/attach/model/AttachmentData;", "equals", "", "other", "hashCode", "", "toString", "", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class AttachmentData {
    public static final int $stable = 8;

    @InterfaceC23984xq6("BankItems")
    private final ArrayList<BankAttachment> bankAttachments;

    @InterfaceC23984xq6("ShareItems")
    private final ArrayList<ShareAttachment> shareAttachments;

    public AttachmentData(ArrayList<BankAttachment> arrayList, ArrayList<ShareAttachment> arrayList2) {
        AbstractC13042fc3.i(arrayList, "bankAttachments");
        AbstractC13042fc3.i(arrayList2, "shareAttachments");
        this.bankAttachments = arrayList;
        this.shareAttachments = arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttachmentData copy$default(AttachmentData attachmentData, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = attachmentData.bankAttachments;
        }
        if ((i & 2) != 0) {
            arrayList2 = attachmentData.shareAttachments;
        }
        return attachmentData.copy(arrayList, arrayList2);
    }

    public final ArrayList<BankAttachment> component1() {
        return this.bankAttachments;
    }

    public final ArrayList<ShareAttachment> component2() {
        return this.shareAttachments;
    }

    public final AttachmentData copy(ArrayList<BankAttachment> bankAttachments, ArrayList<ShareAttachment> shareAttachments) {
        AbstractC13042fc3.i(bankAttachments, "bankAttachments");
        AbstractC13042fc3.i(shareAttachments, "shareAttachments");
        return new AttachmentData(bankAttachments, shareAttachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentData)) {
            return false;
        }
        AttachmentData attachmentData = (AttachmentData) other;
        return AbstractC13042fc3.d(this.bankAttachments, attachmentData.bankAttachments) && AbstractC13042fc3.d(this.shareAttachments, attachmentData.shareAttachments);
    }

    public final ArrayList<BankAttachment> getBankAttachments() {
        return this.bankAttachments;
    }

    public final ArrayList<ShareAttachment> getShareAttachments() {
        return this.shareAttachments;
    }

    public int hashCode() {
        return (this.bankAttachments.hashCode() * 31) + this.shareAttachments.hashCode();
    }

    public String toString() {
        return "AttachmentData(bankAttachments=" + this.bankAttachments + ", shareAttachments=" + this.shareAttachments + Separators.RPAREN;
    }
}
