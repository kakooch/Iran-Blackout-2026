package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_baseThemeTinted extends TLRPC$BaseTheme {
    public static int constructor = 1834973166;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
