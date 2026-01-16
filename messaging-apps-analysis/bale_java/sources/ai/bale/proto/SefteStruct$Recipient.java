package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20290rl6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SefteStruct$Recipient extends GeneratedMessageLite implements InterfaceC20290rl6 {
    private static final SefteStruct$Recipient DEFAULT_INSTANCE;
    public static final int FULL_NAME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int id_;
    private String fullName_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20290rl6 {
        private a() {
            super(SefteStruct$Recipient.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteStruct$Recipient sefteStruct$Recipient = new SefteStruct$Recipient();
        DEFAULT_INSTANCE = sefteStruct$Recipient;
        GeneratedMessageLite.registerDefaultInstance(SefteStruct$Recipient.class, sefteStruct$Recipient);
    }

    private SefteStruct$Recipient() {
    }

    private void clearFullName() {
        this.fullName_ = getDefaultInstance().getFullName();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static SefteStruct$Recipient getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteStruct$Recipient parseDelimitedFrom(InputStream inputStream) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$Recipient parseFrom(ByteBuffer byteBuffer) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFullName(String str) {
        str.getClass();
        this.fullName_ = str;
    }

    private void setFullNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fullName_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Q1.a[gVar.ordinal()]) {
            case 1:
                return new SefteStruct$Recipient();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ", new Object[]{"id_", "fullName_", "nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteStruct$Recipient.class) {
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

    public String getFullName() {
        return this.fullName_;
    }

    public AbstractC2383g getFullNameBytes() {
        return AbstractC2383g.N(this.fullName_);
    }

    public int getId() {
        return this.id_;
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public static a newBuilder(SefteStruct$Recipient sefteStruct$Recipient) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteStruct$Recipient);
    }

    public static SefteStruct$Recipient parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$Recipient parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteStruct$Recipient parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteStruct$Recipient parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteStruct$Recipient parseFrom(byte[] bArr) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteStruct$Recipient parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteStruct$Recipient parseFrom(InputStream inputStream) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$Recipient parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$Recipient parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteStruct$Recipient parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteStruct$Recipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
