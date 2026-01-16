package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PostInStoryCell extends FrameLayout {
    private FrameLayout frameLayoutBottomContainer;
    private FrameLayout frameLayoutTopContainer;
    public ImageView imageViewIcon;
    public ImageView imageViewPost;
    public ImageView imageViewUser;
    public LinearLayout linearLayout;
    public Context mContext;
    public ModeEnum mode;
    public LinearLayout postAndCaptionContainer;
    public RubinoPostObject postObject;
    private boolean supportVideo;
    public TextView textViewCaption;
    public TextView textViewUsername;

    public enum ModeEnum {
        justImage,
        details
    }

    public int getVideoWidth() {
        return this.imageViewPost.getWidth();
    }

    public int getVideoHeight() {
        return this.imageViewPost.getHeight();
    }

    public int getTopOfVideoPost() {
        if (this.mode == ModeEnum.details) {
            return (int) this.postAndCaptionContainer.getY();
        }
        return 0;
    }

    public PostInStoryCell(Context context, boolean z) {
        super(context);
        this.supportVideo = z;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(AndroidUtilities.dp(2.0f));
        }
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_post_in_story_cell, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        this.imageViewUser = (ImageView) viewInflate.findViewById(R.id.imageViewUser);
        this.imageViewPost = (ImageView) viewInflate.findViewById(R.id.imageViewPost);
        this.textViewUsername = (TextView) viewInflate.findViewById(R.id.textViewUser);
        this.textViewCaption = (TextView) viewInflate.findViewById(R.id.textViewCaption);
        this.frameLayoutTopContainer = (FrameLayout) viewInflate.findViewById(R.id.frameLayoutTopContainer);
        this.imageViewIcon = (ImageView) viewInflate.findViewById(R.id.imageViewIcon);
        this.linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linearLayout);
        this.frameLayoutBottomContainer = (FrameLayout) viewInflate.findViewById(R.id.frameLayoutBottomContainer);
        this.postAndCaptionContainer = (LinearLayout) viewInflate.findViewById(R.id.postAndCaptionContainer);
        this.textViewUsername.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.textViewCaption.setTypeface(Theme.getRubinoTypeFaceRegular());
    }

    public void setPost(RubinoPostObject rubinoPostObject, ModeEnum modeEnum) {
        this.postObject = rubinoPostObject;
        setMode(modeEnum);
        RubinoPostObject rubinoPostObject2 = this.postObject;
        if (rubinoPostObject2 != null) {
            GlideHelper.loadCircle(this.mContext, this.imageViewUser, rubinoPostObject2.getProfileTryFromMap().full_thumbnail_url, R.drawable.placeholder_avatar_man);
            this.textViewUsername.setText(this.postObject.getProfileTryFromMap().username);
            RubinoPostObject rubinoPostObject3 = this.postObject;
            if (rubinoPostObject3.photoSlideObject != null) {
                if (rubinoPostObject3.post.file_type == Rubino.FileTypeEnum.Picture) {
                    MyLog.e("PostInStoryCell", "index " + this.postObject.photoSlideObject.getCurrentIndex());
                    GlideHelper.loadPath(this.mContext, this.imageViewPost, this.postObject.photoSlideObject.getPhotos().get(this.postObject.photoSlideObject.getCurrentIndex()).getDownloadFile().getPath(), R.color.white);
                    this.imageViewPost.setVisibility(0);
                } else if (rubinoPostObject.post.file_type == Rubino.FileTypeEnum.Video) {
                    MyLog.e("PostInStoryCell", "index " + this.postObject.photoSlideObject.getCurrentIndex());
                    if (this.supportVideo) {
                        this.imageViewPost.setVisibility(4);
                    } else {
                        GlideHelper.loadPath(this.mContext, this.imageViewPost, this.postObject.photoSlideObject.getPhotos().get(this.postObject.photoSlideObject.getCurrentIndex()).imageObject.getDownloadFile().getPath(), R.color.white);
                        this.imageViewPost.setVisibility(0);
                    }
                }
            } else {
                this.imageViewPost.setVisibility(0);
                this.imageViewPost.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.shape_rectangle_white_conrner_8dp));
            }
            Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
            if (postObjectFromServer.is_multi_file) {
                this.imageViewIcon.setVisibility(0);
                this.imageViewIcon.setImageResource(R.drawable.rubino_multi_grid_album_icon);
                this.imageViewIcon.setAlpha(0.9f);
            } else if (postObjectFromServer.file_type == Rubino.FileTypeEnum.Video) {
                this.imageViewIcon.setVisibility(0);
                this.imageViewIcon.setImageResource(R.drawable.rubino_video_filled_32);
                this.imageViewIcon.setAlpha(0.9f);
            } else {
                this.imageViewIcon.setVisibility(4);
            }
            setCaptionByMode();
            return;
        }
        this.imageViewIcon.setVisibility(4);
        this.textViewUsername.setText(BuildConfig.FLAVOR);
        this.imageViewPost.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.shape_rectangle_white_conrner_8dp));
        this.imageViewUser.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.placeholder_avatar_man));
    }

    public void setMode(ModeEnum modeEnum) {
        this.mode = modeEnum;
        if (modeEnum == ModeEnum.justImage) {
            this.frameLayoutTopContainer.setVisibility(4);
            this.frameLayoutTopContainer.setBackgroundColor(0);
            this.frameLayoutBottomContainer.setBackgroundColor(0);
        } else if (modeEnum == ModeEnum.details) {
            this.frameLayoutTopContainer.setVisibility(0);
            this.frameLayoutTopContainer.setBackground(this.mContext.getResources().getDrawable(R.drawable.shape_white_top_border));
            this.frameLayoutBottomContainer.setBackground(this.mContext.getResources().getDrawable(R.drawable.shape_white_bottom_border));
        }
        setCaptionByMode();
    }

    public void setCaptionByMode() {
        RubinoPostObject rubinoPostObject = this.postObject;
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (rubinoPostObject != null && rubinoPostObject.post != null) {
            this.textViewCaption.setVisibility(0);
            ModeEnum modeEnum = this.mode;
            if (modeEnum == ModeEnum.justImage) {
                this.textViewCaption.setTextColor(this.mContext.getResources().getColor(R.color.white));
                this.textViewCaption.setText("@" + this.postObject.profile.getUsername());
                this.textViewCaption.setShadowLayer((float) AndroidUtilities.dp(1.0f), 0.0f, (float) AndroidUtilities.dp(1.0f), -1442840576);
                return;
            }
            if (modeEnum == ModeEnum.details) {
                String str = this.postObject.post.caption;
                if (str != null && !str.isEmpty()) {
                    this.textViewCaption.setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
                    this.textViewCaption.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    RubinoPostObject rubinoPostObject2 = this.postObject;
                    SpannableString spannableString = rubinoPostObject2.shortCaptionInStorySpannableString;
                    if (spannableString != null) {
                        this.textViewCaption.setText(spannableString);
                        return;
                    }
                    TextView textView = this.textViewCaption;
                    CharSequence charSequence2 = rubinoPostObject2.captionSpannableString;
                    if (charSequence2 != null) {
                        charSequence = charSequence2;
                    }
                    textView.setText(charSequence);
                    return;
                }
                this.textViewCaption.setText(BuildConfig.FLAVOR);
                this.textViewCaption.setVisibility(8);
                return;
            }
            return;
        }
        this.textViewCaption.setText(BuildConfig.FLAVOR);
        this.textViewCaption.setVisibility(8);
    }

    public void setNextMode() {
        ModeEnum modeEnum = this.mode;
        ModeEnum modeEnum2 = ModeEnum.justImage;
        if (modeEnum == modeEnum2) {
            modeEnum2 = ModeEnum.details;
        }
        setMode(modeEnum2);
        requestLayout();
    }

    public int getClickableWidth() {
        if (this.mode == ModeEnum.justImage) {
            return this.postAndCaptionContainer.getWidth();
        }
        return getWidth();
    }

    public int getClickableHeight() {
        if (this.mode == ModeEnum.justImage) {
            return this.postAndCaptionContainer.getHeight();
        }
        return getHeight();
    }

    public float getClickableX() {
        if (this.mode == ModeEnum.justImage) {
            return getX() + this.postAndCaptionContainer.getX();
        }
        return getX();
    }

    public float getClickableY() {
        if (this.mode == ModeEnum.justImage) {
            return getY() + this.postAndCaptionContainer.getY();
        }
        return getY();
    }
}
