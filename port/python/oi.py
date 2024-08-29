from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options

service = Service()
driver = webdriver.Chrome()
chrome_options = Options()
chrome_options.add_argument('--new-tab')

driver = webdriver.Chrome(service=service, options=chrome_options)

urls = [
    "https://www.twitch.tv/gblzera__",
    "https://www.twitch.tv/gblzera__",
    "https://www.twitch.tv/gblzera__",
    "https://www.twitch.tv/gblzera__",
    "https://www.twitch.tv/gblzera__",
    "https://www.twitch.tv/gblzera__"
]

for url in urls:
    driver.execute_script(f"window.open('{url}', '_blank');")

input("Pressione Enter para fechar o navegador...")
driver.quit()
