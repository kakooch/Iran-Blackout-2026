package ir.nasim.database.entity;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.Arrays;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b \b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b\u0007\u0010\u0017R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010\u001b¨\u0006*"}, d2 = {"Lir/nasim/database/entity/ContactEntity;", "", "", "id", "", "name", "", ContactEntity.COLUMN_IS_BOT, "", ContactEntity.COLUMN_SORT_KEY, "", ContactEntity.COLUMN_AVATAR_BYTE, "<init>", "(ILjava/lang/String;ZJ[B)V", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()Z", "component4", "()J", "component5", "()[B", "copy", "(ILjava/lang/String;ZJ[B)Lir/nasim/database/entity/ContactEntity;", "toString", TokenNames.I, "getId", "Ljava/lang/String;", "getName", "Z", "J", "getSortKey", "[B", "getAvatarByte", "Companion", "a", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class ContactEntity {
    public static final String COLUMN_AVATAR_BYTE = "avatarByte";
    public static final String COLUMN_AVATAR_JSON = "avatarJson";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IS_BOT = "isBot";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SORT_KEY = "sortKey";
    public static final String TABLE_NAME = "contacts";
    private final byte[] avatarByte;
    private final int id;
    private final boolean isBot;
    private final String name;
    private final long sortKey;

    public ContactEntity(int i, String str, boolean z, long j, byte[] bArr) {
        AbstractC13042fc3.i(str, "name");
        this.id = i;
        this.name = str;
        this.isBot = z;
        this.sortKey = j;
        this.avatarByte = bArr;
    }

    public static /* synthetic */ ContactEntity copy$default(ContactEntity contactEntity, int i, String str, boolean z, long j, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = contactEntity.id;
        }
        if ((i2 & 2) != 0) {
            str = contactEntity.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z = contactEntity.isBot;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            j = contactEntity.sortKey;
        }
        long j2 = j;
        if ((i2 & 16) != 0) {
            bArr = contactEntity.avatarByte;
        }
        return contactEntity.copy(i, str2, z2, j2, bArr);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsBot() {
        return this.isBot;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSortKey() {
        return this.sortKey;
    }

    /* renamed from: component5, reason: from getter */
    public final byte[] getAvatarByte() {
        return this.avatarByte;
    }

    public final ContactEntity copy(int id, String name, boolean isBot, long sortKey, byte[] avatarByte) {
        AbstractC13042fc3.i(name, "name");
        return new ContactEntity(id, name, isBot, sortKey, avatarByte);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC13042fc3.d(ContactEntity.class, other != null ? other.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(other, "null cannot be cast to non-null type ir.nasim.database.entity.ContactEntity");
        ContactEntity contactEntity = (ContactEntity) other;
        return this.id == contactEntity.id && AbstractC13042fc3.d(this.name, contactEntity.name) && this.isBot == contactEntity.isBot && this.sortKey == contactEntity.sortKey && Arrays.equals(this.avatarByte, contactEntity.avatarByte);
    }

    public final byte[] getAvatarByte() {
        return this.avatarByte;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSortKey() {
        return this.sortKey;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isBot)) * 31) + Long.hashCode(this.sortKey)) * 31) + Arrays.hashCode(this.avatarByte);
    }

    public final boolean isBot() {
        return this.isBot;
    }

    public String toString() {
        return "ContactEntity(id=" + this.id + ", name=" + this.name + ", isBot=" + this.isBot + ", sortKey=" + this.sortKey + ", avatarByte=" + Arrays.toString(this.avatarByte) + Separators.RPAREN;
    }

    public /* synthetic */ ContactEntity(int i, String str, boolean z, long j, byte[] bArr, int i2, ED1 ed1) {
        this(i, str, z, j, (i2 & 16) != 0 ? null : bArr);
    }
}
