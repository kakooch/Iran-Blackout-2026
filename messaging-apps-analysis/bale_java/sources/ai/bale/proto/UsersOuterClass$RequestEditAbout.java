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
public final class UsersOuterClass$RequestEditAbout extends GeneratedMessageLite implements U64 {
    public static final int ABOUT_FIELD_NUMBER = 1;
    private static final UsersOuterClass$RequestEditAbout DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private StringValue about_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((UsersOuterClass$RequestEditAbout) this.b).setAbout(stringValue);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestEditAbout.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditAbout usersOuterClass$RequestEditAbout = new UsersOuterClass$RequestEditAbout();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditAbout;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditAbout.class, usersOuterClass$RequestEditAbout);
    }

    private UsersOuterClass$RequestEditAbout() {
    }

    private void clearAbout() {
        this.about_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$RequestEditAbout getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAbout(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.about_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.about_ = stringValue;
        } else {
            this.about_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.about_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditAbout parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAbout(StringValue stringValue) {
        stringValue.getClass();
        this.about_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditAbout();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "about_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditAbout.class) {
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

    public StringValue getAbout() {
        StringValue stringValue = this.about_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAbout() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$RequestEditAbout usersOuterClass$RequestEditAbout) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditAbout);
    }

    public static UsersOuterClass$RequestEditAbout parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditAbout parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditAbout) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
