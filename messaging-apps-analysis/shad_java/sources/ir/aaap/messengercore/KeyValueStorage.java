package ir.aaap.messengercore;

/* loaded from: classes3.dex */
public interface KeyValueStorage {
    void clear();

    boolean getBoolean(String str, boolean z);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    void setBoolean(String str, boolean z);

    void setInt(String str, int i);

    void setLong(String str, long j);

    void setString(String str, String str2);
}
