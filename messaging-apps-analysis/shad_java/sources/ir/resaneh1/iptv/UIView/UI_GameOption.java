package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.GameOptionObject;

/* loaded from: classes3.dex */
public class UI_GameOption {
    public Context context;
    private FrameLayout loadingProgressBarContainer;
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_GameOption.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                UI_GameOption uI_GameOption = (UI_GameOption) UI_GameOption.this.view.getTag();
                OnSelectOptionListener onSelectOptionListener = UI_GameOption.this.onSelectOptionListener;
                if (onSelectOptionListener != null) {
                    onSelectOptionListener.onSelect(uI_GameOption);
                }
            } catch (Exception unused) {
            }
        }
    };
    public OnSelectOptionListener onSelectOptionListener;
    public GameOptionObject optionObject;
    public ProgressBar progressBar;
    public TextView textViewLeft;
    public TextView textViewRight;
    public View view;

    public interface OnSelectOptionListener {
        void onSelect(UI_GameOption uI_GameOption);
    }

    public enum OptionStateEnum {
        red,
        green,
        notSelected,
        greenSelected
    }

    public View createView(Activity activity, OnSelectOptionListener onSelectOptionListener) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.row_game_option, (ViewGroup) null);
        this.view = viewInflate;
        this.textViewRight = (TextView) viewInflate.findViewById(R.id.textViewRight);
        this.textViewLeft = (TextView) this.view.findViewById(R.id.textViewLeft);
        this.progressBar = (ProgressBar) this.view.findViewById(R.id.progressBar);
        FrameLayout frameLayout = (FrameLayout) this.view.findViewById(R.id.progressBarContainer);
        this.loadingProgressBarContainer = frameLayout;
        UIProgressBarNewStyle.addToFrame(activity, frameLayout, 24);
        this.onSelectOptionListener = onSelectOptionListener;
        this.context = activity;
        this.view.setVisibility(4);
        this.view.setOnClickListener(this.onClickListener);
        this.view.setTag(this);
        setUnSelectedView();
        this.optionObject = null;
        return this.view;
    }

    public void clearViewAndInvisible() {
        this.optionObject = null;
        this.view.setVisibility(0);
        this.textViewRight.setText(BuildConfig.FLAVOR);
        this.textViewLeft.setText(BuildConfig.FLAVOR);
        this.progressBar.setProgress(0);
        this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress));
        this.progressBar.setVisibility(4);
    }

    public void setUnSelectedView() {
        this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress));
        this.progressBar.setVisibility(4);
        this.loadingProgressBarContainer.setVisibility(8);
    }

    public void setSelectedView() {
        this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.shape_game_selected_option));
        this.progressBar.setVisibility(0);
        this.loadingProgressBarContainer.setVisibility(8);
    }

    public void showLoadingProgress() {
        this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.shape_game_selected_option_loading));
        this.progressBar.setVisibility(0);
        this.loadingProgressBarContainer.setVisibility(0);
    }

    public void setOption(GameOptionObject gameOptionObject) {
        this.optionObject = gameOptionObject;
        this.view.setVisibility(0);
        this.textViewRight.setText(gameOptionObject.text);
        this.textViewLeft.setText(BuildConfig.FLAVOR);
        this.progressBar.setVisibility(4);
        this.loadingProgressBarContainer.setVisibility(8);
        setUnSelectedView();
    }

    public void setResult(int i, int i2, OptionStateEnum optionStateEnum, boolean z) {
        this.optionObject = null;
        this.loadingProgressBarContainer.setVisibility(8);
        this.textViewLeft.setText(NumberUtils.toCuteStringWithKOrM(i));
        if (z) {
            this.textViewLeft.setVisibility(4);
        } else {
            this.textViewLeft.setVisibility(0);
        }
        this.progressBar.setVisibility(0);
        if (i2 <= 0) {
            i2 = 1;
        }
        int i3 = (i * 100) / i2;
        int i4 = i3 >= 0 ? i3 : 0;
        if (i4 < 3) {
            i4 = 3;
        }
        int i5 = i4 <= 100 ? i4 : 100;
        if (this.progressBar.getProgress() != i5) {
            this.progressBar.setProgress(i5);
        }
        if (optionStateEnum == OptionStateEnum.red) {
            this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress_red));
            return;
        }
        if (optionStateEnum == OptionStateEnum.green) {
            this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress_green));
        } else if (optionStateEnum == OptionStateEnum.greenSelected) {
            this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress_green_selected));
        } else {
            this.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.game_option_progress));
        }
    }
}
