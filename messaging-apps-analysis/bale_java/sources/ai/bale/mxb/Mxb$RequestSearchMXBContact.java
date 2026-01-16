package ai.bale.mxb;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Mxb$RequestSearchMXBContact extends GeneratedMessageLite implements U64 {
    private static final Mxb$RequestSearchMXBContact DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_FIELD_NUMBER = 1;
    private long phone_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Mxb$RequestSearchMXBContact.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$RequestSearchMXBContact mxb$RequestSearchMXBContact = new Mxb$RequestSearchMXBContact();
        DEFAULT_INSTANCE = mxb$RequestSearchMXBContact;
        GeneratedMessageLite.registerDefaultInstance(Mxb$RequestSearchMXBContact.class, mxb$RequestSearchMXBContact);
    }

    private Mxb$RequestSearchMXBContact() {
    }

    private void clearPhone() {
        this.phone_ = 0L;
    }

    public static Mxb$RequestSearchMXBContact getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$RequestSearchMXBContact parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPhone(long j) {
        this.phone_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$RequestSearchMXBContact();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"phone_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$RequestSearchMXBContact.class) {
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

    public long getPhone() {
        return this.phone_;
    }

    public static a newBuilder(Mxb$RequestSearchMXBContact mxb$RequestSearchMXBContact) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$RequestSearchMXBContact);
    }

    public static Mxb$RequestSearchMXBContact parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(byte[] bArr) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(InputStream inputStream) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$RequestSearchMXBContact parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$RequestSearchMXBContact) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
