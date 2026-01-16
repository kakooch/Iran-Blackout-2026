package ir.nasim;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.MessagingStruct$DocumentEx;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$ServiceEx;
import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.GI7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.FastThumbnailItemEntity;
import ir.nasim.database.dailogLists.MessageState;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class FW1 implements Z64 {
    private final Context a;
    private final GI7 b;
    private final int c;
    private final MessagingStruct$Message.b d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessagingStruct$DocumentEx.b.values().length];
            try {
                iArr[MessagingStruct$DocumentEx.b.DOCUMENT_EX_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessagingStruct$DocumentEx.b.DOCUMENT_EX_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessagingStruct$DocumentEx.b.DOCUMENT_EX_VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessagingStruct$DocumentEx.b.DOCUMENT_EX_AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessagingStruct$DocumentEx.b.DOCUMENT_EX_GIF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessagingStruct$DocumentEx.b.TRAIT_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public FW1(Context context, GI7 gi7, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(gi7, "userNamePlaceHolderManager");
        this.a = context;
        this.b = gi7;
        this.c = i;
        this.d = MessagingStruct$Message.b.DOCUMENT_MESSAGE;
    }

    private final String f(MessagingStruct$DocumentEx.b bVar) {
        int i;
        switch (bVar == null ? -1 : a.a[bVar.ordinal()]) {
            case -1:
            case 6:
                i = FD5.message_holder_content_document;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                i = FD5.last_message_image_text;
                break;
            case 2:
                i = FD5.last_message_video_text;
                break;
            case 3:
                i = FD5.last_message_voice_text;
                break;
            case 4:
                i = FD5.last_message_music_text;
                break;
            case 5:
                i = FD5.last_message_gif_text;
                break;
        }
        String string = this.a.getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final EnumC22968w74 g(MessagingStruct$DocumentEx.b bVar) {
        switch (bVar == null ? -1 : a.a[bVar.ordinal()]) {
            case -1:
            case 6:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return EnumC22968w74.c;
            case 2:
                return EnumC22968w74.e;
            case 3:
                return EnumC22968w74.b;
            case 4:
                return EnumC22968w74.d;
            case 5:
                return EnumC22968w74.f;
        }
    }

    private final String i(MessagingStruct$DocumentEx.b bVar, String str, boolean z) {
        EnumC22968w74 enumC22968w74G;
        StringBuilder sb = new StringBuilder();
        if (z && (enumC22968w74G = g(bVar)) != null) {
            sb.append(enumC22968w74G.j() + Separators.SP);
        }
        if (!(true ^ (str == null || AbstractC20762sZ6.n0(str)))) {
            str = null;
        }
        if (str == null) {
            str = f(bVar);
        }
        sb.append(str);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    static /* synthetic */ String j(FW1 fw1, MessagingStruct$DocumentEx.b bVar, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return fw1.i(bVar, str, z);
    }

    private final FastThumbnailItemEntity k(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        FilesStruct$FastThumb thumb;
        FastThumbnailItemEntity fastThumbnailItemEntity = null;
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = (!messagingStruct$DocumentMessage.hasThumb() || messagingStruct$DocumentMessage.getThumb().getThumb().isEmpty()) ? null : messagingStruct$DocumentMessage;
        if (messagingStruct$DocumentMessage2 != null && (thumb = messagingStruct$DocumentMessage2.getThumb()) != null) {
            fastThumbnailItemEntity = new FastThumbnailItemEntity(thumb.getThumb().a0(), thumb.getW(), thumb.getH(), messagingStruct$DocumentMessage.getExt().getTraitCase() == MessagingStruct$DocumentEx.b.DOCUMENT_EX_VIDEO);
        }
        return fastThumbnailItemEntity;
    }

    private final DialogLastMessage l(MessagingStruct$DocumentEx.b bVar, String str, FastThumbnailItemEntity fastThumbnailItemEntity, int i, ExPeerType exPeerType, MessageState messageState) {
        return (!AbstractC4597Fu6.i(MessagingStruct$DocumentEx.b.DOCUMENT_EX_PHOTO, MessagingStruct$DocumentEx.b.DOCUMENT_EX_VIDEO).contains(bVar) || fastThumbnailItemEntity == null) ? m(bVar, str, i, exPeerType, messageState) : o(bVar, str, fastThumbnailItemEntity, i, exPeerType, messageState);
    }

    private final DialogLastMessage.Text m(final MessagingStruct$DocumentEx.b bVar, final String str, final int i, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Text) this.b.b(new UA2() { // from class: ir.nasim.EW1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return FW1.n(this.a, bVar, str, i, exPeerType, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogLastMessage.Text n(FW1 fw1, MessagingStruct$DocumentEx.b bVar, String str, int i, ExPeerType exPeerType, MessageState messageState, GI7.a aVar) {
        AbstractC13042fc3.i(fw1, "this$0");
        AbstractC13042fc3.i(bVar, "$traitCase");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(messageState, "$state");
        AbstractC13042fc3.i(aVar, "$this$withPlaceHolders");
        return new DialogLastMessage.Text(j(fw1, bVar, str, false, 4, null), (List) null, (EnumC22968w74) null, aVar.c(i, exPeerType), i == fw1.c, i, messageState, aVar.b(), (MessagingStruct$ServiceEx.b) null, 262, (ED1) null);
    }

    private final DialogLastMessage.Album o(final MessagingStruct$DocumentEx.b bVar, final String str, final FastThumbnailItemEntity fastThumbnailItemEntity, final int i, final ExPeerType exPeerType, final MessageState messageState) {
        return (DialogLastMessage.Album) this.b.b(new UA2() { // from class: ir.nasim.DW1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return FW1.p(this.a, bVar, str, fastThumbnailItemEntity, i, exPeerType, messageState, (GI7.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.database.dailogLists.DialogLastMessage.Album p(ir.nasim.FW1 r11, ai.bale.proto.MessagingStruct$DocumentEx.b r12, java.lang.String r13, ir.nasim.database.dailogLists.FastThumbnailItemEntity r14, int r15, ir.nasim.core.modules.profile.entity.ExPeerType r16, ir.nasim.database.dailogLists.MessageState r17, ir.nasim.GI7.a r18) {
        /*
            r0 = r11
            r1 = r12
            r6 = r15
            r2 = r16
            r3 = r18
            java.lang.String r4 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r11, r4)
            java.lang.String r4 = "$type"
            ir.nasim.AbstractC13042fc3.i(r12, r4)
            java.lang.String r4 = "$fastThumb"
            r5 = r14
            ir.nasim.AbstractC13042fc3.i(r14, r4)
            java.lang.String r4 = "$exPeerType"
            ir.nasim.AbstractC13042fc3.i(r2, r4)
            java.lang.String r4 = "$state"
            r7 = r17
            ir.nasim.AbstractC13042fc3.i(r7, r4)
            java.lang.String r4 = "$this$withPlaceHolders"
            ir.nasim.AbstractC13042fc3.i(r3, r4)
            byte[] r4 = r14.getFastThumb()
            r8 = 0
            r9 = 1
            if (r4 == 0) goto L3b
            int r4 = r4.length
            if (r4 != 0) goto L35
            r4 = r9
            goto L36
        L35:
            r4 = r8
        L36:
            r4 = r4 ^ r9
            if (r4 != r9) goto L3b
            r4 = r9
            goto L3c
        L3b:
            r4 = r8
        L3c:
            r4 = r4 ^ r9
            r10 = r13
            java.lang.String r1 = r11.i(r12, r13, r4)
            java.lang.String r4 = r3.c(r15, r2)
            java.util.List r2 = ir.nasim.ZW0.q(r14)
            java.util.Set r5 = r18.b()
            int r0 = r0.c
            if (r6 != r0) goto L53
            r8 = r9
        L53:
            ir.nasim.database.dailogLists.DialogLastMessage$Album r9 = new ir.nasim.database.dailogLists.DialogLastMessage$Album
            r0 = r9
            r3 = r4
            r4 = r8
            r6 = r15
            r7 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FW1.p(ir.nasim.FW1, ai.bale.proto.MessagingStruct$DocumentEx$b, java.lang.String, ir.nasim.database.dailogLists.FastThumbnailItemEntity, int, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.database.dailogLists.MessageState, ir.nasim.GI7$a):ir.nasim.database.dailogLists.DialogLastMessage$Album");
    }

    private final MessagingStruct$DocumentEx.b q(C24967zW1 c24967zW1) {
        return c24967zW1 instanceof C13388g85 ? MessagingStruct$DocumentEx.b.DOCUMENT_EX_PHOTO : c24967zW1 instanceof GS7 ? MessagingStruct$DocumentEx.b.DOCUMENT_EX_VIDEO : c24967zW1 instanceof J08 ? MessagingStruct$DocumentEx.b.DOCUMENT_EX_VOICE : c24967zW1 instanceof TM ? MessagingStruct$DocumentEx.b.DOCUMENT_EX_AUDIO : c24967zW1 instanceof XG2 ? MessagingStruct$DocumentEx.b.DOCUMENT_EX_GIF : MessagingStruct$DocumentEx.b.TRAIT_NOT_SET;
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage b(MessagingStruct$Message messagingStruct$Message, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        MessagingStruct$DocumentMessage documentMessage = messagingStruct$Message.getDocumentMessage();
        MessagingStruct$DocumentEx.b traitCase = documentMessage.getExt().getTraitCase();
        AbstractC13042fc3.h(traitCase, "getTraitCase(...)");
        String text = documentMessage.getCaption().getText();
        AbstractC13042fc3.f(documentMessage);
        return l(traitCase, text, k(documentMessage), i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    public DialogLastMessage c(AbstractC17457n0 abstractC17457n0, int i, ExPeerType exPeerType, MessageState messageState) {
        AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(messageState, "state");
        C24967zW1 c24967zW1 = abstractC17457n0 instanceof C24967zW1 ? (C24967zW1) abstractC17457n0 : null;
        if (c24967zW1 == null) {
            String string = this.a.getString(FD5.message_holder_content_template);
            AbstractC13042fc3.h(string, "getString(...)");
            return new DialogLastMessage.Text(string, (List) null, (EnumC22968w74) null, (String) null, false, 0, (MessageState) null, (Set) null, (MessagingStruct$ServiceEx.b) null, 510, (ED1) null);
        }
        MessagingStruct$DocumentEx.b bVarQ = q(c24967zW1);
        String strV = c24967zW1.t().v();
        C22694vg2 c22694vg2V = c24967zW1.v();
        return l(bVarQ, strV, c22694vg2V != null ? new FastThumbnailItemEntity(c22694vg2V.c(), c22694vg2V.d(), c22694vg2V.b(), c24967zW1 instanceof GS7) : null, i, exPeerType, messageState);
    }

    @Override // ir.nasim.Z64
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessagingStruct$Message.b a() {
        return this.d;
    }
}
