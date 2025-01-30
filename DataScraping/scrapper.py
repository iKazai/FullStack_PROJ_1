url = 'https://www.nba.com/players'
from playwright.sync_api import Page, sync_playwright
import json

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

        with open("DataScraping/players.json", "w", encoding="utf-8") as f:
            f.write(extracted_data)


