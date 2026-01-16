package bale.anonymous_contact.v1;

import bale.anonymous_contact.v1.AnonymousContactOuterClass$LangPair;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5307Iu;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class AnonymousContactOuterClass$KeyValue extends GeneratedMessageLite implements InterfaceC5307Iu {
    private static final AnonymousContactOuterClass$KeyValue DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private AnonymousContactOuterClass$LangPair key_;
    private AnonymousContactOuterClass$LangPair value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5307Iu {
        private a() {
            super(AnonymousContactOuterClass$KeyValue.DEFAULT_INSTANCE);
        }
    }

    static {
        AnonymousContactOuterClass$KeyValue anonymousContactOuterClass$KeyValue = new AnonymousContactOuterClass$KeyValue();
        DEFAULT_INSTANCE = anonymousContactOuterClass$KeyValue;
        GeneratedMessageLite.registerDefaultInstance(AnonymousContactOuterClass$KeyValue.class, anonymousContactOuterClass$KeyValue);
    }

    private AnonymousContactOuterClass$KeyValue() {
    }

    private void clearKey() {
        this.key_ = null;
        this.bitField0_ &= -2;
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -3;
    }

    public static AnonymousContactOuterClass$KeyValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeKey(AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair) {
        anonymousContactOuterClass$LangPair.getClass();
        AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair2 = this.key_;
        if (anonymousContactOuterClass$LangPair2 == null || anonymousContactOuterClass$LangPair2 == AnonymousContactOuterClass$LangPair.getDefaultInstance()) {
            this.key_ = anonymousContactOuterClass$LangPair;
        } else {
            this.key_ = (AnonymousContactOuterClass$LangPair) ((AnonymousContactOuterClass$LangPair.a) AnonymousContactOuterClass$LangPair.newBuilder(this.key_).v(anonymousContactOuterClass$LangPair)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeValue(AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair) {
        anonymousContactOuterClass$LangPair.getClass();
        AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair2 = this.value_;
        if (anonymousContactOuterClass$LangPair2 == null || anonymousContactOuterClass$LangPair2 == AnonymousContactOuterClass$LangPair.getDefaultInstance()) {
            this.value_ = anonymousContactOuterClass$LangPair;
        } else {
            this.value_ = (AnonymousContactOuterClass$LangPair) ((AnonymousContactOuterClass$LangPair.a) AnonymousContactOuterClass$LangPair.newBuilder(this.value_).v(anonymousContactOuterClass$LangPair)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AnonymousContactOuterClass$KeyValue parseDelimitedFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(ByteBuffer byteBuffer) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKey(AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair) {
        anonymousContactOuterClass$LangPair.getClass();
        this.key_ = anonymousContactOuterClass$LangPair;
        this.bitField0_ |= 1;
    }

    private void setValue(AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair) {
        anonymousContactOuterClass$LangPair.getClass();
        this.value_ = anonymousContactOuterClass$LangPair;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.anonymous_contact.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new AnonymousContactOuterClass$KeyValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AnonymousContactOuterClass$KeyValue.class) {
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

    public AnonymousContactOuterClass$LangPair getKey() {
        AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair = this.key_;
        return anonymousContactOuterClass$LangPair == null ? AnonymousContactOuterClass$LangPair.getDefaultInstance() : anonymousContactOuterClass$LangPair;
    }

    public AnonymousContactOuterClass$LangPair getValue() {
        AnonymousContactOuterClass$LangPair anonymousContactOuterClass$LangPair = this.value_;
        return anonymousContactOuterClass$LangPair == null ? AnonymousContactOuterClass$LangPair.getDefaultInstance() : anonymousContactOuterClass$LangPair;
    }

    public boolean hasKey() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AnonymousContactOuterClass$KeyValue anonymousContactOuterClass$KeyValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(anonymousContactOuterClass$KeyValue);
    }

    public static AnonymousContactOuterClass$KeyValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(AbstractC2383g abstractC2383g) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(byte[] bArr) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(AbstractC2384h abstractC2384h) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AnonymousContactOuterClass$KeyValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AnonymousContactOuterClass$KeyValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
