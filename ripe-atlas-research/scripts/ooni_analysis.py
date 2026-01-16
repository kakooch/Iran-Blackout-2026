#!/usr/bin/env python3
"""
OONI measurement analysis for Iranian ISPs.

Fetches and analyzes OONI censorship measurements to understand:
- DNS blocking patterns (10.10.x.x responses)
- HTTP/TCP blocking
- Per-ISP blocking behavior (MCI, Irancell, Shatel, etc.)

Key Iranian ASNs:
- AS197207: MCI (Hamrah Aval) - Mobile
- AS44244: Irancell (MTN) - Mobile
- AS58224: TCI - National backbone
- AS31549: Shatel - ISP
- AS43754: Asiatech - ISP
- AS25184: Afranet - Hosting/ISP

Usage:
    python ooni_analysis.py --asn AS197207 --since 2026-01-01
    python ooni_analysis.py --compare-isps --domain telegram.org
"""
import requests
import argparse
import json
import os
from datetime import datetime, timedelta
from collections import defaultdict
import base64

class OONIAnalyzer:
    """OONI API client for censorship analysis."""

    BASE_URL = "https://api.ooni.io/api/v1"

    IRAN_ASNS = {
        "AS197207": "MCI (Hamrah Aval)",
        "AS44244": "Irancell (MTN)",
        "AS58224": "TCI",
        "AS31549": "Shatel",
        "AS43754": "Asiatech",
        "AS25184": "Afranet",
        "AS12880": "ITC",
        "AS16322": "Pars Online",
    }

    # Known Iran DNS block page IPs
    BLOCK_IPS = {
        "10.10.34.34": "Standard block page",
        "10.10.34.35": "Standard block page (alt)",
        "10.10.34.36": "Standard block page (alt2)",
    }

    def __init__(self):
        self.session = requests.Session()
        self.session.headers.update({'User-Agent': 'IranCensorshipResearch/1.0'})

    def get_measurements(self, probe_cc="IR", probe_asn=None, test_name=None,
                         domain=None, since=None, until=None, limit=100):
        """Fetch OONI measurements with filters."""
        params = {
            "probe_cc": probe_cc,
            "limit": limit
        }
        if probe_asn:
            params["probe_asn"] = probe_asn
        if test_name:
            params["test_name"] = test_name
        if domain:
            params["domain"] = domain
        if since:
            params["since"] = since
        if until:
            params["until"] = until

        resp = self.session.get(f"{self.BASE_URL}/measurements", params=params)
        if resp.status_code == 200:
            return resp.json()
        else:
            print(f"[!] OONI API error: {resp.status_code}")
            return None

    def get_raw_measurement(self, measurement_url):
        """Fetch full raw measurement data."""
        resp = self.session.get(measurement_url)
        if resp.status_code == 200:
            return resp.json()
        return None

    def analyze_blocking_type(self, measurement):
        """Determine blocking type from measurement."""
        scores = measurement.get("scores", {})
        analysis = scores.get("analysis", {})

        if measurement.get("confirmed"):
            blocking_type = analysis.get("blocking_type", "unknown")
            return {
                "blocked": True,
                "confirmed": True,
                "type": blocking_type,
                "fingerprints": scores.get("fingerprints", [])
            }
        elif measurement.get("anomaly"):
            return {
                "blocked": True,
                "confirmed": False,
                "type": "anomaly",
                "fingerprints": scores.get("fingerprints", [])
            }
        else:
            return {
                "blocked": False,
                "confirmed": False,
                "type": None,
                "fingerprints": []
            }

    def compare_isps(self, domain, since=None):
        """Compare blocking behavior across Iranian ISPs."""
        if not since:
            since = (datetime.now() - timedelta(days=30)).strftime("%Y-%m-%d")

        results = {}
        for asn, name in self.IRAN_ASNS.items():
            data = self.get_measurements(
                probe_asn=asn,
                test_name="web_connectivity",
                domain=domain,
                since=since,
                limit=50
            )
            if data and data.get("results"):
                measurements = data["results"]
                blocked = sum(1 for m in measurements if m.get("confirmed") or m.get("anomaly"))
                total = len(measurements)

                # Get most common blocking type
                blocking_types = defaultdict(int)
                for m in measurements:
                    analysis = self.analyze_blocking_type(m)
                    if analysis["blocked"]:
                        blocking_types[analysis["type"]] += 1

                results[asn] = {
                    "name": name,
                    "total_measurements": total,
                    "blocked": blocked,
                    "block_rate": f"{(blocked/total*100):.1f}%" if total > 0 else "N/A",
                    "primary_blocking_type": max(blocking_types, key=blocking_types.get) if blocking_types else None
                }
            else:
                results[asn] = {
                    "name": name,
                    "total_measurements": 0,
                    "blocked": 0,
                    "block_rate": "No data",
                    "primary_blocking_type": None
                }

        return results

    def get_blocking_summary(self, since=None, limit=200):
        """Get summary of blocked domains in Iran."""
        if not since:
            since = (datetime.now() - timedelta(days=7)).strftime("%Y-%m-%d")

        data = self.get_measurements(
            test_name="web_connectivity",
            since=since,
            limit=limit
        )

        if not data or not data.get("results"):
            return None

        domain_stats = defaultdict(lambda: {"blocked": 0, "total": 0, "blocking_types": defaultdict(int)})

        for m in data["results"]:
            domain = m.get("input", "").replace("https://", "").replace("http://", "").rstrip("/")
            if not domain:
                continue

            domain_stats[domain]["total"] += 1
            analysis = self.analyze_blocking_type(m)
            if analysis["blocked"]:
                domain_stats[domain]["blocked"] += 1
                if analysis["type"]:
                    domain_stats[domain]["blocking_types"][analysis["type"]] += 1

        # Sort by block rate
        sorted_domains = sorted(
            domain_stats.items(),
            key=lambda x: x[1]["blocked"] / max(x[1]["total"], 1),
            reverse=True
        )

        return sorted_domains[:50]

    def detect_dns_hijacking(self, measurements):
        """Detect DNS hijacking by looking for known block page IPs."""
        hijacked = []
        for m in measurements:
            fingerprints = m.get("scores", {}).get("fingerprints", [])
            for fp in fingerprints:
                if fp.get("location_found") == "dns":
                    hijacked.append({
                        "input": m.get("input"),
                        "asn": m.get("probe_asn"),
                        "fingerprint": fp.get("name"),
                        "timestamp": m.get("measurement_start_time")
                    })
        return hijacked


