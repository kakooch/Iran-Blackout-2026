package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.appp.messenger.SendPostHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.insta.InstaDraftManager;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import java.util.ArrayList;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class InstaSendingPostView extends FrameLayout {
    private int currentAccount;
    public ImageView imageViewCancel;
    public ImageView imageViewOption;
    public ImageView imageViewPost;
    public ImageView imageViewVideoIcon;
    public Context mContext;
    View.OnClickListener onCancleClickListener;
    View.OnClickListener onOptionClickListener;
    public ProgressBar progressBar;
    public InstaDraftManager.SendingPostInsta sendingPost;
    public TextView textView;

    public InstaSendingPostView(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onCancleClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.InstaSendingPostView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SendPostHelper.getInstance(InstaSendingPostView.this.currentAccount).cancelSendPostRubino(InstaSendingPostView.this.sendingPost.rnd);
            }
        };
        this.onOptionClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.InstaSendingPostView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoRetrySendPost), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.InstaSendingPostView.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) throws InterruptedException {
                        SendPostHelper.getInstance(InstaSendingPostView.this.currentAccount).retrySendPostRubino(InstaSendingPostView.this.sendingPost.rnd);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoCancelSendPost), 0, InstaSendingPostView.this.onCancleClickListener));
                RubinoController.showRubinoCenterDialog(null, arrayList);
            }
        };
        setWillNotDraw(false);
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_sending_post_row, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        this.imageViewPost = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageViewVideoIcon = (ImageView) viewInflate.findViewById(R.id.imageViewVideoIcon);
        this.imageViewCancel = (ImageView) viewInflate.findViewById(R.id.imageViewCancel);
        this.imageViewOption = (ImageView) viewInflate.findViewById(R.id.imageViewOption);
        this.progressBar = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.imageViewOption.setOnClickListener(this.onOptionClickListener);
        this.imageViewCancel.setOnClickListener(this.onCancleClickListener);
        ImageView imageView = this.imageViewCancel;
        int i = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        this.textView.setTextColor(Theme.getColor(i));
        this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.getDividerPaint());
    }

    public void setObject(InstaDraftManager.SendingPostInsta sendingPostInsta) {
        this.sendingPost = sendingPostInsta;
        setProgress();
        SendingMediaInfo sendingMediaInfo = sendingPostInsta.sendingMediaInfoArrayList.get(0);
        boolean z = sendingMediaInfo.isVideo;
        String str = sendingMediaInfo.path;
        if (z) {
            this.imageViewVideoIcon.setVisibility(0);
        } else {
            this.imageViewVideoIcon.setVisibility(4);
        }
        GlideHelper.load(this.mContext, this.imageViewPost, str, R.drawable.shape_grey_background);
        if (!sendingPostInsta.hasError) {
            this.imageViewOption.setVisibility(4);
            this.imageViewCancel.setVisibility(0);
            this.textView.setVisibility(8);
        } else {
            this.textView.setVisibility(0);
            this.textView.setText(LocaleController.getString(R.string.error_on_send));
            this.imageViewCancel.setVisibility(4);
            this.imageViewOption.setVisibility(0);
        }
    }

    public void setProgress() {
        InstaDraftManager.SendingPostInsta sendingPostInsta = this.sendingPost;
        if (!sendingPostInsta.hasError) {
            this.progressBar.setProgress(sendingPostInsta.getProgress());
            this.progressBar.setVisibility(0);
        } else {
            this.progressBar.setVisibility(4);
        }
    }
}
