package androidMessenger.keyValueStorageHelper;

import android.content.SharedPreferences;
import ir.aaap.messengercore.KeyValueStorage;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class KeyValueStorageImpl implements KeyValueStorage {
    private static KeyValueStorageImpl[] instances = new KeyValueStorageImpl[3];
    int accountNumber;
    private String namePreferences = "messengerCorePreferences";
    SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences(getPreferenceName(), 0);

    public static KeyValueStorageImpl getInstance(int i) {
        KeyValueStorageImpl keyValueStorageImpl = instances[i];
        if (keyValueStorageImpl == null) {
            synchronized (KeyValueStorageImpl.class) {
                KeyValueStorageImpl[] keyValueStorageImplArr = instances;
                KeyValueStorageImpl keyValueStorageImpl2 = keyValueStorageImplArr[i];
                if (keyValueStorageImpl2 == null) {
                    keyValueStorageImpl2 = new KeyValueStorageImpl(i);
                    keyValueStorageImplArr[i] = keyValueStorageImpl2;
                }
                keyValueStorageImpl = keyValueStorageImpl2;
            }
        }
        return keyValueStorageImpl;
    }

    public KeyValueStorageImpl(int i) {
        this.accountNumber = i;
    }

    private String getPreferenceName() {
        return this.namePreferences + "_" + this.accountNumber;
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public void setString(String str, String str2) {
        this.sharedPreferences.edit().putString(str, str2).apply();
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public String getString(String str, String str2) {
        return this.sharedPreferences.getString(str, str2);
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public void setLong(String str, long j) {
        this.sharedPreferences.edit().putLong(str, j).apply();
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public void setInt(String str, int i) {
        this.sharedPreferences.edit().putInt(str, i).apply();
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public long getLong(String str, long j) {
        return this.sharedPreferences.getLong(str, j);
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public int getInt(String str, int i) {
        return this.sharedPreferences.getInt(str, i);
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public void setBoolean(String str, boolean z) {
        this.sharedPreferences.edit().putBoolean(str, z).apply();
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public boolean getBoolean(String str, boolean z) {
        return this.sharedPreferences.getBoolean(str, z);
    }

    @Override // ir.aaap.messengercore.KeyValueStorage
    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }
}