def save_results(data, filename, base_dir="investigation/data/ooni"):
    """Save analysis results."""
    os.makedirs(base_dir, exist_ok=True)
    filepath = os.path.join(base_dir, filename)
    with open(filepath, 'w') as f:
        json.dump(data, f, indent=2)
    print(f"[+] Saved to {filepath}")


def main():
    parser = argparse.ArgumentParser(description="OONI Iran Censorship Analysis")
    parser.add_argument("--asn", help="Specific ASN to analyze (e.g., AS197207)")
    parser.add_argument("--domain", help="Domain to check")
    parser.add_argument("--since", help="Start date (YYYY-MM-DD)")
    parser.add_argument("--compare-isps", action="store_true", help="Compare blocking across ISPs")
    parser.add_argument("--blocking-summary", action="store_true", help="Get summary of blocked domains")

    args = parser.parse_args()
    analyzer = OONIAnalyzer()

    if args.compare_isps:
        if not args.domain:
            print("[!] --domain required for ISP comparison")
            return
        print(f"\n[*] Comparing blocking of {args.domain} across Iranian ISPs:\n")
        results = analyzer.compare_isps(args.domain, args.since)
        print(f"{'ASN':<12} | {'ISP Name':<20} | {'Blocked':<8} | {'Total':<6} | {'Rate':<8} | {'Type'}")
        print("-" * 80)
        for asn, data in results.items():
            print(f"{asn:<12} | {data['name']:<20} | {data['blocked']:<8} | {data['total_measurements']:<6} | {data['block_rate']:<8} | {data['primary_blocking_type'] or 'N/A'}")

        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        save_results(results, f"isp_comparison_{args.domain}_{timestamp}.json")

    elif args.blocking_summary:
        print("\n[*] Fetching blocked domain summary for Iran...\n")
        results = analyzer.get_blocking_summary(args.since)
        if results:
            print(f"{'Domain':<40} | {'Blocked':<8} | {'Total':<6} | {'Rate'}")
            print("-" * 70)
            for domain, stats in results[:30]:
                rate = f"{(stats['blocked']/max(stats['total'],1)*100):.0f}%"
                print(f"{domain[:40]:<40} | {stats['blocked']:<8} | {stats['total']:<6} | {rate}")

    elif args.asn:
        print(f"\n[*] Fetching measurements for {args.asn}...\n")
        data = analyzer.get_measurements(
            probe_asn=args.asn,
            test_name="web_connectivity",
            since=args.since,
            limit=100
        )
        if data and data.get("results"):
            measurements = data["results"]
            print(f"[+] Found {len(measurements)} measurements")

            # Analyze blocking patterns
            blocked = [m for m in measurements if m.get("confirmed") or m.get("anomaly")]
            print(f"[+] Blocked: {len(blocked)} / {len(measurements)}")

            # Show recent blocks
            print("\n[+] Recent confirmed blocks:")
            for m in blocked[:10]:
                analysis = analyzer.analyze_blocking_type(m)
                print(f"  - {m.get('input', 'N/A')[:50]} [{analysis['type']}]")

    else:
        parser.print_help()


if __name__ == "__main__":
    main()
