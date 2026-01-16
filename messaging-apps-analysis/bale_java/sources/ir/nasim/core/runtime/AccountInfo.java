package ir.nasim.core.runtime;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\"\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u001bBe\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jp\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0015R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b$\u0010'R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010%\u001a\u0004\b(\u0010'R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b&\u0010*\u001a\u0004\b,\u0010+R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b-\u0010\u001e¨\u0006."}, d2 = {"Lir/nasim/core/runtime/AccountInfo;", "", "", "isAuthCompleted", "", "uid", "", "jwt", "", "phone", "accessHash", "authId", "", "masterKey", "user", "syncContacts", "<init>", "(ZILjava/lang/String;JJJ[B[BZ)V", "b", "(ZILjava/lang/String;JJJ[B[BZ)Lir/nasim/core/runtime/AccountInfo;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "l", "()Z", TokenNames.I, "j", "c", "Ljava/lang/String;", "f", "d", "J", "h", "()J", "e", "g", "[B", "()[B", "k", "i", "base_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class AccountInfo {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Keep
    private static AccountInfo testAccountInfo = new AccountInfo(false, -1, "", -1, -1, -1, new byte[0], new byte[0], false);

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final boolean isAuthCompleted;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final int uid;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String jwt;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final long phone;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final long accessHash;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final long authId;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final byte[] masterKey;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private final byte[] user;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private final boolean syncContacts;

    /* renamed from: ir.nasim.core.runtime.AccountInfo$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final AccountInfo a() {
            return AccountInfo.testAccountInfo;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public AccountInfo(boolean z, int i, String str, long j, long j2, long j3, byte[] bArr, byte[] bArr2, boolean z2) {
        this.isAuthCompleted = z;
        this.uid = i;
        this.jwt = str;
        this.phone = j;
        this.accessHash = j2;
        this.authId = j3;
        this.masterKey = bArr;
        this.user = bArr2;
        this.syncContacts = z2;
    }

    public final AccountInfo b(boolean isAuthCompleted, int uid, String jwt, long phone, long accessHash, long authId, byte[] masterKey, byte[] user, boolean syncContacts) {
        return new AccountInfo(isAuthCompleted, uid, jwt, phone, accessHash, authId, masterKey, user, syncContacts);
    }

    /* renamed from: d, reason: from getter */
    public final long getAccessHash() {
        return this.accessHash;
    }

    /* renamed from: e, reason: from getter */
    public final long getAuthId() {
        return this.authId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) other;
        return this.isAuthCompleted == accountInfo.isAuthCompleted && this.uid == accountInfo.uid && AbstractC13042fc3.d(this.jwt, accountInfo.jwt) && this.phone == accountInfo.phone && this.accessHash == accountInfo.accessHash && this.authId == accountInfo.authId && AbstractC13042fc3.d(this.masterKey, accountInfo.masterKey) && AbstractC13042fc3.d(this.user, accountInfo.user) && this.syncContacts == accountInfo.syncContacts;
    }

    /* renamed from: f, reason: from getter */
    public final String getJwt() {
        return this.jwt;
    }

    /* renamed from: g, reason: from getter */
    public final byte[] getMasterKey() {
        return this.masterKey;
    }

    /* renamed from: h, reason: from getter */
    public final long getPhone() {
        return this.phone;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.isAuthCompleted) * 31) + Integer.hashCode(this.uid)) * 31;
        String str = this.jwt;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.phone)) * 31) + Long.hashCode(this.accessHash)) * 31) + Long.hashCode(this.authId)) * 31;
        byte[] bArr = this.masterKey;
        int iHashCode3 = (iHashCode2 + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
        byte[] bArr2 = this.user;
        return ((iHashCode3 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + Boolean.hashCode(this.syncContacts);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSyncContacts() {
        return this.syncContacts;
    }

    /* renamed from: j, reason: from getter */
    public final int getUid() {
        return this.uid;
    }

    /* renamed from: k, reason: from getter */
    public final byte[] getUser() {
        return this.user;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsAuthCompleted() {
        return this.isAuthCompleted;
    }

    public String toString() {
        return "AccountInfo(isAuthCompleted=" + this.isAuthCompleted + ", uid=" + this.uid + ", jwt=" + this.jwt + ", phone=" + this.phone + ", accessHash=" + this.accessHash + ", authId=" + this.authId + ", masterKey=" + Arrays.toString(this.masterKey) + ", user=" + Arrays.toString(this.user) + ", syncContacts=" + this.syncContacts + Separators.RPAREN;
    }
}
