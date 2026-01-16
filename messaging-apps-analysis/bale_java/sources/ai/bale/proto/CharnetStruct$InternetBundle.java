package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.UK0;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CharnetStruct$InternetBundle extends GeneratedMessageLite implements UK0 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int BILL_AMOUNT_FIELD_NUMBER = 4;
    private static final CharnetStruct$InternetBundle DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int amount_;
    private int billAmount_;
    private long id_;
    private String title_ = "";

    public static final class a extends GeneratedMessageLite.b implements UK0 {
        private a() {
            super(CharnetStruct$InternetBundle.DEFAULT_INSTANCE);
        }
    }

    static {
        CharnetStruct$InternetBundle charnetStruct$InternetBundle = new CharnetStruct$InternetBundle();
        DEFAULT_INSTANCE = charnetStruct$InternetBundle;
        GeneratedMessageLite.registerDefaultInstance(CharnetStruct$InternetBundle.class, charnetStruct$InternetBundle);
    }

    private CharnetStruct$InternetBundle() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearBillAmount() {
        this.billAmount_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static CharnetStruct$InternetBundle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CharnetStruct$InternetBundle parseDelimitedFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundle parseFrom(ByteBuffer byteBuffer) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    private void setBillAmount(int i) {
        this.billAmount_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A.a[gVar.ordinal()]) {
            case 1:
                return new CharnetStruct$InternetBundle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0004\u0004\u0004", new Object[]{"id_", "title_", "amount_", "billAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CharnetStruct$InternetBundle.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public int getBillAmount() {
        return this.billAmount_;
    }

    public long getId() {
        return this.id_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(CharnetStruct$InternetBundle charnetStruct$InternetBundle) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnetStruct$InternetBundle);
    }

    public static CharnetStruct$InternetBundle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CharnetStruct$InternetBundle parseFrom(AbstractC2383g abstractC2383g) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CharnetStruct$InternetBundle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CharnetStruct$InternetBundle parseFrom(byte[] bArr) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CharnetStruct$InternetBundle parseFrom(byte[] bArr, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CharnetStruct$InternetBundle parseFrom(InputStream inputStream) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CharnetStruct$InternetBundle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CharnetStruct$InternetBundle parseFrom(AbstractC2384h abstractC2384h) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CharnetStruct$InternetBundle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CharnetStruct$InternetBundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
