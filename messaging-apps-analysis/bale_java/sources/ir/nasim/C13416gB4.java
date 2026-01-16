package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.gB4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
final class C13416gB4 implements InterfaceC7977Tz5 {
    private final C8445Vz5 a;

    public C13416gB4(C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c8445Vz5, DialogEntity.COLUMN_MESSAGE);
        this.a = c8445Vz5;
    }

    @Override // ir.nasim.InterfaceC7977Tz5
    public String a() {
        C17637nI7 c17637nI7 = (C17637nI7) AbstractC5969Lp4.g().o().d(this.a.z());
        if (c17637nI7 == null) {
            return "";
        }
        String name = c17637nI7.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return name;
    }
}
