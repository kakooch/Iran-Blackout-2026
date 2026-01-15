# Network Infrastructure Analysis

**Analysis Date:** January 15, 2026
**Method:** APK reverse engineering + DNS/WHOIS reconnaissance

---

## 1. ASN Summary

| Application | ASN | AS Name | Owner | Registration |
|-------------|-----|---------|-------|--------------|
| Bale | AS48159 | TIC-AS | Telecommunication Infrastructure Co. | 2010-10-18 |
| Eitaa | AS202798 | EITAA-MESSENGER | Eitaa Messenger | 2023-04-17 |

---

## 2. IP Allocation

### 2.1 Bale (2.189.68.0/24)

| IP Address | Hostname | Function |
|------------|----------|----------|
| 2.189.68.94 | download-siloo.ble.ir | File downloads |
| 2.189.68.94 | video-siloo.ble.ir | Video streaming |
| 2.189.68.98 | download2-siloo.ble.ir | Download node 2 |
| 2.189.68.98 | video2-siloo.ble.ir | Video node 2 |
| 2.189.68.99 | download3-siloo.ble.ir | Download node 3 |
| 2.189.68.99 | video3-siloo.ble.ir | Video node 3 |
| 2.189.68.109 | siloo.bale.ai | Primary file storage |
| 2.189.68.117 | rpc-ssl-c001.bale.ai | RPC cluster |
| 2.189.68.117 | rpc-ssl-c002.bale.ai | RPC cluster |
| 2.189.68.122 | arbaeen.ble.ir | Arbaeen services |
| 2.189.68.126 | bale.ai | Main services |
| 2.189.68.126 | api.bale.ai | API gateway |
| 2.189.68.126 | rpc-ssl.bale.ai | RPC endpoint |
| 2.189.68.126 | web.bale.ai | Web interface |
| 2.189.68.126 | assets.bale.ai | Static assets |
| 2.189.68.126 | tooshle.bale.ai | Business services |
| 2.189.68.149 | (internal) | DNS check service |

### 2.2 Eitaa (2.189.58.0/24)

| IP Address | Hostname | Function |
|------------|----------|----------|
| 2.189.58.5 | dev3.eitaa.com | Backend API |
| 2.189.58.6 | eitaa.com | Main services |
| 2.189.58.27 | armita.eitaa.com | Alternate backend |

---

## 3. AS Topology

```
┌─────────────────────────────────────────────────────────────────┐
│                     IRANIAN INTERNET                             │
│                                                                  │
│    ┌────────────────────────────────────────────────────────┐   │
│    │                    AS48159 (TIC-AS)                     │   │
│    │          Telecommunication Infrastructure Co.           │   │
│    │                  (STATE BACKBONE)                       │   │
│    │                                                         │   │
│    │    ┌─────────────────┐                                 │   │
│    │    │  BALE SERVERS   │                                 │   │
│    │    │  2.189.68.0/24  │                                 │   │
│    │    └─────────────────┘                                 │   │
│    │                                                         │   │
│    │    Peers with:                                         │   │
│    │    • AS58224 (TCI - National Telecom)                  │   │
│    │    • AS12880 (DCI - Data Communication)                │   │
│    │    • AS16322 (ParsOnline)                              │   │
│    └────────────────────────────────────────────────────────┘   │
│                              │                                   │
│                              │ BGP Peering                       │
│                              ▼                                   │
│    ┌────────────────────────────────────────────────────────┐   │
│    │                  AS202798 (EITAA-MESSENGER)             │   │
│    │                   Own Autonomous System                  │   │
│    │                                                         │   │
│    │    ┌─────────────────┐                                 │   │
│    │    │ EITAA SERVERS   │                                 │   │
│    │    │  2.189.58.0/24  │                                 │   │
│    │    └─────────────────┘                                 │   │
│    └────────────────────────────────────────────────────────┘   │
│                                                                  │
│    ┌────────────────────────────────────────────────────────┐   │
│    │                  PAYMENT INFRASTRUCTURE                  │   │
│    │                                                         │   │
│    │    AS39571 (SADAD-AS)      AS205837 (SADADPSP-AS)     │   │
│    │    Mellat Bank             Sadad PSP                   │   │
│    │    89.235.65.214           185.203.160.31              │   │
│    └────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────┘
```

---

## 4. TIC-AS (AS48159) Details

### 4.1 WHOIS Data

```
aut-num:        AS48159
as-name:        TIC-AS
org:            ORG-TIC4-RIPE
abuse-contact:  l_meybodi@tic.ir
```

### 4.2 Peering Relationships

| Peer ASN | Organization | Relationship |
|----------|--------------|--------------|
| AS58224 | TCI (National Telecom) | Customer |
| AS12880 | DCI (Data Communication) | Customer |
| AS16322 | ParsOnline | Peer |
| AS34984 | Superonline | Transit |
| AS12389 | Rostelecom | Transit |
| AS6762 | Telecom Italia | Transit |

---

## 5. EITAA-MESSENGER ASN (AS202798) Details

### 5.1 WHOIS Data

```
aut-num:        AS202798
as-name:        Eitaa-Messenger
org:            ORG-AYTE1-RIPE
created:        2023-04-17T11:49:20Z
abuse-contact:  admin@eitaa.com
```

### 5.2 Significance

Eitaa operating its own AS indicates:
- Significant infrastructure investment
- Direct peering with Iranian backbone
- Independence from third-party hosting
- Long-term infrastructure planning

---

## 6. External Dependencies

### 6.1 DNS Fallback (Bale)

| IP | Provider | Country |
|----|----------|---------|
| 185.136.96.111 | ClouDNS | Bulgaria |
| 185.136.98.111 | ClouDNS | Bulgaria |
| 1.1.1.1 | Cloudflare | US |
| 8.8.8.8 | Google | US |
| 9.9.9.9 | Quad9 | Switzerland |

### 6.2 Analytics (Bale)

```
https://startup.mobile.yandex.net/  (Yandex AppMetrica)
```

---

## 7. Geographic Considerations

| Factor | Assessment |
|--------|------------|
| Server Location | 100% Iran |
| CDN Usage | None (no Cloudflare, Akamai, etc.) |
| International Transit | Via TIC backbone only |
| Redundancy | Domestic only |
| Sanctions Compliance | Full (no US/EU services) |

---

## 8. Surveillance Implications

### 8.1 Network-Level Visibility

| Layer | State Visibility |
|-------|------------------|
| DNS | Full (domestic resolvers) |
| IP Traffic | Full (TIC backbone) |
| BGP Routes | Full (AS control) |
| TLS Metadata | Full (SNI visible) |
| Content | Requires endpoint access |

### 8.2 Traffic Flow

All traffic for both applications:
1. Originates from user device in Iran
2. Routes through domestic ISP
3. Transits TIC backbone (AS48159)
4. Terminates at application servers

No traffic leaves Iranian network infrastructure for core functionality.

---

## 9. Data Sources

| Source | Purpose |
|--------|---------|
| jadx decompilation | Server endpoint extraction |
| dig/nslookup | DNS resolution |
| whois.cymru.com | ASN lookups |
| RIPE Database | AS registration data |
| APK cert pinning config | IP address extraction |
