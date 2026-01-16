package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.BM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$PhoneToImport extends GeneratedMessageLite implements BM7 {
    private static final UsersStruct$PhoneToImport DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue name_;
    private long phoneNumber_;

    public static final class a extends GeneratedMessageLite.b implements BM7 {
        public a A(StringValue stringValue) {
            q();
            ((UsersStruct$PhoneToImport) this.b).setName(stringValue);
            return this;
        }

        public a B(long j) {
            q();
            ((UsersStruct$PhoneToImport) this.b).setPhoneNumber(j);
            return this;
        }

        private a() {
            super(UsersStruct$PhoneToImport.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$PhoneToImport usersStruct$PhoneToImport = new UsersStruct$PhoneToImport();
        DEFAULT_INSTANCE = usersStruct$PhoneToImport;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$PhoneToImport.class, usersStruct$PhoneToImport);
    }

    private UsersStruct$PhoneToImport() {
    }

    private void clearName() {
        this.name_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = 0L;
    }

    public static UsersStruct$PhoneToImport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.name_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.name_ = stringValue;
        } else {
            this.name_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.name_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$PhoneToImport parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PhoneToImport parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(StringValue stringValue) {
        stringValue.getClass();
        this.name_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneNumber(long j) {
        this.phoneNumber_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$PhoneToImport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "phoneNumber_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$PhoneToImport.class) {
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

    public StringValue getName() {
        StringValue stringValue = this.name_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getPhoneNumber() {
        return this.phoneNumber_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$PhoneToImport usersStruct$PhoneToImport) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$PhoneToImport);
    }

    public static UsersStruct$PhoneToImport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PhoneToImport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$PhoneToImport parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$PhoneToImport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$PhoneToImport parseFrom(byte[] bArr) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$PhoneToImport parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$PhoneToImport parseFrom(InputStream inputStream) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PhoneToImport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PhoneToImport parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$PhoneToImport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$PhoneToImport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
