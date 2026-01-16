package org.linphone.core;

/* loaded from: classes3.dex */
public interface Content {
    void addContentTypeParameter(String str, String str2);

    void addCustomHeader(String str, String str2);

    String exportPlainFile();

    Content findPartByHeader(String str, String str2);

    byte[] getBuffer();

    String getCustomHeader(String str);

    String getDisposition();

    String getEncoding();

    int getFileDuration();

    String getFilePath();

    int getFileSize();

    String getKey();

    int getKeySize();

    String getName();

    long getNativePointer();

    Content getPart(int i);

    Content[] getParts();

    @Deprecated
    String getPlainFilePath();

    int getSize();

    @Deprecated
    String getStringBuffer();

    String getSubtype();

    String getType();

    Object getUserData();

    String getUtf8Text();

    boolean isFile();

    boolean isFileEncrypted();

    boolean isFileTransfer();

    boolean isIcalendar();

    boolean isMultipart();

    boolean isText();

    boolean isVoiceRecording();

    void setBuffer(byte[] bArr, int i);

    void setDisposition(String str);

    void setEncoding(String str);

    void setFilePath(String str);

    void setKey(String str, int i);

    void setName(String str);

    void setSize(int i);

    @Deprecated
    void setStringBuffer(String str);

    void setSubtype(String str);

    void setType(String str);

    void setUserData(Object obj);

    void setUtf8Text(String str);

    String toString();
}
