package org.linphone.core;

/* loaded from: classes3.dex */
public interface Config {
    void cleanEntry(String str, String str2);

    void cleanSection(String str);

    String dump();

    String dumpAsXml();

    boolean getBool(String str, String str2, boolean z);

    float getDefaultFloat(String str, String str2, float f);

    int getDefaultInt(String str, String str2, int i);

    int getDefaultInt64(String str, String str2, int i);

    String getDefaultString(String str, String str2, String str3);

    float getFloat(String str, String str2, float f);

    int getInt(String str, String str2, int i);

    int getInt64(String str, String str2, int i);

    String[] getKeysNamesList(String str);

    long getNativePointer();

    boolean getOverwriteFlagForEntry(String str, String str2);

    boolean getOverwriteFlagForSection(String str);

    String getSectionParamString(String str, String str2, String str3);

    String[] getSectionsNamesList();

    boolean getSkipFlagForEntry(String str, String str2);

    boolean getSkipFlagForSection(String str);

    String getString(String str, String str2, String str3);

    String[] getStringList(String str, String str2, String[] strArr);

    Object getUserData();

    int hasEntry(String str, String str2);

    int hasSection(String str);

    String loadFromXmlFile(String str);

    int loadFromXmlString(String str);

    Config newFromBuffer(String str);

    Config newWithFactory(String str, String str2);

    int readFile(String str);

    boolean relativeFileExists(String str);

    void reload();

    void setBool(String str, String str2, boolean z);

    void setFloat(String str, String str2, float f);

    void setInt(String str, String str2, int i);

    void setInt64(String str, String str2, int i);

    void setIntHex(String str, String str2, int i);

    void setOverwriteFlagForEntry(String str, String str2, boolean z);

    void setOverwriteFlagForSection(String str, boolean z);

    void setRange(String str, String str2, int i, int i2);

    void setSkipFlagForEntry(String str, String str2, boolean z);

    void setSkipFlagForSection(String str, boolean z);

    void setString(String str, String str2, String str3);

    void setStringList(String str, String str2, String[] strArr);

    void setUserData(Object obj);

    int sync();

    String toString();

    void writeRelativeFile(String str, String str2);
}
