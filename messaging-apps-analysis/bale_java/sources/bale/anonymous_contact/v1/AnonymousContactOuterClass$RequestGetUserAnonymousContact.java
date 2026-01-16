package bale.anonymous_contact.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class AnonymousContactOuterClass$RequestGetUserAnonymousContact extends GeneratedMessageLite implements U64 {
    private static final AnonymousContactOuterClass$RequestGetUserAnonymousContact DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_MESSAGE_DATE_FIELD_NUMBER = 3;
    public static final int SERVICE_MESSAGE_RID_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long serviceMessageDate_;
    private long serviceMessageRid_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((AnonymousContactOuterClass$RequestGetUserAnonymousContact) this.b).setServiceMessageDate(j);
            return this;
        }

        public a B(long j) {
            q();
            ((AnonymousContactOuterClass$RequestGetUserAnonymousContact) this.b).setServiceMessageRid(j);
            return this;
        }

        public a C(int i) {
            q();
            ((AnonymousContactOuterClass$RequestGetUserAnonymousContact) this.b).setUserId(i);
            return this;
        }

        private a() {
            super(AnonymousContactOuterClass$RequestGetUserAnonymousContact.DEFAULT_INSTANCE);
        }
    }

    static {
        AnonymousContactOuterClass$RequestGetUserAnonymousContact anonymousContactOuterClass$RequestGetUserAnonymousContact = new AnonymousContactOuterClass$RequestGetUserAnonymousContact();
        DEFAULT_INSTANCE = anonymousContactOuterClass$RequestGetUserAnonymousContact;
        GeneratedMessageLite.registerDefaultInstance(AnonymousContactOuterClass$RequestGetUserAnonymousContact.class, anonymousContactOuterClass$RequestGetUserAnonymousContact);
    }

    private AnonymousContactOuterClass$RequestGetUserAnonymousContact() {
    }

    private void clearServiceMessageDate() {
        this.serviceMessageDate_ = 0L;
    }

    private void clearServiceMessageRid() {
        this.serviceMessageRid_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseDelimitedFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(ByteBuffer byteBuffer) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceMessageDate(long j) {
        this.serviceMessageDate_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceMessageRid(long j) {
        this.serviceMessageRid_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.anonymous_contact.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new AnonymousContactOuterClass$RequestGetUserAnonymousContact();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"userId_", "serviceMessageRid_", "serviceMessageDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AnonymousContactOuterClass$RequestGetUserAnonymousContact.class) {
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

    public long getServiceMessageDate() {
        return this.serviceMessageDate_;
    }

    public long getServiceMessageRid() {
        return this.serviceMessageRid_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AnonymousContactOuterClass$RequestGetUserAnonymousContact anonymousContactOuterClass$RequestGetUserAnonymousContact) {
        return (a) DEFAULT_INSTANCE.createBuilder(anonymousContactOuterClass$RequestGetUserAnonymousContact);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(AbstractC2383g abstractC2383g) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(byte[] bArr) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(byte[] bArr, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(InputStream inputStream) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(AbstractC2384h abstractC2384h) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AnonymousContactOuterClass$RequestGetUserAnonymousContact parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AnonymousContactOuterClass$RequestGetUserAnonymousContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
