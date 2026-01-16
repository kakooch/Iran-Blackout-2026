package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.InstaHashTagObject;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.presenters.InstaTopProfilesCellPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class UI_rubinoSuggestionRow {
    private Activity context;
    public FrameLayout frameLayout;
    ArrayList<InstaHashTagObject> hashtags;
    public int itemHeightDp;
    public SelectItemListener listener;
    ArrayList<InstaProfileObject> profiles;
    InstaTopProfilesCellPresenter profilesCellPresenter;
    public RecyclerListView recyclerView;
    private String searchingText;
    private int startIndexOfSearchingText;
    private SuggestionTypeEnum suggestionType;
    public View view;

    public interface SelectItemListener {
        void onSelectItem(String str, String str2, int i);
    }

    public enum SuggestionTypeEnum {
        hashtag,
        mention
    }

    public View createView(Activity activity, SelectItemListener selectItemListener, final SuggestionTypeEnum suggestionTypeEnum) {
        this.context = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.listener = selectItemListener;
        this.hashtags = new ArrayList<>();
        this.profiles = new ArrayList<>();
        this.suggestionType = suggestionTypeEnum;
        this.itemHeightDp = 60;
        if (suggestionTypeEnum == SuggestionTypeEnum.hashtag) {
            this.itemHeightDp = 60;
        } else if (suggestionTypeEnum == SuggestionTypeEnum.mention) {
            this.itemHeightDp = 76;
        }
        this.profilesCellPresenter = new InstaTopProfilesCellPresenter(activity);
        RecyclerListView recyclerListView = new RecyclerListView(activity);
        this.recyclerView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(activity, 0, Build.VERSION.SDK_INT < 17));
        this.recyclerView.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(this.itemHeightDp));
        layoutParams.gravity = 16;
        this.recyclerView.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
        this.recyclerView.setClipToPadding(false);
        this.frameLayout.addView(this.recyclerView, layoutParams);
        this.recyclerView.setAdapter(new SuggestionAdapter());
        if (this.listener != null) {
            this.recyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoSuggestionRow.1
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public void onItemClick(View view, int i) {
                    SuggestionTypeEnum suggestionTypeEnum2 = suggestionTypeEnum;
                    if (suggestionTypeEnum2 == SuggestionTypeEnum.hashtag) {
                        UI_rubinoSuggestionRow.this.listener.onSelectItem(((UI_rubinoHashTagCell) view.getTag()).getText(), UI_rubinoSuggestionRow.this.searchingText, UI_rubinoSuggestionRow.this.startIndexOfSearchingText);
                    } else if (suggestionTypeEnum2 == SuggestionTypeEnum.mention) {
                        UI_rubinoSuggestionRow.this.listener.onSelectItem(((InstaProfileObject) ((InstaTopProfilesCellPresenter.ViewHolder) view.getTag()).item).username, UI_rubinoSuggestionRow.this.searchingText, UI_rubinoSuggestionRow.this.startIndexOfSearchingText);
                    }
                }
            });
        }
        return this.view;
    }

    public void updateHashtagList(ArrayList<InstaHashTagObject> arrayList, String str, int i) {
        this.searchingText = str;
        this.startIndexOfSearchingText = i;
        this.hashtags.clear();
        this.hashtags.addAll(arrayList);
        this.recyclerView.getAdapter().notifyDataSetChanged();
        try {
            this.recyclerView.smoothScrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    public void updateProfileList(ArrayList<InstaProfileObject> arrayList, String str, int i) {
        this.searchingText = str;
        this.startIndexOfSearchingText = i;
        this.profiles.clear();
        this.profiles.addAll(arrayList);
        this.recyclerView.getAdapter().notifyDataSetChanged();
        try {
            this.recyclerView.smoothScrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    public class SuggestionAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public SuggestionAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (UI_rubinoSuggestionRow.this.suggestionType != SuggestionTypeEnum.hashtag) {
                if (UI_rubinoSuggestionRow.this.suggestionType != SuggestionTypeEnum.mention) {
                    return null;
                }
                InstaTopProfilesCellPresenter.ViewHolder viewHolderOnCreateViewHolder = UI_rubinoSuggestionRow.this.profilesCellPresenter.onCreateViewHolder(viewGroup);
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, AndroidUtilities.dp(UI_rubinoSuggestionRow.this.itemHeightDp) - AndroidUtilities.dp(2.0f));
                layoutParams.setMargins(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(4.0f), 0);
                viewHolderOnCreateViewHolder.itemView.setLayoutParams(layoutParams);
                viewHolderOnCreateViewHolder.textView1.setTextColor(-1);
                return new RecyclerListView.Holder(viewHolderOnCreateViewHolder.itemView);
            }
            UI_rubinoHashTagCell uI_rubinoHashTagCell = new UI_rubinoHashTagCell();
            uI_rubinoHashTagCell.createView(UI_rubinoSuggestionRow.this.context);
            RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-2, AndroidUtilities.dp(UI_rubinoSuggestionRow.this.itemHeightDp) - AndroidUtilities.dp(8.0f));
            layoutParams2.setMargins(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(8.0f));
            uI_rubinoHashTagCell.view.setLayoutParams(layoutParams2);
            return new RecyclerListView.Holder(uI_rubinoHashTagCell.view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (UI_rubinoSuggestionRow.this.suggestionType != SuggestionTypeEnum.hashtag) {
                if (UI_rubinoSuggestionRow.this.suggestionType == SuggestionTypeEnum.mention) {
                    InstaTopProfilesCellPresenter.ViewHolder viewHolder2 = (InstaTopProfilesCellPresenter.ViewHolder) viewHolder.itemView.getTag();
                    UI_rubinoSuggestionRow uI_rubinoSuggestionRow = UI_rubinoSuggestionRow.this;
                    uI_rubinoSuggestionRow.profilesCellPresenter.onBindViewHolder(viewHolder2, uI_rubinoSuggestionRow.profiles.get(i));
                    return;
                }
                return;
            }
            ((UI_rubinoHashTagCell) viewHolder.itemView.getTag()).setText(UI_rubinoSuggestionRow.this.hashtags.get(i).content);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (UI_rubinoSuggestionRow.this.suggestionType != SuggestionTypeEnum.hashtag) {
                if (UI_rubinoSuggestionRow.this.suggestionType == SuggestionTypeEnum.mention) {
                    return UI_rubinoSuggestionRow.this.profiles.size();
                }
                return 0;
            }
            return UI_rubinoSuggestionRow.this.hashtags.size();
        }
    }
}
