# Bale Messenger - Technical Protocol Analysis

**Package:** `ir.nasim` (obfuscated)
**Version:** January 2026 build
**APK Size:** 58,064,688 bytes
**Source:** https://bale.ai/apk/bale.apk

---

## 1. Video/Voice Call Architecture

### 1.1 Protocol Stack

Bale implements video calling using **LiveKit**, a WebRTC-based Selective Forwarding Unit (SFU) platform.

| Layer | Technology |
|-------|------------|
| Signaling | LiveKit Protocol (Protobuf-based) |
| Media Transport | WebRTC |
| Encryption | DTLS-SRTP |
| Architecture | Centralized SFU |

### 1.2 Native Libraries

```
lib/arm64-v8a/
├── liblkjingle_peerconnection_so.so  11,764,784 bytes  LiveKit WebRTC
├── libtmessages.45.so                 5,808,320 bytes  Telegram-derived
├── libsentry.so                         704,344 bytes  Error tracking
├── libsentry-android.so                  16,832 bytes  Sentry Android
├── libimage_processing_util_jni.so       29,008 bytes  Camera utils
├── libsurface_util_jni.so                 4,832 bytes  Surface utils
└── libandroidx.graphics.path.so          10,096 bytes  Graphics
```

### 1.3 Code Evidence

LiveKit integration identified via import statements:

```java
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoTrack;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.ScreenCapturerAndroid;
```

Call management logging:

```java
C19406qI3.a("LiveKitCall2", "Reconnected", ...);
C19406qI3.a("LiveKitCall2", "participant " + sid + " connection quality is " + quality);
```

### 1.4 Architecture Diagram

```
┌─────────────┐         ┌─────────────────────┐         ┌─────────────┐
│   User A    │         │   LiveKit SFU       │         │   User B    │
│   (Bale)    │◄───────►│   Media Server      │◄───────►│   (Bale)    │
│             │  WebRTC │   (Centralized)     │  WebRTC │             │
└─────────────┘         └─────────────────────┘         └─────────────┘
                               ▲
                               │ LiveKit Protocol
                               │ (Signaling)
                               ▼
                        ┌─────────────────────┐
                        │   Bale Backend      │
                        │   (ble.ir)          │
                        └─────────────────────┘
```

---

## 2. Server Infrastructure

### 2.1 ASN Information

| Field | Value |
|-------|-------|
| ASN | AS48159 |
| Name | TIC-AS |
| Organization | Telecommunication Infrastructure Company of Iran |
| Country | IR |
| IP Range | 2.189.68.0/24 |

### 2.2 Server Inventory

Extracted from certificate pinning configuration in `C22580vU2.java`:

| Hostname | IP Address | Purpose |
|----------|------------|---------|
| bale.ai | 2.189.68.126 | Main website |
| api.bale.ai | 2.189.68.126 | API gateway |
| rpc-ssl.bale.ai | 2.189.68.126 | RPC over TLS |
| rpc-ssl-c001.bale.ai | 2.189.68.117 | RPC cluster node 1 |
| rpc-ssl-c002.bale.ai | 2.189.68.117 | RPC cluster node 2 |
| ep.bale.ai | 2.189.68.126 | Endpoint service |
| web.bale.ai | 2.189.68.126 | Web interface |
| hash.bale.ai | 2.189.68.126 | Hash/verification |
| assets.bale.ai | 2.189.68.126 | Static assets |
| tooshle.bale.ai | 2.189.68.126 | Business services |
| siloo.bale.ai | 2.189.68.109 | File storage |
| download-siloo.ble.ir | 2.189.68.94 | File downloads |
| download2-siloo.ble.ir | 2.189.68.98 | Download node 2 |
| download3-siloo.ble.ir | 2.189.68.99 | Download node 3 |
| video-siloo.ble.ir | 2.189.68.94 | Video streaming |
| video2-siloo.ble.ir | 2.189.68.98 | Video node 2 |
| video3-siloo.ble.ir | 2.189.68.99 | Video node 3 |
| arbaeen.ble.ir | 2.189.68.122 | Arbaeen pilgrimage |

### 2.3 Payment Integration

| Service | IP | ASN |
|---------|-----|-----|
| nasim-bam.sadad.co.ir | 89.235.65.214 | AS39571 (SADAD-AS) |
| sadad.shaparak.ir | 185.203.160.31 | AS205837 (SADADPSP-AS) |

---

## 3. Certificate Pinning

Bale implements certificate pinning with SHA-256 hashes for all critical endpoints.

Example pinned hashes:
```
6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444
edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3
d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b
```

---

## 4. Telegram Derivation

Evidence of Telegram fork:
- Native library: `libtmessages.45.so` (5.8MB)
- MTProto-style connection handling
- Similar message/update structures

---

## 5. PCAP Capture Considerations

| Traffic Type | Encryption | Visibility |
|--------------|------------|------------|
| Signaling | TLS 1.3 | Metadata only |
| Media | DTLS-SRTP | Encrypted |
| Key Exchange | DTLS | Encrypted |

To decrypt: Requires SRTP master key extraction via runtime hooking (Frida).

---

## 6. Key Findings

1. **NOT P2P**: All media routes through LiveKit SFU servers
2. **NOT XMPP**: No XMPP/Jingle evidence found
3. **State Infrastructure**: Hosted on TIC (government backbone)
4. **Telegram Fork**: Based on Telegram source code
5. **Full Pinning**: Certificate pinning prevents simple MITM
6. **DNS Telemetry**: Reports connection domains to Bale servers (see Section 7)

---

## 7. DNS Resolution Architecture

Bale implements a custom DNS resolution system that bypasses the operating system's DNS on Android 26+.

