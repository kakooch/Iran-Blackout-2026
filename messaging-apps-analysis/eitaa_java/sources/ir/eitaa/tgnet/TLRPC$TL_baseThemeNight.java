package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_baseThemeNight extends TLRPC$BaseTheme {
    public static int constructor = -1212997976;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
