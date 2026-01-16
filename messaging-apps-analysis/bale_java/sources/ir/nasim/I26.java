package ir.nasim;

/* loaded from: classes2.dex */
public final class I26 {
    public static final I26 a = new I26();

    private I26() {
    }

    public static final String a(String str) {
        AbstractC13042fc3.i(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
