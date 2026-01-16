package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_baseThemeClassic extends TLRPC$BaseTheme {
    public static int constructor = -1012849566;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
