package ir.nasim;

import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.FilesStruct$Avatars;
import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class OF7 extends AbstractC20556sC7 {
    private final int a;
    private final FilesStruct$Avatar b;
    private final FilesStruct$Avatars c;

    public OF7(int i, FilesStruct$Avatar filesStruct$Avatar, FilesStruct$Avatars filesStruct$Avatars) {
        super(null);
        this.a = i;
        this.b = filesStruct$Avatar;
        this.c = filesStruct$Avatars;
    }

    public final FilesStruct$Avatar a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OF7)) {
            return false;
        }
        OF7 of7 = (OF7) obj;
        return this.a == of7.a && AbstractC13042fc3.d(this.b, of7.b) && AbstractC13042fc3.d(this.c, of7.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        FilesStruct$Avatar filesStruct$Avatar = this.b;
        int iHashCode2 = (iHashCode + (filesStruct$Avatar == null ? 0 : filesStruct$Avatar.hashCode())) * 31;
        FilesStruct$Avatars filesStruct$Avatars = this.c;
        return iHashCode2 + (filesStruct$Avatars != null ? filesStruct$Avatars.hashCode() : 0);
    }

    public String toString() {
        return "UpdateUserAvatarChanged(uid=" + this.a + ", avatar=" + this.b + ", avatars=" + this.c + Separators.RPAREN;
    }
}
