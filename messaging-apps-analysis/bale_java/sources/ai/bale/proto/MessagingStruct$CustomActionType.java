package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DoNothingAction;
import ai.bale.proto.MessagingStruct$OpenDialogAction;
import ai.bale.proto.MessagingStruct$OpenUrlAction;
import ai.bale.proto.MessagingStruct$ShowSnackBarAction;
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
public final class MessagingStruct$CustomActionType extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$CustomActionType DEFAULT_INSTANCE;
    public static final int DO_NOTHING_ACTION_FIELD_NUMBER = 4;
    public static final int OPEN_DIALOG_ACTION_FIELD_NUMBER = 1;
    public static final int OPEN_URL_ACTION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_SNACK_BAR_ACTION_FIELD_NUMBER = 3;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$CustomActionType.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        OPEN_DIALOG_ACTION(1),
        OPEN_URL_ACTION(2),
        SHOW_SNACK_BAR_ACTION(3),
        DO_NOTHING_ACTION(4),
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
                return OPEN_DIALOG_ACTION;
            }
            if (i == 2) {
                return OPEN_URL_ACTION;
            }
            if (i == 3) {
                return SHOW_SNACK_BAR_ACTION;
            }
            if (i != 4) {
                return null;
            }
            return DO_NOTHING_ACTION;
        }
    }

    static {
        MessagingStruct$CustomActionType messagingStruct$CustomActionType = new MessagingStruct$CustomActionType();
        DEFAULT_INSTANCE = messagingStruct$CustomActionType;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$CustomActionType.class, messagingStruct$CustomActionType);
    }

    private MessagingStruct$CustomActionType() {
    }

    private void clearDoNothingAction() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearOpenDialogAction() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearOpenUrlAction() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearShowSnackBarAction() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$CustomActionType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDoNothingAction(MessagingStruct$DoNothingAction messagingStruct$DoNothingAction) {
        messagingStruct$DoNothingAction.getClass();
        AbstractC2377a abstractC2377aJ = messagingStruct$DoNothingAction;
        if (this.traitCase_ == 4) {
            abstractC2377aJ = messagingStruct$DoNothingAction;
            if (this.trait_ != MessagingStruct$DoNothingAction.getDefaultInstance()) {
                abstractC2377aJ = ((MessagingStruct$DoNothingAction.a) MessagingStruct$DoNothingAction.newBuilder((MessagingStruct$DoNothingAction) this.trait_).v(messagingStruct$DoNothingAction)).j();
            }
        }
        this.trait_ = abstractC2377aJ;
        this.traitCase_ = 4;
    }

    private void mergeOpenDialogAction(MessagingStruct$OpenDialogAction messagingStruct$OpenDialogAction) {
        messagingStruct$OpenDialogAction.getClass();
        AbstractC2377a abstractC2377aJ = messagingStruct$OpenDialogAction;
        if (this.traitCase_ == 1) {
            abstractC2377aJ = messagingStruct$OpenDialogAction;
            if (this.trait_ != MessagingStruct$OpenDialogAction.getDefaultInstance()) {
                abstractC2377aJ = ((MessagingStruct$OpenDialogAction.a) MessagingStruct$OpenDialogAction.newBuilder((MessagingStruct$OpenDialogAction) this.trait_).v(messagingStruct$OpenDialogAction)).j();
            }
        }
        this.trait_ = abstractC2377aJ;
        this.traitCase_ = 1;
    }

    private void mergeOpenUrlAction(MessagingStruct$OpenUrlAction messagingStruct$OpenUrlAction) {
        messagingStruct$OpenUrlAction.getClass();
        AbstractC2377a abstractC2377aJ = messagingStruct$OpenUrlAction;
        if (this.traitCase_ == 2) {
            abstractC2377aJ = messagingStruct$OpenUrlAction;
            if (this.trait_ != MessagingStruct$OpenUrlAction.getDefaultInstance()) {
                abstractC2377aJ = ((MessagingStruct$OpenUrlAction.a) MessagingStruct$OpenUrlAction.newBuilder((MessagingStruct$OpenUrlAction) this.trait_).v(messagingStruct$OpenUrlAction)).j();
            }
        }
        this.trait_ = abstractC2377aJ;
        this.traitCase_ = 2;
    }

    private void mergeShowSnackBarAction(MessagingStruct$ShowSnackBarAction messagingStruct$ShowSnackBarAction) {
        messagingStruct$ShowSnackBarAction.getClass();
        AbstractC2377a abstractC2377aJ = messagingStruct$ShowSnackBarAction;
        if (this.traitCase_ == 3) {
            abstractC2377aJ = messagingStruct$ShowSnackBarAction;
            if (this.trait_ != MessagingStruct$ShowSnackBarAction.getDefaultInstance()) {
                abstractC2377aJ = ((MessagingStruct$ShowSnackBarAction.a) MessagingStruct$ShowSnackBarAction.newBuilder((MessagingStruct$ShowSnackBarAction) this.trait_).v(messagingStruct$ShowSnackBarAction)).j();
            }
        }
        this.trait_ = abstractC2377aJ;
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$CustomActionType parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CustomActionType parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDoNothingAction(MessagingStruct$DoNothingAction messagingStruct$DoNothingAction) {
        messagingStruct$DoNothingAction.getClass();
        this.trait_ = messagingStruct$DoNothingAction;
        this.traitCase_ = 4;
    }

    private void setOpenDialogAction(MessagingStruct$OpenDialogAction messagingStruct$OpenDialogAction) {
        messagingStruct$OpenDialogAction.getClass();
        this.trait_ = messagingStruct$OpenDialogAction;
        this.traitCase_ = 1;
    }

    private void setOpenUrlAction(MessagingStruct$OpenUrlAction messagingStruct$OpenUrlAction) {
        messagingStruct$OpenUrlAction.getClass();
        this.trait_ = messagingStruct$OpenUrlAction;
        this.traitCase_ = 2;
    }

    private void setShowSnackBarAction(MessagingStruct$ShowSnackBarAction messagingStruct$ShowSnackBarAction) {
        messagingStruct$ShowSnackBarAction.getClass();
        this.trait_ = messagingStruct$ShowSnackBarAction;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$CustomActionType();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$OpenDialogAction.class, MessagingStruct$OpenUrlAction.class, MessagingStruct$ShowSnackBarAction.class, MessagingStruct$DoNothingAction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$CustomActionType.class) {
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

    public MessagingStruct$DoNothingAction getDoNothingAction() {
        return this.traitCase_ == 4 ? (MessagingStruct$DoNothingAction) this.trait_ : MessagingStruct$DoNothingAction.getDefaultInstance();
    }

    public MessagingStruct$OpenDialogAction getOpenDialogAction() {
        return this.traitCase_ == 1 ? (MessagingStruct$OpenDialogAction) this.trait_ : MessagingStruct$OpenDialogAction.getDefaultInstance();
    }

    public MessagingStruct$OpenUrlAction getOpenUrlAction() {
        return this.traitCase_ == 2 ? (MessagingStruct$OpenUrlAction) this.trait_ : MessagingStruct$OpenUrlAction.getDefaultInstance();
    }

    public MessagingStruct$ShowSnackBarAction getShowSnackBarAction() {
        return this.traitCase_ == 3 ? (MessagingStruct$ShowSnackBarAction) this.trait_ : MessagingStruct$ShowSnackBarAction.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasDoNothingAction() {
        return this.traitCase_ == 4;
    }

    public boolean hasOpenDialogAction() {
        return this.traitCase_ == 1;
    }

    public boolean hasOpenUrlAction() {
        return this.traitCase_ == 2;
    }

    public boolean hasShowSnackBarAction() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(MessagingStruct$CustomActionType messagingStruct$CustomActionType) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$CustomActionType);
    }

    public static MessagingStruct$CustomActionType parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CustomActionType parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$CustomActionType parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$CustomActionType parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$CustomActionType parseFrom(InputStream inputStream) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CustomActionType parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CustomActionType parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$CustomActionType parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$CustomActionType parseFrom(byte[] bArr) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$CustomActionType parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$CustomActionType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
