package ai.bale.proto;

import ai.bale.proto.MagazineStruct$MagazineUpvotes;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$ResponseGetMyUpvotes extends GeneratedMessageLite implements U64 {
    private static final MagazineOuterClass$ResponseGetMyUpvotes DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPVOTES_FIELD_NUMBER = 1;
    private int bitField0_;
    private MagazineStruct$MagazineUpvotes upvotes_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineOuterClass$ResponseGetMyUpvotes.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$ResponseGetMyUpvotes magazineOuterClass$ResponseGetMyUpvotes = new MagazineOuterClass$ResponseGetMyUpvotes();
        DEFAULT_INSTANCE = magazineOuterClass$ResponseGetMyUpvotes;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$ResponseGetMyUpvotes.class, magazineOuterClass$ResponseGetMyUpvotes);
    }

    private MagazineOuterClass$ResponseGetMyUpvotes() {
    }

    private void clearUpvotes() {
        this.upvotes_ = null;
        this.bitField0_ &= -2;
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUpvotes(MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes) {
        magazineStruct$MagazineUpvotes.getClass();
        MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes2 = this.upvotes_;
        if (magazineStruct$MagazineUpvotes2 == null || magazineStruct$MagazineUpvotes2 == MagazineStruct$MagazineUpvotes.getDefaultInstance()) {
            this.upvotes_ = magazineStruct$MagazineUpvotes;
        } else {
            this.upvotes_ = (MagazineStruct$MagazineUpvotes) ((MagazineStruct$MagazineUpvotes.a) MagazineStruct$MagazineUpvotes.newBuilder(this.upvotes_).v(magazineStruct$MagazineUpvotes)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUpvotes(MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes) {
        magazineStruct$MagazineUpvotes.getClass();
        this.upvotes_ = magazineStruct$MagazineUpvotes;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$ResponseGetMyUpvotes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upvotes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$ResponseGetMyUpvotes.class) {
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

    public MagazineStruct$MagazineUpvotes getUpvotes() {
        MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes = this.upvotes_;
        return magazineStruct$MagazineUpvotes == null ? MagazineStruct$MagazineUpvotes.getDefaultInstance() : magazineStruct$MagazineUpvotes;
    }

    public boolean hasUpvotes() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$ResponseGetMyUpvotes magazineOuterClass$ResponseGetMyUpvotes) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$ResponseGetMyUpvotes);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(byte[] bArr) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$ResponseGetMyUpvotes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMyUpvotes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
