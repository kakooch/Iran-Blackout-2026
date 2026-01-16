package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BotButtonObject extends MiniFunctionObject {
    public BotButtonSimpleObject button_view = new BotButtonSimpleObject();
    public String id;
    public ReplyType reply_type;
    public String reply_url;

    public static class BotButtonPayment {
        public String button_payment_token;
        public boolean is_paid = false;
        public transient boolean isPaying = false;
    }

    public static class BotButtonSelection {
        public String api_url;
        public int columns_count = 1;
        public GetType get_type;
        public boolean is_multi_selection;
        public ArrayList<BotButtonSimpleObject> items;
        public SearchType search_type;
        public String selection_id;
        public String title;

        public enum GetType {
            Local,
            Api
        }

        public enum SearchType {
            None,
            Local,
            Api
        }
    }

    public static class BotButtonSimpleObject {
        public String image_url;
        public boolean isSelected;
        public String text;
        public BotButtonViewType type;

        public enum BotButtonViewType {
            TextOnly,
            TextImgThu,
            TextImgBig
        }
    }

    public enum ReplyType {
        API,
        Message
    }

    @Override // ir.aaap.messengercore.model.MiniFunctionObject
    public String getTitle() {
        return this.button_view.text + BuildConfig.FLAVOR;
    }
}
