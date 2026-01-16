package ir.eitaa.ui.explore.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.helper.live.LiveHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.LiveVideoViewer;
import ir.eitaa.ui.explore.cells.ExploreLivesDialogCell;
import java.util.List;

/* loaded from: classes3.dex */
public class ExploreLivesDialogView extends LinearLayout {
    AlertDialog dialog;
    LiveListAdapter liveListAdapter;
    List<TLRPC$Chat> lives;

    public ExploreLivesDialogView(Activity activity) {
        super(activity);
        setOrientation(1);
        setBackgroundColor(Theme.getColor("dialogBackground"));
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackgroundColor(Theme.getColor("chats_actionBackground"));
        frameLayout.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
        Drawable drawableMutate = activity.getResources().getDrawable(R.drawable.miniplayer_close).mutate();
        ImageView imageView = new ImageView(activity);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 50)));
        imageView.setImageDrawable(drawableMutate);
        imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        frameLayout.addView(imageView, LayoutHelper.createFrame(32, 32.0f, 8388627, 8.0f, 8.0f, 8.0f, 8.0f));
        TextView textView = new TextView(activity);
        textView.setText(LocaleController.getString("VoipLiveStream", R.string.VoipLiveStream));
        textView.setTextSize(18.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextColor(-1);
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 8388629, 16.0f, 8.0f, 16.0f, 8.0f));
        addView(frameLayout, LayoutHelper.createFrame(-1, -2.0f));
        this.liveListAdapter = new LiveListAdapter(activity);
        RecyclerView recyclerView = new RecyclerView(activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(this.liveListAdapter);
        Double.isNaN(AndroidUtilities.displaySize.y);
        addView(recyclerView, LayoutHelper.createFrame(-1, (int) AndroidUtilities.pxToDp((float) (r3 * 0.6d))));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.components.ExploreLivesDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExploreLivesDialogView.this.dialog.dismiss();
            }
        });
    }

    public void setDialog(AlertDialog dialog) {
        this.dialog = dialog;
    }

    public void setLives(List<TLRPC$Chat> lives) {
        this.lives = lives;
        this.liveListAdapter.notifyDataSetChanged();
    }

    class LiveListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Activity activity;

        public LiveListAdapter(Activity activity) {
            this.activity = activity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ExploreLivesDialogCell exploreLivesDialogCell = new ExploreLivesDialogCell(this.activity);
            exploreLivesDialogCell.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
            return new RecyclerListView.Holder(exploreLivesDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ExploreLivesDialogCell exploreLivesDialogCell = (ExploreLivesDialogCell) holder.itemView;
            TLRPC$Chat tLRPC$Chat = ExploreLivesDialogView.this.lives.get(position);
            exploreLivesDialogCell.setTag(tLRPC$Chat);
            exploreLivesDialogCell.setDialog((int) (-tLRPC$Chat.id), true, tLRPC$Chat.title);
            exploreLivesDialogCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.components.ExploreLivesDialogView.LiveListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ExploreLivesDialogView.this.dialog.dismiss();
                    TLRPC$Chat tLRPC$Chat2 = ExploreLivesDialogView.this.lives.get(position);
                    long j = MessagesController.getInstance(UserConfig.selectedAccount).liveDialogId;
                    int i = MessagesController.getInstance(UserConfig.selectedAccount).liveDialogMsgId;
                    int i2 = tLRPC$Chat2.live_stream_msg_id;
                    if (i2 != 0 && i2 == i && j == (-tLRPC$Chat2.id)) {
                        LiveHelper.startLive(LiveListAdapter.this.activity, j, i);
                    } else {
                        LiveVideoViewer.getInstance().setParentActivity(LiveListAdapter.this.activity);
                        LiveVideoViewer.getInstance().openPhoto((int) tLRPC$Chat2.id, 0, 0);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<TLRPC$Chat> list = ExploreLivesDialogView.this.lives;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    public AlertDialog getDialog() {
        return this.dialog;
    }
}