### 7.1 Custom DNS Resolvers

**File:** `ir/nasim/InterfaceC9138Yq4.java`

```java
// Method h() - Creates custom DNS resolver set (Android 26+ only)
public final Set h() {
    if (Build.VERSION.SDK_INT < 26) {
        return AbstractC4363Eu6.c(new LA4());  // Fallback to OS DNS
    }
    String[] strArr = {"185.136.96.111", "185.136.98.111", "1.1.1.1", "8.8.8.8", "9.9.9.9"};
    ArrayList arrayList = new ArrayList(5);
    for (int i = 0; i < 5; i++) {
        String str = strArr[i];
        SimpleResolver simpleResolver = new SimpleResolver(str);
        simpleResolver.setTimeout(Duration.ofSeconds(3L));
        arrayList.add(new C14256hc8(str, simpleResolver));
    }
    return AbstractC15401jX0.r1(arrayList);
}
```

**Resolver Priority Order:**

| Priority | IP | Provider | Location |
|----------|-----|----------|----------|
| 1 | 185.136.96.111 | ClouDNS | Bulgaria |
| 2 | 185.136.98.111 | ClouDNS | Bulgaria |
| 3 | 1.1.1.1 | Cloudflare | Global |
| 4 | 8.8.8.8 | Google | Global |
| 5 | 9.9.9.9 | Quad9 | Global |

### 7.2 DNS Telemetry (ConnectionHealthChecker)

**File:** `ir/nasim/C19596qd1.java`

Bale implements a "ConnectionHealthChecker" that reports DNS-related events to a Bale-controlled endpoint.

**Endpoint:**
```
https://2.189.68.149:443/dnscheck
Host: health.ble.ir
```

**IP Location:** `2.189.68.149` is within Bale's own server range (AS48159 TIC).

**Request Payload:**
```java
// Method c() - Creates JSON request body
RequestBody.INSTANCE.create(
    "{\n" +
    "    \"domain\": \"" + domain + "\",\n" +
    "    \"api_version\": \"" + apiVersion + "\",\n" +
    "    \"app_version\": \"" + appVersion + "\",\n" +
    "    \"request_time\": \"" + requestTime + "\",\n" +
    "    \"session_id\": \"" + sessionId + "\"\n" +
    "}",
    MediaType.get("application/json")
);
```

**Data Collected:**

| Field | Description |
|-------|-------------|
| `domain` | The hostname being checked |
| `api_version` | Android SDK version |
| `app_version` | Bale app version |
| `request_time` | Time taken for resolution (ms) |
| `session_id` | Persistent session identifier |

### 7.3 When Telemetry is Triggered

**File:** `ir/nasim/C19989rH4.java` (Custom OkHttp Dns implementation)

```java
@Override
public List lookup(String str) throws UnknownHostException {
    try {
        DnsResolution dnsResolutionB = c().b(str);  // Try custom DNS
        // ... convert to InetAddress list
    } catch (UnknownHostException e) {
        // ON FAILURE: Report to health checker
        this.b.f(str, String.valueOf(requestTime));
        throw e;
    }
}
```

**File:** `ir/nasim/CL.java` (TCP Connection)

```java
private static void y(long j, ConnectionEndpoint connectionEndpoint) {
    // Report host on connection establishment
    C19596qd1.d(C5721Ko.b).f(connectionEndpoint.getHost(), elapsedTime);
}
```

**Trigger Conditions:**
1. DNS resolution failures (UnknownHostException)
2. TCP connection establishment to Bale servers

### 7.4 Scope and Limitations

**What IS Captured:**
- Domains that Bale app attempts to resolve via OkHttp
- Connection establishment to Bale servers

**What is NOT Captured:**
- DNS queries from other apps (scope is app-internal only)
- External links clicked in Bale (WebView uses Chromium's DNS)
- System-wide DNS queries

**WebView Behavior:**

**File:** `ir/nasim/C23572x88.java` and `ir/nasim/P76.java`

```java
// C23572x88.java - Only intercepts Bale's own domains
@Override
public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest request) {
    WebResourceResponse response = this.c.a(request);
    return response != null ? response : super.shouldInterceptRequest(webView, request);
}

// P76.java line 148 - Check if request is for Bale's host
if (!url.getHost().equals(Uri.parse(this.b).getHost())) {
    return null;  // Don't intercept external URLs
}
```

### 7.5 VPN Implications

1. **App-internal telemetry still reports to Bale** - DNS health checks go to `2.189.68.149` regardless of VPN
2. **Split-tunnel VPNs may leak this traffic** - If VPN excludes Iranian IPs, telemetry bypasses encryption
3. **External links are safe** - Links clicked in Bale use system DNS (routed through VPN if configured)

### 7.6 DoH Implementation

Bale includes a DNS-over-HTTPS implementation from the dnsjava library.

**File:** `org/xbill/DNS/DohResolver.java`

Features:
- HTTP/2 support
- GET and POST methods
- `application/dns-message` content type
- Configurable timeout and concurrent requests

### 7.7 Reproduction

```bash
# Decompile Bale APK
jadx -d bale_java evidence/bale.apk --no-res

# Find DNS health check code
grep -r "dnscheck" bale_java/sources/
grep -r "health.ble.ir" bale_java/sources/
grep -r "ConnectionHealthChecker" bale_java/sources/

# Find custom DNS resolvers
grep -r "SimpleResolver" bale_java/sources/
grep -r "185.136" bale_java/sources/

# Find DoH implementation
grep -r "DohResolver" bale_java/sources/

# Verify IP ownership
whois 2.189.68.149    # Should show TIC-AS (AS48159)
whois 185.136.96.111  # Should show ClouDNS
```
