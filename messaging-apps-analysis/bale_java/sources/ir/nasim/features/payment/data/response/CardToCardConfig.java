package ir.nasim.features.payment.data.response;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÇ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\nR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001f"}, d2 = {"Lir/nasim/features/payment/data/response/CardToCardConfig;", "", "Lir/nasim/features/payment/data/response/Status;", "status", "", "Lir/nasim/features/payment/data/response/Bank;", "BankList", "<init>", "(Lir/nasim/features/payment/data/response/Status;Ljava/util/List;)V", "component1", "()Lir/nasim/features/payment/data/response/Status;", "component2", "()Ljava/util/List;", "copy", "(Lir/nasim/features/payment/data/response/Status;Ljava/util/List;)Lir/nasim/features/payment/data/response/CardToCardConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/features/payment/data/response/Status;", "getStatus", "Ljava/util/List;", "getBankList", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class CardToCardConfig {
    public static final String CONFIG_KEY = "Config";

    @InterfaceC23984xq6("BankList")
    private final List<Bank> BankList;

    @InterfaceC23984xq6("Status")
    private final Status status;
    public static final int $stable = 8;

    public CardToCardConfig(Status status, List<Bank> list) {
        AbstractC13042fc3.i(status, "status");
        AbstractC13042fc3.i(list, "BankList");
        this.status = status;
        this.BankList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardToCardConfig copy$default(CardToCardConfig cardToCardConfig, Status status, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            status = cardToCardConfig.status;
        }
        if ((i & 2) != 0) {
            list = cardToCardConfig.BankList;
        }
        return cardToCardConfig.copy(status, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final List<Bank> component2() {
        return this.BankList;
    }

    public final CardToCardConfig copy(Status status, List<Bank> BankList) {
        AbstractC13042fc3.i(status, "status");
        AbstractC13042fc3.i(BankList, "BankList");
        return new CardToCardConfig(status, BankList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardToCardConfig)) {
            return false;
        }
        CardToCardConfig cardToCardConfig = (CardToCardConfig) other;
        return AbstractC13042fc3.d(this.status, cardToCardConfig.status) && AbstractC13042fc3.d(this.BankList, cardToCardConfig.BankList);
    }

    public final List<Bank> getBankList() {
        return this.BankList;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.BankList.hashCode();
    }

    public String toString() {
        return "CardToCardConfig(status=" + this.status + ", BankList=" + this.BankList + Separators.RPAREN;
    }
}
