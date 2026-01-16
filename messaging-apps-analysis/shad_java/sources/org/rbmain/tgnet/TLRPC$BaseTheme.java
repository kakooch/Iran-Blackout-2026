package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$BaseTheme extends TLObject {
    public static TLRPC$BaseTheme TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$BaseTheme tLRPC$BaseTheme;
        switch (i) {
            case -1212997976:
                tLRPC$BaseTheme = new TLRPC$BaseTheme() { // from class: org.rbmain.tgnet.TLRPC$TL_baseThemeNight
                    public static int constructor = -1212997976;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -1012849566:
                tLRPC$BaseTheme = new TLRPC$BaseTheme() { // from class: org.rbmain.tgnet.TLRPC$TL_baseThemeClassic
                    public static int constructor = -1012849566;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -69724536:
                tLRPC$BaseTheme = new TLRPC$BaseTheme() { // from class: org.rbmain.tgnet.TLRPC$TL_baseThemeDay
                    public static int constructor = -69724536;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1527845466:
                tLRPC$BaseTheme = new TLRPC$BaseTheme() { // from class: org.rbmain.tgnet.TLRPC$TL_baseThemeArctic
                    public static int constructor = 1527845466;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 1834973166:
                tLRPC$BaseTheme = new TLRPC$BaseTheme() { // from class: org.rbmain.tgnet.TLRPC$TL_baseThemeTinted
                    public static int constructor = 1834973166;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$BaseTheme = null;
                break;
        }
        if (tLRPC$BaseTheme == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in BaseTheme", Integer.valueOf(i)));
        }
        if (tLRPC$BaseTheme != null) {
            tLRPC$BaseTheme.readParams(abstractSerializedData, z);
        }
        return tLRPC$BaseTheme;
    }
}
