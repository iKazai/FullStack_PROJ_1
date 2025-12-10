url = 'https://www.nba.com/players'
from playwright.sync_api import Page, sync_playwright
import json
from pathlib import Path

def getRightHTML():
    with sync_playwright() as p:
        browser = p.chromium.launch()
        page = browser.new_page()
        page.goto(url)
        page.select_option('select[title="Page Number Selection Drown Down List"]', '-1')
        html = page.inner_html('html')
        browser.close()
        return html

if __name__ == "__main__":

        html = getRightHTML()

        begin = html.find('"players":[{"')
        end = html.find('"region":')
        
        if begin == -1 or end == -1:
            raise ValueError("Invalid HTML")

        extracted_data = "{" + html[begin:end - 1] + "}"

        # write the output next to this script regardless of current working dir
        out_path = Path(__file__).resolve().parent / "players.json"
        out_path.parent.mkdir(parents=True, exist_ok=True)
        with out_path.open("w", encoding="utf-8") as f:
            f.write(extracted_data)


