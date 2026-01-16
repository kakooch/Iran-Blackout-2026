package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.St2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7681St2 {
    private final List a;
    private final List b;

    public C7681St2(List list, List list2) {
        AbstractC13042fc3.i(list, "folders");
        AbstractC13042fc3.i(list2, "associations");
        this.a = list;
        this.b = list2;
    }

    public static /* synthetic */ C7681St2 b(C7681St2 c7681St2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c7681St2.a;
        }
        if ((i & 2) != 0) {
            list2 = c7681St2.b;
        }
        return c7681St2.a(list, list2);
    }

    public final C7681St2 a(List list, List list2) {
        AbstractC13042fc3.i(list, "folders");
        AbstractC13042fc3.i(list2, "associations");
        return new C7681St2(list, list2);
    }

    public final List c() {
        return this.b;
    }

    public final List d() {
        return this.a;
    }

    public final C7681St2 e(List list) {
        AbstractC13042fc3.i(list, "missing");
        List<DialogFolderAssociationEntity> list2 = this.b;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (DialogFolderAssociationEntity dialogFolderAssociationEntity : list2) {
            arrayList.add(AbstractC4616Fw7.a(Long.valueOf(dialogFolderAssociationEntity.getPeerUid()), Integer.valueOf(dialogFolderAssociationEntity.getFolderId())));
        }
        Set setR1 = AbstractC15401jX0.r1(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            DialogFolderAssociationEntity dialogFolderAssociationEntity2 = (DialogFolderAssociationEntity) obj;
            if (true ^ setR1.contains(AbstractC4616Fw7.a(Long.valueOf(dialogFolderAssociationEntity2.getPeerUid()), Integer.valueOf(dialogFolderAssociationEntity2.getFolderId())))) {
                arrayList2.add(obj);
            }
        }
        return b(this, null, AbstractC15401jX0.R0(this.b, arrayList2), 1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7681St2)) {
            return false;
        }
        C7681St2 c7681St2 = (C7681St2) obj;
        return AbstractC13042fc3.d(this.a, c7681St2.a) && AbstractC13042fc3.d(this.b, c7681St2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FoldersWithRelations(folders=" + this.a + ", associations=" + this.b + Separators.RPAREN;
    }
}
