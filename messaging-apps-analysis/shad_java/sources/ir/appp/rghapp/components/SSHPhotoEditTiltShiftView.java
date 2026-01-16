package ir.appp.rghapp.components;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.rghapp.components.SSHPhotoEditCell;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHPhotoEditTiltShiftView extends FrameLayout {
    private OnActionClickedListener delegate;
    private final SSHPhotoEditCell linearView;
    private final SSHPhotoEditCell offView;
    private OnTiltShiftedClicked onTiltShiftedClicked;
    private final SSHPhotoEditCell radiclView;
    private int selectedPosition;

    public interface OnActionClickedListener {
        void onCancelClicked();

        void onDoneClicked();
    }

    public interface OnTiltShiftedClicked {
        void onTiltShiftedClicked(int i, SSHPhotoEditCell sSHPhotoEditCell);
    }

    public SSHPhotoEditTiltShiftView(Context context) {
        super(context);
        this.selectedPosition = 0;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        SSHPhotoEditCell.OnViewClickListener onViewClickListener = new SSHPhotoEditCell.OnViewClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditTiltShiftView$$ExternalSyntheticLambda2
            @Override // ir.appp.rghapp.components.SSHPhotoEditCell.OnViewClickListener
            public final void onClick(SSHPhotoEditCell sSHPhotoEditCell) {
                this.f$0.lambda$new$0(sSHPhotoEditCell);
            }
        };
        SSHPhotoEditCell sSHPhotoEditCell = new SSHPhotoEditCell(context);
        this.offView = sSHPhotoEditCell;
        sSHPhotoEditCell.setTag(0);
        sSHPhotoEditCell.setDrawablePadding(AndroidUtilities.dp(25.0f));
        sSHPhotoEditCell.setTextAndIcon("Off", R.drawable.ic_tilt_shift_off);
        sSHPhotoEditCell.setSelected(true);
        sSHPhotoEditCell.setOnViewClickListener(onViewClickListener);
        linearLayout.addView(sSHPhotoEditCell, LayoutHelper.createLinear(88, -1));
        SSHPhotoEditCell sSHPhotoEditCell2 = new SSHPhotoEditCell(context);
        this.radiclView = sSHPhotoEditCell2;
        sSHPhotoEditCell2.setTag(1);
        sSHPhotoEditCell2.setDrawablePadding(AndroidUtilities.dp(25.0f));
        sSHPhotoEditCell2.setTextAndIcon("Radial", R.drawable.ic_tilt_shift_radial);
        sSHPhotoEditCell2.setOnViewClickListener(onViewClickListener);
        linearLayout.addView(sSHPhotoEditCell2, LayoutHelper.createLinear(88, -1));
        SSHPhotoEditCell sSHPhotoEditCell3 = new SSHPhotoEditCell(context);
        this.linearView = sSHPhotoEditCell3;
        sSHPhotoEditCell3.setTag(2);
        sSHPhotoEditCell3.setDrawablePadding(AndroidUtilities.dp(25.0f));
        sSHPhotoEditCell3.setTextAndIcon("Linear", R.drawable.ic_tilt_shift_linear);
        sSHPhotoEditCell3.setOnViewClickListener(onViewClickListener);
        linearLayout.addView(sSHPhotoEditCell3, LayoutHelper.createLinear(88, -1));
        addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 44.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(getContext());
        textView.setWillNotDraw(false);
        textView.setGravity(17);
        textView.setText(LocaleController.getString("CANCEL", R.string.rubinoActionCancel));
        int i = Theme.key_rubino_add_post_TabActiveText;
        textView.setTextColor(Theme.getColor(i));
        textView.setTextSize(1, 14.0f);
        textView.setSingleLine(true);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditTiltShiftView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        linearLayout2.addView(textView, LayoutHelper.createLinear(0, -1, 0.5f));
        TextView textView2 = new TextView(getContext());
        textView2.setWillNotDraw(false);
        textView2.setGravity(17);
        textView2.setText(LocaleController.getString("DONE", R.string.rubinoActionDone));
        textView2.setTextColor(Theme.getColor(i));
        textView2.setTextSize(1, 14.0f);
        textView2.setSingleLine(true);
        textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditTiltShiftView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        linearLayout2.addView(textView2, LayoutHelper.createLinear(0, -1, 0.5f));
        addView(linearLayout2, LayoutHelper.createFrame(-1, 44, 83));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SSHPhotoEditCell sSHPhotoEditCell) {
        getSelectedView().setSelected(false);
        this.selectedPosition = ((Integer) sSHPhotoEditCell.getTag()).intValue();
        sSHPhotoEditCell.setSelected(true);
        OnTiltShiftedClicked onTiltShiftedClicked = this.onTiltShiftedClicked;
        if (onTiltShiftedClicked != null) {
            onTiltShiftedClicked.onTiltShiftedClicked(this.selectedPosition, sSHPhotoEditCell);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        OnActionClickedListener onActionClickedListener = this.delegate;
        if (onActionClickedListener != null) {
            onActionClickedListener.onCancelClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        OnActionClickedListener onActionClickedListener = this.delegate;
        if (onActionClickedListener != null) {
            onActionClickedListener.onDoneClicked();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    public void setSelectedPosition(int i) {
        getSelectedView().setSelected(false);
        this.selectedPosition = i;
        getSelectedView().setSelected(true);
    }

    private SSHPhotoEditCell getSelectedView() {
        int i = this.selectedPosition;
        if (i == 0) {
            return this.offView;
        }
        if (i == 1) {
            return this.radiclView;
        }
        return this.linearView;
    }

    public void setOnTiltShiftedClickListener(OnTiltShiftedClicked onTiltShiftedClicked) {
        this.onTiltShiftedClicked = onTiltShiftedClicked;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.delegate = onActionClickedListener;
    }
}
