package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateUserLocalNameChanged extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateUserLocalNameChanged DEFAULT_INSTANCE;
    public static final int LOCAL_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue localName_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserLocalNameChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserLocalNameChanged usersOuterClass$UpdateUserLocalNameChanged = new UsersOuterClass$UpdateUserLocalNameChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserLocalNameChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserLocalNameChanged.class, usersOuterClass$UpdateUserLocalNameChanged);
    }

    private UsersOuterClass$UpdateUserLocalNameChanged() {
    }

    private void clearLocalName() {
        this.localName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLocalName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.localName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.localName_ = stringValue;
        } else {
            this.localName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.localName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLocalName(StringValue stringValue) {
        stringValue.getClass();
        this.localName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserLocalNameChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "uid_", "localName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserLocalNameChanged.class) {
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

    public StringValue getLocalName() {
        StringValue stringValue = this.localName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasLocalName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserLocalNameChanged usersOuterClass$UpdateUserLocalNameChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserLocalNameChanged);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserLocalNameChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserLocalNameChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
