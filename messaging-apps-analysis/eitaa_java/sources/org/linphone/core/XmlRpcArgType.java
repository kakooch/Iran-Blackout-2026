package org.linphone.core;

/* loaded from: classes3.dex */
public enum XmlRpcArgType {
    None(0),
    Int(1),
    String(2),
    StringStruct(3);

    protected final int mValue;

    XmlRpcArgType(int i) {
        this.mValue = i;
    }

    public static XmlRpcArgType fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Int;
        }
        if (i == 2) {
            return String;
        }
        if (i == 3) {
            return StringStruct;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for XmlRpcArgType");
    }

    protected static XmlRpcArgType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        XmlRpcArgType[] xmlRpcArgTypeArr = new XmlRpcArgType[length];
        for (int i = 0; i < length; i++) {
            xmlRpcArgTypeArr[i] = fromInt(iArr[i]);
        }
        return xmlRpcArgTypeArr;
    }

    protected static int[] toIntArray(XmlRpcArgType[] xmlRpcArgTypeArr) throws RuntimeException {
        int length = xmlRpcArgTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = xmlRpcArgTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
