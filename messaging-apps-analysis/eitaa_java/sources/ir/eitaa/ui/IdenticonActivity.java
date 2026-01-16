package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.EmojiData;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.IdenticonDrawable;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.URLSpanReplacement;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class IdenticonActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private AnimatorSet animatorSet;
    private int chat_id;
    private TextView codeTextView;
    private FrameLayout container;
    private boolean emojiSelected;
    private String emojiText;
    private TextView emojiTextView;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout1;
    private TextView textView;

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            try {
                return super.onTouchEvent(widget, buffer, event);
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public IdenticonActivity(Bundle args) {
        super(args);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        this.chat_id = getArguments().getInt("chat_id");
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("EncryptionKey", R.string.EncryptionKey));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.IdenticonActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    IdenticonActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$IdenticonActivity$nvfNajIYzFeBGm5SKVDbF0Q4AD8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return IdenticonActivity.lambda$createView$0(view, motionEvent);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.linearLayout.setWeightSum(100.0f);
        frameLayout2.addView(this.linearLayout, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(20.0f));
        this.linearLayout.addView(frameLayout3, LayoutHelper.createLinear(-1, -1, 50.0f));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        frameLayout3.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: ir.eitaa.ui.IdenticonActivity.2
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (IdenticonActivity.this.codeTextView != null) {
                    int left2 = (IdenticonActivity.this.codeTextView.getLeft() + (IdenticonActivity.this.codeTextView.getMeasuredWidth() / 2)) - (IdenticonActivity.this.emojiTextView.getMeasuredWidth() / 2);
                    int measuredHeight = (((IdenticonActivity.this.codeTextView.getMeasuredHeight() - IdenticonActivity.this.emojiTextView.getMeasuredHeight()) / 2) + IdenticonActivity.this.linearLayout1.getTop()) - AndroidUtilities.dp(16.0f);
                    IdenticonActivity.this.emojiTextView.layout(left2, measuredHeight, IdenticonActivity.this.emojiTextView.getMeasuredWidth() + left2, IdenticonActivity.this.emojiTextView.getMeasuredHeight() + measuredHeight);
                }
            }
        };
        this.container = frameLayout4;
        frameLayout4.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.linearLayout.addView(this.container, LayoutHelper.createLinear(-1, -1, 50.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.linearLayout1 = linearLayout2;
        linearLayout2.setOrientation(1);
        this.linearLayout1.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        this.container.addView(this.linearLayout1, LayoutHelper.createFrame(-2, -2, 17));
        TextView textView = new TextView(context);
        this.codeTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        this.codeTextView.setGravity(17);
        this.codeTextView.setTypeface(Typeface.MONOSPACE);
        this.codeTextView.setTextSize(1, 16.0f);
        this.linearLayout1.addView(this.codeTextView, LayoutHelper.createLinear(-2, -2, 1));
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        this.textView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setLinksClickable(true);
        this.textView.setClickable(true);
        this.textView.setGravity(17);
        this.textView.setMovementMethod(new LinkMovementMethodMy());
        this.linearLayout1.addView(this.textView, LayoutHelper.createFrame(-2, -2, 1));
        TextView textView3 = new TextView(context);
        this.emojiTextView = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        this.emojiTextView.setGravity(17);
        this.emojiTextView.setTextSize(1, 32.0f);
        this.container.addView(this.emojiTextView, LayoutHelper.createFrame(-2, -2.0f));
        TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf(this.chat_id));
        if (encryptedChat != null) {
            IdenticonDrawable identiconDrawable = new IdenticonDrawable();
            imageView.setImageDrawable(identiconDrawable);
            identiconDrawable.setEncryptedChat(encryptedChat);
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(encryptedChat.user_id));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            StringBuilder sb = new StringBuilder();
            byte[] bArr = encryptedChat.key_hash;
            if (bArr.length > 16) {
                String strBytesToHex = Utilities.bytesToHex(bArr);
                for (int i = 0; i < 32; i++) {
                    if (i != 0) {
                        if (i % 8 == 0) {
                            spannableStringBuilder.append('\n');
                        } else if (i % 4 == 0) {
                            spannableStringBuilder.append(' ');
                        }
                    }
                    int i2 = i * 2;
                    spannableStringBuilder.append((CharSequence) strBytesToHex.substring(i2, i2 + 2));
                    spannableStringBuilder.append(' ');
                }
                spannableStringBuilder.append((CharSequence) "\n");
                for (int i3 = 0; i3 < 5; i3++) {
                    byte[] bArr2 = encryptedChat.key_hash;
                    int i4 = (i3 * 4) + 16;
                    int i5 = (bArr2[i4 + 3] & 255) | ((bArr2[i4] & 127) << 24) | ((bArr2[i4 + 1] & 255) << 16) | ((bArr2[i4 + 2] & 255) << 8);
                    if (i3 != 0) {
                        sb.append(" ");
                    }
                    String[] strArr = EmojiData.emojiSecret;
                    sb.append(strArr[i5 % strArr.length]);
                }
                this.emojiText = sb.toString();
            }
            this.codeTextView.setText(spannableStringBuilder.toString());
            spannableStringBuilder.clear();
            String str = user.first_name;
            spannableStringBuilder.append((CharSequence) AndroidUtilities.replaceTags(LocaleController.formatString("EncryptionKeyDescription", R.string.EncryptionKeyDescription, str, str)));
            int iIndexOf = spannableStringBuilder.toString().indexOf("eitaa.org");
            if (iIndexOf != -1) {
                spannableStringBuilder.setSpan(new URLSpanReplacement(LocaleController.getString("EncryptionKeyLink", R.string.EncryptionKeyLink)), iIndexOf, iIndexOf + 9, 33);
            }
            this.textView.setText(spannableStringBuilder);
        }
        updateEmojiButton(false);
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        fixLayout();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        fixLayout();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        TextView textView;
        if (id != NotificationCenter.emojiLoaded || (textView = this.emojiTextView) == null) {
            return;
        }
        textView.invalidate();
    }

    private void updateEmojiButton(boolean animated) {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        if (animated) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            Animator[] animatorArr = new Animator[6];
            TextView textView = this.emojiTextView;
            float[] fArr = new float[1];
            fArr[0] = this.emojiSelected ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(textView, "alpha", fArr);
            TextView textView2 = this.codeTextView;
            float[] fArr2 = new float[1];
            fArr2[0] = this.emojiSelected ? 0.0f : 1.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(textView2, "alpha", fArr2);
            TextView textView3 = this.emojiTextView;
            float[] fArr3 = new float[1];
            fArr3[0] = this.emojiSelected ? 1.0f : 0.0f;
            animatorArr[2] = ObjectAnimator.ofFloat(textView3, "scaleX", fArr3);
            TextView textView4 = this.emojiTextView;
            float[] fArr4 = new float[1];
            fArr4[0] = this.emojiSelected ? 1.0f : 0.0f;
            animatorArr[3] = ObjectAnimator.ofFloat(textView4, "scaleY", fArr4);
            TextView textView5 = this.codeTextView;
            float[] fArr5 = new float[1];
            fArr5[0] = this.emojiSelected ? 0.0f : 1.0f;
            animatorArr[4] = ObjectAnimator.ofFloat(textView5, "scaleX", fArr5);
            TextView textView6 = this.codeTextView;
            float[] fArr6 = new float[1];
            fArr6[0] = this.emojiSelected ? 0.0f : 1.0f;
            animatorArr[5] = ObjectAnimator.ofFloat(textView6, "scaleY", fArr6);
            animatorSet2.playTogether(animatorArr);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.IdenticonActivity.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(IdenticonActivity.this.animatorSet)) {
                        IdenticonActivity.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.setInterpolator(new DecelerateInterpolator());
            this.animatorSet.setDuration(150L);
            this.animatorSet.start();
        } else {
            this.emojiTextView.setAlpha(this.emojiSelected ? 1.0f : 0.0f);
            this.codeTextView.setAlpha(this.emojiSelected ? 0.0f : 1.0f);
            this.emojiTextView.setScaleX(this.emojiSelected ? 1.0f : 0.0f);
            this.emojiTextView.setScaleY(this.emojiSelected ? 1.0f : 0.0f);
            this.codeTextView.setScaleX(this.emojiSelected ? 0.0f : 1.0f);
            this.codeTextView.setScaleY(this.emojiSelected ? 0.0f : 1.0f);
        }
        this.emojiTextView.setTag(!this.emojiSelected ? "chat_emojiPanelIcon" : "chat_emojiPanelIconSelected");
    }

    private void fixLayout() {
        this.fragmentView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.IdenticonActivity.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (((BaseFragment) IdenticonActivity.this).fragmentView == null) {
                    return true;
                }
                ((BaseFragment) IdenticonActivity.this).fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
                if (rotation == 3 || rotation == 1) {
                    IdenticonActivity.this.linearLayout.setOrientation(0);
                } else {
                    IdenticonActivity.this.linearLayout.setOrientation(1);
                }
                ((BaseFragment) IdenticonActivity.this).fragmentView.setPadding(((BaseFragment) IdenticonActivity.this).fragmentView.getPaddingLeft(), 0, ((BaseFragment) IdenticonActivity.this).fragmentView.getPaddingRight(), ((BaseFragment) IdenticonActivity.this).fragmentView.getPaddingBottom());
                return true;
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        String str;
        if (!isOpen || backward || (str = this.emojiText) == null) {
            return;
        }
        TextView textView = this.emojiTextView;
        textView.setText(Emoji.replaceEmoji(str, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(32.0f), false));
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.container, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.codeTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.textView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, "windowBackgroundWhiteLinkText"));
        return arrayList;
    }
}
