package ir.nasim.core.modules.settings;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Build;
import com.google.gson.reflect.TypeToken;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19562qZ6;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21707u0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC7464Rv1;
import ir.nasim.C10853cJ3;
import ir.nasim.C11458d25;
import ir.nasim.C12275eL0;
import ir.nasim.C12736f7;
import ir.nasim.C14582i90;
import ir.nasim.C16022ka3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20644sM5;
import ir.nasim.C22034uZ1;
import ir.nasim.C22078ud6;
import ir.nasim.C22279uy0;
import ir.nasim.C24411ya3;
import ir.nasim.C25226zw5;
import ir.nasim.C5721Ko;
import ir.nasim.C5942Lm4;
import ir.nasim.C7808Th0;
import ir.nasim.C8386Vt0;
import ir.nasim.C9057Yh4;
import ir.nasim.C9528a7;
import ir.nasim.ED1;
import ir.nasim.EY6;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.HS1;
import ir.nasim.I22;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC4314Ep2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9824ad1;
import ir.nasim.JF5;
import ir.nasim.K26;
import ir.nasim.K6;
import ir.nasim.KS2;
import ir.nasim.Q12;
import ir.nasim.SA2;
import ir.nasim.T12;
import ir.nasim.V6;
import ir.nasim.W12;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.Y50;
import ir.nasim.Z50;
import ir.nasim.ZI2;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.a;
import ir.nasim.core.modules.settings.entity.CallRemoteConfig;
import ir.nasim.core.modules.settings.entity.ChangeLogData;
import ir.nasim.features.pfm.entity.AnalysisData;
import ir.nasim.features.pfm.entity.AnalysisDialogData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import okhttp3.HttpUrl;

