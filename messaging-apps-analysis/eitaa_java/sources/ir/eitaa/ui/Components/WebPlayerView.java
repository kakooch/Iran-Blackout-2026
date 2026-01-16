package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Property;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Components.VideoPlayer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class WebPlayerView extends ViewGroup implements VideoPlayer.VideoPlayerDelegate, AudioManager.OnAudioFocusChangeListener {
    private static int lastContainerId = 4001;
    private boolean allowInlineAnimation;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private int audioFocus;
    private Paint backgroundPaint;
    private TextureView changedTextureView;
    private boolean changingTextureView;
    private ControlsView controlsView;
    private float currentAlpha;
    private Bitmap currentBitmap;
    private AsyncTask currentTask;
    private String currentYoutubeId;
    private WebPlayerViewDelegate delegate;
    private boolean drawImage;
    private boolean firstFrameRendered;
    private int fragment_container_id;
    private ImageView fullscreenButton;
    private boolean hasAudioFocus;
    private boolean inFullscreen;
    private boolean initied;
    private ImageView inlineButton;
    private String interfaceName;
    private boolean isAutoplay;
    private boolean isCompleted;
    private boolean isInline;
    private boolean isLoading;
    private boolean isStream;
    private long lastUpdateTime;
    private String playAudioType;
    private String playAudioUrl;
    private ImageView playButton;
    private String playVideoType;
    private String playVideoUrl;
    private AnimatorSet progressAnimation;
    private Runnable progressRunnable;
    private RadialProgressView progressView;
    private boolean resumeAudioOnFocusGain;
    private int seekToTime;
    private ImageView shareButton;
    private TextureView.SurfaceTextureListener surfaceTextureListener;
    private Runnable switchToInlineRunnable;
    private boolean switchingInlineMode;
    private ImageView textureImageView;
    private TextureView textureView;
    private ViewGroup textureViewContainer;
    private VideoPlayer videoPlayer;
    private int waitingForFirstTextureUpload;
    private WebView webView;
    private static final Pattern youtubeIdRegex = Pattern.compile("(?:youtube(?:-nocookie)?\\.com/(?:[^/\\n\\s]+/\\S+/|(?:v|e(?:mbed)?)/|\\S*?[?&]v=)|youtu\\.be/)([a-zA-Z0-9_-]{11})");
    private static final Pattern vimeoIdRegex = Pattern.compile("https?://(?:(?:www|(player))\\.)?vimeo(pro)?\\.com/(?!(?:channels|album)/[^/?#]+/?(?:$|[?#])|[^/]+/review/|ondemand/)(?:.*?/)?(?:(?:play_redirect_hls|moogaloop\\.swf)\\?clip_id=)?(?:videos?/)?([0-9]+)(?:/[\\da-f]+)?/?(?:[?&].*)?(?:[#].*)?$");
    private static final Pattern coubIdRegex = Pattern.compile("(?:coub:|https?://(?:coub\\.com/(?:view|embed|coubs)/|c-cdn\\.coub\\.com/fb-player\\.swf\\?.*\\bcoub(?:ID|id)=))([\\da-z]+)");
    private static final Pattern aparatIdRegex = Pattern.compile("^https?://(?:www\\.)?aparat\\.com/(?:v/|video/video/embed/videohash/)([a-zA-Z0-9]+)");
    private static final Pattern twitchClipIdRegex = Pattern.compile("https?://clips\\.twitch\\.tv/(?:[^/]+/)*([^/?#&]+)");
    private static final Pattern twitchStreamIdRegex = Pattern.compile("https?://(?:(?:www\\.)?twitch\\.tv/|player\\.twitch\\.tv/\\?.*?\\bchannel=)([^/#?]+)");
    private static final Pattern aparatFileListPattern = Pattern.compile("fileList\\s*=\\s*JSON\\.parse\\('([^']+)'\\)");
    private static final Pattern twitchClipFilePattern = Pattern.compile("clipInfo\\s*=\\s*(\\{[^']+\\});");
    private static final Pattern stsPattern = Pattern.compile("\"sts\"\\s*:\\s*(\\d+)");
    private static final Pattern jsPattern = Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")");
    private static final Pattern sigPattern = Pattern.compile("\\.sig\\|\\|([a-zA-Z0-9$]+)\\(");
    private static final Pattern sigPattern2 = Pattern.compile("[\"']signature[\"']\\s*,\\s*([a-zA-Z0-9$]+)\\(");
    private static final Pattern stmtVarPattern = Pattern.compile("var\\s");
    private static final Pattern stmtReturnPattern = Pattern.compile("return(?:\\s+|$)");
    private static final Pattern exprParensPattern = Pattern.compile("[()]");
    private static final Pattern playerIdPattern = Pattern.compile(".*?-([a-zA-Z0-9_-]+)(?:/watch_as3|/html5player(?:-new)?|(?:/[a-z]{2}_[A-Z]{2})?/base)?\\.([a-z]+)$");

    public interface CallJavaResultInterface {
        void jsCallFinished(String value);
    }

    public interface WebPlayerViewDelegate {
        boolean checkInlinePermissions();

        ViewGroup getTextureViewContainer();

        void onInitFailed();

        void onInlineSurfaceTextureReady();

        void onPlayStateChanged(WebPlayerView playerView, boolean playing);

        void onSharePressed();

        TextureView onSwitchInlineMode(View controlsView, boolean inline, float aspectRatio, int rotation, boolean animated);

        TextureView onSwitchToFullscreen(View controlsView, boolean fullscreen, float aspectRatio, int rotation, boolean byButton);

        void onVideoSizeChanged(float aspectRatio, int rotation);

        void prepareToSwitchInlineMode(boolean inline, Runnable switchInlineModeRunnable, float aspectRatio, boolean animated);
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
    }

    static /* synthetic */ float access$4524(WebPlayerView webPlayerView, float f) {
        float f2 = webPlayerView.currentAlpha - f;
        webPlayerView.currentAlpha = f2;
        return f2;
    }

    private static class JSExtractor {
        private String jsCode;
        ArrayList<String> codeLines = new ArrayList<>();
        private String[] operators = {"|", "^", "&", ">>", "<<", "-", "+", "%", "/", "*"};
        private String[] assign_operators = {"|=", "^=", "&=", ">>=", "<<=", "-=", "+=", "%=", "/=", "*=", "="};

        public JSExtractor(String js) {
            this.jsCode = js;
        }

        private void interpretExpression(String expr, HashMap<String, String> localVars, int allowRecursion) throws Exception {
            String strTrim = expr.trim();
            if (TextUtils.isEmpty(strTrim)) {
                return;
            }
            if (strTrim.charAt(0) == '(') {
                Matcher matcher = WebPlayerView.exprParensPattern.matcher(strTrim);
                int i = 0;
                while (true) {
                    if (!matcher.find()) {
                        break;
                    }
                    if (matcher.group(0).indexOf(48) == 40) {
                        i++;
                    } else {
                        i--;
                        if (i == 0) {
                            interpretExpression(strTrim.substring(1, matcher.start()), localVars, allowRecursion);
                            strTrim = strTrim.substring(matcher.end()).trim();
                            if (TextUtils.isEmpty(strTrim)) {
                                return;
                            }
                        }
                    }
                }
                if (i != 0) {
                    throw new Exception(String.format("Premature end of parens in %s", strTrim));
                }
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.assign_operators;
                if (i2 < strArr.length) {
                    Matcher matcher2 = Pattern.compile(String.format(Locale.US, "(?x)(%s)(?:\\[([^\\]]+?)\\])?\\s*%s(.*)$", "[a-zA-Z_$][a-zA-Z_$0-9]*", Pattern.quote(strArr[i2]))).matcher(strTrim);
                    if (matcher2.find()) {
                        interpretExpression(matcher2.group(3), localVars, allowRecursion - 1);
                        String strGroup = matcher2.group(2);
                        if (!TextUtils.isEmpty(strGroup)) {
                            interpretExpression(strGroup, localVars, allowRecursion);
                            return;
                        } else {
                            localVars.put(matcher2.group(1), "");
                            return;
                        }
                    }
                    i2++;
                } else {
                    try {
                        Integer.parseInt(strTrim);
                        return;
                    } catch (Exception unused) {
                        if (Pattern.compile(String.format(Locale.US, "(?!if|return|true|false)(%s)$", "[a-zA-Z_$][a-zA-Z_$0-9]*")).matcher(strTrim).find()) {
                            return;
                        }
                        if (strTrim.charAt(0) == '\"' && strTrim.charAt(strTrim.length() - 1) == '\"') {
                            return;
                        }
                        try {
                            new JSONObject(strTrim).toString();
                            return;
                        } catch (Exception unused2) {
                            Locale locale = Locale.US;
                            Matcher matcher3 = Pattern.compile(String.format(locale, "(%s)\\[(.+)\\]$", "[a-zA-Z_$][a-zA-Z_$0-9]*")).matcher(strTrim);
                            if (matcher3.find()) {
                                matcher3.group(1);
                                interpretExpression(matcher3.group(2), localVars, allowRecursion - 1);
                                return;
                            }
                            Matcher matcher4 = Pattern.compile(String.format(locale, "(%s)(?:\\.([^(]+)|\\[([^]]+)\\])\\s*(?:\\(+([^()]*)\\))?$", "[a-zA-Z_$][a-zA-Z_$0-9]*")).matcher(strTrim);
                            if (matcher4.find()) {
                                String strGroup2 = matcher4.group(1);
                                String strGroup3 = matcher4.group(2);
                                String strGroup4 = matcher4.group(3);
                                if (TextUtils.isEmpty(strGroup3)) {
                                    strGroup3 = strGroup4;
                                }
                                strGroup3.replace("\"", "");
                                String strGroup5 = matcher4.group(4);
                                if (localVars.get(strGroup2) == null) {
                                    extractObject(strGroup2);
                                }
                                if (strGroup5 == null) {
                                    return;
                                }
                                if (strTrim.charAt(strTrim.length() - 1) != ')') {
                                    throw new Exception("last char not ')'");
                                }
                                if (strGroup5.length() != 0) {
                                    for (String str : strGroup5.split(",")) {
                                        interpretExpression(str, localVars, allowRecursion);
                                    }
                                    return;
                                }
                                return;
                            }
                            Matcher matcher5 = Pattern.compile(String.format(locale, "(%s)\\[(.+)\\]$", "[a-zA-Z_$][a-zA-Z_$0-9]*")).matcher(strTrim);
                            if (matcher5.find()) {
                                localVars.get(matcher5.group(1));
                                interpretExpression(matcher5.group(2), localVars, allowRecursion - 1);
                                return;
                            }
                            int i3 = 0;
                            while (true) {
                                String[] strArr2 = this.operators;
                                if (i3 < strArr2.length) {
                                    String str2 = strArr2[i3];
                                    Matcher matcher6 = Pattern.compile(String.format(Locale.US, "(.+?)%s(.+)", Pattern.quote(str2))).matcher(strTrim);
                                    if (matcher6.find()) {
                                        boolean[] zArr = new boolean[1];
                                        int i4 = allowRecursion - 1;
                                        interpretStatement(matcher6.group(1), localVars, zArr, i4);
                                        if (zArr[0]) {
                                            throw new Exception(String.format("Premature left-side return of %s in %s", str2, strTrim));
                                        }
                                        interpretStatement(matcher6.group(2), localVars, zArr, i4);
                                        if (zArr[0]) {
                                            throw new Exception(String.format("Premature right-side return of %s in %s", str2, strTrim));
                                        }
                                    }
                                    i3++;
                                } else {
                                    Matcher matcher7 = Pattern.compile(String.format(Locale.US, "^(%s)\\(([a-zA-Z0-9_$,]*)\\)$", "[a-zA-Z_$][a-zA-Z_$0-9]*")).matcher(strTrim);
                                    if (matcher7.find()) {
                                        extractFunction(matcher7.group(1));
                                    }
                                    throw new Exception(String.format("Unsupported JS expression %s", strTrim));
                                }
                            }
                        }
                    }
                }
            }
        }

        private void interpretStatement(String stmt, HashMap<String, String> localVars, boolean[] abort, int allowRecursion) throws Exception {
            if (allowRecursion < 0) {
                throw new Exception("recursion limit reached");
            }
            abort[0] = false;
            String strTrim = stmt.trim();
            Matcher matcher = WebPlayerView.stmtVarPattern.matcher(strTrim);
            if (!matcher.find()) {
                Matcher matcher2 = WebPlayerView.stmtReturnPattern.matcher(strTrim);
                if (matcher2.find()) {
                    strTrim = strTrim.substring(matcher2.group(0).length());
                    abort[0] = true;
                }
            } else {
                strTrim = strTrim.substring(matcher.group(0).length());
            }
            interpretExpression(strTrim, localVars, allowRecursion);
        }

        private HashMap<String, Object> extractObject(String objname) throws Exception {
            HashMap<String, Object> map = new HashMap<>();
            Matcher matcher = Pattern.compile(String.format(Locale.US, "(?:var\\s+)?%s\\s*=\\s*\\{\\s*((%s\\s*:\\s*function\\(.*?\\)\\s*\\{.*?\\}(?:,\\s*)?)*)\\}\\s*;", Pattern.quote(objname), "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')")).matcher(this.jsCode);
            String str = null;
            while (true) {
                if (!matcher.find()) {
                    break;
                }
                String strGroup = matcher.group();
                String strGroup2 = matcher.group(2);
                if (TextUtils.isEmpty(strGroup2)) {
                    str = strGroup2;
                } else {
                    if (!this.codeLines.contains(strGroup)) {
                        this.codeLines.add(matcher.group());
                    }
                    str = strGroup2;
                }
            }
            Matcher matcher2 = Pattern.compile(String.format("(%s)\\s*:\\s*function\\(([a-z,]+)\\)\\{([^}]+)\\}", "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')")).matcher(str);
            while (matcher2.find()) {
                buildFunction(matcher2.group(2).split(","), matcher2.group(3));
            }
            return map;
        }

        private void buildFunction(String[] argNames, String funcCode) throws Exception {
            HashMap<String, String> map = new HashMap<>();
            for (String str : argNames) {
                map.put(str, "");
            }
            String[] strArrSplit = funcCode.split(";");
            boolean[] zArr = new boolean[1];
            for (String str2 : strArrSplit) {
                interpretStatement(str2, map, zArr, 100);
                if (zArr[0]) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String extractFunction(String funcName) {
            try {
                String strQuote = Pattern.quote(funcName);
                Matcher matcher = Pattern.compile(String.format(Locale.US, "(?x)(?:function\\s+%s|[{;,]\\s*%s\\s*=\\s*function|var\\s+%s\\s*=\\s*function)\\s*\\(([^)]*)\\)\\s*\\{([^}]+)\\}", strQuote, strQuote, strQuote)).matcher(this.jsCode);
                if (matcher.find()) {
                    String strGroup = matcher.group();
                    if (!this.codeLines.contains(strGroup)) {
                        this.codeLines.add(strGroup + ";");
                    }
                    buildFunction(matcher.group(1).split(","), matcher.group(2));
                }
            } catch (Exception e) {
                this.codeLines.clear();
                FileLog.e(e);
            }
            return TextUtils.join("", this.codeLines);
        }
    }

    public static class JavaScriptInterface {
        private final CallJavaResultInterface callJavaResultInterface;

        public JavaScriptInterface(CallJavaResultInterface callJavaResult) {
            this.callJavaResultInterface = callJavaResult;
        }

        @JavascriptInterface
        public void returnResultToJava(String value) {
            this.callJavaResultInterface.jsCallFinished(value);
        }
    }

    protected String downloadUrlContent(AsyncTask parentTask, String url) {
        return downloadUrlContent(parentTask, url, null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String downloadUrlContent(android.os.AsyncTask r19, java.lang.String r20, java.util.HashMap<java.lang.String, java.lang.String> r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.WebPlayerView.downloadUrlContent(android.os.AsyncTask, java.lang.String, java.util.HashMap, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    class YoutubeVideoTask extends AsyncTask<Void, Void, String[]> {
        private boolean canRetry = true;
        private CountDownLatch countDownLatch = new CountDownLatch(1);
        private String[] result = new String[2];
        private String sig;
        private String videoId;

        public YoutubeVideoTask(String vid) {
            this.videoId = vid;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:128:0x02eb  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x03e8  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x045a  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String[] doInBackground(java.lang.Void... r24) throws org.json.JSONException, java.lang.InterruptedException, java.io.UnsupportedEncodingException {
            /*
                Method dump skipped, instructions count: 1134
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.WebPlayerView.YoutubeVideoTask.doInBackground(java.lang.Void[]):java.lang.String[]");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$doInBackground$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$doInBackground$1$WebPlayerView$YoutubeVideoTask(String str) {
            if (Build.VERSION.SDK_INT >= 21) {
                WebPlayerView.this.webView.evaluateJavascript(str, new ValueCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$YoutubeVideoTask$AnWTXlFr8-xPu9ncieu-JhIslpw
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.lambda$doInBackground$0$WebPlayerView$YoutubeVideoTask((String) obj);
                    }
                });
                return;
            }
            try {
                String strEncodeToString = Base64.encodeToString(("<script>" + str + "</script>").getBytes(StandardCharsets.UTF_8), 0);
                WebPlayerView.this.webView.loadUrl("data:text/html;charset=utf-8;base64," + strEncodeToString);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$doInBackground$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$doInBackground$0$WebPlayerView$YoutubeVideoTask(String str) {
            String[] strArr = this.result;
            strArr[0] = strArr[0].replace(this.sig, "/signature/" + str.substring(1, str.length() - 1));
            this.countDownLatch.countDown();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onInterfaceResult(String value) {
            String[] strArr = this.result;
            strArr[0] = strArr[0].replace(this.sig, "/signature/" + value);
            this.countDownLatch.countDown();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String[] result) {
            if (result[0] != null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("start play youtube video " + result[1] + " " + result[0]);
                }
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result[0];
                WebPlayerView.this.playVideoType = result[1];
                if (WebPlayerView.this.playVideoType.equals("hls")) {
                    WebPlayerView.this.isStream = true;
                }
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    private class VimeoVideoTask extends AsyncTask<Void, Void, String> {
        private boolean canRetry = true;
        private String[] results = new String[2];
        private String videoId;

        public VimeoVideoTask(String vid) {
            this.videoId = vid;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws JSONException {
            String strDownloadUrlContent = WebPlayerView.this.downloadUrlContent(this, String.format(Locale.US, "https://player.vimeo.com/video/%s/config", this.videoId));
            if (isCancelled()) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(strDownloadUrlContent).getJSONObject("request").getJSONObject("files");
                if (jSONObject.has("hls")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("hls");
                    try {
                        this.results[0] = jSONObject2.getString("url");
                    } catch (Exception unused) {
                        this.results[0] = jSONObject2.getJSONObject("cdns").getJSONObject(jSONObject2.getString("default_cdn")).getString("url");
                    }
                    this.results[1] = "hls";
                } else if (jSONObject.has("progressive")) {
                    this.results[1] = "other";
                    this.results[0] = jSONObject.getJSONArray("progressive").getJSONObject(0).getString("url");
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (isCancelled()) {
                return null;
            }
            return this.results[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result;
                WebPlayerView.this.playVideoType = this.results[1];
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    private class AparatVideoTask extends AsyncTask<Void, Void, String> {
        private boolean canRetry = true;
        private String[] results = new String[2];
        private String videoId;

        public AparatVideoTask(String vid) {
            this.videoId = vid;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws JSONException {
            String strDownloadUrlContent = WebPlayerView.this.downloadUrlContent(this, String.format(Locale.US, "http://www.aparat.com/video/video/embed/vt/frame/showvideo/yes/videohash/%s", this.videoId));
            if (isCancelled()) {
                return null;
            }
            try {
                Matcher matcher = WebPlayerView.aparatFileListPattern.matcher(strDownloadUrlContent);
                if (matcher.find()) {
                    JSONArray jSONArray = new JSONArray(matcher.group(1));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        if (jSONArray2.length() != 0) {
                            JSONObject jSONObject = jSONArray2.getJSONObject(0);
                            if (jSONObject.has("file")) {
                                this.results[0] = jSONObject.getString("file");
                                this.results[1] = "other";
                            }
                        }
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (isCancelled()) {
                return null;
            }
            return this.results[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result;
                WebPlayerView.this.playVideoType = this.results[1];
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    private class TwitchClipVideoTask extends AsyncTask<Void, Void, String> {
        private String currentUrl;
        private String videoId;
        private boolean canRetry = true;
        private String[] results = new String[2];

        public TwitchClipVideoTask(String url, String vid) {
            this.videoId = vid;
            this.currentUrl = url;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws JSONException {
            String strDownloadUrlContent = WebPlayerView.this.downloadUrlContent(this, this.currentUrl, null, false);
            if (isCancelled()) {
                return null;
            }
            try {
                Matcher matcher = WebPlayerView.twitchClipFilePattern.matcher(strDownloadUrlContent);
                if (matcher.find()) {
                    this.results[0] = new JSONObject(matcher.group(1)).getJSONArray("quality_options").getJSONObject(0).getString("source");
                    this.results[1] = "other";
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (isCancelled()) {
                return null;
            }
            return this.results[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result;
                WebPlayerView.this.playVideoType = this.results[1];
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    private class TwitchStreamVideoTask extends AsyncTask<Void, Void, String> {
        private String currentUrl;
        private String videoId;
        private boolean canRetry = true;
        private String[] results = new String[2];

        public TwitchStreamVideoTask(String url, String vid) {
            this.videoId = vid;
            this.currentUrl = url;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws JSONException, UnsupportedEncodingException {
            HashMap<String, String> map = new HashMap<>();
            map.put("Client-ID", "jzkbprff40iqj646a697cyrvl0zt2m6");
            int iIndexOf = this.videoId.indexOf(38);
            if (iIndexOf > 0) {
                this.videoId = this.videoId.substring(0, iIndexOf);
            }
            WebPlayerView webPlayerView = WebPlayerView.this;
            Locale locale = Locale.US;
            String strDownloadUrlContent = webPlayerView.downloadUrlContent(this, String.format(locale, "https://api.twitch.tv/kraken/streams/%s?stream_type=all", this.videoId), map, false);
            if (isCancelled()) {
                return null;
            }
            try {
                new JSONObject(strDownloadUrlContent).getJSONObject("stream");
                JSONObject jSONObject = new JSONObject(WebPlayerView.this.downloadUrlContent(this, String.format(locale, "https://api.twitch.tv/api/channels/%s/access_token", this.videoId), map, false));
                String strEncode = URLEncoder.encode(jSONObject.getString("sig"), "UTF-8");
                String strEncode2 = URLEncoder.encode(jSONObject.getString("token"), "UTF-8");
                URLEncoder.encode("https://youtube.googleapis.com/v/" + this.videoId, "UTF-8");
                String str = String.format(locale, "https://usher.ttvnw.net/api/channel/hls/%s.m3u8?%s", this.videoId, "allow_source=true&allow_audio_only=true&allow_spectre=true&player=twitchweb&segment_preference=4&p=" + ((int) (Math.random() * 1.0E7d)) + "&sig=" + strEncode + "&token=" + strEncode2);
                String[] strArr = this.results;
                strArr[0] = str;
                strArr[1] = "hls";
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (isCancelled()) {
                return null;
            }
            return this.results[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result;
                WebPlayerView.this.playVideoType = this.results[1];
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    private class CoubVideoTask extends AsyncTask<Void, Void, String> {
        private boolean canRetry = true;
        private String[] results = new String[4];
        private String videoId;

        public CoubVideoTask(String vid) {
            this.videoId = vid;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voids) throws JSONException {
            String strDownloadUrlContent = WebPlayerView.this.downloadUrlContent(this, String.format(Locale.US, "https://coub.com/api/v2/coubs/%s.json", this.videoId));
            if (isCancelled()) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(strDownloadUrlContent).getJSONObject("file_versions").getJSONObject("mobile");
                String string = jSONObject.getString(MediaStreamTrack.VIDEO_TRACK_KIND);
                String string2 = jSONObject.getJSONArray(MediaStreamTrack.AUDIO_TRACK_KIND).getString(0);
                if (string != null && string2 != null) {
                    String[] strArr = this.results;
                    strArr[0] = string;
                    strArr[1] = "other";
                    strArr[2] = string2;
                    strArr[3] = "other";
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (isCancelled()) {
                return null;
            }
            return this.results[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            if (result != null) {
                WebPlayerView.this.initied = true;
                WebPlayerView.this.playVideoUrl = result;
                WebPlayerView.this.playVideoType = this.results[1];
                WebPlayerView.this.playAudioUrl = this.results[2];
                WebPlayerView.this.playAudioType = this.results[3];
                if (WebPlayerView.this.isAutoplay) {
                    WebPlayerView.this.preparePlayer();
                }
                WebPlayerView.this.showProgress(false, true);
                WebPlayerView.this.controlsView.show(true, true);
                return;
            }
            if (isCancelled()) {
                return;
            }
            WebPlayerView.this.onInitFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ControlsView extends FrameLayout {
        private int bufferedPosition;
        private AnimatorSet currentAnimation;
        private int currentProgressX;
        private int duration;
        private StaticLayout durationLayout;
        private int durationWidth;
        private Runnable hideRunnable;
        private ImageReceiver imageReceiver;
        private boolean isVisible;
        private int lastProgressX;
        private int progress;
        private Paint progressBufferedPaint;
        private Paint progressInnerPaint;
        private StaticLayout progressLayout;
        private Paint progressPaint;
        private boolean progressPressed;
        private TextPaint textPaint;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$WebPlayerView$ControlsView() {
            show(false, true);
        }

        public ControlsView(Context context) {
            super(context);
            this.isVisible = true;
            this.hideRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$ControlsView$RtlpKwpdWBPj_7ddFB0MhwCha1o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$WebPlayerView$ControlsView();
                }
            };
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setColor(-1);
            this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
            Paint paint = new Paint(1);
            this.progressPaint = paint;
            paint.setColor(-15095832);
            Paint paint2 = new Paint();
            this.progressInnerPaint = paint2;
            paint2.setColor(-6975081);
            Paint paint3 = new Paint(1);
            this.progressBufferedPaint = paint3;
            paint3.setColor(-1);
            this.imageReceiver = new ImageReceiver(this);
        }

        public void setDuration(int value) {
            if (this.duration == value || value < 0 || WebPlayerView.this.isStream) {
                return;
            }
            this.duration = value;
            StaticLayout staticLayout = new StaticLayout(AndroidUtilities.formatShortDuration(this.duration), this.textPaint, AndroidUtilities.dp(1000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.durationLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.durationWidth = (int) Math.ceil(this.durationLayout.getLineWidth(0));
            }
            invalidate();
        }

        public void setBufferedProgress(int position) {
            this.bufferedPosition = position;
            invalidate();
        }

        public void setProgress(int value) {
            if (this.progressPressed || value < 0 || WebPlayerView.this.isStream) {
                return;
            }
            this.progress = value;
            this.progressLayout = new StaticLayout(AndroidUtilities.formatShortDuration(this.progress), this.textPaint, AndroidUtilities.dp(1000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            invalidate();
        }

        public void show(boolean value, boolean animated) {
            if (this.isVisible == value) {
                return;
            }
            this.isVisible = value;
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.isVisible) {
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.currentAnimation = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<ControlsView, Float>) View.ALPHA, 1.0f));
                    this.currentAnimation.setDuration(150L);
                    this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.WebPlayerView.ControlsView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            ControlsView.this.currentAnimation = null;
                        }
                    });
                    this.currentAnimation.start();
                } else {
                    setAlpha(1.0f);
                }
            } else if (animated) {
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.currentAnimation = animatorSet3;
                animatorSet3.playTogether(ObjectAnimator.ofFloat(this, (Property<ControlsView, Float>) View.ALPHA, 0.0f));
                this.currentAnimation.setDuration(150L);
                this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.WebPlayerView.ControlsView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ControlsView.this.currentAnimation = null;
                    }
                });
                this.currentAnimation.start();
            } else {
                setAlpha(0.0f);
            }
            checkNeedHide();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkNeedHide() {
            AndroidUtilities.cancelRunOnUIThread(this.hideRunnable);
            if (this.isVisible && WebPlayerView.this.videoPlayer.isPlaying()) {
                AndroidUtilities.runOnUIThread(this.hideRunnable, 3000L);
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (ev.getAction() == 0) {
                if (!this.isVisible) {
                    show(true, true);
                    return true;
                }
                onTouchEvent(ev);
                return this.progressPressed;
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
            checkNeedHide();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            int measuredWidth;
            int measuredHeight;
            int iDp;
            if (WebPlayerView.this.inFullscreen) {
                iDp = AndroidUtilities.dp(36.0f) + this.durationWidth;
                measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp(76.0f)) - this.durationWidth;
                measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(28.0f);
            } else {
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(12.0f);
                iDp = 0;
            }
            int i = this.duration;
            int i2 = (i != 0 ? (int) ((measuredWidth - iDp) * (this.progress / i)) : 0) + iDp;
            if (event.getAction() == 0) {
                if (this.isVisible && !WebPlayerView.this.isInline && !WebPlayerView.this.isStream) {
                    if (this.duration != 0) {
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        if (x >= i2 - AndroidUtilities.dp(10.0f) && x <= AndroidUtilities.dp(10.0f) + i2 && y >= measuredHeight - AndroidUtilities.dp(10.0f) && y <= measuredHeight + AndroidUtilities.dp(10.0f)) {
                            this.progressPressed = true;
                            this.lastProgressX = x;
                            this.currentProgressX = i2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            invalidate();
                        }
                    }
                } else {
                    show(true, true);
                }
                AndroidUtilities.cancelRunOnUIThread(this.hideRunnable);
            } else if (event.getAction() == 1 || event.getAction() == 3) {
                if (WebPlayerView.this.initied && WebPlayerView.this.videoPlayer.isPlaying()) {
                    AndroidUtilities.runOnUIThread(this.hideRunnable, 3000L);
                }
                if (this.progressPressed) {
                    this.progressPressed = false;
                    if (WebPlayerView.this.initied) {
                        this.progress = (int) (this.duration * ((this.currentProgressX - iDp) / (measuredWidth - iDp)));
                        WebPlayerView.this.videoPlayer.seekTo(this.progress * 1000);
                    }
                }
            } else if (event.getAction() == 2 && this.progressPressed) {
                int x2 = (int) event.getX();
                int i3 = this.currentProgressX - (this.lastProgressX - x2);
                this.currentProgressX = i3;
                this.lastProgressX = x2;
                if (i3 < iDp) {
                    this.currentProgressX = iDp;
                } else if (i3 > measuredWidth) {
                    this.currentProgressX = measuredWidth;
                }
                setProgress((int) (this.duration * 1000 * ((this.currentProgressX - iDp) / (measuredWidth - iDp))));
                invalidate();
            }
            super.onTouchEvent(event);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r16) {
            /*
                Method dump skipped, instructions count: 460
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.WebPlayerView.ControlsView.onDraw(android.graphics.Canvas):void");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public WebPlayerView(Context context, boolean allowInline, boolean allowShare, WebPlayerViewDelegate webPlayerViewDelegate) {
        super(context);
        int i = lastContainerId;
        lastContainerId = i + 1;
        this.fragment_container_id = i;
        this.allowInlineAnimation = Build.VERSION.SDK_INT >= 21;
        this.backgroundPaint = new Paint();
        this.progressRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.WebPlayerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WebPlayerView.this.videoPlayer == null || !WebPlayerView.this.videoPlayer.isPlaying()) {
                    return;
                }
                WebPlayerView.this.controlsView.setProgress((int) (WebPlayerView.this.videoPlayer.getCurrentPosition() / 1000));
                WebPlayerView.this.controlsView.setBufferedProgress((int) (WebPlayerView.this.videoPlayer.getBufferedPosition() / 1000));
                AndroidUtilities.runOnUIThread(WebPlayerView.this.progressRunnable, 1000L);
            }
        };
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: ir.eitaa.ui.Components.WebPlayerView.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                if (!WebPlayerView.this.changingTextureView) {
                    return true;
                }
                if (WebPlayerView.this.switchingInlineMode) {
                    WebPlayerView.this.waitingForFirstTextureUpload = 2;
                }
                WebPlayerView.this.textureView.setSurfaceTexture(surface);
                WebPlayerView.this.textureView.setVisibility(0);
                WebPlayerView.this.changingTextureView = false;
                return false;
            }

            /* renamed from: ir.eitaa.ui.Components.WebPlayerView$2$1, reason: invalid class name */
            class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
                AnonymousClass1() {
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    WebPlayerView.this.changedTextureView.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (WebPlayerView.this.textureImageView != null) {
                        WebPlayerView.this.textureImageView.setVisibility(4);
                        WebPlayerView.this.textureImageView.setImageDrawable(null);
                        if (WebPlayerView.this.currentBitmap != null) {
                            WebPlayerView.this.currentBitmap.recycle();
                            WebPlayerView.this.currentBitmap = null;
                        }
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$2$1$7j0HeYwj6KkUFrE6qQCIeekuxXg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPreDraw$0$WebPlayerView$2$1();
                        }
                    });
                    WebPlayerView.this.waitingForFirstTextureUpload = 0;
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: lambda$onPreDraw$0, reason: merged with bridge method [inline-methods] */
                public /* synthetic */ void lambda$onPreDraw$0$WebPlayerView$2$1() {
                    WebPlayerView.this.delegate.onInlineSurfaceTextureReady();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                if (WebPlayerView.this.waitingForFirstTextureUpload == 1) {
                    WebPlayerView.this.changedTextureView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1());
                    WebPlayerView.this.changedTextureView.invalidate();
                }
            }
        };
        this.switchToInlineRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.WebPlayerView.3
            @Override // java.lang.Runnable
            public void run() {
                WebPlayerView.this.switchingInlineMode = false;
                if (WebPlayerView.this.currentBitmap != null) {
                    WebPlayerView.this.currentBitmap.recycle();
                    WebPlayerView.this.currentBitmap = null;
                }
                WebPlayerView.this.changingTextureView = true;
                if (WebPlayerView.this.textureImageView != null) {
                    try {
                        WebPlayerView webPlayerView = WebPlayerView.this;
                        webPlayerView.currentBitmap = Bitmaps.createBitmap(webPlayerView.textureView.getWidth(), WebPlayerView.this.textureView.getHeight(), Bitmap.Config.ARGB_8888);
                        WebPlayerView.this.textureView.getBitmap(WebPlayerView.this.currentBitmap);
                    } catch (Throwable th) {
                        if (WebPlayerView.this.currentBitmap != null) {
                            WebPlayerView.this.currentBitmap.recycle();
                            WebPlayerView.this.currentBitmap = null;
                        }
                        FileLog.e(th);
                    }
                    if (WebPlayerView.this.currentBitmap != null) {
                        WebPlayerView.this.textureImageView.setVisibility(0);
                        WebPlayerView.this.textureImageView.setImageBitmap(WebPlayerView.this.currentBitmap);
                    } else {
                        WebPlayerView.this.textureImageView.setImageDrawable(null);
                    }
                }
                WebPlayerView.this.isInline = true;
                WebPlayerView.this.updatePlayButton();
                WebPlayerView.this.updateShareButton();
                WebPlayerView.this.updateFullscreenButton();
                WebPlayerView.this.updateInlineButton();
                ViewGroup viewGroup = (ViewGroup) WebPlayerView.this.controlsView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(WebPlayerView.this.controlsView);
                }
                WebPlayerView webPlayerView2 = WebPlayerView.this;
                webPlayerView2.changedTextureView = webPlayerView2.delegate.onSwitchInlineMode(WebPlayerView.this.controlsView, WebPlayerView.this.isInline, WebPlayerView.this.aspectRatioFrameLayout.getAspectRatio(), WebPlayerView.this.aspectRatioFrameLayout.getVideoRotation(), WebPlayerView.this.allowInlineAnimation);
                WebPlayerView.this.changedTextureView.setVisibility(4);
                ViewGroup viewGroup2 = (ViewGroup) WebPlayerView.this.textureView.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(WebPlayerView.this.textureView);
                }
                WebPlayerView.this.controlsView.show(false, false);
            }
        };
        setWillNotDraw(false);
        this.delegate = webPlayerViewDelegate;
        this.backgroundPaint.setColor(-16777216);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context) { // from class: ir.eitaa.ui.Components.WebPlayerView.4
            @Override // com.google.android.exoplayer2.ui.AspectRatioFrameLayout, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                if (WebPlayerView.this.textureViewContainer != null) {
                    ViewGroup.LayoutParams layoutParams = WebPlayerView.this.textureView.getLayoutParams();
                    layoutParams.width = getMeasuredWidth();
                    layoutParams.height = getMeasuredHeight();
                    if (WebPlayerView.this.textureImageView != null) {
                        ViewGroup.LayoutParams layoutParams2 = WebPlayerView.this.textureImageView.getLayoutParams();
                        layoutParams2.width = getMeasuredWidth();
                        layoutParams2.height = getMeasuredHeight();
                    }
                }
            }
        };
        this.aspectRatioFrameLayout = aspectRatioFrameLayout;
        addView(aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        this.interfaceName = "JavaScriptInterface";
        WebView webView = new WebView(context);
        this.webView = webView;
        webView.addJavascriptInterface(new JavaScriptInterface(new CallJavaResultInterface() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$RdNiAJPwJ5dn1PJXw5UutLH-JHw
            @Override // ir.eitaa.ui.Components.WebPlayerView.CallJavaResultInterface
            public final void jsCallFinished(String str) {
                this.f$0.lambda$new$0$WebPlayerView(str);
            }
        }), this.interfaceName);
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        this.textureViewContainer = this.delegate.getTextureViewContainer();
        TextureView textureView = new TextureView(context);
        this.textureView = textureView;
        textureView.setPivotX(0.0f);
        this.textureView.setPivotY(0.0f);
        ViewGroup viewGroup = this.textureViewContainer;
        if (viewGroup != null) {
            viewGroup.addView(this.textureView);
        } else {
            this.aspectRatioFrameLayout.addView(this.textureView, LayoutHelper.createFrame(-1, -1, 17));
        }
        if (this.allowInlineAnimation && this.textureViewContainer != null) {
            ImageView imageView = new ImageView(context);
            this.textureImageView = imageView;
            imageView.setBackgroundColor(-65536);
            this.textureImageView.setPivotX(0.0f);
            this.textureImageView.setPivotY(0.0f);
            this.textureImageView.setVisibility(4);
            this.textureViewContainer.addView(this.textureImageView);
        }
        VideoPlayer videoPlayer = new VideoPlayer();
        this.videoPlayer = videoPlayer;
        videoPlayer.setDelegate(this);
        this.videoPlayer.setTextureView(this.textureView);
        ControlsView controlsView = new ControlsView(context);
        this.controlsView = controlsView;
        ViewGroup viewGroup2 = this.textureViewContainer;
        if (viewGroup2 != null) {
            viewGroup2.addView(controlsView);
        } else {
            addView(controlsView, LayoutHelper.createFrame(-1, -1.0f));
        }
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressView = radialProgressView;
        radialProgressView.setProgressColor(-1);
        addView(this.progressView, LayoutHelper.createFrame(48, 48, 17));
        ImageView imageView2 = new ImageView(context);
        this.fullscreenButton = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.controlsView.addView(this.fullscreenButton, LayoutHelper.createFrame(56, 56.0f, 85, 0.0f, 0.0f, 0.0f, 5.0f));
        this.fullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$ZaeKtUKTTYcRlJ4w3yBFUlFjApA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$WebPlayerView(view);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.playButton = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        this.controlsView.addView(this.playButton, LayoutHelper.createFrame(48, 48, 17));
        this.playButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$NRv5Fi7bY2lt3coGSqY52y-zacg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$WebPlayerView(view);
            }
        });
        if (allowInline) {
            ImageView imageView4 = new ImageView(context);
            this.inlineButton = imageView4;
            imageView4.setScaleType(ImageView.ScaleType.CENTER);
            this.controlsView.addView(this.inlineButton, LayoutHelper.createFrame(56, 48, 53));
            this.inlineButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$WSQ7CJnnxDI7f_gDNGwXRs-kxkM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3$WebPlayerView(view);
                }
            });
        }
        if (allowShare) {
            ImageView imageView5 = new ImageView(context);
            this.shareButton = imageView5;
            imageView5.setScaleType(ImageView.ScaleType.CENTER);
            this.shareButton.setImageResource(R.drawable.ic_share_video);
            this.controlsView.addView(this.shareButton, LayoutHelper.createFrame(56, 48, 53));
            this.shareButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$HWZ5qbSMxaw0AFoq20lXTWihssg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4$WebPlayerView(view);
                }
            });
        }
        updatePlayButton();
        updateFullscreenButton();
        updateInlineButton();
        updateShareButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$WebPlayerView(String str) {
        AsyncTask asyncTask = this.currentTask;
        if (asyncTask == null || asyncTask.isCancelled()) {
            return;
        }
        AsyncTask asyncTask2 = this.currentTask;
        if (asyncTask2 instanceof YoutubeVideoTask) {
            ((YoutubeVideoTask) asyncTask2).onInterfaceResult(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$WebPlayerView(View view) {
        if (!this.initied || this.changingTextureView || this.switchingInlineMode || !this.firstFrameRendered) {
            return;
        }
        this.inFullscreen = !this.inFullscreen;
        updateFullscreenState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$WebPlayerView(View view) {
        if (!this.initied || this.playVideoUrl == null) {
            return;
        }
        if (!this.videoPlayer.isPlayerPrepared()) {
            preparePlayer();
        }
        if (this.videoPlayer.isPlaying()) {
            this.videoPlayer.pause();
        } else {
            this.isCompleted = false;
            this.videoPlayer.play();
        }
        updatePlayButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$WebPlayerView(View view) {
        if (this.textureView == null || !this.delegate.checkInlinePermissions() || this.changingTextureView || this.switchingInlineMode || !this.firstFrameRendered) {
            return;
        }
        this.switchingInlineMode = true;
        if (!this.isInline) {
            this.inFullscreen = false;
            this.delegate.prepareToSwitchInlineMode(true, this.switchToInlineRunnable, this.aspectRatioFrameLayout.getAspectRatio(), this.allowInlineAnimation);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.aspectRatioFrameLayout.getParent();
        if (viewGroup != this) {
            if (viewGroup != null) {
                viewGroup.removeView(this.aspectRatioFrameLayout);
            }
            addView(this.aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
            this.aspectRatioFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - AndroidUtilities.dp(10.0f), 1073741824));
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.currentBitmap = null;
        }
        this.changingTextureView = true;
        this.isInline = false;
        updatePlayButton();
        updateShareButton();
        updateFullscreenButton();
        updateInlineButton();
        this.textureView.setVisibility(4);
        ViewGroup viewGroup2 = this.textureViewContainer;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.textureView);
        } else {
            this.aspectRatioFrameLayout.addView(this.textureView);
        }
        ViewGroup viewGroup3 = (ViewGroup) this.controlsView.getParent();
        if (viewGroup3 != this) {
            if (viewGroup3 != null) {
                viewGroup3.removeView(this.controlsView);
            }
            ViewGroup viewGroup4 = this.textureViewContainer;
            if (viewGroup4 != null) {
                viewGroup4.addView(this.controlsView);
            } else {
                addView(this.controlsView, 1);
            }
        }
        this.controlsView.show(false, false);
        this.delegate.prepareToSwitchInlineMode(false, null, this.aspectRatioFrameLayout.getAspectRatio(), this.allowInlineAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$WebPlayerView(View view) {
        WebPlayerViewDelegate webPlayerViewDelegate = this.delegate;
        if (webPlayerViewDelegate != null) {
            webPlayerViewDelegate.onSharePressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitFailed() {
        if (this.controlsView.getParent() != this) {
            this.controlsView.setVisibility(8);
        }
        this.delegate.onInitFailed();
    }

    public void updateTextureImageView() {
        if (this.textureImageView == null) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(this.textureView.getWidth(), this.textureView.getHeight(), Bitmap.Config.ARGB_8888);
            this.currentBitmap = bitmapCreateBitmap;
            this.changedTextureView.getBitmap(bitmapCreateBitmap);
        } catch (Throwable th) {
            Bitmap bitmap = this.currentBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.currentBitmap = null;
            }
            FileLog.e(th);
        }
        if (this.currentBitmap != null) {
            this.textureImageView.setVisibility(0);
            this.textureImageView.setImageBitmap(this.currentBitmap);
        } else {
            this.textureImageView.setImageDrawable(null);
        }
    }

    public String getYoutubeId() {
        return this.currentYoutubeId;
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onStateChanged(boolean playWhenReady, int playbackState) {
        if (playbackState != 2) {
            if (this.videoPlayer.getDuration() != -9223372036854775807L) {
                this.controlsView.setDuration((int) (this.videoPlayer.getDuration() / 1000));
            } else {
                this.controlsView.setDuration(0);
            }
        }
        if (playbackState != 4 && playbackState != 1 && this.videoPlayer.isPlaying()) {
            this.delegate.onPlayStateChanged(this, true);
        } else {
            this.delegate.onPlayStateChanged(this, false);
        }
        if (this.videoPlayer.isPlaying() && playbackState != 4) {
            updatePlayButton();
            return;
        }
        if (playbackState == 4) {
            this.isCompleted = true;
            this.videoPlayer.pause();
            this.videoPlayer.seekTo(0L);
            updatePlayButton();
            this.controlsView.show(true, true);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(10.0f), this.backgroundPaint);
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onError(VideoPlayer player, Exception e) {
        FileLog.e(e);
        onInitFailed();
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            if (unappliedRotationDegrees != 90 && unappliedRotationDegrees != 270) {
                height = width;
                width = height;
            }
            float f = width == 0 ? 1.0f : (height * pixelWidthHeightRatio) / width;
            aspectRatioFrameLayout.setAspectRatio(f, unappliedRotationDegrees);
            if (this.inFullscreen) {
                this.delegate.onVideoSizeChanged(f, unappliedRotationDegrees);
            }
        }
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onRenderedFirstFrame() {
        this.firstFrameRendered = true;
        this.lastUpdateTime = System.currentTimeMillis();
        this.controlsView.invalidate();
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
        if (this.changingTextureView) {
            this.changingTextureView = false;
            if (this.inFullscreen || this.isInline) {
                if (this.isInline) {
                    this.waitingForFirstTextureUpload = 1;
                }
                this.changedTextureView.setSurfaceTexture(surfaceTexture);
                this.changedTextureView.setSurfaceTextureListener(this.surfaceTextureListener);
                this.changedTextureView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.waitingForFirstTextureUpload == 2) {
            ImageView imageView = this.textureImageView;
            if (imageView != null) {
                imageView.setVisibility(4);
                this.textureImageView.setImageDrawable(null);
                Bitmap bitmap = this.currentBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.currentBitmap = null;
                }
            }
            this.switchingInlineMode = false;
            this.delegate.onSwitchInlineMode(this.controlsView, false, this.aspectRatioFrameLayout.getAspectRatio(), this.aspectRatioFrameLayout.getVideoRotation(), this.allowInlineAnimation);
            this.waitingForFirstTextureUpload = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = r - l;
        int measuredWidth = (i - this.aspectRatioFrameLayout.getMeasuredWidth()) / 2;
        int i2 = b - t;
        int iDp = ((i2 - AndroidUtilities.dp(10.0f)) - this.aspectRatioFrameLayout.getMeasuredHeight()) / 2;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        aspectRatioFrameLayout.layout(measuredWidth, iDp, aspectRatioFrameLayout.getMeasuredWidth() + measuredWidth, this.aspectRatioFrameLayout.getMeasuredHeight() + iDp);
        if (this.controlsView.getParent() == this) {
            ControlsView controlsView = this.controlsView;
            controlsView.layout(0, 0, controlsView.getMeasuredWidth(), this.controlsView.getMeasuredHeight());
        }
        int measuredWidth2 = (i - this.progressView.getMeasuredWidth()) / 2;
        int measuredHeight = (i2 - this.progressView.getMeasuredHeight()) / 2;
        RadialProgressView radialProgressView = this.progressView;
        radialProgressView.layout(measuredWidth2, measuredHeight, radialProgressView.getMeasuredWidth() + measuredWidth2, this.progressView.getMeasuredHeight() + measuredHeight);
        this.controlsView.imageReceiver.setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(10.0f));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        this.aspectRatioFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - AndroidUtilities.dp(10.0f), 1073741824));
        if (this.controlsView.getParent() == this) {
            this.controlsView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        this.progressView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(44.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(44.0f), 1073741824));
        setMeasuredDimension(size, size2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayButton() {
        this.controlsView.checkNeedHide();
        AndroidUtilities.cancelRunOnUIThread(this.progressRunnable);
        if (!this.videoPlayer.isPlaying()) {
            if (this.isCompleted) {
                this.playButton.setImageResource(this.isInline ? R.drawable.ic_againinline : R.drawable.ic_again);
                return;
            } else {
                this.playButton.setImageResource(this.isInline ? R.drawable.ic_playinline : R.drawable.ic_play);
                return;
            }
        }
        this.playButton.setImageResource(this.isInline ? R.drawable.ic_pauseinline : R.drawable.ic_pause);
        AndroidUtilities.runOnUIThread(this.progressRunnable, 500L);
        checkAudioFocus();
    }

    private void checkAudioFocus() {
        if (this.hasAudioFocus) {
            return;
        }
        AudioManager audioManager = (AudioManager) ApplicationLoader.applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.hasAudioFocus = true;
        if (audioManager.requestAudioFocus(this, 3, 1) == 1) {
            this.audioFocus = 2;
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int focusChange) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$WebPlayerView$ikvca26bJ8B2iFXG1Hr3yebZEuY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioFocusChange$5$WebPlayerView(focusChange);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAudioFocusChange$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onAudioFocusChange$5$WebPlayerView(int i) {
        if (i == -1) {
            if (this.videoPlayer.isPlaying()) {
                this.videoPlayer.pause();
                updatePlayButton();
            }
            this.hasAudioFocus = false;
            this.audioFocus = 0;
            return;
        }
        if (i == 1) {
            this.audioFocus = 2;
            if (this.resumeAudioOnFocusGain) {
                this.resumeAudioOnFocusGain = false;
                this.videoPlayer.play();
                return;
            }
            return;
        }
        if (i == -3) {
            this.audioFocus = 1;
            return;
        }
        if (i == -2) {
            this.audioFocus = 0;
            if (this.videoPlayer.isPlaying()) {
                this.resumeAudioOnFocusGain = true;
                this.videoPlayer.pause();
                updatePlayButton();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFullscreenButton() {
        if (!this.videoPlayer.isPlayerPrepared() || this.isInline) {
            this.fullscreenButton.setVisibility(8);
            return;
        }
        this.fullscreenButton.setVisibility(0);
        if (!this.inFullscreen) {
            this.fullscreenButton.setImageResource(R.drawable.ic_gofullscreen);
            this.fullscreenButton.setLayoutParams(LayoutHelper.createFrame(56, 56.0f, 85, 0.0f, 0.0f, 0.0f, 5.0f));
        } else {
            this.fullscreenButton.setImageResource(R.drawable.ic_outfullscreen);
            this.fullscreenButton.setLayoutParams(LayoutHelper.createFrame(56, 56.0f, 85, 0.0f, 0.0f, 0.0f, 1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShareButton() {
        ImageView imageView = this.shareButton;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility((this.isInline || !this.videoPlayer.isPlayerPrepared()) ? 8 : 0);
    }

    private View getControlView() {
        return this.controlsView;
    }

    private View getProgressView() {
        return this.progressView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInlineButton() {
        ImageView imageView = this.inlineButton;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(this.isInline ? R.drawable.ic_goinline : R.drawable.ic_outinline);
        this.inlineButton.setVisibility(this.videoPlayer.isPlayerPrepared() ? 0 : 8);
        if (this.isInline) {
            this.inlineButton.setLayoutParams(LayoutHelper.createFrame(40, 40, 53));
        } else {
            this.inlineButton.setLayoutParams(LayoutHelper.createFrame(56, 50, 53));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlayer() {
        String str = this.playVideoUrl;
        if (str == null) {
            return;
        }
        if (str != null && this.playAudioUrl != null) {
            this.videoPlayer.preparePlayerLoop(Uri.parse(str), this.playVideoType, Uri.parse(this.playAudioUrl), this.playAudioType);
        } else {
            this.videoPlayer.preparePlayer(Uri.parse(str), this.playVideoType);
        }
        this.videoPlayer.setPlayWhenReady(this.isAutoplay);
        this.isLoading = false;
        if (this.videoPlayer.getDuration() != -9223372036854775807L) {
            this.controlsView.setDuration((int) (this.videoPlayer.getDuration() / 1000));
        } else {
            this.controlsView.setDuration(0);
        }
        updateFullscreenButton();
        updateShareButton();
        updateInlineButton();
        this.controlsView.invalidate();
        if (this.seekToTime != -1) {
            this.videoPlayer.seekTo(r0 * 1000);
        }
    }

    public void pause() {
        this.videoPlayer.pause();
        updatePlayButton();
        this.controlsView.show(true, true);
    }

    private void updateFullscreenState(boolean byButton) {
        ViewGroup viewGroup;
        if (this.textureView == null) {
            return;
        }
        updateFullscreenButton();
        ViewGroup viewGroup2 = this.textureViewContainer;
        if (viewGroup2 == null) {
            this.changingTextureView = true;
            if (!this.inFullscreen) {
                if (viewGroup2 != null) {
                    viewGroup2.addView(this.textureView);
                } else {
                    this.aspectRatioFrameLayout.addView(this.textureView);
                }
            }
            if (this.inFullscreen) {
                ViewGroup viewGroup3 = (ViewGroup) this.controlsView.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.controlsView);
                }
            } else {
                ViewGroup viewGroup4 = (ViewGroup) this.controlsView.getParent();
                if (viewGroup4 != this) {
                    if (viewGroup4 != null) {
                        viewGroup4.removeView(this.controlsView);
                    }
                    ViewGroup viewGroup5 = this.textureViewContainer;
                    if (viewGroup5 != null) {
                        viewGroup5.addView(this.controlsView);
                    } else {
                        addView(this.controlsView, 1);
                    }
                }
            }
            TextureView textureViewOnSwitchToFullscreen = this.delegate.onSwitchToFullscreen(this.controlsView, this.inFullscreen, this.aspectRatioFrameLayout.getAspectRatio(), this.aspectRatioFrameLayout.getVideoRotation(), byButton);
            this.changedTextureView = textureViewOnSwitchToFullscreen;
            textureViewOnSwitchToFullscreen.setVisibility(4);
            if (this.inFullscreen && this.changedTextureView != null && (viewGroup = (ViewGroup) this.textureView.getParent()) != null) {
                viewGroup.removeView(this.textureView);
            }
            this.controlsView.checkNeedHide();
            return;
        }
        if (this.inFullscreen) {
            ViewGroup viewGroup6 = (ViewGroup) this.aspectRatioFrameLayout.getParent();
            if (viewGroup6 != null) {
                viewGroup6.removeView(this.aspectRatioFrameLayout);
            }
        } else {
            ViewGroup viewGroup7 = (ViewGroup) this.aspectRatioFrameLayout.getParent();
            if (viewGroup7 != this) {
                if (viewGroup7 != null) {
                    viewGroup7.removeView(this.aspectRatioFrameLayout);
                }
                addView(this.aspectRatioFrameLayout, 0);
            }
        }
        this.delegate.onSwitchToFullscreen(this.controlsView, this.inFullscreen, this.aspectRatioFrameLayout.getAspectRatio(), this.aspectRatioFrameLayout.getVideoRotation(), byButton);
    }

    public void exitFullscreen() {
        if (this.inFullscreen) {
            this.inFullscreen = false;
            updateInlineButton();
            updateFullscreenState(false);
        }
    }

    public boolean isInitied() {
        return this.initied;
    }

    public boolean isInline() {
        return this.isInline || this.switchingInlineMode;
    }

    public void enterFullscreen() {
        if (this.inFullscreen) {
            return;
        }
        this.inFullscreen = true;
        updateInlineButton();
        updateFullscreenState(false);
    }

    public boolean isInFullscreen() {
        return this.inFullscreen;
    }

    public static String getYouTubeVideoId(String url) {
        Matcher matcher = youtubeIdRegex.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public boolean canHandleUrl(String url) {
        if (url == null) {
            return false;
        }
        if (url.endsWith(".mp4")) {
            return true;
        }
        try {
            Matcher matcher = youtubeIdRegex.matcher(url);
            if ((matcher.find() ? matcher.group(1) : null) != null) {
                return true;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            Matcher matcher2 = vimeoIdRegex.matcher(url);
            if ((matcher2.find() ? matcher2.group(3) : null) != null) {
                return true;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            Matcher matcher3 = aparatIdRegex.matcher(url);
            if ((matcher3.find() ? matcher3.group(1) : null) != null) {
                return true;
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        try {
            Matcher matcher4 = twitchClipIdRegex.matcher(url);
            if ((matcher4.find() ? matcher4.group(1) : null) != null) {
                return true;
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
        try {
            Matcher matcher5 = twitchStreamIdRegex.matcher(url);
            if ((matcher5.find() ? matcher5.group(1) : null) != null) {
                return true;
            }
        } catch (Exception e5) {
            FileLog.e(e5);
        }
        try {
            Matcher matcher6 = coubIdRegex.matcher(url);
            return (matcher6.find() ? matcher6.group(1) : null) != null;
        } catch (Exception e6) {
            FileLog.e(e6);
            return false;
        }
    }

    public void willHandle() {
        this.controlsView.setVisibility(4);
        this.controlsView.show(false, false);
        showProgress(true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean loadVideo(java.lang.String r26, ir.eitaa.tgnet.TLRPC$Photo r27, java.lang.Object r28, java.lang.String r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.WebPlayerView.loadVideo(java.lang.String, ir.eitaa.tgnet.TLRPC$Photo, java.lang.Object, java.lang.String, boolean):boolean");
    }

    public String getCoubId(String url) {
        String strGroup;
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        try {
            Matcher matcher = coubIdRegex.matcher(url);
            strGroup = matcher.find() ? matcher.group(1) : null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (strGroup != null) {
            return strGroup;
        }
        return null;
    }

    public View getAspectRatioView() {
        return this.aspectRatioFrameLayout;
    }

    public TextureView getTextureView() {
        return this.textureView;
    }

    public ImageView getTextureImageView() {
        return this.textureImageView;
    }

    public View getControlsView() {
        return this.controlsView;
    }

    public void destroy() {
        this.videoPlayer.releasePlayer(false);
        AsyncTask asyncTask = this.currentTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.currentTask = null;
        }
        this.webView.stopLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress(boolean show, boolean animated) {
        if (animated) {
            AnimatorSet animatorSet = this.progressAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.progressAnimation = animatorSet2;
            Animator[] animatorArr = new Animator[1];
            RadialProgressView radialProgressView = this.progressView;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(radialProgressView, "alpha", fArr);
            animatorSet2.playTogether(animatorArr);
            this.progressAnimation.setDuration(150L);
            this.progressAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.WebPlayerView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    WebPlayerView.this.progressAnimation = null;
                }
            });
            this.progressAnimation.start();
            return;
        }
        this.progressView.setAlpha(show ? 1.0f : 0.0f);
    }
}
