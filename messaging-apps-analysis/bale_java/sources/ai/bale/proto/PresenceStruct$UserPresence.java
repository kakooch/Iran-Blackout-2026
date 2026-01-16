package ai.bale.proto;

import ai.bale.proto.PresenceStruct$UserOffline;
import ai.bale.proto.PresenceStruct$UserOnline;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PresenceStruct$UserPresence extends GeneratedMessageLite implements InterfaceC1872l1 {
    private static final PresenceStruct$UserPresence DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_OFFLINE_FIELD_NUMBER = 2;
    public static final int USER_ONLINE_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1872l1 {
        private a() {
            super(PresenceStruct$UserPresence.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        USER_ONLINE(1),
        USER_OFFLINE(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return USER_ONLINE;
            }
            if (i != 2) {
                return null;
            }
            return USER_OFFLINE;
        }
    }

    static {
        PresenceStruct$UserPresence presenceStruct$UserPresence = new PresenceStruct$UserPresence();
        DEFAULT_INSTANCE = presenceStruct$UserPresence;
        GeneratedMessageLite.registerDefaultInstance(PresenceStruct$UserPresence.class, presenceStruct$UserPresence);
    }

    private PresenceStruct$UserPresence() {
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearUserOffline() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserOnline() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static PresenceStruct$UserPresence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserOffline(PresenceStruct$UserOffline presenceStruct$UserOffline) {
        presenceStruct$UserOffline.getClass();
        if (this.traitCase_ != 2 || this.trait_ == PresenceStruct$UserOffline.getDefaultInstance()) {
            this.trait_ = presenceStruct$UserOffline;
        } else {
            this.trait_ = ((PresenceStruct$UserOffline.a) PresenceStruct$UserOffline.newBuilder((PresenceStruct$UserOffline) this.trait_).v(presenceStruct$UserOffline)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeUserOnline(PresenceStruct$UserOnline presenceStruct$UserOnline) {
        presenceStruct$UserOnline.getClass();
        if (this.traitCase_ != 1 || this.trait_ == PresenceStruct$UserOnline.getDefaultInstance()) {
            this.trait_ = presenceStruct$UserOnline;
        } else {
            this.trait_ = ((PresenceStruct$UserOnline.a) PresenceStruct$UserOnline.newBuilder((PresenceStruct$UserOnline) this.trait_).v(presenceStruct$UserOnline)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceStruct$UserPresence parseDelimitedFrom(InputStream inputStream) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserPresence parseFrom(ByteBuffer byteBuffer) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserOffline(PresenceStruct$UserOffline presenceStruct$UserOffline) {
        presenceStruct$UserOffline.getClass();
        this.trait_ = presenceStruct$UserOffline;
        this.traitCase_ = 2;
    }

    private void setUserOnline(PresenceStruct$UserOnline presenceStruct$UserOnline) {
        presenceStruct$UserOnline.getClass();
        this.trait_ = presenceStruct$UserOnline;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1869k1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceStruct$UserPresence();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", PresenceStruct$UserOnline.class, PresenceStruct$UserOffline.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceStruct$UserPresence.class) {
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

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public PresenceStruct$UserOffline getUserOffline() {
        return this.traitCase_ == 2 ? (PresenceStruct$UserOffline) this.trait_ : PresenceStruct$UserOffline.getDefaultInstance();
    }

    public PresenceStruct$UserOnline getUserOnline() {
        return this.traitCase_ == 1 ? (PresenceStruct$UserOnline) this.trait_ : PresenceStruct$UserOnline.getDefaultInstance();
    }

    public boolean hasUserOffline() {
        return this.traitCase_ == 2;
    }

    public boolean hasUserOnline() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(PresenceStruct$UserPresence presenceStruct$UserPresence) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceStruct$UserPresence);
    }

    public static PresenceStruct$UserPresence parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserPresence parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceStruct$UserPresence parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceStruct$UserPresence parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceStruct$UserPresence parseFrom(byte[] bArr) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceStruct$UserPresence parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceStruct$UserPresence parseFrom(InputStream inputStream) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserPresence parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserPresence parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceStruct$UserPresence parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceStruct$UserPresence) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
