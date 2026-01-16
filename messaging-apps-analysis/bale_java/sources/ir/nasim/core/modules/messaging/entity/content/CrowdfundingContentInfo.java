package ir.nasim.core.modules.messaging.entity.content;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC24063xz;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11909dl1;
import ir.nasim.C16247kx;
import ir.nasim.C8445Vz5;
import ir.nasim.ED1;
import ir.nasim.EnumC16838lx;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.SA2;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u00024/B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\fH\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0007¢\u0006\u0004\b*\u0010#J\u009c\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b\u0003\u00101R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u00102\u001a\u0004\b3\u0010.R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b4\u00102\u001a\u0004\b5\u0010.R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u00109R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b>\u00107\u001a\u0004\b<\u00109R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b?\u00107\u001a\u0004\b@\u00109R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010A\u001a\u0004\bB\u0010#\"\u0004\bC\u0010DR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u00102\u001a\u0004\b?\u0010.R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010A\u001a\u0004\bR\u0010#\"\u0004\bS\u0010DR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010F\u001a\u0004\bQ\u0010HR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00100\u001a\u0004\bT\u00101\"\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020W8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bE\u0010ZR\u0011\u0010\\\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b6\u00101R\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bK\u00109R\u0011\u0010]\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bX\u0010#R\u0011\u0010_\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b^\u00101R\u0011\u0010`\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b>\u00101¨\u0006a"}, d2 = {"Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "Landroid/os/Parcelable;", "", "isRemote", "", "title", "description", "", "startTime", "endTime", "amount", "quotaAmount", "", "payCount", "cardNumber", "", "msg", "Lir/nasim/lx;", "status", "senderId", "photoContent", DialogEntity.COLUMN_IS_FORWARDED, "<init>", "(ZLjava/lang/String;Ljava/lang/String;JJJJILjava/lang/String;[BLir/nasim/lx;I[BZ)V", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo$c;", "p", "()Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo$c;", "paidAmount", "m", "(J)I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "b", "(ZLjava/lang/String;Ljava/lang/String;JJJJILjava/lang/String;[BLir/nasim/lx;I[BZ)Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "toString", "()Ljava/lang/String;", "a", "Z", "()Z", "Ljava/lang/String;", "s", "c", "h", "d", "J", "q", "()J", "z", "(J)V", "e", "i", "f", "g", "n", TokenNames.I, "getPayCount", "x", "(I)V", "j", "[B", "getMsg", "()[B", "w", "([B)V", "k", "Lir/nasim/lx;", "r", "()Lir/nasim/lx;", "A", "(Lir/nasim/lx;)V", "l", "getSenderId", "y", "u", "setForwarded", "(Z)V", "Lir/nasim/J44;", "o", "Lir/nasim/Yu3;", "()Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "amISender", "remainQuota", "t", "isComplete", "canIDeleteIt", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class CrowdfundingContentInfo implements Parcelable {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final boolean isRemote;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String title;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String description;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final long endTime;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final long amount;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final long quotaAmount;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private int payCount;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private final String cardNumber;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    private byte[] msg;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    private EnumC16838lx status;

    /* renamed from: l, reason: from kotlin metadata and from toString */
    private int senderId;

    /* renamed from: m, reason: from kotlin metadata and from toString */
    private final byte[] photoContent;

    /* renamed from: n, reason: from kotlin metadata and from toString */
    private boolean isForwarded;

    /* renamed from: o, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 message;

    /* renamed from: p, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q = 8;
    public static final Parcelable.Creator<CrowdfundingContentInfo> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final CrowdfundingContentInfo a(String str, String str2, long j, long j2, long j3, String str3, byte[] bArr) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "description");
            AbstractC13042fc3.i(str3, "cardNumber");
            AbstractC13042fc3.i(bArr, "photoContent");
            return new CrowdfundingContentInfo(false, str, str2, System.currentTimeMillis(), j, j2, j3, 0, str3, null, EnumC16838lx.INPROGRESS, AbstractC5969Lp4.f(), bArr, false, 8704, null);
        }

        public final CrowdfundingContentInfo b(C11909dl1 c11909dl1) {
            AbstractC13042fc3.i(c11909dl1, "content");
            AbstractC24063xz abstractC24063xzC = c11909dl1.c();
            AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiCrowdFundingMessage");
            C16247kx c16247kx = (C16247kx) abstractC24063xzC;
            byte[] bArrO = AbstractC17457n0.o(AbstractC17457n0.h(c16247kx.z()));
            String strE = c16247kx.E();
            AbstractC13042fc3.h(strE, "getTitle(...)");
            String strW = c16247kx.w();
            AbstractC13042fc3.h(strW, "getDescription(...)");
            long jY = c16247kx.y();
            long jF = c16247kx.F();
            long jC = c16247kx.C();
            String strU = c16247kx.u();
            AbstractC13042fc3.h(strU, "getCardNumber(...)");
            byte[] byteArray = c11909dl1.c().toByteArray();
            AbstractC13042fc3.h(byteArray, "toByteArray(...)");
            EnumC16838lx enumC16838lxD = c16247kx.D();
            AbstractC13042fc3.f(enumC16838lxD);
            AbstractC13042fc3.f(bArrO);
            return new CrowdfundingContentInfo(true, strE, strW, -1L, jY, jF, jC, -1, strU, byteArray, enumC16838lxD, -1, bArrO, false, 8192, null);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CrowdfundingContentInfo createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new CrowdfundingContentInfo(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.createByteArray(), EnumC16838lx.valueOf(parcel.readString()), parcel.readInt(), parcel.createByteArray(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CrowdfundingContentInfo[] newArray(int i) {
            return new CrowdfundingContentInfo[i];
        }
    }

    public static final class c {
        private final int a;
        private final int b;
        private final int c;

        public c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.a;
        }

        public final String b() {
            int i = this.b;
            return (i < 10 ? "0" : "") + i;
        }

        public final String c() {
            int i = this.c;
            return (i < 10 ? "0" : "") + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "Time(days=" + this.a + ", hours=" + this.b + ", minutes=" + this.c + Separators.RPAREN;
        }
    }

    public CrowdfundingContentInfo(boolean z, String str, String str2, long j, long j2, long j3, long j4, int i, String str3, byte[] bArr, EnumC16838lx enumC16838lx, int i2, byte[] bArr2, boolean z2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "cardNumber");
        AbstractC13042fc3.i(bArr, "msg");
        AbstractC13042fc3.i(enumC16838lx, "status");
        AbstractC13042fc3.i(bArr2, "photoContent");
        this.isRemote = z;
        this.title = str;
        this.description = str2;
        this.startTime = j;
        this.endTime = j2;
        this.amount = j3;
        this.quotaAmount = j4;
        this.payCount = i;
        this.cardNumber = str3;
        this.msg = bArr;
        this.status = enumC16838lx;
        this.senderId = i2;
        this.photoContent = bArr2;
        this.isForwarded = z2;
        if (t()) {
            this.status = EnumC16838lx.DONE;
        } else if (p() == null) {
            this.status = EnumC16838lx.EXPIRED;
        }
        this.message = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jv1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CrowdfundingContentInfo.v(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final J44 v(CrowdfundingContentInfo crowdfundingContentInfo) {
        AbstractC13042fc3.i(crowdfundingContentInfo, "this$0");
        return J44.v.a(crowdfundingContentInfo.msg);
    }

    public final void A(EnumC16838lx enumC16838lx) {
        AbstractC13042fc3.i(enumC16838lx, "<set-?>");
        this.status = enumC16838lx;
    }

    public final CrowdfundingContentInfo b(boolean isRemote, String title, String description, long startTime, long endTime, long amount, long quotaAmount, int payCount, String cardNumber, byte[] msg, EnumC16838lx status, int senderId, byte[] photoContent, boolean isForwarded) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(description, "description");
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        AbstractC13042fc3.i(msg, "msg");
        AbstractC13042fc3.i(status, "status");
        AbstractC13042fc3.i(photoContent, "photoContent");
        return new CrowdfundingContentInfo(isRemote, title, description, startTime, endTime, amount, quotaAmount, payCount, cardNumber, msg, status, senderId, photoContent, isForwarded);
    }

    public final boolean d() {
        return this.senderId == AbstractC5969Lp4.f();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getAmount() {
        return this.amount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC13042fc3.d(CrowdfundingContentInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(other, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo");
        CrowdfundingContentInfo crowdfundingContentInfo = (CrowdfundingContentInfo) other;
        return AbstractC13042fc3.d(this.title, crowdfundingContentInfo.title) && AbstractC13042fc3.d(this.description, crowdfundingContentInfo.description) && this.startTime == crowdfundingContentInfo.startTime && this.endTime == crowdfundingContentInfo.endTime && this.amount == crowdfundingContentInfo.amount && this.quotaAmount == crowdfundingContentInfo.quotaAmount && this.payCount == crowdfundingContentInfo.payCount && AbstractC13042fc3.d(this.cardNumber, crowdfundingContentInfo.cardNumber) && Arrays.equals(this.msg, crowdfundingContentInfo.msg) && this.status == crowdfundingContentInfo.status && this.senderId == crowdfundingContentInfo.senderId;
    }

    public final boolean f() {
        C8445Vz5 c8445Vz5Q = j().Q();
        if ((c8445Vz5Q == null || !c8445Vz5Q.E()) && this.status == EnumC16838lx.INPROGRESS) {
            return p() == null && d();
        }
        return true;
    }

    /* renamed from: g, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: h, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return (((((((((((((((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + Long.hashCode(this.amount)) * 31) + Long.hashCode(this.quotaAmount)) * 31) + this.payCount) * 31) + this.cardNumber.hashCode()) * 31) + Arrays.hashCode(this.msg)) * 31) + this.status.hashCode()) * 31) + this.senderId;
    }

    /* renamed from: i, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    public final J44 j() {
        return (J44) this.message.getValue();
    }

    public final long k() {
        return this.payCount * this.quotaAmount;
    }

    /* renamed from: l, reason: from getter */
    public final byte[] getPhotoContent() {
        return this.photoContent;
    }

    public final int m(long paidAmount) {
        return (int) ((paidAmount / this.amount) * 100);
    }

    /* renamed from: n, reason: from getter */
    public final long getQuotaAmount() {
        return this.quotaAmount;
    }

    public final int o() {
        return (int) ((this.amount - k()) / this.quotaAmount);
    }

    public final c p() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.endTime;
        if (jCurrentTimeMillis > j) {
            return null;
        }
        long j2 = j - jCurrentTimeMillis;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j2);
        long hours = timeUnit.toHours(j2);
        long days = timeUnit.toDays(j2);
        if (minutes + hours + hours >= 1) {
            return new c((int) days, (int) hours, ((int) minutes) % 60);
        }
        return null;
    }

    /* renamed from: q, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: r, reason: from getter */
    public final EnumC16838lx getStatus() {
        return this.status;
    }

    /* renamed from: s, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean t() {
        return k() >= this.amount;
    }

    public String toString() {
        return "CrowdfundingContentInfo(isRemote=" + this.isRemote + ", title=" + this.title + ", description=" + this.description + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", amount=" + this.amount + ", quotaAmount=" + this.quotaAmount + ", payCount=" + this.payCount + ", cardNumber=" + this.cardNumber + ", msg=" + Arrays.toString(this.msg) + ", status=" + this.status + ", senderId=" + this.senderId + ", photoContent=" + Arrays.toString(this.photoContent) + ", isForwarded=" + this.isForwarded + Separators.RPAREN;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsForwarded() {
        return this.isForwarded;
    }

    public final void w(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<set-?>");
        this.msg = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.isRemote ? 1 : 0);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeLong(this.amount);
        dest.writeLong(this.quotaAmount);
        dest.writeInt(this.payCount);
        dest.writeString(this.cardNumber);
        dest.writeByteArray(this.msg);
        dest.writeString(this.status.name());
        dest.writeInt(this.senderId);
        dest.writeByteArray(this.photoContent);
        dest.writeInt(this.isForwarded ? 1 : 0);
    }

    public final void x(int i) {
        this.payCount = i;
    }

    public final void y(int i) {
        this.senderId = i;
    }

    public final void z(long j) {
        this.startTime = j;
    }

    public /* synthetic */ CrowdfundingContentInfo(boolean z, String str, String str2, long j, long j2, long j3, long j4, int i, String str3, byte[] bArr, EnumC16838lx enumC16838lx, int i2, byte[] bArr2, boolean z2, int i3, ED1 ed1) {
        this(z, str, str2, j, j2, j3, j4, i, str3, (i3 & 512) != 0 ? new byte[0] : bArr, enumC16838lx, i2, bArr2, (i3 & 8192) != 0 ? false : z2);
    }
}
