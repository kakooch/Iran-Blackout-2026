package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.StoryObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddStoryBottomView extends LinearLayout {
    private final int currentAccount;
    public FrameLayout deleteView;
    public FrameLayout frameLayoutOptionContainer;
    public FrameLayout frameLayoutSave;
    private ImageView imageViewDelete;
    public boolean isInOptionMode;
    public LinearLayout linearLayout;

    public AddStoryBottomView(Context context) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        setOrientation(1);
        setGravity(3);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayoutOptionContainer = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(-1, -2.0f));
        this.deleteView = new FrameLayout(context);
        ImageView imageView = new ImageView(context);
        this.imageViewDelete = imageView;
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_trash_delete_outline_24));
        this.imageViewDelete.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        this.deleteView.setBackground(context.getResources().getDrawable(R.drawable.circle_black_alpha));
        this.deleteView.addView(this.imageViewDelete, LayoutHelper.createFrame(20, 20, 17));
        this.frameLayoutOptionContainer.addView(this.deleteView, LayoutHelper.createFrame(40, 40.0f, 3, 8.0f, 8.0f, 8.0f, 8.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.linearLayout.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        this.linearLayout.setBackgroundColor(Color.argb(ImageReceiver.DEFAULT_CROSSFADE_DURATION, 0, 0, 0));
        if (Build.VERSION.SDK_INT >= 17) {
            this.linearLayout.setLayoutDirection(0);
        }
        FrameLayout frameLayout2 = new FrameLayout(context);
        addView(frameLayout2, LayoutHelper.createFrame(-1, -2, 80));
        frameLayout2.addView(this.linearLayout, LayoutHelper.createFrame(-1, -2, 83));
        setOptionMode(false);
        ImageView imageView2 = new ImageView(context);
        if (AppRubinoPreferences.getInstance(i).getInstaCurrentProfileObject() != null) {
            GlideHelper.loadCircle(context, imageView2, AppRubinoPreferences.getInstance(i).getInstaCurrentProfileObject().full_thumbnail_url, R.drawable.placeholder_avatar_man);
        } else {
            imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder_avatar_man));
        }
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.frameLayoutSave = frameLayout3;
        frameLayout3.addView(imageView2, LayoutHelper.createFrame(32, 32.0f, 21, 2.0f, 2.0f, 2.0f, 2.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
        textView.setGravity(17);
        textView.setTextSize(1, 13.0f);
        textView.setText(LocaleController.getString(R.string.rubinoActionSend));
        this.frameLayoutSave.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 21, 16.0f, 0.0f, 48.0f, 0.0f));
        this.frameLayoutSave.setBackground(context.getResources().getDrawable(R.drawable.story_send_background));
        frameLayout2.addView(this.frameLayoutSave, LayoutHelper.createFrame(-2, -2.0f, 21, 0.0f, 0.0f, 16.0f, 0.0f));
    }

    public void setOptionMode(boolean z) {
        this.isInOptionMode = z;
        if (z) {
            this.frameLayoutOptionContainer.setVisibility(0);
        } else {
            this.frameLayoutOptionContainer.setVisibility(4);
        }
    }

    public static class LocalStoryFileCell extends FrameLayout {
        public ImageView border;
        public Context context;
        public long endTime;
        public boolean glSceneInitiated;
        public ImageView imageView;
        public int index;
        public boolean inited;
        public boolean isNeededToSave;
        public boolean isSelected;
        public StoryObject localStory;
        public long startTime;

        public LocalStoryFileCell(Context context) {
            super(context);
            this.isNeededToSave = true;
            this.context = context;
            this.border = new ImageView(context);
            this.imageView = new ImageView(context);
            this.border.setImageResource(R.drawable.rubino_shape_transparent_rectangle_border_white);
            this.imageView.setImageResource(R.drawable.rubino_shape_rectangle_grey);
            addView(this.imageView, LayoutHelper.createFrame(32, 64, 17));
            addView(this.border, LayoutHelper.createFrame(36, 68, 17));
        }

        public void setStory(StoryObject storyObject, int i, long j, long j2) {
            if (storyObject == null) {
                return;
            }
            this.localStory = storyObject;
            this.index = i;
            this.startTime = j;
            this.endTime = j2;
            Bitmap videoFrameAt = AddStoryBottomView.getVideoFrameAt(storyObject.localFilePathBeforeSave, j);
            if (videoFrameAt != null && !videoFrameAt.isRecycled()) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.transforms(new CenterCrop(), new RoundedCorners(AndroidUtilities.dp(7.0f)));
                Glide.with(this.context).load(videoFrameAt).apply((BaseRequestOptions<?>) requestOptions).into(this.imageView);
            }
            setSelected(this.isSelected);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            this.isSelected = z;
            if (z) {
                this.border.setVisibility(0);
            } else {
                this.border.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap getVideoFrameAt(java.lang.String r5, long r6) throws java.io.IOException {
        /*
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r1 = 1
            r2 = 0
            r0.setDataSource(r5)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1d
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r3
            android.graphics.Bitmap r5 = r0.getFrameAtTime(r6, r1)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1d
            r0.release()     // Catch: java.lang.RuntimeException -> L16
            goto L21
        L16:
            goto L21
        L18:
            r5 = move-exception
            r0.release()     // Catch: java.lang.RuntimeException -> L1c
        L1c:
            throw r5
        L1d:
            r0.release()     // Catch: java.lang.RuntimeException -> L20
        L20:
            r5 = r2
        L21:
            if (r5 != 0) goto L24
            return r2
        L24:
            int r6 = r5.getWidth()
            int r7 = r5.getHeight()
            int r0 = java.lang.Math.max(r6, r7)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 <= r2) goto L4a
            r2 = 1133903872(0x43960000, float:300.0)
            float r0 = (float) r0
            float r2 = r2 / r0
            float r6 = (float) r6
            float r6 = r6 * r2
            int r6 = java.lang.Math.round(r6)
            float r7 = (float) r7
            float r2 = r2 * r7
            int r7 = java.lang.Math.round(r2)
            android.graphics.Bitmap r5 = org.rbmain.messenger.Bitmaps.createScaledBitmap(r5, r6, r7, r1)
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.AddStoryBottomView.getVideoFrameAt(java.lang.String, long):android.graphics.Bitmap");
    }
}
