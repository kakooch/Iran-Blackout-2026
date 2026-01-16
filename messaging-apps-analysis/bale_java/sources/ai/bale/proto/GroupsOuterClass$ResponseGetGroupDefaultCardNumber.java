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
public final class GroupsOuterClass$ResponseGetGroupDefaultCardNumber extends GeneratedMessageLite implements U64 {
    public static final int DEFAULT_CARD_NUMBER_FIELD_NUMBER = 1;
    private static final GroupsOuterClass$ResponseGetGroupDefaultCardNumber DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String defaultCardNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetGroupDefaultCardNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetGroupDefaultCardNumber groupsOuterClass$ResponseGetGroupDefaultCardNumber = new GroupsOuterClass$ResponseGetGroupDefaultCardNumber();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetGroupDefaultCardNumber;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetGroupDefaultCardNumber.class, groupsOuterClass$ResponseGetGroupDefaultCardNumber);
    }

    private GroupsOuterClass$ResponseGetGroupDefaultCardNumber() {
    }

    private void clearDefaultCardNumber() {
        this.defaultCardNumber_ = getDefaultInstance().getDefaultCardNumber();
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultCardNumber(String str) {
        str.getClass();
        this.defaultCardNumber_ = str;
    }

    private void setDefaultCardNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.defaultCardNumber_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetGroupDefaultCardNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"defaultCardNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetGroupDefaultCardNumber.class) {
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

    public String getDefaultCardNumber() {
        return this.defaultCardNumber_;
    }

    public AbstractC2383g getDefaultCardNumberBytes() {
        return AbstractC2383g.N(this.defaultCardNumber_);
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetGroupDefaultCardNumber groupsOuterClass$ResponseGetGroupDefaultCardNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetGroupDefaultCardNumber);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetGroupDefaultCardNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
