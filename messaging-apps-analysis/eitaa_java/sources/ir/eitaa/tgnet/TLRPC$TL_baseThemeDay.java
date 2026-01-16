package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_baseThemeDay extends TLRPC$BaseTheme {
    public static int constructor = -69724536;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
