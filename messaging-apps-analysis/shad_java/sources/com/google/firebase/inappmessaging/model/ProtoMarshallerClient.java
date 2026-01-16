package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.firebase.inappmessaging.MessagesProto$Action;
import com.google.firebase.inappmessaging.MessagesProto$BannerMessage;
import com.google.firebase.inappmessaging.MessagesProto$Button;
import com.google.firebase.inappmessaging.MessagesProto$CardMessage;
import com.google.firebase.inappmessaging.MessagesProto$Content;
import com.google.firebase.inappmessaging.MessagesProto$ImageOnlyMessage;
import com.google.firebase.inappmessaging.MessagesProto$ModalMessage;
import com.google.firebase.inappmessaging.MessagesProto$Text;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.Button;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;

/* loaded from: classes3.dex */
public class ProtoMarshallerClient {
    ProtoMarshallerClient() {
    }

    private static ModalMessage.Builder from(MessagesProto$ModalMessage messagesProto$ModalMessage) {
        ModalMessage.Builder builder = ModalMessage.builder();
        if (!TextUtils.isEmpty(messagesProto$ModalMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(messagesProto$ModalMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(messagesProto$ModalMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(messagesProto$ModalMessage.getImageUrl()).build());
        }
        if (messagesProto$ModalMessage.hasAction()) {
            builder.setAction(decode(messagesProto$ModalMessage.getAction(), messagesProto$ModalMessage.getActionButton()));
        }
        if (messagesProto$ModalMessage.hasBody()) {
            builder.setBody(decode(messagesProto$ModalMessage.getBody()));
        }
        if (messagesProto$ModalMessage.hasTitle()) {
            builder.setTitle(decode(messagesProto$ModalMessage.getTitle()));
        }
        return builder;
    }

    private static ImageOnlyMessage.Builder from(MessagesProto$ImageOnlyMessage messagesProto$ImageOnlyMessage) {
        ImageOnlyMessage.Builder builder = ImageOnlyMessage.builder();
        if (!TextUtils.isEmpty(messagesProto$ImageOnlyMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(messagesProto$ImageOnlyMessage.getImageUrl()).build());
        }
        if (messagesProto$ImageOnlyMessage.hasAction()) {
            builder.setAction(decode(messagesProto$ImageOnlyMessage.getAction()).build());
        }
        return builder;
    }

    private static BannerMessage.Builder from(MessagesProto$BannerMessage messagesProto$BannerMessage) {
        BannerMessage.Builder builder = BannerMessage.builder();
        if (!TextUtils.isEmpty(messagesProto$BannerMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(messagesProto$BannerMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(messagesProto$BannerMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(messagesProto$BannerMessage.getImageUrl()).build());
        }
        if (messagesProto$BannerMessage.hasAction()) {
            builder.setAction(decode(messagesProto$BannerMessage.getAction()).build());
        }
        if (messagesProto$BannerMessage.hasBody()) {
            builder.setBody(decode(messagesProto$BannerMessage.getBody()));
        }
        if (messagesProto$BannerMessage.hasTitle()) {
            builder.setTitle(decode(messagesProto$BannerMessage.getTitle()));
        }
        return builder;
    }

    private static CardMessage.Builder from(MessagesProto$CardMessage messagesProto$CardMessage) {
        CardMessage.Builder builder = CardMessage.builder();
        if (messagesProto$CardMessage.hasTitle()) {
            builder.setTitle(decode(messagesProto$CardMessage.getTitle()));
        }
        if (messagesProto$CardMessage.hasBody()) {
            builder.setBody(decode(messagesProto$CardMessage.getBody()));
        }
        if (!TextUtils.isEmpty(messagesProto$CardMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(messagesProto$CardMessage.getBackgroundHexColor());
        }
        if (messagesProto$CardMessage.hasPrimaryAction() || messagesProto$CardMessage.hasPrimaryActionButton()) {
            builder.setPrimaryAction(decode(messagesProto$CardMessage.getPrimaryAction(), messagesProto$CardMessage.getPrimaryActionButton()));
        }
        if (messagesProto$CardMessage.hasSecondaryAction() || messagesProto$CardMessage.hasSecondaryActionButton()) {
            builder.setSecondaryAction(decode(messagesProto$CardMessage.getSecondaryAction(), messagesProto$CardMessage.getSecondaryActionButton()));
        }
        if (!TextUtils.isEmpty(messagesProto$CardMessage.getPortraitImageUrl())) {
            builder.setPortraitImageData(ImageData.builder().setImageUrl(messagesProto$CardMessage.getPortraitImageUrl()).build());
        }
        if (!TextUtils.isEmpty(messagesProto$CardMessage.getLandscapeImageUrl())) {
            builder.setLandscapeImageData(ImageData.builder().setImageUrl(messagesProto$CardMessage.getLandscapeImageUrl()).build());
        }
        return builder;
    }

    private static Action decode(MessagesProto$Action messagesProto$Action, MessagesProto$Button messagesProto$Button) {
        Action.Builder builderDecode = decode(messagesProto$Action);
        if (!messagesProto$Button.equals(MessagesProto$Button.getDefaultInstance())) {
            Button.Builder builder = Button.builder();
            if (!TextUtils.isEmpty(messagesProto$Button.getButtonHexColor())) {
                builder.setButtonHexColor(messagesProto$Button.getButtonHexColor());
            }
            if (messagesProto$Button.hasText()) {
                Text.Builder builder2 = Text.builder();
                MessagesProto$Text text = messagesProto$Button.getText();
                if (!TextUtils.isEmpty(text.getText())) {
                    builder2.setText(text.getText());
                }
                if (!TextUtils.isEmpty(text.getHexColor())) {
                    builder2.setHexColor(text.getHexColor());
                }
                builder.setText(builder2.build());
            }
            builderDecode.setButton(builder.build());
        }
        return builderDecode.build();
    }

    private static Action.Builder decode(MessagesProto$Action messagesProto$Action) {
        Action.Builder builder = Action.builder();
        if (!TextUtils.isEmpty(messagesProto$Action.getActionUrl())) {
            builder.setActionUrl(messagesProto$Action.getActionUrl());
        }
        return builder;
    }

    private static Text decode(MessagesProto$Text messagesProto$Text) {
        Text.Builder builder = Text.builder();
        if (!TextUtils.isEmpty(messagesProto$Text.getHexColor())) {
            builder.setHexColor(messagesProto$Text.getHexColor());
        }
        if (!TextUtils.isEmpty(messagesProto$Text.getText())) {
            builder.setText(messagesProto$Text.getText());
        }
        return builder.build();
    }

    public static InAppMessage decode(MessagesProto$Content messagesProto$Content, String str, String str2, boolean z, Map<String, String> map) {
        Preconditions.checkNotNull(messagesProto$Content, "FirebaseInAppMessaging content cannot be null.");
        Preconditions.checkNotNull(str, "FirebaseInAppMessaging campaign id cannot be null.");
        Preconditions.checkNotNull(str2, "FirebaseInAppMessaging campaign name cannot be null.");
        Logging.logd("Decoding message: " + messagesProto$Content.toString());
        CampaignMetadata campaignMetadata = new CampaignMetadata(str, str2, z);
        int i = AnonymousClass2.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[messagesProto$Content.getMessageDetailsCase().ordinal()];
        if (i == 1) {
            return from(messagesProto$Content.getBanner()).build(campaignMetadata, map);
        }
        if (i == 2) {
            return from(messagesProto$Content.getImageOnly()).build(campaignMetadata, map);
        }
        if (i == 3) {
            return from(messagesProto$Content.getModal()).build(campaignMetadata, map);
        }
        if (i == 4) {
            return from(messagesProto$Content.getCard()).build(campaignMetadata, map);
        }
        return new InAppMessage(new CampaignMetadata(str, str2, z), MessageType.UNSUPPORTED, map) { // from class: com.google.firebase.inappmessaging.model.ProtoMarshallerClient.1
        };
    }

    /* renamed from: com.google.firebase.inappmessaging.model.ProtoMarshallerClient$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase;

        static {
            int[] iArr = new int[MessagesProto$Content.MessageDetailsCase.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase = iArr;
            try {
                iArr[MessagesProto$Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[MessagesProto$Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
