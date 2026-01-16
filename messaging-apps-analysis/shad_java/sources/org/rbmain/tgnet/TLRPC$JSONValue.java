package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$JSONValue extends TLObject {
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static TLRPC$JSONValue TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$JSONValue tLRPC$TL_jsonObject;
        switch (i) {
            case -1715350371:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonObject();
                break;
            case -1222740358:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonString();
                break;
            case -952869270:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonBool();
                break;
            case -146520221:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonArray();
                break;
            case 736157604:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonNumber();
                break;
            case 1064139624:
                tLRPC$TL_jsonObject = new TLRPC$JSONValue() { // from class: org.rbmain.tgnet.TLRPC$TL_jsonNull
                    public static int constructor = 1064139624;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_jsonObject = null;
                break;
        }
        if (tLRPC$TL_jsonObject == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in JSONValue", Integer.valueOf(i)));
        }
        if (tLRPC$TL_jsonObject != null) {
            tLRPC$TL_jsonObject.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_jsonObject;
    }
}
