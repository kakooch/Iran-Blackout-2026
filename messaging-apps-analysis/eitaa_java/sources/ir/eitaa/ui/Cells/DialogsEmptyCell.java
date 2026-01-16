package ir.eitaa.ui.Cells;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieImageView;

/* loaded from: classes3.dex */
public class DialogsEmptyCell extends LinearLayout {
    private int currentAccount;
    private int currentType;
    private TextView emptyTextView1;
    private TextView emptyTextView2;
    private RLottieImageView imageView;

    static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public DialogsEmptyCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        setGravity(17);
        setOrientation(1);
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$DialogsEmptyCell$pZDIgq1EdZi1kJTwm0CraG9DwGc
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DialogsEmptyCell.lambda$new$0(view, motionEvent);
            }
        });
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.imageView, LayoutHelper.createFrame(100, 100.0f, 17, 52.0f, 4.0f, 52.0f, 0.0f));
        this.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$DialogsEmptyCell$-QijdifiO5NOQxqM9Kr-YMX-XoI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$DialogsEmptyCell(view);
            }
        });
        TextView textView = new TextView(context);
        this.emptyTextView1 = textView;
        textView.setTextColor(Theme.getColor("chats_nameMessage_threeLines"));
        this.emptyTextView1.setText(LocaleController.getString("NoChats", R.string.NoChats));
        this.emptyTextView1.setTextSize(1, 20.0f);
        this.emptyTextView1.setTypeface(AndroidUtilities.getFontFamily(true));
        this.emptyTextView1.setGravity(17);
        addView(this.emptyTextView1, LayoutHelper.createFrame(-1, -2.0f, 51, 52.0f, 10.0f, 52.0f, 0.0f));
        this.emptyTextView2 = new TextView(context);
        String string = LocaleController.getString("NoChatsHelp", R.string.NoChatsHelp);
        if (AndroidUtilities.isTablet() && !AndroidUtilities.isSmallTablet()) {
            string = string.replace('\n', ' ');
        }
        this.emptyTextView2.setText(string);
        this.emptyTextView2.setTextColor(Theme.getColor("chats_message"));
        this.emptyTextView2.setTextSize(1, 14.0f);
        this.emptyTextView2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.emptyTextView2.setGravity(17);
        this.emptyTextView2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        addView(this.emptyTextView2, LayoutHelper.createFrame(-1, -2.0f, 51, 52.0f, 7.0f, 52.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$DialogsEmptyCell(View view) {
        if (this.imageView.isPlaying()) {
            return;
        }
        this.imageView.setProgress(0.0f);
        this.imageView.playAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setType(int r6) {
        /*
            r5 = this;
            int r0 = r5.currentType
            if (r0 != r6) goto L5
            return
        L5:
            r5.currentType = r6
            r0 = 2131692571(0x7f0f0c1b, float:1.9014246E38)
            java.lang.String r1 = "NoChats"
            r2 = 0
            if (r6 != 0) goto L24
            r6 = 2131692573(0x7f0f0c1d, float:1.901425E38)
            java.lang.String r3 = "NoChatsHelp"
            java.lang.String r6 = ir.eitaa.messenger.LocaleController.getString(r3, r6)
            android.widget.TextView r3 = r5.emptyTextView1
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            r3.setText(r0)
        L21:
            r0 = r6
            r6 = 0
            goto L7c
        L24:
            r3 = 1
            if (r6 != r3) goto L3a
            r6 = 2131692572(0x7f0f0c1c, float:1.9014248E38)
            java.lang.String r3 = "NoChatsContactsHelp"
            java.lang.String r6 = ir.eitaa.messenger.LocaleController.getString(r3, r6)
            android.widget.TextView r3 = r5.emptyTextView1
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            r3.setText(r0)
            goto L21
        L3a:
            r0 = 2
            if (r6 != r0) goto L5d
            ir.eitaa.ui.Components.RLottieImageView r6 = r5.imageView
            r6.setAutoRepeat(r2)
            r6 = 2131623971(0x7f0e0023, float:1.8875109E38)
            r0 = 2131691542(0x7f0f0816, float:1.9012159E38)
            java.lang.String r1 = "FilterNoChatsToDisplayInfo"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            android.widget.TextView r1 = r5.emptyTextView1
            r3 = 2131691541(0x7f0f0815, float:1.9012157E38)
            java.lang.String r4 = "FilterNoChatsToDisplay"
            java.lang.String r3 = ir.eitaa.messenger.LocaleController.getString(r4, r3)
            r1.setText(r3)
            goto L7c
        L5d:
            ir.eitaa.ui.Components.RLottieImageView r6 = r5.imageView
            r6.setAutoRepeat(r3)
            r6 = 2131623970(0x7f0e0022, float:1.8875107E38)
            r0 = 2131691497(0x7f0f07e9, float:1.9012068E38)
            java.lang.String r1 = "FilterAddingChatsInfo"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            android.widget.TextView r1 = r5.emptyTextView1
            r3 = 2131691496(0x7f0f07e8, float:1.9012065E38)
            java.lang.String r4 = "FilterAddingChats"
            java.lang.String r3 = ir.eitaa.messenger.LocaleController.getString(r4, r3)
            r1.setText(r3)
        L7c:
            if (r6 == 0) goto L90
            ir.eitaa.ui.Components.RLottieImageView r1 = r5.imageView
            r1.setVisibility(r2)
            ir.eitaa.ui.Components.RLottieImageView r1 = r5.imageView
            r2 = 100
            r1.setAnimation(r6, r2, r2)
            ir.eitaa.ui.Components.RLottieImageView r6 = r5.imageView
            r6.playAnimation()
            goto L97
        L90:
            ir.eitaa.ui.Components.RLottieImageView r6 = r5.imageView
            r1 = 8
            r6.setVisibility(r1)
        L97:
            boolean r6 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r6 == 0) goto Lab
            boolean r6 = ir.eitaa.messenger.AndroidUtilities.isSmallTablet()
            if (r6 != 0) goto Lab
            r6 = 10
            r1 = 32
            java.lang.String r0 = r0.replace(r6, r1)
        Lab:
            android.widget.TextView r6 = r5.emptyTextView2
            r6.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DialogsEmptyCell.setType(int):void");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        updateLayout();
    }

    @Override // android.view.View
    public void offsetTopAndBottom(int offset) {
        super.offsetTopAndBottom(offset);
        updateLayout();
    }

    public void updateLayout() {
        if (getParent() instanceof View) {
            int i = this.currentType;
            if ((i == 2 || i == 3) && ((View) getParent()).getPaddingTop() != 0) {
                float f = -(getTop() / 2);
                this.imageView.setTranslationY(f);
                this.emptyTextView1.setTranslationY(f);
                this.emptyTextView2.setTranslationY(f);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        if (getParent() instanceof View) {
            View view = (View) getParent();
            size = view.getMeasuredHeight();
            if (view.getPaddingTop() != 0 && Build.VERSION.SDK_INT >= 21) {
                size -= AndroidUtilities.statusBarHeight;
            }
        } else {
            size = View.MeasureSpec.getSize(heightMeasureSpec);
        }
        if (size == 0) {
            size = (AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
        }
        int i = this.currentType;
        if (i == 0 || i == 2 || i == 3) {
            if (!MessagesController.getInstance(this.currentAccount).hintDialogs.isEmpty()) {
                size -= (((AndroidUtilities.dp(72.0f) * r6.size()) + r6.size()) - 1) + AndroidUtilities.dp(50.0f);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            return;
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(166.0f), 1073741824));
    }
}
