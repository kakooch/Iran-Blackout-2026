package ir.resaneh1.iptv.barcode;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.barcode.BarcodeHelper;
import ir.resaneh1.iptv.fragment.EnterCodeFragment;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class NewBarcodeScannerFragment extends PresenterFragment {
    private final Link.BarcodescanData barcodeScanData;
    LinearLayout linearLayout;
    BarcodeHelper.Listener listener;
    private RGHDecorateBarcodeView mBarcodeScannerView;
    private RGHViewfinderView mViewFinderView;
    String title;
    String mLastText = null;
    private BarcodeCallback callback = new BarcodeCallback() { // from class: ir.resaneh1.iptv.barcode.NewBarcodeScannerFragment.5
        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void possibleResultPoints(List<ResultPoint> list) {
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void barcodeResult(BarcodeResult barcodeResult) {
            try {
                NewBarcodeScannerFragment newBarcodeScannerFragment = NewBarcodeScannerFragment.this;
                if (newBarcodeScannerFragment.mLastText == null) {
                    newBarcodeScannerFragment.mLastText = barcodeResult.getText();
                    NewBarcodeScannerFragment.this.mBarcodeScannerView.setStatusText(barcodeResult.getText());
                    Vibrator vibrator = (Vibrator) NewBarcodeScannerFragment.this.getParentActivity().getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(10L);
                    }
                    NewBarcodeScannerFragment newBarcodeScannerFragment2 = NewBarcodeScannerFragment.this;
                    newBarcodeScannerFragment2.listener.onDone(newBarcodeScannerFragment2.mLastText);
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            } catch (Exception unused) {
            }
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.barcode_fragment;
    }

    public NewBarcodeScannerFragment(BarcodeHelper.Listener listener, String str, Link.BarcodescanData barcodescanData) {
        this.listener = listener;
        this.title = str;
        this.barcodeScanData = barcodescanData;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.title);
        if (hasFlash()) {
            final ToolbarImageView toolbarImageView = new ToolbarImageView();
            toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_flashlight_off, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
            toolbarImageView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.barcode.NewBarcodeScannerFragment.1
                boolean isOn = false;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!this.isOn) {
                        NewBarcodeScannerFragment.this.mBarcodeScannerView.setTorchOn();
                        toolbarImageView.imageView.setImageResource(R.drawable.ic_flashlight_on);
                    } else {
                        NewBarcodeScannerFragment.this.mBarcodeScannerView.setTorchOff();
                        toolbarImageView.imageView.setImageResource(R.drawable.ic_flashlight_off);
                    }
                    this.isOn = !this.isOn;
                }
            });
            toolbarImageView.imageView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(4.0f));
            this.toolbarMaker.addViewToLeftLayout(toolbarImageView.view);
        }
        this.mBarcodeScannerView = (RGHDecorateBarcodeView) findViewById(R.id.zxing_barcode_scanner);
        this.mViewFinderView = (RGHViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.mBarcodeScannerView.decodeContinuous(this.callback);
        this.mViewFinderView.setScannerBorder(new ScannerBorder(11, R.color.yellow_500));
        findViewById(R.id.textViewEnterCode).setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.barcode.NewBarcodeScannerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewBarcodeScannerFragment.this.barcodeScanData != null && NewBarcodeScannerFragment.this.barcodeScanData.code_entry_message != null && !NewBarcodeScannerFragment.this.barcodeScanData.code_entry_message.isEmpty()) {
                    NewBarcodeScannerFragment.this.presentFragment(new EnterCodeFragment(NewBarcodeScannerFragment.this.barcodeScanData.code_entry_message, BuildConfig.FLAVOR, NewBarcodeScannerFragment.this.listener));
                    return;
                }
                NewBarcodeScannerFragment newBarcodeScannerFragment = NewBarcodeScannerFragment.this;
                NewBarcodeScannerFragment newBarcodeScannerFragment2 = NewBarcodeScannerFragment.this;
                newBarcodeScannerFragment.presentFragment(new EnterCodeFragment(newBarcodeScannerFragment2.title, BuildConfig.FLAVOR, newBarcodeScannerFragment2.listener));
            }
        });
        Link.BarcodescanData barcodescanData = this.barcodeScanData;
        if (barcodescanData != null) {
            String str = barcodescanData.code_entry_message;
            if (str != null && !str.isEmpty()) {
                ((TextView) findViewById(R.id.textViewEnterCode)).setText(this.barcodeScanData.code_entry_message);
            }
            Link.BarcodescanData barcodescanData2 = this.barcodeScanData;
            if (!barcodescanData2.has_link || barcodescanData2.link == null) {
                return;
            }
            TextView textView = (TextView) findViewById(R.id.textViewLink);
            textView.setText(this.barcodeScanData.link_title + BuildConfig.FLAVOR);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.barcode.NewBarcodeScannerFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainClickHandler mainClickHandler = new MainClickHandler();
                    NewBarcodeScannerFragment newBarcodeScannerFragment = NewBarcodeScannerFragment.this;
                    mainClickHandler.onLinkClick(newBarcodeScannerFragment.baseFragment, newBarcodeScannerFragment.barcodeScanData.link);
                }
            });
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.barcode.NewBarcodeScannerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                NewBarcodeScannerFragment.this.mBarcodeScannerView.resume();
                NewBarcodeScannerFragment.this.getFragmentView().requestLayout();
                NewBarcodeScannerFragment.this.getFragmentView().invalidate();
            }
        }, 270L);
        if (!isPortrait()) {
            ((FrameLayout.LayoutParams) this.linearLayout.getLayoutParams()).gravity = 21;
        } else {
            ((FrameLayout.LayoutParams) this.linearLayout.getLayoutParams()).gravity = 81;
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.mBarcodeScannerView.pause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ((FrameLayout.LayoutParams) this.linearLayout.getLayoutParams()).gravity = 21;
        } else {
            ((FrameLayout.LayoutParams) this.linearLayout.getLayoutParams()).gravity = 81;
        }
    }

    private boolean hasFlash() {
        return ApplicationLoader.applicationContext.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public boolean isPortrait() {
        try {
            return this.mContext.getResources().getConfiguration().orientation == 1;
        } catch (Exception unused) {
            return true;
        }
    }
}
