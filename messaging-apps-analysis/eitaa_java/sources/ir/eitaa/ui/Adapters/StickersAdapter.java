package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.EmojiReplacementCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class StickersAdapter extends RecyclerListView.SelectionAdapter implements NotificationCenter.NotificationCenterDelegate {
    private int currentAccount;
    private StickersAdapterDelegate delegate;
    private ArrayList<MediaDataController.KeywordResult> keywordResults;
    private String lastSearch;
    private String[] lastSearchKeyboardLanguage;
    private Context mContext;
    private final Theme.ResourcesProvider resourcesProvider;
    private Runnable searchRunnable;
    private boolean visible;

    public interface StickersAdapterDelegate {
        void needChangePanelVisibility(boolean show);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return false;
    }

    public StickersAdapter(Context context, StickersAdapterDelegate delegate, Theme.ResourcesProvider resourcesProvider) {
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.mContext = context;
        this.delegate = delegate;
        this.resourcesProvider = resourcesProvider;
        MediaDataController.getInstance(i).checkStickers(0);
        MediaDataController.getInstance(this.currentAccount).checkStickers(1);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newEmojiSuggestionsAvailable);
    }

    public void onDestroy() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newEmojiSuggestionsAvailable);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, final Object... args) {
        if (id == NotificationCenter.newEmojiSuggestionsAvailable) {
            ArrayList<MediaDataController.KeywordResult> arrayList = this.keywordResults;
            if ((arrayList == null || arrayList.isEmpty()) && !TextUtils.isEmpty(this.lastSearch) && getItemCount() == 0) {
                searchEmojiByKeyword();
            }
        }
    }

    public void hide() {
        ArrayList<MediaDataController.KeywordResult> arrayList;
        if (!this.visible || (arrayList = this.keywordResults) == null || arrayList.isEmpty()) {
            return;
        }
        this.visible = false;
        this.delegate.needChangePanelVisibility(false);
    }

    private void cancelEmojiSearch() {
        Runnable runnable = this.searchRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.searchRunnable = null;
        }
    }

    private void searchEmojiByKeyword() {
        String[] currentKeyboardLanguage = AndroidUtilities.getCurrentKeyboardLanguage();
        if (!Arrays.equals(currentKeyboardLanguage, this.lastSearchKeyboardLanguage)) {
            MediaDataController.getInstance(this.currentAccount).fetchNewEmojiKeywords(currentKeyboardLanguage);
        }
        this.lastSearchKeyboardLanguage = currentKeyboardLanguage;
        final String str = this.lastSearch;
        cancelEmojiSearch();
        this.searchRunnable = new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$StickersAdapter$GLnlGRb5Megnu8s3nGUzYCgl1fw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchEmojiByKeyword$1$StickersAdapter(str);
            }
        };
        ArrayList<MediaDataController.KeywordResult> arrayList = this.keywordResults;
        if (arrayList == null || arrayList.isEmpty()) {
            AndroidUtilities.runOnUIThread(this.searchRunnable, 1000L);
        } else {
            this.searchRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchEmojiByKeyword$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchEmojiByKeyword$1$StickersAdapter(final String str) {
        MediaDataController.getInstance(this.currentAccount).getEmojiSuggestions(this.lastSearchKeyboardLanguage, str, true, new MediaDataController.KeywordResultCallback() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$StickersAdapter$OxTDL3Y9EUxg0BgLCqj6HgxIVfM
            @Override // ir.eitaa.messenger.MediaDataController.KeywordResultCallback
            public final void run(ArrayList arrayList, String str2) {
                this.f$0.lambda$searchEmojiByKeyword$0$StickersAdapter(str, arrayList, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchEmojiByKeyword$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchEmojiByKeyword$0$StickersAdapter(String str, ArrayList arrayList, String str2) {
        if (str.equals(this.lastSearch)) {
            if (!arrayList.isEmpty()) {
                this.keywordResults = arrayList;
            }
            notifyDataSetChanged();
            StickersAdapterDelegate stickersAdapterDelegate = this.delegate;
            boolean z = !arrayList.isEmpty();
            this.visible = z;
            stickersAdapterDelegate.needChangePanelVisibility(z);
        }
    }

    public void searchEmojiByKeyword(CharSequence emoji) {
        String string;
        ArrayList<MediaDataController.KeywordResult> arrayList;
        TLRPC$Document emojiAnimatedSticker;
        boolean z = emoji != null && emoji.length() > 0 && emoji.length() <= 14;
        if (z) {
            string = emoji.toString();
            int length = emoji.length();
            int i = 0;
            while (i < length) {
                char cCharAt = emoji.charAt(i);
                int i2 = length - 1;
                char cCharAt2 = i < i2 ? emoji.charAt(i + 1) : (char) 0;
                if (i < i2 && cCharAt == 55356 && cCharAt2 >= 57339 && cCharAt2 <= 57343) {
                    emoji = TextUtils.concat(emoji.subSequence(0, i), emoji.subSequence(i + 2, emoji.length()));
                    length -= 2;
                } else if (cCharAt == 65039) {
                    emoji = TextUtils.concat(emoji.subSequence(0, i), emoji.subSequence(i + 1, emoji.length()));
                    length--;
                } else {
                    i++;
                }
                i--;
                i++;
            }
        } else {
            string = "";
        }
        this.lastSearch = emoji.toString().trim();
        boolean z2 = z && (Emoji.isValidEmoji(string) || Emoji.isValidEmoji(this.lastSearch));
        if (z2 && (emojiAnimatedSticker = MediaDataController.getInstance(this.currentAccount).getEmojiAnimatedSticker(emoji)) != null) {
            ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = MediaDataController.getInstance(this.currentAccount).getStickerSets(4);
            if (!FileLoader.getPathToAttach(emojiAnimatedSticker, true).exists()) {
                FileLoader.getInstance(this.currentAccount).loadFile(ImageLocation.getForDocument(emojiAnimatedSticker), stickerSets.get(0), null, 1, 1);
            }
        }
        if (this.visible && ((arrayList = this.keywordResults) == null || arrayList.isEmpty())) {
            this.visible = false;
            this.delegate.needChangePanelVisibility(false);
            notifyDataSetChanged();
        }
        if (!z2) {
            searchEmojiByKeyword();
        } else {
            clearSearch();
            this.delegate.needChangePanelVisibility(false);
        }
    }

    public void clearSearch() {
        this.lastSearch = null;
        this.keywordResults = null;
        notifyDataSetChanged();
    }

    public String getQuery() {
        return this.lastSearch;
    }

    public boolean isShowingKeywords() {
        ArrayList<MediaDataController.KeywordResult> arrayList = this.keywordResults;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<MediaDataController.KeywordResult> arrayList = this.keywordResults;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        return this.keywordResults.size();
    }

    public Object getItem(int i) {
        ArrayList<MediaDataController.KeywordResult> arrayList = this.keywordResults;
        if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.keywordResults.size()) {
            return null;
        }
        return this.keywordResults.get(i).emoji;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new RecyclerListView.Holder(new EmojiReplacementCell(this.mContext, this.resourcesProvider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int i = 1;
        if (position == 0) {
            i = this.keywordResults.size() == 1 ? 2 : -1;
        } else if (position != this.keywordResults.size() - 1) {
            i = 0;
        }
        ((EmojiReplacementCell) holder.itemView).setEmoji(this.keywordResults.get(position).emoji, i);
    }
}
