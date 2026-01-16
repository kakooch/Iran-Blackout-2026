package ir.eitaa.ui.explore.cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.List;

/* loaded from: classes3.dex */
public class LivesLayout extends FrameLayout {
    boolean isOneLive;
    public List<TLRPC$Chat> lives;
    OnLiveSelected onLiveSelected;

    public interface OnLiveSelected {
        void onLiveSelected();
    }

    public LivesLayout(Context context) {
        super(context);
        this.isOneLive = true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        OnLiveSelected onLiveSelected = this.onLiveSelected;
        if (onLiveSelected != null) {
            onLiveSelected.onLiveSelected();
        }
        super.setOnClickListener(l);
    }

    public void setLives(List<TLRPC$Chat> lives) {
        boolean z;
        List<TLRPC$Chat> list = this.lives;
        if (list == null || list.size() != lives.size()) {
            z = true;
        } else {
            z = false;
            for (int i = 0; i < lives.size(); i++) {
                if (lives.get(i) != this.lives.get(i)) {
                    z = true;
                }
            }
        }
        if (z) {
            this.lives = lives;
            removeAllViews();
            if (lives.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < lives.size(); i2++) {
                ExploreLiveCell exploreLiveCell = new ExploreLiveCell(getContext());
                TLRPC$Chat tLRPC$Chat = lives.get(i2);
                int i3 = (int) tLRPC$Chat.id;
                exploreLiveCell.setTag(tLRPC$Chat);
                exploreLiveCell.setDialog(-i3, true, tLRPC$Chat.title);
                addView(exploreLiveCell, LayoutHelper.createFrame(40, 40.0f, 21, 0.0f, 0.0f, i2 * 20, 0.0f));
            }
        }
    }

    public void setOnLiveSelectedListener(OnLiveSelected inter) {
        this.onLiveSelected = inter;
    }
}
