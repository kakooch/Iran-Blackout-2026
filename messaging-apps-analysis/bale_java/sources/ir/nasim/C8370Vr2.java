package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Vr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8370Vr2 {
    private final List a;
    private final Integer b;
    private final String c;

    public C8370Vr2(List list, Integer num, String str) {
        AbstractC13042fc3.i(list, "folders");
        this.a = list;
        this.b = num;
        this.c = str;
    }

    public static /* synthetic */ C8370Vr2 b(C8370Vr2 c8370Vr2, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c8370Vr2.a;
        }
        if ((i & 2) != 0) {
            num = c8370Vr2.b;
        }
        if ((i & 4) != 0) {
            str = c8370Vr2.c;
        }
        return c8370Vr2.a(list, num, str);
    }

    public final C8370Vr2 a(List list, Integer num, String str) {
        AbstractC13042fc3.i(list, "folders");
        return new C8370Vr2(list, num, str);
    }

    public final List c() {
        return this.a;
    }

    public final Integer d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8370Vr2)) {
            return false;
        }
        C8370Vr2 c8370Vr2 = (C8370Vr2) obj;
        return AbstractC13042fc3.d(this.a, c8370Vr2.a) && AbstractC13042fc3.d(this.b, c8370Vr2.b) && AbstractC13042fc3.d(this.c, c8370Vr2.c);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FolderBottomSheetState(folders=" + this.a + ", selectedFolderId=" + this.b + ", selectedFolderName=" + this.c + Separators.RPAREN;
    }
}
