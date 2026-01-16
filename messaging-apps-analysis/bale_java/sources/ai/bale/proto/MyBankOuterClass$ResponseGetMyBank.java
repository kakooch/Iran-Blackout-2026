package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MyBankOuterClass$ResponseGetMyBank extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final MyBankOuterClass$ResponseGetMyBank DEFAULT_INSTANCE;
    public static final int IS_CHANGED_FIELD_NUMBER = 4;
    public static final int ITEMS_VERSION_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String data_ = "";
    private boolean isChanged_;
    private int itemsVersion_;
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MyBankOuterClass$ResponseGetMyBank.DEFAULT_INSTANCE);
        }
    }

    static {
        MyBankOuterClass$ResponseGetMyBank myBankOuterClass$ResponseGetMyBank = new MyBankOuterClass$ResponseGetMyBank();
        DEFAULT_INSTANCE = myBankOuterClass$ResponseGetMyBank;
        GeneratedMessageLite.registerDefaultInstance(MyBankOuterClass$ResponseGetMyBank.class, myBankOuterClass$ResponseGetMyBank);
    }

    private MyBankOuterClass$ResponseGetMyBank() {
    }

    private void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    private void clearIsChanged() {
        this.isChanged_ = false;
    }

    private void clearItemsVersion() {
        this.itemsVersion_ = 0;
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static MyBankOuterClass$ResponseGetMyBank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MyBankOuterClass$ResponseGetMyBank parseDelimitedFrom(InputStream inputStream) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(ByteBuffer byteBuffer) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    private void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
    }

    private void setIsChanged(boolean z) {
        this.isChanged_ = z;
    }

    private void setItemsVersion(int i) {
        this.itemsVersion_ = i;
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Q0.a[gVar.ordinal()]) {
            case 1:
                return new MyBankOuterClass$ResponseGetMyBank();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u0007", new Object[]{"data_", "version_", "itemsVersion_", "isChanged_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MyBankOuterClass$ResponseGetMyBank.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getData() {
        return this.data_;
    }

    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public boolean getIsChanged() {
        return this.isChanged_;
    }

    public int getItemsVersion() {
        return this.itemsVersion_;
    }

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(MyBankOuterClass$ResponseGetMyBank myBankOuterClass$ResponseGetMyBank) {
        return (a) DEFAULT_INSTANCE.createBuilder(myBankOuterClass$ResponseGetMyBank);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(AbstractC2383g abstractC2383g) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(byte[] bArr) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(byte[] bArr, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(InputStream inputStream) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(AbstractC2384h abstractC2384h) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MyBankOuterClass$ResponseGetMyBank parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MyBankOuterClass$ResponseGetMyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
