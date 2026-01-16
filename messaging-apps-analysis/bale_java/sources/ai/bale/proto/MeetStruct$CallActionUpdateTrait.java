package ai.bale.proto;

import ai.bale.proto.MeetStruct$LowerHand;
import ai.bale.proto.MeetStruct$RaiseHand;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$CallActionUpdateTrait extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$CallActionUpdateTrait DEFAULT_INSTANCE;
    public static final int LOWER_HAND_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RAISE_HAND_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$CallActionUpdateTrait.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        RAISE_HAND(1),
        LOWER_HAND(2),
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
                return RAISE_HAND;
            }
            if (i != 2) {
                return null;
            }
            return LOWER_HAND;
        }
    }

    static {
        MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait = new MeetStruct$CallActionUpdateTrait();
        DEFAULT_INSTANCE = meetStruct$CallActionUpdateTrait;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$CallActionUpdateTrait.class, meetStruct$CallActionUpdateTrait);
    }

    private MeetStruct$CallActionUpdateTrait() {
    }

    private void clearLowerHand() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRaiseHand() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MeetStruct$CallActionUpdateTrait getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLowerHand(MeetStruct$LowerHand meetStruct$LowerHand) {
        meetStruct$LowerHand.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MeetStruct$LowerHand.getDefaultInstance()) {
            this.trait_ = meetStruct$LowerHand;
        } else {
            this.trait_ = ((MeetStruct$LowerHand.a) MeetStruct$LowerHand.newBuilder((MeetStruct$LowerHand) this.trait_).v(meetStruct$LowerHand)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeRaiseHand(MeetStruct$RaiseHand meetStruct$RaiseHand) {
        meetStruct$RaiseHand.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MeetStruct$RaiseHand.getDefaultInstance()) {
            this.trait_ = meetStruct$RaiseHand;
        } else {
            this.trait_ = ((MeetStruct$RaiseHand.a) MeetStruct$RaiseHand.newBuilder((MeetStruct$RaiseHand) this.trait_).v(meetStruct$RaiseHand)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$CallActionUpdateTrait parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLowerHand(MeetStruct$LowerHand meetStruct$LowerHand) {
        meetStruct$LowerHand.getClass();
        this.trait_ = meetStruct$LowerHand;
        this.traitCase_ = 2;
    }

    private void setRaiseHand(MeetStruct$RaiseHand meetStruct$RaiseHand) {
        meetStruct$RaiseHand.getClass();
        this.trait_ = meetStruct$RaiseHand;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$CallActionUpdateTrait();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", MeetStruct$RaiseHand.class, MeetStruct$LowerHand.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$CallActionUpdateTrait.class) {
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

    public MeetStruct$LowerHand getLowerHand() {
        return this.traitCase_ == 2 ? (MeetStruct$LowerHand) this.trait_ : MeetStruct$LowerHand.getDefaultInstance();
    }

    public MeetStruct$RaiseHand getRaiseHand() {
        return this.traitCase_ == 1 ? (MeetStruct$RaiseHand) this.trait_ : MeetStruct$RaiseHand.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasLowerHand() {
        return this.traitCase_ == 2;
    }

    public boolean hasRaiseHand() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(MeetStruct$CallActionUpdateTrait meetStruct$CallActionUpdateTrait) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$CallActionUpdateTrait);
    }

    public static MeetStruct$CallActionUpdateTrait parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(byte[] bArr) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(InputStream inputStream) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$CallActionUpdateTrait parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$CallActionUpdateTrait) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
