package org.linphone.core;

/* loaded from: classes3.dex */
public enum XmlRpcStatus {
    Pending(0),
    Ok(1),
    Failed(2);

    protected final int mValue;

    XmlRpcStatus(int i) {
        this.mValue = i;
    }

    public static XmlRpcStatus fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Pending;
        }
        if (i == 1) {
            return Ok;
        }
        if (i == 2) {
            return Failed;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for XmlRpcStatus");
    }

    protected static XmlRpcStatus[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        XmlRpcStatus[] xmlRpcStatusArr = new XmlRpcStatus[length];
        for (int i = 0; i < length; i++) {
            xmlRpcStatusArr[i] = fromInt(iArr[i]);
        }
        return xmlRpcStatusArr;
    }

    protected static int[] toIntArray(XmlRpcStatus[] xmlRpcStatusArr) throws RuntimeException {
        int length = xmlRpcStatusArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = xmlRpcStatusArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