/* loaded from: classes5.dex */
public final class SettingsModule extends AbstractC21707u0 implements InterfaceC9824ad1 {
    private final C16022ka3 A;
    private final C7808Th0 A0;
    private final EY6 A1;
    private final EY6 A2;
    private final C16022ka3 A3;
    private final EY6 A4;
    private final C10853cJ3 B;
    private final C7808Th0 B0;
    private final EY6 B1;
    private final EY6 B2;
    private final C16022ka3 B3;
    private final EY6 B4;
    private final C10853cJ3 C;
    private final EY6 C0;
    private final EY6 C1;
    private final EY6 C2;
    private final C16022ka3 C3;
    private final EY6 C4;
    private final C16022ka3 D;
    private final EY6 D0;
    private final EY6 D1;
    private final EY6 D2;
    private final C10853cJ3 D3;
    private final EY6 D4;
    private final C10853cJ3 E;
    private final C16022ka3 E0;
    private final C16022ka3 E1;
    private final EY6 E2;
    private final C10853cJ3 E3;
    private final EY6 E4;
    private final EY6 F;
    private final C16022ka3 F0;
    private final C16022ka3 F1;
    private final EY6 F2;
    private final C7808Th0 F3;
    private final C10853cJ3 F4;
    private final EY6 G;
    private final C10853cJ3 G0;
    private final C16022ka3 G1;
    private final EY6 G2;
    private final C7808Th0 G3;
    private final C10853cJ3 G4;
    private final EY6 H;
    private final C16022ka3 H0;
    private final EY6 H1;
    private final EY6 H2;
    private final C7808Th0 H3;
    private final EY6 H4;
    private final C7808Th0 I;
    private final C16022ka3 I0;
    private final C7808Th0 I1;
    private final EY6 I2;
    private final C7808Th0 I3;
    private final EY6 I4;
    private final C7808Th0 J;
    private final C16022ka3 J0;
    private final C16022ka3 J1;
    private final EY6 J2;
    private final C16022ka3 J3;
    private final EY6 J4;
    private final C7808Th0 K;
    private final C16022ka3 K0;
    private final C10853cJ3 K1;
    private final EY6 K2;
    private final C10853cJ3 K3;
    private final EY6 K4;
    private final C7808Th0 L;
    private final C16022ka3 L0;
    private final C16022ka3 L1;
    private final EY6 L2;
    private final C16022ka3 L3;
    private final EY6 L4;
    private final C7808Th0 M;
    private final C16022ka3 M0;
    private final EY6 M1;
    private final C16022ka3 M2;
    private final C10853cJ3 M3;
    private final C10853cJ3 M4;
    private final C7808Th0 N;
    private final EY6 N0;
    private final C16022ka3 N1;
    private final C16022ka3 N2;
    private final C10853cJ3 N3;
    private final C10853cJ3 N4;
    private final C7808Th0 O;
    private final EY6 O0;
    private final C16022ka3 O1;
    private final C16022ka3 O2;
    private final C10853cJ3 O3;
    private final EY6 O4;
    private final C7808Th0 P;
    private final C10853cJ3 P0;
    private final EY6 P1;
    private final EY6 P2;
    private final C10853cJ3 P3;
    private final C7808Th0 P4;
    private final C7808Th0 Q;
    private final C16022ka3 Q0;
    private final EY6 Q1;
    private final C16022ka3 Q2;
    private final C16022ka3 Q3;
    private final EY6 Q4;
    private final C7808Th0 R;
    private final C16022ka3 R0;
    private final EY6 R1;
    private final C16022ka3 R2;
    private final EY6 R3;
    private final EY6 R4;
    private final C7808Th0 S;
    private final EY6 S0;
    private final EY6 S1;
    private final EY6 S2;
    private final EY6 S3;
    private final C16022ka3 S4;
    private final C7808Th0 T;
    private final C16022ka3 T0;
    private final EY6 T1;
    private final EY6 T2;
    private final C16022ka3 T3;
    private final EY6 T4;
    private final C7808Th0 U;
    private final C16022ka3 U0;
    private final EY6 U1;
    private final EY6 U2;
    private final EY6 U3;
    private final C7808Th0 V;
    private final C7808Th0 V0;
    private final EY6 V1;
    private final EY6 V2;
    private final C10853cJ3 V3;
    private final C7808Th0 W;
    private final EY6 W0;
    private final C16022ka3 W1;
    private final EY6 W2;
    private final EY6 W3;
    private final C7808Th0 X;
    private final C16022ka3 X0;
    private final C16022ka3 X1;
    private final C16022ka3 X2;
    private final EY6 X3;
    private final C16022ka3 Y;
    private final EY6 Y0;
    private final C16022ka3 Y1;
    private final EY6 Y2;
    private final EY6 Y3;
    private final C16022ka3 Z;
    private final EY6 Z0;
    private final EY6 Z1;
    private final C16022ka3 Z2;
    private final C16022ka3 Z3;
    private final C16022ka3 a0;
    private final EY6 a1;
    private final EY6 a2;
    private final C16022ka3 a3;
    private final C10853cJ3 a4;
    private final C9057Yh4 b;
    private final C16022ka3 b0;
    private final EY6 b1;
    private final C7808Th0 b2;
    private final C16022ka3 b3;
    private final C7808Th0 b4;
    private final InterfaceC3570Bk5 c;
    private final C7808Th0 c0;
    private final C16022ka3 c1;
    private final C7808Th0 c2;
    private final C16022ka3 c3;
    private final C10853cJ3 c4;
    private C9528a7 d;
    private final C7808Th0 d0;
    private final C7808Th0 d1;
    private final C16022ka3 d2;
    private final C10853cJ3 d3;
    private final C16022ka3 d4;
    private String e;
    private final C7808Th0 e0;
    private final EY6 e1;
    private final C7808Th0 e2;
    private final EY6 e3;
    private final EY6 e4;
    private String f;
    private final C7808Th0 f0;
    private final EY6 f1;
    private final C7808Th0 f2;
    private final C16022ka3 f3;
    private final EY6 f4;
    private final InterfaceC9173Yu3 g;
    private final C7808Th0 g0;
    private volatile int g1;
    private final C16022ka3 g2;
    private final C16022ka3 g3;
    private final EY6 g4;
    private final C10853cJ3 h;
    private final C7808Th0 h0;
    private final List h1;
    private final EY6 h2;
    private final EY6 h3;
    private final EY6 h4;
    private final C16022ka3 i;
    private final EY6 i0;
    private final C7808Th0 i1;
    private final EY6 i2;
    private final C7808Th0 i3;
    private final EY6 i4;
    private final C16022ka3 j;
    private final EY6 j0;
    private final EY6 j1;
    private final EY6 j2;
    private final C7808Th0 j3;
    private final EY6 j4;
    private final C16022ka3 k;
    private final C7808Th0 k0;
    private final EY6 k1;
    private final C16022ka3 k2;
    private final C7808Th0 k3;
    private final EY6 k4;
    private final C16022ka3 l;
    private final EY6 l0;
    private final EY6 l1;
    private final C7808Th0 l2;
    private final C7808Th0 l3;
    private final EY6 l4;
    private final C16022ka3 m;
    private final EY6 m0;
    private final EY6 m1;
    private final C7808Th0 m2;
    private final EY6 m3;
    private final C16022ka3 m4;
    private final C16022ka3 n;
    private final EY6 n0;
    private final EY6 n1;
    private final C7808Th0 n2;
    private final EY6 n3;
    private final C10853cJ3 n4;
    private final C16022ka3 o;
    private final C7808Th0 o0;
    private final EY6 o1;
    private final C16022ka3 o2;
    private final C7808Th0 o3;
    private final EY6 o4;
    private final C16022ka3 p;
    private final C7808Th0 p0;
    private final C7808Th0 p1;
    private final C10853cJ3 p2;
    private final C16022ka3 p3;
    private final EY6 p4;
    private final C10853cJ3 q;
    private final C7808Th0 q0;
    private final C16022ka3 q1;
    private final C10853cJ3 q2;
    private final C16022ka3 q3;
    private final EY6 q4;
    private final EY6 r;
    private final C7808Th0 r0;
    private final C16022ka3 r1;
    private final C7808Th0 r2;
    private final C16022ka3 r3;
    private final C10853cJ3 r4;
    private final EY6 s;
    private final C7808Th0 s0;
    private final C16022ka3 s1;
    private final C16022ka3 s2;
    private final EY6 s3;
    private final C16022ka3 s4;
    private final C7808Th0 t;
    private final C7808Th0 t0;
    private final C10853cJ3 t1;
    private final C10853cJ3 t2;
    private final C16022ka3 t3;
    private final EY6 t4;
    private final C16022ka3 u;
    private final C7808Th0 u0;
    private final C16022ka3 u1;
    private final C10853cJ3 u2;
    private final EY6 u3;
    private final EY6 u4;
    private final C16022ka3 v;
    private final C7808Th0 v0;
    private final C16022ka3 v1;
    private final C16022ka3 v2;
    private final C7808Th0 v3;
    private final EY6 v4;
    private final C16022ka3 w;
    private final C7808Th0 w0;
    private final C16022ka3 w1;
    private final EY6 w2;
    private final EY6 w3;
    private final EY6 w4;
    private final C10853cJ3 x;
    private final C7808Th0 x0;
    private final EY6 x1;
    private final EY6 x2;
    private final EY6 x3;
    private final EY6 x4;
    private final C16022ka3 y;
    private final C7808Th0 y0;
    private final EY6 y1;
    private final EY6 y2;
    private final C16022ka3 y3;
    private final EY6 y4;
    private final EY6 z;
    private final C7808Th0 z0;
    private final EY6 z1;
    private final EY6 z2;
    private final C16022ka3 z3;
    private final EY6 z4;
    static final /* synthetic */ InterfaceC5239Im3[] V4 = {AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "feedRefreshInterval", "getFeedRefreshInterval()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "lowStorageLimitationInMB", "getLowStorageLimitationInMB()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "pinLimitDefaultTabs", "getPinLimitDefaultTabs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "pinLimitAllTab", "getPinLimitAllTab()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "folderLimit", "getFolderLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "exoPlayerMinBufferInMs", "getExoPlayerMinBufferInMs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "exoPlayerMaxBufferInMs", "getExoPlayerMaxBufferInMs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "exoPlayerPlaybackBufferInMs", "getExoPlayerPlaybackBufferInMs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "exoPlayerPlaybackRebufferInMs", "getExoPlayerPlaybackRebufferInMs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "exoPlayerPreloadCacheSize", "getExoPlayerPreloadCacheSize()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "compressionConfig", "getCompressionConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "storyCompressionConfig", "getStoryCompressionConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isPinMigrationDone", "isPinMigrationDone()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "uploadChunkSize", "getUploadChunkSize()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "uploadConcurrentChunks", "getUploadConcurrentChunks()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "uploadConcurrentFiles", "getUploadConcurrentFiles()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "uploadBackoffDurationInMillis", "getUploadBackoffDurationInMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "uploadFileSizeForDirectUpload", "getUploadFileSizeForDirectUpload()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "listOfSafeUniqueIdsToDownloadApkFrom", "getListOfSafeUniqueIdsToDownloadApkFrom()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "countShownSwipeTutorials", "getCountShownSwipeTutorials()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "lastShownSwipeTutorialTime", "getLastShownSwipeTutorialTime()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "lastTimeSimilarPostSwipe", "getLastTimeSimilarPostSwipe()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "count3TimeTutorialShown", "getCount3TimeTutorialShown()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "lastShownFakeDragAnimation", "getLastShownFakeDragAnimation()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "jaryanSearchTooltipConfig", "getJaryanSearchTooltipConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketSearchPopularItems", "getMarketSearchPopularItems()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "jaryanSearchPopularItems", "getJaryanSearchPopularItems()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isShowNotificationsText", "isShowNotificationsText()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isScreenLightEnabled", "isScreenLightEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isLEDLightEnabled", "isLEDLightEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isPrivateNotificationsEnabled", "isPrivateNotificationsEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isGroupNotificationsEnabled", "isGroupNotificationsEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "confirmJoinOnBoardingChannels", "getConfirmJoinOnBoardingChannels()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadWifiPhotoEnabled", "isAutoDownloadWifiPhotoEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadWifiVideoEnabled", "isAutoDownloadWifiVideoEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadWifiVoiceEnabled", "isAutoDownloadWifiVoiceEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadWifiFileEnabled", "isAutoDownloadWifiFileEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadWifiGifEnabled", "isAutoDownloadWifiGifEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadDataPhotoEnabled", "isAutoDownloadDataPhotoEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadDataVideoEnabled", "isAutoDownloadDataVideoEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadDataVoiceEnabled", "isAutoDownloadDataVoiceEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadDataFileEnabled", "isAutoDownloadDataFileEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAutoDownloadDataGifEnabled", "isAutoDownloadDataGifEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "autoDownloadMinLimitInMB", "getAutoDownloadMinLimitInMB()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "autoDownloadCurrentLimitInMB", "getAutoDownloadCurrentLimitInMB()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "autoDownloadMaxLimitInMB", "getAutoDownloadMaxLimitInMB()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "maxVideoSizeForPreviewing", "getMaxVideoSizeForPreviewing()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "isDialogAllTabVisible", "isDialogAllTabVisible()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isDialogChannelTabVisible", "isDialogChannelTabVisible()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isDialogGroupTabVisible", "isDialogGroupTabVisible()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isDialogPrivateTabVisible", "isDialogPrivateTabVisible()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isDialogBotTabVisible", "isDialogBotTabVisible()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isSendByEnterEnabled", "isSendByEnterEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webAppTermsOfUseUrl", "getWebAppTermsOfUseUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "verifiedWebAppsToHavePermission", "getVerifiedWebAppsToHavePermission()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "hasInteractedWithBotBefore", "getHasInteractedWithBotBefore()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "callPrivacy", "getCallPrivacy()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "lastSeenPrivacy", "getLastSeenPrivacy()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "inviteToGroupPrivacy", "getInviteToGroupPrivacy()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "showMenuWithBadge", "getShowMenuWithBadge()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "showMoreWithBadge", "getShowMoreWithBadge()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "showFoldersWithBadge", "getShowFoldersWithBadge()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "showUnreadFolderBadge", "getShowUnreadFolderBadge()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "showSettingWithBadge", "getShowSettingWithBadge()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isStorySuggestionsEnabled", "isStorySuggestionsEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelOwnerStoryBalloonShown", "getChannelOwnerStoryBalloonShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "groupOwnerStoryBalloonShown", "getGroupOwnerStoryBalloonShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelPageStoryBalloonShown", "getChannelPageStoryBalloonShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "groupPageStoryBalloonShown", "getGroupPageStoryBalloonShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "storyBackgroundTooltipShownInUpload", "getStoryBackgroundTooltipShownInUpload()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "hafezFaalTooltipShown", "getHafezFaalTooltipShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "storyTagTooltipShown", "getStoryTagTooltipShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "storyYaldaTagTooltipShown", "getStoryYaldaTagTooltipShown()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "storyGlobalUserIds", "getStoryGlobalUserIds()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "storyBackGroundSuggestions", "getStoryBackGroundSuggestions()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "displayTime", "getDisplayTime()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "videoStoryMaximumDuration", "getVideoStoryMaximumDuration()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "getRelatedChannelsTimeOut", "getGetRelatedChannelsTimeOut()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "sendChannelStoryMinimumMembersCount", "getSendChannelStoryMinimumMembersCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "sendGroupStoryMinimumMembersCount", "getSendGroupStoryMinimumMembersCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "storyAdderFragmentOpeningState", "getStoryAdderFragmentOpeningState()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "addStoryState", "getAddStoryState()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "storyPrefetchSize", "getStoryPrefetchSize()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "textStoryMaxLength", "getTextStoryMaxLength()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "textStoryHint", "getTextStoryHint()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "textStoryHintEnglish", "getTextStoryHintEnglish()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "globalSearchMaxResultsCount", "getGlobalSearchMaxResultsCount()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "storyReactionOnboardingCount", "getStoryReactionOnboardingCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "storyPreDownloadLimit", "getStoryPreDownloadLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "suggestionChannelsTitle", "getSuggestionChannelsTitle()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "myBankVersionForBadge", "getMyBankVersionForBadge()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "navigationPercentage", "getNavigationPercentage()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAuthenticatorEnabled", "isAuthenticatorEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "cardToCardPolicy", "getCardToCardPolicy()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "messageMaxLength", "getMessageMaxLength()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "faleHafezData", "getFaleHafezData()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "attachmentData", "getAttachmentData()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "attachmentDataDarkTheme", "getAttachmentDataDarkTheme()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "attachmentDataWithBadge", "getAttachmentDataWithBadge()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "pollBadgeRemainingCount", "getPollBadgeRemainingCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAttachmentBadgeForPollEnabled", "isAttachmentBadgeForPollEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "newAttachmentData", "getNewAttachmentData()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "newAttachmentDataDarkTheme", "getNewAttachmentDataDarkTheme()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "isFestivalEnable", "isFestivalEnable()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "festivalUrl", "getFestivalUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "arbaeenViewMessage", "getArbaeenViewMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "arbaeenLastViewMessage", "getArbaeenLastViewMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "arbaeenSendPrivateMessage", "getArbaeenSendPrivateMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "arbaeenSendPublicMessage", "getArbaeenSendPublicMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "arbaeenPoweredBy", "getArbaeenPoweredBy()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "arbaeenAddToStory", "getArbaeenAddToStory()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "showArbaeenDialogMaxCount", "getShowArbaeenDialogMaxCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "newLoadHistoryLimit", "getNewLoadHistoryLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "albumMaxSize", "getAlbumMaxSize()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "requestGetGlobalUnreadCountsInterval", "getRequestGetGlobalUnreadCountsInterval()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "channelBadgeAttachmentValue", "getChannelBadgeAttachmentValue()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "groupBadgeAttachmentValue", "getGroupBadgeAttachmentValue()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "privateBadgeAttachmentValue", "getPrivateBadgeAttachmentValue()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "topPeersPrefixes", "getTopPeersPrefixes()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "channelHost", "getChannelHost()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "baleHosts", "getBaleHosts()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "festivalTitleEn", "getFestivalTitleEn()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "festivalTitleFa", "getFestivalTitleFa()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "eventBarData", "getEventBarData()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inviteMessage", "getInviteMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "countForShowChangeDefaultTab", "getCountForShowChangeDefaultTab()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "delayForChangeDefaultTab", "getDelayForChangeDefaultTab()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "minDialogCountForServiceBanner", "getMinDialogCountForServiceBanner()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "ussdChargeCode", "getUssdChargeCode()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isFastChargeBoughtSuccessfully", "isFastChargeBoughtSuccessfully()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "callShareScreenZoomAnimationShowCount", "getCallShareScreenZoomAnimationShowCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "callShareScreenZoomAnimationLastShowTime", "getCallShareScreenZoomAnimationLastShowTime()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "oTPTransactionCheckerTimeoutInSeconds", "getOTPTransactionCheckerTimeoutInSeconds()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "otpInfoMessage", "getOtpInfoMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "dialogPinAdReloadTimeInSecond", "getDialogPinAdReloadTimeInSecond()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "dialogPinAdListRenewTimeInSecond", "getDialogPinAdListRenewTimeInSecond()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "advertisementPanelLink", "getAdvertisementPanelLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionNoticeTextTitleLowMember", "getAdDiscountPromotionNoticeTextTitleLowMember()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionNoticeTextLabelLowMember", "getAdDiscountPromotionNoticeTextLabelLowMember()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionTooltipTextLowMember", "getAdDiscountPromotionTooltipTextLowMember()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionNoticeTextTitleMediumMember", "getAdDiscountPromotionNoticeTextTitleMediumMember()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionNoticeTextLabelMediumMember", "getAdDiscountPromotionNoticeTextLabelMediumMember()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "adDiscountPromotionTooltipTextMediumMember", "getAdDiscountPromotionTooltipTextMediumMember()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "inAppMessageViewCount", "getInAppMessageViewCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inAppMessageAllowableViewCount", "getInAppMessageAllowableViewCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inAppMessageDisplayDelayFromLastSeenInSec", "getInAppMessageDisplayDelayFromLastSeenInSec()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inAppMessageConfig", "getInAppMessageConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "customEventBarConfig", "getCustomEventBarConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "wasMultiAccountOnboardingTooltipShown", "getWasMultiAccountOnboardingTooltipShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "currentCustomEventBarClickedOrClosed", "getCurrentCustomEventBarClickedOrClosed()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "currentCustomEventBarViewCount", "getCurrentCustomEventBarViewCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "passportHasSet", "getPassportHasSet()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isNeverShowRatingAppClicked", "isNeverShowRatingAppClicked()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "currentCustomEventBarAllowableViewCount", "getCurrentCustomEventBarAllowableViewCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "updateEventBarContentLink", "getUpdateEventBarContentLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardToCardBannerAdConfig", "getCardToCardBannerAdConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "dialogBannerAdConfig", "getDialogBannerAdConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "dialogBannerAdViewCount", "getDialogBannerAdViewCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "dialogBannerAdClicked", "getDialogBannerAdClicked()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "archivedClicked", "getArchivedClicked()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyNoticeClicked", "getChannelEarnMoneyNoticeClicked()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyGuidePeerId", "getChannelEarnMoneyGuidePeerId()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyGuidePostRandomId", "getChannelEarnMoneyGuidePostRandomId()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyGuidePostDateInMills", "getChannelEarnMoneyGuidePostDateInMills()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyOptionClicked", "getChannelEarnMoneyOptionClicked()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "channelEarnMoneyOptionViewCount", "getChannelEarnMoneyOptionViewCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "loadReactionsIntervalTimeMillis", "getLoadReactionsIntervalTimeMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "loadViewsIntervalTimeMillis", "getLoadViewsIntervalTimeMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "recentSearchLimit", "getRecentSearchLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "baleDownloadInviteUrl", "getBaleDownloadInviteUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationSendGiftPacket", "getWebViewLocationSendGiftPacket()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationSendGoldGiftPacket", "getWebViewLocationSendGoldGiftPacket()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationPayPurchaseMessage", "getWebViewLocationPayPurchaseMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewWebAppPayment", "getWebViewWebAppPayment()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationCoin", "getWebViewLocationCoin()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationTransactionWallet", "getWebViewLocationTransactionWallet()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationCheckoutWallet", "getWebViewLocationCheckoutWallet()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationUpgradeWallet", "getWebViewLocationUpgradeWallet()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationClubReferral", "getWebViewLocationClubReferral()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationClubCarousel", "getWebViewLocationClubCarousel()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationClubP1", "getWebViewLocationClubP1()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationRialDigital", "getWebViewLocationRialDigital()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationBankWallet", "getWebViewLocationBankWallet()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationBankP2PPayment", "getWebViewLocationBankP2PPayment()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewLocationBankP1", "getWebViewLocationBankP1()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "advancedForwardPeerSendDelayMs", "getAdvancedForwardPeerSendDelayMs()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "advancedForwardPeerSelectLimit", "getAdvancedForwardPeerSelectLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "advancedForwardMessageSelectLimit", "getAdvancedForwardMessageSelectLimit()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardToCardConfig", "getCardToCardConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardToCardMeliPercentage", "getCardToCardMeliPercentage()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardToCardDescriptionLength", "getCardToCardDescriptionLength()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "chargeWalletUrl", "getChargeWalletUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "transactionWalletUrl", "getTransactionWalletUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cashoutUrl", "getCashoutUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "kindCircleUrl", "getKindCircleUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "formalDialogsUniqueIds", "getFormalDialogsUniqueIds()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "formalDialogsMaxUnreadCount", "getFormalDialogsMaxUnreadCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "globalLastVersion", "getGlobalLastVersion()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "feedbackUnder30SCount", "getFeedbackUnder30SCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "maxAccountCount", "getMaxAccountCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "servicesTooltipAllowableViewCount", "getServicesTooltipAllowableViewCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "servicesTooltipViewCount", "getServicesTooltipViewCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "servicesTooltipViewLastSeen", "getServicesTooltipViewLastSeen()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "servicesTooltipConfig", "getServicesTooltipConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "recordCallToolTipShowedCount", "getRecordCallToolTipShowedCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "callMoreMenuBadgeCount", "getCallMoreMenuBadgeCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "lastCallTollTipShowedDate", "getLastCallTollTipShowedDate()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isUserRatedOnBazar", "isUserRatedOnBazar()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isNotShowOnBazarEnabled", "isNotShowOnBazarEnabled()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isFirstTimeBazzarFeedBackShowed", "isFirstTimeBazzarFeedBackShowed()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isAndroid14FullIntentDisabled", "isAndroid14FullIntentDisabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "billPaymentUrl", "getBillPaymentUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "chargePaymentUrl", "getChargePaymentUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "onboardingDialogBannerClickedOrClosed", "getOnboardingDialogBannerClickedOrClosed()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "serviceBannerSessionViewCount", "getServiceBannerSessionViewCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "onboardingDialogBannerSessionViewCount", "getOnboardingDialogBannerSessionViewCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "contactsChannelsOnboardingStringsCategory", "getContactsChannelsOnboardingStringsCategory()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "internetPaymentUrl", "getInternetPaymentUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inviteCoinsCount", "getInviteCoinsCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "urlProxyPrefix", "getUrlProxyPrefix()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "isRegisteredToMXP", "isRegisteredToMXP()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketSellerServices", "getMarketSellerServices()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketBanners", "getMarketBanners()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketLoadMoreSize", "getMarketLoadMoreSize()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketProductLoadMoreSize", "getMarketProductLoadMoreSize()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketItemsCount", "getMarketItemsCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "marketItemsMorePageCacheHour", "getMarketItemsMorePageCacheHour()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "groupCallLimitMemberCount", "getGroupCallLimitMemberCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "gifChannelUniqueId", "getGifChannelUniqueId()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "giftPacketCancelTime", "getGiftPacketCancelTime()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "gifTooltipShown", "getGifTooltipShown()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "seenDialogFirstSuggestMagazine", "getSeenDialogFirstSuggestMagazine()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "seenDialogFirstLimitSuggestMagazine", "getSeenDialogFirstLimitSuggestMagazine()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "suggesterHeaderBannerShown", "getSuggesterHeaderBannerShown()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "randomSuccessRate", "getRandomSuccessRate()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "contactListUpdatePresencesPeriod", "getContactListUpdatePresencesPeriod()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "contactListUpdatePresencesRequestBatchCount", "getContactListUpdatePresencesRequestBatchCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "pushHeartbeatIntervalInMillis", "getPushHeartbeatIntervalInMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "pushHeartbeatExpirationPeriodInMillis", "getPushHeartbeatExpirationPeriodInMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "remainingBalanceWageInRial", "getRemainingBalanceWageInRial()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardStatementWageInRial", "getCardStatementWageInRial()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "lastDateUpVote", "getLastDateUpVote()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "sponsoredMessageSecondPositionBots", "getSponsoredMessageSecondPositionBots()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "tooshleUrl", "getTooshleUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "servicesBotsNewBadgeCount", "getServicesBotsNewBadgeCount()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "allServicesWebViewUrl", "getAllServicesWebViewUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "goldBotId", "getGoldBotId()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "goldWalletClickActionUrl", "getGoldWalletClickActionUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "allBotsWebViewUrl", "getAllBotsWebViewUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "visitedServicesIDs", "getVisitedServicesIDs()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "servicesScrollToGoldWallet", "getServicesScrollToGoldWallet()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "servicesCacheForceDelete", "getServicesCacheForceDelete()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "servicesProfileSupportBotEnabled", "getServicesProfileSupportBotEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "servicesProfileSupportBotPeerId", "getServicesProfileSupportBotPeerId()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "globalGroupSubmitBotId", "getGlobalGroupSubmitBotId()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "sendStartWithoutClickForWhitelistBotIds", "getSendStartWithoutClickForWhitelistBotIds()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "c2cSupportDeepLink", "getC2cSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "createMoneyRequestSupportDeepLink", "getCreateMoneyRequestSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "payMoneyRequestSupportDeepLink", "getPayMoneyRequestSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "payCrowdFundingSupportDeepLink", "getPayCrowdFundingSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardBalanceSupportDeepLink", "getCardBalanceSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardStatementSupportDeepLink", "getCardStatementSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "cardManagementSupportDeepLink", "getCardManagementSupportDeepLink()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "botSupportUserId", "getBotSupportUserId()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "baleGuideChannelId", "getBaleGuideChannelId()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "baleFAQUrl", "getBaleFAQUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "baleDownloadAppUrl", "getBaleDownloadAppUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "validReactionConfig", "getValidReactionConfig()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "servicesMinAmountForChangeNumber", "getServicesMinAmountForChangeNumber()J", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "maxMemberValidForSeenListCount", "getMaxMemberValidForSeenListCount()I", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "addLiveStreamLink", "getAddLiveStreamLink()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "liveBaseLink", "getLiveBaseLink()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "authenticatorCreatePasswordText", "getAuthenticatorCreatePasswordText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "goldConfirmationAuthText", "getGoldConfirmationAuthText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "botConfirmationAuthText", "getBotConfirmationAuthText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "goldAuthenticatorOtpText", "getGoldAuthenticatorOtpText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "botAuthenticatorOtpText", "getBotAuthenticatorOtpText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "authenticatorGoldCreatePasswordText", "getAuthenticatorGoldCreatePasswordText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "createPasswordIntroText", "getCreatePasswordIntroText()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "authenticatorCreatePasswordIntroText", "getAuthenticatorCreatePasswordIntroText()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "botTermsAndConditionsUrl", "getBotTermsAndConditionsUrl()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "genericDeepLinks", "getGenericDeepLinks()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "aiBotId", "getAiBotId()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "aiBotIdForAiTab", "getAiBotIdForAiTab()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "webViewAiTab", "getWebViewAiTab()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "aiNewChatStartMessage", "getAiNewChatStartMessage()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "emptyStateOnboarding", "getEmptyStateOnboarding()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "actionCardBanner", "getActionCardBanner()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "inAppUpdateFlavors", "getInAppUpdateFlavors()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "voiceTranscriptDurationLimitInMillis", "getVoiceTranscriptDurationLimitInMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "voiceTranscriptLoadingDurationLimitInMillis", "getVoiceTranscriptLoadingDurationLimitInMillis()J", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "voiceTranscriptExPeerLimitation", "getVoiceTranscriptExPeerLimitation()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(SettingsModule.class, "generalMessageShown", "getGeneralMessageShown()Z", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "premiumBanners", "getPremiumBanners()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "premiumTerms", "getPremiumTerms()Ljava/lang/String;", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "timcheBotId", "getTimcheBotId()I", 0)), AbstractC10882cM5.i(new C25226zw5(SettingsModule.class, "timcheDetailShortName", "getTimcheDetailShortName()Ljava/lang/String;", 0))};
    public static final a U4 = new a(null);
    public static final int W4 = 8;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsModule(C9057Yh4 c9057Yh4, InterfaceC3570Bk5 interfaceC3570Bk5) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(interfaceC3570Bk5, "settingStorage");
        this.b = c9057Yh4;
        this.c = interfaceC3570Bk5;
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jw6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SettingsModule.Q5(this.a);
            }
        });
        Q12.a aVar = Q12.b;
        W12 w12 = W12.f;
        this.h = new C10853cJ3("jaryan.feed_refresh_time", Q12.A(T12.s(15, w12)));
        this.i = new C16022ka3("app.android.low_storage_limitation", 200);
        this.j = new C16022ka3("app.android.pin.limit.default.tabs.enabled", 50);
        this.k = new C16022ka3("app.android.pin.limit.all.tab.enabled", 5);
        this.l = new C16022ka3("app.android.folder.limit", 20);
        this.m = new C16022ka3("app.android.min_buffer_in_ms", SIPTransactionStack.BASE_TIMER_INTERVAL);
        this.n = new C16022ka3("app.android.max_buffer_in_ms", AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND);
        this.o = new C16022ka3("app.android.playback_buffer_in_ms", SIPTransactionStack.BASE_TIMER_INTERVAL);
        this.p = new C16022ka3("app.android.playback_rebuffer_in_ms", SIPTransactionStack.BASE_TIMER_INTERVAL);
        this.q = new C10853cJ3("app.android.exoplayer_preload_cache_size", 51200L);
        this.r = new EY6("app.android.compression_config", "");
        this.s = new EY6("app.android.story_compression_config", "");
        this.t = new C7808Th0("app.android.migration.pin", false);
        this.u = new C16022ka3("app.android.upload_chunk_size", 16384);
        this.v = new C16022ka3("app.android.upload_concurrent_chunks", 32);
        this.w = new C16022ka3("app.android.upload_concurrent_files", 1);
        this.x = new C10853cJ3("app.android.upload_backoff_duration_in_millis", 5000L);
        this.y = new C16022ka3("app.android.upload_file_size_for_direct_upload", 131072);
        this.z = new EY6("app.android.safe_unique_ids_to_download_apk_from", "6231962865,6378652161");
        this.A = new C16022ka3("jaryan.count_shown_swipe_tutorials", 0);
        this.B = new C10853cJ3("jaryan.last_shown_swipe_tutorial_time", 0L);
        this.C = new C10853cJ3("jaryan.last_time_similar_post_swipe", 0L);
        this.D = new C16022ka3("jaryan.count_3_time_tutorial_shown", 0);
        this.E = new C10853cJ3("jaryan.last_shown_fake_drag_animation", 0L);
        this.F = new EY6("jaryan_search_tooltip_config", "");
        this.G = new EY6("market_popular_search_item", "");
        this.H = new EY6("jaryan_popular_search_item", "");
        this.I = new C7808Th0("category.mobile.notification.show_text", true);
        this.J = new C7808Th0("category.mobile.notification.screen_light", true);
        this.K = new C7808Th0("category.mobile.notification.led_light", true);
        this.L = new C7808Th0("account.notifications.private.enabled", true);
        this.M = new C7808Th0("account.notifications.group.enabled", true);
        this.N = new C7808Th0("app.android_confirm_join_on_boarding_channels", false);
        this.O = new C7808Th0("app.android.mobile.auto_download_wifi_photo", true);
        this.P = new C7808Th0("app.android.mobile.auto_download_wifi_video", false);
        this.Q = new C7808Th0("app.android.mobile.auto_download_wifi_voice", true);
        this.R = new C7808Th0("app.android.mobile.auto_download_wifi_file", false);
        this.S = new C7808Th0("app.android.mobile.auto_download_wifi_gif", true);
        this.T = new C7808Th0("app.android.mobile.auto_download_data_photo", true);
        this.U = new C7808Th0("app.android.mobile.auto_download_data_video", false);
        this.V = new C7808Th0("app.android.mobile.auto_download_data_voice", true);
        this.W = new C7808Th0("app.android.mobile.auto_download_data_file", false);
        this.X = new C7808Th0("app.android.mobile.auto_download_data_gif", true);
        this.Y = new C16022ka3("app.android.mobile.auto_download_min_limit", 5);
        this.Z = new C16022ka3("app.android.mobile.auto_download_current_limit", 15);
        this.a0 = new C16022ka3("app.android.mobile.auto_download_max_limit", 45);
        this.b0 = new C16022ka3("app.android.mobile.max_video_size_for_previewing", 20971520);
        this.c0 = new C7808Th0("app.android.mobile.show_all_dialog_tab", true);
        this.d0 = new C7808Th0("app.android.mobile.show_channel_dialog_tab", true);
        this.e0 = new C7808Th0("app.android.mobile.show_group_dialog_tab", true);
        this.f0 = new C7808Th0("app.android.mobile.show_private_dialog_tab", true);
        this.g0 = new C7808Th0("app.android.mobile.show_bot_dialog_tab", true);
        this.h0 = new C7808Th0("app.androidmobile.send_by_enter", false);
        this.i0 = new EY6("web_app.terms_of_use_url", "");
        this.j0 = new EY6("web_app.verified_bots_to_have_permission", "");
        this.k0 = new C7808Th0("bot.has_interacted_with_bot_before", false);
        this.l0 = new EY6("privacy.call", "always");
        this.m0 = new EY6("privacy.last_seen", "always");
        this.n0 = new EY6("privacy.invite_to_group", "always");
        this.o0 = new C7808Th0("show_menu_with_badge", true);
        this.p0 = new C7808Th0("show_more_with_badge", true);
        this.q0 = new C7808Th0("show_folder_with_badge", true);
        this.r0 = new C7808Th0("show_unread_badge", true);
        this.s0 = new C7808Th0("show_setting_with_badge", true);
        this.t0 = new C7808Th0("app.android.story.suggestions_enabled_new", false);
        this.u0 = new C7808Th0("app.android.story.channel_owner_balloon_shown", false);
        this.v0 = new C7808Th0("app.android.story.group_owner_balloon_shown", false);
        this.w0 = new C7808Th0("app.android.story.channel_page_balloon_shown", false);
        this.x0 = new C7808Th0("app.android.story.group_page_balloon_shown", false);
        this.y0 = new C7808Th0("app.android.story.tooltip_shown_in_upload", false);
        this.z0 = new C7808Th0("story.hafez_faal_tooltip_shown", false);
        this.A0 = new C7808Th0("app.android.story.tag_tooltip_shown", false);
        this.B0 = new C7808Th0("app.android.story.tag_yalda_tooltip_shown", false);
        this.C0 = new EY6("app.android.story.global_user_ids", "");
        this.D0 = new EY6("app.android.story_background_suggestions_title", "");
        this.E0 = new C16022ka3("app.android.story.display_time_in_second", 5);
        this.F0 = new C16022ka3("app.android.story.video_max_duration_in_second_new", 30);
        this.G0 = new C10853cJ3("app.android.chat.related_channels_time_out", 1000L);
        this.H0 = new C16022ka3("farokhi.send.channel.story_min_members_count", 3000);
        this.I0 = new C16022ka3("farokhi.send.group.story_min_members_count", 50);
        this.J0 = new C16022ka3("story.story_adder_fragment_opening_state", 0);
        this.K0 = new C16022ka3("story.add_story_state", 0);
        this.L0 = new C16022ka3("story.prefetch_size", 3);
        this.M0 = new C16022ka3("story.text_story_max_length", 280);
        this.N0 = new EY6("story.new_text_story_hint", "مثلا: داستان کوتاه، اشعار، روزمرگی و...");
        this.O0 = new EY6("story.new_text_story_hint_eng", "Example: Short story, poem, daily life ,...");
        this.P0 = new C10853cJ3("messaging.global_search_max_results_count", 4L);
        this.Q0 = new C16022ka3("story.reaction_onboarding_count", 0);
        this.R0 = new C16022ka3("story.pre_download_limit", 3);
        this.S0 = new EY6(JF5.g() ? "app.android.channels.suggestion_channels_title" : "app.android.channels.suggestion_channels_title_english", "کانال های پیشنهادی");
        this.T0 = new C16022ka3("app.android.my_bank_version_badge", 0);
        this.U0 = new C16022ka3("app.android.story.navigation_percentage", 20);
        this.V0 = new C7808Th0("services.toggle_authenticator.enabled", false);
        this.W0 = new EY6("banking.cardToCard.policy", "always");
        this.X0 = new C16022ka3("message.text.max.length", 4096);
        this.Y0 = new EY6("fale.hafez.data", "[{\"index\":1,\"accessHash\":\"1422775695\",\"fileId\":\"1080811134048867074\",\"fileSize\":\"114678\"},{\"index\":2,\"accessHash\":\"1422775695\",\"fileId\":\"-8182583126056889599\",\"fileSize\":\"120107\"},{\"index\":3,\"accessHash\":\"1422775695\",\"fileId\":\"-3425040293135183102\",\"fileSize\":\"120313\"},{\"index\":4,\"accessHash\":\"1422775695\",\"fileId\":\"-2495046970083044605\",\"fileSize\":\"121487\"},{\"index\":5,\"accessHash\":\"1422775695\",\"fileId\":\"1715079809694438144\",\"fileSize\":\"128034\"},{\"index\":6,\"accessHash\":\"1422775695\",\"fileId\":\"5886644517662757634\",\"fileSize\":\"119567\"},{\"index\":7,\"accessHash\":\"1422775695\",\"fileId\":\"7280614155450258176\",\"fileSize\":\"131919\"},{\"index\":8,\"accessHash\":\"1422775695\",\"fileId\":\"-822118038189108478\",\"fileSize\":\"120147\"},{\"index\":9,\"accessHash\":\"1422775695\",\"fileId\":\"209382198339244801\",\"fileSize\":\"126874\"},{\"index\":10,\"accessHash\":\"1422775695\",\"fileId\":\"-3804908366391799038\",\"fileSize\":\"122780\"},{\"index\":11,\"accessHash\":\"1422775695\",\"fileId\":\"-6091769406863502591\",\"fileSize\":\"129402\"},{\"index\":12,\"accessHash\":\"1422775695\",\"fileId\":\"4190652229865181954\",\"fileSize\":\"115869\"},{\"index\":13,\"accessHash\":\"1422775695\",\"fileId\":\"-5987553296736251136\",\"fileSize\":\"114836\"},{\"index\":14,\"accessHash\":\"1422775695\",\"fileId\":\"6541742341585244930\",\"fileSize\":\"101187\"},{\"index\":15,\"accessHash\":\"1422775695\",\"fileId\":\"-8950306125034351871\",\"fileSize\":\"118787\"},{\"index\":16,\"accessHash\":\"1422775695\",\"fileId\":\"-7015711017914264832\",\"fileSize\":\"113500\"},{\"index\":17,\"accessHash\":\"1422775695\",\"fileId\":\"468603059705877250\",\"fileSize\":\"142127\"},{\"index\":18,\"accessHash\":\"1422775695\",\"fileId\":\"-8556751331032886525\",\"fileSize\":\"125298\"},{\"index\":19,\"accessHash\":\"1422775695\",\"fileId\":\"-8045188153047248126\",\"fileSize\":\"121737\"},{\"index\":20,\"accessHash\":\"1422775695\",\"fileId\":\"1948492934134436608\",\"fileSize\":\"118668\"},{\"index\":21,\"accessHash\":\"1422775695\",\"fileId\":\"-8758938325241163005\",\"fileSize\":\"114566\"},{\"index\":22,\"accessHash\":\"1422775695\",\"fileId\":\"-1959452865958046974\",\"fileSize\":\"100655\"},{\"index\":23,\"accessHash\":\"1422775695\",\"fileId\":\"-4479744623053106431\",\"fileSize\":\"106640\"},{\"index\":24,\"accessHash\":\"1422775695\",\"fileId\":\"5207885203513873155\",\"fileSize\":\"107887\"},{\"index\":25,\"accessHash\":\"1422775695\",\"fileId\":\"647656329266467584\",\"fileSize\":\"111638\"},{\"index\":26,\"accessHash\":\"1422775695\",\"fileId\":\"2257147838284108545\",\"fileSize\":\"113004\"},{\"index\":27,\"accessHash\":\"1422775695\",\"fileId\":\"-2818268204274019584\",\"fileSize\":\"139812\"},{\"index\":28,\"accessHash\":\"1422775695\",\"fileId\":\"7708086684146537216\",\"fileSize\":\"115030\"},{\"index\":29,\"accessHash\":\"1422775695\",\"fileId\":\"-5195588265386044671\",\"fileSize\":\"115283\"},{\"index\":30,\"accessHash\":\"1422775695\",\"fileId\":\"-5179157163620494589\",\"fileSize\":\"109120\"},{\"index\":31,\"accessHash\":\"1422775695\",\"fileId\":\"-2323224088983891199\",\"fileSize\":\"117941\"},{\"index\":32,\"accessHash\":\"1422775695\",\"fileId\":\"-7170610216034299136\",\"fileSize\":\"104255\"},{\"index\":33,\"accessHash\":\"1422775695\",\"fileId\":\"-3768861977183644926\",\"fileSize\":\"126528\"},{\"index\":34,\"accessHash\":\"1422775695\",\"fileId\":\"5009586082421871362\",\"fileSize\":\"116398\"},{\"index\":35,\"accessHash\":\"1422775695\",\"fileId\":\"-6679524342604229888\",\"fileSize\":\"106824\"},{\"index\":36,\"accessHash\":\"1422775695\",\"fileId\":\"-1938430203634052352\",\"fileSize\":\"121127\"}]");
        this.Z0 = new EY6("attachment.data", "{\"BankItems\":[{\"tag\":\"GIFT_POCKET\",\"title\":\"پاکت هدیه\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false},{\"tag\":\"MONEY_TRANSFER\",\"title\":\"کارت\u200c به\u200c کارت\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false},{\"tag\":\"MONEY_REQUEST\",\"title\":\"درخواست پول\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false}],\"ShareItems\":[{\"tag\":\"CAMERA\",\"title\":\"دوربین\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#000000\",\"tint\":\"#00000000\"},{\"tag\":\"GALLERY\",\"title\":\"نگارخانه\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#EC407A\",\"tint\":\"#FFFFFF\"},{\"tag\":\"FILE\",\"title\":\"فایل\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#FFAC28\",\"tint\":\"#FFFFFF\"},{\"tag\":\"LOCATION\",\"title\":\"موقعیت\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#53CCA6\",\"tint\":\"#FFFFFF\"},{\"tag\":\"POLL\",\"title\":\"نظرسنجی\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#B37FEB\",\"tint\":\"#FFFFFF\"},{\"tag\":\"CONTACT\",\"title\":\"مخاطب\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#4FC3F7\",\"tint\":\"#FFFFFF\"}]}");
        this.a1 = new EY6("attachment.data.dark", "{\"BankItems\":[{\"tag\":\"GIFT_POCKET\",\"title\":\"پاکت هدیه\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false},{\"tag\":\"MONEY_TRANSFER\",\"title\":\"کارت \u200cبه\u200c کارت\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false},{\"tag\":\"MONEY_REQUEST\",\"title\":\"درخواست پول\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false}],\"ShareItems\":[{\"tag\":\"CAMERA\",\"title\":\"دوربین\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#000000\",\"tint\":\"#00000000\"},{\"tag\":\"GALLERY\",\"title\":\"نگارخانه\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#EC407A\",\"tint\":\"#FFFFFF\"},{\"tag\":\"FILE\",\"title\":\"فایل\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#FFAC28\",\"tint\":\"#FFFFFF\"},{\"tag\":\"LOCATION\",\"title\":\"موقعیت\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#53CCA6\",\"tint\":\"#FFFFFF\"},{\"tag\":\"POLL\",\"title\":\"نظرسنجی\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#B37FEB\",\"tint\":\"#FFFFFF\"},{\"tag\":\"CONTACT\",\"title\":\"مخاطب\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#4FC3F7\",\"tint\":\"#FFFFFF\"}]}");
        this.b1 = new EY6("attachment.data.with.badge", "[\"POLL\"]");
        this.c1 = new C16022ka3("attachment.poll.remaining.count", 5);
        this.d1 = new C7808Th0("attachment.poll.is_enabled", true);
        this.e1 = new EY6("new.attachment.data", "{\"BankItems\":[{\"tag\":\"GIFT_POCKET\",\"title\":\"پاکت هدیه\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false},{\"tag\":\"GOLD_GIFT_POCKET\",\"title\":\"پاکت هدیه طلایی\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false},{\"tag\":\"MONEY_TRANSFER\",\"title\":\"کارت\u200c به\u200c کارت\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false},{\"tag\":\"MONEY_REQUEST\",\"title\":\"درخواست پول\",\"titleColor\":\"#328FEF\",\"backgroundTint\":\"#FFFFFF\",\"tint\":\"#328FEF\",\"border\":\"#DFE5E8\",\"badgeEnabled\":false}],\"ShareItems\":[{\"tag\":\"CAMERA\",\"title\":\"دوربین\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#000000\",\"tint\":\"#00000000\"},{\"tag\":\"GALLERY\",\"title\":\"نگارخانه\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#EC407A\",\"tint\":\"#FFFFFF\"},{\"tag\":\"FILE\",\"title\":\"فایل\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#FFAC28\",\"tint\":\"#FFFFFF\"},{\"tag\":\"LOCATION\",\"title\":\"موقعیت\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#53CCA6\",\"tint\":\"#FFFFFF\"},{\"tag\":\"POLL\",\"title\":\"نظرسنجی\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#B37FEB\",\"tint\":\"#FFFFFF\"},{\"tag\":\"CONTACT\",\"title\":\"مخاطب\",\"titleColor\":\"#7075A0\",\"backgroundTint\":\"#4FC3F7\",\"tint\":\"#FFFFFF\"}]}");
        this.f1 = new EY6("new.attachment.data.dark", "{\"BankItems\":[{\"tag\":\"GIFT_POCKET\",\"title\":\"پاکت هدیه\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false},{\"tag\":\"GOLD_GIFT_POCKET\",\"title\":\"پاکت هدیه طلایی\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false},{\"tag\":\"MONEY_TRANSFER\",\"title\":\"کارت \u200cبه\u200c کارت\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false},{\"tag\":\"MONEY_REQUEST\",\"title\":\"درخواست پول\",\"titleColor\":\"#EDEDF0\",\"backgroundTint\":\"#181818\",\"tint\":\"#EDEDF0\",\"border\":\"#363636\",\"badgeEnabled\":false}],\"ShareItems\":[{\"tag\":\"CAMERA\",\"title\":\"دوربین\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#000000\",\"tint\":\"#00000000\"},{\"tag\":\"GALLERY\",\"title\":\"نگارخانه\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#EC407A\",\"tint\":\"#FFFFFF\"},{\"tag\":\"FILE\",\"title\":\"فایل\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#FFAC28\",\"tint\":\"#FFFFFF\"},{\"tag\":\"LOCATION\",\"title\":\"موقعیت\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#53CCA6\",\"tint\":\"#FFFFFF\"},{\"tag\":\"POLL\",\"title\":\"نظرسنجی\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#B37FEB\",\"tint\":\"#FFFFFF\"},{\"tag\":\"CONTACT\",\"title\":\"مخاطب\",\"titleColor\":\"#8E8E8E\",\"backgroundTint\":\"#4FC3F7\",\"tint\":\"#FFFFFF\"}]}");
        this.h1 = AbstractC10360bX0.p(EnumC4716Gg2.G4, EnumC4716Gg2.n4, EnumC4716Gg2.H4);
        this.i1 = new C7808Th0("festival.enable", false);
        this.j1 = new EY6("festival.url", "https://bale.ai/festival");
        this.k1 = new EY6("arbaeen.view.message.ussd", "*500*6002*2*");
        this.l1 = new EY6("arbaeen.last.view.message.ussd", "*500*6002*5*");
        this.m1 = new EY6("arbaeen.send.message.ussd", "*500*6002*1*");
        this.n1 = new EY6("arbaeen.send.message.public.ussd", "*500*6001*1*");
        this.o1 = new EY6("arbaeen.powered.by", "#۵۰۰*");
        this.p1 = new C7808Th0("arbaeen.add.to.story", true);
        this.q1 = new C16022ka3("arbaeen.show.dialog.max.count", 1);
        this.r1 = new C16022ka3("app.android.mobile.new_load_history_limit", 40);
        this.s1 = new C16022ka3("app.android.mobile.album_max_size", 10);
        W12 w122 = W12.h;
        this.t1 = new C10853cJ3("app.android.get_global_unread_counts_interval", Q12.A(T12.s(1, w122)));
        this.u1 = new C16022ka3("app.android.mobile.channel_attachment_badge_disabled", 2);
        this.v1 = new C16022ka3("app.android.mobile.group_attachment_badge_disabled", 2);
        this.w1 = new C16022ka3("app.android.mobile.private_attachment_badge_disabled", 2);
        this.x1 = new EY6("app.messaging.top_peers_prefixes", "آقا,  خانوم ,  خانم, آقای , دکتر, مهندس ,سید");
        this.y1 = new EY6("bale.channel.host", "ble.ir");
        this.z1 = new EY6("bale.hosts", "ble.ir");
        this.A1 = new EY6("festival.button.title.en", "");
        this.B1 = new EY6("festival.button.title.fa", "");
        this.C1 = new EY6("app.android.eventbar.data.json", "");
        this.D1 = new EY6("app.android.mobile.invite_message", "{appName}! اولین پیام رسان با قابلیتهای مالی در ایران.\nلینک دانلود:\n{inviteUrl}");
        this.E1 = new C16022ka3("app.android.mobile.count_for_show_change_default_tab", 3);
        this.F1 = new C16022ka3("app.android.mobile.delay_for_change_default_tab", 2000);
        this.G1 = new C16022ka3("app.all.min_dialog_count_service_banner", 7);
        this.H1 = new EY6("ussd.charge.code", "*500*7467668*1{*operator}*2{*amount_option}{*phone_number}#");
        this.I1 = new C7808Th0("app.android.mobile.fast_charge_bought_successfully", false);
        this.J1 = new C16022ka3("app.android.call_share_screen_zoom_animation_show_count", 0);
        this.K1 = new C10853cJ3("app.android.call_share_screen_zoom_animation_last_show_time", 0L);
        this.L1 = new C16022ka3("otp.timeout", SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        this.M1 = new EY6("otp_message_after_card_entered", "مشتری گرامی، اگر از روش\u200cهایی نظیر برنامک\u200cهای رمزساز استفاده می\u200cکنید، نیازی به فشردن دکمه دریافت رمز پویا نیست و می\u200cتوانید رمز دریافت شده از برنامک را در قسمت رمز دوم وارد کنید.");
        this.N1 = new C16022ka3("dialog_ad.reload_time", 90);
        this.O1 = new C16022ka3("dialog_ad_list.renew_time", 300);
        this.P1 = new EY6("advertisement_panel_link", "https://tabligh.bale.ai/login");
        this.Q1 = new EY6("ad_discount_promotion_notice_text_title_low_member", "۵۰٪ تخفیف دائمی برای کانال شما");
        this.R1 = new EY6("ad_discount_promotion_notice_text_label_low_member", "تا زمانی که کانال شما به ۲۰۰۰ عضو برسد، می\u200cتوانید برای ثبت تبلیغ از ۵۰ درصد تخفیف استفاده کنید.");
        this.S1 = new EY6("ad_discount_promotion_tooltip_text_low_member", "٪۵۰ تخفیف ثبت تبلیغ!");
        this.T1 = new EY6("ad_discount_promotion_notice_text_title_medium_member", "۳۵٪ تخفیف دائمی برای کانال شما");
        this.U1 = new EY6("ad_discount_promotion_notice_text_label_medium_member", "تا زمانی که کانال شما به ۵۰۰۰ عضو برسد، می\u200cتوانید برای ثبت تبلیغ از ۳۵ درصد تخفیف استفاده کنید.");
        this.V1 = new EY6("ad_discount_promotion_tooltip_text_medium_member", "٪۳۵ تخفیف ثبت تبلیغ!");
        this.W1 = new C16022ka3("in_app_message_view_count", 0);
        this.X1 = new C16022ka3("in_app_message_allowable_view_count", 1);
        this.Y1 = new C16022ka3("in_app_message_display_delay_from_last_seen_in_sec", SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        this.Z1 = new EY6("in_app_message_config", "{\n  \"in_app_message_id\": \"\",\n  \"title_text\": \"\",\n  \"body_text\": \"\",\n  \"start_button_text\": \"\",\n  \"start_button_link\": \"\",\n  \"content_media_file_id\": \"\",\n  \"content_media_access_hash\": \"\",\n  \"expire_time_in_mills\": \"\"\n}");
        this.a2 = new EY6("custom_event_bar_config", "{\n  \"event_bar_id\": \"\",\n  \"colors_set_number\": \"\",\n  \"title_text\": \"\",\n  \"button_text\": \"\",\n  \"content_link\": \"\",\n  \"expire_time_in_mills\": \"\",\n  \"has_timer\": \"\"\n}");
        this.b2 = new C7808Th0("was_multi_account_onboarding_shown", false);
        this.c2 = new C7808Th0("app.android.current_custom_event_bar_clicked_or_closed", false);
        this.d2 = new C16022ka3("app.android.current_custom_event_bar_view_count", 0);
        this.e2 = new C7808Th0("passport.passport_is_set", false);
        this.f2 = new C7808Th0("rating_app.is_never_show_rating_app_clicked", false);
        this.g2 = new C16022ka3("app.android.current_custom_event_bar_allowable_view_count", 3);
        this.h2 = new EY6("update_event_bar_content_link", "https://bale.ai/dl");
        this.i2 = new EY6("card_to_card_banner_ad_config", "{\n  \"ad_link\": \"\",\n  \"content_media_file_id\": \"\",\n  \"content_media_access_hash\": \"\",\n  \"expire_time_in_mills\": \"\"\n}");
        this.j2 = new EY6("dialog_banner_ad_config", "{\n  \"ad_link\": \"\",\n  \"content_media_file_id\": \"\",\n  \"content_media_access_hash\": \"\",\n  \"expire_time_in_mills\": \"\"\n}");
        this.k2 = new C16022ka3("dialog_banner_ad_view_count", 0);
        this.l2 = new C7808Th0("dialog_banner_ad_clicked", false);
        this.m2 = new C7808Th0("archived_clicked", false);
        this.n2 = new C7808Th0("channel_earn_money_notice_clicked", false);
        this.o2 = new C16022ka3("channel_earn_money_guide_peer_id", 1063843314);
        this.p2 = new C10853cJ3("channel_earn_money_guide_post_random_id", 627221604990432L);
        this.q2 = new C10853cJ3("channel_earn_money_guide_post_date_in_mills", 1720419772027L);
        this.r2 = new C7808Th0("channel_earn_money_option_clicked", false);
        this.s2 = new C16022ka3("channel_earn_money_option_view_count", 0);
        this.t2 = new C10853cJ3("load_reactions_recent_interval_time", 15000L);
        this.u2 = new C10853cJ3("load_views_interval_time", 5000L);
        this.v2 = new C16022ka3("app.android.ferdowc.recent-search-list.limit", 20);
        this.w2 = new EY6("bale_download_invite_url", "https://bale.ai/download");
        this.x2 = new EY6("webview.location.send_gift_packet", "https://tooshle.bale.ai/send_gift");
        this.y2 = new EY6("webview.location.send_gold_gift_packet", "https://tooshle-staging.bale.ai/gold_send_gift");
        this.z2 = new EY6("webview.location.pay_purchase_msg", "https://tooshle.bale.ai/pay_purchase");
        this.A2 = new EY6("webview.webapp_payment", "https://tooshle.bale.ai/pay_purchase/miniapp");
        this.B2 = new EY6("webview.location.coin", "https://tooshle.bale.ai/coin");
        this.C2 = new EY6("webview.location.transaction_wallet", "https://tooshle.bale.ai/transactionWallet");
        this.D2 = new EY6("webview.location.checkout_wallet", "https://tooshle.bale.ai/cashout");
        this.E2 = new EY6("webview.location.upgrade_wallet", "https://tooshle.bale.ai/upgradeWallet");
        this.F2 = new EY6("webview.location.club.referral", "");
        this.G2 = new EY6("webview.location.club.carousel", "");
        this.H2 = new EY6("webview.location.club.p1", "");
        this.I2 = new EY6("webview.location.rialdigital", "https://tooshle.bale.ai/ramz_rial");
        this.J2 = new EY6("webview.location.mybank.wallet", "");
        this.K2 = new EY6("webview.location.mybank.P2Ppayment", "");
        this.L2 = new EY6("webview.location.mybank.p1", "");
        this.M2 = new C16022ka3("app.android.advanced_forward.send_to_peers.delay_ms", 50);
        this.N2 = new C16022ka3("app.android.advanced_forward.peer_selection_limit", 50);
        this.O2 = new C16022ka3("app.android.advanced_forward.message_selection_limit", 50);
        this.P2 = new EY6("card_to_card.config", "{\"BankList\":[{\"CardNumberPattern\":[\"207177\",\"627648\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"توسعه صادرات ایران\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"502229\",\"639347\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"پاسارگاد\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"502806\",\"504706\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"شهر\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"502908\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"توسعه تعاون\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"502910\",\"627488\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"کارآفرین\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"502938\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"دی\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"504172\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"قرض الحسنه رسالت\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"505416\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"گردشگری\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"505785\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"ایران زمین\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"505801\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"موسسه اعتباری کوثر\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"507677\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"موسسه اعتباری نور\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"585947\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"خاورمیانه\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"585983\",\"627353\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"تجارت\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"589210\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"سپه\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"589463\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"رفاه کارگران\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"603769\"],\"ConfirmCodeRequire\":true,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"صادرات\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"603770\",\"639217\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"کشاورزی\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"603799\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":1000,\"Name\":\"ملی\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"606256\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"موسسه اعتباری ملل\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"606373\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"قرض الحسنه مهر ایران\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"610433\",\"991975\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"ملت\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"621986\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"سامان\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"622106\",\"627884\",\"639194\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"پارسیان\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"627381\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"انصار\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"627412\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"اقتصاد نوین\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"627760\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"پست بانک\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"627961\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"صنعت و معدن\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"628023\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"مسکن\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"628157\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"موسسه اعتباری توسعه\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"636214\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"آینده\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"636795\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"مرکزی\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"636949\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"حکمت ایرانیان\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"639346\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"سینا\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"639370\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"مهر اقتصاد\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"639599\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"قوامین\",\"SourceStatus\":{\"Enable\":true}},{\"CardNumberPattern\":[\"639607\"],\"ConfirmCodeRequire\":false,\"DestinationStatus\":{\"Enable\":true},\"Logo\":\"Bank logo url\",\"MaximumAmount\":1000000000,\"MinimumAmount\":10000,\"Name\":\"سرمایه\",\"SourceStatus\":{\"Enable\":true}}],\"Status\":{\"Enable\":true,\"Message\":\"از ساعت ۲۳:۴۵ الی ۰۰:۰۵ دقیقه بامداد هرروز، کارت\u200cبه\u200cکارت به دلیل به\u200cروزرسانی سیستم شتاب با اختلال مواجه است.\",\"MinAppVersion\":0,\"Title\":\"ساعت بروزرسانی سیستم شتاب\"}}");
        this.Q2 = new C16022ka3("card_to_card_melli.percentage", 0);
        this.R2 = new C16022ka3("card_to_card.length", 45);
        this.S2 = new EY6("charge_wallet_url", "https://tooshle.bale.ai/chargeWallet");
        this.T2 = new EY6("transaction_wallet_url", "https://tooshle.bale.ai/transactionWallet");
        this.U2 = new EY6("cashout_url", "https://tooshle.bale.ai/cashout");
        this.V2 = new EY6("kind_circle_url", "https://ble.ir/kind_circle");
        this.W2 = new EY6("app.android.formal_dialogs_unique_ids", "4550604512");
        this.X2 = new C16022ka3("app.android.formal_dialogs_max_unread_count", 10);
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        this.Y2 = new EY6("global.category.android.last_version", strR);
        this.Z2 = new C16022ka3("call.feedback.showed_count", 0);
        this.a3 = new C16022ka3("app.maximum_account_count", 2);
        this.b3 = new C16022ka3("app.all.services_tooltip_allowable_view_count", 3);
        this.c3 = new C16022ka3("app.all.services_tooltip_view_count", 0);
        this.d3 = new C10853cJ3("app.all.services_tooltip_view_last_update", 0L);
        this.e3 = new EY6("app.all.services_tooltip_config", "        {\n          \"title\": \"کارهای مالی و اداری\u200cتان را از اینجا انجام دهید.\",\n          \"maxWidth\": 300,\n          \"relatedPeers\": [1, 2, 3],\n          \"maxNumRelatedPeersToShow\": 0,\n          \"intervalBetweenShowInDays\": [14, 30]\n        }");
        this.f3 = new C16022ka3("call.record.tooltip", 0);
        this.g3 = new C16022ka3("call.moremenu.badge.count", 0);
        this.h3 = new EY6("call.record.tooltip.last", "");
        this.i3 = new C7808Th0("call.feedback.rated_on_bazar", false);
        this.j3 = new C7808Th0("call.feedback.is_show_bazar_enabled", false);
        this.k3 = new C7808Th0("call.feedback.bazar.is_first_time_showed", false);
        this.l3 = new C7808Th0("call.fullscreen.android14", false);
        this.m3 = new EY6("bill_payment_url", "https://tooshle.bale.ai/bill");
        this.n3 = new EY6("charge_payment_url", "https://tooshle.bale.ai/buy_charge");
        this.o3 = new C7808Th0("onboarding_dialog_clicked_or_closed", false);
        this.p3 = new C16022ka3("service_banner_session_view_count", 0);
        this.q3 = new C16022ka3("onboarding_dialog_banner_session_view_count", 0);
        this.r3 = new C16022ka3("contacts_channels_onboarding_strings_category", 1);
        this.s3 = new EY6("internet_payment_url", "https://tooshle.bale.ai/buy_internet");
        this.t3 = new C16022ka3("invite_coins_count", 100);
        this.u3 = new EY6("url_proxy_prefix", "https://l.ble.ir/?l=");
        this.v3 = new C7808Th0("is_registered_to_mxb", false);
        this.w3 = new EY6("market_seller_services", "{\"items\":[{\"action\":{\"id\":1409431017,\"type\":2,\"url\":\"balecommerce\"},\"drawableId\":\"hint\",\"id\":0,\"isDisable\":false,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"راهنمای فروشندگان\"},{\"action\":{\"type\":1,\"url\":\"https://tooshle.bale.ai/shopman\"},\"drawableId\":\"create_market\",\"id\":0,\"isDisable\":false,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"حضور در فروشگاه\"},{\"action\":{\"type\":3,\"url\":\"https://ble.ir/balecommerce/-6366286404700987682/1678900035430\"},\"drawableId\":\"widespread\",\"id\":0,\"badge\":\"جدید\",\"isDisable\":false,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"تبلیغات گسترده\"},{\"dialog\":{\"description\":\"با استفاده از این ویژگی، می\u200cتوانید برای هر یک از محصولات خود فاکتور ایجاد کنید و با مشتریان خود به اشتراک بگذارید. همچنین می\u200cتوانید لوگو و نام فروشگاه\u200cتان را در این فاکتور درج کنید.\",\"title\":\"ساخت فاکتور\"},\"drawableId\":\"create_invoice\",\"id\":0,\"isDisable\":true,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"ساخت فاکتور\"},{\"dialog\":{\"description\":\"شما با توجه به فعالیت و عملکرد خود در فروشگاه، مانند میزان فروش، گردش حساب و... امتیاز اعتباری برای دریافت وام کسب می\u200cکنید.\",\"title\":\"امتیاز تسهیلات\"},\"drawableId\":\"score\",\"id\":0,\"isDisable\":true,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"امتیاز تسهیلات\"},{\"action\":{\"id\":1,\"type\":1},\"dialog\":{\"description\":\"امکان دریافت «تسهیلات خرد» بر اساس امتیاز به\u200c دست آمده، به\u200cزودی برای فروشگاه\u200cداران فعال خواهد شد.\",\"title\":\"تسهیلات خرد\"},\"drawableId\":\"loan\",\"id\":0,\"isDisable\":true,\"maxAppVersion\":0,\"minAppVersion\":0,\"title\":\"تسهیلات خرد\"}],\"title\":\"خدمات فروشندگان\"}");
        this.x3 = new EY6("market_banners", "[{\"action\":{\"id\":1409431017,\"type\":2,\"url\":\"balecommerce\"},\"id\":0,\"imageUrl\":\"https://my-bank.bale.ai/icons/assets/shop_banner_01_03.jpg\",\"maxAppVersion\":0,\"minAppVersion\":0}]");
        this.y3 = new C16022ka3("market_load_more_size", 20);
        this.z3 = new C16022ka3("market_products_load_more_size", 18);
        this.A3 = new C16022ka3("market_items_count", 4);
        this.B3 = new C16022ka3("market_items_more_page_cache_hour", 4);
        this.C3 = new C16022ka3("GROUP_CALL_MEMBER_COUNT", 0);
        this.D3 = new C10853cJ3("app.android.gif_channel_unique_id", 4336139948L);
        this.E3 = new C10853cJ3("git_packet_delay_time", 0L);
        this.F3 = new C7808Th0("app.android.gif_tooltip_shown", false);
        this.G3 = new C7808Th0("app.android.seen_dialog_first_suggest_magazine_v2", false);
        this.H3 = new C7808Th0("app.android.seen_dialog_first_limit_suggest_magazine", false);
        this.I3 = new C7808Th0("app.android.suggester_header_banner_shown", true);
        this.J3 = new C16022ka3("app.android.random_success_rate", 100);
        this.K3 = new C10853cJ3("app.all.contact_presence_refresh_interval", Q12.A(T12.s(1, w12)));
        this.L3 = new C16022ka3("app.all.contact_presence_chunk_size", 100);
        this.M3 = new C10853cJ3("app.android.push_heartbeat_interval_in_millis", Q12.A(T12.s(7, w122)));
        this.N3 = new C10853cJ3("app.android.push_heartbeat_expiration_period_in_millis", Q12.A(T12.s(30, w122)));
        this.O3 = new C10853cJ3("app.android.remaining_balance_wage_in_rial", 360L);
        this.P3 = new C10853cJ3("app.android.card_statement_wage_in_rial", 360L);
        this.Q3 = new C16022ka3("UPVOTE_WINDOW_LIMIT", 24);
        this.R3 = new EY6("app.android.sponsored_message_second_position_bots", "");
        this.S3 = new EY6("webview.location.host", "https://tooshle.bale.ai");
        this.T3 = new C16022ka3("app.services.bots_new_badge_count", 0);
        this.U3 = new EY6("app.android.all_services_webview_url", "https://tooshle.bale.ai/services?menu=all");
        this.V3 = new C10853cJ3("app.android.all_services_gold_bot_id", 513133114L);
        this.W3 = new EY6("app.android.gold_click_action_url", "");
        this.X3 = new EY6("app.android.all_bots_webview_url", "https://tooshle.bale.ai/services?menu=bots");
        this.Y3 = new EY6("services.visited_items", "");
        this.Z3 = new C16022ka3("services.scroll.to.gold.wallet_count", 0);
        this.a4 = new C10853cJ3("services.force_delete_cache", 0L);
        this.b4 = new C7808Th0("app.android.services_profile_support_bot_enabled", true);
        this.c4 = new C10853cJ3("app.android.services_profile_support_bot_peer_id", 1178660080L);
        this.d4 = new C16022ka3("app.android.submit_global_group_bot_peer_id", 1568033539);
        this.e4 = new EY6("services.send_start_for_whitelist_bot_ids", "");
        this.f4 = new EY6("c2c.support.enabled", "0");
        this.g4 = new EY6("createMoneyRequest.support.enabled", "0");
        this.h4 = new EY6("payMoneyRequest.support.enabled", "0");
        this.i4 = new EY6("payCrowdFunding.support.enabled", "0");
        this.j4 = new EY6("cardBalance.support.enabled", "0");
        this.k4 = new EY6("cardStatement.support.enabled", "0");
        this.l4 = new EY6("cardManagement.support.enabled", "0");
        this.m4 = new C16022ka3("bot_support_user_id", 40);
        this.n4 = new C10853cJ3("core.bale_guide_channel_id", 5670030793L);
        this.o4 = new EY6("core.faq_url", "https://faq.bale.ai");
        this.p4 = new EY6("core.download_app_url", "https://bale.ai/dl");
        this.q4 = new EY6("app.android.valid_reactions.enabled", "❤,👍,👎,😂,😭,👌,🙏,🇮🇷,🌷,😍,😎,😱,😡,😐,🤯,🥳,👏,🤲,🔥,✅,😔,🖤");
        this.r4 = new C10853cJ3("app.all.max_balance_wallet_in_change_number", 0L);
        this.s4 = new C16022ka3("app.all.max_members_for_seen_list", 200);
        this.t4 = new EY6("live.add_link", "");
        this.u4 = new EY6("file.live_base_link", "https://tooshle-staging.bale.ai/live");
        this.v4 = new EY6("services.authenticator_create_password_text", "با ایجاد رمز عبور،\u200c می\u200cتوانید پیام\u200cهای ویژهٔ خود را با امنیت بیشتر دریافت کنید.\nاز این رمز عبور در فرآیند کارت\u200cبه\u200cکارت، مشاهدهٔ برخی پیام\u200c\u200cهای بازوهای بانکی و سازمانی استفاده می\u200cشود.");
        this.w4 = new EY6("services.gold_confirmation_auth_text", "از این رمز عبور در فرآیند خرید و فروش طلا، ارسال پاکت هدیهٔ طلایی، مشاهدهٔ برخی پیام\u200c\u200cهای بازوهای بانکی و سازمانی استفاده می\u200cشود.");
        this.x4 = new EY6("services.bot_confirmation_auth_text", "");
        this.y4 = new EY6("services.authenticator_gold_otp_text", "برای ایجاد رمز عبور مورد استفاده در خرید و فروش طلا، پاکت\u200cهدیهٔ طلایی، کارت\u200cبه\u200cکارت و مشاهدهٔ برخی پیام\u200cهای بازوهای بانکی و سازمانی، ابتدا هویت شما با کد پیامکی تأیید می\u200cشود.");
        this.z4 = new EY6("services.authenticator_bot_otp_text", "");
        this.A4 = new EY6("services.authenticator_gold_create_password_text", "با ایجاد رمز عبور،\u200c می\u200cتوانید خرید و فروش طلا را با امنیت بیشتر دریافت کنید.\nاز این رمز عبور در فرآیند خرید و فروش طلا، ارسال پاکت هدیهٔ طلایی، مشاهدهٔ برخی پیام\u200c\u200cهای بازوهای بانکی و سازمانی استفاده می\u200cشود.");
        this.B4 = new EY6("settings.create_password_intro_text", "با ایجاد رمز عبور، بخش\u200cهایی که نیاز به امنیت بیشتری دارند فقط با وارد کردن این رمز در دسترس خواهند بود.<br>درحال حاضر این رمز در فرایند <b>کارت\u200cبه\u200cکارت و برخی از بازوهای سازمانی و بانکی</b> فعال می\u200cشود.");
        this.C4 = new EY6("services.authenticator_create_password_intro_text", "طبق قوانین جدید بانک مرکزی لازم است برای انتقال پول ازطریق کارت\u200cبه\u200cکارت رمز عبور ایجاد کنید.\n| \n|با ایجاد رمز عبور، بخش\u200cهایی که نیاز به امنیت بیشتری دارند فقط با وارد کردن این رمز در دسترس خواهند بود\n");
        this.D4 = new EY6("services.bot_terms_and_conditions.url", "");
        this.E4 = new EY6("app.all.generic_deep_links", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        this.F4 = new C10853cJ3("app.android.ai.bot_id.url", 2006409041L);
        this.G4 = new C10853cJ3("app.android.ai.bot_in_tab_id.url", 2006409041L);
        this.H4 = new EY6("webview.ai.tab.url", "https://web.bale.ai/chat");
        this.I4 = new EY6("app.android.ai.bot_new_start_chat", "ask_ai");
        this.J4 = new EY6("app.all.empty_state_onboard", "{\n  \"peers\": [\n    {\n      \"peerId\": \"1018866566\",\n      \"description\": \"نسخه\u200cهای پزشکت اینجا میاد!\",\n      \"title\": \"نسخه پزشکی\",\n      \"isBlueTick\": true,\n      \"buttonText\": \"شروع\"\n    },\n    {\n      \"peerId\": \"1496077564\",\n      \"description\": \"مالیات رو «راحت» واریز کن!\",\n      \"title\": \"مالیات\",\n      \"isBlueTick\": true,\n      \"buttonText\": \"شروع\"\n    },\n    {\n      \"peerId\": \"1809438266\",\n      \"description\": \"رهگیری «سریع» بسته\u200cهای پستی!\",\n      \"title\": \"رهگیری پستی\",\n      \"isBlueTick\": true,\n      \"buttonText\": \"شروع\"\n    },\n    {\n      \"peerId\": \"1834682924\",\n      \"description\": \"موجودی کالابرگت رو ببین!\",\n      \"title\": \"کالابرگ\",\n      \"isBlueTick\": true,\n      \"buttonText\": \"شروع\"\n    },\n    {\n      \"peerId\": \"294280585\",\n      \"description\": \"استعلام و پرداخت خلافی خودرو!\",\n      \"title\": \"خدمات انتظامی\",\n      \"isBlueTick\": true,\n      \"buttonText\": \"شروع\"\n    }\n  ]\n}\n");
        this.K4 = new EY6("app.all.actionCardBanner", "{}");
        this.L4 = new EY6("app.in_app_update_flavors", "[ \"bale\" , \"myket\"]");
        this.M4 = new C10853cJ3("app.android.voice_transcript_duration_limit_millis", 300000L);
        this.N4 = new C10853cJ3("app.android.voice_transcript_loading_duration_limit_millis", 10000L);
        this.O4 = new EY6("app.android.voice_transcript_ex_peer_limit", "PRIVATE,GROUP");
        this.P4 = new C7808Th0("app.android.general_message_shown", false);
        this.Q4 = new EY6("premium_banners_url", "");
        this.R4 = new EY6("premium_terms_url", "https://bale.ai/terms");
        this.S4 = new C16022ka3("timche_bot_id", -1);
        this.T4 = new EY6("timche_detail_short_name", "");
    }

    private final void E() {
        InterfaceC4314Ep2.k0.a().put(EnumC4716Gg2.n4, new SA2() { // from class: ir.nasim.mw6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SettingsModule.F(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "this$0");
        settingsModule.b.G().i2();
        return C19938rB7.a;
    }

    private final void G() {
        InterfaceC4314Ep2.k0.b().put(EnumC4716Gg2.n4, new SA2() { // from class: ir.nasim.lw6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SettingsModule.H(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "this$0");
        settingsModule.b.G().h2();
        settingsModule.l7(false);
        return C19938rB7.a;
    }

    private final void Q(String str, String str2) {
        if (AbstractC13042fc3.d(W5(str), str2)) {
            return;
        }
        C9528a7 c9528a7 = this.d;
        if (c9528a7 != null) {
            if (c9528a7 == null) {
                AbstractC13042fc3.y("settingsSync");
                c9528a7 = null;
            }
            c9528a7.d(new a.C0998a(str, str2));
        } else {
            C19406qI3.b("AbsModule", "settingsSync is not initialized! on changeValue with key = " + str);
        }
        S5(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q5(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "this$0");
        byte[] bArrO0 = settingsModule.O0("app.android.messages.location.url");
        if (bArrO0 == null) {
            bArrO0 = C14582i90.a("YmJLjeBbbgbaiq3cxYmjajAavoPhAUlND6hIOh99jb1HsEtfcF+aBEBY0zwqrMd/+ihYw/RzhVAnk0ljUZAN3BEk7zsmTjGUpmEXGKZarsGauvgEW6KjtbgldzMBrMnxj4QsihP5iNrgQ1i78B6rl4lfAT9Ep7qhpWsCVqr0gdMqwGSMYhDWSg2oDIzHGoUwMJQBlhzoGOyISB4NU7Jjcw==");
        }
        byte[] bArrB = AbstractC7464Rv1.b(settingsModule.W2(), bArrO0);
        AbstractC13042fc3.f(bArrB);
        return AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(new String(bArrB, C12275eL0.b), "zoom=15", "zoom=18", false, 4, null), "width=300", "width=" + C22078ud6.a(300.0f), false, 4, null), "height=150", "height=" + C22078ud6.a(200.0f), false, 4, null);
    }

    private final void V5(String str, String str2) {
        String strSubstring = str.substring(7);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        C11458d25 c11458d25R = C11458d25.r(Long.parseLong(strSubstring));
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.b.a().f(new C22034uZ1(c11458d25R, AbstractC20507s76.p(), str2));
    }

    private final byte[] W2() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 16) {
            int i4 = i3 + i;
            if (i2 % 2 == 0) {
                sb.append((char) (i + 33));
                sb.append(":");
                sb.append(i4);
            } else {
                sb.append((char) (i + 102));
                sb.append(Separators.QUESTION);
                sb.append((char) (i4 + 66));
            }
            i2++;
            i3 = i;
            i = i4;
        }
        String strSubstring = sb.substring(0, 31);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        byte[] bytes = strSubstring.getBytes(C12275eL0.b);
        AbstractC13042fc3.h(bytes, "getBytes(...)");
        return bytes;
    }

    private final String W5(String str) {
        return this.c.e("app.settings." + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 Z5(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "this$0");
        return new ir.nasim.core.modules.settings.a(settingsModule.b);
    }

    private final String s1(C11458d25 c11458d25) {
        if (c11458d25.s() == W25.a) {
            return "PRIVATE_" + c11458d25.getPeerId();
        }
        if (c11458d25.s() != W25.b) {
            C19406qI3.b("AbsModule", "getChatKey: peer is unknown! So return null");
            return null;
        }
        return "GROUP_" + c11458d25.getPeerId();
    }

    public final String A0() {
        return this.A4.a(this, V4[277]);
    }

    public final String A1() {
        return this.B4.a(this, V4[278]);
    }

    public final String A2() {
        return this.s3.a(this, V4[217]);
    }

    public final int A3() {
        return this.c1.a(this, V4[99]).intValue();
    }

    public final int A4() {
        return this.u.a(this, V4[13]).intValue();
    }

    public final boolean A5() {
        return this.I1.a(this, V4[129]).booleanValue();
    }

    public final void A6(boolean z) {
        this.u0.d(this, V4[65], z);
    }

    public final void A7(boolean z) {
        this.q0.d(this, V4[61], z);
    }

    public final int B0() {
        return this.Z.a(this, V4[44]).intValue();
    }

    public final int B1() {
        return this.g2.a(this, V4[153]).intValue();
    }

    public final int B2() {
        return this.t3.a(this, V4[218]).intValue();
    }

    public final String B3() {
        return this.Q4.a(this, V4[293]);
    }

    public final int B4() {
        return this.v.a(this, V4[14]).intValue();
    }

    public final boolean B5(InterfaceC4314Ep2 interfaceC4314Ep2) {
        AbstractC13042fc3.i(interfaceC4314Ep2, "feature");
        try {
            int i = this.h1.contains(interfaceC4314Ep2) ? 0 : Integer.MAX_VALUE;
            int i2 = getInt("app.android." + interfaceC4314Ep2.getValue(), i);
            if (this.g1 == 0) {
                String strR = AbstractC20507s76.r();
                AbstractC13042fc3.h(strR, "getVersion(...)");
                this.g1 = ZI2.b(strR);
            }
            return this.g1 >= i2;
        } catch (Exception e) {
            C19406qI3.j("AbsModule", "Crash on check flag, feature: " + interfaceC4314Ep2 + ", exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public final void B6(boolean z) {
        this.w0.d(this, V4[67], z);
    }

    public final void B7(boolean z) {
        this.o0.d(this, V4[59], z);
    }

    public final int C0() {
        return this.a0.a(this, V4[45]).intValue();
    }

    public final boolean C1() {
        return this.c2.a(this, V4[149]).booleanValue();
    }

    public final String C2() {
        return this.D1.a(this, V4[124]);
    }

    public final String C3() {
        return this.R4.a(this, V4[294]);
    }

    public final int C4() {
        return this.w.a(this, V4[15]).intValue();
    }

    public final boolean C5() {
        return this.k3.a(this, V4[209]).booleanValue();
    }

    public final void C6(int i) {
        this.D.d(this, V4[22], i);
    }

    public final void C7(boolean z) {
        this.p0.d(this, V4[60], z);
    }

    public final int D0() {
        return this.Y.a(this, V4[43]).intValue();
    }

    public final int D1() {
        return this.d2.a(this, V4[150]).intValue();
    }

    public final String D2() {
        return this.n0.a(this, V4[58]);
    }

    public final int D3() {
        return this.w1.a(this, V4[117]).intValue();
    }

    public final int D4() {
        return this.y.a(this, V4[17]).intValue();
    }

    public final boolean D5() {
        return this.M.a(this, V4[31]).booleanValue();
    }

    public final void D6(int i) {
        this.A.d(this, V4[19], i);
    }

    public final void D7(boolean z) {
        this.I.d(this, V4[27], z);
    }

    public final String E0() {
        return this.p4.a(this, V4[266]);
    }

    public final String E1() {
        return this.a2.a(this, V4[147]);
    }

    public final String E2() {
        return this.H.a(this, V4[26]);
    }

    public final long E3() {
        return this.N3.a(this, V4[238]).longValue();
    }

    public final String E4() {
        return this.u3.a(this, V4[219]);
    }

    public final boolean E5() {
        return this.K.a(this, V4[29]).booleanValue();
    }

    public final void E6(boolean z) {
        this.c2.d(this, V4[149], z);
    }

    public final void E7(boolean z) {
        this.s0.d(this, V4[63], z);
    }

    public final String F0() {
        return this.w2.a(this, V4[169]);
    }

    public final String F1() {
        return W5("dark.wallpaper.uri");
    }

    public final String F2() {
        return this.F.a(this, V4[24]);
    }

    public final long F3() {
        return this.M3.a(this, V4[237]).longValue();
    }

    public final String F4() {
        return this.q4.a(this, V4[267]);
    }

    public final boolean F5() {
        return this.f2.a(this, V4[152]).booleanValue();
    }

    public final void F6(int i) {
        this.d2.d(this, V4[150], i);
    }

    public final void F7(boolean z) {
        this.r0.d(this, V4[62], z);
    }

    public final String G0() {
        return this.o4.a(this, V4[265]);
    }

    public final String G1() {
        String string = getString("default_discover_filter", "ALL");
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String upperCase = string.toUpperCase(locale);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final String G2() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("keyCurrentVersion");
        return null;
    }

    public final boolean G3(long j) {
        List listM;
        List listM2 = new C20644sM5(",").m(getString("app.android.random_success_packet", ""), 0);
        if (listM2.isEmpty()) {
            listM = AbstractC10360bX0.m();
        } else {
            ListIterator listIterator = listM2.listIterator(listM2.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listM = AbstractC10360bX0.m();
        }
        String[] strArr = (String[]) listM.toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                arrayList.add(Long.valueOf(Long.parseLong(str)));
            } catch (NumberFormatException unused) {
                C19406qI3.j("AbsModule", "NumberFormat: Parsing failed! " + str + " can not be an integer", new Object[0]);
            }
        }
        return arrayList.contains(Long.valueOf(j)) || AbstractC13042fc3.d(getString("app.android.random_success_packet", ""), "all");
    }

    public final String G4() {
        return this.j0.a(this, V4[54]);
    }

    public final boolean G5() {
        return this.j3.a(this, V4[208]).booleanValue();
    }

    public final void G6(String str) {
        AbstractC13042fc3.i(str, "value");
        f("default_discover_filter", str);
    }

    public final void G7(int i) {
        this.J0.d(this, V4[80], i);
    }

    public final long H0() {
        return this.n4.a(this, V4[264]).longValue();
    }

    public final int H1(int i) {
        return getInt("app.android.default_tab.index", i);
    }

    public final String H2() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("keyLastVersion");
        return null;
    }

    public final int H3() {
        return this.J3.a(this, V4[234]).intValue();
    }

    public final int H4() {
        return this.F0.a(this, V4[76]).intValue();
    }

    public final boolean H5(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        String strS1 = s1(c11458d25);
        if (strS1 == null) {
            return false;
        }
        return getBoolean("category.all.notification.chat." + strS1 + ".enabled", true);
    }

    public final void H6(int i) {
        e("app.android.default_tab.index", i);
    }

    public final void H7(boolean z) {
        this.y0.d(this, V4[69], z);
    }

    public final boolean I(long j) {
        Q12.a aVar = Q12.b;
        return System.currentTimeMillis() - j <= getLong("message.edit.time.length", Q12.A(T12.s(1, W12.h)));
    }

    public final String I0() {
        return this.z1.a(this, V4[120]);
    }

    public final int I1() {
        return this.F1.a(this, V4[126]).intValue();
    }

    public final String I2() {
        return this.V2.a(this, V4[194]);
    }

    public final int I3() {
        return this.v2.a(this, V4[168]).intValue();
    }

    public final XV4 I4() {
        return new XV4(Float.valueOf(getFloat("app.android.viewer_horizontal_touch_slop", 1.0f)), Float.valueOf(getFloat("app.android.viewer_vertical_touch_slop", 1.25f)));
    }

    public final boolean I5() {
        return this.t.a(this, V4[12]).booleanValue();
    }

    public final void I6(boolean z) {
        this.l2.d(this, V4[158], z);
    }

    public final void I7(int i) {
        this.Q0.d(this, V4[87], i);
    }

    public final boolean J() {
        int i = getInt("enable.notification.dialog", 0);
        if (i >= 3) {
            return false;
        }
        e("enable.notification.dialog", i + 1);
        return true;
    }

    public final String J0() {
        return this.m3.a(this, V4[211]);
    }

    public final boolean J1() {
        return this.l2.a(this, V4[158]).booleanValue();
    }

    public final String J2() {
        return this.h3.a(this, V4[206]);
    }

    public final int J3() {
        return this.f3.a(this, V4[204]).intValue();
    }

    public final String J4() {
        return this.Y3.a(this, V4[249]);
    }

    public final boolean J5() {
        return this.L.a(this, V4[30]).booleanValue();
    }

    public final void J6(int i) {
        this.k2.d(this, V4[157], i);
    }

    public final void J7(boolean z) {
        this.t0.d(this, V4[64], z);
    }

    public final boolean K() {
        return getInt("app.android.low_storage_dialog_count", 0) < 3;
    }

    public final String K0() {
        return this.z4.a(this, V4[276]);
    }

    public final String K1() {
        return this.j2.a(this, V4[156]);
    }

    public final int K2() {
        return this.Q3.a(this, V4[241]).intValue();
    }

    public final long K3() {
        return this.O3.a(this, V4[239]).longValue();
    }

    public final long K4() {
        return this.M4.a(this, V4[289]).longValue();
    }

    public final boolean K5() {
        return this.v3.a(this, V4[220]).booleanValue();
    }

    public final void K6(boolean z) {
        this.g0.d(this, V4[51], z);
    }

    public final void K7(boolean z) {
        this.A0.d(this, V4[71], z);
    }

    public final void L(String str) {
        AbstractC13042fc3.i(str, "value");
        f("app.android.key_analysis_report.dialog", str);
    }

    public final String L0() {
        return this.x4.a(this, V4[274]);
    }

    public final int L1() {
        return this.k2.a(this, V4[157]).intValue();
    }

    public final String L2() {
        return this.m0.a(this, V4[57]);
    }

    public final long L3() {
        return this.t1.a(this, V4[114]).longValue();
    }

    public final String L4() {
        return this.O4.a(this, V4[291]);
    }

    public final boolean L5() {
        return this.J.a(this, V4[28]).booleanValue();
    }

    public final void L6(boolean z) {
        this.d0.d(this, V4[48], z);
    }

    public final void L7(boolean z) {
        this.B0.d(this, V4[72], z);
    }

    public final void M(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        String strS1 = s1(c11458d25);
        if (strS1 == null) {
            return;
        }
        h("category.call.notification.sound.chat." + strS1 + ".enabled", z);
    }

    public final int M0() {
        return this.m4.a(this, V4[263]).intValue();
    }

    public final int M1() {
        return this.O1.a(this, V4[135]).intValue();
    }

    public final long M2() {
        return this.E.a(this, V4[23]).longValue();
    }

    public final boolean M3() {
        return this.H3.a(this, V4[232]).booleanValue();
    }

    public final long M4() {
        return this.N4.a(this, V4[290]).longValue();
    }

    public final boolean M5() {
        return this.h0.a(this, V4[52]).booleanValue();
    }

    public final void M6(boolean z) {
        this.e0.d(this, V4[49], z);
    }

    public final void M7(boolean z) {
        this.I3.d(this, V4[233], z);
    }

    public final void N(String str) {
        AbstractC13042fc3.i(str, "uri");
        Q("dark.wallpaper.uri", str);
    }

    public final String N0() {
        return this.D4.a(this, V4[280]);
    }

    public final int N1() {
        return this.N1.a(this, V4[134]).intValue();
    }

    public final long N2() {
        return this.B.a(this, V4[20]).longValue();
    }

    public final boolean N3() {
        return this.G3.a(this, V4[231]).booleanValue();
    }

    public final boolean N4() {
        return this.b2.a(this, V4[148]).booleanValue();
    }

    public final boolean N5() {
        return this.I.a(this, V4[27]).booleanValue();
    }

    public final void N6(boolean z) {
        this.f0.d(this, V4[50], z);
    }

    public final void N7(boolean z) {
        this.i3.d(this, V4[207], z);
    }

    public final void O(String str) {
        AbstractC13042fc3.i(str, "uri");
        Q("wallpaper.uri", str);
    }

    public final byte[] O0(String str) {
        AbstractC13042fc3.i(str, "key");
        return this.c.b("app.settings." + str);
    }

    public final int O1() {
        return this.E0.a(this, V4[75]).intValue();
    }

    public final long O2() {
        return this.C.a(this, V4[21]).longValue();
    }

    public final int O3() {
        return this.H0.a(this, V4[78]).intValue();
    }

    public final String O4() {
        return this.i0.a(this, V4[53]);
    }

    public final boolean O5() {
        return this.t0.a(this, V4[64]).booleanValue();
    }

    public final void O6(boolean z) {
        this.I1.d(this, V4[129], z);
    }

    public final void O7(String str) {
        AbstractC13042fc3.i(str, ParameterNames.VERSION);
        String string = getString(G2(), "first");
        if (AbstractC13042fc3.d(string, str)) {
            return;
        }
        Q(H2(), string);
        Q(G2(), str);
    }

    public final void P(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        String strS1 = s1(c11458d25);
        if (strS1 == null) {
            return;
        }
        h("category.all.notification.chat." + strS1 + ".enabled", z);
    }

    public final String P0() {
        return this.f4.a(this, V4[256]);
    }

    public final String P1() {
        return this.J4.a(this, V4[286]);
    }

    public final boolean P2(long j) {
        List listM;
        List listM2 = new C20644sM5(",").m(getString("app.android.later_send_to_wallet", ""), 0);
        if (listM2.isEmpty()) {
            listM = AbstractC10360bX0.m();
        } else {
            ListIterator listIterator = listM2.listIterator(listM2.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listM = AbstractC10360bX0.m();
        }
        String[] strArr = (String[]) listM.toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                arrayList.add(Long.valueOf(Long.parseLong(str)));
            } catch (NumberFormatException unused) {
                C19406qI3.j("NumberFormat", "Parsing failed! " + str + " can not be an integer", new Object[0]);
            }
        }
        return arrayList.contains(Long.valueOf(j)) || AbstractC13042fc3.d(getString("app.android.random_success_packet", ""), "all");
    }

    public final int P3() {
        return this.I0.a(this, V4[79]).intValue();
    }

    public final String P4() {
        return this.H4.a(this, V4[284]);
    }

    public final boolean P5() {
        return this.i3.a(this, V4[207]).booleanValue();
    }

    public final void P6(int i) {
        this.Z2.d(this, V4[198], i);
    }

    public final void P7(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.Y3.b(this, V4[249], str);
    }

    public final CallRemoteConfig Q0() {
        try {
            return (CallRemoteConfig) new KS2().k(W5("graham.call.configs"), CallRemoteConfig.class);
        } catch (Exception e) {
            C19406qI3.c("AbsModule", "getCallConfig", e);
            return null;
        }
    }

    public final String Q1() {
        return this.C1.a(this, V4[123]);
    }

    public final String Q2() {
        return W5("wallpaper.uri");
    }

    public final String Q3() {
        return this.e4.a(this, V4[255]);
    }

    public final String Q4() {
        return this.L2.a(this, V4[184]);
    }

    public final void Q6(boolean z) {
        this.k3.d(this, V4[209], z);
    }

    public final void Q7(boolean z) {
        this.b2.d(this, V4[148], z);
    }

    public final String R() {
        return this.K4.a(this, V4[287]);
    }

    public final int R0() {
        return this.g3.a(this, V4[205]).intValue();
    }

    public final int R1() {
        return this.n.a(this, V4[6]).intValue();
    }

    public final String R2() {
        return this.z.a(this, V4[18]);
    }

    public final int R3() {
        return this.p3.a(this, V4[214]).intValue();
    }

    public final String R4() {
        return this.K2.a(this, V4[183]);
    }

    public final void R5() {
        e("app.android.low_storage_dialog_count", getInt("app.android.low_storage_dialog_count", 0) + 1);
    }

    public final void R6(boolean z) {
        this.P4.d(this, V4[292], z);
    }

    public final boolean R7() {
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        return ZI2.b(strR) < ZI2.b(j2()) && Build.VERSION.SDK_INT >= 26;
    }

    public final Map S() {
        String string = getString("ad_discount_promotion_channel_member_count_range", "200-1999|2000-5000");
        List listN0 = AbstractC20762sZ6.N0((CharSequence) AbstractC20762sZ6.N0(string, new String[]{"|"}, false, 0, 6, null).get(0), new String[]{"-"}, false, 0, 6, null);
        C24411ya3 c24411ya3 = new C24411ya3(Integer.parseInt((String) listN0.get(0)), Integer.parseInt((String) listN0.get(1)));
        List listN02 = AbstractC20762sZ6.N0((CharSequence) AbstractC20762sZ6.N0(string, new String[]{"|"}, false, 0, 6, null).get(1), new String[]{"-"}, false, 0, 6, null);
        C24411ya3 c24411ya32 = new C24411ya3(Integer.parseInt((String) listN02.get(0)), Integer.parseInt((String) listN02.get(1)));
        return AbstractC20051rO3.n(AbstractC4616Fw7.a("total_range", new C24411ya3(c24411ya3.o(), c24411ya32.t())), AbstractC4616Fw7.a("low_member_range", c24411ya3), AbstractC4616Fw7.a("medium_member_range", c24411ya32));
    }

    public final String S0() {
        return this.l0.a(this, V4[56]);
    }

    public final int S1() {
        return this.m.a(this, V4[5]).intValue();
    }

    public final String S2() {
        return this.u4.a(this, V4[271]);
    }

    public final int S3() {
        return this.T3.a(this, V4[244]).intValue();
    }

    public final String S4() {
        return this.J2.a(this, V4[182]);
    }

    public final void S5(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        if (str2 == null) {
            C19406qI3.j("AbsModule", "onUpdatedSetting: value is null!, key = " + str, new Object[0]);
            return;
        }
        if (AbstractC13042fc3.d(str, "dns_server_addresses")) {
            this.b.c().putString(str, str2);
        }
        this.c.putString("app.settings." + str, str2);
        if (AbstractC20762sZ6.X(str, "drafts_", false, 2, null)) {
            V5(str, str2);
        }
        if (AbstractC20762sZ6.X(str, "category.all.notification.chat.", false, 2, null)) {
            U5(str, str2);
        }
    }

    public final void S6(boolean z) {
        this.F3.d(this, V4[230], z);
    }

    public final boolean S7() {
        int i = getInt("update_wallet_last_version", 9110);
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        return ZI2.b(strR) < i;
    }

    public final Map T() {
        try {
            Object objL = new KS2().l(getString("ad_discount_promotion_interacted_channels", "{\"tooltip_interacted_channels\":[-1],\"notice_bar_interacted_channels\":[-1]}"), new TypeToken<Map<String, List<Integer>>>() { // from class: ir.nasim.core.modules.settings.SettingsModule$adDiscountPromotionInteractedChannels$1
            }.d());
            AbstractC13042fc3.h(objL, "fromJson(...)");
            return (Map) objL;
        } catch (Exception unused) {
            return new LinkedHashMap();
        }
    }

    public final long T0() {
        return this.K1.a(this, V4[131]).longValue();
    }

    public final int T1() {
        return this.o.a(this, V4[7]).intValue();
    }

    public final long T2() {
        return this.t2.a(this, V4[166]).longValue();
    }

    public final long T3() {
        return this.a4.a(this, V4[251]).longValue();
    }

    public final String T4() {
        return this.D2.a(this, V4[176]);
    }

    public final void T5(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        if (str2 != null) {
            C8386Vt0.a.E3(str, str2);
            S5(str, str2);
        } else {
            C19406qI3.j("AbsModule", "onUpdatedSettingFromServer: value is null!, key = " + str, new Object[0]);
        }
    }

    public final void T6(boolean z) {
        this.M.d(this, V4[31], z);
    }

    public final String U() {
        return this.R1.a(this, V4[138]);
    }

    public final int U0() {
        return this.J1.a(this, V4[130]).intValue();
    }

    public final int U1() {
        return this.p.a(this, V4[8]).intValue();
    }

    public final long U2() {
        return this.u2.a(this, V4[167]).longValue();
    }

    public final long U3() {
        return this.r4.a(this, V4[268]).longValue();
    }

    public final String U4() {
        return this.G2.a(this, V4[179]);
    }

    public final void U5(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "value");
        C11458d25 c11458d25E = null;
        if (AbstractC20153rZ6.S(str, "category.all.notification.chat.", false, 2, null)) {
            String strC0 = AbstractC20762sZ6.C0(str, "category.all.notification.chat.");
            if (AbstractC20153rZ6.C(strC0, ".enabled", false, 2, null)) {
                String strE0 = AbstractC20762sZ6.E0(strC0, ".enabled");
                boolean z = Boolean.parseBoolean(str2);
                List listM0 = AbstractC20762sZ6.M0(strE0, new char[]{'_'}, false, 2, 2, null);
                if (listM0.size() != 2) {
                    return;
                }
                String str3 = (String) listM0.get(0);
                Integer numO = AbstractC19562qZ6.o((String) listM0.get(1));
                if (numO != null) {
                    int iIntValue = numO.intValue();
                    if (AbstractC13042fc3.d(str3, "GROUP")) {
                        c11458d25E = C11458d25.y(iIntValue);
                    } else if (AbstractC13042fc3.d(str3, "PRIVATE")) {
                        c11458d25E = C11458d25.E(iIntValue);
                    }
                    if (c11458d25E == null) {
                        return;
                    }
                    ((HS1) I22.a(C5721Ko.a.d(), HS1.class)).q().M(c11458d25E.u(), z);
                }
            }
        }
    }

    public final void U6(boolean z) {
        this.v0.d(this, V4[66], z);
    }

    public final String V() {
        return this.U1.a(this, V4[141]);
    }

    public final int V0() {
        return j3();
    }

    public final long V1() {
        return this.q.a(this, V4[9]).longValue();
    }

    public final String V2() {
        return (String) this.g.getValue();
    }

    public final boolean V3() {
        return this.b4.a(this, V4[252]).booleanValue();
    }

    public final String V4() {
        return this.H2.a(this, V4[180]);
    }

    public final void V6(boolean z) {
        this.x0.d(this, V4[68], z);
    }

    public final String W() {
        return this.Q1.a(this, V4[137]);
    }

    public final String W0() {
        return this.j4.a(this, V4[260]);
    }

    public final String W1() {
        return this.Y0.a(this, V4[95]);
    }

    public final long W3() {
        return this.c4.a(this, V4[253]).longValue();
    }

    public final String W4() {
        return this.F2.a(this, V4[178]);
    }

    public final void W6(boolean z) {
        this.z0.d(this, V4[70], z);
    }

    public final String X() {
        return this.T1.a(this, V4[140]);
    }

    public final String X0() {
        return this.l4.a(this, V4[262]);
    }

    public final long X1() {
        return this.h.a(this, V4[0]).longValue();
    }

    public final int X2() {
        return this.i.a(this, V4[1]).intValue();
    }

    public final int X3() {
        return this.Z3.a(this, V4[250]).intValue();
    }

    public final String X4() {
        return this.B2.a(this, V4[174]);
    }

    public final void X5() {
        e("enable.notification.dialog", 0);
    }

    public final void X6(boolean z) {
        this.k0.d(this, V4[55], z);
    }

    public final String Y() {
        return this.S1.a(this, V4[139]);
    }

    public final String Y0() {
        return this.k4.a(this, V4[261]);
    }

    public final int Y1() {
        return this.Z2.a(this, V4[198]).intValue();
    }

    public final String Y2() {
        return this.x3.a(this, V4[222]);
    }

    public final int Y3() {
        return this.b3.a(this, V4[200]).intValue();
    }

    public final String Y4() {
        return this.z2.a(this, V4[172]);
    }

    public final void Y5() {
        long jD = this.b.s().F().d();
        this.e = "category.android." + jD + ".current_version";
        this.f = "category.android." + jD + ".last_version";
        G();
        E();
        this.d = C12736f7.n().d("actor/settings", new V6() { // from class: ir.nasim.kw6
            @Override // ir.nasim.V6
            public final K6 create() {
                return SettingsModule.Z5(this.a);
            }
        });
    }

    public final void Y6(int i) {
        this.W1.d(this, V4[143], i);
    }

    public final String Z() {
        return this.V1.a(this, V4[142]);
    }

    public final long Z0() {
        return this.P3.a(this, V4[240]).longValue();
    }

    public final int Z1() {
        return this.l.a(this, V4[4]).intValue();
    }

    public final int Z2() {
        return this.A3.a(this, V4[225]).intValue();
    }

    public final String Z3() {
        return this.e3.a(this, V4[203]);
    }

    public final String Z4() {
        return this.I2.a(this, V4[181]);
    }

    public final void Z6(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.n0.b(this, V4[58], str);
    }

    public final String a0() {
        return this.t4.a(this, V4[270]);
    }

    public final String a1() {
        return this.i2.a(this, V4[155]);
    }

    public final int a2() {
        return this.X2.a(this, V4[196]).intValue();
    }

    public final int a3() {
        return this.B3.a(this, V4[226]).intValue();
    }

    public final int a4() {
        return this.c3.a(this, V4[201]).intValue();
    }

    public final String a5() {
        return this.x2.a(this, V4[170]);
    }

    public final void a6(Map map) {
        AbstractC13042fc3.i(map, "value");
        String strT = new KS2().t(map);
        AbstractC13042fc3.h(strT, "toJson(...)");
        f("ad_discount_promotion_interacted_channels", strT);
    }

    public final void a7(boolean z) {
        this.K.d(this, V4[29], z);
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public void b(String str, long j) {
        AbstractC13042fc3.i(str, "key");
        Q(str, String.valueOf(j));
    }

    public final int b0() {
        return this.K0.a(this, V4[81]).intValue();
    }

    public final String b1() {
        return this.P2.a(this, V4[188]);
    }

    public final String b2() {
        return this.W2.a(this, V4[195]);
    }

    public final int b3() {
        return this.y3.a(this, V4[223]).intValue();
    }

    public final long b4() {
        return this.d3.a(this, V4[202]).longValue();
    }

    public final String b5() {
        return this.y2.a(this, V4[171]);
    }

    public final void b6(int i) {
        this.K0.d(this, V4[81], i);
    }

    public final void b7(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.h3.b(this, V4[206], str);
    }

    public final int c0() {
        return this.O2.a(this, V4[187]).intValue();
    }

    public final int c1() {
        return this.R2.a(this, V4[190]).intValue();
    }

    public final boolean c2() {
        return this.P4.a(this, V4[292]).booleanValue();
    }

    public final int c3() {
        return this.z3.a(this, V4[224]).intValue();
    }

    public final int c4() {
        return this.q1.a(this, V4[111]).intValue();
    }

    public final String c5() {
        return this.C2.a(this, V4[175]);
    }

    public final void c6(boolean z) {
        this.l3.d(this, V4[210], z);
    }

    public final void c7(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.m0.b(this, V4[57], str);
    }

    public final int d0() {
        return this.N2.a(this, V4[186]).intValue();
    }

    public final String d1() {
        return this.W0.a(this, V4[93]);
    }

    public final String d2() {
        return this.E4.a(this, V4[281]);
    }

    public final String d3() {
        return this.G.a(this, V4[25]);
    }

    public final boolean d4() {
        return this.q0.a(this, V4[61]).booleanValue();
    }

    public final String d5() {
        return this.E2.a(this, V4[177]);
    }

    public final void d6(boolean z) {
        this.p1.d(this, V4[110], z);
    }

    public final void d7(long j) {
        this.E.d(this, V4[23], j);
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public void e(String str, int i) {
        AbstractC13042fc3.i(str, "key");
        Q(str, String.valueOf(i));
    }

    public final int e0() {
        return this.M2.a(this, V4[185]).intValue();
    }

    public final String e1() {
        return this.U2.a(this, V4[193]);
    }

    public final long e2() {
        return this.G0.a(this, V4[77]).longValue();
    }

    public final String e3() {
        return this.w3.a(this, V4[221]);
    }

    public final boolean e4() {
        return this.o0.a(this, V4[59]).booleanValue();
    }

    public final String e5() {
        return this.A2.a(this, V4[173]);
    }

    public final void e6(boolean z) {
        this.m2.d(this, V4[159], z);
    }

    public final void e7(long j) {
        this.B.d(this, V4[20], j);
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public void f(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "value");
        Q(str, str2);
    }

    public final String f0() {
        return this.P1.a(this, V4[136]);
    }

    public final ChangeLogData f1() {
        try {
            return (ChangeLogData) new KS2().k(getString("android.change_log", ""), ChangeLogData.class);
        } catch (Exception e) {
            C19406qI3.c("AbsModule", "getChangeLog", e);
            return null;
        }
    }

    public final long f2() {
        return this.D3.a(this, V4[228]).longValue();
    }

    public final int f3() {
        return this.a3.a(this, V4[199]).intValue();
    }

    public final boolean f4() {
        return this.p0.a(this, V4[60]).booleanValue();
    }

    public final boolean f5(int i) {
        return getBoolean("app.android.add_member_show_in_chat_" + i, false);
    }

    public final void f6(boolean z) {
        this.d1.d(this, V4[100], z);
    }

    public final void f7(long j) {
        this.C.d(this, V4[21], j);
    }

    public final long g0() {
        return this.F4.a(this, V4[282]).longValue();
    }

    public final int g1() {
        return this.u1.a(this, V4[115]).intValue();
    }

    public final boolean g2() {
        return this.F3.a(this, V4[230]).booleanValue();
    }

    public final int g3() {
        return this.s4.a(this, V4[269]).intValue();
    }

    public final boolean g4() {
        return this.r0.a(this, V4[62]).booleanValue();
    }

    public final boolean g5() {
        return this.l3.a(this, V4[210]).booleanValue();
    }

    public final void g6(boolean z) {
        this.V0.d(this, V4[92], z);
    }

    public final void g7(boolean z) {
        this.f2.d(this, V4[152], z);
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public boolean getBoolean(String str, boolean z) {
        AbstractC13042fc3.i(str, "key");
        String strW5 = W5(str);
        if (AbstractC13042fc3.d(strW5, "true")) {
            return true;
        }
        if (AbstractC13042fc3.d(strW5, "false")) {
            return false;
        }
        return z;
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public float getFloat(String str, float f) {
        AbstractC13042fc3.i(str, "key");
        String strW5 = W5(str);
        if (strW5 != null) {
            try {
                return Float.parseFloat(strW5);
            } catch (NumberFormatException unused) {
                C19406qI3.b("AbsModule", "Can not parse to float, key: " + str + ", value: " + strW5);
            } catch (Throwable th) {
                C19406qI3.d("AbsModule", th);
            }
        }
        return f;
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public int getInt(String str, int i) {
        AbstractC13042fc3.i(str, "key");
        String strW5 = W5(str);
        if (strW5 != null) {
            try {
                return Integer.parseInt(strW5);
            } catch (NumberFormatException unused) {
                C19406qI3.b("AbsModule", "Can not parse to int, key: " + str);
            } catch (Exception e) {
                C19406qI3.d("AbsModule", e);
            }
        }
        return i;
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public long getLong(String str, long j) {
        AbstractC13042fc3.i(str, "key");
        String strW5 = W5(str);
        if (strW5 != null) {
            try {
                return Long.parseLong(strW5);
            } catch (NumberFormatException unused) {
                C19406qI3.b("AbsModule", "Can not parse to long, key: " + str + ", so return default value.");
            } catch (Exception e) {
                C19406qI3.d("AbsModule", e);
            }
        }
        return j;
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public String getString(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "defaultValue");
        String strW5 = W5(str);
        return strW5 == null ? str2 : strW5;
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public void h(String str, boolean z) {
        AbstractC13042fc3.i(str, "key");
        Q(str, z ? "true" : "false");
    }

    public final long h0() {
        return this.G4.a(this, V4[283]).longValue();
    }

    public final int h1() {
        return this.o2.a(this, V4[161]).intValue();
    }

    public final long h2() {
        return this.E3.a(this, V4[229]).longValue();
    }

    public final float h3() {
        return Float.parseFloat(getString("messaging.maximum_file_upload_size.megabyte", "100"));
    }

    public final String h4() {
        return this.R3.a(this, V4[242]);
    }

    public final boolean h5() {
        return this.d1.a(this, V4[100]).booleanValue();
    }

    public final void h6(int i) {
        this.Z.d(this, V4[44], i);
    }

    public final void h7(boolean z) {
        this.j3.d(this, V4[208], z);
    }

    @Override // ir.nasim.InterfaceC9824ad1
    public void i(String str, float f) {
        AbstractC13042fc3.i(str, "key");
        Q(str, String.valueOf(f));
    }

    public final String i0() {
        return this.I4.a(this, V4[285]);
    }

    public final long i1() {
        return this.q2.a(this, V4[163]).longValue();
    }

    public final int i2() {
        return this.d4.a(this, V4[254]).intValue();
    }

    public final int i3() {
        return this.b0.a(this, V4[46]).intValue();
    }

    public final int i4() {
        return this.J0.a(this, V4[80]).intValue();
    }

    public final boolean i5() {
        return this.V0.a(this, V4[92]).booleanValue();
    }

    public final void i6(boolean z) {
        this.W.d(this, V4[41], z);
    }

    public final void i7(boolean z) {
        this.o3.d(this, V4[213], z);
    }

    public final int j0() {
        return this.s1.a(this, V4[113]).intValue();
    }

    public final long j1() {
        return this.p2.a(this, V4[162]).longValue();
    }

    public final String j2() {
        return this.Y2.a(this, V4[197]);
    }

    public final int j3() {
        return this.X0.a(this, V4[94]).intValue();
    }

    public final String j4() {
        return this.D0.a(this, V4[74]);
    }

    public final boolean j5() {
        return this.W.a(this, V4[41]).booleanValue();
    }

    public final void j6(boolean z) {
        this.X.d(this, V4[42], z);
    }

    public final void j7(int i) {
        this.q3.d(this, V4[215], i);
    }

    public final String k0() {
        return this.X3.a(this, V4[248]);
    }

    public final boolean k1() {
        return this.n2.a(this, V4[160]).booleanValue();
    }

    public final long k2() {
        return this.P0.a(this, V4[86]).longValue();
    }

    public final int k3() {
        return this.G1.a(this, V4[127]).intValue();
    }

    public final boolean k4() {
        return this.y0.a(this, V4[69]).booleanValue();
    }

    public final boolean k5() {
        return this.X.a(this, V4[42]).booleanValue();
    }

    public final void k6(boolean z) {
        this.T.d(this, V4[38], z);
    }

    public final void k7(boolean z) {
        this.e2.d(this, V4[151], z);
    }

    public final String l0() {
        return this.U3.a(this, V4[245]);
    }

    public final boolean l1() {
        return this.r2.a(this, V4[164]).booleanValue();
    }

    public final String l2() {
        return this.y4.a(this, V4[275]);
    }

    public final int l3() {
        return this.T0.a(this, V4[90]).intValue();
    }

    public final String l4() {
        return this.C0.a(this, V4[73]);
    }

    public final boolean l5() {
        return this.T.a(this, V4[38]).booleanValue();
    }

    public final void l6(boolean z) {
        this.U.d(this, V4[39], z);
    }

    public final void l7(boolean z) {
        this.t.d(this, V4[12], z);
    }

    public final AnalysisData m0() {
        try {
            return (AnalysisData) new KS2().k(getString("app.android.key_analysis_report", "{\"text\":\"\",\"command\":\"\",\"timeInMS\":0}"), AnalysisData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final int m1() {
        return this.s2.a(this, V4[165]).intValue();
    }

    public final long m2() {
        return this.V3.a(this, V4[246]).longValue();
    }

    public final int m3() {
        return this.U0.a(this, V4[91]).intValue();
    }

    public final int m4() {
        return this.R0.a(this, V4[88]).intValue();
    }

    public final boolean m5() {
        return this.U.a(this, V4[39]).booleanValue();
    }

    public final void m6(boolean z) {
        this.V.d(this, V4[40], z);
    }

    public final void m7(int i) {
        this.c1.d(this, V4[99], i);
    }

    public final AnalysisDialogData n0() {
        try {
            return (AnalysisDialogData) new KS2().k(getString("app.android.key_analysis_report.dialog", "{\"title\":\"\",\"description\":\"\"}"), AnalysisDialogData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String n1() {
        return this.y1.a(this, V4[119]);
    }

    public final String n2() {
        return this.w4.a(this, V4[273]);
    }

    public final String n3() {
        return this.e1.a(this, V4[101]);
    }

    public final int n4() {
        return this.L0.a(this, V4[82]).intValue();
    }

    public final boolean n5() {
        return this.V.a(this, V4[40]).booleanValue();
    }

    public final void n6(boolean z) {
        this.R.d(this, V4[36], z);
    }

    public final void n7(boolean z) {
        this.L.d(this, V4[30], z);
    }

    public final boolean o0() {
        return this.p1.a(this, V4[110]).booleanValue();
    }

    public final boolean o1() {
        return this.u0.a(this, V4[65]).booleanValue();
    }

    public final String o2() {
        return this.W3.a(this, V4[247]);
    }

    public final String o3() {
        return this.f1.a(this, V4[102]);
    }

    public final int o4() {
        return this.Q0.a(this, V4[87]).intValue();
    }

    public final boolean o5() {
        return this.R.a(this, V4[36]).booleanValue();
    }

    public final void o6(boolean z) {
        this.S.d(this, V4[37], z);
    }

    public final void o7(int i) {
        this.f3.d(this, V4[204], i);
    }

    public final String p0() {
        return this.l1.a(this, V4[106]);
    }

    public final boolean p1() {
        return this.w0.a(this, V4[67]).booleanValue();
    }

    public final int p2() {
        return this.v1.a(this, V4[116]).intValue();
    }

    public final C22279uy0 p3() {
        String strW5 = W5("graham.call.configs.android");
        KS2 ks2 = new KS2();
        try {
            C19406qI3.a("AbsModule", "the resource is " + strW5, new Object[0]);
            Object objL = ks2.l(strW5, new TypeToken<Map<Long, ? extends K26>>() { // from class: ir.nasim.core.modules.settings.SettingsModule$newCallConfig$type$1
            }.d());
            AbstractC13042fc3.h(objL, "fromJson(...)");
            return new C22279uy0((Map) objL);
        } catch (Exception e) {
            C19406qI3.c("AbsModule", "getCallConfig", e);
            return null;
        }
    }

    public final boolean p4() {
        return this.A0.a(this, V4[71]).booleanValue();
    }

    public final boolean p5() {
        return this.S.a(this, V4[37]).booleanValue();
    }

    public final void p6(boolean z) {
        this.O.d(this, V4[33], z);
    }

    public final void p7(boolean z) {
        this.v3.d(this, V4[220], z);
    }

    public final String q0() {
        return this.o1.a(this, V4[109]);
    }

    public final String q1() {
        return this.n3.a(this, V4[212]);
    }

    public final int q2() {
        return this.C3.a(this, V4[227]).intValue();
    }

    public final int q3() {
        return this.r1.a(this, V4[112]).intValue();
    }

    public final boolean q4() {
        return this.B0.a(this, V4[72]).booleanValue();
    }

    public final boolean q5() {
        return this.O.a(this, V4[33]).booleanValue();
    }

    public final void q6(boolean z) {
        this.P.d(this, V4[34], z);
    }

    public final void q7(boolean z) {
        this.J.d(this, V4[28], z);
    }

    public final String r0() {
        return this.m1.a(this, V4[107]);
    }

    public final String r1() {
        return this.S2.a(this, V4[191]);
    }

    public final boolean r2() {
        return this.v0.a(this, V4[66]).booleanValue();
    }

    public final int r3() {
        return this.L1.a(this, V4[132]).intValue();
    }

    public final boolean r4() {
        return this.I3.a(this, V4[233]).booleanValue();
    }

    public final boolean r5() {
        return this.P.a(this, V4[34]).booleanValue();
    }

    public final void r6(boolean z) {
        this.Q.d(this, V4[35], z);
    }

    public final void r7(int i, boolean z) {
        h("app.android.add_member_show_in_chat_" + i, z);
    }

    public final String s0() {
        return this.n1.a(this, V4[108]);
    }

    public final boolean s2() {
        return this.x0.a(this, V4[68]).booleanValue();
    }

    public final boolean s3() {
        return this.o3.a(this, V4[213]).booleanValue();
    }

    public final String s4() {
        return this.S0.a(this, V4[89]);
    }

    public final boolean s5() {
        return this.Q.a(this, V4[35]).booleanValue();
    }

    public final void s6(int i) {
        this.g3.d(this, V4[205], i);
    }

    public final void s7(boolean z) {
        this.H3.d(this, V4[232], z);
    }

    public final String t0() {
        return this.k1.a(this, V4[105]);
    }

    public final long t1() {
        return this.K3.a(this, V4[235]).longValue();
    }

    public final boolean t2() {
        return this.z0.a(this, V4[70]).booleanValue();
    }

    public final int t3() {
        return this.q3.a(this, V4[215]).intValue();
    }

    public final int t4() {
        return this.S4.a(this, V4[295]).intValue();
    }

    public final boolean t5(Y50 y50, Z50 z50) {
        AbstractC13042fc3.i(y50, "bankName");
        AbstractC13042fc3.i(z50, "bankOperationType");
        return getBoolean("bank." + z50.getValue() + ".bank_name." + y50, Z50.j(y50, z50));
    }

    public final void t6(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.l0.b(this, V4[56], str);
    }

    public final void t7(boolean z) {
        this.G3.d(this, V4[231], z);
    }

    public final boolean u0() {
        return this.m2.a(this, V4[159]).booleanValue();
    }

    public final int u1() {
        return this.L3.a(this, V4[236]).intValue();
    }

    public final boolean u2() {
        return this.k0.a(this, V4[55]).booleanValue();
    }

    public final String u3() {
        return this.M1.a(this, V4[133]);
    }

    public final String u4() {
        return this.T4.a(this, V4[296]);
    }

    public final boolean u5(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        String strS1 = s1(c11458d25);
        if (strS1 == null) {
            return false;
        }
        return getBoolean("category.call.notification.sound.chat." + strS1 + ".enabled", true);
    }

    public final void u6(long j) {
        this.K1.d(this, V4[131], j);
    }

    public final void u7(boolean z) {
        this.h0.d(this, V4[52], z);
    }

    public final String v0() {
        return this.Z0.a(this, V4[96]);
    }

    public final int v1() {
        return this.r3.a(this, V4[216]).intValue();
    }

    public final int v2() {
        return this.X1.a(this, V4[144]).intValue();
    }

    public final boolean v3() {
        return this.e2.a(this, V4[151]).booleanValue();
    }

    public final String v4() {
        return this.S3.a(this, V4[243]);
    }

    public final boolean v5() {
        return this.c0.a(this, V4[47]).booleanValue();
    }

    public final void v6(int i) {
        this.J1.d(this, V4[130], i);
    }

    public final void v7(int i) {
        this.p3.d(this, V4[214], i);
    }

    public final String w0() {
        return this.a1.a(this, V4[97]);
    }

    public final int w1() {
        return this.D.a(this, V4[22]).intValue();
    }

    public final String w2() {
        return this.Z1.a(this, V4[146]);
    }

    public final String w3() {
        return this.i4.a(this, V4[259]);
    }

    public final String w4() {
        return this.x1.a(this, V4[118]);
    }

    public final boolean w5() {
        return this.g0.a(this, V4[51]).booleanValue();
    }

    public final void w6(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.W0.b(this, V4[93], str);
    }

    public final void w7(int i) {
        this.T3.d(this, V4[244], i);
    }

    public final String x0() {
        return this.b1.a(this, V4[98]);
    }

    public final int x1() {
        return this.E1.a(this, V4[125]).intValue();
    }

    public final int x2() {
        return this.Y1.a(this, V4[145]).intValue();
    }

    public final String x3() {
        return this.h4.a(this, V4[258]);
    }

    public final String x4() {
        return this.T2.a(this, V4[192]);
    }

    public final boolean x5() {
        return this.d0.a(this, V4[48]).booleanValue();
    }

    public final void x6(boolean z) {
        this.n2.d(this, V4[160], z);
    }

    public final void x7(int i) {
        this.Z3.d(this, V4[250], i);
    }

    public final String y0() {
        return this.C4.a(this, V4[279]);
    }

    public final int y1() {
        return this.A.a(this, V4[19]).intValue();
    }

    public final int y2() {
        return this.W1.a(this, V4[143]).intValue();
    }

    public final int y3() {
        return this.k.a(this, V4[3]).intValue();
    }

    public final String y4() {
        return this.h2.a(this, V4[154]);
    }

    public final boolean y5() {
        return this.e0.a(this, V4[49]).booleanValue();
    }

    public final void y6(boolean z) {
        this.r2.d(this, V4[164], z);
    }

    public final void y7(int i) {
        this.c3.d(this, V4[201], i);
    }

    public final String z0() {
        return this.v4.a(this, V4[272]);
    }

    public final String z1() {
        return this.g4.a(this, V4[257]);
    }

    public final String z2() {
        return this.L4.a(this, V4[288]);
    }

    public final int z3() {
        return this.j.a(this, V4[2]).intValue();
    }

    public final long z4() {
        return this.x.a(this, V4[16]).longValue();
    }

    public final boolean z5() {
        return this.f0.a(this, V4[50]).booleanValue();
    }

    public final void z6(int i) {
        this.s2.d(this, V4[165], i);
    }

    public final void z7(long j) {
        this.d3.d(this, V4[202], j);
    }
}
